package com.sinosoft.fileserver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sinosoft.fileserver.utils.FileServerHelper;
public class TestFileHelp {
	private static final String fileServerURL = "http://127.0.0.1:8091/fileserver";
	
	@Test
	//测试上传文件
	public void TestUpload(){
		Map<String, String> otherParams = new HashMap<String,String>();		
		try {
			otherParams.put("userCode", "test001");
			otherParams.put("systemId", "agri/tempfile");
			otherParams.put("bussType", "bill");
			//1、页面业务数据上传无需设置filepath属性，系统根据systemId、bussTypes设置目录结构，每一层下再创建日期文件夹
			//2、系统生成文件按照 文件生成规则上传文件系统
			//String filePath = "bill/20170712/UPTC002017070618092300001.xlsx";
			/*String filePath = "bill/20170712/";
			otherParams.put("filePath", filePath);*/
			//otherParams.put("filePath", "ls/001.log");
			
			
			Map<String,String> fileResult = FileServerHelper.uploadFile(fileServerURL+"/uploadFile", new File("D:\\机构统计.xlsx"), otherParams );
			System.out.println(JSON.toJSONString(fileResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//下载文件
	@Test
	public void TestDownFile() {
		Map<String,String> otherParams=new HashMap<String,String>();
		try {
			otherParams.put("fileId", "757f8028130f48e39651b235cd6a1271");
			FileServerHelper.dowloadFileByFileId(fileServerURL+"/downloadFile",
					new File("C:\\Users\\zkr21\\Desktop\\sasas23a.java"),otherParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	//生成短连接
	@Test
	public  void TestGenShortFileURL() {
		Map<String,String> otherParams=new HashMap<String,String>();
		try {
			otherParams.put("userCode", "102912121");
			otherParams.put("fileId", "beef13c5c045494b83c3e5fb533a6774");
			otherParams.put("validWhenLong", "360000");
//			otherParams.put("invalidTime", "2018-10-20 22:24:30");
			Map<String, String> res=FileServerHelper.sendPost(fileServerURL+"/generateFileShortLink",otherParams);
			System.out.println(res);
			System.out.println(fileServerURL+"/downloadFileByShortLinkId?shortLinkId="+res.get("shortLinkId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//移动文件
	@Test
	public void TestMoveFile() {
		Map<String,String> otherParams=new HashMap<String,String>();
		try {
			otherParams.put("userCode", "102912121");
			otherParams.put("fileId", "72814a9014be49819d7e5b7027ce2602");
			otherParams.put("targetPath", "ls/002.log");
			FileServerHelper.sendPost(fileServerURL+"/moveFile",otherParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	//备份文件
}
