package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-20 08:18:36.753 
 * 承保支付信息子表主键操作对象
 */
public class PrpPaySubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPaySubKey(){}

	public PrpPaySubKey(String payNo, String endorseNo, String costType) {
		this.payNo = payNo;
		this.endorseNo = endorseNo;
		this.costType = costType;
	}

	/** 属性支付号/支付号 */
	@Column(name = "payNo")
	private String payNo ;
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 费用类型 */
	@Column(name = "costType")
	private String costType;

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}
}