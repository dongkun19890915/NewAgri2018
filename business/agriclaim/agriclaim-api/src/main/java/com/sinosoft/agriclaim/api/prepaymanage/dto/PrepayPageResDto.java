package com.sinosoft.agriclaim.api.prepaymanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLsumpayDto;

/**
 * @description: 类功能简述：特殊赔案页面初始化返参dto
 * @author 安齐崇
 * @date 2017年12月7日下午1:49:33
 *
 */
public class PrepayPageResDto {
	/*保费未实收是否可以与预赔标志，1可以，0不可以*/
	private int prePayFlag;
	/** 用户编码*/
	private String userCode;
	/** 机构编码*/
	private String comCode;
	private String policyNo;
	/** 用户名称*/
	private String userName;
	/** 编辑类型,可以选择ADD,EDIT,SHOW */
	private String editType;
	/** 立案号 */
	private String claimNo;
	/** 特殊赔案号 */
	private String prepayNo;
	/** 工作流号 */
	private String flowId;
	/** 工作流序号 */
	private String logNo;
	/** 模板号 */
	private String registNo;
	/** 节点号 */
	private String nodeNo;
	/** 文本信息 */
	private String context;
	private String sumPaid;
	private String nodeStatus;
	/** 清单号*/
	private String settleListCode;
	/** 立案信息，用于数据传输 */
	private PrpLClaimDto prpLClaimDto;
	/** 特殊赔案信息用于页面展示 */
	private PrpLPrepayDtoExt prpLPrepayDto;
	/*预赔报告*/
	List<PrpLPtextDto> prpLPtextDtpList;
	/** 费用赔款信息*/
	List<PrpLPreChargeDtoExt> prpLPreChargeDtoList;
	/*支付对象*/
	private List<PrpLsumpayDto> prpLsumpayDtoList;
	
	/** 已出险次数 */
	private String perilCount;

	/** 特殊赔案清单号 */
	private String listNo;
	
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	public String getPerilCount() {
		return perilCount;
	}
	public void setPerilCount(String perilCount) {
		this.perilCount = perilCount;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public List<PrpLsumpayDto> getPrpLsumpayDtoList() {
		return prpLsumpayDtoList;
	}
	public void setPrpLsumpayDtoList(List<PrpLsumpayDto> prpLsumpayDtoList) {
		this.prpLsumpayDtoList = prpLsumpayDtoList;
	}
	public String getSettleListCode() {
		return settleListCode;
	}
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	}
	public String getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(String sumPaid) {
		this.sumPaid = sumPaid;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	public PrpLPrepayDtoExt getPrpLPrepayDto() {
		return prpLPrepayDto;
	}
	public void setPrpLPrepayDto(PrpLPrepayDtoExt prpLPrepayDto) {
		this.prpLPrepayDto = prpLPrepayDto;
	}
	public List<PrpLPreChargeDtoExt> getPrpLPreChargeDtoList() {
		return prpLPreChargeDtoList;
	}
	public void setPrpLPreChargeDtoList(List<PrpLPreChargeDtoExt> prpLPreChargeDtoList) {
		this.prpLPreChargeDtoList = prpLPreChargeDtoList;
	}
	public List<PrpLPtextDto> getPrpLPtextDtpList() {
		return prpLPtextDtpList;
	}
	public void setPrpLPtextDtpList(List<PrpLPtextDto> prpLPtextDtpList) {
		this.prpLPtextDtpList = prpLPtextDtpList;
	}
	public int getPrePayFlag() {
		return prePayFlag;
	}
	public void setPrePayFlag(int prePayFlag) {
		this.prePayFlag = prePayFlag;
	}
	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPrepayNo() {
		return prepayNo;
	}
	public void setPrepayNo(String prepayNo) {
		this.prepayNo = prepayNo;
	}
	
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
}
