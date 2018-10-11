package com.sinosoft.dms.core.dict.entity;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.io.Serializable;

public class PrpDNewCodeKey extends BasePKImpl implements Serializable{
	private static final long serialVersionUID = 1L;
    private String codeCode;

    private String codeType;

    public String getCodeCode()
    {
        return codeCode;
    }

    public void setCodeCode(String codeCode)
    {
        this.codeCode = codeCode;
    }

    public String getCodeType()
    {
        return codeType;
    }

    public void setCodeType(String codeType)
    {
        this.codeType = codeType;
    }

    
}