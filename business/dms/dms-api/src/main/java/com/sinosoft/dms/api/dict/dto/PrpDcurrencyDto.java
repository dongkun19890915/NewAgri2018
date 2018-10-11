package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-29 03:33:56.492 
 * 币别代码表Api操作对象
 */
public class PrpDcurrencyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性币别代码/币别代码 */
	private String currencyCode ;		
	/** 属性币别中文名称/币别中文名称 */
	private String currencyCName ;
	/** 属性币别英文名称/币别英文名称 */
	private String currencyEName ;
	/** 属性最新币别代码/最新币别代码 */
	private String newCurrencyCode ;		
	/** 属性帐套类型代码/帐套类型代码 */
	private String accBookCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/** 属性updateDate/updateDate */
	private java.util.Date updateDate ;		
	/** 属性updateBy/updateBy */
	private String updateBy ;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCName() {
		return currencyCName;
	}

	public void setCurrencyCName(String currencyCName) {
		this.currencyCName = currencyCName;
	}

	public String getCurrencyEName() {
		return currencyEName;
	}

	public void setCurrencyEName(String currencyEName) {
		this.currencyEName = currencyEName;
	}

	public String getNewCurrencyCode() {
		return newCurrencyCode;
	}

	public void setNewCurrencyCode(String newCurrencyCode) {
		this.newCurrencyCode = newCurrencyCode;
	}

	public String getAccBookCode() {
		return accBookCode;
	}

	public void setAccBookCode(String accBookCode) {
		this.accBookCode = accBookCode;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
