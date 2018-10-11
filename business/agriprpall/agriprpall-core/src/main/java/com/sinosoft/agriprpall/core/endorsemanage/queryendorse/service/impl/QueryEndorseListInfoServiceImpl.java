package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.EndorseConstants;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestEndorseListDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ResponseEndorseListDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpDcompany;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryEndorseListInfoService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryEndorseListInfoServiceImpl extends BaseServiceImpl implements QueryEndorseListInfoService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryEndorseListInfoServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PrpDuserApi prpDuserApi;

    @Autowired
    private PrpDcompanyApi prpDcompanyApi;

    @Autowired
    private  UtiGroupApi utiGroupApi;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（prptmian表中的systemflag,用于区分新农险系统与老系统的数据）


    /**
     * 按条件查询批单列表
     * @author: 刘曼曼
     * @date: 2017/11/23 16:16
     * @param requestEndorseListDto 查询批单列表条件Dto
     * @return PageInfo<ResponseEndorseListDto> 批单列表信息
     * @throws Exception
     */
    public PageInfo<ResponseEndorseListDto> queryEndorsListInfo(RequestEndorseListDto requestEndorseListDto) throws Exception{
        //请求参数不为空校验，以及页码校验
        if (requestEndorseListDto == null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        if (requestEndorseListDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (requestEndorseListDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        // 查询数据HQL
        StringBuilder dataHql=new StringBuilder(" SELECT new com.sinosoft.agriprpall.api.endorsemanage.dto.ResponseEndorseListDto(" +
                                                " h.endorseNo "+
                                                ",h.batchNo "+
                                               ",h.policyNo "+
                                               " ,m.appliName " +
                                               " ,m.insuredName " +
                                               ",h.operatorCode " +
                                               " ,m.operateDate " +
                                               " ,h.underwriteFlag " +
                                                ",m.othFlag," +
                                                "m.sumPremium,m.chgPremium,m.sumAmount,m.chgAmount,h.printNo) " +
                                               " FROM PrpPhead h,PrpPmain m "+
                                               " WHERE h.endorseNo = m.endorseNo " +
                                               " AND m.classCode in ('31','32') ");
        // 查询总数量的HQL
        StringBuilder countHql=new StringBuilder(" SELECT COUNT(1) FROM PrpPhead h,PrpPmain m WHERE h.endorseNo = m.endorseNo AND m.classCode in ('31','32') ");
        // 条件hql拼接
        StringBuilder condition=new StringBuilder();
        // 存放条件数据
        Map<String,String> conditions=new HashMap<>();
        // 验证登录机构comCode
        if (!EndorseConstants.HEADQUARTERS.equals(requestEndorseListDto.getPowerSystemCode())) {
            condition.append(" AND h.comCode NOT LIKE '%YL%' ");
        }
        if(StringUtils.isNotEmpty(systemFlag)){
            condition.append(" AND m.systemFlag=:systemFlag ");
            conditions.put("systemFlag", systemFlag);
        }
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto =new AddCodePowerConditionDto(requestEndorseListDto.getUserCode(),requestEndorseListDto.getLoginComCode(),
                requestEndorseListDto.getLoginGradeCodes(),requestEndorseListDto.getTableName(),requestEndorseListDto.getUserCodeFields(),
                requestEndorseListDto.getComCodeFields(), requestEndorseListDto.getRiskCode(), "h", true);
        String codePower=utiGroupApi.addCodePower(addCodePowerConditionDto);
        condition.append(codePower);
        
        //扶贫险种标志验证
        if (StringUtils.isNotEmpty(requestEndorseListDto.getHpFlag())){
            if ("1".equals(requestEndorseListDto.getHpFlag())) {// 团体投保---贫困户
                condition.append(" AND h.policyType in ('H23','I27','Q1','E1') ");
            }else if("2".equals(requestEndorseListDto.getHpFlag())){// 个体投保---规模经营主体
                condition.append(" AND h.policyType in ('H24','I28','Q2','E2') ");
            }
        }
        //出单机构makeCom
        if (StringUtils.isNotEmpty(requestEndorseListDto.getMakeCom())) {
            condition.append(" AND m.makeCom = :makeCom");
            conditions.put("makeCom", requestEndorseListDto.getMakeCom());
        }
        //批单号
        if(StringUtils.isNotEmpty(requestEndorseListDto.getEndorseNo())){
            condition.append(" AND h.endorseNo like :endorseNo ");
            conditions.put("endorseNo",requestEndorseListDto.getEndorseNo()+"%");
        }
        //保单号
        if(StringUtils.isNotEmpty(requestEndorseListDto.getPolicyNo())){
            condition.append(" AND h.policyNo like :policyNo ");
            conditions.put("policyNo",requestEndorseListDto.getPolicyNo()+"%");
        }
        //归属机构
        if(StringUtils.isNotEmpty(requestEndorseListDto.getComCode())){
//            Map<String,String> map = new HashMap<>();  //前端不传名称了，名称转代码的部分注释掉
//            map.put("comCName",requestEndorseListDto.getComCode());
//            List<PrpDcompanyDto> prpDcompanyDtoList=prpDcompanyApi.queryComCode(map);
//            if(prpDcompanyDtoList.size()>0){
                condition.append(" AND h.comCode=:comCode ");
                conditions.put("comCode",requestEndorseListDto.getComCode());
//            }else{
//                condition.append(" AND h.comCode=:comCode ");
//                conditions.put("comCode","");
//            }
        }
        //批改申请人
        if(StringUtils.isNotEmpty(requestEndorseListDto.getAppliName())){
            condition.append(" AND h.appliName  like :appliName ");
            conditions.put("appliName","%" +requestEndorseListDto.getAppliName()+"%");
        }

        //被保险人名称insuredName
        if (StringUtils.isNotEmpty(requestEndorseListDto.getInsuredName())) {
            condition.append(" AND m.insuredName LIKE :insuredName");
            conditions.put("insuredName", "%" + requestEndorseListDto.getInsuredName() + "%");
        }

        //业务员代码
        if(StringUtils.isNotEmpty(requestEndorseListDto.getHandler1Code())){
            condition.append(" AND h.handler1Code=:handler1Code ");
            conditions.put("handler1Code",requestEndorseListDto.getHandler1Code());
        }
        //操作员代码
        if(StringUtils.isNotEmpty(requestEndorseListDto.getOperatorCode())){
            condition.append("AND h.operatorCode=:operatorCode ");
            conditions.put("operatorCode",requestEndorseListDto.getOperatorCode());
        }
        //批改日期
        if(StringUtils.isNotEmpty(requestEndorseListDto.getEndorDateStart())&&StringUtils.isNotEmpty(requestEndorseListDto.getEndorDateEnd())){
            condition.append("AND h.endorDate between to_date(:endorDateStart,'yyyy-MM-dd') and to_date(:endorDateEnd,'yyyy-MM-dd') ");
            conditions.put("endorDateStart",requestEndorseListDto.getEndorDateStart());
            conditions.put("endorDateEnd",requestEndorseListDto.getEndorDateEnd());
        }
        //批改生效日期
        if(StringUtils.isNotEmpty(requestEndorseListDto.getValidDateStart())&&StringUtils.isNotEmpty(requestEndorseListDto.getValidDateEnd())){
            condition.append("AND h.validDate between to_date(:validDateStart,'yyyy-MM-dd') and to_date(:validDateEnd,'yyyy-MM-dd') ");
            conditions.put("validDateStart",requestEndorseListDto.getValidDateStart());
            conditions.put("validDateEnd",requestEndorseListDto.getValidDateEnd());
        }

        //过滤掉低无赔款的批单 add by wangjincheng 20061116
        condition.append(" AND h.endorType NOT IN('DW1','DW2') ");
        //批改类型
        if(StringUtils.isNotEmpty(requestEndorseListDto.getEndorType())){
            condition.append("AND h.endorType=:endorType ");
            conditions.put("endorType",requestEndorseListDto.getEndorType());
        }
        //核批标志
//        if(StringUtils.isNotEmpty(requestEndorseListDto.getUnderwriteFlag())){
//            condition.append("AND h.underwriteFlag=:underwriteFlag ");
//            conditions.put("underwriteFlag",requestEndorseListDto.getUnderwriteFlag());
//        }
        //核保标志underWriteFlag
        if (StringUtils.isNotEmpty(requestEndorseListDto.getUnderwriteFlag())) {
            String underWriteFlag = requestEndorseListDto.getUnderwriteFlag();
            if (!"10".equals(underWriteFlag) && !"11".equals(underWriteFlag) && !"2".equals(underWriteFlag)) {
                if ("0".equals(underWriteFlag)) {
                    condition.append(" AND h.underwriteFlag in('0','8') AND substr(m.othFlag,4,1) <> '2' ");
                } else {
                    condition.append(" AND h.underwriteFlag =:underwriteFlag AND substr(m.othFlag,4,1) <> '2' ");
                    conditions.put("underwriteFlag", underWriteFlag);
                }
            } else if ("10".equals(underWriteFlag)) {//核保退回
                condition.append(" AND h.underwriteFlag='2' AND substr(m.othFlag,3,1) <> '3' AND substr(m.othFlag,4,1) <> '2' ");
            } else if ("11".equals(underWriteFlag)) {//已撤单
                condition.append(" AND substr(m.othFlag,4,1) = '2' ");
            } else if ("2".equals(underWriteFlag)) {//不通过（拒保）
                condition.append(" AND h.underwriteFlag='2' AND substr(m.othFlag,3,1) ='3'  AND substr(m.othFlag,4,1) <> '2' ");
            }
        }

        //政策/商业标识
        if(StringUtils.isNotEmpty(requestEndorseListDto.getBusinessType1())){
            condition.append("AND m.businessType1=:businessType1 ");
            conditions.put("businessType1",requestEndorseListDto.getBusinessType1());
        }
        condition.append(" order by h.endorseNo desc ");
        // 查询总数据量的Hql拼接
        countHql.append(condition);
        // 查询数据hql拼接条件
        dataHql.append(condition);
        Query countQuery = entityManager.createQuery(countHql.toString());
        Query dataQuery = entityManager.createQuery(dataHql.toString());
        // 设置参数
        for (String key:conditions.keySet()) {
            countQuery.setParameter(key,conditions.get(key));
            dataQuery.setParameter(key,conditions.get(key));
        }
        // 查询数据总条数
        long countNum = (long) countQuery.getSingleResult();
        dataQuery.setFirstResult((requestEndorseListDto.getPageNo()-1)*requestEndorseListDto.getPageSize());
        dataQuery.setMaxResults(requestEndorseListDto.getPageSize());
        // 接收查询结果
        List<ResponseEndorseListDto> responseList= dataQuery.getResultList();


        if(responseList.size()>0) {
            //根据操作员代码查询操作员名称
            List<String> list = new ArrayList<String>();
            for(ResponseEndorseListDto responseEndorseListDto : responseList){
               if(StringUtils.isNotEmpty(responseEndorseListDto.getOperatorCode())){
                   list.add(responseEndorseListDto.getOperatorCode());
               }
            }
            //把查询到的操作员名称放到responseList集合中
            if(list!=null&&list.size()>0){
                List<PrpDuserDto> prpDuserDtoList = prpDuserApi.getOperatorCode(list);
                for (int i = 0; i < responseList.size(); i++) {
                    for (PrpDuserDto prpDuserDto:prpDuserDtoList){
                        if(StringUtils.isNotEmpty(responseList.get(i).getOperatorCode())){
                            if(responseList.get(i).getOperatorCode().equals(prpDuserDto.getUserCode())){
                                responseList.get(i).setOperatorName(prpDuserDto.getUserName());
                            }
                        }
                    }
                }
            }

        }
        // 统一封装分页响应dto
        PageInfo<ResponseEndorseListDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(responseList);// 数据存放dto集合
        pageInfo.setPages(requestEndorseListDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }

}
