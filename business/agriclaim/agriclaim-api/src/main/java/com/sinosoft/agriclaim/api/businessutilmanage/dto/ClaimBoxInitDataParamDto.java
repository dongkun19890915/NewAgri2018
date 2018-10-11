package com.sinosoft.agriclaim.api.businessutilmanage.dto;
/**
 * @description: 类功能简述:复选框，下拉框所需要的初始化参数
 * @author 安齐崇
 * @date 2017年12月9日下午4:26:40
 *
 */
public class ClaimBoxInitDataParamDto {
	/* 编码 */
	private String codecode;
	/* 编码对应的中文名 */
	private String codeename;
	/* 编码对应的中文名 */
	private String codecname;

	public String getCodecode() {
		return codecode;
	}

	public void setCodecode(String codecode) {
		this.codecode = codecode;
	}

	public String getCodeename() {
		return codeename;
	}

	public void setCodeename(String codeename) {
		this.codeename = codeename;
	}

	public String getCodecname() {
		return codecname;
	}

	public void setCodecname(String codecname) {
		this.codecname = codecname;
	}

}
