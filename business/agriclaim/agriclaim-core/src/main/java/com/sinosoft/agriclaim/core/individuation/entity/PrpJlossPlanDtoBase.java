package com.sinosoft.agriclaim.core.individuation.entity;

import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;

import java.io.Serializable;

/**
 * 
 * @author wubenfu
 *PrpJlossPlanDto的底层类 不与数据库关联
 * 2017年12月21日 
 */

public class PrpJlossPlanDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性赔款业务ID */
    private String certiID = "";
    /** 属性业务类型 */
    private String certiType = "";
    /** 属性计算书号 */
    private String compensateNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性赔款支付计划序号 */
    private int planSerialNo = 0;
    /** 属性赔款支付期数 */
    private int payNo = 0;
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性赔款类型
--** 01 赔款
--** 02 费用 */
    private String lossType = "";
    /** 属性收付原因 */
    private String payRefReason = "";
    /** 属性险类 */
    private String classCode = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性合同号 */
    private String contractNo = "";
    /** 属性组合保单号 */
    private String mainPolicyNo = "";
    /** 属性组合保单险种 */
    private String mainRiskCode = "";
    /** 属性投保人代码 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保人名称 */
    private String insuredName = "";
    /** 属性支付对象代码 */
    private String payObjectCode = "";
    /** 属性支付对象名称 */
    private String payObjectName = "";
    /** 属性代赔公司代码 */
    private String subPayCode = "";
    /** 属性代培公司名称 */
    private String subPayName = "";
    /** 属性保单起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性保单终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性核赔通过日期 */
    private DateTime underWriteDate = new DateTime();
    /** 属性结案日期 */
    private DateTime endCaseDate = new DateTime();
    /** 属性应付赔款币种 */
    private String currency1 = "";
    /** 属性应付赔款金额 */
    private double planFee = 0D;
    /** 属性业务类型决定的该业务的正负相关性 */
    private int settleDCFlag = 0;
    /** 属性缴费起期 */
    private DateTime planStartDate = new DateTime();
    /** 属性缴费止期 */
    private DateTime planEndDate = new DateTime();
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性代理人名称 */
    private String agentName = "";
    /** 属性代理协议号码 */
    private String agreementNo = "";
    /** 属性业务归属人员 */
    private String handler1Code = "";
    /** 属性业务归属人员名称 */
    private String handler1Name = "";
    /** 属性经办人 */
    private String handlerCode = "";
    /** 属性业务渠道 */
    private String businessNature = "";
    /** 属性业务性质 */
    private String shareHolderFlag = "";
    /** 属性车牌号码
    private String licenseNo = ""; */
    /** 属性交强险车辆九大类明细
    private String carNatureCode = ""; */
    /** 属性联共保标志 */
    private String coinsFlag = "";
    /** 属性联共保人代码 */
    private String coinsCode = "";
    /** 属性联共保人名称 */
    private String coinsName = "";
    /** 属性联共保比例 */
    private double coinsRate = 0D;
    /** 属性联共保类型 */
    private String coinsType = "";
    /** 属性是否允许挂帐 */
    private String accountFlag = "";
    /** 属性是否组合产品标识 */
    private String mainPolicyFlag = "";
    /** 属性境内境外标志 */
    private String locationFlag = "";
    /** 属性核算单位 */
    private String centerCode = "";
    /** 属性帐套类型 */
    private String accBookType = "";
    /** 属性帐套代码 */
    private String accBookCode = "";
    /** 属性挂帐会计期间 */
    private String yearMonth = "";
    /** 属性挂帐凭证号 */
    private String voucherNo = "";
    /** 属性实际挂帐时间 */
    private DateTime voucherDate = new DateTime();
    /** 属性挂帐汇率（CNY） */
    private double exchangeRate = 0D;
    /** 属性挂帐金额（CNY） */
    private double planFeeCNY = 0D;
    /** 属性应付挂帐收付号 */
    private String planPayRefNo = "";
    /** 属性是否可以实际收付 */
    private String realPayFlag = "";
    /** 属性已支付金额(应收付币种) */
    private double realPayRefFee = 0D;
    /** 属性已支付次数 */
    private int payRefTimes = 0;
    /** 属性最近一次实付日期 */
    private DateTime payRefDate = new DateTime();
    /** 属性记录状态 */
    private String itemStatus = "";
    /** 属性操作任务ID */
    private long taskID = 0L;
    /** 属性备用字段1 */
    private String attribute1 = "";
    /** 属性备用字段2 */
    private String attribute2 = "";
    /** 属性备用字段3 */
    private String attribute3 = "";
    /** 属性备用字段4 */
    private String attribute4 = "";
    /** 属性投保查询码 */
    private String demandNo = "";
    /** 属性投保确认码 */
    private String validNo = "";
    /** 属性上传标识 */
    private String uFlag = "";
    /** 属性发送短信标识 */
    private String msgFlag = "";
    /** 属性发送短信时间 */
    private DateTime msgDate = new DateTime();
    //FIXME add by zhanglina 添加字段 20100912 end
    //add by xiaoqin 添加字段 20110815 start
    /** 银行代码 */
    private String bankCode = "";
    /** 银行名称 */
    private String bankName = "";
    /** 开户行省份代码 */                   
    private String bankCode1 = "";          
    /** 开户行地区代码 */                   
    private String bankCode2 = "";   
    /** 开户行联行号代码 */                      
    private String bankItemCode = "";   
    /** 开户行联行号名称 */                      
    private String bankItemName = "";   
    /** 开户行明细 */                      
    private String bankOthDetail = "";   
    /** 帐户性质*/
    private String accountType = "";
    /** 银行帐号*/
    private String accountCode = "";
    /** 开户名称*/
    private String accountName = "";
    /** 是否申请例外标志  Y:是 N:否*/
    private String exceptionFlag = "";
    /** 启动例外标志  Y:是 N:否*/
    private String exceptionStartFlag = "";
    /** 启动例外原因*/
    private String exceptionInfo = ""; 
    /** 备用字段5 */
    private String attribute5 = "";
    /** 备用字段6 */
    private String attribute6 = "";
    /** 备用字段7 */
    private String attribute7 = "";
    /** 备用字段8 */
    private String attribute8 = "";
	//add by xiaoqin 添加字段 20110815 end
    
    //add by xiaoqin 20120425 start 代位求偿
    private String recoveryFlag = "";
    //add by xiaoqin 20120425 end 代位求偿
    
//  add by yangxiujuan 20121018 理赔送收付支付信息改造  begin
	private String samepersonFlag="";
	//add by yangxiujuan 20121018 理赔送收付支付信息改造  end 
    
    //add by zhongjiang 添加字段 20121220 begin
    //清算码
    private String recoveryCode = "";
    //理赔编码
    private String claimCode = "";
    //车辆理赔支付信息表ID
    private String acpaymentinfoid = "";
    //add by zhongjiang 添加字段 20121220 end
    
    //add by xiaoqin 20130124  start 赔付开票
    private String invPrintFlag = "";		 			//是否允许打印发票 
    private double invPrintFee = 0D;					//发票已打印金额(应收付币种)
    private int invPrintTimes = 0;			 			//发票已打印次数 
    private DateTime invPrintDate = new DateTime();		//最近一次发票打印日期 
    private String invCode = "";			 			//最近一次发票类型代码 
    private String invSerialNo = "";					//最近一次发票流水号 
    private String invPrintedFlag = "";					//发票打印情况标识 0-未打印 1-已打印部分2-已打印完毕
    //add by xiaoqin 20130124  end  赔付开票
    
    //add by xiaoqin 20130416 start 出险起始日期
    private DateTime damageDate;
    private int backTimes;
    //add by xiaoqin 20130416 start  出险起始日期
	//add by zhangchenlong 20131227 start 支付审核通过日期
    private DateTime payUndwrtDate = new DateTime();
    //add by zhangchenlong 20131227 end   支付审核通过日期
    
    //add by zhanglina 20140512 begin 收付联查新理赔计算书单证信息,增加字段存储查询链接加密信息
    private String newClaimQuery = "";
    //add by zhangmiaomiao begin 
    //新挂账标志位(以险别为核算维度)：空->历史数据；1->按险别维度核算；2->不按险别维度核算；'
    private String  newRuleFlag= "";
    //add by zhangmiaomiao end
    //add by zhangliuzhu 20151111 begin
    //直接理赔费用结算单字段
    private String packFlag="";
    //add by zhangliuzhu 20151111 end
    //add by zhaojiaxin 20160614
    private String vatStatus = "";
    private String transFlag = "";
    //add by zhaojiaxin 20160614
  //add by zhangmiaomiao begin 20151123
    //直接理赔费用收款公司ID编号 如公估公司ID(当PackFlag为1时，不为空)
    private String companyId="";
    //add by zhangmiaomiao end 20151123
        //add by zhaojiaxin 20160429 添加字段
    private String centiCode="";
    private String centiType="";
    //add by zhaojiaxin 20160429 添加字段 
    private DateTime transDate = new DateTime();
    // add by jiangxinjun 20160720  begin
    private DateTime FirstExportDate = new DateTime(); //首次报盘导出时间
    private DateTime NewExportDate = new DateTime(); //最新报盘导出时间
    // add by jiangxinjun 20160720  end
    
    // add by fengwenjia 添加字段 20161010 begin
    /**批次号*/
    private String pkBill="";
	// add by fengwenjia 添加字段 20161010 end
    //add by zhaojiaxin 20170122 begin
    private double thisPlanFeeCNY = 0D;
    //add by zhaojiaxin 20170122 end
    
	public double getThisPlanFeeCNY() {
		return thisPlanFeeCNY;
	}

	public void setThisPlanFeeCNY(double thisPlanFeeCNY) {
		this.thisPlanFeeCNY = thisPlanFeeCNY;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCentiCode() {
		return centiCode;
	}

	public void setCentiCode(String centiCode) {
		this.centiCode = centiCode;
	}

	public String getCentiType() {
		return centiType;
	}

	public void setCentiType(String centiType) {
		this.centiType = centiType;
	}

	public DateTime getTransDate() {
		return transDate;
	}

	public void setTransDate(DateTime transDate) {
		this.transDate = transDate;
	}

	public String getVatStatus() {
		return vatStatus;
	}

	public void setVatStatus(String vatStatus) {
		this.vatStatus = vatStatus;
	}

	public String getNewClaimQuery() {
		return newClaimQuery;
	}

	public void setNewClaimQuery(String newClaimQuery) {
		this.newClaimQuery = newClaimQuery;
	}
    //add by zhanglina 20140512 end 收付联查新理赔计算书单证信息，增加字段存储查询链接加密信息

    /**
     *  默认构造方法,构造一个默认的PrpJlossPlanDtoBase对象
     */
    public PrpJlossPlanDtoBase(){
    }

    /**
     * 设置属性赔款业务ID
     * @param certiID 待设置的属性赔款业务ID的值
     */
    public void setCertiID(String certiID){
        this.certiID = StringUtils.rightTrim(certiID);
    }

    /**
     * 获取属性赔款业务ID
     * @return 属性赔款业务ID的值
     */
    public String getCertiID(){
        return certiID;
    }

    /**
     * 设置属性业务类型
     * @param certiType 待设置的属性业务类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性计算书号
     * @param compensateNo 待设置的属性计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性计算书号
     * @return 属性计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性赔款支付计划序号
     * @param planSerialNo 待设置的属性赔款支付计划序号的值
     */
    public void setPlanSerialNo(int planSerialNo){
        this.planSerialNo = planSerialNo;
    }

    /**
     * 获取属性赔款支付计划序号
     * @return 属性赔款支付计划序号的值
     */
    public int getPlanSerialNo(){
        return planSerialNo;
    }

    /**
     * 设置属性赔款支付期数
     * @param payNo 待设置的属性赔款支付期数的值
     */
    public void setPayNo(int payNo){
        this.payNo = payNo;
    }

    /**
     * 获取属性赔款支付期数
     * @return 属性赔款支付期数的值
     */
    public int getPayNo(){
        return payNo;
    }

    /**
     * 设置属性立案号
     * @param claimNo 待设置的属性立案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号
     * @return 属性立案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性赔款类型
--** 01 赔款
--** 02 费用
     * @param lossType 待设置的属性赔款类型
--** 01 赔款
--** 02 费用的值
     */
    public void setLossType(String lossType){
        this.lossType = StringUtils.rightTrim(lossType);
    }

    /**
     * 获取属性赔款类型
--** 01 赔款
--** 02 费用
     * @return 属性赔款类型
--** 01 赔款
--** 02 费用的值
     */
    public String getLossType(){
        return lossType;
    }

    /**
     * 设置属性收付原因
     * @param payRefReason 待设置的属性收付原因的值
     */
    public void setPayRefReason(String payRefReason){
        this.payRefReason = StringUtils.rightTrim(payRefReason);
    }

    /**
     * 获取属性收付原因
     * @return 属性收付原因的值
     */
    public String getPayRefReason(){
        return payRefReason;
    }

    /**
     * 设置属性险类
     * @param classCode 待设置的属性险类的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类
     * @return 属性险类的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性合同号
     * @param contractNo 待设置的属性合同号的值
     */
    public void setContractNo(String contractNo){
        this.contractNo = StringUtils.rightTrim(contractNo);
    }

    /**
     * 获取属性合同号
     * @return 属性合同号的值
     */
    public String getContractNo(){
        return contractNo;
    }

    /**
     * 设置属性组合保单号
     * @param mainPolicyNo 待设置的属性组合保单号的值
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * 获取属性组合保单号
     * @return 属性组合保单号的值
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * 设置属性组合保单险种
     * @param mainRiskCode 待设置的属性组合保单险种的值
     */
    public void setMainRiskCode(String mainRiskCode){
        this.mainRiskCode = StringUtils.rightTrim(mainRiskCode);
    }

    /**
     * 获取属性组合保单险种
     * @return 属性组合保单险种的值
     */
    public String getMainRiskCode(){
        return mainRiskCode;
    }

    /**
     * 设置属性投保人代码
     * @param appliCode 待设置的属性投保人代码的值
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * 获取属性投保人代码
     * @return 属性投保人代码的值
     */
    public String getAppliCode(){
        return appliCode;
    }

    /**
     * 设置属性投保人名称
     * @param appliName 待设置的属性投保人名称的值
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * 获取属性投保人名称
     * @return 属性投保人名称的值
     */
    public String getAppliName(){
        return appliName;
    }

    /**
     * 设置属性被保险人代码
     * @param insuredCode 待设置的属性被保险人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人代码
     * @return 属性被保险人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保人名称
     * @param insuredName 待设置的属性被保人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保人名称
     * @return 属性被保人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性支付对象代码
     * @param payObjectCode 待设置的属性支付对象代码的值
     */
    public void setPayObjectCode(String payObjectCode){
        this.payObjectCode = StringUtils.rightTrim(payObjectCode);
    }

    /**
     * 获取属性支付对象代码
     * @return 属性支付对象代码的值
     */
    public String getPayObjectCode(){
        return payObjectCode;
    }

    /**
     * 设置属性支付对象名称
     * @param payObjectName 待设置的属性支付对象名称的值
     */
    public void setPayObjectName(String payObjectName){
        this.payObjectName = StringUtils.rightTrim(payObjectName);
    }

    /**
     * 获取属性支付对象名称
     * @return 属性支付对象名称的值
     */
    public String getPayObjectName(){
        return payObjectName;
    }

    /**
     * 设置属性代赔公司代码
     * @param subPayCode 待设置的属性代赔公司代码的值
     */
    public void setSubPayCode(String subPayCode){
        this.subPayCode = StringUtils.rightTrim(subPayCode);
    }

    /**
     * 获取属性代赔公司代码
     * @return 属性代赔公司代码的值
     */
    public String getSubPayCode(){
        return subPayCode;
    }

    /**
     * 设置属性代培公司名称
     * @param subPayName 待设置的属性代培公司名称的值
     */
    public void setSubPayName(String subPayName){
        this.subPayName = StringUtils.rightTrim(subPayName);
    }

    /**
     * 获取属性代培公司名称
     * @return 属性代培公司名称的值
     */
    public String getSubPayName(){
        return subPayName;
    }

    /**
     * 设置属性保单起保日期
     * @param startDate 待设置的属性保单起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性保单起保日期
     * @return 属性保单起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性保单终保日期
     * @param endDate 待设置的属性保单终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性保单终保日期
     * @return 属性保单终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性核赔通过日期
     * @param underWriteDate 待设置的属性核赔通过日期的值
     */
    public void setUnderWriteDate(DateTime underWriteDate){
        this.underWriteDate = underWriteDate;
    }

    /**
     * 获取属性核赔通过日期
     * @return 属性核赔通过日期的值
     */
    public DateTime getUnderWriteDate(){
        return underWriteDate;
    }

    /**
     * 设置属性结案日期
     * @param endCaseDate 待设置的属性结案日期的值
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * 获取属性结案日期
     * @return 属性结案日期的值
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * 设置属性应付赔款币种
     * @param currency1 待设置的属性应付赔款币种的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性应付赔款币种
     * @return 属性应付赔款币种的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性应付赔款金额
     * @param planFee 待设置的属性应付赔款金额的值
     */
    public void setPlanFee(double planFee){
        this.planFee = planFee;
    }

    /**
     * 获取属性应付赔款金额
     * @return 属性应付赔款金额的值
     */
    public double getPlanFee(){
        return planFee;
    }

    /**
     * 设置属性业务类型决定的该业务的正负相关性
     * @param settleDCFlag 待设置的属性业务类型决定的该业务的正负相关性的值
     */
    public void setSettleDCFlag(int settleDCFlag){
        this.settleDCFlag = settleDCFlag;
    }

    /**
     * 获取属性业务类型决定的该业务的正负相关性
     * @return 属性业务类型决定的该业务的正负相关性的值
     */
    public int getSettleDCFlag(){
        return settleDCFlag;
    }

    /**
     * 设置属性缴费起期
     * @param planStartDate 待设置的属性缴费起期的值
     */
    public void setPlanStartDate(DateTime planStartDate){
        this.planStartDate = planStartDate;
    }

    /**
     * 获取属性缴费起期
     * @return 属性缴费起期的值
     */
    public DateTime getPlanStartDate(){
        return planStartDate;
    }

    /**
     * 设置属性缴费止期
     * @param planEndDate 待设置的属性缴费止期的值
     */
    public void setPlanEndDate(DateTime planEndDate){
        this.planEndDate = planEndDate;
    }

    /**
     * 获取属性缴费止期
     * @return 属性缴费止期的值
     */
    public DateTime getPlanEndDate(){
        return planEndDate;
    }

    /**
     * 设置属性归属机构
     * @param comCode 待设置的属性归属机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构
     * @return 属性归属机构的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构
     * @param makeCom 待设置的属性出单机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构
     * @return 属性出单机构的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性代理人代码
     * @param agentCode 待设置的属性代理人代码的值
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * 获取属性代理人代码
     * @return 属性代理人代码的值
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * 设置属性代理人名称
     * @param agentName 待设置的属性代理人名称的值
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * 获取属性代理人名称
     * @return 属性代理人名称的值
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * 设置属性代理协议号码
     * @param agreementNo 待设置的属性代理协议号码的值
     */
    public void setAgreementNo(String agreementNo){
        this.agreementNo = StringUtils.rightTrim(agreementNo);
    }

    /**
     * 获取属性代理协议号码
     * @return 属性代理协议号码的值
     */
    public String getAgreementNo(){
        return agreementNo;
    }

    /**
     * 设置属性业务归属人员
     * @param handler1Code 待设置的属性业务归属人员的值
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * 获取属性业务归属人员
     * @return 属性业务归属人员的值
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * 设置属性业务归属人员名称
     * @param handler1Name 待设置的属性业务归属人员名称的值
     */
    public void setHandler1Name(String handler1Name){
        this.handler1Name = StringUtils.rightTrim(handler1Name);
    }

    /**
     * 获取属性业务归属人员名称
     * @return 属性业务归属人员名称的值
     */
    public String getHandler1Name(){
        return handler1Name;
    }

    /**
     * 设置属性经办人
     * @param handlerCode 待设置的属性经办人的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人
     * @return 属性经办人的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性业务渠道
     * @param businessNature 待设置的属性业务渠道的值
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * 获取属性业务渠道
     * @return 属性业务渠道的值
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * 设置属性业务性质
     * @param shareHolderFlag 待设置的属性业务性质的值
     */
    public void setShareHolderFlag(String shareHolderFlag){
        this.shareHolderFlag = StringUtils.rightTrim(shareHolderFlag);
    }

    /**
     * 获取属性业务性质
     * @return 属性业务性质的值
     */
    public String getShareHolderFlag(){
        return shareHolderFlag;
    }

   

    /**
     * 设置属性交强险车辆九大类明细
     * @param carNatureCode 待设置的属性交强险车辆九大类明细的值
     */
   /* public void setCarNatureCode(String carNatureCode){
        this.carNatureCode = StringUtils.rightTrim(carNatureCode);
    }

    *//**
     * 获取属性交强险车辆九大类明细
     * @return 属性交强险车辆九大类明细的值
     *//*
    public String getCarNatureCode(){
        return carNatureCode;
    }*/

    /**
     * 设置属性联共保标志
     * @param coinsFlag 待设置的属性联共保标志的值
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = StringUtils.rightTrim(coinsFlag);
    }

    /**
     * 获取属性联共保标志
     * @return 属性联共保标志的值
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }

    /**
     * 设置属性联共保人代码
     * @param coinsCode 待设置的属性联共保人代码的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性联共保人代码
     * @return 属性联共保人代码的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性联共保人名称
     * @param coinsName 待设置的属性联共保人名称的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性联共保人名称
     * @return 属性联共保人名称的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性联共保比例
     * @param coinsRate 待设置的属性联共保比例的值
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * 获取属性联共保比例
     * @return 属性联共保比例的值
     */
    public double getCoinsRate(){
        return coinsRate;
    }

    /**
     * 设置属性联共保类型
     * @param coinsType 待设置的属性联共保类型的值
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * 获取属性联共保类型
     * @return 属性联共保类型的值
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * 设置属性是否允许挂帐
     * @param accountFlag 待设置的属性是否允许挂帐的值
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * 获取属性是否允许挂帐
     * @return 属性是否允许挂帐的值
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * 设置属性是否组合产品标识
     * @param mainPolicyFlag 待设置的属性是否组合产品标识的值
     */
    public void setMainPolicyFlag(String mainPolicyFlag){
        this.mainPolicyFlag = StringUtils.rightTrim(mainPolicyFlag);
    }

    /**
     * 获取属性是否组合产品标识
     * @return 属性是否组合产品标识的值
     */
    public String getMainPolicyFlag(){
        return mainPolicyFlag;
    }

    /**
     * 设置属性境内境外标志
     * @param locationFlag 待设置的属性境内境外标志的值
     */
    public void setLocationFlag(String locationFlag){
        this.locationFlag = StringUtils.rightTrim(locationFlag);
    }

    /**
     * 获取属性境内境外标志
     * @return 属性境内境外标志的值
     */
    public String getLocationFlag(){
        return locationFlag;
    }

    /**
     * 设置属性核算单位
     * @param centerCode 待设置的属性核算单位的值
     */
    public void setCenterCode(String centerCode){
        this.centerCode = StringUtils.rightTrim(centerCode);
    }

    /**
     * 获取属性核算单位
     * @return 属性核算单位的值
     */
    public String getCenterCode(){
        return centerCode;
    }

    /**
     * 设置属性帐套类型
     * @param accBookType 待设置的属性帐套类型的值
     */
    public void setAccBookType(String accBookType){
        this.accBookType = StringUtils.rightTrim(accBookType);
    }

    /**
     * 获取属性帐套类型
     * @return 属性帐套类型的值
     */
    public String getAccBookType(){
        return accBookType;
    }

    /**
     * 设置属性帐套代码
     * @param accBookCode 待设置的属性帐套代码的值
     */
    public void setAccBookCode(String accBookCode){
        this.accBookCode = StringUtils.rightTrim(accBookCode);
    }

    /**
     * 获取属性帐套代码
     * @return 属性帐套代码的值
     */
    public String getAccBookCode(){
        return accBookCode;
    }

    /**
     * 设置属性挂帐会计期间
     * @param yearMonth 待设置的属性挂帐会计期间的值
     */
    public void setYearMonth(String yearMonth){
        this.yearMonth = StringUtils.rightTrim(yearMonth);
    }

    /**
     * 获取属性挂帐会计期间
     * @return 属性挂帐会计期间的值
     */
    public String getYearMonth(){
        return yearMonth;
    }

    /**
     * 设置属性挂帐凭证号
     * @param voucherNo 待设置的属性挂帐凭证号的值
     */
    public void setVoucherNo(String voucherNo){
        this.voucherNo = StringUtils.rightTrim(voucherNo);
    }

    /**
     * 获取属性挂帐凭证号
     * @return 属性挂帐凭证号的值
     */
    public String getVoucherNo(){
        return voucherNo;
    }

    /**
     * 设置属性实际挂帐时间
     * @param voucherDate 待设置的属性实际挂帐时间的值
     */
    public void setVoucherDate(DateTime voucherDate){
        this.voucherDate = voucherDate;
    }

    /**
     * 获取属性实际挂帐时间
     * @return 属性实际挂帐时间的值
     */
    public DateTime getVoucherDate(){
        return voucherDate;
    }

    /**
     * 设置属性挂帐汇率（CNY）
     * @param exchangeRate 待设置的属性挂帐汇率（CNY）的值
     */
    public void setExchangeRate(double exchangeRate){
        this.exchangeRate = exchangeRate;
    }

    /**
     * 获取属性挂帐汇率（CNY）
     * @return 属性挂帐汇率（CNY）的值
     */
    public double getExchangeRate(){
        return exchangeRate;
    }

    /**
     * 设置属性挂帐金额（CNY）
     * @param planFeeCNY 待设置的属性挂帐金额（CNY）的值
     */
    public void setPlanFeeCNY(double planFeeCNY){
        this.planFeeCNY = planFeeCNY;
    }

    /**
     * 获取属性挂帐金额（CNY）
     * @return 属性挂帐金额（CNY）的值
     */
    public double getPlanFeeCNY(){
        return planFeeCNY;
    }

    /**
     * 设置属性应付挂帐收付号
     * @param planPayRefNo 待设置的属性应付挂帐收付号的值
     */
    public void setPlanPayRefNo(String planPayRefNo){
        this.planPayRefNo = StringUtils.rightTrim(planPayRefNo);
    }

    /**
     * 获取属性应付挂帐收付号
     * @return 属性应付挂帐收付号的值
     */
    public String getPlanPayRefNo(){
        return planPayRefNo;
    }

    /**
     * 设置属性是否可以实际收付
     * @param realPayFlag 待设置的属性是否可以实际收付的值
     */
    public void setRealPayFlag(String realPayFlag){
        this.realPayFlag = StringUtils.rightTrim(realPayFlag);
    }

    /**
     * 获取属性是否可以实际收付
     * @return 属性是否可以实际收付的值
     */
    public String getRealPayFlag(){
        return realPayFlag;
    }

    /**
     * 设置属性已支付金额(应收付币种)
     * @param realPayRefFee 待设置的属性已支付金额(应收付币种)的值
     */
    public void setRealPayRefFee(double realPayRefFee){
        this.realPayRefFee = realPayRefFee;
    }

    /**
     * 获取属性已支付金额(应收付币种)
     * @return 属性已支付金额(应收付币种)的值
     */
    public double getRealPayRefFee(){
        return realPayRefFee;
    }

    /**
     * 设置属性已支付次数
     * @param payRefTimes 待设置的属性已支付次数的值
     */
    public void setPayRefTimes(int payRefTimes){
        this.payRefTimes = payRefTimes;
    }

    /**
     * 获取属性已支付次数
     * @return 属性已支付次数的值
     */
    public int getPayRefTimes(){
        return payRefTimes;
    }

    /**
     * 设置属性最近一次实付日期
     * @param payRefDate 待设置的属性最近一次实付日期的值
     */
    public void setPayRefDate(DateTime payRefDate){
        this.payRefDate = payRefDate;
    }

    /**
     * 获取属性最近一次实付日期
     * @return 属性最近一次实付日期的值
     */
    public DateTime getPayRefDate(){
        return payRefDate;
    }

    /**
     * 设置属性记录状态
     * @param itemStatus 待设置的属性记录状态的值
     */
    public void setItemStatus(String itemStatus){
        this.itemStatus = StringUtils.rightTrim(itemStatus);
    }

    /**
     * 获取属性记录状态
     * @return 属性记录状态的值
     */
    public String getItemStatus(){
        return itemStatus;
    }

    /**
     * 设置属性操作任务ID
     * @param taskID 待设置的属性操作任务ID的值
     */
    public void setTaskID(long taskID){
        this.taskID = taskID;
    }

    /**
     * 获取属性操作任务ID
     * @return 属性操作任务ID的值
     */
    public long getTaskID(){
        return taskID;
    }

    /**
     * 设置属性备用字段1
     * @param attribute1 待设置的属性备用字段1的值
     */
    public void setAttribute1(String attribute1){
        this.attribute1 = StringUtils.rightTrim(attribute1);
    }

    /**
     * 获取属性备用字段1
     * @return 属性备用字段1的值
     */
    public String getAttribute1(){
        return attribute1;
    }

    /**
     * 设置属性备用字段2
     * @param attribute2 待设置的属性备用字段2的值
     */
    public void setAttribute2(String attribute2){
        this.attribute2 = StringUtils.rightTrim(attribute2);
    }

    /**
     * 获取属性备用字段2
     * @return 属性备用字段2的值
     */
    public String getAttribute2(){
        return attribute2;
    }

    /**
     * 设置属性备用字段3
     * @param attribute3 待设置的属性备用字段3的值
     */
    public void setAttribute3(String attribute3){
        this.attribute3 = StringUtils.rightTrim(attribute3);
    }

    /**
     * 获取属性备用字段3
     * @return 属性备用字段3的值
     */
    public String getAttribute3(){
        return attribute3;
    }

    /**
     * 设置属性备用字段4
     * @param attribute4 待设置的属性备用字段4的值
     */
    public void setAttribute4(String attribute4){
        this.attribute4 = StringUtils.rightTrim(attribute4);
    }

    /**
     * 获取属性备用字段4
     * @return 属性备用字段4的值
     */
    public String getAttribute4(){
        return attribute4;
    }
    //FIXME add by zhanglina 添加字段 20100912 begin
    /**
     * 获取属性投保查询码
     * @return 属性投保查询码的值
     */

	public String getDemandNo() {
		return demandNo;
	}

	/**
	 * 设置属性投保查询码
	 * @param demandNo 投保查询码
	 */
	public void setDemandNo(String demandNo) {
		this.demandNo = StringUtils.rightTrim(demandNo);
	}

	 /**
     * 获取属性上传标识
     * @return 属性上传标识的值
     */
	public String getUFlag() {
		return uFlag;
	}

	 /**
     * 设置属性上传标识
     * @return 属性上传标识的值
     */
	public void setUFlag(String uFlag) {
		this.uFlag = StringUtils.rightTrim(uFlag);
	}

	 /**
     * 获取属性投保确认码码
     * @return 属性投保确认码的值
     */
	public String getValidNo() {
		return validNo;
	}

	 /**
     * 设置属性投保确认码
     * @return 属性投保确认码的值
     */
	public void setValidNo(String validNo) {
		this.validNo = StringUtils.rightTrim(validNo);
	}
	
	/**
	 * 获取属性发送短信日期
	 * @return 发送短信日期
	 */
	public DateTime getMsgDate() {
		return msgDate;
	}

	/**
	 * 设置属性发送短信日期
	 * @param msgDate 发送短信日期
	 */
	public void setMsgDate(DateTime msgDate) {
		this.msgDate = msgDate;
	}

	/**
	 * 获取属性发送短信标识
	 * @return 发送短信标识
	 */
	public String getMsgFlag() {
		return msgFlag;
	}

	/**
	 * 设置属性发送短信标识
	 * @param msgFlag 发送短信标识
	 */
	public void setMsgFlag(String msgFlag) {
		this.msgFlag = msgFlag;
	}
	//FIXME add by zhanglina 添加字段 20100912 end
	//add by xiaoqin 添加字段 20110815 start
	
	/**
	 * 获取属性银行代码
	 * @return 银行代码
	 */
	public String getBankCode() {
		return bankCode;
	}
	
	/**
	 * 设置属性银行代码
	 * @param bankCode 银行代码
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	/**
	 * 获取属性银行名称
	 * @return 银行名称
	 */
	public String getBankName() {
		return bankName;
	}
	
	/**
	 * 设置属性银行名称
	 * @param bankName 银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	/**
	 * 获取属性开户行省份代码
	 * @return 获取属性开户行省份代码
	 */
	public String getBankCode1() {
		return bankCode1;
	}
	
	/**
	 * 设置属性开户行一级代码
	 * @param bankCode1 开户行一级代码
	 */
	public void setBankCode1(String bankCode1) {
		this.bankCode1 = bankCode1;
	}
	
	/**
	 * 获取属性开户行地区代码
	 * @return 获取属性开户行地区代码
	 */
	public String getBankCode2() {
		return bankCode2;
	}
	
	/**
	 * 设置属性开户行地区代码
	 * @param bankCode2 开户行地区代码
	 */
	public void setBankCode2(String bankCode2) {
		this.bankCode2 = bankCode2;
	}
	/**
	 * 获取属性开户行联行号代码
	 * @return 开户行联行号代码
	 */
	public String getBankItemCode() {
		return bankItemCode;
	}
	
	/**
	 * 设置属性开户行联行号代码
	 * @param bankItem 开户行联行号代码
	 */
	public void setBankItemCode(String bankItemCode) {
		this.bankItemCode = bankItemCode;
	}
	
	/**
	 * 获取属性开户行联行号名称
	 * @return 开户行联行号名称
	 */
	public String getBankItemName() {
		return bankItemName;
	}
	
	/**
	 * 设置属性开户行联行号名称
	 * @param bankItem 开户行联行号名称
	 */
	public void setBankItemName(String bankItemName) {
		this.bankItemName = bankItemName;
	}
	
	/**
	 * 获取属性开户行明细
	 * @return 开户行明细
	 */
	public String getBankOthDetail() {
		return bankOthDetail;
	}
	
	/**
	 * 设置属性开户行明细
	 * @param bankItem 开户行明细
	 */
	public void setBankOthDetail(String bankOthDetail) {
		this.bankOthDetail = bankOthDetail;
	}
	
	/**
	 * 获取属性账户性质
	 * @return 账户性质
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * 设置属性账户性质
	 * @param accountType 账户性质
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * 获取属性银行帐号
	 * @return 银行帐号
	 */
	public String getAccountCode() {
		return accountCode;
	}
	
	/**
	 * 设置属性银行帐号
	 * @param accountCode 银行帐号
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	
	/**
	 * 获取属性开户人名称
	 * @return 获取属性开户人名称
	 */
	public String getAccountName() {
		return accountName;
	}
	
	/**
	 * 设置属性开户人名称
	 * @param accountName 开户人名称
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
    
    /**
	 * 获取属性是否申请例外标志  Y:是 N:否
	 * @return 获取属性是否申请例外标志  Y:是 N:否
	 */
	public String getExceptionFlag() {
		return exceptionFlag;
	}
	
	/**
	 * 设置属性是否申请例外标志  Y:是 N:否
	 * @param exceptionFlag 是否申请例外标志  Y:是 N:否
	 */
	public void setExceptionFlag(String exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}
    
	/**
	 * 获取属性启动例外标志  Y:是 N:否
	 * @return 获取属性启动例外标志  Y:是 N:否
	 */
	public String getExceptionStartFlag() {
		return exceptionStartFlag;
	}
	
	/**
	 * 设置属性启动例外标志  Y:是 N:否
	 * @param exceptionStartFlag 启动例外标志  Y:是 N:否
	 */
	public void setExceptionStartFlag(String exceptionStartFlag) {
		this.exceptionStartFlag = exceptionStartFlag;
	}
	
	/**
	 * 获取属性启动例外原因
	 * @return 获取属性启动例外原因
	 */
	public String getExceptionInfo() {
		return exceptionInfo;
	}
	
	/**
	 * 设置属性启动例外原因
	 * @param exceptionInfo 启动例外原因
	 */
	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}
    
	
	/**
	 * 获取属性备用字段5
	 * @return 获取属性备用字段5
	 */
	public String getAttribute5() {
		return attribute5;
	}
	
	/**
	 * 设置属性备用字段5
	 * @param attribute5  备用字段5
	 */
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	
	/**
	 * 获取属性备用字段6
	 * @return 获取属性备用字段6
	 */
	public String getAttribute6() {
		return attribute6;
	}
	
	/**
	 * 设置属性备用字段6
	 * @param attribute6  备用字段6
	 */
	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}
	
	/**
	 * 获取属性备用字段7
	 * @return 获取属性备用字段7
	 */
	public String getAttribute7() {
		return attribute7;
	}
	
	/**
	 * 设置属性备用字段7
	 * @param attribute7  备用字段7
	 */
	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}
	
	/**
	 * 获取属性备用字段8
	 * @return 获取属性备用字段8
	 */
	public String getAttribute8() {
		return attribute8;
	}
	
	/**
	 * 设置属性备用字段8
	 * @param attribute8  备用字段8
	 */
	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}
	//add by xiaoqin 添加字段 20110815 end
	
	//add by xiaoqin 20120425 start  代位求偿
	public void setRecoveryFlag(String recoveryFlag) {
		this.recoveryFlag = recoveryFlag;
	}

	public String getRecoveryFlag() {
		return recoveryFlag;
	}
	//add by xiaoqin 20120425 end 代位求偿

	public String getAcpaymentinfoid() {
		return acpaymentinfoid;
	}

	public void setAcpaymentinfoid(String acpaymentinfoid) {
		this.acpaymentinfoid = acpaymentinfoid;
	}

	public String getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public String getRecoveryCode() {
		return recoveryCode;
	}

	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}

	public String getSamepersonFlag() {
		return samepersonFlag;
	}

	public void setSamepersonFlag(String samepersonFlag) {
		this.samepersonFlag = samepersonFlag;
	}

	public void setInvPrintFlag(String invPrintFlag) {
		this.invPrintFlag = invPrintFlag;
	}

	public String getInvPrintFlag() {
		return invPrintFlag;
	}

	public void setInvPrintFee(double invPrintFee) {
		this.invPrintFee = invPrintFee;
	}

	public double getInvPrintFee() {
		return invPrintFee;
	}

	public void setInvPrintTimes(int invPrintTimes) {
		this.invPrintTimes = invPrintTimes;
	}

	public int getInvPrintTimes() {
		return invPrintTimes;
	}

	public void setInvPrintDate(DateTime invPrintDate) {
		this.invPrintDate = invPrintDate;
	}

	public DateTime getInvPrintDate() {
		return invPrintDate;
	}

	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}

	public String getInvCode() {
		return invCode;
	}

	public void setInvSerialNo(String invSerialNo) {
		this.invSerialNo = invSerialNo;
	}

	public String getInvSerialNo() {
		return invSerialNo;
	}

	public void setInvPrintedFlag(String invPrintedFlag) {
		this.invPrintedFlag = invPrintedFlag;
	}

	public String getInvPrintedFlag() {
		return invPrintedFlag;
	}

	public void setDamageDate(DateTime damageDate) {
		this.damageDate = damageDate;
	}

	public DateTime getDamageDate() {
		return damageDate;
	}

	public void setBackTimes(int backTimes) {
		this.backTimes = backTimes;
	}

	public int getBackTimes() {
		return backTimes;
	}
	//add by zhangchenlong 添加字段 20131227 start

	public DateTime getPayUndwrtDate() {
		return payUndwrtDate;
	}

	public void setPayUndwrtDate(DateTime payUndwrtDate) {
		this.payUndwrtDate = payUndwrtDate;
	}

	public String getNewRuleFlag() {
		return newRuleFlag;
	}

	public void setNewRuleFlag(String newRuleFlag) {
		this.newRuleFlag = newRuleFlag;
	}
	//add by zhangchenlong 添加字段 20131227 end

	public String getPackFlag() {
		return packFlag;
	}

	public void setPackFlag(String packFlag) {
		this.packFlag = packFlag;
	}

	public String getTransFlag() {
		return transFlag;
	}

	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}

	public DateTime getFirstExportDate() {
		return FirstExportDate;
	}

	public void setFirstExportDate(DateTime firstExportDate) {
		FirstExportDate = firstExportDate;
	}

	public DateTime getNewExportDate() {
		return NewExportDate;
	}

	public void setNewExportDate(DateTime newExportDate) {
		NewExportDate = newExportDate;
	}
	
    // add by fengwenjia 添加字段 20161010 begin
	/**
	 * 获取批次号
	 * @return 批次号
	 */
    public String getPkBill() {
		return pkBill;
	}

    /**
     * 设置批次号
     * @param pkBill 批次号
     */
	public void setPkBill(String pkBill) {
		this.pkBill = pkBill;
	}
	// add by fengwenjia 添加字段 20161010 end
}
