package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 08:22:16.508 
 * 贷款保险保单信息主键操作对象
 */
public class PrpPmainLoanKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPmainLoanKey(){}
	public PrpPmainLoanKey(String endorseNo){
		this.endorseNo = endorseNo;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 
}