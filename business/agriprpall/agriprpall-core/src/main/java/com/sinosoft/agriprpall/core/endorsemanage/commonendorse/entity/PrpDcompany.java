package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703
 * 机构代码表实体操作对象
 */
@Entity
@Table(name = "PrpDcompany")
@IdClass(PrpDcompanyKey.class)
public class PrpDcompany extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /** 属性机构代码/机构代码 */
    @Id
    @Column(name = "comCode")
    private String comCode ;

    /** 属性机构中文名称/机构中文名称 */
    @Column(name = "comCName")
    private String comCName ;
    /** 属性机构英文名称/机构英文名称 */
    @Column(name = "comEName")
    private String comEName ;
    /** 属性地址中文名称/地址中文名称 */
    @Column(name = "addressCName")
    private String addressCName ;
    /** 属性地址英文名称/地址英文名称 */
    @Column(name = "addressEName")
    private String addressEName ;
    /** 属性邮编/邮编 */
    @Column(name = "postCode")
    private String postCode ;
    /** 属性客服服务电话(商业险)/客服服务电话(商业险) */
    @Column(name = "phoneNumber")
    private String phoneNumber ;
    /** 属性taxNumber/taxNumber */
    @Column(name = "taxNumber")
    private String taxNumber ;
    /** 属性传真/传真 */
    @Column(name = "faxNumber")
    private String faxNumber ;
    /** 属性upperComCode/upperComCode */
    @Column(name = "upperComCode")
    private String upperComCode ;
    /** 属性insurerName/insurerName */
    @Column(name = "insurerName")
    private String insurerName ;
    /** 属性comAttribute/comAttribute */
    @Column(name = "comAttribute")
    private String comAttribute ;
    /** 属性机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构/机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构 */
    @Column(name = "comType")
    private String comType ;
    /** 属性机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点/机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点 */
    @Column(name = "comLevel")
    private String comLevel ;
    /** 属性manager/manager */
    @Column(name = "manager")
    private String manager ;
    /** 属性上级机构代码/上级机构代码 */
    @Column(name = "accountLeader")
    private String accountLeader ;
    /** 属性cashier/cashier */
    @Column(name = "cashier")
    private String cashier ;
    /** 属性accountant/accountant */
    @Column(name = "accountant")
    private String accountant ;
    /** 属性remark/remark */
    @Column(name = "remark")
    private String remark ;
    /** 属性newComCode/newComCode */
    @Column(name = "newComCode")
    private String newComCode ;
    /** 属性validStatus/validStatus */
    @Column(name = "validStatus")
    private String validStatus ;
    /** 属性acntUnit/acntUnit */
    @Column(name = "acntUnit")
    private String acntUnit ;
    /** 属性articleCode/articleCode */
    @Column(name = "articleCode")
    private String articleCode ;
    /** 属性accCode/accCode */
    @Column(name = "accCode")
    private String accCode ;
    /** 属性核算单位标志：1核算单位 2基层单位 3 核算部门/核算单位标志：1核算单位 2基层单位 3 核算部门 */
    @Column(name = "centerFlag")
    private String centerFlag ;
    /** 属性outerPayCode/outerPayCode */
    @Column(name = "outerPayCode")
    private String outerPayCode ;
    /** 属性innerPayCode/innerPayCode */
    @Column(name = "innerPayCode")
    private String innerPayCode ;
    /** 属性[0]:0:非政策性农险机构 1:政策性农险机构/[0]:0:非政策性农险机构 1:政策性农险机构 */
    @Column(name = "flag")
    private String flag ;
    /** 属性webAddress/webAddress */
    @Column(name = "webAddress")
    private String webAddress ;
    /** 属性商业险报案电话(交强)/商业险报案电话(交强) */
    @Column(name = "servicePhone")
    private String servicePhone ;
    /** 属性农业险报案电话/农业险报案电话 */
    @Column(name = "reportPhone")
    private String reportPhone ;
    /** 属性agentCode/agentCode */
    @Column(name = "agentCode")
    private String agentCode ;
    /** 属性agreementNo/agreementNo */
    @Column(name = "agreementNo")
    private String agreementNo ;
    /** 属性sysAreaCode/sysAreaCode */
    @Column(name = "sysAreaCode")
    private String sysAreaCode ;
    /** 属性公司类别标志（理赔1，非理赔2，公估3）/公司类别标志（理赔1，非理赔2，公估3） */
    @Column(name = "companyFlag")
    private String companyFlag ;
    /** 属性shortComCname/shortComCname */
    @Column(name = "shortComCName")
    private String shortComCName ;
    /** 属性serviceFlag/serviceFlag */
    @Column(name = "serviceFlag")
    private String serviceFlag ;
    /** 属性平台子系统机构代码/平台子系统机构代码 */
    @Column(name = "daaPlatformComCode")
    private String daaPlatformComCode ;
    /** 属性specLevelFlag/specLevelFlag */
    @Column(name = "specLevelFlag")
    private String specLevelFlag ;
    /** 属性normLevel/normLevel */
    @Column(name = "normLevel")
    private String normLevel ;
    /** 属性specLevel/specLevel */
    @Column(name = "specLevel")
    private String specLevel ;
    /** 属性业务来源/业务来源 */
    @Column(name = "businessNature")
    private String businessNature ;
    /** 属性出单机构IP/出单机构IP */
    @Column(name = "ipSegment")
    private String ipSegment ;
    /** 属性出单机构数字证书/出单机构数字证书 */
    @Column(name = "usbKey")
    private String usbKey ;
    /** 属性是否注销标志 1：未注销/是否注销标志 1：未注销 */
    @Column(name = "cancelFlag")
    private String cancelFlag ;
    /** 属性分支机构类型/分支机构类型 */
    @Column(name = "branchType")
    private String branchType ;
    /** 属性机构代码1/机构代码1 */
    @Column(name = "comCodeCirc")
    private String comCodeCirc ;
    /** 属性机构标识/机构标识 */
    @Column(name = "comFlag")
    private String comFlag ;
    /** 属性机构类别/机构类别 */
    @Column(name = "comKind")
    private String comKind ;
    /** 属性邮箱/邮箱 */
    @Column(name = "email")
    private String email ;
    /** 属性机构团队业务来源/机构团队业务来源 */
    @Column(name = "groupNatureDetail")
    private String groupNatureDetail ;
    /** 属性无效日期/无效日期 */
    @Column(name = "invalidDate")
    private Date invalidDate ;
    /** 属性车牌号/车牌号 */
    @Column(name = "licenseNo")
    private String licenseNo ;
    /** 属性操作员机构代码/操作员机构代码 */
    @Column(name = "operatorComCode")
    private String operatorComCode ;
    /** 属性更新日期/更新日期 */
    @Column(name = "updateDate")
    private Date updateDate ;
    /** 属性更新标识/更新标识 */
    @Column(name = "updateFlag")
    private String updateFlag ;
    /** 属性上级机构路径/上级机构路径 */
    @Column(name = "upperPath")
    private String upperPath ;
    /** 属性有效日期/有效日期 */
    @Column(name = "validDate")
    private Date validDate ;
    /** 属性marketType/marketType */
    @Column(name = "marketType")
    private String marketType ;
    /** 属性upperylComCode/upperylComCode */
    @Column(name = "upperylComCode")
    private String upperylComCode ;
    /** 属性修改人/修改人 */
    @Column(name = "update_By")
    private String update_By ;
    /** 属性修改时间/修改时间 */
    @Column(name = "update_Date")
    private Date update_Date ;
    /** 属性纳税人识别号/纳税人识别号 */
    @Column(name = "buyDentiCode")
    private String buyDentiCode ;
    /** 属性核算单位接收部门，顺序财务部-总经理室-综合部/核算单位接收部门，顺序财务部-总经理室-综合部 */
    @Column(name = "receiveComCode")
    private String receiveComCode ;
    /** 属性是否理赔中心，1-是/是否理赔中心，1-是 */
    @Column(name = "claimFlag")
    private String claimFlag ;
    /** 属性保单归属地-地市代码/保单归属地-地市代码 */
    @Column(name = "cityCode")
    private String cityCode ;
    /** 属性保单归属地-县区代码/保单归属地-县区代码 */
    @Column(name = "countyCode")
    private String countyCode ;
    /** 属性updateBy/updateBy */
    @Column(name = "updateBy")
    private String updateBy ;
    /**
     * 属性机构代码/机构代码的getter方法
     */
    public String getComCode() {
        return comCode;
    }
    /**
     * 属性机构代码/机构代码的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
    /**
     * 属性机构中文名称/机构中文名称的getter方法
     */
    public String getComCName() {
        return comCName;
    }
    /**
     * 属性机构中文名称/机构中文名称的setter方法
     */
    public void setComCName(String comCName) {
        this.comCName = comCName;
    }
    /**
     * 属性机构英文名称/机构英文名称的getter方法
     */
    public String getComEName() {
        return comEName;
    }
    /**
     * 属性机构英文名称/机构英文名称的setter方法
     */
    public void setComEName(String comEName) {
        this.comEName = comEName;
    }
    /**
     * 属性地址中文名称/地址中文名称的getter方法
     */
    public String getAddressCName() {
        return addressCName;
    }
    /**
     * 属性地址中文名称/地址中文名称的setter方法
     */
    public void setAddressCName(String addressCName) {
        this.addressCName = addressCName;
    }
    /**
     * 属性地址英文名称/地址英文名称的getter方法
     */
    public String getAddressEName() {
        return addressEName;
    }
    /**
     * 属性地址英文名称/地址英文名称的setter方法
     */
    public void setAddressEName(String addressEName) {
        this.addressEName = addressEName;
    }
    /**
     * 属性邮编/邮编的getter方法
     */
    public String getPostCode() {
        return postCode;
    }
    /**
     * 属性邮编/邮编的setter方法
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    /**
     * 属性客服服务电话(商业险)/客服服务电话(商业险)的getter方法
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * 属性客服服务电话(商业险)/客服服务电话(商业险)的setter方法
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * 属性taxNumber/taxNumber的getter方法
     */
    public String getTaxNumber() {
        return taxNumber;
    }
    /**
     * 属性taxNumber/taxNumber的setter方法
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
    /**
     * 属性传真/传真的getter方法
     */
    public String getFaxNumber() {
        return faxNumber;
    }
    /**
     * 属性传真/传真的setter方法
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    /**
     * 属性upperComCode/upperComCode的getter方法
     */
    public String getUpperComCode() {
        return upperComCode;
    }
    /**
     * 属性upperComCode/upperComCode的setter方法
     */
    public void setUpperComCode(String upperComCode) {
        this.upperComCode = upperComCode;
    }
    /**
     * 属性insurerName/insurerName的getter方法
     */
    public String getInsurerName() {
        return insurerName;
    }
    /**
     * 属性insurerName/insurerName的setter方法
     */
    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }
    /**
     * 属性comAttribute/comAttribute的getter方法
     */
    public String getComAttribute() {
        return comAttribute;
    }
    /**
     * 属性comAttribute/comAttribute的setter方法
     */
    public void setComAttribute(String comAttribute) {
        this.comAttribute = comAttribute;
    }
    /**
     * 属性机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构/机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构的getter方法
     */
    public String getComType() {
        return comType;
    }
    /**
     * 属性机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构/机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构的setter方法
     */
    public void setComType(String comType) {
        this.comType = comType;
    }
    /**
     * 属性机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点/机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点的getter方法
     */
    public String getComLevel() {
        return comLevel;
    }
    /**
     * 属性机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点/机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点的setter方法
     */
    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }
    /**
     * 属性manager/manager的getter方法
     */
    public String getManager() {
        return manager;
    }
    /**
     * 属性manager/manager的setter方法
     */
    public void setManager(String manager) {
        this.manager = manager;
    }
    /**
     * 属性上级机构代码/上级机构代码的getter方法
     */
    public String getAccountLeader() {
        return accountLeader;
    }
    /**
     * 属性上级机构代码/上级机构代码的setter方法
     */
    public void setAccountLeader(String accountLeader) {
        this.accountLeader = accountLeader;
    }
    /**
     * 属性cashier/cashier的getter方法
     */
    public String getCashier() {
        return cashier;
    }
    /**
     * 属性cashier/cashier的setter方法
     */
    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
    /**
     * 属性accountant/accountant的getter方法
     */
    public String getAccountant() {
        return accountant;
    }
    /**
     * 属性accountant/accountant的setter方法
     */
    public void setAccountant(String accountant) {
        this.accountant = accountant;
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
     * 属性newComCode/newComCode的getter方法
     */
    public String getNewComCode() {
        return newComCode;
    }
    /**
     * 属性newComCode/newComCode的setter方法
     */
    public void setNewComCode(String newComCode) {
        this.newComCode = newComCode;
    }
    /**
     * 属性validStatus/validStatus的getter方法
     */
    public String getValidStatus() {
        return validStatus;
    }
    /**
     * 属性validStatus/validStatus的setter方法
     */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }
    /**
     * 属性acntUnit/acntUnit的getter方法
     */
    public String getAcntUnit() {
        return acntUnit;
    }
    /**
     * 属性acntUnit/acntUnit的setter方法
     */
    public void setAcntUnit(String acntUnit) {
        this.acntUnit = acntUnit;
    }
    /**
     * 属性articleCode/articleCode的getter方法
     */
    public String getArticleCode() {
        return articleCode;
    }
    /**
     * 属性articleCode/articleCode的setter方法
     */
    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }
    /**
     * 属性accCode/accCode的getter方法
     */
    public String getAccCode() {
        return accCode;
    }
    /**
     * 属性accCode/accCode的setter方法
     */
    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }
    /**
     * 属性核算单位标志：1核算单位 2基层单位 3 核算部门/核算单位标志：1核算单位 2基层单位 3 核算部门的getter方法
     */
    public String getCenterFlag() {
        return centerFlag;
    }
    /**
     * 属性核算单位标志：1核算单位 2基层单位 3 核算部门/核算单位标志：1核算单位 2基层单位 3 核算部门的setter方法
     */
    public void setCenterFlag(String centerFlag) {
        this.centerFlag = centerFlag;
    }
    /**
     * 属性outerPayCode/outerPayCode的getter方法
     */
    public String getOuterPayCode() {
        return outerPayCode;
    }
    /**
     * 属性outerPayCode/outerPayCode的setter方法
     */
    public void setOuterPayCode(String outerPayCode) {
        this.outerPayCode = outerPayCode;
    }
    /**
     * 属性innerPayCode/innerPayCode的getter方法
     */
    public String getInnerPayCode() {
        return innerPayCode;
    }
    /**
     * 属性innerPayCode/innerPayCode的setter方法
     */
    public void setInnerPayCode(String innerPayCode) {
        this.innerPayCode = innerPayCode;
    }
    /**
     * 属性[0]:0:非政策性农险机构 1:政策性农险机构/[0]:0:非政策性农险机构 1:政策性农险机构的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性[0]:0:非政策性农险机构 1:政策性农险机构/[0]:0:非政策性农险机构 1:政策性农险机构的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性webAddress/webAddress的getter方法
     */
    public String getWebAddress() {
        return webAddress;
    }
    /**
     * 属性webAddress/webAddress的setter方法
     */
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
    /**
     * 属性商业险报案电话(交强)/商业险报案电话(交强)的getter方法
     */
    public String getServicePhone() {
        return servicePhone;
    }
    /**
     * 属性商业险报案电话(交强)/商业险报案电话(交强)的setter方法
     */
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
    /**
     * 属性农业险报案电话/农业险报案电话的getter方法
     */
    public String getReportPhone() {
        return reportPhone;
    }
    /**
     * 属性农业险报案电话/农业险报案电话的setter方法
     */
    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }
    /**
     * 属性agentCode/agentCode的getter方法
     */
    public String getAgentCode() {
        return agentCode;
    }
    /**
     * 属性agentCode/agentCode的setter方法
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    /**
     * 属性agreementNo/agreementNo的getter方法
     */
    public String getAgreementNo() {
        return agreementNo;
    }
    /**
     * 属性agreementNo/agreementNo的setter方法
     */
    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }
    /**
     * 属性sysAreaCode/sysAreaCode的getter方法
     */
    public String getSysAreaCode() {
        return sysAreaCode;
    }
    /**
     * 属性sysAreaCode/sysAreaCode的setter方法
     */
    public void setSysAreaCode(String sysAreaCode) {
        this.sysAreaCode = sysAreaCode;
    }
    /**
     * 属性公司类别标志（理赔1，非理赔2，公估3）/公司类别标志（理赔1，非理赔2，公估3）的getter方法
     */
    public String getCompanyFlag() {
        return companyFlag;
    }
    /**
     * 属性公司类别标志（理赔1，非理赔2，公估3）/公司类别标志（理赔1，非理赔2，公估3）的setter方法
     */
    public void setCompanyFlag(String companyFlag) {
        this.companyFlag = companyFlag;
    }
    /**
     * 属性shortComCname/shortComCname的getter方法
     */
    public String getShortComCName() {
        return shortComCName;
    }
    /**
     * 属性shortComCname/shortComCname的setter方法
     */
    public void setShortComCName(String shortComCName) {
        this.shortComCName = shortComCName;
    }
    /**
     * 属性serviceFlag/serviceFlag的getter方法
     */
    public String getServiceFlag() {
        return serviceFlag;
    }
    /**
     * 属性serviceFlag/serviceFlag的setter方法
     */
    public void setServiceFlag(String serviceFlag) {
        this.serviceFlag = serviceFlag;
    }
    /**
     * 属性平台子系统机构代码/平台子系统机构代码的getter方法
     */
    public String getDaaPlatformComCode() {
        return daaPlatformComCode;
    }
    /**
     * 属性平台子系统机构代码/平台子系统机构代码的setter方法
     */
    public void setDaaPlatformComCode(String daaPlatformComCode) {
        this.daaPlatformComCode = daaPlatformComCode;
    }
    /**
     * 属性specLevelFlag/specLevelFlag的getter方法
     */
    public String getSpecLevelFlag() {
        return specLevelFlag;
    }
    /**
     * 属性specLevelFlag/specLevelFlag的setter方法
     */
    public void setSpecLevelFlag(String specLevelFlag) {
        this.specLevelFlag = specLevelFlag;
    }
    /**
     * 属性normLevel/normLevel的getter方法
     */
    public String getNormLevel() {
        return normLevel;
    }
    /**
     * 属性normLevel/normLevel的setter方法
     */
    public void setNormLevel(String normLevel) {
        this.normLevel = normLevel;
    }
    /**
     * 属性specLevel/specLevel的getter方法
     */
    public String getSpecLevel() {
        return specLevel;
    }
    /**
     * 属性specLevel/specLevel的setter方法
     */
    public void setSpecLevel(String specLevel) {
        this.specLevel = specLevel;
    }
    /**
     * 属性业务来源/业务来源的getter方法
     */
    public String getBusinessNature() {
        return businessNature;
    }
    /**
     * 属性业务来源/业务来源的setter方法
     */
    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }
    /**
     * 属性出单机构IP/出单机构IP的getter方法
     */
    public String getIpSegment() {
        return ipSegment;
    }
    /**
     * 属性出单机构IP/出单机构IP的setter方法
     */
    public void setIpSegment(String ipSegment) {
        this.ipSegment = ipSegment;
    }
    /**
     * 属性出单机构数字证书/出单机构数字证书的getter方法
     */
    public String getUsbKey() {
        return usbKey;
    }
    /**
     * 属性出单机构数字证书/出单机构数字证书的setter方法
     */
    public void setUsbKey(String usbKey) {
        this.usbKey = usbKey;
    }
    /**
     * 属性是否注销标志 1：未注销/是否注销标志 1：未注销的getter方法
     */
    public String getCancelFlag() {
        return cancelFlag;
    }
    /**
     * 属性是否注销标志 1：未注销/是否注销标志 1：未注销的setter方法
     */
    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }
    /**
     * 属性分支机构类型/分支机构类型的getter方法
     */
    public String getBranchType() {
        return branchType;
    }
    /**
     * 属性分支机构类型/分支机构类型的setter方法
     */
    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }
    /**
     * 属性机构代码1/机构代码1的getter方法
     */
    public String getComCodeCirc() {
        return comCodeCirc;
    }
    /**
     * 属性机构代码1/机构代码1的setter方法
     */
    public void setComCodeCirc(String comCodeCirc) {
        this.comCodeCirc = comCodeCirc;
    }
    /**
     * 属性机构标识/机构标识的getter方法
     */
    public String getComFlag() {
        return comFlag;
    }
    /**
     * 属性机构标识/机构标识的setter方法
     */
    public void setComFlag(String comFlag) {
        this.comFlag = comFlag;
    }
    /**
     * 属性机构类别/机构类别的getter方法
     */
    public String getComKind() {
        return comKind;
    }
    /**
     * 属性机构类别/机构类别的setter方法
     */
    public void setComKind(String comKind) {
        this.comKind = comKind;
    }
    /**
     * 属性邮箱/邮箱的getter方法
     */
    public String getEmail() {
        return email;
    }
    /**
     * 属性邮箱/邮箱的setter方法
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 属性机构团队业务来源/机构团队业务来源的getter方法
     */
    public String getGroupNatureDetail() {
        return groupNatureDetail;
    }
    /**
     * 属性机构团队业务来源/机构团队业务来源的setter方法
     */
    public void setGroupNatureDetail(String groupNatureDetail) {
        this.groupNatureDetail = groupNatureDetail;
    }
    /**
     * 属性无效日期/无效日期的getter方法
     */
    public Date getInvalidDate() {
        return invalidDate;
    }
    /**
     * 属性无效日期/无效日期的setter方法
     */
    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }
    /**
     * 属性车牌号/车牌号的getter方法
     */
    public String getLicenseNo() {
        return licenseNo;
    }
    /**
     * 属性车牌号/车牌号的setter方法
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
    /**
     * 属性操作员机构代码/操作员机构代码的getter方法
     */
    public String getOperatorComCode() {
        return operatorComCode;
    }
    /**
     * 属性操作员机构代码/操作员机构代码的setter方法
     */
    public void setOperatorComCode(String operatorComCode) {
        this.operatorComCode = operatorComCode;
    }
    /**
     * 属性更新日期/更新日期的getter方法
     */
    public Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 属性更新日期/更新日期的setter方法
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * 属性更新标识/更新标识的getter方法
     */
    public String getUpdateFlag() {
        return updateFlag;
    }
    /**
     * 属性更新标识/更新标识的setter方法
     */
    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }
    /**
     * 属性上级机构路径/上级机构路径的getter方法
     */
    public String getUpperPath() {
        return upperPath;
    }
    /**
     * 属性上级机构路径/上级机构路径的setter方法
     */
    public void setUpperPath(String upperPath) {
        this.upperPath = upperPath;
    }
    /**
     * 属性有效日期/有效日期的getter方法
     */
    public Date getValidDate() {
        return validDate;
    }
    /**
     * 属性有效日期/有效日期的setter方法
     */
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
    /**
     * 属性marketType/marketType的getter方法
     */
    public String getMarketType() {
        return marketType;
    }
    /**
     * 属性marketType/marketType的setter方法
     */
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
    /**
     * 属性upperylComCode/upperylComCode的getter方法
     */
    public String getUpperylComCode() {
        return upperylComCode;
    }
    /**
     * 属性upperylComCode/upperylComCode的setter方法
     */
    public void setUpperylComCode(String upperylComCode) {
        this.upperylComCode = upperylComCode;
    }
    /**
     * 属性纳税人识别号/纳税人识别号的getter方法
     */
    public String getBuyDentiCode() {
        return buyDentiCode;
    }
    /**
     * 属性纳税人识别号/纳税人识别号的setter方法
     */
    public void setBuyDentiCode(String buyDentiCode) {
        this.buyDentiCode = buyDentiCode;
    }
    /**
     * 属性核算单位接收部门，顺序财务部-总经理室-综合部/核算单位接收部门，顺序财务部-总经理室-综合部的getter方法
     */
    public String getReceiveComCode() {
        return receiveComCode;
    }
    /**
     * 属性核算单位接收部门，顺序财务部-总经理室-综合部/核算单位接收部门，顺序财务部-总经理室-综合部的setter方法
     */
    public void setReceiveComCode(String receiveComCode) {
        this.receiveComCode = receiveComCode;
    }
    /**
     * 属性是否理赔中心，1-是/是否理赔中心，1-是的getter方法
     */
    public String getClaimFlag() {
        return claimFlag;
    }
    /**
     * 属性是否理赔中心，1-是/是否理赔中心，1-是的setter方法
     */
    public void setClaimFlag(String claimFlag) {
        this.claimFlag = claimFlag;
    }
    /**
     * 属性保单归属地-地市代码/保单归属地-地市代码的getter方法
     */
    public String getCityCode() {
        return cityCode;
    }
    /**
     * 属性保单归属地-地市代码/保单归属地-地市代码的setter方法
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * 属性保单归属地-县区代码/保单归属地-县区代码的getter方法
     */
    public String getCountyCode() {
        return countyCode;
    }
    /**
     * 属性保单归属地-县区代码/保单归属地-县区代码的setter方法
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}