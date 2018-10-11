package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class QueryMyJobCountDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /*暂存单总条数*/
    private Long tempProposal;
    /*投保单总条数*/
    private Long proposal;
    /*保单总条数*/
    private Long policy;
    /*批单总条数*/
    private Long Endors;

    public Long getTempProposal() {
        return tempProposal;
    }

    public void setTempProposal(Long tempProposal) {
        this.tempProposal = tempProposal;
    }

    public Long getProposal() {
        return proposal;
    }

    public void setProposal(Long proposal) {
        this.proposal = proposal;
    }

    public Long getPolicy() {
        return policy;
    }

    public void setPolicy(Long policy) {
        this.policy = policy;
    }

    public Long getEndors() {
        return Endors;
    }

    public void setEndors(Long endors) {
        Endors = endors;
    }
}
