package com.sinosoft.fileserver.service;

import com.sinosoft.fileserver.entity.TFileInfo;

/**
 * 
* @description 文件服务业务层
* @author 周建龙
* @date 2016年10月5日下午3:02:08
 */
public interface TFileInfoService {
	/**
	* @description 根据文件id找到文件信息
	* @param fileId 文件id
	* @return 文件信息
	* @author 周建龙
	* @date 2016年10月5日下午3:02:50
	 */
	public TFileInfo queryTFileInfoByFileId(String fileId);
	/**
	 * 
	* @description 保存文件信息
	* @param tfileInfo 文件信息
	* @author 周建龙
	* @date 2016年10月5日下午3:04:00
	 */
	public void save(TFileInfo tfileInfo);
	/**
	 * 
	* @description 更新文件信息
	* @param tfileInfo
	* @return
	* @author 周建龙
	* @date 2016年10月5日下午9:00:22
	 */
	public void updateByPrimaryKey(TFileInfo tfileInfo);
	
	
	/**
	 * 
	* @description 根据主键查询文件信息
	* @param fileId
	* @param storeConfig 
	* @return
	* @author kongchao
	* @date 2016年11月26日10:15:52
	 */
	public TFileInfo queryByPrimaryKey(String fileId,String storeConfig);
	

	/**
	 * 
	* @description 同步文件方法
	* @param time
	* @return
	* @author kongchao
	* @date 2016年11月26日10:15:52
	 */
	public void synFile();
}
