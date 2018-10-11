package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*** @Description:保费计算Dto
* @Author: 田健
* @Date: 2017/10/16 11:48
*/
public class CalPremiumDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 清单号*/
    private  String inusrelistcode;

    /**金禾的清单号*/
    private String gisInusrelistcode;

    /** 起保日期*/
    private  Date startDate;

    /** 终保日期*/
    private  Date endDate;

    /** 险别序号*/
    private List<String> kindCodeList;

    /** 单位保额*/
    private  List<String> agriUnitAmountMainList;

    /** 费率*/
    private  List<String> rateList;

    /** 短期费率方式*/
    private  List<String> shortRateFlagList;

    /** 短期费率*/
    private  List<String> shortRateList;

    /** 自缴份额比例*/
    private  String fplanRate;

    /** 中央财政补贴比例*/
    private  String centralRate;

    /** 省级财政补贴比例*/
    private  String provinceRate;

    /** 地市财政补贴比例*/
    private  String cityRate;

    /** 县(区)财政补贴比例*/
    private  String townRate;

    /**其他来源补贴比例*/
    private  String otherRate;

    /**标识*/
    private  String flag;

    /**主险标志*/
    private List<String> calculateFlagList;

    /**险种代码*/
    private String riskCode;

    /** 投保单号，养殖险用来删除关联清单信息*/
    private String proposalNo;

    /**标的*/
    private List<String> itemCodeList;
    /** 金禾的清单序列号*/
    private String serialNo;
    /** 标的清单编号*/
    private List<String> itemListCodes;
    /** 养殖方式*/
    private String policyType;
    /**保存请求次数*/
    private String times;

    public String getInusrelistcode() {
        return inusrelistcode;
    }

    public void setInusrelistcode(String inusrelistcode) {
        this.inusrelistcode = inusrelistcode;
    }

    public Date getStartDate() {        return startDate;    }

    public void setStartDate(Date startDate) {        this.startDate = startDate;    }

    public Date getEndDate() {        return endDate;    }

    public void setEndDate(Date endDate) {        this.endDate = endDate;    }

    public List<String> getKindCodeList() {
        return kindCodeList;
    }

    public void setKindCodeList(List<String> kindCodeList) {
        this.kindCodeList = kindCodeList;
    }

    public List<String> getAgriUnitAmountMainList() {
        return agriUnitAmountMainList;
    }

    public void setAgriUnitAmountMainList(List<String> agriUnitAmountMainList) {
        this.agriUnitAmountMainList = agriUnitAmountMainList;
    }

    public List<String> getRateList() {
        return rateList;
    }

    public void setRateList(List<String> rateList) {
        this.rateList = rateList;
    }

    public List<String> getShortRateFlagList() {
        return shortRateFlagList;
    }

    public void setShortRateFlagList(List<String> shortRateFlagList) {
        this.shortRateFlagList = shortRateFlagList;
    }

    public List<String> getShortRateList() {
        return shortRateList;
    }

    public void setShortRateList(List<String> shortRateList) {
        this.shortRateList = shortRateList;
    }

    public String getFplanRate() {
        return fplanRate;
    }

    public void setFplanRate(String fplanRate) {
        this.fplanRate = fplanRate;
    }

    public String getCentralRate() {
        return centralRate;
    }

    public void setCentralRate(String centralRate) {
        this.centralRate = centralRate;
    }

    public String getProvinceRate() {
        return provinceRate;
    }

    public void setProvinceRate(String provinceRate) {
        this.provinceRate = provinceRate;
    }

    public String getCityRate() {
        return cityRate;
    }

    public void setCityRate(String cityRate) {
        this.cityRate = cityRate;
    }

    public String getTownRate() {
        return townRate;
    }

    public void setTownRate(String townRate) {
        this.townRate = townRate;
    }

    public String getOtherRate() {
        return otherRate;
    }

    public void setOtherRate(String otherRate) {
        this.otherRate = otherRate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<String> getCalculateFlagList() {        return calculateFlagList;    }

    public void setCalculateFlagList(List<String> calculateFlagList) {        this.calculateFlagList = calculateFlagList;    }

    public String getRiskCode() {        return riskCode;    }

    public void setRiskCode(String riskCode) {        this.riskCode = riskCode;    }

    public String getGisInusrelistcode() {        return gisInusrelistcode;    }

    public void setGisInusrelistcode(String gisInusrelistcode) {        this.gisInusrelistcode = gisInusrelistcode;    }

    public String getProposalNo() {        return proposalNo;    }

    public void setProposalNo(String proposalNo) {        this.proposalNo = proposalNo;    }

    public List<String> getItemCodeList() {        return itemCodeList;    }

    public void setItemCodeList(List<String> itemCodeList) {        this.itemCodeList = itemCodeList;    }

    public String getSerialNo() {        return serialNo;    }

    public void setSerialNo(String serialNo) {        this.serialNo = serialNo;    }

    public List<String> getItemListCodes() {        return itemListCodes;    }

    public void setItemListCodes(List<String> itemListCodes) {        this.itemListCodes = itemListCodes;    }

    public String getPolicyType() {        return policyType;    }

    public void setPolicyType(String policyType) {        this.policyType = policyType;    }

    public String getTimes() {        return times;    }

    public void setTimes(String times) {        this.times = times;    }
}
