package com.sinosoft.agriprpall.api.printPdf.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyPrintStatusDto extends BaseRequest implements Serializable {
    List<String> policyPrintList=new ArrayList<>();
    Map<String,String> policyPrintUploadList=new HashMap<>();
    List<String> policyPrintNo=new ArrayList<>();

    public List<String> getPolicyPrintList() {
        return policyPrintList;
    }

    public void setPolicyPrintList(List<String> policyPrintList) {
        this.policyPrintList = policyPrintList;
    }

    public Map<String, String> getPolicyPrintUploadList() {
        return policyPrintUploadList;
    }

    public void setPolicyPrintUploadList(Map<String, String> policyPrintUploadList) {
        this.policyPrintUploadList = policyPrintUploadList;
    }

    public List<String> getPolicyPrintNo() {
        return policyPrintNo;
    }

    public void setPolicyPrintNo(List<String> policyPrintNo) {
        this.policyPrintNo = policyPrintNo;
    }
}
