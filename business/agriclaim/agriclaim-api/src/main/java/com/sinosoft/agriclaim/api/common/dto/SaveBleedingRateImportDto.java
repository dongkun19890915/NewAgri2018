package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;

import java.io.Serializable;
import java.util.List;

public class SaveBleedingRateImportDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性养殖险字表集合/属性养殖险字表集合 */
	private List<BreedLossRateListDto> breedLossRateListDto;
	/** 属性理赔清单信息主表/属性理赔清单信息主表 */
	private LossRateListDto lossRateListDto;
	/** 清单大对象*/
	private LossRateWholeListDto lossRateWholeListDto ;

	public LossRateWholeListDto getRequestGYLossRateAllListDto() {
		return lossRateWholeListDto;
	}

	public void setRequestGYLossRateAllListDto(LossRateWholeListDto lossRateWholeListDto) {
		this.lossRateWholeListDto = lossRateWholeListDto;
	}

	public List<BreedLossRateListDto> getBreedLossRateListDto() {
		return breedLossRateListDto;
	}

	public void setBreedLossRateListDto(List<BreedLossRateListDto> breedLossRateListDto) {
		this.breedLossRateListDto = breedLossRateListDto;
	}

	public LossRateListDto getLossRateListDto() {
		return lossRateListDto;
	}

	public void setLossRateListDto(LossRateListDto lossRateListDto) {
		this.lossRateListDto = lossRateListDto;
	}

}
