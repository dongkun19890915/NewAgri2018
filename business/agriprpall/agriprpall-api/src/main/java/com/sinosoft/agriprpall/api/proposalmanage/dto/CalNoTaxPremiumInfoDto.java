package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**页面保费计算点击币别确定时价税分离调取服务
* @Author: 田健
* @Date: 2017/11/19 13:01
*/
public class CalNoTaxPremiumInfoDto extends BaseRequest implements Serializable {

    /**主险险别 */
    private String kindCodeMainStr;
    /**主险保费 */
    private String premiumMainStr;
    /** 附加险险别*/
    private String kindCodeSubStr;
    /**附加险保费 */
    private String premiumSubStr;
    /**险种 */
    private String riskCode;
    /**主险序号 */
    private String itemKindNoMainStr;
    /**附加险序号 */
    private String itemKindNoSubStr;
    /**主险个数 */
    private String mainCounts;
    /** 附加险个数*/
    private String subCounts;
    /** 不含税保费*/
    private String sumNoTaxPremium;
    /**税 */
    private String sumTaxFee;
    /**归属机构 */
    private String comCode;

    public String getSumNoTaxPremium() {
        return sumNoTaxPremium;
    }

    public void setSumNoTaxPremium(String sumNoTaxPremium) {
        this.sumNoTaxPremium = sumNoTaxPremium;
    }

    public String getSumTaxFee() {
        return sumTaxFee;
    }

    public void setSumTaxFee(String sumTaxFee) {
        this.sumTaxFee = sumTaxFee;
    }

    public String getKindCodeMainStr() {
        return kindCodeMainStr;
    }

    public void setKindCodeMainStr(String kindCodeMainStr) {
        this.kindCodeMainStr = kindCodeMainStr;
    }

    public String getPremiumMainStr() {
        return premiumMainStr;
    }

    public void setPremiumMainStr(String premiumMainStr) {
        this.premiumMainStr = premiumMainStr;
    }

    public String getKindCodeSubStr() {
        return kindCodeSubStr;
    }

    public void setKindCodeSubStr(String kindCodeSubStr) {
        this.kindCodeSubStr = kindCodeSubStr;
    }

    public String getPremiumSubStr() {
        return premiumSubStr;
    }

    public void setPremiumSubStr(String premiumSubStr) {
        this.premiumSubStr = premiumSubStr;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getItemKindNoMainStr() {
        return itemKindNoMainStr;
    }

    public void setItemKindNoMainStr(String itemKindNoMainStr) {
        this.itemKindNoMainStr = itemKindNoMainStr;
    }

    public String getItemKindNoSubStr() {
        return itemKindNoSubStr;
    }

    public void setItemKindNoSubStr(String itemKindNoSubStr) {
        this.itemKindNoSubStr = itemKindNoSubStr;
    }

    public String getMainCounts() {
        return mainCounts;
    }

    public void setMainCounts(String mainCounts) {
        this.mainCounts = mainCounts;
    }

    public String getSubCounts() {
        return subCounts;
    }

    public void setSubCounts(String subCounts) {
        this.subCounts = subCounts;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
}
