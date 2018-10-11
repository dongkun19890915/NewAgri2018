package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author 潘峰
 * @date 13/03/2018 9:38 AM
 */
public class UnderwritingListDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String insureListCode;

    private List<PrpCmainDto> policyInfoList;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public List<PrpCmainDto> getPolicyInfoList() {
        return policyInfoList;
    }

    public void setPolicyInfoList(List<PrpCmainDto> policyInfoList) {
        this.policyInfoList = policyInfoList;
    }
}
