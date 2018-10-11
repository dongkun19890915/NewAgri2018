package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 批改信息表主键操作对象
 */
public class PrpPaddressCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPaddressCopyKey(){}
	public PrpPaddressCopyKey(String endorseNo,Integer addressNo){
		this.endorseNo = endorseNo;
		this.addressNo = addressNo;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性地址序号/地址序号 */
	@Column(name = "addressNo")
	private Integer addressNo ;
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
	/**
	 * 属性地址序号/地址序号的getter方法
	 */
	public Integer getAddressNo() {
    		return addressNo;
	}
	/**
	 * 属性地址序号/地址序号的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	} 
}