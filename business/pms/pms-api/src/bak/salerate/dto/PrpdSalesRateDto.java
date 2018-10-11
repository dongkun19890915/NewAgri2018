package com.sinosoft.pms.api.salerate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseDto;

/**
 * 获取PrpdSalesRate对象的相关属性
 * @author yinqingzhu
 */
public class PrpdSalesRateDto extends BaseDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性VersionNo/版次号 */
	private String versionNo ;
	/** 属性RiskCode/产品代码 */
	private String riskCode ;
	/** 属性BusinessNature/业务来源 */
	private String businessNature ;
	/** 属性RiskName/产品名称 */
	private String riskName ;
	/** 属性SalesRate/销售费用率 */
	private Double salesRate ;
	/** 属性EffectDate/生效日期 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.util.Date effectDate ;
	/** 属性InvalidDate/失效日期 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.util.Date invalidDate ;
	/** 属性Flag/标志 */
	private String flag ;
	/** 属性Remark/备注 */
	private String remark ;
	/** 属性CreateTime/创建时间 */
	private java.util.Date createTime ;
	/** 属性CreateBy/创建人 */
	private String createBy ;
	/** 属性UpdateTime/更新时间 */
	private java.util.Date updateTime ;
	/** 属性UpdateBy/更新人 */
	private String updateBy ;
	
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getBusinessNature() {
		return businessNature;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public Double getSalesRate() {
		return salesRate;
	}
	public void setSalesRate(Double salesRate) {
		this.salesRate = salesRate;
	}
	public java.util.Date getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	}
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
