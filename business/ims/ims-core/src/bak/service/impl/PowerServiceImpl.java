package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.bill.dto.BillDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.convert.BeanConverter;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.PermissionException;
import com.sinosoft.ims.PowerConstants;
import com.sinosoft.ims.api.kernel.dto.*;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import com.sinosoft.ims.core.kernel.dao.*;
import com.sinosoft.ims.core.kernel.entity.*;
import com.sinosoft.ims.core.kernel.service.CompanyService;
import com.sinosoft.ims.core.kernel.service.GradeService;
import com.sinosoft.ims.core.kernel.service.PowerService;
import com.sinosoft.ims.core.kernel.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;


/**
 * @author hzhongkai
 * @description 权限管理服务接口实现类
 * @date 2016年9月28日下午4:59:28
 */
@Service
public class PowerServiceImpl extends BaseServiceImpl implements PowerService {
    /**
     * log日志
     */
    private static Log LOGGER = LogFactory.getLog(PowerServiceImpl.class);

    @Autowired
    private SaaUserPermitCompanyDao saaUserPermitCompanyMapper;

    @Autowired
    private SaaUserPowerDao saaUserPowerMapper;
    @Autowired
    private SaaUserPermitRiskDao saaUserPermitRiskMapper;

    @Autowired
    private SaaGradeTaskDao saaGradeTaskMapper;

    @Autowired
    private UtiIUserIdvDao utiIUserIdvMapper;

    @Autowired
    private SaaGradeDao saaGradeMapper;

    @Autowired
    private SaaTaskDao saaTaskMapper;

    @Autowired
    private SaaUserGradeDao saaUserGradeMapper;

    @Autowired
    private SaaMethodTaskDao saaMethodTaskMapper;

    @Autowired
    private SmcMenuDao smcMenuMapper;

    @Autowired
    private PrpDCompanyDao prpDCompanyMapper;

    @Autowired
    private BillApi billService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private GradeService gradeService;


    /**
     * @param powerConditionDto
     * @return ResponseDto
     * @description 用户数据权限配置服务(配置允许机构)
     * @
     * @author hzhongkai
     * @date 2016年9月25日下午3:37:48
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto configUserPermitCompany(PowerConditionDto powerConditionDto)

    {
        Assert.notNull(powerConditionDto, " 配置允许机构服务 入参 powerConditionDto 不允许为空！");
        Assert.hasText(powerConditionDto.getUserCode(), " 配置允许机构服务 入参 UserCode 不允许为空！");
        Assert.hasText(powerConditionDto.getTaskId(), " 配置允许机构服务 入参 TaskId 不允许为空！");

        LOGGER.error("  配置允许机构服务 开始  UserCode=" + powerConditionDto.getUserCode());
        ResponseDto result = new ResponseDto();
        try {
            // 获取powerId
            String powerId = getPowerId(powerConditionDto.getUserCode(), powerConditionDto.getTaskId());
            if (StringUtils.isEmpty(powerId)) {
                LOGGER.error("没有找到对应的powerId ，重新创建powerId!  usercode=" + powerConditionDto.getUserCode() + "  taskId=" + powerConditionDto.getTaskId());
                powerId = createUserPower(powerConditionDto);
            }
            // 清空用户机构权限
            //saaUserPermitCompanyMapper.clearUserPermitCompany(powerId);

            if (powerConditionDto.getCompanyList() != null
                    && powerConditionDto.getCompanyList().size() > 0) {
                // 当传入的CompanyList 不为空时，执行更新或者插入操作
                // 重新处理 CompanyList ,如果父节点勾中，去除子节点,处理结束后的CompanyList均包含子节点
                List<PrpDCompanyDto> companyList = analyzeCompanyList(powerConditionDto.getCompanyList());
                mergeUserPermitCompany(companyList, powerId, SinoRequestContext.getCurrentContext().getUserCode());
            }
        } catch (Exception e) {
            LOGGER.error("  配置允许机构服务 发生异常！" + e.getMessage());
            throw e;
        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        LOGGER.error("  配置允许机构服务 结束  UserCode=" + powerConditionDto.getUserCode());

        Assert.notNull(powerConditionDto, " 配置允许机构服务 入参 powerConditionDto 不允许为空！");

        return result;
    }


    /**
     * @param companyList
     * @return List<PrpDCompanyDto>
     * @description 重新处理 CompanyList ,如果父节点勾中，去除子节点
     * @author hzhongkai
     * @date 2016年10月21日上午10:45:03
     */
    private List<PrpDCompanyDto> analyzeCompanyList(List<PrpDCompanyDto> companyList) {
        // 以comcode 为key, upperComcode 为 value
        Map<String, String> mapC = new HashMap<String, String>();
        for (PrpDCompanyDto company : companyList) {
            mapC.put(company.getComCode(), company.getUpperComCode());
        }
        //使用迭代器再次循环CompanyList，如果 company 的UpperComCode 存在，则将该 company剔除
        Iterator<PrpDCompanyDto> iter = companyList.iterator();
        while (iter.hasNext()) {
            PrpDCompanyDto c = iter.next();
            //CompanyList 存在该机构的UpperCompany
            if (mapC.get(c.getUpperComCode()) != null) {
                iter.remove();
            }
        }
        return companyList;
    }

    /**
     * @param powerConditionDto
     * @return PowerReturnDto
     * @description 用户权限机构获取服务(机构数据权限)
     * @
     * @author hzhongkai
     * @date 2016年9月25日下午3:38:20
     */
    @Override
    public List<SaaUserPermitCompanyDto> queryUserPermitCompanyList(PowerConditionDto powerConditionDto)

    {
        Assert.notNull(powerConditionDto, " 用户权限机构获取服务 入参 powerConditionDto 不允许为空！");
        Assert.hasText(powerConditionDto.getUserCode(), " 用户权限机构获取服务 入参 UserCode 不允许为空！");
        Assert.hasText(powerConditionDto.getTaskId(), " 用户权限机构获取服务 入参 TaskId 不允许为空！");

        // 返回对象列表
        List<SaaUserPermitCompanyDto> userPermitCompanyDtoLsit = new ArrayList<SaaUserPermitCompanyDto>();

        LOGGER.error("  用户权限机构获取服务 开始  UserCode=" + powerConditionDto.getUserCode());
        try
        {
            // 获取powerId
           String powerId = getPowerId(powerConditionDto.getUserCode(), powerConditionDto.getTaskId());
            if (StringUtils.isEmpty(powerId))
            {
                LOGGER.error("没有找到对应的powerId!  usercode=" + powerConditionDto.getUserCode()
                + "  taskId=" + powerConditionDto.getTaskId());
                return null;
            }

            // 根据powerId查询对应的用户权限机构
            //2017年8月3日17:11:35
            List<SaaUserPermitCompany> userPermitCompanyList=saaUserPermitCompanyMapper.findAllByPowerIdAndValidStatus(powerId,"1");
//            SaaUserPermitCompanyExample example = new SaaUserPermitCompanyExample();
//            SaaUserPermitCompanyExample.Criteria criteria = example.createCriteria();
//            criteria.andPowerIdEqualTo(powerId);
//            criteria.andValidStatusEqualTo("1");
//
//            SaaUserPermitCompanyDto dto = null;
//
//            // 根据powerId查询对应的用户权限机构
//            List<SaaUserPermitCompany> userPermitCompanyList = saaUserPermitCompanyMapper.selectByExample( example);
            for (SaaUserPermitCompany saaUserPermitCompany : userPermitCompanyList)
            {
                SaaUserPermitCompanyDto dto = entityTODto(saaUserPermitCompany);
                userPermitCompanyDtoLsit.add(dto);
            }
        }
        catch (Exception e)
        {
            LOGGER.error(" 用户权限机构获取服务 发生异常！" + e.getMessage());
            throw e;
        }
        return userPermitCompanyDtoLsit;
    }

    /**
     * @param userCode
     * @param taskId
     * @return powerId
     * @description 根据userCode和taskId 查询对应的powerId
     * @author hzhongkai
     * @date 2016年9月25日上午11:55:01
     */
    private String getPowerId(String userCode, String taskId) {
        // 获取powerId
        //2017年8月3日17:17:26
        List<SaaUserPower> saaUserPower=saaUserPowerMapper.findOneByUserCodeAndTaskID(userCode,taskId);
//        SaaUserPowerExample example = new SaaUserPowerExample();
//        SaaUserPowerExample.Criteria criteria = example.createCriteria();
//        criteria.andUserCodeEqualTo(userCode);
//        criteria.andTaskIDEqualTo(taskId);
//        List<SaaUserPower> userPowerList = saaUserPowerMapper.selectByExample(example);
        String powerId = "";
        if (saaUserPower!=null && saaUserPower.size()>0)
        {
            powerId = saaUserPower.get(0).getID();
        }
        return powerId;
    }

    /**
     * @param companyList
     * @return List<UserPermitCompanyDto>
     * @description 更新或者插入数据库
     * @author hzhongkai
     * @
     * @date 2016年9月23日上午11:55:42
     */
    private void mergeUserPermitCompany(List<PrpDCompanyDto> companyList, String powerId, String globalUserCode) {
        SaaUserPermitCompanyDto saaUserPermitCompanyDto = null;
        BillConditionDto billConditionDto = new BillConditionDto();
        billConditionDto.setBillType("imsSaaUserPermitCompany_");
        for (PrpDCompanyDto company : companyList) {
            saaUserPermitCompanyDto = new SaaUserPermitCompanyDto();
            //saaUserPermitCompanyDto.setGlobalUserCode(globalUserCode);
            saaUserPermitCompanyDto.setPowerId(powerId);
            saaUserPermitCompanyDto.setComCode(company.getComCode());
            saaUserPermitCompanyDto.setIncludeSubCom("1");
            mergeUPC(saaUserPermitCompanyDto, billConditionDto);
        }
    }


    /**
     * @param saaUserPermitCompanyDto
     * @param billConditionDto
     * @description 更新或者插入userPermitCompany
     * @
     * @author hzhongkai
     * @date 2016年10月10日上午11:02:04
     */
    private void mergeUPC(SaaUserPermitCompanyDto saaUserPermitCompanyDto, BillConditionDto billConditionDto)

    {
//        SaaUserPermitCompany saaUserPermitCompany = DtoTOEntity(saaUserPermitCompanyDto);
//
//        SaaUserPermitCompanyExample example = new SaaUserPermitCompanyExample();
//        SaaUserPermitCompanyExample.Criteria criteria =  example.createCriteria();
//        criteria.andComCodeEqualTo(saaUserPermitCompany.getComCode());
//        criteria.andPowerIdEqualTo(saaUserPermitCompany.getPowerId());
//        List<SaaUserPermitCompany>  list = saaUserPermitCompanyMapper.selectByExample(example);
//
//        if (list != null && list.size() > 0)
//        {
//            // 更新
//            saaUserPermitCompany.setID(list.get(0).getID());
//            saaUserPermitCompany.setUpdateDate(new Date());
//            saaUserPermitCompany.setUpdaterCode(saaUserPermitCompanyDto.getGlobalUserCode());
//            saaUserPermitCompany.setValidStatus("1");
//            saaUserPermitCompanyMapper.updateByPrimaryKeySelective(saaUserPermitCompany);
//        }
//        else
//        {
//            // 插入
//            BillDto billDto = null;
//            try
//            {
//                billDto = billService.getSerialNo(billConditionDto);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//            String id = String.format("%019d", billDto.getSerialNo());
//            saaUserPermitCompany.setID(id);
//            saaUserPermitCompany.setCreateDate(new Date());
//            saaUserPermitCompany.setCreatorCode(saaUserPermitCompanyDto.getGlobalUserCode());
//            saaUserPermitCompany.setValidStatus("1");
//            saaUserPermitCompanyMapper.insert(saaUserPermitCompany);
//        }
    }


    /**
     * @description 对象互转
     * @param SaaUserPermitCompanyDto
     * @return UserPermitCompany
     * @author hzhongkai
     * @date 2016年9月20日下午3:58:45
     */
//    private SaaUserPermitCompany DtoTOEntity(SaaUserPermitCompanyDto dto)
//    {
//        SaaUserPermitCompany saaUserPermitCompany = new SaaUserPermitCompany();
//        beanConverter.convert(dto, saaUserPermitCompany);
//        return saaUserPermitCompany;
//    }

    /**
     * @param saaUserPermitCompany
     * @return UserPermitCompanyDto
     * @description 对象互转
     * @author hzhongkai
     * @date 2016年9月20日下午3:58:45
     */
    private SaaUserPermitCompanyDto entityTODto(SaaUserPermitCompany saaUserPermitCompany)
    {
        SaaUserPermitCompanyDto usserPermitCompanyDto = convert(saaUserPermitCompany, SaaUserPermitCompanyDto.class);
        return usserPermitCompanyDto;
    }
    /* (non-Javadoc)
     * @see PowerService#getPowerCondition(com.sinosoft.ims.kernel.dto.PowerConditionDto)
     */
    @Override
    public String getPowerCondition(PowerConditionDto powerConditionDto)

    {
        // 设置taskID
        setTaskIDByUrl(powerConditionDto);
        if (StringUtils.isEmpty(powerConditionDto.getTaskId())) {
            //查询不到taskid 直接返回 不需要做权限控制
            return null;
        }
        String strUserCode = powerConditionDto.getUserCode();
        // 权限允许的险种拼接串，“,” 分割
        StringBuilder sbRisk = new StringBuilder(50);
        // 权限允许的机构拼接串，“,” 分割
        StringBuilder sbComcode = new StringBuilder(50);
        // 完整的权限拼接条件
        StringBuilder sbAllCondition = new StringBuilder(50);
        sbAllCondition.append(" and exists( select 1 from ").append(
                powerConditionDto.getTableName()).append(" a where a.").append(
                PowerConstants.TABLE_PK.get(powerConditionDto.getTableName())).append(
                " = ").append(powerConditionDto.getOuterTableName()).append(".").append(
                PowerConstants.TABLE_PK.get(powerConditionDto.getTableName()));
        //如果用户不存在 则表示没有权限
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        utiIUserIdvKey.setUserCode(strUserCode);
        UtiIUserIdv utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        if (utiIUserIdv == null) {
            throw new PermissionException("用戶沒有權限");
        }
        //根据powerid查询用户允许险种
        String strRiskCode = getPermitRiskCode(strUserCode, powerConditionDto.getTaskId());
        // 拼接险种条件
        if (StringUtils.isNotBlank(strRiskCode)) {
            sbAllCondition.append(" and a.riskcode in (").append(strRiskCode).append(") ");
        }
        //拼接机构条件
        String strCompanyCode = getPermitCompany(strUserCode, powerConditionDto.getTaskId());
        if (StringUtils.isNotBlank(strCompanyCode)) {
            String strComcode = strCompanyCode.toString();
            if (StringUtils.isNoneBlank(strComcode)) {
                //给comcode追加别名
                strComcode = strComcode.replace("comcode", "a.comcode");
                // 拼接机构条件  
                sbAllCondition.append("  and  (").append(strComcode).append(")");
            }
        }
        //拼接个人权限
        String strSinglePower = getSinglePower(strUserCode, powerConditionDto.getTaskId());
        if (strSinglePower != null) {
            sbAllCondition.append(strSinglePower);
        }
        sbAllCondition.append(")");
        return sbAllCondition.toString();
    }


    /**
     * @param userCode 用户代码
     * @param taskid
     * @return 返回值 类似 comcode like '000014%'  或者 comcode = '000014'  or  comcode = '000022'
     * @description 获取允许机构
     * @author zkr07
     * @date 2016年10月21日下午5:57:44
     */
    private String getPermitCompany(String userCode, String taskid) {
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        utiIUserIdvKey.setUserCode(userCode);
        UtiIUserIdv utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        if (utiIUserIdv == null) {
            throw new PermissionException("用戶沒有權限");
        }
        // 保险公司前6位代码
        String companyCode = utiIUserIdv.getComCode();
        // 获取powerid
        String powerId = null;
        StringBuilder sbComcode = new StringBuilder(50);
        if (StringUtils.isNotBlank(taskid)) {
            powerId = getPowerId(userCode, taskid);
        }
        if (StringUtils.isEmpty(powerId)) {
            // 默认就是所有机构和所有险种（如果是保险公司人员，需要加保险公司归属机构判断）
            if (PowerConstants.TOP_COMCODE.equals(companyCode)) {
                // 如果这个人归属共保体公司， 则默认查询所有机构
            } else {
                // 归属保险公司，则需要加保险公司机构权限控制
                sbComcode.append(getLowerCodeStr(companyCode));
            }
        } else {
            // 查询机构（没有则表示全部都可以）
//            SaaUserPermitCompanyExample companyExample = new SaaUserPermitCompanyExample();
//            SaaUserPermitCompanyExample.Criteria companyCriteria = companyExample.createCriteria();
//            companyCriteria.andPowerIdEqualTo(powerId);
            List<SaaUserPermitCompany> saaUserPermitCompanyList = saaUserPermitCompanyMapper.findAll(Specifications.<SaaUserPermitCompany>and()
                    .eq("powerId", powerId).build());
            if (saaUserPermitCompanyList == null || saaUserPermitCompanyList.size() == 0) {
                if (PowerConstants.TOP_COMCODE.equals(companyCode)) {
                    // 如果这个人归属共保体公司， 且没有配置机构，则默认查询所有机构
                } else {
                    // 归属保险公司， 没有配置机构，则需要加保险公司机构权限控制
                    sbComcode.append(getLowerCodeStr(companyCode));
                }
            } else {
                for (int i = 0; i < saaUserPermitCompanyList.size(); i++) {
                    if ("1".equals(saaUserPermitCompanyList.get(i).getIncludeSubCom())) {
                        if (sbComcode != null && sbComcode.length() > 0) {
                            sbComcode.append(",").append(
                                    getLowerCodeStr(saaUserPermitCompanyList.get(i).getComCode()));
                        } else {
                            sbComcode.append(
                                    getLowerCodeStr(saaUserPermitCompanyList.get(i).getComCode()));
                        }
                    } else {
                        if (sbComcode != null && sbComcode.length() > 0) {
                            sbComcode.append(" or ").append("comcode='").append(
                                    saaUserPermitCompanyList.get(i).getComCode()).append("'");
                        } else {
                            sbComcode.append(" comcode='").append(
                                    saaUserPermitCompanyList.get(i).getComCode()).append("'");
                        }
                    }
                }
            }
        }
        return sbComcode.toString();
    }


    /**
     * @param usercode 用户代码
     * @param taskid   任务ID
     * @return
     * @description 根据powerid 查询允许险种， 多个用“,”分割, 返回空对象表示不用控制
     * @author zkr07
     * @date 2016年10月21日下午5:33:03
     */
    private String getPermitRiskCode(String usercode, String taskid) {
        // 获取powerid
        String powerId = null;
        if (StringUtils.isNotBlank(taskid)) {
            powerId = getPowerId(usercode, taskid);
        }
        if (StringUtils.isEmpty(powerId)) {
            //powerid 没有值则表示不加权限控制
            return null;
        }
//        SaaUserPermitRiskExample riskExample = new SaaUserPermitRiskExample();
//        SaaUserPermitRiskExample.Criteria riskCriteria = riskExample.createCriteria();
//        riskCriteria.andPowerIdEqualTo(powerId);
        List<SaaUserPermitRisk> saaUserPermitRiskList = saaUserPermitRiskMapper.findAll(Specifications.<SaaUserPermitRisk>and()
                .eq("powerId", powerId).build());
        StringBuilder sbRisk = null;
        if (saaUserPermitRiskList == null || saaUserPermitRiskList.size() == 0) {
            // 查询不到默认就是所有险种
        } else {
            sbRisk = new StringBuilder(50);
            for (int i = 0; i < saaUserPermitRiskList.size(); i++) {
                if (i > 0) {
                    sbRisk.append(",");
                }
                sbRisk.append("'").append(saaUserPermitRiskList.get(i).getRiskCode()).append("'");
            }
            return sbRisk.toString();
        }
        return null;
    }


    /**
     * @param powerConditionDto
     * @return
     * @description 获取用户允许机构查询权限
     * @
     * @author hzhongkai
     * @date 2016年10月22日上午11:43:27
     */
    @Override
    public String getPowerCompanyCondition(PowerConditionDto powerConditionDto) {

        String strUserCode = powerConditionDto.getUserCode();
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        utiIUserIdvKey.setUserCode(strUserCode);
        UtiIUserIdv utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        if (utiIUserIdv == null) {
            throw new PermissionException("用戶沒有權限");
        }
        String companyCode = utiIUserIdv.getComCode();

        // 权限允许的机构拼接串，“,” 分割
        StringBuilder sbComcode = new StringBuilder(50);
        // 完整的权限拼接条件
        StringBuilder sbAllCondition = new StringBuilder(50);
        sbAllCondition.append(" and exists( select 1 from ")

                .append("(")
                .append("select comcode from prpdcompany  start with comcode = '")
                .append(companyCode)
                .append("' ")
                .append("connect by nocycle prior comcode = uppercomcode ")
                .append(") a")

                .append("  where a.")
                .append(PowerConstants.TABLE_PK.get(powerConditionDto.getTableName()))
                .append(" = ")
                .append(powerConditionDto.getOuterTableName())
                .append(".").append(PowerConstants.TABLE_PK.get(powerConditionDto.getTableName()));

        String powerId = null;
        if (StringUtils.isEmpty(powerConditionDto.getTaskId())) {
            //查询不到taskid 直接返回 不需要做权限控制
            sbAllCondition.append(")");
            return sbAllCondition.toString();
        } else {
            // 获取powerid
            powerId = getPowerId(strUserCode, powerConditionDto.getTaskId());
        }
        if (powerId != null && !"".equals(powerId)) {
            // 查询机构（没有则表示全部都可以）
//            SaaUserPermitCompanyExample companyExample = new SaaUserPermitCompanyExample();
//            SaaUserPermitCompanyExample.Criteria companyCriteria = companyExample.createCriteria();
//            companyCriteria.andPowerIdEqualTo(powerId);
            List<SaaUserPermitCompany> saaUserPermitCompanyList = saaUserPermitCompanyMapper.findAll(Specifications.<SaaUserPermitCompany>and()
                    .eq("powerId", powerId).build());
            if (saaUserPermitCompanyList != null && saaUserPermitCompanyList.size() > 0) {
                for (int i = 0; i < saaUserPermitCompanyList.size(); i++) {
                    if ("1".equals(saaUserPermitCompanyList.get(i).getIncludeSubCom())) {
                        if (sbComcode != null && sbComcode.length() > 0) {
                            sbComcode.append(",").append(
                                    getLowerCodeStr(saaUserPermitCompanyList.get(i).getComCode()));
                        } else {
                            sbComcode.append(
                                    getLowerCodeStr(saaUserPermitCompanyList.get(i).getComCode()));
                        }
                    } else {
                        if (sbComcode != null && sbComcode.length() > 0) {
                            sbComcode.append(" or ").append("a.comcode='").append(
                                    saaUserPermitCompanyList.get(i).getComCode()).append("'");
                        } else {
                            sbComcode.append(" a.comcode='").append(
                                    saaUserPermitCompanyList.get(i).getComCode()).append("'");
                        }
                    }
                }
                // 拼接机构条件
                sbAllCondition.append("  and  (").append(sbComcode.toString()).append(")");
            }
        }
        sbAllCondition.append(")");
        return sbAllCondition.toString();
    }


    /**
     * @param powerConditionDto
     * @description 根据请求URL设置taskID
     * @author zkr07
     * @date 2016年10月14日下午3:12:26
     */
    private void setTaskIDByUrl(PowerConditionDto powerConditionDto) {
//        String taskcode = PowerConstants.POWER_URL_TASKCODE_MAPPER.get(powerConditionDto.getServletPath());
//        //根据taskcode 查询taskid;
//        if(StringUtils.isNotBlank(taskcode)){
//            SaaTaskExample example = new SaaTaskExample();
//            SaaTaskExample.Criteria taskCriteria = example.createCriteria();
//            taskCriteria.andTaskCodeEqualTo(taskcode);
//            List<SaaTask> listTask = saaTaskMapper.selectByExample(example);
//            if(listTask != null && listTask.size() > 0){
//                powerConditionDto.setTaskId(listTask.get(0).getID());
//            }
//        }
    }

    /**
     * @param strUserCode
     * @param taskID
     * @return
     * @description 对于只有出单岗(没有管理岗)的用户，只能查询自己出的单子
     * @author zkr07
     * @date 2016年10月10日下午8:08:16
     */
    private String getSinglePower(String strUserCode, String taskID) {
//        SaaUserGradeExample userGradeExample = new SaaUserGradeExample();
//        SaaUserGradeExample.Criteria userGradeCriteria = userGradeExample.createCriteria();
//        userGradeCriteria.andUserCodeEqualTo(strUserCode);
        List<SaaUserGrade> listGrade = saaUserGradeMapper.findAll(Specifications.<SaaUserGrade>and()
                .eq("userCode", strUserCode).build());
        SaaGradeKey saaGradeKey = new SaaGradeKey();
        SaaGrade saaGrade = null;
        List<String> notMasterGrade = new ArrayList<String>();
        for (int i = 0; i < listGrade.size(); i++) {
            saaGradeKey.setID(listGrade.get(i).getGradeID());
            saaGrade = saaGradeMapper.findOne(saaGradeKey);
            if (PowerConstants.GRADE_001.equals(saaGrade.getGradeCode())
                    || PowerConstants.GRADE_002.equals(saaGrade.getGradeCode())
                    || PowerConstants.GRADE_003.equals(saaGrade.getGradeCode())
                    || PowerConstants.GRADE_004.equals(saaGrade.getGradeCode())) {
                //如果存在管理岗 则直接返回 不做控制
                return null;
            } else {
                notMasterGrade.add(saaGrade.getID());
            }
        }
        for (int i = 0; i < notMasterGrade.size(); i++) {
            //查询传过来的taskID所属岗位是否有配置【gscore-front.siglepower】takscode， 如果有则加上个人权限控制
            if (isHasSinglePower(taskID, notMasterGrade.get(i))) {
                return " and a.createby = '" + strUserCode + "' ";
            }
        }
        return null;
    }


    /**
     * @param taskID
     * @param gradeID
     * @return
     * @description 判断此task 是否需要做个人权限控制
     * @author zkr07
     * @date 2016年10月14日下午4:21:26
     */
    private boolean isHasSinglePower(String taskID, String gradeID) {
//        SaaGradeTaskExample taskExample = new SaaGradeTaskExample();
//        SaaGradeTaskExample.Criteria criteria = taskExample.createCriteria();
//        criteria.andTaskIDEqualTo(taskID);
//        criteria.andGradeIDEqualTo(gradeID);
        List<SaaGradeTask> gradeTaskList = saaGradeTaskMapper.findAll(Specifications.<SaaGradeTask>and()
                .eq("taskID", taskID).eq("gradeID", gradeID).build());
        if (gradeTaskList != null && gradeTaskList.size() > 0) {
            String sigleTaskID = "";
//            SaaTaskExample example = new SaaTaskExample();
//            SaaTaskExample.Criteria taskCriteria = example.createCriteria();
//            taskCriteria.andTaskCodeEqualTo(PowerConstants.SINGLEPOWER);
            List<SaaTask> listTask = saaTaskMapper.findAll(Specifications.<SaaTask>and()
                    .eq("TaskCode", PowerConstants.SINGLEPOWER).build());
            if (listTask != null && listTask.size() > 0) {
                sigleTaskID = listTask.get(0).getID();
            }
            if (StringUtils.isEmpty(sigleTaskID)) {
                //没有配置直接返回
                return false;
            }
//            SaaGradeTaskExample singleTaskExample = new SaaGradeTaskExample();
//            SaaGradeTaskExample.Criteria  singleCriteria = singleTaskExample.createCriteria();
//            singleCriteria.andTaskIDEqualTo(sigleTaskID);
//            singleCriteria.andGradeIDEqualTo(gradeID);
            if (saaGradeTaskMapper.findAll(Specifications.<SaaGradeTask>and()
                    .eq("sigleTaskID", sigleTaskID).eq("gradeID", gradeID).build()).size() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param comCode 机构代码
     * @description 获取机构的下级机构
     * @author zkr07
     * @date 2016年10月10日下午5:27:36
     */
    private String getLowerCodeStr(String comCode) {
        StringBuilder sbComCode = new StringBuilder(50);
        // 查询该用户的所属机构权限
        List<PrpDCompany> prpDCompanyList = prpDCompanyMapper.findAll(Specifications.<PrpDCompany>and()
                .eq("comCode", "1").build());
        if (prpDCompanyList != null) {
            for (int i = 0; i < prpDCompanyList.size(); i++) {
                if (i > 0) {
                    sbComCode.append(" or ");
                }
                sbComCode.append(" comcode ='").append(prpDCompanyList.get(i).getComCode()).append("'");
            }
        }
        return sbComCode.toString();
    }

    /**
     * @description 用户功能权限任务
     * @remark 先根据  methodCode / actionURL获取TaskId 如果查询不到 直接返回正确,如查询到且无权限抛出异常
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto checkUserPowerService(OptPowerConditionDto powerConditionDto) {
        String taskId = null;
        if (null != powerConditionDto) {
            if (null != powerConditionDto.getActionURL() && !"".equals(powerConditionDto.getActionURL())) {//先判断
//				SaaMethodTaskExample saaMethodTaskCondtion = new SaaMethodTaskExample();
//				saaMethodTaskCondtion.createCriteria().andMethodCodeEqualTo(powerConditionDto.getActionURL());
                List<SaaMethodTask> saaMethodTaskList = saaMethodTaskMapper.findAll(Specifications.<SaaMethodTask>and()
                        .eq("MethodCode", powerConditionDto.getActionURL()).build());
                if (null != saaMethodTaskList && saaMethodTaskList.size() > 0) {
                    taskId = saaMethodTaskList.get(0).getTaskId();
                }
//				if(null==taskId){
//					SmcMenuExample smcMenuCondtion = new SmcMenuExample();
//					smcMenuCondtion.createCriteria().andActionURLEqualTo(powerConditionDto.getActionURL());
//					List<SmcMenu> smcMenuList = smcMenuMapper.selectByExample(smcMenuCondtion);
//					if(null!=smcMenuList&&smcMenuList.size()>0){
//						taskId = smcMenuList.get(0).getTaskCode();
//					}					
//				}
            }
        }
        if (null != taskId && null != powerConditionDto.getUserCode()) {
            boolean powerResult = checkTaskPower(powerConditionDto.getUserCode(), taskId);
            if (!powerResult) {
                String taskName = taskId;
                //如果没有权限需要在给前段提示的时候显示taskName
                SaaTaskKey taskKey = new SaaTaskKey();
                taskKey.setID(taskId);
                SaaTask saaTask = saaTaskMapper.findOne(taskKey);
                if (null != saaTask) {
                    taskName = saaTask.getTaskCName();
                }
                return new ResponseDto(PermissionException.PERMISSION_ERROR_CODE, taskName, null);
            }
        }
        return ResponseDto.instance(null);
    }

    /**
     * @return
     */
    private boolean checkTaskPower(String strUserCode, String taskId) {
//        SaaUserGradeExample userGradeExample = new SaaUserGradeExample();
//        SaaUserGradeExample.Criteria userGradeCriteria = userGradeExample.createCriteria();
//        userGradeCriteria.andUserCodeEqualTo(strUserCode);
        List<SaaUserGrade> listGrade = saaUserGradeMapper.findAll(Specifications.<SaaUserGrade>and()
                .eq("UserCode", strUserCode).build());
        List<String> notMasterGrade = new ArrayList<String>();
        if (null != listGrade && listGrade.size() > 0) {//没有配置任何岗位
        } else {
            return false;
        }
        for (int i = 0; i < listGrade.size(); i++) {
            notMasterGrade.add(listGrade.get(i).getGradeID());
        }
//		SaaGradeTaskExample example = new SaaGradeTaskExample();
//		example.createCriteria().andGradeIDIn(notMasterGrade).andTaskIDEqualTo(taskId);
        List<SaaGradeTask> gradeTaskList = saaGradeTaskMapper.findAll(Specifications.<SaaGradeTask>and()
                .eq("GradeID", notMasterGrade).eq("taskId", taskId).build());
        if (null != gradeTaskList && gradeTaskList.size() > 0) {
            return true;
        }
        return false;
    }


    /**
     * @param powerConditionDto
     * @return TreeNodeDto
     * @description 根据用户获取机构树
     * @
     * @author hzhongkai
     * @date 2016年10月20日上午11:21:20
     */
    @Override
    public List<TreeNodeDto> getCompanyTree(PowerConditionDto powerConditionDto) {
        if (StringUtils.isEmpty(powerConditionDto.getUserCode())) {
            throw new BusinessException("待维护用户 UserCode 不允许为空！");
        }
        // 判断待维护用户是否与当前登录用户归属同一成员公司
        if (!checkUserOwner(SinoRequestContext.getCurrentContext().getUserCode(), powerConditionDto.getUserCode())) {
            throw new BusinessException("待维护用户 " + powerConditionDto.getUserCode() + " 不存在！");
        }
        // 判断待维护用户岗位是否为成员公司管理用户
        if (!checkUserGrade(powerConditionDto.getUserCode(), PowerConstants.GRADE_004)) {
            throw new BusinessException("待维护用户 " + powerConditionDto.getUserCode() + " 不是 成员公司管理用户！");
        }

        List<TreeNodeDto> treeNodeList = new ArrayList<TreeNodeDto>();


        // 获取当前登录用户所属机构
        UserDto userDto = new UserDto();
        userDto.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
        PrpDCompanyDto prpDCompanyDto = userService.queryUserCompany(userDto);

        // 获取待维护用户所属机构
        userDto.setUserCode(powerConditionDto.getUserCode());
        PrpDCompanyDto fixCompany = userService.queryUserCompany(userDto);

        //用户所属机构直接子机构列表
        List<PrpDCompanyDto> childComList = null;

        // 组装TreeNode
        TreeNodeDto treeNode = new TreeNodeDto();
        treeNode.setComCode(prpDCompanyDto.getComCode());
        treeNode.setUpperComCode(prpDCompanyDto.getUpperComCode());
        treeNode.setTitle(prpDCompanyDto.getComCName());

        // 获取需维护用户允许机构列表
        List<SaaUserPermitCompanyDto> upcList = queryUserPermitCompanyList(powerConditionDto);
        Map<String, String> upcMap = new HashMap<String, String>();

        // 查询下级机构入参对象
        PrpDCompanyDto prpDCompanyDtoTemp = new PrpDCompanyDto();
        prpDCompanyDtoTemp.setUpperComCode(prpDCompanyDto.getComCode());
        prpDCompanyDtoTemp.setComType(PowerConstants.COMTYPE_01);
        if (upcList == null || upcList.size() == 0) {
            // 该用户没有没有配置业务允许机构，默认待维护用户的下级所有机构均勾中
            treeNode.setChecked(true);
            if (prpDCompanyDto.getComCode().equals(fixCompany.getComCode())) {
                // 待维护用户和登录用户一致
                treeNode.setChecked(true);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(treeNode, childComList, true, null);
                }
            } else {
                //待维护用户和登录用户不一致，fixCompany 待维护用户机构，仅当没有配置powerid的用户才传值
                treeNode.setChecked(false);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(treeNode, childComList, false, fixCompany);
                }

            }
        } else {
            for (SaaUserPermitCompanyDto upc : upcList) {
                upcMap.put(upc.getComCode(), upc.getIncludeSubCom());
            }
            if ("1".equals(upcMap.get(prpDCompanyDto.getComCode()))) {
                //业务允许机构包含下级
                treeNode.setChecked(true);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(treeNode, childComList, true, null);
                }
            } else {
                // 业务允许机构不包含下级
                treeNode.setChecked(false);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(treeNode, childComList, upcMap);
                }
            }
        }
        treeNodeList.add(treeNode);
        return treeNodeList;
    }


    /**
     * @param globalUserCode
     * @return
     * @description 判断待维护用户是否归属于当前登录用户
     * @author hzhongkai
     * @
     * @date 2016年10月21日上午9:50:14
     */

    private boolean checkUserOwner(String globalUserCode, String userCode) {
        // 获取待维护用户所属机构
        UserDto userDto = new UserDto();
        userDto.setUserCode(userCode);
        PrpDCompanyDto fixCompany = userService.queryUserCompany(userDto);

        // 获取当前登录用户所有下级机构
        userDto.setUserCode(globalUserCode);
        List<PrpDCompanyDto> companyList = userService.queryUserComCodeService(userDto);

        for (PrpDCompanyDto company : companyList) {
            //待维护用户所属机构不归属与登录用户
            if (company.getComCode().equals(fixCompany.getComCode())) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param userCode  用户名
     * @param gradeCode 岗位列表
     * @return
     * @description 检查用户是否拥有相应的岗位权限
     * @author hzhongkai
     * @
     * @date 2016年10月21日上午10:15:26
     */
    private boolean checkUserGrade(String userCode, String gradeCode) {
        GradeQueryConditionDto gradeQueryConditionDto = new GradeQueryConditionDto();
        gradeQueryConditionDto.setUserCode(userCode);
        List<SaaGradeDto> list = gradeService.queryGradeList(gradeQueryConditionDto);
        for (SaaGradeDto saaGradeDto : list) {
            if (saaGradeDto.getGradeCode().equals(gradeCode)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param treeNode
     * @param comList
     * @param upcMap
     * @return
     * @description 根据用户允许机构表 组装TreeNode
     * @author hzhongkai
     * @
     * @date 2016年10月20日下午2:25:49
     */
    private void assembleTreeNode(TreeNodeDto treeNode, List<PrpDCompanyDto> comList, Map<String, String> upcMap) {
        List<TreeNodeDto> nodes = new ArrayList<TreeNodeDto>();
        // 查询下级机构入参对象
        PrpDCompanyDto prpDCompanyDtoTemp = new PrpDCompanyDto();
        //子机构列表
        List<PrpDCompanyDto> childComList = null;
        TreeNodeDto childNode = null;
        for (PrpDCompanyDto company : comList) {
            prpDCompanyDtoTemp.setUpperComCode(company.getComCode());
            prpDCompanyDtoTemp.setComType(PowerConstants.COMTYPE_01);

            childNode = new TreeNodeDto();
            if ("1".equals(upcMap.get(company.getComCode()))) {
                //业务允许机构包含下级
                childNode.setChecked(true);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(childNode, childComList, true, null);
                }
            } else {
                // 业务允许机构不包含下级
                childNode.setChecked(false);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(childNode, childComList, upcMap);
                }
            }
            childNode.setComCode(company.getComCode());
            childNode.setUpperComCode(company.getUpperComCode());
            childNode.setTitle(company.getComCName());
            nodes.add(childNode);
        }
        treeNode.setNodes(nodes);
    }

    /**
     * @param treeNode
     * @param comList
     * @param checked
     * @param fixCompany 待维护用户机构，仅当没有配置powerid的用户才传值
     * @return
     * @description 组装TreeNode ,指定checked
     * @author hzhongkai
     * @
     * @date 2016年10月20日下午2:25:49
     */
    private void assembleTreeNode(TreeNodeDto treeNode, List<PrpDCompanyDto> comList, boolean checked, PrpDCompanyDto fixCompany) {
        List<TreeNodeDto> nodes = new ArrayList<TreeNodeDto>();
        // 查询下级机构入参对象
        PrpDCompanyDto prpDCompanyDtoTemp = new PrpDCompanyDto();

        //子机构列表
        List<PrpDCompanyDto> childComList = null;
        TreeNodeDto childNode = null;
        for (PrpDCompanyDto company : comList) {
            prpDCompanyDtoTemp.setUpperComCode(company.getComCode());
            prpDCompanyDtoTemp.setComType(PowerConstants.COMTYPE_01);
            childNode = new TreeNodeDto();
            childNode.setComCode(company.getComCode());
            childNode.setUpperComCode(company.getUpperComCode());
            //待维护机构不为空，则勾中自己包括其所有子机构
            if (fixCompany != null && fixCompany.getComCode().equals(company.getComCode())) {
                childNode.setChecked(true);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(childNode, childComList, true, null);
                }
            } else {
                childNode.setChecked(checked);
                childComList = companyService.qeuryPrpDCompanyList(prpDCompanyDtoTemp);
                if (childComList != null && childComList.size() > 0) {
                    assembleTreeNode(childNode, childComList, checked, null);
                }
            }
            childNode.setTitle(company.getComCName());
            nodes.add(childNode);
        }
        treeNode.setNodes(nodes);
    }


    /**
     * @param powerConditionDto
     * @return SaaUserPower
     * @description 创建用户数据权限
     * @
     * @author hzhongkai
     * @date 2016年10月21日上午11:53:02
     */
    @Override
    public String createUserPower(PowerConditionDto powerConditionDto) {
        Assert.notNull(powerConditionDto, " 配置允许机构服务 入参 powerConditionDto 不允许为空！");
        Assert.hasText(powerConditionDto.getUserCode(), " 配置允许机构服务 入参 UserCode 不允许为空！");
        Assert.hasText(powerConditionDto.getTaskId(), " 配置允许机构服务 入参 TaskId 不允许为空！");
        SaaUserPower saaUserPower = new SaaUserPower();
        saaUserPower.setCreateDate(new Date());
        saaUserPower.setCreatorCode(SinoRequestContext.getCurrentContext().getUserCode());
        saaUserPower.setUserCode(powerConditionDto.getUserCode());
        saaUserPower.setTaskID(powerConditionDto.getTaskId());

        BillConditionDto billConditionDto = new BillConditionDto();
        billConditionDto.setBillType("imsSaaUserPower_");
        BillDto billDto = null;
        try {
            billDto = billService.getSerialNo(billConditionDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = String.format("%019d", billDto.getSerialNo());
        saaUserPower.setID(id);
        saaUserPowerMapper.save(saaUserPower);

        return id;
    }
}
