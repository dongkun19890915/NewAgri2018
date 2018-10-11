package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/** 保费计算与清单数据交互主表Dto
* @Author: 田健
* @Date: 2018/1/17 9:50
*/
public class TxnlistDetailedMainDto extends BaseRequest implements Serializable {
    /** 属性投保清单编号（key）/投保清单编号（key） */
    private String inusreListCode ;
    /** 金禾清单编号*/
    private String gisInsureListCode;
    /**属性险类/险类  */
    private String classCode ;
    /** 属性险种/险种 */
    private String riskCode ;
    /** 金禾的清单序列号*/
    private String serialNo;
    /** 属性清单标志（0未提交、1已关联未提交、2正常，3注销）/清单标志（0未提交、1已关联未提交、2正常，3注销） */
    private String validity ;
    /** 投保单号 */
    private String proposalNo;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getSerialNo() {        return serialNo;    }

    public void setSerialNo(String serialNo) {        this.serialNo = serialNo;    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getGisInsureListCode() {        return gisInsureListCode;    }

    public void setGisInsureListCode(String gisInsureListCode) {        this.gisInsureListCode = gisInsureListCode;    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }
}
