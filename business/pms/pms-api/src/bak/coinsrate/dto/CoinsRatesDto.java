package com.sinosoft.pms.api.coinsrate.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;


/**
 * @description 保存传入数据时使用
 * @author yinqingzhu
 * @date 2016年9月28日下午9:32:34
 */
public class CoinsRatesDto extends PmsRequestDto implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    //入参集合
    private List<PrpDcoinsRateDto> prpDcoinsRateDtos = new ArrayList<PrpDcoinsRateDto>(0);
	//生效日期
    private Date effectDate;
	//创建人
    private String createBy;

    public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public List<PrpDcoinsRateDto> getPrpDcoinsRateDtos() {
		return prpDcoinsRateDtos;
	}

	public void setPrpDcoinsRateDtos(List<PrpDcoinsRateDto> prpDcoinsRateDtos) {
		this.prpDcoinsRateDtos = prpDcoinsRateDtos;
	}

	public Date getEffectDate() {
		return effectDate;
}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
}
