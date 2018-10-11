package com.sinosoft.txnlist.api.makeuplist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 23/01/2018 10:28 AM
 */
public class EarLabelListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @ExportConfig(value = "清单编号", width = 300)
    private String insureListCode;
    /**
     * 属性农户代码/农户代码
     */
    @ExportConfig(value = "农户代码", width = 200)
    private String fCode;
    /**
     * 属性农户姓名/农户姓名
     */
    @ExportConfig("农户姓名")
    private String fName;
    /**
     * 属性标的代码
     */
    @ExportConfig("标的序号")
    private String itemCode;
    /**
     * 属性标的名称/标的名称
     */
    @ExportConfig("标的名称")
    private String itemName;
    /**
     * 属性耳标号/耳标号
     */
    @ExportConfig(value = "耳标号", width = 200)
    private String earLabel;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }
}
