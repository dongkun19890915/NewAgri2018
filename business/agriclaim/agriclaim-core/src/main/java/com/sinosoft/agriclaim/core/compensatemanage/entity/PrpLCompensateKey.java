package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算书表主键操作对象
 */
public class PrpLCompensateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCompensateKey(){}
	public PrpLCompensateKey(String compensateNo){
		this.compensateNo = compensateNo;
	}
	/** 属性赔款计算书号码/赔款计算书号码 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/**
	 * 属性赔款计算书号码/赔款计算书号码的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性赔款计算书号码/赔款计算书号码的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 
}