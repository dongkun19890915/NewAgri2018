package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.dao.*;
import com.sinosoft.dms.core.customer.dao.specification.CustomerSpecBuilder;
import com.sinosoft.dms.core.customer.entity.*;
import com.sinosoft.dms.core.customer.service.CustomerService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HSQ
 * @description 客户信息接口实现
 * @date 2017年8月28日 下午3:26:29
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseCustomServiceImpl implements CustomerService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private PrpDcustomerDao prpDcustomerDao;
    @Autowired
    private PrpDcustomLevelTraceDao prpDcustomLevelTraceDao;
    @Autowired
    private PrpDcustomerIdvDao prpDcustomerIdvDao;
    @Autowired
    private PrpDcustomerUnitDao prpDcustomerUnitDao;
    @Autowired
    private BillApi billApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcustomerTaxPayInfoDao prpDCustomerTaxPayInfoDao;
   // @Autowired
   // private GetRuleInUtiPlatConfigRuleApi getRuleInUtiPlatConfigRuleApi;

    /**
     * @param prpDcustomerDto
     * @return
     * @throws Exception
     * @description 新增prpDcustomer
     * @author HSQ
     * @date 2017年8月28日 下午2:59:34
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveCustomer(PrpDcustomerDto prpDcustomerDto) {
        PrpDcustomer prpDcustomer = convert(prpDcustomerDto, PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomer);
    }

    /**
     * @param customerCode
     * @throws Exception
     * @description 删除prpDcustomer/prpDcustomerIdv/prpDcustomerUnit
     * @author HSQ
     * @date 2017年8月28日 下午2:59:13
     */
    @Override
    public String removeCustomer(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        // 删除子表
        PrpDcustomerIdvDto prpDcustomerIdvDto = queryCustomerIdvByPK(customerCode);
        if (null != prpDcustomerIdvDto) {
            removeCustomerIdv(customerCode);
        }
        PrpDcustomerUnitDto prpDcustomerUnitDto = queryCustomerUnitByPK(customerCode);
        if (null != prpDcustomerUnitDto) {
            removeCustomerUnit(customerCode);
        }
        // 删除主表
        PrpDcustomerDto prpDcustomerDto = queryCustomerByPK(customerCode);
        if (null != prpDcustomerDto) {
            PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
            prpDcustomerDao.delete(prpDcustomerKey);
        }
        return "success";
    }

    /**
     * @param prpDcustomerDto
     * @throws Exception
     * @description 修改prpDcustomer
     * @author HSQ
     * @date 2017年8月28日 下午2:58:58
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void modifyCustomer(PrpDcustomerDto prpDcustomerDto) throws Exception {
        String customerCode = prpDcustomerDto.getCustomerCode();
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomer prpDcustomer = convert(prpDcustomerDto, PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomer);
    }

    /**
     * @param customerCode
     * @return
     * @throws Exception
     * @description 按主键查询prpDcustomer
     * @author HSQ
     * @date 2017年8月28日 下午2:58:42
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
        PrpDcustomer prpDcustomer = prpDcustomerDao.findOne(prpDcustomerKey);
        return convert(prpDcustomer, PrpDcustomerDto.class);
    }

    /**
     * @param prpDcustomerIdvDto
     * @return
     * @throws Exception
     * @description 新增prpDcustomerIdv
     * @author HSQ
     * @date 2017年8月28日 下午2:59:34
     */
    @Override
    public String saveCustomerIdv(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception {
        String customerCode = prpDcustomerIdvDto.getCustomerCode();
        if (StringUtils.isNotEmpty(customerCode)) {
            throw new Exception("客户编码必须为空！");
        }
        // 获取客户编码
        customerCode = getCustomerCode("1");
        LOGGER.error("saveCustomerIdv:customerCode={}", customerCode);
        prpDcustomerIdvDto.setCustomerCode(customerCode);
        prpDcustomerIdvDto.setNewCustomerCode(customerCode);
        prpDcustomerIdvDto.setValidStatus("1");
        // 存储主表PrpDcustomer
        PrpDcustomerDto prpDcustomerDto = convert(prpDcustomerIdvDto, PrpDcustomerDto.class);
        prpDcustomerDto.setCustomerType("1");// 个人
        saveCustomer(prpDcustomerDto);
        // 存储子表PrpDcustomerIdv
        PrpDcustomerIdv prpDcustomerIdv = convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
        prpDcustomerIdvDao.save(prpDcustomerIdv);
        return "success";
    }

    /**
     * @param customerCode
     * @throws Exception
     * @description 删除prpDcustomerIdv
     * @author HSQ
     * @date 2017年8月28日 下午2:59:13
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeCustomerIdv(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerIdvKey prpDcustomerIdvKey = new PrpDcustomerIdvKey(customerCode);
        prpDcustomerIdvDao.delete(prpDcustomerIdvKey);
    }

    /**
     * @param prpDcustomerIdvDto
     * @throws Exception
     * @description 修改prpDcustomerIdv
     * @author HSQ
     * @date 2017年8月28日 下午2:58:58
     */
    @Override
    public String modifyCustomerIdv(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception {
        String customerCode = prpDcustomerIdvDto.getCustomerCode();
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerDto prpDcustomerDtoCheck = queryCustomerByPK(customerCode);
        if (null == prpDcustomerDtoCheck) {
            throw new Exception("客户" + customerCode + "不存在！");
        }
        // 修改主表prpDcustomer
        PrpDcustomerDto prpDcustomerDto = convert(prpDcustomerIdvDto, PrpDcustomerDto.class);
        prpDcustomerDto.setCustomerType("1");// 个人
        modifyCustomer(prpDcustomerDto);
        // 修改子表PrpDcustomerIdv
        prpDcustomerIdvDto.setNewCustomerCode(prpDcustomerIdvDto.getCustomerCode());
        PrpDcustomerIdv prpDcustomerIdv = convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
        prpDcustomerIdvDao.save(prpDcustomerIdv);
        return "success";
    }

    /**
     * @param customerCode
     * @return
     * @throws Exception
     * @description 按主键查询prpDcustomerIdv
     * @author HSQ
     * @date 2017年8月28日 下午2:58:42
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PrpDcustomerIdvDto queryCustomerIdvByPK(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerIdvKey prpDcustomerIdvKey = new PrpDcustomerIdvKey(customerCode);
        PrpDcustomerIdv prpDcustomerIdv = prpDcustomerIdvDao.findOne(prpDcustomerIdvKey);
        return convert(prpDcustomerIdv, PrpDcustomerIdvDto.class);
    }

    /**
     * @param prpDcustomerUnitDto
     * @return
     * @throws Exception
     * @description 新增prpDcustomerUnit
     * @author HSQ
     * @date 2017年8月28日 下午2:59:34
     */
    @Override
    public String saveCustomerUnit(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception {
        String customerCode = prpDcustomerUnitDto.getCustomerCode();
        if (StringUtils.isNotEmpty(customerCode)) {
            throw new Exception("客户编码必须为空！");
        }
        // 获取客户编码
        customerCode = getCustomerCode("2");
        LOGGER.error("saveCustomerUnit:customerCode={}", customerCode);
        prpDcustomerUnitDto.setCustomerCode(customerCode);
        prpDcustomerUnitDto.setNewCustomerCode(customerCode);
        prpDcustomerUnitDto.setValidStatus("1");
        // 存储主表PrpDcustomer
        PrpDcustomerDto prpDcustomerDto = convert(prpDcustomerUnitDto, PrpDcustomerDto.class);
        prpDcustomerDto.setCustomerType("2");// 集体
        saveCustomer(prpDcustomerDto);
        // 存储子表PrpDcustomerUnit
        PrpDcustomerUnit prpDcustomerUnit = convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
        prpDcustomerUnitDao.save(prpDcustomerUnit);
        return "success";
    }

    /**
     * @param customerCode
     * @throws Exception
     * @description 删除prpDcustomerUnit
     * @author HSQ
     * @date 2017年8月28日 下午2:59:13
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeCustomerUnit(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerUnitKey prpDcustomerUnitKey = new PrpDcustomerUnitKey(customerCode);
        prpDcustomerUnitDao.delete(prpDcustomerUnitKey);
    }

    /**
     * @param prpDcustomerUnitDto
     * @throws Exception
     * @description 修改prpDcustomerUnit
     * @author HSQ
     * @date 2017年8月28日 下午2:58:58
     */
    @Override
    public String modifyCustomerUnit(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception {
        String customerCode = prpDcustomerUnitDto.getCustomerCode();
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerDto prpDcustomerDtoCheck = queryCustomerByPK(customerCode);
        if (null == prpDcustomerDtoCheck) {
            throw new Exception("客户" + customerCode + "不存在！");
        }
        // 修改主表prpDcustomer
        PrpDcustomerDto prpDcustomerDto = convert(prpDcustomerUnitDto, PrpDcustomerDto.class);
        prpDcustomerDto.setCustomerType("2");// 集体
        modifyCustomer(prpDcustomerDto);
        // 修改子表PrpDcustomerUnit
        PrpDcustomerUnit prpDcustomerUnit = convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
        prpDcustomerUnitDao.save(prpDcustomerUnit);
        return "success";
    }

    /**
     * @param customerCode
     * @return
     * @throws Exception
     * @description 按主键查询prpDcustomerUnit
     * @author HSQ
     * @date 2017年8月28日 下午2:58:42
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PrpDcustomerUnitDto queryCustomerUnitByPK(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerUnitKey prpDcustomerUnitKey = new PrpDcustomerUnitKey(customerCode);
        PrpDcustomerUnit prpDcustomerUnit = prpDcustomerUnitDao.findOne(prpDcustomerUnitKey);
        return convert(prpDcustomerUnit, PrpDcustomerUnitDto.class);
    }

    /**
     * @param customerReqDto
     * @return
     * @throws Exception
     * @description 根据条件查询个人客户信息
     * @author HSQ
     * @date 2017年8月28日 下午2:58:15
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<PrpDcustomerIdvDto> findPrpDcustomerIdvByCondition(CustomerReqDto customerReqDto) throws Exception {
        if (StringUtils.isEmpty(customerReqDto.getIdentifyType())) {
            throw new Exception("证件类型不能为空！");
        }
        if (StringUtils.isEmpty(customerReqDto.getIdentifyNumber())) {
            throw new Exception("证件号码不能为空！");
        }
        Specification<PrpDcustomerIdv> specification = CustomerSpecBuilder.idvSpecification(customerReqDto);
        List<PrpDcustomerIdv> list = prpDcustomerIdvDao.findAll(specification);
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = new ArrayList<PrpDcustomerIdvDto>(list.size());
        convertCollection(list, prpDcustomerIdvDtoList, PrpDcustomerIdvDto.class);
        return prpDcustomerIdvDtoList;
    }

    /**
     * @param customerReqDto
     * @return
     * @throws Exception
     * @description 根据条件查询团体客户信息
     * @author HSQ
     * @date 2017年8月28日 下午2:58:15
     */
    @Override
    public List<PrpDcustomerUnitDto> findPrpDcustomerUnitByCondition(CustomerReqDto customerReqDto) throws Exception {
        if (StringUtils.isEmpty(customerReqDto.getOrganizeCode())) {
            throw new Exception("组织机构编码不能为空！");
        }
        Specification<PrpDcustomerUnit> specification = CustomerSpecBuilder.unitSpecification(customerReqDto);
        List<PrpDcustomerUnit> list = prpDcustomerUnitDao.findAll(specification);
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList = new ArrayList<PrpDcustomerUnitDto>(list.size());
        convertCollection(list, prpDcustomerUnitDtoList, PrpDcustomerUnitDto.class);
        return prpDcustomerUnitDtoList;
    }

    /**
     * @param customerType
     * @return
     * @throws Exception
     * @description 获取客户编码
     * @author HSQ
     * @date 2017年8月28日 下午3:47:02
     */
    private String getCustomerCode(String customerType) throws Exception {
        BillConditionDto billConditionDto = new BillConditionDto();
        customerType = "customerCode_" + customerType;
        billConditionDto.setBillType(customerType);
//		billConditionDto.setLength(11);// 可以传递生成业务号长度
        String customerCode = billApi.getCustomerCode(billConditionDto);
        return customerCode;
    }

    /**
     * 保存客户信息，自动生成客户号
     *
     * @param iPrpDcustomerSchema 客户记录
     * @param comCode             机构代码
     * @throws Exception
     */
    public String addCustomer(PrpDcustomerDto iPrpDcustomerSchema, String comCode)
            throws Exception {
        String strCustomerCode = this.apply(iPrpDcustomerSchema.getCustomerType(), comCode);
        iPrpDcustomerSchema.setCustomerCode(strCustomerCode);
        PrpDcustomer prpDcustomer = convert(iPrpDcustomerSchema, PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomer);
        return strCustomerCode;
    }

    /**
     * @param iCustomerType 客户类型
     * @param iMakeCom
     * @return
     * @throws Exception
     * @description:生成客户号
     * @author: 钱浩
     * @date: 2017/10/20 19:36
     */
    public String apply(String iCustomerType, String iMakeCom)
            throws Exception {
        String strWherePart = "";
        String strCustomerCode = "";
        String sql = "";
        // 平台配置系统交互
        /*String dbType=getProperty("DBTYPE");*/
        //TODO 与平台交互暂时注掉，等待国元开发完成链接测试 String dbType = getRuleInUtiPlatConfigRuleApi.queryfindOne("prpall", "DBTYPE", "1");
        String dbType = "";
        dbType="ORACLE";
        if (dbType.endsWith("ORACLE")) {
            sql = " Select * From (Select * From Prpdcustomer  where  ";
        }
        if (dbType.endsWith("DB2")) {
            sql = " Select * From (Select row_number() over(Order By Customercode desc)  As Linenum ,Prpdcustomer.* From Prpdcustomer  where  ";
        }
        if (iCustomerType.equals("1")) {
            strWherePart = "Substr(CustomerCode,1,7) ='" + "5" + iMakeCom.trim().substring(0, 6)
                    + "'";
        } else {
            strWherePart = "Substr(CustomerCode,1,7) ='" + "0" + iMakeCom.trim().substring(0, 6)
                    + "'";
        }
        String strsql = " SELECT COUNT(*) FROM PrpDcustomer WHERE " + strWherePart;
        Query query = entityManager.createNativeQuery(strsql);
        Object obj = query.getSingleResult();
        int integer = Integer.parseInt(obj.toString());
        if (integer == 0) {
            if (iCustomerType.equals("1")) {
                strCustomerCode = "5" + iMakeCom.trim().substring(0, 6) + "000000001";
            } else {
                strCustomerCode = "0" + iMakeCom.trim().substring(0, 6) + "000000001";
            }
        } else {
            if (dbType.endsWith("ORACLE")) {
                sql = sql + strWherePart + "  AND LENGTH(Trim(CustomerCode))=16  Order By Customercode Desc) T  Where Rownum = 1";
            } else {
                sql = sql + strWherePart + "  AND LENGTH(rtrim(ltrim(CustomerCode)))=16   ) T  Where Linenum = 1";
            }
            Query query1 = entityManager.createNativeQuery(sql, PrpDcustomer.class);
            List<PrpDcustomer> list = query1.getResultList();
            PrpDcustomer prpDcustomer1 = list.get(0);
            int intcode = Integer.parseInt(prpDcustomer1.getCustomerCode().trim().substring(7, 16));
            intcode++;
            String strcode = "" + intcode;
            int intlimit = 9 - strcode.length();
            for (int i = 0; i < intlimit; i++) {
                strcode = "0" + strcode;
            }
            strCustomerCode = prpDcustomer1.getCustomerCode().substring(0, 7) + strcode;
        }
        return strCustomerCode;
    }

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        PrpDcustomLevelTrace prpDcustomLevelTrace = this.convert(prpDcustomLevelTraceDto, PrpDcustomLevelTrace.class);
        prpDcustomLevelTraceDao.save(prpDcustomLevelTrace);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDcustomLevelTraceDto queryByPK(String customerCode, java.lang.Integer lineNo) {
        PrpDcustomLevelTraceKey prpDcustomLevelTraceKey = new PrpDcustomLevelTraceKey(customerCode, lineNo);
        PrpDcustomLevelTrace prpDcustomLevelTrace = prpDcustomLevelTraceDao.findOne(prpDcustomLevelTraceKey);
        return this.convert(prpDcustomLevelTrace, PrpDcustomLevelTraceDto.class);
    }

    /**
     * @param customerCode
     * @return
     * @description:根据customerCode查询
     * @author: 钱浩
     * @date: 2017/10/21 14:10
     */
    public PrpDcustomLevelTraceDto queryPrpDcustomLevelTraceByConnection(String customerCode) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = new PrpDcustomLevelTraceDto();
        stringBuilder.append(" select t from  PrpDcustomLevelTrace t where t.customerCode=:customerCode ");
        Query managerQuery = entityManager.createQuery(stringBuilder.toString());
        managerQuery.setParameter("customerCode", customerCode);
        List<PrpDcustomLevelTrace> prpDcustomLevelTraceList = managerQuery.getResultList();
        for (PrpDcustomLevelTrace prpDcustomLevelTrace : prpDcustomLevelTraceList) {
            prpDcustomLevelTraceDto = convert(prpDcustomLevelTrace, PrpDcustomLevelTraceDto.class);
        }
        return prpDcustomLevelTraceDto;
    }

    /**
     *   集体客户根据号查询
     * @author: 钱浩
     * @date: 2017/11/1 15:29
     * @param socialCode 机构代码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ： PageInfo<PrpDcustomerUnitDto>对象
     * @throws Exception
     */
    public ResponseDto queryPrpDcustomerUnitByCondition(String socialCode, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(socialCode)) {
            throw new BusinessException("客户名称不能为空！");
        }
        if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        String totalSize = "";
        Long totalSizeStrLon = null;
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList = new ArrayList<PrpDcustomerUnitDto>();
        PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();
        prpDcustomerUnitDto.setSocialCode(socialCode);
        StringBuilder strWhereUnti = new StringBuilder(" select t from PrpDcustomerUnit t where t.socialCode like :socialCode  order by  t.customerCode ");
        StringBuilder strWhereUntiCount = new StringBuilder(" select count(t) from PrpDcustomerUnit t where t.socialCode like :socialCode ");
        Query queryUnti = entityManager.createQuery(strWhereUnti.toString());
        //查询总条数
        Query queryUntiCount = entityManager.createQuery(strWhereUntiCount.toString());
        queryUntiCount.setParameter("socialCode", "%" + prpDcustomerUnitDto.getSocialCode() + "%");
        Object object = queryUntiCount.getSingleResult();
        totalSize = object.toString();
        if (pageNo != null) {
            queryUnti.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            queryUnti.setMaxResults(pageSize.intValue());
        }
        queryUnti.setParameter("socialCode", "%" + prpDcustomerUnitDto.getSocialCode() + "%");
        List<PrpDcustomerUnit> prpDcustomerUnitList = queryUnti.getResultList();
        convertCollection(prpDcustomerUnitList, prpDcustomerUnitDtoList, PrpDcustomerUnitDto.class);

        totalSizeStrLon = Long.valueOf(totalSize);
        PageInfo<PrpDcustomerUnitDto> pageInfo = this.setPageInfo(prpDcustomerUnitDtoList, pageNo, totalSizeStrLon, PrpDcustomerUnitDto.class);
        return ResponseDto.instance(pageInfo);
    }

    /**
     *  个体客户根据证件号查询
     * @author: 钱浩
     * @date: 2017/10/13 18:39
     * @param identifyNumber 证件号码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ：PageInfo<PrpDcustomerIdvDto>  大对象
     * @throws Exception
     */
    public ResponseDto queryPrpDcustomerIdvByCondition(String identifyNumber, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(identifyNumber)) {
            throw new BusinessException("客户名称不能为空！");
        }
        if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        String totalSize = "";
        Long totalSizeStrLon = null;
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = new ArrayList<PrpDcustomerIdvDto>();
        PrpDcustomerIdvDto prpDcustomerIdvDto = new PrpDcustomerIdvDto();
        //个人客户
        prpDcustomerIdvDto.setIdentifyNumber(identifyNumber);
        StringBuilder strWhereIdv = new StringBuilder("select t from PrpDcustomerIdv t where t.identifyNumber like :identifyNumber  order by  t.customerCode ");
        StringBuilder strWhereIdvCount = new StringBuilder("select count(t) from PrpDcustomerIdv t where t.identifyNumber like :identifyNumber ");
        System.out.print(strWhereIdv.toString());
        Query queryIdv = entityManager.createQuery(strWhereIdv.toString());
        //查询总条数
        Query queryCount = entityManager.createQuery(strWhereIdvCount.toString());
        queryCount.setParameter("identifyNumber", "%" + prpDcustomerIdvDto.getIdentifyNumber() + "%");
        Object object = queryCount.getSingleResult();
        totalSize = object.toString();
        if (pageNo != null) {
            queryIdv.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            queryIdv.setMaxResults(pageSize.intValue());
        }
        queryIdv.setParameter("identifyNumber", "%" + prpDcustomerIdvDto.getIdentifyNumber() + "%");
        List<PrpDcustomerIdv> prpDcustomerIdvList = queryIdv.getResultList();
        convertCollection(prpDcustomerIdvList, prpDcustomerIdvDtoList, PrpDcustomerIdvDto.class);
        totalSizeStrLon = Long.valueOf(totalSize);
        PageInfo<PrpDcustomerIdvDto> pageInfo = this.setPageInfo(prpDcustomerIdvDtoList, pageNo, totalSizeStrLon, PrpDcustomerIdvDto.class);
        return ResponseDto.instance(pageInfo);
    }

    /**
     *  1.判断customerType为1走个体客户，否则集体客户
     * 2.风险轨迹表PrpDcustomLevelTrace保存
     * 3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
     * @author: 钱浩
     * @date: 2017/10/21 15:00
     * @param prpDcustomerSaveDto 增加或者修改客户封装dto
     * @return ResponseDto： 成功或失败
     * @throws Exception
     */
    public ResponseDto saveCustomerInfo(PrpDcustomerSaveDto prpDcustomerSaveDto) throws Exception {
        String userCode = prpDcustomerSaveDto.getUserCode();
        String comCode = prpDcustomerSaveDto.getComCode();
        String customerType = prpDcustomerSaveDto.getCustomerType();
        PrpDcustomerIdvDto prpDcustomerIdvDto = prpDcustomerSaveDto.getPrpDcustomerIdvDto();
        PrpDcustomerUnitDto prpDcustomerUnitDto = prpDcustomerSaveDto.getPrpDcustomerUnitDto();
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = prpDcustomerSaveDto.getPrpDcustomerTaxPayInfoDto();
        if (StringUtils.isEmpty(customerType)) {
            throw new Exception("用户类型不能为空");
        }
        com.sinosoft.dms.api.customer.dto.PrpDcustomerDto prpDcustomerDto = new com.sinosoft.dms.api.customer.dto.PrpDcustomerDto();
        String EditType = "M";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
        String inputDate = simpleDateFormat.format(new Date());
        String update = simpleDateFormat.format(new Date());
        String oldUserCode = "";
        String customerCode = "";
        String strNewRiskLevel = "";
        //1.判断customerType为1走个体客户，否则集体客户
        if ("1".equals(customerType)) {
            prpDcustomerDto.setCustomerCName(prpDcustomerIdvDto.getCustomerCName());
            prpDcustomerDto.setCustomerEName(prpDcustomerIdvDto.getCustomerEName());
            prpDcustomerDto.setAddressCName(prpDcustomerIdvDto.getAddressCName());
            prpDcustomerDto.setAddressEName(prpDcustomerIdvDto.getAddressEName());
            prpDcustomerDto.setValidStatus("1");
            prpDcustomerDto.setCustomerType(customerType);
            strNewRiskLevel = prpDcustomerIdvDto.getRiskLevel();
            //判断CustomerCode是否为空，为空走生成CustomerCode逻辑
            if (StringUtils.isEmpty(prpDcustomerIdvDto.getCustomerCode())) {
                EditType = "I";
            } else {
                customerCode = prpDcustomerIdvDto.getCustomerCode();
            }
            if (EditType.equals("I")) {
                //生成新CustomerCode
                customerCode = addCustomer(prpDcustomerDto, comCode);
                prpDcustomerIdvDto.setCustomerCode(customerCode);
            }
            prpDcustomerIdvDto.setNewCustomerCode(customerCode);
            if (EditType.equals("M")) {
                PrpDcustomerIdv prpDcustomerIdv1 = prpDcustomerIdvDao.findOne(new PrpDcustomerIdvKey(customerCode));
                if (prpDcustomerIdv1.getInputDate() == null || "".equals(prpDcustomerIdv1.getInputDate())) {
                    inputDate = null;
                } else {
                    inputDate = simpleDateFormat.format(prpDcustomerIdv1.getInputDate());
                }
                oldUserCode = prpDcustomerIdv1.getOperatorCode();
            }
            prpDcustomerIdvDto.setValidStatus("1");
            if (EditType.equals("I")) {
                //新增时才需要填这两项shuxing
                prpDcustomerIdvDto.setOperatorCode(userCode);
                prpDcustomerIdvDto.setInputDate(simpleDateFormat.parse(inputDate));
            } else {
                if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
                } else {
                    prpDcustomerIdvDto.setInputDate(simpleDateFormat.parse(inputDate));
                }
                prpDcustomerIdvDto.setOperatorCode(oldUserCode);
                prpDcustomerIdvDto.setUpdateDate(simpleDateFormat.parse(update));
                prpDcustomerIdvDto.setUpdaterCode(userCode);
            }
            PrpDcustomerIdv prpDcustomerIdv = convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
            //更新
            prpDcustomerIdvDao.save(prpDcustomerIdv);
        } else {
            prpDcustomerDto.setCustomerCName(prpDcustomerUnitDto.getCustomerCName());
            prpDcustomerDto.setCustomerEName(prpDcustomerUnitDto.getCustomerEName());
            prpDcustomerDto.setAddressCName(prpDcustomerUnitDto.getAddressCName());
            prpDcustomerDto.setAddressEName(prpDcustomerUnitDto.getAddressEName());
            prpDcustomerDto.setValidStatus("1");
            prpDcustomerDto.setCustomerType(customerType);
            strNewRiskLevel = prpDcustomerUnitDto.getRiskLevel();
            if (StringUtils.isEmpty(prpDcustomerUnitDto.getCustomerCode())) {
                EditType = "I";
            } else {
                customerCode = prpDcustomerUnitDto.getCustomerCode();
            }
            if (EditType.equals("I")) {
                customerCode = addCustomer(prpDcustomerDto, comCode);
                prpDcustomerUnitDto.setCustomerCode(customerCode);
            }
            prpDcustomerUnitDto.setNewCustomerCode(customerCode);
            if (EditType.equals("M")) {
                PrpDcustomerUnit prpDcustomerUnit1 = prpDcustomerUnitDao.findOne(new PrpDcustomerUnitKey(customerCode));
                if (prpDcustomerUnit1.getInputDate() == null || "".equals(prpDcustomerUnit1.getInputDate())) {
                    inputDate = null;
                } else {
                    inputDate = simpleDateFormat.format(prpDcustomerUnit1.getInputDate());
                }
                oldUserCode = prpDcustomerUnit1.getOperatorCode();
            }
            prpDcustomerUnitDto.setValidStatus("1");
            if (EditType.equals("I")) {
                //新增时才需要填这两项
                prpDcustomerUnitDto.setOperatorCode(userCode);
                prpDcustomerUnitDto.setInputDate(simpleDateFormat.parse(inputDate));
            } else {
                if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
                } else {
                    prpDcustomerUnitDto.setInputDate(simpleDateFormat.parse(inputDate));
                }
                prpDcustomerUnitDto.setOperatorCode(oldUserCode);
                prpDcustomerUnitDto.setUpdateDate(simpleDateFormat.parse(update));
                prpDcustomerUnitDto.setUpdaterCode(userCode);
            }
            PrpDcustomerUnit prpDcustomerUnit = convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
            prpDcustomerUnitDao.save(prpDcustomerUnit);
        }
        //2.风险轨迹表PrpDcustomLevelTrace保存
        int maxLineNo = 1;

        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = queryPrpDcustomLevelTraceByConnection(customerCode);
        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto1 = new com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto();
        if (prpDcustomLevelTraceDto.getCustomerCode() != null) {
            prpDcustomLevelTraceDto1.setOldRiskLevel(prpDcustomLevelTraceDto.getNewRiskLevel());
            maxLineNo = prpDcustomLevelTraceDto.getLineNo() + 1;
        }
        prpDcustomLevelTraceDto1.setCustomerCode(customerCode);
        prpDcustomLevelTraceDto1.setLineNo(maxLineNo);
        prpDcustomLevelTraceDto1.setNewRiskLevel(strNewRiskLevel);
        prpDcustomLevelTraceDto1.setOperateCode(userCode);
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
        } else {
            prpDcustomLevelTraceDto1.setOperateDate(simpleDateFormat.parse(inputDate));
        }
        save(prpDcustomLevelTraceDto1);
        //3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
        if (StringUtils.isEmpty(prpDcustomerTaxPayInfoDto.getTaxpayerType())) {
            throw new Exception("纳税人身份不能为空");
        }
        prpDcustomerTaxPayInfoDto.setCustomerCode(customerCode);
        if (customerType.trim().equals("1")) {//个人客户
            prpDcustomerTaxPayInfoDto.setCustomerName(prpDcustomerIdvDto.getCustomerCName());
            prpDcustomerTaxPayInfoDto.setCustomerType(customerType);

        } else {//单位用户
            prpDcustomerTaxPayInfoDto.setCustomerName(prpDcustomerUnitDto.getCustomerCName());
            prpDcustomerTaxPayInfoDto.setCustomerType(customerType);
        }
        PrpDcustomerTaxPayInfo prpDCustomerTaxPayInfo = convert(prpDcustomerTaxPayInfoDto, PrpDcustomerTaxPayInfo.class);
        prpDCustomerTaxPayInfoDao.save(prpDCustomerTaxPayInfo);
        return ResponseDto.instance("success");
    }

}
