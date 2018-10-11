package com.sinosoft.agriclaim.api.workflowmanage.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;

public class SwfModelUseSaveDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 模板号 */
	private Integer modelNo;
	/** 模板状态 */
	private String modelStatus;
	/** 选中的险种号 */
	private List<String> riskCodes;
	/** 选中的机构代码 */
	private List<String> comCodes;

	public Integer getModelNo() {
		return modelNo;
	}

	public void setModelNo(Integer modelNo) {
		this.modelNo = modelNo;
	}

	public String getModelStatus() {
		return modelStatus;
	}

	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	}

	public List<String> getRiskCodes() {
		return riskCodes;
	}

	public void setRiskCodes(List<String> riskCodes) {
		this.riskCodes = riskCodes;
	}

	public List<String> getComCodes() {
		return comCodes;
	}

	public void setComCodes(List<String> comCodes) {
		this.comCodes = comCodes;
	}

}
