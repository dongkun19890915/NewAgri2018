package com.sinosoft.agriprpall.api.endorsemanage.dto;

/**
 *  不分流程的itemkind实体类
 * @author 王心洋
 * @time 2017-11-06
 */
public class ItemKindDto {
    private static final long serialVersionUID = 1L;
    // 业务单号 BusinessNo
    private String businessNo = "";
    // 险种 RiskCode
    private String riskCode = "";
    // 序号 ItemKindNo
    private String itemKindNo = "";
    // 险别代码KindCode
    private String kindCode = "";
    // 应/免税标志
    private String taxFlag = "";
    // 保额 amount，批改时为变化量
    private double amount;
    // 保费 Premium，批改时为变化量
    private double premium;
    // 不含税保费 noTaxPremium
    private double noTaxPremium;
    // 税率 taxRate，批改时需传入投保时的税率
    private double taxRate;
    // 税额 taxFee，批改时为变化量
    private double taxFee;
    //FeeTax 手续费税额
    private double FeeTax;
    //Fee 含税手续费
    private double Fee;
    //NoTaxFee 不含税手续费
    private double NoTaxFee;
    //feeTaxRate 手续费税率
    private double feeTaxRate;
    //联共保 我方含税保费
    private double oCPremium;
    //联共保 我方 不含税保费
    private double oCNoTaxPremium;
    //联共保 我方 税额
    private double oCTaxFee;

    private double orderByPremium;

    public double getoCPremium() {
        return oCPremium;
    }

    public void setoCPremium(double oCPremium) {
        this.oCPremium = oCPremium;
    }

    public double getoCNoTaxPremium() {
        return oCNoTaxPremium;
    }

    public void setoCNoTaxPremium(double oCNoTaxPremium) {
        this.oCNoTaxPremium = oCNoTaxPremium;
    }

    public double getoCTaxFee() {
        return oCTaxFee;
    }

    public void setoCTaxFee(double oCTaxFee) {
        this.oCTaxFee = oCTaxFee;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getItemKindNo() {
        return itemKindNo;
    }

    public void setItemKindNo(String itemKindNo) {
        this.itemKindNo = itemKindNo;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getNoTaxPremium() {
        return noTaxPremium;
    }

    public void setNoTaxPremium(double noTaxPremium) {
        this.noTaxPremium = noTaxPremium;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(double taxFee) {
        this.taxFee = taxFee;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public double getNoTaxFee() {
        return NoTaxFee;
    }

    public void setNoTaxFee(double noTaxFee) {
        NoTaxFee = noTaxFee;
    }

    public double getFeeTax() {
        return FeeTax;
    }

    public void setFeeTax(double feeTax) {
        FeeTax = feeTax;
    }

    public double getFeeTaxRate() {
        return feeTaxRate;
    }

    public void setFeeTaxRate(double feeTaxRate) {
        this.feeTaxRate = feeTaxRate;
    }

    public int compareTo(ItemKindDto o) {
        // TODO Auto-generated method stub
        double premium1 = this.premium*100;
        double premium2 = o.getPremium()*100;

        return (int)(premium1-premium2);
    }

    public String getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(String taxFlag) {
        this.taxFlag = taxFlag;
    }

    @Override
    public boolean equals(Object obj) {

        if(this.itemKindNo.equals( ((ItemKindDto)obj).getItemKindNo()) ){
            return true;
        }else{
            return false;
        }

    }

    public double getOrderByPremium() {
        return orderByPremium;
    }

    public void setOrderByPremium(double orderByPremium) {
        this.orderByPremium = orderByPremium;
    }


}
