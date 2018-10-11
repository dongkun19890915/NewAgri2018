package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-04 09:05:54.250 
 * 单证校验信息表实体操作对象
 */
@Entity
@Table(name = "PrpDcertifycheckAgri")
@IdClass(PrpDcertifycheckKey.class)
public class PrpDcertifycheck extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种号（key）/险种号（key） */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性节点名称(核心为prpall，其他同理赔系统节点名称)（key）/节点名称(核心为prpall，其他同理赔系统节点名称)（key） */
	@Id
	@Column(name = "nodeType")
	private String nodeType ;/** 属性必传的单证类型（key）/必传的单证类型（key） */
	@Id
	@Column(name = "certifyType")
	private String certifyType ;	



	/** 属性单证名称/单证名称 */
	@Column(name = "CertifyName")
	private String certifyName ;
	/** 属性是否有效（1为有效，0为无效）/是否有效（1为有效，0为无效） */
	@Column(name = "ValidStatus")
	private String validStatus ;
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
	 * 属性节点名称(核心为prpall，其他同理赔系统节点名称)（key）/节点名称(核心为prpall，其他同理赔系统节点名称)（key）的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点名称(核心为prpall，其他同理赔系统节点名称)（key）/节点名称(核心为prpall，其他同理赔系统节点名称)（key）的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性必传的单证类型（key）/必传的单证类型（key）的getter方法
	 */
	public String getCertifyType() {
		return certifyType;
	}
	/**
	 * 属性必传的单证类型（key）/必传的单证类型（key）的setter方法
	 */
	public void setCertifyType(String certifyType) {
		this.certifyType = certifyType;
	} 	
	/**
	 * 属性单证名称/单证名称的getter方法
	 */
	public String getCertifyName() {
		return certifyName;
	}
	/**
	 * 属性单证名称/单证名称的setter方法
	 */
	public void setCertifyName(String certifyName) {
		this.certifyName = certifyName;
	} 	
	/**
	 * 属性是否有效（1为有效，0为无效）/是否有效（1为有效，0为无效）的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效（1为有效，0为无效）/是否有效（1为有效，0为无效）的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
}