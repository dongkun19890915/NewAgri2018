package com.sinosoft.fileserver.storage;

import com.sinosoft.fileserver.controller.ApplicationInitProcessor;

/**
 * 文件操作的工具类
 * @description （用一句话描述这个类的作用）
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月3日上午10:31:36
 */
public class FileOptFactory {
	/**
	 * 根据业务类型获取上传实例
	 * @description （用一句话描述这个方法是做什么的）
	 * @param busType
	 * @param flag
	 * @author yangqunwei@sinosoft.com.cn
	 * @return 
	 * @date 2016年11月3日上午10:32:17
	 */
	public static final Integer BUSSTYPE=1;
	public static final Integer CONFIGCODE=2;
	
	public static FileOptInter getFileInstance(String input,Integer inputType){
		if(inputType==1){
			String configCode=FileOptInter.BussOptMap.get(input);
			String defaultConfigCode=FileOptInter.BussOptMap.get(ApplicationInitProcessor.defaultBusType);
			
			if(configCode!=null&&FileOptInter.fileOptMap.containsKey(configCode)){
				return FileOptInter.fileOptMap.get(configCode);
			}
			return FileOptInter.fileOptMap.get(defaultConfigCode);
		}else if(inputType==2){
			
			return FileOptInter.fileOptMap.get(input);
		}
		return null;
		
		
	}
	
	
}
