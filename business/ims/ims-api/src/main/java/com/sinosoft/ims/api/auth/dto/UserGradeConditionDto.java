package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseDto;

public class UserGradeConditionDto extends BaseDto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String userCode;
	/** 岗位ID列表/ */
	private List<String> gradeIds ;
	
	/** 岗位ID列表/ */
	private String[] gradeIdArr ;
	public String[] getGradeIdArr() {
		return gradeIdArr;
	}
	public void setGradeIdArr(String[] gradeIdArr) {
		this.gradeIdArr = gradeIdArr;
	}
	public List<String> getGradeIds() {
		return gradeIds;
	}
	public void setGradeIds(List<String> gradeIds) {
		this.gradeIds = gradeIds;
	}

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
}
