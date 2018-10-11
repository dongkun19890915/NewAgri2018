package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/** @Description:（保费计算返回Dto）
* @Author: 田健
* @Date: 2017/10/17 18:28
*/
public class CalPremiumResponseDto extends BaseRequest implements Serializable {
    /**返回信息，成功或失败*/
    private String message;
    /**flag*/
    private  String flag;
    /**每个标的户数*/
    private List<String> iSumInsuredList;
    /**总的承保数量 */
    private String count;
    /**总面积*/
    private List<String> bigList;
    /** 险别代码*/
    private List<String> kindCodeList;
    /**总保费*/
    private List<String> sumPremiumList;
    /**自留份额比例*/
    private List<String> fPremiumList;
    /**中央财政补贴比例*/
    private List<String> centralPremiumList;
    /**省级财政补贴比例*/
    private List<String> provincePremiumList;
    /**地市财政补贴比例*/
    private List<String> cityPremiumList;
    /**县（区）财政补贴比例*/
    private List<String> townPremiumList;
    /**其他补贴比例*/
    private List<String> otherPremiumList;
    /**总保额 */
    private String sumAmount;
    /**标的清单编号 */
    private List<String> itemListCodes;
    /**标的代码 */
    private List<String> itemCodeList;

    public List<String> getItemCodeList() {
        return itemCodeList;
    }

    public void setItemCodeList(List<String> itemCodeList) {
        this.itemCodeList = itemCodeList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<String> getiSumInsuredList() {
        return iSumInsuredList;
    }

    public void setiSumInsuredList(List<String> iSumInsuredList) {
        this.iSumInsuredList = iSumInsuredList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<String> getBigList() {
        return bigList;
    }

    public void setBigList(List<String> bigList) {
        this.bigList = bigList;
    }

    public List<String> getSumPremiumList() {
        return sumPremiumList;
    }

    public void setSumPremiumList(List<String> sumPremiumList) {
        this.sumPremiumList = sumPremiumList;
    }

    public List<String> getfPremiumList() {
        return fPremiumList;
    }

    public void setfPremiumList(List<String> fPremiumList) {
        this.fPremiumList = fPremiumList;
    }

    public List<String> getCentralPremiumList() {
        return centralPremiumList;
    }

    public void setCentralPremiumList(List<String> centralPremiumList) {
        this.centralPremiumList = centralPremiumList;
    }

    public List<String> getProvincePremiumList() {
        return provincePremiumList;
    }

    public void setProvincePremiumList(List<String> provincePremiumList) {
        this.provincePremiumList = provincePremiumList;
    }

    public List<String> getCityPremiumList() {
        return cityPremiumList;
    }

    public void setCityPremiumList(List<String> cityPremiumList) {
        this.cityPremiumList = cityPremiumList;
    }

    public List<String> getTownPremiumList() {
        return townPremiumList;
    }

    public void setTownPremiumList(List<String> townPremiumList) {
        this.townPremiumList = townPremiumList;
    }

    public List<String> getOtherPremiumList() {
        return otherPremiumList;
    }

    public void setOtherPremiumList(List<String> otherPremiumList) {
        this.otherPremiumList = otherPremiumList;
    }

    public String getSumAmount() {        return sumAmount;    }

    public void setSumAmount(String sumAmount) {        this.sumAmount = sumAmount;    }

    public List<String> getItemListCodes() {        return itemListCodes;    }

    public void setItemListCodes(List<String> itemListCodes) {        this.itemListCodes = itemListCodes;    }

    public List<String> getKindCodeList() {        return kindCodeList;    }

    public void setKindCodeList(List<String> kindCodeList) {        this.kindCodeList = kindCodeList;    }
}
