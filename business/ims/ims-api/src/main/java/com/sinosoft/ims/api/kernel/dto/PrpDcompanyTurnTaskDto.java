package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description 理赔任务转交机构拓展类
 * @author 杨航
 * @date 2017年12月11日上午10:41:27
 */
public class PrpDcompanyTurnTaskDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	// 机构Dto
	private PrpDcompanyDto prpDcompanyDto;
	// 是否下级机构标志位
	private String ifHasDownCompany;

	public PrpDcompanyDto getPrpDcompanyDto() {
		return prpDcompanyDto;
	}

	public void setPrpDcompanyDto(PrpDcompanyDto prpDcompanyDto) {
		this.prpDcompanyDto = prpDcompanyDto;
	}

	public String getIfHasDownCompany() {
		return ifHasDownCompany;
	}

	public void setIfHasDownCompany(String ifHasDownCompany) {
		this.ifHasDownCompany = ifHasDownCompany;
	}

}
