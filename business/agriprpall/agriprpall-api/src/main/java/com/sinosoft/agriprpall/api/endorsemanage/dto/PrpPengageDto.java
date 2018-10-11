package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpPengageDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性批单号码/批单号码 */

    private String endorseNo;

    private String policyNo ;/** 属性序号/序号 */

    private Integer serialNo ;/** 属性行序号/行序号 */

    private Integer lineNo ;

    /** 属性险种代码 /险种代码  */
    private String riskCode ;


    /** 属性条款编码 /条款编码  */
    private String clauseCode ;
    /** 属性条款文字描述/条款文字描述 */
    private String clauses ;
    /** 属性titleFlag/titleFlag */
    private String titleFlag ;
    /** 属性--** 标志字段--** Flag[2]：1：标识标题项/--** 标志字段--** Flag[2]：1：标识标题项 */
    private String flag ;
    /** 属性clauseName/clauseName */
    private String clauseName ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    /**
     * 属性保单号码/保单号码的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性保单号码/保单号码的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性险种代码 /险种代码 的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }
    /**
     * 属性险种代码 /险种代码 的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
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
     * 属性行序号/行序号的getter方法
     */
    public Integer getLineNo() {
        return lineNo;
    }
    /**
     * 属性行序号/行序号的setter方法
     */
    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }
    /**
     * 属性条款编码 /条款编码 的getter方法
     */
    public String getClauseCode() {
        return clauseCode;
    }
    /**
     * 属性条款编码 /条款编码 的setter方法
     */
    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }
    /**
     * 属性条款文字描述/条款文字描述的getter方法
     */
    public String getClauses() {
        return clauses;
    }
    /**
     * 属性条款文字描述/条款文字描述的setter方法
     */
    public void setClauses(String clauses) {
        this.clauses = clauses;
    }
    /**
     * 属性titleFlag/titleFlag的getter方法
     */
    public String getTitleFlag() {
        return titleFlag;
    }
    /**
     * 属性titleFlag/titleFlag的setter方法
     */
    public void setTitleFlag(String titleFlag) {
        this.titleFlag = titleFlag;
    }
    /**
     * 属性--** 标志字段--** Flag[2]：1：标识标题项/--** 标志字段--** Flag[2]：1：标识标题项的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性--** 标志字段--** Flag[2]：1：标识标题项/--** 标志字段--** Flag[2]：1：标识标题项的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性clauseName/clauseName的getter方法
     */
    public String getClauseName() {
        return clauseName;
    }
    /**
     * 属性clauseName/clauseName的setter方法
     */
    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }
}
