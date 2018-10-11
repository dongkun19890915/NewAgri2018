package com.sinosoft.pms.core.config.service;

public interface SysConfigService {
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 * @throws Exception
	 */
    String getValue(String key) throws Exception;
	
}
