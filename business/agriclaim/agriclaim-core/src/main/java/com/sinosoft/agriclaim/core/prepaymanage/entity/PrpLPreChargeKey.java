package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预赔费用信息表主键操作对象
 */
public class PrpLPreChargeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPreChargeKey(){}
	public PrpLPreChargeKey(String precompensateNo){
		this.precompensateNo = precompensateNo;
	}
	public PrpLPreChargeKey(java.lang.Integer serialNo){
		this.serialNo = serialNo;
	}
	/** 属性id主键/id主键 */
	@Column(name = "precompensateNo")
	private String precompensateNo ;
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;

	public String getPrecompensateNo() {
		return precompensateNo;
	}

	public void setPrecompensateNo(String precompensateNo) {
		this.precompensateNo = precompensateNo;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
}