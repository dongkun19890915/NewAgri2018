package com.sinosoft.agriclaim.api.claimmanage.dto;

public class PrpLClaimDtoSaveExt extends PrpLClaimDto{
	private static final long serialVersionUID = 1L;
	private String llflag;
	private PrpLClaimDto prpLClaimDto;

	public String getLlflag() {
		return llflag;
	}

	public void setLlflag(String llflag) {
		this.llflag = llflag;
	}

	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}

	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		//this.prpLClaimDto = prpLClaimDto;
		this.setClaimNo(prpLClaimDto.getClaimNo());
		this.setLFlag(prpLClaimDto.getLFlag());
		this.setLlflag(prpLClaimDto.getLFlag());
		this.setCaseNo(prpLClaimDto.getCaseNo());
		this.setClassCode(prpLClaimDto.getClassCode());
		this.setRiskCode(prpLClaimDto.getRiskCode());
		this.setRegistNo(prpLClaimDto.getRegistNo());
		this.setPolicyNo(prpLClaimDto.getPolicyNo());
		this.setBusinessNature(prpLClaimDto.getBusinessNature());
		this.setLanguage(prpLClaimDto.getLanguage());
		this.setPolicyType(prpLClaimDto.getPolicyType());
		this.setInsuredCode(prpLClaimDto.getInsuredCode());
		this.setInsuredName(prpLClaimDto.getInsuredName());
		this.setStartDate(prpLClaimDto.getStartDate());
		this.setStartHour(prpLClaimDto.getStartHour());
		this.setEndDate(prpLClaimDto.getEndDate());
		this.setEndHour(prpLClaimDto.getEndHour());
		this.setCurrency(prpLClaimDto.getCurrency());
		this.setSumAmount(prpLClaimDto.getSumAmount());
		this.setSumPremium(prpLClaimDto.getSumPremium());
		this.setDamageStartDate(prpLClaimDto.getDamageStartDate());
		this.setDamageStartHour(prpLClaimDto.getDamageStartHour());
		this.setDamageEndDate(prpLClaimDto.getDamageEndDate());
		this.setDamageEndHour(prpLClaimDto.getDamageEndHour());
		this.setDamageCode(prpLClaimDto.getDamageCode());
		this.setDamageName(prpLClaimDto.getDamageName());
		this.setDamageTypeCode(prpLClaimDto.getDamageTypeCode());
		this.setDamageTypeName(prpLClaimDto.getDamageTypeName());
		this.setDamageAreaCode(prpLClaimDto.getDamageAreaCode());
		this.setDamageAreaName(prpLClaimDto.getDamageAreaName());
		this.setDamageAddressType(prpLClaimDto.getDamageAddressType());
		this.setAddressCode(prpLClaimDto.getAddressCode());
		this.setDamageAddress(prpLClaimDto.getDamageAddress());
		this.setLossName(prpLClaimDto.getLossName());
		this.setLossQuantity(prpLClaimDto.getLossQuantity());
		this.setDamageKind(prpLClaimDto.getDamageKind());
		this.setClaimDate(prpLClaimDto.getClaimDate());
		this.setIndemnityDuty(prpLClaimDto.getIndemnityDuty());
		this.setIndemnityDutyRate(prpLClaimDto.getIndemnityDutyRate());
		this.setDeductibleRate(prpLClaimDto.getDeductibleRate());
		this.setSumClaim(prpLClaimDto.getSumClaim());
		this.setSumDefLoss(prpLClaimDto.getSumDefLoss());
		this.setSumPaid(prpLClaimDto.getSumPaid());
		this.setSumReplevy(prpLClaimDto.getSumReplevy());
		this.setRemark(prpLClaimDto.getRemark());
		this.setCaseType(prpLClaimDto.getCaseType());
		this.setMakeCom(prpLClaimDto.getMakeCom());
		this.setComCode(prpLClaimDto.getComCode());
		this.setAgentCode(prpLClaimDto.getAgentCode());
		this.setHandlerCode(prpLClaimDto.getHandlerCode());
		this.setHandler1Code(prpLClaimDto.getHandler1Code());
		this.setStatisticsYM(prpLClaimDto.getStatisticsYM());
		this.setOperatorCode(prpLClaimDto.getOperatorCode());
		this.setInputDate(prpLClaimDto.getInputDate());
		this.setEndCaseDate(prpLClaimDto.getEndCaseDate());
		this.setEndCaserCode(prpLClaimDto.getEndCaserCode());
		this.setCancelDate(prpLClaimDto.getCancelDate());
		this.setCancelReason(prpLClaimDto.getCancelReason());
		this.setDealerCode(prpLClaimDto.getDealerCode());
		this.setEscapeFlag(prpLClaimDto.getEscapeFlag());
		this.setFlag(prpLClaimDto.getFlag());
		this.setReplevyFlag(prpLClaimDto.getReplevyFlag());
		this.setThirdComFlag(prpLClaimDto.getThirdComFlag());
		this.setEndCaseFlag(prpLClaimDto.getEndCaseFlag());
		this.setCIndemnityDutyRate(prpLClaimDto.getCIndemnityDutyRate());
		this.setDamageAreaPostCode(prpLClaimDto.getDamageAreaPostCode());
		this.setCatastropheCode1(prpLClaimDto.getCatastropheCode1());
		this.setCatastropheName1(prpLClaimDto.getCatastropheName1());
		this.setCatastropheCode2(prpLClaimDto.getCatastropheCode2());
		this.setCatastropheName2(prpLClaimDto.getCatastropheName2());
		this.setClaimType(prpLClaimDto.getClaimType());
		this.setLossesNumber(prpLClaimDto.getLossesNumber());
		this.setLossesUnitCode(prpLClaimDto.getLossesUnitCode());
		this.setDamageInsured(prpLClaimDto.getDamageInsured());
		this.setDisasterArea(prpLClaimDto.getDisasterArea());
		this.setDisasterUnit(prpLClaimDto.getDisasterUnit());
		this.setAffectedArea(prpLClaimDto.getAffectedArea());
		this.setAffectedUnit(prpLClaimDto.getAffectedUnit());
		this.setNoProductionArea(prpLClaimDto.getNoProductionArea());
		this.setNoProductionUnit(prpLClaimDto.getNoProductionUnit());
		this.setDeathQuantity(prpLClaimDto.getDeathQuantity());
		this.setDeathUnit(prpLClaimDto.getDeathUnit());
		this.setKillQuantity(prpLClaimDto.getKillQuantity());
		this.setKillUnit(prpLClaimDto.getKillUnit());
		this.setBusinessType(prpLClaimDto.getBusinessType());
		this.setBusinessType1(prpLClaimDto.getBusinessType1());
		this.setMedicalType(prpLClaimDto.getMedicalType());
		this.setBusinessFlag(prpLClaimDto.getBusinessFlag());
		this.setOtherFlag(prpLClaimDto.getOtherFlag());
		this.setClaimLossFlag(prpLClaimDto.getClaimLossFlag());
		this.setAvgFlag(prpLClaimDto.getAvgFlag());
		this.setFifteenFlag(prpLClaimDto.getFifteenFlag());
		this.setThirtyFlag(prpLClaimDto.getThirtyFlag());
		this.setCancelReasonExplan(prpLClaimDto.getCancelReasonExplan());
		this.setAutoFlag(prpLClaimDto.getAutoFlag());
		this.setClaimTime(prpLClaimDto.getClaimTime());
		this.setUpDateBy(prpLClaimDto.getUpDateBy());
		this.setUpDateDate(prpLClaimDto.getUpDateDate());
	}
}
