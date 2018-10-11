package com.sinosoft.ims.api.kernel.dto;


import java.io.Serializable;

import com.sinosoft.framework.dto.BaseDto;



/**
 * @description （用一句话描述这个类的作用）
 * @author hzhongkai
 * @date 2016年10月11日下午3:56:58
 */
public class GradeQueryConditionDto extends BaseDto implements Serializable
{
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
