/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;

import java.util.List;

/**
 * @description 查询产品因子输入类
 * @author 王志伟
 * @date 2016年9月17日上午10:03:22
 */
public class UtiFactorConditionDto extends UtiFormulaConditionDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 因子代码
	 */
	private List<String> factorCodeList;

	/**
	 * 构造方法
	 */
	public UtiFactorConditionDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the factorCodeList
	 */
	public List<String> getFactorCodeList() {
		return factorCodeList;
	}

	/**
	 * @param factorCodeList
	 *            the factorCodeList to set
	 */
	public void setFactorCodeList(List<String> factorCodeList) {
		this.factorCodeList = factorCodeList;
	}

}
