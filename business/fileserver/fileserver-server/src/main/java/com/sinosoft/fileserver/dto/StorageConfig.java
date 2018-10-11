package com.sinosoft.fileserver.dto;
/**
 * @description 文件存储的配置信息
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午7:27:27
 */
public class StorageConfig {
	/**存储类型*/
	private String storageType = null;
	/**FTP-IP*/
	private String ftpIp = null;
	/**FTP-端口*/
	private int ftpPort = 21;
	/**FTP-用户名*/
	private String ftpUserName = null;
	/**FTP-密码*/
	private String ftpPassword = null;
	/**FTP-连接超时时间*/
	private int ftpTimeout = 0;
	/**FTP-默认工作目录*/
	private String ftpWorkDir =null;
	/**Ali节点*/
	private String ossEndpoint = null;
	/**应用Id*/
	private String ossAccessKeyId = null;
	/**应用密钥*/
	private String ossAccessKeySecret = null;
	/**OSS-Bucket与BusType的映射关系*/
	private String ossBucketMap = null;
	/**是否使用共有云,默认私有云*/
	private boolean ossPublicFlag = false;	
	
	public String getFtpIp() {
		return ftpIp;
	}
	public void setFtpIp(String ftpIp) {
		this.ftpIp = ftpIp;
	}
	public int getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpUserName() {
		return ftpUserName;
	}
	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}	
	public int getFtpTimeout() {
		return ftpTimeout;
	}
	public void setFtpTimeout(int ftpTimeout) {
		this.ftpTimeout = ftpTimeout;
	}
	public String getOssEndpoint() {
		return ossEndpoint;
	}
	public void setOssEndpoint(String ossEndpoint) {
		this.ossEndpoint = ossEndpoint;
	}
	public String getOssAccessKeyId() {
		return ossAccessKeyId;
	}
	public void setOssAccessKeyId(String ossAccessKeyId) {
		this.ossAccessKeyId = ossAccessKeyId;
	}
	public String getOssAccessKeySecret() {
		return ossAccessKeySecret;
	}
	public void setOssAccessKeySecret(String ossAccessKeySecret) {
		this.ossAccessKeySecret = ossAccessKeySecret;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getFtpWorkDir() {
		return ftpWorkDir;
	}
	public void setFtpWorkDir(String ftpWorkDir) {
		this.ftpWorkDir = ftpWorkDir;
	}
	public String getOssBucketMap() {
		return ossBucketMap;
	}
	public void setOssBucketMap(String ossBucketMap) {
		this.ossBucketMap = ossBucketMap;
	}
	public boolean isOssPublicFlag() {
		return ossPublicFlag;
	}
	public void setOssPublicFlag(boolean ossPublicFlag) {
		this.ossPublicFlag = ossPublicFlag;
	}
	
}
