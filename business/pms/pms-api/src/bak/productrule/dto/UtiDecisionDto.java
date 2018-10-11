/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;


import com.sinosoft.pms.api.common.dto.PmsResponseDto;

/**
 * @description 分子因子返回
 * @author 王志伟
 * @date 2016年9月18日下午1:48:41
 */
public class UtiDecisionDto extends PmsResponseDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 分子因子代码
	 */
	private String factorCode;
	/**
	 * 分子因子值
	 */
	private String factorValue;

	/**
	 * 构造方法
	 */
	public UtiDecisionDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the factorCode
	 */
	public String getFactorCode() {
		return factorCode;
	}

	/**
	 * @param factorCode
	 *            the factorCode to set
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}

	/**
	 * @return the factorValue
	 */
	public String getFactorValue() {
		return factorValue;
	}

	/**
	 * @param factorValue
	 *            the factorValue to set
	 */
	public void setFactorValue(String factorValue) {
		this.factorValue = factorValue;
	}

}
