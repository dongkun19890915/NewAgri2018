package com.sinosoft.fileserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.fileserver.dto.BusStorageConfig;
import com.sinosoft.fileserver.dto.StorageConfig;
import com.sinosoft.fileserver.storage.FileOptInter;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.utils.ExtensionLoader;

/**
 * 初始化文件实例
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月3日上午9:16:31
 */
public class ApplicationInitProcessor implements ApplicationListener<ContextRefreshedEvent> {
	private static boolean isStart = false;
	private static final String instanceDir = "META-INF/file/";
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitProcessor.class);
	/** 文件存储类型 和 存储配置信息的映射关系 configCode 和 文件操作实例的配置项 */
	public static Map<String,StorageConfig> storageConfigMap = new HashMap<String,StorageConfig>();
	/** 存储介质和对应实例的映射关系 */
	public static Map<String,Class<FileOptInter>> fileInstanceMap = new HashMap<String,Class<FileOptInter>>();
	/** 业务类型及存储介质的 */
	private List<BusStorageConfig> storageConfigList = new ArrayList<BusStorageConfig>();
	/** 配置文件位置 */
	private String propertiesFile = "file.properties";
	public void setStorageConfigList(List<BusStorageConfig> storageConfigList) {
		this.storageConfigList = storageConfigList;
	}
	/**
	 * 数据源
	 */
	@Autowired
	private DruidDataSource dataSource;
	//默认存储代码
	public static String defaultStoreConfig;
	//默认存储代码
	public static String defaultBusType = "default";
	//同步存储代码
	public static String synStoreConfig;
	//默认存储代码
	public static String synBusType = "syn";

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {	
		if(isStart){
			return;
		}
		
		LOGGER.error("初始化文件存储配置文件,确认系统支持的文件存储类型!");
		readInstance();
		LOGGER.error("开始读取配置文件[{}],加载系统内配置的所有[账户/存储信息]",propertiesFile);
		readConfig();
		LOGGER.error("共找到到{}个配置文件",storageConfigList.size());
		LOGGER.error("初始化配置文件的中的文件实例!");
		initStorageConfig();
		isStart = true;
		// ftp初使化操作
//		LOGGER.error("数据库配置:{},{}",dataSource.getUrl(),dataSource.getUsername());
	}
	/**
	 * 初始化配置中的实例 
	 * @description （用一句话描述这个方法是做什么的）
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月2日下午10:58:27
	 */
	private void initStorageConfig() {
		BusStorageConfig defStorageConfig = new BusStorageConfig();
		defStorageConfig.setConfigCode(defaultStoreConfig);
		defStorageConfig.setBusType(defaultBusType);
		storageConfigList.add(defStorageConfig);
		
		
		BusStorageConfig synStorageConfig = new BusStorageConfig();
		synStorageConfig.setConfigCode(synStoreConfig);
		synStorageConfig.setBusType(synBusType);
		storageConfigList.add(synStorageConfig);
		
		
		for(int i=0;i<storageConfigList.size();i++){
			BusStorageConfig storageConfig = storageConfigList.get(i);
			LOGGER.error("初始化第{}个配置文件,业务类型:{},存储类型:{}",(i+1),storageConfig.getBusType(),storageConfig.getConfigCode());
			StorageConfig config = storageConfigMap.get(storageConfig.getConfigCode());
			if(null!=config){
				LOGGER.error("实例化存储类型:{},配置信息{}",storageConfig.getConfigCode(),JSON.toJSONString(config));
				if(null!=config){
					try {
						if(null!=fileInstanceMap.get(config.getStorageType())){
							FileOptInter fileOptInstance = fileInstanceMap.get(config.getStorageType()).newInstance();
							fileOptInstance.setStorageMedium(config.getStorageType());
							fileOptInstance.setStoreConfig(storageConfig.getConfigCode());
							boolean initResult = fileOptInstance.init(config);
							if(initResult){
								FileOptInter.BussOptMap.put(storageConfig.getBusType(), storageConfig.getConfigCode());	
								FileOptInter.fileOptMap.put(storageConfig.getConfigCode(), fileOptInstance);	
								LOGGER.error("业务类型:{},存储代码:{},存储介质:{}.初始化成功!",storageConfig.getBusType(),storageConfig.getConfigCode(),config.getStorageType());
							}else{
								LOGGER.error("业务类型:{},存储代码:{},存储介质:{}.初始化失败!",storageConfig.getBusType(),storageConfig.getConfigCode(),config.getStorageType());														
							}						
						}else{
							LOGGER.error("业务类型:{},存储代码:{}中使用了不支持的存储介质:{}.请排查!",storageConfig.getBusType(),storageConfig.getConfigCode(),config.getStorageType());															
						}				
					} catch (Exception e) {
						LOGGER.error("业务类型:{},存储代码:{},存储介质:{}.初始化失败!{}",storageConfig.getBusType(),storageConfig.getConfigCode(),config.getStorageType(),e);						
						e.printStackTrace();
					}
				}						
			}else{
				LOGGER.error("存储类型:{}未在配置文件中配置,请确认所使用的存储类型在配置文件中存在!",storageConfig.getConfigCode());
			}
		}
		if(null==FileOptInter.BussOptMap.get(defaultBusType)){
			LOGGER.error("默认存储类型:{}未在配置文件中配置或实例化失败,请确认所使用的存储类型在配置文件中存在!",defaultStoreConfig);			
		}
		
	}
	/**
	 * 读取配置文件
	 * @description （用一句话描述这个方法是做什么的）
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月2日下午10:56:23
	 */
	private void readConfig() {
		Map<String, JSONObject> configMap = new HashMap<String, JSONObject>();
		try {
			Resource resource = new ClassPathResource(propertiesFile);
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			Object defaultStoreConfig = props.get("defaultStoreConfig");
			if(null!=defaultStoreConfig){
				ApplicationInitProcessor.defaultStoreConfig = defaultStoreConfig.toString();
				props.remove("defaultStoreConfig");
			}else{
				LOGGER.error("没有配置默认的存储介质。");
				throw  new BusinessException("没有配置默认的存储介质。");
			}	
			
			Object synStoreConfig = props.get("synStoreConfig");
			if(null!=synStoreConfig){
				ApplicationInitProcessor.synStoreConfig = synStoreConfig.toString();
				props.remove("synStoreConfig");
			}else{
				LOGGER.error("没有配置同步的存储介质。");
			}	
			
			Set<Object> setObject = props.keySet();
			
			for(Object propKey:setObject){
				if(null!=propKey&&!"".equals(propKey)&propKey.toString().indexOf(".")>-1){
					String key = propKey.toString();
					String configCode = key.substring(0,key.indexOf("."));
					String configKey = key.substring(key.indexOf(".")+1);
					System.out.println(configKey+"-----");
					if(configKey.contains("storageType"))
					{
						BusStorageConfig busStorageConfig=new BusStorageConfig();
						busStorageConfig.setBusType("noBusType-"+configCode);
						busStorageConfig.setConfigCode(configCode);
						storageConfigList.add(busStorageConfig);
						
					}

					
					JSONObject jsonObject = new JSONObject();
					if(configMap.containsKey(configCode)){
						jsonObject = configMap.get(configCode);
					}
					String value = (String) props.get(key);

					//加解密处理
					if (value.indexOf("ENC(") == 0) {
						String str = value;
						str = str.substring(4, str.length() - 1);
						StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
						encryptor.setPassword((String) props.get("jasypt.encryptor.password"));
						value = encryptor.decrypt(str);
					}

					jsonObject.put(configKey, value);
					configMap.put(configCode, jsonObject);	
				}
			}	
			Iterator<Entry<String, JSONObject>> iter = configMap.entrySet().iterator();
			while (iter.hasNext()) {
			Entry<String, JSONObject> entry = iter.next();
				String key = entry.getKey();
				JSONObject jsonObject = entry.getValue();
				StorageConfig storageConfig=(StorageConfig) JSONObject.toJavaObject(jsonObject,StorageConfig.class);  
				storageConfigMap.put(key,storageConfig);
			}			
		} catch (Exception e) {
			LOGGER.error("初始化默认配置文件报错",e);
		}		
	}
	/**
	 * 加载文件处理实例
	 * @description （用一句话描述这个方法是做什么的）
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月2日下午10:59:06
	 */
	private void readInstance() {
		LOGGER.error("开始读取实例列表.");
		//获取MQ实例列表
		ExtensionLoader<FileOptInter> extensionLoader = new ExtensionLoader<FileOptInter>();
		fileInstanceMap =	extensionLoader.loadExtensionClasses(instanceDir, FileOptInter.class);

		LOGGER.error("读取到{}个File存储实例实例,明细为{}",fileInstanceMap.size(),JSON.toJSONString(fileInstanceMap));
	}

}
