package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 处理意见表主键操作对象
 */
public class PrpLverifyLossExtKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLverifyLossExtKey(){}
	public PrpLverifyLossExtKey(String registNo){
		this.registNo = registNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "RegistNo")
	private String registNo ;
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
}