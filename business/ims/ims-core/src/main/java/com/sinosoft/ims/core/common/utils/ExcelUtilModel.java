package com.sinosoft.ims.core.common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.sinosoft.framework.exception.BusinessException;


/**
 * @description Excel工具类
 * @author hzhongkai
 * @date 2016年10月11日上午10:41:27
 */
public class ExcelUtilModel
{
    private static final Log LOGGER = LogFactory.getLog(ExcelUtilModel.class);

    /** workbook_2003 */
    private HSSFWorkbook workbook_2003; // excel 2003的workbook
    /** workbook_2007 */

//     private XSSFWorkbook workbook_2007; // excel 2007以及后版本的workbook
    /** 默认的sheet名称:"Sheet1" */
    private final String DEFAULTSHEETNAME = "Sheet1";

    /** 序号 sericalNumber */
    public static String SERICALNUMBER = "sericalNumber";

    /**
     * @description 创建一个2003工作簿，拥有一个工作表sheetName，包含标题、表头、数据
     * @param sheetName
     *            工作表名称
     * @param title
     *            第一行需要展示的列标题名称
     * @param columnKeys
     *            表头
     * @param data
     *            数据
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:40:39
     */
    public HSSFWorkbook creatXlsWithList(String sheetName, String title,
                                         LinkedHashMap<String, String> columnKeys,
                                         List<Map<String, Object>> data)
    {
        setTitle_03(sheetName, title, columnKeys);
        addData_03(sheetName, columnKeys, data);
        return this.workbook_2003;
    }


    
    
    /**
     * @description 创建Excel文件,并指定下载地址
     * @param fileName
     * @param wb
     * @param url
     * @throws IOException
     * @author hzhongkai
     * @return 
     * @date 2016年10月12日上午10:47:32
     */
    public Map<String, String> createExcelFile(String fileName, Workbook wb,String url,Map<String,String> otherParams)
        throws IOException
    {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        
        File file = new File(fileName);
        try
        {
          // return FileServerHelper.uploadFile(url, file, otherParams);
            return otherParams;
        }
        catch (Exception e)
        {
            throw new BusinessException("创建用户信息清单文件发生异常！");
        }
          
    }

    /**
     * @description 在模板文件后面添加数据（列名和数据）
     * @param sheetName
     * @param modelPath
     *            模板路径
     * @param columnKeys
     *            列名
     * @param data
     *            数据
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:39:44
     */
    public HSSFWorkbook modelAddData(String sheetName, String modelPath,
                                     LinkedHashMap<String, String> columnKeys,
                                     List<Map<String, Object>> data)
    {
        // 获取所读取excel模板的对象
        try
        {
            File file = new File(modelPath);
            if (!file.exists())
            {
                System.out.println("模板文件:" + modelPath + "不存在!");
            }
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            workbook_2003 = new HSSFWorkbook(fs);
        }
        catch (FileNotFoundException e)
        {
            LOGGER.error("模板文件不存在", e);
        }
        catch (IOException e)
        {
            LOGGER.error("IO异常", e);
        }
        // 在表的尾部追加数据 后面跟数据 单元格默认样式（12号 宋体 上下左右居中、有边框）
        addData_03(sheetName, columnKeys, data);
        return workbook_2003;
    }

    /**
     * @description Excel2003添加一个sheet 并且填充数据
     * @param workbook
     *            Excel2003文件
     * @param sheetName
     *            工作表名
     * @param columnKeys
     *            列名
     * @param data
     *            数据
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:39:10
     */
    public HSSFWorkbook addXlsSheetWithList(HSSFWorkbook workbook, String sheetName,
                                            LinkedHashMap<String, String> columnKeys,
                                            List<Map<String, Object>> data)
    {
        workbook.createSheet(sheetName);
        addData_03(sheetName, columnKeys, data);
        return workbook;
    }

    /**
     * @description 生成一个2003的工作簿，包含一个自定义表名的工作表
     * @param sheetName
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:37:48
     */
    private HSSFWorkbook createXls(String sheetName)
    {
        sheetName = sheetName == null || sheetName.length() <= 0 ? DEFAULTSHEETNAME : sheetName;
        this.workbook_2003 = new HSSFWorkbook();
        this.workbook_2003.createSheet(sheetName);
        return this.workbook_2003;
    }

    /**
     * @description 为指定工作表加入标题，第一行合并居中 默认标题样式 24号宋体
     * @param sheetName
     * @param title
     * @param columnKeys
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:37:29
     */
    private HSSFWorkbook setTitle_03(String sheetName, String title,
                                     LinkedHashMap<String, String> columnKeys)
    {
        sheetName = sheetName == null || sheetName.length() <= 0 ? DEFAULTSHEETNAME : sheetName;
        if (this.workbook_2003 == null)
        {
            createXls(sheetName);
        }
        HSSFSheet sheet = this.workbook_2003.getSheet(sheetName);
        HSSFRow firstRow = sheet.createRow(0);
        HSSFCell cell = firstRow.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCellStyle style = defaultTitleStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnKeys.size() - 1));
        cell.setCellValue(title);
        cell.setCellStyle(style);
        HSSFRow secondRow = sheet.createRow(1);// 第二行为空行
        // HSSFCell nullCell = secondRow.createCell(0, HSSFCell.CELL_TYPE_STRING);
        // nullCell.setCellValue("");
        return this.workbook_2003;
    }

    /**
     * 方法作用：在表的尾部追加数据，第一行表头，后面跟数据 单元格默认样式（12号 宋体 上下左右居中、有边框）
     * 
     * @param sheetName
     * @param columnKeys
     * @param data
     * @Author: 刘泽中
     * @Date: 2015年12月14日 上午11:07:18
     */
    private HSSFWorkbook addData_03(String sheetName, LinkedHashMap<String, String> columnKeys,
                                    List<Map<String, Object>> data)
    {
        sheetName = sheetName == null || sheetName.length() <= 0 ? DEFAULTSHEETNAME : sheetName;
        if (this.workbook_2003 == null)
        {
            createXls(sheetName);
        }
        HSSFSheet sheet = this.workbook_2003.getSheet(sheetName);
        if (sheet == null)
        {
            sheet = this.workbook_2003.createSheet(sheetName);
        }
        HSSFCellStyle bodyStyle = defaultStyle();
        int NumberOfExistRows = sheet.getPhysicalNumberOfRows();
        int NumberOfDateStartRow = NumberOfExistRows + 1;
        int NumberOfDateLimitRow = NumberOfDateStartRow + data.size();
        Iterator<String> keysIt = columnKeys.keySet().iterator();
        ArrayList<String> keysList = new ArrayList<String>();
        while (keysIt.hasNext())
        {
            keysList.add(keysIt.next());
        }
        HSSFRow firstRow = sheet.createRow(NumberOfExistRows);
        for (int i = 0; i < keysList.size(); i++ )
        {
            HSSFCell cell = firstRow.createCell(i, HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(columnKeys.get(keysList.get(i)));
            cell.setCellStyle(bodyStyle);
            sheet.autoSizeColumn((short)i); // 调整当前列宽度
        }
        for (int i = NumberOfDateStartRow; i < NumberOfDateLimitRow; i++ )
        {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < keysList.size(); j++ )
            {
                HSSFCell cell = row.createCell(j);
                Map<String, Object> rowMap = data.get(i - NumberOfDateStartRow);
                Object cellValue;
                if (keysList.get(j).equals(SERICALNUMBER))
                {
                    cellValue = i + 1 - NumberOfDateStartRow;
                }
                else
                {
                    cellValue = rowMap.get(keysList.get(j));
                }
                if (cellValue != null)
                {
                    if (cellValue instanceof Double)
                    {
                        cell.setCellValue(Double.parseDouble(cellValue.toString()));
                    }
                    else if (cellValue instanceof Integer)
                    {
                        cell.setCellValue(Double.parseDouble(cellValue.toString()));
                    }
                    else if (cellValue instanceof Float)
                    {
                        cell.setCellValue(Double.parseDouble(cellValue.toString()));
                    }
                    else if (cellValue instanceof Long)
                    {
                        cell.setCellValue(Double.parseDouble(cellValue.toString()));
                    }
                    else if (cellValue instanceof Number)
                    {
                        cell.setCellValue(Double.parseDouble(cellValue.toString()));
                    }
                    else if (cellValue instanceof Date)
                    {
                        cell.setCellValue(cellValue.toString().substring(0, 10));
                    }
                    else
                    {
                        cell.setCellValue(cellValue.toString());
                    }
                }
                else
                {
                    cell.setCellValue("");
                }
                cell.setCellStyle(bodyStyle);
                if (i == NumberOfDateLimitRow - 1)
                {
                    sheet.autoSizeColumn((short)j); // 调整当前列宽度
                }
            }
        }
        return this.workbook_2003;
    }

    /**
     * @description 默认样式（12号 宋体 上下左右居中、有边框）
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:36:11
     */
    private HSSFCellStyle defaultStyle()
    {
        HSSFFont font = this.workbook_2003.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)10);// 设置字体大小
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        return defaultStyle(font);
    }

    /**
     * @description 默认标题样式 24号宋体
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:36:30
     */
    private HSSFCellStyle defaultTitleStyle()
    {
        HSSFCellStyle style = this.workbook_2003.createCellStyle();
        HSSFFont font = this.workbook_2003.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)24);// 设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
        style.setFont(font);
        return style;
    }

    /**
     * @description 默认样式
     * @param font
     * @return
     * @author hzhongkai
     * @date 2016年10月11日上午10:36:42
     */
    private HSSFCellStyle defaultStyle(HSSFFont font)
    {
        HSSFCellStyle style = this.workbook_2003.createCellStyle();
        // 设置垂直居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        // 设置边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置长文本自动换行
        // style.setWrapText(true);
        style.setFont(font);
        return style;
    }

    
    /**
     * 从文件服务器下载文件
     * @return
     */
    
    /**
     * @description 从文件服务器下载文件，并写入到指定路径
     * @param downloadPath
     * @param fileName
     * @param fileId
     * @return
     * @author hzhongkai
     * @date 2016年10月14日下午2:00:23
     */
    public String downLoadFromFileServ(String downloadPath,String fileName,String fileId){
        Map<String,String> params=new HashMap<String,String>();
        String tempUrl = this.getClass().getClassLoader().getResource("/").getPath(); 
        System.err.println("====================tempUrl========================"+tempUrl);
        File file = new File(tempUrl+"temp");
        if (!file.exists()) {
             file.mkdir();
        }
        String excelPath = tempUrl+File.separator + "temp"+File.separator + fileName+ ".xls";
        try
        {
            params.put("fileId", fileId);
            //FileServerHelper.dowloadFileByFileId(downloadPath, new File(excelPath),params);
            return excelPath;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
