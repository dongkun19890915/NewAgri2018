package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:17:47.442 
 * 自动理赔清单数据表实体操作对象
 */
@Entity
@Table(name = "PrpLAutoClaimList")
@IdClass(PrpLAutoClaimListKey.class)
public class PrpLAutoClaimList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;	
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性流程编号/流程编号 */
	@Column(name = "flowId")
	private String flowId ;
	/** 属性流入节点号/流入节点号 */
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;
	/** 属性流入节点名称/流入节点名称 */
	@Column(name = "nodeName")
	private String nodeName ;
	/** 属性节点开始标志/节点开始标志 */
	@Column(name = "nodeStartFlag")
	private String nodeStartFlag ;
	/** 属性定损清单清单号/定损清单清单号 */
	@Column(name = "billNo")
	private String billNo ;
	/** 属性是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）/是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能） */
	@Column(name = "autoFlag")
	private String autoFlag ;
	/** 属性自动理赔是否完成(1完成,0失败)/自动理赔是否完成(1完成,0失败) */
	@Column(name = "finishFlag")
	private String finishFlag ;
	/** 属性自动理赔失败原因/自动理赔失败原因 */
	@Column(name = "falseReason")
	private String falseReason ;
	/** 属性预留字段1/预留字段1 */
	@Column(name = "remark1")
	private String remark1 ;
	/** 属性预留字段2/预留字段2 */
	@Column(name = "remark2")
	private String remark2 ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;




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
	 * 属性流入节点号/流入节点号的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性流入节点号/流入节点号的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 	
	/**
	 * 属性流入节点名称/流入节点名称的getter方法
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 属性流入节点名称/流入节点名称的setter方法
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	} 	
	/**
	 * 属性节点开始标志/节点开始标志的getter方法
	 */
	public String getNodeStartFlag() {
		return nodeStartFlag;
	}
	/**
	 * 属性节点开始标志/节点开始标志的setter方法
	 */
	public void setNodeStartFlag(String nodeStartFlag) {
		this.nodeStartFlag = nodeStartFlag;
	} 	
	/**
	 * 属性定损清单清单号/定损清单清单号的getter方法
	 */
	public String getBillNo() {
		return billNo;
	}
	/**
	 * 属性定损清单清单号/定损清单清单号的setter方法
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	} 	
	/**
	 * 属性是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）/是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）的getter方法
	 */
	public String getAutoFlag() {
		return autoFlag;
	}
	/**
	 * 属性是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）/是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）的setter方法
	 */
	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	} 	
	/**
	 * 属性自动理赔是否完成(1完成,0失败)/自动理赔是否完成(1完成,0失败)的getter方法
	 */
	public String getFinishFlag() {
		return finishFlag;
	}
	/**
	 * 属性自动理赔是否完成(1完成,0失败)/自动理赔是否完成(1完成,0失败)的setter方法
	 */
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	} 	
	/**
	 * 属性自动理赔失败原因/自动理赔失败原因的getter方法
	 */
	public String getFalseReason() {
		return falseReason;
	}
	/**
	 * 属性自动理赔失败原因/自动理赔失败原因的setter方法
	 */
	public void setFalseReason(String falseReason) {
		this.falseReason = falseReason;
	} 	
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	} 	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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
		
		
		
		
}