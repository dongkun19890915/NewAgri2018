package com.sinosoft.agriclaim.api.registmanage.dto;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarRegistDto;
import com.sinosoft.agriclaim.api.common.dto.LoginUserDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;


public class ReportDto extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 /** 耳标号清单列表*/
	private List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList;
	  /** 报案主信息*/
	private PrpLRegistDtoExtend prpLregistDto;
	 /** 强三关联信息*/
	private List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList;
	/** 文本信息*/
	private List<PrpLRegistTextDto> prpLregistTextDtoList; 
	/**出险原因详细信息*/
	private List<PrpLRegistTextDto> prpLregistTextDtoDetailList;
	/** 调度主表信息*/
	private PrpLScheduleMainWfDto prpLScheduleMainWfDto;           
	  /** 调度表的信息*/
	private List<PrpLScheduleItemDto> prplScheduleItemDtoList;           
	/** 操作状态信息*/
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/** 登录用户的相关信息 */
	private LoginUserDto loginUserDto;

	public LoginUserDto getLoginUserDto() {
		return loginUserDto;
	}

	public void setLoginUserDto(LoginUserDto loginUserDto) {
		this.loginUserDto = loginUserDto;
	}

	public List<PrpLRegistRPolicyDto> getPrpLRegistRPolicyDtoList() {
		return prpLRegistRPolicyDtoList;
	}
	public void setPrpLRegistRPolicyDtoList(List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList) {
		this.prpLRegistRPolicyDtoList = prpLRegistRPolicyDtoList;
	}
	public List<PrpLRegistTextDto> getPrpLregistTextDtoList() {
		return prpLregistTextDtoList;
	}
	public void setPrpLregistTextDtoList(List<PrpLRegistTextDto> prpLregistTextDtoList) {
		this.prpLregistTextDtoList = prpLregistTextDtoList;
	}
	public List<PrpLScheduleItemDto> getPrplScheduleItemDtoList() {
		return prplScheduleItemDtoList;
	}
	public void setPrplScheduleItemDtoList(List<PrpLScheduleItemDto> prplScheduleItemDtoList) {
		this.prplScheduleItemDtoList = prplScheduleItemDtoList;
	}
	public PrpLRegistDtoExtend getPrpLregistDto() {
		return prpLregistDto;
	}
	public void setPrpLregistDto(PrpLRegistDtoExtend prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}
	public List<PrpLRegistTextDto> getPrpLregistTextDtoDetailList() {
		return prpLregistTextDtoDetailList;
	}
	public void setPrpLregistTextDtoDetailList(List<PrpLRegistTextDto> prpLregistTextDtoDetailList) {
		this.prpLregistTextDtoDetailList = prpLregistTextDtoDetailList;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public PrpLScheduleMainWfDto getPrpLScheduleMainWfDto() {
		return prpLScheduleMainWfDto;
	}
	public void setPrpLScheduleMainWfDto(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
		this.prpLScheduleMainWfDto = prpLScheduleMainWfDto;
	}
	public List<PrpLCompensateEarRegistDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
}
