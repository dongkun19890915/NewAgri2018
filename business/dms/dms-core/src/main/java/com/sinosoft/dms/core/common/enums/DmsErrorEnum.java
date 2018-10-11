package com.sinosoft.dms.core.common.enums;

/**
* @description  核心业务系统错误信息枚举类
* @author YJX
* @date 2016年9月16日上午10:06:47
*/
public enum DmsErrorEnum {

	DMS_SUCCESS("0000", "处理成功"),
	DMS_ERROR("9999", "其他类型异常"),

      //数据校验错误（1打头）
	DMS_ERROR_1001("1001","险种不能为空"),
	DMS_ERROR_1002("1002","用户不能为空"),
	DMS_ERROR_1003("1003","险种或者机构长度错误"),
	DMS_ERROR_1004("1004","客户代码类型错误"),
	DMS_ERROR_1005("1005","前缀错误"),
	
	
	//业务异常（2打头）
	DMS_ERROR_2001("2001","转换数据对象异常"),
	DMS_ERROR_2002("2002","投保单保存失败"),
	DMS_ERROR_2003("2003","投保单号生成失败"),
	DMS_ERROR_2004("2004","保单号生成失败"),
	DMS_ERROR_2005("2005","批单号生成失败"),
	DMS_ERROR_2006("2006","批单申请号生成失败"),
	DMS_ERROR_2007("2007","标的号生成失败"),
    DMS_ERROR_2008("2008","订单号生成失败"),
    DMS_ERROR_2009("2009","单号生成失败");
	
	
	// 成员变量
	private String code;
	private String name;

	// 构造方法
	private DmsErrorEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	
	/**
	* @description 通过名称获取代码
	* @param name  错误信息描述
	* @return  错误信息代码
	* @author YJX
	* @date 2016年9月16日上午10:06:07
	*/
	public static String getCodeByName(String name) {
		for (DmsErrorEnum info : DmsErrorEnum.values()) {
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
