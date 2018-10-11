package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;

import java.text.DecimalFormat;

public class GetHerdInsuranceListExcelDto {
    @ExportConfig(value = "序号", width = 70)
    private String id;
    @ExportConfig(value = "投保单号", width = 180)
    private String proposalNo;
    @ExportConfig(value = "保单号", width = 180)
    private String policyNo;
    @ExportConfig(value = "农户代码", width = 150)
    private String fCode;
    @ExportConfig(value = "农户姓名")
    private String fName;
    @ExportConfig(value = "组织机构代码/身份证号码",width = 186)
    private String fIdCard;
    @ExportConfig(value = "银行卡号", width = 200)
    private String bankCard;
    @ExportConfig(value = "饲养地点", width = 200)
    private String breedingAreaName;
    @ExportConfig(value = "饲养品种")
    private String species;
    @ExportConfig(value = "饲养方式（规模/散养）", width = 168)
    private String breedingKind;
    @ExportConfig(value = "耳标号", width = 150)
    private String earlAbel;
    @ExportConfig(value = "险别", width = 150)
    private String riskName;
    @ExportConfig(value = "标的", width = 150)
    private String iTemName;
    @ExportConfig(value = "总保额（元）", width = 90)
    private String sumAmount;
    @ExportConfig(value = "有效保额（元）", width = 90)
    private String effAmount;
    @ExportConfig(value = "总保费（元）", width = 90)
    private String sumPremium;
    @ExportConfig(value = "自缴保费（元）", width = 150)
    private String insurePremium;
    @ExportConfig(value = "中央财政补贴（元）", width = 150)
    private String centralPremium;
    @ExportConfig(value = "省级财政补贴（元）", width = 150)
    private String provincePremium;
    @ExportConfig(value = "地市财政补贴（元）", width = 150)
    private String cityPremium;
    @ExportConfig(value = "区（县）财政（元）", width = 150)
    private String townPremium;
    @ExportConfig(value = "其他来源补贴（元）", width = 150)
    private String otherPremium;
    @ExportConfig(value = "备注", width = 150)
    private String remark;

    /**
     * 清单数据转换成下载Dto数据---单险别
     *
     * @param herdInsuranceListDto 清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 田慧
     * @date: 2017/12/8 上午 9:10
     */
    public GetHerdInsuranceListExcelDto getGetHerdInsuranceListExcelDto(HerdInsuranceListDto herdInsuranceListDto) {
        GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto = new GetHerdInsuranceListExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        //农户代码fCode
        getHerdInsuranceListExcelDto.setfCode(herdInsuranceListDto.getfCode());
        //农户姓名fName
        getHerdInsuranceListExcelDto.setfName(herdInsuranceListDto.getfName());
        //组织机构代码/身份证号码fIdCard
        getHerdInsuranceListExcelDto.setfIdCard(herdInsuranceListDto.getfIdCard());
        //银行卡号bankCard
        getHerdInsuranceListExcelDto.setBankCard(herdInsuranceListDto.getBankCard());
        //饲养地点breedingAreaName
        getHerdInsuranceListExcelDto.setBreedingAreaName(herdInsuranceListDto.getBreedingAreaName());
        //饲养品种species
        getHerdInsuranceListExcelDto.setSpecies(herdInsuranceListDto.getSpecies());
        //饲养方式（规模/散养）breedingKind
        getHerdInsuranceListExcelDto.setBreedingKind(herdInsuranceListDto.getBreedingKind());
        //耳标号earlAbel
        getHerdInsuranceListExcelDto.setEarlAbel(herdInsuranceListDto.getEarlAbel());
        //总保额（元）sumAmount
        getHerdInsuranceListExcelDto.setSumAmount(format.format(herdInsuranceListDto.getSumAmount()));
        //总保费（元）sumPremium
        getHerdInsuranceListExcelDto.setSumPremium(format.format(herdInsuranceListDto.getSumPremium()));
        //自缴保费（元）insurePremium
        getHerdInsuranceListExcelDto.setInsurePremium(format.format(herdInsuranceListDto.getInsurePremium()));
        //中央财政补贴（元）centralPremium
        getHerdInsuranceListExcelDto.setCentralPremium(format.format(herdInsuranceListDto.getCentralPremium()));
        //省级财政补贴（元）provincePremium
        getHerdInsuranceListExcelDto.setProvincePremium(format.format(herdInsuranceListDto.getProvincePremium()));
        //地市财政补贴（元）cityPremium
        getHerdInsuranceListExcelDto.setCityPremium(format.format(herdInsuranceListDto.getCityPremium()));
        //区（县）财政（元）townPremium
        getHerdInsuranceListExcelDto.setTownPremium(format.format(herdInsuranceListDto.getTownPremium()));
        //其他来源补贴（元）otherPremium
        getHerdInsuranceListExcelDto.setOtherPremium(format.format(herdInsuranceListDto.getOtherPremium()));
        //备注remark
        getHerdInsuranceListExcelDto.setRemark(herdInsuranceListDto.getRemark());

        return getHerdInsuranceListExcelDto;
    }
    /**
     * 清单数据转换成下载Dto数据--多险别
     *
     * @param nyxInsuranceListDto 清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 田慧
     * @date: 2017/12/8 上午 9:10
     */
    public GetHerdInsuranceListExcelDto getGetHerdInsuranceListExcelDto(NyxInsuranceListDto nyxInsuranceListDto) {
        GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto = new GetHerdInsuranceListExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        //农户代码fCode
        getHerdInsuranceListExcelDto.setfCode(nyxInsuranceListDto.getfCode());
        //农户姓名fName
        getHerdInsuranceListExcelDto.setfName(nyxInsuranceListDto.getfName());
        //组织机构代码/身份证号码fIdCard
        getHerdInsuranceListExcelDto.setfIdCard(nyxInsuranceListDto.getfIdCard());
        //银行卡号bankCard
        getHerdInsuranceListExcelDto.setBankCard(nyxInsuranceListDto.getBankCard());
        //饲养地点breedingAreaName
        getHerdInsuranceListExcelDto.setBreedingAreaName(nyxInsuranceListDto.getBreedingAreaName());
        //饲养品种species
        getHerdInsuranceListExcelDto.setSpecies(nyxInsuranceListDto.getSpecies());
        //饲养方式（规模/散养）breedingKind
        getHerdInsuranceListExcelDto.setBreedingKind(nyxInsuranceListDto.getBreedingKind());
        //耳标号earlAbel
        getHerdInsuranceListExcelDto.setEarlAbel(nyxInsuranceListDto.getBusinessNo());
        //总保额（元）sumAmount
        getHerdInsuranceListExcelDto.setSumAmount(format.format(nyxInsuranceListDto.getSumAmount()));
        //总保费（元）sumPremium
        getHerdInsuranceListExcelDto.setSumPremium(format.format(nyxInsuranceListDto.getSumPremium()));
        //自缴保费（元）insurePremium
        getHerdInsuranceListExcelDto.setInsurePremium(format.format(nyxInsuranceListDto.getfPremium()));
        //中央财政补贴（元）centralPremium
        getHerdInsuranceListExcelDto.setCentralPremium(format.format(nyxInsuranceListDto.getCentralPremium()));
        //省级财政补贴（元）provincePremium
        getHerdInsuranceListExcelDto.setProvincePremium(format.format(nyxInsuranceListDto.getProvincePremium()));
        //地市财政补贴（元）cityPremium
        getHerdInsuranceListExcelDto.setCityPremium(format.format(nyxInsuranceListDto.getCityPremium()));
        //区（县）财政（元）townPremium
        getHerdInsuranceListExcelDto.setTownPremium(format.format(nyxInsuranceListDto.getTownPremium()));
        //其他来源补贴（元）otherPremium
        getHerdInsuranceListExcelDto.setOtherPremium(format.format(nyxInsuranceListDto.getOtherPremium()));
        //备注remark
        getHerdInsuranceListExcelDto.setRemark(nyxInsuranceListDto.getRemark());

        return getHerdInsuranceListExcelDto;
    }
    /**
     * 清单数据转换成下载Dto数据-
     * @param acceptInsuranceDto 清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 田慧
     * @date: 2017/12/8 上午 9:10
     */
    public GetHerdInsuranceListExcelDto getInsureListInfoExcelDto(AcceptInsuranceDto acceptInsuranceDto) {
        GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto = new GetHerdInsuranceListExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        //农户代码fCode
        getHerdInsuranceListExcelDto.setfCode(acceptInsuranceDto.getfCode());
        //农户姓名fName
        getHerdInsuranceListExcelDto.setfName(acceptInsuranceDto.getfName());
        //组织机构代码/身份证号码fIdCard
        getHerdInsuranceListExcelDto.setfIdCard(acceptInsuranceDto.getfIdCard());
        //银行卡号bankCard
        getHerdInsuranceListExcelDto.setBankCard(acceptInsuranceDto.getZhiBuKa());
        //有效保额
        getHerdInsuranceListExcelDto.setEffAmount(acceptInsuranceDto.getEffAmount());
        //饲养地点breedingAreaName
        getHerdInsuranceListExcelDto.setBreedingAreaName(acceptInsuranceDto.getBreedingAreaName());
        //饲养品种species
        getHerdInsuranceListExcelDto.setSpecies(acceptInsuranceDto.getSpecies());
        //饲养方式（规模/散养）breedingKind
        getHerdInsuranceListExcelDto.setBreedingKind(acceptInsuranceDto.getBreedingKind());
        //耳标号earlAbel
        getHerdInsuranceListExcelDto.setEarlAbel(acceptInsuranceDto.getEarlAbel());
        //总保额（元）sumAmount
        getHerdInsuranceListExcelDto.setSumAmount(acceptInsuranceDto.getSumAmount());
        //总保费（元）sumPremium
        getHerdInsuranceListExcelDto.setSumPremium(acceptInsuranceDto.getSumPremium());
        //自缴保费（元）insurePremium
        getHerdInsuranceListExcelDto.setInsurePremium(acceptInsuranceDto.getfPremium());
        //中央财政补贴（元）centralPremium
        getHerdInsuranceListExcelDto.setCentralPremium(acceptInsuranceDto.getCentralPremium());
        //省级财政补贴（元）provincePremium
        getHerdInsuranceListExcelDto.setProvincePremium(acceptInsuranceDto.getProvincePremium());
        //地市财政补贴（元）cityPremium
        getHerdInsuranceListExcelDto.setCityPremium(acceptInsuranceDto.getCityPremium());
        //区（县）财政（元）townPremium
        getHerdInsuranceListExcelDto.setTownPremium(acceptInsuranceDto.getTownPremium());
        //其他来源补贴（元）otherPremium
        getHerdInsuranceListExcelDto.setOtherPremium(acceptInsuranceDto.getOtherPremium());
        //备注remark
        getHerdInsuranceListExcelDto.setRemark(acceptInsuranceDto.getRemark());

        return getHerdInsuranceListExcelDto;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
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

    public String getEarlAbel() {
        return earlAbel;
    }

    public void setEarlAbel(String earlAbel) {
        this.earlAbel = earlAbel;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getiTemName() {
        return iTemName;
    }

    public void setiTemName(String iTemName) {
        this.iTemName = iTemName;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getInsurePremium() {
        return insurePremium;
    }

    public void setInsurePremium(String insurePremium) {
        this.insurePremium = insurePremium;
    }

    public String getCentralPremium() {
        return centralPremium;
    }

    public void setCentralPremium(String centralPremium) {
        this.centralPremium = centralPremium;
    }

    public String getProvincePremium() {
        return provincePremium;
    }

    public void setProvincePremium(String provincePremium) {
        this.provincePremium = provincePremium;
    }

    public String getCityPremium() {
        return cityPremium;
    }

    public void setCityPremium(String cityPremium) {
        this.cityPremium = cityPremium;
    }

    public String getTownPremium() {
        return townPremium;
    }

    public void setTownPremium(String townPremium) {
        this.townPremium = townPremium;
    }

    public String getOtherPremium() {
        return otherPremium;
    }

    public void setOtherPremium(String otherPremium) {
        this.otherPremium = otherPremium;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEffAmount() {        return effAmount;    }

    public void setEffAmount(String effAmount) {        this.effAmount = effAmount;    }
}
