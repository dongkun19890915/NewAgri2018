/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;

import java.util.List;
import java.util.Map;

/**
 * @description 分子因子获取值的输入
 * @author 王志伟
 * @date 2016年9月18日下午1:47:39
 */
public class UtiDecisionConditionDto extends UtiFormulaConditionDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 分子因子关联的原子因子的值，从condition1~condition10，顺序放入map
	 * 分子因子代码factorCode 也放入map
	 */
    private List<Map<String, Object>> paramMapList;

	/**
	 * 构造方法
	 */
	public UtiDecisionConditionDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the paramMapList
	 */
    public List<Map<String, Object>> getParamMapList()
    {
		return paramMapList;
	}

	/**
	 * @param paramMapList
	 *            the paramMapList to set
	 */
    public void setParamMapList(List<Map<String, Object>> paramMapList)
    {
		this.paramMapList = paramMapList;
	}

}
