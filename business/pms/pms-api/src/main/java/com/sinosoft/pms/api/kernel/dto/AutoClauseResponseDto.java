package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class AutoClauseResponseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性机构代码/机构代码 */
    private String comCode ;
    //机构名称
    private String comName ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    //代码名称
    private String riskName ;
    /** 属性特约代码/特约代码 */
    private String clauseCode ;
    /** 属性特约名称/特约名称 */
    private String clauseName ;
    /** 属性特约内容/特约内容：
     需要动态生成特约内容的特约，动态内容以*****代替。 */
    private String clauseText ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性适用系统/适用系统 */
    private String policySort ;
    //特约类型
    private String clauseType ;
    //是否允许手工删除
    private String delText ;
    private List<AutoClauseModuleResponseDto> autoClauseModuleResponseDtos;
    private List<PrpDautoClauseContentDto> prpDautoClauseContentDtos;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getClauseName() {
        return clauseName;
    }

    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }

    public String getClauseText() {
        return clauseText;
    }

    public void setClauseText(String clauseText) {
        this.clauseText = clauseText;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPolicySort() {
        return policySort;
    }

    public void setPolicySort(String policySort) {
        this.policySort = policySort;
    }

    public String getClauseType() {
        return clauseType;
    }

    public void setClauseType(String clauseType) {
        this.clauseType = clauseType;
    }

    public String getDelText() {
        return delText;
    }

    public void setDelText(String delText) {
        this.delText = delText;
    }

    public List<AutoClauseModuleResponseDto> getAutoClauseModuleResponseDtos() {
        return autoClauseModuleResponseDtos;
    }

    public void setAutoClauseModuleResponseDtos(List<AutoClauseModuleResponseDto> autoClauseModuleResponseDtos) {
        this.autoClauseModuleResponseDtos = autoClauseModuleResponseDtos;
    }

    public List<PrpDautoClauseContentDto> getPrpDautoClauseContentDtos() {
        return prpDautoClauseContentDtos;
    }

    public void setPrpDautoClauseContentDtos(List<PrpDautoClauseContentDto> prpDautoClauseContentDtos) {
        this.prpDautoClauseContentDtos = prpDautoClauseContentDtos;
    }
}
