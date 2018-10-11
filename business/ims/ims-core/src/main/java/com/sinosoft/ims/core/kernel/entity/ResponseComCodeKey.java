package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 机构代码表实体操作对象
 */

public class ResponseComCodeKey extends BasePKImpl{

	private static final long serialVersionUID = 1L;
	public ResponseComCodeKey(){}
	public ResponseComCodeKey(String comCode){
		this.comCode = comCode;
	}
	/** 属性用户代码/用户代码 */
	private String comCode ;

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
}