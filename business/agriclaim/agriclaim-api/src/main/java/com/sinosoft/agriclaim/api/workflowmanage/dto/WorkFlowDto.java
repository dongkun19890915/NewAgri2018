package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @description 工作流流程数据传输对象
 * @author 杨航
 * @date 2017年10月20日
 */
public class WorkFlowDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 工作流流程节点信息 */
	private List<SwfLogDto> swfLogDtoList;
	/** 工作流流程边信息 */
	private List<SwfPathLogDto> swfPathLogDtoList;
	/** 工作流日志业务信息 */
	private List<SwfPackageDto> swfPackageDtoList;

	/** 工作流流程主表信息 */
	private SwfFlowMainDto swfFlowMainDto;

	/*-----------以上定义由于后来的事务处理，后来不再使用-----------*/

	/** 工作流当前处理节点的业务编码信息 */
	private String bessinessNo = "";
	/** 工作流当前状态 0 正常， 9异常 只做运算时候用的。 */
	private String status = "0";
	/** 工作流创建操作 */

	private boolean create = false;
	/** 创建时，创建节点的工作流流程节点信息 */
	private SwfLogDto createSwfLogDto;
	/** 创建时，工作流流程主表信息 */
	private SwfFlowMainDto createSwfFlowMainDto;

	/** 工作流更新操作 */
	private boolean update = false;
	/** 更新时，更新节点的工作流流程节点信息 */
	private SwfLogDto updateSwfLogDto;
	/** 更新时，批量更新节点的信息 */
	private List<SwfLogDto> updateSwfLogDtoList;

	/** 工作流提交操作 */
	private boolean submit = false;
	/** 提交时，新增加节点的工作流流程节点信息 */
	private List<SwfLogDto> submitSwfLogDtoList;
	/** 提交时，新增加节点路径的工作流流程节点路径信息 */
	private List<SwfPathLogDto> submitSwfPathLogDtoList;

	/** 节点的办理信息 */
	private List<SwfNotionDto> swfNotionDtoList;

	/** 工作流关闭操作 */
	private boolean close = false;
	/** 关闭时，工作流流程主表信息 */
	private SwfFlowMainDto closeSwfFlowMainDto;

	/** 数据整理的结果 */
	private int operateResult = 0;

	/** 工作流重开操作 */
	private boolean reOpen = false;
	/** 重开时，工作流流程主表信息 */
	private SwfFlowMainDto reOpenSwfFlowMainDto;

	/** 工作流日志存储信息 */
	/** 工作流日志包信息存储信息 */

	/** 工作流是否已经被关闭操作 */
	private boolean checkClose = false;

	/** 是否是需要进行占用节点操作 */
	boolean freeHoldNode = false;
	/** 工作流回收操作 */
	boolean recycle = false;
	/** 更新时，可以更新节点的另外一个，就是更新的时候，可以更新两个节点。工作流流程节点信息 */
	private SwfLogDto updateSwfLog2Dto;

	/** 并案工作流操作 */
	private List<WorkFlowDto> workFlowDtoList;

	public WorkFlowDto() {
	}

	public List<SwfLogDto> getSwfLogDtoList() {
		return swfLogDtoList;
	}

	public void setSwfLogDtoList(List<SwfLogDto> swfLogDtoList) {
		this.swfLogDtoList = swfLogDtoList;
	}

	public List<SwfPathLogDto> getSwfPathLogDtoList() {
		return swfPathLogDtoList;
	}

	public void setSwfPathLogDtoList(List<SwfPathLogDto> swfPathLogDtoList) {
		this.swfPathLogDtoList = swfPathLogDtoList;
	}

	public List<SwfPackageDto> getSwfPackageDtoList() {
		return swfPackageDtoList;
	}

	public void setSwfPackageDtoList(List<SwfPackageDto> swfPackageDtoList) {
		this.swfPackageDtoList = swfPackageDtoList;
	}

	public SwfFlowMainDto getSwfFlowMainDto() {
		return swfFlowMainDto;
	}

	public void setSwfFlowMainDto(SwfFlowMainDto swfFlowMainDto) {
		this.swfFlowMainDto = swfFlowMainDto;
	}

	public String getBessinessNo() {
		return bessinessNo;
	}

	public void setBessinessNo(String bessinessNo) {
		this.bessinessNo = bessinessNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public SwfLogDto getCreateSwfLogDto() {
		return createSwfLogDto;
	}

	public void setCreateSwfLogDto(SwfLogDto createSwfLogDto) {
		this.createSwfLogDto = createSwfLogDto;
	}

	public SwfFlowMainDto getCreateSwfFlowMainDto() {
		return createSwfFlowMainDto;
	}

	public void setCreateSwfFlowMainDto(SwfFlowMainDto createSwfFlowMainDto) {
		this.createSwfFlowMainDto = createSwfFlowMainDto;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public SwfLogDto getUpdateSwfLogDto() {
		return updateSwfLogDto;
	}

	public void setUpdateSwfLogDto(SwfLogDto updateSwfLogDto) {
		this.updateSwfLogDto = updateSwfLogDto;
	}

	public List<SwfLogDto> getUpdateSwfLogDtoList() {
		return updateSwfLogDtoList;
	}

	public void setUpdateSwfLogDtoList(List<SwfLogDto> updateSwfLogDtoList) {
		this.updateSwfLogDtoList = updateSwfLogDtoList;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	public List<SwfLogDto> getSubmitSwfLogDtoList() {
		return submitSwfLogDtoList;
	}

	public void setSubmitSwfLogDtoList(List<SwfLogDto> submitSwfLogDtoList) {
		this.submitSwfLogDtoList = submitSwfLogDtoList;
	}

	public List<SwfPathLogDto> getSubmitSwfPathLogDtoList() {
		return submitSwfPathLogDtoList;
	}

	public void setSubmitSwfPathLogDtoList(List<SwfPathLogDto> submitSwfPathLogDtoList) {
		this.submitSwfPathLogDtoList = submitSwfPathLogDtoList;
	}

	public List<SwfNotionDto> getSwfNotionDtoList() {
		return swfNotionDtoList;
	}

	public void setSwfNotionDtoList(List<SwfNotionDto> swfNotionDtoList) {
		this.swfNotionDtoList = swfNotionDtoList;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public SwfFlowMainDto getCloseSwfFlowMainDto() {
		return closeSwfFlowMainDto;
	}

	public void setCloseSwfFlowMainDto(SwfFlowMainDto closeSwfFlowMainDto) {
		this.closeSwfFlowMainDto = closeSwfFlowMainDto;
	}

	public int getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(int operateResult) {
		this.operateResult = operateResult;
	}

	public boolean isReOpen() {
		return reOpen;
	}

	public void setReOpen(boolean reOpen) {
		this.reOpen = reOpen;
	}

	public SwfFlowMainDto getReOpenSwfFlowMainDto() {
		return reOpenSwfFlowMainDto;
	}

	public void setReOpenSwfFlowMainDto(SwfFlowMainDto reOpenSwfFlowMainDto) {
		this.reOpenSwfFlowMainDto = reOpenSwfFlowMainDto;
	}

	public boolean isCheckClose() {
		return checkClose;
	}

	public void setCheckClose(boolean checkClose) {
		this.checkClose = checkClose;
	}

	public boolean isFreeHoldNode() {
		return freeHoldNode;
	}

	public void setFreeHoldNode(boolean freeHoldNode) {
		this.freeHoldNode = freeHoldNode;
	}

	public boolean isRecycle() {
		return recycle;
	}

	public void setRecycle(boolean recycle) {
		this.recycle = recycle;
	}

	public SwfLogDto getUpdateSwfLog2Dto() {
		return updateSwfLog2Dto;
	}

	public void setUpdateSwfLog2Dto(SwfLogDto updateSwfLog2Dto) {
		this.updateSwfLog2Dto = updateSwfLog2Dto;
	}

	public List<WorkFlowDto> getWorkFlowDtoList() {
		return workFlowDtoList;
	}

	public void setWorkFlowDtoList(List<WorkFlowDto> workFlowDtoList) {
		this.workFlowDtoList = workFlowDtoList;
	}

}
