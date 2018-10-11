package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * 投保明细表主键操作对象
 */
public class PlantingInsuranceListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingInsuranceListKey(){}

    public PlantingInsuranceListKey(String inusreListCode, String fCode, String kindCode) {
        this.inusreListCode = inusreListCode;
        this.fCode = fCode;
        this.kindCode = kindCode;
    }
	/** 属性投保清单编号/投保清单编号 */
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /** 属性农户代码/农户代码 */
    @Column(name = "fCode")
    private String fCode;
    /** 属性险别序号/险别序号 */
    @Column(name = "kindCode")
    private String kindCode;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }
}