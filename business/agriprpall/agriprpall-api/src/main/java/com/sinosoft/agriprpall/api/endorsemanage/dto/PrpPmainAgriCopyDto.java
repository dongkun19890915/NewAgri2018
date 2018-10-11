package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class PrpPmainAgriCopyDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性批单号码/批单号码 */
    private String endorseNo ;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性种植养殖时间/种植养殖时间 */
    private java.util.Date raiseDate ;
    /** 属性种植养殖地点/种植养殖地点 */
    private String raiseSite ;
    /** 属性总投保面积/总投保面积 */
    private Double insureArea ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性observePeriod/observePeriod */
    private Integer observePeriod ;
    /** 属性observeStartDate/observeStartDate */
    private java.util.Date observeStartDate ;
    /** 属性observeStartHour/observeStartHour */
    private Integer observeStartHour ;
    /** 属性observeEndDate/observeEndDate */
    private java.util.Date observeEndDate ;
    /** 属性observeEndHour/observeEndHour */
    private Integer observeEndHour ;
    /** 属性valueRate/valueRate */
    private Double valueRate ;
    /** 属性selfPremium/selfPremium */
    private Double selfPremium ;
    /** 属性天气指数发布部门名称/天气指数发布部门名称 */
    private String deptName ;
    /** 属性天气指数发布部门地址/天气指数发布部门地址 */
    private String deptAddress ;
    /** 属性投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否/投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否 */
    private String areaFlag ;
    /** 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到） */
    private String raiseType ;
    /** 属性分户清单关联号/分户清单关联号 */
    private String relationListNo ;
    /** 属性分户清单备注/分户清单备注 */
    private String relationListNoRemark ;
    /** 属性土地流转号/土地流转号 */
    private String circulationCode ;
    /** 属性开垦复垦面积(种植险)/开垦复垦面积(种植险) */
    private Integer reclamationArea ;
    /** 属性土地流转面积(种植险)/土地流转面积(种植险) */
    private Integer circulationArea ;
    /** 属性chgSelfpremium/chgSelfpremium */
    private Double chgSelfPremium ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public Date getRaiseDate() {
        return raiseDate;
    }

    public void setRaiseDate(Date raiseDate) {
        this.raiseDate = raiseDate;
    }

    public String getRaiseSite() {
        return raiseSite;
    }

    public void setRaiseSite(String raiseSite) {
        this.raiseSite = raiseSite;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getObservePeriod() {
        return observePeriod;
    }

    public void setObservePeriod(Integer observePeriod) {
        this.observePeriod = observePeriod;
    }

    public Date getObserveStartDate() {
        return observeStartDate;
    }

    public void setObserveStartDate(Date observeStartDate) {
        this.observeStartDate = observeStartDate;
    }

    public Integer getObserveStartHour() {
        return observeStartHour;
    }

    public void setObserveStartHour(Integer observeStartHour) {
        this.observeStartHour = observeStartHour;
    }

    public Date getObserveEndDate() {
        return observeEndDate;
    }

    public void setObserveEndDate(Date observeEndDate) {
        this.observeEndDate = observeEndDate;
    }

    public Integer getObserveEndHour() {
        return observeEndHour;
    }

    public void setObserveEndHour(Integer observeEndHour) {
        this.observeEndHour = observeEndHour;
    }

    public Double getValueRate() {
        return valueRate;
    }

    public void setValueRate(Double valueRate) {
        this.valueRate = valueRate;
    }

    public Double getSelfPremium() {
        return selfPremium;
    }

    public void setSelfPremium(Double selfPremium) {
        this.selfPremium = selfPremium;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getAreaFlag() {
        return areaFlag;
    }

    public void setAreaFlag(String areaFlag) {
        this.areaFlag = areaFlag;
    }

    public String getRaiseType() {
        return raiseType;
    }

    public void setRaiseType(String raiseType) {
        this.raiseType = raiseType;
    }

    public String getRelationListNo() {
        return relationListNo;
    }

    public void setRelationListNo(String relationListNo) {
        this.relationListNo = relationListNo;
    }

    public String getRelationListNoRemark() {
        return relationListNoRemark;
    }

    public void setRelationListNoRemark(String relationListNoRemark) {
        this.relationListNoRemark = relationListNoRemark;
    }

    public String getCirculationCode() {
        return circulationCode;
    }

    public void setCirculationCode(String circulationCode) {
        this.circulationCode = circulationCode;
    }

    public Integer getReclamationArea() {
        return reclamationArea;
    }

    public void setReclamationArea(Integer reclamationArea) {
        this.reclamationArea = reclamationArea;
    }

    public Integer getCirculationArea() {
        return circulationArea;
    }

    public void setCirculationArea(Integer circulationArea) {
        this.circulationArea = circulationArea;
    }

    public Double getChgSelfPremium() {
        return chgSelfPremium;
    }

    public void setChgSelfPremium(Double chgSelfPremium) {
        this.chgSelfPremium = chgSelfPremium;
    }
}
