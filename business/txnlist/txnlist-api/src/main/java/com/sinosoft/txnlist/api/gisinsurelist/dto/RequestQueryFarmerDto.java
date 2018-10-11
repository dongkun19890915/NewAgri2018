package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BasePageableRequest;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestQueryFarmerDto extends BasePageableRequest implements Serializable {
    private String insureListCode;
    private String serialNo;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
