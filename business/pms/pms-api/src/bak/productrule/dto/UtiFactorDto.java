/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;


import com.sinosoft.pms.api.common.dto.PmsResponseDto;

/**
 * @description 查询产品因子返回类
 * @author 王志伟
 * @date 2016年9月17日上午10:09:46
 */
public class UtiFactorDto extends PmsResponseDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 因子代码
	 */
	private String factorCode;
	/**
	 * 因子类型
	 */
	private String factorType;
	/**
	 * 原子根据哪个键获取值
	 */
	private String fromKey;
	/**
	 * 分子因子的相关原子因子
	 */
	private String relatedFactorCodes;

	/**
	 * 构造方法
	 */
	public UtiFactorDto() {
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
	 * @return the factorType
	 */
	public String getFactorType() {
		return factorType;
	}

	/**
	 * @param factorType
	 *            the factorType to set
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
	}

	/**
	 * @return the fromKey
	 */
	public String getFromKey() {
		return fromKey;
	}

	/**
	 * @param fromKey
	 *            the fromKey to set
	 */
	public void setFromKey(String fromKey) {
		this.fromKey = fromKey;
	}

	/**
	 * @return the relatedFactorCodes
	 */
	public String getRelatedFactorCodes() {
		return relatedFactorCodes;
	}

	/**
	 * @param relatedFactorCodes
	 *            the relatedFactorCodes to set
	 */
	public void setRelatedFactorCodes(String relatedFactorCodes) {
		this.relatedFactorCodes = relatedFactorCodes;
	}

}
