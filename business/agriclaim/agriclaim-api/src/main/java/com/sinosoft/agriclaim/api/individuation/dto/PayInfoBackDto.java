package com.sinosoft.agriclaim.api.individuation.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * 支付信息退回操作对象
 */
public class PayInfoBackDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务类型/业务类型 */
	private String certiType ;	
	/** 属性计算书号/计算书号 */
	private String compensateNo ;
	/** 属性理赔ID/理赔ID */
	private String acpaymentInfoId ;
	/** 属性certiId/certiId */
	private String certiId ;
	/** 属性uploadFileName/uploadFileName */
	private String uploadFileName ;
	/** 属性立案号/立案号 */
	private String claimNo ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性退回原因代码/退回原因代码*/
	private String backCode ;
	/** 属性退回原因描述/退回原因描述 */
	private String backMessage ;
	/** 属性预赔号/预赔号*/
	private String preparNo ;
	/** 属性节点号/序号 */
	private String nodeType ;
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getAcpaymentInfoId() {
		return acpaymentInfoId;
	}
	public void setAcpaymentInfoId(String acpaymentInfoId) {
		this.acpaymentInfoId = acpaymentInfoId;
	}
	public String getCertiId() {
		return certiId;
	}
	public void setCertiId(String certiId) {
		this.certiId = certiId;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBackCode() {
		return backCode;
	}
	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}
	public String getBackMessage() {
		return backMessage;
	}
	public void setBackMessage(String backMessage) {
		this.backMessage = backMessage;
	}
	public String getPreparNo() {
		return preparNo;
	}
	public void setPreparNo(String preparNo) {
		this.preparNo = preparNo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	
}
