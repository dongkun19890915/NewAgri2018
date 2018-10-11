package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * 牲畜耳标号/脚环号表实体操作对象
 * @author: 何伟东
 * @date: 2017/12/19 9:51
 */
@Entity
@Table(name = "GisHerdField")
@IdClass(GisHerdFieldKey.class)
public class GisHerdField extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	@Id
	@Column(name = "insureListCode")
	private String insureListCode ;
	/** 属性农户代码/农户代码 */
	@Id
	@Column(name = "fCode")
	private String fCode ;
	/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性耳标号/耳标号 */
	@Id
	@Column(name = "earLabel")
	private String earLabel ;	




	/** 属性养殖地点代码/养殖地点代码 */
	@Column(name = "breedingAreaCode")
	private String breedingAreaCode ;
	/** 属性养殖地点名称/养殖地点名称 */
	@Column(name = "breedingAreaName")
	private String breedingAreaName ;
	/** 属性养殖方式/养殖方式 */
	@Column(name = "breedingKind")
	private String breedingKind ;
	/** 属性养殖品种/养殖品种 */
	@Column(name = "species")
	private String species ;
	/** 属性畜龄/畜龄 */
	@Column(name = "animalAge")
	private Double animalAge ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性备用字段1/备用字段1 */
	@Column(name = "remark1")
	private String remark1 ;
	/** 属性备用字段2/备用字段2 */
	@Column(name = "remark2")
	private String remark2 ;
	/** 属性备用字段3/备用字段3 */
	@Column(name = "remark3")
	private String remark3 ;
	/** 属性备用字段4/备用字段4 */
	@Column(name = "remark4")
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

	public Double getAnimalAge() {		return animalAge;	}

	public void setAnimalAge(Double animalAge) {		this.animalAge = animalAge;	}

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