package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 保存支付信息的dto
 *
 * @author: 何伟东
 * @date: 2017/12/22 10:29
 */
public class RequestSavePayInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 整单支付批单号码集合
     */
    private List<String> endorseNos;
    /**
     * 清单支付批单号
     */
    private String endorseNo;
    /**
     * 登录机构代码
     */
    private String loginComCode;
    /**
     * 费用类型
     */
    private String costType;
    /**
     * 整单支付信息
     */
    private PrpPayMainDto prpPayMainDto;
    /**
     * 支付信息集合
     */
    private List<PrpPayMainDto> prpPayMainDtos;

    private List<PrpPaySubDto> subInfo = new ArrayList<>();

    public List<String> getEndorseNos() {
        return endorseNos;
    }

    public void setEndorseNos(List<String> endorseNos) {
        this.endorseNos = endorseNos;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public PrpPayMainDto getPrpPayMainDto() {
        return prpPayMainDto;
    }

    public void setPrpPayMainDto(PrpPayMainDto prpPayMainDto) {
        this.prpPayMainDto = prpPayMainDto;
    }

    public List<PrpPayMainDto> getPrpPayMainDtos() {
        return prpPayMainDtos;
    }

    public void setPrpPayMainDtos(List<PrpPayMainDto> prpPayMainDtos) {
        this.prpPayMainDtos = prpPayMainDtos;
    }

    public List<PrpPaySubDto> getSubInfo() {
        return subInfo;
    }

    public void setSubInfo(List<PrpPaySubDto> subInfo) {
        this.subInfo = subInfo;
    }
}
