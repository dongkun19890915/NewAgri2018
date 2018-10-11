package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * planting31cpendorchgdetail实体操作对象
 */
@Entity
@Table(name = "planting31CpEndorChgDetail")
@IdClass(Planting31CpEndorChgDetailKey.class)
public class Planting31CpEndorChgDetail extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性inusreListCode/inusreListCode */
	@Id
	@Column(name = "inusreListCode")
	private String inusreListCode ;/** 属性kindCode/kindCode */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性itemCode/itemCode */
	@Id
	@Column(name = "itemCode")
	private String itemCode ;/** 属性fIdCard/fIdCard */
	@Id
	@Column(name = "fIdCard")
	private String fIdCard ;	

	/** 属性fCode/fCode */
	@Column(name = "fCode")
	private String fCode ;


	/** 属性indexCode/indexCode */
	@Column(name = "indexCode")
	private String indexCode ;
	/** 属性phone/phone */
	@Column(name = "phone")
	private String phone ;
	/** 属性bank/bank */
	@Column(name = "bank")
	private String bank ;
	/** 属性zhiBuKa/zhiBuKa */
	@Column(name = "zhiBuKa")
	private String zhiBuKa ;
	/** 属性fName/fName */
	@Column(name = "fName")
	private String fName ;

	/** 属性classCode/classCode */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性fareaCode/fareaCode */
	@Column(name = "fareaCode")
	private String fareaCode ;
	/** 属性taxArea/taxArea */
	@Column(name = "taxArea")
	private java.lang.Double taxArea ;
	/** 属性insureArea/insureArea */
	@Column(name = "insureArea")
	private java.lang.Double insureArea ;
	/** 属性amount/amount */
	@Column(name = "amount")
	private java.lang.Double amount ;
	/** 属性rate/rate */
	@Column(name = "rate")
	private java.lang.Double rate ;
	/** 属性shortRateFlag/shortRateFlag */
	@Column(name = "shortRateFlag")
	private String shortRateFlag ;
	/** 属性shortRate/shortRate */
	@Column(name = "shortRate")
	private java.lang.Double shortRate ;
	/** 属性sumAmount/sumAmount */
	@Column(name = "sumAmount")
	private java.lang.Double sumAmount ;
	/** 属性sumPremium/sumPremium */
	@Column(name = "sumPremium")
	private java.lang.Double sumPremium ;
	/** 属性startDate/startDate */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性endDate/endDate */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性calculateFlag/calculateFlag */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性opCode/opCode */
	@Column(name = "opCode")
	private String opCode ;
	/** 属性opTime/opTime */
	@Column(name = "opTime")
	private java.util.Date opTime ;
	/** 属性validity/validity */
	@Column(name = "validity")
	private String validity ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性fPremium/fPremium */
	@Column(name = "fPremium")
	private java.lang.Double fPremium ;
	/** 属性teamName/teamName */
	@Column(name = "teamName")
	private String teamName ;
	/** 属性centralPremium/centralPremium */
	@Column(name = "centralPremium")
	private java.lang.Double centralPremium ;
	/** 属性provincePremium/provincePremium */
	@Column(name = "provincePremium")
	private java.lang.Double provincePremium ;
	/** 属性cityPremium/cityPremium */
	@Column(name = "cityPremium")
	private java.lang.Double cityPremium ;
	/** 属性townPremium/townPremium */
	@Column(name = "townPremium")
	private java.lang.Double townPremium ;
	/** 属性otherPremium/otherPremium */
	@Column(name = "otherPremium")
	private java.lang.Double otherPremium ;
	/** 属性fieldSource/fieldSource */
	@Column(name = "fieldSource")
	private String fieldSource ;
	/** 属性mulchDate/mulchDate */
	@Column(name = "mulchDate")
	private String mulchDate ;
	/** 属性mulchType/mulchType */
	@Column(name = "mulchType")
	private String mulchType ;
	/**
	 * 属性inusreListCode/inusreListCode的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性inusreListCode/inusreListCode的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 	
	/**
	 * 属性fCode/fCode的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性fCode/fCode的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 	
	/**
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性itemCode/itemCode的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性itemCode/itemCode的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性indexCode/indexCode的getter方法
	 */
	public String getIndexCode() {
		return indexCode;
	}
	/**
	 * 属性indexCode/indexCode的setter方法
	 */
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	} 	
	/**
	 * 属性phone/phone的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性phone/phone的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	} 	
	/**
	 * 属性bank/bank的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性bank/bank的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 	
	/**
	 * 属性zhiBuKa/zhiBuKa的getter方法
	 */
	public String getZhiBuKa() {
		return zhiBuKa;
	}
	/**
	 * 属性zhiBuKa/zhiBuKa的setter方法
	 */
	public void setZhiBuKa(String zhiBuKa) {
		this.zhiBuKa = zhiBuKa;
	} 	
	/**
	 * 属性fName/fName的getter方法
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 属性fName/fName的setter方法
	 */
	public void setFName(String fName) {
		this.fName = fName;
	} 	
	/**
	 * 属性fIdCard/fIdCard的getter方法
	 */
	public String getFIdCard() {
		return fIdCard;
	}
	/**
	 * 属性fIdCard/fIdCard的setter方法
	 */
	public void setFIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	} 	
	/**
	 * 属性classCode/classCode的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性classCode/classCode的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性fareaCode/fareaCode的getter方法
	 */
	public String getFareaCode() {
		return fareaCode;
	}
	/**
	 * 属性fareaCode/fareaCode的setter方法
	 */
	public void setFareaCode(String fareaCode) {
		this.fareaCode = fareaCode;
	} 	
	/**
	 * 属性taxArea/taxArea的getter方法
	 */
	public java.lang.Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性taxArea/taxArea的setter方法
	 */
	public void setTaxArea(java.lang.Double taxArea) {
		this.taxArea = taxArea;
	} 	
	/**
	 * 属性insureArea/insureArea的getter方法
	 */
	public java.lang.Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性insureArea/insureArea的setter方法
	 */
	public void setInsureArea(java.lang.Double insureArea) {
		this.insureArea = insureArea;
	} 	
	/**
	 * 属性amount/amount的getter方法
	 */
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	} 	
	/**
	 * 属性rate/rate的getter方法
	 */
	public java.lang.Double getRate() {
		return rate;
	}
	/**
	 * 属性rate/rate的setter方法
	 */
	public void setRate(java.lang.Double rate) {
		this.rate = rate;
	} 	
	/**
	 * 属性shortRateFlag/shortRateFlag的getter方法
	 */
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	/**
	 * 属性shortRateFlag/shortRateFlag的setter方法
	 */
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	} 	
	/**
	 * 属性shortRate/shortRate的getter方法
	 */
	public java.lang.Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性shortRate/shortRate的setter方法
	 */
	public void setShortRate(java.lang.Double shortRate) {
		this.shortRate = shortRate;
	} 	
	/**
	 * 属性sumAmount/sumAmount的getter方法
	 */
	public java.lang.Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性sumAmount/sumAmount的setter方法
	 */
	public void setSumAmount(java.lang.Double sumAmount) {
		this.sumAmount = sumAmount;
	} 	
	/**
	 * 属性sumPremium/sumPremium的getter方法
	 */
	public java.lang.Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性sumPremium/sumPremium的setter方法
	 */
	public void setSumPremium(java.lang.Double sumPremium) {
		this.sumPremium = sumPremium;
	} 	
	/**
	 * 属性startDate/startDate的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性startDate/startDate的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性endDate/endDate的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性endDate/endDate的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性calculateFlag/calculateFlag的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性calculateFlag/calculateFlag的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	} 	
	/**
	 * 属性opCode/opCode的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性opCode/opCode的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	} 	
	/**
	 * 属性opTime/opTime的getter方法
	 */
	public java.util.Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性opTime/opTime的setter方法
	 */
	public void setOpTime(java.util.Date opTime) {
		this.opTime = opTime;
	} 	
	/**
	 * 属性validity/validity的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性validity/validity的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
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
	 * 属性fPremium/fPremium的getter方法
	 */
	public java.lang.Double getFPremium() {
		return fPremium;
	}
	/**
	 * 属性fPremium/fPremium的setter方法
	 */
	public void setFPremium(java.lang.Double fPremium) {
		this.fPremium = fPremium;
	} 	
	/**
	 * 属性teamName/teamName的getter方法
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * 属性teamName/teamName的setter方法
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	} 	
	/**
	 * 属性centralPremium/centralPremium的getter方法
	 */
	public java.lang.Double getCentralPremium() {
		return centralPremium;
	}
	/**
	 * 属性centralPremium/centralPremium的setter方法
	 */
	public void setCentralPremium(java.lang.Double centralPremium) {
		this.centralPremium = centralPremium;
	} 	
	/**
	 * 属性provincePremium/provincePremium的getter方法
	 */
	public java.lang.Double getProvincePremium() {
		return provincePremium;
	}
	/**
	 * 属性provincePremium/provincePremium的setter方法
	 */
	public void setProvincePremium(java.lang.Double provincePremium) {
		this.provincePremium = provincePremium;
	} 	
	/**
	 * 属性cityPremium/cityPremium的getter方法
	 */
	public java.lang.Double getCityPremium() {
		return cityPremium;
	}
	/**
	 * 属性cityPremium/cityPremium的setter方法
	 */
	public void setCityPremium(java.lang.Double cityPremium) {
		this.cityPremium = cityPremium;
	} 	
	/**
	 * 属性townPremium/townPremium的getter方法
	 */
	public java.lang.Double getTownPremium() {
		return townPremium;
	}
	/**
	 * 属性townPremium/townPremium的setter方法
	 */
	public void setTownPremium(java.lang.Double townPremium) {
		this.townPremium = townPremium;
	} 	
	/**
	 * 属性otherPremium/otherPremium的getter方法
	 */
	public java.lang.Double getOtherPremium() {
		return otherPremium;
	}
	/**
	 * 属性otherPremium/otherPremium的setter方法
	 */
	public void setOtherPremium(java.lang.Double otherPremium) {
		this.otherPremium = otherPremium;
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
	 * 属性mulchDate/mulchDate的getter方法
	 */
	public String getMulchDate() {
		return mulchDate;
	}
	/**
	 * 属性mulchDate/mulchDate的setter方法
	 */
	public void setMulchDate(String mulchDate) {
		this.mulchDate = mulchDate;
	} 	
	/**
	 * 属性mulchType/mulchType的getter方法
	 */
	public String getMulchType() {
		return mulchType;
	}
	/**
	 * 属性mulchType/mulchType的setter方法
	 */
	public void setMulchType(String mulchType) {
		this.mulchType = mulchType;
	} 	
}