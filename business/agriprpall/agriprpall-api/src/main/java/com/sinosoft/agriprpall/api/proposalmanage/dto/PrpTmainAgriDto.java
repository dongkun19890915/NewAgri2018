package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * 农业险投保单信息表Api操作对象
 */
public class PrpTmainAgriDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	private String proposalNo ;		
	/** 属性险种代码 ▲/险种代码 ▲ */
	private String riskCode ;		
	/** 属性种植/养殖时间/种植/养殖时间 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date raiseDate ;
	/** 属性种植地点/养殖地点/坐落地点/种植地点/养殖地点/坐落地点 */
	private String raiseSite ;		
	/** 属性总投保面积(种植险)/总投保面积(种植险) */
	private Double insureArea ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性observepeRiod/observepeRiod */
	private Integer observePeriod ;
	/** 属性observeStartDate/observeStartDate */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date observeStartDate ;
	/** 属性observeStartHour/observeStartHour */
	private Integer observeStartHour ;
	/** 属性observeEndDate/observeEndDate */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date observeEndDate ;
	/** 属性observeEndHour/observeEndHour */
	private Integer observeEndHour ;
	/** 属性valueRate/valueRate */
	private Double valueRate ;
	/** 属性selfpremium/selfpremium */
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
	private Double reclamationArea ;
	/** 属性土地流转面积(种植险)/土地流转面积(种植险) */
	private Double circulationArea ;



	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性险种代码 ▲/险种代码 ▲的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码 ▲/险种代码 ▲的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性种植/养殖时间/种植/养殖时间的getter方法
	 */
	public Date getRaiseDate() {
		return raiseDate;
	}
	/**
	 * 属性种植/养殖时间/种植/养殖时间的setter方法
	 */
	public void setRaiseDate(Date raiseDate) {
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
	 * 属性observeStartDate/observeStartDate的getter方法
	 */
	public Date getObserveStartDate() {
		return observeStartDate;
	}
	/**
	 * 属性observeStartDate/observeStartDate的setter方法
	 */
	public void setObserveStartDate(Date observeStartDate) {
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
	public Date getObserveEndDate() {
		return observeEndDate;
	}
	/**
	 * 属性observeEndDate/observeEndDate的setter方法
	 */
	public void setObserveEndDate(Date observeEndDate) {
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

	public Integer getObservePeriod() {
		return observePeriod;
	}

	public void setObservePeriod(Integer observePeriod) {
		this.observePeriod = observePeriod;
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
}
