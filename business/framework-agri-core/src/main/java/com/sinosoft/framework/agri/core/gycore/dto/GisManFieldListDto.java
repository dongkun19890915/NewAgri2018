package com.sinosoft.framework.agri.core.gycore.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 预投保清单农户标的清单明细表（人）Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:27
 */
public class GisManFieldListDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性证件类型/证件类型
     */
    private String idType;
    /**
     * 属性证件号码/证件号码
     */
    private String idCard;
    /**
     * 属性姓名/姓名
     */
    private String name;
    /**
     * 属性性别/性别
     */
    private String sex;
    /**
     * 属性与农户关系/与农户关系
     */
    private String relation;

    // 针对草莓种植保险新增字段
    /**
     * 行业类别
     */
    private String industryCategory;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
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

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }
}
