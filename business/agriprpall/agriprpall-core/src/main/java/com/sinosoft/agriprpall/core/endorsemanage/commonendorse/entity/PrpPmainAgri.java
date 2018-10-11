package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 08:12:17.248 
 * 农业险保单信息P实体操作对象
 */
@Entity
@Table(name = "PrpPmainAgri")
@IdClass(PrpPmainAgriKey.class)
public class PrpPmainAgri extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;

	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性种植养殖时间/种植养殖时间 */
	@Column(name = "raiseDate")
	private Date raiseDate ;
	/** 属性种植养殖地点/种植养殖地点 */
	@Column(name = "raiseSite")
	private String raiseSite ;
	/** 属性总投保面积/总投保面积 */
	@Column(name = "insureArea")
	private Double insureArea ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性observePeriod/observePeriod */
	@Column(name = "observePeriod")
	private Integer observePeriod ;
	/** 属性observeStartDate/observeStartDate */
	@Column(name = "observeStartDate")
	private Date observeStartDate ;
	/** 属性observeStartHour/observeStartHour */
	@Column(name = "observeStartHour")
	private Integer observeStartHour ;
	/** 属性observeEndDate/observeEndDate */
	@Column(name = "observeEndDate")
	private Date observeEndDate ;
	/** 属性observeEndHour/observeEndHour */
	@Column(name = "observeEndHour")
	private Integer observeEndHour ;
	/** 属性valueRate/valueRate */
	@Column(name = "valueRate")
	private Integer valueRate ;
	/** 属性selfPremium/selfPremium */
	@Column(name = "selfPremium")
	private Integer selfPremium ;
	/** 属性天气指数发布部门名称/天气指数发布部门名称 */
	@Column(name = "deptName")
	private String deptName ;
	/** 属性天气指数发布部门地址/天气指数发布部门地址 */
	@Column(name = "deptAddress")
	private String deptAddress ;
	/** 属性投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否/投保水稻是否距离气象发布部门或其监测机构20公里的范围内 Y/是 N/否 */
	@Column(name = "areaFlag")
	private String areaFlag ;
	/** 属性养殖户类型（3221肉牛险用到）/养殖户类型（3221肉牛险用到） */
	@Column(name = "raiseType")
	private String raiseType ;
	/** 属性分户清单关联号/分户清单关联号 */
	@Column(name = "relationListNo")
	private String relationListNo ;
	/** 属性分户清单备注/分户清单备注 */
	@Column(name = "relationListNoRemark")
	private String relationListNoRemark ;
	/** 属性土地流转号/土地流转号 */
	@Column(name = "circulationCode")
	private String circulationCode ;
	/** 属性开垦复垦面积(种植险)/开垦复垦面积(种植险) */
	@Column(name = "reclamationArea")
	private Integer reclamationArea ;
	/** 属性土地流转面积(种植险)/土地流转面积(种植险) */
	@Column(name = "circulationArea")
	private Integer circulationArea ;
	/** 属性chgSelfpremium/chgSelfpremium */
	@Column(name = "chgSelfPremium")
	private Double chgSelfPremium ;
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

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
	public Date getRaiseDate() {
		return raiseDate;
	}
	/**
	 * 属性种植养殖时间/种植养殖时间的setter方法
	 */
	public void setRaiseDate(Date raiseDate) {
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
	public Integer getValueRate() {
		return valueRate;
	}
	/**
	 * 属性valueRate/valueRate的setter方法
	 */
	public void setValueRate(Integer valueRate) {
		this.valueRate = valueRate;
	} 	
	/**
	 * 属性selfPremium/selfPremium的getter方法
	 */
	public Integer getSelfPremium() {
		return selfPremium;
	}
	/**
	 * 属性selfPremium/selfPremium的setter方法
	 */
	public void setSelfPremium(Integer selfPremium) {
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