package com.sinosoft.agriclaim.api.cetainmanage.dto;
/**
 * @description: 类功能简述：财产核定损明细清单表扩展类
 * @author 安齐崇
 * @date 2017年11月21日上午11:11:10
 */
public class PrpLPropDtoExt extends PrpLPropDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*险别名称*/
	private String kindName;
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
}
