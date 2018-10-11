package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckLossDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNotionDto;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.UserDto;

public class ComCheckInDto extends ComCheckDetailQueryDto implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	
	/**通知调度标志*/
	private String messageToScheduleCheck;
	/**自动调度标志*/
	private String autoScheduleFlag;
	/**理赔节点状态表Api操作对象*/
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/**报案信息补充说明*/
	private List<PrpLRegistExtDto> prpLregistExtDtoList;
	

	public String getMessageToScheduleCheck() {
		return messageToScheduleCheck;
	}

	public void setMessageToScheduleCheck(String messageToScheduleCheck) {
		this.messageToScheduleCheck = messageToScheduleCheck;
	}

	public String getAutoScheduleFlag() {
		return autoScheduleFlag;
	}

	public void setAutoScheduleFlag(String autoScheduleFlag) {
		this.autoScheduleFlag = autoScheduleFlag;
	}

	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	public List<PrpLRegistExtDto> getPrpLregistExtDtoList() {
		return prpLregistExtDtoList;
	}

	public void setPrpLregistExtDtoList(List<PrpLRegistExtDto> prpLregistExtDtoList) {
		this.prpLregistExtDtoList = prpLregistExtDtoList;
	}

}
