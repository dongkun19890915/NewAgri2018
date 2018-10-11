package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单主表Api操作对象
 */
public class LossRateMainListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔损失清单编号/理赔损失清单编号 */
	private String lossListCode ;		
	/** 属性序列号/序列号 */
	private java.lang.Integer serialNo ;		
	/** 属性业务单号/业务单号 */
	private String bizNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性清单缮制时间/清单缮制时间 */
	private Date listCreateTime ;
	/** 属性清单缮制人工号/清单缮制人工号 */
	private String opCode ;		
	/** 属性清单缮制人姓名/清单缮制人姓名 */
	private String opName ;		
	/** 属性清单最终确认时间/清单最终确认时间 */
	private Date listAffirmTime ;
	/** 属性清单最终确认人代码/清单最终确认人代码 */
	private String affirmOpCode ;		
	/** 属性清单最终确认人姓名/清单最终确认人姓名 */
	private String affirmOpName ;
	/** 属性查勘地点/查勘地点 */
	private String exploreArea;
	/** 属性查勘时间/查勘时间 */
	private Date exploreTime;
	/** 属性备注/备注 */
	private String remark;
	/** 属性选择标识/选择标识 */
	private String checkBoxFlag;
	/** 属性导入来源：0 金禾导入，1 手工导入/导入来源：0 金禾导入，1 手工导入 */
	private String origin;
	/** 属性导入来源节点/导入来源节点 */
	private String nodeOrigin;
	//add by wxy 2018/4/10
	String checkId;         //查勘编号
	Double disasterArea;    //受灾面积
	Double affectedArea;    //成灾面积
	Double noProductionArea;//绝产面积
	Double deathQuantity;   //死亡数量
	Double killQuantity;    //扑杀数量
	String checkContext;    //查勘报告
	/**
	 * 属性理赔损失清单编号/理赔损失清单编号的getter方法
	 */
	public String getLossListCode() {
		return lossListCode;
	}
	/**
	 * 属性理赔损失清单编号/理赔损失清单编号的setter方法
	 */
	public void setLossListCode(String lossListCode) {
		this.lossListCode = lossListCode;
	}	
	/**
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性业务单号/业务单号的getter方法
	 */
	public String getBizNo() {
		return bizNo;
	}
	/**
	 * 属性业务单号/业务单号的setter方法
	 */
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
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
	 * 属性清单缮制时间/清单缮制时间的getter方法
	 */
	public Date getListCreateTime() {
		return listCreateTime;
	}
	/**
	 * 属性清单缮制时间/清单缮制时间的setter方法
	 */
	public void setListCreateTime(Date listCreateTime) {
		this.listCreateTime = listCreateTime;
	}	
	/**
	 * 属性清单缮制人工号/清单缮制人工号的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性清单缮制人工号/清单缮制人工号的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性清单缮制人姓名/清单缮制人姓名的getter方法
	 */
	public String getOpName() {
		return opName;
	}
	/**
	 * 属性清单缮制人姓名/清单缮制人姓名的setter方法
	 */
	public void setOpName(String opName) {
		this.opName = opName;
	}	
	/**
	 * 属性清单最终确认时间/清单最终确认时间的getter方法
	 */
	public Date getListAffirmTime() {
		return listAffirmTime;
	}
	/**
	 * 属性清单最终确认时间/清单最终确认时间的setter方法
	 */
	public void setListAffirmTime(Date listAffirmTime) {
		this.listAffirmTime = listAffirmTime;
	}	
	/**
	 * 属性清单最终确认人代码/清单最终确认人代码的getter方法
	 */
	public String getAffirmOpCode() {
		return affirmOpCode;
	}
	/**
	 * 属性清单最终确认人代码/清单最终确认人代码的setter方法
	 */
	public void setAffirmOpCode(String affirmOpCode) {
		this.affirmOpCode = affirmOpCode;
	}	
	/**
	 * 属性清单最终确认人姓名/清单最终确认人姓名的getter方法
	 */
	public String getAffirmOpName() {
		return affirmOpName;
	}
	/**
	 * 属性清单最终确认人姓名/清单最终确认人姓名的setter方法
	 */
	public void setAffirmOpName(String affirmOpName) {
		this.affirmOpName = affirmOpName;
	}

	public String getExploreArea() {
		return exploreArea;
	}

	public void setExploreArea(String exploreArea) {
		this.exploreArea = exploreArea;
	}

	public Date getExploreTime() {
		return exploreTime;
	}

	public void setExploreTime(Date exploreTime) {
		this.exploreTime = exploreTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCheckBoxFlag() {
		return checkBoxFlag;
	}

	public void setCheckBoxFlag(String checkBoxFlag) {
		this.checkBoxFlag = checkBoxFlag;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNodeOrigin() {
		return nodeOrigin;
	}

	public void setNodeOrigin(String nodeOrigin) {
		this.nodeOrigin = nodeOrigin;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public Double getDisasterArea() {
		return disasterArea;
	}

	public void setDisasterArea(Double disasterArea) {
		this.disasterArea = disasterArea;
	}

	public Double getAffectedArea() {
		return affectedArea;
	}

	public void setAffectedArea(Double affectedArea) {
		this.affectedArea = affectedArea;
	}

	public Double getNoProductionArea() {
		return noProductionArea;
	}

	public void setNoProductionArea(Double noProductionArea) {
		this.noProductionArea = noProductionArea;
	}

	public Double getDeathQuantity() {
		return deathQuantity;
	}

	public void setDeathQuantity(Double deathQuantity) {
		this.deathQuantity = deathQuantity;
	}

	public Double getKillQuantity() {
		return killQuantity;
	}

	public void setKillQuantity(Double killQuantity) {
		this.killQuantity = killQuantity;
	}

	public String getCheckContext() {
		return checkContext;
	}

	public void setCheckContext(String checkContext) {
		this.checkContext = checkContext;
	}
}
