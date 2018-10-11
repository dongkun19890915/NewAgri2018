package com.sinosoft.notice.core.model.service.impl;

import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.model.PrpMmodelComApi;
import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.CompanyListDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import com.sinosoft.notice.api.common.dto.MessageConfig;
import com.sinosoft.notice.api.common.dto.UtilNoticeModelDto;
import com.sinosoft.notice.core.model.dao.HisUtilNoticeModelDao;
import com.sinosoft.notice.core.model.dao.UtilNoticeModelDao;
import com.sinosoft.notice.core.model.entity.HisUtilNoticeModel;
import com.sinosoft.notice.core.model.entity.UtilNoticeModel;
import com.sinosoft.notice.core.model.entity.UtilNoticeModelKey;
import com.sinosoft.notice.core.model.service.UtilNoticeModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-30 07:15:42.402
 * @description 通知模板表Core接口实现
 */
@Service
public class UtilNoticeModelServiceImpl extends BaseServiceImpl implements UtilNoticeModelService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilNoticeModelServiceImpl.class);

    /**
     * 用来区分是否为短信权限表
     */
    private String UTILNOTICEMODELFlag = "99";

    @Autowired
    private UtilNoticeModelDao utilNoticeModelDao;

    @Autowired
    private HisUtilNoticeModelDao hisUtilNoticeModelDao;

    @Autowired
    private BillNoApi billNoApi;

    @Autowired
    private PrpMmodelComApi prpMmodelComApi;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UtiGroupApi utiGroupApi;

    @Autowired
    private PrpDcompanyApi prpDcompanyApi;



    /**
     * 新增短信模板
     *
     * @param utilNoticeModelDto
     * @return UtilNoticeModelDto
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:14
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UtilNoticeModelDto addUtilNoticeModelService(UtilNoticeModelDto utilNoticeModelDto) throws Exception {
        String noticeCode = generageNoticeCoSde();
        utilNoticeModelDto.setNoticeCode(noticeCode);
        initialize(utilNoticeModelDto);
        UserInfo userInfo = SinoRequestContext.getCurrentContext().getUser();
        utilNoticeModelDto.setCreatedTime(new Date());
        UtilNoticeModel utilNoticeModel = this.convert(utilNoticeModelDto, UtilNoticeModel.class);
        utilNoticeModel.setModelCreatedBy(userInfo.getUserName());
        utilNoticeModelDao.save(utilNoticeModel);
        List<String> comCodeList = utilNoticeModelDto.getComCodeList();
        saveModelComCode(comCodeList, noticeCode);
        return utilNoticeModelDto;
    }


    /**
     * 逻辑删除短信模板
     *
     * @param noticeCode
     * @return String
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:14
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteUtilNoticeModel(String noticeCode) throws Exception {
        if (StringUtils.isEmpty(noticeCode)) {
            LOGGER.error("短信模板编号为空");
            throw new DataVerifyException("短信模板编号为空");
        }
        UtilNoticeModel utilNoticeModel = utilNoticeModelDao.findOne(new UtilNoticeModelKey(MessageConfig.NOTICETYPE_MESSAGE, noticeCode));
        if (null == utilNoticeModel) {
            throw new DataVerifyException("没有此短信模板");
        }
        utilNoticeModel.setDeleteFlag(MessageConfig.DELETE_OF);
        UtilNoticeModel deleteUtilNoticeModel = utilNoticeModelDao.save(utilNoticeModel);
        if (MessageConfig.DELETE_OF.equals(deleteUtilNoticeModel.getDeleteFlag())) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    /**
     * 查询短信模板详细
     *
     * @param noticeCode
     * @return UtilNoticeModelDto
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:15
     */
    @Override
    public UtilNoticeModelDto findUtilNoticeModel(String noticeCode, String comCode) throws Exception {
        if (StringUtils.isEmpty(noticeCode)) {
            LOGGER.error("短信模板编号为空");
            throw new DataVerifyException("短信模板编号为空");
        }
        UtilNoticeModel utilNoticeModel = utilNoticeModelDao.findByNoticeCodeAndDeleteFlag(noticeCode, MessageConfig.DELETE_ON);
        UtilNoticeModelDto utilNoticeModelDto = convert(utilNoticeModel, UtilNoticeModelDto.class);

        List<PrpMmodelComDto> prpMmodelComDtos = prpMmodelComApi.findByModelCode(noticeCode);

        List<String> comCodeList = new ArrayList<>(prpMmodelComDtos.size());
        prpMmodelComDtos.forEach(prpMmodelComDto -> {
            String getComCode = prpMmodelComDto.getComCode();
            comCodeList.add(getComCode);
        });
//        List<String> comCodeList = prpMmodelComDtos.stream().map(p -> p.getComCode()).collect(Collectors.toList());
        utilNoticeModelDto.setComCodeList(comCodeList);
        //调用机构数方法
        QueryComCodeInfoDto queryComCodeInfoDto = new QueryComCodeInfoDto();
        queryComCodeInfoDto.setSelectList(comCodeList);

        UserInfo userinfo = SinoRequestContext.getCurrentContext().getUser();
        String userCode = userinfo.getUserCode();
        queryComCodeInfoDto.setUserCode(userCode);
        queryComCodeInfoDto.setLoginComCode(comCode);
        List<CompanyListDto> companyListDtos = prpDcompanyApi.queryCompanyTree(queryComCodeInfoDto);

        utilNoticeModelDto.setCompanyListDtos(companyListDtos);
        return utilNoticeModelDto;
    }


    /**
     * 修改 先通过 noticeCode 保存原来的 hisUtilNoticeModel 表，然后在更新
     *
     * @param utilNoticeModelDto
     * @return String
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:12
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateUtilNoticeModel(UtilNoticeModelDto utilNoticeModelDto) throws Exception {

        String noticeCode = utilNoticeModelDto.getNoticeCode();
        UtilNoticeModel utilNoticeModel = utilNoticeModelDao.findByNoticeCodeAndDeleteFlag(noticeCode, MessageConfig.DELETE_ON);
        HisUtilNoticeModel hisUtilNoticeModel = this.convert(utilNoticeModel, HisUtilNoticeModel.class);
        int serialNo = hisUtilNoticeModelDao.serialNoMax(noticeCode);
        hisUtilNoticeModel.setSerialNo(++serialNo);

        List<String> comCodeList = utilNoticeModelDto.getComCodeList();
        prpMmodelComApi.deleteByModelCode(noticeCode);
        saveModelComCode(comCodeList, noticeCode);
        hisUtilNoticeModelDao.save(hisUtilNoticeModel);

        UtilNoticeModel noticeModel = this.convert(utilNoticeModelDto, UtilNoticeModel.class);
        utilNoticeModelDao.save(noticeModel);
        return "修改成功";
    }


    /**
     * 不需要判断 noticeCode status 是否为空，因为页面是通过按钮来传递的，必然有值且不为null
     * 当用户 点击按钮的时候改变为相反的状态
     * @param noticeCode
     * @param status
     * @return String
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:13
     */
    @Override
    public String changeStatus(String noticeCode, String status) throws Exception {
        UtilNoticeModel utilNoticeModel = utilNoticeModelDao.findOne(new UtilNoticeModelKey(MessageConfig.NOTICETYPE_MESSAGE, noticeCode));
        if (MessageConfig.STATUS_OF.equals(status)) {
            utilNoticeModel.setStatus(MessageConfig.STATUS_ON);
            utilNoticeModelDao.save(utilNoticeModel);
            return "短信模板已启用";
        } else {
            utilNoticeModel.setStatus(MessageConfig.STATUS_OF);
            utilNoticeModelDao.save(utilNoticeModel);
            return "短信模板已停用";
        }
    }


    /**
     * 短信模板分页
     *
     * @param offset
     * @param length
     * @param noticeName
     * @return PageInfo<UtilNoticeModelDto>
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/13 上午9:13
     */
    @Override
    public PageInfo<UtilNoticeModelDto> queryByNoticeNamePaging(Integer offset, Integer length, String noticeName, String type) throws Exception {

        Pageable pageable = new PageRequest(offset - 1, length, Sort.Direction.DESC, "noticeCode");

        Page<UtilNoticeModel> noticePage = null;
        if (StringUtils.isEmpty(noticeName)) {
            noticePage = utilNoticeModelDao.findByDeleteFlag(pageable, MessageConfig.DELETE_ON);
        } else if ("1".equals(type)) {//模板名称
            noticePage = utilNoticeModelDao.findByNoticeNameContainingAndDeleteFlag(pageable, noticeName, MessageConfig.DELETE_ON);
        } else if ("2".equals(type)) {//模板号码
            noticePage = utilNoticeModelDao.findByNoticeCodeAndDeleteFlag(pageable, noticeName, MessageConfig.DELETE_ON);
        } else if ("3".equals(type)) {//创建人
            noticePage = utilNoticeModelDao.findByModelCreatedByAndDeleteFlag(pageable, noticeName, MessageConfig.DELETE_ON);
        }

        List<UtilNoticeModel> utilNoticeModels = noticePage.getContent();
        for (UtilNoticeModel utilNoticeModel : utilNoticeModels) {
            if (new Date().after(utilNoticeModel.getValidEndDate())) {
                utilNoticeModel.setStatus(MessageConfig.STATUS_OF);
            }
        }
        List<UtilNoticeModelDto> utilNoticeModelDtos = new ArrayList<>(utilNoticeModels.size());
        this.convertCollection(utilNoticeModels, utilNoticeModelDtos, UtilNoticeModelDto.class);

        PageInfo<UtilNoticeModelDto> pageInfo = new PageInfo<>();
        pageInfo.setContent(utilNoticeModelDtos);
        pageInfo.setTotalCount(noticePage.getTotalElements());
        pageInfo.setPages(offset);
        return pageInfo;
    }


    /**
     * 判断用户是否输入有中文，如果有，就走模板名称模糊查询，如果没有，走模板编号模糊查询
     *
     * @param
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/18 上午10:03
     */
    @Override
    public List<UtilNoticeModelDto> findNoticeContent(String comCode, String userCode,String loginGradeCodes,String riskCode) throws Exception {

        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("参数\"员工代码\"没有值");
        }

        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("参数\"机构代码\"没有值");
        }

        Map<String, String> map = new HashMap<>();
        map.put("flag", UTILNOTICEMODELFlag);

//        comCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
        map.put("comCode", comCode);

        List<PrpMmodelComDto> prpMmodelComDtoList = prpMmodelComApi.queryByComcode(map);

        StringBuilder dataSql = new StringBuilder("select n from UtilNoticeModel n where n.status ='1'" +
                " and n.deleteFlag = '1' AND n.validStartDate <= TO_DATE(SYSDATE) AND n.validEndDate >= TO_DATE(SYSDATE) ");
        if (prpMmodelComDtoList.size() > 0) {
            dataSql.append(" AND n.noticeCode IN(");
            for (int i = 0; i < prpMmodelComDtoList.size(); i++) {
                if (i == prpMmodelComDtoList.size() - 1) {
                    dataSql.append("'" + prpMmodelComDtoList.get(i).getModelCode() + "'");
                } else {
                    dataSql.append("'" + prpMmodelComDtoList.get(i).getModelCode() + "',");
                }
            }
            dataSql.append(")");
        }
        if(StringUtils.isNotEmpty(riskCode)){
            dataSql.append("and n.riskCode='"+riskCode+"'");
        }else {
            riskCode="";
        }

        AddCodePowerConditionDto addCodePowerConditionDto
                = new AddCodePowerConditionDto(userCode, comCode,
                loginGradeCodes,
                "UtilNoticeModel",
                "userCode",
                "comCode",
                riskCode,
                "n",
                false);
        String addCodePower = utiGroupApi.addRiskCodePermit(addCodePowerConditionDto);
        if (!StringUtils.isEmpty(addCodePower)) {
            dataSql.append(addCodePower);
        }

        Query dataQuery = entityManager.createQuery(dataSql.toString());
        List<UtilNoticeModel> utilNoticeModels = dataQuery.getResultList();
        List<UtilNoticeModelDto> utilNoticeModelDtos = new ArrayList<>(utilNoticeModels.size());
        this.convertCollection(utilNoticeModels, utilNoticeModelDtos, UtilNoticeModelDto.class);
        return utilNoticeModelDtos;
    }

    @Override
    @Transactional
    public Map<String, String> deleteAllUtilNoticeModel(List<String> noticeCodes) throws Exception {

        if (noticeCodes.size() == 0) {
            throw new DataVerifyException("条款代码集合不能为空！");
        }
        utilNoticeModelDao.deleteList(noticeCodes);

        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }


    /**
     * 初始化 utilNoticeModelDto 赋值
     * 使之默认为 短信类型， 状态开启，未删除，短信发送优先权为 1(最低)
     *
     * @param utilNoticeModelDto
     * @return
     * @author: 潘峰
     * @date: 2017/12/14 下午2:54
     */
    private UtilNoticeModelDto initialize(UtilNoticeModelDto utilNoticeModelDto) {
        utilNoticeModelDto.setNoticeType(MessageConfig.NOTICETYPE_MESSAGE);
        utilNoticeModelDto.setStatus(MessageConfig.STATUS_ON);
        utilNoticeModelDto.setDeleteFlag(MessageConfig.DELETE_ON);
        utilNoticeModelDto.setModuleCode("2");
        return utilNoticeModelDto;
    }

    /**
     * 生成模板代码
     * @return String
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/4 下午4:23
     */
    private String generageNoticeCoSde() throws Exception {
        BillNoDto billNoDto = new BillNoDto();
        billNoDto.setiComCode("");//目前不适用
        billNoDto.setRiskCode("");//目前不适用
        billNoDto.setTableName(MessageConfig.SMSTEMPLATE);
        Map<String, String> billNo = billNoApi.getBillNo(billNoDto);
        String noticeCode = billNo.get("billNo");
        return noticeCode;
    }

    /**
     * 提取重复的保存 prpMmodelComDtoList
     *
     * @param comCodeList
     * @param noticeCode
     * @author: 潘峰
     * @date: 2017/12/13 下午3:19
     */
    private void saveModelComCode(List<String> comCodeList, String noticeCode) {
        List<PrpMmodelComDto> prpMmodelComDtoList = new LinkedList<>();
        PrpMmodelComDto prpMmodelComDto;
        for (String modelComCode : comCodeList) {
            prpMmodelComDto = new PrpMmodelComDto();
            prpMmodelComDto.setModelCode(noticeCode);
            prpMmodelComDto.setFlag(UTILNOTICEMODELFlag);
            prpMmodelComDto.setComCode(modelComCode);
            prpMmodelComDtoList.add(prpMmodelComDto);
        }
        prpMmodelComApi.save(prpMmodelComDtoList);
    }
}