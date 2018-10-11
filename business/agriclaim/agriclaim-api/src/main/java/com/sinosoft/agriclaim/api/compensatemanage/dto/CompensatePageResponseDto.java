package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;

public class CompensatePageResponseDto {
	/** 险别代码 */
	private String kindCode;
	/** 清单号 */
	private String billNo;

	private String validAmount;

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/*编辑类型ADD,EDIT,SHOW*/
	private String editType;
	/*立案号*/
	private String claimNo;
	/*保单号*/
	private String policyNo;
	/*报案号*/
	private String registNo;
	/*赔款计算书号*/
	private String compensateNo;
	/*特殊赔案标志，案件性质:0 已注销，1 已拒赔，2 已结案 空值表示未结案*/
	private String message;
	//保费未交或未交全标识
	private String msgCode;
	private String caseType;
	/*工作流程编号*/
	private String flowId;
	/*工作流程序号*/
	private String logNo;
	/*模板编号*/
	private String modelNo;
	/*节点编号*/
	private String nodeNo;
	private String nodeType;
	private String nodeName;
	/*理算节点状态*/
	private String status;
	/*险种编码*/
	private String riskCode;
	/*险种大类*/
	private String riskType;
	/*险种名称*/
	private String riskName;
	/*清单号*/
	private String settleListCode;
	/*调查标志*/
	private String checkFlag12;
	/*分入标志，1分入，0非分入*/
	private String businessFlag;
	/*共保标志*/
	private String coinsFlag;
	/*共保协议号*/
	private String coinsTreatyNo;
	/*共保我方份额*/
	private double selfRate;
	private double otherRate;
	
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
	public double getOtherRate() {
		return otherRate;
	}
	public void setOtherRate(double otherRate) {
		this.otherRate = otherRate;
	}
	public void setSelfRate(double selfRate) {
		this.selfRate = selfRate;
	}
	public Double getSelfRate() {
		return selfRate;
	}
	public void setSelfRate(Double selfRate) {
		this.selfRate = selfRate;
	}
	/*缴费标志-1,表示根本没有交费 -2表示交了部分，1表示全交*/
	private int payFeeFlag;
	/*工作流提交信息*/
	private String msg;
	/*重开赔案标志*/
	private String recaseFlag;
	/*重开赔案的总出险户次*/
	private String sumDamageInsured;
	/*重开赔案总赔付金额(同保单币别) */
	private String dbSumPaid;
	/*重开赔案赔付数量*/
	private String dbLossNumber;
	/*重开赔案责任赔款合计(同保单币别)*/
	private String dbSumDutyPaid;
	/*用户编码*/
	private String userCode;
	/*用户名*/
	private String userName;
	/*用户所属机构*/
	private String comCode;
	/*耳标号标志1有其它无*/
	private String familySplittingFlag;
	/*总赔付金额*/
	private double sumloss;
	/*理算报告文本说明信息*/
	private String text;
	/*已出险次数*/
	private int perilCount;
	/*立案信息*/
	private PrpLClaimDto prpLClaimDto;
	private List<PrpLLossDtoExt> prpLLossDtoExtList;
	/*赔款计算书主信息*/
	private PrpLCompensateDtoExt prpLCompensateDtoExt;
	/*耳标号*/
	private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
	/*付费文字说明*/
	private PrpLCTextDtoExt prpLCTextPayTextDto;
	/*赔款计算过程*/
	private PrpLCTextDtoExt prpLCTextPayCalcul;
	/*理算报告*/
	private PrpLCTextDtoExt prpLCTextReport;
	/*赔款费用信息*/
	private List<PrpLChargeDtoExt> prpLChargeDtoExtList;
	/*结案报告*/
	private PrpLLTextDto prpLLTextDto;
	/*特别约定*/
	private List<PrpCengageDtoExt> prpCengageDtoList;
	/*支付对象*/
	private List<PrpLsumpayDto> prpLsumpayDtoList;
	private List<PrpCcoinsDto>  ccoinsDtoList;
	/** 理算过程 */
    private String contextReport = "";
    /** 赔款计算过程 */
    private String contextPayCalcul = "";
    /** 付款说明*/
    private String contextPayText = "";

	public String getValidAmount() {
		return validAmount;
	}

	public void setValidAmount(String validAmount) {
		this.validAmount = validAmount;
	}

	public String getContextReport() {
		return contextReport;
	}
	public void setContextReport(String contextReport) {
		this.contextReport = contextReport;
	}
	public String getContextPayCalcul() {
		return contextPayCalcul;
	}
	public void setContextPayCalcul(String contextPayCalcul) {
		this.contextPayCalcul = contextPayCalcul;
	}
	public String getContextPayText() {
		return contextPayText;
	}
	public void setContextPayText(String contextPayText) {
		this.contextPayText = contextPayText;
	}
	public List<PrpCcoinsDto> getCcoinsDtoList() {
		return ccoinsDtoList;
	}
	public void setCcoinsDtoList(List<PrpCcoinsDto> ccoinsDtoList) {
		this.ccoinsDtoList = ccoinsDtoList;
	}
	public String getCoinsTreatyNo() {
		return coinsTreatyNo;
	}
	public void setCoinsTreatyNo(String coinsTreatyNo) {
		this.coinsTreatyNo = coinsTreatyNo;
	}
	public List<PrpLsumpayDto> getPrpLsumpayDtoList() {
		return prpLsumpayDtoList;
	}
	public void setPrpLsumpayDtoList(List<PrpLsumpayDto> prpLsumpayDtoList) {
		this.prpLsumpayDtoList = prpLsumpayDtoList;
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
	public List<PrpCengageDtoExt> getPrpCengageDtoList() {
		return prpCengageDtoList;
	}
	public void setPrpCengageDtoList(List<PrpCengageDtoExt> prpCengageDtoList) {
		this.prpCengageDtoList = prpCengageDtoList;
	}
	public PrpLCTextDtoExt getPrpLCTextReport() {
		return prpLCTextReport;
	}
	public void setPrpLCTextReport(PrpLCTextDtoExt prpLCTextReport) {
		this.prpLCTextReport = prpLCTextReport;
	}
	public PrpLCTextDtoExt getPrpLCTextPayCalcul() {
		return prpLCTextPayCalcul;
	}
	public void setPrpLCTextPayCalcul(PrpLCTextDtoExt prpLCTextPayCalcul) {
		this.prpLCTextPayCalcul = prpLCTextPayCalcul;
	}
	public PrpLLTextDto getPrpLLTextDto() {
		return prpLLTextDto;
	}
	public void setPrpLLTextDto(PrpLLTextDto prpLLTextDto) {
		this.prpLLTextDto = prpLLTextDto;
	}
	public String getCoinsFlag() {
		return coinsFlag;
	}
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
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
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public int getPerilCount() {
		return perilCount;
	}
	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}
	public List<PrpLChargeDtoExt> getPrpLChargeDtoExtList() {
		return prpLChargeDtoExtList;
	}
	public void setPrpLChargeDtoExtList(List<PrpLChargeDtoExt> prpLChargeDtoExtList) {
		this.prpLChargeDtoExtList = prpLChargeDtoExtList;
	}
	public PrpLCTextDtoExt getPrpLCTextPayTextDto() {
		return prpLCTextPayTextDto;
	}
	public void setPrpLCTextPayTextDto(PrpLCTextDtoExt prpLCTextPayTextDto) {
		this.prpLCTextPayTextDto = prpLCTextPayTextDto;
	}
	public double getSumloss() {
		return sumloss;
	}
	public void setSumloss(double sumloss) {
		this.sumloss = sumloss;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFamilySplittingFlag() {
		return familySplittingFlag;
	}
	public void setFamilySplittingFlag(String familySplittingFlag) {
		this.familySplittingFlag = familySplittingFlag;
	}
	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
	public PrpLCompensateDtoExt getPrpLCompensateDtoExt() {
		return prpLCompensateDtoExt;
	}
	public void setPrpLCompensateDtoExt(PrpLCompensateDtoExt prpLCompensateDtoExt) {
		this.prpLCompensateDtoExt = prpLCompensateDtoExt;
	}
	public List<PrpLLossDtoExt> getPrpLLossDtoExtList() {
		return prpLLossDtoExtList;
	}
	public void setPrpLLossDtoExtList(List<PrpLLossDtoExt> prpLLossDtoExtList) {
		this.prpLLossDtoExtList = prpLLossDtoExtList;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
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
	public String getRecaseFlag() {
		return recaseFlag;
	}
	public void setRecaseFlag(String recaseFlag) {
		this.recaseFlag = recaseFlag;
	}
	public String getSumDamageInsured() {
		return sumDamageInsured;
	}
	public void setSumDamageInsured(String sumDamageInsured) {
		this.sumDamageInsured = sumDamageInsured;
	}
	public String getDbSumPaid() {
		return dbSumPaid;
	}
	public void setDbSumPaid(String dbSumPaid) {
		this.dbSumPaid = dbSumPaid;
	}
	public String getDbLossNumber() {
		return dbLossNumber;
	}
	public void setDbLossNumber(String dbLossNumber) {
		this.dbLossNumber = dbLossNumber;
	}
	public String getDbSumDutyPaid() {
		return dbSumDutyPaid;
	}
	public void setDbSumDutyPaid(String dbSumDutyPaid) {
		this.dbSumDutyPaid = dbSumDutyPaid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getBusinessFlag() {
		return businessFlag;
	}
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getCheckFlag12() {
		return checkFlag12;
	}
	public void setCheckFlag12(String checkFlag12) {
		this.checkFlag12 = checkFlag12;
	}
	public String getSettleListCode() {
		return settleListCode;
	}
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	}
	
	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
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

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
}
