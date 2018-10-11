package com.sinosoft.agriclaim.api.paymentmanage.dto;

/***（支付统计情况列表查询入参）
* @Author: 王志文
* @Date: 2018/1/4 15:54
*/
public class PaymentStatisticsInDto {
	/** 理算书号 */
	private String compensateNo;
	/** 保单号 */
	private String policyNo;
	/** 报案号 */
	private String registNo;
	/** 被保险人名称 */
	private String insuredName;
	/** 赔款类型 */
	private String paymentType;
	/** 核赔通过时间起 */
	private String underWriteEndDateStart;
	/** 核赔通过时间止 */
	private String underWriteEndDateEnd;
	/** 案件类型  */
	private String caseType;
	/** 支付类型 */
	private String payType;
	/** 是否分页 all为不分页 */
	private String queryType;
	/** 当前页数 */
	private int pageNo = 0;

	private int pageSize =0;
	
	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getUnderWriteEndDateStart() {
		return underWriteEndDateStart;
	}

	public void setUnderWriteEndDateStart(String underWriteEndDateStart) {
		this.underWriteEndDateStart = underWriteEndDateStart;
	}

	public String getUnderWriteEndDateEnd() {
		return underWriteEndDateEnd;
	}

	public void setUnderWriteEndDateEnd(String underWriteEndDateEnd) {
		this.underWriteEndDateEnd = underWriteEndDateEnd;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
}
