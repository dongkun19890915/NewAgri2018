package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.util.Date;
import java.util.List;

/**
* 查勘定损初始化查询受灾面积等
* @Author: 孙朋飞
* @Date: 2018/04/13 10:13
*/
public class ResponseCheckDto {
    private static final long serialVersionUID = 1L;
    /** 定损时间*/
    private Date underWriteEndDate;
    /** 属性赔付数量/赔付数量 */
    private java.lang.Double lossEsnumBer ;
    /** 出险户次*/
    private Integer damageInsured ;
    /** 属性受灾面积/受灾面积 */
    private java.lang.Double disasterArea ;
    /** 属性成灾面积/成灾面积 */
    private java.lang.Double affectEDarea ;
    /** 属性绝产面积/绝产面积 */
    private java.lang.Double noProductionArea ;
    /** 属性死亡数量/死亡数量 */
    private java.lang.Double deathQuantity ;
    /** 属性扑杀数量/扑杀数量 */
    private java.lang.Double killQuantity ;
    /** 查勘报告*/
    private String context;
    public Date getUnderWriteEndDate() {
        return underWriteEndDate;
    }

    public void setUnderWriteEndDate(Date underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }

    public Double getLossEsnumBer() {
        return lossEsnumBer;
    }

    public void setLossEsnumBer(Double lossEsnumBer) {
        this.lossEsnumBer = lossEsnumBer;
    }

    public Integer getDamageInsured() {
        return damageInsured;
    }

    public void setDamageInsured(Integer damageInsured) {
        this.damageInsured = damageInsured;
    }

    public Double getDisasterArea() {
        return disasterArea;
    }

    public void setDisasterArea(Double disasterArea) {
        this.disasterArea = disasterArea;
    }

    public Double getAffectEDarea() {
        return affectEDarea;
    }

    public void setAffectEDarea(Double affectEDarea) {
        this.affectEDarea = affectEDarea;
    }

    public Double getNoProductionArea() {
        return noProductionArea;
    }

    public void setNoProductionArea(Double noProductionArea) {
        this.noProductionArea = noProductionArea;
    }

    public Double getDeathQuantity() {
        return deathQuantity;
    }

    public void setDeathQuantity(Double deathQuantity) {
        this.deathQuantity = deathQuantity;
    }

    public Double getKillQuantity() {
        return killQuantity;
    }

    public void setKillQuantity(Double killQuantity) {
        this.killQuantity = killQuantity;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
