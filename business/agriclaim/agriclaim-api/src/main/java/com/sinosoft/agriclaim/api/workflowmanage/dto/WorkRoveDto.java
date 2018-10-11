package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
/**
 * @description 工作流转交数据传输对象
 * @author yanlei
 * @date 2017年11月17日
 */
public class WorkRoveDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	private String registNo = "";
	/** 属性节点类型/节点类型 */
	private String nodeType = "" ;
	/** 属性案件补充说明/案件补充说明*/
	private List<PrpLRegistExtDto> prpLRegistExtDtoList = new ArrayList<PrpLRegistExtDto>();
	/** 属性调度以及查勘任务主表操作对象/调度以及查勘任务主表操作对象 */
	private PrpLScheduleMainWfDto prpLScheduleMainWfDto;
	/** 属性调度任务标的表操作对象/调度任务标的表操作对象 */
	private PrpLScheduleItemDto  prpLScheduleItemDto  ;
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * 属性节点类型/节点类型的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点类型/节点类型的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * 属性案件补充说明/案件补充说明的getter方法
	 */
	public List<PrpLRegistExtDto> getPrpLRegistExtDtoList() {
		return prpLRegistExtDtoList;
	}
	/**
	 * 属性案件补充说明/案件补充说明的setter方法
	 */
	public void setPrpLRegistExtDtoList(List<PrpLRegistExtDto> prpLRegistExtDtoList) {
		this.prpLRegistExtDtoList = prpLRegistExtDtoList;
	}
	/**
	 * 属性调度以及查勘任务主表操作对象/调度以及查勘任务主表操作对象的getter方法
	 */
	public PrpLScheduleMainWfDto getPrpLScheduleMainWfDto() {
		return prpLScheduleMainWfDto;
	}
	/**
	 * 属性调度以及查勘任务主表操作对象/调度以及查勘任务主表操作对象的setter方法
	 */
	public void setPrpLScheduleMainWfDto(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
		this.prpLScheduleMainWfDto = prpLScheduleMainWfDto;
	}
	/**
	 * 属性调度任务标的表操作对象/调度任务标的表操作对象的getter方法
	 */
	public PrpLScheduleItemDto getPrpLScheduleItemDto() {
		return prpLScheduleItemDto;
	}
	/**
	 * 属性调度任务标的表操作对象/调度任务标的表操作对象的setter方法
	 */
	public void setPrpLScheduleItemDto(PrpLScheduleItemDto prpLScheduleItemDto) {
		this.prpLScheduleItemDto = prpLScheduleItemDto;
	}
}
