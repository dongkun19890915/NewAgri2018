package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 投保明细最新数据表2主键操作对象
 */
public class PlantingCCirculationListOriginKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PlantingCCirculationListOriginKey() {
    }

    public PlantingCCirculationListOriginKey(String inusreListCode, String fCode, String kindCode) {
        this.inusreListCode = inusreListCode;
        this.fCode = fCode;
        this.kindCode = kindCode;
    }

    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    @Column(name = "kindCode")
    private String kindCode;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    /**
     * 属性农户代码（key）/农户代码（key）的getter方法
     */
    public String getfCode() {
        return fCode;
    }

    /**
     * 属性农户代码（key）/农户代码（key）的setter方法
     */
    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    /**
     * 属性险别序号（key）/险别序号（key）的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别序号（key）/险别序号（key）的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }
}