package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 08:12:17.248 
 * 农业险保单信息P主键操作对象
 */
public class PrpPmainAgriCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPmainAgriCopyKey(){}

	public PrpPmainAgriCopyKey(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/**
	 * 属性批单号码/批单号码的getter方法
	 */

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
}