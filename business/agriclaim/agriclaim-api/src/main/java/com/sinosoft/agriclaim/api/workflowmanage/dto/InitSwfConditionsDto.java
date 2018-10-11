package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description 路径条件维护页面初始化DTO
 * @author yanghang
 * @date 2017年10月31日
 */
public class InitSwfConditionsDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 模板号 */
    private Integer modelNo;
    
    /** 路径号 */
    private Integer pathNo;
    
    /** 路径名称 */
    private String pathName;
    
    /** 工作流条件信息集合 */
    private List<SwfConditionDto> swfConditionDtoList;

	public Integer getModelNo() {
		return modelNo;
	}

	public void setModelNo(Integer modelNo) {
		this.modelNo = modelNo;
	}

	public Integer getPathNo() {
		return pathNo;
	}

	public void setPathNo(Integer pathNo) {
		this.pathNo = pathNo;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public List<SwfConditionDto> getSwfConditionDtoList() {
		return swfConditionDtoList;
	}

	public void setSwfConditionDtoList(List<SwfConditionDto> swfConditionDtoList) {
		this.swfConditionDtoList = swfConditionDtoList;
	}
    
    
}
