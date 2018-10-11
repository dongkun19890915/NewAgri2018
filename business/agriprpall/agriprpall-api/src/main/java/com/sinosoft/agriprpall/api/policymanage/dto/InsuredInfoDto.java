package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @Description:被保险人信息返回Dto
 * @Author: 潘峰
 * @Date: 2017/10/20 11:05
 */
public class InsuredInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*被保险人名称 */
    private String insuredName;
    /*被保险人电话 */
    private String mobile;
    /*被保险人地址 */
    private String insureAddress;
    /*被保险人邮政编码 */
    private String postCode;
    /*投保财产地址 */
    private String addressName;
    /*起保日期 */
    private String startDate;
    /*终保日期 */
    private String endDate;
    /*被保险人代码 */
    private String insuredCode;
    /*签单日期 */
    private String operateDate;
    /*核保人 */
    private String underWriteName;
    /*投保人 */
    private String appInsuredName;
    /*与被保险人关系 */
    private String insuredInsuredidenty;
    /*投保方式 */
    private String policyType;
    /*户数 */
    private String sumInsured;
    /*按何种方式呢确定金额 */
    private String remark;
    /*组织机构代码/身份证号 */
    private String insuredIdNum;
    //养殖方式
    private String raiseType;

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInsureAddress() {
        return insureAddress;
    }

    public void setInsureAddress(String insureAddress) {
        this.insureAddress = insureAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public String getAppInsuredName() {
        return appInsuredName;
    }

    public void setAppInsuredName(String appInsuredName) {
        this.appInsuredName = appInsuredName;
    }

    public String getInsuredInsuredidenty() {
        return insuredInsuredidenty;
    }

    public void setInsuredInsuredidenty(String insuredInsuredidenty) {
        this.insuredInsuredidenty = insuredInsuredidenty;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(String sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsuredIdNum() {
        return insuredIdNum;
    }

    public void setInsuredIdNum(String insuredIdNum) {
        this.insuredIdNum = insuredIdNum;
    }

    public String getRaiseType() {
        return raiseType;
    }

    public void setRaiseType(String raiseType) {
        this.raiseType = raiseType;
    }
}
