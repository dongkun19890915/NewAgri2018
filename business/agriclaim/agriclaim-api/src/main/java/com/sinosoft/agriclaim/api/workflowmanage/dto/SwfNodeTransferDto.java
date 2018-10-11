package com.sinosoft.agriclaim.api.workflowmanage.dto;
/**
 * @author yanlei
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-24 05:47:03.090 
 * 工作流节点定义拓展表操作对象
 */
public class SwfNodeTransferDto{
	private static final long serialVersionUID = 1L;
	/** 熟悉工作流主表/工作流主表 */
	private SwfNodeDto swfNodeDto;
	/** 属性调度号码/调度号码 */
    private int ScheduleID = 0;
    /** 属性标的序号/标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码/车牌号码 */
    private String lossItemName = "";
    /** 属性是否为本保单车辆 /是否本保单车辆*/
    private String insureCarFlag = "";
    /** 属性类型标志/类型标志 */
    private String typeFlag = "";
    /** 属性可操作/处理的级别划分 */
    private String handlerRange = "";
    /** 属性紧急程度/紧急程度 */
    private String exigenceGree = "";
    /** 属性处理部门/处理部门 */
    private String handleDept = "";
    /** 属性处理部门名称/处理部门名称 */
    private String deptName = "";
    /** 属性保单号码/保单号码 */
    private String policyNo = "";
    /** 属性险种代码/险种代码 */
    private String riskCode = "";
    /** 属性业务号/业务号 */
    private String businessNo = "";
    /** 属性任务接收载体键值任务接收载体键值 */
    private String keyIn = "";
    
    /**
	 * 熟悉工作流主表/工作流主表的getter方法
	 */
    public SwfNodeDto getSwfNodeDto() {
		return swfNodeDto;
	}
    /**
	 * 熟悉工作流主表/工作流主表的setter方法
	 */
	public void setSwfNodeDto(SwfNodeDto swfNodeDto) {
		this.swfNodeDto = swfNodeDto;
	}
	/**
	 * 属性调度号码/调度号码 的getter方法
	 */
	public int getScheduleID() {
		return ScheduleID;
	}
	/**
	 * 属性调度号码/调度号码 的setter方法
	 */
	public void setScheduleID(int scheduleID) {
		ScheduleID = scheduleID;
	}
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}
	/**
	 * 属性车牌号码/车牌号码的getter方法
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * 属性车牌号码/车牌号码的setter方法
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}
	/**
	 * 属性是否为本保单车辆 /是否本保单车辆的getter方法
	 */
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	/**
	 * 属性是否为本保单车辆 /是否本保单车辆的setter方法
	 */
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	}
	/**
	 * 属性类型标志/类型标志的getter方法
	 */
	public String getTypeFlag() {
		return typeFlag;
	}
	/**
	 * 属性类型标志/类型标志的setter方法
	 */
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	/**
	 * 属性可操作/处理的级别划分的getter方法
	 */
	public String getHandlerRange() {
		return handlerRange;
	}
	/**
	 * 属性可操作/处理的级别划分的setter方法
	 */
	public void setHandlerRange(String handlerRange) {
		this.handlerRange = handlerRange;
	}
	/**
	 * 属性紧急程度/紧急程度的getter方法
	 */
	public String getExigenceGree() {
		return exigenceGree;
	}
	/**
	 * 属性紧急程度/紧急程度的setter方法
	 */
	public void setExigenceGree(String exigenceGree) {
		this.exigenceGree = exigenceGree;
	}
	/**
	 * 属性处理部门/处理部门的getter方法
	 */
	public String getHandleDept() {
		return handleDept;
	}
	/**
	 * 属性处理部门/处理部门的setter方法
	 */
	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept;
	}
	/**
	 * 属性处理部门名称/处理部门名称的getter方法
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 属性处理部门名称/处理部门名称的setter方法
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	/**
	 * 属性任务接收载体键值任务接收载体键值的getter方法
	 */
	public String getKeyIn() {
		return keyIn;
	}
	/**
	 * 属性任务接收载体键值任务接收载体键值的setter方法
	 */
	public void setKeyIn(String keyIn) {
		this.keyIn = keyIn;
	}
}
