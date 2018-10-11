package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * 种植险理赔清单信息表Api操作对象
 */
public class NyxPlantingClaimListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;;
	/** 属性理赔清单号/理赔清单号 */
//	@ExportConfig(value = "理赔清单号",width = 80)
	private String listNo ;
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width = 80)
	private String serialNo ;		
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号码",width = 80)
	private String policyNo ;		
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width = 80)
	private String registNo ;
	/** 属性理赔清单号/理赔清单号 */
	@ExportConfig(value = "立案号",width = 80)
	private String claimNo;
	/** 属性计算书号/计算书号 */
	@ExportConfig(value = "计算书号",width = 80)
	private String compensateNo ;		
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width = 80)
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户姓名",width = 80)
	private String fName ;		
	/** 属性身份证号码/身份证号码 */
	@ExportConfig(value = "身份证号码",width = 80)
	private String fIdCard ;
	/** 属性联系电话/联系电话 */
	@ExportConfig(value = "联系电话",width = 80)
	private String phoneNumber ;
	/** 属性赔付险别代码/赔付险别代码 */
	@ExportConfig(value = "赔付险别代码",width = 80)
	private String claimRiskCode ;
	/** 属性标的号码/标的号码 */
	@ExportConfig(value = "标的号码",width = 80)
	private String itemCode ;
	/** 属性受损面积/受损面积 */
	@ExportConfig(value = "受损面积",width = 80)
	private java.lang.Double lossArea ;
//	/** 属性银行账号/银行账号 */
//	@ExportConfig(value = "银行账号",width = 80)
	private String bankAccount ;
	/** 属性损失率/损失率 */
	@ExportConfig(value = "损失率",width = 80)
	private java.lang.Double lossRate ;
	/** 属性有效保额/有效保额 */
	@ExportConfig(value = "有效保额",width = 80)
	private String effectiveGuarantee;
	/** 属性赔付比例/赔付比例 */
	@ExportConfig(value = "赔付比例",width = 80)
	private java.lang.Double claimRate ;
	/** 属性每次事故免赔率/每次事故免赔率 */
	@ExportConfig(value = "每次事故免赔率",width = 80)
	private String accident  ;
	/** 属性绝对免赔率/绝对免赔率 */
	@ExportConfig(value = "绝对免赔率",width = 80)
	private String deductible  ;
	/** 属性赔偿金额/赔偿金额 */
	@ExportConfig(value = "赔偿金额",width = 80)
	private java.lang.Double settleAmount ;
	/** 属性赔付类型 01-预赔/赔付类型 01-预赔 */
	@ExportConfig(value = "赔付类型",width = 80)
	private String payType ;
	/** 属性计算公式*/
	@ExportConfig(value="计算公式",width = 80)
	private String formula;
	/** 属性扣除金额*/
	@ExportConfig(value="扣除金额",width = 80)
	private String deductionAmount;
//	/** 属性剩余面积/剩余面积 */
//	@ExportConfig(value = "剩余面积",width = 80)
	private java.lang.Double remainingArea ;
	/** 属性剩余保额/剩余保额 */
//	@ExportConfig(value = "剩余保额",width = 80)
	private java.lang.Double remainingAmount ;
	/** 属性土地来源/土地来源 */
//	@ExportConfig(value = "土地来源",width = 80)
	private String fieldSource ;
	/** 属性连带被保险人姓名*/
	@ExportConfig(value="连带被保险人姓名",width = 80, enabled=false)
	private String name;
	/** 属性贷款合同编号*/
	@ExportConfig(value="贷款合同编号",width = 80,enabled=false)
	private String no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	/** 节点类型*/
	private String nodeType;

	public String getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(String deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getEffectiveGuarantee() {
		return effectiveGuarantee;
	}

	public void setEffectiveGuarantee(String effectiveGuarantee) {
		this.effectiveGuarantee = effectiveGuarantee;
	}

	public String getAccident() {
		return accident;
	}

	public void setAccident(String accident) {
		this.accident = accident;
	}

	public String getDeductible() {
		return deductible;
	}

	public void setDeductible(String deductible) {
		this.deductible = deductible;
	}

	/**
	 * 属性序号/序号的getter方法
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
	 * 属性计算书号/计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性计算书号/计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfIdCard() {
		return fIdCard;
	}

	public void setfIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	}

	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	/**
	 * 属性剩余面积/剩余面积的getter方法
	 */
	public java.lang.Double getRemainingArea() {
		return remainingArea;
	}
	/**
	 * 属性剩余面积/剩余面积的setter方法
	 */
	public void setRemainingArea(java.lang.Double remainingArea) {
		this.remainingArea = remainingArea;
	}
	/**
	 * 属性剩余保额/剩余保额的getter方法
	 */
	public java.lang.Double getRemainingAmount() {
		return remainingAmount;
	}
	/**
	 * 属性剩余保额/剩余保额的setter方法
	 */
	public void setRemainingAmount(java.lang.Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	/**
	 * 属性赔付险别代码/赔付险别代码的getter方法
	 */
	public String getClaimRiskCode() {
		return claimRiskCode;
	}
	/**
	 * 属性赔付险别代码/赔付险别代码的setter方法
	 */
	public void setClaimRiskCode(String claimRiskCode) {
		this.claimRiskCode = claimRiskCode;
	}	
	/**
	 * 属性土地来源/土地来源的getter方法
	 */
	public String getFieldSource() {
		return fieldSource;
	}
	/**
	 * 属性土地来源/土地来源的setter方法
	 */
	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
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
	 * 属性受损面积/受损面积的getter方法
	 */
	public java.lang.Double getLossArea() {
		return lossArea;
	}
	/**
	 * 属性受损面积/受损面积的setter方法
	 */
	public void setLossArea(java.lang.Double lossArea) {
		this.lossArea = lossArea;
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
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Double getSettleAmount() {
		return settleAmount;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSettleAmount(java.lang.Double settleAmount) {
		this.settleAmount = settleAmount;
	}	
	/**
	 * 属性银行账号/银行账号的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性银行账号/银行账号的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 属性赔付类型 01-预赔/赔付类型 01-预赔的getter方法
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 属性赔付类型 01-预赔/赔付类型 01-预赔的setter方法
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
}
