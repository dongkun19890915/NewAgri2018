package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * @Description: 保单查询列表信息requestDtoApi操作对象
 * @Author: 潘峰
 * @Date: 2017/10/18 16:19
 */
public class RequestPolicyQueryDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性保单代码
     */
    private String policyNo;
    /**
     * 属性保单代码查询方法*模糊查询，=精确查询
     */
    private String queryPolicyNoMethod;
    /**
     * 属性投保单号
     */
    private String proposalNo;
    /**
     * 属性投保单号查询方法*模糊查询，=精确查询
     */
    private String queryProposalNoMethod;
    /**
     * 属性投保人名称
     */
    private String appliName;
    /**
     * 属性投保人名称查询方法*模糊查询，=精确查询
     */
    private String queryAppliNameMethod;
    /**
     * 属性投保人代码
     */
    private String appliCode;
    /**
     * 扶贫险种标志验证
     */
    private String hpFlag;
    /**
     * 属性投保人代码查询方法*模糊查询，=精确查询
     */
    private String queryAppliCodeMethod;
    /**
     * 属性被保险人名称
     */
    private String insuredName;
    /**
     * 属性被保险人名称查询方法*模糊查询，=精确查询
     */
    private String queryInsuredNameMethod;
    /**
     * 属性被保险人代码
     */
    private String insuredCode;
    /**
     * 属性被保险人代码查询方法*模糊查询，=精确查询
     */
    private String queryInsuredCodeMethod;
    /**
     * 属性总保险金额
     */
    private String sumAmount;
    /**
     * 属性总保险金额查询方法*模糊查询，=精确查询
     */
    private String querySumAmountMethod;
    /**
     * 属性总保险费
     */
    private String sumPremium;
    /**
     * 属性总保险费查询方法*模糊查询，=精确查询
     */
    private String querySumPremiumMethod;
    /**
     * 属性业务归属机构代码
     */
    private String comCode;
    /**
     * 属性业务归属机构代码查询方法*模糊查询，=精确查询
     */
    private String queryComCodeMethod;
    /**
     * 属性归属业务员代码
     */
    private String handler1Code;
    /**
     * 属性归属业务员代码查询方法*模糊查询，=精确查询
     */
    private String queryHandler1CodeMethod;
    /**
     * 属性操作员代码
     */
    private String operatorCode;
    /**
     * 属性操作员代码查询方法*模糊查询，=精确查询
     */
    private String queryOperatorCodeMethod;
    /**
     * 属性起保日期
     */
    private String startDate;
    /**
     * 属性起保日期查询方法=,>=,<=,>,<
     */
    private String queryStartDateMethod;
    /**
     * 属性终保日期
     */
    private String endDate;
    /**
     * 属性终保日期查询方法=,>=,<=,>,<
     */
    private String queryEndDateMethod;
    /**
     * 属性起保日期
     */
    private String operateDate;
    /**
     * 属性起保日期查询方法=,>=,<=,>,<
     */
    private String queryOperateDateMethod;
    /**
     * 所有/中央政策性/地方政策性/商业性标志
     */
    private String businessType1;
    /**
     * 属性打印状态
     */
    private String printStatus;
    /**
     * 正本限制
     */
    private String editType;

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getQueryPolicyNoMethod() {
        return queryPolicyNoMethod;
    }

    public void setQueryPolicyNoMethod(String queryPolicyNoMethod) {
        this.queryPolicyNoMethod = queryPolicyNoMethod;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getQueryProposalNoMethod() {
        return queryProposalNoMethod;
    }

    public void setQueryProposalNoMethod(String queryProposalNoMethod) {
        this.queryProposalNoMethod = queryProposalNoMethod;
    }

    public String getHpFlag() {
        return hpFlag;
    }

    public void setHpFlag(String hpFlag) {
        this.hpFlag = hpFlag;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getQueryAppliNameMethod() {
        return queryAppliNameMethod;
    }

    public void setQueryAppliNameMethod(String queryAppliNameMethod) {
        this.queryAppliNameMethod = queryAppliNameMethod;
    }

    public String getAppliCode() {
        return appliCode;
    }

    public void setAppliCode(String appliCode) {
        this.appliCode = appliCode;
    }

    public String getQueryAppliCodeMethod() {
        return queryAppliCodeMethod;
    }

    public void setQueryAppliCodeMethod(String queryAppliCodeMethod) {
        this.queryAppliCodeMethod = queryAppliCodeMethod;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getQueryInsuredNameMethod() {
        return queryInsuredNameMethod;
    }

    public void setQueryInsuredNameMethod(String queryInsuredNameMethod) {
        this.queryInsuredNameMethod = queryInsuredNameMethod;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getQueryInsuredCodeMethod() {
        return queryInsuredCodeMethod;
    }

    public void setQueryInsuredCodeMethod(String queryInsuredCodeMethod) {
        this.queryInsuredCodeMethod = queryInsuredCodeMethod;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getQuerySumAmountMethod() {
        return querySumAmountMethod;
    }

    public void setQuerySumAmountMethod(String querySumAmountMethod) {
        this.querySumAmountMethod = querySumAmountMethod;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getQuerySumPremiumMethod() {
        return querySumPremiumMethod;
    }

    public void setQuerySumPremiumMethod(String querySumPremiumMethod) {
        this.querySumPremiumMethod = querySumPremiumMethod;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getQueryComCodeMethod() {
        return queryComCodeMethod;
    }

    public void setQueryComCodeMethod(String queryComCodeMethod) {
        this.queryComCodeMethod = queryComCodeMethod;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getQueryHandler1CodeMethod() {
        return queryHandler1CodeMethod;
    }

    public void setQueryHandler1CodeMethod(String queryHandler1CodeMethod) {
        this.queryHandler1CodeMethod = queryHandler1CodeMethod;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getQueryOperatorCodeMethod() {
        return queryOperatorCodeMethod;
    }

    public void setQueryOperatorCodeMethod(String queryOperatorCodeMethod) {
        this.queryOperatorCodeMethod = queryOperatorCodeMethod;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getQueryStartDateMethod() {
        return queryStartDateMethod;
    }

    public void setQueryStartDateMethod(String queryStartDateMethod) {
        this.queryStartDateMethod = queryStartDateMethod;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getQueryEndDateMethod() {
        return queryEndDateMethod;
    }

    public void setQueryEndDateMethod(String queryEndDateMethod) {
        this.queryEndDateMethod = queryEndDateMethod;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getQueryOperateDateMethod() {
        return queryOperateDateMethod;
    }

    public void setQueryOperateDateMethod(String queryOperateDateMethod) {
        this.queryOperateDateMethod = queryOperateDateMethod;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }
}
