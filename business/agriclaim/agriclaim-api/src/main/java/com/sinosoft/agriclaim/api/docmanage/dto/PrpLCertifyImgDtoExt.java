package com.sinosoft.agriclaim.api.docmanage.dto;

import java.util.List;

public class PrpLCertifyImgDtoExt extends PrpLCertifyImgDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 List certifyImgDtoList;
	 /** 编辑类型 */
	 private String editType = "";

	 /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
	 private String status ="";

	public List getCertifyImgDtoList() {
		return certifyImgDtoList;
	}

	public void setCertifyImgDtoList(List certifyImgDtoList) {
		this.certifyImgDtoList = certifyImgDtoList;
	}

	public String getEditType() {
		return editType;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
     
}
