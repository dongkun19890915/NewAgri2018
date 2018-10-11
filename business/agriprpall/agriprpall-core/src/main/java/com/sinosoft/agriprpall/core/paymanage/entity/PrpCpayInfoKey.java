package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-05-27 08:23:10.186
 * 支付信息表主键操作对象
 */
public class PrpCpayInfoKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PrpCpayInfoKey() {
    }

    public PrpCpayInfoKey(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    /**
     * 属性批单号/批单号
     */
    @Column(name = "endorseNo")
    private String endorseNo;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }
}