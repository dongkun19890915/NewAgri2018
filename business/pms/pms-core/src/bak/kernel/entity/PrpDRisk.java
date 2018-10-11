package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time 2016-10-12 19:47:01.205
 * 产品定义表-PrpDRisk   基础数据对象
 */
@Entity
@Table(name = "prpdrisk")
@IdClass(PrpDRiskKey.class)
public class PrpDRisk implements BaseEntity,Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性产品代码/产品代码
     */
    @Id
    @Column(name = "riskCode")
    private String riskCode;
    /**
     * 属性旧产品代码/旧产品代码
     */
    private String oldRiskCode;
    /**
     * 属性产品中文名称/产品中文名称
     */
    private String riskCName;
    /**
     * 属性产品中文简称/产品中文简称
     */
    private String riskSCName;
    /**
     * 属性产品繁体中文名称/产品繁体中文名称
     */
    private String riskTName;
    /**
     * 属性产品英文名称/产品英文名称
     */
    private String riskEName;
    /**
     * 属性产品英文简称/产品英文简称
     */
    private String riskSEName;
    /**
     * 属性产品属性/产品属性
     */
    private String riskAttribute;
    /**
     * 属性销售区域层级/销售区域层级
     */
    private String saleAreaLevel;
    /**
     * 属性销售区域代码/销售区域代码
     */
    private String saleAreaCode;
    /**
     * 属性销售区域名称/销售区域名称
     */
    private String saleAreaName;
    /**
     * 属性资料内容/资料内容
     */
    private String materialContxt;
    /**
     * 属性险种分类代码/险种分类代码
     */
    private String classCode;
    /**
     * 属性报备\报批号/报备\报批号
     */
    private String reportNo;
    /**
     * 属性是否存在方案/是否存在方案
     */
    private String planInd;
    /**
     * 属性财务核算层级/财务核算层级
     */
    private String accountLevel;
    /**
     * 属性再保核算层级/再保核算层级
     */
    private String reinsLevel;
    /**
     * 属性管理核算层级/管理核算层级
     */
    private String managementLevel;
    /**
     * 属性统计核算层级/统计核算层级
     */
    private String statLevel;
    /**
     * 属性审核标志/审核标志
     */
    private String auditFlag;
    /**
     * 属性涉农标志/涉农标志
     */
    private String agricultureFlag;
    /**
     * 属性政策\商业性标志/政策\商业性标志
     */
    private String policyFlag;
    /**
     * 属性出单政策性业务处理标志/出单政策性业务处理标志
     */
    private String policyProcessFlag;
    /**
     * 属性出单是否必选方案/出单是否必选方案
     */
    private String requiredFlag;
    /**
     * 属性同步标志/同步标志
     */
    private String synflag;
    /**
     * 属性费率单位/费率单位
     */
    private Double rateUnit;
    /**
     * 属性按什么取短期费率标志/按什么取短期费率标志
     */
    private String shortRateFlag;
    /**
     * 属性险种分类标志/险种分类标志
     */
    private String classFlag;
    /**
     * 属性产品标志/产品标志
     */
    private String riskFlag;
    /**
     * 属性自动送收付费/自动送收付费
     */
    private String autoPaymentFlag;
    /**
     * 属性生效日期/生效日期
     */
    private java.util.Date validDate;
    /**
     * 属性失效日期/失效日期
     */
    private java.util.Date invalidDate;
    /**
     * 属性有效标志/有效标志
     */
    private String validInd;
    /**
     * 属性预留字段1/预留字段1
     */
    private String tCol1;
    /**
     * 属性预留字段2/预留字段2
     */
    private String tCol2;
    /**
     * 属性预留字段3/预留字段3
     */
    private String tCol3;
    /**
     * 属性标志字段/标志字段
     */
    private String flag;
    /**
     * 属性创建人/创建人
     */
    private String creatorCode;
    /**
     * 属性创建时间/创建时间
     */
    private java.util.Date createTime;
    /**
     * 属性最后修改人/最后修改人
     */
    private String updaterCode;
    /**
     * 属性最后修改时间/最后修改时间
     */
    private java.util.Date updateTime;

    /**
     * 类PrpDRisk的默认构造方法
     */
    public PrpDRisk() {
    }

    /**
     * 属性旧产品代码/旧产品代码的getter方法
     */
    public String getOldRiskCode() {
        return oldRiskCode;
    }

    /**
     * 属性旧产品代码/旧产品代码的setter方法
     */
    public void setOldRiskCode(String oldRiskCode) {
        this.oldRiskCode = oldRiskCode;
    }

    /**
     * 属性产品中文名称/产品中文名称的getter方法
     */
    public String getRiskCName() {
        return riskCName;
    }

    /**
     * 属性产品中文名称/产品中文名称的setter方法
     */
    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    /**
     * 属性产品中文简称/产品中文简称的getter方法
     */
    public String getRiskSCName() {
        return riskSCName;
    }

    /**
     * 属性产品中文简称/产品中文简称的setter方法
     */
    public void setRiskSCName(String riskSCName) {
        this.riskSCName = riskSCName;
    }

    /**
     * 属性产品繁体中文名称/产品繁体中文名称的getter方法
     */
    public String getRiskTName() {
        return riskTName;
    }

    /**
     * 属性产品繁体中文名称/产品繁体中文名称的setter方法
     */
    public void setRiskTName(String riskTName) {
        this.riskTName = riskTName;
    }

    /**
     * 属性产品英文名称/产品英文名称的getter方法
     */
    public String getRiskEName() {
        return riskEName;
    }

    /**
     * 属性产品英文名称/产品英文名称的setter方法
     */
    public void setRiskEName(String riskEName) {
        this.riskEName = riskEName;
    }

    /**
     * 属性产品英文简称/产品英文简称的getter方法
     */
    public String getRiskSEName() {
        return riskSEName;
    }

    /**
     * 属性产品英文简称/产品英文简称的setter方法
     */
    public void setRiskSEName(String riskSEName) {
        this.riskSEName = riskSEName;
    }

    /**
     * 属性产品属性/产品属性的getter方法
     */
    public String getRiskAttribute() {
        return riskAttribute;
    }

    /**
     * 属性产品属性/产品属性的setter方法
     */
    public void setRiskAttribute(String riskAttribute) {
        this.riskAttribute = riskAttribute;
    }

    /**
     * 属性销售区域层级/销售区域层级的getter方法
     */
    public String getSaleAreaLevel() {
        return saleAreaLevel;
    }

    /**
     * 属性销售区域层级/销售区域层级的setter方法
     */
    public void setSaleAreaLevel(String saleAreaLevel) {
        this.saleAreaLevel = saleAreaLevel;
    }

    /**
     * 属性销售区域代码/销售区域代码的getter方法
     */
    public String getSaleAreaCode() {
        return saleAreaCode;
    }

    /**
     * 属性销售区域代码/销售区域代码的setter方法
     */
    public void setSaleAreaCode(String saleAreaCode) {
        this.saleAreaCode = saleAreaCode;
    }

    /**
     * 属性销售区域名称/销售区域名称的getter方法
     */
    public String getSaleAreaName() {
        return saleAreaName;
    }

    /**
     * 属性销售区域名称/销售区域名称的setter方法
     */
    public void setSaleAreaName(String saleAreaName) {
        this.saleAreaName = saleAreaName;
    }

    /**
     * 属性资料内容/资料内容的getter方法
     */
    public String getMaterialContxt() {
        return materialContxt;
    }

    /**
     * 属性资料内容/资料内容的setter方法
     */
    public void setMaterialContxt(String materialContxt) {
        this.materialContxt = materialContxt;
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
     * 属性是否存在方案/是否存在方案的getter方法
     */
    public String getPlanInd() {
        return planInd;
    }

    /**
     * 属性是否存在方案/是否存在方案的setter方法
     */
    public void setPlanInd(String planInd) {
        this.planInd = planInd;
    }

    /**
     * 属性财务核算层级/财务核算层级的getter方法
     */
    public String getAccountLevel() {
        return accountLevel;
    }

    /**
     * 属性财务核算层级/财务核算层级的setter方法
     */
    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    /**
     * 属性再保核算层级/再保核算层级的getter方法
     */
    public String getReinsLevel() {
        return reinsLevel;
    }

    /**
     * 属性再保核算层级/再保核算层级的setter方法
     */
    public void setReinsLevel(String reinsLevel) {
        this.reinsLevel = reinsLevel;
    }

    /**
     * 属性管理核算层级/管理核算层级的getter方法
     */
    public String getManagementLevel() {
        return managementLevel;
    }

    /**
     * 属性管理核算层级/管理核算层级的setter方法
     */
    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }

    /**
     * 属性统计核算层级/统计核算层级的getter方法
     */
    public String getStatLevel() {
        return statLevel;
    }

    /**
     * 属性统计核算层级/统计核算层级的setter方法
     */
    public void setStatLevel(String statLevel) {
        this.statLevel = statLevel;
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
     * 属性出单政策性业务处理标志/出单政策性业务处理标志的getter方法
     */
    public String getPolicyProcessFlag() {
        return policyProcessFlag;
    }

    /**
     * 属性出单政策性业务处理标志/出单政策性业务处理标志的setter方法
     */
    public void setPolicyProcessFlag(String policyProcessFlag) {
        this.policyProcessFlag = policyProcessFlag;
    }

    /**
     * 属性出单是否必选方案/出单是否必选方案的getter方法
     */
    public String getRequiredFlag() {
        return requiredFlag;
    }

    /**
     * 属性出单是否必选方案/出单是否必选方案的setter方法
     */
    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    /**
     * 属性同步标志/同步标志的getter方法
     */
    public String getSynflag() {
        return synflag;
    }

    /**
     * 属性同步标志/同步标志的setter方法
     */
    public void setSynflag(String synflag) {
        this.synflag = synflag;
    }

    /**
     * 属性费率单位/费率单位的getter方法
     */
    public Double getRateUnit() {
        return rateUnit;
    }

    /**
     * 属性费率单位/费率单位的setter方法
     */
    public void setRateUnit(Double rateUnit) {
        this.rateUnit = rateUnit;
    }

    /**
     * 属性按什么取短期费率标志/按什么取短期费率标志的getter方法
     */
    public String getShortRateFlag() {
        return shortRateFlag;
    }

    /**
     * 属性按什么取短期费率标志/按什么取短期费率标志的setter方法
     */
    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    /**
     * 属性险种分类标志/险种分类标志的getter方法
     */
    public String getClassFlag() {
        return classFlag;
    }

    /**
     * 属性险种分类标志/险种分类标志的setter方法
     */
    public void setClassFlag(String classFlag) {
        this.classFlag = classFlag;
    }

    /**
     * 属性产品标志/产品标志的getter方法
     */
    public String getRiskFlag() {
        return riskFlag;
    }

    /**
     * 属性产品标志/产品标志的setter方法
     */
    public void setRiskFlag(String riskFlag) {
        this.riskFlag = riskFlag;
    }

    /**
     * 属性自动送收付费/自动送收付费的getter方法
     */
    public String getAutoPaymentFlag() {
        return autoPaymentFlag;
    }

    /**
     * 属性自动送收付费/自动送收付费的setter方法
     */
    public void setAutoPaymentFlag(String autoPaymentFlag) {
        this.autoPaymentFlag = autoPaymentFlag;
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
}