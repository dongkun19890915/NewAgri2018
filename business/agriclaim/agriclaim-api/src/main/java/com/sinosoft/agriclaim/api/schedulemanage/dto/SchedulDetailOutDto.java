package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDto;

import java.util.List;

/**
 * @description 调度初始化页面对象展示
 * @author 马俊玲
 * @date 2017年10月19日 下午3:55:50
 */
public class SchedulDetailOutDto {
	//工作流编号
	private String swfLogFlowID;
	//工作流logNo
	private String swfLogLogNo;
	//特殊字段   这个参数原本是schedule.Flag
	private String scheduleFlag;
	//报案主表
	private PrpLRegistDto prpLregistDto;
	//调度标识
	private String schedFlag;
	//调度主表
	private PrpLScheduleMainWfDto prpLscheduleMainWFDto;
	//
	private String finishSubmit;
	//报案附加表
	private PrpLRegistExtDto prpLregistExtDto;
	//调度对象
	private ScheduleDto scheduleDto;
	//省
	private String provinceCode;
	//工作流路径集合
	private List<SwfPathDto> swfPathList;
	//工作流路径
	private SwfPathDto swfPathDto;
	

	public SchedulDetailOutDto() {
		super();
	}

	public String getScheduleFlag() {
		return scheduleFlag;
	}

	public void setScheduleFlag(String scheduleFlag) {
		this.scheduleFlag = scheduleFlag;
	}

	public PrpLRegistDto getPrpLregistDto() {
		return prpLregistDto;
	}

	public void setPrpLregistDto(PrpLRegistDto prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}

	public String getSchedFlag() {
		return schedFlag;
	}

	public void setSchedFlag(String schedFlag) {
		this.schedFlag = schedFlag;
	}

	public PrpLScheduleMainWfDto getPrpLscheduleMainWFDto() {
		return prpLscheduleMainWFDto;
	}

	public void setPrpLscheduleMainWFDto(PrpLScheduleMainWfDto prpLscheduleMainWFDto) {
		this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
	}

	public String getFinishSubmit() {
		return finishSubmit;
	}

	public void setFinishSubmit(String finishSubmit) {
		this.finishSubmit = finishSubmit;
	}


	public PrpLRegistExtDto getPrpLregistExtDto() {
		return prpLregistExtDto;
	}

	public void setPrpLregistExtDto(PrpLRegistExtDto prpLregistExtDto) {
		this.prpLregistExtDto = prpLregistExtDto;
	}

	public ScheduleDto getScheduleDto() {
		return scheduleDto;
	}

	public void setScheduleDto(ScheduleDto scheduleDto) {
		this.scheduleDto = scheduleDto;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public List<SwfPathDto> getSwfPathList() {
		return swfPathList;
	}

	public void setSwfPathList(List<SwfPathDto> swfPathList) {
		this.swfPathList = swfPathList;
	}

	public SwfPathDto getSwfPathDto() {
		return swfPathDto;
	}

	public void setSwfPathDto(SwfPathDto swfPathDto) {
		this.swfPathDto = swfPathDto;
	}

	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}

	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}

	public String getSwfLogLogNo() {
		return swfLogLogNo;
	}

	public void setSwfLogLogNo(String swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}

	
	
	
}
