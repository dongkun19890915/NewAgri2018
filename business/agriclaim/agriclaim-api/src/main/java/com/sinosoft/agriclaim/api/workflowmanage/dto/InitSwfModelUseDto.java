package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;

public class InitSwfModelUseDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 模板主信息 */
	private List<SwfModelMainDto> swfModelMainDtos;
	/** 险种信息 */
	private List<PrpDriskDto> prpdriskDtoList;
	/** 机构信息 */
	private List<PrpDcompanyDto> prpDcompanyDtoList;
	/** 险种信息 */
	private List<ResponseRiskAndCompanyDto> riskInfos;
	/** 机构信息 */
	private List<ResponseRiskAndCompanyDto> companyInfos;

	public List<SwfModelMainDto> getSwfModelMainDtos() {
		return swfModelMainDtos;
	}

	public void setSwfModelMainDtos(List<SwfModelMainDto> swfModelMainDtos) {
		this.swfModelMainDtos = swfModelMainDtos;
	}

	public List<PrpDcompanyDto> getPrpDcompanyDtoList() {
		return prpDcompanyDtoList;
	}

	public void setPrpDcompanyDtoList(List<PrpDcompanyDto> prpDcompanyDtoList) {
		this.prpDcompanyDtoList = prpDcompanyDtoList;
	}

	public List<PrpDriskDto> getPrpdriskDtoList() {
		return prpdriskDtoList;
	}

	public void setPrpdriskDtoList(List<PrpDriskDto> prpdriskDtoList) {
		this.prpdriskDtoList = prpdriskDtoList;
	}
	public List<ResponseRiskAndCompanyDto> getRiskInfos() {
		return riskInfos;
	}

	public void setRiskInfos(List<ResponseRiskAndCompanyDto> riskInfos) {
		this.riskInfos = riskInfos;
	}

	public List<ResponseRiskAndCompanyDto> getCompanyInfos() {
		return companyInfos;
	}

	public void setCompanyInfos(List<ResponseRiskAndCompanyDto> companyInfos) {
		this.companyInfos = companyInfos;
	}

}
