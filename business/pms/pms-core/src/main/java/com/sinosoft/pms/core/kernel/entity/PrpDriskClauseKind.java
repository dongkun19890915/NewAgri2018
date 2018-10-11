package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDriskClauseKind实体操作对象
 */
@Entity
@Table(name = "PrpDriskClauseKind")
@IdClass(PrpDriskClauseKindKey.class)
public class PrpDriskClauseKind extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性riskCode/riskCode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性riskkcserialNo/riskkcserialNo */
	@Id
	@Column(name = "riskKcSerialNo")
	private java.lang.Integer riskKcSerialNo ;/** 属性clauseCode/clauseCode */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;	



	/** 属性clauseKindId/clauseKindId */
	@Column(name = "clauseKindId")
	private String clauseKindId ;
	/** 属性kindCode/kindCode */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性oldKindCode/oldKindCode */
	@Column(name = "oldKindCode")
	private String oldKindCode ;
	/** 属性kindScname/kindScname */
	@Column(name = "kindSCName")
	private String kindSCName ;
	/** 属性kindEname/kindEname */
	@Column(name = "kindEName")
	private String kindEName ;
	/** 属性kindName/kindName */
	@Column(name = "kindName")
	private String kindName ;
	/** 属性clauseClassCode/clauseClassCode */
	@Column(name = "clauseClassCode")
	private String clauseClassCode ;
	/** 属性kindClassCode/kindClassCode */
	@Column(name = "kindClassCode")
	private String kindClassCode ;
	/** 属性itemCode/itemCode */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性kindAttribute/kindAttribute */
	@Column(name = "kindAttribute")
	private String kindAttribute ;
	/** 属性type/type */
	@Column(name = "type")
	private String type ;
	/** 属性rateUnit/rateUnit */
	@Column(name = "rateUnit")
	private String rateUnit ;
	/** 属性lowerOperator/lowerOperator */
	@Column(name = "lowerOperator")
	private String lowerOperator ;
	/** 属性upperOperator/upperOperator */
	@Column(name = "upperOperator")
	private String upperOperator ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/** 属性upper/upper */
	@Column(name = "upper")
	private java.lang.Double upper ;
	/** 属性lower/lower */
	@Column(name = "lower")
	private java.lang.Double lower ;
	/** 属性value/value */
	@Column(name = "value")
	private java.lang.Double value ;
	/** 属性claculateFag/claculateFag */
	@Column(name = "claculateFag")
	private String claculateFag ;
	/** 属性hycenterFlag/hycenterFlag */
	@Column(name = "hyCenterFlag")
	private String hyCenterFlag ;
	/** 属性dutyfreeFlag/dutyfreeFlag */
	@Column(name = "dutyFreeFlag")
	private String dutyFreeFlag ;
	/** 属性validDate/validDate */
	@Column(name = "validDate")
	private java.util.Date validDate ;
	/** 属性invalidDate/invalidDate */
	@Column(name = "invalidDate")
	private java.util.Date invalidDate ;
	/** 属性validind/validind */
	@Column(name = "validind")
	private String validind ;
	/** 属性tcol1/tcol1 */
	@Column(name = "tcol1")
	private String tcol1 ;
	/** 属性tcol2/tcol2 */
	@Column(name = "tcol2")
	private String tcol2 ;
	/** 属性tcol3/tcol3 */
	@Column(name = "tcol3")
	private String tcol3 ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性calculateFlag/calculateFlag */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性claimType/claimType */
	@Column(name = "claimType")
	private String claimType ;
	/** 属性endUpdaterCode/endUpdaterCode */
	@Column(name = "endUpdaterCode")
	private String endUpdaterCode ;
	/** 属性operateTimeforhis/operateTimeforhis */
	@Column(name = "operateTimeForHis")
	private java.util.Date operateTimeForHis ;
	/** 属性kindLevel/kindLevel */
	@Column(name = "kindLevel")
	private String kindLevel ;
	/** 属性upperKindCode/upperKindCode */
	@Column(name = "upperKindCode")
	private String upperKindCode ;
	/** 属性upperKindName/upperKindName */
	@Column(name = "upperKindName")
	private String upperKindName ;
	/** 属性kindRatio/kindRatio */
	@Column(name = "kindRatio")
	private java.lang.Double kindRatio ;
	/** 属性allowance/allowance */
	@Column(name = "allowance")
	private String allowance ;
	/** 属性allowanceAmount/allowanceAmount */
	@Column(name = "allowanceAmount")
	private String allowanceAmount ;
	/** 属性allowanceDays/allowanceDays */
	@Column(name = "allowanceDays")
	private String allowanceDays ;
	/** 属性allowanceSumAmount/allowanceSumAmount */
	@Column(name = "allowanceSumAmount")
	private String allowanceSumAmount ;
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性riskkcserialNo/riskkcserialNo的getter方法
	 */
	public java.lang.Integer getRiskKcSerialNo() {
		return riskKcSerialNo;
	}
	/**
	 * 属性riskkcserialNo/riskkcserialNo的setter方法
	 */
	public void setRiskKcSerialNo(java.lang.Integer riskKcSerialNo) {
		this.riskKcSerialNo = riskKcSerialNo;
	} 	
	/**
	 * 属性clauseCode/clauseCode的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性clauseCode/clauseCode的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 	
	/**
	 * 属性clauseKindId/clauseKindId的getter方法
	 */
	public String getClauseKindId() {
		return clauseKindId;
	}
	/**
	 * 属性clauseKindId/clauseKindId的setter方法
	 */
	public void setClauseKindId(String clauseKindId) {
		this.clauseKindId = clauseKindId;
	} 	
	/**
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性oldKindCode/oldKindCode的getter方法
	 */
	public String getOldKindCode() {
		return oldKindCode;
	}
	/**
	 * 属性oldKindCode/oldKindCode的setter方法
	 */
	public void setOldKindCode(String oldKindCode) {
		this.oldKindCode = oldKindCode;
	} 	
	/**
	 * 属性kindScname/kindScname的getter方法
	 */
	public String getKindSCName() {
		return kindSCName;
	}
	/**
	 * 属性kindScname/kindScname的setter方法
	 */
	public void setKindSCName(String kindSCName) {
		this.kindSCName = kindSCName;
	} 	
	/**
	 * 属性kindEname/kindEname的getter方法
	 */
	public String getKindEName() {
		return kindEName;
	}
	/**
	 * 属性kindEname/kindEname的setter方法
	 */
	public void setKindEName(String kindEName) {
		this.kindEName = kindEName;
	} 	
	/**
	 * 属性kindName/kindName的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性kindName/kindName的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	} 	
	/**
	 * 属性clauseClassCode/clauseClassCode的getter方法
	 */
	public String getClauseClassCode() {
		return clauseClassCode;
	}
	/**
	 * 属性clauseClassCode/clauseClassCode的setter方法
	 */
	public void setClauseClassCode(String clauseClassCode) {
		this.clauseClassCode = clauseClassCode;
	} 	
	/**
	 * 属性kindClassCode/kindClassCode的getter方法
	 */
	public String getKindClassCode() {
		return kindClassCode;
	}
	/**
	 * 属性kindClassCode/kindClassCode的setter方法
	 */
	public void setKindClassCode(String kindClassCode) {
		this.kindClassCode = kindClassCode;
	} 	
	/**
	 * 属性itemCode/itemCode的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性itemCode/itemCode的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性kindAttribute/kindAttribute的getter方法
	 */
	public String getKindAttribute() {
		return kindAttribute;
	}
	/**
	 * 属性kindAttribute/kindAttribute的setter方法
	 */
	public void setKindAttribute(String kindAttribute) {
		this.kindAttribute = kindAttribute;
	} 	
	/**
	 * 属性type/type的getter方法
	 */
	public String getType() {
		return type;
	}
	/**
	 * 属性type/type的setter方法
	 */
	public void setType(String type) {
		this.type = type;
	} 	
	/**
	 * 属性rateUnit/rateUnit的getter方法
	 */
	public String getRateUnit() {
		return rateUnit;
	}
	/**
	 * 属性rateUnit/rateUnit的setter方法
	 */
	public void setRateUnit(String rateUnit) {
		this.rateUnit = rateUnit;
	} 	
	/**
	 * 属性lowerOperator/lowerOperator的getter方法
	 */
	public String getLowerOperator() {
		return lowerOperator;
	}
	/**
	 * 属性lowerOperator/lowerOperator的setter方法
	 */
	public void setLowerOperator(String lowerOperator) {
		this.lowerOperator = lowerOperator;
	} 	
	/**
	 * 属性upperOperator/upperOperator的getter方法
	 */
	public String getUpperOperator() {
		return upperOperator;
	}
	/**
	 * 属性upperOperator/upperOperator的setter方法
	 */
	public void setUpperOperator(String upperOperator) {
		this.upperOperator = upperOperator;
	} 	
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性upper/upper的getter方法
	 */
	public java.lang.Double getUpper() {
		return upper;
	}
	/**
	 * 属性upper/upper的setter方法
	 */
	public void setUpper(java.lang.Double upper) {
		this.upper = upper;
	} 	
	/**
	 * 属性lower/lower的getter方法
	 */
	public java.lang.Double getLower() {
		return lower;
	}
	/**
	 * 属性lower/lower的setter方法
	 */
	public void setLower(java.lang.Double lower) {
		this.lower = lower;
	} 	
	/**
	 * 属性value/value的getter方法
	 */
	public java.lang.Double getValue() {
		return value;
	}
	/**
	 * 属性value/value的setter方法
	 */
	public void setValue(java.lang.Double value) {
		this.value = value;
	} 	
	/**
	 * 属性claculateFag/claculateFag的getter方法
	 */
	public String getClaculateFag() {
		return claculateFag;
	}
	/**
	 * 属性claculateFag/claculateFag的setter方法
	 */
	public void setClaculateFag(String claculateFag) {
		this.claculateFag = claculateFag;
	} 	
	/**
	 * 属性hycenterFlag/hycenterFlag的getter方法
	 */
	public String getHyCenterFlag() {
		return hyCenterFlag;
	}
	/**
	 * 属性hycenterFlag/hycenterFlag的setter方法
	 */
	public void setHyCenterFlag(String hyCenterFlag) {
		this.hyCenterFlag = hyCenterFlag;
	} 	
	/**
	 * 属性dutyfreeFlag/dutyfreeFlag的getter方法
	 */
	public String getDutyFreeFlag() {
		return dutyFreeFlag;
	}
	/**
	 * 属性dutyfreeFlag/dutyfreeFlag的setter方法
	 */
	public void setDutyFreeFlag(String dutyFreeFlag) {
		this.dutyFreeFlag = dutyFreeFlag;
	} 	
	/**
	 * 属性validDate/validDate的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性validDate/validDate的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 	
	/**
	 * 属性invalidDate/invalidDate的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性invalidDate/invalidDate的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 	
	/**
	 * 属性validind/validind的getter方法
	 */
	public String getValidind() {
		return validind;
	}
	/**
	 * 属性validind/validind的setter方法
	 */
	public void setValidind(String validind) {
		this.validind = validind;
	} 	
	/**
	 * 属性tcol1/tcol1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性tcol1/tcol1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	} 	
	/**
	 * 属性tcol2/tcol2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性tcol2/tcol2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	} 	
	/**
	 * 属性tcol3/tcol3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性tcol3/tcol3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	/**
	 * 属性calculateFlag/calculateFlag的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性calculateFlag/calculateFlag的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	} 	
	/**
	 * 属性claimType/claimType的getter方法
	 */
	public String getClaimType() {
		return claimType;
	}
	/**
	 * 属性claimType/claimType的setter方法
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	} 	
	/**
	 * 属性endUpdaterCode/endUpdaterCode的getter方法
	 */
	public String getEndUpdaterCode() {
		return endUpdaterCode;
	}
	/**
	 * 属性endUpdaterCode/endUpdaterCode的setter方法
	 */
	public void setEndUpdaterCode(String endUpdaterCode) {
		this.endUpdaterCode = endUpdaterCode;
	} 	
	/**
	 * 属性operateTimeforhis/operateTimeforhis的getter方法
	 */
	public java.util.Date getOperateTimeForHis() {
		return operateTimeForHis;
	}
	/**
	 * 属性operateTimeforhis/operateTimeforhis的setter方法
	 */
	public void setOperateTimeForHis(java.util.Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	} 	
	/**
	 * 属性kindLevel/kindLevel的getter方法
	 */
	public String getKindLevel() {
		return kindLevel;
	}
	/**
	 * 属性kindLevel/kindLevel的setter方法
	 */
	public void setKindLevel(String kindLevel) {
		this.kindLevel = kindLevel;
	} 	
	/**
	 * 属性upperKindCode/upperKindCode的getter方法
	 */
	public String getUpperKindCode() {
		return upperKindCode;
	}
	/**
	 * 属性upperKindCode/upperKindCode的setter方法
	 */
	public void setUpperKindCode(String upperKindCode) {
		this.upperKindCode = upperKindCode;
	} 	
	/**
	 * 属性upperKindName/upperKindName的getter方法
	 */
	public String getUpperKindName() {
		return upperKindName;
	}
	/**
	 * 属性upperKindName/upperKindName的setter方法
	 */
	public void setUpperKindName(String upperKindName) {
		this.upperKindName = upperKindName;
	} 	
	/**
	 * 属性kindRatio/kindRatio的getter方法
	 */
	public java.lang.Double getKindRatio() {
		return kindRatio;
	}
	/**
	 * 属性kindRatio/kindRatio的setter方法
	 */
	public void setKindRatio(java.lang.Double kindRatio) {
		this.kindRatio = kindRatio;
	} 	
	/**
	 * 属性allowance/allowance的getter方法
	 */
	public String getAllowance() {
		return allowance;
	}
	/**
	 * 属性allowance/allowance的setter方法
	 */
	public void setAllowance(String allowance) {
		this.allowance = allowance;
	} 	
	/**
	 * 属性allowanceAmount/allowanceAmount的getter方法
	 */
	public String getAllowanceAmount() {
		return allowanceAmount;
	}
	/**
	 * 属性allowanceAmount/allowanceAmount的setter方法
	 */
	public void setAllowanceAmount(String allowanceAmount) {
		this.allowanceAmount = allowanceAmount;
	} 	
	/**
	 * 属性allowanceDays/allowanceDays的getter方法
	 */
	public String getAllowanceDays() {
		return allowanceDays;
	}
	/**
	 * 属性allowanceDays/allowanceDays的setter方法
	 */
	public void setAllowanceDays(String allowanceDays) {
		this.allowanceDays = allowanceDays;
	} 	
	/**
	 * 属性allowanceSumAmount/allowanceSumAmount的getter方法
	 */
	public String getAllowanceSumAmount() {
		return allowanceSumAmount;
	}
	/**
	 * 属性allowanceSumAmount/allowanceSumAmount的setter方法
	 */
	public void setAllowanceSumAmount(String allowanceSumAmount) {
		this.allowanceSumAmount = allowanceSumAmount;
	} 	
}