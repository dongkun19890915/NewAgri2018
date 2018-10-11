package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-13 19:23:10.296 
 * 标的分类表-PrpDItemType 主键操作类
 */
public class PrpDItemTypeKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;
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
}