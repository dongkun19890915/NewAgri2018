package com.sinosoft.agriclaim.api.combinemanage.dto;
/**
 * @description: 扩展类
 * @author chong
 * @date 2017112111:11:10
 */

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;

public class PrpLPropDtoExt  {

	
	private static final long serialVersionUID = 1L;
	private PrpLPropDto prpLPropDto;
	private String FamilyName;
	private String LossItemName;
	private String kindName;
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public PrpLPropDto getPrpLPropDto() {
		return prpLPropDto;
	}
	public void setPrpLPropDto(PrpLPropDto prpLPropDto) {
		this.prpLPropDto = prpLPropDto;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	public String getLossItemName() {
		return LossItemName;
	}
	public void setLossItemName(String lossItemName) {
		LossItemName = lossItemName;
	}
	
	
}
