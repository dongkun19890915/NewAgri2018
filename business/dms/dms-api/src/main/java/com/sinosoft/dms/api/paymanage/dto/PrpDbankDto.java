package com.sinosoft.dms.api.paymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * 银行定义表Api操作对象
 */
public class PrpDbankDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性银行代码（银行提供）/银行代码（银行提供） */
	private String bankCode ;		
	/** 属性银行名称（银行提供）/银行名称（银行提供） */
	private String bankName ;		
	/** 属性银行联系人（银行提供）/银行联系人（银行提供） */
	private String bankLinkMan ;		
	/** 属性银行联系电话（银行提供）/银行联系电话（银行提供） */
	private String bankPhone ;		
	/** 属性银行联系地址（银行提供）/银行联系地址（银行提供） */
	private String bankAddress ;		
	/** 属性银行联系传真（银行提供）/银行联系传真（银行提供） */
	private String bankFax ;		
	/** 属性银行联系邮编（银行提供）/银行联系邮编（银行提供） */
	private String bankPostCode ;		
	/** 属性银行级别(0-总行,1-分行,2-支行,3-分理处,网点)/银行级别(0-总行,1-分行,2-支行,3-分理处,网点) */
	private String bankLevel ;		
	/** 属性对应业务归属机构/对应业务归属机构 */
	private String comCode ;		
	/** 属性上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空）/上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空） */
	private String upperBankCode ;		
	/** 属性对应代理编码/对应代理编码 */
	private String agentCode ;		
	/** 属性有效性标志（0-无效,1-有效）/有效性标志（0-无效,1-有效） */
	private String inureFlag ;		
	/** 属性上级机构/上级机构 */
	private String upperComCode ;		
	/** 属性经办人/经办人 */
	private String handlerCode ;		
	/** 属性协议号/协议号 */
	private String agrrementNo ;		
	/** 属性不规则联行号/不规则联行号 */
	private String anomalyAreaBankCode ;		
	/** 属性银行所属地区编码/银行所属地区编码 */
	private String areaCode ;		
	/** 属性对公-开户行所在省是否允许为空（Y-允许，N-不允许）/对公-开户行所在省是否允许为空（Y-允许，N-不允许） */
	private String pubProvinceFlag ;		
	/** 属性对公-开户行所在市是否允许为空（Y-允许，N-不允许）/对公-开户行所在市是否允许为空（Y-允许，N-不允许） */
	private String pubAreaFlag ;		
	/** 属性对公-联行号是否允许为空（Y-允许，N-不允许）/对公-联行号是否允许为空（Y-允许，N-不允许） */
	private String pubBankFlag ;		
	/** 属性对公-户名是否允许为空（Y-允许，N-不允许）/对公-户名是否允许为空（Y-允许，N-不允许） */
	private String pubAccountFlag ;		
	/** 属性对公-金额是否允许为空（Y-允许，N-不允许）/对公-金额是否允许为空（Y-允许，N-不允许） */
	private String pubAmountFlag ;		
	/** 属性对私-开户行所在省是否允许为空（Y-允许，N-不允许）/对私-开户行所在省是否允许为空（Y-允许，N-不允许） */
	private String priProvinceFlag ;		
	/** 属性对私-开户行所在市是否允许为空（Y-允许，N-不允许）/对私-开户行所在市是否允许为空（Y-允许，N-不允许） */
	private String priAreaFlag ;		
	/** 属性对私-联行号是否允许为空（Y-允许，N-不允许）/对私-联行号是否允许为空（Y-允许，N-不允许） */
	private String priBankFlag ;		
	/** 属性对私-户名是否允许为空（Y-允许，N-不允许）/对私-户名是否允许为空（Y-允许，N-不允许） */
	private String priAccountFlag ;		
	/** 属性对私-金额是否允许为空（Y-允许，N-不允许）/对私-金额是否允许为空（Y-允许，N-不允许） */
	private String priAmountFlag ;		
	/** 属性handelCode/handelCode */
	private String handelCode ;		
	/**
	 * 属性银行代码（银行提供）/银行代码（银行提供）的getter方法
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * 属性银行代码（银行提供）/银行代码（银行提供）的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}	
	/**
	 * 属性银行名称（银行提供）/银行名称（银行提供）的getter方法
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 属性银行名称（银行提供）/银行名称（银行提供）的setter方法
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}	
	/**
	 * 属性银行联系人（银行提供）/银行联系人（银行提供）的getter方法
	 */
	public String getBankLinkMan() {
		return bankLinkMan;
	}
	/**
	 * 属性银行联系人（银行提供）/银行联系人（银行提供）的setter方法
	 */
	public void setBankLinkMan(String bankLinkMan) {
		this.bankLinkMan = bankLinkMan;
	}	
	/**
	 * 属性银行联系电话（银行提供）/银行联系电话（银行提供）的getter方法
	 */
	public String getBankPhone() {
		return bankPhone;
	}
	/**
	 * 属性银行联系电话（银行提供）/银行联系电话（银行提供）的setter方法
	 */
	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}	
	/**
	 * 属性银行联系地址（银行提供）/银行联系地址（银行提供）的getter方法
	 */
	public String getBankAddress() {
		return bankAddress;
	}
	/**
	 * 属性银行联系地址（银行提供）/银行联系地址（银行提供）的setter方法
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}	
	/**
	 * 属性银行联系传真（银行提供）/银行联系传真（银行提供）的getter方法
	 */
	public String getBankFax() {
		return bankFax;
	}
	/**
	 * 属性银行联系传真（银行提供）/银行联系传真（银行提供）的setter方法
	 */
	public void setBankFax(String bankFax) {
		this.bankFax = bankFax;
	}	
	/**
	 * 属性银行联系邮编（银行提供）/银行联系邮编（银行提供）的getter方法
	 */
	public String getBankPostCode() {
		return bankPostCode;
	}
	/**
	 * 属性银行联系邮编（银行提供）/银行联系邮编（银行提供）的setter方法
	 */
	public void setBankPostCode(String bankPostCode) {
		this.bankPostCode = bankPostCode;
	}	
	/**
	 * 属性银行级别(0-总行,1-分行,2-支行,3-分理处,网点)/银行级别(0-总行,1-分行,2-支行,3-分理处,网点)的getter方法
	 */
	public String getBankLevel() {
		return bankLevel;
	}
	/**
	 * 属性银行级别(0-总行,1-分行,2-支行,3-分理处,网点)/银行级别(0-总行,1-分行,2-支行,3-分理处,网点)的setter方法
	 */
	public void setBankLevel(String bankLevel) {
		this.bankLevel = bankLevel;
	}	
	/**
	 * 属性对应业务归属机构/对应业务归属机构的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性对应业务归属机构/对应业务归属机构的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空）/上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空）的getter方法
	 */
	public String getUpperBankCode() {
		return upperBankCode;
	}
	/**
	 * 属性上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空）/上级银行代码（如果为总行和分行时可以不设置上级银行编码，其他不能为空）的setter方法
	 */
	public void setUpperBankCode(String upperBankCode) {
		this.upperBankCode = upperBankCode;
	}	
	/**
	 * 属性对应代理编码/对应代理编码的getter方法
	 */
	public String getAgentCode() {
		return agentCode;
	}
	/**
	 * 属性对应代理编码/对应代理编码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}	
	/**
	 * 属性有效性标志（0-无效,1-有效）/有效性标志（0-无效,1-有效）的getter方法
	 */
	public String getInureFlag() {
		return inureFlag;
	}
	/**
	 * 属性有效性标志（0-无效,1-有效）/有效性标志（0-无效,1-有效）的setter方法
	 */
	public void setInureFlag(String inureFlag) {
		this.inureFlag = inureFlag;
	}	
	/**
	 * 属性上级机构/上级机构的getter方法
	 */
	public String getUpperComCode() {
		return upperComCode;
	}
	/**
	 * 属性上级机构/上级机构的setter方法
	 */
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}	
	/**
	 * 属性经办人/经办人的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性经办人/经办人的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性协议号/协议号的getter方法
	 */
	public String getAgrrementNo() {
		return agrrementNo;
	}
	/**
	 * 属性协议号/协议号的setter方法
	 */
	public void setAgrrementNo(String agrrementNo) {
		this.agrrementNo = agrrementNo;
	}	
	/**
	 * 属性不规则联行号/不规则联行号的getter方法
	 */
	public String getAnomalyAreaBankCode() {
		return anomalyAreaBankCode;
	}
	/**
	 * 属性不规则联行号/不规则联行号的setter方法
	 */
	public void setAnomalyAreaBankCode(String anomalyAreaBankCode) {
		this.anomalyAreaBankCode = anomalyAreaBankCode;
	}	
	/**
	 * 属性银行所属地区编码/银行所属地区编码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性银行所属地区编码/银行所属地区编码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性对公-开户行所在省是否允许为空（Y-允许，N-不允许）/对公-开户行所在省是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPubProvinceFlag() {
		return pubProvinceFlag;
	}
	/**
	 * 属性对公-开户行所在省是否允许为空（Y-允许，N-不允许）/对公-开户行所在省是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPubProvinceFlag(String pubProvinceFlag) {
		this.pubProvinceFlag = pubProvinceFlag;
	}	
	/**
	 * 属性对公-开户行所在市是否允许为空（Y-允许，N-不允许）/对公-开户行所在市是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPubAreaFlag() {
		return pubAreaFlag;
	}
	/**
	 * 属性对公-开户行所在市是否允许为空（Y-允许，N-不允许）/对公-开户行所在市是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPubAreaFlag(String pubAreaFlag) {
		this.pubAreaFlag = pubAreaFlag;
	}	
	/**
	 * 属性对公-联行号是否允许为空（Y-允许，N-不允许）/对公-联行号是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPubBankFlag() {
		return pubBankFlag;
	}
	/**
	 * 属性对公-联行号是否允许为空（Y-允许，N-不允许）/对公-联行号是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPubBankFlag(String pubBankFlag) {
		this.pubBankFlag = pubBankFlag;
	}	
	/**
	 * 属性对公-户名是否允许为空（Y-允许，N-不允许）/对公-户名是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPubAccountFlag() {
		return pubAccountFlag;
	}
	/**
	 * 属性对公-户名是否允许为空（Y-允许，N-不允许）/对公-户名是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPubAccountFlag(String pubAccountFlag) {
		this.pubAccountFlag = pubAccountFlag;
	}	
	/**
	 * 属性对公-金额是否允许为空（Y-允许，N-不允许）/对公-金额是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPubAmountFlag() {
		return pubAmountFlag;
	}
	/**
	 * 属性对公-金额是否允许为空（Y-允许，N-不允许）/对公-金额是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPubAmountFlag(String pubAmountFlag) {
		this.pubAmountFlag = pubAmountFlag;
	}	
	/**
	 * 属性对私-开户行所在省是否允许为空（Y-允许，N-不允许）/对私-开户行所在省是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPriProvinceFlag() {
		return priProvinceFlag;
	}
	/**
	 * 属性对私-开户行所在省是否允许为空（Y-允许，N-不允许）/对私-开户行所在省是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPriProvinceFlag(String priProvinceFlag) {
		this.priProvinceFlag = priProvinceFlag;
	}	
	/**
	 * 属性对私-开户行所在市是否允许为空（Y-允许，N-不允许）/对私-开户行所在市是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPriAreaFlag() {
		return priAreaFlag;
	}
	/**
	 * 属性对私-开户行所在市是否允许为空（Y-允许，N-不允许）/对私-开户行所在市是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPriAreaFlag(String priAreaFlag) {
		this.priAreaFlag = priAreaFlag;
	}	
	/**
	 * 属性对私-联行号是否允许为空（Y-允许，N-不允许）/对私-联行号是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPriBankFlag() {
		return priBankFlag;
	}
	/**
	 * 属性对私-联行号是否允许为空（Y-允许，N-不允许）/对私-联行号是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPriBankFlag(String priBankFlag) {
		this.priBankFlag = priBankFlag;
	}	
	/**
	 * 属性对私-户名是否允许为空（Y-允许，N-不允许）/对私-户名是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPriAccountFlag() {
		return priAccountFlag;
	}
	/**
	 * 属性对私-户名是否允许为空（Y-允许，N-不允许）/对私-户名是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPriAccountFlag(String priAccountFlag) {
		this.priAccountFlag = priAccountFlag;
	}	
	/**
	 * 属性对私-金额是否允许为空（Y-允许，N-不允许）/对私-金额是否允许为空（Y-允许，N-不允许）的getter方法
	 */
	public String getPriAmountFlag() {
		return priAmountFlag;
	}
	/**
	 * 属性对私-金额是否允许为空（Y-允许，N-不允许）/对私-金额是否允许为空（Y-允许，N-不允许）的setter方法
	 */
	public void setPriAmountFlag(String priAmountFlag) {
		this.priAmountFlag = priAmountFlag;
	}	
	/**
	 * 属性handelCode/handelCode的getter方法
	 */
	public String getHandelCode() {
		return handelCode;
	}
	/**
	 * 属性handelCode/handelCode的setter方法
	 */
	public void setHandelCode(String handelCode) {
		this.handelCode = handelCode;
	}	
}
