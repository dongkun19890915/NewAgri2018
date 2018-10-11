package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.agriclaim.api.common.dto.LoginUserDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @description 调度任务查询返参对象
 * @author 马俊玲
 * @date 2017年10月19日 下午3:55:50
 */
public class ScheduleSaveDto extends BasePageableRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	// private PowerConditionDto powerConditionDto;
	// 调度主表对象
	private PrpLScheduleMainWfDto prpLscheduleMainWFDto;
	// 报案主表对象
	private PrpLRegistDto prpLregistDto;
	// 报损目标
	private ArrayList<PrpLScheduleItemDto> scheduleItemList;
	// 调度补充说明
	private PrpLRegistExtDto prpLregistExtDto;
	// 调度大对象
	private ScheduleDto scheduleDto;
	// 工作流ID
	private String swflogFlowId;
	// 工作里No
	private String swflogLogNo;
	// 结束标志
	private String endflag;
	// 上次提交时间
	private Long oldScheduleLastAccessedTime;
	// 保存按键属性
	private String buttonSaveType;
	// 保存类型
	private String saveType;
	// 改派节点类型
	private String getbackNodeType;
	// "ALLS":查勘调度，调度类型
	private String scheduleType;
	// 报损对象数量
	private int maxrow;
	// 最近一次进入时间
	private Long lastAccessedTime;
	// 报案号
	private String registNo;
	// 新的操作员名称
	private String newHandlerCode;

	// 是否选择查勘调度
	private String checkSelectSend;
	// 下个节点No
	private String NextNodeNo;


	/** 用户登录相关信息 */
	private LoginUserDto loginUserDto;

	public LoginUserDto getLoginUserDto() {
		return loginUserDto;
	}

	public void setLoginUserDto(LoginUserDto loginUserDto) {
		this.loginUserDto = loginUserDto;
	}

	public PrpLScheduleMainWfDto getPrpLscheduleMainWFDto() {
        return prpLscheduleMainWFDto;
    }

    public void setPrpLscheduleMainWFDto(PrpLScheduleMainWfDto prpLscheduleMainWFDto) {
        this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
    }

    public PrpLRegistExtDto getPrpLregistExtDto() {
        return prpLregistExtDto;
    }

    public void setPrpLregistExtDto(PrpLRegistExtDto prpLregistExtDto) {
        this.prpLregistExtDto = prpLregistExtDto;
    }

    public String getCheckSelectSend() {
		return checkSelectSend;
	}

	public void setCheckSelectSend(String checkSelectSend) {
		this.checkSelectSend = checkSelectSend;
	}

	public ArrayList<PrpLScheduleItemDto> getScheduleItemList() {
		return scheduleItemList;
	}

	public void setScheduleItemList(ArrayList<PrpLScheduleItemDto> scheduleItemList) {
		this.scheduleItemList = scheduleItemList;
	}

	public PrpLRegistDto getPrpLregistDto() {
		return prpLregistDto;
	}

	public void setPrpLregistDto(PrpLRegistDto prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}

	public PrpLScheduleMainWfDto getPrpLScheduleMainWfDto() {
		return prpLscheduleMainWFDto;
	}

	public void setPrpLScheduleMainWfDto(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
		this.prpLscheduleMainWFDto = prpLScheduleMainWfDto;
	}

	public String getNewHandlerCode() {
		return newHandlerCode;
	}

	public void setNewHandlerCode(String newHandlerCode) {
		this.newHandlerCode = newHandlerCode;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public Long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(Long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public ScheduleDto getScheduleDto() {
		return scheduleDto;
	}

	public void setScheduleDto(ScheduleDto scheduleDto) {
		this.scheduleDto = scheduleDto;
	}


	public String getEndflag() {
		return endflag;
	}

	public void setEndflag(String endflag) {
		this.endflag = endflag;
	}

	public Long getOldScheduleLastAccessedTime() {
		return oldScheduleLastAccessedTime;
	}

	public void setOldScheduleLastAccessedTime(Long oldScheduleLastAccessedTime) {
		this.oldScheduleLastAccessedTime = oldScheduleLastAccessedTime;
	}

	public String getButtonSaveType() {
		return buttonSaveType;
	}

	public void setButtonSaveType(String buttonSaveType) {
		this.buttonSaveType = buttonSaveType;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getGetbackNodeType() {
		return getbackNodeType;
	}

	public void setGetbackNodeType(String getbackNodeType) {
		this.getbackNodeType = getbackNodeType;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public int getMaxrow() {
		return maxrow;
	}

	public void setMaxrow(int maxrow) {
		this.maxrow = maxrow;
	}

	public String getNextNodeNo() {
		return NextNodeNo;
	}

	public void setNextNodeNo(String nextNodeNo) {
		NextNodeNo = nextNodeNo;
	}


	public String getSwflogLogNo() {
		return swflogLogNo;
	}

	public void setSwflogLogNo(String swflogLogNo) {
		this.swflogLogNo = swflogLogNo;
	}

	public String getSwflogFlowId() {
		return swflogFlowId;
	}

	public void setSwflogFlowId(String swflogFlowId) {
		this.swflogFlowId = swflogFlowId;
	}

	// public PowerConditionDto getPowerConditionDto() {
	// return powerConditionDto;
	// }
	// public void setPowerConditionDto(PowerConditionDto powerConditionDto) {
	// this.powerConditionDto = powerConditionDto;
	// }

}
