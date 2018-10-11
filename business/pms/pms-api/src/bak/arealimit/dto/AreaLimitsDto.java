package com.sinosoft.pms.api.arealimit.dto;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;

import java.util.Date;
import java.util.List;


/**
 * @description 区域销售限额保存时传入数据使用
 * @author yinqingzhu
 * @date 2016年9月28日下午9:19:15
 */
public class AreaLimitsDto extends PmsRequestDto implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    List<PrpdAreaLimitDto> areaLimits ;
    /**生效日期**/
    private Date effectDate;
	/**创建人**/
    private String createBy;
    /**版次号**/
    private String versionNo;
    
	public String getVersionNo()
    {
        return versionNo;
    }

    public void setVersionNo(String versionNo)
    {
        this.versionNo = versionNo;
    }

    public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public List<PrpdAreaLimitDto> getAreaLimits() {
		return areaLimits;
	}

	public void setAreaLimits(List<PrpdAreaLimitDto> areaLimits) {
		this.areaLimits = areaLimits;
	}
	
}
