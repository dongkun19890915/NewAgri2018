package com.sinosoft.txnlist.api.makeuplist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 2018/1/22 上午10:47
 */
public class MakeUpListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性投保单号码/投保单号码
     */
    private String proposalNo;

    /**
     * 属性投保人名称/投保人名称
     */
    private String appliName;

    /**
     * 属性被保险人名称/被保险人名称
     */
    private String insuredName;

    /**
     * 属性险种名称
     */
    private String riskName;

    /**
     * 属性业务归属机构代码/业务归属机构代码
     */
    private String comName;


    /**
     * 属性归属业务员代码/归属业务员代码
     */
    private String handler1Name;

    /**
     * 操作员姓名
     */
    private String operatorName;

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getHandler1Name() {
        return handler1Name;
    }

    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
