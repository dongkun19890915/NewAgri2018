package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 01:22:46.932 
 * 分户/虚拟分户信息实体操作对象
 */
@Entity
@Table(name = "PrpCvirturlItem")
@IdClass(PrpCvirturlItemKey.class)
public class PrpCvirturlItem extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	@Id
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;/** 属性虚拟分户标志/虚拟分户标志 */
	@Id
	@Column(name = "virturlFlag")
	private String virturlFlag ;/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;	
	/** 属性保单号码/保单号码 */
	@Column(name = "PolicyNo")
	private String policyNo ;
	/** 属性险种代码 /险种代码  */
	@Column(name = "RiskCode")
	private String riskCode ;

	/** 属性团意险存储方案类别/团意险存储方案类别 */
	@Column(name = "RationType")
	private String rationType ;
	/** 属性分户序号/分户序号 */
	@Column(name = "FamilyNo")
	private Integer familyNo ;
	/** 属性分户名称/分户名称 */
	@Column(name = "FamilyName")
	private String familyName ;
	/** 属性分户性别/分户性别 */
	@Column(name = "FamilySex")
	private String familySex ;
	/** 属性分户年龄/分户年龄 */
	@Column(name = "FamilyAge")
	private Integer familyAge ;
	/** 属性分户工种代码/分户工种代码 */
	@Column(name = "FamilyJobCode")
	private String familyJobCode ;
	/** 属性分户工种名称/分户工种名称 */
	@Column(name = "FamilyJobName")
	private String familyJobName ;
	/** 属性分户地址序号/分户地址序号 */
	@Column(name = "AddressNo")
	private Integer addressNo ;
	/** 属性分户地址，门牌号码/分户地址，门牌号码 */
	@Column(name = "Address")
	private String address ;
	/** 属性东/东 */
	@Column(name = "East")
	private String east ;
	/** 属性西/西 */
	@Column(name = "West")
	private String west ;
	/** 属性南/南 */
	@Column(name = "South")
	private String south ;
	/** 属性北/北 */
	@Column(name = "North")
	private String north ;
	/** 属性证件类型/证件类型 */
	@Column(name = "IdentifyType")
	private String identifyType ;
	/** 属性证件号码/证件号码 */
	@Column(name = "IdentifyNumber")
	private String identifyNumber ;
	/** 属性有无社保或公费医疗/有无社保或公费医疗 */
	@Column(name = "SocietyFlag")
	private String societyFlag ;
	/** 属性受益人姓名/受益人姓名 */
	@Column(name = "BenName")
	private String benName ;
	/** 属性受益人性别/受益人性别 */
	@Column(name = "BenSex")
	private String benSex ;
	/** 属性受益人身份证号码/受益人身份证号码 */
	@Column(name = "BenidentifyNumber")
	private String benidentifyNumber ;
	/** 属性险别代码 /险别代码  */
	@Column(name = "KindCode")
	private String kindCode ;
	/** 属性险别名称/险别名称 */
	@Column(name = "KindName")
	private String kindName ;
	/** 属性标的序号/标的序号 */
	@Column(name = "ItemNo")
	private Integer itemNo ;
	/** 属性标的项目类别代码/标的项目类别代码 */
	@Column(name = "ItemCode")
	private String itemCode ;
	/** 属性标的项目明细名称/标的项目明细名称 */
	@Column(name = "ItemdetailName")
	private String itemdetailName ;
	/** 属性币别/币别 */
	@Column(name = "Currency")
	private String currency ;
	/** 属性折扣/投保成数/折扣/投保成数 */
	@Column(name = "Proportion")
	private Double proportion ;
	/** 属性折旧率/树龄(林木险)/折旧率/树龄(林木险) */
	@Column(name = "DepreciationRate")
	private Double depreciationRate ;
	/** 属性单位保险金额/单位保险金额 */
	@Column(name = "UnitAmount")
	private Double unitAmount ;
	/** 属性数量/数量 */
	@Column(name = "Quantity")
	private Double quantity ;
	/** 属性数量单位/数量单位 */
	@Column(name = "Unit")
	private String unit ;
	/** 属性保险金额/保险金额 */
	@Column(name = "Amount")
	private Double amount ;
	/** 属性费率/费率 */
	@Column(name = "Rate")
	private Double rate ;
	/** 属性折扣率/折扣率 */
	@Column(name = "Discount")
	private Double discount ;
	/** 属性保费/保费 */
	@Column(name = "Premium")
	private Double premium ;
	/** 属性备注/备注 */
	@Column(name = "Remark")
	private String remark ;

	/** 属性冲减保额标志/冲减保额标志 */
	@Column(name = "AmountFlag")
	private String amountFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "Flag")
	private String flag ;
	/** 属性房间数目/房间数目 */
	@Column(name = "RoomQuantity")
	private Integer roomQuantity ;

	/** 属性投保人名称/投保人名称 */
	@Column(name = "AppliName")
	private String appliName ;
	/** 属性户序号/户序号 */
	@Column(name = "HouseNumber")
	private Integer houseNumber ;
	/** 属性是否主被保险人/是否主被保险人 */
	@Column(name = "MainInsuredFlag")
	private String mainInsuredFlag ;
	/** 属性车辆厂牌型号/车辆厂牌型号 */
	@Column(name = "BrandCode")
	private String brandCode ;
	/** 属性车辆编号/车辆编号 */
	@Column(name = "CarNumber")
	private String carNumber ;
	/** 属性房屋类型/房屋类型 */
	@Column(name = "HouseType")
	private String houseType ;
	/** 属性风险类型/风险类型 */
	@Column(name = "RiskType")
	private String riskType ;
	/** 属性厨房数量/厨房数量 */
	@Column(name = "KitCount")
	private Integer kitCount ;
	/** 属性客户编码/客户编码 */
	@Column(name = "CustomerSequenceNo")
	private String customerSequenceNo ;
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
	 * 属性险种代码 /险种代码 的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码 /险种代码 的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 	
	/**
	 * 属性团意险存储方案类别/团意险存储方案类别的getter方法
	 */
	public String getRationType() {
		return rationType;
	}
	/**
	 * 属性团意险存储方案类别/团意险存储方案类别的setter方法
	 */
	public void setRationType(String rationType) {
		this.rationType = rationType;
	} 	
	/**
	 * 属性分户序号/分户序号的getter方法
	 */
	public Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性分户序号/分户序号的setter方法
	 */
	public void setFamilyNo(Integer familyNo) {
		this.familyNo = familyNo;
	} 	
	/**
	 * 属性分户名称/分户名称的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性分户名称/分户名称的setter方法
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	} 	
	/**
	 * 属性分户性别/分户性别的getter方法
	 */
	public String getFamilySex() {
		return familySex;
	}
	/**
	 * 属性分户性别/分户性别的setter方法
	 */
	public void setFamilySex(String familySex) {
		this.familySex = familySex;
	} 	
	/**
	 * 属性分户年龄/分户年龄的getter方法
	 */
	public Integer getFamilyAge() {
		return familyAge;
	}
	/**
	 * 属性分户年龄/分户年龄的setter方法
	 */
	public void setFamilyAge(Integer familyAge) {
		this.familyAge = familyAge;
	} 	
	/**
	 * 属性分户工种代码/分户工种代码的getter方法
	 */
	public String getFamilyJobCode() {
		return familyJobCode;
	}
	/**
	 * 属性分户工种代码/分户工种代码的setter方法
	 */
	public void setFamilyJobCode(String familyJobCode) {
		this.familyJobCode = familyJobCode;
	} 	
	/**
	 * 属性分户工种名称/分户工种名称的getter方法
	 */
	public String getFamilyJobName() {
		return familyJobName;
	}
	/**
	 * 属性分户工种名称/分户工种名称的setter方法
	 */
	public void setFamilyJobName(String familyJobName) {
		this.familyJobName = familyJobName;
	} 	
	/**
	 * 属性分户地址序号/分户地址序号的getter方法
	 */
	public Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性分户地址序号/分户地址序号的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	} 	
	/**
	 * 属性分户地址，门牌号码/分户地址，门牌号码的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性分户地址，门牌号码/分户地址，门牌号码的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	} 	
	/**
	 * 属性东/东的getter方法
	 */
	public String getEast() {
		return east;
	}
	/**
	 * 属性东/东的setter方法
	 */
	public void setEast(String east) {
		this.east = east;
	} 	
	/**
	 * 属性西/西的getter方法
	 */
	public String getWest() {
		return west;
	}
	/**
	 * 属性西/西的setter方法
	 */
	public void setWest(String west) {
		this.west = west;
	} 	
	/**
	 * 属性南/南的getter方法
	 */
	public String getSouth() {
		return south;
	}
	/**
	 * 属性南/南的setter方法
	 */
	public void setSouth(String south) {
		this.south = south;
	} 	
	/**
	 * 属性北/北的getter方法
	 */
	public String getNorth() {
		return north;
	}
	/**
	 * 属性北/北的setter方法
	 */
	public void setNorth(String north) {
		this.north = north;
	} 	
	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	} 	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	} 	
	/**
	 * 属性有无社保或公费医疗/有无社保或公费医疗的getter方法
	 */
	public String getSocietyFlag() {
		return societyFlag;
	}
	/**
	 * 属性有无社保或公费医疗/有无社保或公费医疗的setter方法
	 */
	public void setSocietyFlag(String societyFlag) {
		this.societyFlag = societyFlag;
	} 	
	/**
	 * 属性受益人姓名/受益人姓名的getter方法
	 */
	public String getBenName() {
		return benName;
	}
	/**
	 * 属性受益人姓名/受益人姓名的setter方法
	 */
	public void setBenName(String benName) {
		this.benName = benName;
	} 	
	/**
	 * 属性受益人性别/受益人性别的getter方法
	 */
	public String getBenSex() {
		return benSex;
	}
	/**
	 * 属性受益人性别/受益人性别的setter方法
	 */
	public void setBenSex(String benSex) {
		this.benSex = benSex;
	} 	
	/**
	 * 属性受益人身份证号码/受益人身份证号码的getter方法
	 */
	public String getBenidentifyNumber() {
		return benidentifyNumber;
	}
	/**
	 * 属性受益人身份证号码/受益人身份证号码的setter方法
	 */
	public void setBenidentifyNumber(String benidentifyNumber) {
		this.benidentifyNumber = benidentifyNumber;
	} 	
	/**
	 * 属性险别代码 /险别代码 的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码 /险别代码 的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性险别名称/险别名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别名称/险别名称的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	} 	
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	} 	
	/**
	 * 属性标的项目类别代码/标的项目类别代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目类别代码/标的项目类别代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性标的项目明细名称/标的项目明细名称的getter方法
	 */
	public String getItemdetailName() {
		return itemdetailName;
	}
	/**
	 * 属性标的项目明细名称/标的项目明细名称的setter方法
	 */
	public void setItemdetailName(String itemdetailName) {
		this.itemdetailName = itemdetailName;
	} 	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性折扣/投保成数/折扣/投保成数的getter方法
	 */
	public Double getProportion() {
		return proportion;
	}
	/**
	 * 属性折扣/投保成数/折扣/投保成数的setter方法
	 */
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	} 	
	/**
	 * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的getter方法
	 */
	public Double getDepreciationRate() {
		return depreciationRate;
	}
	/**
	 * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的setter方法
	 */
	public void setDepreciationRate(Double depreciationRate) {
		this.depreciationRate = depreciationRate;
	} 	
	/**
	 * 属性单位保险金额/单位保险金额的getter方法
	 */
	public Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性单位保险金额/单位保险金额的setter方法
	 */
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	} 	
	/**
	 * 属性数量/数量的getter方法
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * 属性数量/数量的setter方法
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	} 	
	/**
	 * 属性数量单位/数量单位的getter方法
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 属性数量单位/数量单位的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	} 	
	/**
	 * 属性保险金额/保险金额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性保险金额/保险金额的setter方法
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
	 * 属性折扣率/折扣率的getter方法
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * 属性折扣率/折扣率的setter方法
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	} 	
	/**
	 * 属性保费/保费的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
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
	 * 属性虚拟分户标志/虚拟分户标志的getter方法
	 */
	public String getVirturlFlag() {
		return virturlFlag;
	}
	/**
	 * 属性虚拟分户标志/虚拟分户标志的setter方法
	 */
	public void setVirturlFlag(String virturlFlag) {
		this.virturlFlag = virturlFlag;
	} 	
	/**
	 * 属性冲减保额标志/冲减保额标志的getter方法
	 */
	public String getAmountFlag() {
		return amountFlag;
	}
	/**
	 * 属性冲减保额标志/冲减保额标志的setter方法
	 */
	public void setAmountFlag(String amountFlag) {
		this.amountFlag = amountFlag;
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
	 * 属性房间数目/房间数目的getter方法
	 */
	public Integer getRoomQuantity() {
		return roomQuantity;
	}
	/**
	 * 属性房间数目/房间数目的setter方法
	 */
	public void setRoomQuantity(Integer roomQuantity) {
		this.roomQuantity = roomQuantity;
	} 	
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性投保人名称/投保人名称的getter方法
	 */
	public String getAppliName() {
		return appliName;
	}
	/**
	 * 属性投保人名称/投保人名称的setter方法
	 */
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	} 	
	/**
	 * 属性户序号/户序号的getter方法
	 */
	public Integer getHouseNumber() {
		return houseNumber;
	}
	/**
	 * 属性户序号/户序号的setter方法
	 */
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	} 	
	/**
	 * 属性是否主被保险人/是否主被保险人的getter方法
	 */
	public String getMainInsuredFlag() {
		return mainInsuredFlag;
	}
	/**
	 * 属性是否主被保险人/是否主被保险人的setter方法
	 */
	public void setMainInsuredFlag(String mainInsuredFlag) {
		this.mainInsuredFlag = mainInsuredFlag;
	} 	
	/**
	 * 属性车辆厂牌型号/车辆厂牌型号的getter方法
	 */
	public String getBrandCode() {
		return brandCode;
	}
	/**
	 * 属性车辆厂牌型号/车辆厂牌型号的setter方法
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	} 	
	/**
	 * 属性车辆编号/车辆编号的getter方法
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * 属性车辆编号/车辆编号的setter方法
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	} 	
	/**
	 * 属性房屋类型/房屋类型的getter方法
	 */
	public String getHouseType() {
		return houseType;
	}
	/**
	 * 属性房屋类型/房屋类型的setter方法
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	} 	
	/**
	 * 属性风险类型/风险类型的getter方法
	 */
	public String getRiskType() {
		return riskType;
	}
	/**
	 * 属性风险类型/风险类型的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	} 	
	/**
	 * 属性厨房数量/厨房数量的getter方法
	 */
	public Integer getKitCount() {
		return kitCount;
	}
	/**
	 * 属性厨房数量/厨房数量的setter方法
	 */
	public void setKitCount(Integer kitCount) {
		this.kitCount = kitCount;
	} 	
	/**
	 * 属性客户编码/客户编码的getter方法
	 */
	public String getCustomerSequenceNo() {
		return customerSequenceNo;
	}
	/**
	 * 属性客户编码/客户编码的setter方法
	 */
	public void setCustomerSequenceNo(String customerSequenceNo) {
		this.customerSequenceNo = customerSequenceNo;
	} 	
}