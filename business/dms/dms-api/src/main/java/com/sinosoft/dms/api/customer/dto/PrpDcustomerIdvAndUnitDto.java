package com.sinosoft.dms.api.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
public class PrpDcustomerIdvAndUnitDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 属性客户代码/客户代码  */
    private String customerCode ;
    /** 属性客户密码/客户密码 */
    private String password ;
    /** 属性速查索引码/速查索引码 */
    private String shorthandCode ;
    /** 属性客户中文名称/客户中文名称 */
    private String customerCName ;
    /** 属性客户英文名称/客户英文名称 */
    private String customerEName ;
    /** 属性地址中文名称/地址中文名称 */
    private String addressCName ;
    /** 属性地址英文名称/地址英文名称 */
    private String addressEName ;
    /** 属性证件类型/证件类型 */
    private String identifyType ;
    /** 属性证件号码 (U)/证件号码 (U) */
    private String identifyNumber ;
    /** 属性资信等级 (I)  A/B/C/D/资信等级 (I)  A/B/C/D */
    private String creditLevel ;
    /** 属性性别 /性别  */
    private String sex ;
    /** 属性年龄/年龄 */
    private Integer age ;
    /** 属性健康状况/健康状况 */
    private String health ;
    /** 属性职业代码/职业代码 */
    private String occupationCode ;
    /** 属性学历代码/学历代码 */
    private String educationCode ;
    /** 属性工作单位/工作单位 */
    private String unit ;
    /** 属性单位地址/单位地址 */
    private String unitAddress ;
    /** 属性客户类型/客户类型 */
    private String customerKind ;
    /** 属性客户标志(0:临时/1:正式)/客户标志(0:临时/1:正式) */
    private String customerFlag ;
    /** 属性电话/电话 */
    private String phoneNumber ;
    /** 属性传真/传真 */
    private String faxNumber ;
    /** 属性手机/手机 */
    private String mobile ;
    /** 属性通信地址/通信地址 */
    private String linkAddress ;
    /** 属性邮编/邮编 */
    private String postCode ;
    /** 属性呼机/呼机 */
    private String pager ;
    /** 属性E_mail信箱/E_mail信箱 */
    private String email ;
    /** 属性开户银行/开户银行 */
    private String bank ;
    /** 属性帐号/帐号 */
    private String account ;
    /** 属性死亡时间/死亡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deathDate ;
    /** 属性黑名单标志[1]:0:正常 1：黑名单/黑名单标志[1]:0:正常 1：黑名单 */
    private String blackState ;
    /** 属性新的客户代码/新的客户代码 */
    private String newCustomerCode ;
    /** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
    private String validStatus ;
    /** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
    private String articleCode ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性网址/网址 */
    private String netAddress ;
    /** 属性下级机构是否允许查看 1/是 0/否/下级机构是否允许查看 1/是 0/否 */
    private String lowerViewFlag ;
    /** 属性归属业务员代码/归属业务员代码 */
    private String handlerCode ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode ;
    /** 属性输入日期/输入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputDate ;
    /** 属性最后一次修改人/最后一次修改人 */
    private String updaterCode ;
    /** 属性归属机构代码/归属机构代码 */
    private String comCode ;
    /** 属性toplevelFlag/toplevelFlag */
    private String topLevelFlag ;
    /** 属性出生日期/出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthDate ;
    /** 属性风险等级/风险等级 */
    private String riskLevel ;
    /** 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息 */
    private String isCareClaim ;
    /** 属性行业现金密集程度/行业现金密集程度 */
    private String cashFocus ;
    /** 属性证件有效期限/证件有效期限 */
    private String validPeriod3 ;
    /** 属性职称/职称 */
    private String jobTitle ;
    /** 属性国籍/国籍 */
    private String nationality ;
    /** 属性vip标识/vip标识 */
    private String vipFlag ;
    /** 属性属性证型有效起期/属性证型有效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date certificadeStartDate ;
    /** 属性属性微信号/属性微信号 */
    private String wechatNo ;
    /** 属性属性证件有效止期/属性证件有效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date certificadeEndDate ;
    /** 属性修改人/修改人 */
    private String update_By ;
    /** 属性修改时间/修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date update_Date ;
    /** 属性公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他/公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他 */
    private String comType;
    /** 属性工商营业执照登记号/工商营业执照登记号 */
    private String businessLicenceNo ;
    /** 属性工商营业执照登记号有效期/工商营业执照登记号有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date businessLicenceValidPeriod ;
    /** 属性企业税务代码/企业税务代码 */
    private String revenueCode ;
    /** 属性税务登记有效期/税务登记有效期 */
    private String revenuePeriod ;
    /** 属性其他证件号码/其他证件号码 */
    private String otherCodeNo ;
    /** 属性其他证件有效期/其他证件有效期 */
    private String otherCodeValidPeriod ;
   /*修改人姓名*/
    private String  userName;
    public String getAddressCName() {
        return addressCName;
    }

    public void setAddressCName(String addressCName) {
        this.addressCName = addressCName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddressEName() {

        return addressEName;
    }

    public String getOrganizeCode() {
        return organizeCode;
    }

    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }

    /** 法人代码*/

  private String  organizeCode;
    public void setAddressEName(String addressEName) {
        this.addressEName = addressEName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBlackState() {
        return blackState;
    }

    public void setBlackState(String blackState) {
        this.blackState = blackState;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCashFocus() {
        return cashFocus;
    }

    public void setCashFocus(String cashFocus) {
        this.cashFocus = cashFocus;
    }

    public Date getCertificadeStartDate() {
        return certificadeStartDate;
    }

    public void setCertificadeStartDate(Date certificadeStartDate) {
        this.certificadeStartDate = certificadeStartDate;
    }

    public Date getCertificadeEndDate() {
        return certificadeEndDate;
    }

    public void setCertificadeEndDate(Date certificadeEndDate) {
        this.certificadeEndDate = certificadeEndDate;
    }

    public String getBusinessLicenceNo() {
        return businessLicenceNo;
    }

    public void setBusinessLicenceNo(String businessLicenceNo) {
        this.businessLicenceNo = businessLicenceNo;
    }

    public Date getBusinessLicenceValidPeriod() {
        return businessLicenceValidPeriod;
    }

    public void setBusinessLicenceValidPeriod(Date businessLicenceValidPeriod) {
        this.businessLicenceValidPeriod = businessLicenceValidPeriod;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShorthandCode() {
        return shorthandCode;
    }

    public void setShorthandCode(String shorthandCode) {
        this.shorthandCode = shorthandCode;
    }

    public String getCustomerCName() {
        return customerCName;
    }

    public void setCustomerCName(String customerCName) {
        this.customerCName = customerCName;
    }

    public String getCustomerEName() {
        return customerEName;
    }

    public void setCustomerEName(String customerEName) {
        this.customerEName = customerEName;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getCustomerKind() {
        return customerKind;
    }

    public void setCustomerKind(String customerKind) {
        this.customerKind = customerKind;
    }

    public String getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(String customerFlag) {
        this.customerFlag = customerFlag;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getNewCustomerCode() {
        return newCustomerCode;
    }

    public void setNewCustomerCode(String newCustomerCode) {
        this.newCustomerCode = newCustomerCode;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(String netAddress) {
        this.netAddress = netAddress;
    }

    public String getLowerViewFlag() {
        return lowerViewFlag;
    }

    public void setLowerViewFlag(String lowerViewFlag) {
        this.lowerViewFlag = lowerViewFlag;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getUpdaterCode() {
        return updaterCode;
    }

    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getTopLevelFlag() {
        return topLevelFlag;
    }

    public void setTopLevelFlag(String topLevelFlag) {
        this.topLevelFlag = topLevelFlag;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getIsCareClaim() {
        return isCareClaim;
    }

    public void setIsCareClaim(String isCareClaim) {
        this.isCareClaim = isCareClaim;
    }

    public String getValidPeriod3() {
        return validPeriod3;
    }

    public void setValidPeriod3(String validPeriod3) {
        this.validPeriod3 = validPeriod3;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(String revenueCode) {
        this.revenueCode = revenueCode;
    }

    public String getRevenuePeriod() {
        return revenuePeriod;
    }

    public void setRevenuePeriod(String revenuePeriod) {
        this.revenuePeriod = revenuePeriod;
    }

    public String getOtherCodeNo() {
        return otherCodeNo;
    }

    public void setOtherCodeNo(String otherCodeNo) {
        this.otherCodeNo = otherCodeNo;
    }

    public String getOtherCodeValidPeriod() {
        return otherCodeValidPeriod;
    }

    public void setOtherCodeValidPeriod(String otherCodeValidPeriod) {
        this.otherCodeValidPeriod = otherCodeValidPeriod;
    }



}
