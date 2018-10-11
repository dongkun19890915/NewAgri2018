package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLInvestigateDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLInvestigateDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLInvestigate;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLInvestigateKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLInvestigateService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNodeDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNode;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.agri.core.gycore.dto.AddSurveyTaskDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 案情调查信息表Core接口实现
 */
@Service
@Transactional
public class PrpLInvestigateServiceImpl extends BaseServiceImpl implements PrpLInvestigateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLInvestigateServiceImpl.class);
    
    @Autowired
    private PrpLInvestigateDao prpLInvestigateDao;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private SwfNodeDao swfNodeDao;
    @Autowired
    private SwfPathLogDao swfPathLogDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    @Autowired
    private PrpDriskApi prpDriskApi;
    /**
     * 金禾webservice地址
     */
    @Value("${webservice.gycoreService.url}")
    private String gycoreService;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLInvestigateDto prpLInvestigateDto) {
        PrpLInvestigate prpLInvestigate = this.convert(prpLInvestigateDto, PrpLInvestigate.class);
        prpLInvestigateDao.save(prpLInvestigate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Double serialNo,String objectType) {
        PrpLInvestigateKey prpLInvestigateKey = new PrpLInvestigateKey(registNo,serialNo,objectType);
        prpLInvestigateDao.delete(prpLInvestigateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLInvestigateDto prpLInvestigateDto) {
        PrpLInvestigate prpLInvestigate = this.convert(prpLInvestigateDto, PrpLInvestigate.class);
        prpLInvestigateDao.save(prpLInvestigate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLInvestigateDto queryByPK(String registNo,java.lang.Double serialNo,String objectType) {
        PrpLInvestigateKey prpLInvestigateKey = new PrpLInvestigateKey(registNo,serialNo,objectType);
        PrpLInvestigate prpLInvestigate = prpLInvestigateDao.findOne(prpLInvestigateKey);
        return this.convert(prpLInvestigate,PrpLInvestigateDto.class);
    }
    /**
     * 调查流程节点
     * @author: 孙朋飞
     * @date: 2018/2/22 10:43
     * @param nodeStatus 节点状态
     * @param registNo 报案号
     * @param handlerCode 处理人代码
     * @param handlerName 处理人名称
     * @param userComCode 用户机构代码
     * @param userComCname 用户机构名称
     * @return 报案号
     * @throws Exception
     */
    @Override
    public Map<String,String> saveInvestigation(String registNo, String nodeStatus, String handlerCode, String handlerName, String userComCode, String userComCname) throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("registNo",registNo);
        //根据报案号查询流程编号
        String flowId = swfLogDao.findSwfLogByRegistNo(registNo);
        List<SwfLog> swfList = swfLogDao.findSwfLogByFlowIdAndNodeTypes(flowId, "inves","4");
        if(swfList!=null&&swfList.size()>0){
            map.put("message","该案件已调查！");
            return map;
        }
        if("2".equals(nodeStatus)){
            List<SwfLog> inves = swfLogDao.findSwfLogByFlowIdAndNodeTypes(flowId, "inves","2");
            if(inves!=null&&inves.size()>0){
                map.put("message","已生成调查节点，请勿重复生成!");
                return map;
            }
        }
        if("4".equals(nodeStatus)){
            List<SwfLog> inves = swfLogDao.findSwfLogByFlowIdAndNodeTypes(flowId, "inves","2");
            if(inves==null||inves.size()==0){
                map.put("message","请先生成调查节点，再处理!");
                return map;
            }
        }
        //根据flowid查询最大logNo值
        Integer maxLogNo = swfLogDao.getMaxSwfLogNo(flowId);
        //查询模板
        SwfLog swf=swfLogDao.findModelNoByFlowId(flowId);
        if(maxLogNo==0 ){
            map.put("message","案件未查询到工作流信息");
            return map;
        }
        //根据模板号和流程号查询
        /*List<SwfNode> swfNodeList = swfNodeDao.getFirstNodeTypeNode(swf.getModelNo(), "inves");
        if (swfNodeList == null||swfNodeList.size()==0){
            throw new BusinessException("未查询到该模板号的节点信息");
        }*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SwfLog swfLog = new SwfLog();
        SwfLog swfLogByFlowIdAndLogNo = swfLogDao.findByFlowIdAndLogNo(flowId,2);
        int maxPathNo = swfPathLogDao.getMaxPathNo(flowId);
        if("2".equals(nodeStatus)){
            swfLog.setFlowId(flowId);
            //查询调度的节点号码
            swfLog.setLogNo(maxLogNo+1);
            swfLog.setModelNo(swf.getModelNo());
            //swfLog.setNodeNo(swfNodeList.get(0).getNodeNo());
            swfLog.setNodeNo(swf.getNodeNo());
            swfLog.setNodeName("调查");
            swfLog.setBusinessNo(registNo);
            swfLog.setHandleDept(userComCode);
            swfLog.setHandlerCode(handlerCode);
            swfLog.setHandlerName(handlerName);
            swfLog.setFlowInTime(sdf.format(new Date()));
            swfLog.setTimeLimit(0);
            swfLog.setHandleTime(sdf.format(new Date()));
            swfLog.setSubmitTime(sdf.format(new Date()));
            swfLog.setNodeStatus("2");
            swfLog.setFlowStatus("1");
            swfLog.setPackageId("0");
            swfLog.setTaskNo(0);
            swfLog.setTaskType("S");
            swfLog.setNodeType("inves");
            swfLog.setTitleStr("调查节点");
            swfLog.setRiskCode(swf.getRiskCode());
            swfLog.setKeyIn(registNo);
            swfLog.setKeyOut(registNo);
            swfLog.setDeptName(userComCname);
            swfLog.setMainFlowId("0");
            swfLog.setSubFlowId("0");
            swfLog.setPosx(0);
            swfLog.setPosy(0);
            swfLog.setEndFlag("0");
            //beforeHandlerCode 和beforeHandlerNamea上个处理人员代码和上个处理人员名称
            swfLog.setBeforeHandlerCode(swfLogByFlowIdAndLogNo.getHandlerCode());
            swfLog.setBeforeHandlerName(swfLogByFlowIdAndLogNo.getHandlerName());
            swfLog.setComCode(userComCode);
            swfLog.setPolicyNo(swf.getPolicyNo());
            swfLog.setTypeFlag("1");
            swfLog.setScheduleId(0);
            swfLog.setInsuredName(swf.getInsuredName());
            swfLog.setRegistNo(registNo);
            swfLogDao.save(swfLog);
            SwfPathLog swfPathLog = new SwfPathLog();
            swfPathLog.setPathNo(maxPathNo+1);
            swfPathLog.setFlowId(flowId);
            swfPathLog.setStartNodeNo(swfLogByFlowIdAndLogNo.getLogNo());
            swfPathLog.setStartNodeName(swfLogByFlowIdAndLogNo.getNodeName());
            swfPathLog.setEndNodeNo(maxLogNo+1);
            swfPathLog.setEndNodeName("调查");
            swfPathLog.setModelNo(swf.getModelNo());
            swfPathLog.setPathName("从 "+swfLogByFlowIdAndLogNo.getNodeName()+" 到 "+"调查");
            swfPathLogDao.save(swfPathLog);
            map.put("message","生成调查节点成功！");
        }

        if("4".equals(nodeStatus)){
            //第2次
            //开始节点即调查的节点
            SwfLog swflogs = swfLogDao.findSwfLogByFlowIdAndNodeType(flowId, "inves");
            //更新节点的状态 更新处理时间
            swfLogDao.updateSwfLogByRegistNoAndNodeStatus(registNo,sdf.format(new Date()));
            //SwfLog swfLogByNodeStatus = swfLogDao.findByFlowIdAndLogNo(flowId,maxLogNo);
            //查询除调查之外的最大节点
            SwfLog swfLogByNodeStatus=swfLogDao.findSwfLogByFlowId(flowId);
            //如果最大的节点的上一节点是调度不生成第二条线
            List<SwfLog> allByFlowIDAndLogNo = swfLogDao.findAllByFlowIDAndLogNo(flowId, swfLogByNodeStatus.getLogNo() - 1);
            if(allByFlowIDAndLogNo!=null&&allByFlowIDAndLogNo.size()>0){
                if(!"sched".equals(allByFlowIDAndLogNo.get(0).getNodeType())){
                    SwfPathLog swfPathLogs = new SwfPathLog();
                    swfPathLogs.setPathNo(maxPathNo+1);
                    swfPathLogs.setFlowId(flowId);
                    swfPathLogs.setStartNodeNo(swflogs.getLogNo());
                    swfPathLogs.setStartNodeName("调查");
                    swfPathLogs.setEndNodeNo(swfLogByNodeStatus.getLogNo());
                    swfPathLogs.setEndNodeName(swfLogByNodeStatus.getNodeName());
                    swfPathLogs.setModelNo(swf.getModelNo());
                    swfPathLogs.setPathName("从 "+"调查"+" 到 "+swfLogByNodeStatus.getNodeName());
                    swfPathLogDao.save(swfPathLogs);
                }
            }else{
                map.put("message","流程异常！");
                return map;
            }
            map.put("message","处理调查节点成功！");
        }
        return map;
    }
    /**
     * 发起调查
     * @author: 孙朋飞
     * @date: 2018/3/30 17:14
     * @param registNo 报案号
     * @param policyNo 保单号
     * @param nextHandlerCode 被调度人代码
     * @param nextHandlerName 被调度人姓名
     * @return 发起调查成功
     * @throws Exception
     */
    @Override
    public Map<String, String> submitInvestigation(String registNo,String policyNo,String nextHandlerCode,String nextHandlerName) throws Exception {
        if(StringUtils.isEmpty(registNo)){
            throw new BusinessException("报案号不能为空！");
        }
        //根据保单号查询金禾清单号
        List<InsureMainListDto> insureMainListDtos = insureMainListApi.queryByPolicyNo(policyNo);
        String gisInsureListCode="";
        if(insureMainListDtos!=null&&insureMainListDtos.size()>0){
            gisInsureListCode=insureMainListDtos.get(0).getGisInsureListCode();
        }
        //发起人姓名
        String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
        //发起人代码
        String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
        GYcoreUtil gYcoreUtil = new GYcoreUtil(gycoreService);
        AddSurveyTaskDto readyRegistInfo = new AddSurveyTaskDto();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //封装案件信息
        PrpLRegist byRegistNo = prpLRegistDao.findByRegistNo(registNo);

        readyRegistInfo.setRegistNo(byRegistNo.getRegistNo());
        readyRegistInfo.setRiskCode(byRegistNo.getRiskCode());
        //通过riskcode查询riskname
        String riskName = prpDriskApi.translateCodeByPK(byRegistNo.getRiskCode());
        readyRegistInfo.setRiskName(riskName);
        readyRegistInfo.setPolicyNo(byRegistNo.getPolicyNo());
        readyRegistInfo.setDamageStartDate(format.format(byRegistNo.getDamageStartDate()));
        readyRegistInfo.setDamageStartHour(byRegistNo.getDamageStartHour());
        readyRegistInfo.setDamageStartMinute("");
        readyRegistInfo.setDamageCode(byRegistNo.getDamageCode());
        readyRegistInfo.setDamageName(byRegistNo.getDamageName());
        readyRegistInfo.setDamageMessage("");
        readyRegistInfo.setReportorName(byRegistNo.getReportorName());
        readyRegistInfo.setReportDate(format.format(byRegistNo.getReportDate()));
        readyRegistInfo.setReportHour(byRegistNo.getReportHour());
        if(StringUtils.isEmpty(byRegistNo.getReportType())){
            readyRegistInfo.setReportType("");
        }else{
            readyRegistInfo.setReportType(byRegistNo.getReportType());
        }
        readyRegistInfo.setLinkerName(byRegistNo.getLinkerName());
        readyRegistInfo.setPhoneNumber(byRegistNo.getPhoneNumber());
        if(StringUtils.isEmpty(byRegistNo.getAddressCode())){
            readyRegistInfo.setAddressCode("");
        }else{
            readyRegistInfo.setAddressCode(byRegistNo.getAddressCode());
        }
        readyRegistInfo.setDamageAddress(byRegistNo.getDamageAddress());
        readyRegistInfo.setEstiCurrency(byRegistNo.getEsticurrency());
        readyRegistInfo.setEstimateLoss(byRegistNo.getEstimateLoss().toString());
        readyRegistInfo.setLossName(byRegistNo.getLossName());
        //事故者信息
        readyRegistInfo.setAcciPersonDtoList("");
        readyRegistInfo.setOperatorCode(SinoRequestContext.getCurrentContext().getUser().getUserCode());
        readyRegistInfo.setOperatorName(SinoRequestContext.getCurrentContext().getUser().getUserName());
        readyRegistInfo.setMakeCom(byRegistNo.getMakeCom());
        readyRegistInfo.setMakeComName(SinoRequestContext.getCurrentContext().getUser().getLoginComCode());
        if(StringUtils.isEmpty(readyRegistInfo.getRemark())){
            readyRegistInfo.setRemark("");
        }else{
            readyRegistInfo.setRemark(byRegistNo.getRemark());
        }
        //出险摘要
        readyRegistInfo.setTextContext("");
        if(StringUtils.isEmpty(byRegistNo.getCatastropheCode1())){
            readyRegistInfo.setCatastropheCode1("");
        }else{
            readyRegistInfo.setCatastropheCode1(byRegistNo.getCatastropheCode1());
        }
        if(StringUtils.isEmpty(byRegistNo.getCatastropheName1())){
            readyRegistInfo.setCatastropheName1("");
        }else{
            readyRegistInfo.setCatastropheName1(byRegistNo.getCatastropheName1());
        }
        if(StringUtils.isEmpty(byRegistNo.getCatastropheCode2())){
            readyRegistInfo.setCatastropheCode2("");
        }else{
            readyRegistInfo.setCatastropheCode2(byRegistNo.getCatastropheCode2());
        }
        if(StringUtils.isEmpty(byRegistNo.getCatastropheName2())){
            readyRegistInfo.setCatastropheName2("");
        }else{
            readyRegistInfo.setCatastropheName2(byRegistNo.getCatastropheName2());
        }
        readyRegistInfo.setInsuranceListCode(gisInsureListCode);
        readyRegistInfo.setOpUserCode(SinoRequestContext.getCurrentContext().getUser().getUserCode());
        readyRegistInfo.setOpUserName(SinoRequestContext.getCurrentContext().getUser().getUserName());
        if(StringUtils.isEmpty(nextHandlerCode)){
            readyRegistInfo.setAdjustUserCode("");
        }else{
            readyRegistInfo.setAdjustUserCode(nextHandlerCode);
        }
        if(StringUtils.isEmpty(nextHandlerName)){
            readyRegistInfo.setAdjustUserName("");
        }else{
            readyRegistInfo.setAdjustUserName(nextHandlerName);
        }

        //根据报案号查询案件信息
        String xml=gYcoreUtil.addSurveyTask(readyRegistInfo);
        Map<String, String> returnMap=new HashMap<>();
        if(StringUtils.isEmpty(xml)){
            returnMap.put("message","案件信息推送成功！");
        }else{
            returnMap.put("message",xml);
        }
        return returnMap;
    }

}