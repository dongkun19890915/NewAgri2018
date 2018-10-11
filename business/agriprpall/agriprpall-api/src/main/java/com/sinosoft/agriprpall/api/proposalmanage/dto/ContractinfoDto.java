package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 合同信息Api操作对象
 */
public class ContractinfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保方式/投保方式 */
	private String policyType ;		
	/** 属性按何种方式确定保险金额/按何种方式确定保险金额 */
	private String proposalType ;		
	/** 属性承保数量/承保数量 */
	private Double statQuantity ;
	/** 属性参保农户户次/参保农户户次 */
	private Double sumInsured ;
	/** 属性种植时间/种植时间 */
	private java.util.Date raiseDate ;		
	/** 属性承保清单归属区域/承保清单归属区域 */
	private String fareaCode ;		
	/** 属性清单编号/清单编号 */
	private String insureListCode ;
    private String gisInsureListCode;
    /** 属性清单类型/清单类型 */
	private String valicity ;		
	/** 属性清单备注/清单备注 */
	private String remark ;		
	/** 属性序号/序号 */
	private Integer addressNo ;
	/** 属性邮政编码/邮政编码 */
	private String addressCode ;		
	/** 属性地址/地址 */
	private String addressName ;		
	/** 属性汇总币别/汇总币别 */
	private String currency2 ;		
	/** 属性支付币别/支付币别 */
	private String currency1 ;		
	/** 属性原币/原币 */
	private String currency ;		
	/** 属性原保额/原保额 */
	private Double amount ;
	/** 属性原保费/原保费 */
	private Double premium ;
	/** 属性汇总兑换率/汇总兑换率 */
	private Double exchangeRate2 ;
	/** 属性汇总保额/汇总保额 */
	private Double amount2 ;
	/** 属性汇总保费/汇总保费 */
	private Double premium2 ;
	/** 属性支付兑换率/支付兑换率 */
	private Double exchangeRate1 ;
	/** 属性支付兑换保额/支付兑换保额 */
	private Double amount1 ;
	/** 属性支付兑换保费/支付兑换保费 */
	private Double premium1 ;
	/** 属性缴费次数/缴费次数 */
	private Integer payTimes ;
	/** 险种信息 */
	private List<PrpTitemKindDto> prpTitemKindList;
	/** 险种信息 */
	private List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList;
	/** 补贴信息 */
	private List<PrpTsubsidyDto> prpTsubsidyList;
	private PrpTmainAgriDto prpTmainAgriDto;
	/** 缴费计划信息 */
	private List<PrpTplanDto> prpTplanList;
	private Double noTaxPremium;
	private Double noTaxPremium1;
	private Double noTaxPremium2;
	private Double taxFee ;
	private Double taxFee1 ;
	private String currency2Name;
	private String listTypeFlag;
	/** 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到） */
	private String raiseType ;

	public List<PrpTitemKindAgriDto> getPrpTitemKindAgriDtoList() {
		return prpTitemKindAgriDtoList;
	}

	public void setPrpTitemKindAgriDtoList(List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList) {
		this.prpTitemKindAgriDtoList = prpTitemKindAgriDtoList;
	}

	public String getGisInsureListCode() {
        return gisInsureListCode;
    }

    public void setGisInsureListCode(String gisInsureListCode) {
        this.gisInsureListCode = gisInsureListCode;
    }

	public String getCurrency2Name() {
		return currency2Name;
	}

	public void setCurrency2Name(String currency2Name) {
		this.currency2Name = currency2Name;
	}

	public Double getNoTaxPremium() {
		return noTaxPremium;
	}

	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}

	public Double getNoTaxPremium1() {
		return noTaxPremium1;
	}

	public void setNoTaxPremium1(Double noTaxPremium1) {
		this.noTaxPremium1 = noTaxPremium1;
	}

	public Double getNoTaxPremium2() {
		return noTaxPremium2;
	}

	public void setNoTaxPremium2(Double noTaxPremium2) {
		this.noTaxPremium2 = noTaxPremium2;
	}

	public Double getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}

	public Double getTaxFee1() {
		return taxFee1;
	}

	public void setTaxFee1(Double taxFee1) {
		this.taxFee1 = taxFee1;
	}

	public Double getTaxFee2() {
		return taxFee2;
	}

	public void setTaxFee2(Double taxFee2) {
		this.taxFee2 = taxFee2;
	}

	private Double taxFee2 ;

	/**
	 * 属性缴费次数/缴费次数的getter方法
	 */
	public Integer getPayTimes() {
		return payTimes;
	}

	/**
	 * 属性缴费次数/缴费次数的setter方法
	 */
	public void setPayTimes(Integer payTimes) {
		this.payTimes = payTimes;
	}

	public List<PrpTitemKindDto> getPrpTitemKindList() {
		return prpTitemKindList;
	}

	public void setPrpTitemKindList(List<PrpTitemKindDto> prpTitemKindList) {
		this.prpTitemKindList = prpTitemKindList;
	}

	public List<PrpTplanDto> getPrpTplanList() {
		return prpTplanList;
	}

	public void setPrpTplanList(List<PrpTplanDto> prpTplanList) {
		this.prpTplanList = prpTplanList;
	}

	public List<PrpTsubsidyDto> getPrpTsubsidyList() {
		return prpTsubsidyList;
	}

	public void setPrpTsubsidyList(List<PrpTsubsidyDto> prpTsubsidyList) {
		this.prpTsubsidyList = prpTsubsidyList;
	}

	/**
	 * 属性投保方式/投保方式的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性投保方式/投保方式的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}	
	/**
	 * 属性按何种方式确定保险金额/按何种方式确定保险金额的getter方法
	 */
	public String getProposalType() {
		return proposalType;
	}
	/**
	 * 属性按何种方式确定保险金额/按何种方式确定保险金额的setter方法
	 */
	public void setProposalType(String proposalType) {
		this.proposalType = proposalType;
	}	
	/**
	 * 属性承保数量/承保数量的getter方法
	 */
	public Double getStatQuantity() {
		return statQuantity;
	}
	/**
	 * 属性承保数量/承保数量的setter方法
	 */
	public void setStatQuantity(Double statQuantity) {
		this.statQuantity = statQuantity;
	}	
	/**
	 * 属性参保农户户次/参保农户户次的getter方法
	 */
	public Double getSumInsured() {
		return sumInsured;
	}
	/**
	 * 属性参保农户户次/参保农户户次的setter方法
	 */
	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}	
	/**
	 * 属性种植时间/种植时间的getter方法
	 */
	public java.util.Date getRaiseDate() {
		return raiseDate;
	}
	/**
	 * 属性种植时间/种植时间的setter方法
	 */
	public void setRaiseDate(java.util.Date raiseDate) {
		this.raiseDate = raiseDate;
	}	
	/**
	 * 属性承保清单归属区域/承保清单归属区域的getter方法
	 */
	public String getFareaCode() {
		return fareaCode;
	}
	/**
	 * 属性承保清单归属区域/承保清单归属区域的setter方法
	 */
	public void setFareaCode(String fareaCode) {
		this.fareaCode = fareaCode;
	}

	public String getInsureListCode() {
		return insureListCode;
	}

	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
	}

	/**
	 * 属性清单类型/清单类型的getter方法
	 */
	public String getValicity() {
		return valicity;
	}
	/**
	 * 属性清单类型/清单类型的setter方法
	 */
	public void setValicity(String valicity) {
		this.valicity = valicity;
	}	
	/**
	 * 属性清单备注/清单备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性清单备注/清单备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}	
	/**
	 * 属性地址/地址的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性地址/地址的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}	
	/**
	 * 属性汇总币别/汇总币别的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性汇总币别/汇总币别的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}	
	/**
	 * 属性支付币别/支付币别的getter方法
	 */
	public String getCurrency1() {
		return currency1;
	}
	/**
	 * 属性支付币别/支付币别的setter方法
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}	
	/**
	 * 属性原币/原币的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性原币/原币的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性原保额/原保额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性原保额/原保额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性原保费/原保费的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性原保费/原保费的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性汇总兑换率/汇总兑换率的getter方法
	 */
	public Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性汇总兑换率/汇总兑换率的setter方法
	 */
	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}	
	/**
	 * 属性汇总保额/汇总保额的getter方法
	 */
	public Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性汇总保额/汇总保额的setter方法
	 */
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}	
	/**
	 * 属性汇总保费/汇总保费的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性汇总保费/汇总保费的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}	
	/**
	 * 属性支付兑换率/支付兑换率的getter方法
	 */
	public Double getExchangeRate1() {
		return exchangeRate1;
	}
	/**
	 * 属性支付兑换率/支付兑换率的setter方法
	 */
	public void setExchangeRate1(Double exchangeRate1) {
		this.exchangeRate1 = exchangeRate1;
	}	
	/**
	 * 属性支付兑换保额/支付兑换保额的getter方法
	 */
	public Double getAmount1() {
		return amount1;
	}
	/**
	 * 属性支付兑换保额/支付兑换保额的setter方法
	 */
	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}	
	/**
	 * 属性支付兑换保费/支付兑换保费的getter方法
	 */
	public Double getPremium1() {
		return premium1;
	}
	/**
	 * 属性支付兑换保费/支付兑换保费的setter方法
	 */
	public void setPremium1(Double premium1) {
		this.premium1 = premium1;
	}

	public String getListTypeFlag() {
		return listTypeFlag;
	}

	public void setListTypeFlag(String listTypeFlag) {
		this.listTypeFlag = listTypeFlag;
	}

	public String getRaiseType() {		return raiseType;	}

	public void setRaiseType(String raiseType) {		this.raiseType = raiseType;	}

	public PrpTmainAgriDto getPrpTmainAgriDto() {		return prpTmainAgriDto;	}

	public void setPrpTmainAgriDto(PrpTmainAgriDto prpTmainAgriDto) {		this.prpTmainAgriDto = prpTmainAgriDto;	}
}
