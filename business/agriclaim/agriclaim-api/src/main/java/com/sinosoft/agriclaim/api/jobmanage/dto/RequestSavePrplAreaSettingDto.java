package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
/**
 *（接受批量保存的页面参数）
 * @Author: 孙朋飞
 * @Date: 2017/11/11 17:48
 */
public class RequestSavePrplAreaSettingDto extends BasePageableRequest implements Serializable {
    private String handleDept;
    private String[] indexId;
    private Long[] id;
    private String[] handlerCode;
    private String[] handlerName;
    private String[] area;
    private String[] tel;
    private String[] flowInTime;
    private String operator;
    private String operatorId;
    private String prplAreaSettingDtoHandlercode;
    private String prplAreaSettingDtoHandleDept;
    public String getHandleDept() {
        return handleDept;
    }
    public void setHandleDept(String handleDept) {
        this.handleDept = handleDept;
    }
    public String[] getIndexId() {
        return indexId;
    }
    public void setIndexId(String[] indexId) {
        this.indexId = indexId;
    }
    public Long[] getId() {
        return id;
    }
    public void setId(Long[] id) {
        this.id = id;
    }
    public String[] getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String[] handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String[] getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String[] handlerName) {
        this.handlerName = handlerName;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }

    public String[] getTel() {
        return tel;
    }

    public void setTel(String[] tel) {
        this.tel = tel;
    }

    public String getPrplAreaSettingDtoHandlercode() {
        return prplAreaSettingDtoHandlercode;
    }

    public void setPrplAreaSettingDtoHandlercode(String prplAreaSettingDtoHandlercode) {
        this.prplAreaSettingDtoHandlercode = prplAreaSettingDtoHandlercode;
    }

    public String getPrplAreaSettingDtoHandleDept() {
        return prplAreaSettingDtoHandleDept;
    }

    public void setPrplAreaSettingDtoHandleDept(String prplAreaSettingDtoHandleDept) {
        this.prplAreaSettingDtoHandleDept = prplAreaSettingDtoHandleDept;
    }

    public String[] getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String[] flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
