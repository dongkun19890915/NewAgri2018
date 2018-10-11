package com.sinosoft.framework.agri.core.excel.hanlder;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * Excel (97-2003)导出Excel设置接口。导出时需要此类的实现类
 * @Author: 何伟东
 * @Date: 2017/11/24 10:42
 */
public interface HSSFExportHandler {

	/**
	 * 设置接口样式
	 * @author: 何伟东
	 * @date: 2017/11/24 10:43
	 * @param workbook 工作薄对象
	 * @param sheet sheet页对象
	 * @return List<Object>;size=2;[1]CellStyle样式对象[2]lastRow合并单元的最后一行坐标
	 */
	public List<Object> headCellStyle(HSSFWorkbook workbook, HSSFSheet sheet);
}
