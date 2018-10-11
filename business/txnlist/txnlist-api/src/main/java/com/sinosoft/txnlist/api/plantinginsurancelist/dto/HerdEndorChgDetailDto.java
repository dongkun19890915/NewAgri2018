package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-14 07:07:05.012
 * 养殖险保单清单最新数据表Api操作对象
 */
public class HerdEndorChgDetailDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 序号
     */
    @ExportConfig(value = "序号", width = 50)
    private int serialNo;
    /**
     * 属性批单号/批单号
     */
    @ExportConfig(value = "批单号", width = 220)
    private String endorseNo;
    /**
     * 保单号
     */
    @ExportConfig(value = "保单号", width = 200)
    private String policyNo;
    /**
     * 属性保险起期/保险起期
     */
    private java.util.Date startDate;
    /**
     * 属性保险起期/保险起期
     */
    @ExportConfig(value = "保险起期", width = 130)
    private String startDateStr;
    /**
     * 属性保险止期/保险止期
     */
    private java.util.Date endDate;
    /**
     * 属性保险止期/保险止期
     */
    @ExportConfig(value = "保险止期", width = 130)
    private String endDateStr;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    @ExportConfig(value = "农户代码", width = 170)
    private String fCode;
    /**
     * 属性农户姓名/农户姓名
     */
    @ExportConfig(value = "农户姓名", width = 120)
    private String fName;
    /**
     * 属性农户身份证/农户身份证
     */
    @ExportConfig(value = "身份证号码", width = 170)
    private String fIdCard;
    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */
    @ExportConfig(value = "银行卡号", width = 210)
    private String zhiBuKa;
    /**
     * 属性联系电话号码/联系电话号码
     */
    @ExportConfig(value = "联系电话", width = 120)
    private String phone;
    /**
     * 属性投保面积/投保面积
     */
    @ExportConfig(value = "投保面积（亩）")
    private Double insureArea;
    /**
     * 属性险别序号（key）/险别名称
     */
    @ExportConfig(value = "险别")
    private String kindName;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    private String kindCode;
    /**
     * 属性标的名称
     */
    @ExportConfig(value = "标的")
    private String itemName;
    /**
     * 属性标的代码
     */
    private String itemCode;
    /**
     * 属性总保额/总保额
     */
    @ExportConfig(value = "总保额（元）")
    private Double sumAmount;
    /**
     * 属性总保费/总保费
     */
    @ExportConfig(value = "总保费（元）")
    private Double sumPremium;
    /**
     * 属性短期费率方式/短期费率方式
     */
    @ExportConfig(value = "短期费率方式")
    private String shortRateFlag;
    /**
     * 属性短期费率/短期费率
     */
    @ExportConfig(value = "短期费率")
    private Double shortRate;
    /**
     * 属性农民自缴保费/农民自缴保费
     */
    @ExportConfig(value = "自缴保费（元）")
    private Double insurePremium;
    /**
     * 属性中央财政补贴/中央财政补贴
     */
    @ExportConfig(value = "中央财政补贴（元）")
    private Double centralPremium;
    /**
     * 属性省级财政补贴/省级财政补贴
     */
    @ExportConfig(value = "省级财政补贴（元）")
    private Double provincePremium;
    /**
     * 属性地市财政补贴/地市财政补贴
     */
    @ExportConfig(value = "地市财政补贴（元）")
    private Double cityPremium;
    /**
     * 属性县(区)财政补贴/县(区)财政补贴
     */
    @ExportConfig(value = "区县财政补贴（元）")
    private Double townPremium;
    /**
     * 属性其他来源补贴/其他来源补贴
     */
    @ExportConfig(value = "其他补贴（元）")
    private Double otherPremium;
    /**
     * 属性保额变化量/保额变化量
     */
    @ExportConfig(value = "变化保额（元）")
    private Double chgSumAmount;
    /**
     * 属性保费变化量/保费变化量
     */
    @ExportConfig(value = "变化保费（元）")
    private Double chgSumPremium;
    /**
     * 自缴保费变化量
     */
    @ExportConfig(value = "变化自缴保费（元）")
    private Double chgFPremium;
    /**
     * 中央财政补贴变化量
     */
    @ExportConfig(value = "变化中央财政补贴（元）")
    private Double chgCentralPremium;
    /**
     * 省级财政补贴变化量
     */
    @ExportConfig(value = "变化省级财政补贴（元）")
    private Double chgProvincePremium;
    /**
     * 地市财政补贴变化量
     */
    @ExportConfig(value = "变化地市财政补贴（元）")
    private Double chgCityPremium;
    /**
     * 区（县）财政变化量
     */
    @ExportConfig(value = "变化区县财政补贴（元）")
    private Double chgTownPremium;
    /**
     * 其他来源补贴变化量
     */
    @ExportConfig(value = "变化其他补贴（元）")
    private Double chgOtherPremium;
    /**
     * 属性修改标志位/修改标志位
     */
    @ExportConfig(value = "批改类型")
    private String flag;

    /**
     * 属性投保清单编号/投保清单编号
     */
    private String inusreListCode;
    /**
     * 属性耳标号/耳标号
     */
    private String earLabel;
    /**
     * 属性排序序号/排序序号
     */
    private String indexCode;
    /**
     * 属性养殖地点代码/养殖地点代码
     */
    private String breedingAreaCode;
    /**
     * 属性养殖品种/养殖品种
     */
    private String species;
    /**
     * 属性养殖方式/养殖方式
     */
    private String breedingKind;
    /**
     * 属性开户银行/开户银行
     */
    private String bank;
    /**
     * 属性银行卡帐号/银行卡帐号
     */
    private String bankCard;
    /**
     * 属性投保数量/投保数量
     */
    private Integer insureNumber;
    /**
     * 属性单位保额/单位保额
     */
    private Double amount;
    /**
     * 属性费率/费率
     */
    private Double rate;
    /**
     * 属性主险标志（Y是、N否）/主险标志（Y是、N否）
     */
    private String calculateFlag;
    /**
     * 属性操作员代码/操作员代码
     */
    private String opCode;
    /**
     * 属性操作时间/操作时间
     */
    private Date opTime;
    /**
     * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交
     */
    private String validity;
    /**
     * 属性备注/备注
     */
    private String remark;
    /**
     * 属性养殖数量/养殖数量
     */
    private Integer breedingNumber;
    /**
     * 属性养殖地点名称/养殖地点名称
     */
    private String breedingAreaName;
    /**
     * 属性开始时间/开始时间
     */
    private String startTime;
    /**
     * 属性终止时间/终止时间
     */
    private String endTime;
    /**
     * 属性赔付数量/赔付数量
     */
    private Integer settleNumber;
    /**
     * 属性投保数量变化量/投保数量变化量
     */
    private Integer chgInsureNumber;
    /**
     * 属性areaNumber/areaNumber
     */
    private Double areaNumber;
    /**
     * 属性chgAreaNumber/chgAreaNumber
     */
    private Double chgAreaNumber;
    /**
     * 属性litterArea/litterArea
     */
    private String litterArea;
    /**
     * 属性畜龄/畜龄
     */
    private Double animalAge;

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
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

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getZhiBuKa() {
        return zhiBuKa;
    }

    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    public Double getShortRate() {
        return shortRate;
    }

    public void setShortRate(Double shortRate) {
        this.shortRate = shortRate;
    }

    public Double getInsurePremium() {
        return insurePremium;
    }

    public void setInsurePremium(Double insurePremium) {
        this.insurePremium = insurePremium;
    }

    public Double getCentralPremium() {
        return centralPremium;
    }

    public void setCentralPremium(Double centralPremium) {
        this.centralPremium = centralPremium;
    }

    public Double getProvincePremium() {
        return provincePremium;
    }

    public void setProvincePremium(Double provincePremium) {
        this.provincePremium = provincePremium;
    }

    public Double getCityPremium() {
        return cityPremium;
    }

    public void setCityPremium(Double cityPremium) {
        this.cityPremium = cityPremium;
    }

    public Double getTownPremium() {
        return townPremium;
    }

    public void setTownPremium(Double townPremium) {
        this.townPremium = townPremium;
    }

    public Double getOtherPremium() {
        return otherPremium;
    }

    public void setOtherPremium(Double otherPremium) {
        this.otherPremium = otherPremium;
    }

    public Double getChgSumAmount() {
        return chgSumAmount;
    }

    public void setChgSumAmount(Double chgSumAmount) {
        this.chgSumAmount = chgSumAmount;
    }

    public Double getChgSumPremium() {
        return chgSumPremium;
    }

    public void setChgSumPremium(Double chgSumPremium) {
        this.chgSumPremium = chgSumPremium;
    }

    public Double getChgFPremium() {
        return chgFPremium;
    }

    public void setChgFPremium(Double chgFPremium) {
        this.chgFPremium = chgFPremium;
    }

    public Double getChgCentralPremium() {
        return chgCentralPremium;
    }

    public void setChgCentralPremium(Double chgCentralPremium) {
        this.chgCentralPremium = chgCentralPremium;
    }

    public Double getChgProvincePremium() {
        return chgProvincePremium;
    }

    public void setChgProvincePremium(Double chgProvincePremium) {
        this.chgProvincePremium = chgProvincePremium;
    }

    public Double getChgCityPremium() {
        return chgCityPremium;
    }

    public void setChgCityPremium(Double chgCityPremium) {
        this.chgCityPremium = chgCityPremium;
    }

    public Double getChgTownPremium() {
        return chgTownPremium;
    }

    public void setChgTownPremium(Double chgTownPremium) {
        this.chgTownPremium = chgTownPremium;
    }

    public Double getChgOtherPremium() {
        return chgOtherPremium;
    }

    public void setChgOtherPremium(Double chgOtherPremium) {
        this.chgOtherPremium = chgOtherPremium;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreedingKind() {
        return breedingKind;
    }

    public void setBreedingKind(String breedingKind) {
        this.breedingKind = breedingKind;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Integer getInsureNumber() {
        return insureNumber;
    }

    public void setInsureNumber(Integer insureNumber) {
        this.insureNumber = insureNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCalculateFlag() {
        return calculateFlag;
    }

    public void setCalculateFlag(String calculateFlag) {
        this.calculateFlag = calculateFlag;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getSettleNumber() {
        return settleNumber;
    }

    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
    }

    public Integer getChgInsureNumber() {
        return chgInsureNumber;
    }

    public void setChgInsureNumber(Integer chgInsureNumber) {
        this.chgInsureNumber = chgInsureNumber;
    }

    public Double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Double getChgAreaNumber() {
        return chgAreaNumber;
    }

    public void setChgAreaNumber(Double chgAreaNumber) {
        this.chgAreaNumber = chgAreaNumber;
    }

    public String getLitterArea() {
        return litterArea;
    }

    public void setLitterArea(String litterArea) {
        this.litterArea = litterArea;
    }

    public Double getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Double animalAge) {
        this.animalAge = animalAge;
    }
}
