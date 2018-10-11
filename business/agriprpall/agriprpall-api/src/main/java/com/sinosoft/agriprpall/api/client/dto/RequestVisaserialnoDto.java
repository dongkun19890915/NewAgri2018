package com.sinosoft.agriprpall.api.client.dto;

public class RequestVisaserialnoDto {
    /**
     * ��֤����
     */
    private String visaCode;
    /**
     * ��¼�û���������
     */
    private String userCode;
    /**
     * ��ˮ��
     */
    private String visaSerialNo;
    /**
     * ������
     */
    private String businessNo;

    public String getVisaCode() {
        return visaCode;
    }

    public void setVisaCode(String visaCode) {
        this.visaCode = visaCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getVisaSerialNo() {
        return visaSerialNo;
    }

    public void setVisaSerialNo(String visaSerialNo) {
        this.visaSerialNo = visaSerialNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }


}
