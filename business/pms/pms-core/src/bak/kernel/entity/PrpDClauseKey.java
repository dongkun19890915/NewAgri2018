package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-13 16:30:54.800 
 * 条款定义表-PrpDClause 主键操作类
 */
public class PrpDClauseKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;
    /** 属性条款代码/条款代码 */
    private String clauseCode ;
    /**
     * 属性条款代码/条款代码的getter方法
     */
    public String getClauseCode() {
        return clauseCode;
    }
    /**
     * 属性条款代码/条款代码的setter方法
     */
    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    } 
}