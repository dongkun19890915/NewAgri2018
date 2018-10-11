package com.sinosoft.agriprpall.api.policymanage.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 缴费计划打印
 * @Author: 潘峰
 * @Date: 2017/10/18 16:19
 */
public class ResponsePaymentPlanPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性保单代码
     */
    private String policyNo;

    //缴费次数序号
    private Integer serialNo;

    //交费期次
    private Integer payNo;

    /**
     * 计划缴费截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planDate;
    private  String strPlanDate;

    //币别
    private String currency;

    //应缴费金额
    private Double planFee;



    /**
     * 属性制单日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date operateDate;
    private String strOperateDate;
    private String dataFlag;
    private String oneFlag;
    private String twoFlag;
    private String threeFlag;

    public String getThreeFlag() {
        return threeFlag;
    }

    public void setThreeFlag(String threeFlag) {
        this.threeFlag = threeFlag;
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

    public ResponsePaymentPlanPrintDto() {
    }

    public ResponsePaymentPlanPrintDto(String policyNo, Integer serialNo, Integer payNo, Date planDate, String currency, Double planFee, Date operateDate) {
        this.policyNo = policyNo;
        this.serialNo = serialNo;
        this.payNo = payNo;
        this.planDate = planDate;
        this.currency = currency;
        this.planFee = planFee;
        this.operateDate = operateDate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        this.strOperateDate = simpleDateFormat.format(operateDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.strPlanDate=sdf.format(planDate);
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getPayNo() {
        return payNo;
    }

    public void setPayNo(Integer payNo) {
        this.payNo = payNo;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPlanFee() {
        return planFee;
    }

    public void setPlanFee(Double planFee) {
        this.planFee = planFee;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getStrOperateDate() {
        return strOperateDate;
    }

    public void setStrOperateDate(String strOperateDate) {
        this.strOperateDate = strOperateDate;
    }

    public String getStrPlanDate() {
        return strPlanDate;
    }

    public void setStrPlanDate(String strPlanDate) {
        this.strPlanDate = strPlanDate;
    }
}
