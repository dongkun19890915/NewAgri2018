package com.sinosoft.fileserver.storage.instance;

import java.io.InputStream;

import com.sinosoft.fileserver.dto.StorageConfig;
import com.sinosoft.fileserver.storage.FileOptInter;
import com.sinosoft.fileserver.storage.SftpHelper;
/**
 * Sftp的文件操作实现
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午10:15:10
 */
public class SftpOptUtil extends ParentFileUtil implements FileOptInter{
	private SftpHelper sftpHelper = null;
	/**
	 * 
	* @description 更新文件到相应存储介质
	* @param filePath 文件路径
	* @param in 输入流
	* @author 周建龙
	* @date 2016年10月7日上午10:29:54
	 */
	
	public void uploadFile(String filePath, InputStream in) throws Exception {
		sftpHelper.uploadFile(filePath, in);
	}
	/**
	 * 
	* @description 根据文件路径获取文件流信息
	* @param filePath 文件路径
	* @return 输入流
	* @author 周建龙
	* @date 2016年10月7日上午10:30:21
	 */
	
	public InputStream getInputStreamByPath(String filePath) throws Exception {		
		return sftpHelper.getFtpInputStreamByPath(filePath);
	}
	/**
	 * 初始化实例配置
	 */
	public boolean init(StorageConfig config) {
		sftpHelper = new SftpHelper();
		return sftpHelper.initConfit(config);
	}
	public void moveFile(String srcPath, String distPath) throws Exception {
		if(srcPath.equals(distPath)){
			return;
		}
		sftpHelper.moveFile(srcPath, distPath);
	}	
}
