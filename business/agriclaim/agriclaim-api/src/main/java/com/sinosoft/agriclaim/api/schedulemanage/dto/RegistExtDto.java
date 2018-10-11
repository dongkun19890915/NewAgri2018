package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

public class RegistExtDto extends BaseRequest{

    /**序号 */
    private String serialNo;

    /**时间 */
    private String inputDate;

    /**小时 */
    private String inputHour;

    /**操作员 */
    private String operatorCode;

    /**内容 */
    private String context;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputHour() {
        return inputHour;
    }

    public void setInputHour(String inputHour) {
        this.inputHour = inputHour;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
