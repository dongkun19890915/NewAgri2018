package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoins;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 共保信息表实体操作对象
 */
@Entity
@Table(name = "PrpCcoins")
@IdClass(PrpCcoinsKey.class)
public class PrpCcoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;


	/** 属性主保单号码/主保单号码 */
	@Column(name = "mainPolicyNo")
	private String mainPolicyNo ;
	/** 属性共保人机构代码/共保人机构代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性共保人名称/共保人名称 */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性共保份额/共保份额 */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外 */
	@Column(name = "coinsRate")
	private Double coinsRate ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性首席标志/首席标志 */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性分摊标志/分摊标志 */
	@Column(name = "proportionFlag")
	private String proportionFlag ;
	/** 属性共保协议号/共保协议号 */
	@Column(name = "coinsTreatyNo")
	private String coinsTreatyNo ;
	/** 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司 */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务 */
	@Column(name = "reinsCiFlag")
	private String reinsCiFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date updateDate ;
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
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性主保单号码/主保单号码的getter方法
	 */
	public String getMainPolicyNo() {
		return mainPolicyNo;
	}
	/**
	 * 属性主保单号码/主保单号码的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	} 	
	/**
	 * 属性共保人机构代码/共保人机构代码的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性共保人机构代码/共保人机构代码的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 	
	/**
	 * 属性共保人名称/共保人名称的getter方法
	 */
	public String getCoinsName() {
		return coinsName;
	}
	/**
	 * 属性共保人名称/共保人名称的setter方法
	 */
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	} 	
	/**
	 * 属性共保份额/共保份额的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	} 	
	/**
	 * 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
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
	/**
	 * 属性首席标志/首席标志的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性首席标志/首席标志的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	} 	
	/**
	 * 属性分摊标志/分摊标志的getter方法
	 */
	public String getProportionFlag() {
		return proportionFlag;
	}
	/**
	 * 属性分摊标志/分摊标志的setter方法
	 */
	public void setProportionFlag(String proportionFlag) {
		this.proportionFlag = proportionFlag;
	} 	
	/**
	 * 属性共保协议号/共保协议号的getter方法
	 */

	/**
	 * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	} 	
	/**
	 * 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务的getter方法
	 */
	public String getCoinsTreatyNo() {
		return coinsTreatyNo;
	}

	public void setCoinsTreatyNo(String coinsTreatyNo) {
		this.coinsTreatyNo = coinsTreatyNo;
	}

	public String getReinsCiFlag() {
		return reinsCiFlag;
	}

	public void setReinsCiFlag(String reinsCiFlag) {
		this.reinsCiFlag = reinsCiFlag;
	}

	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}