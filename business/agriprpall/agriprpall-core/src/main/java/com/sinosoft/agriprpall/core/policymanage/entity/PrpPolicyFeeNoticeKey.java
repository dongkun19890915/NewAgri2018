package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757 
 * 保费缴款通知书信息表主键操作对象
 */
public class PrpPolicyFeeNoticeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPolicyFeeNoticeKey(){}
	public PrpPolicyFeeNoticeKey(String policyFeeNo){
		this.policyFeeNo = policyFeeNo;
	}
	/** 属性缴费通知书编号/缴费通知书编号 */
	@Column(name = "policyFeeNo")
	private String policyFeeNo ;
	/**
	 * 属性缴费通知书编号/缴费通知书编号的getter方法
	 */
	public String getPolicyFeeNo() {
    		return policyFeeNo;
	}
	/**
	 * 属性缴费通知书编号/缴费通知书编号的setter方法
	 */
	public void setPolicyFeeNo(String policyFeeNo) {
		this.policyFeeNo = policyFeeNo;
	} 
}