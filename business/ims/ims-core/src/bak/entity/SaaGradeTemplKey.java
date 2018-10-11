package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 岗位模板表-Saa_GradeTempl 主键操作类
 */
public class SaaGradeTemplKey extends BasePKImpl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性ID/ */
	@Id
	@Column(name = "id")
	private String iD ;
	/**
	 * 属性ID/的getter方法
	 */
	public String getID() {
		return iD;
	}
	/**
	 * 属性ID/的setter方法
	 */
	public void setID(String iD) {
		this.iD = iD;
	} 
}