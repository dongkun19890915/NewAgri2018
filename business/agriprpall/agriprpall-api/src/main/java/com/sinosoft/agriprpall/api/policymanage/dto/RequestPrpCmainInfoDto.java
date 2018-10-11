package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

public class RequestPrpCmainInfoDto  extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 清单编号
     */
    private String gisInsureListCode;

    /**
     * 投保单号
     */
    private List<String> proposalNos;

    private String startDate;
    private String endDate;

    private String riskCode;
    private String  businessType1;


    public String getGisInsureListCode() {
        return gisInsureListCode;
    }

    public void setGisInsureListCode(String gisInsureListCode) {
        this.gisInsureListCode = gisInsureListCode;
    }

    public List<String> getProposalNos() {
        return proposalNos;
    }

    public void setProposalNos(List<String> proposalNos) {
        this.proposalNos = proposalNos;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }
}
