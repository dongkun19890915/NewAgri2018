package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class PrpPcoinsCopyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性endorseNo/endorseNo */
    private String endorseNo ;
    /** 属性policyNo/policyNo */
    private String policyNo ;
    /** 属性serialNo/serialNo */
    private Integer serialNo ;
    /** 属性mainPolicyNo/mainPolicyNo */
    private String mainPolicyNo ;
    /** 属性coinsCode/coinsCode */
    private String coinsCode ;
    /** 属性coinsName/coinsName */
    private String coinsName ;
    /** 属性coinsType/coinsType */
    private String coinsType ;
    /** 属性coinsRate/coinsRate */
    private Double coinsRate ;
    /** 属性flag/flag */
    private String flag ;
    /** 属性chiefFlag/chiefFlag */
    private String chiefFlag ;
    /** 属性proportionFlag/proportionFlag */
    private String proportionFlag ;
    /** 属性共保业务共保比例变化/共保业务共保比例变化 */
    private Double chgCoinsRate ;
    /** 属性共保协议号/共保协议号 */
    private String coinsTreatyNo ;
    /** 属性coinsFlag/coinsFlag */
    private String coinsFlag ;
    /** 属性reInsciFlag/reInsciFlag */
    private String reinsCiFlag ;
    /** 属性修改人/修改人 */
    private String update_By ;
    /** 属性修改时间/修改时间 */
    private Date update_Date ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getMainPolicyNo() {
        return mainPolicyNo;
    }

    public void setMainPolicyNo(String mainPolicyNo) {
        this.mainPolicyNo = mainPolicyNo;
    }

    public String getCoinsCode() {
        return coinsCode;
    }

    public void setCoinsCode(String coinsCode) {
        this.coinsCode = coinsCode;
    }

    public String getCoinsName() {
        return coinsName;
    }

    public void setCoinsName(String coinsName) {
        this.coinsName = coinsName;
    }

    public String getCoinsType() {
        return coinsType;
    }

    public void setCoinsType(String coinsType) {
        this.coinsType = coinsType;
    }

    public Double getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(Double coinsRate) {
        this.coinsRate = coinsRate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getChiefFlag() {
        return chiefFlag;
    }

    public void setChiefFlag(String chiefFlag) {
        this.chiefFlag = chiefFlag;
    }

    public String getProportionFlag() {
        return proportionFlag;
    }

    public void setProportionFlag(String proportionFlag) {
        this.proportionFlag = proportionFlag;
    }

    public Double getChgCoinsRate() {
        return chgCoinsRate;
    }

    public void setChgCoinsRate(Double chgCoinsRate) {
        this.chgCoinsRate = chgCoinsRate;
    }

    public String getCoinsTreatyNo() {
        return coinsTreatyNo;
    }

    public void setCoinsTreatyNo(String coinsTreatyNo) {
        this.coinsTreatyNo = coinsTreatyNo;
    }

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

    public String getReinsCiFlag() {
        return reinsCiFlag;
    }

    public void setReinsCiFlag(String reinsCiFlag) {
        this.reinsCiFlag = reinsCiFlag;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }
}
