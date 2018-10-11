package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author 潘峰
 * @date 2017/11/13 上午11:31
 */
public class RequestInsuranceQueryDto extends BasePageableRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    private String insureListCode;

    /**
     * 属性清单别名/清单别名
     */
    private String listAlias;

    /**
     * 属性清单初始生成时间/清单初始生成时间
     */
    private String beginTime;

    /**
     * 属性清单最终确认时间/清单最终确认时间
     */
    private String endTime;

    /**
     * 属性清单最终确认的人员姓名/清单最终确认的人员姓名
     */
    private String affrimOpName;

    private String opName;

    /**
     * 清单归属区域（省级）代码-标准区划代码
     */
    private String fProvinceCode;
    /**
     * 清单归属区域（市级）代码-标准区划代码
     */
    private String fCityCode;
    /**
     * 清单归属区域（县/区级）代码-标准区划代码
     */
    private String fCountyCode;
    /**
     * 清单归属区域（镇级）代码-标准区划代码
     */
    private String fTownCode;
    /**
     * 清单归属区域（村级）代码-标准区划代码
     */
    private String fVillageCode;


    private List<String> fProvinceCodes;
    private List<String> fCityCodes;
    private List<String> fCountyCodes;
    private List<String> fTownCodes;
    private List<String> fVillageCodes;

    private Integer serialNo;

    /**
     * 出单向导页面，清单查询新增险种查询条件
     */
    private String riskCode;

    /**
     * 查询的场景，proposal:出单向导的清单查询;makeUpList:清单补录的清单查询
     */
    private String queryScenes;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getListAlias() {
        return listAlias;
    }

    public void setListAlias(String listAlias) {
        this.listAlias = listAlias;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAffrimOpName() {
        return affrimOpName;
    }

    public void setAffrimOpName(String affrimOpName) {
        this.affrimOpName = affrimOpName;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getfProvinceCode() {
        return fProvinceCode;
    }

    public void setfProvinceCode(String fProvinceCode) {
        this.fProvinceCode = fProvinceCode;
    }

    public String getfCityCode() {
        return fCityCode;
    }

    public void setfCityCode(String fCityCode) {
        this.fCityCode = fCityCode;
    }

    public String getfCountyCode() {
        return fCountyCode;
    }

    public void setfCountyCode(String fCountyCode) {
        this.fCountyCode = fCountyCode;
    }

    public String getfTownCode() {
        return fTownCode;
    }

    public void setfTownCode(String fTownCode) {
        this.fTownCode = fTownCode;
    }

    public String getfVillageCode() {
        return fVillageCode;
    }

    public void setfVillageCode(String fVillageCode) {
        this.fVillageCode = fVillageCode;
    }

    public List<String> getfProvinceCodes() {
        return fProvinceCodes;
    }

    public void setfProvinceCodes(List<String> fProvinceCodes) {
        this.fProvinceCodes = fProvinceCodes;
    }

    public List<String> getfCityCodes() {
        return fCityCodes;
    }

    public void setfCityCodes(List<String> fCityCodes) {
        this.fCityCodes = fCityCodes;
    }

    public List<String> getfCountyCodes() {
        return fCountyCodes;
    }

    public void setfCountyCodes(List<String> fCountyCodes) {
        this.fCountyCodes = fCountyCodes;
    }

    public List<String> getfTownCodes() {
        return fTownCodes;
    }

    public void setfTownCodes(List<String> fTownCodes) {
        this.fTownCodes = fTownCodes;
    }

    public List<String> getfVillageCodes() {
        return fVillageCodes;
    }

    public void setfVillageCodes(List<String> fVillageCodes) {
        this.fVillageCodes = fVillageCodes;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getQueryScenes() {
        return queryScenes;
    }

    public void setQueryScenes(String queryScenes) {
        this.queryScenes = queryScenes;
    }
}
