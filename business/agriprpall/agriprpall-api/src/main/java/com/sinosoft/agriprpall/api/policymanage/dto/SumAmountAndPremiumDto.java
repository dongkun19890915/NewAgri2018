package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 查询签单总保额、总保费，未交费保单总保额、总保费，应收保费总保额、总保费
 * @Author: 刘曼曼
 * @Date: 2017/11/13 10:53
 */

public class SumAmountAndPremiumDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*签单总保额*/
    private Double sumAmount;
    /*签单总保费*/
    private Double sumPremium;
    /*应收保额总保额*/
    private  Double UnpaidSumAmount;
    /*应收保额总保费*/
    private Double UnpaidSumPremium;
    /*未缴费保单总保额*/
    private Double delinQuentFeeSumAmount;
    /*未缴费保单总保费*/
    private Double delinQuentFeeSumPremium;

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public Double getUnpaidSumAmount() {
        return UnpaidSumAmount;
    }

    public void setUnpaidSumAmount(Double unpaidSumAmount) {
        UnpaidSumAmount = unpaidSumAmount;
    }

    public Double getUnpaidSumPremium() {
        return UnpaidSumPremium;
    }

    public void setUnpaidSumPremium(Double unpaidSumPremium) {
        UnpaidSumPremium = unpaidSumPremium;
    }

    public Double getDelinQuentFeeSumAmount() {
        return delinQuentFeeSumAmount;
    }

    public void setDelinQuentFeeSumAmount(Double delinQuentFeeSumAmount) {
        this.delinQuentFeeSumAmount = delinQuentFeeSumAmount;
    }

    public Double getDelinQuentFeeSumPremium() {
        return delinQuentFeeSumPremium;
    }

    public void setDelinQuentFeeSumPremium(Double delinQuentFeeSumPremium) {
        this.delinQuentFeeSumPremium = delinQuentFeeSumPremium;
    }
}