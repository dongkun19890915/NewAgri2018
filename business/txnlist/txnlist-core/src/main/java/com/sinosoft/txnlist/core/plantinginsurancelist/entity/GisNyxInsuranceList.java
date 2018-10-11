package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-06 02:22:27.335
 * 投保预确认农户清单表实体操作对象
 */
@Entity
@Table(name = "GisNyxInsuranceList")
@IdClass(GisNyxInsuranceListKey.class)
public class GisNyxInsuranceList extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    @Id
    @Column(name = "insureListCode")
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    @Id
    @Column(name = "serialNo")
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;


    /**
     * 属性农户姓名/农户姓名
     */
    @Column(name = "fName")
    private String fName;
    /**
     * 属性农户证件类型/农户证件类型
     */
    @Column(name = "fIdType")
    private String fIdType;
    /**
     * 属性证件号码/证件号码
     */
    @Column(name = "fIdCard")
    private String fIdCard;
    /**
     * 属性手机号码/手机号码
     */
    @Column(name = "fPhone")
    private String fPhone;
    /**
     * 属性住址/住址
     */
    @Column(name = "fAddress")
    private String fAddress;
    /**
     * 属性组别/组别
     */
    @Column(name = "teamName")
    private String teamName;
    /**
     * 属性开户银行大类/开户银行大类
     */
    @Column(name = "bankType")
    private String bankType;
    /**
     * 属性开户银行/开户银行
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */
    @Column(name = "zhiBuKa")
    private String zhiBuKa;
    /**
     * 属性银行联行号/银行联行号
     */
    @Column(name = "bankLineNo")
    private String bankLineNo;
    /**
     * 属性土地确权证号码/土地确权证号码
     */
    @Column(name = "landCard")
    private String landCard;
    /**
     * 属性农户确权面积/农户确权面积
     */
    @Column(name = "landArea")
    private Double landArea;
    /**
     * 属性农户实际总面积/农户实际总面积
     */
    @Column(name = "realArea")
    private Double realArea;
    /**
     * 属性投保总面积/投标总数量/投保总面积/投标总数量
     */
    @Column(name = "insureArea")
    private Double insureArea;
    /**
     * 属性实际投保总面积/实际投保总面积
     */
    @Column(name = "tInsureArea")
    private Double tInsureArea;
    /**
     * 属性剔除面积/剔除面积
     */
    @Column(name = "delArea")
    private Double delArea;
    /**
     * 属性整体调整原因/整体调整原因
     */
    @Column(name = "adjustReason")
    private String adjustReason;
    /**
     * 属性备注/备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 属性备用字段1/备用字段1
     */
    @Column(name = "remark1")
    private String remark1;
    /**
     * 属性备用字段2/备用字段2
     */
    @Column(name = "remark2")
    private String remark2;
    /**
     * 属性备用字段3/备用字段3
     */
    @Column(name = "remark3")
    private String remark3;
    /**
     * 属性备用字段4/备用字段4
     */
    @Column(name = "remark4")
    private String remark4;

    /**
     * 属性清单编号/清单编号的getter方法
     */
    public String getInsureListCode() {
        return insureListCode;
    }

    /**
     * 属性清单编号/清单编号的setter方法
     */
    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    /**
     * 属性序列号/序列号的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }

    /**
     * 属性序列号/序列号的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 属性农户代码/农户代码的getter方法
     */
    public String getFCode() {
        return fCode;
    }

    /**
     * 属性农户代码/农户代码的setter方法
     */
    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    /**
     * 属性农户姓名/农户姓名的getter方法
     */
    public String getFName() {
        return fName;
    }

    /**
     * 属性农户姓名/农户姓名的setter方法
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * 属性手机号码/手机号码的getter方法
     */
    public String getFPhone() {
        return fPhone;
    }

    /**
     * 属性手机号码/手机号码的setter方法
     */
    public void setFPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    /**
     * 属性住址/住址的getter方法
     */
    public String getFAddress() {
        return fAddress;
    }

    /**
     * 属性住址/住址的setter方法
     */
    public void setFAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    /**
     * 属性组别/组别的getter方法
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 属性组别/组别的setter方法
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 属性开户银行大类/开户银行大类的getter方法
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 属性开户银行大类/开户银行大类的setter方法
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * 属性开户银行/开户银行的getter方法
     */
    public String getBank() {
        return bank;
    }

    /**
     * 属性开户银行/开户银行的setter方法
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号的getter方法
     */
    public String getZhiBuKa() {
        return zhiBuKa;
    }

    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号的setter方法
     */
    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }

    /**
     * 属性银行联行号/银行联行号的getter方法
     */
    public String getBankLineNo() {
        return bankLineNo;
    }

    /**
     * 属性银行联行号/银行联行号的setter方法
     */
    public void setBankLineNo(String bankLineNo) {
        this.bankLineNo = bankLineNo;
    }

    /**
     * 属性土地确权证号码/土地确权证号码的getter方法
     */
    public String getLandCard() {
        return landCard;
    }

    /**
     * 属性土地确权证号码/土地确权证号码的setter方法
     */
    public void setLandCard(String landCard) {
        this.landCard = landCard;
    }

    /**
     * 属性农户确权面积/农户确权面积的getter方法
     */
    public Double getLandArea() {
        return landArea;
    }

    /**
     * 属性农户确权面积/农户确权面积的setter方法
     */
    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    /**
     * 属性农户实际总面积/农户实际总面积的getter方法
     */
    public Double getRealArea() {
        return realArea;
    }

    /**
     * 属性农户实际总面积/农户实际总面积的setter方法
     */
    public void setRealArea(Double realArea) {
        this.realArea = realArea;
    }

    /**
     * 属性投保总面积/投标总数量/投保总面积/投标总数量的getter方法
     */
    public Double getInsureArea() {
        return insureArea;
    }

    /**
     * 属性投保总面积/投标总数量/投保总面积/投标总数量的setter方法
     */
    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
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

    public Double gettInsureArea() {
        return tInsureArea;
    }

    public void settInsureArea(Double tInsureArea) {
        this.tInsureArea = tInsureArea;
    }

    /**
     * 属性剔除面积/剔除面积的getter方法
     */
    public Double getDelArea() {
        return delArea;
    }

    /**
     * 属性剔除面积/剔除面积的setter方法
     */
    public void setDelArea(Double delArea) {
        this.delArea = delArea;
    }

    /**
     * 属性整体调整原因/整体调整原因的getter方法
     */
    public String getAdjustReason() {
        return adjustReason;
    }

    /**
     * 属性整体调整原因/整体调整原因的setter方法
     */
    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    /**
     * 属性备注/备注的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性备注/备注的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性备用字段1/备用字段1的getter方法
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 属性备用字段1/备用字段1的setter方法
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 属性备用字段2/备用字段2的getter方法
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 属性备用字段2/备用字段2的setter方法
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * 属性备用字段3/备用字段3的getter方法
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 属性备用字段3/备用字段3的setter方法
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    /**
     * 属性备用字段4/备用字段4的getter方法
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 属性备用字段4/备用字段4的setter方法
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
}