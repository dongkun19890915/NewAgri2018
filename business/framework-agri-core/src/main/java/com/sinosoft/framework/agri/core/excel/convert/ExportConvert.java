package com.sinosoft.framework.agri.core.excel.convert;

/**
 * 数值对应的值需要查询数据库才能进行映射时需要有此类的实现
 * @Author: 何伟东
 * @Date: 2017/11/24 11:22
 */
public interface ExportConvert {
	public String handler(Integer val);
}
