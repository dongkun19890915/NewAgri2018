package com.sinosoft.pms.core.productrule.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time 2016-09-18 20:27:00.111
 * UtiFormula   基础数据对象
 */
@Entity
@Table(name = "utiformula")
@IdClass(UtiFormulaKey.class)
public class UtiFormula implements BaseEntity,Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 属性RiskCode/
     */
    @Id
    @Column(name = "riskCode")
    private String riskCode;
    /**
     * 属性ClauseCode/
     */
    @Id
    @Column(name = "clauseCode")
    private String clauseCode;
    /**
     * 属性KindCode/
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性ComCode/
     */
    @Id
    @Column(name = "comCode")
    private String comCode;
    /**
     * 属性CalFormulaType/
     */
    @Id
    @Column(name = "calFormulaType")
    private String calFormulaType;
    /**
     * 属性FormulaType/
     */
    @Id
    @Column(name = "formulaType")
    private String formulaType;
    /**
     * 属性FactorCode/
     */
    @Id
    @Column(name = "factorCode")
    private String factorCode;


    /**
     * 属性Source/
     */
    private String source;
    /**
     * 属性FormulaName/
     */
    private String formulaName;
    /**
     * 属性Content/
     */
    private String content;
    /**
     * 属性Accuracy/
     */
    private Double accuracy;
    /**
     * 属性CreatorCode/
     */
    private String creatorCode;
    /**
     * 属性UpdaterCode/
     */
    private String updaterCode;
    /**
     * 属性ValidDate/
     */
    private java.util.Date validDate;
    /**
     * 属性InvalidDate/
     */
    private java.util.Date invalidDate;
    /**
     * 属性ValidStatus/
     */
    private String validStatus;
    /**
     * 属性Flag/
     */
    private String flag;
    /**
     * 属性Remark/
     */
    private String remark;
    /**
     * 属性InsertTimeForHis/
     */
    private java.util.Date insertTimeForHis;
    /**
     * 属性OperateTimeForHis/
     */
    private java.util.Date operateTimeForHis;

    /**
     * 类UtiFormula的默认构造方法
     */
    public UtiFormula() {
    }


    /**
     * 属性Source/的getter方法
     */
    public String getSource() {
        return source;
    }

    /**
     * 属性Source/的setter方法
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 属性FormulaName/的getter方法
     */
    public String getFormulaName() {
        return formulaName;
    }

    /**
     * 属性FormulaName/的setter方法
     */
    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }

    /**
     * 属性Content/的getter方法
     */
    public String getContent() {
        return content;
    }

    /**
     * 属性Content/的setter方法
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 属性Accuracy/的getter方法
     */
    public Double getAccuracy() {
        return accuracy;
    }

    /**
     * 属性Accuracy/的setter方法
     */
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * 属性CreatorCode/的getter方法
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 属性CreatorCode/的setter方法
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * 属性UpdaterCode/的getter方法
     */
    public String getUpdaterCode() {
        return updaterCode;
    }

    /**
     * 属性UpdaterCode/的setter方法
     */
    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }

    /**
     * 属性ValidDate/的getter方法
     */
    public java.util.Date getValidDate() {
        return validDate;
    }

    /**
     * 属性ValidDate/的setter方法
     */
    public void setValidDate(java.util.Date validDate) {
        this.validDate = validDate;
    }

    /**
     * 属性InvalidDate/的getter方法
     */
    public java.util.Date getInvalidDate() {
        return invalidDate;
    }

    /**
     * 属性InvalidDate/的setter方法
     */
    public void setInvalidDate(java.util.Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    /**
     * 属性ValidStatus/的getter方法
     */
    public String getValidStatus() {
        return validStatus;
    }

    /**
     * 属性ValidStatus/的setter方法
     */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    /**
     * 属性Flag/的getter方法
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 属性Flag/的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 属性Remark/的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性Remark/的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性InsertTimeForHis/的getter方法
     */
    public java.util.Date getInsertTimeForHis() {
        return insertTimeForHis;
    }

    /**
     * 属性InsertTimeForHis/的setter方法
     */
    public void setInsertTimeForHis(java.util.Date insertTimeForHis) {
        this.insertTimeForHis = insertTimeForHis;
    }

    /**
     * 属性OperateTimeForHis/的getter方法
     */
    public java.util.Date getOperateTimeForHis() {
        return operateTimeForHis;
    }

    /**
     * 属性OperateTimeForHis/的setter方法
     */
    public void setOperateTimeForHis(java.util.Date operateTimeForHis) {
        this.operateTimeForHis = operateTimeForHis;
    }

    /*
    * 属性riskCode的getter方法
    */
    public String getRiskCode() {
        return riskCode;
    }

    /*
    * 属性riskCode的setter方法
    */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    /*
    * 属性clauseCode的getter方法
    */
    public String getClauseCode() {
        return clauseCode;
    }

    /*
    * 属性clauseCode的setter方法
    */
    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    /*
    * 属性kindCode的getter方法
    */
    public String getKindCode() {
        return kindCode;
    }

    /*
    * 属性kindCode的setter方法
    */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    /*
    * 属性comCode的getter方法
    */
    public String getComCode() {
        return comCode;
    }

    /*
    * 属性comCode的setter方法
    */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    /*
    * 属性calFormulaType的getter方法
    */
    public String getCalFormulaType() {
        return calFormulaType;
    }

    /*
    * 属性calFormulaType的setter方法
    */
    public void setCalFormulaType(String calFormulaType) {
        this.calFormulaType = calFormulaType;
    }

    /*
    * 属性formulaType的getter方法
    */
    public String getFormulaType() {
        return formulaType;
    }

    /*
    * 属性formulaType的setter方法
    */
    public void setFormulaType(String formulaType) {
        this.formulaType = formulaType;
    }

    /*
    * 属性factorCode的getter方法
    */
    public String getFactorCode() {
        return factorCode;
    }

    /*
    * 属性factorCode的setter方法
    */
    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }
}