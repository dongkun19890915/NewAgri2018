package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseDto;
import com.sinosoft.framework.dto.BasePageableRequest;

public class PowerConditionDto extends BasePageableRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String systemCode;
	
	private String userCode;

    private String taskId;
    
    /*
     * 表名，在PowerConstants.TABLE_PK中定义
     */
    private String tableName;
    
    /*
     * 外部条件控制表名
     */
    private String outerTableName;
	
	private List<PrpDCompanyDto> companyList;
	   
	
    public String getSystemCode()
    {
        return systemCode;
    }
    public void setSystemCode(String systemCode)
    {
        this.systemCode = systemCode;
    }
    public String getTableName()
    {
        return tableName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    public String getOuterTableName()
    {
        return outerTableName;
    }
    public void setOuterTableName(String outerTableName)
    {
        this.outerTableName = outerTableName;
    }
    public String getUserCode()
    {
        return userCode;
    }
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public List<PrpDCompanyDto> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<PrpDCompanyDto> companyList) {
		this.companyList = companyList;
	}
	
}
