package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
//import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 报案主表Api操作对象
 */
public class PrpLregistDetailQueryDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String editType;
	private String policyNo; //保单号
	private String registNo; //报案号
	private String damageDate;//出险日期
	private String damageHour;//出险小时
	private String damageMinute;//出险分钟
	private String FlashPage;//是否是ajax刷新页面
	private String editRegistFlag;//是否是种植险的二次报案
	private String riskCode;
	private RiskQueryConditionDto riskQueryConditionDto;
	
	
	public String getEditType() {
		return editType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	public String getDamageHour() {
		return damageHour;
	}
	public void setDamageHour(String damageHour) {
		this.damageHour = damageHour;
	}
	public String getDamageMinute() {
		return damageMinute;
	}
	public void setDamageMinute(String damageMinute) {
		this.damageMinute = damageMinute;
	}
	public String getFlashPage() {
		return FlashPage;
	}
	public void setFlashPage(String flashPage) {
		FlashPage = flashPage;
	}
	public String getEditRegistFlag() {
		return editRegistFlag;
	}
	public void setEditRegistFlag(String editRegistFlag) {
		this.editRegistFlag = editRegistFlag;
	}
	public RiskQueryConditionDto getRiskQueryConditionDto() {
		return riskQueryConditionDto;
	}
	public void setRiskQueryConditionDto(RiskQueryConditionDto riskQueryConditionDto) {
		this.riskQueryConditionDto = riskQueryConditionDto;
	}
		
}
