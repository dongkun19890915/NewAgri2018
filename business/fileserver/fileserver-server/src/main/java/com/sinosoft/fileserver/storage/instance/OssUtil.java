package com.sinosoft.fileserver.storage.instance;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.sinosoft.fileserver.dto.StorageConfig;
import com.sinosoft.fileserver.storage.FileOptInter;
import com.sinosoft.framework.exception.BusinessException;
/**
 * OSS的文件操作实现类
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午10:13:58
 */
public class OssUtil  extends ParentFileUtil  implements FileOptInter{

	private static final Logger LOGGER = LoggerFactory.getLogger(OssUtil.class);
	 OSSClient ossClient = null;
	 private static Map<String,String> bussBucketMap = new HashMap<String,String>();
	 private static final String defaultCode = "default";
	 
	/**
	 * 初始化实例配置
	 */
	public void uploadFile(String filePath,InputStream in) throws Exception {
		if(null==filePath){
			return; 
		}		
		//只截取filePath的第一个有效的文件夹作为bucketName
		String bucketName = getBucketName(filePath);
		String realFilePath = getRealFilePath(filePath);
        if (ossClient.doesBucketExist(bucketName)) {
        	LOGGER.error("使用Bucket:{}.",bucketName);
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
        	LOGGER.warn("创建新的Bucket:{}.",bucketName);        	
            ossClient.createBucket(bucketName);
        }
        ossClient.putObject(bucketName, realFilePath, in);
	}
	public InputStream getInputStreamByPath(String filePath) throws Exception {
		//只截取filePath的第一个有效的文件夹作为bucketName
		String bucketName = getBucketName(filePath);
		String realFilePath = getRealFilePath(filePath);
        OSSObject ossObject = ossClient.getObject(bucketName, realFilePath);
        if(null!=ossObject){
        	return ossObject.getObjectContent();	
        }else{
        	throw new BusinessException("文件不存在!");
        }        
	}	
	private String getRealFilePath(String filePath) {
		return filePath.substring(filePath.indexOf("/")+1);
	}
	private String getBucketName(String filePath) {
		String[] disrnams = filePath.split("/");
		String bucketName = disrnams[0].toLowerCase();
		if(bussBucketMap.containsKey(bucketName)){
			return bussBucketMap.get(bucketName);
		}else{
			return bussBucketMap.get(defaultCode);
		}
	}
	public boolean init(StorageConfig config) {
		try {
			ClientConfiguration ossConfig = new ClientConfiguration();
			if(!config.isOssPublicFlag()){//私有云使用
				ossConfig.setSupportCname(false);//	
			}else{
				ossConfig.setSupportCname(true);
			}				
			ossClient = new OSSClient(config.getOssEndpoint(),config.getOssAccessKeyId(),config.getOssAccessKeySecret(),ossConfig);
			LOGGER.error("初始化ONS-Bucket配置开始{}.",config.getOssBucketMap());
			if(null!=config.getOssBucketMap()&&!"".equals(config.getOssBucketMap())){
				String[] bucketMapArray = config.getOssBucketMap().split(",");
				for(String bucketMapItem:bucketMapArray){
					String[] keyValueArray = bucketMapItem.split(":");
					if(null!=keyValueArray&&keyValueArray.length>=2){
						String key = keyValueArray[0];
						String value = keyValueArray[1];
						bussBucketMap.put(key.substring(1).toLowerCase(), value.substring(0, value.length()-1).toLowerCase());						
					}
				}
			}
			LOGGER.error("初始化ONS-Bucket配置结束{}.",JSON.toJSONString(bussBucketMap));
			if(null==bussBucketMap.get(defaultCode)){
				LOGGER.error("没有配置默认的BucketName:{}",defaultCode);
				throw new BusinessException("没有配置默认的BucketName");
			}
			ossClient.listBuckets();
		} catch (Exception e) {
			LOGGER.error("初始化OSS异常{}.",e);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//因为OSS中不存在文件移动操作,仅能先上传后删除
	public void moveFile(String srcPath, String distPath) throws Exception {
		if(srcPath.equals(distPath)){
			return;
		}
		this.uploadFile(distPath, getInputStreamByPath(srcPath));
		ossClient.deleteObject(getBucketName(srcPath), srcPath);
	}

}
