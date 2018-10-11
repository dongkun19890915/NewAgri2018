package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 *（班表管理-区域设置-分页查询）
 * @Author: 孙朋飞
 * @Date: 2017/11/3 11:33
 */
public class RequestPrplAreaSettingQueryDto extends BasePageableRequest implements Serializable {
    private String handleDept;//班表机构
    private String handlerName;//查勘员/被维护人员
    private String handlerCode;//查勘员代码
    private String classCode;//险类
    public String getHandleDept() {
        return handleDept;
    }
    public void setHandleDept(String handleDept) {
        this.handleDept = handleDept;
    }
    public String getHandlerName() {
        return handlerName;
    }
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
}
