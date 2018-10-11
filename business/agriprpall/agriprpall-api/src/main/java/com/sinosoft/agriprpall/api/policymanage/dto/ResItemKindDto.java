package com.sinosoft.agriprpall.api.policymanage.dto;

import java.util.Date;
import java.util.List;

public class ResItemKindDto {
    /** 签单日期 */
    private Date operateDate;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    private List<ResponseItemKindDto> responseItemKindDtoList ;

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public List<ResponseItemKindDto> getResponseItemKindDtoList() {
        return responseItemKindDtoList;
    }

    public void setResponseItemKindDtoList(List<ResponseItemKindDto> responseItemKindDtoList) {
        this.responseItemKindDtoList = responseItemKindDtoList;
    }
}
