package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpPengageCopyDto extends BaseRequest implements Serializable {
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

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getClauses() {
        return clauses;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }

    public String getTitleFlag() {
        return titleFlag;
    }

    public void setTitleFlag(String titleFlag) {
        this.titleFlag = titleFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getClauseName() {
        return clauseName;
    }

    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }
}
