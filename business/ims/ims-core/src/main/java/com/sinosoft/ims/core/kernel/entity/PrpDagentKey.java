package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 中介机构代码表主键操作对象
 */
public class PrpDagentKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDagentKey(){}
	public PrpDagentKey(String agentCode){
		this.agentCode = agentCode;
	}
	/** 属性代理人代码/代理人代码 */
	@Column(name = "agentCode")
	private String agentCode ;
	/**
	 * 属性代理人代码/代理人代码的getter方法
	 */
	public String getAgentCode() {
    		return agentCode;
	}
	/**
	 * 属性代理人代码/代理人代码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	} 
}