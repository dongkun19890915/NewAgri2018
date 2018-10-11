package com.sinosoft.txnlist.api.insuremainlist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
* @Description: 根据清单信息查询保单Api接口
* @Author: 杨成程
* @Date: 2017/11/23 11:20
*/
public class RequestQueryPolicyDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性耳标号 /耳标号 */
	private String earLabel;
	/** 属性农户姓名 /农户姓名(种植险专用) */
	private String fName;
	/** 属性起保日期 /起保日期 */
	private String startDate;
	/** 属性终保日期/终保日期 */
	private String endDate;
	/** 属性查询类型/1、RegistBeforeQuery 报案登记查询保单； 2、Show 报案登记任务查询*/
	private String editType;
    /**
     * 属性农户代码
     */
    private String fCode;

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

	/**
	 * 属性耳标号 /耳标号 的getter方法
	 */
	public String getEarLabel() {
		return earLabel;
	}
	/**
	 * 属性耳标号 /耳标号 的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}
	/**
	 * 属性农户姓名 /农户姓名的getter方法
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * 属性农户姓名 /农户姓名 的setter方法
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * 属性起保日期 /起保日期的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期 /起保日期的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 属性终保日期/终保日期的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期/终保日期 的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 属性查询类型/查询类型的getter方法
	 */
	public String getEditType() {
		return editType;
	}
	/**
	 * 属性查询类型/查询类型 的setter方法
	 */
	public void setEditType(String editType) {
		this.editType = editType;
	}

}
