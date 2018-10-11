package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-13 16:30:54.800 
 * 条款定义表-PrpDClause   基础数据对象
 */
@Entity
@Table(name = "prpdclause")
@IdClass(PrpDClauseKey.class)
public class PrpDClause implements BaseEntity,Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性条款代码/条款代码 */
    @Id
    @Column(name = "clauseCode")
    private String clauseCode ;
    /** 属性旧条款代码/旧条款代码 */
    private String oldClauseCode ;
    /** 属性险种分类代码/险种分类代码 */
    private String classCode ;
    /** 属性条款简体中文名称/条款简体中文名称 */
    private String clauseCName ;
    /** 属性条款繁体中文名称/条款繁体中文名称 */
    private String clauseTName ;
    /** 属性条款英文名称/条款英文名称 */
    private String clauseEName ;
    /** 属性条款中文简称/条款中文简称 */
    private String clauseSCName ;
    /** 属性条款英文简称/条款英文简称 */
    private String clauseSEName ;
    /** 属性条款版本/条款版本 */
    private String clauseVersion ;
    /** 属性涉农标志/涉农标志 */
    private String agricultureFlag ;
    /** 属性条款属性(主险、附加险)/条款属性(主险、附加险) */
    private String clauseAttribute ;
    /** 属性审核标志/审核标志 */
    private String auditFlag ;
    /** 属性适用区域层级/适用区域层级 */
    private String areaLevel ;
    /** 属性适用区域代码/适用区域代码 */
    private String areaCode ;
    /** 属性适用区域名称/适用区域名称 */
    private String areaName ;
    /** 属性报备\报批号/报备\报批号 */
    private String reportNo ;
    /** 属性审批部门/审批部门 */
    private String approvalDepart ;
    /** 属性政策\商业性标志/政策\商业性标志 */
    private String policyFlag ;
    /** 属性条款中文内容/条款中文内容 */
    private String clauseDesc ;
    /** 属性条款英文内容/条款英文内容 */
    private String clauseEDesc ;
    /** 属性是否捆绑责任销售标志/是否捆绑责任销售标志 */
    private String kindBindFlag ;
    /** 属性第一层/第一层 */
    private String firstLevel ;
    /** 属性第二层/第二层 */
    private String secondLevel ;
    /** 属性第三层/第三层 */
    private String thirdLevel ;
    /** 属性航保中心标志/航保中心标志 */
    private String hYCenterFlag ;
    /** 属性免税标志/免税标志 */
    private String dutyFreeFlag ;
    /** 属性生效日期/生效日期 */
    private java.util.Date validDate ;
    /** 属性失效日期/失效日期 */
    private java.util.Date invalidDate ;
    /** 属性有效标志/有效标志 */
    private String validInd ;
    /** 属性预留字段1/预留字段1 */
    private String tCol1 ;
    /** 属性预留字段2/预留字段2 */
    private String tCol2 ;
    /** 属性预留字段3/预留字段3 */
    private String tCol3 ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性创建人/创建人 */
    private String creatorCode ;
    /** 属性创建时间/创建时间 */
    private java.util.Date createTime ;
    /** 属性最后修改人/最后修改人 */
    private String updaterCode ;
    /** 属性最后修改时间/最后修改时间 */
    private java.util.Date updateTime ;
    /**
     * 类PrpDClause的默认构造方法
     */
    public PrpDClause() {
    }

    /**
     * 属性旧条款代码/旧条款代码的getter方法
     */
    public String getOldClauseCode() {
        return oldClauseCode;
    }
    /**
     * 属性旧条款代码/旧条款代码的setter方法
     */
    public void setOldClauseCode(String oldClauseCode) {
        this.oldClauseCode = oldClauseCode;
    } 
    /**
     * 属性险种分类代码/险种分类代码的getter方法
     */
    public String getClassCode() {
        return classCode;
    }
    /**
     * 属性险种分类代码/险种分类代码的setter方法
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    } 
    /**
     * 属性条款简体中文名称/条款简体中文名称的getter方法
     */
    public String getClauseCName() {
        return clauseCName;
    }
    /**
     * 属性条款简体中文名称/条款简体中文名称的setter方法
     */
    public void setClauseCName(String clauseCName) {
        this.clauseCName = clauseCName;
    } 
    /**
     * 属性条款繁体中文名称/条款繁体中文名称的getter方法
     */
    public String getClauseTName() {
        return clauseTName;
    }
    /**
     * 属性条款繁体中文名称/条款繁体中文名称的setter方法
     */
    public void setClauseTName(String clauseTName) {
        this.clauseTName = clauseTName;
    } 
    /**
     * 属性条款英文名称/条款英文名称的getter方法
     */
    public String getClauseEName() {
        return clauseEName;
    }
    /**
     * 属性条款英文名称/条款英文名称的setter方法
     */
    public void setClauseEName(String clauseEName) {
        this.clauseEName = clauseEName;
    } 
    /**
     * 属性条款中文简称/条款中文简称的getter方法
     */
    public String getClauseSCName() {
        return clauseSCName;
    }
    /**
     * 属性条款中文简称/条款中文简称的setter方法
     */
    public void setClauseSCName(String clauseSCName) {
        this.clauseSCName = clauseSCName;
    } 
    /**
     * 属性条款英文简称/条款英文简称的getter方法
     */
    public String getClauseSEName() {
        return clauseSEName;
    }
    /**
     * 属性条款英文简称/条款英文简称的setter方法
     */
    public void setClauseSEName(String clauseSEName) {
        this.clauseSEName = clauseSEName;
    } 
    /**
     * 属性条款版本/条款版本的getter方法
     */
    public String getClauseVersion() {
        return clauseVersion;
    }
    /**
     * 属性条款版本/条款版本的setter方法
     */
    public void setClauseVersion(String clauseVersion) {
        this.clauseVersion = clauseVersion;
    } 
    /**
     * 属性涉农标志/涉农标志的getter方法
     */
    public String getAgricultureFlag() {
        return agricultureFlag;
    }
    /**
     * 属性涉农标志/涉农标志的setter方法
     */
    public void setAgricultureFlag(String agricultureFlag) {
        this.agricultureFlag = agricultureFlag;
    } 
    /**
     * 属性条款属性(主险、附加险)/条款属性(主险、附加险)的getter方法
     */
    public String getClauseAttribute() {
        return clauseAttribute;
    }
    /**
     * 属性条款属性(主险、附加险)/条款属性(主险、附加险)的setter方法
     */
    public void setClauseAttribute(String clauseAttribute) {
        this.clauseAttribute = clauseAttribute;
    } 
    /**
     * 属性审核标志/审核标志的getter方法
     */
    public String getAuditFlag() {
        return auditFlag;
    }
    /**
     * 属性审核标志/审核标志的setter方法
     */
    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag;
    } 
    /**
     * 属性适用区域层级/适用区域层级的getter方法
     */
    public String getAreaLevel() {
        return areaLevel;
    }
    /**
     * 属性适用区域层级/适用区域层级的setter方法
     */
    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    } 
    /**
     * 属性适用区域代码/适用区域代码的getter方法
     */
    public String getAreaCode() {
        return areaCode;
    }
    /**
     * 属性适用区域代码/适用区域代码的setter方法
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    } 
    /**
     * 属性适用区域名称/适用区域名称的getter方法
     */
    public String getAreaName() {
        return areaName;
    }
    /**
     * 属性适用区域名称/适用区域名称的setter方法
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    } 
    /**
     * 属性报备\报批号/报备\报批号的getter方法
     */
    public String getReportNo() {
        return reportNo;
    }
    /**
     * 属性报备\报批号/报备\报批号的setter方法
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    } 
    /**
     * 属性审批部门/审批部门的getter方法
     */
    public String getApprovalDepart() {
        return approvalDepart;
    }
    /**
     * 属性审批部门/审批部门的setter方法
     */
    public void setApprovalDepart(String approvalDepart) {
        this.approvalDepart = approvalDepart;
    } 
    /**
     * 属性政策\商业性标志/政策\商业性标志的getter方法
     */
    public String getPolicyFlag() {
        return policyFlag;
    }
    /**
     * 属性政策\商业性标志/政策\商业性标志的setter方法
     */
    public void setPolicyFlag(String policyFlag) {
        this.policyFlag = policyFlag;
    } 
    /**
     * 属性条款中文内容/条款中文内容的getter方法
     */
    public String getClauseDesc() {
        return clauseDesc;
    }
    /**
     * 属性条款中文内容/条款中文内容的setter方法
     */
    public void setClauseDesc(String clauseDesc) {
        this.clauseDesc = clauseDesc;
    } 
    /**
     * 属性条款英文内容/条款英文内容的getter方法
     */
    public String getClauseEDesc() {
        return clauseEDesc;
    }
    /**
     * 属性条款英文内容/条款英文内容的setter方法
     */
    public void setClauseEDesc(String clauseEDesc) {
        this.clauseEDesc = clauseEDesc;
    } 
    /**
     * 属性是否捆绑责任销售标志/是否捆绑责任销售标志的getter方法
     */
    public String getKindBindFlag() {
        return kindBindFlag;
    }
    /**
     * 属性是否捆绑责任销售标志/是否捆绑责任销售标志的setter方法
     */
    public void setKindBindFlag(String kindBindFlag) {
        this.kindBindFlag = kindBindFlag;
    } 
    /**
     * 属性第一层/第一层的getter方法
     */
    public String getFirstLevel() {
        return firstLevel;
    }
    /**
     * 属性第一层/第一层的setter方法
     */
    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel;
    } 
    /**
     * 属性第二层/第二层的getter方法
     */
    public String getSecondLevel() {
        return secondLevel;
    }
    /**
     * 属性第二层/第二层的setter方法
     */
    public void setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
    } 
    /**
     * 属性第三层/第三层的getter方法
     */
    public String getThirdLevel() {
        return thirdLevel;
    }
    /**
     * 属性第三层/第三层的setter方法
     */
    public void setThirdLevel(String thirdLevel) {
        this.thirdLevel = thirdLevel;
    } 
    /**
     * 属性航保中心标志/航保中心标志的getter方法
     */
    public String getHYCenterFlag() {
        return hYCenterFlag;
    }
    /**
     * 属性航保中心标志/航保中心标志的setter方法
     */
    public void setHYCenterFlag(String hYCenterFlag) {
        this.hYCenterFlag = hYCenterFlag;
    } 
    /**
     * 属性免税标志/免税标志的getter方法
     */
    public String getDutyFreeFlag() {
        return dutyFreeFlag;
    }
    /**
     * 属性免税标志/免税标志的setter方法
     */
    public void setDutyFreeFlag(String dutyFreeFlag) {
        this.dutyFreeFlag = dutyFreeFlag;
    } 
    /**
     * 属性生效日期/生效日期的getter方法
     */
    public java.util.Date getValidDate() {
        return validDate;
    }
    /**
     * 属性生效日期/生效日期的setter方法
     */
    public void setValidDate(java.util.Date validDate) {
        this.validDate = validDate;
    } 
    /**
     * 属性失效日期/失效日期的getter方法
     */
    public java.util.Date getInvalidDate() {
        return invalidDate;
    }
    /**
     * 属性失效日期/失效日期的setter方法
     */
    public void setInvalidDate(java.util.Date invalidDate) {
        this.invalidDate = invalidDate;
    } 
    /**
     * 属性有效标志/有效标志的getter方法
     */
    public String getValidInd() {
        return validInd;
    }
    /**
     * 属性有效标志/有效标志的setter方法
     */
    public void setValidInd(String validInd) {
        this.validInd = validInd;
    } 
    /**
     * 属性预留字段1/预留字段1的getter方法
     */
    public String getTCol1() {
        return tCol1;
    }
    /**
     * 属性预留字段1/预留字段1的setter方法
     */
    public void setTCol1(String tCol1) {
        this.tCol1 = tCol1;
    } 
    /**
     * 属性预留字段2/预留字段2的getter方法
     */
    public String getTCol2() {
        return tCol2;
    }
    /**
     * 属性预留字段2/预留字段2的setter方法
     */
    public void setTCol2(String tCol2) {
        this.tCol2 = tCol2;
    } 
    /**
     * 属性预留字段3/预留字段3的getter方法
     */
    public String getTCol3() {
        return tCol3;
    }
    /**
     * 属性预留字段3/预留字段3的setter方法
     */
    public void setTCol3(String tCol3) {
        this.tCol3 = tCol3;
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
     * 属性标志字段/标志字段的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性标志字段/标志字段的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    } 
    /**
     * 属性创建人/创建人的getter方法
     */
    public String getCreatorCode() {
        return creatorCode;
    }
    /**
     * 属性创建人/创建人的setter方法
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    } 
    /**
     * 属性创建时间/创建时间的getter方法
     */
    public java.util.Date getCreateTime() {
        return createTime;
    }
    /**
     * 属性创建时间/创建时间的setter方法
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    } 
    /**
     * 属性最后修改人/最后修改人的getter方法
     */
    public String getUpdaterCode() {
        return updaterCode;
    }
    /**
     * 属性最后修改人/最后修改人的setter方法
     */
    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    } 
    /**
     * 属性最后修改时间/最后修改时间的getter方法
     */
    public java.util.Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 属性最后修改时间/最后修改时间的setter方法
     */
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
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
}