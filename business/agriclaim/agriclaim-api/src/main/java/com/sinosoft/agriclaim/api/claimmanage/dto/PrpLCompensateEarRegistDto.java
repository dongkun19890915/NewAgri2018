package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 理赔分户清单表Api操作对象
 */
public class PrpLCompensateEarRegistDto extends PrpLCompensateEarDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性农户代码/农户代码 */
	private String code;
	private PrpLCompensateEarDto prpLCompensateEarDto;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public PrpLCompensateEarDto getPrpLCompensateEarDto() {
		return prpLCompensateEarDto;
	}

	public void setPrpLCompensateEarDto(PrpLCompensateEarDto prpLCompensateEarDto) {
		//this.prpLCompensateEarDto = prpLCompensateEarDto;
		this.setCode(prpLCompensateEarDto.getCode());
		this.setEarNo(prpLCompensateEarDto.getEarNo());
		this.setPolicyNo(prpLCompensateEarDto.getPolicyNo());
		this.setRegistNo(prpLCompensateEarDto.getRegistNo());
		this.setClaimNo(prpLCompensateEarDto.getClaimNo());
		this.setCompensateNo(prpLCompensateEarDto.getCompensateNo());
		this.setCombineNo(prpLCompensateEarDto.getCombineNo());
		this.setCaseNo(prpLCompensateEarDto.getCaseNo());
		this.setDamageStartDate(prpLCompensateEarDto.getDamageStartDate());
		this.setDamageStartHour(prpLCompensateEarDto.getDamageStartHour());
		this.setDamageendDate(prpLCompensateEarDto.getDamageendDate());
		this.setDamageCode(prpLCompensateEarDto.getDamageCode());
		this.setDamageName(prpLCompensateEarDto.getDamageName());
		this.setName(prpLCompensateEarDto.getName());
		this.setIdCard(prpLCompensateEarDto.getIdCard());
		this.setBank(prpLCompensateEarDto.getBank());
		this.setAccount(prpLCompensateEarDto.getAccount());
		this.setUnitAmount(prpLCompensateEarDto.getUnitAmount());
		this.setEstimateLoss(prpLCompensateEarDto.getEstimateLoss());
		this.setRestFee(prpLCompensateEarDto.getRestFee());
		this.setClaimRate(prpLCompensateEarDto.getClaimRate());
		this.setDeductibleRate(prpLCompensateEarDto.getDeductibleRate());
		this.setDeductible(prpLCompensateEarDto.getDeductible());
		this.setSumRealpay(prpLCompensateEarDto.getSumRealpay());
		this.setNodeNo(prpLCompensateEarDto.getNodeNo());
		this.setNodeType(prpLCompensateEarDto.getNodeType());
		this.setCullNumber(prpLCompensateEarDto.getCullNumber());
		this.setDeadNumber(prpLCompensateEarDto.getDeadNumber());
		this.setDeadReason(prpLCompensateEarDto.getDeadReason());
		this.setBreedingAreaName(prpLCompensateEarDto.getBreedingAreaName());
		this.setFCode(prpLCompensateEarDto.getFCode());
		this.setBreedingAreaCode(prpLCompensateEarDto.getBreedingAreaCode());
	}
}
