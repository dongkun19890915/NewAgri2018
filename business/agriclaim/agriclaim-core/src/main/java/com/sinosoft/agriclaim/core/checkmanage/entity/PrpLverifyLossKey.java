package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 定核损主表主键操作对象
 */
public class PrpLverifyLossKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLverifyLossKey(){}
	public PrpLverifyLossKey(String registNo,String lossItemCode){
		this.registNo = registNo;
		this.lossItemCode = lossItemCode;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "RegistNo")
	private String registNo ;
	/** 属性标的序号/标的序号 */
	@Column(name = "LossItemCode")
	private String lossItemCode ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getLossItemCode() {
    		return lossItemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 
}