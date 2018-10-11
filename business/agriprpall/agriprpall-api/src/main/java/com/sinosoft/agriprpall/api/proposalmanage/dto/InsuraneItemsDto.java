package com.sinosoft.agriprpall.api.proposalmanage.dto;

/**
* @Description:保险项目返回Dto
* @Author: 陈道洋
* @Date: 2017/10/20 11:06
*/
public class InsuraneItemsDto {
//    /*承保明细 */
//    private List<ItemKingAgriDto> itemKingAgriDtoList;
    /*总保险金额 */
    private String sumAmount;
    /*总保险费 */
    private String sumPremium;
    /*特别约定内容 */
    private String clauses;
    /*绝对免赔率 */
    private String deductible;
    /*缴费起期 */
    private String planStartdate;
    /*缴费止期 */
    private String planDate;
    //免赔说明
    private String deduText;

    public String getDeduText() {
        return deduText;
    }

    public void setDeduText(String deduText) {
        this.deduText = deduText;
    }

    public String getPlanStartdate() {
        return planStartdate;
    }

    public void setPlanStartdate(String planStartdate) {
        this.planStartdate = planStartdate;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getClauses() {
        return clauses;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

//    public List<ItemKingAgriDto> getItemKingAgriDtoList() {
//        return itemKingAgriDtoList;
//    }
//
//    public void setItemKingAgriDtoList(List<ItemKingAgriDto> itemKingAgriDtoList) {
//        this.itemKingAgriDtoList = itemKingAgriDtoList;
//    }
}
