package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class ProductQeuryConditionDto  extends BaseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userCode;

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
	
	
}
