package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainSub;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保单隶属表实体操作对象
 */
@Entity
@Table(name = "PrpCmainSub")
@IdClass(PrpCmainSubKey.class)
public class PrpCmainSub extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性主保单号码/主保单号码 */
	@Id
	@Column(name = "mainPolicyNo")
	private String mainPolicyNo ;	


	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性标志字段 /标志字段  */
	@Column(name = "flag")
	private String flag ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性交强险的起始日期/交强险的起始日期 */
	@Column(name = "startDate")
	private Date startDate ;
	/** 属性交强险的终止日期/交强险的终止日期 */
	@Column(name = "endDate")
	private Date endDate ;
	/** 属性balanceTimes/balanceTimes */
	@Column(name = "balanceTimes")
	private Integer balanceTimes ;
	/** 属性batchNo/batchNo */
	@Column(name = "batchNo")
	private String batchNo ;
	/** 属性checkAgentDescription/checkAgentDescription */
	@Column(name = "checkAgentDescription")
	private String checkAgentDescription ;
	/** 属性conditions/conditions */
	@Column(name = "conditions")
	private String conditions ;
	/** 属性groupNo/groupNo */
	@Column(name = "groupNo")
	private String groupNo ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
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
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 	
	/**
	 * 属性标志字段 /标志字段 的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段 /标志字段 的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性交强险的起始日期/交强险的起始日期的getter方法
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性交强险的起始日期/交强险的起始日期的setter方法
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性交强险的终止日期/交强险的终止日期的getter方法
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性交强险的终止日期/交强险的终止日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性balanceTimes/balanceTimes的getter方法
	 */
	public Integer getBalanceTimes() {
		return balanceTimes;
	}
	/**
	 * 属性balanceTimes/balanceTimes的setter方法
	 */
	public void setBalanceTimes(Integer balanceTimes) {
		this.balanceTimes = balanceTimes;
	} 	
	/**
	 * 属性batchNo/batchNo的getter方法
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * 属性batchNo/batchNo的setter方法
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	} 	
	/**
	 * 属性checkAgentDescription/checkAgentDescription的getter方法
	 */
	public String getCheckAgentDescription() {
		return checkAgentDescription;
	}
	/**
	 * 属性checkAgentDescription/checkAgentDescription的setter方法
	 */
	public void setCheckAgentDescription(String checkAgentDescription) {
		this.checkAgentDescription = checkAgentDescription;
	} 	
	/**
	 * 属性conditions/conditions的getter方法
	 */
	public String getConditions() {
		return conditions;
	}
	/**
	 * 属性conditions/conditions的setter方法
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	} 	
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

}