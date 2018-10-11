package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author 赵鹏
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341
 *  个体。团体风险等级查询条件封装类
 */
public class RequestUnitAndldvDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 证件号码*/
    private String prpDCustomerIdvIdentifyNumber;
    /** 客户代码*/
    private String customerCode;
    /** 客户名称*/
    private String customerCName;
    /** 客户风险等级*/
    private String riskLevel;

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    /**证件类型 */
    private String identifyType ;
    /** 客户类型*/
    private String customerType;
    /** 当前页*/
    private int pageNum;
    /** 页面条数*/
    private int pageSize;
    public String getPrpDCustomerIdvIdentifyNumber() {
        return prpDCustomerIdvIdentifyNumber;
    }

    public void setPrpDCustomerIdvIdentifyNumber(String prpDCustomerIdvIdentifyNumber) {
        this.prpDCustomerIdvIdentifyNumber = prpDCustomerIdvIdentifyNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCName() {
        return customerCName;
    }

    public void setCustomerCName(String customerCName) {
        this.customerCName = customerCName;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
