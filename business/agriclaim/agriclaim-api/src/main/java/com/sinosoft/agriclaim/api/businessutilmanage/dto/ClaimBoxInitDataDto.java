package com.sinosoft.agriclaim.api.businessutilmanage.dto;
/**
 * @description: 类功能简述：下拉框初始化返参组装对象
 * @author 安齐崇
 * @date 2017年12月18日上午11:22:21
 */
public class ClaimBoxInitDataDto {
	/*类型编码*/
	private String codeType;
	private ClaimBoxInitActionDto resultobj;
    
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public ClaimBoxInitActionDto getResultobj() {
		return resultobj;
	}

	public void setResultobj(ClaimBoxInitActionDto resultobj) {
		this.resultobj = resultobj;
	}

}
