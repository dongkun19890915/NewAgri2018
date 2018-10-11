package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
*清单批改持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:29
*/
@Entity
@Table(name = "plantingCpEndorChgDetail")
@IdClass(PlantingCpEndorChgDetailKey.class)
public class PlantingCpEndorChgDetail extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保清单编号（key）/投保清单编号（key） */
	@Id
	@Column(name = "inusreListCode")
	private String inusreListCode ;/** 属性农户代码（key）/农户代码（key） */
	@Id
	@Column(name = "fCode")
	private String fCode ;/** 属性险别序号（key）/险别序号（key） */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性排序序号/排序序号 */
	@Id
	@Column(name = "indexCode")
	private String indexCode ;	




	/** 属性联系电话号码/联系电话号码 */
	@Column(name = "phone")
	private String phone ;
	/** 属性开户银行/开户银行 */
	@Column(name = "bank")
	private String bank ;
	/** 属性直补卡号/银行卡号/直补卡号/银行卡号 */
	@Column(name = "zhiBuKa")
	private String zhiBuKa ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性农户身份证/农户身份证 */
	@Column(name = "fIdCard")
	private String fIdCard;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性种植区域代码/种植区域代码 */
	@Column(name = "fAreaCode")
	private String fAreaCode ;
	/** 属性自定义种植面积/自定义种植面积 */
	@Column(name = "taxArea")
	private Double taxArea ;
	/** 属性投保面积/投保面积 */
	@Column(name = "insureArea")
	private Double insureArea ;
	/** 属性单位保额/单位保额 */
	@Column(name = "amount")
	private Double amount ;
	/** 属性费率/费率 */
	@Column(name = "rate")
	private Double rate ;
	/** 属性短期费率方式/短期费率方式 */
	@Column(name = "shortRateFlag")
	private String shortRateFlag ;
	/** 属性短期费率/短期费率 */
	@Column(name = "shortRate")
	private Double shortRate ;
	/** 属性总保额/总保额 */
	@Column(name = "sumAmount")
	private Double sumAmount ;
	/** 属性总保费/总保费 */
	@Column(name = "sumPremium")
	private Double sumPremium ;
	/** 属性保险起期/保险起期 */
	@Column(name = "startDate")
	private Date startDate ;
	/** 属性保险止期/保险止期 */
	@Column(name = "endDate")
	private Date endDate ;
	/** 属性主险标志（Y是、N否）/主险标志（Y是、N否） */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "opCode")
	private String opCode ;
	/** 属性操作时间/操作时间 */
	@Column(name = "opTime")
	private Date opTime ;
	/** 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交 */
	@Column(name = "validity")
	private String validity ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性中央财政补贴/中央财政补贴 */
	@Column(name = "centralPremium")
	private Double centralPremium ;
	/** 属性省级财政补贴/省级财政补贴 */
	@Column(name = "provincePremium")
	private Double provincePremium ;
	/** 属性地市财政补贴/地市财政补贴 */
	@Column(name = "cityPremium")
	private Double cityPremium ;
	/** 属性县(区)财政补贴/县(区)财政补贴 */
	@Column(name = "townPremium")
	private Double townPremium ;
	/** 属性其他来源补贴/其他来源补贴 */
	@Column(name = "otherPremium")
	private Double otherPremium ;
	/** 属性农民自缴保费/农民自缴保费 */
	@Column(name = "fPremium")
	private Double fPremium ;
	/** 属性组别/组别 */
	@Column(name = "teamName")
	private String teamName ;
	/** 属性土地来源/土地来源 */
	@Column(name = "fieldSource")
	private String fieldSource ;
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
	private Double woodLandArea ;
	/** 标的代码 */
	@Column(name = "itemCode")
	private String itemCode;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 	
	/**
	 * 属性农户代码（key）/农户代码（key）的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码（key）/农户代码（key）的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 	
	/**
	 * 属性险别序号（key）/险别序号（key）的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号（key）/险别序号（key）的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性排序序号/排序序号的getter方法
	 */
	public String getIndexCode() {
		return indexCode;
	}
	/**
	 * 属性排序序号/排序序号的setter方法
	 */
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	} 	
	/**
	 * 属性联系电话号码/联系电话号码的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性联系电话号码/联系电话号码的setter方法
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
	 * 属性直补卡号/银行卡号/直补卡号/银行卡号的getter方法
	 */
	public String getZhiBuKa() {
		return zhiBuKa;
	}
	/**
	 * 属性直补卡号/银行卡号/直补卡号/银行卡号的setter方法
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
	 * 属性农户身份证/农户身份证的getter方法
	 */
	public String getFIdCcard() {
		return fIdCard;
	}
	/**
	 * 属性农户身份证/农户身份证的setter方法
	 */
	public void setFIdCcard(String fIdCcard) {
		this.fIdCard = fIdCcard;
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
	 * 属性种植区域代码/种植区域代码的getter方法
	 */
	public String getFAreaCode() {
		return fAreaCode;
	}
	/**
	 * 属性种植区域代码/种植区域代码的setter方法
	 */
	public void setFAreaCode(String fAreaCode) {
		this.fAreaCode = fAreaCode;
	} 	
	/**
	 * 属性自定义种植面积/自定义种植面积的getter方法
	 */
	public Double getTaxArea() {
		return taxArea;
	}
	/**
	 * 属性自定义种植面积/自定义种植面积的setter方法
	 */
	public void setTaxArea(Double taxArea) {
		this.taxArea = taxArea;
	} 	
	/**
	 * 属性投保面积/投保面积的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性投保面积/投保面积的setter方法
	 */
	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	} 	
	/**
	 * 属性单位保额/单位保额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性单位保额/单位保额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	} 	
	/**
	 * 属性费率/费率的getter方法
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * 属性费率/费率的setter方法
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	} 	
	/**
	 * 属性短期费率方式/短期费率方式的getter方法
	 */
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	/**
	 * 属性短期费率方式/短期费率方式的setter方法
	 */
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	} 	
	/**
	 * 属性短期费率/短期费率的getter方法
	 */
	public Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性短期费率/短期费率的setter方法
	 */
	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	} 	
	/**
	 * 属性总保额/总保额的getter方法
	 */
	public Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保额/总保额的setter方法
	 */
	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	} 	
	/**
	 * 属性总保费/总保费的getter方法
	 */
	public Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总保费/总保费的setter方法
	 */
	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	} 	
	/**
	 * 属性保险起期/保险起期的getter方法
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性保险起期/保险起期的setter方法
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性保险止期/保险止期的getter方法
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性保险止期/保险止期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性主险标志（Y是、N否）/主险标志（Y是、N否）的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性主险标志（Y是、N否）/主险标志（Y是、N否）的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
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
	public Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	} 	
	/**
	 * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
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
	 * 属性中央财政补贴/中央财政补贴的getter方法
	 */
	public Double getCentralPremium() {
		return centralPremium;
	}
	/**
	 * 属性中央财政补贴/中央财政补贴的setter方法
	 */
	public void setCentralPremium(Double centralPremium) {
		this.centralPremium = centralPremium;
	} 	
	/**
	 * 属性省级财政补贴/省级财政补贴的getter方法
	 */
	public Double getProvincePremium() {
		return provincePremium;
	}
	/**
	 * 属性省级财政补贴/省级财政补贴的setter方法
	 */
	public void setProvincePremium(Double provincePremium) {
		this.provincePremium = provincePremium;
	} 	
	/**
	 * 属性地市财政补贴/地市财政补贴的getter方法
	 */
	public Double getCityPremium() {
		return cityPremium;
	}
	/**
	 * 属性地市财政补贴/地市财政补贴的setter方法
	 */
	public void setCityPremium(Double cityPremium) {
		this.cityPremium = cityPremium;
	} 	
	/**
	 * 属性县(区)财政补贴/县(区)财政补贴的getter方法
	 */
	public Double getTownPremium() {
		return townPremium;
	}
	/**
	 * 属性县(区)财政补贴/县(区)财政补贴的setter方法
	 */
	public void setTownPremium(Double townPremium) {
		this.townPremium = townPremium;
	} 	
	/**
	 * 属性其他来源补贴/其他来源补贴的getter方法
	 */
	public Double getOtherPremium() {
		return otherPremium;
	}
	/**
	 * 属性其他来源补贴/其他来源补贴的setter方法
	 */
	public void setOtherPremium(Double otherPremium) {
		this.otherPremium = otherPremium;
	} 	
	/**
	 * 属性农民自缴保费/农民自缴保费的getter方法
	 */
	public Double getFPremium() {
		return fPremium;
	}
	/**
	 * 属性农民自缴保费/农民自缴保费的setter方法
	 */
	public void setFPremium(Double fPremium) {
		this.fPremium = fPremium;
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
	public Double getWoodLandArea() {
		return woodLandArea;
	}
	/**
	 * 属性实有林地/实有林地的setter方法
	 */
	public void setWoodLandArea(Double woodLandArea) {
		this.woodLandArea = woodLandArea;
	} 	
}