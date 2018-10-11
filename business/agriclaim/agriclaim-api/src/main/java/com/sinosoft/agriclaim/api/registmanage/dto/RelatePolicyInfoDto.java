package com.sinosoft.agriclaim.api.registmanage.dto;


import java.io.Serializable;
import java.util.List;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author 陈旭
 * @time  2017-11-14 15:38:49.324 
 * 保单关联信息Api操作对象
 */
public class RelatePolicyInfoDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性保单主信息 */
	private PrpCmainDto prpCmainDto;
	/** 属性批单信息 */
	private List<PrpPheadDto> prpPheadDtoList;
	/** 属性理赔信息 */
	private List<RelateRegistExtDto> prpLregistDtoList;
	
	public PrpCmainDto getPrpCmainDto() {
		return prpCmainDto;
	}
	public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
		this.prpCmainDto = prpCmainDto;
	}
	public List<PrpPheadDto> getPrpPheadDtoList() {
		return prpPheadDtoList;
	}
	public void setPrpPheadDtoList(List<PrpPheadDto> prpPheadDtoList) {
		this.prpPheadDtoList = prpPheadDtoList;
	}
	public List<RelateRegistExtDto> getPrpLregistDtoList() {
		return prpLregistDtoList;
	}
	public void setPrpLregistDtoList(List<RelateRegistExtDto> prpLregistDtoList) {
		this.prpLregistDtoList = prpLregistDtoList;
	}

	

}
