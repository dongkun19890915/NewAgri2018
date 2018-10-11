package com.sinosoft.agriprpall.api.policymanage.dto;

public class PaymentContentDto {
    /*险种名称 */
    private String riskCName;
    /*保单号 */
    private String policyNo;
    /*保险费 */
    private String planFee;
    /*序号 */
    private Integer no;
    /*合计 */
    private Double sumPlanFee;
    /*合计标志 */
    private String sumFlag;
    /*数据标志 */
    private String dataFlag;
    private String oneFlag;
    private String twoFlag;
    private String threeFlag;
    private String fourFlag;
    private String fiveFlag;
    private String sixFlag;
    private String sumPlanFeeCapital;
    private  String comCName;

    public String getSumPlanFeeCapital() {
        return sumPlanFeeCapital;
    }

    public void setSumPlanFeeCapital(String sumPlanFeeCapital) {
        this.sumPlanFeeCapital = sumPlanFeeCapital;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }

    public String getOneFlag() {
        return oneFlag;
    }

    public void setOneFlag(String oneFlag) {
        this.oneFlag = oneFlag;
    }

    public String getTwoFlag() {
        return twoFlag;
    }

    public void setTwoFlag(String twoFlag) {
        this.twoFlag = twoFlag;
    }

    public String getThreeFlag() {
        return threeFlag;
    }

    public void setThreeFlag(String threeFlag) {
        this.threeFlag = threeFlag;
    }

    public String getFourFlag() {
        return fourFlag;
    }

    public void setFourFlag(String fourFlag) {
        this.fourFlag = fourFlag;
    }

    public String getFiveFlag() {
        return fiveFlag;
    }

    public void setFiveFlag(String fiveFlag) {
        this.fiveFlag = fiveFlag;
    }

    public String getSixFlag() {
        return sixFlag;
    }

    public void setSixFlag(String sixFlag) {
        this.sixFlag = sixFlag;
    }

    public Double getSumPlanFee() {
        return sumPlanFee;
    }

    public void setSumPlanFee(Double sumPlanFee) {
        this.sumPlanFee = sumPlanFee;
    }

    public String getSumFlag() {
        return sumFlag;
    }

    public void setSumFlag(String sumFlag) {
        this.sumFlag = sumFlag;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPlanFee() {
        return planFee;
    }

    public void setPlanFee(String planFee) {
        this.planFee = planFee;
    }
}
