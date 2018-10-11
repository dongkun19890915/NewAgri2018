package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 核损明细表实体操作对象
 */
@Entity
@Table(name = "PrpLverifyLossItem")
@IdClass(PrpLverifyLossItemKey.class)
public class PrpLverifyLossItem extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;	

	/** 属性立案号/立案号 */
	@Column(name = "ClaimNo")
	private String claimNo ;
	/** 属性序号/序号 */
	@Column(name = "SerialNo")
	private java.lang.Integer serialNo ;
	/** 属性损失类型/损失类型 */
	@Column(name = "LossType")
	private String lossType ;
	/** 属性险种代码/险种代码 */
	@Column(name = "RiskCode")
	private String riskCode ;

	/** 属性被保险人名称/被保险人名称 */
	@Column(name = "InSuredName")
	private String inSuredName ;
	/** 属性车牌号/车牌号 */
	@Column(name = "LicenseNo")
	private String licenseNo ;
	/** 属性号牌底色代码/号牌底色代码 */
	@Column(name = "LicenseColorCode")
	private String licenseColorCode ;
	/** 属性号牌种类代码/号牌种类代码 */
	@Column(name = "CarKindCode")
	private String carKindCode ;
	/** 属性币别代码/币别代码 */
	@Column(name = "Currency")
	private String currency ;
	/** 属性定损总金额/定损总金额 */
	@Column(name = "SumPRedEfloss")
	private java.lang.Double sumPRedEfloss ;
	/** 属性核损总金额/核损总金额 */
	@Column(name = "Sumdefloss")
	private java.lang.Double sumdefloss ;
	/** 属性出单机构/出单机构 */
	@Column(name = "Makecom")
	private String makecom ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "Comcode")
	private String comcode ;
	/** 属性定损人代码/定损人代码 */
	@Column(name = "HandlerCode")
	private String handlerCode ;
	/** 属性定损人（名称）/定损人（名称） */
	@Column(name = "HandlerName")
	private String handlerName ;
	/** 属性定损结束日期/定损结束日期 */
	@Column(name = "DefLossDate")
	private java.util.Date defLossDate ;
	/** 属性核损人代码/核损人代码 */
	@Column(name = "UnderWriteCode")
	private String underWriteCode ;
	/** 属性核损人名称/核损人名称 */
	@Column(name = "UnderWriteName")
	private String underWriteName ;
	/** 属性最终核损完成日期/最终核损完成日期 */
	@Column(name = "UnderWriteEndDate")
	private java.util.Date underWriteEndDate ;
	/** 属性是否经过核损标志/是否经过核损标志 */
	@Column(name = "UnderWriteFlag")
	private String underWriteFlag ;
	/** 属性Nodetype/Nodetype */
	@Column(name = "Nodetype")
	private String nodetype ;
	/** 属性备注/备注 */
	@Column(name = "Remark")
	private String remark ;
	/** 属性备注(核损) /备注(核损)  */
	@Column(name = "VerifyRemark")
	private String verifyRemark ;
	/** 属性标志位/标志位 */
	@Column(name = "Flag")
	private String flag ;
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
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性损失类型/损失类型的getter方法
	 */
	public String getLossType() {
		return lossType;
	}
	/**
	 * 属性损失类型/损失类型的setter方法
	 */
	public void setLossType(String lossType) {
		this.lossType = lossType;
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
	 * 属性被保险人名称/被保险人名称的getter方法
	 */
	public String getInSuredName() {
		return inSuredName;
	}
	/**
	 * 属性被保险人名称/被保险人名称的setter方法
	 */
	public void setInSuredName(String inSuredName) {
		this.inSuredName = inSuredName;
	} 	
	/**
	 * 属性车牌号/车牌号的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性车牌号/车牌号的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	} 	
	/**
	 * 属性号牌底色代码/号牌底色代码的getter方法
	 */
	public String getLicenseColorCode() {
		return licenseColorCode;
	}
	/**
	 * 属性号牌底色代码/号牌底色代码的setter方法
	 */
	public void setLicenseColorCode(String licenseColorCode) {
		this.licenseColorCode = licenseColorCode;
	} 	
	/**
	 * 属性号牌种类代码/号牌种类代码的getter方法
	 */
	public String getCarKindCode() {
		return carKindCode;
	}
	/**
	 * 属性号牌种类代码/号牌种类代码的setter方法
	 */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	} 	
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性定损总金额/定损总金额的getter方法
	 */
	public java.lang.Double getSumPRedEfloss() {
		return sumPRedEfloss;
	}
	/**
	 * 属性定损总金额/定损总金额的setter方法
	 */
	public void setSumPRedEfloss( java.lang.Double sumPRedEfloss) {
		this.sumPRedEfloss = sumPRedEfloss;
	} 	
	/**
	 * 属性核损总金额/核损总金额的getter方法
	 */
	public java.lang.Double getSumdefloss() {
		return sumdefloss;
	}
	/**
	 * 属性核损总金额/核损总金额的setter方法
	 */
	public void setSumdefloss( java.lang.Double sumdefloss) {
		this.sumdefloss = sumdefloss;
	} 	
	/**
	 * 属性出单机构/出单机构的getter方法
	 */
	public String getMakecom() {
		return makecom;
	}
	/**
	 * 属性出单机构/出单机构的setter方法
	 */
	public void setMakecom(String makecom) {
		this.makecom = makecom;
	} 	
	/**
	 * 属性业务归属机构代码/业务归属机构代码的getter方法
	 */
	public String getComcode() {
		return comcode;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的setter方法
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	} 	
	/**
	 * 属性定损人代码/定损人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性定损人代码/定损人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	} 	
	/**
	 * 属性定损人（名称）/定损人（名称）的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性定损人（名称）/定损人（名称）的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	} 	
	/**
	 * 属性定损结束日期/定损结束日期的getter方法
	 */
	public java.util.Date getDefLossDate() {
		return defLossDate;
	}
	/**
	 * 属性定损结束日期/定损结束日期的setter方法
	 */
	public void setDefLossDate(java.util.Date defLossDate) {
		this.defLossDate = defLossDate;
	} 	
	/**
	 * 属性核损人代码/核损人代码的getter方法
	 */
	public String getUnderWriteCode() {
		return underWriteCode;
	}
	/**
	 * 属性核损人代码/核损人代码的setter方法
	 */
	public void setUnderWriteCode(String underWriteCode) {
		this.underWriteCode = underWriteCode;
	} 	
	/**
	 * 属性核损人名称/核损人名称的getter方法
	 */
	public String getUnderWriteName() {
		return underWriteName;
	}
	/**
	 * 属性核损人名称/核损人名称的setter方法
	 */
	public void setUnderWriteName(String underWriteName) {
		this.underWriteName = underWriteName;
	} 	
	/**
	 * 属性最终核损完成日期/最终核损完成日期的getter方法
	 */
	public java.util.Date getUnderWriteEndDate() {
		return underWriteEndDate;
	}
	/**
	 * 属性最终核损完成日期/最终核损完成日期的setter方法
	 */
	public void setUnderWriteEndDate(java.util.Date underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	} 	
	/**
	 * 属性是否经过核损标志/是否经过核损标志的getter方法
	 */
	public String getUnderWriteFlag() {
		return underWriteFlag;
	}
	/**
	 * 属性是否经过核损标志/是否经过核损标志的setter方法
	 */
	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
	} 	
	/**
	 * 属性Nodetype/Nodetype的getter方法
	 */
	public String getNodetype() {
		return nodetype;
	}
	/**
	 * 属性Nodetype/Nodetype的setter方法
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
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
	 * 属性备注(核损) /备注(核损) 的getter方法
	 */
	public String getVerifyRemark() {
		return verifyRemark;
	}
	/**
	 * 属性备注(核损) /备注(核损) 的setter方法
	 */
	public void setVerifyRemark(String verifyRemark) {
		this.verifyRemark = verifyRemark;
	} 	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}