package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 预投保清单标的表Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:26
 */
public class GisItemListDto extends BaseRequest implements Serializable {
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
     * 属性标的序号/标的序号
     */
    private String itemNo;
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性标的类型/标的类型
     */
    private String itemType;
    /**
     * 属性标的名称/标的名称
     */
    private String itemName;
    /**
     * 属性标的全称/标的全称
     */
    private String itemFullName;
    /**
     * 属性标的清单编号/标的清单编号
     */
    private String itemListCode;

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

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemFullName() {
        return itemFullName;
    }

    public void setItemFullName(String itemFullName) {
        this.itemFullName = itemFullName;
    }

    public String getItemListCode() {
        return itemListCode;
    }

    public void setItemListCode(String itemListCode) {
        this.itemListCode = itemListCode;
    }
}
