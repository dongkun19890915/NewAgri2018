package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class MessageReturnDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 返回结果code  */
    public String resultCode;

    /** 返回结果msg  */
    public String resultMsg;

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getResultMsg()
    {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg)
    {
        this.resultMsg = resultMsg;
    }
}
