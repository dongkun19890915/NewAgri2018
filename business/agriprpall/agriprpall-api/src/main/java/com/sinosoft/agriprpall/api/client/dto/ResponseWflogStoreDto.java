package com.sinosoft.agriprpall.api.client.dto;

public class ResponseWflogStoreDto {

    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性任务状态 */
    private String nodeStatusName = "";
    /** 属性任务状态 */
    private String flowStatusName = "";
    /** 审批意见 */
    private String handleText = "";
    /** 用户代码 */
    private String userCode = "";

    /** 用于工作流状态查询字段 **/
    //工作流起始时间
    private String startTime = "";
    //工作流终止时间
    private String endTime = "";
    //流程图展现的Title
    private String title = "";
    //增加画矩形的Y轴坐标
    private int posY1 = 0;
    private int posY2 = 0;
    //增加画线的坐标
    private int startPosX = 0;
    private int startPosY = 0;
    private int endPosX = 0;
    private int endPosY = 0;
    //节点背景色
    private String nodeColor = "";
    //超时状态
    private String overTime = "";
    private String identifyType = null;
    private String identifyNumber = null;
    private String reinsStatus = null;
    private String policyNo = null;
    private String claimNo = null;
    private String comName = null;

    private String registNo = "";
    private String countRecoder ="";
    private String relatedBusinessno = "";//关联的businessno
    private String relatedPolicyNo = "";//关联保单号
    private String relatedClaimNo = "";//关联立案号
    private String relatedRiskCode = "";//关联险种代码
    private int nextNodeNo = 0;
    private String nextNodeName = null;
    private String amendRelateFlowID ="";
    private int amendRelateLogNo ;
    private String costTime = "";
    private double sumpaid = 0d;
    private String payName = "";
    private String acciName = "";

    private String medicalTransitFlag ;

    private String flowID = "";
    /** 属性序号 */
    private int logNo = 0;
    /** 属性模板号 */
    private int modelNo = 0;
    /** 属性节点号 */
    private int nodeNo = 0;
    /** 属性当前节点名称 */
    private String nodeName = "";
    /** 属性处理部门代码 */
    private String deptCode = "";
    /** 属性处理部门名称 */
    private String deptName = "";
    /** 属性处理人员代码 */
    private String operatorCode = "";
    /** 属性处理人员名称 */
    private String operatorName = "";
    /** 属性流入时间 */
    private String flowInTime = "";
    /** 属性处理时限 */
    private int timeLimit = 0;
    /** 属性处理时间 */
    private String handleTime = "";
    /** 属性提交时间 */
    private String submitTime = "";
    /** 属性节点状态 */
    private String nodeStatus = "";
    /** 属性流状态 */
    private String flowStatus = "";
    /** 属性明细信息包 */
    private String packageID = "";
    /** 属性业务类型 */
    private String businessType = "";
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性合同号 */
    private String contractNo = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性归属部门 */
    private String comCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性相关工作流号 */
    private String relateFlowID = "";
    /** 属性相关工作流序号 */
    private int relateLogNo = 0;
    /** 属性节点X坐标 */
    private int posX = 0;
    /** 属性节点Y坐标 */
    private int posY = 0;
    /** 属性标志 */
    private String flag = "";
    /** 属性状态明细类 */
    private String nodeDetailStatus = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性关联预约协议号 */
    private String relateContractNo = "";
    /** 属性险种大类代码 */
    private String riskCategory = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";

    public String getFlowID() {
        return flowID;
    }

    public void setFlowID(String flowID) {
        this.flowID = flowID;
    }

    public int getLogNo() {
        return logNo;
    }

    public void setLogNo(int logNo) {
        this.logNo = logNo;
    }

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public int getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(int nodeNo) {
        this.nodeNo = nodeNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getRelateFlowID() {
        return relateFlowID;
    }

    public void setRelateFlowID(String relateFlowID) {
        this.relateFlowID = relateFlowID;
    }

    public int getRelateLogNo() {
        return relateLogNo;
    }

    public void setRelateLogNo(int relateLogNo) {
        this.relateLogNo = relateLogNo;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getNodeDetailStatus() {
        return nodeDetailStatus;
    }

    public void setNodeDetailStatus(String nodeDetailStatus) {
        this.nodeDetailStatus = nodeDetailStatus;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getNodeStatusName() {
        return nodeStatusName;
    }

    public void setNodeStatusName(String nodeStatusName) {
        this.nodeStatusName = nodeStatusName;
    }

    public String getFlowStatusName() {
        return flowStatusName;
    }

    public void setFlowStatusName(String flowStatusName) {
        this.flowStatusName = flowStatusName;
    }

    public String getHandleText() {
        return handleText;
    }

    public void setHandleText(String handleText) {
        this.handleText = handleText;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosY1() {
        return posY1;
    }

    public void setPosY1(int posY1) {
        this.posY1 = posY1;
    }

    public int getPosY2() {
        return posY2;
    }

    public void setPosY2(int posY2) {
        this.posY2 = posY2;
    }

    public int getStartPosX() {
        return startPosX;
    }

    public void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public void setStartPosY(int startPosY) {
        this.startPosY = startPosY;
    }

    public int getEndPosX() {
        return endPosX;
    }

    public void setEndPosX(int endPosX) {
        this.endPosX = endPosX;
    }

    public int getEndPosY() {
        return endPosY;
    }

    public void setEndPosY(int endPosY) {
        this.endPosY = endPosY;
    }

    public String getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(String nodeColor) {
        this.nodeColor = nodeColor;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getRelateContractNo() {
        return relateContractNo;
    }

    public void setRelateContractNo(String relateContractNo) {
        this.relateContractNo = relateContractNo;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getReinsStatus() {
        return reinsStatus;
    }

    public void setReinsStatus(String reinsStatus) {
        this.reinsStatus = reinsStatus;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCountRecoder() {
        return countRecoder;
    }

    public void setCountRecoder(String countRecoder) {
        this.countRecoder = countRecoder;
    }

    public String getRelatedBusinessno() {
        return relatedBusinessno;
    }

    public void setRelatedBusinessno(String relatedBusinessno) {
        this.relatedBusinessno = relatedBusinessno;
    }

    public String getRelatedPolicyNo() {
        return relatedPolicyNo;
    }

    public void setRelatedPolicyNo(String relatedPolicyNo) {
        this.relatedPolicyNo = relatedPolicyNo;
    }

    public String getRelatedClaimNo() {
        return relatedClaimNo;
    }

    public void setRelatedClaimNo(String relatedClaimNo) {
        this.relatedClaimNo = relatedClaimNo;
    }

    public String getRelatedRiskCode() {
        return relatedRiskCode;
    }

    public void setRelatedRiskCode(String relatedRiskCode) {
        this.relatedRiskCode = relatedRiskCode;
    }

    public int getNextNodeNo() {
        return nextNodeNo;
    }

    public void setNextNodeNo(int nextNodeNo) {
        this.nextNodeNo = nextNodeNo;
    }

    public String getNextNodeName() {
        return nextNodeName;
    }

    public void setNextNodeName(String nextNodeName) {
        this.nextNodeName = nextNodeName;
    }

    public String getAmendRelateFlowID() {
        return amendRelateFlowID;
    }

    public void setAmendRelateFlowID(String amendRelateFlowID) {
        this.amendRelateFlowID = amendRelateFlowID;
    }

    public int getAmendRelateLogNo() {
        return amendRelateLogNo;
    }

    public void setAmendRelateLogNo(int amendRelateLogNo) {
        this.amendRelateLogNo = amendRelateLogNo;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public double getSumpaid() {
        return sumpaid;
    }

    public void setSumpaid(double sumpaid) {
        this.sumpaid = sumpaid;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getAcciName() {
        return acciName;
    }

    public void setAcciName(String acciName) {
        this.acciName = acciName;
    }

    public String getMedicalTransitFlag() {
        return medicalTransitFlag;
    }

    public void setMedicalTransitFlag(String medicalTransitFlag) {
        this.medicalTransitFlag = medicalTransitFlag;
    }
}
