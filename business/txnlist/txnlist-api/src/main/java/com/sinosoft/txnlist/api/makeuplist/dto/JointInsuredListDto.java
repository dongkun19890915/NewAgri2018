package com.sinosoft.txnlist.api.makeuplist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 26/01/2018 9:53 AM
 */
public class JointInsuredListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @ExportConfig(value = "清单编号", width = 300)
    private String insureListCode;
    /**
     * 属性农户代码/农户代码
     */
    @ExportConfig(value = "农户代码", width = 200)
    private String fCode;
    /**
     * 属性农户姓名/农户姓名
     */
    @ExportConfig(value = "农户姓名")
    private String fName;
    /**
     * 属性标的代码/标的代码
     */
    @ExportConfig(value = "标的序号")
    private String itemCode;
    /**
     * 属性证件类型
     */
    @ExportConfig(value = "证件类型")
    private String idType;
    /**
     * 属性证件号码
     */
    @ExportConfig(value = "证件号码", width = 200)
    private String idCard;
    /**
     * 属性姓名/姓名
     */
    @ExportConfig(value = "姓名")
    private String name;
    /**
     * 属性性别/性别
     */
    @ExportConfig(value = "性别")
    private String sex;
    /**
     * 属性与农户关系/与农户关系
     */
    @ExportConfig(value = "与农户关系", width = 200)
    private String relation;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
