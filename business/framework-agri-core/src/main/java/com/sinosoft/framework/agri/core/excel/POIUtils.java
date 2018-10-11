package com.sinosoft.framework.agri.core.excel;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Apache POI SXSS相关API的简易封装，以及注解动态修改的方法
 * @Author: 何伟东
 * @Date: 2017/11/24 11:17
 */
public class POIUtils {

	private static final int mDefaultRowAccessWindowSize = 100;

	/**
	 * 创建指定大小的大数据Excel 2007 以上版本工作薄
	 * @author: 何伟东
	 * @date: 2017/11/24 11:17
	 * @param rowAccessWindowSize 指定大小
	 * @return 工作薄对象
	 */
	public static SXSSFWorkbook newSXSSFWorkbook(int rowAccessWindowSize) {
		return new SXSSFWorkbook(rowAccessWindowSize);
	}

	/**
	 * 创建默认大小的大数据Excel 2007 以上版本工作薄
	 * @author: 何伟东
	 * @date: 2017/11/24 11:18
	 * @return 工作薄对象
	 */
	public static SXSSFWorkbook newSXSSFWorkbook() {
		return newSXSSFWorkbook(mDefaultRowAccessWindowSize);
	}

	/**
	 * 创建默认大小的Excel 97-2003 版本工作薄
	 * @author: 何伟东
	 * @date: 2017/11/24 11:18
	 * @return 工作薄对象
	 */
	public static HSSFWorkbook newHSSFWorkbook(){
		return new HSSFWorkbook();
	}

	/**
	 * 创建默认大小的Excel 2007 以上版本工作薄
	 * @author: 何伟东
	 * @date: 2017/11/24 11:18
	 * @return 工作薄对象
	 */
	public static XSSFWorkbook newXSSFWorkbook(){
		return new XSSFWorkbook();
	}

	/**
	 * 创建一个Excel 2007 以上版本大数据工作薄中的sheet页
	 * @author: 何伟东
	 * @date: 2017/11/24 11:18
	 * @param sxwb 工作薄对象
	 * @param sheetName sheet页名称
	 * @return sheet页对象
	 */
	public static SXSSFSheet newSXSSFSheet(SXSSFWorkbook sxwb,String sheetName) {
		return sxwb.createSheet(sheetName);
	}

	/**
	 * 创建一个Excel 97-2003 版本工作薄中的sheet页
	 * @author: 何伟东
	 * @date: 2017/11/24 11:18
	 * @param hwb 工作薄对象
	 * @param sheetName sheet页名称
	 * @return sheet页对象
	 */
	public static HSSFSheet newHSSFSheet(HSSFWorkbook hwb,String sheetName) {
		return hwb.createSheet(sheetName);
	}

	/**
	 * 创建一个Excel 2007 以上版本工作薄中的sheet页
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param xwb 工作薄对象
	 * @param sheetName sheet页名称
	 * @return sheet页对象
	 */
	public static XSSFSheet newXSSFSheet(XSSFWorkbook xwb, String sheetName) {
		return xwb.createSheet(sheetName);
	}

	/**
	 * 创建一个Excel 2007 以上版本大数据sheet页中的一行
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param sheet sheet页对象
	 * @param index 行数下标
	 * @return 行对象
	 */
	public static SXSSFRow newSXSSFRow(SXSSFSheet sheet,int index) {
		return sheet.createRow(index);
	}

	/**
	 * 创建一个Excel 97-2003 版本sheet页中的一行
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param sheet sheet页对象
	 * @param index 行数下标
	 * @return 行对象
	 */
	public static HSSFRow newHSSFRow(HSSFSheet sheet, int index) {
		return sheet.createRow(index);
	}

	/**
	 * 创建一个Excel 2007 以上版本sheet页中的一行
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param sheet sheet页对象
	 * @param index 行数下标
	 * @return 行对象
	 */
	public static XSSFRow newXSSFRow(XSSFSheet sheet, int index) {
		return sheet.createRow(index);
	}

	/**
	 * 创建一个Excel 2007 以上版本大数据行中的单元格
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param row 行对象
	 * @param index 单元格下标
	 * @return 单元格对象
	 */
	public static SXSSFCell newSXSSFCell(SXSSFRow row, int index) {
		return row.createCell(index);
	}

	/**
	 * 创建一个Excel 97-2003 版本行中的单元格
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param row 行对象
	 * @param index 单元格下标
	 * @return 单元格对象
	 */
	public static HSSFCell newHSSFCell(HSSFRow row, int index) {
		return row.createCell(index);
	}

	/**
	 * 创建一个Excel 2007 以上版本行中的单元格
	 * @author: 何伟东
	 * @date: 2017/11/24 11:19
	 * @param row 行对象
	 * @param index 单元格下标
	 * @return 单元格对象
	 */
	public static XSSFCell newXSSFCell(XSSFRow row, int index) {
		return row.createCell(index);
	}

	/**
	 * 设定单元格宽度 (手动/自动)
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param sheet 工作薄对象
	 * @param index 单元格索引
	 * @param width 指定宽度,-1为自适应
	 * @param value 自适应需要单元格内容进行计算
	 */
	public static void setColumnWidth(SXSSFSheet sheet,int index, short width, String value) {
		if (width == -1 && value != null && !"".equals(value)) {
			sheet.setColumnWidth(index, (short) (value.length() * 512));
		} else {
			width = width == -1 ? 200 : width;
			sheet.setColumnWidth(index, (short) (width * 35.7));
		}
	}


	/**
	 * 设定单元格宽度 (手动/自动)
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param sheet 工作薄对象
	 * @param index 单元格索引
	 * @param width 指定宽度,-1为自适应
	 * @param value 自适应需要单元格内容进行计算
	 */
	public static void setHSSFColumnWidth(HSSFSheet sheet,int index, short width, String value) {
		if (width == -1 && value != null && !"".equals(value)) {
			sheet.setColumnWidth(index, (short) (value.length() * 512));
		} else {
			width = width == -1 ? 200 : width;
			sheet.setColumnWidth(index, (short) (width * 35.7));
		}
	}

	/**
	 * 设定单元格宽度 (手动/自动)
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param sheet 工作薄对象
	 * @param index 单元格索引
	 * @param width 指定宽度,-1为自适应
	 * @param value 自适应需要单元格内容进行计算
	 */
	public static void setXSSFColumnWidth(XSSFSheet sheet,int index, short width, String value) {
		if (width == -1 && value != null && !"".equals(value)) {
			sheet.setColumnWidth(index, (short) (value.length() * 512));
		} else {
			width = width == -1 ? 200 : width;
			sheet.setColumnWidth(index, (short) (width * 35.7));
		}
	}

	/**
	 * 大数据文件将Excel 2007 以上版本内容写到指定文件输出流中
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param sxwb 大数据工作薄对象
	 * @param out 输出流
	 * @throws Exception
	 */
	public static void writeSXSSFByLocal(SXSSFWorkbook sxwb, OutputStream out) throws Exception {
		sxwb.write(out);
		out.flush();
		out.close();
	}

	/**
	 * Excel 97-2003 版本工作薄内容写到指定文件输出流中
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param hwb 工作薄对象
	 * @param out 输出流
	 * @throws Exception
	 */
	public static void writeHSSFByLocal(HSSFWorkbook hwb, OutputStream out) throws Exception {
		hwb.write(out);
		out.flush();
		out.close();
	}

	/**
	 * Excel 2007 以上版本工作薄内容写到指定文件输出流中
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param xwb 工作薄对象
	 * @param out 输出流
	 * @throws Exception
	 */
	public static void writeXSSFByLocal(XSSFWorkbook xwb, OutputStream out) throws Exception {
		xwb.write(out);
		out.flush();
		out.close();
	}

	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param sheet 要设置的sheet.
	 * @param textlist 下拉框显示的内容
	 * @param firstRow 开始行
	 * @param endRow 结束行
	 * @param firstCol   开始列
	 * @param endCol  结束列
	 * @return 设置好的sheet.
	 */
	public static SXSSFSheet setHSSFValidation(SXSSFSheet sheet,
											  String[] textlist, int firstRow, int endRow, int firstCol,
											  int endCol) {
		DataValidationHelper validationHelper = sheet.getDataValidationHelper();
		// 加载下拉列表内容
		DataValidationConstraint explicitListConstraint = validationHelper.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,endRow, firstCol, endCol);
		// 数据有效性对象
		DataValidation validation = validationHelper.createValidation(explicitListConstraint, regions);
		validation.setSuppressDropDownArrow(true);
		validation.createErrorBox("tip","请从下拉列表选取");
		//错误警告框
		validation.setShowErrorBox(true);
		sheet.addValidationData(validation);
		return sheet;
	}

	/**
	 * 检查Excel版本
	 * @author: 何伟东
	 * @date: 2017/11/24 11:20
	 * @param fileName 文件名称
	 * @return 2003版本返回HSSF,2007以上版本返回XSSF
	 */
	public static String checkExcelVersion(String fileName) {
		if (fileName.toLowerCase().endsWith(ExcelConst.XLS_SUFFIX)){
			return ExcelConst.EXCEL_TYPE_HSSF;
		}else if (fileName.toLowerCase().endsWith(ExcelConst.XLSX_SUFFIX)) {
			return ExcelConst.EXCEL_TYPE_XSSF;
		}else{
			throw new IllegalArgumentException("仅支持支持.xls和.xlsx的Excel文件！");
		}
	}

	/**
	 * 动态的修改要转换 excel 的dto中的注解内容
	 * @author: 何伟东
	 * @date: 2017/11/24 11:21
	 * @param fieldName 属性名
	 * @param annotationKey 注解的属性名
	 * @param annotationValue 要替换的值
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static void modfiyAnnotationKey(Class className, String fieldName, Object annotationKey, Object annotationValue) throws NoSuchFieldException, IllegalAccessException {
		Field field = className.getDeclaredField(fieldName);
		ExportConfig annotation = field.getAnnotation(ExportConfig.class);
		InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
		Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
		memberValues.setAccessible(true);
		Map map = (Map) memberValues.get(invocationHandler);
		map.put(annotationKey, annotationValue);
	}

	/**
	 * 设置XSSF的body内容样式
	 * @author: 何伟东
	 * @date: 2017/12/6 17:45
	 * @param workbook 工作薄对象
	 * @param cellStyle 单元格样式
	 * @param font 字体
	 * @param fontColor 字体颜色
	 */
	public static void setCellBodyStyle(Workbook workbook, CellStyle cellStyle, Font font, short fontColor){
		//设置单元格为文本格式 主要是为了方面处理 日期等特殊格式
		DataFormat dataFormat = workbook.createDataFormat();
		cellStyle.setDataFormat(dataFormat.getFormat("@"));
		//字体
		font.setFontName("宋体");
		font.setColor(fontColor);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setFont(font);
		// 水平居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		// 垂直居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 上边框为细边框
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		// 右边框为细边框
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// 下边框为细边框
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		// 左边框为细边框
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
	}
}
