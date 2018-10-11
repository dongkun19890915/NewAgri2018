package com.sinosoft.ims.api.kernel.dto;


import com.sinosoft.framework.dto.BaseDto;

public class PrpDCompanyDto extends BaseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性ComCode/ 机构代码 */
	private String comCode ;
	/** 属性ComCName/机构名称 */
	private String comCName ;
	/** 属性ComEName/机构英文名称 */
	private String comEName ;
	/** 属性IsHeadOffice/是否总公司 0-否 1-是 */
	private String isHeadOffice ;
	/** 属性AddressCName/联系地址 */
	private String addressCName ;
	/** 属性AddressEName/地址英文名称 */
	private String addressEName ;
	/** 属性PostCode/ 邮编 */
	private String postCode ;
	/** 属性PhoneNumber/服务电话 */
	private String phoneNumber ;
	/** 属性FaxNumber/传真 */
	private String faxNumber ;
	/** 属性UpperComCode/上级机构代码 */
	private String upperComCode ;
	/** 属性Url/网址 */
	private String webSiteURL ;
	/** 属性OrganizationCode/ 组织机构代码证件号 */
	private String organizationCode ;
	/** 属性TaxRegistCertiNo/税务登记证号 */
	private String taxRegistCertiNo ;
	/** 属性BusinessLicenseNo/营业执照号 */
	private String businessLicenseNo ;
	/** 属性UnSocialCreditCode/社会统一信用代码 */
	private String unSocialCreditCode ;
	/** 属性InsurerName/归属保险公司名称 */
	private String insurerName ;
	/** 属性ComType/机构类型(出单/归属/收付) */
	private String comType ;
	/** 属性Manager/ 经理 */
	private String manager ;
	/** 属性Accountant/会计 */
	private String accountant ;
	/** 属性Remark/备注 */
	private String remark ;
	/** 属性NewComCode/最新更新操作人员 */
	private String newComCode ;
	/** 属性ValidStatus/效力状态(0失效/1有效) */
	private String validStatus ;
	/** 属性AcntUnit/账户归属机构代码 */
	private String acntUnit ;
	/** 属性ArticleCode/专项代码(对应会计科目) */
	private String articleCode ;
	/** 属性IdType/证件类型 */
	private String idType ;
	/** 属性Flag/标志字段 */
	private String flag ;
	
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComCName() {
		return comCName;
	}
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
	public String getComEName() {
		return comEName;
	}
	public void setComEName(String comEName) {
		this.comEName = comEName;
	}
	public String getIsHeadOffice() {
		return isHeadOffice;
	}
	public void setIsHeadOffice(String isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	}
	public String getAddressCName() {
		return addressCName;
	}
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}
	public String getAddressEName() {
		return addressEName;
	}
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getUpperComCode() {
		return upperComCode;
	}
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}
    public String getWebSiteURL()
    {
        return webSiteURL;
    }
    public void setWebSiteURL(String webSiteURL)
    {
        this.webSiteURL = webSiteURL;
    }
    public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getTaxRegistCertiNo() {
		return taxRegistCertiNo;
	}
	public void setTaxRegistCertiNo(String taxRegistCertiNo) {
		this.taxRegistCertiNo = taxRegistCertiNo;
	}
	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	public String getUnSocialCreditCode() {
		return unSocialCreditCode;
	}
	public void setUnSocialCreditCode(String unSocialCreditCode) {
		this.unSocialCreditCode = unSocialCreditCode;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAccountant() {
		return accountant;
	}
	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNewComCode() {
		return newComCode;
	}
	public void setNewComCode(String newComCode) {
		this.newComCode = newComCode;
	}
	public String getValidStatus() {
		return validStatus;
	}
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	public String getAcntUnit() {
		return acntUnit;
	}
	public void setAcntUnit(String acntUnit) {
		this.acntUnit = acntUnit;
	}
	public String getArticleCode() {
		return articleCode;
	}
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	}
	
	
	

