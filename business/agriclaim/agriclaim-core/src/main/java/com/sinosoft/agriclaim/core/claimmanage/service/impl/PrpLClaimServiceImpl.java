package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLLTextApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpCengageDtoExt;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.individuation.dto.UserDto;
import com.sinosoft.agriclaim.api.recasemanage.PrpLRecaseApi;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.workflowmanage.SwfFlowMainApi;
import com.sinosoft.agriclaim.api.workflowmanage.SwfLogApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimKey;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimService;
import com.sinosoft.agriclaim.core.claimmanage.utils.NumberToCN;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCTextDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCText;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensatePageCommonService;
import com.sinosoft.agriclaim.core.endcasemanage.dao.PrpLCaseNoDao;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNo;
import com.sinosoft.agriclaim.core.recasemanage.dao.PrpLRecaseDao;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecaseKey;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.workflowmanage.dao.PrplReturnVisitSwflogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNotionDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotion;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.PrpCengageApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCplanApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案基本信息表Core接口实现
 */
@Lazy
@Service
public class PrpLClaimServiceImpl extends BaseCustomServiceImpl implements PrpLClaimService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimServiceImpl.class);

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PrpLClaimDao prpLClaimDao;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpCitemKindApi prpCItemKindApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private SwfLogStoreDao swfLogStoreDao;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Autowired
    private PrpLLTextApi prpLLTextApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpLCTextDao prpLCTextDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpLRecaseDao prpLRecaseDao;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpCengageApi prpCEngageApi;
    @Autowired
    private PrpCplanApi prpCplanApi;
    @Autowired
    private PrpPheadApi prpPheadApi;
    @Autowired
    private PrpLLTextDao prpLLTextDao;
    @Autowired
    private PrpLCaseNoDao prpLCaseNoDao;
    @Autowired
    private PrpLclaimStatusDao prpLclaimStatusDao;
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    @Autowired
    private PrplReturnVisitSwflogDao prplReturnVisitSwflogDao;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private SwfLogApi swfLogApi;
    @Autowired
    private SwfFlowMainApi swfFlowMainApi;
    @Autowired
    private PrpLCompensateApi prpLCompensateApi;
    @Autowired
    private PrpLClaimApi prpLClaimApi;
    @Autowired
    private SwfNotionDao swfNotionDao;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
    private PrpLRecaseApi prpLRecaseApi;
    @Autowired
    private UserApi userApi;
    @Autowired
    private CompensatePageCommonService compensatePageCommonService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日");

    private SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception {

        //检查工作流是否合法。。
        SwfLogDto swfLogTemp=swfLogApi.queryByPK(flowID, logNo);
        SwfLogDto swfLogDto = new SwfLogDto();
        //没查询到工作流，有错误
        if (swfLogTemp == null) {
            swfLogDto.setLogNo(-1);
            return swfLogDto;
        }
        //业务号不是这个工作流上的业务号码，直接返回false
        if (!swfLogTemp.getBusinessNo().equals(businessNo)) {
            swfLogDto.setLogNo(-2);
            return swfLogDto;
        }
        //已经回退过了
        if (swfLogTemp.getNodeStatus().equals("5")) {
            swfLogDto.setLogNo(-3);
            return swfLogDto;
        }
        //已经提交过了，直接返回ture
        if (swfLogTemp.getNodeStatus().equals("4")&& "endca".equals(swfLogTemp.getNodeType())) {
            swfLogDto.setLogNo(0);
            return swfLogDto;
        }
        swfLogDto = swfLogTemp;
        //没有问题的
        return swfLogDto;
    }

    /**
     * 整理dto
     *
     * @param user UserDto
     * @param flowID String
     * @param logNo int
     * @param nodeStatus String
     * @param nextBusinessNo String
     * @param keyIn String
     * @param keyOut String
     * @param wclose boolean
     * @throws Exception
     * @return WorkFlowDto
     */
    private WorkFlowDto getWorkFlowDto(UserDto user, String flowID, int logNo, String nodeStatus, String businessNo,
                                       String nextBusinessNo, String keyIn, String keyOut, boolean wclose) throws Exception {

        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        SwfLogTransferDto swfLogTransferDto=new SwfLogTransferDto();
        swfLogDtoDealNode.setFlowId(flowID);
        swfLogDtoDealNode.setLogNo(logNo);
        swfLogDtoDealNode.setNodeStatus(nodeStatus);
        swfLogDtoDealNode.setBusinessNo(businessNo);//计算书号码/赔付号码等
        //jiaoyunzhen 无此属性，是否需要添加
        //swfLogDtoDealNode.setNextBusinessNo(nextBusinessNo);
        swfLogDtoDealNode.setKeyIn(keyIn);
        swfLogDtoDealNode.setKeyOut(keyOut);
//	        swfLogDtoDealNode.setRiskCode("2801");
        swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);

        swfLogTransferDto.setUserUserCode(user.getUserCode());
        swfLogTransferDto.setUserUserName(user.getUserName());
        swfLogTransferDto.setUserComCode(user.getComCode());
        swfLogTransferDto.setUserComName(user.getComName());
        swfLogTransferDto.setNextBusinessNo(nextBusinessNo);
        swfLogTransferDto.setCreateFlow(false);
        WorkFlowDto workFlowDto = new WorkFlowDto();
        if (nodeStatus.equals("5")) { //回退
            //查询工作流状态信息,整理输入，用于初始界面显示
            //jiaoyunzhen 元逻辑较多，是否考虑移
            workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
        } else {
            workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
        }
        if (wclose) {
            //关闭操作
            SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
            swfFlowMainDto =  swfFlowMainApi.queryByPK(flowID);
            if (swfFlowMainDto != null) {
                swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
                swfFlowMainDto.setFlowStatus("0");
                //工作流FlowStatus置0，则同时可转储标志置为1
                swfFlowMainDto.setStoreFlag("1");
            }
            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto);
            workFlowDto.setClose(true);
            //设置submit中的swflog为都提交
            if (workFlowDto.isSubmit()) {
                if (workFlowDto.getSubmitSwfLogDtoList() != null) {
                    List<SwfLogDto> nodeList = workFlowDto.getSubmitSwfLogDtoList();
                    ArrayList nodeLastList = new ArrayList();
                    //设置的提交节点都自动结束的
                    for (int i = 0; i < nodeList.size(); i++) {
                        SwfLogDto swfLogDto = (SwfLogDto) nodeList.get(i);
                        swfLogDto.setBusinessNo(nextBusinessNo);
                        swfLogDto.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
                        swfLogDto.setNodeType("endca");
                        //add by jiaoyunzhen
                        String claimNo=prpLCompensateApi.queryByPK(nextBusinessNo).getClaimNo();
                        String endFlag = prpLClaimApi.queryByPK(claimNo).getEndCaseFlag();
                        LOGGER.error("endFlag=========================================="+endFlag);
                        if("1".equals(endFlag)){
                            swfLogDto.setHandlerName("自动结案");
                            swfLogDto.setNodeStatus("4");
                        }else{
                            swfLogDto.setHandlerName("手动结案");
                            swfLogDto.setNodeStatus("0");
                        }
                        nodeLastList.add(swfLogDto);
                    }
                    workFlowDto.setSubmitSwfLogDtoList(nodeLastList);
                }
            }

        }
        if (!workFlowService.checkDealDto(workFlowDto)) {
            return null;
        }
        return workFlowDto;
    }


    /**
     * 追加批办信息
     * @param workFlowDto
     * @param flowID
     * @param logNo
     * @param notion
     * @return
     * @throws Exception
     */
    private WorkFlowDto AddNotionToWorkFlowDto(WorkFlowDto workFlowDto, String flowID, int logNo, String notion)
            throws Exception {
        Specification<SwfNotion> build= Specifications.<SwfNotion>and().eq("flowId", flowID).build();
        List<SwfNotion> otherList=swfNotionDao.findAll(build);
        int maxLineNo = otherList.size();
        SwfNotionDto swfNotionDto = new SwfNotionDto();
        swfNotionDto.setFlowId(flowID);
        swfNotionDto.setLogNo(logNo);
        swfNotionDto.setLineNo(maxLineNo);
        if (notion.length() > 255)
            notion = notion.substring(0, 250) + "...";
        swfNotionDto.setHandleText(notion);
        ArrayList notionList = new ArrayList();
        notionList.add(swfNotionDto);
        workFlowDto.setSwfNotionDtoList(notionList);
        return workFlowDto;
    }

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimDto prpLClaimDto) {
        PrpLClaim prpLClaim = this.convert(prpLClaimDto, PrpLClaim.class);
        prpLClaimDao.save(prpLClaim);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo) {
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey(claimNo);
        prpLClaimDao.delete(prpLClaimKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimDto prpLClaimDto) {
        PrpLClaim prpLClaim = this.convert(prpLClaimDto, PrpLClaim.class);
        prpLClaimDao.save(prpLClaim);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimDto queryByPK(String claimNo) {
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        return this.convert(prpLClaim,PrpLClaimDto.class);
    }

    /**
     * （理赔打印 列表查询接口）
     * @author: 王志文
     * @date: 2017/11/20 17:43
     * @param claimPrintDto 页面输入框输入数据
     * @return 分页数据列表
     */
    @Override
    public PageInfo queryAgriByPrintType(ClaimPrintDto claimPrintDto) throws Exception {
        //判断传入参数是否全部为空 为空则返回空集合
        if (claimPrintDto.getCaseNo() == null && claimPrintDto.getClaimNo() == null &&
                claimPrintDto.getCompensateNo() == null && claimPrintDto.getRegistNo() == null &&
                claimPrintDto.getCaseType() == null && claimPrintDto.getHandleTimeStart() == null &&
                claimPrintDto.getInsuredName() == null && claimPrintDto.getPolicyNo() == null &&
                claimPrintDto.getRiskClaimType() == null && claimPrintDto.getHandleTimeEnd() == null &&
                claimPrintDto.getPrintType() == null ){
            return null;
        }
        String dataCondition;
        Long totalSizeStrLon;
        Integer pageNo = claimPrintDto.getPageNo();
        Integer pageSize = claimPrintDto.getPageSize();
        List<Object> caseTypeRegistNos = new ArrayList<>();//新加判断案件状态
        PageInfo pageInfo = new PageInfo();
        //定义条件参数集合
        Map<String, Object> paraMap = new HashMap<>();
        List<ClaimPrintBackDto> claimPrintBackDtoList = new ArrayList<>();
        //定义查询条件语句
        List<String> conditionList = new ArrayList<>();
        //结案号
        if (StringUtils.isNotEmpty(claimPrintDto.getCaseNo())){
            conditionList.add(" and p.caseNo like:caseNo ");
            paraMap.put("caseNo","%"+claimPrintDto.getCaseNo()+"%");
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getClaimNo())){
            conditionList.add(" and p.claimNo like:claimNo ");
            paraMap.put("claimNo","%"+claimPrintDto.getClaimNo()+"%");
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getCompensateNo())){
            conditionList.add(" and pc.compensateNo like:compensateNo ");
            paraMap.put("compensateNo","%"+claimPrintDto.getCompensateNo()+"%");
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getRegistNo())){
            conditionList.add(" and r.registNo like :registNo");
            paraMap.put("registNo","%"+claimPrintDto.getRegistNo()+"%");
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getCaseType())){
            if ("all".equals(claimPrintDto.getCaseType())){
                conditionList.add(" and (p.caseType in ('0','1','2') or p.caseType is null) ");
            }else if ("2".equals(claimPrintDto.getCaseType())){
                conditionList.add(" and p.caseType is null ");
            }else if ("0".equals(claimPrintDto.getCaseType())){
                conditionList.add(" and p.caseType in ('0','1','2') ");
            }
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getInsuredName())){
            conditionList.add(" and r.insuredName like:insuredName ");
            paraMap.put("insuredName","%"+claimPrintDto.getInsuredName()+"%");
        }
        if (StringUtils.isNotEmpty(claimPrintDto.getPolicyNo())){
            conditionList.add(" and p.policyNo like :policyNo ");
            paraMap.put("policyNo","%"+claimPrintDto.getPolicyNo()+"%");
        }
        //险种大类为 种植险 和 养殖险 全部险种   32%    31%   0
        if (StringUtils.isNotEmpty(claimPrintDto.getRiskClaimType())){
            if (claimPrintDto.getRiskClaimType() != null && "31".equals(claimPrintDto.getRiskClaimType())) {
                conditionList.add(" and r.riskCode like '31%' ");
            }else if (claimPrintDto.getRiskClaimType() != null && "32".equals(claimPrintDto.getRiskClaimType())){
                conditionList.add(" and r.riskCode like '32%' ");
            }
        }
        if (StringUtils.isEmpty(claimPrintDto.getHandleTimeStart()) || StringUtils.isEmpty(claimPrintDto.getHandleTimeEnd())){
            if (StringUtils.isEmpty(claimPrintDto.getHandleTimeStart())&&StringUtils.isNotEmpty(claimPrintDto.getHandleTimeEnd())){
                throw new BusinessException("请输入流入时间起期！");
            }
            if (StringUtils.isEmpty(claimPrintDto.getHandleTimeEnd()) && StringUtils.isNotEmpty(claimPrintDto.getHandleTimeStart())){
                Date date = new Date();
                String currentTime = simpleDateFormat.format(date);
                conditionList.add(" and r.inputDate between to_date('"+claimPrintDto.getHandleTimeStart()+" 00:00:00','yyyy-MM-dd hh24:mi:ss') " +
                        " and to_date('"+currentTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ");
            }
        } else if (StringUtils.isNotEmpty(claimPrintDto.getHandleTimeStart()) && StringUtils.isNotEmpty(claimPrintDto.getHandleTimeEnd())){
            conditionList.add(" and r.inputDate between to_date('"+claimPrintDto.getHandleTimeStart()+" 00:00:00','yyyy-MM-dd hh24:mi:ss') " +
                    " and to_date('"+claimPrintDto.getHandleTimeEnd()+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ");
        }

        // 承接操作时间判断，如果都没有查询条件则返回空
        if (conditionList.size()==0){
            pageInfo.setTotalCount(0);
            pageInfo.setPages(claimPrintDto.getPageSize());
            pageInfo.setContent(claimPrintBackDtoList);
            return pageInfo;
        }
        if (claimPrintDto.getPrintType().contains("EndCase")){
            conditionList.add(" and p.endCaserCode is not null ");
        }
        conditionList.add(" order by r.reportDate desc ");
        //原生sql
        StringBuilder stringBuilder = new StringBuilder("select distinct p.claimNo, p.insuredName,r.reportDate,p.riskCode,p.caseType,pc.compensateNo,r.registNo " +
                " from PrpLClaim p , PrpLRegist r , PrpLCompensate pc " +
                " where r.registNo = p.registNo and pc.claimNo = p.claimNo ");
        StringBuilder countHql = new StringBuilder("select count(distinct pc.compensateNo) " +
                " from PrpLClaim p , PrpLRegist r , PrpLCompensate pc " +
                " where r.registNo = p.registNo and pc.claimNo = p.claimNo ");
        if (conditionList.size()>0){
            dataCondition = this.joinCondition(conditionList);
            stringBuilder.append(" and ");
            stringBuilder.append(dataCondition);
            countHql.append(" and ");
            countHql.append(dataCondition);
        }
        Query query = em.createNativeQuery(stringBuilder.toString());
        Query query1 = em.createNativeQuery(countHql.toString());
        this.setQueryParam(query1,paraMap);
        this.setQueryParam(query,claimPrintDto.getPageNo(),claimPrintDto.getPageSize(),paraMap);
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
        List<Object []> objectList = query.getResultList();
        ClaimPrintBackDto claimPrintBackDto ;
        boolean chooseFlag = true;//保单抄件，查勘报告在报案后就可以打印，此处加标记，跳过立案等查询
        if (objectList.size()==0 && (claimPrintDto.getPrintType().contains("CopyPrint") || claimPrintDto.getPrintType().contains("LocalCheck") || claimPrintDto.getPrintType().contains("Cancel"))){
            chooseFlag = false;
            List<String> copyCondition = new ArrayList<>();
            if (paraMap.get("claimNo") != null){
                String claimNo = (String)paraMap.get("claimNo");
                StringBuilder claimSql = new StringBuilder("select p.registNo from PrpLClaim p where p.claimNo like '"+claimNo+"'");
                Query query2 = em.createNativeQuery(claimSql.toString());
                List<Object> registNos = query2.getResultList();
                paraMap.remove("claimNo");
                if (registNos != null && registNos.size()>0){
                    caseTypeRegistNos.addAll(registNos);
                    String registNoList ="";
                    for (Object regist :registNos){
                        registNoList += "'"+regist+"',";
                    }
                    registNoList+=" '1') ";
                    copyCondition.add(" and r.registNo in ("+registNoList);
                }else {
                    copyCondition.add(" and r.registNo in ('1')");
                }
            }
            if (StringUtils.isNotEmpty(claimPrintDto.getRegistNo())){
                copyCondition.add(" and r.registNo like :registNo ");
                caseTypeRegistNos.add(claimPrintDto.getRegistNo());
            }
            if (StringUtils.isNotEmpty(claimPrintDto.getInsuredName())){
                copyCondition.add(" and r.insuredName like :insuredName");
            }
            if (StringUtils.isNotEmpty(claimPrintDto.getPolicyNo())){
                copyCondition.add(" and r.policyNo like :policyNo");
            }
            if (StringUtils.isNotEmpty(claimPrintDto.getCaseNo()) || StringUtils.isNotEmpty(claimPrintDto.getCompensateNo())){
                pageInfo.setTotalCount(0);
                pageInfo.setPages(claimPrintDto.getPageSize());
                pageInfo.setContent(claimPrintBackDtoList);
                return pageInfo;
            }
            StringBuilder copySql = new StringBuilder("select distinct r.registNo,r.insuredName,r.reportDate,r.riskCode,r.reportType, " +
                    " r.policyNo, r.classCode from  PrpLRegist r where 1=1 ");
            StringBuilder countCopySql = new StringBuilder("select count(r.registNo) " +
                    "  from  PrpLRegist r where 1=1");
            if (copyCondition.size()>0){
                dataCondition = this.joinCondition(copyCondition);
                copySql.append(" and ");
                copySql.append(dataCondition);
                countCopySql.append(" and ");
                countCopySql.append(dataCondition);
            }else  if (copyCondition.size()==0){
                pageInfo.setTotalCount(0);
                pageInfo.setPages(claimPrintDto.getPageSize());
                pageInfo.setContent(claimPrintBackDtoList);
                return pageInfo;
            }
            query = em.createNativeQuery(copySql.toString());
            query1 = em.createNativeQuery(countCopySql.toString());
            this.setQueryParam(query1,paraMap);
            this.setQueryParam(query,claimPrintDto.getPageNo(),claimPrintDto.getPageSize(),paraMap);
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
            objectList = query.getResultList();
        }

        for (Object [] obj: objectList) {
            claimPrintBackDto = new ClaimPrintBackDto();
            String businessNo = (String)obj[0];
            String policyNo ;
            String registNo = "";
            PrpLClaimDto prpLClaimDto =new PrpLClaimDto();
            PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
            if (businessNo.startsWith("4")){
                registNo = businessNo;
                List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByRegistNo(businessNo);
                if (prpLClaimList.size()>0){
                    prpLClaimDto = this.convert(prpLClaimList.get(0),PrpLClaimDto.class);
                    businessNo = prpLClaimDto.getClaimNo();
                }
            }else {
                prpLClaimKey.setClaimNo(businessNo);
                prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
            }
            claimPrintBackDto.setBusinessNo(businessNo);
            if (chooseFlag){
                policyNo = prpLClaimDto.getPolicyNo();
                registNo = prpLClaimDto.getRegistNo();
            }else {
                PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
                if (StringUtils.isNotEmpty(registNo)){
                    prpLRegistKey.setRegistNo(registNo);
                }else {
                    prpLRegistKey.setRegistNo(businessNo);
                }
                PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
                policyNo = prpLRegist.getPolicyNo();
                registNo = businessNo;
            }
            claimPrintBackDto.setInsuredName((String)obj[1]);
            Date date = (Date)obj[2];
            claimPrintBackDto.setReportDate(date);
            claimPrintBackDto.setPolicyNo(policyNo);
            if (chooseFlag){
                claimPrintBackDto.setCompensateNo((String)obj[5]);
                claimPrintBackDto.setRegistNo((String)obj[6]);
            }else {
                claimPrintBackDto.setRegistNo(registNo);
            }
            String riskCName = "";
            PrpDriskDto prpdRiskAgriDto = null;
            if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty((String)obj[3])){
                Map<String,String> map = new HashMap<>();
                map.put("riskCode",(String)obj[3]);
                prpdRiskAgriDto = prpDriskApi.queryByPK(map);
            }
            if (prpdRiskAgriDto != null) {
                riskCName = prpdRiskAgriDto.getRiskCName();
            }else{
                riskCName = "";
            }
            claimPrintBackDto.setRiskCName(riskCName);
            //caseType '案件性质:0 已注销，1 已拒赔，2 已结案 空值表示未结案'
            if (chooseFlag){
                if (obj != null && (String)obj[4] == null){
                    claimPrintBackDto.setCaseType("未结案");
                    PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
                    prpLCompensateKey.setCompensateNo((String)obj[5]);
                    PrpLCompensateDto prpLCompensateDto = this.convert(prpLCompensateDao.findOne(prpLCompensateKey),PrpLCompensateDto.class);
                    if (prpLCompensateDto != null && "1".equals(prpLCompensateDto.getUnderWriteFlag())){
                        claimPrintBackDto.setBusinessNo((String)obj[5]);
                        claimPrintBackDto.setCaseType("已理算");
                    }else if (prpLCompensateDto != null && "9".equals(prpLCompensateDto.getUnderWriteFlag())){
                        claimPrintBackDto.setBusinessNo((String)obj[5]);
                        claimPrintBackDto.setCaseType("未核赔");
                    }else if (prpLCompensateDto != null && "2".equals(prpLCompensateDto.getUnderWriteFlag())){
                        claimPrintBackDto.setBusinessNo((String)obj[5]);
                        claimPrintBackDto.setCaseType("正在核赔");
                    }else if (StringUtils.isNotEmpty(registNo)){
                        claimPrintBackDto.setCaseType("已立案");
                    }
                }else if ("2".equals((String)obj[4])){
                    List<PrpLCaseNo> prpLCaseNoList = prpLCaseNoDao.findByClaimNo((String)obj[0]);
                    if (prpLCaseNoList.size()>0){
                        claimPrintBackDto.setBusinessNo(prpLCaseNoList.get(0).getCaseNo());
                    }
                    claimPrintBackDto.setCaseType("已结案");
                }else if ("0".equals((String)obj[4])){
                    claimPrintBackDto.setCaseType("已注销");
                }else if ("1".equals((String)obj[4])) {
                    claimPrintBackDto.setCaseType("已拒赔");
                }
            }else {
                if (caseTypeRegistNos.size()>0){
                    for (Object regist:caseTypeRegistNos){
                        List<SwfLog> swfLogList = swfLogDao.queryByRegistNo((String)regist);
                        if (swfLogList.size()>0){
                            String businessFlag = swfLogList.get(0).getBusinessNo();
                            String nodeType = swfLogList.get(0).getNodeType();
                            String nodeStatus = swfLogList.get(0).getNodeStatus();
                            if ("compe".equals(nodeType)){
                                if ("0".equals(nodeStatus)){
                                    claimPrintBackDto.setBusinessNo(prpLClaimDto.getClaimNo());
                                    claimPrintBackDto.setCaseType("已立案");
                                }
                            }
                            if ("claim".equals(nodeType)){
                                if ("4".equals(nodeStatus)){
                                    claimPrintBackDto.setBusinessNo(prpLClaimDto.getClaimNo());
                                    claimPrintBackDto.setCaseType("已立案");
                                }else {
                                    claimPrintBackDto.setCaseType("未立案");
                                }
                            }
                            if ("check".equals(nodeType)){
                                if ("4".equals(nodeStatus)){
                                    claimPrintBackDto.setCaseType("已查勘");
                                }else {
                                    claimPrintBackDto.setCaseType("未查勘");
                                }
                            }
                            if ("sched".equals(nodeType)){
                                if ("4".equals(nodeStatus)){
                                    claimPrintBackDto.setCaseType("已调度");
                                }else {
                                    claimPrintBackDto.setCaseType("未调度");
                                }
                            }
                            if ("regis".equals(nodeType)){
                                if ("4".equals(nodeStatus)){
                                    claimPrintBackDto.setCaseType("已报案");
                                }
                            }
                            if ("speci".equals(nodeType) || businessFlag.startsWith("8")){
                                claimPrintBackDto.setBusinessNo(businessFlag);
                                claimPrintBackDto.setCaseType("特殊赔案");
                            }
                        }else {
                            List<SwfLogStore> swfLogStoreList = swfLogStoreDao.queryByRegistNo((String)regist);
                            if (swfLogStoreList.size()>0){
                                String nodeType = swfLogStoreList.get(0).getNodeType();
                                String nodeStatus = swfLogStoreList.get(0).getNodeStatus();
                                if ("cance".equals(nodeType)){
                                    if ("4".equals(nodeStatus)){
                                        if ("0".equals(prpLClaimDto.getCaseType())){
                                            claimPrintBackDto.setCaseType("已注销");
                                        }else if ("1".equals(prpLClaimDto.getCaseType())){
                                            claimPrintBackDto.setCaseType("已拒赔");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //itemCName   PrpCItemKind
            PrpDitemAgriDto prpDitemAgriDto ;
            PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
            prpLRegistKey.setRegistNo(prpLClaimDto.getRegistNo());
            PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
            List<String> strList = new ArrayList<>();
            Map<String,String> map=new HashMap<>();
            map.put("riskCode",prpLClaimDto.getRiskCode());
            map.put("itemCode",prpLRegist.getLossCode());
            prpDitemAgriDto = prpDitemAgriApi.queryByPk(map);
            if (prpDitemAgriDto != null) {
                strList.add(prpDitemAgriDto.getItemCName());
            } else {
                strList.add("");
            }
            claimPrintBackDto.setItemCName(strList);
            //打印类型判断
            List<String> allowPrintTypeList = new ArrayList<>();
            List<PrpLCompensate> prpLCompensateList = new ArrayList<>();
            PrpLCompensateDto prpLCompensateDto = null;
            if (chooseFlag){
                prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByClaimNo(prpLClaimDto.getClaimNo());
                prpLCompensateDto = this.convert(prpLCompensateList.get(0),PrpLCompensateDto.class);
            }
            if (claimPrintDto.getPrintType() != null && claimPrintDto.getPrintType().size() > 0){
                //农险卷宗
                if (claimPrintDto.getPrintType().contains("CoverPrint")){
                    //判断 compensateNo 是否存在对应数据
                    if (prpLCompensateDto != null && prpLCompensateDto.getCompensateNo() != null ) {
                        if (prpLCompensateDto.getCompensateNo().startsWith("631") || prpLCompensateDto.getCompensateNo().startsWith("632")) {
                            allowPrintTypeList.add("农险卷宗");
                        }
                    }
                }
                //现场查勘报告
                if (claimPrintDto.getPrintType().contains("LocalCheck")){
                    allowPrintTypeList.add("查勘报告");
                }
                //结案报告
                if (claimPrintDto.getPrintType().contains("EndCase")){
                    if (prpLClaimDto != null && prpLClaimDto.getEndCaserCode() != null){
                        allowPrintTypeList.add("结案报告");
                    }
                }
                //注销/拒赔通知书
                if (claimPrintDto.getPrintType().contains("Cancel")){
                    if (prpLClaimDto!= null){
                        businessNo = prpLClaimDto.getClaimNo();
                        int count = swfLogStoreDao.getCountByCheckCondition(businessNo);
                        if (count > 0){
                            allowPrintTypeList.add("拒赔/注销");
                        }
                    }
                }
                //保单抄件
                if (claimPrintDto.getPrintType().contains("CopyPrint")){
                    allowPrintTypeList.add("保单抄件");
                }
                //赔款理算书打印
                if (claimPrintDto.getPrintType().contains("Compensate")){
                    if (prpLCompensateDto != null){
                        allowPrintTypeList.add("赔款理算书");
                    }
                }
                if (claimPrintDto.getPrintType().contains("IndemnityNotice")){//赔款收据
                    if (prpLCompensateDto != null){
                        allowPrintTypeList.add("赔款收据");
                    }
                }
                claimPrintBackDto.setAllowedPrintType(allowPrintTypeList);
            }
            if (claimPrintBackDto.getAllowedPrintType() != null && claimPrintBackDto.getAllowedPrintType().size()>0){
                claimPrintBackDtoList.add(claimPrintBackDto);
            }
        }
        pageInfo.setTotalCount(totalSizeStrLon);
        pageInfo.setPages(claimPrintDto.getPageSize());
        pageInfo.setContent(claimPrintBackDtoList);
        return pageInfo;
    }

    /**
     * （理赔打印 农险卷宗封面）
     * @author: 王志文
     * @date: 2017/11/11 16:38
     * @param claimNo 立案号
     * @return 理赔打印页面数据
     * @throws Exception
     */
    @Override
    public AgriPrintDto queryAgriByPrint(String claimNo) throws Exception{
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(claimNo)){
            return new AgriPrintDto();
        }
        if (claimNo.startsWith("6")){
            PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
            prpLCompensateKey.setCompensateNo(claimNo);
            PrpLCompensate prpLCompensate= prpLCompensateDao.findOne(prpLCompensateKey);
            claimNo = prpLCompensate.getClaimNo();
        }
        if (claimNo.startsWith("7")){
            List<PrpLCaseNo> prpLCaseNoList = prpLCaseNoDao.findByCaseNo(claimNo);
            if (prpLCaseNoList.size()>0){
                claimNo = prpLCaseNoList.get(0).getClaimNo();
            }
        }
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        if (prpLClaim == null){
            return new AgriPrintDto();
        }
        String classCode = this.convert(prpLClaim,PrpLClaimDto.class).getClassCode();
        if (!"32".equals(classCode) && !"31".equals(classCode)){
            throw new Exception("请输入农险数据进行农险卷宗打印");
        }
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByClaimNo(claimNo);
        double sumPaid = 0.0;
        if (prpLCompensateList.size()>1){
            for (PrpLCompensate prpLCompensate: prpLCompensateList) {
                if (prpLCompensate.getTimes() == 1){
                    sumPaid = prpLCompensate.getSumPaid();
                }
            }
        }else if (prpLCompensateList.size() == 1){
            for (PrpLCompensate prpLCompensate: prpLCompensateList) {
                sumPaid = prpLCompensate.getSumPaid();
            }
        }
        String comCode = prpLClaimDto.getComCode(); //机构代码
        String riskCode = prpLClaimDto.getRiskCode();//险种代码
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",riskCode);
        PrpDriskDto prpDriskAgriDto = prpDriskApi.queryByPK(map);
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
        AgriPrintDto agriPrintDto = new AgriPrintDto();
        agriPrintDto.setClaimNo(claimNo);
        agriPrintDto.setComCName(prpDcompanyDto.getComCName());
        agriPrintDto.setDamageName(prpLClaimDto.getDamageName());
        agriPrintDto.setDamageStartDate(simpleDateFormat.format(prpLClaimDto.getDamageStartDate()));
        agriPrintDto.setInsuredName(prpLClaimDto.getInsuredName());
        agriPrintDto.setPolicyNo(prpLClaimDto.getPolicyNo());
        agriPrintDto.setRiskCName(prpDriskAgriDto.getRiskCName());
        agriPrintDto.setSumPaid(sumPaid);
        return agriPrintDto;
    }

    /**
     * （拒赔注销通知书查询）
     * @author: 王志文
     * @date: 2017/11/14 10:38
     * @param claimNo 立案号
     * @return 拒赔注销通知书页面数据
     * @throws Exception
     */
    @Override
    public RefuseCancelBackPrintDto queryRefuseCancelByClaimNo(String claimNo) throws Exception{
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(claimNo)){
            return new RefuseCancelBackPrintDto();
        }else{
            PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
            prpLClaimKey.setClaimNo(claimNo);
            PrpLClaim prpLClaim =prpLClaimDao.findOne(prpLClaimKey);
            if (prpLClaim == null){
                return new RefuseCancelBackPrintDto();
            }
            String classCode = this.convert(prpLClaim,PrpLClaimDto.class).getClassCode();
            if (!"32".equals(classCode) && !"31".equals(classCode)){
                throw new Exception("请输入农险数据进行打印");
            }
        }
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        RefuseCancelBackPrintDto refuseCancelBackDto = new RefuseCancelBackPrintDto();
        refuseCancelBackDto.setRegistNo(prpLClaimDto.getRegistNo());
        refuseCancelBackDto.setCancelReason(prpLClaimDto.getCancelReason());
        refuseCancelBackDto.setCaseNo(prpLClaimDto.getCaseNo());
        refuseCancelBackDto.setInsuredName(prpLClaimDto.getInsuredName());
        refuseCancelBackDto.setSumAmount(prpLClaimDto.getSumAmount());
        String riskCode = prpLClaimDto.getRiskCode();
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",riskCode);
        PrpDriskDto prpDriskAgriDto = prpDriskApi.queryByPK(map);
        String riskCName = "";
        if (prpDriskAgriDto != null){
            riskCName = prpDriskAgriDto.getRiskCName();
        }
        refuseCancelBackDto.setRiskCName(riskCName);
        PrpDitemAgriDto prpDitemAgriDto ;
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(prpLClaimDto.getRegistNo());
        map.put("riskCode",prpDriskAgriDto.getRiskCode());
        map.put("itemCode",prpLRegistDto.getLossCode());
        prpDitemAgriDto = prpDitemAgriApi.queryByPk(map);
        refuseCancelBackDto.setItemCName(prpDitemAgriDto.getItemCName());

        refuseCancelBackDto.setPolicyNo(prpLClaimDto.getPolicyNo());
        refuseCancelBackDto.setStartDate(simpleDateFormat1.format(prpLClaimDto.getStartDate()));
        refuseCancelBackDto.setEndDate(simpleDateFormat1.format(prpLClaimDto.getEndDate()));
        refuseCancelBackDto.setDamageStartDate(simpleDateFormat1.format(prpLClaimDto.getDamageStartDate())+prpLClaimDto.getDamageStartHour().substring(0,2)+"时");
        refuseCancelBackDto.setDamageAddress(prpLClaimDto.getDamageAddress());
        refuseCancelBackDto.setDamageName(prpLClaimDto.getDamageName());
        refuseCancelBackDto.setAddressCName("上海东大明路670号");
        refuseCancelBackDto.setPostCode("230031");
        refuseCancelBackDto.setPhoneNumber("0551-65197999");
        refuseCancelBackDto.setPrintTime(simpleDateFormat1.format(new Date()));
        return refuseCancelBackDto;
    }

    /**
     * （结案报告查询）
     * @author: 王志文
     * @date: 2017/11/14 10:38
     * @param claimNo 立案号
     * @return 结案报告页面数据
     * @throws Exception
     */
    @Override
    public EndCasePrintBackDto queryEndCasePrintByClaimNo(String claimNo) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(claimNo)){
            return new EndCasePrintBackDto();
        }else{
            if (claimNo.startsWith("7")){
                List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByCaseNo(claimNo);
                if (prpLClaimList.size()>0){
                    claimNo = prpLClaimList.get(0).getClaimNo();
                }
            }
            PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
            prpLClaimKey.setClaimNo(claimNo);
            PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
            if (prpLClaim == null){
                return new EndCasePrintBackDto();
            }
            String classCode = this.convert(prpLClaim,PrpLClaimDto.class).getClassCode();
            if (!"32".equals(classCode) && !"31".equals(classCode)){
                throw new Exception("请输入农险数据");
            }
        }
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        EndCasePrintBackDto endCasePrintBackDto = new EndCasePrintBackDto();
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",prpLClaimDto.getRiskCode());
        String riskCName = "";
        PrpDriskDto prpDriskAgriDto = prpDriskApi.queryByPK(map);
        if (prpDriskAgriDto != null){
            riskCName = prpDriskAgriDto.getRiskCName();
        }
        endCasePrintBackDto.setRiskCName(riskCName);
        endCasePrintBackDto.setPolicyNo(prpLClaimDto.getPolicyNo());
        endCasePrintBackDto.setDamageAddress(prpLClaimDto.getDamageAddress());
        endCasePrintBackDto.setDamageStartDate(simpleDateFormat.format(prpLClaimDto.getDamageStartDate()));
        endCasePrintBackDto.setInsuredName(prpLClaimDto.getInsuredName());
        endCasePrintBackDto.setSumAmount(new DecimalFormat("##0.00").format(prpLClaimDto.getSumAmount()));
        endCasePrintBackDto.setSumPremium(new DecimalFormat("##0.00").format(prpLClaimDto.getSumPremium()));
        List<PrpLLTextDto> prpLRegistTexts = prpLLTextApi.queryListByClaimNoAndTextType(prpLClaimDto.getClaimNo(),"08");
        List<String> tempContext = new ArrayList<String>();
        for (PrpLLTextDto prp: prpLRegistTexts) {
            tempContext.add(prp.getContext());
        }
        String temp = "";
        for (String str: tempContext) {
            temp += str;
        }
        endCasePrintBackDto.setTempContext(temp);
        return endCasePrintBackDto;
    }

    /**
     * （赔款收据打印）
     * @author: 王志文
     * @date: 2017/11/14 17:53
     * @param compensateNo 赔款计算书号
     * @return 赔款收据页面数据
     * @throws Exception
     */
    @Override
    public IndemnityNoticePrintBackDto queryIndemnityNoticeByCompensateNo(String compensateNo) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(compensateNo)){
            return new IndemnityNoticePrintBackDto();
        }
        PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
        prpLCompensateKey.setCompensateNo(compensateNo);
        PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
        if (prpLCompensate == null){
            return new IndemnityNoticePrintBackDto();
        }
        PrpLCompensateDto prpLCompensateDto = this.convert(prpLCompensate,PrpLCompensateDto.class);
        if (prpLCompensateDto == null ){
            return null;
        }
        String claimNo = prpLCompensateDto.getClaimNo();
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        if (!"31".equals(prpLClaimDto.getClassCode()) && !"32".equals(prpLClaimDto.getClassCode())){
            throw new Exception("请进行农险赔款收据打印！");
        }
        IndemnityNoticePrintBackDto indemnityNoticePrintBackDto = new IndemnityNoticePrintBackDto();
        indemnityNoticePrintBackDto.setCompensateNo(compensateNo);
        indemnityNoticePrintBackDto.setAccount(prpLCompensateDto.getAccount());
        indemnityNoticePrintBackDto.setBank(prpLCompensateDto.getBank());
        indemnityNoticePrintBackDto.setHandlerCode(prpDuserApi.queryByPK(prpLCompensateDto.getHandlerCode()).getUserName());
        indemnityNoticePrintBackDto.setInsuredName(prpLClaimDto.getInsuredName());
        indemnityNoticePrintBackDto.setPolicyNo(prpLClaimDto.getPolicyNo());
        indemnityNoticePrintBackDto.setPrintTime(simpleDateFormat1.format(new Date()));
        indemnityNoticePrintBackDto.setReceiverName(prpLCompensateDto.getReceiverName());
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",prpLClaimDto.getRiskCode());
        String riskCName = "";
        PrpDriskDto prpDriskAgriDto = prpDriskApi.queryByPK(map);
        if (prpDriskAgriDto != null){
            riskCName = prpDriskAgriDto.getRiskCName();
        }
        indemnityNoticePrintBackDto.setRiskCName(riskCName);
        indemnityNoticePrintBackDto.setSumClaim(new DecimalFormat("#,##0.00").format(prpLCompensateDto.getSumDutyPaid()));
        Map<String,String> map1 = new HashMap<>();
        map1.put("policyNo",prpLCompensateDto.getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map1);
        if (prpCmainDto != null){
            indemnityNoticePrintBackDto.setUnderWriteName(prpCmainDto.getUnderwriteName());
        }
        PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("CURRENCY_CI",prpLClaimDto.getCurrency());
        String capitalSumClaim = "";
        if (prpDcodeDto != null && prpLCompensateDto.getSumDutyPaid() != null){
            BigDecimal bigDecimal = new BigDecimal(prpLCompensateDto.getSumDutyPaid());
            capitalSumClaim =prpDcodeDto.getCodeCName() + NumberToCN.number2CNMontrayUnit(bigDecimal);
        }
        indemnityNoticePrintBackDto.setCapitalSumClaim(capitalSumClaim);
        return indemnityNoticePrintBackDto;
    }

    /**
     * （赔款理算书打印）
     * @author: 王志文
     * @date: 2017/11/15 11:09
     * @param compensateNo 赔款计算书号
     * @return 赔款理算书打印页面数据
     * @throws Exception
     */
    @Override
    public CompensatePrintBackDto queryCompensatePrintByCompensateNo(String compensateNo) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(compensateNo)){
            return new CompensatePrintBackDto();
        }
        PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
        prpLCompensateKey.setCompensateNo(compensateNo);
        PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
        if (prpLCompensate == null){
            return new CompensatePrintBackDto();
        }
        PrpLCompensateDto prpLCompensateDto = this.convert(prpLCompensate,PrpLCompensateDto.class);
        //没有数据则返回空
        if (prpLCompensateDto == null ){
            return null;
        }
        PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey();
        prpLRecaseKey.setClaimNo(prpLCompensateDto.getClaimNo());
        PrpLRecase prpLRecase = prpLRecaseDao.queryMaxSerialNoPrpByClaimNo(prpLCompensateDto.getClaimNo());
        String flag = "";
        if (prpLRecase != null && prpLRecase.getUndwrtFlag() != null){
            flag = prpLRecase.getUndwrtFlag();
        }
        if ("1".equals(flag)){ //重开赔案审核通过后没有计算书
            throw new Exception("该案件已进行重开赔案，无赔款理算书打印！");
        }
        CompensatePrintBackDto compensatePrintBackDto = new CompensatePrintBackDto();
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(prpLCompensateDto.getClaimNo());
        PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
        if (!"31".equals(prpLClaimDto.getClassCode()) && !"32".equals(prpLClaimDto.getClassCode())){
            throw new Exception("请进行农险赔案理算书打印！");
        }
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCItemKindApi.queryItemCodeByPolicyNo(prpLClaimDto.getPolicyNo());
        double amount = 0;
        for (PrpCitemKindDto prp: prpCitemKindDtoList) {
            amount = prp.getAmount();
        }
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",prpLClaimDto.getRiskCode());
        String riskCName = "";
        PrpDriskDto prpDriskAgriDto = prpDriskApi.queryByPK(map);
        if (prpDriskAgriDto != null){
            riskCName = prpDriskAgriDto.getRiskCName();
        }
        compensatePrintBackDto.setRiskCName(riskCName);
        compensatePrintBackDto.setCompensateNo(compensateNo);
        compensatePrintBackDto.setClaimNo(prpLClaimDto.getClaimNo());
        compensatePrintBackDto.setInsuredName(prpLClaimDto.getInsuredName());
        compensatePrintBackDto.setPolicyNo(prpLClaimDto.getPolicyNo());
        compensatePrintBackDto.setDamageStartDate(simpleDateFormat1.format(prpLClaimDto.getDamageStartDate())+prpLClaimDto.getDamageStartHour().substring(0,2)+"时");
        compensatePrintBackDto.setAmount(new DecimalFormat("#,##0.00").format(amount));
        compensatePrintBackDto.setDamageAddress(prpLClaimDto.getDamageAddress());
        compensatePrintBackDto.setValidAmount(new DecimalFormat("#,##0.00").format(prpLClaimDto.getSumAmount()));
        compensatePrintBackDto.setDamageName(prpLClaimDto.getDamageName());
        compensatePrintBackDto.setStartDate(simpleDateFormat1.format(prpLClaimDto.getStartDate()));
        compensatePrintBackDto.setEndDate(simpleDateFormat1.format(prpLClaimDto.getEndDate()));

        //获取标的名称
        String itemCName = "";
        for (PrpCitemKindDto prpc: prpCitemKindDtoList) {
            Map<String,String> map2=new HashMap<>();
            map.put("riskCode",prpLClaimDto.getRiskCode());
            map.put("itemCode",prpc.getItemCode());
            itemCName = prpDitemAgriApi.queryByPk(map).getItemCName();
        }
        compensatePrintBackDto.setItemCName(itemCName);
        compensatePrintBackDto.setBank(prpLCompensateDto.getBank());
        compensatePrintBackDto.setAccount(prpLCompensateDto.getAccount());
        compensatePrintBackDto.setReceiverName(prpLCompensateDto.getReceiverName());
        List<PrpLCText> prpLCTextList = prpLCTextDao.queryPrpLCTextsByCompensateNoAndTextType(compensateNo);
        String tempContext = "";
        for (PrpLCText prp: prpLCTextList) {
            tempContext += prp.getContext();
        }
        //计算公式及结果 如果大于6条 在清单中显示
        if (prpLCTextList.size()>6){
            compensatePrintBackDto.setListFlag("true");
            compensatePrintBackDto.setTempContext("理算过程信息过多，请详见清单。");
            compensatePrintBackDto.setTempContext1(" 计算公式及结果：\n        "+tempContext);
        }else{
            compensatePrintBackDto.setTempContext(" 计算公式及结果：\n        "+tempContext);
        }
        //应测试和需求要求，改为和合计金额相同
        compensatePrintBackDto.setSumClaim(prpLCompensateDto.getSumDutyPaid());
        compensatePrintBackDto.setSumDutyPaid(prpLCompensateDto.getSumDutyPaid());
        compensatePrintBackDto.setSumPaid(prpLClaimDto.getSumPaid());
        compensatePrintBackDto.setUnderWriteEndDate(simpleDateFormat1.format(prpLCompensateDto.getUnderWriteEndDate()));
        String underWriteName = "";
        Map<String,String> map1 = new HashMap<>();
        map1.put("policyNo",prpLCompensateDto.getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map1);
        if (prpCmainDto!= null){
            underWriteName = prpCmainDto.getUnderwriteName();
        }
        compensatePrintBackDto.setUnderWriteName(underWriteName);
        String userName = "";
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpLClaimDto.getHandlerCode())){
            userName = prpDuserApi.queryByPK(prpLClaimDto.getHandlerCode()).getUserName();
        }
        compensatePrintBackDto.setUserName(userName);
        return compensatePrintBackDto;
    }

    /**
     * （保单抄件打印）
     * @author: 王志文
     * @date: 2017/11/15 20:14
     * @param registNo 报案号
     * @return 保单抄件页面数据
     * @throws Exception
     */
    @Override
    public CopyPrintBackDto queryCopyPrintByRegistNo(String registNo,String userCode) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(registNo)){
            return new CopyPrintBackDto();
        }
        CopyPrintBackDto copyPrintBackDto = new CopyPrintBackDto();
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
        prpLRegistKey.setRegistNo(registNo);
        PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
        if ( prpLRegist == null){
            return new CopyPrintBackDto();
        }
        Map<String,String> map = new HashMap<>();
        map.put("riskCode",prpLRegist.getRiskCode());
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(map);
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCItemKindApi.queryItemCodeByPolicyNo(prpLRegist.getPolicyNo());
        Map<String,String> map1 = new HashMap<>();
        map1.put("policyNo",prpLRegist.getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map1);
        double unitAmount = 0;
        double deductible = 0;
        unitAmount = prpCitemKindDtoList.get(0).getUnitAmount();
        deductible = prpCitemKindDtoList.get(0).getDeductible();
        String riskCName = "";
        if (prpDriskDto != null ){
            riskCName = prpDriskDto.getRiskCName();
        }
        copyPrintBackDto.setRiskCName(riskCName);
        copyPrintBackDto.setRegistNo(prpLRegist.getRegistNo());
        copyPrintBackDto.setPolicyNo(prpLRegist.getPolicyNo());
        copyPrintBackDto.setInsuredName(prpLRegist.getInsuredName());
        double sumAmount = 0.0;

        if (prpCmainDto != null){
            sumAmount = prpCmainDto.getSumAmount();
            if (unitAmount != 0){
                copyPrintBackDto.setAmount(sumAmount/unitAmount);
            }
            copyPrintBackDto.setSumAmount(sumAmount);
            copyPrintBackDto.setInsuredAddress(prpCmainDto.getInsuredAddress());
            copyPrintBackDto.setOperateDate(simpleDateFormat.format(prpCmainDto.getOperateDate()));
            copyPrintBackDto.setInputDate(simpleDateFormat.format(prpCmainDto.getInputDate()));
            copyPrintBackDto.setSignDate(simpleDateFormat.format(prpCmainDto.getSignDate()));
            copyPrintBackDto.setOutputDate(simpleDateFormat.format(prpCmainDto.getInputDate()));
            copyPrintBackDto.setSumAmount1(prpCmainDto.getCurrency()+sumAmount);
            copyPrintBackDto.setDeductible(prpCmainDto.getCurrency()+deductible);
            copyPrintBackDto.setStartDate(simpleDateFormat.format(prpCmainDto.getStartDate()));
            copyPrintBackDto.setEndDate(simpleDateFormat.format(prpCmainDto.getEndDate()));
        }
        copyPrintBackDto.setItemDetailName(prpLRegist.getLossName());
        copyPrintBackDto.setUnitAmount(unitAmount);
        List<CopyPrintListDto> copyPrintListDtoList = new ArrayList<>();
        CopyPrintListDto copyPrintListDto ;
        Map<String,String> map2 = new HashMap<>();
        map2.put("policyNo",prpLRegist.getPolicyNo());
        PrpCmainDto prpCMainDto = this.convert(prpCmainApi.queryByPK(map2),PrpCmainDto.class);
        if (prpCMainDto!= null && "0".equals(prpCMainDto.getCoinsFlag())){
            copyPrintBackDto.setCoinsFlag("否");
        }else {
            copyPrintBackDto.setCoinsFlag("是");
        }
//        List<PrpCengageDto> prpCEngageDtoList = prpCEngageApi.queryEngageByPolicyNo(prpLRegist.getPolicyNo());
        CompensatePageResponseDto compensatePageResponseDto = new CompensatePageResponseDto();
        compensatePageResponseDto.setPolicyNo(prpLRegist.getPolicyNo());
        List<PrpCengageDtoExt> prpCEngageDtoList = compensatePageCommonService.setPrpCengageText(compensatePageResponseDto);
        //特别约定
        String clauses = "";
        for (PrpCengageDtoExt prp: prpCEngageDtoList) {
            clauses += prp.getClauses()+"\r\n"+prp.getContext()+"\r\n";
        }
        copyPrintBackDto.setClauses(clauses);
        //附加险    itemCKind   flag 字段  1为主险，2 为附加险
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setAddFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setAddHeadFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);
        for (PrpCitemKindDto prpCitemKindDto:prpCitemKindDtoList) {
            String flag = prpCitemKindDto.getFlag();
            if (StringUtils.isNotEmpty(flag) && "2".equals(flag.substring(1,2))){
                copyPrintListDto = new CopyPrintListDto();
                copyPrintListDto.setAddBodyFlag("true");
                copyPrintListDto.setKindName(prpCitemKindDto.getKindName());
                copyPrintListDto.setDbAmount(prpCitemKindDto.getAmount());
                copyPrintListDto.setDbDeductible(prpCitemKindDto.getUnitPersonLimitAmount());
                copyPrintListDtoList.add(copyPrintListDto);
            }
        }

        //批改情况
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setCorrectFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);

        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setCorrectHeadFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpLRegist.getPolicyNo())){
            List<PrpPheadDto> prpPheadDtoList = prpPheadApi.queryByPolicyNo(prpLRegist.getPolicyNo());
            if (prpPheadDtoList!= null && prpPheadDtoList.size() >0) {
                for (PrpPheadDto prpPheadDto:prpPheadDtoList
                        ){
                    if (prpPheadDto != null){
                        copyPrintListDto = new CopyPrintListDto();
                        copyPrintListDto.setCorrectBodyFlag("true");
                        copyPrintListDto.setEndorseNo1(prpPheadDto.getEndorseNo());
                        if (prpPheadDto.getEndorDate() != null){
                            copyPrintListDto.setEndorDate(simpleDateFormat.format(prpPheadDto.getEndorDate()));
                        }
                        PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("EndorType",prpPheadDto.getEndorType());
                        if (prpDcodeDto != null ){
                            copyPrintListDto.setEndorseReason(prpDcodeDto.getCodeCName());
                        }
                        Map<String,String> map3 = new HashMap<>();
                        map3.put("policyNo",prpLRegist.getPolicyNo());
                        copyPrintListDto.setUnderWriteName1(prpCmainApi.queryByPK(map3).getUnderwriteName());
                        copyPrintListDtoList.add(copyPrintListDto);
                    }
                }
            }
        }

        //保费到账情况
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setEndorseFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);

        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setEndorseHeadFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);
        List<PrpCplanDto> prpCplanDtoList = prpCplanApi.queryPrpCplanListByPolicyNo(prpLRegist.getPolicyNo());
        String endorseNo ;
        double planFee ; //应收费用
        double realFee ; //实收
        int payNo ;
        Date payDate ;
        for (PrpCplanDto prp:prpCplanDtoList) {
            payNo = prp.getPayNo();
            endorseNo = prp.getEndorseNo();
            planFee = prp.getPlanFee();
            realFee = planFee - prp.getDelinquentFee();
            payDate = prp.getPlanDate();
            copyPrintListDto = new CopyPrintListDto();
            copyPrintListDto.setEndorseBodyFlag("true");
            copyPrintListDto.setEndorseNo(endorseNo);
            copyPrintListDto.setPayDate(simpleDateFormat.format(payDate));
            copyPrintListDto.setPayNo(payNo);
            copyPrintListDto.setPlanFee(new DecimalFormat("#,##0.00").format(planFee));
            copyPrintListDto.setRealFee(new DecimalFormat("#,##0.00").format(realFee));
            copyPrintListDtoList.add(copyPrintListDto);
        }

        //历史赔付记录
        String policyNo = prpLRegist.getPolicyNo();
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setHistoryFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);

        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setHistoryHeadFlag("true");
        copyPrintListDtoList.add(copyPrintListDto);
        List<PrpLClaim> prpLClaims = prpLClaimDao.queryListByPolicyNo(policyNo);
        for (PrpLClaim prp: prpLClaims) {
            copyPrintListDto = new CopyPrintListDto();
            copyPrintListDto.setHistoryBodyFlag("true");
            copyPrintListDto.setClaimNo(prp.getClaimNo());
            if (prp.getDamageStartDate() != null){
                copyPrintListDto.setDamageStartDate(simpleDateFormat.format(prp.getDamageStartDate()));
            }
            if(prp.getEndCaseDate() != null){
                copyPrintListDto.setEndCaseDate(simpleDateFormat.format(prp.getEndCaseDate()));
            }else {
                copyPrintListDto.setEndCaseDate(" ");
            }
            copyPrintListDto.setUndeterminedAmount(0.00);
            if (prp.getSumPaid() != null){
                copyPrintListDto.setSumPaid(prp.getSumPaid());
            }
            Map<String,String> map4 = new HashMap<>();
            map4.put("policyNo",prpLRegist.getPolicyNo());
            PrpCmainDto prpCmainDto1 = prpCmainApi.queryByPK(map4);
            if (prpCmainDto1!= null){
                copyPrintListDto.setUnderWriteName(prpCmainDto1.getUnderwriteName());
            }

            String userName1 = "";
            if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prp.getHandlerCode())){
                userName1 = prpDuserApi.queryByPK(prp.getHandlerCode()).getUserName();
            }
            copyPrintListDto.setUserName1(userName1);   //该节点操作人
            copyPrintListDtoList.add(copyPrintListDto);
        }
        String currentUserCode = SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto userInfo = userApi.queryUserInfo(currentUserCode);
        copyPrintListDto = new CopyPrintListDto();
        copyPrintListDto.setEndFlag("true");
        copyPrintListDto.setUserName(userInfo.getUserName()); //当前操作人
        copyPrintListDto.setPrintDate(simpleDateFormat1.format(new Date()));
        copyPrintListDtoList.add(copyPrintListDto);
        copyPrintBackDto.setCopyPrintListDtoList(copyPrintListDtoList);
        return copyPrintBackDto;
    }

    /**
     * （根据保单号查询PrpLClaim表）
     * @author: 王志文
     * @date: 2017/11/21 10:44
     * @param policyNo 保单号
     * @return PrpLClaimDto 的集合
     */
    @Override
    public List<PrpLClaimDto> queryByPolicyNo(String policyNo) throws Exception {
        List<PrpLClaim> prpLClaims = prpLClaimDao.queryListByPolicyNo(policyNo);
        List<PrpLClaimDto> prpLClaimDtos = new ArrayList<>();
        for (PrpLClaim prplclaim: prpLClaims) {
            prpLClaimDtos.add(this.convert(prplclaim,PrpLClaimDto.class));
        }
        return prpLClaimDtos;
    }
    /**
     * （根据立案号、报案号、保单号查询结案登记页面详细信息）
     * @param prpLClaimDto （只有立案号、报案号、保单号）
     * @return 结案登记展示页面相关信息
     * @author: 董坤
     * @date: 2017/11/11 10:41
     */
    @Override
    public PrpLClaimEndCaseDto queryEndCaseDetailByCondition(PrpLClaimDto prpLClaimDto) throws Exception{
        if(StringUtils.isEmpty(prpLClaimDto.getPolicyNo())){
            throw new DataVerifyException("保单号不能为空");
        }
        if(StringUtils.isEmpty(prpLClaimDto.getClaimNo())){
            throw new DataVerifyException("立案号不能为空");
        }
        if(StringUtils.isEmpty(prpLClaimDto.getRegistNo())){
            throw new DataVerifyException("报案号不能为空");
        }
        //查结案登记详细信息
        PrpLClaimDto prpLClaimDto1 =  queryByPK(prpLClaimDto.getClaimNo());
        PrpLClaimEndCaseDto prpLClaimEndCaseDto = convert(prpLClaimDto1,PrpLClaimEndCaseDto.class);
        // 理赔类型代码对应中文 固定为L'理赔'
        prpLClaimEndCaseDto.setlFlag("理赔");
        //查语言代码对应中文
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getLanguage())){
            String codeCName = prpDcodeApi.translateCodeByPK("Language",prpLClaimEndCaseDto.getLanguage());
            prpLClaimEndCaseDto.setLanguage(codeCName);
        }
        //查币别代码对应中文
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getLanguage())){
            String codeCName = prpDcodeApi.translateCodeByPK("CURRENCY_CI",prpLClaimEndCaseDto.getCurrency());
            prpLClaimEndCaseDto.setCurrency(codeCName);
        }

        //查投保人名称
        if(StringUtils.isNotEmpty(prpLClaimDto.getPolicyNo())){
            Map<String,String> map = new HashMap<>();
            map.put("policyNo",prpLClaimDto.getPolicyNo());
            PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
            if(prpCmainDto!=null){
                prpLClaimEndCaseDto.setAppliName(prpCmainDto.getAppliName());
            }
        }
        //查险种名
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getRiskCode())){
            String riskCName = prpDriskApi.translateCodeByPK(prpLClaimEndCaseDto.getRiskCode());
            prpLClaimEndCaseDto.setRiskName(riskCName);
        }
        //查机构名
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getComCode())){
            String ComCName = prpDcompanyApi.translateCodeByPK(prpLClaimEndCaseDto.getComCode());
            prpLClaimEndCaseDto.setComName(ComCName);
        }
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getMakeCom())){
            String ComCName = prpDcompanyApi.translateCodeByPK(prpLClaimEndCaseDto.getMakeCom());
            prpLClaimEndCaseDto.setMakeComName(ComCName);
        }
        //查人名
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getHandler1Code())){//归属业务员
            String userName = prpDuserApi.translateCodeByPK(prpLClaimEndCaseDto.getHandler1Code());
            prpLClaimEndCaseDto.setHandler1Name(userName);
        }
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getHandlerCode())){//经办人
            String userName = prpDuserApi.translateCodeByPK(prpLClaimEndCaseDto.getHandlerCode());
            prpLClaimEndCaseDto.setHandlerName(userName);
        }
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getOperatorCode())){//操作员
            String userName = prpDuserApi.translateCodeByPK(prpLClaimEndCaseDto.getOperatorCode());
            prpLClaimEndCaseDto.setOperatorName(userName);
        }
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getEndCaserCode())){//结案员
            String userName = prpDuserApi.translateCodeByPK(prpLClaimEndCaseDto.getEndCaserCode());
            prpLClaimEndCaseDto.setEndCaserName(userName);
        }
        if(StringUtils.isNotEmpty(prpLClaimEndCaseDto.getDealerCode())){//注销人
            String userName = prpDuserApi.translateCodeByPK(prpLClaimEndCaseDto.getDealerCode());
            prpLClaimEndCaseDto.setDealerName(userName);
        }
        PrpLRegist prpLRegist= prpLRegistDao.findByRegistNo(prpLClaimDto.getRegistNo());
        prpLClaimEndCaseDto.setLossName(prpLRegist.getLossName());

        // 查结案报告
        String textType="08";//文字说明类型
        List<PrpLLText> contextList = prpLLTextDao.queryByClaimNoAndTextType(prpLClaimDto.getClaimNo(),textType);
        String context = "";
        for(PrpLLText prpLLText:contextList){
            if(prpLLText!=null){
                context += prpLLText.getContext();
            }
        }
        prpLClaimEndCaseDto.setContext(context);

        //初始化的占号操作,在一个用户进行结案的时候就设置swflog表的当前节点的用户为当前用户,这样别的用户无法查询到
        if("EDIT".equals(prpLClaimDto.getEditType())){
            String userCode  = SinoRequestContext.getCurrentContext().getUserCode();
            String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
            SwfLog swfLog = swfLogDao.queryEndcaByRegistNo(prpLClaimDto.getRegistNo());
            String flowId = swfLog.getFlowId();
            Integer logNo = swfLog.getLogNo();
            workFlowService.holdNode(flowId,logNo,userCode,userName);
        }
        return prpLClaimEndCaseDto;
    }

    /**
     * （结案登记页面详细信息保存）
     * @param prpLClaimEndCaseDto 结案登记展示页面相关信息
     * @return 结案信息保存成功与否信息
     * @author: 董坤
     * @date: 2017/11/13 14:31
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveEndCaseInfo(PrpLClaimEndCaseDto prpLClaimEndCaseDto) throws Exception{String message = "success";
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getRegistNo())){
            throw new DataVerifyException("报案号不能为空！");
        }
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getPolicyNo())){
            throw new DataVerifyException("保单号不能为空！");
        }
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getClaimNo())){
            throw new DataVerifyException("立案号不能为空！");
        }
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getRiskCode())){
            throw new DataVerifyException("险种代码不能为空！");
        }
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getOperatorCode())){
            throw new DataVerifyException("操作员代码不能为空！");
        }
        if(org.apache.commons.lang3.StringUtils.isEmpty(prpLClaimEndCaseDto.getComCode())){
            throw new DataVerifyException("机构代码不能为空！");
        }
        if(prpLClaimEndCaseDto.getInputDate() ==null){
            throw new DataVerifyException("输单日期不能为空！");
        }
        List<SwfLog>  swfLogList =swfLogDao.queryByRegistNo(prpLClaimEndCaseDto.getRegistNo());
        String swfLogFlowID = swfLogList.get(0).getFlowId();
        List<SwfLog> swfLogList1=swfLogDao.queryComppByFlowId(swfLogFlowID);



        String claimNo = prpLClaimEndCaseDto.getClaimNo();
        String registNo = prpLClaimEndCaseDto.getRegistNo();
        String policyNo = prpLClaimEndCaseDto.getPolicyNo();
        String riskCode = prpLClaimEndCaseDto.getRiskCode();
        String comCode = prpLClaimEndCaseDto.getComCode();
        //1.数据、业务校验

        List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByClaimNo(claimNo);
        if (prpLCompensateList == null || prpLCompensateList.size() < 1) {
            throw new BusinessException("此立案"+ claimNo +"没有赔款计算书，不能结案！");
        }else{
            for(PrpLCompensate prpLCompensate:prpLCompensateList){
                if (!(prpLCompensate.getUnderWriteFlag().equals("1") || prpLCompensate.getUnderWriteFlag().equals("3") )) {//核赔标志UnderWriteFlag： 1，3未通过
                    throw new BusinessException("有没有核赔通过的计算书，不能结案！");
                }
            }
        }

        //--2..获取赔案号
        String tableName = "prplcaseno";//表名
        String nodeType= "endca";
        int year = DateTime.current().getYear();

        boolean isRecase =false;//是否重开赔案(true:有重开，且未结案;false:无重开赔案 或 无未结案的重开赔案)
        List<PrpLRecase> prpLRecaseList = prpLRecaseDao.findByClaimNoOrderBySerialNo(claimNo);//根据最后一次重开赔案数据
        if(prpLRecaseList!=null && prpLRecaseList.size()>0){
            PrpLRecase prpLRecase = prpLRecaseList.get(0);
            if(  (prpLRecase.getCloseCaseuserCode()==null ||  prpLRecase.getCloseCaseuserCode().trim().equals(""))
                    && (prpLRecase.getCloseCaseDate()==null ||  prpLRecase.getCloseCaseDate()==null) ){
                isRecase = true;
            }
        }
        boolean isGenrateCaseNo =false;//是否生成过赔案号码
        PrpLClaimDto prpLClaimDto = queryByPK(claimNo);
        if(prpLClaimDto!=null){
            if(prpLClaimDto.getCaseNo()!=null){
                isGenrateCaseNo=true;
            }
        }
        boolean isPrepay = true;//特俗赔案是否结案 :false没结案, true结案
        //判断结案是否是特俗赔案生成的结案节点
        if(isGenrateCaseNo == true && isRecase == false){//已有赔案号 且 （无重开赔案 或 无未结案的重开赔案）
            List<PrpLCaseNo> prpLCaseNoList = prpLCaseNoDao.findByClaimNo(claimNo);
            if(prpLCaseNoList!=null){
                if(prpLCaseNoList.size()>0){
                    isPrepay = false;
                }
            }
        }
        String caseNo ="";
//    if(isRecase==true || isPrepay==true){ //有未结的重开赔案或特俗赔案已经结案
//        caseNo = prpLClaimDto.getCaseNo();
//    }else{
        BillNoDto billNoDto = new BillNoDto();
        billNoDto.setiComCode(comCode);
        billNoDto.setiYear(String.valueOf(year));
        billNoDto.setTableName(tableName);
        billNoDto.setUserCode(prpLClaimEndCaseDto.getOperatorCode());
        billNoDto.setRiskCode(riskCode);
        caseNo = billNoApi.getBillNo(billNoDto).get("billNo");//拼接赔案号
        prpLClaimEndCaseDto.setCaseNo(caseNo);
//    }
//    //--3.工作流数据、业务数据的保存保存
//    SwfLog swfLog=swfLogDao.queryEndCa(prpLClaimEndCaseDto.getRegistNo());
//    SwfLogDto swfLogDto = convert(swfLog,SwfLogDto.class);
//    swfLogDto.setNodeType("endca");
//    swfLogDto.setNodeStatus("4"); // 默认都是提交
//    swfLogDto.setBusinessNo(prpLClaimEndCaseDto.getClaimNo());
////    swfLogDto.setNextBusinessNo(claimNo);
//    swfLogDto.setKeyIn(prpLClaimEndCaseDto.getClaimNo());
//    swfLogDto.setKeyOut(caseNo);
//    // todo 判断是否有可以保存的工作流
//
//    if (true) { //有可以保存的工作流
//        if(isRecase==true){ //重开赔案只保存流的东西 + 回写 prplrecase表
//            //回写 prplrecase表
//            Integer serialNo = prpLRecaseDao.findMaxSerialNoByClaimNo(claimNo);//最后一次重开赔案数据
//            PrpLRecaseKey prpLRecaseKey = new PrpLRecaseKey(claimNo,serialNo);
//            PrpLRecase prpLRecase = prpLRecaseDao.findOne(prpLRecaseKey);
//            prpLRecase.setCloseCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
//            prpLRecase.setCloseCaseuserCode(prpLClaimEndCaseDto.getOperatorCode());
//            prpLRecaseDao.save(prpLRecase);
//
//            saveEndcaseInfoAndWorkFlow(null,swfLogDto,caseNo,isRecase);
//        }else{ //一般案件结案
//            saveEndcaseInfoAndWorkFlow(prpLClaimEndCaseDto,swfLogDto,caseNo,isRecase);
//        }
//    } else {//无可保存的工作流
//        saveEndcaseInfoAndWorkFlow(prpLClaimEndCaseDto,null,caseNo,isRecase);
//    }

        //获取相关的参数
        String context = prpLClaimEndCaseDto.getContext();
        int RULE_LENGTH = 70;
        String[] rules = StringGyUtils.split(context, RULE_LENGTH);
        for (int k = 0; k < rules.length; k++) {
            PrpLLText prpLltext = new PrpLLText();
            prpLltext.setClaimNo(claimNo);
            prpLltext.setContext(rules[k]);
            prpLltext.setLineNo(k + 1);
            prpLltext.setTextType("08");
            prpLLTextDao.save(prpLltext);
        }

        swfLogList =swfLogDao.queryByRegistNo(prpLClaimEndCaseDto.getRegistNo());
        swfLogFlowID = swfLogList.get(0).getFlowId();
        Integer swfLogLogNo = swfLogList.get(0).getLogNo();
        String businessNo = swfLogList.get(0).getBusinessNo();
        SwfLogDto swfLogDto = new SwfLogDto();
        //jiaoyunzhen 检查内容是否合法 例如是不是已经回退过了或者提交了等
        swfLogDto = this.checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(prpLClaimEndCaseDto.getHandlerCode());
        user.setUserName(prpLClaimEndCaseDto.getOperatorName());
        if (checkFlag < 0) {
            return String.valueOf(checkFlag);
        }
        String keyString = swfLogDto.getBusinessNo();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //jiaoyunzhen 整理Dto

        WorkFlowDto workFlowDto = this.getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                businessNo, false);
        if (workFlowDto == null) {
            return String.valueOf(-5);
        }
        //追加意见
        // AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        // jiaoyunzhen 处理整个工作流程(这个是整个工作流处理的基础)

        if (prpLRecaseApi.queryReCaseByClaimNo(claimNo).getSerialNo()!=0){
        }
        else {
            PrpLClaimKey prpLClaimKey = new PrpLClaimKey(claimNo);
            PrpLClaim prpLClaim=prpLClaimDao.findOne(prpLClaimKey);
            prpLClaim.setEndCaseDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            //结案保存caseType为2  0 注销
            //1 拒赔
            //2 结案
            // null 未结案
            prpLClaim.setCaseType("2");
        }
        workFlowService.deal(workFlowDto);
        workProcessService.saveWorkProcess(
                prpLClaimEndCaseDto.getPolicyNo(),prpLClaimEndCaseDto.getRegistNo(),
                prpLClaimEndCaseDto.getClaimNo(),prpLClaimEndCaseDto.getCaseNo(),
                prpLClaimEndCaseDto.getClassCode(),prpLClaimEndCaseDto.getRiskCode(),
                "endca","endca", AgriclaimWorkProcessEnum.已结案,
                SinoRequestContext.getCurrentContext().getUserCode());
        PrpLCaseNo prpLCaseNo=new PrpLCaseNo();
//        SwfLog swfLog=swfLogDao.queryComppByFlowId(swfLogFlowID);
        prpLCaseNo.setCaseNo(caseNo);

        prpLCaseNo.setCertiNo(swfLogList1.get(0).getBusinessNo());
        prpLCaseNo.setCertiType("C");
        prpLCaseNo.setClaimNo(claimNo);
        prpLCaseNoDao.save(prpLCaseNo);
        message="结案成功！结案号："+caseNo;
        return message;
    }

    /**
     * （结案登记页面数据保存（流+页面数据） 被主保存方法调用的方法）
     * @param prpLClaimEndCaseDto 页面数据dto
     * @param caseNo 赔案号
     * @author: 董坤
     * @date: 2017/11/15 15:52
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveEndcaseInfoAndWorkFlow(PrpLClaimEndCaseDto prpLClaimEndCaseDto,SwfLogDto swfLogDto, String caseNo,boolean isRecase) throws Exception{
        String message ="结案成功";
        //todo 保存流
        //保存工作流 就是查出未处理的结案节点 然后再将nodeStatus设置为4 已处理
        SwfLog swfLog=convert(swfLogDto,SwfLog.class);
        SwfLog swfLog1=swfLogDao.saveAndFlush(swfLog);
        if (swfLog1==null){
            throw new BusinessException("工作流表保存失败");
        }
        //保存业务数据
        if(prpLClaimEndCaseDto!=null){
            String claimNo = prpLClaimEndCaseDto.getClaimNo();
            String registNo = prpLClaimEndCaseDto.getRegistNo();
            String policyNo = prpLClaimEndCaseDto.getPolicyNo();
            String riskCode = prpLClaimEndCaseDto.getRiskCode();
            String comCode = prpLClaimEndCaseDto.getComCode();
            String nodeType= "endca";

            if(!isRecase){    //无重开赔案 或 无未结案的重开赔案
                //首先删除原来的相关数据
                String textType = "";//文字说明类型
                if(!"".equals(prpLClaimEndCaseDto.getCancelDate())){
                    textType = "10";
                }
                else{
                    textType = "08";
                }
                prpLLTextDao.deleteByClaimNoAndTextType(claimNo,textType);
                //保存prpLltext文字信息表
                String context = prpLClaimEndCaseDto.getContext();
                int RULE_LENGTH = 70;
                String[] rules = StringGyUtils.split(context, RULE_LENGTH);
                for (int k = 0; k < rules.length; k++) {
                    PrpLLText prpLltext = new PrpLLText();
                    prpLltext.setClaimNo(claimNo);
                    prpLltext.setContext(rules[k]);
                    prpLltext.setLineNo(k + 1);
                    prpLltext.setTextType("08");
                    prpLLTextDao.save(prpLltext);
                }

                //更新prpLClaim立案表
                PrpLClaimKey prpLClaimKey = new PrpLClaimKey(claimNo);
                PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
                if (caseNo != null && caseNo.length() > 1) {
                    prpLClaim.setCaseNo(caseNo);
                } else {
                    prpLClaim.setCaseNo(null);
                }
                prpLClaim.setCaseType("2"); //设置案件类型 2为正常结案
                prpLClaim.setEndCaserCode(prpLClaimEndCaseDto.getOperatorCode());
                prpLClaim.setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
                prpLClaimDao.save(prpLClaim);

                //保存prplreturnvisitswflog表信息 生成结案回访数据
                PrpLRegistDto prpLRegistDto =  prpLRegistApi.queryByPK(registNo);
                PrplReturnVisitSwflog prplReturnVisitSwflog = new PrplReturnVisitSwflog();
                if(prpLRegistDto != null && !"".equals(prpLRegistDto)){
                    prplReturnVisitSwflog.setBusinessNo(prpLRegistDto.getRegistNo());								//业务号
                    prplReturnVisitSwflog.setNodeType(nodeType);														//节点号
                    prplReturnVisitSwflog.setRegistNo(prpLRegistDto.getRegistNo());									//报案号
                    prplReturnVisitSwflog.setComCode(prpLRegistDto.getComCode());									//承保机构
                    prplReturnVisitSwflog.setPolicyNo(prpLRegistDto.getPolicyNo());

                    PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(prpLRegistDto.getComCode());

                    prplReturnVisitSwflog.setComCodeName(prpDcompanyDto.getComCName());										//机构名称
                    prplReturnVisitSwflog.setInsuredName(prpLRegistDto.getInsuredName());							//被保险人
                    String reportd = prpLRegistDto.getReportDate().toString();
                    reportd = reportd+" "+prpLRegistDto.getReportHour();
                    DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
                    prplReturnVisitSwflog.setReportDate(d);			//报案时间
                    if("sched".equals(nodeType)){

                    }else{
                        prplReturnVisitSwflog.setCeaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//结案时间
                    }
                    prplReturnVisitSwflog.setLicenseNo(prpLRegistDto.getLicenseNo());								//车牌号
                    prplReturnVisitSwflog.setHandlerCode(prpLClaimEndCaseDto.getOperatorCode());				    //处理人代码
                    prplReturnVisitSwflog.setHandlerName(prpLClaimEndCaseDto.getOperatorName());					//处理人名称
                    prplReturnVisitSwflog.setHandlerComCode(prpLClaimEndCaseDto.getComCode());						//处理人部门
                    prplReturnVisitSwflog.setFlowintoTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//流入时间
                    prplReturnVisitSwflog.setClassCode(prpLRegistDto.getClassCode());								//险类
                    String state="0";//状态(0未处理，2正在处理，4已经处理)
                    prplReturnVisitSwflog.setState(state);															//状态
                    prplReturnVisitSwflog.setRiskCode(prpLRegistDto.getRiskCode());
                    prplReturnVisitSwflogDao.save(prplReturnVisitSwflog);

                }
                if(caseNo!=null){
                    prpLCaseNoDao.deleteByCaseNo(caseNo);
                    List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByClaimNo(claimNo);
                    for(PrpLCompensate prpLCompensate:prpLCompensateList) {
                        //保存prpLCaseNo赔案号表  todo 3.prpLCaseNoDao存不了值？？
                        PrpLCaseNo prpLCaseNo = new PrpLCaseNo();
                        prpLCaseNo.setCertiType("C");
//                        prpLCaseNo.setFlag("");
                        prpLCaseNo.setCertiNo(prpLCompensate.getCompensateNo());
                        prpLCaseNo.setCaseNo(caseNo);
                        prpLCaseNo.setClaimNo(claimNo);
                        prpLCaseNoDao.save(prpLCaseNo);

                        //更新赔款计算书
                        prpLCompensate.setCaseNo(caseNo);
                        prpLCompensateDao.save(prpLCompensate);
                    }

                    //更新prpLclaimStatus状态表信息
                    //先删除
                    prpLclaimStatusDao.deleteByBusinessNoAndNodeType(caseNo,nodeType);

                    PrpLclaimStatus prpLclaimStatus = new PrpLclaimStatus();
                    //Status操作状态位 :老系统在jsp页面设置为 "1"
                    prpLclaimStatus.setStatus("1");
                    prpLclaimStatus.setBusinessno(caseNo);
                    prpLclaimStatus.setPolicyno(policyNo);
                    prpLclaimStatus.setRiskcode(riskCode);
                    prpLclaimStatus.setNodetype("endca");
                    prpLclaimStatus.setSerialno(0);//序列号
                    prpLclaimStatus.setHandlercode(prpLClaimEndCaseDto.getOperatorCode());
                    prpLclaimStatus.setInputdate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
                    prpLclaimStatus.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLclaimStatusDao.save(prpLclaimStatus);
                }
            }
        }

        return message;

    }
}