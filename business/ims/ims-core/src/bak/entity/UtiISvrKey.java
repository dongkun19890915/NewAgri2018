package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time 2016-09-23 17:19:21.110
 * 服务表-UtiISvr 主键操作类
 */
public class UtiISvrKey extends BasePKImpl implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性服务代码/
     */
    @Id
    @Column(name = "svrCode")
    private String svrCode;

    /**
     * 属性服务代码/的getter方法
     */
    public String getSvrCode() {
        return svrCode;
    }

    /**
     * 属性服务代码/的setter方法
     */
    public void setSvrCode(String svrCode) {
        this.svrCode = svrCode;
    }
}