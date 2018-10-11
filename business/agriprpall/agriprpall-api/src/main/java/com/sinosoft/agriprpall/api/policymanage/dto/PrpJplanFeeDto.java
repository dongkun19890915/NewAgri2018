package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;
import java.io.Serializable;
import java.util.Date;

public class PrpJplanFeeDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款 */

    private String certiType ;/** 属性保单号码/批单号码/保单号码/批单号码 */

    private String certiNo ;/** 属性保单号码/保单号码 */
    private String policyNo ;/** 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号) */
    private String payRefreason ;



    /** 属性交费计划序号(PrpCplan.SerialNo)/交费计划序号(PrpCplan.SerialNo) */
    private Integer serialNo ;

    /** 属性立案号/立案号 */
    private String claimNo ;
    /** 属性险类/险类 */
    private String classCode ;
    /** 属性险种/险种 */
    private String riskCode ;
    /** 属性合同号/合同号 */
    private String contractNo ;
    /** 属性投保人/投保人 */
    private String appliCode ;
    /** 属性投保人名称/投保人名称 */
    private String appliName ;
    /** 属性被保险人/被保险人 */
    private String insuredCode ;
    /** 属性被保人名称/被保人名称 */
    private String insuredName ;
    /** 属性起保日期/起保日期 */
    private Date startDate ;
    /** 属性终保日期/终保日期 */
    private Date endDate ;
    /** 属性批单生效日期/批单生效日期 */
    private Date validdate ;
    /** 属性缴费期数/缴费期数 */
    private Integer payNo ;
    /** 属性应收币种（保单实收币别）/应收币种（保单实收币别） */
    private String currency1 ;
    /** 属性应收应付金额（保单实收币别金额）/应收应付金额（保单实收币别金额） */
    private Double planFee ;
    /** 属性分期缴费日期/分期缴费日期 */
    private Date planDate ;
    /** 属性归属机构/归属机构 */
    private String comCode ;
    /** 属性出单机构/出单机构 */
    private String makeCom ;
    /** 属性代理人代码/代理人代码 */
    private String agentcode ;
    /** 属性业务归属人员/业务归属人员 */
    private String handler1code ;
    /** 属性经办人/经办人 */
    private String handlercode ;
    /** 属性核保/赔日期/核保/赔日期 */
    private Date underwritedate ;
    /** 属性联共保标志/联共保标志 */
    private String coinsflag ;
    /** 属性联共保人代码/联共保人代码 */
    private String coinscode ;
    /** 属性联共保人名称/联共保人名称 */
    private String coinsname ;
    /** 属性联共保类型/联共保类型 */
    private String coinstype ;
    /** 属性核算单位/核算单位 */
    private String centercode ;
    /** 属性基层单位/基层单位 */
    private String branchcode ;
    /** 属性帐套类型/帐套类型 */
    private String accbooktype ;
    /** 属性帐套代码/帐套代码 */
    private String accbookcode ;
    /** 属性会计期间/会计期间 */
    private String yearmonth ;
    /** 属性凭证号/凭证号 */
    private String voucherno ;
    /** 属性应收/应付汇率/应收/应付汇率 */
    private Double exchangerate ;
    /** 属性应收/应付进帐金额/应收/应付进帐金额 */
    private Double planfeecny ;
    /** 属性收收/应付金额(折应收付币种)/收收/应付金额(折应收付币种) */
    private Double payreffee ;
    /** 属性收收/应付确认金额(折应收付币种)/收收/应付确认金额(折应收付币种) */
    private Double realpayreffee ;
    /** 属性预留标志/预留标志 */
    private String flag ;
    /** 属性业务渠道/业务渠道 */
    private String businessnature ;
    /** 属性总缴费次数/总缴费次数 */
    private String othflag ;
    /** 属性交强险车辆九大类类/交强险车辆九大类类 */
    private String carnaturecode ;
    /** 属性交强险九大类使用性质(与业务不同)/交强险九大类使用性质(与业务不同) */
    private String usenaturecode ;
    /** 属性交强险九大类车的属性/交强险九大类车的属性 */
    private Double carproperty ;
    /** 属性paycomcode/paycomcode */
    private String paycomcode ;
    /** 属性农业/涉农/非农标志/农业/涉农/非农标志 */
    private String businesstype ;
    /** 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志 */
    private String businesstype1 ;
    /** 属性payrefstate/payrefstate */
    private String payrefstate ;
    /** 属性recoveryserialno/recoveryserialno */
    private String recoveryserialno ;
    /** 属性修改人/修改人 */
    private String updateBy ;
    /** 属性修改时间/修改时间 */
    private Date updateDate ;
    /** 属性税额/税额 */
    private Double vatax ;
    /** 属性不含税保费/不含税保费 */
    private Double ntplanfee ;
    /** 属性免税比例/免税比例 */
    private Integer dutyratio ;

    /**
     * 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款的getter方法
     */
    public String getCertiType() {
        return certiType;
    }
    /**
     * 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款的setter方法
     */
    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }
    /**
     * 属性保单号码/批单号码/保单号码/批单号码的getter方法
     */
    public String getCertiNo() {
        return certiNo;
    }
    /**
     * 属性保单号码/批单号码/保单号码/批单号码的setter方法
     */
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }
    /**
     * 属性保单号码/保单号码的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性保单号码/保单号码的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性交费计划序号(PrpCplan.SerialNo)/交费计划序号(PrpCplan.SerialNo)的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 属性交费计划序号(PrpCplan.SerialNo)/交费计划序号(PrpCplan.SerialNo)的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号)的getter方法
     */
    public String getPayRefreason() {
        return payRefreason;
    }
    /**
     * 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号)的setter方法
     */
    public void setPayRefreason(String payRefreason) {
        this.payRefreason = payRefreason;
    }
    /**
     * 属性立案号/立案号的getter方法
     */
    public String getClaimNo() {
        return claimNo;
    }
    /**
     * 属性立案号/立案号的setter方法
     */
    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }
    /**
     * 属性险类/险类的getter方法
     */
    public String getClassCode() {
        return classCode;
    }
    /**
     * 属性险类/险类的setter方法
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    /**
     * 属性险种/险种的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }
    /**
     * 属性险种/险种的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
    /**
     * 属性合同号/合同号的getter方法
     */
    public String getContractNo() {
        return contractNo;
    }
    /**
     * 属性合同号/合同号的setter方法
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
    /**
     * 属性投保人/投保人的getter方法
     */
    public String getAppliCode() {
        return appliCode;
    }
    /**
     * 属性投保人/投保人的setter方法
     */
    public void setAppliCode(String appliCode) {
        this.appliCode = appliCode;
    }
    /**
     * 属性投保人名称/投保人名称的getter方法
     */
    public String getAppliName() {
        return appliName;
    }
    /**
     * 属性投保人名称/投保人名称的setter方法
     */
    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }
    /**
     * 属性被保险人/被保险人的getter方法
     */
    public String getInsuredCode() {
        return insuredCode;
    }
    /**
     * 属性被保险人/被保险人的setter方法
     */
    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }
    /**
     * 属性被保人名称/被保人名称的getter方法
     */
    public String getInsuredName() {
        return insuredName;
    }
    /**
     * 属性被保人名称/被保人名称的setter方法
     */
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    /**
     * 属性起保日期/起保日期的getter方法
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * 属性起保日期/起保日期的setter方法
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * 属性终保日期/终保日期的getter方法
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * 属性终保日期/终保日期的setter方法
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * 属性批单生效日期/批单生效日期的getter方法
     */
    public Date getValiddate() {
        return validdate;
    }
    /**
     * 属性批单生效日期/批单生效日期的setter方法
     */
    public void setValiddate(Date validdate) {
        this.validdate = validdate;
    }
    /**
     * 属性缴费期数/缴费期数的getter方法
     */
    public Integer getPayNo() {
        return payNo;
    }
    /**
     * 属性缴费期数/缴费期数的setter方法
     */
    public void setPayNo(Integer payNo) {
        this.payNo = payNo;
    }
    /**
     * 属性应收币种（保单实收币别）/应收币种（保单实收币别）的getter方法
     */
    public String getCurrency1() {
        return currency1;
    }
    /**
     * 属性应收币种（保单实收币别）/应收币种（保单实收币别）的setter方法
     */
    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }
    /**
     * 属性应收应付金额（保单实收币别金额）/应收应付金额（保单实收币别金额）的getter方法
     */
    public Double getPlanFee() {
        return planFee;
    }
    /**
     * 属性应收应付金额（保单实收币别金额）/应收应付金额（保单实收币别金额）的setter方法
     */
    public void setPlanFee(Double planFee) {
        this.planFee = planFee;
    }
    /**
     * 属性分期缴费日期/分期缴费日期的getter方法
     */
    public Date getPlanDate() {
        return planDate;
    }
    /**
     * 属性分期缴费日期/分期缴费日期的setter方法
     */
    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }
    /**
     * 属性归属机构/归属机构的getter方法
     */
    public String getComCode() {
        return comCode;
    }
    /**
     * 属性归属机构/归属机构的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
    /**
     * 属性出单机构/出单机构的getter方法
     */
    public String getMakeCom() {
        return makeCom;
    }
    /**
     * 属性出单机构/出单机构的setter方法
     */
    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }
    /**
     * 属性代理人代码/代理人代码的getter方法
     */
    public String getAgentcode() {
        return agentcode;
    }
    /**
     * 属性代理人代码/代理人代码的setter方法
     */
    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode;
    }
    /**
     * 属性业务归属人员/业务归属人员的getter方法
     */
    public String getHandler1code() {
        return handler1code;
    }
    /**
     * 属性业务归属人员/业务归属人员的setter方法
     */
    public void setHandler1code(String handler1code) {
        this.handler1code = handler1code;
    }
    /**
     * 属性经办人/经办人的getter方法
     */
    public String getHandlercode() {
        return handlercode;
    }
    /**
     * 属性经办人/经办人的setter方法
     */
    public void setHandlercode(String handlercode) {
        this.handlercode = handlercode;
    }
    /**
     * 属性核保/赔日期/核保/赔日期的getter方法
     */
    public Date getUnderwritedate() {
        return underwritedate;
    }
    /**
     * 属性核保/赔日期/核保/赔日期的setter方法
     */
    public void setUnderwritedate(Date underwritedate) {
        this.underwritedate = underwritedate;
    }
    /**
     * 属性联共保标志/联共保标志的getter方法
     */
    public String getCoinsflag() {
        return coinsflag;
    }
    /**
     * 属性联共保标志/联共保标志的setter方法
     */
    public void setCoinsflag(String coinsflag) {
        this.coinsflag = coinsflag;
    }
    /**
     * 属性联共保人代码/联共保人代码的getter方法
     */
    public String getCoinscode() {
        return coinscode;
    }
    /**
     * 属性联共保人代码/联共保人代码的setter方法
     */
    public void setCoinscode(String coinscode) {
        this.coinscode = coinscode;
    }
    /**
     * 属性联共保人名称/联共保人名称的getter方法
     */
    public String getCoinsname() {
        return coinsname;
    }
    /**
     * 属性联共保人名称/联共保人名称的setter方法
     */
    public void setCoinsname(String coinsname) {
        this.coinsname = coinsname;
    }
    /**
     * 属性联共保类型/联共保类型的getter方法
     */
    public String getCoinstype() {
        return coinstype;
    }
    /**
     * 属性联共保类型/联共保类型的setter方法
     */
    public void setCoinstype(String coinstype) {
        this.coinstype = coinstype;
    }
    /**
     * 属性核算单位/核算单位的getter方法
     */
    public String getCentercode() {
        return centercode;
    }
    /**
     * 属性核算单位/核算单位的setter方法
     */
    public void setCentercode(String centercode) {
        this.centercode = centercode;
    }
    /**
     * 属性基层单位/基层单位的getter方法
     */
    public String getBranchcode() {
        return branchcode;
    }
    /**
     * 属性基层单位/基层单位的setter方法
     */
    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }
    /**
     * 属性帐套类型/帐套类型的getter方法
     */
    public String getAccbooktype() {
        return accbooktype;
    }
    /**
     * 属性帐套类型/帐套类型的setter方法
     */
    public void setAccbooktype(String accbooktype) {
        this.accbooktype = accbooktype;
    }
    /**
     * 属性帐套代码/帐套代码的getter方法
     */
    public String getAccbookcode() {
        return accbookcode;
    }
    /**
     * 属性帐套代码/帐套代码的setter方法
     */
    public void setAccbookcode(String accbookcode) {
        this.accbookcode = accbookcode;
    }
    /**
     * 属性会计期间/会计期间的getter方法
     */
    public String getYearmonth() {
        return yearmonth;
    }
    /**
     * 属性会计期间/会计期间的setter方法
     */
    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }
    /**
     * 属性凭证号/凭证号的getter方法
     */
    public String getVoucherno() {
        return voucherno;
    }
    /**
     * 属性凭证号/凭证号的setter方法
     */
    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }
    /**
     * 属性应收/应付汇率/应收/应付汇率的getter方法
     */
    public Double getExchangerate() {
        return exchangerate;
    }
    /**
     * 属性应收/应付汇率/应收/应付汇率的setter方法
     */
    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }
    /**
     * 属性应收/应付进帐金额/应收/应付进帐金额的getter方法
     */
    public Double getPlanfeecny() {
        return planfeecny;
    }
    /**
     * 属性应收/应付进帐金额/应收/应付进帐金额的setter方法
     */
    public void setPlanfeecny(Double planfeecny) {
        this.planfeecny = planfeecny;
    }
    /**
     * 属性收收/应付金额(折应收付币种)/收收/应付金额(折应收付币种)的getter方法
     */
    public Double getPayreffee() {
        return payreffee;
    }
    /**
     * 属性收收/应付金额(折应收付币种)/收收/应付金额(折应收付币种)的setter方法
     */
    public void setPayreffee(Double payreffee) {
        this.payreffee = payreffee;
    }
    /**
     * 属性收收/应付确认金额(折应收付币种)/收收/应付确认金额(折应收付币种)的getter方法
     */
    public Double getRealpayreffee() {
        return realpayreffee;
    }
    /**
     * 属性收收/应付确认金额(折应收付币种)/收收/应付确认金额(折应收付币种)的setter方法
     */
    public void setRealpayreffee(Double realpayreffee) {
        this.realpayreffee = realpayreffee;
    }
    /**
     * 属性预留标志/预留标志的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性预留标志/预留标志的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性业务渠道/业务渠道的getter方法
     */
    public String getBusinessnature() {
        return businessnature;
    }
    /**
     * 属性业务渠道/业务渠道的setter方法
     */
    public void setBusinessnature(String businessnature) {
        this.businessnature = businessnature;
    }
    /**
     * 属性总缴费次数/总缴费次数的getter方法
     */
    public String getOthflag() {
        return othflag;
    }
    /**
     * 属性总缴费次数/总缴费次数的setter方法
     */
    public void setOthflag(String othflag) {
        this.othflag = othflag;
    }
    /**
     * 属性交强险车辆九大类类/交强险车辆九大类类的getter方法
     */
    public String getCarnaturecode() {
        return carnaturecode;
    }
    /**
     * 属性交强险车辆九大类类/交强险车辆九大类类的setter方法
     */
    public void setCarnaturecode(String carnaturecode) {
        this.carnaturecode = carnaturecode;
    }
    /**
     * 属性交强险九大类使用性质(与业务不同)/交强险九大类使用性质(与业务不同)的getter方法
     */
    public String getUsenaturecode() {
        return usenaturecode;
    }
    /**
     * 属性交强险九大类使用性质(与业务不同)/交强险九大类使用性质(与业务不同)的setter方法
     */
    public void setUsenaturecode(String usenaturecode) {
        this.usenaturecode = usenaturecode;
    }
    /**
     * 属性交强险九大类车的属性/交强险九大类车的属性的getter方法
     */
    public Double getCarproperty() {
        return carproperty;
    }
    /**
     * 属性交强险九大类车的属性/交强险九大类车的属性的setter方法
     */
    public void setCarproperty(Double carproperty) {
        this.carproperty = carproperty;
    }
    /**
     * 属性paycomcode/paycomcode的getter方法
     */
    public String getPaycomcode() {
        return paycomcode;
    }
    /**
     * 属性paycomcode/paycomcode的setter方法
     */
    public void setPaycomcode(String paycomcode) {
        this.paycomcode = paycomcode;
    }
    /**
     * 属性农业/涉农/非农标志/农业/涉农/非农标志的getter方法
     */
    public String getBusinesstype() {
        return businesstype;
    }
    /**
     * 属性农业/涉农/非农标志/农业/涉农/非农标志的setter方法
     */
    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }
    /**
     * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的getter方法
     */
    public String getBusinesstype1() {
        return businesstype1;
    }
    /**
     * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的setter方法
     */
    public void setBusinesstype1(String businesstype1) {
        this.businesstype1 = businesstype1;
    }
    /**
     * 属性payrefstate/payrefstate的getter方法
     */
    public String getPayrefstate() {
        return payrefstate;
    }
    /**
     * 属性payrefstate/payrefstate的setter方法
     */
    public void setPayrefstate(String payrefstate) {
        this.payrefstate = payrefstate;
    }
    /**
     * 属性recoveryserialno/recoveryserialno的getter方法
     */
    public String getRecoveryserialno() {
        return recoveryserialno;
    }
    /**
     * 属性recoveryserialno/recoveryserialno的setter方法
     */
    public void setRecoveryserialno(String recoveryserialno) {
        this.recoveryserialno = recoveryserialno;
    }
    /**
     * 属性修改人/修改人的getter方法
     */
    public String getUpdateBy() {
        return updateBy;
    }
    /**
     * 属性修改人/修改人的setter方法
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    /**
     * 属性修改时间/修改时间的getter方法
     */
    public Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 属性修改时间/修改时间的setter方法
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * 属性税额/税额的getter方法
     */
    public Double getVatax() {
        return vatax;
    }
    /**
     * 属性税额/税额的setter方法
     */
    public void setVatax(Double vatax) {
        this.vatax = vatax;
    }
    /**
     * 属性不含税保费/不含税保费的getter方法
     */
    public Double getNtplanfee() {
        return ntplanfee;
    }
    /**
     * 属性不含税保费/不含税保费的setter方法
     */
    public void setNtplanfee(Double ntplanfee) {
        this.ntplanfee = ntplanfee;
    }
    /**
     * 属性免税比例/免税比例的getter方法
     */
    public Integer getDutyratio() {
        return dutyratio;
    }
    /**
     * 属性免税比例/免税比例的setter方法
     */
    public void setDutyratio(Integer dutyratio) {
        this.dutyratio = dutyratio;
    }

}
