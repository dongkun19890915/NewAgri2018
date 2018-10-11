package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.pms.api.common.dto.PmsResponseDto;

public class PrpDItemTypeDto extends PmsResponseDto implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 属性标的名称/标的名称 */
    private String itemName ;
    /** 属性标的分类名称/标的分类名称 */
    private String itemTypeName ;
    /** 属性最小保额/最小保额 */
    private Double minAmount ;
    /** 属性最大保额/最大保额 */
    private Double maxAmount ;
    /** 属性标志/标志 */
    private String flag ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性创建时间/创建时间 */
    private java.util.Date createTime ;
    /** 属性创建人/创建人 */
    private String createBy ;
    /** 属性更新时间/更新时间 */
    private java.util.Date updateTime ;
    /** 属性更新人/更新人 */
    private String updateBy ;
    /** 属性标的代码/标的代码 */
    private String itemCode ;
    /** 属性标的分类标准/标的分类标准01 住宅类型 02 建筑类型 */
    private String itemTypeBase ;
    /** 属性标的分类代码/标的分类代码 0101 城镇住宅 0102 农村住宅 0201 钢结构 0202 钢和钢筋混凝土结构 0203 钢筋混凝土结构 0204 混合结构 0205 砖木结构 0299 其他结构 */
    private String itemTypeCode ;
    /**
     * 属性标的代码/标的代码的getter方法
     */
    public String getItemCode() {
        return itemCode;
    }
    /**
     * 属性标的代码/标的代码的setter方法
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    } 
    /**
     * 属性标的分类标准/标的分类标准01 住宅类型 02 建筑类型的getter方法
     */
    public String getItemTypeBase() {
        return itemTypeBase;
    }
    /**
     * 属性标的分类标准/标的分类标准01 住宅类型 02 建筑类型的setter方法
     */
    public void setItemTypeBase(String itemTypeBase) {
        this.itemTypeBase = itemTypeBase;
    } 
    /**
     * 属性标的分类代码/标的分类代码 0101 城镇住宅 0102 农村住宅 0201 钢结构 0202 钢和钢筋混凝土结构 0203 钢筋混凝土结构 0204 混合结构 0205 砖木结构 0299 其他结构的getter方法
     */
    public String getItemTypeCode() {
        return itemTypeCode;
    }
    /**
     * 属性标的分类代码/标的分类代码 0101 城镇住宅 0102 农村住宅 0201 钢结构 0202 钢和钢筋混凝土结构 0203 钢筋混凝土结构 0204 混合结构 0205 砖木结构 0299 其他结构的setter方法
     */
    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    } 

    /**
     * 属性标的名称/标的名称的getter方法
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * 属性标的名称/标的名称的setter方法
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    } 


    /**
     * 属性标的分类名称/标的分类名称的getter方法
     */
    public String getItemTypeName() {
        return itemTypeName;
    }
    /**
     * 属性标的分类名称/标的分类名称的setter方法
     */
    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    } 
    /**
     * 属性最小保额/最小保额的getter方法
     */
    public Double getMinAmount() {
        return minAmount;
    }
    /**
     * 属性最小保额/最小保额的setter方法
     */
    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    } 
    /**
     * 属性最大保额/最大保额的getter方法
     */
    public Double getMaxAmount() {
        return maxAmount;
    }
    /**
     * 属性最大保额/最大保额的setter方法
     */
    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    } 
    /**
     * 属性标志/标志的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性标志/标志的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    } 
    /**
     * 属性备注/备注的getter方法
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 属性备注/备注的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    } 
    /**
     * 属性创建时间/创建时间的getter方法
     */
    public java.util.Date getCreateTime() {
        return createTime;
    }
    /**
     * 属性创建时间/创建时间的setter方法
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    } 
    /**
     * 属性创建人/创建人的getter方法
     */
    public String getCreateBy() {
        return createBy;
    }
    /**
     * 属性创建人/创建人的setter方法
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    } 
    /**
     * 属性更新时间/更新时间的getter方法
     */
    public java.util.Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 属性更新时间/更新时间的setter方法
     */
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    } 
    /**
     * 属性更新人/更新人的getter方法
     */
    public String getUpdateBy() {
        return updateBy;
    }
    /**
     * 属性更新人/更新人的setter方法
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    } 

}