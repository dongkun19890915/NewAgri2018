package com.sinosoft.agriclaim.core.claimmanage.utils;

import com.sinosoft.framework.core.utils.DateUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.FontKey;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.PdfFont;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * @Description: 单证打印工具类
 * @Author: sucong
 * @Date: 2017/9/3
 */

public class PrintUtil {

    /**
     * @description 单张列印方法
     * @param list
     * @param params
     * @param response
     * @throws Exception
     * @author sucong
     * @date 2017/9/3 16:44
     */
    public void printReportPdf(List list, Map<String,Object> params, HttpServletResponse response) throws Exception
    {
        if(list == null){
            list = new ArrayList<Object>();
            list.add(new Object());
        }
        if(list.isEmpty()){
            list.add(new Object());
        }
        try{
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
            String templetPath = (String) params.get("templetPath");
            JasperPrint jprint = JasperFillManager.fillReport(templetPath, params, jrDataSource);
            JRPdfExporter exporter = new JRPdfExporter();
            Map<FontKey,PdfFont> fontsMap = new HashMap<FontKey,PdfFont>();
            //此处用黑体代表STSong-Light在pdf中的粗体，模板中选择的字体需要是黑体
            fontsMap.put(new FontKey("黑体", true, false), new PdfFont("STSong-Light",  "UniGB-UCS2-H", true, true, false));
            exporter.setParameter(JRExporterParameter.FONT_MAP, fontsMap);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exporter.exportReport();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @description 多张列印方法
     * @param listMap
     * @param n
     * @param response
     * @throws Exception
     * @author sucong
     * @date 2017/9/3 16:44
     */
    public static void printReportPdfMore(List<Map<String,Object>> listMap, int n, HttpServletResponse response) throws Exception {
        ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        InputStream inputStream;
        for(int j =0; j<n; j++){
            for (int i = 0; i < listMap.size(); i++) {
                inputStream = (InputStream) listMap.get(i).get("templetPath");
                ArrayList list;
                list=(ArrayList)listMap.get(i).get("list");
                if(list==null || list.size()==0){
                    list=new ArrayList();
                    list.add(new Object());
                }
                JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
                JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
                jasperPrintList.add(JasperFillManager.fillReport(jasperReport, listMap.get(i), jrDataSource));
            }
        }
        JRPdfExporter exporter = new JRPdfExporter();
        Map<FontKey,PdfFont> fontsMap = new HashMap<FontKey,PdfFont>();
        //此处用黑体代表STSong-Light在pdf中的粗体，模板中选择的字体需要是黑体
        fontsMap.put(new FontKey("黑体", true, false), new PdfFont("STSong-Light",  "UniGB-UCS2-H", true, true, false));
        exporter.setParameter(JRExporterParameter.FONT_MAP, fontsMap);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
        exporter.exportReport();
    }

    /**
     * @description 转化日期
     * @param date yyyy-MM-dd
     * @return yyyy年MM月dd日
     * @author sucong
     * @date 2017/9/3 16:44
     */
    public static String formatDateStr(String date){
        if(date!=null && !"".equals(date)){
            String dateArr[] = date.split("-");
            return dateArr[0]+"年"+dateArr[1]+"月"+dateArr[2]+"日";
        }else{
            return "";
        }
    }

    /**
     * @description 转化日期
     * @param date yyyy-MM-dd
     * @return yyyy年MM月dd日
     * @author sucong
     * @date 2017/9/3 16:44
     */
    public static String formatDate(Date date){
        if(date!=null){
            String strDate = DateUtils.formatDate(date);
            String dateArr[] = strDate.split("-");
            return dateArr[0]+"年"+dateArr[1]+"月"+dateArr[2]+"日";
        }else{
            return "";
        }
    }
}
