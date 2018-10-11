package com.sinosoft.demo.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

public class PrpDuserKey extends BasePKImpl {


    private static final long serialVersionUID = 1L;
    public PrpDuserKey(){}
    public PrpDuserKey(String customerCode){
        this.userCode = userCode;
    }
    /** 属性客户代码/客户代码 */
    private String userCode ;
    /**
     * 属性客户代码/客户代码的getter方法
     */
    public String getUserCode() {
        return userCode;
    }
    /**
     * 属性客户代码/客户代码的setter方法
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
