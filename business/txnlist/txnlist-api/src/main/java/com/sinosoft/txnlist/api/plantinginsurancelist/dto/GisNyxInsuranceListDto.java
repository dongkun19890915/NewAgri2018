package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-06 02:22:27.335
 * 投保预确认农户清单表Api操作对象
 */
public class GisNyxInsuranceListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性农户姓名/农户姓名
     */
    private String fName;
    /**
     * 属性农户证件类型/农户证件类型
     */
    private String fIdType;
    /**
     * 属性证件号码/证件号码
     */
    private String fIdCard;
    /**
     * 属性手机号码/手机号码
     */
    private String fPhone;
    /**
     * 属性住址/住址
     */
    private String fAddress;
    /**
     * 属性组别/组别
     */
    private String teamName;
    /**
     * 属性开户银行大类/开户银行大类
     */
    private String bankType;
    /**
     * 属性开户银行/开户银行
     */
    private String bank;
    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */
    private String zhiBuKa;
    /**
     * 属性银行联行号/银行联行号
     */
    private String bankLineNo;
    /**
     * 属性土地确权证号码/土地确权证号码
     */
    private String landCard;
    /**
     * 属性农户确权面积/农户确权面积
     */
    private Double landArea;
    /**
     * 属性农户实际总面积/农户实际总面积
     */
    private Double realArea;
    /**
     * 属性投保总面积/投标总数量/投保总面积/投标总数量
     */
    private Double insureArea;
    /**
     * 属性实际投保总面积/实际投保总面积
     */
    private Double tInsureArea;
    /**
     * 属性剔除面积/剔除面积
     */
    private Double delArea;
    /**
     * 属性整体调整原因/整体调整原因
     */
    private String adjustReason;
    /**
     * 属性备注/备注
     */
    private String remark;
    /**
     * 属性备用字段1/备用字段1
     */
    private String remark1;
    /**
     * 属性备用字段2/备用字段2
     */
    private String remark2;
    /**
     * 属性备用字段3/备用字段3
     */
    private String remark3;
    /**
     * 属性备用字段4/备用字段4
     */
    private String remark4;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfIdType() {
        return fIdType;
    }

    public void setfIdType(String fIdType) {
        this.fIdType = fIdType;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getZhiBuKa() {
        return zhiBuKa;
    }

    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }

    public String getBankLineNo() {
        return bankLineNo;
    }

    public void setBankLineNo(String bankLineNo) {
        this.bankLineNo = bankLineNo;
    }

    public String getLandCard() {
        return landCard;
    }

    public void setLandCard(String landCard) {
        this.landCard = landCard;
    }

    public Double getLandArea() {
        return landArea;
    }

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    public Double getRealArea() {
        return realArea;
    }

    public void setRealArea(Double realArea) {
        this.realArea = realArea;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public Double gettInsureArea() {
        return tInsureArea;
    }

    public void settInsureArea(Double tInsureArea) {
        this.tInsureArea = tInsureArea;
    }

    public Double getDelArea() {
        return delArea;
    }

    public void setDelArea(Double delArea) {
        this.delArea = delArea;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
}
