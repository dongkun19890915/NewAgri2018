package com.sinosoft.fileserver.storage;

import java.io.InputStream;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sinosoft.fileserver.dto.StorageConfig;
import com.sinosoft.framework.exception.BusinessException;
/**
 * Sftp的操作实现类
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月3日下午1:53:33
 */
public class SftpHelper {
	private int ftpTimeout  = 50000;
	private  StorageConfig  config =null;	
	//初始化配置
	public boolean initConfit(StorageConfig config) {
		try {
			if(0==config.getFtpTimeout()){
				config.setFtpTimeout(ftpTimeout);
			}			
			this.config = config;	
			Sftp sftp = createSftpInstance();
			sftp.lsDirs();
			sftp.logout();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	//上传文件
	public  void uploadFile(String path, InputStream in) throws SftpException, JSchException {
		Sftp sftp = createSftpInstance();
		String filename = path.substring(path.lastIndexOf("/") + 1);
		String filepath = path.substring(0, path.lastIndexOf("/"));
		String[] disrnams = filepath.split("/");
		String lastPath = disrnams[disrnams.length - 1];
		for (int i = 0; i < disrnams.length; i++) {
			String dirname = disrnams[i];
			if (!sftp.existDir(dirname)) {
				sftp.makeDir(dirname);
			}
			if (i != disrnams.length - 1) {
				sftp.changeDir(dirname);
			}
		}
		boolean falg=sftp.uploadFile(lastPath, filename, in);
		sftp.logout();
		if (!falg) {
			throw new BusinessException("上传失败");
		}
	}
	//下载文件
	public  void downloadFile(String remotePath,String fileName,String localPath) throws JSchException, SftpException {
		Sftp sftp = createSftpInstance();		
		boolean flag = sftp.downloadFile(remotePath, fileName, localPath);
		sftp.logout();
		if(!flag){
			throw new BusinessException("下载失败");
		}		
	}
	//移动文件
	public  void moveFile(String srcSftpFilePath, String distSftpFilePath) throws Exception{
		uploadFile(distSftpFilePath,getFtpInputStreamByPath(srcSftpFilePath));
		String filepath = srcSftpFilePath.substring(0, srcSftpFilePath.lastIndexOf("/"));
		String[] disrnams = filepath.split("/");
		Sftp sftp = createSftpInstance();				
		for (int i = 0; i < disrnams.length; i++) {
			String dirname = disrnams[i];
			sftp.changeDir(dirname);
		}
		sftp.currentDir();
		sftp.delFile(srcSftpFilePath.substring(srcSftpFilePath.lastIndexOf("/")+1,srcSftpFilePath.length()));
	}
	//根据路径获取流信息
	public  InputStream getFtpInputStreamByPath(String path) throws SftpException, JSchException {
		Sftp sftp =  createSftpInstance();
	    return sftp.getInputStreamByFilePath(path);
	}
	/**
	 * 创建Sftp上传下载实例
	 * @description （用一句话描述这个方法是做什么的）
	 * @return
	 * @throws JSchException
	 * @author yangqunwei@sinosoft.com.cn
	 * @throws SftpException 
	 * @date 2016年11月3日上午10:54:39
	 */
	private Sftp createSftpInstance() throws JSchException, SftpException {
		Sftp sftp = new Sftp(config.getFtpIp(), config.getFtpPort(), config.getFtpTimeout(), config.getFtpUserName(),config.getFtpPassword());
		sftp.login();
		sftp.changeDir(config.getFtpWorkDir());
		return sftp;
	}
}
