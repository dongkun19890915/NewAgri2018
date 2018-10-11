package com.sinosoft.ims.api.kernel.dto;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-20 17:08:11.477 
 * Saa_PermitRisk   基础数据对象
 */
public class SaaUserPermitRiskDto  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性Id/ */
	private String id ;
	/** 属性RiskCode/ */
	private String riskCode ;
	/** 属性RiskName/ */
	private String riskName ;
	/** 属性UserGradeID/ */
	private String userGradeID ;
	/** 属性Flag/ */
	private String flag ;
	/**
	 * 类SaaPermitRisk的默认构造方法
	 */
	public SaaUserPermitRiskDto() {
	}
	/**
	 * 属性Id/的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性Id/的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
	/**
	 * 属性RiskCode/的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	/**
	 * 属性RiskCode/的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性UserGradeID/的getter方法
	 */
	public String getUserGradeID() {
		return userGradeID;
	}
	/**
	 * 属性UserGradeID/的setter方法
	 */
	public void setUserGradeID(String userGradeID) {
		this.userGradeID = userGradeID;
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
}