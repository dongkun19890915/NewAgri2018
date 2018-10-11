package com.sinosoft.agriclaim.core.individuation.entity;

import com.sinosoft.framework.datatype.DateTime;

import java.io.Serializable;

/**
 * 这是PrpJlossPlan-赔款应付信息表的数据传输对象类<br>
 * @author wubenfu
 */
public class PrpJlossPlanDto extends PrpJlossPlanDtoBase implements
		Serializable {

	private static final long serialVersionUID = 1L;
	
	private double thisPlanFee = 0D;
	
	private String coinsInfo = "";
    
	private String zhachaFlag="";
    private int pageNo = 0;
    
    //当前汇率
    private double currentExchangeRate = 0;
    //实收币种，本次可收金额
    private double thisPlanFee1 = 0;
    
    //本地币种
    private String localCurrency = "";
    
    private long printDay1 = 0; //打印天数1
    
    private long printDay2 = 0; //打印天数2
    
    private String bankAccountNo = "";  //付款账号
    
    private int exportNo = 0;
    private double uiExchangeRate = 0;
    private DateTime exportDate = null;
    
    private String settlementMode;
    private String cardType;
    
    public String getSettlementMode() {
		return settlementMode;
	}

	public void setSettlementMode(String settlementMode) {
		this.settlementMode = settlementMode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
    
    public DateTime getExportDate() {
		return exportDate;
	}

	public void setExportDate(DateTime exportDate) {
		this.exportDate = exportDate;
	}
   
    
    private String invPrintType = ""; 			//开票类型
    private double invExchRate 	= 0; 			//发票汇率
    private double invoiceFee  	= 0;			//本次发票金额
    private String invCurrency 	= "";			//发票币种
    private String payCurrency 	= "";
    private double payExchRate 	= 0;
    private String AllowModifyInvFeeFlag = "";	//是否允许修改开票金额
    private String carNatureName = "";
    //add by wangchuanzhong 20130402 end 综合查询增加车型名称显示
    
    //add by xiaoqin 20130409 start 赔付支付信息是否允许退回理赔系统的标识
    private boolean AllowPayInfoBackToClaimFlag ;
    //add by xiaoqin 20130409 end 赔付支付信息是否允许退回理赔系统的标识
    //add by chenjie 20131227 start 增加手机号
    private String mobile;
    //add by chenjie 20131227 end 增加手机号
    //add by chenjie 20131229 start 增加省/市名称
    private String bankName1;
    private String bankName2;
    //add by chenjie 20131229 end 
    private String backStatus = "";	//赔款退回状态
    //add by zhanglina 20140617 增加损余批次号
    private String batchNo = "";
    //add by zhanglina 20140822 计算书首位
    private String firCompensateNo = "";
    // add by zhangchenlong 集中支付调整
    private String payReturnCode = "";
    private String payFailedReason = "";
    private String centerName = "";
    //add by guqiaozhi 20160826 begin 收款公司代码
    private String companyId="";
    private double curExchangeRate = 0D;
    private String systemCode="";
    
	public String getCompanyId() {
		return companyId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getPayReturnCode() {
		return payReturnCode;
	}

	public void setPayReturnCode(String payReturnCode) {
		this.payReturnCode = payReturnCode;
	}
	public String getPayFailedReason() {
		return payFailedReason;
	}
	
	public void setPayFailedReason(String payFailedReason) {
		this.payFailedReason = payFailedReason;
	}

	/**
	 * 默认构造方法,构造一个默认的PrpJlossPlanDto对象
	 */
	public PrpJlossPlanDto() {
	}

	/**
	 * @desc 根据已有的PrpJlossPlanDto值设置新的PrpJlossPlanDto值
	 * @author shibifu
	 * @param PrpJlossPlanDto
	 */
	public void setDto(PrpJlossPlanDto prpJlossPlanDto)
			throws Exception {
		this.setCertiID(prpJlossPlanDto.getCertiID());
		this.setCertiType(prpJlossPlanDto.getCertiType());
		this.setCompensateNo(prpJlossPlanDto.getCompensateNo());
		this.setPolicyNo(prpJlossPlanDto.getPolicyNo());
		this.setPlanSerialNo(prpJlossPlanDto.getPlanSerialNo());
		this.setPayNo(prpJlossPlanDto.getPayNo());
		this.setClaimNo(prpJlossPlanDto.getClaimNo());
		this.setLossType(prpJlossPlanDto.getLossType());
		this.setPayRefReason(prpJlossPlanDto.getPayRefReason());
		this.setClassCode(prpJlossPlanDto.getClassCode());
		this.setRiskCode(prpJlossPlanDto.getRiskCode());
		this.setContractNo(prpJlossPlanDto.getContractNo());
		this.setMainPolicyNo(prpJlossPlanDto.getMainPolicyNo());
		this.setMainRiskCode(prpJlossPlanDto.getMainRiskCode());
		this.setAppliCode(prpJlossPlanDto.getAppliCode());
		this.setAppliName(prpJlossPlanDto.getAppliName());
		this.setInsuredCode(prpJlossPlanDto.getInsuredCode());
		this.setInsuredName(prpJlossPlanDto.getInsuredName());
		this.setPayObjectCode(prpJlossPlanDto.getPayObjectCode());
		this.setPayObjectName(prpJlossPlanDto.getPayObjectName());
        this.setSubPayCode(prpJlossPlanDto.getSubPayCode());
        this.setSubPayName(prpJlossPlanDto.getSubPayName());
		this.setStartDate(prpJlossPlanDto.getStartDate());
		this.setEndDate(prpJlossPlanDto.getEndDate());
		this.setUnderWriteDate(prpJlossPlanDto.getUnderWriteDate());
		this.setEndCaseDate(prpJlossPlanDto.getEndCaseDate());
		this.setCurrency1(prpJlossPlanDto.getCurrency1());
		this.setPlanFee(prpJlossPlanDto.getPlanFee());
        this.setSettleDCFlag(prpJlossPlanDto.getSettleDCFlag());
		this.setPlanStartDate(prpJlossPlanDto.getPlanStartDate());
		this.setPlanEndDate(prpJlossPlanDto.getPlanEndDate());
		this.setComCode(prpJlossPlanDto.getComCode());
		this.setMakeCom(prpJlossPlanDto.getMakeCom());
		this.setAgentCode(prpJlossPlanDto.getAgentCode());
		this.setAgentName(prpJlossPlanDto.getAgentName());
		this.setAgreementNo(prpJlossPlanDto.getAgreementNo());
		this.setHandler1Code(prpJlossPlanDto.getHandler1Code());
		this.setHandler1Name(prpJlossPlanDto.getHandler1Name());
		this.setHandlerCode(prpJlossPlanDto.getHandlerCode());
		this.setBusinessNature(prpJlossPlanDto.getBusinessNature());
		this.setShareHolderFlag(prpJlossPlanDto.getShareHolderFlag());
	//	this.setLicenseNo(prpJlossPlanDto.getLicenseNo());
	//	this.setCarNatureCode(prpJlossPlanDto.getCarNatureCode());
		this.setCoinsFlag(prpJlossPlanDto.getCoinsFlag());
		this.setCoinsCode(prpJlossPlanDto.getCoinsCode());
		this.setCoinsName(prpJlossPlanDto.getCoinsName());
		this.setCoinsRate(prpJlossPlanDto.getCoinsRate());
		this.setCoinsType(prpJlossPlanDto.getCoinsType());
		this.setAccountFlag(prpJlossPlanDto.getAccountFlag());
		this.setMainPolicyFlag(prpJlossPlanDto.getMainPolicyFlag());
		this.setLocationFlag(prpJlossPlanDto.getLocationFlag());
		this.setCenterCode(prpJlossPlanDto.getCenterCode());
		this.setAccBookType(prpJlossPlanDto.getAccBookType());
		this.setAccBookCode(prpJlossPlanDto.getAccBookCode());
		this.setYearMonth(prpJlossPlanDto.getYearMonth());
		this.setVoucherNo(prpJlossPlanDto.getVoucherNo());
		this.setVoucherDate(prpJlossPlanDto.getVoucherDate());
		this.setExchangeRate(prpJlossPlanDto.getExchangeRate());
		this.setPlanFeeCNY(prpJlossPlanDto.getPlanFeeCNY());
		this.setPlanPayRefNo(prpJlossPlanDto.getPlanPayRefNo());
		this.setRealPayFlag(prpJlossPlanDto.getRealPayFlag());
		this.setRealPayRefFee(prpJlossPlanDto.getRealPayRefFee());
		this.setPayRefTimes(prpJlossPlanDto.getPayRefTimes());
		this.setPayRefDate(prpJlossPlanDto.getPayRefDate());
		this.setItemStatus(prpJlossPlanDto.getItemStatus());
		this.setTaskID(prpJlossPlanDto.getTaskID());
		this.setAttribute1(prpJlossPlanDto.getAttribute1());
		this.setAttribute2(prpJlossPlanDto.getAttribute2());
		this.setAttribute3(prpJlossPlanDto.getAttribute3());
		this.setAttribute4(prpJlossPlanDto.getAttribute4());
		//FIXME add by zhanglina 添加字段 20100912 begin
		this.setDemandNo(prpJlossPlanDto.getDemandNo());
		this.setValidNo(prpJlossPlanDto.getValidNo());
		this.setUFlag(prpJlossPlanDto.getUFlag());
		//FIXME add by zhanglina 添加字段 20100912 end
		// add by xiaoqin 添加字段 20110815 start
		this.setBankCode(prpJlossPlanDto.getBankCode());
		this.setBankName(prpJlossPlanDto.getBankName());
		this.setBankCode1(prpJlossPlanDto.getBankCode1());
		this.setBankCode2(prpJlossPlanDto.getBankCode2());
		this.setBankItemCode(prpJlossPlanDto.getBankItemCode());
		this.setBankItemName(prpJlossPlanDto.getBankItemName());
		this.setBankOthDetail(prpJlossPlanDto.getBankOthDetail());
		this.setAccountType(prpJlossPlanDto.getAccountType());
		this.setAccountCode(prpJlossPlanDto.getAccountCode());
		this.setAccountName(prpJlossPlanDto.getAccountName());
		this.setExceptionFlag(prpJlossPlanDto.getExceptionFlag());
		this.setExceptionStartFlag(prpJlossPlanDto.getExceptionStartFlag());
		this.setExceptionInfo(prpJlossPlanDto.getExceptionInfo());
		this.setAttribute5(prpJlossPlanDto.getAttribute5());
		this.setAttribute6(prpJlossPlanDto.getAttribute6());
		this.setAttribute7(prpJlossPlanDto.getAttribute7());
		this.setAttribute8(prpJlossPlanDto.getAttribute8());
		this.setRecoveryFlag(prpJlossPlanDto.getRecoveryFlag());
		this.setSamepersonFlag(prpJlossPlanDto.getSamepersonFlag());
		this.setRecoveryFlag(prpJlossPlanDto.getRecoveryFlag());
		this.setClaimCode(prpJlossPlanDto.getClaimCode());
		this.setAcpaymentinfoid(prpJlossPlanDto.getAcpaymentinfoid());
		this.setDamageDate(prpJlossPlanDto.getDamageDate());
		this.setBackTimes(prpJlossPlanDto.getBackTimes());
		
		this.setInvPrintFlag(prpJlossPlanDto.getInvPrintFlag());
		this.setInvPrintFee(prpJlossPlanDto.getInvPrintFee());
		this.setInvPrintTimes(prpJlossPlanDto.getInvPrintTimes());
		this.setInvPrintDate(prpJlossPlanDto.getInvPrintDate());
		this.setInvPrintedFlag(prpJlossPlanDto.getInvPrintedFlag());
		//add by zhangchenlong 20131227 start 支付审核通过日期
		this.setPayUndwrtDate(prpJlossPlanDto.getPayUndwrtDate());
		this.setRecoveryCode(prpJlossPlanDto.getRecoveryCode());
		this.setNewRuleFlag(prpJlossPlanDto.getNewRuleFlag());
		this.setPackFlag(prpJlossPlanDto.getPackFlag());
		this.setCompanyId(prpJlossPlanDto.getCompanyId());
		//add by yangzonghe 20160516 费改三期收付接口调整 begin
		this.setCentiCode(prpJlossPlanDto.getCentiCode());
		this.setCentiType(prpJlossPlanDto.getCentiType());
		this.setCompanyId(prpJlossPlanDto.getCompanyId());
		this.setFirstExportDate(prpJlossPlanDto.getFirstExportDate()); //上传平台的首次报盘导出时间
		this.setNewExportDate(prpJlossPlanDto.getNewExportDate()); //统计系统使用的最新报盘导出时间
		//add by zhangzhi 20161212 begin reason:增加"结算方式","卡折类型"
		this.setSettlementMode(prpJlossPlanDto.getSettlementMode());
		this.setCardType(prpJlossPlanDto.getCardType());
		//add by zhangzhi 20161212 end reason:增加"结算方式","卡折类型"	
		
	}

	/**
	 * @return the thisPlanFee
	 */
	public double getThisPlanFee() {
		return thisPlanFee;
	}

	/**
	 * @param thisPlanFee the thisPlanFee to set
	 */
	public void setThisPlanFee(double thisPlanFee) {
		this.thisPlanFee = thisPlanFee;
	}

	/**
	 * @return the coinsInfo
	 */
	public String getCoinsInfo() {
		return coinsInfo;
	}

	/**
	 * @param coinsInfo the coinsInfo to set
	 */
	public void setCoinsInfo(String coinsInfo) {
		this.coinsInfo = coinsInfo;
	}

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

	public double getCurrentExchangeRate() {
		return currentExchangeRate;
	}

	public void setCurrentExchangeRate(double currentExchangeRate) {
		this.currentExchangeRate = currentExchangeRate;
	}

	public String getLocalCurrency() {
		return localCurrency;
	}

	public void setLocalCurrency(String localCurrency) {
		this.localCurrency = localCurrency;
	}

	public double getThisPlanFee1() {
		return thisPlanFee1;
	}

	public void setThisPlanFee1(double thisPlanFee1) {
		this.thisPlanFee1 = thisPlanFee1;
	}
	
	public long getPrintDay1() {
		return printDay1;
	}

	public void setPrintDay1(long printDay1) {
		this.printDay1 = printDay1;
	}
	
	public long getPrintDay2() {
		return printDay2;
	}

	public void setPrintDay2(long printDay2) {
		this.printDay2 = printDay2;
	}

	public void setZhachaFlag(String zhachaFlag) {
		this.zhachaFlag = zhachaFlag;
	}

	public String getZhachaFlag() {
		return zhachaFlag;
	}

	// add by sunlin 付款账号 20120229 begin
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public int getExportNo() {
		return exportNo;
	}

	public void setExportNo(int exportNo) {
		this.exportNo = exportNo;
	}

	public void setInvPrintType(String invPrintType) {
		this.invPrintType = invPrintType;
	}

	public String getInvPrintType() {
		return invPrintType;
	}

	public void setInvExchRate(double invExchRate) {
		this.invExchRate = invExchRate;
	}

	public double getInvExchRate() {
		return invExchRate;
	}

	public void setInvoiceFee(double invoiceFee) {
		this.invoiceFee = invoiceFee;
	}

	public double getInvoiceFee() {
		return invoiceFee;
	}

	public void setInvCurrency(String invCurrency) {
		this.invCurrency = invCurrency;
	}

	public String getInvCurrency() {
		return invCurrency;
	}

	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}

	public String getPayCurrency() {
		return payCurrency;
	}

	public void setPayExchRate(double payExchRate) {
		this.payExchRate = payExchRate;
	}

	public double getPayExchRate() {
		return payExchRate;
	}

	public void setAllowModifyInvFeeFlag(String allowModifyInvFeeFlag) {
		AllowModifyInvFeeFlag = allowModifyInvFeeFlag;
	}

	public String getAllowModifyInvFeeFlag() {
		return AllowModifyInvFeeFlag;
	}

	public void setAllowPayInfoBackToClaimFlag(
			boolean allowPayInfoBackToClaimFlag) {
		AllowPayInfoBackToClaimFlag = allowPayInfoBackToClaimFlag;
	}

	public boolean getAllowPayInfoBackToClaimFlag() {
		return AllowPayInfoBackToClaimFlag;
	}
	
	public String getCarNatureName() {
		return carNatureName;
	}

	public void setCarNatureName(String carNatureName) {
		this.carNatureName = carNatureName;
	}

	public void setBackStatus(String backStatus) {
		this.backStatus = backStatus;
	}

	public String getBackStatus() {
		return backStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBankName1() {
		return bankName1;
	}

	public void setBankName1(String bankName1) {
		this.bankName1 = bankName1;
	}

	public String getBankName2() {
		return bankName2;
	}

	public void setBankName2(String bankName2) {
		this.bankName2 = bankName2;
	}
	//add by zhanglina 20140617 begin 新理赔接口增加损余回收，增加损余批次号
	public String getBatchNo() { 
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	//add by zhanglina 20140617 end 新理赔接口增加损余回收，增加损余批次号

	public String getFirCompensateNo() {
		return firCompensateNo;
	}

	public void setFirCompensateNo(String firCompensateNo) {
		this.firCompensateNo = firCompensateNo;
	}

	public double getCurExchangeRate() {
		return curExchangeRate;
	}

	public void setCurExchangeRate(double curExchangeRate) {
		this.curExchangeRate = curExchangeRate;
	}

	public double getUiExchangeRate() {
		return uiExchangeRate;
	}

	public void setUiExchangeRate(double uiExchangeRate) {
		this.uiExchangeRate = uiExchangeRate;
	}

	

}
