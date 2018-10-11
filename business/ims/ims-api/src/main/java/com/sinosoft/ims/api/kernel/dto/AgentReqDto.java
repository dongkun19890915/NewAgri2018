package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @description 客户查询请求参数 
 * @author 宋振振
 * @date 2017年8月28日 下午2:29:51
 */
public class AgentReqDto extends BaseRequest implements Serializable {

	/** 归属机构代码 */
	private String comCode;
	/** 业务性质(0直接业务/1个人代理/2专业代理/3兼业代理/4境内经纪业务) */
	private String businessNature;
	/**代理人姓名*/
	private String agentName;
	/**代理人代码*/
	private String agentCode;
	/**登陆用户代码*/
	private String powerUserCode;
	/**codeClass-代码域codeCode或姓名域codeName*/
	private String codeClass;
	/**查询方式--like或eq*/
	private String codeMethod;

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getComCode() {
		return comCode;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public String getAgentName() {
		return agentName;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public String getPowerUserCode() {
		return powerUserCode;
	}

	public void setPowerUserCode(String powerUserCode) {
		this.powerUserCode = powerUserCode;
	}

	public String getCodeClass() {
		return codeClass;
	}

	public void setCodeClass(String codeClass) {
		this.codeClass = codeClass;
	}

	public String getCodeMethod() {
		return codeMethod;
	}

	public void setCodeMethod(String codeMethod) {
		this.codeMethod = codeMethod;
	}
}
