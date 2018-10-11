package com.sinosoft.agriclaim.api.docmanage.dto;

import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyImgDtoExt;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;

import java.util.List;

public class ClaimListDto {
	private String buttonSaveType;//提交类型
	private String registNo;//报案号
	private String policyNo;
	private String flowId; //工作流id
	private String logNo;  //工作日志no
	private String riskCode; //险种类型
    private String relatePolicyFlag;//是否是关联保单0非1是
    private PrpLRegistDto prpLregistDto; //报案主信息
    private PrpLRegistRPolicyDto prpLRegistRPolicyCompel; //获得关联的强制保单关联信息
    private PrpLcertifyCollectDtoExt prpLcertifyCollectDtoExt;
    private PrpLCertifyImgDtoExt prpLCertifyImgDtoExt;
    private PrplCertifyDirectDtoExt prplCertifyDirectDtoExt;
    private List<PrpDcodeDto> imageTypeList;
    private List<PrpDcodeDto> qualityCheckList;
    private CertifyDto certifyDto;
    
    
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	public String getButtonSaveType() {
		return buttonSaveType;
	}
	public void setButtonSaveType(String buttonSaveType) {
		this.buttonSaveType = buttonSaveType;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public CertifyDto getCertifyDto() {
		return certifyDto;
	}
	public void setCertifyDto(CertifyDto certifyDto) {
		this.certifyDto = certifyDto;
	}
	public List<PrpDcodeDto> getQualityCheckList() {
		return qualityCheckList;
	}
	public void setQualityCheckList(List<PrpDcodeDto> qualityCheckList) {
		this.qualityCheckList = qualityCheckList;
	}
	public List<PrpDcodeDto> getImageTypeList() {
		return imageTypeList;
	}
	public void setImageTypeList(List<PrpDcodeDto> imageTypeList) {
		this.imageTypeList = imageTypeList;
	}
	public PrplCertifyDirectDtoExt getPrplCertifyDirectDtoExt() {
		return prplCertifyDirectDtoExt;
	}
	public void setPrplCertifyDirectDtoExt(PrplCertifyDirectDtoExt prplCertifyDirectDtoExt) {
		this.prplCertifyDirectDtoExt = prplCertifyDirectDtoExt;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRelatePolicyFlag() {
		return relatePolicyFlag;
	}
	public void setRelatePolicyFlag(String relatePolicyFlag) {
		this.relatePolicyFlag = relatePolicyFlag;
	}
	public PrpLRegistDto getPrpLregistDto() {
		return prpLregistDto;
	}
	public void setPrpLregistDto(PrpLRegistDto prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}
	public PrpLRegistRPolicyDto getPrpLRegistRPolicyCompel() {
		return prpLRegistRPolicyCompel;
	}
	public void setPrpLRegistRPolicyCompel(PrpLRegistRPolicyDto prpLRegistRPolicyCompel) {
		this.prpLRegistRPolicyCompel = prpLRegistRPolicyCompel;
	}
	public PrpLcertifyCollectDtoExt getPrpLcertifyCollectDtoExt() {
		return prpLcertifyCollectDtoExt;
	}
	public void setPrpLcertifyCollectDtoExt(PrpLcertifyCollectDtoExt prpLcertifyCollectDtoExt) {
		this.prpLcertifyCollectDtoExt = prpLcertifyCollectDtoExt;
	}
	public PrpLCertifyImgDtoExt getPrpLCertifyImgDtoExt() {
		return prpLCertifyImgDtoExt;
	}
	public void setPrpLCertifyImgDtoExt(PrpLCertifyImgDtoExt prpLCertifyImgDtoExt) {
		this.prpLCertifyImgDtoExt = prpLCertifyImgDtoExt;
	}
	
}
