package com.sinosoft.agriclaim.api.businessutilmanage.dto;

/**
 * 查询定损清单和承保清单拼接理赔清单的入参dto
 * @author 王心洋
 * @time 2017-12-27
 */
public class RequestQueryClaimListDto {
    private static final long serialVersionUID = 1L;

    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性报案号码/报案号码 */
    private String registNo ;
    /** 属性计算书号码/计算书号码 */
    private String compensateNo ;
    /** 属性生长期/生长期 */
    private String growPeriod ;
    /** 属性理赔清单号码/理赔清单号码 */
    private String listNo ;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getGrowPeriod() {
        return growPeriod;
    }

    public void setGrowPeriod(String growPeriod) {
        this.growPeriod = growPeriod;
    }

    public String getListNo() {
        return listNo;
    }

    public void setListNo(String listNo) {
        this.listNo = listNo;
    }
}
