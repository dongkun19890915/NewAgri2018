package com.sinosoft.fileserver.client;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.framework.exception.BusinessException;
/**
 * @description 调用FileServer的工具类
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午2:43:23
 */
public class FileServerHelper {
//	private static final Logger LOGGER = LoggerFactory.getLogger(FileServerHelper.class);
	/**
	* @description 更新文件到文件服务器
	* @param url 超链接 http://fileserver.com/uploadFile
	* @param file 文件信息
	* @param otherParams 其他参数  userCode-用户代码/systemId-系统代码/bussType-业务类型/filePath-存储位置/fileName-文件存储名称(仅FTP/SFTP可用)
	* @return  resultCode-响应代码/fileId-文件ID
	* @throws Exception
	* @author 周建龙
	* @date 2016年10月6日下午6:49:20
	 */
	public static Map<String,String> uploadFile(String url,File file,Map<String,String> otherParams) throws Exception
	{
		String res1=HttpHelper.executeUploadFile(null, url, file,otherParams, "UTF-8", true);
//		LOGGER.error("上传返回值:{}",res1);
		if (res1==null||"".equals(res1.trim())) {	
			throw new BusinessException("文件服务响应失败!");
		}
		return dealResult(res1);
	}
	/**
	 * 
	* @description 下载文件到指定路径
	* @param  url 超链接 http://fileserver.com/downloadFile
	* @param  file 目标文件
	* @param  otherParams 其他参数 【fileId-文件ID】
	* @author 周建龙
	* @throws Exception 
	* @date 2016年10月7日上午11:17:42
	 */
	public static void dowloadFileByFileId(String url,File file,Map<String,String> otherParams) throws Exception
	{
		Set<String> ks=otherParams.keySet();
		url+="?";
		for (String key : ks) {
			url+=key+"="+otherParams.get(key)+"&";
		}
		HttpHelper.executeDownloadFile(null, url, file, "UTF-8", true);
	}
	/**
	* @description 发送post请求 
	* @param  url 地址  http://fileserver.com/***  generateFileShortLink-生成短连接  moveFile-移动文件(仅限存储介质为Ftp/sftp时使用)
	* @param  otherParams  generateFileShortLink【userCode-用户代码/fileId-文件ID/fileId-文件ID/invalidTime-失效时间/validWhenLong-有效时间】  moveFile【userCode-用户代码/fileId-文件ID/targetPath-目标路径】
	* @return generateFileShortLink【resultCode-响应代码/shortLinkId-短连接地址】 moveFile【resultCode-响应代码】 
	* @throws IOException
	* @author 周建龙
	* @date 2016年10月20日下午7:23:24
	 */
	public static Map<String,String> sendPost(String url,Map<String,String> otherParams) throws IOException 
	{		
		String res1 = null;
		try {
			res1=HttpHelper.executePost(null,url,otherParams,null,null,"UTF-8",true);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("文件服务响应失败!");
		}
//		LOGGER.error("上传返回值:{}",res1);
		if (res1==null||"".equals(res1.trim())) {			
			return new HashMap<String, String>();
		}
		return dealResult(res1);	
	}
	/**
	 * @description 处理公共响应
	 * @param resultStr 返回的参数
	 * @return
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月2日下午2:47:42
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, String> dealResult(String resultStr) {
		JSONObject result = JSON.parseObject(resultStr);
		if(null!=result.getString("resultCode")&&null!=result.get("resultObj") &&"0000".equals(result.getString("resultCode"))){
			return result.getObject("resultObj", Map.class);
		}		
		if(null!=result.getString("resultCode")&&null!=result.get("resultMsg")){
			throw new BusinessException(result.getString("resultCode"),result.getString("resultMsg"));	
		}
		throw new BusinessException("文件服务响应失败!");
	}
}
