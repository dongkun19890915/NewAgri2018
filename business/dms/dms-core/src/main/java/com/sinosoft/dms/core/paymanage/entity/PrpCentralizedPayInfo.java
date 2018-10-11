package com.sinosoft.dms.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 08:39:47.289 
 * PrpCentralizedPayInfo实体操作对象
 */
@Entity
@Table(name = "PrpCentralizedPayInfo")
@IdClass(PrpCentralizedPayInfoKey.class)
public class PrpCentralizedPayInfo extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性operateid/operateid */
	@Id
	@Column(name = "operateId")
	private String operateId ;	

	/** 属性businessno/businessno */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性policyno/policyno */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性comcode/comcode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性riskcode/riskcode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性operatestatus/operatestatus */
	@Column(name = "operateStatus")
	private String operateStatus ;
	/** 属性flowstatus/flowstatus */
	@Column(name = "flowStatus")
	private String flowStatus ;
	/** 属性bankoriginal/bankoriginal */
	@Column(name = "bankOriginal")
	private String bankOriginal ;
	/** 属性accountnameoriginal/accountnameoriginal */
	@Column(name = "accountNameOriginal")
	private String accountNameOriginal ;
	/** 属性accountoriginal/accountoriginal */
	@Column(name = "accountOriginal")
	private String accountOriginal ;
	/** 属性accounttypeoriginal/accounttypeoriginal */
	@Column(name = "accountTypeOriginal")
	private String accountTypeOriginal ;
	/** 属性areabankcodeoriginal/areabankcodeoriginal */
	@Column(name = "areaBankCodeOriginal")
	private String areaBankCodeOriginal ;
	/** 属性bankprovincecodeoriginal/bankprovincecodeoriginal */
	@Column(name = "bankProvinceCodeOriginal")
	private String bankProvinceCodeOriginal ;
	/** 属性bankareastandardcodeoriginal/bankareastandardcodeoriginal */
	@Column(name = "bankAreaStandardCodeOriginal")
	private String bankAreaStandardCodeOriginal ;
	/** 属性banknew/banknew */
	@Column(name = "bankNew")
	private String bankNew ;
	/** 属性accountnamenew/accountnamenew */
	@Column(name = "accountNameNew")
	private String accountNameNew ;
	/** 属性accountnew/accountnew */
	@Column(name = "accountNew")
	private String accountNew ;
	/** 属性accounttypenew/accounttypenew */
	@Column(name = "accountTypeNew")
	private String accountTypeNew ;
	/** 属性areabankcodenew/areabankcodenew */
	@Column(name = "areaBankCodeNew")
	private String areaBankCodeNew ;
	/** 属性bankprovincecodenew/bankprovincecodenew */
	@Column(name = "bankProvinceCodeNew")
	private String bankProvinceCodeNew ;
	/** 属性bankareastandardnew/bankareastandardnew */
	@Column(name = "bankAreaStandardNew")
	private String bankAreaStandardNew ;
	/** 属性operatorcode/operatorcode */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性operatorname/operatorname */
	@Column(name = "operatorName")
	private String operatorName ;
	/** 属性underwritecode/underwritecode */
	@Column(name = "underwriteCode")
	private String underwriteCode ;
	/** 属性underwritename/underwritename */
	@Column(name = "underwriteName")
	private String underwriteName ;
	/** 属性operatedate/operatedate */
	@Column(name = "operateDate")
	private java.util.Date operateDate ;
	/** 属性createdate/createdate */
	@Column(name = "createDate")
	private String createDate ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性upperbankcodeoriginal/upperbankcodeoriginal */
	@Column(name = "upperBankCodeOriginal")
	private String upperBankCodeOriginal ;
	/** 属性upperbankcodenew/upperbankcodenew */
	@Column(name = "upperBankCodeNew")
	private String upperBankCodeNew ;
	/** 属性underwritedate/underwritedate */
	@Column(name = "underwriteDate")
	private java.util.Date underwriteDate ;
	/** 属性errorcode/errorcode */
	@Column(name = "errorCode")
	private String errorCode ;
	/** 属性errordescription/errordescription */
	@Column(name = "errorDescription")
	private String errorDescription ;
	/** 属性certiid/certiid */
	@Column(name = "certiId")
	private String certiId ;
	/** 属性uploadfilename/uploadfilename */
	@Column(name = "uploadFileName")
	private String uploadFileName ;
	/** 属性cardtypeoriginal/cardtypeoriginal */
	@Column(name = "cardTypeOriginal")
	private String cardTypeOriginal ;
	/** 属性cardtypenew/cardtypenew */
	@Column(name = "cardTypeNew")
	private String cardTypeNew ;
	/** 属性settlementmodeoriginal/settlementmodeoriginal */
	@Column(name = "settlementModeOriginal")
	private String settlementModeOriginal ;
	/** 属性settlementmodenew/settlementmodenew */
	@Column(name = "settlementModeNew")
	private String settlementModeNew ;
	/** 属性remarkinfooriginal/remarkinfooriginal */
	@Column(name = "remarkInfoOriginal")
	private String remarkInfoOriginal ;
	/** 属性remarkinfonew/remarkinfonew */
	@Column(name = "remarkInfoNew")
	private String remarkInfoNew ;
	/**
	 * 属性operateid/operateid的getter方法
	 */
	public String getOperateId() {
		return operateId;
	}
	/**
	 * 属性operateid/operateid的setter方法
	 */
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	} 	
	/**
	 * 属性businessno/businessno的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性businessno/businessno的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
	/**
	 * 属性policyno/policyno的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性policyno/policyno的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性comcode/comcode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comcode/comcode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性riskcode/riskcode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskcode/riskcode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性operatestatus/operatestatus的getter方法
	 */
	public String getOperateStatus() {
		return operateStatus;
	}
	/**
	 * 属性operatestatus/operatestatus的setter方法
	 */
	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	} 	
	/**
	 * 属性flowstatus/flowstatus的getter方法
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 属性flowstatus/flowstatus的setter方法
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	} 	
	/**
	 * 属性bankoriginal/bankoriginal的getter方法
	 */
	public String getBankOriginal() {
		return bankOriginal;
	}
	/**
	 * 属性bankoriginal/bankoriginal的setter方法
	 */
	public void setBankOriginal(String bankOriginal) {
		this.bankOriginal = bankOriginal;
	} 	
	/**
	 * 属性accountnameoriginal/accountnameoriginal的getter方法
	 */
	public String getAccountNameOriginal() {
		return accountNameOriginal;
	}
	/**
	 * 属性accountnameoriginal/accountnameoriginal的setter方法
	 */
	public void setAccountNameOriginal(String accountNameOriginal) {
		this.accountNameOriginal = accountNameOriginal;
	} 	
	/**
	 * 属性accountoriginal/accountoriginal的getter方法
	 */
	public String getAccountOriginal() {
		return accountOriginal;
	}
	/**
	 * 属性accountoriginal/accountoriginal的setter方法
	 */
	public void setAccountOriginal(String accountOriginal) {
		this.accountOriginal = accountOriginal;
	} 	
	/**
	 * 属性accounttypeoriginal/accounttypeoriginal的getter方法
	 */
	public String getAccountTypeOriginal() {
		return accountTypeOriginal;
	}
	/**
	 * 属性accounttypeoriginal/accounttypeoriginal的setter方法
	 */
	public void setAccountTypeOriginal(String accountTypeOriginal) {
		this.accountTypeOriginal = accountTypeOriginal;
	} 	
	/**
	 * 属性areabankcodeoriginal/areabankcodeoriginal的getter方法
	 */
	public String getAreaBankCodeOriginal() {
		return areaBankCodeOriginal;
	}
	/**
	 * 属性areabankcodeoriginal/areabankcodeoriginal的setter方法
	 */
	public void setAreaBankCodeOriginal(String areaBankCodeOriginal) {
		this.areaBankCodeOriginal = areaBankCodeOriginal;
	} 	
	/**
	 * 属性bankprovincecodeoriginal/bankprovincecodeoriginal的getter方法
	 */
	public String getBankProvinceCodeOriginal() {
		return bankProvinceCodeOriginal;
	}
	/**
	 * 属性bankprovincecodeoriginal/bankprovincecodeoriginal的setter方法
	 */
	public void setBankProvinceCodeOriginal(String bankProvinceCodeOriginal) {
		this.bankProvinceCodeOriginal = bankProvinceCodeOriginal;
	} 	
	/**
	 * 属性bankareastandardcodeoriginal/bankareastandardcodeoriginal的getter方法
	 */
	public String getBankAreaStandardCodeOriginal() {
		return bankAreaStandardCodeOriginal;
	}
	/**
	 * 属性bankareastandardcodeoriginal/bankareastandardcodeoriginal的setter方法
	 */
	public void setBankAreaStandardCodeOriginal(String bankAreaStandardCodeOriginal) {
		this.bankAreaStandardCodeOriginal = bankAreaStandardCodeOriginal;
	} 	
	/**
	 * 属性banknew/banknew的getter方法
	 */
	public String getBankNew() {
		return bankNew;
	}
	/**
	 * 属性banknew/banknew的setter方法
	 */
	public void setBankNew(String bankNew) {
		this.bankNew = bankNew;
	} 	
	/**
	 * 属性accountnamenew/accountnamenew的getter方法
	 */
	public String getAccountNameNew() {
		return accountNameNew;
	}
	/**
	 * 属性accountnamenew/accountnamenew的setter方法
	 */
	public void setAccountNameNew(String accountNameNew) {
		this.accountNameNew = accountNameNew;
	} 	
	/**
	 * 属性accountnew/accountnew的getter方法
	 */
	public String getAccountNew() {
		return accountNew;
	}
	/**
	 * 属性accountnew/accountnew的setter方法
	 */
	public void setAccountNew(String accountNew) {
		this.accountNew = accountNew;
	} 	
	/**
	 * 属性accounttypenew/accounttypenew的getter方法
	 */
	public String getAccountTypeNew() {
		return accountTypeNew;
	}
	/**
	 * 属性accounttypenew/accounttypenew的setter方法
	 */
	public void setAccountTypeNew(String accountTypeNew) {
		this.accountTypeNew = accountTypeNew;
	} 	
	/**
	 * 属性areabankcodenew/areabankcodenew的getter方法
	 */
	public String getAreaBankCodeNew() {
		return areaBankCodeNew;
	}
	/**
	 * 属性areabankcodenew/areabankcodenew的setter方法
	 */
	public void setAreaBankCodeNew(String areaBankCodeNew) {
		this.areaBankCodeNew = areaBankCodeNew;
	} 	
	/**
	 * 属性bankprovincecodenew/bankprovincecodenew的getter方法
	 */
	public String getBankProvinceCodeNew() {
		return bankProvinceCodeNew;
	}
	/**
	 * 属性bankprovincecodenew/bankprovincecodenew的setter方法
	 */
	public void setBankProvinceCodeNew(String bankProvinceCodeNew) {
		this.bankProvinceCodeNew = bankProvinceCodeNew;
	} 	
	/**
	 * 属性bankareastandardnew/bankareastandardnew的getter方法
	 */
	public String getBankAreaStandardNew() {
		return bankAreaStandardNew;
	}
	/**
	 * 属性bankareastandardnew/bankareastandardnew的setter方法
	 */
	public void setBankAreaStandardNew(String bankAreaStandardNew) {
		this.bankAreaStandardNew = bankAreaStandardNew;
	} 	
	/**
	 * 属性operatorcode/operatorcode的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性operatorcode/operatorcode的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性operatorname/operatorname的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性operatorname/operatorname的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	} 	
	/**
	 * 属性underwritecode/underwritecode的getter方法
	 */
	public String getUnderwriteCode() {
		return underwriteCode;
	}
	/**
	 * 属性underwritecode/underwritecode的setter方法
	 */
	public void setUnderwriteCode(String underwriteCode) {
		this.underwriteCode = underwriteCode;
	} 	
	/**
	 * 属性underwritename/underwritename的getter方法
	 */
	public String getUnderwriteName() {
		return underwriteName;
	}
	/**
	 * 属性underwritename/underwritename的setter方法
	 */
	public void setUnderwriteName(String underwriteName) {
		this.underwriteName = underwriteName;
	} 	
	/**
	 * 属性operatedate/operatedate的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性operatedate/operatedate的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	} 	
	/**
	 * 属性createdate/createdate的getter方法
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 属性createdate/createdate的setter方法
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性upperbankcodeoriginal/upperbankcodeoriginal的getter方法
	 */
	public String getUpperBankCodeOriginal() {
		return upperBankCodeOriginal;
	}
	/**
	 * 属性upperbankcodeoriginal/upperbankcodeoriginal的setter方法
	 */
	public void setUpperBankCodeOriginal(String upperBankCodeOriginal) {
		this.upperBankCodeOriginal = upperBankCodeOriginal;
	} 	
	/**
	 * 属性upperbankcodenew/upperbankcodenew的getter方法
	 */
	public String getUpperBankCodeNew() {
		return upperBankCodeNew;
	}
	/**
	 * 属性upperbankcodenew/upperbankcodenew的setter方法
	 */
	public void setUpperBankCodeNew(String upperBankCodeNew) {
		this.upperBankCodeNew = upperBankCodeNew;
	} 	
	/**
	 * 属性underwritedate/underwritedate的getter方法
	 */
	public java.util.Date getUnderwriteDate() {
		return underwriteDate;
	}
	/**
	 * 属性underwritedate/underwritedate的setter方法
	 */
	public void setUnderwriteDate(java.util.Date underwriteDate) {
		this.underwriteDate = underwriteDate;
	} 	
	/**
	 * 属性errorcode/errorcode的getter方法
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * 属性errorcode/errorcode的setter方法
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	} 	
	/**
	 * 属性errordescription/errordescription的getter方法
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	/**
	 * 属性errordescription/errordescription的setter方法
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	} 	
	/**
	 * 属性certiid/certiid的getter方法
	 */
	public String getCertiId() {
		return certiId;
	}
	/**
	 * 属性certiid/certiid的setter方法
	 */
	public void setCertiId(String certiId) {
		this.certiId = certiId;
	} 	
	/**
	 * 属性uploadfilename/uploadfilename的getter方法
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * 属性uploadfilename/uploadfilename的setter方法
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	} 	
	/**
	 * 属性cardtypeoriginal/cardtypeoriginal的getter方法
	 */
	public String getCardTypeOriginal() {
		return cardTypeOriginal;
	}
	/**
	 * 属性cardtypeoriginal/cardtypeoriginal的setter方法
	 */
	public void setCardTypeOriginal(String cardTypeOriginal) {
		this.cardTypeOriginal = cardTypeOriginal;
	} 	
	/**
	 * 属性cardtypenew/cardtypenew的getter方法
	 */
	public String getCardTypeNew() {
		return cardTypeNew;
	}
	/**
	 * 属性cardtypenew/cardtypenew的setter方法
	 */
	public void setCardTypeNew(String cardTypeNew) {
		this.cardTypeNew = cardTypeNew;
	} 	
	/**
	 * 属性settlementmodeoriginal/settlementmodeoriginal的getter方法
	 */
	public String getSettlementModeOriginal() {
		return settlementModeOriginal;
	}
	/**
	 * 属性settlementmodeoriginal/settlementmodeoriginal的setter方法
	 */
	public void setSettlementModeOriginal(String settlementModeOriginal) {
		this.settlementModeOriginal = settlementModeOriginal;
	} 	
	/**
	 * 属性settlementmodenew/settlementmodenew的getter方法
	 */
	public String getSettlementModeNew() {
		return settlementModeNew;
	}
	/**
	 * 属性settlementmodenew/settlementmodenew的setter方法
	 */
	public void setSettlementModeNew(String settlementModeNew) {
		this.settlementModeNew = settlementModeNew;
	} 	
	/**
	 * 属性remarkinfooriginal/remarkinfooriginal的getter方法
	 */
	public String getRemarkInfoOriginal() {
		return remarkInfoOriginal;
	}
	/**
	 * 属性remarkinfooriginal/remarkinfooriginal的setter方法
	 */
	public void setRemarkInfoOriginal(String remarkInfoOriginal) {
		this.remarkInfoOriginal = remarkInfoOriginal;
	} 	
	/**
	 * 属性remarkinfonew/remarkinfonew的getter方法
	 */
	public String getRemarkInfoNew() {
		return remarkInfoNew;
	}
	/**
	 * 属性remarkinfonew/remarkinfonew的setter方法
	 */
	public void setRemarkInfoNew(String remarkInfoNew) {
		this.remarkInfoNew = remarkInfoNew;
	} 	
}
