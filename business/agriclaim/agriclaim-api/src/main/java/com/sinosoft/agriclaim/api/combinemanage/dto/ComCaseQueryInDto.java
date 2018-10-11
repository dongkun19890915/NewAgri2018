package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @descption 合并案件查询服务入参dto
 * @author liyang	
 * @date 2017-11-26
 */
public class ComCaseQueryInDto extends BaseRequest implements Serializable{
	private static final long SerialVersionUID = 1L;
	/**保单号 */
	private String policyNo;
	/**报案起始日期 */
	private String startDate;
	/**报案截止日期 */
	private String endDate;
	/**被保险人 */
	private String insuredName;
	/**险种 */
	private String riskCode;
	/**事故号 */
	private String accidentNo;
	
	/**页码 */
	private int pageNo;
	/**页容量*/
	private int pageSize;
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getStartDate() { 
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getAccidentNo() {
		return accidentNo;
	}
	public void setAccidentNo(String accidentNo) {
		this.accidentNo = accidentNo;
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
	
}
