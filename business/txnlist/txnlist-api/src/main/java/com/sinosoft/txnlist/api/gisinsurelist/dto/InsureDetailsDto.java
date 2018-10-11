package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.util.List;

/**
 * 查询清单明细的dto
 *
 * @Author: 何伟东
 * @Date: 2018/4/26 17:31
 */
public class InsureDetailsDto {
    private String detailsType;
    private List content;

    public String getDetailsType() {
        return detailsType;
    }

    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
