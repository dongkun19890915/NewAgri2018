package com.sinosoft.dms.api.model.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class QueryModelPrpTengageDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性序号/序号 */
    private Integer serialNo ;
    /** 属性代码/代码 */
    private String clauseCode ;
    /** 属性名称/名称 */
    private String clauseName;
    /** 属性内容/内容 */
    private String clausesContent;
    /**
     * 属性序号/序号的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 属性序号/序号的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 属性代码/代码的getter方法
     */
    public String getClauseCode() {
        return clauseCode;
    }
    /**
     * 属性代码/代码的setter方法
     */
    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }
    /**
     * 属性名称/名称的getter方法
     */
    public String getClauseName() {
        return clauseName;
    }
    /**
     * 属性名称/名称的setter方法
     */
    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }
    /**
     * 属性内容/内容的getter方法
     */
    public String getClausesContent() {
        return clausesContent;
    }
    /**
     * 属性内容/内容的setter方法
     */
    public void setClausesContent(String clausesContent) {
        this.clausesContent = clausesContent;
    }
}
