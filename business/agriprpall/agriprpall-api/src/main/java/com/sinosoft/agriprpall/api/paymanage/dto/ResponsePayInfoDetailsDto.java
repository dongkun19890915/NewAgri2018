package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 支付详细信息查询响应Dto
 *
 * @author: 何伟东
 * @date: 2017/12/25 10:34
 */
public class ResponsePayInfoDetailsDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 支付信息与业务信息关联数据
     */
    private PrpPaySubDto prpPaySubDto;
    /**
     * 支付信息主要数据
     */
    private List<PrpPayMainDto> prpPayMainDtos;

    public PrpPaySubDto getPrpPaySubDto() {
        return prpPaySubDto;
    }

    public void setPrpPaySubDto(PrpPaySubDto prpPaySubDto) {
        this.prpPaySubDto = prpPaySubDto;
    }

    public List<PrpPayMainDto> getPrpPayMainDtos() {
        return prpPayMainDtos;
    }

    public void setPrpPayMainDtos(List<PrpPayMainDto> prpPayMainDtos) {
        this.prpPayMainDtos = prpPayMainDtos;
    }
}
