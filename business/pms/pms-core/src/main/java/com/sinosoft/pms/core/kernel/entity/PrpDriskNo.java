package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品临时代码表实体操作对象
 */
@Entity
@Table(name = "PrpDriskNo")
@IdClass(PrpDriskNoKey.class)
public class PrpDriskNo extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性流水号ID/流水号ID */
        @Id
        @Column(name = "id")
	private String id ;	

	/** 属性产品临时码/产品临时码 */
	private String tempRiskCode ;
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;




	/**
	 * 属性流水号ID/流水号ID的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性流水号ID/流水号ID的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 	
	/**
	 * 属性产品临时码/产品临时码的getter方法
	 */
	public String getTempRiskCode() {
		return tempRiskCode;
	}
	/**
	 * 属性产品临时码/产品临时码的setter方法
	 */
	public void setTempRiskCode(String tempRiskCode) {
		this.tempRiskCode = tempRiskCode;
	} 	
	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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