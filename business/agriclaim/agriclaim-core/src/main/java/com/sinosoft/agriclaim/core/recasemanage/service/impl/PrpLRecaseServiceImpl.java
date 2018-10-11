package com.sinosoft.agriclaim.core.recasemanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.prepaymanage.PrpLPrepayApi;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimKey;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateKey;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.recasemanage.dao.PrpLRecaseDao;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecaseKey;
import com.sinosoft.agriclaim.core.recasemanage.service.PrpLRecaseService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.*;
import com.sinosoft.agriclaim.core.workflowmanage.entity.*;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * @description 重开赔案表Core接口实现
 */
@Service
public class PrpLRecaseServiceImpl extends BaseCustomServiceImpl implements PrpLRecaseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRecaseServiceImpl.class);
    
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpLRecaseDao prpLRecaseDao;
    @Autowired
    private SwfLogStoreDao swfLogStoreDao;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private SwfFlowMainDao swfFlowMainDao;
    @Autowired
    private SwfNodeDao swfNodeDao;
    @Autowired
    private SwfPathLogDao swfPathLogDao;
    @Autowired
    private PrpLClaimDao prpLClaimDao;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Autowired
    private UserApi userApi;
    @Autowired
    private PrpLPrepayApi prpLPrepayApi;
    @Autowired
    private PrpLPrepayDao prpLPrepayDao;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRecaseDto prpLRecaseDto) {
        PrpLRecase prpLRecase = this.convert(prpLRecaseDto, PrpLRecase.class);
        prpLRecaseDao.save(prpLRecase);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,java.lang.Integer serialNo) {
        PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey(claimNo,serialNo);
        prpLRecaseDao.delete(prpLRecaseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRecaseDto prpLRecaseDto) {
        PrpLRecase prpLRecase = this.convert(prpLRecaseDto, PrpLRecase.class);
        prpLRecaseDao.save(prpLRecase);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRecaseDto queryByPK(String claimNo,java.lang.Integer serialNo) {
        PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey(claimNo,serialNo);
        PrpLRecase prpLRecase = prpLRecaseDao.findOne(prpLRecaseKey);
        return this.convert(prpLRecase,PrpLRecaseDto.class);
    }

    /**
     * @description 重开赔案列表查询
     * @author: 王志文
     * @date: 2017/11/3 15:28
     * @param reCaseDto 重开赔案查询页面输入框信息
     * @return 重开赔案查询列表信息 List集合
     */
    @Override
    public PageInfo queryBySql(ReCaseDto reCaseDto) throws Exception {
        int pageSize = reCaseDto.getPageSize();
        //定义条件参数集合
        Map<String, Object> paraMap = new HashMap<>();
        List<String> conditionList = new ArrayList<>();
        String dataCondition;
        if (StringUtils.isNotEmpty(reCaseDto.getRegistNo())){
            conditionList.add(" and x.registNo like :registNo ");
            paraMap.put("registNo","%"+reCaseDto.getRegistNo()+"%");
        }//如果输入为空，则不计入sql中
        if (StringUtils.isNotEmpty(reCaseDto.getPolicyNo())){
            conditionList.add(" and x.policyNo like :policyNo ");
            paraMap.put("policyNo","%"+reCaseDto.getPolicyNo()+"%");
        }
        if (StringUtils.isNotEmpty(reCaseDto.getClaimNo())){
            List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryAllByClaimNo(reCaseDto.getClaimNo());
            List<PrpLPrepay> prpLPrepayList = prpLPrepayDao.queryAllByClaimNo(reCaseDto.getClaimNo());
            if (prpLCompensateList.size()>0){
                String compensateNos = " (";
                for(PrpLCompensate prpLCompensate : prpLCompensateList){
                    compensateNos += "'"+prpLCompensate.getCompensateNo()+"',";
                    if (prpLPrepayList.size()>0){
                        for (PrpLPrepay prpLPrepay : prpLPrepayList){
                            compensateNos += "'"+prpLPrepay.getPreCompensateNo()+"',";
                        }
                    }
                }
                compensateNos += " '1') ";
                conditionList.add(" and x.businessNo in "+compensateNos);
            }
        }
        if (StringUtils.isNotEmpty(reCaseDto.getInsuredName())){
            conditionList.add(" and x.insuredName like :insuredName ");
            paraMap.put("insuredName","%"+reCaseDto.getInsuredName()+"%");
        }
        //案件状态 审核通过: 1; 审核回退: 3;  所有案件为null则不进入此判断
        if (StringUtils.isNotEmpty(reCaseDto.getUndwrtFlag())){
            conditionList.add(" and x.businessNo in ( select pl.compensateNo from PrpLRecase pl where pl.undwrtFlag =:undwrtFlag) ");
            paraMap.put("undwrtFlag",reCaseDto.getUndwrtFlag());
        }
        //流入时间可全部为空  分三种情况
        if (StringUtils.isEmpty(reCaseDto.getFlowInTimeDown()) || StringUtils.isEmpty(reCaseDto.getFlowInTimeUp())){
            Date date = new Date();
            String currentTime = simpleDateFormat.format(date);
            if (StringUtils.isEmpty(reCaseDto.getFlowInTimeDown()) && StringUtils.isNotEmpty(reCaseDto.getFlowInTimeUp())){
                throw new BusinessException("请输入流入时间起期！");
            }else if (StringUtils.isNotEmpty(reCaseDto.getFlowInTimeDown()) && StringUtils.isEmpty(reCaseDto.getFlowInTimeUp())){
                conditionList.add(" and x.flowInTime between '"+reCaseDto.getFlowInTimeDown()+" 00:00:00' and '"+currentTime+"23:59:59' ");
            }
        }else if (StringUtils.isNotEmpty(reCaseDto.getFlowInTimeDown()) && StringUtils.isNotEmpty(reCaseDto.getFlowInTimeUp())){
            conditionList.add(" and x.flowInTime between '"+reCaseDto.getFlowInTimeDown()+" 00:00:00' and '"+reCaseDto.getFlowInTimeUp()+" 23:59:59' ");
        }
        //险种大类为 养殖险 和 种植险 全部险种   32%    31%   0
        if (StringUtils.isNotEmpty(reCaseDto.getRiskClaimType())){
            if (reCaseDto.getRiskClaimType() != null && "31".equals(reCaseDto.getRiskClaimType())) {
                conditionList.add(" and x.riskCode like '31%' ");
            }else if (reCaseDto.getRiskClaimType() != null && "32".equals(reCaseDto.getRiskClaimType())){
                conditionList.add(" and x.riskCode like '32%' ");
            }
        }
        StringBuilder Sql;
        StringBuilder countSql;
        //原生sql
        //如果转储表没有当前工作流信息则从swfLog表取
        Sql = new StringBuilder(
                "select distinct x.registNo,  " +
                        "                x.policyNo,  " +
                        "                x.businessNo,  " +
                        "                x.riskCode,  " +
                        "                x.flowInTime,  " +
                        "                x.insuredName,  " +
                        "                x.handlerName,  " +
                        "                x.nodeType "+
                        "  from (select * from swflog t " +
                        " where ((t.nodetype = 'endca' " +
                        "   and t.nodestatus = '4' " +
                        "   and not exists (select * " +
                        "          from swfpathlog t1 " +
                        "         where t.flowid = t1.flowid " +
                        "           and t1.startnodeno = t.logno " +
                        "           and t1.endnodename = '重开赔案')  " +
                        "           ) or (t.nodetype = 'rcase' )) " +
                        "         union all  select * " +
                        "  from swflogstore t " +
                        " where ((t.nodetype = 'endca' " +
                        "   and t.nodestatus = '4' " +
                        "   and not exists (select * " +
                        "          from swfpathlog t1 " +
                        "         where t.flowid = t1.flowid " +
                        "           and t1.startnodeno = t.logno " +
                        "           and t1.endnodename = '重开赔案')  " +
                        "           ) " +
                        "           or (t.nodetype = 'rcase' ))      " +
                        "            ) x");
        countSql = new StringBuilder(
                " select count(x.registNo) " +
                        "  from (select * from swflog t " +
                        " where ((t.nodetype = 'endca' " +
                        "   and t.nodestatus = '4' " +
                        "   and not exists (select * " +
                        "          from swfpathlog t1 " +
                        "         where t.flowid = t1.flowid " +
                        "           and t1.startnodeno = t.logno " +
                        "           and t1.endnodename = '重开赔案')  " +
                        "           ) or (t.nodetype = 'rcase' )) " +
                        "         union all  select * " +
                        "  from swflogstore t " +
                        " where ((t.nodetype = 'endca' " +
                        "   and t.nodestatus = '4' " +
                        "   and not exists (select * " +
                        "          from swfpathlog t1 " +
                        "         where t.flowid = t1.flowid " +
                        "           and t1.startnodeno = t.logno " +
                        "           and t1.endnodename = '重开赔案')  " +
                        "           ) " +
                        "           or (t.nodetype = 'rcase' ))      " +
                        "            ) x  ");
        if (conditionList.size()>0){
            dataCondition = this.joinCondition(conditionList);
            Sql.append(" where ");
            //拼接查询条件
            Sql.append(dataCondition);

            countSql.append(" where ");
            //获取总页数
            countSql.append(dataCondition);
        }else {
            return new PageInfo();
        }
        PageInfo pageInfo = getRecaseResultList(reCaseDto,Sql.toString(),countSql.toString(),paraMap);
        return pageInfo;
    }
    //列表查询独立调用
    private PageInfo getRecaseResultList(ReCaseDto reCaseDto,String Hql,String countHql,Map<String, Object> paraMap){
        Long totalSizeStrLon;
        PageInfo pageInfo = new PageInfo();
        List<ReCaseViewDto> reCaseViewDtoList = new ArrayList<>();
        Integer pageNo = reCaseDto.getPageNo();
        Integer pageSize = reCaseDto.getPageSize();
        Hql = Hql+" and x.systemFlag = 'agri' order by x.flowInTime desc";
        countHql=countHql+" and x.systemFlag = 'agri'";
        Query query = em.createNativeQuery(Hql.toString());
        Query query1 = em.createNativeQuery(countHql.toString());
        this.setQueryParam(query1,paraMap);
        this.setQueryParam(query,reCaseDto.getPageNo(),reCaseDto.getPageSize(),paraMap);
        for (String key : paraMap.keySet()) {
            query.setParameter(key, paraMap.get(key));
            query1.setParameter(key, paraMap.get(key));
        }
        totalSizeStrLon = new BigInteger(query1.getSingleResult().toString()).longValue();
        if (pageNo != null) {
            query.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            query.setMaxResults(pageSize.intValue());
        }
        //数组接收 转为对象
        List<Object[]> objectList = query.getResultList();
        ReCaseViewDto reCaseViewDto ;
        for (Object [] obj: objectList) {
            reCaseViewDto = new ReCaseViewDto();
            reCaseViewDto.setRegistNo((String)obj[0]);
            reCaseViewDto.setPolicyNo((String)obj[1]);
            PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
            if (((String)obj[2]).startsWith("6")){
                prpLCompensateKey.setCompensateNo((String)obj[2]);
                PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
                reCaseViewDto.setClaimNo(prpLCompensate.getClaimNo());
            }else if (((String)obj[2]).startsWith("8")){
                PrpLPrepayDto prpLPrepayDto = prpLPrepayApi.queryByPK((String)obj[2]);
                reCaseViewDto.setClaimNo(prpLPrepayDto.getClaimNo());
            }else {
                reCaseViewDto.setClaimNo((String)obj[2]);
            }
            String riskCode = (String)obj[3];
            String riskCName = "";
            Map<String,String> map = new HashMap<>();
            map.put("riskCode",riskCode);
            PrpDriskDto prpdRiskDto = prpDriskApi.queryByPK(map);
            if (prpdRiskDto != null){
                riskCName = prpdRiskDto.getRiskCName();
            }
            //通过riskCode转换为riskCName 输出
            reCaseViewDto.setRiskCName(riskCName);
            reCaseViewDto.setInsuredName((String)obj[5]);
            reCaseViewDto.setFlowInTime((String)obj[4]);
            PrpLRecase prpLRecase = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(reCaseViewDto.getClaimNo());
            if (prpLRecase != null && prpLRecase.getUndwrtFlag() != null && "1".equals(prpLRecase.getUndwrtFlag())){
                reCaseViewDto.setCaseType("审核通过");
            }else if (prpLRecase != null && prpLRecase.getUndwrtFlag() != null && "3".equals(prpLRecase.getUndwrtFlag())){
                reCaseViewDto.setCaseType("审核退回");
            }else if (prpLRecase != null && prpLRecase.getUndwrtFlag() != null && "9".equals(prpLRecase.getUndwrtFlag())){
                reCaseViewDto.setCaseType("待审核");
            }else if (prpLRecase == null ){
                reCaseViewDto.setCaseType("已结案");
            }
            if ("endca".equals((String)obj[7])){
                reCaseViewDto.setCaseType("已结案");
            }
            reCaseViewDto.setHandlerName((String)obj[6]);
            reCaseViewDtoList.add(reCaseViewDto);
        }
        pageInfo.setContent(reCaseViewDtoList);
        pageInfo.setPages(reCaseDto.getPageSize());
        pageInfo.setTotalCount(totalSizeStrLon);
        return pageInfo;
    }

    /**
     * （立案号精确查询 实现方法）
     * @author: 王志文
     * @date: 2017/11/3 10:39
     * @param claimNo 立案号
     * @return 页面显示信息，报案号超链接查询后所需信息
     */
    @Override
    public ReCaseViewDto queryReCaseReasonByClaimNo(String claimNo) {
        ReCaseViewDto reCaseViewDto = new ReCaseViewDto();
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(claimNo)){
            return reCaseViewDto;
        }
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        if (prpLClaim != null){
            Map<String,String> map = new HashMap<>();
            map.put("riskCode",prpLClaim.getRiskCode());
            PrpDriskDto prpDriskDto= prpDriskApi.queryByPK(map);
            String riskCName = "";
            if (prpDriskDto!= null){
                riskCName = prpDriskDto.getRiskCName();
            }
            if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(riskCName)){
                reCaseViewDto.setRiskCName(riskCName);
            }
            reCaseViewDto.setClaimNo(prpLClaim.getClaimNo());
            reCaseViewDto.setPolicyNo(prpLClaim.getPolicyNo());
            reCaseViewDto.setRegistNo(prpLClaim.getRegistNo());
        }
        //找到最大serialNo  查询到的是上一条重开赔案记录 如果没有进行过重开赔案则显示为空
        PrpLRecase maxSerialNoPrpByClaimNo = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(claimNo);
        PrpLRecase prpLRecase;
        if (maxSerialNoPrpByClaimNo != null ){
            //通过主键查询找到对应的重开赔案原因
            if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(reCaseViewDto.getClaimNo())){
                PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey();
                prpLRecaseKey.setSerialNo(maxSerialNoPrpByClaimNo.getSerialNo());
                prpLRecaseKey.setClaimNo(maxSerialNoPrpByClaimNo.getClaimNo());
                prpLRecase = prpLRecaseDao.findOne(prpLRecaseKey);
                if (prpLRecase != null){
                    reCaseViewDto.setSerialNo(prpLRecase.getSerialNo());
                    reCaseViewDto.setReCaseReason(prpLRecase.getRecaseReason());
                    reCaseViewDto.setCompensateNo(prpLRecase.getCompensateNo());
                }
            }
        }
        return reCaseViewDto;
    }

    /**
     * （重开赔案申请提交双核实现方法）
     * @author: 王志文
     * @date: 2017/11/3 10:40
     * @param reCaseCommitDto 包含险种名称、立案号、保单号、报案号等基本信息
     * @return 返回提交结果，成功或其他失败信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String> saveReCaseCommittedByReCaseDto(ReCaseCommitDto reCaseCommitDto)throws Exception {
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        String comCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
        //设置默认返回页面信息
        Map<String,String> map = new HashMap<>();
        map.put("message","重开赔案成功提交申请!");
        //判断传入数据是否具有重开赔案资格
        PrpLRecase prpLRecase = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(reCaseCommitDto.getClaimNo());
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(reCaseCommitDto.getClaimNo());
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        if (prpLRecase != null && com.sinosoft.framework.core.utils.StringUtils.isEmpty(prpLRecase.getCloseCaseuserCode())){
            throw new BusinessException("此案件上次重开赔案尚未结案,不能再次重开赔案");
        }
        if (prpLClaim != null && prpLClaim.getEndCaseDate() == null){
            throw new BusinessException("此案件未结案不能重开赔案");
        }
        List<String> flowIds ;
        flowIds= swfLogStoreDao.queryFlowId(reCaseCommitDto.getClaimNo());
        if (flowIds.size()==0){//如果转储表没有就从swfLog表取
            flowIds = swfLogDao.queryFlowId(reCaseCommitDto.getClaimNo());
        }
        String flowId = "";
        if (flowIds.size()!=0){
            flowId = flowIds.get(0);
        }
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(flowId)){//如果取不到flowId
            throw new BusinessException("message","未找到工作流信息，不能重开赔案！");
        }

        SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
        swfFlowMainKey.setFlowId(flowId);
        SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
        SwfFlowMainDto swfFlowMainDto = this.convert(swfFlowMain,SwfFlowMainDto.class);
        int maxLogNo ;//最大logNo值，取max(logNo)+1
        int maxEndCaseLogNo ;
        int compeCount ;
        SwfLogEndCaseDto swfLogEndCaseDto;
        Collection swfList ;
        if (StringUtils.isNotEmpty(swfFlowMainDto.getStoreFlag()) && "1".equals(swfFlowMainDto.getStoreFlag())){
            maxLogNo = swfLogStoreDao.getMaxLogNo(flowId)+1;
            maxEndCaseLogNo = swfLogStoreDao.getEndCaseLogNo(flowId);
            SwfLogStoreKey swfLogStoreKey = new SwfLogStoreKey(flowId,maxEndCaseLogNo);
            SwfLogStore swfLogStore = swfLogStoreDao.findOne(swfLogStoreKey);
            swfLogEndCaseDto = this.convert(swfLogStore,SwfLogEndCaseDto.class);
            swfList = swfLogStoreDao.queryByCondition(flowId,reCaseCommitDto.getClaimNo());
            compeCount = swfLogStoreDao.getCount(flowId,reCaseCommitDto.getClaimNo());
            //未转储的从SwfLog表取
        }else{
            maxLogNo = swfLogDao.getMaxLogNo(flowId);
            maxEndCaseLogNo = swfLogDao.getEndCaseLogNo(flowId);
            SwfLogKey swfLogKey = new SwfLogKey(flowId,maxEndCaseLogNo);
            SwfLog swfLog = swfLogDao.findOne(swfLogKey);
            swfLogEndCaseDto = this.convert(swfLog,SwfLogEndCaseDto.class);
            swfList = swfLogDao.queryByCondition(flowId,reCaseCommitDto.getClaimNo());
            compeCount = swfLogDao.getCount(flowId,reCaseCommitDto.getClaimNo());
        }

        if (swfList==null || swfList.size()==0){
            throw new BusinessException("message","没有发现此立案的理算节点！");
        }
        if (compeCount>0){
            throw new BusinessException("message","此案件的立案已经重开过赔案并未处理完毕，请不要再重开赔案！");
        }
        if(swfLogEndCaseDto == null){
            throw new BusinessException("message","案件未查询到结案的工作流信息，不能重开赔案！");
        }
        if ("0".equals(swfFlowMainDto.getFlowStatus())){
            swfFlowMainDto.setFlowStatus("1");//如果工作流处于关闭状态，则设置为"1"打开工作流
        }
        int modelNo = swfFlowMainDto.getModelNo();
//        Integer nodeNo1 = swfLogEndCaseDto.getNodeNo();
        SwfNodeDto swfNodeDto ;
        if ("2".equals(String.valueOf(swfFlowMainDto.getModelNo()))) {
            swfNodeDto = this.convert(swfNodeDao.queryByCondition(modelNo,15),SwfNodeDto.class) ;
        }else {
            swfNodeDto = this.convert(swfNodeDao.queryByCondition(modelNo,17),SwfNodeDto.class) ;
        }
        if (swfNodeDto == null){
            throw new BusinessException("未查询到该模板号的节点信息，不能重开赔案");
        }
        PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
        int nodeNo = swfNodeDto.getNodeNo();
        SwfLogEndCaseDto nextSwfLogDto = swfLogEndCaseDto;
        nextSwfLogDto.setNodeNo(nodeNo);
        nextSwfLogDto.setNodeName(swfNodeDto.getNodeName());
        nextSwfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
        nextSwfLogDto.setFlowStatus("1");
        nextSwfLogDto.setLogNo(maxLogNo);
        nextSwfLogDto.setNodeStatus("0");
        nextSwfLogDto.setNodeType("rcase");
        nextSwfLogDto.setMainFlowId("0");
        nextSwfLogDto.setPackageId("0");
        nextSwfLogDto.setKeyIn(swfLogEndCaseDto.getBusinessNo());
        nextSwfLogDto.setSubFlowId("0");
        nextSwfLogDto.setRegistNo(swfLogEndCaseDto.getRegistNo());
        nextSwfLogDto.setInsuredName(swfLogEndCaseDto.getInsuredName());
        nextSwfLogDto.setHandleDept(swfLogEndCaseDto.getHandleDept());
        nextSwfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
        String beforeHandlerCode = swfLogEndCaseDto.getBeforeHandlerCode();
        String beforeHandlerName = swfLogEndCaseDto.getHandlerName();
        nextSwfLogDto.setBeforeHandlerCode(beforeHandlerCode);
        nextSwfLogDto.setBeforeHandlerName(beforeHandlerName);
        nextSwfLogDto.setTaskNo(swfNodeDto.getTaskNo());
        nextSwfLogDto.setTaskType(swfNodeDto.getTaskType());
        nextSwfLogDto.setTitleStr("重开赔案");
        nextSwfLogDto.setHandlerCode(userInfo.getUserCode());
        nextSwfLogDto.setHandlerName(userInfo.getUserName());
        nextSwfLogDto.setDeptName(prpDcompanyDto.getComCName());
        nextSwfLogDto.setPosx(0);
        nextSwfLogDto.setPosy(0);
        nextSwfLogDto.setTypeFlag(swfLogEndCaseDto.getTypeFlag());
        /*if(swfLogEndCaseDto.getRiskCode().substring(0,2).equals("05")){
            nextSwfLogDto.setLossItemCode(swfLogEndCaseDto.getLossItemCode());
            nextSwfLogDto.setLossItemName(swfLogEndCaseDto.getLossItemName());
        }*/
        nextSwfLogDto.setEndFlag(swfNodeDto.getEndFlag());
        if (swfFlowMain.getStoreFlag() != null && "1".equals(swfFlowMain.getStoreFlag())){
            //先删再插
            swfLogStoreDao.delete(this.convert(nextSwfLogDto,SwfLogStore.class));
            swfLogStoreDao.save(this.convert(nextSwfLogDto,SwfLogStore.class));//存入转储工作流日志表
        }else {
            //先删再插
            swfLogDao.delete(this.convert(nextSwfLogDto,SwfLog.class));
            swfLogDao.save(this.convert(nextSwfLogDto,SwfLog.class));//存入工作流日志表
        }
        //形成新的理赔线数据
        String pathName = "从 结案 到 重开赔案";
        SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
        swfPathLogDto.setPathNo(swfPathLogDao.findMaxPathNoByFlowId(flowId));
        swfPathLogDto.setFlowId(flowId);
        swfPathLogDto.setStartNodeNo(maxEndCaseLogNo);
        swfPathLogDto.setStartNodeName("结案");
        swfPathLogDto.setEndNodeNo(maxLogNo);
        swfPathLogDto.setEndNodeName("重开赔案");
        swfPathLogDto.setModelNo(modelNo);
        swfPathLogDto.setPathName(pathName);
        //先删再插
        swfPathLogDao.delete(this.convert(swfPathLogDto,SwfPathLog.class));
        swfPathLogDao.save(this.convert(swfPathLogDto,SwfPathLog.class));//存入工作流路径日志表

        //prpLReCase
        PrpLRecaseDto prpLRecaseDto = new PrpLRecaseDto();
        int serialNo ;
        if (prpLRecase != null ){
            prpLRecaseDto = this.convert(prpLRecase,PrpLRecaseDto.class);
            serialNo = prpLRecaseDto.getSerialNo();
            prpLRecaseDto.setClaimNo(reCaseCommitDto.getClaimNo());
            prpLRecaseDto.setSerialNo(serialNo+1);
            prpLRecaseDto.setRecaseReason(reCaseCommitDto.getReCaseReason());
            prpLRecaseDto.setUndwrtFlag("9");
            prpLRecaseDto.setCompensateNo(reCaseCommitDto.getCompensateNo());
            prpLRecaseDto.setOpencaseDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            prpLRecaseDto.setOpencaseuserCode(userCode);
            prpLRecaseDto.setNodeNo(swfNodeDto.getNodeNo());
        }else{
            serialNo = 1;
            prpLRecaseDto.setClaimNo(reCaseCommitDto.getClaimNo());
            prpLRecaseDto.setSerialNo(serialNo);
            prpLRecaseDto.setUndwrtFlag("9");
            prpLRecaseDto.setRecaseReason(reCaseCommitDto.getReCaseReason());
            prpLRecaseDto.setCompensateNo(reCaseCommitDto.getCompensateNo());
            prpLRecaseDto.setOpencaseDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            prpLRecaseDto.setOpencaseuserCode(userCode);
            prpLRecaseDto.setNodeNo(swfNodeDto.getNodeNo());
        }
        //先删再插
        prpLRecaseDao.delete(this.convert(prpLRecaseDto,PrpLRecase.class));
        prpLRecaseDao.save(this.convert(prpLRecaseDto,PrpLRecase.class));//存入重开赔案表

        //workflow操作
        List<SwfPathLogDto> swfPathLogDtoList = new ArrayList<>();
        swfPathLogDtoList.add(swfPathLogDto);
        WorkFlowDto workFlowDto = new WorkFlowDto();
        workFlowDto.setReOpen(true);
        workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
        workFlowDto.setSubmit(true);
        workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
        workFlowService.deal(workFlowDto);

        //发送XML到双核系统
        ReCaseXMLCommitDto reCaseXMLCommitDto = new ReCaseXMLCommitDto();//用xml发送的Dto
        reCaseXMLCommitDto.setlFlowID(nextSwfLogDto.getFlowId());
        reCaseXMLCommitDto.setlLogNo(nextSwfLogDto.getLogNo());
        reCaseXMLCommitDto.setModelType("62");
        reCaseXMLCommitDto.setCertiType("B");
        reCaseXMLCommitDto.setBusinessNo(reCaseCommitDto.getClaimNo());
        reCaseXMLCommitDto.setRiskCode(swfLogEndCaseDto.getRiskCode());
        Map<String,String> map1 = new HashMap<>();
        map1.put("riskCode",swfLogEndCaseDto.getRiskCode());
        PrpDriskDto prpdRiskDto = prpDriskApi.queryByPK(map1);
        if (prpdRiskDto != null){
            if (prpdRiskDto.getClassCode() != null){
                reCaseXMLCommitDto.setClassCode(prpdRiskDto.getClassCode());
            }
        }else {
            reCaseXMLCommitDto.setClassCode("");
        }
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        reCaseXMLCommitDto.setComCode(prpLClaimDto.getComCode());
        reCaseXMLCommitDto.setMakecom(prpLClaimDto.getMakeCom());
        reCaseXMLCommitDto.setUserCode(userCode);
        reCaseXMLCommitDto.setHandlerCode(prpLClaimDto.getHandlerCode());
        reCaseXMLCommitDto.setHandler1Code(prpLClaimDto.getHandler1Code());
        reCaseXMLCommitDto.setContractNo("");
        String requestXml ;
        XmlUtil xmlUtil = new XmlUtil();
        PacketDto<ReCaseXMLCommitDto> packetDto = new PacketDto<>();
        packetDto.setBody(reCaseXMLCommitDto);
        requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
        NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();

        String getXml = newAgriPrpallUndwrtService.reCaseSubmit(requestXml);

        Document document;
        try {
            document = DocumentHelper.parseText(getXml);
        } catch (DocumentException e) {
            throw new BusinessException(e.getMessage());
        }

        Element requestData =document.getRootElement();
        Element flowID = requestData.element("flowId");
        if (StringUtils.isNotEmpty(flowID.getTextTrim())){
            return map;
        }else {
            map.put("message","重开赔案提交失败!");
        }
        return map;
    }

    /**
     * （双核审核重开赔案后调用，将审核状态写入到理赔表中）
     * @author: 王志文
     * @date: 2017/11/17 15:18
     * @param undwrtWriteBackReCaseDto 包含流程编号、序号、业务号、审核结果
     * @return int  返回回写结果信息，大于0 则回写成功
     * @throws Exception 异常信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveCaseTypeByUndwrt(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
        String checkFlag ;
        String claimNo = undwrtWriteBackReCaseDto.getBusinessNo();
        String swfLogFlowID = undwrtWriteBackReCaseDto.getLflowID();
        SwfLogDto swfLogDto ;
        List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryAllByClaimNo(claimNo);
        if (prpLCompensateList.size()>0){
            undwrtWriteBackReCaseDto.setBusinessNo(prpLCompensateList.get(0).getCompensateNo());
        }
        swfLogDto = checkFlowNode(swfLogFlowID, undwrtWriteBackReCaseDto.getLlogNo(), undwrtWriteBackReCaseDto.getBusinessNo());

        checkFlag = swfLogDto.getLogNo().toString();
        if (Integer.parseInt(checkFlag) < 0){
            return checkFlag;
        }
        if (Integer.parseInt(checkFlag) == 0){
            return checkFlag;
        }
        //"PassOldClaimRecase"     审批通过调用
        if ("1".equals(undwrtWriteBackReCaseDto.getUndwrtFlag())) {
            SwfLogDto nextNode = new SwfLogDto();
            nextNode.setNodeStatus("4");
            nextNode.setBusinessNo(swfLogDto.getBusinessNo());
            nextNode.setNodeType("compe");
            nextNode.setNodeNo(17);
            int maxLogNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId());
            swfLogDao.upDateSwfNodeByCondition(swfLogDto.getFlowId(),maxLogNo,nextNode.getNodeStatus(),nextNode.getBusinessNo(),nextNode.getNodeType(),nextNode.getNodeNo());
            int count = prpLRecaseDao.getCountByClaimNo(claimNo);
            PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey();
            prpLRecaseKey.setClaimNo(claimNo);
            prpLRecaseKey.setSerialNo(count);
            PrpLRecaseDto prpLRecaseDto = this.convert(prpLRecaseDao.findOne(prpLRecaseKey),PrpLRecaseDto.class);
            prpLRecaseDto.setFlag("1");
            prpLRecaseDto.setUndwrtFlag(undwrtWriteBackReCaseDto.getUndwrtFlag());
            prpLRecaseDto.setNodeNo(prpLRecaseDto.getNodeNo()+1);
            prpLRecaseDao.upDateByEntity(prpLRecaseDto.getFlag(),
                    prpLRecaseDto.getUndwrtFlag(), prpLRecaseDto.getNodeNo(),
                    prpLRecaseDto.getClaimNo(),prpLRecaseDto.getSerialNo());
            List<SwfLogDto> swfLogDtoList = new ArrayList<>();
            SwfLogKey swfLogKey = new SwfLogKey(swfLogFlowID,maxLogNo);
            SwfLogDto nextSwfLogDto;
            SwfLog nowSwfLog = swfLogDao.findOne(swfLogKey);
            nowSwfLog.setNodeStatus("4");
            nowSwfLog.setHandlerCode(userInfo.getUserCode());
            nowSwfLog.setHandlerName(userInfo.getUserName());
            nextSwfLogDto = this.convert(nowSwfLog,SwfLogDto.class);
            nextSwfLogDto.setNodeNo(8);
            nextSwfLogDto.setLogNo(nowSwfLog.getLogNo()+1);
            nextSwfLogDto.setNodeName("理算");
            nextSwfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
            nextSwfLogDto.setFlowStatus("1");
            nextSwfLogDto.setNodeStatus("0");
            nextSwfLogDto.setNodeType("compe");
            nextSwfLogDto.setMainFlowId("0");
            nextSwfLogDto.setPackageId("0");
            nextSwfLogDto.setHandlerName("");
            nextSwfLogDto.setHandlerCode("");
            nextSwfLogDto.setBusinessNo(claimNo);
            nextSwfLogDto.setKeyIn(claimNo);
            nextSwfLogDto.setKeyOut("");
            nextSwfLogDto.setSubFlowId("0");
            nextSwfLogDto.setRegistNo(nowSwfLog.getRegistNo());
            nextSwfLogDto.setInsuredName(nowSwfLog.getInsuredName());
            nextSwfLogDto.setHandleDept(nowSwfLog.getHandleDept());
            nextSwfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
            nextSwfLogDto.setBeforeHandlerCode(nowSwfLog.getHandlerCode());
            nextSwfLogDto.setBeforeHandlerName(nowSwfLog.getHandlerName());
            nextSwfLogDto.setTaskNo(4);
            nextSwfLogDto.setTaskType("M");
            nextSwfLogDto.setTitleStr("理算节点流入时间："+new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString()+
                                    " 上一节点操作人:"+nowSwfLog.getHandlerName());
            nextSwfLogDto.setDeptName(userInfo.getComCode());
            nextSwfLogDto.setPosx(0);
            nextSwfLogDto.setPosy(0);
            nextSwfLogDto.setTypeFlag(nowSwfLog.getTypeFlag());
            nextSwfLogDto.setEndFlag("0");
            swfLogDtoList.add(this.convert(nextSwfLogDto,SwfLogDto.class));
            SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
            swfFlowMainKey.setFlowId(swfLogFlowID);
            SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
            SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
            swfPathLogDto.setPathNo(swfPathLogDao.getMaxPathNo(swfLogFlowID)+1);
            swfPathLogDto.setFlowId(swfLogFlowID);
            swfPathLogDto.setStartNodeNo(nowSwfLog.getLogNo());
            swfPathLogDto.setStartNodeName("重开赔案");
            swfPathLogDto.setEndNodeNo(nextSwfLogDto.getLogNo());
            swfPathLogDto.setEndNodeName("理算");
            swfPathLogDto.setModelNo(swfFlowMain.getModelNo());
            swfPathLogDto.setPathName("从 重开赔案 到 理算");
            ArrayList swfPathLogDtoList = new ArrayList();
            swfPathLogDtoList.add(swfPathLogDto);
            WorkFlowDto workFlowDto = new WorkFlowDto();
            workFlowDto.setUpdate(true);
            workFlowDto.setUpdateSwfLogDto(this.convert(nowSwfLog,SwfLogDto.class));
            workFlowDto.setSubmit(true);
            workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
            workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
            workFlowService.deal(workFlowDto);
        }else{       //prplrecase  swflog  SwfFlowMain  SwfPathLog 相关表名
            //更新swflog的流状态
            swfLogDao.updateFlowStatusByFlowId(undwrtWriteBackReCaseDto.getLflowID());
            List<Object []> objects = swfLogDao.queryMaxLogNoSwfLogByFlowId(undwrtWriteBackReCaseDto.getBusinessNo());
            Object [] object = objects.get(0);
            SwfLogKey swfLogKey = new SwfLogKey();
            swfLogKey.setFlowId((String)object[0]);
            swfLogKey.setLogNo((int)object[1]);
            SwfLog swfLog = swfLogDao.findOne(swfLogKey);
            swfLog.setNodeName("重开赔案调整审批");
            swfLog.setNodeNo(35);
            swfLogDao.save(swfLog);
            //将swflog中的数据插入swflogstore
            //原生sql
            StringBuilder sql = new StringBuilder(" insert into SwfLogStore " +
                    " select s.* from SwfLog s where  s.flowId = :flowId");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("flowId",undwrtWriteBackReCaseDto.getLflowID());
            query.executeUpdate();
            //删除swflog表中的原有数据
            swfLogDao.deleteByFlowId(undwrtWriteBackReCaseDto.getLflowID());
            //更新流程主表的数据
            swfFlowMainDao.updateMsgByFlowId(undwrtWriteBackReCaseDto.getLflowID());
            PrpLRecase prpLRecase = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(undwrtWriteBackReCaseDto.getBusinessNo());
            //设为审核退回
            prpLRecase.setUndwrtFlag("3");
            prpLRecaseDao.save(prpLRecase);
        }
        return checkFlag;
    }

    /**
     * （双核回写调用，进行检查回写数据是否符合要求）
     * @author: 王志文
     * @date: 2017/11/17 16:11
     * @param flowID 流程编号
     * @param logNo 序号
     * @param businessNo 业务号
     * @return 返回符合要求的工作流对象信息
     * @throws Exception 异常信息
     */
    public SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception{
        SwfLogKey swfLogKey = new SwfLogKey();
        SwfLogDto swfLogDto ;
        swfLogKey.setFlowId(flowID);
        swfLogKey.setLogNo(logNo);
        SwfLogDto swfLogCheckDto = this.convert(swfLogDao.findOne(swfLogKey),SwfLogDto.class);
        if (swfLogCheckDto == null){
            throw new BusinessException("没查询到工作流，有错误");
        }
        if (!com.sinosoft.framework.core.utils.StringUtils.isEmpty(businessNo)){
            if (!businessNo.equals(swfLogCheckDto.getBusinessNo())){
                throw new BusinessException("业务号不是这个工作流上的业务号码");
            }
        }else{
            throw new BusinessException("传入参数有误");
        }
        if ("5".equals(swfLogCheckDto.getNodeStatus())){
            throw new BusinessException("已经回退过了的案件");
        }
        if ("4".equals(swfLogCheckDto.getNodeStatus())){
            throw new BusinessException("已经提交过了的案件");
        }
        //没有问题的返回
        swfLogDto = swfLogCheckDto;
        return swfLogDto;
    }

    /**
     * （重开赔案成功后重新生成理算节点后，在理算时将新的赔款计算书号写入到重开赔案表中）
     * @author: 王志文
     * @date: 2017/11/17 17:04
     * @param compensateNo 计算书号
     * @return 写入结果，成功或失败
     * @throws Exception 异常信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String>  saveCompensateNoByRecase(String compensateNo,String claimNo) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(compensateNo) || com.sinosoft.framework.core.utils.StringUtils.isEmpty(claimNo)){
            throw new DataVerifyException("数据异常或不全，请重试!");
        }
        //设置默认返回数据
        Map<String,String> map = new HashMap<>();
        map.put("message","保存成功！");
        List<Object []> swfLogKeyList = swfLogDao.queryMaxLogNoSwfLogByFlowId(claimNo);
        PrpLRecase prpLRecase = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(claimNo);
        if (swfLogKeyList != null && swfLogKeyList.size()>0 && prpLRecase != null){
            SwfLogKey swfLogKey = new SwfLogKey();
            for (Object [] swfLogKeyArray: swfLogKeyList) {
                swfLogKey.setFlowId((String)swfLogKeyArray[0]);
                swfLogKey.setLogNo((int)swfLogKeyArray[1]);
            }
            SwfLogDto swfLogDto = this.convert(swfLogDao.findOne(swfLogKey),SwfLogDto.class);
            int nodeNo = swfLogDto.getNodeNo();
            PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey();
            prpLRecaseKey.setClaimNo(prpLRecase.getClaimNo());
            prpLRecaseKey.setSerialNo(prpLRecase.getSerialNo());
            PrpLRecaseDto prpLRecaseDto = this.convert(prpLRecaseDao.findOne(prpLRecaseKey),PrpLRecaseDto.class);
            prpLRecaseDto.setNodeNo(nodeNo);
            prpLRecaseDto.setCompensateNo(compensateNo);
            prpLRecaseDao.save(this.convert(prpLRecaseDto,PrpLRecase.class));
        }else {
            map.put("message","当前案件未重开赔案，无需进行此操作");
        }
        return map;
    }

    /**
     *  根据投保单号查询PrpLRecase表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param claimNo 包括claimNo立案号
     * @return prpLRecaseDtoList 返回PrpLRecaseDto的集合
     */
//    @Override
    public List<PrpLRecaseDto> queryByClaimNo(String claimNo) {
        if (StringUtils.isEmpty(claimNo)) {
            throw new DataVerifyException("立案号不能为空");
        }
        List<PrpLRecase> prpLRecaseList = prpLRecaseDao.findByClaimNo(claimNo);
        List<PrpLRecaseDto> prpLRecaseDtoList = new ArrayList<PrpLRecaseDto>();
        this.convertCollection(prpLRecaseList, prpLRecaseDtoList, PrpLRecaseDto.class);
        return prpLRecaseDtoList;
    }

}