package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703
 * 机构代码表主键操作对象
 */
public class PrpDcompanyKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;
    public PrpDcompanyKey(){}
    public PrpDcompanyKey(String comCode){
        this.comCode = comCode;
    }
    /** 属性机构代码/机构代码 */
    @Column(name = "comCode")
    private String comCode ;
    /**
     * 属性机构代码/机构代码的getter方法
     */
    public String getComCode() {
        return comCode;
    }
    /**
     * 属性机构代码/机构代码的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
}