package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 导入清单excel的Dto
 *
 * @author: 何伟东
 * @date: 2017/12/22 10:29
 */
public class RequestImportPayListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 批单号码
     */
    private String endorseNo;
    /**
     * 费用类型
     */
    private String costType;
    /**
     * 登录机构
     */
    private String loginComCode;
    /**
     * 是否修改操作
     */
    private boolean isModify;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public boolean getModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }
}
