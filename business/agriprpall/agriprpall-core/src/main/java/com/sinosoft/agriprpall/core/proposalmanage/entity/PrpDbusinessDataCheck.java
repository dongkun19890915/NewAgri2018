package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 * 业务数据检查表实体操作对象
 */
@Entity
@Table(name = "PrpDbusinessDataCheck")
@IdClass(PrpDbusinessDataCheckKey.class)
public class PrpDbusinessDataCheck extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	@Id
	@Column(name = "id")
	private String id;
	/** 属性检查日期/检查日期 */
	@Column(name = "CheckDate")
	private Date checkDate ;
	/** 属性标题/标题 */
	@Column(name = "Title")
	private String title ;
	/** 属性备注/备注 */
	@Column(name = "Remark")
	private String remark ;
	/** 属性错误信息/错误信息 */
	@Column(name = "StackTrace")
	private String stackTrace ;

	/**
	 * 属性检查日期/检查日期的getter方法
	 */
	public Date getCheckDate() {
		return checkDate;
	}
	/**
	 * 属性检查日期/检查日期的setter方法
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	} 	
	/**
	 * 属性标题/标题的getter方法
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 属性标题/标题的setter方法
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * 属性错误信息/错误信息的getter方法
	 */
	public String getStackTrace() {
		return stackTrace;
	}
	/**
	 * 属性错误信息/错误信息的setter方法
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 	
}