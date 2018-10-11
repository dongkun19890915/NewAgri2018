package com.sinosoft.pms.api.common.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.util.Date;



/**
 * @description pms数据传输对象中共有的字段在此类中
 * @author yinqingzhu
 * @date 2016年9月29日上午9:16:10
 */
public class PmsRequestDto extends BasePageableRequest implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//产品代码
	String riskCode ;

	//版次号
	String versionNo ;

	//页面传入的生效日期
	Date issueDate ;
	//产品名称
    private String riskName;
    
    public String getRiskName(){
        return riskName;
    }

    public void setRiskName(String riskName){
        this.riskName = riskName;
    }
	
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
}
