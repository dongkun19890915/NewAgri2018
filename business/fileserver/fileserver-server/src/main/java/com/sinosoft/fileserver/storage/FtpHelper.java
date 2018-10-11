package com.sinosoft.fileserver.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.sinosoft.fileserver.dto.StorageConfig;

/**
 * 
* @description ftp上传工具类
* @author yangqunwei@sinosoft.com.cn
* @date 2016年10月7日上午11:08:25
 */
public class FtpHelper {
	private StorageConfig ftpconfig = null;
	
	
	/** 
	* @description 初始化对象
	* @param ftpconfig
	* @author 周建龙
	* @date 2016年10月7日上午11:08:44
	 */
	public  void initFtpConfig(StorageConfig ftpconfig) {
		this.ftpconfig = ftpconfig;
	}
	
	/**
	 * 
	* @description 创建ftp客户端
	* @return ftp客户端
	* @throws IOException
	* @author 周建龙
	 * @param ftpconfig 
	* @date 2016年10月7日上午11:09:48
	 */
	private  FTPClient createFtpClient(StorageConfig ftpconfig) throws IOException {
		String ip = ftpconfig.getFtpIp();
		int port = ftpconfig.getFtpPort();
		String username = ftpconfig.getFtpUserName();
		String password = ftpconfig.getFtpPassword();
		FTPClient client = new FTPClient();
		client.connect(ip, port);
		int replyCode = client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			client.disconnect();
			throw new IOException("Cannot connect to FTP " + ip + ":" + port);
		}
		if (!client.login(username, password)) {
			throw new IOException("FTP login error: address=" + ip + ":" + port + ", username=" + username
					+ ", password=" + password);
		}
		client.setFileType(FTP.BINARY_FILE_TYPE);
		return client;
	}
	//获取FTP客户端
	public  FTPClient getFtpClient() throws Exception {
		FTPClient client = createFtpClient(ftpconfig);
		if(null!=ftpconfig.getFtpWorkDir()){
			client.changeWorkingDirectory(ftpconfig.getFtpWorkDir());
		}		
		return client;
	}
	//充值FTP客户端
	public  void releaseFtpClient(FTPClient client) {
		try {
			client.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//上传文件
	public  void uploadFile(String path, File file) throws Exception {
		uploadFile(path, new FileInputStream(file));
	}
	//上传文件
	public  void uploadFile(String path, InputStream in) throws Exception {
		FTPClient client = null;
		try {
			if (!path.startsWith("/")) {
				path = "/" + path;
			}
			String folder = StringUtils.substringBeforeLast(path, "/");
			if (StringUtils.isBlank(folder)) {
				folder = "/";
			}
			String fileName = StringUtils.substringAfterLast(path, "/");
			client = getFtpClient();
			if (!client.changeWorkingDirectory(folder)) {
				if (!makeDirectory(client, folder)) {
					throw new IOException("Failed to make directory: " + folder);
				}
				client.changeWorkingDirectory(folder);
			}
			if (!client.storeFile(fileName, in)) {
				throw new IOException("Failed to upload file: " + path);
			}
		} finally {
			releaseFtpClient(client);
		}
	}

	/**
	 * 
	* @description 获得ftp文件流
	* @param path 路径
	* @return 文件流
	* @throws Exception
	* @author 周建龙
	* @date 2016年10月5日下午6:14:16
	 */
	public  InputStream getInputStreamByPath(String path) throws Exception {
		FTPClient client = null;
		try {
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
			String folder = StringUtils.substringBeforeLast(path, "/");
			if (StringUtils.isBlank(folder)) {
				folder = "";
			}
			String fileName = StringUtils.substringAfterLast(path, "/");
			client = getFtpClient();
			if (!client.changeWorkingDirectory(folder)) {
				throw new IOException("Cannot change directory to: " + folder);
			}
			return client.retrieveFileStream(fileName);
		} finally {
			releaseFtpClient(client);
		}
	}
	public void moveFile(String srcPath, String distPath) throws Exception {
		if(srcPath.equals(distPath)){
			return;
		}
		this.uploadFile(distPath, getInputStreamByPath(srcPath));
		deleteFile(srcPath);	
	}
	public  void deleteFile(String path) throws Exception {
		FTPClient client = null;
		try {
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
			String folder = StringUtils.substringBeforeLast(path, "/");
			if (StringUtils.isBlank(folder)) {
				folder = "";
			}
			String fileName = StringUtils.substringAfterLast(path, "/");
			client = getFtpClient();
			if (!client.changeWorkingDirectory(folder)) {
				throw new IOException("Cannot change directory to: " + folder);
			}
			client.deleteFile(fileName);
		} finally {
			releaseFtpClient(client);
		}
	}

	public  String[] listFileNames(String folder) throws Exception {
		FTPClient client = null;
		try {
			if (!folder.startsWith("/")) {
				folder = "/" + folder;
			}
			client = getFtpClient();
			if (!client.changeWorkingDirectory(folder)) {
				throw new IOException("Cannot change directory to: " + folder);
			}
			return client.listNames(folder);
		} finally {
			releaseFtpClient(client);
		}
	}
	//创建文件
	private  boolean makeDirectory(FTPClient client, String folder) throws IOException {
		String[] pathArr = folder.split("/");
		for (String path : pathArr) {
			if (StringUtils.isBlank(path)) {
				continue;
			}
			if (!client.changeWorkingDirectory(path)) {
				if (!client.makeDirectory(path)) {
					return false;
				}
				client.changeWorkingDirectory(path);
			}
		}
		return true;
	}



}
