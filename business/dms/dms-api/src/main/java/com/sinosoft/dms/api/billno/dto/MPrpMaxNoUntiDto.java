package com.sinosoft.dms.api.billno.dto;

import java.io.Serializable;

public class MPrpMaxNoUntiDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String maxNo;
    private  String minNo;
    private  Long count;
    public  MPrpMaxNoUntiDto(String maxNo,String minNo,Long count){
        this.maxNo=maxNo;
        this.minNo=minNo;
        this.count=count;
    }

    public String getMaxNo() {
        return maxNo;
    }

    public void setMaxNo(String maxNo) {
        this.maxNo = maxNo;
    }

    public String getMinNo() {
        return minNo;
    }

    public void setMinNo(String minNo) {
        this.minNo = minNo;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
