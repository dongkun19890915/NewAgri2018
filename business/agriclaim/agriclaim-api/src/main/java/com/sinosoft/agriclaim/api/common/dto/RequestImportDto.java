package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;

import java.io.Serializable;

public class RequestImportDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性文件名称/*属性文件名称 */
	private String fileName;
	/** 属性文件Id/*属性文件Id */
	private String fileId;
	/** 属性险种代码/*属性险种代码 */
	private String riskCode;
//	/** 属性损失率清单号/损失率清单号 */
//	private String listNo;
	/** 属性保单号/ 保单号 */
	private String policyNo;
	/** 属性立案号/ 立案号 */
	private String registNo;
	/** 出险日期*/
    private String damageStartDate;
    /** 出险小时*/
    private String damageStartHour;
	private String userCode;
	private String userName;
	/** 属性导入来源节点/导入来源节点 */
	private String nodeOrigin;

	public String getNodeOrigin() {
		return nodeOrigin;
	}

	public void setNodeOrigin(String nodeOrigin) {
		this.nodeOrigin = nodeOrigin;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDamageStartDate() {
		return damageStartDate;
	}

	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}

	public String getDamageStartHour() {
		return damageStartHour;
	}

	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/** 属性 当前页/ 当前页 */
	private String pageNo;
	/** 属性 当前页/ 当前页 */
	private String pageSize;

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

//	public String getListNo() {
//		return listNo;
//	}
//
//	public void setListNo(String listNo) {
//		this.listNo = listNo;
//	}

	private LossRateListDto lossRateListDto;

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public LossRateListDto getLossRateListDto() {
		return lossRateListDto;
	}

	public void setLossRateListDto(LossRateListDto lossRateListDto) {
		this.lossRateListDto = lossRateListDto;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	

}
