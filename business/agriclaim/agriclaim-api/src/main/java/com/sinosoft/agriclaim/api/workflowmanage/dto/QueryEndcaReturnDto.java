package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.util.List;

public class QueryEndcaReturnDto {

    private List<ResponseQueryEndCaseDto> responseQueryEndCaseDtoList;

    private Long totalCount;

    public List<ResponseQueryEndCaseDto> getResponseQueryEndCaseDtoList() {
        return responseQueryEndCaseDtoList;
    }

    public void setResponseQueryEndCaseDtoList(List<ResponseQueryEndCaseDto> responseQueryEndCaseDtoList) {
        this.responseQueryEndCaseDtoList = responseQueryEndCaseDtoList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
