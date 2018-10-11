package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:27:57.599 
 * 自动生成特约主表Api操作对象
 */
public class AutoClauseRequestDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性机构代码/机构代码 */
	private List comCode ;
	/** 属性险种代码/险种代码 */
	private List riskCode ;
	/** 属性特约代码/特约代码 */
	private String clauseCode ;
	/** 属性特约名称/特约名称 */
	private String clauseName ;
	/** 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。 */
	private String clauseText ;
	/** 属性有效性标识/有效性标识：
1 有效
0 无效 */
	private String validStatus ;
	/** 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型 */
	private String othFlag ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性适用系统/适用系统 */
	private List policySort ;
	//特约类型
	private String clauseType ;
	//是否允许手工删除
	private String delText ;
	//保存标志 I-新增保存，U-修改保存
	private String saveType ;
	List<AutoClauseModuleDto> autoClauseModuleDtos;
	List<AutoClauseTextModuleDto> autoClauseTextModuleDtos;

	public List getComCode() {
		return comCode;
	}

	public void setComCode(List comCode) {
		this.comCode = comCode;
	}

	public List getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(List riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性特约代码/特约代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性特约代码/特约代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}
	/**
	 * 属性特约名称/特约名称的getter方法
	 */
	public String getClauseName() {
		return clauseName;
	}
	/**
	 * 属性特约名称/特约名称的setter方法
	 */
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	}
	/**
	 * 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。的getter方法
	 */
	public String getClauseText() {
		return clauseText;
	}
	/**
	 * 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。的setter方法
	 */
	public void setClauseText(String clauseText) {
		this.clauseText = clauseText;
	}
	/**
	 * 属性有效性标识/有效性标识：
1 有效
0 无效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效性标识/有效性标识：
1 有效
0 无效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型的setter方法
	 */
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
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

	public List getPolicySort() {
		return policySort;
	}

	public void setPolicySort(List policySort) {
		this.policySort = policySort;
	}

	public String getClauseType() {
		return clauseType;
	}

	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	public String getDelText() {
		return delText;
	}

	public void setDelText(String delText) {
		this.delText = delText;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public List<AutoClauseModuleDto> getAutoClauseModuleDtos() {
		return autoClauseModuleDtos;
	}

	public void setAutoClauseModuleDtos(List<AutoClauseModuleDto> autoClauseModuleDtos) {
		this.autoClauseModuleDtos = autoClauseModuleDtos;
	}

	public List<AutoClauseTextModuleDto> getAutoClauseTextModuleDtos() {
		return autoClauseTextModuleDtos;
	}

	public void setAutoClauseTextModuleDtos(List<AutoClauseTextModuleDto> autoClauseTextModuleDtos) {
		this.autoClauseTextModuleDtos = autoClauseTextModuleDtos;
	}

	public static void main(String[] args){
		List<AutoClauseModuleDto> autoClauseModuleDtos = new ArrayList<>();
		AutoClauseModuleDto autoClauseModuleDto = new AutoClauseModuleDto();
		AutoClauseModuleDto autoClauseModuleDto2 = new AutoClauseModuleDto();
		List<ClauseModuleDto> clauseModuleDtos = new ArrayList<>();
		List<ClauseModuleDto> clauseModuleDtos2 = new ArrayList<>();

		ClauseModuleDto clauseModuleDto = new ClauseModuleDto();
		clauseModuleDto.setModule("ITEMKIND");
		clauseModuleDto.setProperty("KindCode");
		clauseModuleDto.setPropertyType("STRING");
		clauseModuleDto.setCheckType("GetListValue");
		clauseModuleDto.setCheckValue("F");
		clauseModuleDto.setCheckModule("请选择");
		clauseModuleDto.setCheckProperty("请选择");
		clauseModuleDto.setRuleRemark("");
		clauseModuleDtos.add(clauseModuleDto);

		ClauseModuleDto clauseModuleDto2 = new ClauseModuleDto();
		clauseModuleDto2.setModule("ITEMKIND");
		clauseModuleDto2.setProperty("ModeCode");
		clauseModuleDto2.setPropertyType("STRING");
		clauseModuleDto2.setCheckType("ListValueEqual");
		clauseModuleDto2.setCheckValue("4");
		clauseModuleDto2.setCheckModule("请选择");
		clauseModuleDto2.setCheckProperty("请选择");
		clauseModuleDto2.setRuleRemark("");
		clauseModuleDtos.add(clauseModuleDto2);

		ClauseModuleDto clauseModuleDto3 = new ClauseModuleDto();
		clauseModuleDto3.setModule("ITEMCAR");
		clauseModuleDto3.setProperty("NewDeviceFlag");
		clauseModuleDto3.setPropertyType("STRING");
		clauseModuleDto3.setCheckType("ValueEqual");
		clauseModuleDto3.setCheckValue("1");
		clauseModuleDto3.setCheckModule("请选择");
		clauseModuleDto3.setCheckProperty("请选择");
		clauseModuleDto3.setRuleRemark("");
		clauseModuleDtos2.add(clauseModuleDto3);

		autoClauseModuleDto.setClauseModuleDtos(clauseModuleDtos);
		autoClauseModuleDto2.setClauseModuleDtos(clauseModuleDtos2);
		autoClauseModuleDtos.add(autoClauseModuleDto);
		autoClauseModuleDtos.add(autoClauseModuleDto2);

		//System.out.println(JSON.toJSON(autoClauseModuleDtos));

	}
}
