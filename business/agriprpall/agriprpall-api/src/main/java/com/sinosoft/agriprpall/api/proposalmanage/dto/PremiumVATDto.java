package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.endorsemanage.dto.ItemKindDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @ClassName: PremiumVATSchema
 * @Description: TODO 保费价税分离计算使用的schema TODO
 *  包括以下属性： businessType 业务类型 businessNo,计算价税分离的费用类型 vatFeeType
 *               业务单号 comcode 机构代码 currency 币别 itemkindlist
 *               险别列表，出参时会更新,作为入参时，险别列表允许null，如果为null，则价税分离只明细到险种。 //planlist
 *               缴费计划列表，出参时会更新 sumNoTaxPremium 总不含税保费，出参时返回 sumTaxFee 总税额，出参时返回
 *               dutyRatio 免税比例，出参时返回
 * @author 紫金财险中科软项目组
 * @date 2016-3-21 上午11:40:16
 * @version V1.0
 *
 */
public class PremiumVATDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String formula = "";//税额计算公式：1-公式1（默认）、2-公式2
    private String businessType = "";//业务类型包括：投保、批改
    private String vatFeeType = "";//计算价税分离的费用类型  保费、手续费、联共保出单费、分入业务、退保手续费、投资金退保手续费
    private String businessNo = "";
    private String comcode = "";
    private String riskCode = "";
    private String currency = "";
    //总含税保费
    private double sumPremium;
    //总不含税保费
    private double sumNoTaxPremium;
    private double sumTaxFee;
    //dutyRatio 免税比例
    private double dutyRatio;
    //transferTax 转出税额
    private double transferTax;
    private ArrayList<PrpTitemKindDto> itemKindList;
    /**
     * add by 王心洋 2017-11-06
     * 批单价税分离传入参数*/
    private ArrayList<ItemKindDto> itemKindDtoList;

    public ArrayList<ItemKindDto> getItemKindDtoList() {
        return itemKindDtoList;
    }

    public void setItemKindDtoList(ArrayList<ItemKindDto> itemKindDtoList) {
        this.itemKindDtoList = itemKindDtoList;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getVatFeeType() {
        return vatFeeType;
    }

    public void setVatFeeType(String vatFeeType) {
        this.vatFeeType = vatFeeType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public double getSumNoTaxPremium() {
        return sumNoTaxPremium;
    }

    public void setSumNoTaxPremium(double sumNoTaxPremium) {
        this.sumNoTaxPremium = sumNoTaxPremium;
    }

    public double getSumTaxFee() {
        return sumTaxFee;
    }

    public void setSumTaxFee(double sumTaxFee) {
        this.sumTaxFee = sumTaxFee;
    }

    public double getDutyRatio() {
        return dutyRatio;
    }

    public void setDutyRatio(double dutyRatio) {
        this.dutyRatio = dutyRatio;
    }

    public double getTransferTax() {
        return transferTax;
    }

    public void setTransferTax(double transferTax) {
        this.transferTax = transferTax;
    }

    public ArrayList<PrpTitemKindDto> getItemKindList() {
        return itemKindList;
    }

    public void setItemKindList(ArrayList<PrpTitemKindDto> itemKindList) {
        this.itemKindList = itemKindList;
    }
}
