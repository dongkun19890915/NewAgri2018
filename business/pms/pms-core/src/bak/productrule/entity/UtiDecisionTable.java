package com.sinosoft.pms.core.productrule.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time 2016-09-18 20:27:00.111
 * UtiDecisionTable   基础数据对象
 */
@Entity
@Table(name = "utidecisiontable")
@IdClass(UtiDecisionTableKey.class)
public class UtiDecisionTable implements BaseEntity,Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性DecisionNo/
     */
    @Id
    @Column(name = "decisionNo")
    private String decisionNo;
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
     * 属性FactorCode/
     */
    @Id
    @Column(name = "factorCode")
    private String factorCode;


    /**
     * 属性DecisionScope/
     */
    private String decisionScope;
    /**
     * 属性DefaultValue/
     */
    private String defaultValue;
    /**
     * 属性Condition1/
     */
    private String condition1;
    /**
     * 属性Condition2/
     */
    private String condition2;
    /**
     * 属性Condition3/
     */
    private String condition3;
    /**
     * 属性Condition4/
     */
    private String condition4;
    /**
     * 属性Condition5/
     */
    private String condition5;
    /**
     * 属性Condition6/
     */
    private String condition6;
    /**
     * 属性Condition7/
     */
    private String condition7;
    /**
     * 属性Condition8/
     */
    private String condition8;
    /**
     * 属性Condition9/
     */
    private String condition9;
    /**
     * 属性Condition10/
     */
    private String condition10;
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
     * 类UtiDecisionTable的默认构造方法
     */
    public UtiDecisionTable() {
    }


    /**
     * 属性DecisionScope/的getter方法
     */
    public String getDecisionScope() {
        return decisionScope;
    }

    /**
     * 属性DecisionScope/的setter方法
     */
    public void setDecisionScope(String decisionScope) {
        this.decisionScope = decisionScope;
    }

    /**
     * 属性DefaultValue/的getter方法
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 属性DefaultValue/的setter方法
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 属性Condition1/的getter方法
     */
    public String getCondition1() {
        return condition1;
    }

    /**
     * 属性Condition1/的setter方法
     */
    public void setCondition1(String condition1) {
        this.condition1 = condition1;
    }

    /**
     * 属性Condition2/的getter方法
     */
    public String getCondition2() {
        return condition2;
    }

    /**
     * 属性Condition2/的setter方法
     */
    public void setCondition2(String condition2) {
        this.condition2 = condition2;
    }

    /**
     * 属性Condition3/的getter方法
     */
    public String getCondition3() {
        return condition3;
    }

    /**
     * 属性Condition3/的setter方法
     */
    public void setCondition3(String condition3) {
        this.condition3 = condition3;
    }

    /**
     * 属性Condition4/的getter方法
     */
    public String getCondition4() {
        return condition4;
    }

    /**
     * 属性Condition4/的setter方法
     */
    public void setCondition4(String condition4) {
        this.condition4 = condition4;
    }

    /**
     * 属性Condition5/的getter方法
     */
    public String getCondition5() {
        return condition5;
    }

    /**
     * 属性Condition5/的setter方法
     */
    public void setCondition5(String condition5) {
        this.condition5 = condition5;
    }

    /**
     * 属性Condition6/的getter方法
     */
    public String getCondition6() {
        return condition6;
    }

    /**
     * 属性Condition6/的setter方法
     */
    public void setCondition6(String condition6) {
        this.condition6 = condition6;
    }

    /**
     * 属性Condition7/的getter方法
     */
    public String getCondition7() {
        return condition7;
    }

    /**
     * 属性Condition7/的setter方法
     */
    public void setCondition7(String condition7) {
        this.condition7 = condition7;
    }

    /**
     * 属性Condition8/的getter方法
     */
    public String getCondition8() {
        return condition8;
    }

    /**
     * 属性Condition8/的setter方法
     */
    public void setCondition8(String condition8) {
        this.condition8 = condition8;
    }

    /**
     * 属性Condition9/的getter方法
     */
    public String getCondition9() {
        return condition9;
    }

    /**
     * 属性Condition9/的setter方法
     */
    public void setCondition9(String condition9) {
        this.condition9 = condition9;
    }

    /**
     * 属性Condition10/的getter方法
     */
    public String getCondition10() {
        return condition10;
    }

    /**
     * 属性Condition10/的setter方法
     */
    public void setCondition10(String condition10) {
        this.condition10 = condition10;
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
    * 属性decisionNo的getter方法
    */
    public String getDecisionNo() {
        return decisionNo;
    }

    /*
    * 属性decisionNo的setter方法
    */
    public void setDecisionNo(String decisionNo) {
        this.decisionNo = decisionNo;
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