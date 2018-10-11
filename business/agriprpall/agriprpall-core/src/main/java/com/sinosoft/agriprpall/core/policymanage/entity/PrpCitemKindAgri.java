package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindAgri;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time 2017-10-22 07:54:48.524
 * 农险保单标的子险信息表实体操作对象
 */
@Entity
@Table(name = "PrpCitemKindAgri")
@IdClass(PrpCitemKindAgriKey.class)
public class PrpCitemKindAgri extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性保单号/保单号
     */
    @Id
    @Column(name = "policyNo")
    private String policyNo;
    /**
     * 属性标的序号/标的序号
     */
    @Id
    @Column(name = "itemKindNo")
    private Integer itemKindNo;
    /**
     * 属性险别/险别
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性茬次/茬次
     */
    @Id
    @Column(name = "times")
    private Integer times;

    /**
     * 属性险种/险种
     */
    @Column(name = "riskCode")
    private String riskCode;


    /**
     * 属性单位产量/密度/单位产量/密度
     */
    @Column(name = "unitOutput")
    private Double unitOutput;
    /**
     * 属性约定单价/约定单价
     */
    @Column(name = "unitCost")
    private Double unitCost;
    /**
     * 属性折扣/投保成数/折扣/投保成数
     */
    @Column(name = "proportion")
    private Double proportion;
    /**
     * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)
     */
    @Column(name = "depreciationRate")
    private Double depreciationRate;
    /**
     * 属性单位保险金额/单位保险金额
     */
    @Column(name = "unitAmount")
    private Double unitAmount;
    /**
     * 属性种养总量/种养总量
     */
    @Column(name = "grossQuantity")
    private Double grossQuantity;
    /**
     * 属性比例类型/比例类型
     */
    @Column(name = "discountType")
    private String discountType;
    /**
     * 属性flag/flag
     */
    @Column(name = "flag")
    private String flag;
    /**
     * 属性借用存储张种规格/借用存储张种规格
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 属性当前茬次起始日期/当前茬次起始日期
     */
    @Column(name = "stratDate")
    private Date stratDate;
    /**
     * 属性当前茬次终止日期/当前茬次终止日期
     */
    @Column(name = "endDate")
    private Date endDate;
    /**
     * 属性保险金额分布比例/保险金额分布比例
     */
    @Column(name = "distributingRate")
    private Double distributingRate;
    /**
     * 属性投保面积/投保面积
     */
    @Column(name = "insureArea")
    private Double insureArea;
    /**
     * 属性茬次保额/茬次保额
     */
    @Column(name = "timesAmount")
    private Double timesAmount;

    /**
     * 属性保单号/保单号的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 属性保单号/保单号的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 属性险种/险种的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }

    /**
     * 属性险种/险种的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    /**
     * 属性标的序号/标的序号的getter方法
     */
    public Integer getItemKindNo() {
        return itemKindNo;
    }

    /**
     * 属性标的序号/标的序号的setter方法
     */
    public void setItemKindNo(Integer itemKindNo) {
        this.itemKindNo = itemKindNo;
    }

    /**
     * 属性险别/险别的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别/险别的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public Double getUnitOutput() {
        return unitOutput;
    }

    public void setUnitOutput(Double unitOutput) {
        this.unitOutput = unitOutput;
    }

    /**
     * 属性约定单价/约定单价的getter方法
     */
    public Double getUnitCost() {
        return unitCost;
    }

    /**
     * 属性约定单价/约定单价的setter方法
     */
    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * 属性折扣/投保成数/折扣/投保成数的getter方法
     */
    public Double getProportion() {
        return proportion;
    }

    /**
     * 属性折扣/投保成数/折扣/投保成数的setter方法
     */
    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    /**
     * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的getter方法
     */
    public Double getDepreciationRate() {
        return depreciationRate;
    }

    /**
     * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的setter方法
     */
    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    /**
     * 属性单位保险金额/单位保险金额的getter方法
     */
    public Double getUnitAmount() {
        return unitAmount;
    }

    /**
     * 属性单位保险金额/单位保险金额的setter方法
     */
    public void setUnitAmount(Double unitAmount) {
        this.unitAmount = unitAmount;
    }

    /**
     * 属性种养总量/种养总量的getter方法
     */
    public Double getGrossQuantity() {
        return grossQuantity;
    }

    /**
     * 属性种养总量/种养总量的setter方法
     */
    public void setGrossQuantity(Double grossQuantity) {
        this.grossQuantity = grossQuantity;
    }

    /**
     * 属性比例类型/比例类型的getter方法
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * 属性比例类型/比例类型的setter方法
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * 属性flag/flag的getter方法
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 属性flag/flag的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 属性借用存储张种规格/借用存储张种规格的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性借用存储张种规格/借用存储张种规格的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性茬次/茬次的getter方法
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 属性茬次/茬次的setter方法
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * 属性当前茬次起始日期/当前茬次起始日期的getter方法
     */
    public Date getStratDate() {
        return stratDate;
    }

    /**
     * 属性当前茬次起始日期/当前茬次起始日期的setter方法
     */
    public void setStratDate(Date stratDate) {
        this.stratDate = stratDate;
    }

    /**
     * 属性当前茬次终止日期/当前茬次终止日期的getter方法
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 属性当前茬次终止日期/当前茬次终止日期的setter方法
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 属性保险金额分布比例/保险金额分布比例的getter方法
     */
    public Double getDistributingRate() {
        return distributingRate;
    }

    /**
     * 属性保险金额分布比例/保险金额分布比例的setter方法
     */
    public void setDistributingRate(Double distributingRate) {
        this.distributingRate = distributingRate;
    }

    /**
     * 属性投保面积/投保面积的getter方法
     */
    public Double getInsureArea() {
        return insureArea;
    }

    /**
     * 属性投保面积/投保面积的setter方法
     */
    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    /**
     * 属性茬次保额/茬次保额的getter方法
     */
    public Double getTimesAmount() {
        return timesAmount;
    }

    /**
     * 属性茬次保额/茬次保额的setter方法
     */
    public void setTimesAmount(Double timesAmount) {
        this.timesAmount = timesAmount;
    }
    /**
     * PrpTitemKindAgriToPrpCitemKindAgri
     */
    public void setPrpTitemKindAgriToPrpCitemKindAgri(PrpTitemKindAgri prpTitemKindAgri){
        this.riskCode =prpTitemKindAgri.getRiskCode();
        this.itemKindNo =prpTitemKindAgri.getItemKindNo();
        this.kindCode =prpTitemKindAgri.getKindCode();
        this.unitOutput =prpTitemKindAgri.getUnitOutput();
        this.unitCost =prpTitemKindAgri.getUnitCost();
        this.proportion =prpTitemKindAgri.getProportion();
        this.depreciationRate =prpTitemKindAgri.getDepreciationRate();
        this.unitAmount =prpTitemKindAgri.getUnitAmount();
        this.grossQuantity =prpTitemKindAgri.getGrossQuantity();
        this.discountType =prpTitemKindAgri.getDiscountType();
        this.flag =prpTitemKindAgri.getFlag();
        this.remark =prpTitemKindAgri.getRemark();
        this.times =prpTitemKindAgri.getTimes();
        this.stratDate =prpTitemKindAgri.getStratDate();
        this.endDate =prpTitemKindAgri.getEndDate();
        this.distributingRate =prpTitemKindAgri.getDistributingRate();
        this.insureArea =prpTitemKindAgri.getInsureArea();
        this.timesAmount =prpTitemKindAgri.getTimesAmount();
    }
}