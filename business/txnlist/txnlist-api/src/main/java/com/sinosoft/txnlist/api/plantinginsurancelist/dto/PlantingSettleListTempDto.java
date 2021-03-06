package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * plantingsettlelisttempApi操作对象
 */
public class PlantingSettleListTempDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号（KEY）/报案号（KEY） */
	private String registCode ;		
	/** 属性时间戳（KEY）/时间戳（KEY） */
	private String stringTimeStamp ;		
	/** 属性序列号（KEY）/序列号（KEY） */
	private java.lang.Integer indexOfSettle ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性险别序号/险别序号 */
	private String kindCode ;		
	/** 属性险类/险类 */
	private String classCode ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性承保面积/承保面积 */
	private java.lang.Double insureArea ;		
	/** 属性保额/保额 */
	private java.lang.Double sumInsured ;		
	/** 属性直补卡/直补卡 */
	private String zhiBuKa ;		
	/** 属性农户姓名/农户姓名 */
	private String fName ;		
	/** 属性身份证/身份证 */
	private String fIdCard ;		
	/** 属性行政区域/行政区域 */
	private String fareaCode ;		
	/** 属性承包清单号/承包清单号 */
	private String inusreListCode ;		
	/** 属性生长期/生长期 */
	private java.lang.Double growingSeason ;		
	/** 属性损失率/损失率 */
	private java.lang.Double lossRate ;		
	/** 属性理赔面积/理赔面积 */
	private java.lang.Double settleArea ;		
	/** 属性赔偿金额/赔偿金额 */
	private java.lang.Double settleSum ;		
	/** 属性操作员代码/操作员代码 */
	private String opCode ;		
	/** 属性操作时间/操作时间 */
	private java.util.Date opTime ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性有效标志位/有效标志位 */
	private String validity ;		
	/** 属性打卡成功时间/打卡成功时间 */
	private java.util.Date settleDate ;		
	/** 属性赔付比例/赔付比例 */
	private java.lang.Double claimRate ;		
	/** 属性节点类型/节点类型 */
	private String nodeType ;		
	/** 属性联系电话/联系电话 */
	private String phone ;		
	/** 属性开户银行/开户银行 */
	private String bank ;		
	/** 属性fieldSource/fieldSource */
	private String fieldSource ;		
	/** 属性林权证号/林权证号 */
	private String warrant ;		
	/** 属性自定义种植面积/自定义种植面积 */
	private java.lang.Double taxArea ;		
	/** 属性littleAreaName/littleAreaName */
	private String littleAreaName ;		
	/** 属性atArea/atArea */
	private String atArea ;		
	/** 属性实有林地/实有林地 */
	private java.lang.Double woodLandArea ;		
	/**
	 * 属性报案号（KEY）/报案号（KEY）的getter方法
	 */
	public String getRegistCode() {
		return registCode;
	}
	/**
	 * 属性报案号（KEY）/报案号（KEY）的setter方法
	 */
	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	}	
	/**
	 * 属性时间戳（KEY）/时间戳（KEY）的getter方法
	 */
	public String getStringTimeStamp() {
		return stringTimeStamp;
	}
	/**
	 * 属性时间戳（KEY）/时间戳（KEY）的setter方法
	 */
	public void setStringTimeStamp(String stringTimeStamp) {
		this.stringTimeStamp = stringTimeStamp;
	}	
	/**
	 * 属性序列号（KEY）/序列号（KEY）的getter方法
	 */
	public java.lang.Integer getIndexOfSettle() {
		return indexOfSettle;
	}
	/**
	 * 属性序列号（KEY）/序列号（KEY）的setter方法
	 */
	public void setIndexOfSettle(java.lang.Integer indexOfSettle) {
		this.indexOfSettle = indexOfSettle;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	}	
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
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
	 * 属性承保面积/承保面积的getter方法
	 */
	public java.lang.Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性承保面积/承保面积的setter方法
	 */
	public void setInsureArea(java.lang.Double insureArea) {
		this.insureArea = insureArea;
	}	
	/**
	 * 属性保额/保额的getter方法
	 */
	public java.lang.Double getSumInsured() {
		return sumInsured;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setSumInsured(java.lang.Double sumInsured) {
		this.sumInsured = sumInsured;
	}	
	/**
	 * 属性直补卡/直补卡的getter方法
	 */
	public String getZhiBuKa() {
		return zhiBuKa;
	}
	/**
	 * 属性直补卡/直补卡的setter方法
	 */
	public void setZhiBuKa(String zhiBuKa) {
		this.zhiBuKa = zhiBuKa;
	}	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}	
	/**
	 * 属性身份证/身份证的getter方法
	 */
	public String getFIdCard() {
		return fIdCard;
	}
	/**
	 * 属性身份证/身份证的setter方法
	 */
	public void setFIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	}	
	/**
	 * 属性行政区域/行政区域的getter方法
	 */
	public String getFareaCode() {
		return fareaCode;
	}
	/**
	 * 属性行政区域/行政区域的setter方法
	 */
	public void setFareaCode(String fareaCode) {
		this.fareaCode = fareaCode;
	}	
	/**
	 * 属性承包清单号/承包清单号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性承包清单号/承包清单号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	}	
	/**
	 * 属性生长期/生长期的getter方法
	 */
	public java.lang.Double getGrowingSeason() {
		return growingSeason;
	}
	/**
	 * 属性生长期/生长期的setter方法
	 */
	public void setGrowingSeason(java.lang.Double growingSeason) {
		this.growingSeason = growingSeason;
	}	
	/**
	 * 属性损失率/损失率的getter方法
	 */
	public java.lang.Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失率/损失率的setter方法
	 */
	public void setLossRate(java.lang.Double lossRate) {
		this.lossRate = lossRate;
	}	
	/**
	 * 属性理赔面积/理赔面积的getter方法
	 */
	public java.lang.Double getSettleArea() {
		return settleArea;
	}
	/**
	 * 属性理赔面积/理赔面积的setter方法
	 */
	public void setSettleArea(java.lang.Double settleArea) {
		this.settleArea = settleArea;
	}	
	/**
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Double getSettleSum() {
		return settleSum;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSettleSum(java.lang.Double settleSum) {
		this.settleSum = settleSum;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性操作时间/操作时间的getter方法
	 */
	public java.util.Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOpTime(java.util.Date opTime) {
		this.opTime = opTime;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性有效标志位/有效标志位的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性有效标志位/有效标志位的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}	
	/**
	 * 属性打卡成功时间/打卡成功时间的getter方法
	 */
	public java.util.Date getSettleDate() {
		return settleDate;
	}
	/**
	 * 属性打卡成功时间/打卡成功时间的setter方法
	 */
	public void setSettleDate(java.util.Date settleDate) {
		this.settleDate = settleDate;
	}	
	/**
	 * 属性赔付比例/赔付比例的getter方法
	 */
	public java.lang.Double getClaimRate() {
		return claimRate;
	}
	/**
	 * 属性赔付比例/赔付比例的setter方法
	 */
	public void setClaimRate(java.lang.Double claimRate) {
		this.claimRate = claimRate;
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
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}	
	/**
	 * 属性fieldSource/fieldSource的getter方法
	 */
	public String getFieldSource() {
		return fieldSource;
	}
	/**
	 * 属性fieldSource/fieldSource的setter方法
	 */
	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
	}	
	/**
	 * 属性林权证号/林权证号的getter方法
	 */
	public String getWarrant() {
		return warrant;
	}
	/**
	 * 属性林权证号/林权证号的setter方法
	 */
	public void setWarrant(String warrant) {
		this.warrant = warrant;
	}	
	/**
	 * 属性自定义种植面积/自定义种植面积的getter方法
	 */
	public java.lang.Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性自定义种植面积/自定义种植面积的setter方法
	 */
	public void setTaxArea(java.lang.Double taxArea) {
		this.taxArea = taxArea;
	}	
	/**
	 * 属性littleAreaName/littleAreaName的getter方法
	 */
	public String getLittleAreaName() {
		return littleAreaName;
	}
	/**
	 * 属性littleAreaName/littleAreaName的setter方法
	 */
	public void setLittleAreaName(String littleAreaName) {
		this.littleAreaName = littleAreaName;
	}	
	/**
	 * 属性atArea/atArea的getter方法
	 */
	public String getAtArea() {
		return atArea;
	}
	/**
	 * 属性atArea/atArea的setter方法
	 */
	public void setAtArea(String atArea) {
		this.atArea = atArea;
	}	
	/**
	 * 属性实有林地/实有林地的getter方法
	 */
	public java.lang.Double getWoodLandArea() {
		return woodLandArea;
	}
	/**
	 * 属性实有林地/实有林地的setter方法
	 */
	public void setWoodLandArea(java.lang.Double woodLandArea) {
		this.woodLandArea = woodLandArea;
	}	
}
