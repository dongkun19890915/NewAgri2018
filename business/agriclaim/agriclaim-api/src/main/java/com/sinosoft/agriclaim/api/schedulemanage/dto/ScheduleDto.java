package com.sinosoft.agriclaim.api.schedulemanage.dto;

import java.io.Serializable;
import java.util.List;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;
import com.sinosoft.framework.dto.BaseRequest;

/**
 * 调度大对象
 * @author 马俊玲
 * @version 1.0
 */
public class ScheduleDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 调度主表 */
	private PrpLScheduleMainWfDto prpLscheduleMainWFDto;
	/** 案件状态表 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/** 定损标的 */
	private List<PrpLScheduleItemDto> prpLscheduleItemDtoList;
	/** 报案附加表 */
	private List<PrpLRegistExtDto> PrpLRegistExtDtoList;
	/** 回访信息 */
	private PrplReturnVisitSwflogDto prplreturnvisitswflogDto;
	/** 调度ID */
	private String prpLscheduleItemScheduleID;
	/** 调度类型 */
	private String ScheduleType;

	public PrpLScheduleMainWfDto getPrpLscheduleMainWFDto() {
		return prpLscheduleMainWFDto;
	}

	public void setPrpLscheduleMainWFDto(PrpLScheduleMainWfDto prpLscheduleMainWFDto) {
		this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
	}

	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	public List<PrpLScheduleItemDto> getPrpLscheduleItemDtoList() {
		return prpLscheduleItemDtoList;
	}

	public void setPrpLscheduleItemDtoList(List<PrpLScheduleItemDto> prpLscheduleItemDtoList) {
		this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
	}

	public List<PrpLRegistExtDto> getPrpLRegistExtDtoList() {
		return PrpLRegistExtDtoList;
	}

	public void setPrpLRegistExtDtoList(List<PrpLRegistExtDto> prpLRegistExtDtoList) {
		PrpLRegistExtDtoList = prpLRegistExtDtoList;
	}

	public PrplReturnVisitSwflogDto getPrplreturnvisitswflogDto() {
		return prplreturnvisitswflogDto;
	}

	public void setPrplreturnvisitswflogDto(PrplReturnVisitSwflogDto prplreturnvisitswflogDto) {
		this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
	}

	public String getPrpLscheduleItemScheduleID() {
		return prpLscheduleItemScheduleID;
	}

	public void setPrpLscheduleItemScheduleID(String prpLscheduleItemScheduleID) {
		this.prpLscheduleItemScheduleID = prpLscheduleItemScheduleID;
	}

	public String getScheduleType() {
		return ScheduleType;
	}

	public void setScheduleType(String scheduleType) {
		ScheduleType = scheduleType;
	}

}
