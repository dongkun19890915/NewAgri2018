/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;


import com.sinosoft.pms.api.common.dto.PmsResponseDto;

/**
 * @description 查询产品公式返回类
 * @author 王志伟
 * @date 2016年9月17日上午10:09:46
 */
public class UtiFormulaDto extends PmsResponseDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 计算公式
	 */
	private String formulaContent;
	/**
	 * 精度
	 */
	private String accuracy;
	/**
	 * 机构代码
	 */
	private String comCode;

	/**
	 * 构造方法
	 */
	public UtiFormulaDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the formulaContent
	 */
	public String getFormulaContent() {
		return formulaContent;
	}

	/**
	 * @param formulaContent
	 *            the formulaContent to set
	 */
	public void setFormulaContent(String formulaContent) {
		this.formulaContent = formulaContent;
	}

	/**
	 * @return the accuracy
	 */
	public String getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy
	 *            the accuracy to set
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * @return the comCode
	 */
	public String getComCode() {
		return comCode;
	}

	/**
	 * @param comCode
	 *            the comCode to set
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

}
