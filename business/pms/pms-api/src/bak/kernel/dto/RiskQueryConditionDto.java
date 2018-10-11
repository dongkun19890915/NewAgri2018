package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;

/**
 * @description 根据险种代码查询险种信息，查询条件入参
 * @author yinqingzhu
 * @date 2016年10月12日下午9:06:51
 */
public class RiskQueryConditionDto extends PmsRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性有效标志/有效标志 */
    private String validInd ;
	public String getValidInd() {
		return validInd;
	}
	public void setValidInd(String validInd) {
		this.validInd = validInd;
	}
}
