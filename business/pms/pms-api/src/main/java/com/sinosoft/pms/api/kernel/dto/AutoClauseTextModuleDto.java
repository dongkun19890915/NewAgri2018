package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrx
 * @time  2017-09-13
 * 自动生成特约动态生成特约内容规则操作对象
 */
public class AutoClauseTextModuleDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //动态生成特约内容规则 模块
    private String textModule ;
    //动态生成特约内容规则 属性
    private String textProporty ;
    //动态生成特约内容规则 属性类型
    private String textProportyType ;
    //动态生成特约内容规则 带入类型
    private String valueType ;
    //动态生成特约内容规则 辅助值
    private String propertySub ;
    //动态生成特约内容规则 备注
    private String textRemark ;

    public String getTextModule() {
        return textModule;
    }

    public void setTextModule(String textModule) {
        this.textModule = textModule;
    }

    public String getTextProporty() {
        return textProporty;
    }

    public void setTextProporty(String textProporty) {
        this.textProporty = textProporty;
    }

    public String getTextProportyType() {
        return textProportyType;
    }

    public void setTextProportyType(String textProportyType) {
        this.textProportyType = textProportyType;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getPropertySub() {
        return propertySub;
    }

    public void setPropertySub(String propertySub) {
        this.propertySub = propertySub;
    }

    public String getTextRemark() {
        return textRemark;
    }

    public void setTextRemark(String textRemark) {
        this.textRemark = textRemark;
    }
}
