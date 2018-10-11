/**a	
 * 
 */
package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.pms.api.kernel.dto.PrpDlimitDto;

/**
 * @author Administrator
 *
 */
public class CompensateSaveInDto {
	/**保存或者暂存类型*/
	private String buttonSaveType ;
	/**工作流号*/
	private String flowId;
	/**工作流节点号*/
	private java.lang.Integer logNo ;
	/** 赔款计算书主信息 */
    private PrpLCompensateDto prpLCompensateDtoExt;
    /** 属性联共保信息 */
    private String coinsFlag = "";
    /** 联共保序号 */
    private List<String> coinsSerialNo ;
    /** 联共保共保人类型 */
    private List<String> coinsType ;
    /** 联共保chiefflag */
    private List<String> coinsChiefFlag ;
    /** 联共保共保人机构代码 */
    private List<String> coinsCode ;
    /** 联共保共保人名称 */
    private List<String> coinsName ;
    /** 联共保共保份额 */
    private List<String> coinsRate ;
    /** 联共保总赔款 */
    private List<String> coinsSumpaid ;
    /** 联共保信息表集合 */
    private List<PrpLCfeecoinsDto> prpLcfeecoinsList;
    /** 理算过程 */
    private String contextReport = "";
    /** 赔款计算过程 */
    private String contextPayCalcul = "";
    /** 付款说明*/
    private String contextPayText = "";
    /** 赔款计算文字表 */
    private List<PrpLCTextDto> prpLctextList;
    /**耳标号信息表*/
    private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
    /**索赔人姓名*/
    private List<String> proposerName;
    /**索赔人序号*/
    private List<String> proposerSerialNo;
    /**索赔人身份证号*/
    private List<String> proposerIdentifyNumber;
    /**索赔人和被保险人关系*/
    private List<String> proposerRelation;
    /**索赔人电话*/
    private List<String> proposerPhone;
    /**索赔人地址*/
    private List<String> proposerAddress;
    /**索赔人信息表*/
    private List<PrpLAccIPersonDto> prpLAccIPersonDtoList;
    /**赔付被保险人信息*/
    private List<PrpLAccIPersonDto> prpLagriPersonList ;
    /**状态内容*/
    private PrpLclaimStatusDto prpLclaimStatusDto ;
    /** 立案信息 */
    private PrpLClaimDto prpLClaimDto;
    /** 赔付标的信息表 */
    private List<PrpLLossDto> prpLLossDtoList;
    /** 立案文字表*/
    private List<PrpLLTextDto> prpLLTextDtoList ;
    /** 索赔申请人信息表*/
    private List<PrpLAccIPersonDto> prpLAccIPersonDto;
    /** 赔款费用信息 */
    private List<PrpLChargeDto> prpLChargeDtoExtList;
    /** 限额免赔代码表 */
    private List<PrpDlimitDto> prpDlimitDtoList;
    /** 赔款计算金额表 */
    private List<PrpLCFeeDto> prpLCFeeDtoList;
    /** 账户信息表实体*/
    private List<PrpLsumpayDto> prpLsumpayDtoList;
    /** 清单号*/
    private String settleListCode;
    /** 当前用户代码*/
    private String userCode;
    /** 当前用户名称*/
    private String userName;
    /** 支付清单号*/
    private String payBillNo;
    
    public String getSettleListCode() {
		return settleListCode;
	}
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	}
	public PrpLCompensateDto getPrpLCompensateDtoExt() {
		return prpLCompensateDtoExt;
	}
	public void setPrpLCompensateDtoExt(PrpLCompensateDto prpLCompensateDtoExt) {
		this.prpLCompensateDtoExt = prpLCompensateDtoExt;
	}
	/** 预赔金额*/
    private String sumPrePaid;
    
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public java.lang.Integer getLogNo() {
		return logNo;
	}
	public void setLogNo(java.lang.Integer logNo) {
		this.logNo = logNo;
	}
	/**
	 * 保存或者暂存类型的getter方法
	 */
	public String getButtonSaveType() {
		return buttonSaveType;
	}
	/**
	 * 保存或者暂存类型的setter方法
	 */
	public void setButtonSaveType(String buttonSaveType) {
		this.buttonSaveType = buttonSaveType;
	}
	/**
	 * coinsFlag的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * coinsSerialNo的getter方法
	 */
	public List<String> getCoinsSerialNo() {
		return coinsSerialNo;
	}
	/**
	 * coinsType的getter方法
	 */
	public List<String> getCoinsType() {
		return coinsType;
	}
	/**
	 * coinsChiefFlag的getter方法
	 */
	public List<String> getCoinsChiefFlag() {
		return coinsChiefFlag;
	}
	/**
	 * coinsCode的getter方法
	 */
	public List<String> getCoinsCode() {
		return coinsCode;
	}
	/**
	 * coinsName的getter方法
	 */
	public List<String> getCoinsName() {
		return coinsName;
	}
	/**
	 * coinsRate的getter方法
	 */
	public List<String> getCoinsRate() {
		return coinsRate;
	}
	/**
	 * coinsSumpaid的getter方法
	 */
	public List<String> getCoinsSumpaid() {
		return coinsSumpaid;
	}
	/**
	 * prpLcfeecoinsList的getter方法
	 */
	public List<PrpLCfeecoinsDto> getPrpLcfeecoinsList() {
		return prpLcfeecoinsList;
	}
	/**
	 * contextReport的getter方法
	 */
	public String getContextReport() {
		return contextReport;
	}
	/**
	 * contextPayCalcul的getter方法
	 */
	public String getContextPayCalcul() {
		return contextPayCalcul;
	}
	/**
	 * contextPayText的getter方法
	 */
	public String getContextPayText() {
		return contextPayText;
	}
	/**
	 * prpLctextReportList的getter方法
	 */
	public List<PrpLCTextDto> getPrpLctextList() {
		return prpLctextList;
	}
	/**
	 * prpLCompensateEarDtoList的getter方法
	 */
	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	/**
	 * proposerName的getter方法
	 */
	public List<String> getProposerName() {
		return proposerName;
	}
	/**
	 * proposerSerialNo的getter方法
	 */
	public List<String> getProposerSerialNo() {
		return proposerSerialNo;
	}
	/**
	 * proposerIdentifyNumber的getter方法
	 */
	public List<String> getProposerIdentifyNumber() {
		return proposerIdentifyNumber;
	}
	/**
	 * proposerRelation的getter方法
	 */
	public List<String> getProposerRelation() {
		return proposerRelation;
	}
	/**
	 * proposerPhone的getter方法
	 */
	public List<String> getProposerPhone() {
		return proposerPhone;
	}
	/**
	 * proposerAddress的getter方法
	 */
	public List<String> getProposerAddress() {
		return proposerAddress;
	}
	/**
	 * prpLAccIPersonDtoList的getter方法
	 */
	public List<PrpLAccIPersonDto> getPrpLAccIPersonDtoList() {
		return prpLAccIPersonDtoList;
	}
	/**
	 * prpLclaimStatusDto的getter方法
	 */
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	/**
	 * prpLClaimDto的getter方法
	 */
	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}
	/**
	 * prpLLossDtoList的getter方法
	 */
	public List<PrpLLossDto> getPrpLLossDtoList() {
		return prpLLossDtoList;
	}
	/**
	 * prpLAccIPersonDto的getter方法
	 */
	public List<PrpLAccIPersonDto> getPrpLAccIPersonDto() {
		return prpLAccIPersonDto;
	}
	/**
	 * prpLChargeDtoList的getter方法
	 */
	public List<PrpLChargeDto> getPrpLChargeDtoExtList() {
		return prpLChargeDtoExtList;
	}
	/**
	 * prpDlimitDtoList的getter方法
	 */
	public List<PrpDlimitDto> getPrpDlimitDtoList() {
		return prpDlimitDtoList;
	}
	/**
	 * prpLCFeeDtoList的getter方法
	 */
	public List<PrpLCFeeDto> getPrpLCFeeDtoList() {
		return prpLCFeeDtoList;
	}
	
	/**
	 * coinsFlag的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
	/**
	 * coinsSerialNo的setter方法
	 */
	public void setCoinsSerialNo(List<String> coinsSerialNo) {
		this.coinsSerialNo = coinsSerialNo;
	}
	/**
	 * coinsType的setter方法
	 */
	public void setCoinsType(List<String> coinsType) {
		this.coinsType = coinsType;
	}
	/**
	 * coinsChiefFlag的setter方法
	 */
	public void setCoinsChiefFlag(List<String> coinsChiefFlag) {
		this.coinsChiefFlag = coinsChiefFlag;
	}
	/**
	 * coinsCode的setter方法
	 */
	public void setCoinsCode(List<String> coinsCode) {
		this.coinsCode = coinsCode;
	}
	/**
	 * coinsName的setter方法
	 */
	public void setCoinsName(List<String> coinsName) {
		this.coinsName = coinsName;
	}
	/**
	 * coinsRate的setter方法
	 */
	public void setCoinsRate(List<String> coinsRate) {
		this.coinsRate = coinsRate;
	}
	/**
	 * coinsSumpaid的setter方法
	 */
	public void setCoinsSumpaid(List<String> coinsSumpaid) {
		this.coinsSumpaid = coinsSumpaid;
	}
	/**
	 * prpLcfeecoinsList的setter方法
	 */
	public void setPrpLcfeecoinsList(List<PrpLCfeecoinsDto> prpLcfeecoinsList) {
		this.prpLcfeecoinsList = prpLcfeecoinsList;
	}
	/**
	 * contextReport的setter方法
	 */
	public void setContextReport(String contextReport) {
		this.contextReport = contextReport;
	}
	/**
	 * contextPayCalcul的setter方法
	 */
	public void setContextPayCalcul(String contextPayCalcul) {
		this.contextPayCalcul = contextPayCalcul;
	}
	/**
	 * contextPayText的setter方法
	 */
	public void setContextPayText(String contextPayText) {
		this.contextPayText = contextPayText;
	}
	/**
	 * prpLctextReportList的setter方法
	 */
	public void setPrpLctextList(List<PrpLCTextDto> prpLctextList) {
		this.prpLctextList = prpLctextList;
	}
	/**
	 * prpLCompensateEarDtoList的setter方法
	 */
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
	/**
	 * proposerName的setter方法
	 */
	public void setProposerName(List<String> proposerName) {
		this.proposerName = proposerName;
	}
	/**
	 * proposerSerialNo的setter方法
	 */
	public void setProposerSerialNo(List<String> proposerSerialNo) {
		this.proposerSerialNo = proposerSerialNo;
	}
	/**
	 * proposerIdentifyNumber的setter方法
	 */
	public void setProposerIdentifyNumber(List<String> proposerIdentifyNumber) {
		this.proposerIdentifyNumber = proposerIdentifyNumber;
	}
	/**
	 * proposerRelation的setter方法
	 */
	public void setProposerRelation(List<String> proposerRelation) {
		this.proposerRelation = proposerRelation;
	}
	/**
	 * proposerPhone的setter方法
	 */
	public void setProposerPhone(List<String> proposerPhone) {
		this.proposerPhone = proposerPhone;
	}
	/**
	 * proposerAddress的setter方法
	 */
	public void setProposerAddress(List<String> proposerAddress) {
		this.proposerAddress = proposerAddress;
	}
	/**
	 * prpLAccIPersonDtoList的setter方法
	 */
	public void setPrpLAccIPersonDtoList(List<PrpLAccIPersonDto> prpLAccIPersonDtoList) {
		this.prpLAccIPersonDtoList = prpLAccIPersonDtoList;
	}
	/**
	 * 赔付被保险人信息的getter方法
	 */
	public List<PrpLAccIPersonDto> getPrpLagriPersonList() {
		return prpLagriPersonList;
	}
	/**
	 * 赔付被保险人信息的setter方法
	 */
	public void setPrpLagriPersonList(List<PrpLAccIPersonDto> prpLagriPersonList) {
		this.prpLagriPersonList = prpLagriPersonList;
	}
	/**
	 * prpLclaimStatusDto的setter方法
	 */
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	/**
	 * prpLClaimDto的setter方法
	 */
	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	/**
	 * prpLLossDtoList的setter方法
	 */
	public void setPrpLLossDtoList(List<PrpLLossDto> prpLLossDtoList) {
		this.prpLLossDtoList = prpLLossDtoList;
	}
	/**
	 * 立案文字表的getter方法
	 */
	public List<PrpLLTextDto> getPrpLLTextDtoList() {
		return prpLLTextDtoList;
	}
	/**
	 * 立案文字表的setter方法
	 */
	public void setPrpLLTextDtoList(List<PrpLLTextDto> prpLLTextDtoList) {
		this.prpLLTextDtoList = prpLLTextDtoList;
	}
	/**
	 * prpLAccIPersonDto的setter方法
	 */
	public void setPrpLAccIPersonDto(List<PrpLAccIPersonDto> prpLAccIPersonDto) {
		this.prpLAccIPersonDto = prpLAccIPersonDto;
	}
	/**
	 * prpLChargeDtoList的setter方法
	 */
	public void setPrpLChargeDtoExtList(List<PrpLChargeDto> prpLChargeDtoList) {
		this.prpLChargeDtoExtList = prpLChargeDtoList;
	}
	/**
	 * prpDlimitDtoList的setter方法
	 */
	public void setPrpDlimitDtoList(List<PrpDlimitDto> prpDlimitDtoList) {
		this.prpDlimitDtoList = prpDlimitDtoList;
	}
	/**
	 * prpLCFeeDtoList的setter方法
	 */
	public void setPrpLCFeeDtoList(List<PrpLCFeeDto> prpLCFeeDtoList) {
		this.prpLCFeeDtoList = prpLCFeeDtoList;
	}
	/**
	 * 预赔金额的getter方法
	 */
	public String getSumPrePaid() {
		return sumPrePaid;
	}
	/**
	 * 预赔金额的setter方法
	 */
	public void setSumPrePaid(String sumPrePaid) {
		this.sumPrePaid = sumPrePaid;
	}
	public List<PrpLsumpayDto> getPrpLsumpayDtoList() {
		return prpLsumpayDtoList;
	}
	public void setPrpLsumpayDtoList(List<PrpLsumpayDto> prpLsumpayDtoList) {
		this.prpLsumpayDtoList = prpLsumpayDtoList;
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

	public String getPayBillNo() {
		return payBillNo;
	}

	public void setPayBillNo(String payBillNo) {
		this.payBillNo = payBillNo;
	}
}
