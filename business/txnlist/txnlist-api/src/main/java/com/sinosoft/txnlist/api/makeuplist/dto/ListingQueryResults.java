package com.sinosoft.txnlist.api.makeuplist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 潘峰
 * @date 05/02/2018 3:12 PM
 */
public class ListingQueryResults extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String insureListCode;
    /**
     * 属性清单别名/清单别名
     */
    private String listAlias;

    /**
     * 属性清单缮制时间/清单缮制时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date listCreateTime;

    /**
     * 属性清单缮制人姓名/清单缮制人姓名
     */
    private String opName;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getListAlias() {
        return listAlias;
    }

    public void setListAlias(String listAlias) {
        this.listAlias = listAlias;
    }

    public Date getListCreateTime() {
        return listCreateTime;
    }

    public void setListCreateTime(Date listCreateTime) {
        this.listCreateTime = listCreateTime;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }
}
