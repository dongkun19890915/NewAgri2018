package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 03:00:47.370 
 * 承保理赔镜像代码表Api操作对象
 */
public class PrpDImageCodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种号（key）/险种号（key） */
	private String riskCode ;		
	/** 属性机构号（key）/机构号（key） */
	private String comCode ;		
	/** 属性承保编号/承保编号 */
	private String prpallCode ;		
	/** 属性承保角色/承保角色 */
	private String prpallRole ;		
	/** 属性承保业务名称/承保业务名称 */
	private String prpallName ;		
	/** 属性理赔编号/理赔编号 */
	private String claimCode ;		
	/** 属性理赔角色/理赔角色 */
	private String claimRole ;		
	/** 属性理赔业务名称/理赔业务名称 */
	private String claimName ;		
	/**
	 * 属性险种号（key）/险种号（key）的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种号（key）/险种号（key）的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性机构号（key）/机构号（key）的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构号（key）/机构号（key）的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性承保编号/承保编号的getter方法
	 */
	public String getPrpallCode() {
		return prpallCode;
	}
	/**
	 * 属性承保编号/承保编号的setter方法
	 */
	public void setPrpallCode(String prpallCode) {
		this.prpallCode = prpallCode;
	}	
	/**
	 * 属性承保角色/承保角色的getter方法
	 */
	public String getPrpallRole() {
		return prpallRole;
	}
	/**
	 * 属性承保角色/承保角色的setter方法
	 */
	public void setPrpallRole(String prpallRole) {
		this.prpallRole = prpallRole;
	}	
	/**
	 * 属性承保业务名称/承保业务名称的getter方法
	 */
	public String getPrpallName() {
		return prpallName;
	}
	/**
	 * 属性承保业务名称/承保业务名称的setter方法
	 */
	public void setPrpallName(String prpallName) {
		this.prpallName = prpallName;
	}	
	/**
	 * 属性理赔编号/理赔编号的getter方法
	 */
	public String getClaimCode() {
		return claimCode;
	}
	/**
	 * 属性理赔编号/理赔编号的setter方法
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}	
	/**
	 * 属性理赔角色/理赔角色的getter方法
	 */
	public String getClaimRole() {
		return claimRole;
	}
	/**
	 * 属性理赔角色/理赔角色的setter方法
	 */
	public void setClaimRole(String claimRole) {
		this.claimRole = claimRole;
	}	
	/**
	 * 属性理赔业务名称/理赔业务名称的getter方法
	 */
	public String getClaimName() {
		return claimName;
	}
	/**
	 * 属性理赔业务名称/理赔业务名称的setter方法
	 */
	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}	
}
