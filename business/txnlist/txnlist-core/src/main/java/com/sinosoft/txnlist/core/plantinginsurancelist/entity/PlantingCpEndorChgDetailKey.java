package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
*清单批改持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:29
*/
public class PlantingCpEndorChgDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingCpEndorChgDetailKey(){}
	public PlantingCpEndorChgDetailKey(String inusreListCode,String fCode,String kindCode,String indexCode){
		this.inusreListCode = inusreListCode;
		this.fCode = fCode;
		this.kindCode = kindCode;
		this.indexCode = indexCode;
	}
	/** 属性投保清单编号（key）/投保清单编号（key） */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性农户代码（key）/农户代码（key） */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性险别序号（key）/险别序号（key） */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性排序序号/排序序号 */
	@Column(name = "indexCode")
	private String indexCode ;
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 
	/**
	 * 属性农户代码（key）/农户代码（key）的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性农户代码（key）/农户代码（key）的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
	/**
	 * 属性险别序号（key）/险别序号（key）的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别序号（key）/险别序号（key）的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性排序序号/排序序号的getter方法
	 */
	public String getIndexCode() {
    		return indexCode;
	}
	/**
	 * 属性排序序号/排序序号的setter方法
	 */
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	} 
}