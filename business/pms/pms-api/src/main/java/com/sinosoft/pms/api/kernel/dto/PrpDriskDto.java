package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 险种代码表Api操作对象
 */
public class PrpDriskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性险种中文名称/险种中文名称 */
	private String riskCName ;		
	/** 属性险种英文名称/险种英文名称 */
	private String riskEName ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性权限组号代码/权限组号代码 */
	private String groupCode ;		
	/** 属性计算保费方式 100 :按百分之计算 1000:按千分之计算/计算保费方式 100 :按百分之计算 1000:按千分之计算 */
	private java.lang.Integer calculator ;		
	/** 属性endDateFlag/endDateFlag */
	private String endDateFlag ;		
	/** 属性险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工/险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工 */
	private String riskFlag ;		
	/** 属性起保小时/起保小时 */
	private java.lang.Integer startHour ;		
	/** 属性新的险种代码/新的险种代码 */
	private String newRiskCode ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	private String articleCode ;		
	/** 属性收付费处理标志/收付费处理标志 */
	private String manageFlag ;		
	/** 属性settleType/settleType */
	private String settleType ;		
	/** 属性标志字段 [2] 1 通用险种/标志字段 [2] 1 通用险种 */
	private String flag ;		
	/** 属性长短期标志：0短期 1长期 健康险统计专用 /长短期标志：0短期 1长期 健康险统计专用  */
	private String periodType ;		
	/** 属性个人/团体标志：0个人 1团体 健康险统计专用/个人/团体标志：0个人 1团体 健康险统计专用 */
	private String massFlag ;		
	/** 属性保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用/保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用 */
	private String dutyFlag ;		
	/** 属性reinsinFlag/reinsinFlag */
	private String reinsinFlag ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性财务核算层级/财务核算层级 */
	private String accountLevel ;		
	/** 属性涉农标志/涉农标志 */
	private String agricultureFlag ;		
	/** 属性审核标志/审核标志 */
	private String auditFlag ;		
	/** 属性自动送收付费/自动送收付费 */
	private String autoPaymentFlag ;		
	/** 属性险种分类标志/险种分类标志 */
	private String classFlag ;		
	/** 属性创建时间/创建时间 */
	private java.util.Date createTime ;		
	/** 属性创建人/创建人 */
	private String creatorCode ;		
	/** 属性配置修改人/配置修改人 */
	private String endUpdaterCode ;		
	/** 属性框架代码/框架代码 */
	private String frameCode ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性强制保险标志/强制保险标志 */
	private String isForce ;		
	/** 属性管理核算层级/管理核算层级 */
	private String managementLevel ;		
	/** 属性资料内容/资料内容 */
	private String materialContxt ;		
	/** 属性旧产品代码/旧产品代码 */
	private String oldRiskCode ;		
	/** 属性更新时间/更新时间 */
	private java.util.Date operateTimeForHis ;		
	/** 属性是否存在方案/是否存在方案 */
	private String planind ;		
	/** 属性政策商业性标志/政策商业性标志 */
	private String policyFlag ;		
	/** 属性出单政策性业务处理标志/出单政策性业务处理标志 */
	private String policyProcessFlag ;		
	/** 属性保单属性/保单属性 */
	private String policyType ;		
	/** 属性归属项目/归属项目 */
	private String projectCode ;		
	/** 属性费率单位/费率单位 */
	private java.lang.Integer rateUnit ;		
	/** 属性再保核算层级/再保核算层级 */
	private String reinsLevel ;		
	/** 属性报备报批号/报备报批号 */
	private String reportNo ;		
	/** 属性出单是否必选方案/出单是否必选方案 */
	private String requiredFlag ;		
	/** 属性产品属性/产品属性 */
	private String riskAttribute ;		
	/** 属性产品中文简称/产品中文简称 */
	private String riskSCName ;		
	/** 属性产品英文简称/产品英文简称 */
	private String riskSEName ;		
	/** 属性产品繁体中文名称（预留）/产品繁体中文名称（预留） */
	private String riskTName ;		
	/** 属性销售区域代码(用逗号分隔)/销售区域代码(用逗号分隔) */
	private String saleAreaCode ;		
	/** 属性销售区域层级/销售区域层级 */
	private String saleAreaLevel ;		
	/** 属性销售区域名/销售区域名 */
	private String saleAreaName ;		
	/** 属性按什么取短期费率标志/按什么取短期费率标志 */
	private String shortRateFlag ;		
	/** 属性统计核算层级/统计核算层级 */
	private String statLevel ;		
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;		
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;		
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;		
	/** 属性最后修改人/最后修改人 */
	private String updaterCode ;		
	/** 属性最后修改时间 /最后修改时间  */
	private java.util.Date updateTime ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性有效标志/有效标志 */
	private String validind ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性险种中文名称/险种中文名称的getter方法
	 */
	public String getRiskCName() {
		return riskCName;
	}
	/**
	 * 属性险种中文名称/险种中文名称的setter方法
	 */
	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	}	
	/**
	 * 属性险种英文名称/险种英文名称的getter方法
	 */
	public String getRiskEName() {
		return riskEName;
	}
	/**
	 * 属性险种英文名称/险种英文名称的setter方法
	 */
	public void setRiskEName(String riskEName) {
		this.riskEName = riskEName;
	}	
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性权限组号代码/权限组号代码的getter方法
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * 属性权限组号代码/权限组号代码的setter方法
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}	
	/**
	 * 属性计算保费方式 100 :按百分之计算 1000:按千分之计算/计算保费方式 100 :按百分之计算 1000:按千分之计算的getter方法
	 */
	public java.lang.Integer getCalculator() {
		return calculator;
	}
	/**
	 * 属性计算保费方式 100 :按百分之计算 1000:按千分之计算/计算保费方式 100 :按百分之计算 1000:按千分之计算的setter方法
	 */
	public void setCalculator(java.lang.Integer calculator) {
		this.calculator = calculator;
	}	
	/**
	 * 属性endDateFlag/endDateFlag的getter方法
	 */
	public String getEndDateFlag() {
		return endDateFlag;
	}
	/**
	 * 属性endDateFlag/endDateFlag的setter方法
	 */
	public void setEndDateFlag(String endDateFlag) {
		this.endDateFlag = endDateFlag;
	}	
	/**
	 * 属性险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工/险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工的getter方法
	 */
	public String getRiskFlag() {
		return riskFlag;
	}
	/**
	 * 属性险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工/险种标志 [1]:1保费/2储金 [2]:1非定额 2定额 3定限额  [3]1允许补输/不允许 [4]:1正常保费计算公式/2其他 [5]1有续保/2无续保 [6]1无误差校验/2有误差检验  [7]1投资型险种 [8]1使用单证接口 [9]是否自动送收付费系统 1:自动 [10]收付费分摊标志 1:不分摊到险别 2:分摊到险别  [11]1有短期不查表 2有短期需查表 3无短期需查表 4无短期需手工的setter方法
	 */
	public void setRiskFlag(String riskFlag) {
		this.riskFlag = riskFlag;
	}	
	/**
	 * 属性起保小时/起保小时的getter方法
	 */
	public java.lang.Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(java.lang.Integer startHour) {
		this.startHour = startHour;
	}	
	/**
	 * 属性新的险种代码/新的险种代码的getter方法
	 */
	public String getNewRiskCode() {
		return newRiskCode;
	}
	/**
	 * 属性新的险种代码/新的险种代码的setter方法
	 */
	public void setNewRiskCode(String newRiskCode) {
		this.newRiskCode = newRiskCode;
	}	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的getter方法
	 */
	public String getArticleCode() {
		return articleCode;
	}
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}	
	/**
	 * 属性收付费处理标志/收付费处理标志的getter方法
	 */
	public String getManageFlag() {
		return manageFlag;
	}
	/**
	 * 属性收付费处理标志/收付费处理标志的setter方法
	 */
	public void setManageFlag(String manageFlag) {
		this.manageFlag = manageFlag;
	}	
	/**
	 * 属性settleType/settleType的getter方法
	 */
	public String getSettleType() {
		return settleType;
	}
	/**
	 * 属性settleType/settleType的setter方法
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}	
	/**
	 * 属性标志字段 [2] 1 通用险种/标志字段 [2] 1 通用险种的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段 [2] 1 通用险种/标志字段 [2] 1 通用险种的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性长短期标志：0短期 1长期 健康险统计专用 /长短期标志：0短期 1长期 健康险统计专用 的getter方法
	 */
	public String getPeriodType() {
		return periodType;
	}
	/**
	 * 属性长短期标志：0短期 1长期 健康险统计专用 /长短期标志：0短期 1长期 健康险统计专用 的setter方法
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}	
	/**
	 * 属性个人/团体标志：0个人 1团体 健康险统计专用/个人/团体标志：0个人 1团体 健康险统计专用的getter方法
	 */
	public String getMassFlag() {
		return massFlag;
	}
	/**
	 * 属性个人/团体标志：0个人 1团体 健康险统计专用/个人/团体标志：0个人 1团体 健康险统计专用的setter方法
	 */
	public void setMassFlag(String massFlag) {
		this.massFlag = massFlag;
	}	
	/**
	 * 属性保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用/保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用的getter方法
	 */
	public String getDutyFlag() {
		return dutyFlag;
	}
	/**
	 * 属性保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用/保险责任：0疾病 1重大疾病 2医疗保险 3费用补偿型医疗 4定额给付型医疗 5失能收入损失 6护理 健康险统计专用的setter方法
	 */
	public void setDutyFlag(String dutyFlag) {
		this.dutyFlag = dutyFlag;
	}	
	/**
	 * 属性reinsinFlag/reinsinFlag的getter方法
	 */
	public String getReinsinFlag() {
		return reinsinFlag;
	}
	/**
	 * 属性reinsinFlag/reinsinFlag的setter方法
	 */
	public void setReinsinFlag(String reinsinFlag) {
		this.reinsinFlag = reinsinFlag;
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
	 * 属性财务核算层级/财务核算层级的getter方法
	 */
	public String getAccountLevel() {
		return accountLevel;
	}
	/**
	 * 属性财务核算层级/财务核算层级的setter方法
	 */
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}	
	/**
	 * 属性涉农标志/涉农标志的getter方法
	 */
	public String getAgricultureFlag() {
		return agricultureFlag;
	}
	/**
	 * 属性涉农标志/涉农标志的setter方法
	 */
	public void setAgricultureFlag(String agricultureFlag) {
		this.agricultureFlag = agricultureFlag;
	}	
	/**
	 * 属性审核标志/审核标志的getter方法
	 */
	public String getAuditFlag() {
		return auditFlag;
	}
	/**
	 * 属性审核标志/审核标志的setter方法
	 */
	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}	
	/**
	 * 属性自动送收付费/自动送收付费的getter方法
	 */
	public String getAutoPaymentFlag() {
		return autoPaymentFlag;
	}
	/**
	 * 属性自动送收付费/自动送收付费的setter方法
	 */
	public void setAutoPaymentFlag(String autoPaymentFlag) {
		this.autoPaymentFlag = autoPaymentFlag;
	}	
	/**
	 * 属性险种分类标志/险种分类标志的getter方法
	 */
	public String getClassFlag() {
		return classFlag;
	}
	/**
	 * 属性险种分类标志/险种分类标志的setter方法
	 */
	public void setClassFlag(String classFlag) {
		this.classFlag = classFlag;
	}	
	/**
	 * 属性创建时间/创建时间的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性创建时间/创建时间的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}	
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}	
	/**
	 * 属性配置修改人/配置修改人的getter方法
	 */
	public String getEndUpdaterCode() {
		return endUpdaterCode;
	}
	/**
	 * 属性配置修改人/配置修改人的setter方法
	 */
	public void setEndUpdaterCode(String endUpdaterCode) {
		this.endUpdaterCode = endUpdaterCode;
	}	
	/**
	 * 属性框架代码/框架代码的getter方法
	 */
	public String getFrameCode() {
		return frameCode;
	}
	/**
	 * 属性框架代码/框架代码的setter方法
	 */
	public void setFrameCode(String frameCode) {
		this.frameCode = frameCode;
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
	 * 属性强制保险标志/强制保险标志的getter方法
	 */
	public String getIsForce() {
		return isForce;
	}
	/**
	 * 属性强制保险标志/强制保险标志的setter方法
	 */
	public void setIsForce(String isForce) {
		this.isForce = isForce;
	}	
	/**
	 * 属性管理核算层级/管理核算层级的getter方法
	 */
	public String getManagementLevel() {
		return managementLevel;
	}
	/**
	 * 属性管理核算层级/管理核算层级的setter方法
	 */
	public void setManagementLevel(String managementLevel) {
		this.managementLevel = managementLevel;
	}	
	/**
	 * 属性资料内容/资料内容的getter方法
	 */
	public String getMaterialContxt() {
		return materialContxt;
	}
	/**
	 * 属性资料内容/资料内容的setter方法
	 */
	public void setMaterialContxt(String materialContxt) {
		this.materialContxt = materialContxt;
	}	
	/**
	 * 属性旧产品代码/旧产品代码的getter方法
	 */
	public String getOldRiskCode() {
		return oldRiskCode;
	}
	/**
	 * 属性旧产品代码/旧产品代码的setter方法
	 */
	public void setOldRiskCode(String oldRiskCode) {
		this.oldRiskCode = oldRiskCode;
	}	
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getOperateTimeForHis() {
		return operateTimeForHis;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setOperateTimeForHis(java.util.Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	}	
	/**
	 * 属性是否存在方案/是否存在方案的getter方法
	 */
	public String getPlanind() {
		return planind;
	}
	/**
	 * 属性是否存在方案/是否存在方案的setter方法
	 */
	public void setPlanind(String planind) {
		this.planind = planind;
	}	
	/**
	 * 属性政策商业性标志/政策商业性标志的getter方法
	 */
	public String getPolicyFlag() {
		return policyFlag;
	}
	/**
	 * 属性政策商业性标志/政策商业性标志的setter方法
	 */
	public void setPolicyFlag(String policyFlag) {
		this.policyFlag = policyFlag;
	}	
	/**
	 * 属性出单政策性业务处理标志/出单政策性业务处理标志的getter方法
	 */
	public String getPolicyProcessFlag() {
		return policyProcessFlag;
	}
	/**
	 * 属性出单政策性业务处理标志/出单政策性业务处理标志的setter方法
	 */
	public void setPolicyProcessFlag(String policyProcessFlag) {
		this.policyProcessFlag = policyProcessFlag;
	}	
	/**
	 * 属性保单属性/保单属性的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单属性/保单属性的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}	
	/**
	 * 属性归属项目/归属项目的getter方法
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * 属性归属项目/归属项目的setter方法
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}	
	/**
	 * 属性费率单位/费率单位的getter方法
	 */
	public java.lang.Integer getRateUnit() {
		return rateUnit;
	}
	/**
	 * 属性费率单位/费率单位的setter方法
	 */
	public void setRateUnit(java.lang.Integer rateUnit) {
		this.rateUnit = rateUnit;
	}	
	/**
	 * 属性再保核算层级/再保核算层级的getter方法
	 */
	public String getReinsLevel() {
		return reinsLevel;
	}
	/**
	 * 属性再保核算层级/再保核算层级的setter方法
	 */
	public void setReinsLevel(String reinsLevel) {
		this.reinsLevel = reinsLevel;
	}	
	/**
	 * 属性报备报批号/报备报批号的getter方法
	 */
	public String getReportNo() {
		return reportNo;
	}
	/**
	 * 属性报备报批号/报备报批号的setter方法
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}	
	/**
	 * 属性出单是否必选方案/出单是否必选方案的getter方法
	 */
	public String getRequiredFlag() {
		return requiredFlag;
	}
	/**
	 * 属性出单是否必选方案/出单是否必选方案的setter方法
	 */
	public void setRequiredFlag(String requiredFlag) {
		this.requiredFlag = requiredFlag;
	}	
	/**
	 * 属性产品属性/产品属性的getter方法
	 */
	public String getRiskAttribute() {
		return riskAttribute;
	}
	/**
	 * 属性产品属性/产品属性的setter方法
	 */
	public void setRiskAttribute(String riskAttribute) {
		this.riskAttribute = riskAttribute;
	}	
	/**
	 * 属性产品中文简称/产品中文简称的getter方法
	 */
	public String getRiskSCName() {
		return riskSCName;
	}
	/**
	 * 属性产品中文简称/产品中文简称的setter方法
	 */
	public void setRiskSCName(String riskSCName) {
		this.riskSCName = riskSCName;
	}	
	/**
	 * 属性产品英文简称/产品英文简称的getter方法
	 */
	public String getRiskSEName() {
		return riskSEName;
	}
	/**
	 * 属性产品英文简称/产品英文简称的setter方法
	 */
	public void setRiskSEName(String riskSEName) {
		this.riskSEName = riskSEName;
	}	
	/**
	 * 属性产品繁体中文名称（预留）/产品繁体中文名称（预留）的getter方法
	 */
	public String getRiskTName() {
		return riskTName;
	}
	/**
	 * 属性产品繁体中文名称（预留）/产品繁体中文名称（预留）的setter方法
	 */
	public void setRiskTName(String riskTName) {
		this.riskTName = riskTName;
	}	
	/**
	 * 属性销售区域代码(用逗号分隔)/销售区域代码(用逗号分隔)的getter方法
	 */
	public String getSaleAreaCode() {
		return saleAreaCode;
	}
	/**
	 * 属性销售区域代码(用逗号分隔)/销售区域代码(用逗号分隔)的setter方法
	 */
	public void setSaleAreaCode(String saleAreaCode) {
		this.saleAreaCode = saleAreaCode;
	}	
	/**
	 * 属性销售区域层级/销售区域层级的getter方法
	 */
	public String getSaleAreaLevel() {
		return saleAreaLevel;
	}
	/**
	 * 属性销售区域层级/销售区域层级的setter方法
	 */
	public void setSaleAreaLevel(String saleAreaLevel) {
		this.saleAreaLevel = saleAreaLevel;
	}	
	/**
	 * 属性销售区域名/销售区域名的getter方法
	 */
	public String getSaleAreaName() {
		return saleAreaName;
	}
	/**
	 * 属性销售区域名/销售区域名的setter方法
	 */
	public void setSaleAreaName(String saleAreaName) {
		this.saleAreaName = saleAreaName;
	}	
	/**
	 * 属性按什么取短期费率标志/按什么取短期费率标志的getter方法
	 */
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	/**
	 * 属性按什么取短期费率标志/按什么取短期费率标志的setter方法
	 */
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	}	
	/**
	 * 属性统计核算层级/统计核算层级的getter方法
	 */
	public String getStatLevel() {
		return statLevel;
	}
	/**
	 * 属性统计核算层级/统计核算层级的setter方法
	 */
	public void setStatLevel(String statLevel) {
		this.statLevel = statLevel;
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
	 * 属性最后修改人/最后修改人的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最后修改人/最后修改人的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}	
	/**
	 * 属性最后修改时间 /最后修改时间 的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性最后修改时间 /最后修改时间 的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
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
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidind() {
		return validind;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidind(String validind) {
		this.validind = validind;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}
