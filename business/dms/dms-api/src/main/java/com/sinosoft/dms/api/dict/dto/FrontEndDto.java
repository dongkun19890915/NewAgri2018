package com.sinosoft.dms.api.dict.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-10 06:45:04.724
 * 行政区域表Api操作对象
 */
public class FrontEndDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //承保调用理赔Url
    private String prpallClaimUrl;
    //承保调用金禾Url
    private String prpallGisUrl;
    //承保调用影像Url
    private String prpallSunECMUrl;
    //理赔调用承保Url
    private String claimPrpallUrl;
    //理赔调用金禾Url
    private String claimGisUrl;
    //理赔调用影像Url
    private String claimSunECMUrl;

    /**
     * 承保对接影像系统的密钥
     */
    private String prpallSunECMKeys;

    /**
     * 理赔对接影像的系统的密钥
     */
    private String claimSunECMKeys;

    public String getPrpallClaimUrl() {
        return prpallClaimUrl;
    }

    public void setPrpallClaimUrl(String prpallClaimUrl) {
        this.prpallClaimUrl = prpallClaimUrl;
    }

    public String getPrpallGisUrl() {
        return prpallGisUrl;
    }

    public void setPrpallGisUrl(String prpallGisUrl) {
        this.prpallGisUrl = prpallGisUrl;
    }

    public String getPrpallSunECMUrl() {
        return prpallSunECMUrl;
    }

    public void setPrpallSunECMUrl(String prpallSunECMUrl) {
        this.prpallSunECMUrl = prpallSunECMUrl;
    }

    public String getClaimPrpallUrl() {
        return claimPrpallUrl;
    }

    public void setClaimPrpallUrl(String claimPrpallUrl) {
        this.claimPrpallUrl = claimPrpallUrl;
    }

    public String getClaimGisUrl() {
        return claimGisUrl;
    }

    public void setClaimGisUrl(String claimGisUrl) {
        this.claimGisUrl = claimGisUrl;
    }

    public String getClaimSunECMUrl() {
        return claimSunECMUrl;
    }

    public void setClaimSunECMUrl(String claimSunECMUrl) {
        this.claimSunECMUrl = claimSunECMUrl;
    }

    public String getPrpallSunECMKeys() {
        return prpallSunECMKeys;
    }

    public void setPrpallSunECMKeys(String prpallSunECMKeys) {
        this.prpallSunECMKeys = prpallSunECMKeys;
    }

    public String getClaimSunECMKeys() {
        return claimSunECMKeys;
    }

    public void setClaimSunECMKeys(String claimSunECMKeys) {
        this.claimSunECMKeys = claimSunECMKeys;
    }
}
