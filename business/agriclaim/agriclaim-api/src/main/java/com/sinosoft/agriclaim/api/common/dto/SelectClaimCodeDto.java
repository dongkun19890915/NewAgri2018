package com.sinosoft.agriclaim.api.common.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectClaimCodeDto implements Serializable {
    /**英文代码 */
    private String codeCode;
    /**中文名称 */
    private String codeName;
    /**内容*/
    private  String ClausesContext;
    /** 机构级别*/
    private String comLevel;
    /** 上级机构*/
    private String upperComCode;
    private String codecode;
    private String codecname;
    private List<SelectClaimCodeDto> selectClaimList=new ArrayList<>();
    public String getCodeCode() {
        return codeCode;
    }

    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getClausesContext() {
        return ClausesContext;
    }

    public void setClausesContext(String clausesContext) {
        ClausesContext = clausesContext;
    }

    public String getComLevel() {
        return comLevel;
    }

    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }

    public String getUpperComCode() {
        return upperComCode;
    }

    public void setUpperComCode(String upperComCode) {
        this.upperComCode = upperComCode;
    }

    public List<SelectClaimCodeDto> getSelectClaimList() {
        return selectClaimList;
    }

    public void setSelectClaimList(List<SelectClaimCodeDto> selectClaimList) {
        this.selectClaimList = selectClaimList;
    }

    public String getCodecode() {
        return codecode;
    }

    public void setCodecode(String codecode) {
        this.codecode = codecode;
    }

    public String getCodecname() {
        return codecname;
    }

    public void setCodecname(String codecname) {
        this.codecname = codecname;
    }
}
