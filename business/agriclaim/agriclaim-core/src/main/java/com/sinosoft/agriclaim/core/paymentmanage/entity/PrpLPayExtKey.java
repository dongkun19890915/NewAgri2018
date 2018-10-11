package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258
 * 支付处理意见表主键操作对象
 */
public class PrpLPayExtKey  extends BasePKImpl {
    private static final long serialVersionUID = 1L;
    public PrpLPayExtKey(){}
    public PrpLPayExtKey(String paymentNo,int serialNo){
        this.paymentNo = paymentNo;
        this.serialNo = serialNo;
    }
    /** 属性收付编号/收付编号 */
    @Column(name = "paymentNo")
    private String paymentNo;
    /** 属性序号/序号 */
    @Column(name = "serialNo")
    private int serialNo;

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
}
