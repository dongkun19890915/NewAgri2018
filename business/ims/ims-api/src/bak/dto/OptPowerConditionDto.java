package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseDto;
/**
 * 验证操作权限的入口参数类-methodCode/actionURL 必填一项
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016-10-16 21:40
 */
public class OptPowerConditionDto extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户代码
	 */
	private String userCode;
    /**
     * 请求URL 对应 Smc_Menu/Saa_MethodTask(methodCode)
     */
    private String actionURL;
    
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getActionURL() {
		return actionURL;
	}
	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}    
    
}
