package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;

public class WorkFlowModelDto extends BaseRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/** 模板主表信息 */
	private SwfModelMainDto swfModelMainDto;
	/** 工作流节点信息 */
	private List<SwfNodeDto> swfNodeDtoList;
	/** 工作流路径信息 */
	private List<SwfPathDto> swfPathDtoList;
	/** 工作流条件描述信息 */
	private List<SwfConditionDto> swfConditionDtoList;

	public SwfModelMainDto getSwfModelMainDto() {
		return swfModelMainDto;
	}

	public void setSwfModelMainDto(SwfModelMainDto swfModelMainDto) {
		this.swfModelMainDto = swfModelMainDto;
	}

	public List<SwfNodeDto> getSwfNodeDtoList() {
		return swfNodeDtoList;
	}

	public void setSwfNodeDtoList(List<SwfNodeDto> swfNodeDtoList) {
		this.swfNodeDtoList = swfNodeDtoList;
	}

	public List<SwfPathDto> getSwfPathDtoList() {
		return swfPathDtoList;
	}

	public void setSwfPathDtoList(List<SwfPathDto> swfPathDtoList) {
		this.swfPathDtoList = swfPathDtoList;
	}

	public List<SwfConditionDto> getSwfConditionDtoList() {
		return swfConditionDtoList;
	}

	public void setSwfConditionDtoList(List<SwfConditionDto> swfConditionDtoList) {
		this.swfConditionDtoList = swfConditionDtoList;
	}

}
