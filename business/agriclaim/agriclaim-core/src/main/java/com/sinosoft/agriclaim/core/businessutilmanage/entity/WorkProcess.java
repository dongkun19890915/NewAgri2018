package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * 工作流程表实体操作对象
 */
@Entity
@Table(name = "WorkProcess")
@IdClass(WorkProcessKey.class)
public class WorkProcess extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	@Id
	@Column(name = "id")
	private Integer id ;/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性赔款计算书号/赔款计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性结案号/结案号 */
	@Column(name = "caseNo")
	private String caseNo ;
	/** 属性流程号/流程号 */
	@Column(name = "flowId")
	private String flowId ;
	/** 属性预赔号/预赔号 */
	@Column(name = "preCompensateNo")
	private String preCompensateNo ;
	/** 属性当前节点代码/当前节点代码 */
	@Column(name = "nodeType")
	private String nodeType ;
	/** 属性当前节点/当前节点 */
	@Column(name = "nodeName")
	private String nodeName ;
	/** 属性下一个节点名称/下一个节点名称 */
	@Column(name = "nextNodeType")
	private String nextNodeType ;
	/** 属性险种大类/险种大类 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性当前状态/当前状态 */
	@Column(name = "nodeStatus")
	private String nodeStatus ;
	/** 属性案件状态/案件状态 */
	@Column(name = "caseType")
	private String caseType ;
	/** 属性报案流入时间/报案流入时间 */
	@Column(name = "registFlowInTime")
	private String registFlowInTime ;
	/** 属性最新节点流入时间/最新节点流入时间 */
	@Column(name = "flowInTime")
	private String flowInTime ;
	/** 属性操作人/操作人 */
	@Column(name = "operator")
	private String operator ;
	/** 属性操作时间/操作时间 */
	@Column(name = "operateDate")
	private Date operateDate ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(Integer id) {
		this.id = id;
	} 	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 	
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 	
	/**
	 * 属性结案号/结案号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性结案号/结案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	} 	
	/**
	 * 属性流程号/流程号的getter方法
	 */
	public String getFlowId() {
		return flowId;
	}
	/**
	 * 属性流程号/流程号的setter方法
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	} 	
	/**
	 * 属性预赔号/预赔号的getter方法
	 */
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	/**
	 * 属性预赔号/预赔号的setter方法
	 */
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	} 	
	/**
	 * 属性当前节点代码/当前节点代码的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性当前节点代码/当前节点代码的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性当前节点/当前节点的getter方法
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 属性当前节点/当前节点的setter方法
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	} 	
	/**
	 * 属性下一个节点名称/下一个节点名称的getter方法
	 */
	public String getNextNodeType() {
		return nextNodeType;
	}
	/**
	 * 属性下一个节点名称/下一个节点名称的setter方法
	 */
	public void setNextNodeType(String nextNodeType) {
		this.nextNodeType = nextNodeType;
	} 	
	/**
	 * 属性险种大类/险种大类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险种大类/险种大类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性当前状态/当前状态的getter方法
	 */
	public String getNodeStatus() {
		return nodeStatus;
	}
	/**
	 * 属性当前状态/当前状态的setter方法
	 */
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	} 	
	/**
	 * 属性案件状态/案件状态的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性案件状态/案件状态的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	} 	
	/**
	 * 属性报案流入时间/报案流入时间的getter方法
	 */
	public String getRegistFlowInTime() {
		return registFlowInTime;
	}
	/**
	 * 属性报案流入时间/报案流入时间的setter方法
	 */
	public void setRegistFlowInTime(String registFlowInTime) {
		this.registFlowInTime = registFlowInTime;
	} 	
	/**
	 * 属性最新节点流入时间/最新节点流入时间的getter方法
	 */
	public String getFlowInTime() {
		return flowInTime;
	}
	/**
	 * 属性最新节点流入时间/最新节点流入时间的setter方法
	 */
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	} 	
	/**
	 * 属性操作人/操作人的getter方法
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 属性操作人/操作人的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	} 	
	/**
	 * 属性操作时间/操作时间的getter方法
	 */
	public Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	} 	
}