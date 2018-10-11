package com.sinosoft.pms.api.arealimit.dto;


import com.sinosoft.pms.api.common.dto.PmsRequestDto;

import java.util.Date;


/**
 * @description 区域销售限额查询时使用
 * @author yinqingzhu
 * @date 2016年9月28日下午9:17:26
 */
public class AreaLimitQueryConditionDto extends PmsRequestDto implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    //区域代码
	String areaCode ;
	//生效日期
	Date effectDate;
	//失效日期
	Date invalidDate;
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

}
