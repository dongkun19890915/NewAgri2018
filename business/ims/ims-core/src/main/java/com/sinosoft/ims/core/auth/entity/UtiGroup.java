package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiGroup实体操作对象
 */
@Entity
@Table(name = "UtiGroup")
@IdClass(UtiGroupKey.class)
public class UtiGroup extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性groupCode/groupCode */
	@Id
	@Column(name = "groupCode")
	private String groupCode ;	

	/** 属性groupName/groupName */
	@Column(name = "groupName")
	private String groupName ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性groupCode/groupCode的getter方法
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * 属性groupCode/groupCode的setter方法
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	} 	
	/**
	 * 属性groupName/groupName的getter方法
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 属性groupName/groupName的setter方法
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
}