package com.sinosoft.demo;

import com.alibaba.fastjson.JSON;
import com.sinosoft.fileserver.client.FileServerHelper;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileServerTest {
    public static void main(String[] args) throws Exception {
        //1.前端给后端传文件Home/jre/lib/libinstrument.dylib (0x1015314e0)
        //1.1.前端上传文件
        //1.2.后端下载解析
        //dowloadFileByFileId();

        //2后端给前端传文件
        //2.1文件上传
        //testUploadFile();
        //2.2生成短链接,返回给前端
        testGenerateFileShortLink();
    }
    public  static void testUploadFile() throws Exception {
        File file = new File("/Users/zhoujiawei/Desktop/123.xls");
        Map<String,String> otherParams = new HashMap<String,String>();
        otherParams.put("userCode","0000000000");
        otherParams.put("systemId","demo");
        otherParams.put("bussType","test");
        //otherParams.put("filePath","/test6.txt");
        FileServerHelper helper = new FileServerHelper();
        Map<String,String> fileResult = helper.uploadFile("http://192.168.0.5:8080/fileserver-server/uploadFile", file, otherParams);
        System.out.println(JSON.toJSONString(fileResult));
    }

    public static void dowloadFileByFileId() throws Exception {
        Map<String,String> otherParams=new HashMap<String,String>();
        try {
            otherParams.put("fileId", "003b8cfc970e4f9fada5d78311a0b67c");
            FileServerHelper.dowloadFileByFileId("http://192.168.0.5:8080/fileserver-server/downloadFile",new File("D:\\1.txt"),otherParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testGenerateFileShortLink() throws Exception {
        Map<String,String> otherParams=new HashMap<String,String>();
        try {
            otherParams.put("userCode", "00000000");
            otherParams.put("fileId", "96020d6c8be6403d82b131965603ff37");
            otherParams.put("validWhenLong", "3600000");
//			otherParams.put("invalidTime", "2018-10-20 22:24:30");  //此参数默认不加，默认使用文件id作为文件存储名
            Map<String, String> res=FileServerHelper.sendPost("http://192.168.0.5:8080/fileserver-server/generateFileShortLink",otherParams);
            System.out.println(res);
            System.out.println("http://192.168.0.5:8080/fileserver-server/downloadFileByShortLinkId?shortLinkId="+res.get("shortLinkId"));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
