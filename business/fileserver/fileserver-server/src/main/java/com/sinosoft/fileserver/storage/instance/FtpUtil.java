package com.sinosoft.fileserver.storage.instance;

import java.io.InputStream;

import com.sinosoft.fileserver.dto.StorageConfig;
import com.sinosoft.fileserver.storage.FileOptInter;
import com.sinosoft.fileserver.storage.FtpHelper;

/**
 * FTP的文件操作实现类
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午10:13:58
 */
public class FtpUtil  extends ParentFileUtil  implements FileOptInter{
	private FtpHelper ftpHelper = null;
	//上传文件
	public void uploadFile(String filePath, InputStream in) throws Exception {
		ftpHelper.uploadFile(filePath, in);
	}
	//获取文件流信息
	public InputStream getInputStreamByPath(String filePath) throws Exception {		
		return ftpHelper.getInputStreamByPath(filePath);
	}
	//初始化文件信息
	public boolean init(StorageConfig config) {
		ftpHelper = new FtpHelper();
		ftpHelper.initFtpConfig(config);
		try {
			return ftpHelper.getFtpClient().isConnected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//移动文件
	public void moveFile(String srcPath, String distPath) throws Exception {
		ftpHelper.moveFile(srcPath, distPath);
		ftpHelper.deleteFile(srcPath);
	}
}
