package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 机构代码-PrpDCompany   基础数据对象
 */
@Entity
@Table(name = "prpdcompany")
@IdClass(PrpDCompanyKey.class)
public class PrpDCompany implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;


	/** 属性机构代码/ */
	@Id
	@Column(name = "comCode")
	private String comCode ;
	/** 属性机构名称/ */
	private String comCName ;
	/** 属性机构英文名称/ */
	private String comEName ;
	/** 属性是否总公司0-否1-是/ */
	private String isHeadOffice ;
	/** 属性最新机构代码/ */
	private String newComCode ;
	/** 属性联系地址/ */
	private String addressCName ;
	/** 属性地址英文名称/ */
	private String addressEName ;
	/** 属性邮编/ */
	private String postCode ;
	/** 属性服务电话/ */
	private String phoneNumber ;
	/** 属性传真/ */
	private String faxNumber ;
	/** 属性上级机构代码/ */
	private String upperComCode ;
	/** 属性网址/ */
	private String webSiteURL ;
	/** 属性证件类型/ */
	private String idType ;
	/** 属性组织机构代码证件号/ */
	private String organizationCode ;
	/** 属性税务登记证号/ */
	private String taxRegistCertiNo ;
	/** 属性营业执照号/ */
	private String businessLicenseNo ;
	/** 属性社会统一信用代码/ */
	private String unSocialCreditCode ;
	/** 属性归属保险公司名称/ */
	private String insurerName ;
	/** 属性机构类型01保险公司机构02 共保体机构/ */
	private String comType ;
	/** 属性经理/ */
	private String manager ;
	/** 属性会计/ */
	private String accountant ;
	/** 属性备注/ */
	private String remark ;
	/** 属性效力状态/ */
	private String validStatus ;
	/** 属性账户归属机构代码/ */
	private String acntUnit ;
	/** 属性专项代码/ */
	private String articleCode ;
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
	 * 类PrpDCompany的默认构造方法
	 */
	public PrpDCompany() {
	}

	/**
	 * 属性机构名称/的getter方法
	 */
	public String getComCName() {
		return comCName;
	}
	/**
	 * 属性机构名称/的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	} 
	/**
	 * 属性机构英文名称/的getter方法
	 */
	public String getComEName() {
		return comEName;
	}
	/**
	 * 属性机构英文名称/的setter方法
	 */
	public void setComEName(String comEName) {
		this.comEName = comEName;
	} 
	/**
	 * 属性是否总公司0-否1-是/的getter方法
	 */
	public String getIsHeadOffice() {
		return isHeadOffice;
	}
	/**
	 * 属性是否总公司0-否1-是/的setter方法
	 */
	public void setIsHeadOffice(String isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	} 
	/**
	 * 属性最新机构代码/的getter方法
	 */
	public String getNewComCode() {
		return newComCode;
	}
	/**
	 * 属性最新机构代码/的setter方法
	 */
	public void setNewComCode(String newComCode) {
		this.newComCode = newComCode;
	} 
	/**
	 * 属性联系地址/的getter方法
	 */
	public String getAddressCName() {
		return addressCName;
	}
	/**
	 * 属性联系地址/的setter方法
	 */
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	} 
	/**
	 * 属性地址英文名称/的getter方法
	 */
	public String getAddressEName() {
		return addressEName;
	}
	/**
	 * 属性地址英文名称/的setter方法
	 */
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	} 
	/**
	 * 属性邮编/的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮编/的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	} 
	/**
	 * 属性服务电话/的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性服务电话/的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 
	/**
	 * 属性传真/的getter方法
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * 属性传真/的setter方法
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	} 
	/**
	 * 属性上级机构代码/的getter方法
	 */
	public String getUpperComCode() {
		return upperComCode;
	}
	/**
	 * 属性上级机构代码/的setter方法
	 */
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	} 
	/**
	 * 属性网址/的getter方法
	 */
	public String getWebSiteURL() {
		return webSiteURL;
	}
	/**
	 * 属性网址/的setter方法
	 */
	public void setWebSiteURL(String webSiteURL) {
		this.webSiteURL = webSiteURL;
	} 
	/**
	 * 属性证件类型/的getter方法
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 属性证件类型/的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	} 
	/**
	 * 属性组织机构代码证件号/的getter方法
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 属性组织机构代码证件号/的setter方法
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	} 
	/**
	 * 属性税务登记证号/的getter方法
	 */
	public String getTaxRegistCertiNo() {
		return taxRegistCertiNo;
	}
	/**
	 * 属性税务登记证号/的setter方法
	 */
	public void setTaxRegistCertiNo(String taxRegistCertiNo) {
		this.taxRegistCertiNo = taxRegistCertiNo;
	} 
	/**
	 * 属性营业执照号/的getter方法
	 */
	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}
	/**
	 * 属性营业执照号/的setter方法
	 */
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	} 
	/**
	 * 属性社会统一信用代码/的getter方法
	 */
	public String getUnSocialCreditCode() {
		return unSocialCreditCode;
	}
	/**
	 * 属性社会统一信用代码/的setter方法
	 */
	public void setUnSocialCreditCode(String unSocialCreditCode) {
		this.unSocialCreditCode = unSocialCreditCode;
	} 
	/**
	 * 属性归属保险公司名称/的getter方法
	 */
	public String getInsurerName() {
		return insurerName;
	}
	/**
	 * 属性归属保险公司名称/的setter方法
	 */
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	} 
	/**
	 * 属性机构类型01保险公司机构02 共保体机构/的getter方法
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * 属性机构类型01保险公司机构02 共保体机构/的setter方法
	 */
	public void setComType(String comType) {
		this.comType = comType;
	} 
	/**
	 * 属性经理/的getter方法
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 属性经理/的setter方法
	 */
	public void setManager(String manager) {
		this.manager = manager;
	} 
	/**
	 * 属性会计/的getter方法
	 */
	public String getAccountant() {
		return accountant;
	}
	/**
	 * 属性会计/的setter方法
	 */
	public void setAccountant(String accountant) {
		this.accountant = accountant;
	} 
	/**
	 * 属性备注/的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性效力状态/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性账户归属机构代码/的getter方法
	 */
	public String getAcntUnit() {
		return acntUnit;
	}
	/**
	 * 属性账户归属机构代码/的setter方法
	 */
	public void setAcntUnit(String acntUnit) {
		this.acntUnit = acntUnit;
	} 
	/**
	 * 属性专项代码/的getter方法
	 */
	public String getArticleCode() {
		return articleCode;
	}
	/**
	 * 属性专项代码/的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
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

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
}