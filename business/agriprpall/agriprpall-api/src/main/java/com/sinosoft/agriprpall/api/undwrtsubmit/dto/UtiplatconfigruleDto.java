package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * UtiplatconfigruleApi操作对象
 */
public class UtiplatconfigruleDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性systemCode/systemCode */
	private String systemCode ;		
	/** 属性paramCode/paramCode */
	private String paramCode ;		
	/** 属性serialNo/serialNo */
	private Integer serialNo ;
	/** 属性rule/rule */
	private String rule ;		
	/** 属性flag/flag */
	private String flag ;		

	/** 属性createDBy/createDBy */
	private String createDBy ;
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;

	public String getCreateDBy() {
		return createDBy;
	}

	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}

	public Date getCreateDTime() {
		return createDTime;
	}

	public void setCreateDTime(Date createDTime) {
		this.createDTime = createDTime;
	}

	public String getUpdateDBy() {
		return updateDBy;
	}

	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}

	public Date getUpdateDTime() {
		return updateDTime;
	}

	public void setUpdateDTime(Date updateDTime) {
		this.updateDTime = updateDTime;
	}

	/**
	 * 属性systemCode/systemCode的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性systemCode/systemCode的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}	
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}	
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性rule/rule的getter方法
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 属性rule/rule的setter方法
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
		

		
}
