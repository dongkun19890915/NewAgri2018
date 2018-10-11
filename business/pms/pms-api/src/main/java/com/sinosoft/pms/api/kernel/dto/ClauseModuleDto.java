package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrx
 * @time  2017-09-13
 * 自动生成特约车险自动生成特约规则操作对象
 */
public class ClauseModuleDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //车险自动生成特约规则 模块
    private String module ;
    //车险自动生成特约规则 属性
    private String property ;
    //车险自动生成特约规则 属性类型
    private String propertyType ;
    //车险自动生成特约规则 校验类型
    private String checkType ;
    //车险自动生成特约规则 校验值
    private String checkValue ;
    //车险自动生成特约规则 校验模块
    private String checkModule ;
    //车险自动生成特约规则 校验属性
    private String checkProperty ;
    //车险自动生成特约规则 备注
    private String ruleRemark ;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public String getCheckModule() {
        return checkModule;
    }

    public void setCheckModule(String checkModule) {
        this.checkModule = checkModule;
    }

    public String getCheckProperty() {
        return checkProperty;
    }

    public void setCheckProperty(String checkProperty) {
        this.checkProperty = checkProperty;
    }

    public String getRuleRemark() {
        return ruleRemark;
    }

    public void setRuleRemark(String ruleRemark) {
        this.ruleRemark = ruleRemark;
    }
}
