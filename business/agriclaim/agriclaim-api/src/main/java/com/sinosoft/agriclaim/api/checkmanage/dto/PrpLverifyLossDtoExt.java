package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDtoExt;

/**
 * @description: 类功能简述：定损扩展表
 * @author chong
 * @date 2017年11月18日下午3:40:49
 */
public class PrpLverifyLossDtoExt extends PrpLverifyLossDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*财产核定损明细清单表信息*/
	private List<PrpLPropDtoExt> prpLpropDtoExtList;
	public List<PrpLPropDtoExt> getPrpLpropDtoExtList() {
		return prpLpropDtoExtList;
	}
	public void setPrpLpropDtoExtList(List<PrpLPropDtoExt> prpLpropDtoExtList) {
		this.prpLpropDtoExtList = prpLpropDtoExtList;
	}

}
