package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 报案主表Api操作对象
 */
public class PrpLregistResponseDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	//报案号
	private String registNo;
	//关联保单号
	private List relatepolicyNos;
	//案件状态
	private String Status;
	//险种代码
	private String RiskCode;
	//被保险人姓名
	private String InsuredName;
	//报告日期
	private String reportDate;
	//险种名称
	private String riskCname;
	//保单号码
	private String policyNo;

	private Date cancelDate;

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
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
	public List getRelatepolicyNos() {
		return relatepolicyNos;
	}
	public void setRelatepolicyNos(List relatepolicyNos) {
		this.relatepolicyNos = relatepolicyNos;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getRiskCode() {
		return RiskCode;
	}
	public void setRiskCode(String riskCode) {
		RiskCode = riskCode;
	}
	public String getInsuredName() {
		return InsuredName;
	}
	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}
    public String getReportDate() {
        return reportDate;
    }
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
    public String getRiskCname() {
        return riskCname;
    }
    public void setRiskCname(String riskCname) {
        this.riskCname = riskCname;
    }
		
		
}
