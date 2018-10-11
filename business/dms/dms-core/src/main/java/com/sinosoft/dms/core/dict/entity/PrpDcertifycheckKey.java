package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-04 09:05:54.250 
 * 单证校验信息表主键操作对象
 */
public class PrpDcertifycheckKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcertifycheckKey(){}
	public PrpDcertifycheckKey(String riskCode,String nodeType,String certifyType){
		this.riskCode = riskCode;
		this.nodeType = nodeType;
		this.certifyType = certifyType;
	}
	/** 属性险种号（key）/险种号（key） */
	@Column(name = "RiskCode")
	private String riskCode ;
	/** 属性节点名称(核心为prpall，其他同理赔系统节点名称)（key）/节点名称(核心为prpall，其他同理赔系统节点名称)（key） */
	@Column(name = "NodeType")
	private String nodeType ;
	/** 属性必传的单证类型（key）/必传的单证类型（key） */
	@Column(name = "CertifyType")
	private String certifyType ;
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
}