package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TxnlistDetailedDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private TxnlistDetailedMainDto txnlistDetailedMainDto;
    private List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList;
    private List<String> itemCodeList;

    /**
     * 保存次数
     */
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public List<String> getItemCodeList() {
        return itemCodeList;
    }

    public void setItemCodeList(List<String> itemCodeList) {
        this.itemCodeList = itemCodeList;
    }

    public TxnlistDetailedMainDto getTxnlistDetailedMainDto() {
        return txnlistDetailedMainDto;
    }

    public void setTxnlistDetailedMainDto(TxnlistDetailedMainDto txnlistDetailedMainDto) {
        this.txnlistDetailedMainDto = txnlistDetailedMainDto;
    }
    public List<TxnlistDetailedSubDto> getTxnlistDetailedSubDtoList() {
        return txnlistDetailedSubDtoList;
    }

    public void setTxnlistDetailedSubDtoList(List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList) {
        this.txnlistDetailedSubDtoList = txnlistDetailedSubDtoList;
    }
}
