package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 服务表-UtiISvr   基础数据对象
 */
@Entity
@Table(name = "UtiISvr")
@IdClass(UtiISvrKey.class)
public class UtiISvr implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性服务名称/ */
	private String svrName ;
	/** 属性Web应用名称/ */
	private String webName ;
	/** 属性省集中代码/ */
	private String companyCode ;
	/** 属性省集中服务代码/ */
	private String svrCodeInCompany ;
	/** 属性服务IP/ */
	private String svrIP ;
	/** 属性服务端口号/ */
	private String svrPort ;
	/** 属性服务分类/ */
	private String svrType ;
	/** 属性服务优先级别/ */
	private String svrPriority ;
	/** 属性服务认证方式/ */
	private String svrLoginMethod ;
	/** 属性管理权限状态/ */
	private String manageRightStatus ;
	/** 属性管理菜单状态/ */
	private String manageMenuStatus ;
	/** 属性使用平台管理状态/ */
	private String manageLoginStatus ;
	/** 属性账户受管状态/ */
	private String manageAccStatus ;
	/** 属性账户同步状态/ */
	private String accSyncStatus ;
	/** 属性账户信息同步状态/ */
	private String accMsgSyncStatus ;
	/** 属性使用账户登录状态/ */
	private String accLoginStatus ;
	/** 属性有效状态/ */
	private String validStatus ;
	/** 属性有效终止时间/ */
	private java.util.Date validEndDate ;
	/** 属性系统对应工具库/ */
	private String utilitySvrCode ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/**
	 * 属性服务代码/
	 */
	@Id
	@Column(name = "svrCode")
	private String svrCode;

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
	 * 类UtiISvr的默认构造方法
	 */
	public UtiISvr() {
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
	 * 属性Web应用名称/的getter方法
	 */
	public String getWebName() {
		return webName;
	}
	/**
	 * 属性Web应用名称/的setter方法
	 */
	public void setWebName(String webName) {
		this.webName = webName;
	} 
	/**
	 * 属性省集中代码/的getter方法
	 */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
	 * 属性省集中代码/的setter方法
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	} 
	/**
	 * 属性省集中服务代码/的getter方法
	 */
	public String getSvrCodeInCompany() {
		return svrCodeInCompany;
	}
	/**
	 * 属性省集中服务代码/的setter方法
	 */
	public void setSvrCodeInCompany(String svrCodeInCompany) {
		this.svrCodeInCompany = svrCodeInCompany;
	} 
	/**
	 * 属性服务IP/的getter方法
	 */
	public String getSvrIP() {
		return svrIP;
	}
	/**
	 * 属性服务IP/的setter方法
	 */
	public void setSvrIP(String svrIP) {
		this.svrIP = svrIP;
	} 
	/**
	 * 属性服务端口号/的getter方法
	 */
	public String getSvrPort() {
		return svrPort;
	}
	/**
	 * 属性服务端口号/的setter方法
	 */
	public void setSvrPort(String svrPort) {
		this.svrPort = svrPort;
	} 
	/**
	 * 属性服务分类/的getter方法
	 */
	public String getSvrType() {
		return svrType;
	}
	/**
	 * 属性服务分类/的setter方法
	 */
	public void setSvrType(String svrType) {
		this.svrType = svrType;
	} 
	/**
	 * 属性服务优先级别/的getter方法
	 */
	public String getSvrPriority() {
		return svrPriority;
	}
	/**
	 * 属性服务优先级别/的setter方法
	 */
	public void setSvrPriority(String svrPriority) {
		this.svrPriority = svrPriority;
	} 
	/**
	 * 属性服务认证方式/的getter方法
	 */
	public String getSvrLoginMethod() {
		return svrLoginMethod;
	}
	/**
	 * 属性服务认证方式/的setter方法
	 */
	public void setSvrLoginMethod(String svrLoginMethod) {
		this.svrLoginMethod = svrLoginMethod;
	} 
	/**
	 * 属性管理权限状态/的getter方法
	 */
	public String getManageRightStatus() {
		return manageRightStatus;
	}
	/**
	 * 属性管理权限状态/的setter方法
	 */
	public void setManageRightStatus(String manageRightStatus) {
		this.manageRightStatus = manageRightStatus;
	} 
	/**
	 * 属性管理菜单状态/的getter方法
	 */
	public String getManageMenuStatus() {
		return manageMenuStatus;
	}
	/**
	 * 属性管理菜单状态/的setter方法
	 */
	public void setManageMenuStatus(String manageMenuStatus) {
		this.manageMenuStatus = manageMenuStatus;
	} 
	/**
	 * 属性使用平台管理状态/的getter方法
	 */
	public String getManageLoginStatus() {
		return manageLoginStatus;
	}
	/**
	 * 属性使用平台管理状态/的setter方法
	 */
	public void setManageLoginStatus(String manageLoginStatus) {
		this.manageLoginStatus = manageLoginStatus;
	} 
	/**
	 * 属性账户受管状态/的getter方法
	 */
	public String getManageAccStatus() {
		return manageAccStatus;
	}
	/**
	 * 属性账户受管状态/的setter方法
	 */
	public void setManageAccStatus(String manageAccStatus) {
		this.manageAccStatus = manageAccStatus;
	} 
	/**
	 * 属性账户同步状态/的getter方法
	 */
	public String getAccSyncStatus() {
		return accSyncStatus;
	}
	/**
	 * 属性账户同步状态/的setter方法
	 */
	public void setAccSyncStatus(String accSyncStatus) {
		this.accSyncStatus = accSyncStatus;
	} 
	/**
	 * 属性账户信息同步状态/的getter方法
	 */
	public String getAccMsgSyncStatus() {
		return accMsgSyncStatus;
	}
	/**
	 * 属性账户信息同步状态/的setter方法
	 */
	public void setAccMsgSyncStatus(String accMsgSyncStatus) {
		this.accMsgSyncStatus = accMsgSyncStatus;
	} 
	/**
	 * 属性使用账户登录状态/的getter方法
	 */
	public String getAccLoginStatus() {
		return accLoginStatus;
	}
	/**
	 * 属性使用账户登录状态/的setter方法
	 */
	public void setAccLoginStatus(String accLoginStatus) {
		this.accLoginStatus = accLoginStatus;
	} 
	/**
	 * 属性有效状态/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效状态/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性有效终止时间/的getter方法
	 */
	public java.util.Date getValidEndDate() {
		return validEndDate;
	}
	/**
	 * 属性有效终止时间/的setter方法
	 */
	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	} 
	/**
	 * 属性系统对应工具库/的getter方法
	 */
	public String getUtilitySvrCode() {
		return utilitySvrCode;
	}
	/**
	 * 属性系统对应工具库/的setter方法
	 */
	public void setUtilitySvrCode(String utilitySvrCode) {
		this.utilitySvrCode = utilitySvrCode;
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
}