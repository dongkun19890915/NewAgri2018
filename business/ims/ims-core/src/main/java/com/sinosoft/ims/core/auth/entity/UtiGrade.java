package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiGrade实体操作对象
 */
@Entity
@Table(name = "UtiGrade")
@IdClass(UtiGradeKey.class)
public class UtiGrade extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性gradeCode/gradeCode */
	@Id
	@Column(name = "gradeCode")
	private String gradeCode ;	

	/** 属性gradeName/gradeName */
	@Column(name = "gradeName")
	private String gradeName ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性gradeLevel/gradeLevel */
	@Column(name = "gradeLevel")
	private String gradeLevel ;
	/**
	 * 属性gradeCode/gradeCode的getter方法
	 */
	public String getGradeCode() {
		return gradeCode;
	}
	/**
	 * 属性gradeCode/gradeCode的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	} 	
	/**
	 * 属性gradeName/gradeName的getter方法
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * 属性gradeName/gradeName的setter方法
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性gradeLevel/gradeLevel的getter方法
	 */
	public String getGradeLevel() {
		return gradeLevel;
	}
	/**
	 * 属性gradeLevel/gradeLevel的setter方法
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	} 	
}