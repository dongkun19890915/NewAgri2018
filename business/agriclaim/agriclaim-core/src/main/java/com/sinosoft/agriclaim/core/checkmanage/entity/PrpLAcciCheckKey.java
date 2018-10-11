package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 意健险调查主表主键操作对象
 */
public class PrpLAcciCheckKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLAcciCheckKey(){}
	public PrpLAcciCheckKey(String checkNo){
		this.checkNo = checkNo;
	}
	/** 属性查勘序号/查勘序号 */
	@Column(name = "checkNo")
	private String checkNo ;
	/**
	 * 属性查勘序号/查勘序号的getter方法
	 */
	public String getCheckNo() {
    		return checkNo;
	}
	/**
	 * 属性查勘序号/查勘序号的setter方法
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	} 
}