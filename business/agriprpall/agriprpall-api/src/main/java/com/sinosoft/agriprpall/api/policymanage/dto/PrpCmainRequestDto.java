package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

public class PrpCmainRequestDto extends BasePageableRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**属性 保单基本信息表/保单基本信息表  */
    private PrpCmainDto prpCmainDto;
	/**属性 险种集合/险种集合  */
    private List<String> riskCodeList;
	/**属性 保单号集合/保单号集合  */
    private List<String> policyNoList;
	/** 属性身份证件号/身份证件号  */
    private String identifyNumber;
	/**
	 * 属性保单基本信息表/保单基本信息表的getter方法
	 */
    public PrpCmainDto getPrpCmainDto() {
        return prpCmainDto;
    }
	/**
	 * 属性保单基本信息表/保单基本信息表的setter方法
	 */
    public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
        this.prpCmainDto = prpCmainDto;
    }
	/**
	 * 属性 险种集合/ 险种集合的getter方法
	 */
    public List<String> getRiskCodeList() {
        return riskCodeList;
    }
	/**
	 * 属性 险种集合/ 险种集合的setter方法
	 */
    public void setRiskCodeList(List<String> riskCodeList) {
        this.riskCodeList = riskCodeList;
    }
	/**
	 * 属性保单号集合/保单号集合的getter方法
	 */
    public List<String> getPolicyNoList() {
        return policyNoList;
    }
	/**
	 * 属性约定单价/约定单价的setter方法
	 */
    public void setPolicyNoList(List<String> policyNoList) {
        this.policyNoList = policyNoList;
    }
	/**
	 * 属性约定单价/约定单价的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性约定单价/约定单价的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
    
}
