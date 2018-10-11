package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:50:26.122 
 * 回访工作流表主键操作对象
 */
public class PrplReturnVisitSwflogKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrplReturnVisitSwflogKey(){}
	public PrplReturnVisitSwflogKey(String businessNo,String nodeType){
		this.businessNo = businessNo;
		this.nodeType = nodeType;
	}
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性节点/节点 */
	@Column(name = "nodeType")
	private String nodeType ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
    		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 
	/**
	 * 属性节点/节点的getter方法
	 */
	public String getNodeType() {
    		return nodeType;
	}
	/**
	 * 属性节点/节点的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 
}