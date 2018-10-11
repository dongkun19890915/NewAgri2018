package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:承保明细返回Dto
 * @Author: 潘峰
 * @Date: 2017/10/20 11:03
 */
public class ItemKingAgriDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*投保面积 */
    private Double insureArea;
    /*单位约定产量 */
    private String unitOutPut;
    /*约定价格 */
    private String unitCost;
    /*单位保险金额 */
    private String unitAmount;
    /*保险金额 */
    private String amount;
    /*费率 */
    private String rate;
    /*保险费 */
    private String adjuStrate;
    /*保险项目名称 */
    private String itemDetailName;
    /*附加险保费 */
    private Double premium;
    /*主险保费 */
    private Double premium1;
    /*单位 */
    private String unit;
    /*每次事故免赔率 */
    private String deductibleRate;
    /*保险数量 */
    private String grossQuantity;
    private String timesAmount;
    //投保成数
    private String proportion;

    public String getTimesAmount() {
        return timesAmount;
    }

    public void setTimesAmount(String timesAmount) {
        this.timesAmount = timesAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDeductibleRate() {
        return deductibleRate;
    }

    public void setDeductibleRate(String deductibleRate) {
        this.deductibleRate = deductibleRate;
    }

    public String getGrossQuantity() {
        return grossQuantity;
    }

    public void setGrossQuantity(String grossQuantity) {
        this.grossQuantity = grossQuantity;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public String getUnitOutPut() {
        return unitOutPut;
    }

    public void setUnitOutPut(String unitOutPut) {
        this.unitOutPut = unitOutPut;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(String unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAdjuStrate() {
        return adjuStrate;
    }

    public void setAdjuStrate(String adjuStrate) {
        this.adjuStrate = adjuStrate;
    }

    public String getItemDetailName() {
        return itemDetailName;
    }

    public void setItemDetailName(String itemDetailName) {
        this.itemDetailName = itemDetailName;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Double getPremium1() {
        return premium1;
    }

    public void setPremium1(Double premium1) {
        this.premium1 = premium1;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }
}
