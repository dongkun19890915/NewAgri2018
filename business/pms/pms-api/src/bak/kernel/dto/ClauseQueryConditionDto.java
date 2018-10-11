package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;
/**
 * @description 根据条款代码查询条款信息，查询条件入参
 * @author yinqingzhu
 * @date 2016年10月12日下午9:06:51
 */
public class ClauseQueryConditionDto extends PmsRequestDto implements Serializable {
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