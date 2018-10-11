package com.sinosoft.pms.api.filesmodel.dto;

public class PrpDfilesModelDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 属性RiskCode/产品 */
	private String riskCode ;
	/** 属性ModelType/模板类型 */
	private String modelType ;
	
	/** 属性ModelName/模板文件名 */
	private String modelName ;
	/** 属性ModelUrl/下载地址 */
	private String modelUrl ;
	/** 属性CreateTime/审计字段：创建时间 */
	private java.util.Date createTime ;
	/** 属性CreateBy/审计字段：创建人 */
	private String createBy ;
	/** 属性UploadTime/审计字段：更新时间 */
	private java.util.Date uploadTime ;
	/** 属性UpdateBy/审计字段：更新人 */
	private String updateBy ;
	/** 属性Flag/备注 */
	private String flag ;
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelUrl() {
		return modelUrl;
	}
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
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
	public java.util.Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(java.util.Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
