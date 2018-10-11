package com.sinosoft.txnlist.api.basicInfos.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 12:58:53.230 
 * basicInfosApi操作对象
 */
public class BasicInfosDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性农户代码/农户代码 */
	private String code ;		
	/** 属性直补卡帐号/直补卡帐号 */
	private String zhiBuKa ;		
	/** 属性身份证号码/身份证号码 */
	private String idCard ;		
	/** 属性农户性命/农户性命 */
	private String name ;		
	/** 属性性别/性别 */
	private String sex ;		
	/** 属性自定义种植面积（亩）/自定义种植面积（亩） */
	private java.lang.Double taxArea ;		
	/** 属性人口/人口 */
	private java.lang.Integer population ;		
	/** 属性开户银行/开户银行 */
	private String bank ;		
	/** 属性邮政编码/邮政编码 */
	private String postalCode ;		
	/** 属性所在区域/所在区域 */
	private String areaName ;		
	/** 属性区域代码/区域代码 */
	private String areaCode ;		
	/** 属性地址/地址 */
	private String address ;		
	/** 属性电话/电话 */
	private String phone ;		
	/** 属性出租给他人的耕地面积/出租给他人的耕地面积 */
	private java.lang.Double rentArea ;		
	/** 属性操作员代码/操作员代码 */
	private String opCode ;		
	/** 属性操作员时间/操作员时间 */
	private Date opTime ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性二轮承包面积/二轮承包面积 */
	private java.lang.Double ownArea ;		
	/** 属性租种面积/租种面积 */
	private java.lang.Double croftingArea ;		
	/** 属性种植面积/种植面积 */
	private java.lang.Double plantArea ;		
	/** 属性农户代码1/农户代码1 */
	private String codeBackUp ;		
	/** 属性原行政区划代码/原行政区划代码 */
	private String areaCodeBackUp ;		
	/** 属性0：无效，1有效/0：无效，1有效 */
	private String flag ;		
	/** 属性并发控制/并发控制 */
	private java.lang.Integer version ;		
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setCode(String code) {
		this.code = code;
	}	
	/**
	 * 属性直补卡帐号/直补卡帐号的getter方法
	 */
	public String getZhiBuKa() {
		return zhiBuKa;
	}
	/**
	 * 属性直补卡帐号/直补卡帐号的setter方法
	 */
	public void setZhiBuKa(String zhiBuKa) {
		this.zhiBuKa = zhiBuKa;
	}	
	/**
	 * 属性身份证号码/身份证号码的getter方法
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 属性身份证号码/身份证号码的setter方法
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}	
	/**
	 * 属性农户性命/农户性命的getter方法
	 */
	public String getName() {
		return name;
	}
	/**
	 * 属性农户性命/农户性命的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	}	
	/**
	 * 属性性别/性别的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别/性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}	
	/**
	 * 属性自定义种植面积（亩）/自定义种植面积（亩）的getter方法
	 */
	public java.lang.Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性自定义种植面积（亩）/自定义种植面积（亩）的setter方法
	 */
	public void setTaxArea(java.lang.Double taxArea) {
		this.taxArea = taxArea;
	}	
	/**
	 * 属性人口/人口的getter方法
	 */
	public java.lang.Integer getPopulation() {
		return population;
	}
	/**
	 * 属性人口/人口的setter方法
	 */
	public void setPopulation(java.lang.Integer population) {
		this.population = population;
	}	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
	/**
	 * 属性所在区域/所在区域的getter方法
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 属性所在区域/所在区域的setter方法
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	
	/**
	 * 属性区域代码/区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性区域代码/区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性地址/地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性地址/地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}	
	/**
	 * 属性电话/电话的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性电话/电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	/**
	 * 属性出租给他人的耕地面积/出租给他人的耕地面积的getter方法
	 */
	public java.lang.Double getRentArea() {
		return rentArea;
	}
	/**
	 * 属性出租给他人的耕地面积/出租给他人的耕地面积的setter方法
	 */
	public void setRentArea(java.lang.Double rentArea) {
		this.rentArea = rentArea;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性操作员时间/操作员时间的getter方法
	 */
	public Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性操作员时间/操作员时间的setter方法
	 */
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性二轮承包面积/二轮承包面积的getter方法
	 */
	public java.lang.Double getOwnArea() {
		return ownArea;
	}
	/**
	 * 属性二轮承包面积/二轮承包面积的setter方法
	 */
	public void setOwnArea(java.lang.Double ownArea) {
		this.ownArea = ownArea;
	}	
	/**
	 * 属性租种面积/租种面积的getter方法
	 */
	public java.lang.Double getCroftingArea() {
		return croftingArea;
	}
	/**
	 * 属性租种面积/租种面积的setter方法
	 */
	public void setCroftingArea(java.lang.Double croftingArea) {
		this.croftingArea = croftingArea;
	}	
	/**
	 * 属性种植面积/种植面积的getter方法
	 */
	public java.lang.Double getPlantArea() {
		return plantArea;
	}
	/**
	 * 属性种植面积/种植面积的setter方法
	 */
	public void setPlantArea(java.lang.Double plantArea) {
		this.plantArea = plantArea;
	}	
	/**
	 * 属性农户代码1/农户代码1的getter方法
	 */
	public String getCodeBackUp() {
		return codeBackUp;
	}
	/**
	 * 属性农户代码1/农户代码1的setter方法
	 */
	public void setCodeBackUp(String codeBackUp) {
		this.codeBackUp = codeBackUp;
	}	
	/**
	 * 属性原行政区划代码/原行政区划代码的getter方法
	 */
	public String getAreaCodeBackUp() {
		return areaCodeBackUp;
	}
	/**
	 * 属性原行政区划代码/原行政区划代码的setter方法
	 */
	public void setAreaCodeBackUp(String areaCodeBackUp) {
		this.areaCodeBackUp = areaCodeBackUp;
	}	
	/**
	 * 属性0：无效，1有效/0：无效，1有效的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性0：无效，1有效/0：无效，1有效的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性并发控制/并发控制的getter方法
	 */
	public java.lang.Integer getVersion() {
		return version;
	}
	/**
	 * 属性并发控制/并发控制的setter方法
	 */
	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}	
}
