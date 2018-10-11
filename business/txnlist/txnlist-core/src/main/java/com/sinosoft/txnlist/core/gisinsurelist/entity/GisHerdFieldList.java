package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * 预投保清单农户标的清单明细表（物）实体操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:42
 */
@Entity
@Table(name = "GisHerdFieldList")
@IdClass(GisHerdFieldListKey.class)
public class GisHerdFieldList extends BaseEntityImpl {

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
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性耳标号/脚环号/耳标号/脚环号
     */
    @Id
    @Column(name = "earLabel")
    private String earLabel;
    /**
     * 属性标的代码/标的代码
     */
    @Column(name = "itemCode")
    private String itemCode;
    /**
     * 属性养殖地点代码/养殖地点代码
     */
    @Column(name = "breedingAreaCode")
    private String breedingAreaCode;
    /**
     * 属性养殖地点名称/养殖地点名称
     */
    @Column(name = "breedingAreaName")
    private String breedingAreaName;
    /**
     * 属性养殖品种/养殖品种
     */
    @Column(name = "species")
    private String species;
    /**
     * 属性畜龄/畜龄
     */
    @Column(name = "animalAge")
    private Double animalAge;


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

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
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

    public Double getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Double animalAge) {
        this.animalAge = animalAge;
    }
}