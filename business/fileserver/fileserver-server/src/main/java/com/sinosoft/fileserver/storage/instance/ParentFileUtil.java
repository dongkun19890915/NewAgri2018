package com.sinosoft.fileserver.storage.instance;

/**
 * 文件操作的公共父类
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月3日下午4:15:38
 */
public abstract class ParentFileUtil {
	//存储介质
	private String storageMedium = null;	
	//存储用户
	private String storeConfig = null;	
	public String getStorageMedium() {
		return storageMedium;
	}
	public void setStorageMedium(String storageMedium) {
		this.storageMedium = storageMedium;
	}
	public String getStoreConfig() {
		return storeConfig;
	}
	public void setStoreConfig(String storeConfig) {
		this.storeConfig = storeConfig;
	}
}
