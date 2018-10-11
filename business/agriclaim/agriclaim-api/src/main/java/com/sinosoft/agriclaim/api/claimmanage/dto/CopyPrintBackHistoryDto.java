package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/***
* @description: （保单抄件历史赔付记录Dto）
* @Author: 王志文
* @Date: 2017/11/15 17:54
*/
public class CopyPrintBackHistoryDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 立案号 */
    private String claimNo;
    /** 出险时间 */
    private String damageStartDate;
    /** 未决金额 */
    private double undeterminedAmount;
    /** 赔付金额 */
    private double sumPaid;
    /** 结案日期 */
    private String endCaseDate;
    /** 理算人 */
    private String userName;
    /** 核赔人*/
    private String underWriteName;
    /** 赔付次数 */
    private int claimTimes;

    public CopyPrintBackHistoryDto() {
    }

    //==============
    public CopyPrintBackHistoryDto(String claimNo,String damageStartDate,double undeterminedAmount,double sumPaid){
        this.claimNo = claimNo;
        this.damageStartDate = damageStartDate;
        this.undeterminedAmount = undeterminedAmount;
        this.sumPaid = sumPaid;
    }
    //==============


    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public double getUndeterminedAmount() {
        return undeterminedAmount;
    }

    public void setUndeterminedAmount(double undeterminedAmount) {
        this.undeterminedAmount = undeterminedAmount;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public String getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(String endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public int getClaimTimes() {
        return claimTimes;
    }

    public void setClaimTimes(int claimTimes) {
        this.claimTimes = claimTimes;
    }
}
