package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-20 08:18:36.753 
 * 承保主支付信息表主键操作对象
 */
public class PrpPayMainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPayMainKey(){}
	public PrpPayMainKey(String payNo,String fCode){
		this.payNo = payNo;
		this.fCode = fCode;
	}
	/** 属性支付号/支付号 */
	@Column(name = "payNo")
	private String payNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}
}