package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * plantingUpLoadInsuranceList实体操作对象
 */
@Entity
@Table(name = "plantingUpLoadInsuranceList")
@IdClass(PlantingUpLoadInsuranceListKey.class)
public class PlantingUpLoadInsuranceList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性临时标识/临时标识 */
	@Id
	@Column(name = "inusreListCode")
	private String inusreListCode ;/** 属性农户代码/农户代码 */
	@Id
	@Column(name = "fCode")
	private String fCode ;	


	/** 属性电话/电话 */
	@Column(name = "phone")
	private String phone ;
	/** 属性直补卡/直补卡 */
	@Column(name = "zhiBuKa")
	private String zhiBuKa ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性身份证号/身份证号 */
	@Column(name = "fIdCard")
	private String fIdCard ;
	/** 属性预留字段/预留字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性可承保面积/可承保面积 */
	@Column(name = "taxArea")
	private java.lang.Double taxArea ;
	/** 属性实际承保面积/实际承保面积 */
	@Column(name = "insureArea")
	private java.lang.Double insureArea ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性组别/组别 */
	@Column(name = "teamName")
	private String teamName ;
	/** 属性土地来源/土地来源 */
	@Column(name = "fieldSource")
	private String fieldSource ;
	/** 属性预留字段1/预留字段1 */
	@Column(name = "flag1")
	private String flag1 ;
	/** 属性操作日期/操作日期 */
	@Column(name = "operateDate")
	private java.util.Date operateDate ;
	/** 属性林权证号/林权证号 */
	@Column(name = "warrant")
	private String warrant ;
	/** 属性坐落地点/坐落地点 */
	@Column(name = "atArea")
	private String atArea ;
	/** 属性小地名/小地名 */
	@Column(name = "littleAreaName")
	private String littleAreaName ;
	/** 属性实有林地/实有林地 */
	@Column(name = "woodLandArea")
	private java.lang.Double woodLandArea ;
	/**
	 * 属性临时标识/临时标识的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性临时标识/临时标识的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
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
	 * 属性直补卡/直补卡的getter方法
	 */
	public String getZhiBuKa() {
		return zhiBuKa;
	}
	/**
	 * 属性直补卡/直补卡的setter方法
	 */
	public void setZhiBuKa(String zhiBuKa) {
		this.zhiBuKa = zhiBuKa;
	} 	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setFName(String fName) {
		this.fName = fName;
	} 	
	/**
	 * 属性身份证号/身份证号的getter方法
	 */
	public String getFIdCard() {
		return fIdCard;
	}
	/**
	 * 属性身份证号/身份证号的setter方法
	 */
	public void setFIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	} 	
	/**
	 * 属性预留字段/预留字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性预留字段/预留字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性可承保面积/可承保面积的getter方法
	 */
	public java.lang.Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性可承保面积/可承保面积的setter方法
	 */
	public void setTaxArea(java.lang.Double taxArea) {
		this.taxArea = taxArea;
	} 	
	/**
	 * 属性实际承保面积/实际承保面积的getter方法
	 */
	public java.lang.Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性实际承保面积/实际承保面积的setter方法
	 */
	public void setInsureArea(java.lang.Double insureArea) {
		this.insureArea = insureArea;
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
	 * 属性组别/组别的getter方法
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * 属性组别/组别的setter方法
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	} 	
	/**
	 * 属性土地来源/土地来源的getter方法
	 */
	public String getFieldSource() {
		return fieldSource;
	}
	/**
	 * 属性土地来源/土地来源的setter方法
	 */
	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
	} 	
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getFlag1() {
		return flag1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	} 	
	/**
	 * 属性操作日期/操作日期的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性操作日期/操作日期的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	} 	
	/**
	 * 属性林权证号/林权证号的getter方法
	 */
	public String getWarrant() {
		return warrant;
	}
	/**
	 * 属性林权证号/林权证号的setter方法
	 */
	public void setWarrant(String warrant) {
		this.warrant = warrant;
	} 	
	/**
	 * 属性坐落地点/坐落地点的getter方法
	 */
	public String getAtArea() {
		return atArea;
	}
	/**
	 * 属性坐落地点/坐落地点的setter方法
	 */
	public void setAtArea(String atArea) {
		this.atArea = atArea;
	} 	
	/**
	 * 属性小地名/小地名的getter方法
	 */
	public String getLittleAreaName() {
		return littleAreaName;
	}
	/**
	 * 属性小地名/小地名的setter方法
	 */
	public void setLittleAreaName(String littleAreaName) {
		this.littleAreaName = littleAreaName;
	} 	
	/**
	 * 属性实有林地/实有林地的getter方法
	 */
	public java.lang.Double getWoodLandArea() {
		return woodLandArea;
	}
	/**
	 * 属性实有林地/实有林地的setter方法
	 */
	public void setWoodLandArea(java.lang.Double woodLandArea) {
		this.woodLandArea = woodLandArea;
	} 	
}