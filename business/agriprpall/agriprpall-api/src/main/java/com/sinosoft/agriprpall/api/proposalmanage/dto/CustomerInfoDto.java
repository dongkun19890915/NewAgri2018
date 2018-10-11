package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639
 * 投保人/被保人信息Api操作对象
 */
public class CustomerInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保人 */
	private PrpTinsuredDto appliInsuredDto;
	/** 属性被保险人 */
	private PrpTinsuredDto insuredDto;

	/** 属性纳税人 */
	private List<PrpDcustomerTaxPayInfoDto> customerTaxPayInfoDtoList;

	public PrpTinsuredDto getAppliInsuredDto() {
		return appliInsuredDto;
	}

	public void setAppliInsuredDto(PrpTinsuredDto appliInsuredDto) {
		this.appliInsuredDto = appliInsuredDto;
	}

	public PrpTinsuredDto getInsuredDto() {
		return insuredDto;
	}

	public void setInsuredDto(PrpTinsuredDto insuredDto) {
		this.insuredDto = insuredDto;
	}

	public List<PrpDcustomerTaxPayInfoDto> getCustomerTaxPayInfoDtoList() {
		return customerTaxPayInfoDtoList;
	}

	public void setCustomerTaxPayInfoDtoList(List<PrpDcustomerTaxPayInfoDto> customerTaxPayInfoDtoList) {
		this.customerTaxPayInfoDtoList = customerTaxPayInfoDtoList;
	}
}
