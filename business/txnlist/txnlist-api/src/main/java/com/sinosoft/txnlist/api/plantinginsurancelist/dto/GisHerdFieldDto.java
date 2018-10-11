package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * 牲畜耳标号/脚环号表Api操作对象
 * @author: 何伟东
 * @date: 2017/12/19 9:48
 */
public class GisHerdFieldDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	private String insureListCode ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性序列号/序列号 */
	private Integer serialNo ;
	/** 属性耳标号/耳标号 */
	private String earLabel ;		
	/** 属性养殖地点代码/养殖地点代码 */
	private String breedingAreaCode ;		
	/** 属性养殖地点名称/养殖地点名称 */
	private String breedingAreaName ;		
	/** 属性养殖方式/养殖方式 */
	private String breedingKind ;		
	/** 属性养殖品种/养殖品种 */
	private String species ;		
	/** 属性畜龄/畜龄 */
	private Double aniMalage ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性备用字段1/备用字段1 */
	private String remark1 ;		
	/** 属性备用字段2/备用字段2 */
	private String remark2 ;		
	/** 属性备用字段3/备用字段3 */
	private String remark3 ;		
	/** 属性备用字段4/备用字段4 */
	private String remark4 ;		
			
			
			
			
	/**
	 * 属性清单编号/清单编号的getter方法
	 */
	public String getInsureListCode() {
		return insureListCode;
	}
	/**
	 * 属性清单编号/清单编号的setter方法
	 */
	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	}	
	/**
	 * 属性序列号/序列号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarLabel() {
		return earLabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}	
	/**
	 * 属性养殖地点代码/养殖地点代码的getter方法
	 */
	public String getBreedingAreaCode() {
		return breedingAreaCode;
	}
	/**
	 * 属性养殖地点代码/养殖地点代码的setter方法
	 */
	public void setBreedingAreaCode(String breedingAreaCode) {
		this.breedingAreaCode = breedingAreaCode;
	}	
	/**
	 * 属性养殖地点名称/养殖地点名称的getter方法
	 */
	public String getBreedingAreaName() {
		return breedingAreaName;
	}
	/**
	 * 属性养殖地点名称/养殖地点名称的setter方法
	 */
	public void setBreedingAreaName(String breedingAreaName) {
		this.breedingAreaName = breedingAreaName;
	}	
	/**
	 * 属性养殖方式/养殖方式的getter方法
	 */
	public String getBreedingKind() {
		return breedingKind;
	}
	/**
	 * 属性养殖方式/养殖方式的setter方法
	 */
	public void setBreedingKind(String breedingKind) {
		this.breedingKind = breedingKind;
	}	
	/**
	 * 属性养殖品种/养殖品种的getter方法
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * 属性养殖品种/养殖品种的setter方法
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	public Double getAniMalage() {
		return aniMalage;
	}

	public void setAniMalage(Double aniMalage) {
		this.aniMalage = aniMalage;
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
	 * 属性备用字段1/备用字段1的getter方法
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * 属性备用字段1/备用字段1的setter方法
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}	
	/**
	 * 属性备用字段3/备用字段3的getter方法
	 */
	public String getRemark3() {
		return remark3;
	}
	/**
	 * 属性备用字段3/备用字段3的setter方法
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}	
	/**
	 * 属性备用字段4/备用字段4的getter方法
	 */
	public String getRemark4() {
		return remark4;
	}
	/**
	 * 属性备用字段4/备用字段4的setter方法
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}	
		
		
		
		
}
