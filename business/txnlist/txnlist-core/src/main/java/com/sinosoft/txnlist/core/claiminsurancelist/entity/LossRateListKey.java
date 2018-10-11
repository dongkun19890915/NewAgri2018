package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 08:50:16.862 
 * 理赔清单信息主表主键操作对象
 */
public class LossRateListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public LossRateListKey(){}
	public LossRateListKey(String listNo       ){
		this.listNo        = listNo       ;
	}
	/** 属性损失率清单号/损失率清单号 */
	@Column(name = "listNo       ")
	private String listNo        ;
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
}