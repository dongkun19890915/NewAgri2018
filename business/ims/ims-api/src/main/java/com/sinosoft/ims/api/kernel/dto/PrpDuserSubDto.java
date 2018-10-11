package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 员工附加信息表Api操作对象
 */
public class PrpDuserSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性用户名/用户名 */
	private String userCode ;		
	/** 属性身份证号/身份证号 */
	private String identifyNo ;		
	/** 属性性别：1 男 0 女/性别：1 男 0 女 */
	private String sex ;		
	/** 属性民族/民族 */
	private String nationality ;		
	/** 属性生日/生日 */
	private java.util.Date birthday ;		
	/** 属性enrollDate/enrollDate */
	private java.util.Date enrollDate ;		
	/** 属性position/position */
	private String position ;		
	/** 属性jobTitle/jobTitle */
	private String jobTitle ;		
	/** 属性aquireDate/aquireDate */
	private java.util.Date aquireDate ;		
	/** 属性politicalNature/politicalNature */
	private String politicalNature ;		
	/** 属性joinPartyDate/joinPartyDate */
	private java.util.Date joinPartyDate ;		
	/** 属性beginWorkDate/beginWorkDate */
	private java.util.Date beginWorkDate ;		
	/** 属性gocountryDate/gocountryDate */
	private java.util.Date goCountryDate ;		
	/** 属性joinArmyDate/joinArmyDate */
	private java.util.Date joinArmyDate ;		
	/** 属性primaryGraduateSchool/primaryGraduateSchool */
	private String primaryGraduateSchool ;		
	/** 属性primaryMajor/primaryMajor */
	private String primaryMajor ;		
	/** 属性primaryEducationExperience/primaryEducationExperience */
	private String primaryEducationExperience ;		
	/** 属性primaryDegree/primaryDegree */
	private String primaryDegree ;		
	/** 属性secondGraduateSchool/secondGraduateSchool */
	private String secondGraduateSchool ;		
	/** 属性secondMajor/secondMajor */
	private String secondMajor ;		
	/** 属性secondEducationExperience/secondEducationExperience */
	private String secondEducationExperience ;		
	/** 属性secondDegree/secondDegree */
	private String secondDegree ;		
	/** 属性thirdGraduateSchool/thirdGraduateSchool */
	private String thirdGraduateSchool ;		
	/** 属性thirdMajor/thirdMajor */
	private String thirdMajor ;		
	/** 属性thirdEducationExperience/thirdEducationExperience */
	private String thirdEducationExperience ;		
	/** 属性thirdDegree/thirdDegree */
	private String thirdDegree ;		
	/** 属性originUnit/originUnit */
	private String originUnit ;		
	/** 属性originPosition/originPosition */
	private String originPosition ;		
	/** 属性homePhone/homePhone */
	private String homePhone ;		
	/** 属性homeAddress/homeAddress */
	private String homeAddress ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/**
	 * 属性用户名/用户名的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性用户名/用户名的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性身份证号/身份证号的getter方法
	 */
	public String getIdentifyNo() {
		return identifyNo;
	}
	/**
	 * 属性身份证号/身份证号的setter方法
	 */
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}	
	/**
	 * 属性性别：1 男 0 女/性别：1 男 0 女的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别：1 男 0 女/性别：1 男 0 女的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}	
	/**
	 * 属性民族/民族的getter方法
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * 属性民族/民族的setter方法
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}	
	/**
	 * 属性生日/生日的getter方法
	 */
	public java.util.Date getBirthday() {
		return birthday;
	}
	/**
	 * 属性生日/生日的setter方法
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}	
	/**
	 * 属性enrollDate/enrollDate的getter方法
	 */
	public java.util.Date getEnrollDate() {
		return enrollDate;
	}
	/**
	 * 属性enrollDate/enrollDate的setter方法
	 */
	public void setEnrollDate(java.util.Date enrollDate) {
		this.enrollDate = enrollDate;
	}	
	/**
	 * 属性position/position的getter方法
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 属性position/position的setter方法
	 */
	public void setPosition(String position) {
		this.position = position;
	}	
	/**
	 * 属性jobTitle/jobTitle的getter方法
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * 属性jobTitle/jobTitle的setter方法
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
	/**
	 * 属性aquireDate/aquireDate的getter方法
	 */
	public java.util.Date getAquireDate() {
		return aquireDate;
	}
	/**
	 * 属性aquireDate/aquireDate的setter方法
	 */
	public void setAquireDate(java.util.Date aquireDate) {
		this.aquireDate = aquireDate;
	}	
	/**
	 * 属性politicalNature/politicalNature的getter方法
	 */
	public String getPoliticalNature() {
		return politicalNature;
	}
	/**
	 * 属性politicalNature/politicalNature的setter方法
	 */
	public void setPoliticalNature(String politicalNature) {
		this.politicalNature = politicalNature;
	}	
	/**
	 * 属性joinPartyDate/joinPartyDate的getter方法
	 */
	public java.util.Date getJoinPartyDate() {
		return joinPartyDate;
	}
	/**
	 * 属性joinPartyDate/joinPartyDate的setter方法
	 */
	public void setJoinPartyDate(java.util.Date joinPartyDate) {
		this.joinPartyDate = joinPartyDate;
	}	
	/**
	 * 属性beginWorkDate/beginWorkDate的getter方法
	 */
	public java.util.Date getBeginWorkDate() {
		return beginWorkDate;
	}
	/**
	 * 属性beginWorkDate/beginWorkDate的setter方法
	 */
	public void setBeginWorkDate(java.util.Date beginWorkDate) {
		this.beginWorkDate = beginWorkDate;
	}	
	/**
	 * 属性gocountryDate/gocountryDate的getter方法
	 */
	public java.util.Date getGoCountryDate() {
		return goCountryDate;
	}
	/**
	 * 属性gocountryDate/gocountryDate的setter方法
	 */
	public void setGoCountryDate(java.util.Date goCountryDate) {
		this.goCountryDate = goCountryDate;
	}	
	/**
	 * 属性joinArmyDate/joinArmyDate的getter方法
	 */
	public java.util.Date getJoinArmyDate() {
		return joinArmyDate;
	}
	/**
	 * 属性joinArmyDate/joinArmyDate的setter方法
	 */
	public void setJoinArmyDate(java.util.Date joinArmyDate) {
		this.joinArmyDate = joinArmyDate;
	}	
	/**
	 * 属性primaryGraduateSchool/primaryGraduateSchool的getter方法
	 */
	public String getPrimaryGraduateSchool() {
		return primaryGraduateSchool;
	}
	/**
	 * 属性primaryGraduateSchool/primaryGraduateSchool的setter方法
	 */
	public void setPrimaryGraduateSchool(String primaryGraduateSchool) {
		this.primaryGraduateSchool = primaryGraduateSchool;
	}	
	/**
	 * 属性primaryMajor/primaryMajor的getter方法
	 */
	public String getPrimaryMajor() {
		return primaryMajor;
	}
	/**
	 * 属性primaryMajor/primaryMajor的setter方法
	 */
	public void setPrimaryMajor(String primaryMajor) {
		this.primaryMajor = primaryMajor;
	}	
	/**
	 * 属性primaryEducationExperience/primaryEducationExperience的getter方法
	 */
	public String getPrimaryEducationExperience() {
		return primaryEducationExperience;
	}
	/**
	 * 属性primaryEducationExperience/primaryEducationExperience的setter方法
	 */
	public void setPrimaryEducationExperience(String primaryEducationExperience) {
		this.primaryEducationExperience = primaryEducationExperience;
	}	
	/**
	 * 属性primaryDegree/primaryDegree的getter方法
	 */
	public String getPrimaryDegree() {
		return primaryDegree;
	}
	/**
	 * 属性primaryDegree/primaryDegree的setter方法
	 */
	public void setPrimaryDegree(String primaryDegree) {
		this.primaryDegree = primaryDegree;
	}	
	/**
	 * 属性secondGraduateSchool/secondGraduateSchool的getter方法
	 */
	public String getSecondGraduateSchool() {
		return secondGraduateSchool;
	}
	/**
	 * 属性secondGraduateSchool/secondGraduateSchool的setter方法
	 */
	public void setSecondGraduateSchool(String secondGraduateSchool) {
		this.secondGraduateSchool = secondGraduateSchool;
	}	
	/**
	 * 属性secondMajor/secondMajor的getter方法
	 */
	public String getSecondMajor() {
		return secondMajor;
	}
	/**
	 * 属性secondMajor/secondMajor的setter方法
	 */
	public void setSecondMajor(String secondMajor) {
		this.secondMajor = secondMajor;
	}	
	/**
	 * 属性secondEducationExperience/secondEducationExperience的getter方法
	 */
	public String getSecondEducationExperience() {
		return secondEducationExperience;
	}
	/**
	 * 属性secondEducationExperience/secondEducationExperience的setter方法
	 */
	public void setSecondEducationExperience(String secondEducationExperience) {
		this.secondEducationExperience = secondEducationExperience;
	}	
	/**
	 * 属性secondDegree/secondDegree的getter方法
	 */
	public String getSecondDegree() {
		return secondDegree;
	}
	/**
	 * 属性secondDegree/secondDegree的setter方法
	 */
	public void setSecondDegree(String secondDegree) {
		this.secondDegree = secondDegree;
	}	
	/**
	 * 属性thirdGraduateSchool/thirdGraduateSchool的getter方法
	 */
	public String getThirdGraduateSchool() {
		return thirdGraduateSchool;
	}
	/**
	 * 属性thirdGraduateSchool/thirdGraduateSchool的setter方法
	 */
	public void setThirdGraduateSchool(String thirdGraduateSchool) {
		this.thirdGraduateSchool = thirdGraduateSchool;
	}	
	/**
	 * 属性thirdMajor/thirdMajor的getter方法
	 */
	public String getThirdMajor() {
		return thirdMajor;
	}
	/**
	 * 属性thirdMajor/thirdMajor的setter方法
	 */
	public void setThirdMajor(String thirdMajor) {
		this.thirdMajor = thirdMajor;
	}	
	/**
	 * 属性thirdEducationExperience/thirdEducationExperience的getter方法
	 */
	public String getThirdEducationExperience() {
		return thirdEducationExperience;
	}
	/**
	 * 属性thirdEducationExperience/thirdEducationExperience的setter方法
	 */
	public void setThirdEducationExperience(String thirdEducationExperience) {
		this.thirdEducationExperience = thirdEducationExperience;
	}	
	/**
	 * 属性thirdDegree/thirdDegree的getter方法
	 */
	public String getThirdDegree() {
		return thirdDegree;
	}
	/**
	 * 属性thirdDegree/thirdDegree的setter方法
	 */
	public void setThirdDegree(String thirdDegree) {
		this.thirdDegree = thirdDegree;
	}	
	/**
	 * 属性originUnit/originUnit的getter方法
	 */
	public String getOriginUnit() {
		return originUnit;
	}
	/**
	 * 属性originUnit/originUnit的setter方法
	 */
	public void setOriginUnit(String originUnit) {
		this.originUnit = originUnit;
	}	
	/**
	 * 属性originPosition/originPosition的getter方法
	 */
	public String getOriginPosition() {
		return originPosition;
	}
	/**
	 * 属性originPosition/originPosition的setter方法
	 */
	public void setOriginPosition(String originPosition) {
		this.originPosition = originPosition;
	}	
	/**
	 * 属性homePhone/homePhone的getter方法
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * 属性homePhone/homePhone的setter方法
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}	
	/**
	 * 属性homeAddress/homeAddress的getter方法
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * 属性homeAddress/homeAddress的setter方法
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}
