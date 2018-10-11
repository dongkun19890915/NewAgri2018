package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单农户标的明细表-人实体操作对象
 */
@Entity
@Table(name = "LossRatePersList")
@IdClass(LossRatePersListKey.class)
public class LossRatePersList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	@Id
	@Column(name = "lossListCode")
	private String lossListCode ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性农户代码/农户代码 */
	@Id
	@Column(name = "fCode")
	private String fCode ;/** 属性标的代码/标的代码 */
	@Id
	@Column(name = "itemCode")
	private String itemCode ;/** 属性损失序列号/损失序列号 */
	@Id
	@Column(name = "lossSerialNo")
	private java.lang.Integer lossSerialNo ;/** 属性证件号码/证件号码 */
	@Id
	@Column(name = "idCard")
	private String idCard ;	





	/** 属性证件类型/证件类型 */
	@Column(name = "idType")
	private String idType ;

	/** 属性姓名/姓名 */
	@Column(name = "name")
	private String name ;
	/** 属性性别/性别 */
	@Column(name = "sex")
	private String sex ;
	/** 属性与农户关系/与农户关系 */
	@Column(name = "relation")
	private String relation ;
	/**
	 * 属性清单编号/清单编号的getter方法
	 */
	public String getLossListCode() {
		return lossListCode;
	}
	/**
	 * 属性清单编号/清单编号的setter方法
	 */
	public void setLossListCode(String lossListCode) {
		this.lossListCode = lossListCode;
	} 	
	/**
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getfCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setfCode(String fCode) {
		this.fCode = fCode;
	} 	
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性损失序列号/损失序列号的getter方法
	 */
	public java.lang.Integer getLossSerialNo() {
		return lossSerialNo;
	}
	/**
	 * 属性损失序列号/损失序列号的setter方法
	 */
	public void setLossSerialNo(java.lang.Integer lossSerialNo) {
		this.lossSerialNo = lossSerialNo;
	} 	
	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	} 	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	} 	
	/**
	 * 属性姓名/姓名的getter方法
	 */
	public String getName() {
		return name;
	}
	/**
	 * 属性姓名/姓名的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	} 	
	/**
	 * 属性性别/性别的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别/性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	} 	
	/**
	 * 属性与农户关系/与农户关系的getter方法
	 */
	public String getRelation() {
		return relation;
	}
	/**
	 * 属性与农户关系/与农户关系的setter方法
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	} 	
}