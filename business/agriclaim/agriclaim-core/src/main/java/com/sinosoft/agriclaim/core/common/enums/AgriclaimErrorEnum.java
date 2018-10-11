package com.sinosoft.agriclaim.core.common.enums;

/**
 * @description agriclaim错误信息枚举类
 * @author yanghang
 * @date 2017年11月1日
 */
public enum AgriclaimErrorEnum {
	AGRICLAIM_SUCCESS("0000", "处理成功"), AGRICLAIM_ERROR("9999", "处理失败");

	// 成员变量
	private String code;

	private String name;

	// 构造方法
	private AgriclaimErrorEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getCodeByName(String name) {
		for (AgriclaimErrorEnum info : AgriclaimErrorEnum.values()) {
			if (name.indexOf(info.getName()) > -1) {
				return info.getCode();
			}
		}
		return "999";
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
