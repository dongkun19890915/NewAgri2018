package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31InsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;

import java.text.DecimalFormat;

/**
 * 业务清单查询结果数据，将数据导出到Excel中时需要添加@ExportConfig注解
 *
 * @author: 钱浩
 * @date: 2017/12/6 上午 11:12
 */
public class ResponsePlantingExcelDto {

    /**
     * 序号
     */
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
    @ExportConfig(value = "数量(亩)")
    private String taxArea;
    @ExportConfig(value = "身份证号码", width = 180)
    private String idCard;
    @ExportConfig(value = "银行卡号", width = 200)
    private String zhiBuKa;
    @ExportConfig(value = "联系电话")
    private String phone;
    @ExportConfig(value = "险别", width = 150)
    private String riskName;
    @ExportConfig(value = "标的", width = 150)
    private String iTemName;
    @ExportConfig(value = "总保额(元)", width = 90)
    private String sumAmount;
    @ExportConfig(value = "总保费(元)", width = 90)
    private String sumPremium;
    @ExportConfig(value = "有效保额(元)", width = 90)
    private String effAmount;
    @ExportConfig(value = "自缴保费(元)", width = 90)
    private String premium;
    @ExportConfig(value = "中央财政补贴(元)", width = 90)
    private String centralPremium;
    @ExportConfig(value = "省级财政补贴(元)", width = 90)
    private String provincePremium;
    @ExportConfig(value = "地市财政补贴(元)", width = 90)
    private String cityPremium;
    @ExportConfig(value = "区(县)\r\n财政(元)", width = 90)
    private String townPremium;
    @ExportConfig(value = "其他来源补贴(元)", width = 90)
    private String otherPremium;
    @ExportConfig(value = "粮补面积")
    private String atArea;
    @ExportConfig(value = "土地来源")
    private String fieldSource;
    @ExportConfig(value = "备注")
    private String remark;


    /**
     * 清单数据转换成下载Dto数据
     *
     * @param plantingInsuranceListDto 清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 钱浩
     * @date: 2017/12/8 上午 9:10
     */
    public ResponsePlantingExcelDto getResponsePlantingExcelDto(PlantingInsuranceListDto plantingInsuranceListDto) {
        ResponsePlantingExcelDto responsePlantingExcelDto = new ResponsePlantingExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        responsePlantingExcelDto.setfCode(plantingInsuranceListDto.getfCode()); //农号
        responsePlantingExcelDto.setfName(plantingInsuranceListDto.getfName());//农名
        responsePlantingExcelDto.setTaxArea(format.format(plantingInsuranceListDto.getInsureArea()));//农投保面积
        responsePlantingExcelDto.setIdCard(plantingInsuranceListDto.getfIdCard()); //农证
        responsePlantingExcelDto.setZhiBuKa(plantingInsuranceListDto.getZhiBuKa());//银行号
        responsePlantingExcelDto.setPhone(plantingInsuranceListDto.getPhone());//电话
        responsePlantingExcelDto.setSumAmount(format.format(plantingInsuranceListDto.getSumAmount()));//总保额
        responsePlantingExcelDto.setSumPremium(format.format(plantingInsuranceListDto.getSumPremium()));//总保费
        responsePlantingExcelDto.setPremium(format.format(plantingInsuranceListDto.getfPremium()));//总保费
        responsePlantingExcelDto.setCentralPremium(format.format(plantingInsuranceListDto.getCentralPremium()));//中央财
        responsePlantingExcelDto.setProvincePremium(format.format(plantingInsuranceListDto.getProvincePremium()));//省级财
        responsePlantingExcelDto.setCityPremium(format.format(plantingInsuranceListDto.getCityPremium()));//地市财
        responsePlantingExcelDto.setTownPremium(format.format(plantingInsuranceListDto.getTownPremium()));//区域财
        responsePlantingExcelDto.setOtherPremium(format.format(plantingInsuranceListDto.getOtherPremium()));//区域财
        responsePlantingExcelDto.setAtArea(plantingInsuranceListDto.getAtArea());//粮补
        responsePlantingExcelDto.setFieldSource(plantingInsuranceListDto.getFieldSource());//土地
        responsePlantingExcelDto.setRemark(plantingInsuranceListDto.getRemark());//备注
        return responsePlantingExcelDto;
    }
    /**
     * 清单数据转换成下载Dto数据
     *
     * @param nyxInsuranceListDto 清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 钱浩
     * @date: 2017/12/8 上午 9:10
     */
    public ResponsePlantingExcelDto getResponsePlantingExcelDto(NyxInsuranceListDto nyxInsuranceListDto) {
        ResponsePlantingExcelDto responsePlantingExcelDto = new ResponsePlantingExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        responsePlantingExcelDto.setfCode(nyxInsuranceListDto.getfCode()); //农号
        responsePlantingExcelDto.setfName(nyxInsuranceListDto.getfName());//农名
        responsePlantingExcelDto.setTaxArea(format.format(nyxInsuranceListDto.getInsureArea()));//农投保面积
        responsePlantingExcelDto.setIdCard(nyxInsuranceListDto.getfIdCard()); //农证
        responsePlantingExcelDto.setZhiBuKa(nyxInsuranceListDto.getZhiBuKa());//银行号
        responsePlantingExcelDto.setPhone(nyxInsuranceListDto.getPhone());//电话
        responsePlantingExcelDto.setSumAmount(format.format(nyxInsuranceListDto.getSumAmount()));//总保额
        responsePlantingExcelDto.setSumPremium(format.format(nyxInsuranceListDto.getSumPremium()));//总保费
        responsePlantingExcelDto.setPremium(format.format(nyxInsuranceListDto.getfPremium()));//总保费
        responsePlantingExcelDto.setCentralPremium(format.format(nyxInsuranceListDto.getCentralPremium()));//中央财
        responsePlantingExcelDto.setProvincePremium(format.format(nyxInsuranceListDto.getProvincePremium()));//省级财
        responsePlantingExcelDto.setCityPremium(format.format(nyxInsuranceListDto.getCityPremium()));//地市财
        responsePlantingExcelDto.setTownPremium(format.format(nyxInsuranceListDto.getTownPremium()));//区域财
        responsePlantingExcelDto.setOtherPremium(format.format(nyxInsuranceListDto.getOtherPremium()));//区域财
        responsePlantingExcelDto.setOtherPremium(format.format(nyxInsuranceListDto.getOtherPremium()));//区域财
        responsePlantingExcelDto.setAtArea(nyxInsuranceListDto.getAtArea() ==null || ("null").equals(nyxInsuranceListDto.getAtArea()) ?"":nyxInsuranceListDto.getAtArea());//粮补
        responsePlantingExcelDto.setFieldSource(nyxInsuranceListDto.getFieldSource() ==null || ("null").equals(nyxInsuranceListDto.getFieldSource()) ?"":nyxInsuranceListDto.getFieldSource());//土地
        responsePlantingExcelDto.setRemark(nyxInsuranceListDto.getRemark());//备注
        return responsePlantingExcelDto;
    }
    /**
     * 清单数据转换成下载Dto数据
     *
     * @param planting31InsuranceListDto 31大棚蔬菜清单数据对象
     * @return ResponsePlantingExcelDto
     * @author: 钱浩
     * @date: 2017/12/8 上午 9:10
     */
    public ResponsePlantingExcelDto getResponsePlanting31ExcelDto(Planting31InsuranceListDto planting31InsuranceListDto) {
        ResponsePlantingExcelDto responsePlantingExcelDto = new ResponsePlantingExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        responsePlantingExcelDto.setfCode(planting31InsuranceListDto.getfCode()); //农号
        responsePlantingExcelDto.setfName(planting31InsuranceListDto.getfName());//农名
        responsePlantingExcelDto.setTaxArea(format.format(planting31InsuranceListDto.getInsureArea()));//农投保面积
        responsePlantingExcelDto.setIdCard(planting31InsuranceListDto.getfIdCard()); //农证
        responsePlantingExcelDto.setZhiBuKa(planting31InsuranceListDto.getZhiBuKa());//银行号
        responsePlantingExcelDto.setPhone(planting31InsuranceListDto.getPhone());//电话
        responsePlantingExcelDto.setSumAmount(format.format(planting31InsuranceListDto.getSumAmount()));//总保额
        responsePlantingExcelDto.setSumPremium(format.format(planting31InsuranceListDto.getSumPremium()));//总保费
        responsePlantingExcelDto.setPremium(format.format(planting31InsuranceListDto.getfPremium()));//总保费
        responsePlantingExcelDto.setCentralPremium(format.format(planting31InsuranceListDto.getCentralPremium()));//中央财
        responsePlantingExcelDto.setProvincePremium(format.format(planting31InsuranceListDto.getProvincePremium()));//省级财
        responsePlantingExcelDto.setCityPremium(format.format(planting31InsuranceListDto.getCityPremium()));//地市财
        responsePlantingExcelDto.setTownPremium(format.format(planting31InsuranceListDto.getTownPremium()));//区域财
        responsePlantingExcelDto.setOtherPremium(format.format(planting31InsuranceListDto.getOtherPremium()));//区域财
        responsePlantingExcelDto.setOtherPremium(format.format(planting31InsuranceListDto.getOtherPremium()));//区域财
        responsePlantingExcelDto.setAtArea("");//粮补
        responsePlantingExcelDto.setFieldSource(planting31InsuranceListDto.getFieldSource() == null || ("null").equals(planting31InsuranceListDto.getFieldSource())?"":planting31InsuranceListDto.getFieldSource());//土地
        responsePlantingExcelDto.setRemark(planting31InsuranceListDto.getRemark());//备注
        return responsePlantingExcelDto;
    }

    /**
     * 承保分户清单数据转换Dto
     * @author: 田健
     * @date: 2018/4/11 17:14
     * @param acceptInsuranceDto 清单信息
     * @return 转换后下载的数据信息
     */
    public ResponsePlantingExcelDto getInsureListInfoExcelDto(AcceptInsuranceDto acceptInsuranceDto) {
        ResponsePlantingExcelDto responsePlantingExcelDto = new ResponsePlantingExcelDto();
        DecimalFormat format = new DecimalFormat("0.00");
        responsePlantingExcelDto.setfCode(acceptInsuranceDto.getfCode()); //农号
        responsePlantingExcelDto.setfName(acceptInsuranceDto.getfName());//农名
        responsePlantingExcelDto.setTaxArea(acceptInsuranceDto.getInsureArea());//农投保面积
        responsePlantingExcelDto.setIdCard(acceptInsuranceDto.getfIdCard()); //农证
        responsePlantingExcelDto.setZhiBuKa(acceptInsuranceDto.getZhiBuKa());//银行号
        responsePlantingExcelDto.setEffAmount(acceptInsuranceDto.getEffAmount());//有效保额
        responsePlantingExcelDto.setPhone(acceptInsuranceDto.getPhone());//电话
        responsePlantingExcelDto.setSumAmount(acceptInsuranceDto.getSumAmount());//总保额
        responsePlantingExcelDto.setSumPremium(acceptInsuranceDto.getSumPremium());//总保费
        responsePlantingExcelDto.setPremium(acceptInsuranceDto.getfPremium());//总保费
        responsePlantingExcelDto.setCentralPremium(acceptInsuranceDto.getCentralPremium());//中央财
        responsePlantingExcelDto.setProvincePremium(acceptInsuranceDto.getProvincePremium());//省级财
        responsePlantingExcelDto.setCityPremium(acceptInsuranceDto.getCityPremium());//地市财
        responsePlantingExcelDto.setTownPremium(acceptInsuranceDto.getTownPremium());//区域财
        responsePlantingExcelDto.setOtherPremium(acceptInsuranceDto.getOtherPremium());//区域财
        responsePlantingExcelDto.setAtArea(acceptInsuranceDto.getAtArea()==null || ("null").equals(acceptInsuranceDto.getAtArea()) ?"":acceptInsuranceDto.getAtArea());//粮补
        responsePlantingExcelDto.setFieldSource(acceptInsuranceDto.getFieldSource()==null|| ("null").equals(acceptInsuranceDto.getFieldSource())?"":acceptInsuranceDto.getFieldSource());//土地
        responsePlantingExcelDto.setRemark(acceptInsuranceDto.getRemark());//备注
        return responsePlantingExcelDto;
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

    public String getTaxArea() {
        return taxArea;
    }

    public void setTaxArea(String taxArea) {
        this.taxArea = taxArea;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
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

    public String getAtArea() {
        return atArea;
    }

    public void setAtArea(String atArea) {
        this.atArea = atArea;
    }

    public String getFieldSource() {
        return fieldSource;
    }

    public void setFieldSource(String fieldSource) {
        this.fieldSource = fieldSource;
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
