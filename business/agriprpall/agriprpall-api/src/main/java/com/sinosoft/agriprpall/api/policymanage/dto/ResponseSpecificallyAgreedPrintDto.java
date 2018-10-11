package com.sinosoft.agriprpall.api.policymanage.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 特别约定打印
 * @Author: 潘峰
 * @Date: 2017/10/18 16:19
 */
public class ResponseSpecificallyAgreedPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性保单代码
     */
    private String policyNo;
    /**
     * 属性制单日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date operatedate;
    //约定条款
    private String clauses;
    private String dataFlag;
    private String oneFlag;
    private String twoFlag;
    private String strOperateDate;
    private String titleFlag;

    public String getTitleFlag() {
        return titleFlag;
    }

    public void setTitleFlag(String titleFlag) {
        this.titleFlag = titleFlag;
    }

    public String getStrOperateDate() {
        return strOperateDate;
    }

    public void setStrOperateDate(String strOperateDate) {
        this.strOperateDate = strOperateDate;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getOneFlag() {
        return oneFlag;
    }

    public void setOneFlag(String oneFlag) {
        this.oneFlag = oneFlag;
    }

    public String getTwoFlag() {
        return twoFlag;
    }

    public void setTwoFlag(String twoFlag) {
        this.twoFlag = twoFlag;
    }

    public ResponseSpecificallyAgreedPrintDto(String policyNo, Date operatedate, String clauses,String titleFlag) {
        this.policyNo = policyNo;
        this.operatedate = operatedate;
        this.clauses = clauses;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        this.strOperateDate = simpleDateFormat.format(operatedate);
        this.titleFlag=titleFlag;
    }

    public ResponseSpecificallyAgreedPrintDto() {
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        this.strOperateDate = simpleDateFormat.format(operatedate);
    }

    public String getClauses() {
        return clauses;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }
}
