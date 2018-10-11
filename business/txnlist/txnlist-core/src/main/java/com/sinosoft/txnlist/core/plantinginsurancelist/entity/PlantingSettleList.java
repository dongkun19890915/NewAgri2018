package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * plantingsettlelist实体操作对象
 */
@Entity
@Table(name = "plantingSettleList")
@IdClass(PlantingSettleListKey.class)
public class PlantingSettleList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性理赔清单号（KEY）/理赔清单号（KEY） */
	@Id
	@Column(name = "settleListCode")
	private String settleListCode ;/** 属性农户代码（KEY）/农户代码（KEY） */
	@Id
	@Column(name = "fCode")
	private String fCode ;/** 属性险别序号（KEY）/险别序号（KEY） */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性险类/险类 */
	@Id
	@Column(name = "classCode")
	private String classCode ;	




	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性承保面积/承保面积 */
	@Column(name = "insureArea")
	private java.lang.Double insureArea ;
	/** 属性保额/保额 */
	@Column(name = "sumInsured")
	private java.lang.Double sumInsured ;
	/** 属性直补卡/直补卡 */
	@Column(name = "zhiBuKa")
	private String zhiBuKa ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性身份证/身份证 */
	@Column(name = "fIdCard")
	private String fIdCard ;
	/** 属性行政区域/行政区域 */
	@Column(name = "fareaCode")
	private String fareaCode ;
	/** 属性承包清单号/承包清单号 */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性生长期/生长期 */
	@Column(name = "growingSeason")
	private java.lang.Double growingSeason ;
	/** 属性损失率/损失率 */
	@Column(name = "lossRate")
	private java.lang.Double lossRate ;
	/** 属性理赔面积/理赔面积 */
	@Column(name = "settleArea")
	private java.lang.Double settleArea ;
	/** 属性赔偿金额/赔偿金额 */
	@Column(name = "settleSum")
	private java.lang.Double settleSum ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "opCode")
	private String opCode ;
	/** 属性操作时间/操作时间 */
	@Column(name = "opTime")
	private java.util.Date opTime ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功/有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功 */
	@Column(name = "validity")
	private String validity ;
	/** 属性打卡成功时间/打卡成功时间 */
	@Column(name = "settleDate")
	private java.util.Date settleDate ;
	/** 属性赔付比例/赔付比例 */
	@Column(name = "claimRate")
	private java.lang.Double claimRate ;
	/** 属性节点类型/节点类型 */
	@Column(name = "nodeType")
	private String nodeType ;
	/** 属性indexOfSettle/indexOfSettle */
	@Column(name = "indexOfSettle")
	private java.lang.Integer indexOfSettle ;
	/** 属性联系电话/联系电话 */
	@Column(name = "phone")
	private String phone ;
	/** 属性开户银行/开户银行 */
	@Column(name = "bank")
	private String bank ;
	/** 属性fieldSource/fieldSource */
	@Column(name = "fieldSource")
	private String fieldSource ;
	/** 属性修改后的农户代码，用于打卡发放/修改后的农户代码，用于打卡发放 */
	@Column(name = "fcoDemodify")
	private String fcoDemodify ;
	/** 属性林权证号/林权证号 */
	@Column(name = "warrant")
	private String warrant ;
	/** 属性自定义种植面积/自定义种植面积 */
	@Column(name = "taxArea")
	private java.lang.Double taxArea ;
	/** 属性littleAreaName/littleAreaName */
	@Column(name = "littleAreaName")
	private String littleAreaName ;
	/** 属性atArea/atArea */
	@Column(name = "atArea")
	private String atArea ;
	/** 属性实有林地/实有林地 */
	@Column(name = "woodLandArea")
	private java.lang.Double woodLandArea ;
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的getter方法
	 */
	public String getSettleListCode() {
		return settleListCode;
	}
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的setter方法
	 */
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	} 	
	/**
	 * 属性农户代码（KEY）/农户代码（KEY）的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码（KEY）/农户代码（KEY）的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 	
	/**
	 * 属性险别序号（KEY）/险别序号（KEY）的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号（KEY）/险别序号（KEY）的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性承保面积/承保面积的getter方法
	 */
	public java.lang.Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性承保面积/承保面积的setter方法
	 */
	public void setInsureArea(java.lang.Double insureArea) {
		this.insureArea = insureArea;
	} 	
	/**
	 * 属性保额/保额的getter方法
	 */
	public java.lang.Double getSumInsured() {
		return sumInsured;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setSumInsured(java.lang.Double sumInsured) {
		this.sumInsured = sumInsured;
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
	 * 属性身份证/身份证的getter方法
	 */
	public String getFIdCard() {
		return fIdCard;
	}
	/**
	 * 属性身份证/身份证的setter方法
	 */
	public void setFIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	} 	
	/**
	 * 属性行政区域/行政区域的getter方法
	 */
	public String getFareaCode() {
		return fareaCode;
	}
	/**
	 * 属性行政区域/行政区域的setter方法
	 */
	public void setFareaCode(String fareaCode) {
		this.fareaCode = fareaCode;
	} 	
	/**
	 * 属性承包清单号/承包清单号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性承包清单号/承包清单号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 	
	/**
	 * 属性生长期/生长期的getter方法
	 */
	public java.lang.Double getGrowingSeason() {
		return growingSeason;
	}
	/**
	 * 属性生长期/生长期的setter方法
	 */
	public void setGrowingSeason(java.lang.Double growingSeason) {
		this.growingSeason = growingSeason;
	} 	
	/**
	 * 属性损失率/损失率的getter方法
	 */
	public java.lang.Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失率/损失率的setter方法
	 */
	public void setLossRate(java.lang.Double lossRate) {
		this.lossRate = lossRate;
	} 	
	/**
	 * 属性理赔面积/理赔面积的getter方法
	 */
	public java.lang.Double getSettleArea() {
		return settleArea;
	}
	/**
	 * 属性理赔面积/理赔面积的setter方法
	 */
	public void setSettleArea(java.lang.Double settleArea) {
		this.settleArea = settleArea;
	} 	
	/**
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Double getSettleSum() {
		return settleSum;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSettleSum(java.lang.Double settleSum) {
		this.settleSum = settleSum;
	} 	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	} 	
	/**
	 * 属性操作时间/操作时间的getter方法
	 */
	public java.util.Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOpTime(java.util.Date opTime) {
		this.opTime = opTime;
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
	 * 属性有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功/有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功/有效标志位：0：无效；2：暂存；1：已提交；9：打卡成功的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	} 	
	/**
	 * 属性打卡成功时间/打卡成功时间的getter方法
	 */
	public java.util.Date getSettleDate() {
		return settleDate;
	}
	/**
	 * 属性打卡成功时间/打卡成功时间的setter方法
	 */
	public void setSettleDate(java.util.Date settleDate) {
		this.settleDate = settleDate;
	} 	
	/**
	 * 属性赔付比例/赔付比例的getter方法
	 */
	public java.lang.Double getClaimRate() {
		return claimRate;
	}
	/**
	 * 属性赔付比例/赔付比例的setter方法
	 */
	public void setClaimRate(java.lang.Double claimRate) {
		this.claimRate = claimRate;
	} 	
	/**
	 * 属性节点类型/节点类型的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点类型/节点类型的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性indexOfSettle/indexOfSettle的getter方法
	 */
	public java.lang.Integer getIndexOfSettle() {
		return indexOfSettle;
	}
	/**
	 * 属性indexOfSettle/indexOfSettle的setter方法
	 */
	public void setIndexOfSettle(java.lang.Integer indexOfSettle) {
		this.indexOfSettle = indexOfSettle;
	} 	
	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	} 	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 	
	/**
	 * 属性fieldSource/fieldSource的getter方法
	 */
	public String getFieldSource() {
		return fieldSource;
	}
	/**
	 * 属性fieldSource/fieldSource的setter方法
	 */
	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
	} 	
	/**
	 * 属性修改后的农户代码，用于打卡发放/修改后的农户代码，用于打卡发放的getter方法
	 */
	public String getFcoDemodify() {
		return fcoDemodify;
	}
	/**
	 * 属性修改后的农户代码，用于打卡发放/修改后的农户代码，用于打卡发放的setter方法
	 */
	public void setFcoDemodify(String fcoDemodify) {
		this.fcoDemodify = fcoDemodify;
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
	 * 属性自定义种植面积/自定义种植面积的getter方法
	 */
	public java.lang.Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性自定义种植面积/自定义种植面积的setter方法
	 */
	public void setTaxArea(java.lang.Double taxArea) {
		this.taxArea = taxArea;
	} 	
	/**
	 * 属性littleAreaName/littleAreaName的getter方法
	 */
	public String getLittleAreaName() {
		return littleAreaName;
	}
	/**
	 * 属性littleAreaName/littleAreaName的setter方法
	 */
	public void setLittleAreaName(String littleAreaName) {
		this.littleAreaName = littleAreaName;
	} 	
	/**
	 * 属性atArea/atArea的getter方法
	 */
	public String getAtArea() {
		return atArea;
	}
	/**
	 * 属性atArea/atArea的setter方法
	 */
	public void setAtArea(String atArea) {
		this.atArea = atArea;
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