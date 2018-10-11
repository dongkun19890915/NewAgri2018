package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 工作流表Api操作对象
 */
public class WfLogDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性工作流号/工作流号 */
	private String flowid ;		
	/** 属性序号/序号 */
	private Integer logno ;
	/** 属性模板号/模板号 */
	private Integer modelno ;
	/** 属性当前节点号/当前节点号 */
	private Integer nodeno ;
	/** 属性当前节点名称/当前节点名称 */
	private String nodeName ;		
	/** 属性处理部门代码/处理部门代码 */
	private String deptCode ;		
	/** 属性部门名称/部门名称 */
	private String deptName ;		
	/** 属性处理人员代码/处理人员代码 */
	private String operatorCode ;		
	/** 属性处理人员名称/处理人员名称 */
	private String operatorName ;		
	/** 属性流入时间（日志生成时间）/流入时间（日志生成时间） */
	private String flowinTime ;		
	/** 属性处理时限/处理时限 */
	private Integer timeLimit ;
	/** 属性处理时间/处理时间 */
	private String handleTime ;		
	/** 属性提交时间/提交时间 */
	private String submitTime ;		
	/** 属性节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭/节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭 */
	private String nodeStatus ;		
	/** 属性0:正常流转 1:回退/0:正常流转 1:回退 */
	private String flowStatus ;		
	/** 属性明细信息包ID/明细信息包ID */
	private String packageid ;		
	/** 属性业务类型 T:投保单P:保单E:批单Y:预赔C:计算书/业务类型 T:投保单P:保单E:批单Y:预赔C:计算书 */
	private String businessType ;		
	/** 属性业务号/业务号 */
	private String businessno ;		
	/** 属性合同号 车队合同号 统括合同号/合同号 车队合同号 统括合同号 */
	private String contractno ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性出单机构/出单机构 */
	private String makeCom ;		
	/** 属性归属部门/归属部门 */
	private String comCode ;		
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;		
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code ;		
	/** 属性相关工作流号/相关工作流号 */
	private String relateFlowid ;		
	/** 属性相关工作流序号/相关工作流序号 */
	private Integer relateLogno ;
	/** 属性节点X坐标/节点X坐标 */
	private Integer posx ;
	/** 属性节点Y坐标/节点Y坐标 */
	private Integer posy ;
	/** 属性备用标志/备用标志 */
	private String flag ;		
	/** 属性车牌号/车牌号 */
	private String licenseno ;		
	/** 属性Relatecontractno/Relatecontractno */
	private String relatecontractno ;		
	/** 属性Riskcategory/Riskcategory */
	private String riskCategory ;		
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;		
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;		
	/** 属性证件类型/证件类型 */
	private String identifyType ;		
	/** 属性证件号码/证件号码 */
	private String identifyNumber ;		
	/** 属性Reinsstatus/Reinsstatus */
	private String reinsStatus ;		
	/** 属性保单号/保单号 */
	private String policyno ;		
	/** 属性立案号/立案号 */
	private String claimno ;		
	/** 属性Billno/Billno */
	private String billno ;		
	/** 属性Billnoflag/Billnoflag */
	private String billnoFlag ;		
	/** 属性Medicaltransitflag/Medicaltransitflag */
	private  String medicaltransitFlag ;

	/** 属性createDBy/createDBy */
	private String createDBy ;
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;

	public String getCreateDBy() {
		return createDBy;
	}

	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}

	public Date getCreateDTime() {
		return createDTime;
	}

	public void setCreateDTime(Date createDTime) {
		this.createDTime = createDTime;
	}

	public String getUpdateDBy() {
		return updateDBy;
	}

	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}

	public Date getUpdateDTime() {
		return updateDTime;
	}

	public void setUpdateDTime(Date updateDTime) {
		this.updateDTime = updateDTime;
	}

	/**
	 * 属性工作流号/工作流号的getter方法
	 */
	public String getFlowid() {
		return flowid;
	}
	/**
	 * 属性工作流号/工作流号的setter方法
	 */
	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getLogno() {
		return logno;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setLogno(Integer logno) {
		this.logno = logno;
	}	
	/**
	 * 属性模板号/模板号的getter方法
	 */
	public Integer getModelno() {
		return modelno;
	}
	/**
	 * 属性模板号/模板号的setter方法
	 */
	public void setModelno(Integer modelno) {
		this.modelno = modelno;
	}	
	/**
	 * 属性当前节点号/当前节点号的getter方法
	 */
	public Integer getNodeno() {
		return nodeno;
	}
	/**
	 * 属性当前节点号/当前节点号的setter方法
	 */
	public void setNodeno(Integer nodeno) {
		this.nodeno = nodeno;
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
	 * 属性处理部门代码/处理部门代码的getter方法
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * 属性处理部门代码/处理部门代码的setter方法
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
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
	 * 属性处理人员代码/处理人员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性处理人员代码/处理人员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性处理人员名称/处理人员名称的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性处理人员名称/处理人员名称的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}	
	/**
	 * 属性流入时间（日志生成时间）/流入时间（日志生成时间）的getter方法
	 */
	public String getFlowinTime() {
		return flowinTime;
	}
	/**
	 * 属性流入时间（日志生成时间）/流入时间（日志生成时间）的setter方法
	 */
	public void setFlowinTime(String flowinTime) {
		this.flowinTime = flowinTime;
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
	 * 属性节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭/节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭的getter方法
	 */
	public String getNodeStatus() {
		return nodeStatus;
	}
	/**
	 * 属性节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭/节点状态 1:待处理2:正在处理3:已处理未提交 4:已提交0:已关闭的setter方法
	 */
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}	
	/**
	 * 属性0:正常流转 1:回退/0:正常流转 1:回退的getter方法
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 属性0:正常流转 1:回退/0:正常流转 1:回退的setter方法
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}	
	/**
	 * 属性明细信息包ID/明细信息包ID的getter方法
	 */
	public String getPackageid() {
		return packageid;
	}
	/**
	 * 属性明细信息包ID/明细信息包ID的setter方法
	 */
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}	
	/**
	 * 属性业务类型 T:投保单P:保单E:批单Y:预赔C:计算书/业务类型 T:投保单P:保单E:批单Y:预赔C:计算书的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性业务类型 T:投保单P:保单E:批单Y:预赔C:计算书/业务类型 T:投保单P:保单E:批单Y:预赔C:计算书的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessno() {
		return businessno;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}	
	/**
	 * 属性合同号 车队合同号 统括合同号/合同号 车队合同号 统括合同号的getter方法
	 */
	public String getContractno() {
		return contractno;
	}
	/**
	 * 属性合同号 车队合同号 统括合同号/合同号 车队合同号 统括合同号的setter方法
	 */
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}	
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
	 * 属性出单机构/出单机构的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性出单机构/出单机构的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}	
	/**
	 * 属性归属部门/归属部门的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属部门/归属部门的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性经办人代码/经办人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性经办人代码/经办人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性归属业务员代码/归属业务员代码的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的setter方法
	 */
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}	
	/**
	 * 属性相关工作流号/相关工作流号的getter方法
	 */
	public String getRelateFlowid() {
		return relateFlowid;
	}
	/**
	 * 属性相关工作流号/相关工作流号的setter方法
	 */
	public void setRelateFlowid(String relateFlowid) {
		this.relateFlowid = relateFlowid;
	}	
	/**
	 * 属性相关工作流序号/相关工作流序号的getter方法
	 */
	public Integer getRelateLogno() {
		return relateLogno;
	}
	/**
	 * 属性相关工作流序号/相关工作流序号的setter方法
	 */
	public void setRelateLogno(Integer relateLogno) {
		this.relateLogno = relateLogno;
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
	 * 属性车牌号/车牌号的getter方法
	 */
	public String getLicenseno() {
		return licenseno;
	}
	/**
	 * 属性车牌号/车牌号的setter方法
	 */
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}	
	/**
	 * 属性Relatecontractno/Relatecontractno的getter方法
	 */
	public String getRelatecontractno() {
		return relatecontractno;
	}
	/**
	 * 属性Relatecontractno/Relatecontractno的setter方法
	 */
	public void setRelatecontractno(String relatecontractno) {
		this.relatecontractno = relatecontractno;
	}	
	/**
	 * 属性Riskcategory/Riskcategory的getter方法
	 */
	public String getRiskCategory() {
		return riskCategory;
	}
	/**
	 * 属性Riskcategory/Riskcategory的setter方法
	 */
	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}	
	/**
	 * 属性被保险人代码/被保险人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性被保险人代码/被保险人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
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
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性Reinsstatus/Reinsstatus的getter方法
	 */
	public String getReinsStatus() {
		return reinsStatus;
	}
	/**
	 * 属性Reinsstatus/Reinsstatus的setter方法
	 */
	public void setReinsStatus(String reinsStatus) {
		this.reinsStatus = reinsStatus;
	}	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyno() {
		return policyno;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}	
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimno() {
		return claimno;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimno(String claimno) {
		this.claimno = claimno;
	}	
	/**
	 * 属性Billno/Billno的getter方法
	 */
	public String getBillno() {
		return billno;
	}
	/**
	 * 属性Billno/Billno的setter方法
	 */
	public void setBillno(String billno) {
		this.billno = billno;
	}	
	/**
	 * 属性Billnoflag/Billnoflag的getter方法
	 */
	public String getBillnoFlag() {
		return billnoFlag;
	}
	/**
	 * 属性Billnoflag/Billnoflag的setter方法
	 */
	public void setBillnoFlag(String billnoFlag) {
		this.billnoFlag = billnoFlag;
	}

	public String getMedicaltransitFlag() {
		return medicaltransitFlag;
	}

	public void setMedicaltransitFlag(String medicaltransitFlag) {
		this.medicaltransitFlag = medicaltransitFlag;
	}
}
