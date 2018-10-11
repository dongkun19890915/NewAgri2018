package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

public class NyxInsuranceInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /*种植面积*/
    private Double insureArea;
    /** 属性农民自缴保费/农民自缴保费 */
    private Double fPremium;
    /** 属性中央财政补贴/中央财政补贴 */
    private Double centralPremium;
    /** 属性省级财政补贴/省级财政补贴 */
    private Double provincePremium;
    /** 属性地市财政补贴/地市财政补贴 */
    private Double cityPremium;
    /** 属性县(区)财政补贴/县(区)财政补贴 */
    private Double townPremium;
    /** 属性其他来源补贴/其他来源补贴 */
    private Double otherPremium;
    /** 总的承保数量，防止农户投保多个标的*/
    private long conut;
    /**每个标的农户户次 */
    private long iSumInsured;
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public NyxInsuranceInfoDto() {
    }
    public NyxInsuranceInfoDto(Double fPremium, Double centralPremium, Double provincePremium, Double cityPremium, Double townPremium, Double otherPremium, Double insureArea, Long iSumInsured) {
        this.fPremium = fPremium;
        this.centralPremium = centralPremium;
        this.provincePremium = provincePremium;
        this.cityPremium = cityPremium;
        this.townPremium = townPremium;
        this.otherPremium = otherPremium;
        this.insureArea = insureArea;
        this.iSumInsured = iSumInsured;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public Double getfPremium() {
        return fPremium;
    }

    public void setfPremium(Double fPremium) {
        this.fPremium = fPremium;
    }

    public Double getCentralPremium() {
        return centralPremium;
    }

    public void setCentralPremium(Double centralPremium) {
        this.centralPremium = centralPremium;
    }

    public Double getProvincePremium() {
        return provincePremium;
    }

    public void setProvincePremium(Double provincePremium) {
        this.provincePremium = provincePremium;
    }

    public Double getCityPremium() {
        return cityPremium;
    }

    public void setCityPremium(Double cityPremium) {
        this.cityPremium = cityPremium;
    }

    public Double getTownPremium() {
        return townPremium;
    }

    public void setTownPremium(Double townPremium) {
        this.townPremium = townPremium;
    }

    public Double getOtherPremium() {
        return otherPremium;
    }

    public void setOtherPremium(Double otherPremium) {
        this.otherPremium = otherPremium;
    }

    public long getConut() {        return conut;    }

    public void setConut(long conut) {        this.conut = conut;    }

    public long getiSumInsured() {
        return iSumInsured;
    }

    public void setiSumInsured(long iSumInsured) {
        this.iSumInsured = iSumInsured;
    }

}
