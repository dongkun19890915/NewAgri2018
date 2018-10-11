package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预支付理赔表主键操作对象
 */
public class PrpLPrepayKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPrepayKey(){}
	public PrpLPrepayKey(String preCompensateNo){
		this.preCompensateNo = preCompensateNo;
	}
	/** 属性预赔号/预赔号 */
	@Column(name = "preCompensateNo")
	private String preCompensateNo ;
	/**
	 * 属性预赔号/预赔号的getter方法
	 */
	public String getPreCompensateNo() {
    		return preCompensateNo;
	}
	/**
	 * 属性预赔号/预赔号的setter方法
	 */
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	} 
}