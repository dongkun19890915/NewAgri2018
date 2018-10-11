package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 账户表-UtiIAccount   基础数据对象
 */
@Entity
@Table(name = "UtiIAccount")
@IdClass(UtiIAccountKey.class)
public class UtiIAccount implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性服务代码/ */
	private String svrCode ;
	/** 属性账号名称/ */
	private String accName ;
	/** 属性账号密码/ */
	private String passWord ;
	/** 属性用户代码/ */
	private String userCode ;
	/** 属性机构代码/ */
	private String comCode ;
	/** 属性用户名称/ */
	private String userName ;
	/** 属性原系统账号代码/ */
	private String fAccCode ;
	/** 属性服务名称/ */
	private String svrName ;
	/** 属性有效标志/ */
	private String validStatus ;
	/** 属性有效截止时间/ */
	private java.util.Date validEndDate ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性允许登录标志/ */
	private String loginPowerFlag ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性密码设定日期/ */
	private java.util.Date passwdSetDate ;
	/** 属性密码过期日期/ */
	private java.util.Date passwdExpireDate ;
	/** 属性账号代码/ */
	@Id
	@Column(name = "accCode")
	private String accCode ;
	/**
	 * 属性账号代码/的getter方法
	 */
	public String getAccCode() {
		return accCode;
	}
	/**
	 * 属性账号代码/的setter方法
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	/**
	 * 类UtiIAccount的默认构造方法
	 */
	public UtiIAccount() {
	}

	/**
	 * 属性服务代码/的getter方法
	 */
	public String getSvrCode() {
		return svrCode;
	}
	/**
	 * 属性服务代码/的setter方法
	 */
	public void setSvrCode(String svrCode) {
		this.svrCode = svrCode;
	} 
	/**
	 * 属性账号名称/的getter方法
	 */
	public String getAccName() {
		return accName;
	}
	/**
	 * 属性账号名称/的setter方法
	 */
	public void setAccName(String accName) {
		this.accName = accName;
	} 
	/**
	 * 属性账号密码/的getter方法
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * 属性账号密码/的setter方法
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	} 
	/**
	 * 属性用户代码/的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性用户代码/的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
	/**
	 * 属性机构代码/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性用户名称/的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性用户名称/的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	} 
	/**
	 * 属性原系统账号代码/的getter方法
	 */
	public String getFAccCode() {
		return fAccCode;
	}
	/**
	 * 属性原系统账号代码/的setter方法
	 */
	public void setFAccCode(String fAccCode) {
		this.fAccCode = fAccCode;
	} 
	/**
	 * 属性服务名称/的getter方法
	 */
	public String getSvrName() {
		return svrName;
	}
	/**
	 * 属性服务名称/的setter方法
	 */
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	} 
	/**
	 * 属性有效标志/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效标志/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性有效截止时间/的getter方法
	 */
	public java.util.Date getValidEndDate() {
		return validEndDate;
	}
	/**
	 * 属性有效截止时间/的setter方法
	 */
	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	} 
	/**
	 * 属性信息创建日期/的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性信息创建日期/的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	} 
	/**
	 * 属性最新更新操作日期/的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新更新操作日期/的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 
	/**
	 * 属性信息创建人员/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性信息创建人员/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性最新更新操作人员/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最新更新操作人员/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 
	/**
	 * 属性允许登录标志/的getter方法
	 */
	public String getLoginPowerFlag() {
		return loginPowerFlag;
	}
	/**
	 * 属性允许登录标志/的setter方法
	 */
	public void setLoginPowerFlag(String loginPowerFlag) {
		this.loginPowerFlag = loginPowerFlag;
	} 
	/**
	 * 属性标志字段/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
	/**
	 * 属性密码设定日期/的getter方法
	 */
	public java.util.Date getPasswdSetDate() {
		return passwdSetDate;
	}
	/**
	 * 属性密码设定日期/的setter方法
	 */
	public void setPasswdSetDate(java.util.Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	} 
	/**
	 * 属性密码过期日期/的getter方法
	 */
	public java.util.Date getPasswdExpireDate() {
		return passwdExpireDate;
	}
	/**
	 * 属性密码过期日期/的setter方法
	 */
	public void setPasswdExpireDate(java.util.Date passwdExpireDate) {
		this.passwdExpireDate = passwdExpireDate;
	} 
}