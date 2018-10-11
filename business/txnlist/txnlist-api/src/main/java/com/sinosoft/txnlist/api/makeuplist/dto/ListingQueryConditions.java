package com.sinosoft.txnlist.api.makeuplist.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 05/02/2018 2:51 PM
 */
public class ListingQueryConditions extends BasePageableRequest implements Serializable {
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

    private String fProvinceCode;
    private String fCityCode;
    private String fCountyCode;
    private String fTownCode;
    private String fVillageCode;
    private Integer serialNo;

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

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
}
