
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sinosoft.fileserver.client.FileServerHelper;
public class TestFileHelp {
	private static final String fileServerURL = "http://127.0.0.1:7001/fileserver-server";
	
	@Test
	//测试上传文件
	public void TestUpload(){
		Map<String, String> otherParams = new HashMap<String,String>();		
		try {
			otherParams.put("userCode", "102912121");
			otherParams.put("systemId", "agri/tempfile");
			otherParams.put("bussType", "clearingfile");
			Map<String,String> fileResult = FileServerHelper.uploadFile(fileServerURL+"/uploadFile", new File("/home/unhappydepig/1.txt"),otherParams );
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
