package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-08 01:17:24.831 
 * HerdcEndorChgDetailApi操作对象
 */
public class HerdcEndorChgDetailDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性inusreListCode/inusreListCode */
	private String inusreListCode ;		
	/** 属性earLabel/earLabel */
	private String earLabel ;		
	/** 属性kindCode/kindCode */
	private String kindCode ;		
	/** 属性indexCode/indexCode */
	private String indexCode ;		



	/** 属性breedingAreaCode/breedingAreaCode */
	private String breedingAreaCode ;		
	/** 属性species/species */
	private String species ;		
	/** 属性breedingKind/breedingKind */
	private String breedingKind ;		
	/** 属性bank/bank */
	private String bank ;		


	/** 属性amount/amount */
	private Double amount ;
	/** 属性rate/rate */
	private Double rate ;
	/** 属性shortRateFlag/shortRateFlag */
	private String shortRateFlag ;		
	/** 属性shortRate/shortRate */
	private Double shortRate ;

	/** 属性startDate/startDate */
	private java.util.Date startDate ;		
	/** 属性endDate/endDate */
	private java.util.Date endDate ;		
	/** 属性calculateFlag/calculateFlag */
	private String calculateFlag ;		
	/** 属性opCode/opCode */
	private String opCode ;		
	/** 属性opTime/opTime */
	private java.util.Date opTime ;		
	/** 属性validity/validity */
	private String validity ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性breedingNumber/breedingNumber */
	private Integer breedingNumber ;
	/** 属性breedingAreaName/breedingAreaName */
	private String breedingAreaName ;		
	/** 属性startTime/startTime */
	private String startTime ;		
	/** 属性endTime/endTime */
	private String endTime ;		
	/** 属性phone/phone */

	/** 属性settleNumber/settleNumber */
	private Integer settleNumber ;

	/** 属性areaNumber/areaNumber */
	private Double areaNumber ;
	/** 属性litterArea/litterArea */
	private String litterArea ;		
	/** 属性animalAge/animalAge */
	private Double animalAge ;
	/** 标的代码 */
	private String itemCode;

	@ExportConfig(value = "序号")
	private int serialNo;
	@ExportConfig(value = "批单号")
	private String endorseNo;
	@ExportConfig(value = "保单号")
	private String policyNo;
	/** 属性fCode/fCode */
	@ExportConfig(value = "农户代码")
	private String fCode ;
	/** 属性fName/fName */
	@ExportConfig(value = "农户姓名")
	private String fName ;
	/** 属性insureNumber/insureNumber */
	@ExportConfig(value = "投保数量")
	private Integer insureNumber ;
	/** 属性fIdCard/fIdCard */
	@ExportConfig(value = "身份证号码")
	private String fIdCard ;
	/** 属性bankCard/bankCard */
	@ExportConfig(value = "银行卡号")
	private String bankCard ;
	@ExportConfig(value = "联系电话")
	private String phone ;
	@ExportConfig(value = "险别")
	private String kindName;
	@ExportConfig(value = "标的")
	private String itemName;
	/** 属性sumAmount/sumAmount */
	@ExportConfig(value = "总保额（元）")
	private Double sumAmount ;
	/**
	 * 属性总保费/总保费
	 */
	@ExportConfig(value = "总保费（元）")
	private Double sumPremium;
	/** 属性insurePremium/insurePremium */
	@ExportConfig(value = "自缴保费（元）")
	private Double insurePremium ;
	/**
	 * 属性中央财政补贴/中央财政补贴
	 */
	@ExportConfig(value = "中央财政补贴（元）")
	private Double centralPremium;
	/**
	 * 属性省级财政补贴/省级财政补贴
	 */
	@ExportConfig(value = "省级财政补贴（元）")
	private Double provincePremium;
	/**
	 * 属性地市财政补贴/地市财政补贴
	 */
	@ExportConfig(value = "地市财政补贴（元）")
	private Double cityPremium;
	/**
	 * 属性县(区)财政补贴/县(区)财政补贴
	 */
	@ExportConfig(value = "区县财政补贴（元）")
	private Double townPremium;
	/**
	 * 属性其他来源补贴/其他来源补贴
	 */
	@ExportConfig(value = "其他补贴（元）")
	private Double otherPremium;

	private Double fPremium;

	public Double getCentralPremium() {
		return centralPremium;
	}

	public void setCentralPremium(Double centralPremium) {
		this.centralPremium = centralPremium;
	}

	public Double getProvincePremium() {
		return provincePremium;
	}

	public void setProvincePremium(Double provincePremium) {
		this.provincePremium = provincePremium;
	}

	public Double getCityPremium() {
		return cityPremium;
	}

	public void setCityPremium(Double cityPremium) {
		this.cityPremium = cityPremium;
	}

	public Double getTownPremium() {
		return townPremium;
	}

	public void setTownPremium(Double townPremium) {
		this.townPremium = townPremium;
	}

	public Double getOtherPremium() {
		return otherPremium;
	}

	public void setOtherPremium(Double otherPremium) {
		this.otherPremium = otherPremium;
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

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

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
	 * 属性earLabel/earLabel的getter方法
	 */
	public String getEarLabel() {
		return earLabel;
	}
	/**
	 * 属性earLabel/earLabel的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
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
	 * 属性breedingAreaCode/breedingAreaCode的getter方法
	 */
	public String getBreedingAreaCode() {
		return breedingAreaCode;
	}
	/**
	 * 属性breedingAreaCode/breedingAreaCode的setter方法
	 */
	public void setBreedingAreaCode(String breedingAreaCode) {
		this.breedingAreaCode = breedingAreaCode;
	}	
	/**
	 * 属性species/species的getter方法
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * 属性species/species的setter方法
	 */
	public void setSpecies(String species) {
		this.species = species;
	}	
	/**
	 * 属性breedingKind/breedingKind的getter方法
	 */
	public String getBreedingKind() {
		return breedingKind;
	}
	/**
	 * 属性breedingKind/breedingKind的setter方法
	 */
	public void setBreedingKind(String breedingKind) {
		this.breedingKind = breedingKind;
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
	 * 属性bankCard/bankCard的getter方法
	 */
	public String getBankCard() {
		return bankCard;
	}
	/**
	 * 属性bankCard/bankCard的setter方法
	 */
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}	
	/**
	 * 属性insureNumber/insureNumber的getter方法
	 */
	public Integer getInsureNumber() {
		return insureNumber;
	}
	/**
	 * 属性insureNumber/insureNumber的setter方法
	 */
	public void setInsureNumber(Integer insureNumber) {
		this.insureNumber = insureNumber;
	}	
	/**
	 * 属性amount/amount的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性rate/rate的getter方法
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * 属性rate/rate的setter方法
	 */
	public void setRate(Double rate) {
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
	public Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性shortRate/shortRate的setter方法
	 */
	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	}	
	/**
	 * 属性sumAmount/sumAmount的getter方法
	 */
	public Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性sumAmount/sumAmount的setter方法
	 */
	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * 属性sumPremium/sumPremium的getter方法
	 */
	public Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性sumPremium/sumPremium的setter方法
	 */
	public void setSumPremium(Double sumPremium) {
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
	 * 属性breedingNumber/breedingNumber的getter方法
	 */
	public Integer getBreedingNumber() {
		return breedingNumber;
	}
	/**
	 * 属性breedingNumber/breedingNumber的setter方法
	 */
	public void setBreedingNumber(Integer breedingNumber) {
		this.breedingNumber = breedingNumber;
	}	
	/**
	 * 属性breedingAreaName/breedingAreaName的getter方法
	 */
	public String getBreedingAreaName() {
		return breedingAreaName;
	}
	/**
	 * 属性breedingAreaName/breedingAreaName的setter方法
	 */
	public void setBreedingAreaName(String breedingAreaName) {
		this.breedingAreaName = breedingAreaName;
	}	
	/**
	 * 属性startTime/startTime的getter方法
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 属性startTime/startTime的setter方法
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}	
	/**
	 * 属性endTime/endTime的getter方法
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 属性endTime/endTime的setter方法
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	 * 属性settleNumber/settleNumber的getter方法
	 */
	public Integer getSettleNumber() {
		return settleNumber;
	}
	/**
	 * 属性settleNumber/settleNumber的setter方法
	 */
	public void setSettleNumber(Integer settleNumber) {
		this.settleNumber = settleNumber;
	}	
	/**
	 * 属性insurePremium/insurePremium的getter方法
	 */
	public Double getInsurePremium() {
		return insurePremium;
	}
	/**
	 * 属性insurePremium/insurePremium的setter方法
	 */
	public void setInsurePremium(Double insurePremium) {
		this.insurePremium = insurePremium;
	}	
	/**
	 * 属性areaNumber/areaNumber的getter方法
	 */
	public Double getAreaNumber() {
		return areaNumber;
	}
	/**
	 * 属性areaNumber/areaNumber的setter方法
	 */
	public void setAreaNumber(Double areaNumber) {
		this.areaNumber = areaNumber;
	}	
	/**
	 * 属性litterArea/litterArea的getter方法
	 */
	public String getLitterArea() {
		return litterArea;
	}
	/**
	 * 属性litterArea/litterArea的setter方法
	 */
	public void setLitterArea(String litterArea) {
		this.litterArea = litterArea;
	}	
	/**
	 * 属性animalAge/animalAge的getter方法
	 */
	public Double getAnimalAge() {
		return animalAge;
	}
	/**
	 * 属性animalAge/animalAge的setter方法
	 */
	public void setAnimalAge(Double animalAge) {
		this.animalAge = animalAge;
	}

	public Double getfPremium() {
		return fPremium;
	}

	public void setfPremium(Double fPremium) {
		this.fPremium = fPremium;
	}
}
