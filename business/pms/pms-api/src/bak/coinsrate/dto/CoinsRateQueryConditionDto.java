package com.sinosoft.pms.api.coinsrate.dto;

import java.util.Date;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;

/**
 * @description 共保比例和共保比例列表查询时使用
 * @author yinqingzhu
 * @date 2016年9月28日下午9:28:44
 */
public class CoinsRateQueryConditionDto extends PmsRequestDto implements java.io.Serializable{
    //共保体公司代码
	String comCode ;
	//失效日期
	private Date invalidDate; 

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

    public Date getInvalidDate()
    {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate)
    {
        this.invalidDate = invalidDate;
    }
	
}
