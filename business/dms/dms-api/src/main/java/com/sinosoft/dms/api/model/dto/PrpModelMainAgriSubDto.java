package com.sinosoft.dms.api.model.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板农业险保单信息Api操作对象
 */
public class PrpModelMainAgriSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板号码/模板号码 */
	private String modelCode ;		
	/** 属性种植/养殖时间/种植/养殖时间 */
	private java.util.Date raiseDate ;		
	/** 属性种植地点/养殖地点/坐落地点/种植地点/养殖地点/坐落地点 */
	private String raiseSite ;		
	/** 属性总投保面积(种植险)/总投保面积(种植险) */
	private Double insureArea ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性疾病观察期天数/疾病观察期天数 */
	private Integer observePeriod ;
	/** 属性疾病观察期起始日期/疾病观察期起始日期 */
	private java.util.Date observeStartDate ;		
	/** 属性疾病观察期起始小时/疾病观察期起始小时 */
	private Integer observeStartHour ;
	/** 属性疾病观察期终止日期/疾病观察期终止日期 */
	private java.util.Date observeEndDate ;		
	/** 属性疾病观察期终止小时/疾病观察期终止小时 */
	private Integer observeEndHour ;
	/** 属性valueRate/valueRate */
	private Double valueRate ;
	/** 属性自缴保费/自缴保费 */
	private Double selfPremium ;
	/** 属性天气指数发布部门名称/天气指数发布部门名称 */
	private String deptName ;		
	/** 属性天气指数发布部门地址/天气指数发布部门地址 */
	private String deptAddress ;		
	/** 属性投保水稻是否距离气象发布部门/投保水稻是否距离气象发布部门 */
	private String areaFlag ;		
	/** 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到） */
	private String raiseType ;		
	/** 属性分户清单关联号/分户清单关联号 */
	private String relationListNo ;		
	/** 属性分户清单备注/分户清单备注 */
	private String relationListnoRemark ;		
	/** 属性土地流转号/土地流转号 */
	private String circulationCode ;		
	/** 属性开垦复垦面积(种植险)/开垦复垦面积(种植险) */
	private Double reclamationArea ;
	/** 属性土地流转面积(种植险)/土地流转面积(种植险) */
	private Double circulationArea ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/**
	 * 属性模板号码/模板号码的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * 属性模板号码/模板号码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}	
	/**
	 * 属性种植/养殖时间/种植/养殖时间的getter方法
	 */
	public java.util.Date getRaiseDate() {
		return raiseDate;
	}
	/**
	 * 属性种植/养殖时间/种植/养殖时间的setter方法
	 */
	public void setRaiseDate(java.util.Date raiseDate) {
		this.raiseDate = raiseDate;
	}	
	/**
	 * 属性种植地点/养殖地点/坐落地点/种植地点/养殖地点/坐落地点的getter方法
	 */
	public String getRaiseSite() {
		return raiseSite;
	}
	/**
	 * 属性种植地点/养殖地点/坐落地点/种植地点/养殖地点/坐落地点的setter方法
	 */
	public void setRaiseSite(String raiseSite) {
		this.raiseSite = raiseSite;
	}	
	/**
	 * 属性总投保面积(种植险)/总投保面积(种植险)的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性总投保面积(种植险)/总投保面积(种植险)的setter方法
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
	 * 属性疾病观察期天数/疾病观察期天数的getter方法
	 */
	public Integer getObservePeriod() {
		return observePeriod;
	}
	/**
	 * 属性疾病观察期天数/疾病观察期天数的setter方法
	 */
	public void setObservePeriod(Integer observePeriod) {
		this.observePeriod = observePeriod;
	}	
	/**
	 * 属性疾病观察期起始日期/疾病观察期起始日期的getter方法
	 */
	public java.util.Date getObserveStartDate() {
		return observeStartDate;
	}
	/**
	 * 属性疾病观察期起始日期/疾病观察期起始日期的setter方法
	 */
	public void setObserveStartDate(java.util.Date observeStartDate) {
		this.observeStartDate = observeStartDate;
	}	
	/**
	 * 属性疾病观察期起始小时/疾病观察期起始小时的getter方法
	 */
	public Integer getObserveStartHour() {
		return observeStartHour;
	}
	/**
	 * 属性疾病观察期起始小时/疾病观察期起始小时的setter方法
	 */
	public void setObserveStartHour(Integer observeStartHour) {
		this.observeStartHour = observeStartHour;
	}	
	/**
	 * 属性疾病观察期终止日期/疾病观察期终止日期的getter方法
	 */
	public java.util.Date getObserveEndDate() {
		return observeEndDate;
	}
	/**
	 * 属性疾病观察期终止日期/疾病观察期终止日期的setter方法
	 */
	public void setObserveEndDate(java.util.Date observeEndDate) {
		this.observeEndDate = observeEndDate;
	}	
	/**
	 * 属性疾病观察期终止小时/疾病观察期终止小时的getter方法
	 */
	public Integer getObserveEndHour() {
		return observeEndHour;
	}
	/**
	 * 属性疾病观察期终止小时/疾病观察期终止小时的setter方法
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
	 * 属性自缴保费/自缴保费的getter方法
	 */
	public Double getSelfPremium() {
		return selfPremium;
	}
	/**
	 * 属性自缴保费/自缴保费的setter方法
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
	 * 属性投保水稻是否距离气象发布部门/投保水稻是否距离气象发布部门的getter方法
	 */
	public String getAreaFlag() {
		return areaFlag;
	}
	/**
	 * 属性投保水稻是否距离气象发布部门/投保水稻是否距离气象发布部门的setter方法
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
	 * 属性分户清单备注/分户清单备注的getter方法
	 */
	public String getRelationListnoRemark() {
		return relationListnoRemark;
	}
	/**
	 * 属性分户清单备注/分户清单备注的setter方法
	 */
	public void setRelationListnoRemark(String relationListnoRemark) {
		this.relationListnoRemark = relationListnoRemark;
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
	public Double getReclamationArea() {
		return reclamationArea;
	}
	/**
	 * 属性开垦复垦面积(种植险)/开垦复垦面积(种植险)的setter方法
	 */
	public void setReclamationArea(Double reclamationArea) {
		this.reclamationArea = reclamationArea;
	}	
	/**
	 * 属性土地流转面积(种植险)/土地流转面积(种植险)的getter方法
	 */
	public Double getCirculationArea() {
		return circulationArea;
	}
	/**
	 * 属性土地流转面积(种植险)/土地流转面积(种植险)的setter方法
	 */
	public void setCirculationArea(Double circulationArea) {
		this.circulationArea = circulationArea;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
}
