package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 08:12:17.248 
 * 农业险保单信息PApi操作对象
 */
public class PrpPmainAgriDto extends BaseRequest implements Serializable{
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

	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性种植养殖时间/种植养殖时间的getter方法
	 */
	public java.util.Date getRaiseDate() {
		return raiseDate;
	}
	/**
	 * 属性种植养殖时间/种植养殖时间的setter方法
	 */
	public void setRaiseDate(java.util.Date raiseDate) {
		this.raiseDate = raiseDate;
	}	
	/**
	 * 属性种植养殖地点/种植养殖地点的getter方法
	 */
	public String getRaiseSite() {
		return raiseSite;
	}
	/**
	 * 属性种植养殖地点/种植养殖地点的setter方法
	 */
	public void setRaiseSite(String raiseSite) {
		this.raiseSite = raiseSite;
	}	
	/**
	 * 属性总投保面积/总投保面积的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性总投保面积/总投保面积的setter方法
	 */
	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
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
	 * 属性observePeriod/observePeriod的getter方法
	 */
	public Integer getObservePeriod() {
		return observePeriod;
	}
	/**
	 * 属性observePeriod/observePeriod的setter方法
	 */
	public void setObservePeriod(Integer observePeriod) {
		this.observePeriod = observePeriod;
	}	
	/**
	 * 属性observeStartDate/observeStartDate的getter方法
	 */
	public java.util.Date getObserveStartDate() {
		return observeStartDate;
	}
	/**
	 * 属性observeStartDate/observeStartDate的setter方法
	 */
	public void setObserveStartDate(java.util.Date observeStartDate) {
		this.observeStartDate = observeStartDate;
	}	
	/**
	 * 属性observeStartHour/observeStartHour的getter方法
	 */
	public Integer getObserveStartHour() {
		return observeStartHour;
	}
	/**
	 * 属性observeStartHour/observeStartHour的setter方法
	 */
	public void setObserveStartHour(Integer observeStartHour) {
		this.observeStartHour = observeStartHour;
	}	
	/**
	 * 属性observeEndDate/observeEndDate的getter方法
	 */
	public java.util.Date getObserveEndDate() {
		return observeEndDate;
	}
	/**
	 * 属性observeEndDate/observeEndDate的setter方法
	 */
	public void setObserveEndDate(java.util.Date observeEndDate) {
		this.observeEndDate = observeEndDate;
	}	
	/**
	 * 属性observeEndHour/observeEndHour的getter方法
	 */
	public Integer getObserveEndHour() {
		return observeEndHour;
	}
	/**
	 * 属性observeEndHour/observeEndHour的setter方法
	 */
	public void setObserveEndHour(Integer observeEndHour) {
		this.observeEndHour = observeEndHour;
	}	
	/**
	 * 属性valueRate/valueRate的getter方法
	 */
	public Double getValueRate() {
		return valueRate;
	}
	/**
	 * 属性valueRate/valueRate的setter方法
	 */
	public void setValueRate(Double valueRate) {
		this.valueRate = valueRate;
	}	
	/**
	 * 属性selfPremium/selfPremium的getter方法
	 */
	public Double getSelfPremium() {
		return selfPremium;
	}
	/**
	 * 属性selfPremium/selfPremium的setter方法
	 */
	public void setSelfPremium(Double selfPremium) {
		this.selfPremium = selfPremium;
	}	
	/**
	 * 属性天气指数发布部门名称/天气指数发布部门名称的getter方法
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 属性天气指数发布部门名称/天气指数发布部门名称的setter方法
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}	
	/**
	 * 属性天气指数发布部门地址/天气指数发布部门地址的getter方法
	 */
	public String getDeptAddress() {
		return deptAddress;
	}
	/**
	 * 属性天气指数发布部门地址/天气指数发布部门地址的setter方法
	 */
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}	
	/**
	 * 属性投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否/投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否的getter方法
	 */
	public String getAreaFlag() {
		return areaFlag;
	}
	/**
	 * 属性投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否/投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否的setter方法
	 */
	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}	
	/**
	 * 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到）的getter方法
	 */
	public String getRaiseType() {
		return raiseType;
	}
	/**
	 * 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到）的setter方法
	 */
	public void setRaiseType(String raiseType) {
		this.raiseType = raiseType;
	}	
	/**
	 * 属性分户清单关联号/分户清单关联号的getter方法
	 */
	public String getRelationListNo() {
		return relationListNo;
	}
	/**
	 * 属性分户清单关联号/分户清单关联号的setter方法
	 */
	public void setRelationListNo(String relationListNo) {
		this.relationListNo = relationListNo;
	}	

	/**
	 * 属性土地流转号/土地流转号的getter方法
	 */
	public String getCirculationCode() {
		return circulationCode;
	}
	/**
	 * 属性土地流转号/土地流转号的setter方法
	 */
	public void setCirculationCode(String circulationCode) {
		this.circulationCode = circulationCode;
	}	
	/**
	 * 属性开垦复垦面积(种植险)/开垦复垦面积(种植险)的getter方法
	 */
	public Integer getReclamationArea() {
		return reclamationArea;
	}
	/**
	 * 属性开垦复垦面积(种植险)/开垦复垦面积(种植险)的setter方法
	 */
	public void setReclamationArea(Integer reclamationArea) {
		this.reclamationArea = reclamationArea;
	}	
	/**
	 * 属性土地流转面积(种植险)/土地流转面积(种植险)的getter方法
	 */
	public Integer getCirculationArea() {
		return circulationArea;
	}
	/**
	 * 属性土地流转面积(种植险)/土地流转面积(种植险)的setter方法
	 */
	public void setCirculationArea(Integer circulationArea) {
		this.circulationArea = circulationArea;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getRelationListNoRemark() {
		return relationListNoRemark;
	}

	public void setRelationListNoRemark(String relationListNoRemark) {
		this.relationListNoRemark = relationListNoRemark;
	}

	public Double getChgSelfPremium() {
		return chgSelfPremium;
	}

	public void setChgSelfPremium(Double chgSelfPremium) {
		this.chgSelfPremium = chgSelfPremium;
	}
}
