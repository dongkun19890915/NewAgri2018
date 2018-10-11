package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

/**
 * 清单查询查询，下载
 *inusreListCode 清单号
 * pageNo 页数
 * pageSize  每页条数
 *proposalno 投保单号
 *policyNo 保单号
 *userCode 用户编码
 * @author: 钱浩
 * @date: 2017/12/1 上午 11:04
 */
public class PlantingExcelDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String inusreListCode;
    private Integer pageNo;
    private Integer pageSize;
    private String proposalNo;
    private String policyNo;
    private String userCode;
    private String riskCode;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
