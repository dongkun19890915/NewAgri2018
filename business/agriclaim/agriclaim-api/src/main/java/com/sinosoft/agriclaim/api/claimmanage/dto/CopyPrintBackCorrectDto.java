package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class CopyPrintBackCorrectDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 批单号 */
    private String endorseNo;
    /** 批改原因 */
    private String endorseReason;
    /** 批改时间 */
    private String endorDate;
    /** 核保人 */
    private String underWriteName;

    //=============
    public CopyPrintBackCorrectDto(){}

    public CopyPrintBackCorrectDto(String endorseNo,String endorseReason,String endorDate,String underWriteName){
        this.endorseNo = endorseNo;
        this.endorseReason = endorseReason;
        this.endorDate = endorDate;
        this.underWriteName = underWriteName;
    }
    //============

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getEndorseReason() {
        return endorseReason;
    }

    public void setEndorseReason(String endorseReason) {
        this.endorseReason = endorseReason;
    }

    public String getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(String endorDate) {
        this.endorDate = endorDate;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }
}
