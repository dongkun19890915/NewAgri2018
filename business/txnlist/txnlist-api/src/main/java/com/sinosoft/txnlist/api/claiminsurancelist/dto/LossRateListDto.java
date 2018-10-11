package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 08:50:16.862 
 * 理赔清单信息主表Api操作对象
 */
public class LossRateListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	private String listNo        ;		
	/** 属性定损清单名称/定损清单名称 */
	private String listName      ;		
	/** 属性保单号/保单号 */
	private String policyNo      ;		
	/** 属性报案号/报案号 */
	private String registNo      ;
	/** 属性计算书号/计算书号 */
	private String compensateNo  ;		
	/** 属性支付清单号/支付清单号 */
	private String paymentListNo ;		
	/** 属性理赔清单号/理赔清单号 */
	private String claimListNo   ;		
	/** 属性归属区域/归属区域 */
	private String areaCode      ;		
	/** 属性备用/备用 */
	private String remark        ;		
	/** 属性备用1/备用1 */
	private String remark1       ;		
	/** 属性备用2/备用2 */
	private String remark2       ;		
	/**
	 * 属性损失率清单号/损失率清单号的getter方法
	 */
	public String getListNo       () {
		return listNo       ;
	}
	/**
	 * 属性损失率清单号/损失率清单号的setter方法
	 */
	public void setListNo       (String listNo       ) {
		this.listNo        = listNo       ;
	}	
	/**
	 * 属性定损清单名称/定损清单名称的getter方法
	 */
	public String getListName     () {
		return listName     ;
	}
	/**
	 * 属性定损清单名称/定损清单名称的setter方法
	 */
	public void setListName     (String listName     ) {
		this.listName      = listName     ;
	}	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo     () {
		return policyNo     ;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo     (String policyNo     ) {
		this.policyNo      = policyNo     ;
	}	
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo     () {
		return registNo     ;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo     (String registNo     ) {
		this.registNo      = registNo     ;
	}	
	/**
	 * 属性计算书号/计算书号的getter方法
	 */
	public String getCompensateNo () {
		return compensateNo ;
	}
	/**
	 * 属性计算书号/计算书号的setter方法
	 */
	public void setCompensateNo (String compensateNo ) {
		this.compensateNo  = compensateNo ;
	}	
	/**
	 * 属性支付清单号/支付清单号的getter方法
	 */
	public String getPaymentListNo() {
		return paymentListNo;
	}
	/**
	 * 属性支付清单号/支付清单号的setter方法
	 */
	public void setPaymentListNo(String paymentListNo) {
		this.paymentListNo = paymentListNo;
	}	
	/**
	 * 属性理赔清单号/理赔清单号的getter方法
	 */
	public String getClaimListNo  () {
		return claimListNo  ;
	}
	/**
	 * 属性理赔清单号/理赔清单号的setter方法
	 */
	public void setClaimListNo  (String claimListNo  ) {
		this.claimListNo   = claimListNo  ;
	}	
	/**
	 * 属性归属区域/归属区域的getter方法
	 */
	public String getAreaCode     () {
		return areaCode     ;
	}
	/**
	 * 属性归属区域/归属区域的setter方法
	 */
	public void setAreaCode     (String areaCode     ) {
		this.areaCode      = areaCode     ;
	}	
	/**
	 * 属性备用/备用的getter方法
	 */
	public String getRemark       () {
		return remark       ;
	}
	/**
	 * 属性备用/备用的setter方法
	 */
	public void setRemark       (String remark       ) {
		this.remark        = remark       ;
	}	
	/**
	 * 属性备用1/备用1的getter方法
	 */
	public String getRemark1      () {
		return remark1      ;
	}
	/**
	 * 属性备用1/备用1的setter方法
	 */
	public void setRemark1      (String remark1      ) {
		this.remark1       = remark1      ;
	}	
	/**
	 * 属性备用2/备用2的getter方法
	 */
	public String getRemark2      () {
		return remark2      ;
	}
	/**
	 * 属性备用2/备用2的setter方法
	 */
	public void setRemark2      (String remark2      ) {
		this.remark2       = remark2      ;
	}	
}
