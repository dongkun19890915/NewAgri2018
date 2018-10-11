package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;

import java.util.List;
/**
 * @description: 类功能简述：立案登记页面初始化
 * @author 安齐崇
 * @date 2017年11月28日下午7:26:49
 *
 */
public class ClaimPageInitResDto {
	/* 报案登记页面初始化编辑类型ADD,新增，EDIT编辑，SHOW展示 */
	private String editType;
	/* 报案号 */
	private String registNo;
	/* 赔案号 */
	private String claimNo;
	/*保单号*/
	private String policyNo;
	/* 工作流程编号 */
	private String flowId;
	/* 工作流程序号 */
	private String logNo;
	/* 模板编号 */
	private String modelNo;
	/* 节点编号 */
	private String nodeNo;
	/* 立案状态 */
	private String status;
	/*险种编码*/
	private String riskCode;
	/*险种类型*/
	private String riskType;
	private String nodeType;
	private String nodeName;
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/*险种名称*/
	private String riskName;
	private String userCode;
	private String userName;
	private String comCode;
	/*0无耳标号信息，1，有耳标号信息*/
	private String earFlag;
	/*已出险次数*/
	private String perilCount;
	/*立案天数，*0立案天数大于系统规定时间，进行提示1表示立案天数小于系统规定时间，不进行提示*/
	private String claimDays;
	/*缴费状态码*/
	private int payFeeFlag;
	/*校验信息*/
	private String message;
	/*缴费计划*/
	private String delinquentfeeCase;
	/*共保标志*/
	private String coinsFlag;
	/*股东分红业务标志*/
	private String shareHolderFlag;
	/*立案文本信息*/
	private String context;
	/*估损金额信息*/
	private List<PrpLClaimLossDtoExt> prpLclaimLossDtoList;
	/*立案信息*/
	private PrpLClaimDtoExt prpLClaimDto;
	/*报案信息*/
	private PrpLRegistDto prpLRegistDto;
	private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/*立案文本信息*/
	List<PrpLLTextDto> prpLLTextDtoList;
	/*单位信息*/
	List<PrpDcodeDto> unitList;
	/** 危险单位信息 */
	DangerUnitBackDto dangerUnitBackDto;
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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public List<PrpLClaimLossDtoExt> getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}
	public void setPrpLclaimLossDtoList(List<PrpLClaimLossDtoExt> prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}
	public PrpLClaimDtoExt getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDtoExt prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	private PrpCmainDto prpCmainDto;
	
	public int getPayFeeFlag() {
		return payFeeFlag;
	}
	public void setPayFeeFlag(int payFeeFlag) {
		this.payFeeFlag = payFeeFlag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDelinquentfeeCase() {
		return delinquentfeeCase;
	}
	public void setDelinquentfeeCase(String delinquentfeeCase) {
		this.delinquentfeeCase = delinquentfeeCase;
	}
	public PrpCmainDto getPrpCmainDto() {
		return prpCmainDto;
	}
	public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
		this.prpCmainDto = prpCmainDto;
	}
	public String getShareHolderFlag() {
		return shareHolderFlag;
	}
	public void setShareHolderFlag(String shareHolderFlag) {
		this.shareHolderFlag = shareHolderFlag;
	}
	public String getCoinsFlag() {
		return coinsFlag;
	}
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
	public List<PrpDcodeDto> getUnitList() {
		return unitList;
	}
	public void setUnitList(List<PrpDcodeDto> unitList) {
		this.unitList = unitList;
	}
	public String getPerilCount() {
		return perilCount;
	}
	public void setPerilCount(String perilCount) {
		this.perilCount = perilCount;
	}
	public PrpLRegistDto getPrpLRegistDto() {
		return prpLRegistDto;
	}
	public void setPrpLRegistDto(PrpLRegistDto prpLRegistDto) {
		this.prpLRegistDto = prpLRegistDto;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
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
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getEarFlag() {
		return earFlag;
	}
	public void setEarFlag(String earFlag) {
		this.earFlag = earFlag;
	}
	public String getClaimDays() {
		return claimDays;
	}
	public void setClaimDays(String claimDays) {
		this.claimDays = claimDays;
	}
	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
	public List<PrpLLTextDto> getPrpLLTextDtoList() {
		return prpLLTextDtoList;
	}
	public void setPrpLLTextDtoList(List<PrpLLTextDto> prpLLTextDtoList) {
		this.prpLLTextDtoList = prpLLTextDtoList;
	}

	public DangerUnitBackDto getDangerUnitBackDto() {
		return dangerUnitBackDto;
	}

	public void setDangerUnitBackDto(DangerUnitBackDto dangerUnitBackDto) {
		this.dangerUnitBackDto = dangerUnitBackDto;
	}
}
