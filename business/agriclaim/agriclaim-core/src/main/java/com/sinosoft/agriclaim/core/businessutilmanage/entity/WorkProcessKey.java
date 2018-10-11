package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * 工作流程表主键操作对象
 */
public class WorkProcessKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public WorkProcessKey(){}
	public WorkProcessKey(Integer id,String registNo){
		this.id = id;
		this.registNo = registNo;
	}
	/** 属性主键/主键 */
	@Column(name = "id")
	private Integer id ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public Integer getId() {
    		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(Integer id) {
		this.id = id;
	} 
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