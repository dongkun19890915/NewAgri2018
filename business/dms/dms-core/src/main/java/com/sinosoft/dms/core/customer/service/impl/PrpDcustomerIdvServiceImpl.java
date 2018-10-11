package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.dao.PrpDcustomLevelTraceDao;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerDao;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerIdvDao;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerUnitDao;
import com.sinosoft.dms.core.customer.entity.*;
import com.sinosoft.dms.core.customer.service.PrpDcustomerIdvService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 个人客户代码表Core接口实现
 */
@Service
public class PrpDcustomerIdvServiceImpl extends BaseCustomServiceImpl implements PrpDcustomerIdvService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerIdvServiceImpl.class);

    @Autowired
    private PrpDcustomerIdvDao prpDcustomerIdvDao;
    @Autowired
    private PrpDcustomerDao prpDCustomerDao;
    @Autowired
    private PrpDcustomerUnitDao prpDCustomerUnitDao;
    @Autowired
    private PrpDcustomLevelTraceDao prpDCustomLevelTraceDao;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDcustomerIdvDto prpDcustomerIdvDto) {
        PrpDcustomerIdv prpDcustomerIdv = this.convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
        prpDcustomerIdvDao.save(prpDcustomerIdv);
    }
    /**
     * 保存个体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:01
     * @param prpDcustomerIdvDtos 个体客户信息集合
     */
    @Override
    public void saveByList(List<PrpDcustomerIdvDto> prpDcustomerIdvDtos) {
        List<PrpDcustomerIdv> prpDcustomerIdvs = new ArrayList<PrpDcustomerIdv>();
        this.convertCollection(prpDcustomerIdvDtos,prpDcustomerIdvs,PrpDcustomerIdv.class);
        prpDcustomerIdvDao.save(prpDcustomerIdvs);
    }
    /**
     * @param
     * @description 删除
     */
    public void remove(String customercode) {
        PrpDcustomerIdvKey prpDcustomerIdvKey = new PrpDcustomerIdvKey(customercode);
        prpDcustomerIdvDao.delete(prpDcustomerIdvKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(PrpDcustomerIdvDto prpDcustomerIdvDto) {
        PrpDcustomerIdv prpDcustomerIdv = this.convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
        prpDcustomerIdvDao.save(prpDcustomerIdv);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDcustomerIdvDto queryByPK(String customercode) {
        PrpDcustomerIdvKey prpDcustomerIdvKey = new PrpDcustomerIdvKey(customercode);
        PrpDcustomerIdv prpDcustomerIdv = prpDcustomerIdvDao.findOne(prpDcustomerIdvKey);
        return this.convert(prpDcustomerIdv, PrpDcustomerIdvDto.class);
    }

    /**
     * @param requestSaveDto
     * @return String
     * @description:（保存数据）
     * @author: 董坤
     * @date: 2017/10/18 8:57
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveByCondition(RequestSaveDto requestSaveDto) throws Exception {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);
        StringBuilder sqlMain = new StringBuilder(" select p from PrpDcustomer p where 1=1 ");
        StringBuilder sqlIdv = new StringBuilder(" select p from PrpDcustomerIdv p where 1=1 ");
        StringBuilder sqlUnit = new StringBuilder(" select p from PrpDcustomerUnit p where 1=1 ");
        StringBuilder sqlTrace = new StringBuilder(" select p from PrpDcustomLevelTrace p where 1=1 ");
        Map<String, Object> map = new HashMap<>();
        if (!"".equals(requestSaveDto.getAppliInsuredInsuredCode())) {
            sqlMain.append(" AND  p.customerCode = :customerCode ");
            sqlIdv.append(" AND  p.customerCode = :customerCode ");
            sqlUnit.append(" AND  p.customerCode = :customerCode ");
            sqlTrace.append(" AND  p.customerCode = :customerCode ");
            map.put("customerCode", requestSaveDto.getAppliInsuredInsuredCode());
        }
        String message = "";
        try {
            //更新客户主表
            Query queryMain = entityManager.createQuery(sqlMain.toString());
            this.setQueryParam(queryMain, map);
            List<PrpDcustomer> listMain = queryMain.getResultList();
            for (PrpDcustomer prpDCustomer : listMain) {
                prpDCustomer.setCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                prpDCustomer.setCustomerCName(requestSaveDto.getAppliInsuredInsuredName());
                prpDCustomer.setAddressCName(requestSaveDto.getAppliInsuredInsuredAddress());
                prpDCustomer.setOrganizeCode(requestSaveDto.getAppliInsuredIdentifyNumber());
                prpDCustomerDao.save(prpDCustomer);
            }
            //更新客户明细表
            //个人客户信息保存

            if ("1".equals(requestSaveDto.getAppliInsuredInsuredType())) {
                Query queryIdv = entityManager.createQuery(sqlIdv.toString());
                this.setQueryParam(queryIdv, map);
                List<PrpDcustomerIdv> listIdv = queryIdv.getResultList();
                for (PrpDcustomerIdv prpDCustomerIdv : listIdv) {
                    prpDCustomerIdv.setCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                    prpDCustomerIdv.setAddressCName(requestSaveDto.getAppliInsuredInsuredAddress());
                    prpDCustomerIdv.setPostCode(requestSaveDto.getPostCode());
                    prpDCustomerIdv.setIdentifyNumber(requestSaveDto.getAppliInsuredIdentifyNumber());
                    prpDCustomerIdv.setLinkAddress(requestSaveDto.getPostAddress());
                    prpDCustomerIdv.setCustomerCName(requestSaveDto.getAppliInsuredInsuredName());
                    prpDCustomerIdv.setNewCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                    prpDCustomerIdv.setValidStatus("1");
                    prpDCustomerIdv.setIdentifyType(requestSaveDto.getAppliInsuredIdentifyType());
                    prpDCustomerIdv.setRiskLevel(requestSaveDto.getAppliInsuredRiskLevel());
                    prpDCustomerIdv.setOperatorCode(requestSaveDto.getOperatiorCode());
                    prpDCustomerIdv.setInputDate("".equals(requestSaveDto.getInputDate()) ? null : sdf.parse(requestSaveDto.getInputDate()));
                    prpDCustomerIdv.setUpdaterCode(requestSaveDto.getUserCode());
                    prpDCustomerIdv.setUpdateDate("".equals(currentDate) ? null : sdf.parse(currentDate));
                    prpDCustomerIdv.setComCode(requestSaveDto.getComCode());
                    prpDCustomerIdv.setPhoneNumber(requestSaveDto.getPhoneNumber());
                    prpDCustomerIdv.setSex(requestSaveDto.getAppliSex());
                    prpDCustomerIdv.setValidPeriod3(requestSaveDto.getAppliValidperiod3());
                    prpDCustomerIdv.setNationality(requestSaveDto.getAppliNationality());
                    prpDCustomerIdv.setCashFocus(requestSaveDto.getAppliCashFocus());
                    prpDCustomerIdv.setJobTitle(requestSaveDto.getAppliJobTitle());
                    prpDCustomerIdv.setIsCareClaim(requestSaveDto.getAppliIsCareClaim());
                    prpDcustomerIdvDao.save(prpDCustomerIdv);
                }
            }

            //单位客户信息保存
            if ("2".equals(requestSaveDto.getAppliInsuredInsuredType())) {
                Query queryUnit = entityManager.createQuery(sqlUnit.toString());
                this.setQueryParam(queryUnit, map);
                List<PrpDcustomerUnit> listUnit = queryUnit.getResultList();
                for (PrpDcustomerUnit prpDCustomerUnit : listUnit) {
                    prpDCustomerUnit.setCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                    prpDCustomerUnit.setAddressCName(requestSaveDto.getAppliInsuredInsuredAddress());
                    prpDCustomerUnit.setPostCode(requestSaveDto.getPostCode());
                    prpDCustomerUnit.setCustomerCName(requestSaveDto.getAppliInsuredInsuredName());
                    prpDCustomerUnit.setNewCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                    prpDCustomerUnit.setValidStatus("1");
                    prpDCustomerUnit.setIdentifyType(requestSaveDto.getAppliInsuredIdentifyType());
                    prpDCustomerUnit.setRiskLevel(requestSaveDto.getAppliInsuredRiskLevel());
                    prpDCustomerUnit.setOperatorCode(requestSaveDto.getOperatiorCode());
                    prpDCustomerUnit.setOrganizeCode(requestSaveDto.getAppliInsuredIdentifyNumber());
                    prpDCustomerUnit.setInputDate("".equals(requestSaveDto.getInputDate()) ? null : sdf.parse(requestSaveDto.getInputDate()));
                    prpDCustomerUnit.setUpdaterCode(requestSaveDto.getUserCode());
                    prpDCustomerUnit.setUpdateDate("".equals(currentDate) ? null : sdf.parse(currentDate));
                    prpDCustomerUnit.setComCode(requestSaveDto.getComCode());
                    prpDCustomerUnit.setPostAddress(requestSaveDto.getPostAddress());
                    prpDCustomerUnit.setCustomerShortName(requestSaveDto.getShortName());
                    prpDCustomerUnit.setPhoneNumber(requestSaveDto.getPhoneNumber());
                    prpDCustomerUnit.setIdentifyValidPeriod(requestSaveDto.getAppliIdentifyValidPeriod());
                    prpDCustomerUnit.setComType(requestSaveDto.getAppliComtype());//公司性质
                    prpDCustomerUnit.setIsCareClaim(requestSaveDto.getAppliIsCareClaim());//客户是否关注审计、理赔、退保信息
                    prpDCustomerUnit.setCashFocus(requestSaveDto.getAppliCashFocus());//行业现金密度
                    prpDCustomerUnit.setBusinessLicenceNo(requestSaveDto.getAppliBusinessLicenceno());//营业执照
                    prpDCustomerUnit.setBusinessLicenceValidPeriod(new DateTime(requestSaveDto.getAppliBusinessLicenceValidPeriod()));//营业执照到期日
                    prpDCustomerUnit.setRevenueCode(requestSaveDto.getAppliRevenueCode());//税务登记证
                    prpDCustomerUnit.setRevenuePeriod(requestSaveDto.getAppliRevenuePeriod());//税务登记证有效期
                    prpDCustomerUnit.setOtherCodeNo(requestSaveDto.getAppliOtherCode());//其他证件代码
                    prpDCustomerUnit.setOtherCodeValidPeriod(requestSaveDto.getAppliOtherPeriod());//其他证件有效期
                    prpDCustomerUnitDao.save(prpDCustomerUnit);
                }

            }
            //风险等级 Starttttttttttttttt
            int maxLineNo = 1;
            String strOldRiskLevel = "";
            Query queryTrace = entityManager.createQuery(sqlTrace.toString());
            this.setQueryParam(queryTrace, map);
            List<PrpDcustomLevelTrace> listTrace = queryTrace.getResultList();
            //与数据库交互的类
            PrpDcustomLevelTrace prpDCustomLevelTrace = new PrpDcustomLevelTrace();
            for (PrpDcustomLevelTrace trace : listTrace) {
                if (trace.getNewRiskLevel() != null) {
                    strOldRiskLevel = trace.getNewRiskLevel();
                    prpDCustomLevelTrace.setOldRiskLevel(trace.getNewRiskLevel());
                }
                maxLineNo = trace.getLineNo() + 1;
            }
            //如果修改了风险等级，则插入数据
            if (!strOldRiskLevel.equals(requestSaveDto.getAppliInsuredRiskLevel())) {
                prpDCustomLevelTrace.setCustomerCode(requestSaveDto.getAppliInsuredInsuredCode());
                prpDCustomLevelTrace.setLineNo(maxLineNo);
                prpDCustomLevelTrace.setNewRiskLevel(requestSaveDto.getAppliInsuredRiskLevel());
                prpDCustomLevelTrace.setOperateCode(requestSaveDto.getOperatiorCode());
                prpDCustomLevelTrace.setOperateDate("".equals(currentDate) ? null : sdf.parse(currentDate));
                prpDCustomLevelTraceDao.save(prpDCustomLevelTrace);
            }
            //风险等级 Endddddddddddddddddd
            message = "success";
        } catch (Exception e) {
            message = "failed";
            e.printStackTrace();
            throw e;
        } finally {

        }
        return message;
    }

    /**
     * @param requestDto
     * @return List<PrpDCustomerIdvDto>
     * @description:（查询个人客户风险等级信息）
     * @author: 董坤
     * @date: 2017/10/16 8:40
     */
    @Override
    public List<ResponseCustomerRiskLevelDto> queryRiskLevelByCondition(RequestDto requestDto) throws Exception {
        int pageSize = 10; //每页显示的记录数
        int pageNum = 1;//页码号
        int pageCount = 0;//总页码数

        //com.sinosoft.framework.dto.ResponseDto
        //原生sql
        String sql1 = " select count(*) from PrpDcustomerIdv  where  comCode ='" + requestDto.getComCode() + "' ";
        String sqlT1 = " select count(*) from PrpDcustomerUnit  where  comCode ='" + requestDto.getComCode() + "' ";
        //查询符合条件的数据
        //jpql
        StringBuilder sql = new StringBuilder(" select p from PrpDcustomerIdv p where  p.comCode = :comCode   ");
        StringBuilder sqlT = new StringBuilder(" select p from PrpDcustomerUnit p where  p.comCode = :comCode   ");
        Map<String, Object> map = new HashMap<>();
        map.put("comCode", requestDto.getComCode());

        List<PrpDcustomerIdv> idvList = new ArrayList<>();
        List<PrpDcustomerUnit> unitList = new ArrayList<>();
        //个人客户
        if ("1".equals(requestDto.getCustomerType())) {
            if (requestDto.getRiskLevel() != null && !"0".equals(requestDto.getRiskLevel())) {
                sql.append(" AND p.riskLevel = :riskLevel ");
            map.put("riskLevel", requestDto.getRiskLevel());
            sql1 += " and riskLevel='" + requestDto.getRiskLevel() + "' ";
         }
            //Str.convertString()
            //判断前台输入的查询限定符
            if ("*".equals(requestDto.getUserCodeSign())) {
                sql.append(" and p.customerCode like :customerCode ");
                map.put("customerCode", requestDto.getUserCode() + "%");
                sql1 += " and customerCode like '" + requestDto.getUserCode() + "%' ";
            } else if ("=".equals(requestDto.getUserCodeSign())) {
                sql.append(" and p.customerCode = :customerCode ");
                map.put("customerCode", requestDto.getUserCode());
                sql1 += " and customerCode = '" + requestDto.getUserCode() + "' ";
            }
            if ("*".equals(requestDto.getUserNameSign())) {
                sql.append(" and p.customerCName like :customerCName ");
                map.put("customerCName", requestDto.getUserName() + "%");
                sql1 += " and customerCName like '" + requestDto.getUserName() + "%' ";
            } else if ("=".equals(requestDto.getUserNameSign())) {
                sql.append(" and p.customerCName = :customerCName ");
                map.put("customerCName", requestDto.getUserName());
                sql1 += " and customerCName = '" + requestDto.getUserName() + "' ";
            }
            if ("*".equals(requestDto.getPrpDCustomerIdvIdentifyNumberSign())) {
                sql.append(" and p.identifyNumber like :identifyNumber ");
                map.put("identifyNumber", requestDto.getPrpDCustomerIdvIdentifyNumber() + "%");
                sql1 += " and identifyNumber like '" + requestDto.getPrpDCustomerIdvIdentifyNumber() + "%' ";
            } else if ("=".equals(requestDto.getPrpDCustomerIdvIdentifyNumberSign())) {
                sql.append(" and p.identifyNumber = :identifyNumber ");
                map.put("identifyNumber", requestDto.getPrpDCustomerIdvIdentifyNumber());
                sql1 += " and identifyNumber = '" + requestDto.getPrpDCustomerIdvIdentifyNumber() + "' ";
            }
            Query dataQuery = entityManager.createQuery(sql.toString());
            Query dataQuery1 = entityManager.createNativeQuery(sql1);
            System.err.println(sql.toString());
            //this.setQueryParam(dataQuery,map);
            this.setQueryParam(dataQuery, pageNum, pageSize, map);
            //this.setQueryParam(dataQuery1,map);
            //获取结果集
            idvList = dataQuery.getResultList();
            //获取总记录数
            Object obj = dataQuery1.getSingleResult();
            pageCount = Integer.parseInt(obj.toString());
        }
        //集体客户
        if ("2".equals(requestDto.getCustomerType())) {
            if (requestDto.getRiskLevel() != null && !"0".equals(requestDto.getRiskLevel())) {
                sqlT.append(" AND p.riskLevel = :riskLevel ");
                map.put("riskLevel", requestDto.getRiskLevel());
                sqlT1 += " and riskLevel='" + requestDto.getRiskLevel() + "' ";
            }
            //Str.convertString()
            //判断前台输入的查询限定符
            if ("*".equals(requestDto.getUserCodeSign())) {
                sqlT.append(" and p.customerCode like :customerCode ");
                map.put("customerCode", requestDto.getUserCode() + "%");
                sqlT1 += " and customerCode like '" + requestDto.getUserCode() + "%' ";
            } else if ("=".equals(requestDto.getUserCodeSign())) {
                sqlT.append(" and p.customerCode = :customerCode ");
                map.put("customerCode", requestDto.getUserCode());
                sqlT1 += " and customerCode = '" + requestDto.getUserCode() + "' ";
            }
            if ("*".equals(requestDto.getUserNameSign())) {
                sqlT.append(" and p.customerCName like :customerCName ");
                map.put("customerCName", requestDto.getUserName() + "%");
                sqlT1 += " and customerCName like '" + requestDto.getUserName() + "%' ";
            } else if ("=".equals(requestDto.getUserNameSign())) {
                sqlT.append(" and p.customerCName = :customerCName ");
                map.put("customerCName", requestDto.getUserName());
                sqlT1 += " and customerCName = '" + requestDto.getUserName() + "' ";
            }
            if ("*".equals(requestDto.getPrpDCustomerIdvIdentifyNumberSign())) {
                sqlT.append(" and p.organizeCode like :organizeCode ");
                map.put("organizeCode", requestDto.getPrpDCustomerIdvIdentifyNumber() + "%");
                sqlT1 += " and organizeCode like '" + requestDto.getPrpDCustomerIdvIdentifyNumber() + "%' ";
            } else if ("=".equals(requestDto.getPrpDCustomerIdvIdentifyNumberSign())) {
                sqlT.append(" and p.organizeCode = :organizeCode ");
                map.put("organizeCode", requestDto.getPrpDCustomerIdvIdentifyNumber());
                sqlT1 += " and organizeCode = '" + requestDto.getPrpDCustomerIdvIdentifyNumber() + "' ";
            }
            System.err.println(sqlT.toString());
            Query dataQuery = entityManager.createQuery(sqlT.toString());
            Query dataQuery1 = entityManager.createNativeQuery(sqlT1);
            System.err.println(sqlT.toString());
            //this.setQueryParam(dataQuery,map);
            this.setQueryParam(dataQuery, pageNum, pageSize, map);
            //this.setQueryParam(dataQuery1,map);
            //获取结果集
            unitList = dataQuery.getResultList();
            //获取总记录数
            Object obj = dataQuery1.getSingleResult();
            pageCount = Integer.parseInt(obj.toString());
        }
        //总页码数
        if (pageCount > 0) {
            pageCount = (pageCount - 1) / pageSize + 1;
        }
        List<ResponseCustomerRiskLevelDto> responseCustomerRiskLevelDtoList = new ArrayList<>();
        if ("1".equals(requestDto.getCustomerType())) {
            for (PrpDcustomerIdv prpDCustomerIdv : idvList) {
                ResponseCustomerRiskLevelDto responseCustomerRiskLevelDto = new ResponseCustomerRiskLevelDto();
                responseCustomerRiskLevelDto.setAddressCName(prpDCustomerIdv.getAddressCName());
                responseCustomerRiskLevelDto.setCustomerCName(prpDCustomerIdv.getCustomerCName());
                responseCustomerRiskLevelDto.setCustomerCode(prpDCustomerIdv.getCustomerCode());
                responseCustomerRiskLevelDto.setCustomerType(requestDto.getCustomerType());
                responseCustomerRiskLevelDto.setPageCount(pageCount);
                responseCustomerRiskLevelDto.setPageNum(pageNum);
                responseCustomerRiskLevelDto.setRiskLevel(prpDCustomerIdv.getRiskLevel());
                responseCustomerRiskLevelDto.setValidStatus(prpDCustomerIdv.getValidStatus());
                responseCustomerRiskLevelDtoList.add(responseCustomerRiskLevelDto);
            }
        } else if ("2".equals(requestDto.getCustomerType())) {
            for (PrpDcustomerUnit prpDCustomerUnit : unitList) {
                ResponseCustomerRiskLevelDto responseCustomerRiskLevelDto = new ResponseCustomerRiskLevelDto();
                responseCustomerRiskLevelDto.setAddressCName(prpDCustomerUnit.getAddressCName());
                responseCustomerRiskLevelDto.setCustomerCName(prpDCustomerUnit.getCustomerCName());
                responseCustomerRiskLevelDto.setCustomerCode(prpDCustomerUnit.getCustomerCode());
                responseCustomerRiskLevelDto.setCustomerType(requestDto.getCustomerType());
                responseCustomerRiskLevelDto.setPageCount(pageCount);
                responseCustomerRiskLevelDto.setPageNum(pageNum);
                responseCustomerRiskLevelDto.setRiskLevel(prpDCustomerUnit.getRiskLevel());
                responseCustomerRiskLevelDto.setValidStatus(prpDCustomerUnit.getValidStatus());
                responseCustomerRiskLevelDtoList.add(responseCustomerRiskLevelDto);
            }
        }
        return responseCustomerRiskLevelDtoList;
    }

    /**
     * （根据条件查询客户信息列表信息）
     * @author: 赵鹏
     * @date: 2017/12/16 14:32
     * @param requestDto (查询的对象参数)
     * @return public List<ResponseCustomerRiskLevelDto>（客户信息列表信息）
     * @throws Exception
     */
    @Override
    public List<ResponseCustomerRiskLevelDto> queryAllUnitAndIdv(RequestUnitAndldvDto requestDto) throws Exception {
        //获取得到的参数
        int pageNo = requestDto.getPageNum();
         int pageSize = requestDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
          throw new DataVerifyException("每页数量不能小于1");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuilder ldvSql = new StringBuilder("SELECT p FROM PrpDcustomerIdv p ");
        StringBuilder ldvCount = new StringBuilder("SELECT COUNT(1) FROM PrpDcustomerIdv p");

        StringBuilder unitlSql = new StringBuilder("SELECT p FROM PrpDcustomerUnit p ");
        StringBuilder unitlCount = new StringBuilder("SELECT COUNT(1) FROM PrpDcustomerUnit p");
        //判断参数是否为空，不为空则追加sql
        List<String> strWhere = new ArrayList<String>();

        //Str.convertString()
        //判断前台输入的查询限定符
        if (StringUtils.isNotEmpty(requestDto.getCustomerCode())) {
            strWhere.add(" AND p.customerCode=:customerCode ");
            map.put("customerCode",requestDto.getCustomerCode());
        }
        //客户姓名
        if (StringUtils.isNotEmpty(requestDto.getCustomerCName())) {
            strWhere.add(" AND p.customerCName like :customerCName ");
            map.put("customerCName","%"+requestDto.getCustomerCName()+"%");
        }
        //身份证号
        if (StringUtils.isNotEmpty(requestDto.getPrpDCustomerIdvIdentifyNumber())) {
            strWhere.add(" AND p.identifyNumber=:identifyNumber ");
            map.put("identifyNumber", requestDto.getPrpDCustomerIdvIdentifyNumber());
        }
        //证件类型
        if (StringUtils.isNotEmpty(requestDto.getIdentifyType())) {
            strWhere.add(" AND p.identifyType=:identifyType ");
            map.put("identifyType", requestDto.getIdentifyType());
        }
        //如果有拼接条件
        if (strWhere.size() > 0) {
            //自动拼接条件sql语句
            String dataCondition = this.joinCondition(strWhere);

            //增加分页查询语句的查询条件个体
            ldvSql.append(" where "); //where 根据实际情况是否需要在这里添加
            ldvSql.append(dataCondition);
            //增加统计总页数据语句
            ldvCount.append(" where "); //where 根据实际情况是否需要在这里添加
            ldvCount.append(dataCondition);

            //增加分页查询语句的查询条件团体
            unitlSql.append(" where "); //where 根据实际情况是否需要在这里添加
            unitlSql.append(dataCondition);

            //增加统计总页数据语句
            unitlCount.append(" where "); //where 根据实际情况是否需要在这里添加
            unitlCount.append(dataCondition);
        }
        List<ResponseCustomerRiskLevelDto> responseCustomerRiskLevelDtoList = new ArrayList<>();
        if ("1".equals(requestDto.getCustomerType())) {
            //执行sql
            Query dataQuery = entityManager.createQuery(ldvSql.toString());
            Query countQuery = entityManager.createQuery(ldvCount.toString());
            this.setQueryParam(dataQuery, pageNo, pageSize, map);
            this.setQueryParam(countQuery,map);
            //查询结果
            List<PrpDcustomerIdv> dataList = dataQuery.getResultList();

            //查询总条数
            Long pageCount = Long.valueOf(countQuery.getSingleResult().toString());
            if (pageCount > 0) {
                pageCount = (pageCount - 1) / pageSize + 1;
            }
            for (PrpDcustomerIdv prpDCustomerIdv : dataList) {
                ResponseCustomerRiskLevelDto responseCustomerRiskLevelDto = new ResponseCustomerRiskLevelDto();
                responseCustomerRiskLevelDto.setAddressCName(prpDCustomerIdv.getAddressCName());
                responseCustomerRiskLevelDto.setCustomerCName(prpDCustomerIdv.getCustomerCName());
                responseCustomerRiskLevelDto.setCustomerCode(prpDCustomerIdv.getCustomerCode());
                responseCustomerRiskLevelDto.setCustomerType(requestDto.getCustomerType());
                responseCustomerRiskLevelDto.setPageCount((pageCount.intValue()));
                responseCustomerRiskLevelDto.setPageNum(pageNo);
                responseCustomerRiskLevelDto.setRiskLevel(prpDCustomerIdv.getRiskLevel());
                responseCustomerRiskLevelDto.setValidStatus(prpDCustomerIdv.getValidStatus());
                responseCustomerRiskLevelDtoList.add(responseCustomerRiskLevelDto);
            }
        }
        if ("2".equals(requestDto.getCustomerType())) {
            //执行sql
            //执行sql
            Query dataQuery = entityManager.createQuery(unitlSql.toString());
            Query countQuery = entityManager.createQuery(unitlCount.toString());
            this.setQueryParam(dataQuery, pageNo, pageSize, map);
            this.setQueryParam(countQuery,map);
            //查询结果
            List<PrpDcustomerUnit> unitList = dataQuery.getResultList();
            //查询总条数
            Long pageCount = Long.valueOf(countQuery.getSingleResult().toString());
            if (pageCount > 0) {
                pageCount = (pageCount - 1) / pageSize + 1;
            }
            for (PrpDcustomerUnit prpDCustomerUnit : unitList) {
                ResponseCustomerRiskLevelDto responseCustomerRiskLevelDto = new ResponseCustomerRiskLevelDto();
                responseCustomerRiskLevelDto.setAddressCName(prpDCustomerUnit.getAddressCName());
                responseCustomerRiskLevelDto.setCustomerCName(prpDCustomerUnit.getCustomerCName());
                responseCustomerRiskLevelDto.setCustomerCode(prpDCustomerUnit.getCustomerCode());
                responseCustomerRiskLevelDto.setCustomerType(requestDto.getCustomerType());
                responseCustomerRiskLevelDto.setPageCount(pageCount.intValue());
                responseCustomerRiskLevelDto.setPageNum(pageNo);
                responseCustomerRiskLevelDto.setRiskLevel(prpDCustomerUnit.getRiskLevel());
                responseCustomerRiskLevelDto.setValidStatus(prpDCustomerUnit.getValidStatus());
                responseCustomerRiskLevelDtoList.add(responseCustomerRiskLevelDto);
            }
        }
        return responseCustomerRiskLevelDtoList;
    }
    /**
     * （保存客户信息）
     * @author: 赵鹏
     * @date: 2017/12/16 14:34
     * @param requestSaveDto(要保存或更新的对象参数)
     * @return  Map<String,String > （返回操作码1-成功，2-失败，和操作信息）
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,String > saveByCustomerRiskLevel(PrpDcustomerIdvAndUnitDto requestSaveDto) throws Exception {
        Date date = new Date();
        Map<String,String> codeInfo=new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);
        try {
            //更新客户主表
                PrpDcustomer prpDCustomer=new PrpDcustomer();
                prpDCustomer.setCustomerCode(requestSaveDto.getCustomerCode());
                prpDCustomer.setCustomerCName(requestSaveDto.getCustomerCName());
                prpDCustomer.setAddressCName(requestSaveDto.getAddressCName());
                //prpDCustomer.setOrganizeCode(requestSaveDto.getIdentifyType());//
                prpDCustomer.setCustomerType(requestSaveDto.getCustomerKind());//客户类型
                prpDCustomer.setInputDate(requestSaveDto.getInputDate());//输入时间
                prpDCustomer.setValidStatus(requestSaveDto.getValidStatus());//状态
                prpDCustomer.setOperatorCode(requestSaveDto.getOperatorCode());//操作者代码
                prpDCustomer.setOrganizeCode(requestSaveDto.getIdentifyNumber());//身份证号码
                prpDCustomer.setUpdate_Date(sdf.parse(currentDate));//更新时间
                prpDCustomerDao.save(prpDCustomer);
            //个人客户信息保存
            if ("1".equals(requestSaveDto.getCustomerKind())) {
                    PrpDcustomerIdv prpDCustomerIdv =new PrpDcustomerIdv ();
                    prpDCustomerIdv.setCustomerCode(requestSaveDto.getCustomerCode());//客户代码1
                    prpDCustomerIdv.setAddressCName(requestSaveDto.getAddressCName());//客户地址1
                    prpDCustomerIdv.setPostCode(requestSaveDto.getPostCode());//邮编1
                    prpDCustomerIdv.setIdentifyNumber(requestSaveDto.getIdentifyNumber());//证件号码1
                    prpDCustomerIdv.setLinkAddress(requestSaveDto.getLinkAddress());//通讯地址1
                    prpDCustomerIdv.setCustomerCName(requestSaveDto.getCustomerCName());//客户名称1
                    prpDCustomerIdv.setCustomerKind(requestSaveDto.getCustomerKind());//客户类型1
                    prpDCustomerIdv.setValidStatus(requestSaveDto.getValidStatus());//状态1
                    prpDCustomerIdv.setIdentifyType(requestSaveDto.getIdentifyType());//证件类型1
                    prpDCustomerIdv.setRiskLevel(requestSaveDto.getRiskLevel());//风险等级1
                    prpDCustomerIdv.setUpdateDate(sdf.parse(currentDate));//修改时间1
                    prpDCustomerIdv.setSex(requestSaveDto.getSex());//性别1
                    prpDCustomerIdv.setValidPeriod3(requestSaveDto.getValidPeriod3());//证件有效期限1
                    prpDCustomerIdv.setNationality(requestSaveDto.getNationality());//国籍1
                    prpDCustomerIdv.setCashFocus(requestSaveDto.getCashFocus());//行业现金密集程度1
                    prpDCustomerIdv.setJobTitle(requestSaveDto.getJobTitle());//职业名称1
                    prpDCustomerIdv.setIsCareClaim(requestSaveDto.getIsCareClaim());//是否关注理赔审计退保等信息1
                    prpDCustomerIdv.setUpdaterCode(requestSaveDto.getUpdaterCode());//最后一次更新人1
                    prpDCustomerIdv.setOperatorCode(requestSaveDto.getOperatorCode());//操作者代码1
                    prpDCustomerIdv.setNewCustomerCode(requestSaveDto.getCustomerCode());//客户新代码1
                   prpDCustomerIdv.setComCode(requestSaveDto.getComCode());//归属机构代码1
                   prpDCustomerIdv.setInputDate(requestSaveDto.getInputDate());//输入日期1
                    prpDcustomerIdvDao.save(prpDCustomerIdv);
                  }else if ("2".equals(requestSaveDto.getCustomerKind())) { //单位客户信息保存
                    PrpDcustomerUnit prpDCustomerUnit=new PrpDcustomerUnit();
                    prpDCustomerUnit.setCustomerCode(requestSaveDto.getCustomerCode());//客户代码
                    prpDCustomerUnit.setCustomerKind(requestSaveDto.getCustomerKind());//客户类型
                    prpDCustomerUnit.setAddressCName(requestSaveDto.getAddressCName());//客户地址
                    prpDCustomerUnit.setPostCode(requestSaveDto.getPostCode());//邮编
                    prpDCustomerUnit.setCustomerCName(requestSaveDto.getCustomerCName());//客户名称
                    prpDCustomerUnit.setNewCustomerCode(requestSaveDto.getCustomerCode());//客户新代码
                    prpDCustomerUnit.setValidStatus(requestSaveDto.getValidStatus());//状态
                    prpDCustomerUnit.setRiskLevel(requestSaveDto.getRiskLevel());//风险等级
                    prpDCustomerUnit.setOperatorCode(requestSaveDto.getOperatorCode());//操作者代码
                    prpDCustomerUnit.setInputDate(requestSaveDto.getInputDate());//输入日期
                    prpDCustomerUnit.setUpdaterCode(requestSaveDto.getUpdaterCode());//修改人代码
                    prpDCustomerUnit.setUpdateDate(sdf.parse(currentDate));//修改日期
                    prpDCustomerUnit.setComCode(requestSaveDto.getComCode());//归属机构代码
                    prpDCustomerUnit.setPostAddress(requestSaveDto.getLinkAddress());//通讯地址
                    prpDCustomerUnit.setCustomerShortName(requestSaveDto.getCustomerCName());//客户简称
                    prpDCustomerUnit.setPhoneNumber(requestSaveDto.getPhoneNumber());//电话
                    prpDCustomerUnit.setIsCareClaim(requestSaveDto.getIsCareClaim());//客户是否关注审计、理赔、退保信息
                    prpDCustomerUnit.setCashFocus(requestSaveDto.getCashFocus());//行业现金密度
                    prpDCustomerUnit.setOtherCodeNo(requestSaveDto.getOtherCodeNo());//其他证件号码
                    prpDCustomerUnit.setIdentifyType(requestSaveDto.getIdentifyType());//证件类型
                    prpDCustomerUnit.setIdentifyValidPeriod(requestSaveDto.getValidPeriod3());//证件有效期
                    prpDCustomerUnit.setOtherCodeValidPeriod(requestSaveDto.getOtherCodeValidPeriod());//其他证件有效期
                    prpDCustomerUnit.setBusinessLicenceNo(requestSaveDto.getBusinessLicenceNo());//营业执照
                    prpDCustomerUnit.setRevenuePeriod(requestSaveDto.getRevenuePeriod());//税务登记有效期
                    prpDCustomerUnit.setBusinessLicenceValidPeriod(requestSaveDto.getBusinessLicenceValidPeriod());//营业执照到期
                    prpDCustomerUnit.setRevenueCode(requestSaveDto.getRevenueCode());//企业税务代码
                    prpDCustomerUnit.setComType(requestSaveDto.getComType());//公司性质
                    prpDCustomerUnit.setOrganizeCode(requestSaveDto.getOrganizeCode());
                    prpDCustomerUnitDao.save(prpDCustomerUnit);
                }
                //客户风险等级轨迹表更新
                PrpDcustomLevelTrace prpDCustomLevel= new PrpDcustomLevelTrace();
                int maxLineNo =1;
                String strOldRiskLevel = "";
                PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = prpDcustomLevelTraceApi.findRiskLevelByCustomerCode(requestSaveDto.getCustomerCode());
                if(prpDcustomLevelTraceDto!=null){
                    if(prpDcustomLevelTraceDto.getNewRiskLevel()!=null){
                        strOldRiskLevel = prpDcustomLevelTraceDto.getNewRiskLevel();
                        prpDCustomLevel.setOldRiskLevel(strOldRiskLevel);
                    }
                    maxLineNo = prpDcustomLevelTraceDto.getLineNo()+1;
                }

                prpDCustomLevel.setCustomerCode(requestSaveDto.getCustomerCode());
                prpDCustomLevel.setNewRiskLevel(requestSaveDto.getRiskLevel());
                prpDCustomLevel.setOperateCode(requestSaveDto.getOperatorCode());
                prpDCustomLevel.setLineNo(maxLineNo);
                prpDCustomLevel.setOperateDate(sdf.parse(currentDate));
                prpDCustomLevelTraceDao.save(prpDCustomLevel);
            //更新成功
            codeInfo.put("message","success");
        } catch (Exception e) {
            //失败
            codeInfo.put("message","failed");
            e.printStackTrace();
        } finally {
        }
        return codeInfo;
    }

    /**
     * 根据证件类型和证件号去基础表中查询是否有该大户的信息
     * @param identifyType
     * @param identifyNumber
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @Override
    public List<PrpDcustomerIdvDto> queryPrpDcustomerByIndentity(String identifyType, String identifyNumber) throws Exception {
        List<PrpDcustomerIdv> prpDcustomerIdvList=prpDcustomerIdvDao.queryByIndentity(identifyType,identifyNumber);
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList=new ArrayList<>();
        convertCollection(prpDcustomerIdvList,prpDcustomerIdvDtoList,PrpDcustomerIdvDto.class);
        return prpDcustomerIdvDtoList;
    }


}