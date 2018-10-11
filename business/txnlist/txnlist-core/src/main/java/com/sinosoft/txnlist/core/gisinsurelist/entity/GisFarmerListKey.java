package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-15 07:18:08.821 
 * 投保预确认农户清单表主键操作对象
 */
public class GisFarmerListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public GisFarmerListKey(){}
	public GisFarmerListKey(String insureListCode,Integer serialNo,String fCode){
		this.insureListCode = insureListCode;
		this.serialNo = serialNo;
		this.fCode = fCode;
	}
	/** 属性清单编号/清单编号 */
	@Column(name = "insureListCode")
	private String insureListCode ;
	/** 属性序列号/序列号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getInsureListCode() {
		return insureListCode;
	}

	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
	}

	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
}