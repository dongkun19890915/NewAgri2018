package com.sinosoft.dms.api.dict.dto;

import java.util.ArrayList;
import java.util.List;

public class PrpDcodeRetuenDto {
    private List<QueryPrpDcodeDto> queryPrpDcodeDtoList = new ArrayList<>();

    public List<QueryPrpDcodeDto> getQueryPrpDcodeDtoList() {
        return queryPrpDcodeDtoList;
    }

    public void setQueryPrpDcodeDtoList(List<QueryPrpDcodeDto> queryPrpDcodeDtoList) {
        this.queryPrpDcodeDtoList = queryPrpDcodeDtoList;
    }
}
