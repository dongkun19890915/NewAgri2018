package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 预投保清单农户标的清单明细表（物）Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:23
 */
public class GisHerdFieldListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性耳标号/脚环号/耳标号/脚环号
     */
    private String earLabel;
    /**
     * 属性养殖地点代码/养殖地点代码
     */
    private String breedingAreaCode;
    /**
     * 属性养殖地点名称/养殖地点名称
     */
    private String breedingAreaName;
    /**
     * 属性养殖品种/养殖品种
     */
    private String species;
    /**
     * 属性畜龄/畜龄
     */
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
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
