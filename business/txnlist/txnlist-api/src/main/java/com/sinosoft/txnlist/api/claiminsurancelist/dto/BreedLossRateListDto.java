package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 06:26:52.496 
 * 养殖险定损清单信息表Api操作对象
 */
public class BreedLossRateListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	private String listNo ;
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width = 37)
	private String serialNo ;
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号",width = 47)
	private String policyNo ;
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width = 52)
	private String registNo ;		
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width = 67)
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户姓名",width = 67)
	private String fName ;		
	/** 属性耳标号/耳标号 */
	@ExportConfig(value = "耳标号")
	private String earConNo ;		
	/** 属性赔款金额/赔款金额 */
	@ExportConfig(value = "赔偿金额",width = 116)
	private java.lang.Double payAmount ;
	/** 属性备注/备注 */
	@ExportConfig(value = "备注",width = 116)
	private String remark ;		
	/**
	 * 属性损失率清单号/损失率清单号的getter方法
	 */
	public String getListNo() {
		return listNo;
	}
	/**
	 * 属性损失率清单号/损失率清单号的setter方法
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarConNo() {
		return earConNo;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarConNo(String earConNo) {
		this.earConNo = earConNo;
	}	
	/**
	 * 属性赔款金额/赔款金额的getter方法
	 */
	public java.lang.Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性赔款金额/赔款金额的setter方法
	 */
	public void setPayAmount(java.lang.Double payAmount) {
		this.payAmount = payAmount;
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
}
