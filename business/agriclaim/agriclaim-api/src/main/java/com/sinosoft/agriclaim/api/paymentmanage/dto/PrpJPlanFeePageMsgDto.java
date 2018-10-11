package com.sinosoft.agriclaim.api.paymentmanage.dto;

import java.util.List;

public class PrpJPlanFeePageMsgDto {
    //属性 每页显示记录数
    private int pageCount = 0;

    //属性  跳转页码
    private int pageNum = 0;

    //属性 总记录数
    private int pageSize = 0;

    //属性 保单号码
    private String policyNo = "";

    //属性 报案号码
    private String registNo = "";

    //属性 计算书号
    private String certiNo = "";

    //属性 赔款类型
    private String payRefReason = "";

    //属性 被保险人名称
    private String insuredName = "";

    //属性 流入时间起
    private String flowStartDate = "";

    //属性 流入时间止
    private String flowEndDate = "";

    //属性 案件类型
    private String comCode = "";

    //属性 支付类型
    private String certiType = "";

    private List<PrpJplanFeeDto> prpJplanFeeDtoList;


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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

    public List<PrpJplanFeeDto> getPrpJplanFeeDtoList() {
        return prpJplanFeeDtoList;
    }

    public void setPrpJplanFeeDtoList(List<PrpJplanFeeDto> prpJplanFeeDtoList) {
        this.prpJplanFeeDtoList = prpJplanFeeDtoList;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public String getPayRefReason() {
        return payRefReason;
    }

    public void setPayRefReason(String payRefReason) {
        this.payRefReason = payRefReason;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getFlowStartDate() {
        return flowStartDate;
    }

    public void setFlowStartDate(String flowStartDate) {
        this.flowStartDate = flowStartDate;
    }

    public String getFlowEndDate() {
        return flowEndDate;
    }

    public void setFlowEndDate(String flowEndDate) {
        this.flowEndDate = flowEndDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCertiType() {
        return certiType;
    }

    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }
}
