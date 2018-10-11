package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 费用类型对应收付原因的临时表
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
public class ResTempCostTypeKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public ResTempCostTypeKey() {
    }

    public ResTempCostTypeKey(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    @Column(name = "endorseNo")
    private String endorseNo;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }
}