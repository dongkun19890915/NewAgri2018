package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 09:56:41.944 
 * 保单保险地址表Api操作对象
 */
public class PrpCaddressDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性险种代码C/险种代码C */
	private String riskCode ;		
	/** 属性地址序号C/地址序号C */
	private Integer addressNo ;
	/** 属性地址编码C/地址编码C */
	private String addressCode ;
	/** 属性地址C/地址C */
	private String addressName ;
	/** 属性标志字段C/标志字段C */
	private String flag="" ;
	/** 属性项目名称C/项目名称C */
	private String projectName ;
	/** 属性城市编码/城市编码 */
	private String cityCode ;
	/** 属性城市标志/城市标志 */
	private String cityFlag ;
	/** 属性城市名称/城市名称 */
	private String cityName ;
	/** 属性地区代码C/地区代码C */
	private String districtCode ;
	/** 属性地区标识C/地区标识C */
	private String districtFlag ;
	/** 属性地区名称C/地区名称C */
	private String districtName ;
	/** 属性省会代码/省会代码 */
	private String provinceCode ;
	/** 属性省会标识/省会标识 */
	private String provinceFlag ;
	/** 属性省会名称/省会名称 */
	private String provinceName ;
	/** 属性备注C/备注C */
	private String remark ;
	private Integer no ;
	private String oneFlag ;
	private String twoFlag ;
	private String dataFlag;
	private String threeFlag;
	private String signDate;

	public String getThreeFlag() {
		return threeFlag;
	}

	public void setThreeFlag(String threeFlag) {
		this.threeFlag = threeFlag;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
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

	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性险种代码C/险种代码C的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码C/险种代码C的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性地址序号C/地址序号C的getter方法
	 */
	public Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性地址序号C/地址序号C的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	}	
	/**
	 * 属性地址编码C/地址编码C的getter方法
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 属性地址编码C/地址编码C的setter方法
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}	
	/**
	 * 属性地址C/地址C的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性地址C/地址C的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}	
	/**
	 * 属性标志字段C/标志字段C的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段C/标志字段C的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性项目名称C/项目名称C的getter方法
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 属性项目名称C/项目名称C的setter方法
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}	
	/**
	 * 属性城市编码/城市编码的getter方法
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 属性城市编码/城市编码的setter方法
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}	
	/**
	 * 属性城市标志/城市标志的getter方法
	 */
	public String getCityFlag() {
		return cityFlag;
	}
	/**
	 * 属性城市标志/城市标志的setter方法
	 */
	public void setCityFlag(String cityFlag) {
		this.cityFlag = cityFlag;
	}	
	/**
	 * 属性城市名称/城市名称的getter方法
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 属性城市名称/城市名称的setter方法
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	
	/**
	 * 属性地区代码C/地区代码C的getter方法
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * 属性地区代码C/地区代码C的setter方法
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}	
	/**
	 * 属性地区标识C/地区标识C的getter方法
	 */
	public String getDistrictFlag() {
		return districtFlag;
	}
	/**
	 * 属性地区标识C/地区标识C的setter方法
	 */
	public void setDistrictFlag(String districtFlag) {
		this.districtFlag = districtFlag;
	}	
	/**
	 * 属性地区名称C/地区名称C的getter方法
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * 属性地区名称C/地区名称C的setter方法
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}	
	/**
	 * 属性省会代码/省会代码的getter方法
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/**
	 * 属性省会代码/省会代码的setter方法
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}	
	/**
	 * 属性省会标识/省会标识的getter方法
	 */
	public String getProvinceFlag() {
		return provinceFlag;
	}
	/**
	 * 属性省会标识/省会标识的setter方法
	 */
	public void setProvinceFlag(String provinceFlag) {
		this.provinceFlag = provinceFlag;
	}	
	/**
	 * 属性省会名称/省会名称的getter方法
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 属性省会名称/省会名称的setter方法
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}	
	/**
	 * 属性备注C/备注C的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注C/备注C的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
