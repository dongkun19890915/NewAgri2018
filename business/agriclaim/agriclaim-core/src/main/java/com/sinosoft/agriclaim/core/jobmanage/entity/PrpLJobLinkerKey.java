package com.sinosoft.agriclaim.core.jobmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 联系人主键操作对象
 */
public class PrpLJobLinkerKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLJobLinkerKey(){}
	public PrpLJobLinkerKey(String staffId){
		this.staffId = staffId;
	}
	/** 属性主键/主键 */
	@Column(name = "staffId")
	private String staffId ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public String getStaffId() {
    		return staffId;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	} 
}