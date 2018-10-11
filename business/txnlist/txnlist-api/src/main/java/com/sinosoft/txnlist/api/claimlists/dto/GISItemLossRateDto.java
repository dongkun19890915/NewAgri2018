package com.sinosoft.txnlist.api.claimlists.dto;

import java.util.List;

/**
 * 理赔损失清单农户标的损失主信息
 * @author 王心洋
 * @time 2018-01-18
 */
public class GISItemLossRateDto {
    private static final long serialVersionUID = 1L;
    String lossAmount;//损失数量
    String lossRate;//损失率
    String lossMoney;//损失金额
    String fieldCode;//田块代码
    //理赔损失清单农户标的损失清单信息（养殖险耳标号清单）
    List<GISHerdLossDetailDto> herdLossDetailList;
    List<GISManLossDetailDto> manLossDetailList;

    public String getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(String lossAmount) {
        this.lossAmount = lossAmount;
    }

    public String getLossRate() {
        return lossRate;
    }

    public void setLossRate(String lossRate) {
        this.lossRate = lossRate;
    }

    public String getLossMoney() {
        return lossMoney;
    }

    public void setLossMoney(String lossMoney) {
        this.lossMoney = lossMoney;
    }

    public List<GISHerdLossDetailDto> getHerdLossDetailList() {
        return herdLossDetailList;
    }

    public void setHerdLossDetailList(List<GISHerdLossDetailDto> herdLossDetailList) {
        this.herdLossDetailList = herdLossDetailList;
    }

    public List<GISManLossDetailDto> getManLossDetailList() {
        return manLossDetailList;
    }

    public void setManLossDetailList(List<GISManLossDetailDto> manLossDetailList) {
        this.manLossDetailList = manLossDetailList;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }
}
