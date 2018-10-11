package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * 条款公式配置项配置表实体操作对象
 */
@Entity
@Table(name = "PrpLFormulaConfig")
@IdClass(PrpLFormulaConfigKey.class)
public class PrpLFormulaConfig extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性序号，唯一标识/序号，唯一标识 */
	@Id
	@Column(name = "id")
	private String id ;	

	/** 属性险种/险种 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险类/险类 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性配置项代码/配置项代码 */
	@Column(name = "configCode")
	private String configCode ;
	/** 属性配置项说明/配置项说明 */
	@Column(name = "configDescribing")
	private String configDescribing ;
	/** 属性配置范围  H汇总计算  F分开计算/配置范围  H汇总计算  F分开计算 */
	@Column(name = "configUrationRange")
	private String configUrationRange ;
	/** 属性取值方式  0直接取值  1通过SQL取值/取值方式  0直接取值  1通过SQL取值 */
	@Column(name = "configUrationType")
	private String configUrationType ;
	/** 属性取值内容/取值内容 */
	@Column(name = "configUrationContent")
	private String configUrationContent ;
	/** 属性备用字段1/备用字段1 */
	@Column(name = "reserve1")
	private String reserve1 ;
	/** 属性备用字段2/备用字段2 */
	@Column(name = "reserve2")
	private String reserve2 ;
	/** 属性备用字段3/备用字段3 */
	@Column(name = "reserve3")
	private String reserve3 ;
	/** 属性备用字段4/备用字段4 */
	@Column(name = "reserve4")
	private String reserve4 ;
	/** 属性备用字段5/备用字段5 */
	@Column(name = "reserve5")
	private String reserve5 ;
	/** 属性备用字段6/备用字段6 */
	@Column(name = "reserve6")
	private String reserve6 ;
	/** 属性备用字段7/备用字段7 */
	@Column(name = "reserve7")
	private String reserve7 ;
	/**
	 * 属性序号，唯一标识/序号，唯一标识的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性序号，唯一标识/序号，唯一标识的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性配置项代码/配置项代码的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性配置项代码/配置项代码的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	} 	
	/**
	 * 属性配置项说明/配置项说明的getter方法
	 */
	public String getConfigDescribing() {
		return configDescribing;
	}
	/**
	 * 属性配置项说明/配置项说明的setter方法
	 */
	public void setConfigDescribing(String configDescribing) {
		this.configDescribing = configDescribing;
	} 	
	/**
	 * 属性配置范围  H汇总计算  F分开计算/配置范围  H汇总计算  F分开计算的getter方法
	 */
	public String getConfigUrationRange() {
		return configUrationRange;
	}
	/**
	 * 属性配置范围  H汇总计算  F分开计算/配置范围  H汇总计算  F分开计算的setter方法
	 */
	public void setConfigUrationRange(String configUrationRange) {
		this.configUrationRange = configUrationRange;
	} 	
	/**
	 * 属性取值方式  0直接取值  1通过SQL取值/取值方式  0直接取值  1通过SQL取值的getter方法
	 */
	public String getConfigUrationType() {
		return configUrationType;
	}
	/**
	 * 属性取值方式  0直接取值  1通过SQL取值/取值方式  0直接取值  1通过SQL取值的setter方法
	 */
	public void setConfigUrationType(String configUrationType) {
		this.configUrationType = configUrationType;
	} 	
	/**
	 * 属性取值内容/取值内容的getter方法
	 */
	public String getConfigUrationContent() {
		return configUrationContent;
	}
	/**
	 * 属性取值内容/取值内容的setter方法
	 */
	public void setConfigUrationContent(String configUrationContent) {
		this.configUrationContent = configUrationContent;
	} 	
	/**
	 * 属性备用字段1/备用字段1的getter方法
	 */
	public String getReserve1() {
		return reserve1;
	}
	/**
	 * 属性备用字段1/备用字段1的setter方法
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	} 	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	} 	
	/**
	 * 属性备用字段3/备用字段3的getter方法
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * 属性备用字段3/备用字段3的setter方法
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	} 	
	/**
	 * 属性备用字段4/备用字段4的getter方法
	 */
	public String getReserve4() {
		return reserve4;
	}
	/**
	 * 属性备用字段4/备用字段4的setter方法
	 */
	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	} 	
	/**
	 * 属性备用字段5/备用字段5的getter方法
	 */
	public String getReserve5() {
		return reserve5;
	}
	/**
	 * 属性备用字段5/备用字段5的setter方法
	 */
	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	} 	
	/**
	 * 属性备用字段6/备用字段6的getter方法
	 */
	public String getReserve6() {
		return reserve6;
	}
	/**
	 * 属性备用字段6/备用字段6的setter方法
	 */
	public void setReserve6(String reserve6) {
		this.reserve6 = reserve6;
	} 	
	/**
	 * 属性备用字段7/备用字段7的getter方法
	 */
	public String getReserve7() {
		return reserve7;
	}
	/**
	 * 属性备用字段7/备用字段7的setter方法
	 */
	public void setReserve7(String reserve7) {
		this.reserve7 = reserve7;
	} 	
}