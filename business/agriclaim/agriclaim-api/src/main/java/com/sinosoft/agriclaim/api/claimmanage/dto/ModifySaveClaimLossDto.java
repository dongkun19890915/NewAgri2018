package com.sinosoft.agriclaim.api.claimmanage.dto;


import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class ModifySaveClaimLossDto extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	private String claimNo;
	
	List<PrpLClaimLossDto> prpLclaimLossDtoList;

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}


	public List<PrpLClaimLossDto> getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}

	public void setPrpLclaimLossDtoList(List<PrpLClaimLossDto> prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}
}
