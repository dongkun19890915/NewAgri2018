package com.sinosoft.fileserver.storage;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.fileserver.dto.StorageConfig;

/**
 * 文件操作的接口
 * @description 定义文件操作的接口类
 * @author yangqunwei@sinosoft.com.cn
 * @date 2016年11月2日下午10:03:23
 */
public interface FileOptInter {	
	
	
	/**
	 * 存储类型和文件操作实例的映射关系
	 */
	public static Map<String,FileOptInter> fileOptMap = new HashMap<String,FileOptInter>();	
	

	/**
	 * 业务类型和存储类型的映射关系
	 */
	public static Map<String,String> BussOptMap = new HashMap<String,String>();		
	/**
	 * 
	 * @description 初始化文件存储并检验配置是否可用
	 * @param config
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月2日下午10:38:10
	 */
	public boolean init(StorageConfig config);	
	/**
	* @description 更新文件到相应存储介质
	* @param filePath 文件路径
	* @param in 输入流
	* @author yangqunwei@sinosoft.com.cn
	* @author 周建龙
	* @date 2016年10月7日上午10:29:54
	*/
	public void uploadFile(String filePath,InputStream in)  throws Exception ;
	/**
	* @description 根据路径获得存储介质的输入流
	* @param filePath 文件路径
	* @return 输入流
	* @author yangqunwei@sinosoft.com.cn
	* @author 周建龙
	* @date 2016年10月7日上午10:30:21
	 */
	public InputStream getInputStreamByPath(String filePath) throws Exception;
	/**
	 * 移动文件
	 * @description OSS存储时不建议使用
	 * @param srcPath 源文件
	 * @param distPath 目标文件
	 * @throws Exception
	 * @author yangqunwei@sinosoft.com.cn
	 * @date 2016年11月3日下午1:59:20
	 */
	public void moveFile(String srcPath,String distPath) throws Exception;
	
	public String getStorageMedium();
	public void setStorageMedium(String storageMedium);
	
	public String getStoreConfig();
	public void setStoreConfig(String storeConfig);
	
}
