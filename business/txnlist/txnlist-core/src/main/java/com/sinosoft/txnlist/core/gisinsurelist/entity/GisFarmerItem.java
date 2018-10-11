package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * 预投保清单农户标的表实体操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:33
 */
@Entity
@Table(name = "GisFarmerItem")
@IdClass(GisFarmerItemKey.class)
public class GisFarmerItem extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    @Id
    @Column(name = "insureListCode")
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    @Id
    @Column(name = "serialNo")
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性标的代码/标的代码
     */
    @Id
    @Column(name = "itemCode")
    private String itemCode;
    /**
     * 属性标的清单编号/标的清单编号
     */
    @Column(name = "itemListCode")
    private String itemListCode;
    /**
     * 属性投保数量/投保数量
     */
    @Column(name = "insureCount")
    private Double insureCount;

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
}