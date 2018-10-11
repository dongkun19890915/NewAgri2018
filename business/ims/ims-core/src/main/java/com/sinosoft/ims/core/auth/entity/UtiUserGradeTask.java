package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 机构员工岗位差异功能权限表实体操作对象
 */
@Entity
@Table(name = "UtiUserGradeTask")
@IdClass(UtiUserGradeTaskKey.class)
public class UtiUserGradeTask extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性归属机构代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性员工代码 */
        @Id
        @Column(name = "userCode")
	private String userCode ;/** 属性岗位代码 */
        @Id
        @Column(name = "gradeCode")
	private String gradeCode ;/** 属性功能代码 */
        @Id
        @Column(name = "taskCode")
	private String taskCode ;	




	/** 属性权限级别 */
	private String grantLevel ;
	/** 属性权限值 */
	private String grantValue ;
	/** 属性权限值 */
	private String value ;
	/** 属性备注 */
	private String remark ;
	/** 属性标志字段 */
	private String flag ;
	/**
	 * 属性归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性员工代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
	/**
	 * 属性岗位代码的getter方法
	 */
	public String getGradeCode() {
		return gradeCode;
	}
	/**
	 * 属性岗位代码的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	} 
	/**
	 * 属性功能代码的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性功能代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 
	/**
	 * 属性权限级别的getter方法
	 */
	public String getGrantLevel() {
		return grantLevel;
	}
	/**
	 * 属性权限级别的setter方法
	 */
	public void setGrantLevel(String grantLevel) {
		this.grantLevel = grantLevel;
	} 
	/**
	 * 属性权限值的getter方法
	 */
	public String getGrantValue() {
		return grantValue;
	}
	/**
	 * 属性权限值的setter方法
	 */
	public void setGrantValue(String grantValue) {
		this.grantValue = grantValue;
	} 
	/**
	 * 属性权限值的getter方法
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 属性权限值的setter方法
	 */
	public void setValue(String value) {
		this.value = value;
	} 
	/**
	 * 属性备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
}