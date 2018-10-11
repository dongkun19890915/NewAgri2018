package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 *（班表管理-区域设置-分页查询）
 * @Author: 孙朋飞
 * @Date: 2017/11/3 11:33
 */
public class RequestPrpLJobManagerDto extends BasePageableRequest implements Serializable {
    private String systemCode;//系统代码
    private String policyNo;//保单号
    private String handleDept;//机构代码

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }



    public String getHandleDept() {
        return handleDept;
    }

    public void setHandleDept(String handleDept) {
        this.handleDept = handleDept;
    }
}
