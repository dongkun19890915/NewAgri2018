package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 支付信息录入列表信息查询出参Dto
 *
 * @author: 何伟东
 * @date: 2017/12/20 17:17
 */
public class ResponsePayInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 批单号码
     */
    private String endorseNo;
    /**
     * 保单号码
     */
    private String policyNo;
    /**
     * 被保险人代码
     */
    private String insuredCode;
    /**
     * 被保险人名称
     */
    private String insuredName;
    /**
     * 结算金额
     */
    private Double chgPremium;
    /**
     * 承保机构代码
     */
    private String makeCom;
    /**
     * 承保机构名称
     */
    private String makeComName;
    /**
     * 费用类型名称
     */
    private String costType;
    /**
     * 费用类型代码
     */
    private String costTypeCode;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public Double getChgPremium() {
        return chgPremium;
    }

    public void setChgPremium(Double chgPremium) {
        this.chgPremium = Math.abs(chgPremium);
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getMakeComName() {
        return makeComName;
    }

    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostTypeCode() {
        return costTypeCode;
    }

    public void setCostTypeCode(String costTypeCode) {
        this.costTypeCode = costTypeCode;
    }
}
