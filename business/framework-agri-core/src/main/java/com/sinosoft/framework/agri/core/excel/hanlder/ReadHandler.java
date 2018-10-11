package com.sinosoft.framework.agri.core.excel.hanlder;

import java.util.List;

/**
 * 行级别的数据读取回调接口,读取Excel时必须有此接口的实现类
 * @Author: 何伟东
 * @Date: 2017/11/17 17:08
 */
public interface ReadHandler {

	/**
	 * 处理当前行数据
	 * @author: 何伟东
	 * @date: 2017/11/24 10:44
	 * @param sheetIndex 当前sheet页的页码,从0开始
	 * @param rowIndex 当前行的行号，从0开始
	 * @param row 当前行数据
	 */
	public void handler(int sheetIndex, int rowIndex, List<String> row) throws  Exception;
}
