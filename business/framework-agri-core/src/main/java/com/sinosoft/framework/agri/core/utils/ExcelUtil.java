package com.sinosoft.framework.agri.core.utils;


import com.sinosoft.framework.agri.core.excel.ExcelReader;
import com.sinosoft.framework.agri.core.excel.POIUtils;
import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.agri.core.excel.convert.ExportConvert;
import com.sinosoft.framework.agri.core.excel.convert.ExportRange;
import com.sinosoft.framework.agri.core.excel.hanlder.HSSFExportHandler;
import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.agri.core.excel.hanlder.SXSSFExportHandler;
import com.sinosoft.framework.agri.core.excel.hanlder.XSSFExportHandler;
import com.sinosoft.framework.agri.core.excel.pojo.ExportItem;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Excel快速导入导出工具
 * @Author: 何伟东
 * @Date: 2017/11/16 14:06
 */
public class ExcelUtil {
    private static Logger log = Logger.getLogger(ExcelUtil.class);

    private Class<?> mClass = null;
    /** 默认以此值填充空单元格,可通过 setEmptyCellValue(string)改变其默认值。 */
    private String mEmptyCellValue = null;
    /** 分Sheet机制：每个Sheet最多多少条数据 */
    private Integer mMaxSheetRecords = 30000;
    /** 缓存数据格式器实例,避免多次使用反射进行实例化*/
    private Map<String, ExportConvert> mConvertInstanceCache = new HashMap<>();
    /** 读取Excel时的起始行数，从0开始，默认为0*/
    private Integer startRowNumber = 0;

    private ExcelUtil() {
    }

    private ExcelUtil(Class<?> clazz) {
        this.mClass = clazz;
    }

    /**
     * 用于导出Excel文件时，初始化工具类
     * @author: 何伟东
     * @date: 2017/11/24 11:11
     * @param clazz 实体Class对象
     * @return ExcelUtil 本类对象
     */
    public static ExcelUtil initBuilder(Class<?> clazz) {
        return new ExcelUtil(clazz);
    }

    /**
     * 用于导入数据解析
     * @author: 何伟东
     * @date: 2017/11/24 11:11
     * @return ExcelUtil 本类对象
     */
    public static ExcelUtil initImport() {
        return new ExcelUtil();
    }

    /**
     * 读取Excel时以该值填充空单元格值 (默认null)
     * @author: 何伟东
     * @date: 2017/11/24 11:10
     * @param emptyCellValue 单元格值
     * @return this 本类对象
     */
    public ExcelUtil setEmptyCellValue(String emptyCellValue) {
        this.mEmptyCellValue = emptyCellValue;
        return this;
    }

    /**
     * 读取Excel时从该行开始读取内容，从0开始，默认0
     * @author: 何伟东
     * @date: 2017/11/24 11:07
     * @param startRowNumber 起始行数
     * @return this 本类对象
     */
    public ExcelUtil setStartRowNumber(Integer startRowNumber){
        this.startRowNumber = startRowNumber;
        return this;
    }

    /**
     * 分Sheet机制：每个Sheet最多多少条数据(默认30000)
     * @author: 何伟东
     * @date: 2017/11/24 11:07
     * @param size 数据条数
     * @return this 本类对象
     */
    public ExcelUtil setMaxSheetRecords(Integer size) {
        this.mMaxSheetRecords = size;
        return this;
    }

    /**
     * 导出Excel 2007（数据量较大的Excel） 以上版本的方法,相对toXSSFExcel方法速度较快推荐使用此方法
     * @author: 何伟东
     * @date: 2017/11/24 11:03
     * @param data 导出Excel的数据
     * @param sheetName sheet的名称
     * @param handler 标题行样式
     * @param out 文件输出流
     * @return 成功-true，失败-false
     */
    public boolean toSXSSFExcel(List<?> data, String sheetName, SXSSFExportHandler handler, OutputStream out) throws Exception {
        requiredBuilderParams();
        long begin = System.currentTimeMillis();
        List<ExportItem> exportItems = this.initExportItem(data);
        if (exportItems==null){
            return false;
        }
        // 创建新的工作薄。
        SXSSFWorkbook wb = POIUtils.newSXSSFWorkbook();
        // 取出一共有多少个sheet.
        double sheetNo = Math.ceil(data.size() / mMaxSheetRecords);
        // 多sheet生成填充数据
        for (int index = 0; index <= (sheetNo == 0.0 ? sheetNo : sheetNo - 1); index++) {
            // 创建Sheet页
            SXSSFSheet sheet = POIUtils.newSXSSFSheet(wb, sheetName + (index == 0 ? "" : "_" + index));
            // 获取表头样式以及表头行数
            List<Object> objects = handler.headCellStyle(wb, sheet);
            if (objects == null || objects.size() < 2) {
                throw new DataVerifyException("表头样式回调方法返回参数为空或不足！");
            } else {
                if (!(objects.get(0) instanceof CellStyle)) {
                    throw new DataVerifyException("表头样式回调方法返回的list中第一个参数不是CellStyle！");
                }
            }
            CellStyle headStyle = (CellStyle) objects.get(0);
            int rowNumber = (int) objects.get(1);
            // 创建表头
            SXSSFRow headerRow = POIUtils.newSXSSFRow(sheet, rowNumber+1);
            for (int i = 0; i < exportItems.size(); i++) {
                SXSSFCell cell = POIUtils.newSXSSFCell(headerRow, i);
                POIUtils.setColumnWidth(sheet, i, exportItems.get(i).getWidth(), exportItems.get(i).getDisplay());
                cell.setCellValue(exportItems.get(i).getDisplay());
                if (headStyle != null) {
                    cell.setCellStyle(headStyle);
                }
                //设置下拉列表 下拉格式不是针对整列的需要指定生效的行数 所以我设置的是和数据数量一样的行数，也可以改成mMaxSheetRecords,如果要生成导出模板我的建议增加一个注解这个数量 设置成变量
                String range = exportItems.get(i).getRange();
                if (!"".equals(range)){
                    String[] ranges = rangeCellValues(range);
                    POIUtils.setHSSFValidation(sheet,ranges,1,data.size(),i,i);
                }
            }
            // 产生数据行
            if (data.size() > 0) {
                int startNo = index * mMaxSheetRecords;
                int endNo = Math.min(startNo + mMaxSheetRecords, data.size());
                CellStyle bodyStyle = wb.createCellStyle();
                Font font = wb.createFont();
                for (int i = startNo; i < endNo; i++) {
                    SXSSFRow bodyRow = POIUtils.newSXSSFRow(sheet, i + rowNumber + 2 - startNo);

                    for (int j = 0; j < exportItems.size(); j++) {
                        // 处理单元格值
                        String cellValue = exportItems.get(j).getReplace();
                        if ("".equals(cellValue)) {
                            cellValue = BeanUtils.getProperty(data.get(i), exportItems.get(j).getField());
                        }
                        // 格式化单元格值
                        if (!"".equals(exportItems.get(j).getConvert())) {
                            cellValue = convertCellValue(Integer.parseInt(cellValue), exportItems.get(j).getConvert());
                        }
                        // 单元格宽度
                        POIUtils.setColumnWidth(sheet, j, exportItems.get(j).getWidth(), cellValue);
                        SXSSFCell cell = POIUtils.newSXSSFCell(bodyRow, j);
                        // fix: 当值为“”时,当前index的cell会失效
                        cell.setCellValue(StringUtils.isEmpty(cellValue) ? mEmptyCellValue : cellValue);
                        POIUtils.setCellBodyStyle(wb,bodyStyle,font,exportItems.get(j).getColor());
                        cell.setCellStyle(bodyStyle);
                        cell.setCellType(SXSSFCell.CELL_TYPE_STRING);
                    }
                }
            }
        }
        try {
            POIUtils.writeSXSSFByLocal(wb, out);
        } catch (Exception e) {
            log.error("生成Excel文件失败:" + e.getMessage(), e);
            throw e;
        }
        log.info(String.format("Excel处理完成,共生成数据:%s行 (不包含表头),耗时：%s seconds.", (data != null ? data.size() : 0),
                (System.currentTimeMillis() - begin) / 1000F));
        return true;
    }

    /**
     * 导出Excel 97-2003 版本的方法
     * @author: 何伟东
     * @date: 2017/11/24 11:03
     * @param data 导出Excel的数据
     * @param sheetName sheet的名称
     * @param handler 标题行样式
     * @param out 文件输出流
     * @return 成功-true，失败-false
     */
    public boolean toHSSFExcel(List<?> data, String sheetName, HSSFExportHandler handler, OutputStream out) throws Exception {
        requiredBuilderParams();
        long begin = System.currentTimeMillis();
        List<ExportItem> exportItemList = this.initExportItem(data);
        if (exportItemList==null){
            return false;
        }
        //创建一个新的工作簿
        HSSFWorkbook hssfWorkbook = POIUtils.newHSSFWorkbook();
        double sheetNo = Math.ceil(data.size() / mMaxSheetRecords);
        // =====多sheet生成填充数据=====
        for (int index = 0; index <= (sheetNo == 0.0 ? sheetNo : sheetNo - 1); index++) {
            //创建sheet页
            HSSFSheet hssfSheet = POIUtils.newHSSFSheet(hssfWorkbook, sheetName + (index == 0 ? "" : "_" + index));
            // 获取表头样式以及表头行数
            List<Object> objects = handler.headCellStyle(hssfWorkbook, hssfSheet);
            CellStyle headCellStyle = (CellStyle) objects.get(0);
            int rowNumber = (int) objects.get(1);
            //创建表头
            HSSFRow headRow = POIUtils.newHSSFRow(hssfSheet, rowNumber+1);
            for (int i = 0; i < exportItemList.size(); i++) {
                HSSFCell headCell = POIUtils.newHSSFCell(headRow, i);
                POIUtils.setHSSFColumnWidth(hssfSheet,i,exportItemList.get(i).getWidth(),exportItemList.get(i).getDisplay());
                headCell.setCellValue(exportItemList.get(i).getDisplay());
                if (headCellStyle != null){
                    headCell.setCellStyle(headCellStyle);
                }
            }
            // 产生数据行
            if (data.size() > 0) {
                int startNo = index * mMaxSheetRecords;
                int endNo = Math.min(startNo + mMaxSheetRecords, data.size());
                HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
                HSSFFont font = hssfWorkbook.createFont();
                cellStyle.setFont(font);
                for (int i = startNo; i < endNo; i++) {
                    HSSFRow bodyRow = POIUtils.newHSSFRow(hssfSheet, i + rowNumber + 2 - startNo);
                    for (int j = 0; j < exportItemList.size(); j++) {
                        // 处理单元格值
                        String cellValue = exportItemList.get(j).getReplace();
                        if ("".equals(cellValue)) {
                            cellValue = BeanUtils.getProperty(data.get(i), exportItemList.get(j).getField());
                        }
                        // 格式化单元格值
                        if (!"".equals(exportItemList.get(j).getConvert())) {
                            cellValue = convertCellValue(Integer.parseInt(cellValue), exportItemList.get(j).getConvert());
                        }
                        // 单元格宽度
                        HSSFCell bodyCell = POIUtils.newHSSFCell(bodyRow, j);
                        POIUtils.setCellBodyStyle(hssfWorkbook,cellStyle,font,exportItemList.get(j).getColor());
                        bodyCell.setCellValue(StringUtils.isEmpty(cellValue) ? mEmptyCellValue : cellValue);
                        bodyCell.setCellStyle(cellStyle);
                        bodyCell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                }
            }
        }
        try {
            POIUtils.writeHSSFByLocal(hssfWorkbook, out);
        } catch (Exception e) {
            log.error("生成Excel文件失败:" + e.getMessage(), e);
            throw e;
        }
        log.info(String.format("Excel处理完成,共生成数据:%s行 (不包含表头),耗时：%s seconds.", (data != null ? data.size() : 0),
                (System.currentTimeMillis() - begin) / 1000F));
        return true;
    }

    /**
     * 导出Excel 2007（普通数据量Excel） 以上版本的方法,相对toSXSSFExcel方法速度较慢不推荐使用此方法
     * @author: 何伟东
     * @date: 2017/11/24 11:02
     * @param data 导出Excel的数据
     * @param sheetName sheet的名称
     * @param handler 标题行样式
     * @param out 文件输出流
     * @return 成功-true，失败-false
     */
    @Deprecated
    public boolean toXSSFExcel(List<?> data, String sheetName, XSSFExportHandler handler, OutputStream out) throws Exception {
        requiredBuilderParams();
        long begin = System.currentTimeMillis();
        List<ExportItem> exportItemList = this.initExportItem(data);
        if (exportItemList==null){
            return false;
        }
        //创建一个新的工作簿
        XSSFWorkbook xssfWorkbook = POIUtils.newXSSFWorkbook();
        double sheetNo = Math.ceil(data.size() / mMaxSheetRecords);
        // =====多sheet生成填充数据=====
        for (int index = 0; index <= (sheetNo == 0.0 ? sheetNo : sheetNo - 1); index++) {
            //创建sheet页
            XSSFSheet xssfSheet = POIUtils.newXSSFSheet(xssfWorkbook, sheetName + (index == 0 ? "" : "_" + index));
            List<Object> objects = handler.headCellStyle(xssfWorkbook, xssfSheet);
            CellStyle headStyle = (CellStyle) objects.get(0);
            int rowNumber = (int) objects.get(1);
            //创建表头
            XSSFRow headRow = POIUtils.newXSSFRow(xssfSheet, rowNumber+1);
            for (int i = 0; i < exportItemList.size(); i++) {
                XSSFCell headCell = POIUtils.newXSSFCell(headRow, i);
                POIUtils.setXSSFColumnWidth(xssfSheet,i,exportItemList.get(i).getWidth(),exportItemList.get(i).getDisplay());
                headCell.setCellValue(exportItemList.get(i).getDisplay());
                if (headStyle != null){
                    headCell.setCellStyle(headStyle);
                }
            }
            // 产生数据行
            if (data.size() > 0) {
                int startNo = index * mMaxSheetRecords;
                int endNo = Math.min(startNo + mMaxSheetRecords, data.size());
                XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
                XSSFFont font = xssfWorkbook.createFont();
                cellStyle.setFont(font);
                for (int i = startNo; i < endNo; i++) {
                    XSSFRow bodyRow = POIUtils.newXSSFRow(xssfSheet, i + rowNumber + 2 - startNo);
                    //设置单元格为文本格式 主要是为了方面处理 日期等特殊格式
                    DataFormat dataFormat = xssfWorkbook.createDataFormat();
                    cellStyle.setDataFormat(dataFormat.getFormat("@"));
                    for (int j = 0; j < exportItemList.size(); j++) {
                        // 处理单元格值
                        String cellValue = exportItemList.get(j).getReplace();
                        if ("".equals(cellValue)) {
                            cellValue = BeanUtils.getProperty(data.get(i), exportItemList.get(j).getField());
                        }
                        // 格式化单元格值
                        if (!"".equals(exportItemList.get(j).getConvert())) {
                            cellValue = convertCellValue(Integer.parseInt(cellValue), exportItemList.get(j).getConvert());
                        }
                        // 单元格宽度
                        XSSFCell bodyCell = POIUtils.newXSSFCell(bodyRow, j);
                        bodyCell.setCellValue(StringUtils.isEmpty(cellValue) ? mEmptyCellValue : cellValue);
                        POIUtils.setCellBodyStyle(xssfWorkbook,cellStyle,font,exportItemList.get(j).getColor());
                        bodyCell.setCellStyle(cellStyle);
                        bodyCell.setCellType(XSSFCell.CELL_TYPE_STRING);
                    }
                }

            }
        }
        try {
            POIUtils.writeXSSFByLocal(xssfWorkbook, out);
        } catch (Exception e) {
            log.error("生成Excel文件失败:" + e.getMessage(), e);
            throw e;
        }
        log.info(String.format("Excel处理完成,共生成数据:%s行 (不包含表头),耗时：%s seconds.", (data != null ? data.size() : 0),
                (System.currentTimeMillis() - begin) / 1000F));
        return true;
    }

    /**
     * 初始化ExportItem
     * @author: 何伟东
     * @date: 2017/11/16 15:39
     * @param data 需要导出的数据
     * @return List<ExportItem> 需要导出的数据明细
     */
    private List<ExportItem> initExportItem(List<?> data){
        if (data == null || data.size() < 1) {
            log.error("没有检测到数据,不执行导出操作。");
            return null;
        }
        log.info(String.format("即将导出excel数据：%s条,请稍后..", data.size()));
        // 导出列查询。
        ExportConfig currentExportConfig = null;
        ExportItem currentExportItem = null;
        List<ExportItem> exportItems = new ArrayList<>();
        for (Field field : mClass.getDeclaredFields()) {
            currentExportConfig = field.getAnnotation(ExportConfig.class);
            if (currentExportConfig != null && currentExportConfig.enabled()) {
                currentExportItem = new ExportItem()
                        .setField(field.getName())
                        .setDisplay("field".equals(currentExportConfig.value()) ? field.getName() : currentExportConfig.value())
                        .setWidth(currentExportConfig.width())
                        .setConvert(currentExportConfig.convert())
                        .setColor(currentExportConfig.color())
                        .setRange(currentExportConfig.range())
                        .setReplace(currentExportConfig.replace());
                exportItems.add(currentExportItem);
                Method[] declaredMethods = mClass.getDeclaredMethods();
            }
            currentExportItem = null;
            currentExportConfig = null;
        }
        return exportItems;
    }

    /**
     * 读取Excel所有sheet页数据
     * @author: 何伟东
     * @date: 2017/11/24 11:00
     * @param excelFile excel文件
     * @param handler 数据处理回调
     */
    public void readExcel(File excelFile, ReadHandler handler) throws Exception {
        this.readExcel(excelFile, -1, handler);
    }

    /**
     * 读取Excel（使用SAX的方式进行解析,读取指定Sheet数据）
     * @author: 何伟东
     * @date: 2017/11/24 10:57
     * @param excelFile excel文件
     * @param sheetIndex sheet索引,-1为读取所有
     * @param handler 数据处理回调
     */
    public void readExcel(File excelFile, int sheetIndex, ReadHandler handler) throws Exception {
        long begin = System.currentTimeMillis();
        String fileName = excelFile.getAbsolutePath();
        ExcelReader reader = new ExcelReader(handler);
        try {
            if (sheetIndex >= 0) {
                // 读取指定sheet
                reader.process(startRowNumber,fileName, sheetIndex);
            } else {
                // 读取所有sheet
                reader.process(fileName,startRowNumber);
            }
        } catch (Exception e) {
            log.error("读取excel文件时发生异常：" + e.getMessage(), e);
            throw e;
        }
        log.info(String.format("Excel读取并处理完成,耗时：%s seconds.", (System.currentTimeMillis() - begin) / 1000F));
    }

    /**
     * 键值对字符串解析(例如：s:1=男,2=女)
     * @author: 何伟东
     * @date: 2017/11/24 10:54
     * @param oldValue 对象的值
     * @param format 映射值的数组
     * @return 转换后的值
     */
    private String convertCellValue(Integer oldValue, String format) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        try {
            String protocol = format.split(":")[0];
            // 键值对字符串解析：s:1=男,2=女
            if ("s".equalsIgnoreCase(protocol)) {

                String[] pattern = format.split(":")[1].split(",");
                for (String p : pattern) {
                    String[] cp = p.split("=");
                    if (Integer.parseInt(cp[0]) == oldValue) {
                        return cp[1];
                    }
                }
            }
            if ("c".equalsIgnoreCase(protocol)) {
                String clazz = format.split(":")[1];
                ExportConvert export = mConvertInstanceCache.get(clazz);
                if (export == null) {
                    export = (ExportConvert) Class.forName(clazz).newInstance();
                    mConvertInstanceCache.put(clazz, export);
                }
                if (mConvertInstanceCache.size() > 10) {
                    mConvertInstanceCache.clear();
                }
                return export.handler(oldValue);
            }
        } catch (Exception e) {
            log.error("出现问题,可能是@ExportConfig.format()的值不规范导致。", e);
            throw e;
        }
        return String.valueOf(oldValue);
    }

    /**
     * 填充下拉数据验证(maxcess)
     * @author: 何伟东
     * @date: 2017/11/24 10:53
     * @param format 下拉框的内容
     * @return 拆分后的数组
     */
	private String[] rangeCellValues(String format) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        try {
            String protocol = format.split(":")[0];
            if ("c".equalsIgnoreCase(protocol)) {
                String clazz = format.split(":")[1];
                ExportRange export = (ExportRange) Class.forName(clazz).newInstance();
                if (export != null) {
                	return export.handler();
                }
            }
        } catch (Exception e) {
            log.error("出现问题,可能是@ExportConfig.range()的值不规范导致。", e);
            throw e;
        }
        return new String[]{};
    }

    /**
     * 校验导出Excel时是否正确初始化对象
     * @author: 何伟东
     * @date: 2017/11/24 10:58
     */
    private void requiredBuilderParams() {
        if (mClass == null) {
            throw new DataVerifyException("请先使用ExcelUtil.initBuilder(Class<?>)构造器初始化参数。");
        }
    }

}
