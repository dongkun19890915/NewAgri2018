package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 07:46:04.010
 * 标的子险信息Api操作对象
 */
public class PrpCitemKindDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String flag;

    private String kindCode;

    private String kindName;

    private String itemCode;

    private String itemDetailName;

    private Double amount;

    private Double premium;

    /**
     * 属性全损损失率/全损损失率
     */
    private Double totalLossRatio;

    /**
     * 属性起赔点/起赔点
     */
    private Double triggerPoint;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDetailName() {
        return itemDetailName;
    }

    public void setItemDetailName(String itemDetailName) {
        this.itemDetailName = itemDetailName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Double getTotalLossRatio() {
        return totalLossRatio;
    }

    public void setTotalLossRatio(Double totalLossRatio) {
        this.totalLossRatio = totalLossRatio;
    }

    public Double getTriggerPoint() {
        return triggerPoint;
    }

    public void setTriggerPoint(Double triggerPoint) {
        this.triggerPoint = triggerPoint;
    }
}
