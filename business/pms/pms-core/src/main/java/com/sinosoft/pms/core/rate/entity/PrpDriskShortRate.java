package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 产品短期费率表实体操作对象
 */
@Entity
@Table(name = "PrpDriskShortRate")
@IdClass(PrpDriskShortRateKey.class)
public class PrpDriskShortRate extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性短期费率代码/短期费率代码 */
        @Id
        @Column(name = "shortRateId")
	private String shortRateId ;/** 属性条款代码/条款代码 */
        @Id
        @Column(name = "clauseCode")
	private String clauseCode ;/** 属性序号/序号 */
        @Id
        @Column(name = "serialNo")
	private java.lang.Integer serialNo ;	


	/** 属性旧短期费率代码/旧短期费率代码 */
	private String oldShortRateId ;


	/** 属性短期费率名称/短期费率名称 */
	private String shortRateName ;
	/** 属性短期费率类型/短期费率类型 */
	private String rateType ;
	/** 属性下限计算符/下限计算符 */
	private String lowerOperator ;
	/** 属性时间下限/时间下限 */
	private java.lang.Double lower ;
	/** 属性上限计算符/上限计算符 */
	private String upperOperator ;
	/** 属性时间上限/时间上限 */
	private java.lang.Double upper ;
	/** 属性短期费率计算方式/短期费率计算方式 */
	private String modeType ;
	/** 属性实际承保下限计算符/实际承保下限计算符 */
	private String actualLowerOperator ;
	/** 属性实际承保时间下限/实际承保时间下限 */
	private java.lang.Double actualLower ;
	/** 属性实际承保上限计算符/实际承保上限计算符 */
	private String actuaUpperOperator ;
	/** 属性实际承保时间上限/实际承保时间上限 */
	private java.lang.Double actuaUpper ;
	/** 属性短期费率分子/短期费率分子 */
	private java.lang.Double shortRateNumerator ;
	/** 属性短期费率分母/短期费率分母 */
	private java.lang.Integer shortRateDenominator ;
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
	 * 属性短期费率代码/短期费率代码的getter方法
	 */
	public String getShortRateId() {
		return shortRateId;
	}
	/**
	 * 属性短期费率代码/短期费率代码的setter方法
	 */
	public void setShortRateId(String shortRateId) {
		this.shortRateId = shortRateId;
	} 	
	/**
	 * 属性旧短期费率代码/旧短期费率代码的getter方法
	 */
	public String getOldShortRateId() {
		return oldShortRateId;
	}
	/**
	 * 属性旧短期费率代码/旧短期费率代码的setter方法
	 */
	public void setOldShortRateId(String oldShortRateId) {
		this.oldShortRateId = oldShortRateId;
	} 	
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性短期费率名称/短期费率名称的getter方法
	 */
	public String getShortRateName() {
		return shortRateName;
	}
	/**
	 * 属性短期费率名称/短期费率名称的setter方法
	 */
	public void setShortRateName(String shortRateName) {
		this.shortRateName = shortRateName;
	} 	
	/**
	 * 属性短期费率类型/短期费率类型的getter方法
	 */
	public String getRateType() {
		return rateType;
	}
	/**
	 * 属性短期费率类型/短期费率类型的setter方法
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	} 	
	/**
	 * 属性下限计算符/下限计算符的getter方法
	 */
	public String getLowerOperator() {
		return lowerOperator;
	}
	/**
	 * 属性下限计算符/下限计算符的setter方法
	 */
	public void setLowerOperator(String lowerOperator) {
		this.lowerOperator = lowerOperator;
	} 	
	/**
	 * 属性时间下限/时间下限的getter方法
	 */
	public java.lang.Double getLower() {
		return lower;
	}
	/**
	 * 属性时间下限/时间下限的setter方法
	 */
	public void setLower(java.lang.Double lower) {
		this.lower = lower;
	} 	
	/**
	 * 属性上限计算符/上限计算符的getter方法
	 */
	public String getUpperOperator() {
		return upperOperator;
	}
	/**
	 * 属性上限计算符/上限计算符的setter方法
	 */
	public void setUpperOperator(String upperOperator) {
		this.upperOperator = upperOperator;
	} 	
	/**
	 * 属性时间上限/时间上限的getter方法
	 */
	public java.lang.Double getUpper() {
		return upper;
	}
	/**
	 * 属性时间上限/时间上限的setter方法
	 */
	public void setUpper(java.lang.Double upper) {
		this.upper = upper;
	} 	
	/**
	 * 属性短期费率计算方式/短期费率计算方式的getter方法
	 */
	public String getModeType() {
		return modeType;
	}
	/**
	 * 属性短期费率计算方式/短期费率计算方式的setter方法
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	} 	
	/**
	 * 属性实际承保下限计算符/实际承保下限计算符的getter方法
	 */
	public String getActualLowerOperator() {
		return actualLowerOperator;
	}
	/**
	 * 属性实际承保下限计算符/实际承保下限计算符的setter方法
	 */
	public void setActualLowerOperator(String actualLowerOperator) {
		this.actualLowerOperator = actualLowerOperator;
	} 	
	/**
	 * 属性实际承保时间下限/实际承保时间下限的getter方法
	 */
	public java.lang.Double getActualLower() {
		return actualLower;
	}
	/**
	 * 属性实际承保时间下限/实际承保时间下限的setter方法
	 */
	public void setActualLower(java.lang.Double actualLower) {
		this.actualLower = actualLower;
	} 	
	/**
	 * 属性实际承保上限计算符/实际承保上限计算符的getter方法
	 */
	public String getActuaUpperOperator() {
		return actuaUpperOperator;
	}
	/**
	 * 属性实际承保上限计算符/实际承保上限计算符的setter方法
	 */
	public void setActuaUpperOperator(String actuaUpperOperator) {
		this.actuaUpperOperator = actuaUpperOperator;
	} 	
	/**
	 * 属性实际承保时间上限/实际承保时间上限的getter方法
	 */
	public java.lang.Double getActuaUpper() {
		return actuaUpper;
	}
	/**
	 * 属性实际承保时间上限/实际承保时间上限的setter方法
	 */
	public void setActuaUpper(java.lang.Double actuaUpper) {
		this.actuaUpper = actuaUpper;
	} 	
	/**
	 * 属性短期费率分子/短期费率分子的getter方法
	 */
	public java.lang.Double getShortRateNumerator() {
		return shortRateNumerator;
	}
	/**
	 * 属性短期费率分子/短期费率分子的setter方法
	 */
	public void setShortRateNumerator(java.lang.Double shortRateNumerator) {
		this.shortRateNumerator = shortRateNumerator;
	} 	
	/**
	 * 属性短期费率分母/短期费率分母的getter方法
	 */
	public java.lang.Integer getShortRateDenominator() {
		return shortRateDenominator;
	}
	/**
	 * 属性短期费率分母/短期费率分母的setter方法
	 */
	public void setShortRateDenominator(java.lang.Integer shortRateDenominator) {
		this.shortRateDenominator = shortRateDenominator;
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