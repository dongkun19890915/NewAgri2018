package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/***
*@description: （保单抄件打印保费到账情况Dto）
* @Author: 王志文
* @Date: 2017/11/15 16:23
*/
public class CopyPrintBackEndorDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 付款期数 */
    private int payNo;
    /** 批单号 */
    private String endorseNo;
    /** 应收 */
    private double planFee;
    /** 实收 */
    private double realFee;//planFee - delinQuentFee
    /** 到账日期 */
    private String payDate;

    //==========
    public CopyPrintBackEndorDto(){}

    public CopyPrintBackEndorDto(int payNo,String endorseNo,double planFee,double realFee,String payDate){
        this.payNo = payNo;
        this.endorseNo = endorseNo;
        this.planFee = planFee;
        this.realFee = realFee;
        this.payDate = payDate;
    }
    //==========

    public int getPayNo() {
        return payNo;
    }

    public void setPayNo(int payNo) {
        this.payNo = payNo;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public double getPlanFee() {
        return planFee;
    }

    public void setPlanFee(double planFee) {
        this.planFee = planFee;
    }

    public double getRealFee() {
        return realFee;
    }

    public void setRealFee(double realFee) {
        this.realFee = realFee;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
