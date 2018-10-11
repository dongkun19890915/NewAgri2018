package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * 投保预确认数据主表实体操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:40
 */
@Entity
@Table(name = "GisInsureMainList")
@IdClass(GisInsureMainListKey.class)
public class GisInsureMainList extends BaseEntityImpl {

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
     * 属性清单别名/清单别名
     */
    @Column(name = "listAlias")
    private String listAlias;
    /**
     * 属性清单类型标志/清单类型标志
     */
    @Column(name = "listTypeFlag")
    private String listTypeFlag;
    /**
     * 属性清单类型/清单类型
     */
    @Column(name = "listType")
    private String listType;
    /**
     * 属性清单归属区域（省级）代码-标准区划代码/清单归属区域（省级）代码-标准区划代码
     */
    @Column(name = "fProvinceCode")
    private String fProvinceCode;
    /**
     * 属性清单归属区域（省级）名称-标准区划代码/清单归属区域（省级）名称-标准区划代码
     */
    @Column(name = "fProvinceName")
    private String fProvinceName;
    /**
     * 属性清单归属区域（市级）代码-标准区划代码/清单归属区域（市级）代码-标准区划代码
     */
    @Column(name = "fCityCode")
    private String fCityCode;
    /**
     * 属性清单归属区域（市级）名称-标准区划代码/清单归属区域（市级）名称-标准区划代码
     */
    @Column(name = "fCityName")
    private String fCityName;
    /**
     * 属性清单归属区域（县/区级）代码-标准区划代码/清单归属区域（县/区级）代码-标准区划代码
     */
    @Column(name = "fCountyCode")
    private String fCountyCode;
    /**
     * 属性清单归属区域（县/区级）名称-标准区划代码/清单归属区域（县/区级）名称-标准区划代码
     */
    @Column(name = "fCountyName")
    private String fCountyName;
    /**
     * 属性清单归属区域（镇级）代码-标准区划代码/清单归属区域（镇级）代码-标准区划代码
     */
    @Column(name = "fTownCode")
    private String fTownCode;
    /**
     * 属性清单归属区域（镇级）名称-标准区划代码/清单归属区域（镇级）名称-标准区划代码
     */
    @Column(name = "fTownName")
    private String fTownName;
    /**
     * 属性清单归属区域（村级）代码-标准区划代码/清单归属区域（村级）代码-标准区划代码
     */
    @Column(name = "fVillageCode")
    private String fVillageCode;
    /**
     * 属性清单归属区域（村级）名称-标准区划代码/清单归属区域（村级）名称-标准区划代码
     */
    @Column(name = "fVillageName")
    private String fVillageName;
    /**
     * 属性清单归属区域（省级）代码-平台行政区划/清单归属区域（省级）代码-平台行政区划
     */
    @Column(name = "pProvinceCode")
    private String pProvinceCode;
    /**
     * 属性清单归属区域（省级）名称-平台行政区划/清单归属区域（省级）名称-平台行政区划
     */
    @Column(name = "pProvinceName")
    private String pProvinceName;
    /**
     * 属性清单归属区域（市级）代码-平台行政区划/清单归属区域（市级）代码-平台行政区划
     */
    @Column(name = "pCityCode")
    private String pCityCode;
    /**
     * 属性清单归属区域（市级）名称-平台行政区划/清单归属区域（市级）名称-平台行政区划
     */
    @Column(name = "pCityName")
    private String pCityName;
    /**
     * 属性清单归属区域（县/区级）代码-平台行政区划/清单归属区域（县/区级）代码-平台行政区划
     */
    @Column(name = "pCountyCode")
    private String pCountyCode;
    /**
     * 属性清单归属区域（县/区级）名称-平台行政区划/清单归属区域（县/区级）名称-平台行政区划
     */
    @Column(name = "pCountyName")
    private String pCountyName;
    /**
     * 属性清单归属区域（镇级）代码-平台行政区划/清单归属区域（镇级）代码-平台行政区划
     */
    @Column(name = "pTownCode")
    private String pTownCode;
    /**
     * 属性清单归属区域（镇级）名称-平台行政区划/清单归属区域（镇级）名称-平台行政区划
     */
    @Column(name = "pTownName")
    private String pTownName;
    /**
     * 属性清单归属区域（村级）代码-平台行政区划/清单归属区域（村级）代码-平台行政区划
     */
    @Column(name = "pVillageCode")
    private String pVillageCode;
    /**
     * 属性清单归属区域（村级）名称-平台行政区划/清单归属区域（村级）名称-平台行政区划
     */
    @Column(name = "pVillageName")
    private String pVillageName;
    /**
     * 属性农户数量/农户数量
     */
    @Column(name = "fCount")
    private Integer fCount;
    /**
     * 属性是否gis端生成标志/是否gis端生成标志
     */
    @Column(name = "gisFlag")
    private String gisFlag;
    /**
     * 属性是否最新保单标志/是否最新保单标志
     */
    @Column(name = "newFlag")
    private String newFlag;
    /**
     * 属性清单缮制时间/清单缮制时间
     */
    @Column(name = "listCreateTime")
    private Date listCreateTime;
    /**
     * 属性清单缮制人代码/清单缮制人代码
     */
    @Column(name = "opCode")
    private String opCode;
    /**
     * 属性清单缮制人姓名/清单缮制人姓名
     */
    @Column(name = "opName")
    private String opName;
    /**
     * 属性清单最终确认时间/清单最终确认时间
     */
    @Column(name = "listAffrimTime")
    private Date listAffrimTime;
    /**
     * 属性清单最终确认人代码/清单最终确认人代码
     */
    @Column(name = "affrimopCode")
    private String affrimopCode;
    /**
     * 属性清单最终确认人姓名/清单最终确认人姓名
     */
    @Column(name = "affrimopName")
    private String affrimopName;
    /**
     * 属性清单备注/清单备注
     */
    @Column(name = "remark")
    private String remark;

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

    public String getListAlias() {
        return listAlias;
    }

    public void setListAlias(String listAlias) {
        this.listAlias = listAlias;
    }

    public String getListTypeFlag() {
        return listTypeFlag;
    }

    public void setListTypeFlag(String listTypeFlag) {
        this.listTypeFlag = listTypeFlag;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getfProvinceCode() {
        return fProvinceCode;
    }

    public void setfProvinceCode(String fProvinceCode) {
        this.fProvinceCode = fProvinceCode;
    }

    public String getfProvinceName() {
        return fProvinceName;
    }

    public void setfProvinceName(String fProvinceName) {
        this.fProvinceName = fProvinceName;
    }

    public String getfCityCode() {
        return fCityCode;
    }

    public void setfCityCode(String fCityCode) {
        this.fCityCode = fCityCode;
    }

    public String getfCityName() {
        return fCityName;
    }

    public void setfCityName(String fCityName) {
        this.fCityName = fCityName;
    }

    public String getfCountyCode() {
        return fCountyCode;
    }

    public void setfCountyCode(String fCountyCode) {
        this.fCountyCode = fCountyCode;
    }

    public String getfCountyName() {
        return fCountyName;
    }

    public void setfCountyName(String fCountyName) {
        this.fCountyName = fCountyName;
    }

    public String getfTownCode() {
        return fTownCode;
    }

    public void setfTownCode(String fTownCode) {
        this.fTownCode = fTownCode;
    }

    public String getfTownName() {
        return fTownName;
    }

    public void setfTownName(String fTownName) {
        this.fTownName = fTownName;
    }

    public String getfVillageCode() {
        return fVillageCode;
    }

    public void setfVillageCode(String fVillageCode) {
        this.fVillageCode = fVillageCode;
    }

    public String getfVillageName() {
        return fVillageName;
    }

    public void setfVillageName(String fVillageName) {
        this.fVillageName = fVillageName;
    }

    public String getpProvinceCode() {
        return pProvinceCode;
    }

    public void setpProvinceCode(String pProvinceCode) {
        this.pProvinceCode = pProvinceCode;
    }

    public String getpProvinceName() {
        return pProvinceName;
    }

    public void setpProvinceName(String pProvinceName) {
        this.pProvinceName = pProvinceName;
    }

    public String getpCityCode() {
        return pCityCode;
    }

    public void setpCityCode(String pCityCode) {
        this.pCityCode = pCityCode;
    }

    public String getpCityName() {
        return pCityName;
    }

    public void setpCityName(String pCityName) {
        this.pCityName = pCityName;
    }

    public String getpCountyCode() {
        return pCountyCode;
    }

    public void setpCountyCode(String pCountyCode) {
        this.pCountyCode = pCountyCode;
    }

    public String getpCountyName() {
        return pCountyName;
    }

    public void setpCountyName(String pCountyName) {
        this.pCountyName = pCountyName;
    }

    public String getpTownCode() {
        return pTownCode;
    }

    public void setpTownCode(String pTownCode) {
        this.pTownCode = pTownCode;
    }

    public String getpTownName() {
        return pTownName;
    }

    public void setpTownName(String pTownName) {
        this.pTownName = pTownName;
    }

    public String getpVillageCode() {
        return pVillageCode;
    }

    public void setpVillageCode(String pVillageCode) {
        this.pVillageCode = pVillageCode;
    }

    public String getpVillageName() {
        return pVillageName;
    }

    public void setpVillageName(String pVillageName) {
        this.pVillageName = pVillageName;
    }

    public Integer getfCount() {
        return fCount;
    }

    public void setfCount(Integer fCount) {
        this.fCount = fCount;
    }

    public String getGisFlag() {
        return gisFlag;
    }

    public void setGisFlag(String gisFlag) {
        this.gisFlag = gisFlag;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public Date getListCreateTime() {
        return listCreateTime;
    }

    public void setListCreateTime(Date listCreateTime) {
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

    public Date getListAffrimTime() {
        return listAffrimTime;
    }

    public void setListAffrimTime(Date listAffrimTime) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}