package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-12 19:47:01.205 
 * 产品定义表-PrpDRisk 主键操作类
 */
public class PrpDRiskKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;
    /** 属性产品代码/产品代码 */
    private String riskCode ;
    /**
     * 属性产品代码/产品代码的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }
    /**
     * 属性产品代码/产品代码的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    } 
}