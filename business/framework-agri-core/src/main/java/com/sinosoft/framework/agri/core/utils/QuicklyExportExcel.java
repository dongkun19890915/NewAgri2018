package com.sinosoft.framework.agri.core.utils;

import com.sinosoft.framework.agri.core.excel.ExcelConst;
import com.sinosoft.framework.agri.core.excel.headstyle.HSSFDefaultHeadCellStyle;
import com.sinosoft.framework.agri.core.excel.headstyle.SXSSFDefaultHeadCellStyle;
import com.sinosoft.framework.exception.DataVerifyException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 快速到导出Excel工具类对ExcelUtil二次封装
 *
 * @author: 何伟东
 * @date: 2017/12/27 14:57
 */
public class QuicklyExportExcel {

    /**
     * 快速导入excel工具，默认样式
     *
     * @param exportExcelType excel导出类型
     * @param excelName       excel文件名称
     * @param titleName       表头标题名称
     * @param dataList        数据存储的list
     * @param lastRow         合并单元格最后一行行数，从0开始
     * @param lastCol         合并单元格最后一列列数，从0开始
     * @param ObjectClass     数据载体的dto对应的Class类
     * @return 生成的excel文件file对象
     * @author: 何伟东
     * @date: 2017/12/27 17:16
     */
    public <T> File quicklyExport(String exportExcelType, String excelName, String titleName, List<T> dataList, int lastRow, int lastCol, Class<T> ObjectClass) throws Exception {
        // 此方法默认sheet页名称为"sheet"
        return this.quicklyExport(exportExcelType, excelName, "sheet", titleName, dataList, lastRow, lastCol, ObjectClass);
    }

    /**
     * 快速导入excel工具，默认样式
     *
     * @param exportExcelType excel导出类型
     * @param excelName       excel文件名称
     * @param sheetName       sheet页名称
     * @param titleName       表头标题名称
     * @param dataList        数据存储的list
     * @param lastRow         合并单元格最后一行行数，从0开始
     * @param lastCol         合并单元格最后一列列数，从0开始
     * @param ObjectClass     数据载体的dto对应的Class类
     * @return 生成的excel文件file对象
     * @author: 何伟东
     * @date: 2017/12/28 13:02
     */
    public <T> File quicklyExport(String exportExcelType, String excelName, String sheetName, String titleName, List<T> dataList, int lastRow, int lastCol, Class<T> ObjectClass) throws Exception {
        File file;
        ExcelUtil excelUtil = ExcelUtil.initBuilder(ObjectClass);
        // Excel导出类型判断：.xls 97-2003 版本 Excel
        if (ExcelConst.XLS_SUFFIX.equalsIgnoreCase(exportExcelType)) {
            file = File.createTempFile(excelName, ExcelConst.XLS_SUFFIX);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 导出Excel 97-2003 版本 方法
            excelUtil.toHSSFExcel(dataList, sheetName, new HSSFDefaultHeadCellStyle(titleName, lastRow, lastCol), fileOutputStream);
        }
        // Excel导出类型判断：.xlsx 2007 及以上版本版本 Excel
        else if (ExcelConst.XLSX_SUFFIX.equalsIgnoreCase(exportExcelType)) {
            file = File.createTempFile(excelName, ExcelConst.XLSX_SUFFIX);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 导出Excel 2007 以上版本 方法
            excelUtil.toSXSSFExcel(dataList, titleName, new SXSSFDefaultHeadCellStyle(titleName, lastRow, lastCol), fileOutputStream);
        } else {
            throw new DataVerifyException("导出Excel类型配置不正确:exportExcelType:" + exportExcelType);
        }
        return file;
    }
}
