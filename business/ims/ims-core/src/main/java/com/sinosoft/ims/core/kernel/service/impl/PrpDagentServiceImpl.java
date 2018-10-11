package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.framework.agri.core.constant.QuerySignConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.AgentReqDto;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.kernel.dao.PrpDagentDao;
import com.sinosoft.ims.core.kernel.entity.PrpDagent;
import com.sinosoft.ims.core.kernel.entity.PrpDagentKey;
import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import com.sinosoft.ims.core.kernel.service.PrpDagentService;
import com.sinosoft.ims.core.kernel.service.PrpDuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Description: 中介机构代码表Care接口实现
 * @Author: 宋振振
 * @Date: 10:55 2017/10/10
 */
@Service
@Transactional
public class PrpDagentServiceImpl extends BaseServiceImpl implements PrpDagentService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDagentServiceImpl.class);

    @Autowired
    private PrpDagentDao prpDagentDao;
    @Autowired
    private PrpDuserService prpDuserService;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDagentDto prpDagentDto) {
        PrpDagent prpDagent = this.convert(prpDagentDto, PrpDagent.class);
        prpDagentDao.save(prpDagent);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String agentCode) {
        PrpDagentKey prpDagentKey = new PrpDagentKey(agentCode);
        prpDagentDao.delete(prpDagentKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDagentDto prpDagentDto) {
        PrpDagent prpDagent = this.convert(prpDagentDto, PrpDagent.class);
        prpDagentDao.save(prpDagent);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDagentDto queryByPK(String agentCode) {
        PrpDagentKey prpDagentKey = new PrpDagentKey(agentCode);
        PrpDagent prpDagent = prpDagentDao.findOne(prpDagentKey);
        return this.convert(prpDagent,PrpDagentDto.class);
    }
    /**
     * 根据条件查询代理人/经纪人信息
     * @author: 宋振振
     * @date: 2017/10/10 10:55
     * @param  agentReqDto 代理人/经纪人查询请求参数的Dto
     * @return List<PrpDagentDto> 返回代理人/经纪人信息
     * @throws Exception
     */
    public  List<PrpDagentDto> queryAgentInfo(AgentReqDto agentReqDto, String validStatus) throws Exception{
        if(agentReqDto==null){
            throw new DataVerifyException("入参agentReqDto为null！");
        }
        //获取请求参数
        String agentName=agentReqDto.getAgentName();
        String agentCode=agentReqDto.getAgentCode();
        String codeMethod=agentReqDto.getCodeMethod();
        String codeClass=agentReqDto.getCodeClass();
        String powerUserCode=agentReqDto.getPowerUserCode();
        String comCode=agentReqDto.getComCode();//归属机构代码
        String businessNature=agentReqDto.getBusinessNature();
        DateTime dateTime = new DateTime().current();
        String strDateTimes =(dateTime.toString().substring(0,10));
        PrpDagentDto prpDagentDto=null;
        List<PrpDagentDto> prpDagentDtoList=new ArrayList<>();
        String userflag="";//员工标志[1]:操作员[2]:经办人[3]:业务员
        if(StringUtils.isEmpty(comCode)&&StringUtils.isEmpty(businessNature)){
            throw new DataVerifyException("comCode或businessNature入参不完整！");
        }
        //TODO 原生SQL
        StringBuilder stringBuilder1=new StringBuilder("SELECT * FROM PrpDagent  WHERE validStatus='");
        stringBuilder1.append(validStatus).append("' ");
        if(QuerySignConstant.LIKE.equals(codeMethod)){
            if("codeCode".equals(codeClass))
                stringBuilder1.append(" AND AgentCode like '").append(agentCode).append("' ");
            else
                stringBuilder1.append(" AND AgentName like '").append(agentName).append("' ");
        }else if(QuerySignConstant.EQ.equals(codeMethod)){
            if("codeCode".equals(codeClass))
                stringBuilder1.append(" AND agentCode = '").append(agentCode).append("'");
            else
                stringBuilder1.append(" AND agentName = '").append(agentName).append("'");
        }else {
            throw new DataVerifyException("请输入正确的查询标识！");
        }

        stringBuilder1.append(" AND agentType = '"+ businessNature+"'  AND (handlerCode ='"+ powerUserCode +"' )")
                .append(" AND agentCode in(SELECT agentCode FROM PrpDagreement")
                .append(" WHERE startDate<=TO_DATE('").append(strDateTimes).append("','yyyy-mm-dd')")
                .append(" AND endDate>=TO_DATE('").append(strDateTimes).append("','yyyy-mm-dd') AND validStatus='1') ");
        stringBuilder1.append(" and (date '").append(strDateTimes).append("' between creStartDate and creEndDate or creStartDate is null or creEndDate is null) ORDER BY agentCode");

        Query agentQuery = entityManager.createNativeQuery(stringBuilder1.toString(),PrpDagent.class);
        List<PrpDagent>  agentList=agentQuery.getResultList();
        convertCollection(agentList,prpDagentDtoList,PrpDagentDto.class);
        int intSize=agentList.size();

        //查询员工标志
        PrpDuserDto prpDuserDto=prpDuserService.queryByPK(powerUserCode);
        if(prpDuserDto!=null){
            if(prpDuserDto.getUserFlag().length()>=2){
                userflag=prpDuserDto.getUserFlag().substring(1,2);
            }else{
                userflag="0";
            }
        }else{
            userflag="0";
        }
        //TODO 原生SQL
        if(businessNature.equals("1")&&intSize==0&&userflag.equals("2") ){
            //实际业务员为直销员，当选择个人代理时，必须选择此直销员关联的个人代理，没有关联时或已关联的失效时，均不允许选择。
        }else if(intSize==0){
            StringBuilder strQueryCondition=new StringBuilder("SELECT agentCode,agentName,creStartDate,creEndDate FROM PrpDagent WHERE ValidStatus = '").append(validStatus).append("' ");

            if(QuerySignConstant.LIKE.equals(codeMethod)){// codeMethod--查询方式like或eq
                if("codeCode".equals(codeClass)){//codeClass--codecode或codename 在代码域或姓名域

                    strQueryCondition.append(" AND AgentCode like '").append(agentCode).append("%' AND AgentType = '").append(businessNature).append("'")
                            .append(" AND ( ComCode = '").append(comCode).append("' OR   ComCode IN(select comcode from prpdcompany ")
                            .append(" Start With  comcode = '").append(comCode).append("'  Connect by prior uppercomcode=comcode   and prior comcode!=uppercomcode) AND LowerViewFlag='Y') ");
                }else{

                    strQueryCondition.append(" AND AgentName like '").append(agentName).append("%'  AND AgentType ='").append(businessNature).append("'")
                            .append(" AND (ComCode IN(select comcode from prpdcompany ")
                            .append(" Start With  comcode = '").append(comCode).append("'  Connect by prior uppercomcode=comcode   and prior comcode!=uppercomcode) AND LowerViewFlag='Y' )");
                }
            }else if(QuerySignConstant.EQ.equals(codeMethod)){
                if("codeCode".equals(codeClass)){
                    strQueryCondition.append( " AND AgentCode like '").append(agentCode).append("%' AND AgentType ='").append(businessNature).append("' AND (substr(comCode,0,4)='").append(comCode.substring(0,4)).append("' or (comCode='0000000000' and LowerViewFlag='Y')) ");
                }else{
                    strQueryCondition.append( " AND AgentName like '").append(agentName).append("%' AND AgentType ='").append(businessNature).append("' AND (substr(comCode,0,4)='").append(comCode.substring(0,4)).append("' or (comCode='0000000000' and LowerViewFlag='Y')) ");
                }
            }else {
                throw new DataVerifyException("请输入正确的查询标识！");
            }
            //代理机构的资格证的有效期在当期内
            strQueryCondition.append("  and agentcode in(SELECT agentcode FROM PrpDagreement WHERE StartDate<=TO_DATE('").append(strDateTimes).append("','yyyy-mm-dd') AND EndDate>=TO_DATE('").append(strDateTimes).append("','yyyy-mm-dd') AND ValidStatus='1')")
                .append(" and (date '").append(strDateTimes).append("' between crestartdate and creenddate or crestartdate is null or creenddate is null)  and handlercode is  null   ORDER BY AgentCode");

            Query dataQuery= entityManager.createNativeQuery(strQueryCondition.toString());
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

            List<Object[]> dataList=dataQuery.getResultList();
            if (dataList != null && dataList.size() > 0) {
                for (Object[] obj : dataList) {
                    prpDagentDto=new PrpDagentDto();
                    prpDagentDto.setAgentCode((String)obj[0]);
                    prpDagentDto.setAgentName((String)obj[1]);
                    prpDagentDto.setCreStartDate(format.parse(format.format((Date) obj[2])));
                    prpDagentDto.setCreEndDate(format.parse(format.format((Date) obj[3])));
                    prpDagentDto.setAgreementStartDate(DateUtils.dateToStr((Date) obj[2]));
                    prpDagentDto.setAgreementEndDate(DateUtils.dateToStr((Date) obj[3]));
                    prpDagentDtoList.add(prpDagentDto);
                }
            }
        }

        return prpDagentDtoList;
    }
}