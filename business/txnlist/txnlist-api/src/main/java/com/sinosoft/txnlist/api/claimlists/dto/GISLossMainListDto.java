package com.sinosoft.txnlist.api.claimlists.dto;

import java.util.List;

/**
 * 理赔损失清单主信息
 * @author 王心洋
 * @time 2018-01-18
 */
public class GISLossMainListDto {

    private static final long serialVersionUID = 1L;

    String lossListCode;    //清单编号
    String bizNo;           //业务单号(保单号/报案号/立案号)
    String policyNo;        //保单号</policyNo>
    String listCreateTime;  //清单初始生成时间
    String opCode;          //清单缮制人代码
    String opName;          //清单缮制人姓名
    String listAffrimTime;  //清单最终确认时间
    String affrimopCode;    //清单最终确认的人员代码
    String affrimopName;    //清单最终确认的人员姓名
    String exploreArea;     //查勘地点
    String exploreTime;     //查勘时间
    String remark;          //清单备注
    String checkId;         //查勘编号
    String disasterArea;    //受灾面积
    String affectedArea;    //成灾面积
    String noProductionArea;//绝产面积
    String deathQuantity;   //死亡数量
    String killQuantity;    //扑杀数量
    String checkContext;    //查勘报告
    List<GISFarmerDto> farmerList;//理赔损失清单农户信息

    public String getLossListCode() {
        return lossListCode;
    }

    public void setLossListCode(String lossListCode) {
        this.lossListCode = lossListCode;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getListCreateTime() {
        return listCreateTime;
    }

    public void setListCreateTime(String listCreateTime) {
        this.listCreateTime = listCreateTime;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getListAffrimTime() {
        return listAffrimTime;
    }

    public void setListAffrimTime(String listAffrimTime) {
        this.listAffrimTime = listAffrimTime;
    }

    public String getAffrimopCode() {
        return affrimopCode;
    }

    public void setAffrimopCode(String affrimopCode) {
        this.affrimopCode = affrimopCode;
    }

    public String getAffrimopName() {
        return affrimopName;
    }

    public void setAffrimopName(String affrimopName) {
        this.affrimopName = affrimopName;
    }

    public String getExploreArea() {
        return exploreArea;
    }

    public void setExploreArea(String exploreArea) {
        this.exploreArea = exploreArea;
    }

    public String getExploreTime() {
        return exploreTime;
    }

    public void setExploreTime(String exploreTime) {
        this.exploreTime = exploreTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<GISFarmerDto> getFarmerList() {
        return farmerList;
    }

    public void setFarmerList(List<GISFarmerDto> farmerList) {
        this.farmerList = farmerList;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getDisasterArea() {
        return disasterArea;
    }

    public void setDisasterArea(String disasterArea) {
        this.disasterArea = disasterArea;
    }

    public String getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    public String getNoProductionArea() {
        return noProductionArea;
    }

    public void setNoProductionArea(String noProductionArea) {
        this.noProductionArea = noProductionArea;
    }

    public String getDeathQuantity() {
        return deathQuantity;
    }

    public void setDeathQuantity(String deathQuantity) {
        this.deathQuantity = deathQuantity;
    }

    public String getKillQuantity() {
        return killQuantity;
    }

    public void setKillQuantity(String killQuantity) {
        this.killQuantity = killQuantity;
    }

    public String getCheckContext() {
        return checkContext;
    }

    public void setCheckContext(String checkContext) {
        this.checkContext = checkContext;
    }
}
