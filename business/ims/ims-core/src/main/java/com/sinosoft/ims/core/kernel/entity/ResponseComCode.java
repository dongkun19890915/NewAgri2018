package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 机构代码表实体操作对象
 */
@Entity
@IdClass(ResponseComCodeKey.class)
public class ResponseComCode {

	private static final long serialVersionUID = 1L;
	/*机构代码*/
	@Id
	@Column(name = "comCode")
	private String comCode;
	/*用户代码*/

	@Column(name = "userCode")
	private String userCode;
	/*机构等级*/
	@Column(name = "comLevel")
	private String comLevel;

	@Column(name = "comCName")
	private String comCName;

	public ResponseComCode() {
	}

	public ResponseComCode(String comCode, String userCode, String comLevel, String comCName) {
		this.comCode = comCode;
		this.userCode = userCode;
		this.comLevel = comLevel;
		this.comCName = comCName;
	}

	public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getComLevel() {
		return comLevel;
	}

	public void setComLevel(String comLevel) {
		this.comLevel = comLevel;
	}
}