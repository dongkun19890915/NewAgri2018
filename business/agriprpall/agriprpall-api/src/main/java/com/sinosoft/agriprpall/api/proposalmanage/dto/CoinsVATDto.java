package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.endorsemanage.dto.CoinsDetailDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ItemKindDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @ClassName: CoinsVATSchema
 * @Description: TODO 共保价税分离对象
TODO 包括共保保费、出单费、手续费价税分离对应的属性
 * @author 紫金财险中科软项目组
 * @date 2016-3-21 下午04:07:58
 * @version V1.0
 *
 */
public class CoinsVATDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String formula = "";//计算公式：1-公式1（默认）、2-公式2
    private String businessType = "";//业务类型包括：投保、批改
    private String vatFeeType = "";//计算价税分离的费用类型  保费、手续费、联共保出单费、分入业务、退保手续费、投资金退保手续费
    private String expenseCalType = "";//手续费价税分离保费基数类型：1-按含税保费（默认）、2-不含税保费
    private String businessNo = "";
    private String comcode = "";
    private String currency = "";
    //共保标识  1-主共保（默认）  2-从共保
    private String coinsFlag = "";
    //从共保比例
    private double coinsRate = 0d;
    //riskcode 险种代码
    private String riskcode = "";
    //总含税保费
    private double sumPremium;
    //总不含税保费
    private double sumNoTaxPremium;
    //总税额
    private double sumTaxFee;
    //免税比例
    private double dutyRatio;
    //保单险别明细
    private ArrayList<PrpTitemKindDto> itemKindList;
    //共保明细信息
    private ArrayList<PrpTcoinsDetailDto> coinsDetailList;

    /**
     * add by 王心洋 2017-11-06
     * 通用险别明细实体类
     */
    //保单险别明细
    private ArrayList<ItemKindDto> itemKindDtoList;
    //共保明细信息
    private ArrayList<CoinsDetailDto> coinsDetailDtoList;

    public ArrayList<CoinsDetailDto> getCoinsDetailDtoList() {
        return coinsDetailDtoList;
    }

    public void setCoinsDetailDtoList(ArrayList<CoinsDetailDto> coinsDetailDtoList) {
        this.coinsDetailDtoList = coinsDetailDtoList;
    }

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

    public String getExpenseCalType() {
        return expenseCalType;
    }

    public void setExpenseCalType(String expenseCalType) {
        this.expenseCalType = expenseCalType;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

    public double getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(double coinsRate) {
        this.coinsRate = coinsRate;
    }

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode;
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

    public ArrayList<PrpTitemKindDto> getItemKindList() {
        return itemKindList;
    }

    public void setItemKindList(ArrayList<PrpTitemKindDto> itemKindList) {
        this.itemKindList = itemKindList;
    }

    public ArrayList<PrpTcoinsDetailDto> getCoinsDetailList() {
        return coinsDetailList;
    }

    public void setCoinsDetailList(ArrayList<PrpTcoinsDetailDto> coinsDetailList) {
        this.coinsDetailList = coinsDetailList;
    }
}
