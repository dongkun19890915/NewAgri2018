package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（SwfLog与SwfLogStore表的综合类，字段相同，用来转存分别来自两个Dao的数据）
* @Author: 王志文
* @Date: 2017/12/6 9:16
*/
public class SwfLogEndCaseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性流程编号/流程编号 */
    private String flowId ;
    /** 属性序号/序号 */
    private Integer logNo ;
    /** 属性模板号/模板号 */
    private Integer modelNo ;
    /** 属性当前节点号/当前节点号 */
    private Integer nodeNo ;
    /** 属性当前节点名称/当前节点名称 */
    private String nodeName ;
    /** 属性业务号(赔款计算书号)/业务号(赔款计算书号) */
    private String businessNo ;
    /** 属性处理部门/处理部门 */
    private String handleDept ;
    /** 属性处理人员代码/处理人员代码 */
    private String handlerCode ;
    /** 属性处理人员名称/处理人员名称 */
    private String handlerName ;
    /** 属性流入时间/流入时间 */
    private String flowInTime ;
    /** 属性处理时限/处理时限 */
    private Integer timeLimit ;
    /** 属性处理时间/处理时间 */
    private String handleTime ;
    /** 属性提交时间/提交时间 */
    private String submitTime ;
    /** 属性节点状态/节点状态 */
    private String nodeStatus ;
    /** 属性流状态/流状态 */
    private String flowStatus ;
    /** 属性明细信息包ID/明细信息包ID */
    private String packageId ;
    /** 属性备用标志/备用标志 */
    private String flag ;
    /** 属性任务编号/任务编号 */
    private Integer taskNo ;
    /** 属性任务类型/任务类型 */
    private String taskType ;
    /** 属性节点类型/节点类型 */
    private String nodeType ;
    /** 属性任务备注/任务备注 */
    private String titleStr ;
    /** 属性业务类型/业务类型 */
    private String businessType ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性任务接收载体键值/任务接收载体键值 */
    private String keyIn ;
    /** 属性记录流出时的业务编码/记录流出时的业务编码 */
    private String keyOut ;
    /** 属性部门名称/部门名称 */
    private String deptName ;
    /** 属性主流程编号/主流程编号 */
    private String mainFlowId ;
    /** 属性子流程编号/子流程编号 */
    private String subFlowId ;
    /** 属性节点X坐标/节点X坐标 */
    private Integer posx ;
    /** 属性节点Y坐标/节点Y坐标 */
    private Integer posy ;
    /** 属性结束标志/结束标志 */
    private String endFlag ;
    /** 属性上个处理人员代码/上个处理人员代码 */
    private String beforeHandlerCode ;
    /** 属性上个处理人员名称/上个处理人员名称 */
    private String beforeHandlerName ;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性类型标志/类型标志 */
    private String typeFlag ;
    /** 属性归属机构/归属机构 */
    private String comCode ;
    /** 属性调度号码/调度号码 */
    private Integer scheduleId ;
    /** 属性标的序号/标的序号 */
    private String lossitemCode ;
    /** 属性车牌号码/车牌号码 */
    private String lossitemName ;
    /** 属性是否为本保单车辆/是否为本保单车辆 */
    private String insurecarFlag ;
    /** 属性可操作/处理的级别/可操作/处理的级别 */
    private String handlerRange ;
    /** 属性紧急程度/紧急程度 */
    private String exigenceGree ;
    /** 属性被保险人名称/被保险人名称 */
    private String insuredName ;
    /** 属性报案号码/报案号码 */
    private String registNo ;
    /** 属性新老系统数据标志 1：新系统数据  null：表示老系统数据/新老系统数据标志 1：新系统数据  null：表示老系统数据 */
    private String dataFlag ;
    /** 属性医疗/医疗 */
    private String medicalTransitFlag ;
    /** 属性修改人/修改人 */
    private String updateBy ;
    /** 属性修改时间/修改时间 */
    private java.util.Date updateDate ;
    /** 属性空表示电脑端，2表示手机端/空表示电脑端，2表示手机端 */
    private String workPlatForm ;
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /**
     * 属性流程编号/流程编号的getter方法
     */
    public String getFlowId() {
        return flowId;
    }
    /**
     * 属性流程编号/流程编号的setter方法
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
    /**
     * 属性序号/序号的getter方法
     */
    public Integer getLogNo() {
        return logNo;
    }
    /**
     * 属性序号/序号的setter方法
     */
    public void setLogNo(Integer logNo) {
        this.logNo = logNo;
    }
    /**
     * 属性模板号/模板号的getter方法
     */
    public Integer getModelNo() {
        return modelNo;
    }
    /**
     * 属性模板号/模板号的setter方法
     */
    public void setModelNo(Integer modelNo) {
        this.modelNo = modelNo;
    }
    /**
     * 属性当前节点号/当前节点号的getter方法
     */
    public Integer getNodeNo() {
        return nodeNo;
    }
    /**
     * 属性当前节点号/当前节点号的setter方法
     */
    public void setNodeNo(Integer nodeNo) {
        this.nodeNo = nodeNo;
    }
    /**
     * 属性当前节点名称/当前节点名称的getter方法
     */
    public String getNodeName() {
        return nodeName;
    }
    /**
     * 属性当前节点名称/当前节点名称的setter方法
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    /**
     * 属性业务号(赔款计算书号)/业务号(赔款计算书号)的getter方法
     */
    public String getBusinessNo() {
        return businessNo;
    }
    /**
     * 属性业务号(赔款计算书号)/业务号(赔款计算书号)的setter方法
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
    /**
     * 属性处理部门/处理部门的getter方法
     */
    public String getHandleDept() {
        return handleDept;
    }
    /**
     * 属性处理部门/处理部门的setter方法
     */
    public void setHandleDept(String handleDept) {
        this.handleDept = handleDept;
    }
    /**
     * 属性处理人员代码/处理人员代码的getter方法
     */
    public String getHandlerCode() {
        return handlerCode;
    }
    /**
     * 属性处理人员代码/处理人员代码的setter方法
     */
    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }
    /**
     * 属性处理人员名称/处理人员名称的getter方法
     */
    public String getHandlerName() {
        return handlerName;
    }
    /**
     * 属性处理人员名称/处理人员名称的setter方法
     */
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }
    /**
     * 属性流入时间/流入时间的getter方法
     */
    public String getFlowInTime() {
        return flowInTime;
    }
    /**
     * 属性流入时间/流入时间的setter方法
     */
    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }
    /**
     * 属性处理时限/处理时限的getter方法
     */
    public Integer getTimeLimit() {
        return timeLimit;
    }
    /**
     * 属性处理时限/处理时限的setter方法
     */
    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }
    /**
     * 属性处理时间/处理时间的getter方法
     */
    public String getHandleTime() {
        return handleTime;
    }
    /**
     * 属性处理时间/处理时间的setter方法
     */
    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }
    /**
     * 属性提交时间/提交时间的getter方法
     */
    public String getSubmitTime() {
        return submitTime;
    }
    /**
     * 属性提交时间/提交时间的setter方法
     */
    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
    /**
     * 属性节点状态/节点状态的getter方法
     */
    public String getNodeStatus() {
        return nodeStatus;
    }
    /**
     * 属性节点状态/节点状态的setter方法
     */
    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }
    /**
     * 属性流状态/流状态的getter方法
     */
    public String getFlowStatus() {
        return flowStatus;
    }
    /**
     * 属性流状态/流状态的setter方法
     */
    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }
    /**
     * 属性明细信息包ID/明细信息包ID的getter方法
     */
    public String getPackageId() {
        return packageId;
    }
    /**
     * 属性明细信息包ID/明细信息包ID的setter方法
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    /**
     * 属性备用标志/备用标志的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性备用标志/备用标志的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性任务编号/任务编号的getter方法
     */
    public Integer getTaskNo() {
        return taskNo;
    }
    /**
     * 属性任务编号/任务编号的setter方法
     */
    public void setTaskNo(Integer taskNo) {
        this.taskNo = taskNo;
    }
    /**
     * 属性任务类型/任务类型的getter方法
     */
    public String getTaskType() {
        return taskType;
    }
    /**
     * 属性任务类型/任务类型的setter方法
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    /**
     * 属性节点类型/节点类型的getter方法
     */
    public String getNodeType() {
        return nodeType;
    }
    /**
     * 属性节点类型/节点类型的setter方法
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    /**
     * 属性任务备注/任务备注的getter方法
     */
    public String getTitleStr() {
        return titleStr;
    }
    /**
     * 属性任务备注/任务备注的setter方法
     */
    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }
    /**
     * 属性业务类型/业务类型的getter方法
     */
    public String getBusinessType() {
        return businessType;
    }
    /**
     * 属性业务类型/业务类型的setter方法
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    /**
     * 属性险种代码/险种代码的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }
    /**
     * 属性险种代码/险种代码的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
    /**
     * 属性任务接收载体键值/任务接收载体键值的getter方法
     */
    public String getKeyIn() {
        return keyIn;
    }
    /**
     * 属性任务接收载体键值/任务接收载体键值的setter方法
     */
    public void setKeyIn(String keyIn) {
        this.keyIn = keyIn;
    }
    /**
     * 属性记录流出时的业务编码/记录流出时的业务编码的getter方法
     */
    public String getKeyOut() {
        return keyOut;
    }
    /**
     * 属性记录流出时的业务编码/记录流出时的业务编码的setter方法
     */
    public void setKeyOut(String keyOut) {
        this.keyOut = keyOut;
    }
    /**
     * 属性部门名称/部门名称的getter方法
     */
    public String getDeptName() {
        return deptName;
    }
    /**
     * 属性部门名称/部门名称的setter方法
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    /**
     * 属性主流程编号/主流程编号的getter方法
     */
    public String getMainFlowId() {
        return mainFlowId;
    }
    /**
     * 属性主流程编号/主流程编号的setter方法
     */
    public void setMainFlowId(String mainFlowId) {
        this.mainFlowId = mainFlowId;
    }
    /**
     * 属性子流程编号/子流程编号的getter方法
     */
    public String getSubFlowId() {
        return subFlowId;
    }
    /**
     * 属性子流程编号/子流程编号的setter方法
     */
    public void setSubFlowId(String subFlowId) {
        this.subFlowId = subFlowId;
    }
    /**
     * 属性节点X坐标/节点X坐标的getter方法
     */
    public Integer getPosx() {
        return posx;
    }
    /**
     * 属性节点X坐标/节点X坐标的setter方法
     */
    public void setPosx(Integer posx) {
        this.posx = posx;
    }
    /**
     * 属性节点Y坐标/节点Y坐标的getter方法
     */
    public Integer getPosy() {
        return posy;
    }
    /**
     * 属性节点Y坐标/节点Y坐标的setter方法
     */
    public void setPosy(Integer posy) {
        this.posy = posy;
    }
    /**
     * 属性结束标志/结束标志的getter方法
     */
    public String getEndFlag() {
        return endFlag;
    }
    /**
     * 属性结束标志/结束标志的setter方法
     */
    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
    }
    /**
     * 属性上个处理人员代码/上个处理人员代码的getter方法
     */
    public String getBeforeHandlerCode() {
        return beforeHandlerCode;
    }
    /**
     * 属性上个处理人员代码/上个处理人员代码的setter方法
     */
    public void setBeforeHandlerCode(String beforeHandlerCode) {
        this.beforeHandlerCode = beforeHandlerCode;
    }
    /**
     * 属性上个处理人员名称/上个处理人员名称的getter方法
     */
    public String getBeforeHandlerName() {
        return beforeHandlerName;
    }
    /**
     * 属性上个处理人员名称/上个处理人员名称的setter方法
     */
    public void setBeforeHandlerName(String beforeHandlerName) {
        this.beforeHandlerName = beforeHandlerName;
    }
    /**
     * 属性保单号码/保单号码的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性保单号码/保单号码的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性类型标志/类型标志的getter方法
     */
    public String getTypeFlag() {
        return typeFlag;
    }
    /**
     * 属性类型标志/类型标志的setter方法
     */
    public void setTypeFlag(String typeFlag) {
        this.typeFlag = typeFlag;
    }
    /**
     * 属性归属机构/归属机构的getter方法
     */
    public String getComCode() {
        return comCode;
    }
    /**
     * 属性归属机构/归属机构的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
    /**
     * 属性调度号码/调度号码的getter方法
     */
    public Integer getScheduleId() {
        return scheduleId;
    }
    /**
     * 属性调度号码/调度号码的setter方法
     */
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
    /**
     * 属性标的序号/标的序号的getter方法
     */
    public String getLossitemCode() {
        return lossitemCode;
    }
    /**
     * 属性标的序号/标的序号的setter方法
     */
    public void setLossitemCode(String lossitemCode) {
        this.lossitemCode = lossitemCode;
    }
    /**
     * 属性车牌号码/车牌号码的getter方法
     */
    public String getLossitemName() {
        return lossitemName;
    }
    /**
     * 属性车牌号码/车牌号码的setter方法
     */
    public void setLossitemName(String lossitemName) {
        this.lossitemName = lossitemName;
    }
    /**
     * 属性是否为本保单车辆/是否为本保单车辆的getter方法
     */
    public String getInsurecarFlag() {
        return insurecarFlag;
    }
    /**
     * 属性是否为本保单车辆/是否为本保单车辆的setter方法
     */
    public void setInsurecarFlag(String insurecarFlag) {
        this.insurecarFlag = insurecarFlag;
    }
    /**
     * 属性可操作/处理的级别/可操作/处理的级别的getter方法
     */
    public String getHandlerRange() {
        return handlerRange;
    }
    /**
     * 属性可操作/处理的级别/可操作/处理的级别的setter方法
     */
    public void setHandlerRange(String handlerRange) {
        this.handlerRange = handlerRange;
    }
    /**
     * 属性紧急程度/紧急程度的getter方法
     */
    public String getExigenceGree() {
        return exigenceGree;
    }
    /**
     * 属性紧急程度/紧急程度的setter方法
     */
    public void setExigenceGree(String exigenceGree) {
        this.exigenceGree = exigenceGree;
    }
    /**
     * 属性被保险人名称/被保险人名称的getter方法
     */
    public String getInsuredName() {
        return insuredName;
    }
    /**
     * 属性被保险人名称/被保险人名称的setter方法
     */
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    /**
     * 属性报案号码/报案号码的getter方法
     */
    public String getRegistNo() {
        return registNo;
    }
    /**
     * 属性报案号码/报案号码的setter方法
     */
    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }
    /**
     * 属性新老系统数据标志 1：新系统数据  null：表示老系统数据/新老系统数据标志 1：新系统数据  null：表示老系统数据的getter方法
     */
    public String getDataFlag() {
        return dataFlag;
    }
    /**
     * 属性新老系统数据标志 1：新系统数据  null：表示老系统数据/新老系统数据标志 1：新系统数据  null：表示老系统数据的setter方法
     */
    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }
    /**
     * 属性医疗/医疗的getter方法
     */
    public String getMedicalTransitFlag() {
        return medicalTransitFlag;
    }
    /**
     * 属性医疗/医疗的setter方法
     */
    public void setMedicalTransitFlag(String medicalTransitFlag) {
        this.medicalTransitFlag = medicalTransitFlag;
    }
    /**
     * 属性修改人/修改人的getter方法
     */
    public String getUpdateBy() {
        return updateBy;
    }
    /**
     * 属性修改人/修改人的setter方法
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    /**
     * 属性修改时间/修改时间的getter方法
     */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 属性修改时间/修改时间的setter方法
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * 属性空表示电脑端，2表示手机端/空表示电脑端，2表示手机端的getter方法
     */
    public String getWorkPlatForm() {
        return workPlatForm;
    }
    /**
     * 属性空表示电脑端，2表示手机端/空表示电脑端，2表示手机端的setter方法
     */
    public void setWorkPlatForm(String workPlatForm) {
        this.workPlatForm = workPlatForm;
    }

    public String getLossItemCode() {
        return lossItemCode;
    }

    public void setLossItemCode(String lossItemCode) {
        this.lossItemCode = lossItemCode;
    }

    public String getLossItemName() {
        return lossItemName;
    }

    public void setLossItemName(String lossItemName) {
        this.lossItemName = lossItemName;
    }
}