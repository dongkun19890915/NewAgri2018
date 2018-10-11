/**
 * 
 */
package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.util.Collection;
import java.util.List;

/**
 * @author yanlei
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-16 
 * 转交提交暂存工作流中转Api操作对象
 */
public class SwfLogTransferDto {
	private static final long serialVersionUID = 1L;
	/** 属性当前工作流对象/当前工作流对象*/
	private SwfLogDto swfLogDto ; 
	/** 属性下一个工作流集合/下一个工作流集合*/
	private List<SwfLogDto> swfLogNextList;
	
	/** 属性转交受理机构/转交受理机构*/
	private String handleCode ;	
	/** 属性转交受理机构名称/转交受理机构名称*/
	private String handleName ;
	/** 属性转交受理人/转交受理人 */
	private String handlerCode ;
	/** 属性转交受理人名称/转交受理人名称 */
	private String handlerName ;
	/** 属性当前用户机构代码/当前用户机构代码*/
	private String userComName ;
	/** 属性当前用户机构名称/当前用户机构名称*/
	private String userComCode ; 
	/** 属性当前用户代码/当前用户代码*/
	private String userUserCode ;
	/** 属性当前用户名称/当前用户名称*/
	private String userUserName ;
	
	
	/** 属性是否需要创建流程/是否需要创建流程*/
	boolean createFlow = false;
	/** 是否是正在独自占用该节点 */
	boolean holdNode = false;
	/** 属性节点种类名称/节点种类名称 */
	private String nodeTypeName = "";
	/** 属性操作状态名称/操作状态名称 */
	private String nodeStatusName = "";
	/** 属性险种名称/险种名称 */
	private String riskCodeName = "";
	/** 定损类型的名称/定损类型名称 */
	private String typeFlagName = "";
	/** 设置得到下一个节点的来源类型，设置为1，表示同时指定节点，否则从模板寻找 */
	private String nextNodeListType = "";
	/** 属性编辑类型/编辑类型 */
	private String editType = "";
	/** 属性新处理部门/新处理部门 */
	private String newNewHandleDept = "";
	/** 属性新处理部门名称/新处理部门名称 */
	private String newNewDeptName = "";
	/** 节点的办理信息 */
	private Collection swfNotionDtoList;
	/** 未核赔通过的计算书数目 */
	private int compeCount;
	/** 理算任务状态 0表示未出计算书，1表示正在处理中，2表示已核赔通过 */
	private String compeFlag;
	/** 保单是否已被注销 */
	private String otherFlag;
	/** 一个流程的报案上对应的保单号信息信息 */
	private Collection relatePolicyList;
	/** 属性下一个节点的属性业务号/下一个节点的属性业务号 */
	private String nextBusinessNo = "";
	/** 属性业务号限制条件/业务号限制条件  */
	private String conditionBusinessNo = "";
	/**
	 * 属性当前工作流对象/当前工作流对象的getter方法
	 */
	public SwfLogDto getSwfLogDto() {
		return swfLogDto;
	}
	/**
	 * 属性当前工作流对象/当前工作流对象的setter方法
	 */
	public void setSwfLogDto(SwfLogDto swfLogDto) {
		this.swfLogDto = swfLogDto;
	}
	/**
	 * 属性下一个工作流集合/下一个工作流集合的getter方法
	 */
	public List<SwfLogDto> getSwfLogNextList() {
		return swfLogNextList;
	}
	/**
	 * 属性下一个工作流集合/下一个工作流集合的setter方法
	 */
	public void setSwfLogNextList(List<SwfLogDto> swfLogNextList) {
		this.swfLogNextList = swfLogNextList;
	}
    /**
	 * 属性转交受理机构/转交受理机构的getter方法
	 */
	public String getHandleCode() {
		return handleCode;
	}
	/**
	 * 属性转交受理机构/转交受理机构的setter方法
	 */
	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}
	/**
	 * 属性转交受理机构名称/转交受理机构名称的getter方法
	 */
	public String getHandleName() {
		return handleName;
	}
	/**
	 * 属性转交受理机构名称/转交受理机构名称的setter方法
	 */
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}
	/**
	 * 属性转交受理人/转交受理人的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性转交受理人/转交受理人的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * 属性转交受理人名称/转交受理人名称的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性转交受理人名称/转交受理人名称的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * 属性当前用户机构代码/当前用户机构代码的getter方法
	 */
	public String getUserComName() {
		return userComName;
	}
	/**
	 * 属性当前用户机构代码/当前用户机构代码的setter方法
	 */
	public void setUserComName(String userComName) {
		this.userComName = userComName;
	}
	/**
	 * 属性当前用户机构名称/当前用户机构名称的getter方法
	 */
	public String getUserComCode() {
		return userComCode;
	}
	/**
	 * 属性当前用户机构名称/当前用户机构名称的setter方法
	 */
	public void setUserComCode(String userComCode) {
		this.userComCode = userComCode;
	}
	/**
	 * 属性当前用户代码/当前用户代码的getter方法
	 */
	public String getUserUserCode() {
		return userUserCode;
	}
	/**
	 * 属性当前用户代码/当前用户代码的setter方法
	 */
	public void setUserUserCode(String userUserCode) {
		this.userUserCode = userUserCode;
	}
	/**
	 * 属性当前用户名称/当前用户名称的getter方法
	 */
	public String getUserUserName() {
		return userUserName;
	}
	/**
	 * 属性当前用户名称/当前用户名称的setter方法
	 */
	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}
	/**
	 * 属性是否需要创建流程/是否需要创建流程的getter方法
	 */
	public boolean isCreateFlow() {
		return createFlow;
	}
	/**
	 * 属性是否需要创建流程/是否需要创建流程的setter方法
	 */
	public void setCreateFlow(boolean createFlow) {
		this.createFlow = createFlow;
	}
	/**
	 * 是否是正在独自占用该节点的getter方法
	 */
	public boolean isHoldNode() {
		return holdNode;
	}
	/**
	 * 是否是正在独自占用该节点的setter方法
	 */
	public void setHoldNode(boolean holdNode) {
		this.holdNode = holdNode;
	}
	/**
	 * 属性节点种类名称/节点种类名称的getter方法
	 */
	public String getNodeTypeName() {
		return nodeTypeName;
	}
	/**
	 * 属性节点种类名称/节点种类名称的setter方法
	 */
	public void setNodeTypeName(String nodeTypeName) {
		this.nodeTypeName = nodeTypeName;
	}
	/**
	 * 属性操作状态名称/操作状态名称的getter方法
	 */
	public String getNodeStatusName() {
		return nodeStatusName;
	}
	/**
	 * 属性操作状态名称/操作状态名称的setter方法
	 */
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}
	/**
	 * 属性险种名称/险种名称的getter方法
	 */
	public String getRiskCodeName() {
		return riskCodeName;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = riskCodeName;
	}
	/**
	 * 定损类型的名称/定损类型名称的getter方法
	 */
	public String getTypeFlagName() {
		return typeFlagName;
	}
	/**
	 * 定损类型的名称/定损类型名称的setter方法
	 */
	public void setTypeFlagName(String typeFlagName) {
		this.typeFlagName = typeFlagName;
	}
	/**
	 * 属性编辑类型/编辑类型 的getter方法
	 */
	public String getEditType() {
		return editType;
	}
	/**
	 * 属性编辑类型/编辑类型 的setter方法
	 */
	public void setEditType(String editType) {
		this.editType = editType;
	}
	/**
	 * 节点的办理信息 的getter方法
	 */
	public Collection getSwfNotionDtoList() {
		return swfNotionDtoList;
	}
	/**
	 * 节点的办理信息 的setter方法
	 */
	public void setSwfNotionDtoList(Collection swfNotionDtoList) {
		this.swfNotionDtoList = swfNotionDtoList;
	}
	/**
	 * 未核赔通过的计算书数目的getter方法
	 */
	public int getCompeCount() {
		return compeCount;
	}
	/**
	 * 未核赔通过的计算书数目的setter方法
	 */
	public void setCompeCount(int compeCount) {
		this.compeCount = compeCount;
	}
	/**
	 * 理算任务状态 0表示未出计算书，1表示正在处理中，2表示已核赔通过的getter方法
	 */
	public String getCompeFlag() {
		return compeFlag;
	}
	/**
	 * 理算任务状态 0表示未出计算书，1表示正在处理中，2表示已核赔通过的setter方法
	 */
	public void setCompeFlag(String compeFlag) {
		this.compeFlag = compeFlag;
	}
	/**
	 * 保单是否已被注销 的getter方法
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * 保单是否已被注销 的setter方法
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}
	/**
	 * 一个流程的报案上对应的保单号信息信息的getter方法
	 */
	public Collection getRelatePolicyList() {
		return relatePolicyList;
	}
	/**
	 * 一个流程的报案上对应的保单号信息信息的setter方法
	 */
	public void setRelatePolicyList(Collection relatePolicyList) {
		this.relatePolicyList = relatePolicyList;
	}
	/**
	 * 设置得到下一个节点的来源类型的getter方法
	 */
	public String getNextNodeListType() {
		return nextNodeListType;
	}
	/**
	 * 设置得到下一个节点的来源类型的setter方法
	 */
	public void setNextNodeListType(String nextNodeListType) {
		this.nextNodeListType = nextNodeListType;
	}
	/**
	 * 属性新处理部门/新处理部门的getter方法
	 */
	public String getNewHandleDept() {
		return newNewHandleDept;
	}
	/**
	 * 属性新处理部门/新处理部门的setter方法
	 */
	public void setNewHandleDept(String newNewHandleDept) {
		this.newNewHandleDept = newNewHandleDept;
	}
	/**
	 * 属性新处理部门名称/新处理部门名称的getter方法
	 */
	public String getNewDeptName() {
		return newNewDeptName;
	}
	/**
	 * 属性新处理部门名称/新处理部门名称的setter方法
	 */
	public void setNewDeptName(String newNewDeptName) {
		this.newNewDeptName = newNewDeptName;
	}
	/**
	 * 属性下一个节点的属性业务号/下一个节点的属性业务号的getter方法
	 */
	public String getNextBusinessNo() {
		return nextBusinessNo;
	}
	/**
	 * 属性下一个节点的属性业务号/下一个节点的属性业务号的setter方法
	 */
	public void setNextBusinessNo(String nextBusinessNo) {
		this.nextBusinessNo = nextBusinessNo;
	}
	/**
	 * 属性业务号限制条件/业务号限制条件的getter方法
	 */
	public String getConditionBusinessNo() {
		return conditionBusinessNo;
	}
	/**
	 * 属性业务号限制条件/业务号限制条件的setter方法
	 */
	public void setConditionBusinessNo(String conditionBusinessNo) {
		this.conditionBusinessNo = conditionBusinessNo;
	}
}
