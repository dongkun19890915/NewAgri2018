package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;

import java.io.Serializable;
import java.util.List;

public class PaySaveDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 清单号 */
    private String billNo;
    /** 第三方支付标识 0待提交 1待审核 2审核不通过
     3 支付中心待处理 4 支付中心退回 5 已打包待审核
     6打包审核通过待发送 7已发往银行 在途 8银行打回
     9支付成功 m默认成功 n银行退回支付中心 */
    private String thirdPayFlag;
    /** 清单支付标志 1清单支付  0 整单支付 */
    private String billFlag;
    /** 支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付) */
    private String payType;
    /** 机构代码 */
    private String comCode;
    /** 节点名称 apay 支付节点*/
    private String node;
    /**  */
    private String paymentType;
    /** 合并下发标志(1:勾选,0：未勾选) */
    private String mergerFlag;
    /** 用户代码 */
    private String userCode;
    /** 传统方式支付原因 */
    private String payReason;
    /** 支付行号 */
    private String routeNum;
    /** 整单合并支付数据存放 */
    private List<PaymentMessageDto> paymentMessageDtoList;
    /** excel数据存放 */
    private List<NyxClaimPayListDto> nyxClaimPayListDtoList;
    /** 处理意见 */
    private List<PayPurposeDto> payPurposeDtoList;
    /** 整单录单页面信息 */
    /** 支付信息 */
    private PrpLPayMainDto prpLPayMainDto;

    private String newContext;

    public String getNewContext() {

        return newContext;
    }

    public void setNewContext(String newContext) {
        this.newContext = newContext;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public List<PayPurposeDto> getPayPurposeDtoList() {
        return payPurposeDtoList;
    }

    public void setPayPurposeDtoList(List<PayPurposeDto> payPurposeDtoList) {
        this.payPurposeDtoList = payPurposeDtoList;
    }

    public List<PaymentMessageDto> getPaymentMessageDtoList() {
        return paymentMessageDtoList;
    }

    public void setPaymentMessageDtoList(List<PaymentMessageDto> paymentMessageDtoList) {
        this.paymentMessageDtoList = paymentMessageDtoList;
    }

    public String getBillFlag() {
        return billFlag;
    }

    public void setBillFlag(String billFlag) {
        this.billFlag = billFlag;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }

    public String getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(String routeNum) {
        this.routeNum = routeNum;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getThirdPayFlag() {
        return thirdPayFlag;
    }

    public void setThirdPayFlag(String thirdPayFlag) {
        this.thirdPayFlag = thirdPayFlag;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getMergerFlag() {
        return mergerFlag;
    }

    public void setMergerFlag(String mergerFlag) {
        this.mergerFlag = mergerFlag;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<NyxClaimPayListDto> getNyxClaimPayListDtoList() {
        return nyxClaimPayListDtoList;
    }

    public void setNyxClaimPayListDtoList(List<NyxClaimPayListDto> nyxClaimPayListDtoList) {
        this.nyxClaimPayListDtoList = nyxClaimPayListDtoList;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public PrpLPayMainDto getPrpLPayMainDto() {
        return prpLPayMainDto;
    }

    public void setPrpLPayMainDto(PrpLPayMainDto prpLPayMainDto) {
        this.prpLPayMainDto = prpLPayMainDto;
    }
}
