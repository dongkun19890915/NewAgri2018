package com.sinosoft.pms.core.misc.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 参考资料信息表实体操作对象
 */
@Entity
@Table(name = "PrpDmaterialInfo")
@IdClass(PrpDmaterialInfoKey.class)
public class PrpDmaterialInfo extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性资料编号/资料编号 */
        @Id
        @Column(name = "materialId")
	private String materialId ;	

	/** 属性资料标题/资料标题 */
	private String materialName ;
	/** 属性资料关键字/资料关键字 */
	private String keyWord ;
	/** 属性资料分类/资料分类 */
	private String materialType ;
	/** 属性颁布日期/颁布日期 */
	private java.util.Date enactmentTime ;
	/** 属性适用区域层级/适用区域层级 */
	private String areaLevel ;
	/** 属性适用区域代码/适用区域代码 */
	private String areaCode ;
	/** 属性适用区域名称/适用区域名称 */
	private String areaName ;
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;
	/** 属性有效标志/有效标志 */
	private String validInd ;
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;




	/**
	 * 属性资料编号/资料编号的getter方法
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * 属性资料编号/资料编号的setter方法
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	} 	
	/**
	 * 属性资料标题/资料标题的getter方法
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * 属性资料标题/资料标题的setter方法
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	} 	
	/**
	 * 属性资料关键字/资料关键字的getter方法
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 属性资料关键字/资料关键字的setter方法
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	} 	
	/**
	 * 属性资料分类/资料分类的getter方法
	 */
	public String getMaterialType() {
		return materialType;
	}
	/**
	 * 属性资料分类/资料分类的setter方法
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	} 	
	/**
	 * 属性颁布日期/颁布日期的getter方法
	 */
	public java.util.Date getEnactmentTime() {
		return enactmentTime;
	}
	/**
	 * 属性颁布日期/颁布日期的setter方法
	 */
	public void setEnactmentTime(java.util.Date enactmentTime) {
		this.enactmentTime = enactmentTime;
	} 	
	/**
	 * 属性适用区域层级/适用区域层级的getter方法
	 */
	public String getAreaLevel() {
		return areaLevel;
	}
	/**
	 * 属性适用区域层级/适用区域层级的setter方法
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	} 	
	/**
	 * 属性适用区域代码/适用区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性适用区域代码/适用区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	} 	
	/**
	 * 属性适用区域名称/适用区域名称的getter方法
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 属性适用区域名称/适用区域名称的setter方法
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	} 	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 	
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
	} 	
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	} 	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	} 	
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
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
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
		
		
		
		
}