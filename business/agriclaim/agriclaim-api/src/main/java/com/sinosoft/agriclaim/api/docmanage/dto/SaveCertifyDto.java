package com.sinosoft.agriclaim.api.docmanage.dto;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;

import java.util.List;

/**
 * @description: 类功能简述：索赔清单保存dto
 * @author 安齐崇
 * @date 2017年12月29日上午12:17:23
 */
public class SaveCertifyDto {
	/** 工作流id */
	private String flowId;
	/** 流程编号 */
	private String logNo;
	/** 报案号*/
	private String registNo;
	/** 保单号*/
	private String policyNo;
	/** 单证类 */
	private CertifyDto certifyDto;
	/** 影像资料 */
	private List<PrpDcodeDto> imageTypeList;
	/** 报案信息 */
	private PrpLRegistDto prpLregistDto;
    
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public PrpLRegistDto getPrpLregistDto() {
		return prpLregistDto;
	}

	public void setPrpLregistDto(PrpLRegistDto prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getLogNo() {
		return logNo;
	}

	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}

	public CertifyDto getCertifyDto() {
		return certifyDto;
	}

	public void setCertifyDto(CertifyDto certifyDto) {
		this.certifyDto = certifyDto;
	}

	public List<PrpDcodeDto> getImageTypeList() {
		return imageTypeList;
	}

	public void setImageTypeList(List<PrpDcodeDto> imageTypeList) {
		this.imageTypeList = imageTypeList;
	}

}
