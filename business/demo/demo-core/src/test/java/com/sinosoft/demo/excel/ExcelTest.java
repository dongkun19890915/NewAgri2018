package com.sinosoft.demo.excel;

import com.alibaba.fastjson.JSON;
import com.sinosoft.demo.core.customer.entity.PrpDuser;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.utils.UUIDUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description: excel导入导出 样例代码
* @Author: 周家伟
* @Date: 2017/10/30 下午3:25
*/
public class ExcelTest {
    /**
     * @description: excel导出样例代码
     * @author: 周家伟
     * @date: 2017/10/30 下午3:27
     */
    @Test
    public void exportTest(){
        List<PrpDuserDto> prpDuserDtoList = new ArrayList<>();
        PrpDuserDto prpDuserDto = new PrpDuserDto();
        prpDuserDto.setUserCode("001");
        prpDuserDto.setUserName("张三");
        prpDuserDto.setAge(20);
        prpDuserDto.setSex("男");
        PrpDuserDto prpDuserDto2 = new PrpDuserDto();
        prpDuserDto2.setUserCode("0022");
        prpDuserDto2.setUserName("李四");
        prpDuserDto2.setAge(21);
        prpDuserDto2.setSex("女");
        prpDuserDtoList.add(prpDuserDto);
        prpDuserDtoList.add(prpDuserDto2);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("测试第一个sheet页");
        HSSFRow headRow = hssfSheet.createRow((short)0);
        HSSFCell headCell = headRow.createCell(0);
        headCell.setCellValue("工号");
        HSSFCell headCell1 = headRow.createCell(1);
        headCell1.setCellValue("用户名");
        HSSFCell headCell2 = headRow.createCell(2);
        headCell2.setCellValue("年龄");
        HSSFCell headCell3 = headRow.createCell(3);
        headCell3.setCellValue("性别");

        for(short i = 0;i<prpDuserDtoList.size();i++){
            PrpDuserDto prpDuserDto1 = prpDuserDtoList.get(i);
            HSSFRow row = hssfSheet.createRow(i+1);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(prpDuserDto1.getUserCode());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(prpDuserDto1.getUserName());
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(prpDuserDto1.getAge());
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(prpDuserDto1.getSex());

        }
        FileOutputStream fileOut = null;
        try {
            System.out.println("UUIDUtil.create8Id()-"+UUIDUtil.create8Id());
            // 生成临时文件
            File tempFile = File.createTempFile("test",".xls");
            tempFile.deleteOnExit();

            fileOut = new FileOutputStream(tempFile);
            hssfWorkbook.write(fileOut);


            // 上传文件到fileserver
            Map<String,String> otherParams = new HashMap<String,String>();
            otherParams.put("userCode","0000000000");
            otherParams.put("systemId","demo");
            otherParams.put("bussType","test");
            //otherParams.put("filePath","/test6.txt");
            FileServerHelper helper = new FileServerHelper();
            Map<String,String> fileResult = helper.uploadFile("http://192.168.0.5:8080/fileserver-server/uploadFile", tempFile, otherParams);
            String fileid ="";
            if(fileResult!=null&&fileResult.get("fileId")!=null){
                fileid = fileResult.get("fileId");
            }

            System.out.println(JSON.toJSONString(fileResult));

            // 生成短链接
            Map<String,String> otherParams2=new HashMap<String,String>();
                otherParams2.put("userCode", "00000000");
                otherParams2.put("fileId", fileid);
                otherParams2.put("validWhenLong", "3600000");
//			otherParams.put("invalidTime", "2018-10-20 22:24:30");  //此参数默认不加，默认使用文件id作为文件存储名
                Map<String, String> res=FileServerHelper.sendPost("http://192.168.0.5:8080/fileserver-server/generateFileShortLink",otherParams2);
                System.out.println(res);
                System.out.println("点击以下地址下载文件：");
                System.out.println("http://192.168.0.5:8080/fileserver-server/downloadFileByShortLinkId?shortLinkId="+res.get("shortLinkId"));
                System.out.println(res);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOut.close();
                hssfWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
