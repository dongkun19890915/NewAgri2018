package com.sinosoft.agriprpall.api.proposalmanage.dto;
/**
* @Description:承保明细返回Dto
* @Author: 陈道洋
* @Date: 2017/10/20 11:03
*/
public class ItemKingAgriSubDto {
    /*投保面积 */
    private Double subinsureArea;
    /*单位约定产量 */
    private String subunitOutPut;
    /*单位成本 */
    private String subunitCost;
    /*单位保险金额 */
    private String subunitAmount;
    /*保险金额 */
    private String subamount;
    /*费率 */
    private String subrate;
    /*保险费 */
    private String subadjuStrate  ;
    /*保险项目名称 */
    private String subitemDetailName;
    /*附加险保费 */
    private String subpremium;
    /*主险保费 */
    private Double subpremium1;
    /*单位 */
    private String subunit;
    /*每次事故免赔率 */
    private String subdeductibleRate;
    /*保险数量 */
    private String subgrossQuantity;
    /*约定单价 */
    private String subtimesAmount;

    public Double getSubinsureArea() {
        return subinsureArea;
    }

    public void setSubinsureArea(Double subinsureArea) {
        this.subinsureArea = subinsureArea;
    }

    public String getSubunitOutPut() {
        return subunitOutPut;
    }

    public void setSubunitOutPut(String subunitOutPut) {
        this.subunitOutPut = subunitOutPut;
    }

    public String getSubunitCost() {
        return subunitCost;
    }

    public void setSubunitCost(String subunitCost) {
        this.subunitCost = subunitCost;
    }

    public String getSubunitAmount() {
        return subunitAmount;
    }

    public void setSubunitAmount(String subunitAmount) {
        this.subunitAmount = subunitAmount;
    }

    public String getSubamount() {
        return subamount;
    }

    public void setSubamount(String subamount) {
        this.subamount = subamount;
    }

    public String getSubrate() {
        return subrate;
    }

    public void setSubrate(String subrate) {
        this.subrate = subrate;
    }

    public String getSubadjuStrate() {
        return subadjuStrate;
    }

    public void setSubadjuStrate(String subadjuStrate) {
        this.subadjuStrate = subadjuStrate;
    }

    public String getSubitemDetailName() {
        return subitemDetailName;
    }

    public void setSubitemDetailName(String subitemDetailName) {
        this.subitemDetailName = subitemDetailName;
    }

    public String getSubpremium() {
        return subpremium;
    }

    public void setSubpremium(String subpremium) {
        this.subpremium = subpremium;
    }

    public Double getSubpremium1() {
        return subpremium1;
    }

    public void setSubpremium1(Double subpremium1) {
        this.subpremium1 = subpremium1;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }

    public String getSubdeductibleRate() {
        return subdeductibleRate;
    }

    public void setSubdeductibleRate(String subdeductibleRate) {
        this.subdeductibleRate = subdeductibleRate;
    }

    public String getSubgrossQuantity() {
        return subgrossQuantity;
    }

    public void setSubgrossQuantity(String subgrossQuantity) {
        this.subgrossQuantity = subgrossQuantity;
    }

    public String getSubtimesAmount() {
        return subtimesAmount;
    }

    public void setSubtimesAmount(String subtimesAmount) {
        this.subtimesAmount = subtimesAmount;
    }
}
