package com.sinosoft.agriprpall.api.client.dto;
/**
 * 恐怖信息查询响应信息
 * @author Administrator
 *
 */
public class ResponseQueryTerroristInfoDto {

	/** 属性 恐怖分子中文名称 */
	private String terroristCName = "";
	/** 属性 恐怖分子类型--**1:个人--**2:组织 */
	private String terroristType = "";
	/** 属性 性别 */
	private String sex = "";
	/** 属性 国籍 */
	private String nationality = "";
	/** 属性 出生日期 */
	private String birthDate = "";
	/** 属性 所属组织 */
	private String relegation = "";
	/** 属性 证件号码 */
	private String identifyNumber = "";
	/** 属性 备注 */
	private String remark = "";
	/** 属性 恐怖分子代码 */
	private String terroristCode = "";
	/** 属性 总条数*/
	private int count = 0;
	/** 属性 当前页*/
	private int pageNo = 0;

	public String getTerroristCName() {
		return terroristCName;
	}
	public void setTerroristCName(String terroristCName) {
		this.terroristCName = terroristCName;
	}
	public String getTerroristType() {
		return terroristType;
	}
	public void setTerroristType(String terroristType) {
		this.terroristType = terroristType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getRelegation() {
		return relegation;
	}
	public void setRelegation(String relegation) {
		this.relegation = relegation;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTerroristCode() {
		return terroristCode;
	}
	public void setTerroristCode(String terroristCode) {
		this.terroristCode = terroristCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}

