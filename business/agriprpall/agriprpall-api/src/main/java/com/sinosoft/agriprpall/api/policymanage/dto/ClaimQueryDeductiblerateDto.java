package com.sinosoft.agriprpall.api.policymanage.dto;

/**理赔查询免赔率与绝对免赔率
* @Author: 田健
* @Date: 2018/4/13 11:41
*/
public class ClaimQueryDeductiblerateDto extends PrpCitemKindDto {
    /** 免赔率*/
    private String eachDeductibleRate;

    public String getEachDeductibleRate() {
        return eachDeductibleRate;
    }

    public void setEachDeductibleRate(String eachDeductibleRate) {
        this.eachDeductibleRate = eachDeductibleRate;
    }
}
