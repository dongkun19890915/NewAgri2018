package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 用户权限表实体操作对象
 */
@Entity
@Table(name = "UtiUserGrade")
@IdClass(UtiUserGradeKey.class)
public class UtiUserGrade extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性归属机构代码/归属机构代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性员工代码/员工代码 */
        @Id
        @Column(name = "userCode")
	private String userCode ;/** 属性岗位代码/岗位代码 */
        @Id
        @Column(name = "gradeCode")
	private String gradeCode ;	



	/** 属性失效日期/失效日期 */
	private Date invalidDate ;
	/** 属性效力状态/效力状态 */
	private String validStatus ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;


	/**
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
	/**
	 * 属性岗位代码/岗位代码的getter方法
	 */
	public String getGradeCode() {
		return gradeCode;
	}
	/**
	 * 属性岗位代码/岗位代码的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	} 	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	} 	
	/**
	 * 属性效力状态/效力状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态/效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

}