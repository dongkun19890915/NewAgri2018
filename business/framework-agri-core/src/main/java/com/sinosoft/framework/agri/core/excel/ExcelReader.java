package com.sinosoft.framework.agri.core.excel;

import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取Excel的工具类，用回调方法的方式实现不同表格的个性化处理
 *
 * @Author: 何伟东
 * @Date: 2017/11/18 16:19
 */
public class ExcelReader {
    private int mSheetIndex = -1;
    private ReadHandler mReadHandler;

    /**
     * 创建ExcelReader实例时，需要指定回调方法的类
     *
     * @param handler 读取回调接口
     * @author: 何伟东
     * @date: 2017/11/18 16:02
     */
    public ExcelReader(ReadHandler handler) {
        this.mReadHandler = handler;
    }

    /**
     * 读取工作簿中所有的sheet页
     *
     * @param fileName       文件名
     * @param startRowNumber 起始行数
     * @throws Exception
     * @author: 何伟东
     * @date: 2017/11/18 16:03
     */
    public void process(String fileName, int startRowNumber) throws Exception {
        Workbook workbook = WorkbookFactory.create(new File(fileName));
        if (workbook instanceof HSSFWorkbook) {
            HSSFWorkbook hssfWorkbook = (HSSFWorkbook) workbook;
            processHSSFAll(hssfWorkbook, startRowNumber);
        } else if (workbook instanceof XSSFWorkbook) {
            XSSFWorkbook xssfWorkbook = (XSSFWorkbook) workbook;
            processXSSFAll(xssfWorkbook, startRowNumber);
        }
    }

    /**
     * 读取工作簿中指定的sheet页
     *
     * @param fileName   excel文件
     * @param sheetIndex 从0开始
     * @throws Exception
     * @author: 何伟东
     * @date: 2017/11/18 16:03
     */
    public void process(int startRowNumber, String fileName, int sheetIndex) throws Exception {
        Workbook workbook = WorkbookFactory.create(new File(fileName));
        if (workbook instanceof HSSFWorkbook) {
            HSSFWorkbook hssfWorkbook = (HSSFWorkbook) workbook;
            processByHSSFSheet(sheetIndex, hssfWorkbook, startRowNumber);
        } else if (workbook instanceof XSSFWorkbook) {
            XSSFWorkbook xssfWorkbook = (XSSFWorkbook) workbook;
            processByXSSFSheet(sheetIndex, xssfWorkbook, startRowNumber);
        }
    }

    /**
     * 从指定行开始读取excel 2007 以上版本中所有sheet页的内容
     *
     * @param xssfWorkbook   工作表对象
     * @param startRowNumber 从指定行开始读取
     * @author: 何伟东
     * @date: 2017/11/18 16:03
     */
    private void processXSSFAll(XSSFWorkbook xssfWorkbook, int startRowNumber) throws Exception {
        int numberOfSheets = xssfWorkbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
            mSheetIndex = i;
            this.readerXSSFRow(xssfSheet, startRowNumber);
        }
    }

    /**
     * 从指定行开始读取excel 97-2003 版本中所有sheet页的内容
     *
     * @param hssfWorkbook   工作表对象
     * @param startRowNumber 从指定行开始读取
     * @author: 何伟东
     * @date: 2017/11/18 16:07
     */
    private void processHSSFAll(HSSFWorkbook hssfWorkbook, int startRowNumber) throws Exception {
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(i);
            mSheetIndex = i;
            this.readerHSSFRow(hssfSheet, startRowNumber);
        }
    }

    /**
     * 从指定行开始读取excel 2007 以上版本中指定sheet页的内容
     *
     * @param sheetIndex     sheet页的页码，从0开始
     * @param xssfWorkbook   工作表对象
     * @param startRowNumber 开始行，从0开始
     * @author: 何伟东
     * @date: 2017/11/18 16:15
     */
    private void processByXSSFSheet(int sheetIndex, XSSFWorkbook xssfWorkbook, int startRowNumber) throws Exception {
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
        mSheetIndex = sheetIndex;
        this.readerXSSFRow(xssfSheet, startRowNumber);
    }

    /**
     * 从指定行开始读取excel 97-2003 版本中指定sheet页的内容
     *
     * @param sheetIndex     sheet页的页码，从0开始
     * @param hssfWorkbook   工作表对象
     * @param startRowNumber 开始行，从0开始
     * @author: 何伟东
     * @date: 2017/11/18 16:15
     */
    private void processByHSSFSheet(int sheetIndex, HSSFWorkbook hssfWorkbook, int startRowNumber) throws Exception {
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetIndex);
        mSheetIndex = sheetIndex;
        this.readerHSSFRow(hssfSheet, startRowNumber);
    }

    /**
     * 从指定行数开始读取97-2003版本Excel的sheet中所有内容
     *
     * @param hssfSheet      97-2003版本Excel的sheet页对象
     * @param startRowNumber 指定行数
     * @author: 何伟东
     * @date: 2017/11/18 16:09
     */
    private void readerHSSFRow(HSSFSheet hssfSheet, int startRowNumber) throws Exception {
        int sumRows = hssfSheet.getLastRowNum();
        if (startRowNumber > sumRows) {
            throw new DataVerifyException("sheet页[" + hssfSheet.getSheetName() + "]中仅有" + sumRows + "行数据，无法从第" + startRowNumber + "行开始读取！");
        }
        for (int i = startRowNumber; i <= sumRows; i++) {
            HSSFRow row = hssfSheet.getRow(i);
            if (row != null) {
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                List<String> rowList = new ArrayList<>();
                for (int j = 0; j < physicalNumberOfCells; j++) {
                    HSSFCell cell = row.getCell(j);
                    String cellValue;
                    if (cell == null) {
                        cellValue = "";
                    } else {
                        cellValue = getCellValue(cell);
                    }
                    rowList.add(cellValue);
                }
                mReadHandler.handler(mSheetIndex, i, rowList);
            }
        }

    }

    /**
     * 从指定行数开始读取2007 及以上版本Excel的sheet中所有内容
     *
     * @param xssfSheet      2007 及以上版本Excel的sheet页对象
     * @param startRowNumber 指定行数
     * @author: 何伟东
     * @date: 2017/11/18 16:09
     */
    private void readerXSSFRow(XSSFSheet xssfSheet, int startRowNumber) throws Exception {
        int sumRows = xssfSheet.getLastRowNum();
        if (startRowNumber > sumRows) {
            throw new DataVerifyException("sheet页[" + xssfSheet.getSheetName() + "]中仅有" + sumRows + "行数据，无法从第" + startRowNumber + "行开始读取！");
        }
        for (int i = startRowNumber; i <= sumRows; i++) {
            XSSFRow row = xssfSheet.getRow(i);
            if (row != null) {
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                List<String> rowList = new ArrayList<>();
                for (int j = 0; j < physicalNumberOfCells; j++) {
                    XSSFCell cell = row.getCell(j);
                    String cellValue = getCellValue(cell);
                    rowList.add(cellValue);
                }
                mReadHandler.handler(mSheetIndex, i, rowList);
            }
        }
    }

    /**
     * 获取单元格的值，并转换为string
     *
     * @param cell 单元格对象
     * @return
     */
    private String getCellValue(Cell cell) {
        String cellValue;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            default:
                cellValue = "";
                break;
        }
        return cellValue;
    }
}
