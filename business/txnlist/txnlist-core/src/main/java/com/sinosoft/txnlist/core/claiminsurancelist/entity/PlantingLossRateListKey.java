package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * 定损清单信息表主键操作对象
 */
public class PlantingLossRateListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingLossRateListKey(){}
	public PlantingLossRateListKey(String listNo,String serialNo){
		this.listNo = listNo;
		this.serialNo = serialNo;
	}
	/** 属性损失率清单号/损失率清单号 */
	@Column(name = "listNo")
	private String listNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
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
}