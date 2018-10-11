package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 预投保清单农户标的表Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:18
 */
public class GisFarmerItemDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExportConfig(value = "序号")
    private int sequenceNo;

    @ExportConfig(value = "标的类型")
    private String itemType;

    @ExportConfig(value = "标的名称")
    private String itemName;
    /**
     * 属性标的清单编号/标的清单编号
     */

    @ExportConfig(value = "标的清单编号")
    private String itemListCode;


    /**
     * 属性农户代码/农户代码
     */
    @ExportConfig(value = "农户代码")
    private String fCode;

    @ExportConfig(value = "农户名称")
    private String fName;

    /**
     * 属性投保数量/投保数量
     */
    @ExportConfig(value = "投保数量")
    private Double insureCount;

    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;

    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;

    /** 属性证件号码/证件号码 */
    private String fIdCard ;


    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
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

    public String getItemListCode() {
        return itemListCode;
    }

    public void setItemListCode(String itemListCode) {
        this.itemListCode = itemListCode;
    }

    public Double getInsureCount() {
        return insureCount;
    }

    public void setInsureCount(Double insureCount) {
        this.insureCount = insureCount;
    }

    public String getfIdCard() {        return fIdCard;    }

    public void setfIdCard(String fIdCard) {        this.fIdCard = fIdCard;    }
}
