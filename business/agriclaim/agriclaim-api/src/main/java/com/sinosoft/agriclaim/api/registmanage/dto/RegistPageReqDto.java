package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description: 类功能简述:报案登记页面初始化入参类
 * @author 安齐崇
 * @date 2017年11月28日下午5:54:30
 *
 */
public class RegistPageReqDto extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/* 保单号 ADD编辑；类型必传 */
	private String policyNo;
	/* 报案号,EDIT,SHOW 编辑类型必传 */
	private String registNo;
	/* 编辑类型ADD,EDIT,SHOW */
	private String editType;
	/* 出险时间 */
	private String damageDate;
	/* 出险小时 */
	private String damageHour;
	/* 出险分钟 */
	private String damageMinute;
	/* 工作流号 */
	private String swfLogFlowID;
	/* 工作流号序号 */
	private String swfLogLogNo;
	/* 模板号 */
	private String modelNo;
	/* 节点号 */
	private String nodeNo;
	/* 报案状态 */
	private String status;

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

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getNodeNo() {
		return nodeNo;
	}

	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getEditType() {
		return editType;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public String getDamageDate() {
		return damageDate;
	}

	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}

	public String getDamageHour() {
		return damageHour;
	}

	public void setDamageHour(String damageHour) {
		this.damageHour = damageHour;
	}

	public String getDamageMinute() {
		return damageMinute;
	}

	public void setDamageMinute(String damageMinute) {
		this.damageMinute = damageMinute;
	}

}
