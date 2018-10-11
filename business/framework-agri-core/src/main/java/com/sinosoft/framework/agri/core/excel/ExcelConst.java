package com.sinosoft.framework.agri.core.excel;

/**
 * Excel导入导出常量类
 * @Author: 何伟东
 * @Date: 2017/11/24 11:14
 */
public final class ExcelConst {
	private ExcelConst() {}
	/** Excel 2007 以上版本扩展名 */
	public static final String XLSX_SUFFIX = ".xlsx";
	/** Excel 97-2003 版本扩展名 */
	public static final String XLS_SUFFIX = ".xls";
	/** Excel类型：Excel 97-2003 版本Excel */
	public static final String EXCEL_TYPE_HSSF = "HSSF";
	/** Excel类型：Excel 2007 以上版本Excel */
	public static final String EXCEL_TYPE_XSSF = "XSSF";
}
