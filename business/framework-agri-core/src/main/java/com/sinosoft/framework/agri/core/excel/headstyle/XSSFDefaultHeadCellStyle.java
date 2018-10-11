package com.sinosoft.framework.agri.core.excel.headstyle;

import com.sinosoft.framework.agri.core.excel.hanlder.XSSFExportHandler;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * 导出 Excel 97-2003 版本的表格的默认头样式
 * @Author: 何伟东
 * @Date: 2017/11/24 10:26
 */
public class XSSFDefaultHeadCellStyle implements XSSFExportHandler {

    /** 标题名称 */
    private String titleName;
    /** 合并单元格的最后一行 */
    private int lastRow;
    /** 合并单元格的最后一列 */
    private int lastCol;

    /**
     * 默认设置标题名称“国元保险”;默认单元格不合并
     * @author: 何伟东
     * @date: 2017/11/24 10:21
     */
    public XSSFDefaultHeadCellStyle() {
        this.titleName = "国元保险";
        this.lastRow = 0;
        this.lastCol = 0;
    }

    /**
     * 预设置表头内容，以及单元格合并
     * @author: 何伟东
     * @date: 2017/11/24 10:22
     * @param titleName 表头标题
     * @param lastRow 合并单元格最后一行行数，从0开始
     * @param lastCol 合并单元格最后一列列数，从0开始
     */
    public XSSFDefaultHeadCellStyle(String titleName, int lastRow, int lastCol) {
        this.titleName = titleName;
        this.lastRow = lastRow;
        this.lastCol = lastCol;
    }

    /**
     * 设置单元格格式回调方法
     * @author: 何伟东
     * @date: 2017/11/24 10:23
     * @param workbook 工作簿对象
     * @param sheet sheet页对象
     * @return List<Object>;size=2;[1]CellStyle样式对象[2]lastRow合并单元的最后一行坐标
     */
    @Override
    public List<Object> headCellStyle(XSSFWorkbook workbook, XSSFSheet sheet) {
        List<Object> objects = new ArrayList<>();
        // 标题行的样式
        CellStyle cellStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        // 表头的样式
        CellStyle cellStyle1 = workbook.createCellStyle();
        Font headFont = workbook.createFont();

        CellRangeAddress cra = new CellRangeAddress(0,lastRow,0,lastCol);
        sheet.addMergedRegion(cra);
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        headFont.setFontName("宋体");
        //字体高度
        headFont.setFontHeightInPoints((short) 11);
        cellStyle1.setFont(headFont);
        cell.setCellValue(titleName);
        cell.setCellStyle(cellStyle1);

        cellStyle.setFillForegroundColor(HSSFColor.BLUE.index);
        // 填充模式
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // 自动换行
        cellStyle.setWrapText(true);
        // 上边框为细边框
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        // 右边框为细边框
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        // 下边框为细边框
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        // 左边框为细边框
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        // 水平对齐
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // 垂直对齐
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillBackgroundColor(HSSFColor.GREEN.index);
        //字体高度
        titleFont.setFontHeightInPoints((short) 11);
        titleFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        titleFont.setColor(HSSFColor.WHITE.index);
        titleFont.setFontName("宋体");
        // 应用标题字体到标题样式
        cellStyle.setFont(titleFont);
        //设置单元格文本形式
        DataFormat dataFormat =  workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        objects.add(cellStyle);
        objects.add(lastRow);
        return objects;
    }
}
