package com.sinosoft.ims.api.kernel.dto;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-05 01:10:12.703
 * 机构代码表Api操作对象
 */
public class CompanyListDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性机构代码/机构代码
     */

    @JsonProperty(value="id")
    private String comCode;
    /**
     * 属性机构中文名称/机构中文名称
     */

    @JsonProperty(value="n")
    private String comCName;
    /**
     * 属性upperComCode/upperComCode
     */
    @JsonProperty(value="pid")
    private String upperComCode;

    @JsonProperty(value="ck")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean checked;
    /**
     * 属性机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构/机构类型[1]：1出单机构[2]：1归属机构[3]：1收付机构[4]：1分保机构
     */
//	private String comType ;
//	/** 属性机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点/机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点 */
//	private String comLevel ;

    @JsonProperty(value="ch")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CompanyListDto> childs;

    @JsonProperty(value="chkDisabled")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean disabled;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public CompanyListDto() {
    }

    public CompanyListDto(String comCode, String comCName, String upperComCode) {
        this.comCode = comCode;
        this.comCName = comCName;
        this.upperComCode = upperComCode;
//		this.comLevel = comLevel;
    }

    public List<CompanyListDto> getChilds() {
        return childs;
    }

    public void setChilds(List<CompanyListDto> childs) {
        this.childs = childs;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }

    public String getUpperComCode() {
        return upperComCode;
    }

    public void setUpperComCode(String upperComCode) {
        this.upperComCode = upperComCode;
    }

//	public String getComType() {
//		return comType;
//	}
//
//	public void setComType(String comType) {
//		this.comType = comType;
//	}
//
//	public String getComLevel() {
//		return comLevel;
//	}

//	public void setComLevel(String comLevel) {
//		this.comLevel = comLevel;
//	}

    public String toString() {
        return "PrpdCompany{" +
                "comcode='" + comCode + '\'' +
                ", comcname='" + comCName + '\'' +
                ", uppercomcode='" + upperComCode + '\'' +
                '}';
    }
}
