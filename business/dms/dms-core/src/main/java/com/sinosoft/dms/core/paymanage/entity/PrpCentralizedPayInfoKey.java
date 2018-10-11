package com.sinosoft.dms.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 08:39:47.289 
 * PrpCentralizedPayInfo主键操作对象
 */
public class PrpCentralizedPayInfoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCentralizedPayInfoKey(){}
	public PrpCentralizedPayInfoKey(String operateId){
		this.operateId = operateId;
	}
	/** 属性operateid/operateid */
	@Column(name = "operateId")
	private String operateId ;
	/**
	 * 属性operateid/operateid的getter方法
	 */
	public String getOperateId() {
    		return operateId;
	}
	/**
	 * 属性operateid/operateid的setter方法
	 */
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	} 
}