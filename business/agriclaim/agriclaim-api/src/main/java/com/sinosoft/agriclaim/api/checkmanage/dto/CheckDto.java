package com.sinosoft.agriclaim.api.checkmanage.dto;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 类功能简述：查勘传输对象
 * @author chong
 * @date 2017年11月9日下午4:29:33
 */
public class CheckDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 查勘主信息 */
	private PrpLCheckDto prpLcheckDto;
	private PrpLextDto prpLextDto;
    /*报案文本信息*/
	private List<PrpLRegistTextDto> prpLregistTextDtoList;
    /*查勘扩展信息*/
	private List<PrpLCheckExtDto> prpLCheckExtDtoList;
	/*估损金额表*/
	private List<PrpLCheckLossDto> prpLCheckLossDtoList;
	/*报案状态信息*/
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/*报案扩展信息*/
	private List<PrpLRegistExtDto> prpLRegistExtDtoList;
	
	public PrpLextDto getPrpLextDto() {
		return prpLextDto;
	}

	public void setPrpLextDto(PrpLextDto prpLextDto) {
		this.prpLextDto = prpLextDto;
	}

	public List<PrpLRegistExtDto> getPrpLRegistExtDtoList() {
		return prpLRegistExtDtoList;
	}

	public void setPrpLRegistExtDtoList(List<PrpLRegistExtDto> prpLRegistExtDtoList) {
		this.prpLRegistExtDtoList = prpLRegistExtDtoList;
	}

	public PrpLCheckDto getPrpLcheckDto() {
		return prpLcheckDto;
	}

	public void setPrpLcheckDto(PrpLCheckDto prpLcheckDto) {
		this.prpLcheckDto = prpLcheckDto;
	}

	public List<PrpLRegistTextDto> getPrpLregistTextDtoList() {
		return prpLregistTextDtoList;
	}

	public void setPrpLregistTextDtoList(List<PrpLRegistTextDto> prpLregistTextDtoList) {
		this.prpLregistTextDtoList = prpLregistTextDtoList;
	}

	public List<PrpLCheckExtDto> getPrpLCheckExtDtoList() {
		return prpLCheckExtDtoList;
	}

	public void setPrpLCheckExtDtoList(List<PrpLCheckExtDto> prpLCheckExtDtoList) {
		this.prpLCheckExtDtoList = prpLCheckExtDtoList;
	}

	public List<PrpLCheckLossDto> getPrpLCheckLossDtoList() {
		return prpLCheckLossDtoList;
	}

	public void setPrpLCheckLossDtoList(List<PrpLCheckLossDto> prpLCheckLossDtoList) {
		this.prpLCheckLossDtoList = prpLCheckLossDtoList;
	}

	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

}
