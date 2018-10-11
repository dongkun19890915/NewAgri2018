package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseDto;

public class UserImportDto extends BaseDto implements Serializable
{
    private static final long serialVersionUID = 1L;
    /**文件*/
    private String fileId;
    /**iD*/
    private List<String> gradeIds;
    /**grades类*/
    private List<SaaGradeDto>grades;

    public List<SaaGradeDto> getGrades() {
		return grades;
	}

	public void setGrades(List<SaaGradeDto> grades) {
		this.grades = grades;
	}

	public List<String> getGradeIds()
    {
        return gradeIds;
    }

    public void setGradeIds(List<String> gradeIds)
    {
        this.gradeIds = gradeIds;
    }

    public String getFileId()
    {
        return fileId;
    }

    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }

}
