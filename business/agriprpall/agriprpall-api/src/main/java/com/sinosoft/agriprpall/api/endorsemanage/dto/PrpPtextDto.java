package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * 批改文字信息表Api操作对象
 */
public class PrpPtextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号次/批单号次 */
	private String endorseNo ;		
	/** 属性保险单号次/保险单号次 */
	private String policyNo ;		
	/** 属性批文的行号/批文的行号 */
	private Integer lineNo ;
	/** 属性批文内容/批文内容 */
	private String endorseText ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性批单号次/批单号次的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号次/批单号次的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性保险单号次/保险单号次的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保险单号次/保险单号次的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性批文的行号/批文的行号的getter方法
	 */
	public Integer getLineNo() {
		return lineNo;
	}
	/**
	 * 属性批文的行号/批文的行号的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}	
	/**
	 * 属性批文内容/批文内容的getter方法
	 */
	public String getEndorseText() {
		return endorseText;
	}
	/**
	 * 属性批文内容/批文内容的setter方法
	 */
	public void setEndorseText(String endorseText) {
		this.endorseText = endorseText;
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
}
