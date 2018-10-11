package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

/**
 * 投保单、批单 提交核保入参对象
 * @author: 钱浩
 * @date: 2017/12/1 上午 10:46
 */
public class UndwrtEndorSubmitDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String[] proposalno; //投保单号数组
    private String[] endorseNos; //批单号数组
    private String userCode; //用户代码
    private String DLComCode; //机构代码


    public String[] getProposalno() {
        return proposalno;
    }

    public void setProposalno(String[] proposalno) {
        this.proposalno = proposalno;
    }

    public String[] getEndorseNos() {
        return endorseNos;
    }

    public void setEndorseNos(String[] endorseNos) {
        this.endorseNos = endorseNos;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDLComCode() {
        return DLComCode;
    }

    public void setDLComCode(String DLComCode) {
        this.DLComCode = DLComCode;
    }
}
