package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * plantingsettlelist主键操作对象
 */
public class PlantingSettleListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingSettleListKey(){}
	public PlantingSettleListKey(String settleListCode,String fCode,String kindCode,String classCode){
		this.settleListCode = settleListCode;
		this.fCode = fCode;
		this.kindCode = kindCode;
		this.classCode = classCode;
	}
	/** 属性理赔清单号（KEY）/理赔清单号（KEY） */
	@Column(name = "settleListCode")
	private String settleListCode ;
	/** 属性农户代码（KEY）/农户代码（KEY） */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性险别序号（KEY）/险别序号（KEY） */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的getter方法
	 */
	public String getSettleListCode() {
    		return settleListCode;
	}
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的setter方法
	 */
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	} 
	/**
	 * 属性农户代码（KEY）/农户代码（KEY）的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性农户代码（KEY）/农户代码（KEY）的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
	/**
	 * 属性险别序号（KEY）/险别序号（KEY）的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别序号（KEY）/险别序号（KEY）的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
    		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 
}