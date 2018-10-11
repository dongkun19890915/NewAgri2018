package com.sinosoft.fileserver.service.impl;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.fileserver.controller.ApplicationInitProcessor;
import com.sinosoft.fileserver.dao.TFileInfoMapper;
import com.sinosoft.fileserver.entity.TFileInfo;
import com.sinosoft.fileserver.entity.TFileInfoExample;
import com.sinosoft.fileserver.entity.TFileInfoKey;
import com.sinosoft.fileserver.service.TFileInfoService;
import com.sinosoft.fileserver.storage.FileOptFactory;
import com.sinosoft.fileserver.storage.FileOptInter;
/**
 * 
* @description 文件信息业务层实现
* @author 周建龙
* @date 2016年10月5日下午3:04:58
 */
@Service("tfileInfoService")
public class TFileInfoServiceImpl implements TFileInfoService{
	private static final Logger LOGGER = LoggerFactory.getLogger(TFileInfoServiceImpl.class);	

	@Autowired
	private TFileInfoMapper mapper;
	
	/**
	* @description 根据文件id找到文件信息
	* @param fileId 文件id
	* @return 文件信息
	* @author 周建龙
	* @date 2016年10月5日下午3:02:50
	 */	
	@Override
	public TFileInfo queryTFileInfoByFileId(String fileId) {
		TFileInfoExample example=new TFileInfoExample();
		String storeConfig=FileOptInter.BussOptMap.get(ApplicationInitProcessor.synBusType);
		if(null!=storeConfig){
			example.createCriteria().andFileIdEqualTo(fileId).andStorageConfigNotEqualTo(storeConfig);
		}else{
			example.createCriteria().andFileIdEqualTo(fileId);
		}
		List<TFileInfo> info =mapper.selectByExample(example);
		return info.size()==0?null:info.get(0);
	}
	/**
	 * 
	* @description 保存文件信息
	* @param tfileInfo 文件信息
	* @author 周建龙
	* @date 2016年10月5日下午3:04:00
	 */
	@Override
	public void save(TFileInfo tfileInfo) {
		try {
			mapper.insert(tfileInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @description 更新文件信息
	* @param tfileInfo
	* @return
	* @author 周建龙
	* @date 2016年10月5日下午9:00:22
	 */
	@Override
	public void updateByPrimaryKey(TFileInfo tfileInfo) {
		mapper.updateByPrimaryKey(tfileInfo);
	}
	/**
	 * 
	* @description 根据主键查询文件信息
	* @param fileId
	* @param storeConfig 
	* @return
	* @author kongchao
	* @date 2016年11月26日10:15:52
	 */
	@Override
	public TFileInfo queryByPrimaryKey(String fileId, String storeConfig) {
		TFileInfoKey key=new TFileInfoKey();
		key.setFileId(fileId);
		key.setStorageConfig(storeConfig);
		mapper.selectByPrimaryKey(key);
		return mapper.selectByPrimaryKey(key);
	}
	/**
	 * 
	* @description 同步文件方法
	* @param time
	* @return
	* @author kongchao
	* @date 2016年11月26日10:15:52
	 */
	@Override
	public void synFile() {
		//查询出小时之前到当前时间的说有文件信息
		TFileInfoExample example=new TFileInfoExample();
		Calendar calendar=Calendar.getInstance();
		Date now=calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
		example.createCriteria().andCreateTimeBetween(calendar.getTime(), now);		
		List<TFileInfo> fileInfoList = mapper.selectByExample(example);
		//获取同步的storeConfig
		String storeConfig=FileOptInter.BussOptMap.get(ApplicationInitProcessor.synBusType);
		if(storeConfig==null){
			return;
		}
		for (TFileInfo tFileInfo : fileInfoList) {
			try {
				TFileInfoKey key=new TFileInfoKey();
				key.setFileId(tFileInfo.getFileId());
				key.setStorageConfig(storeConfig);
				TFileInfo queryInfo=mapper.selectByPrimaryKey(key);
				if(null==queryInfo||"".equals(queryInfo)){
					FileOptInter srcfileOptInter  = FileOptFactory.getFileInstance(tFileInfo.getBussType(),FileOptFactory.BUSSTYPE);
					InputStream srcinputStream = srcfileOptInter.getInputStreamByPath(tFileInfo.getFilePath());				
					FileOptInter synfileOptInter  = FileOptFactory.getFileInstance(ApplicationInitProcessor.synBusType,FileOptFactory.BUSSTYPE);
					if(synfileOptInter==null){
						return;
					}
					// 把文件存放到相应介质
					synfileOptInter.uploadFile(tFileInfo.getFilePath(), srcinputStream);
					tFileInfo.setUpdateBy(ApplicationInitProcessor.synBusType);
					tFileInfo.setUpdateTime(new Date());
					tFileInfo.setStorageConfig(ApplicationInitProcessor.synStoreConfig);
					queryInfo=mapper.selectByPrimaryKey(key);
					if(null==queryInfo){
						mapper.insert(tFileInfo);	
					}						
					LOGGER.debug("文件[{}]同步至[{}],成功!",tFileInfo.getFileId(),ApplicationInitProcessor.synBusType);	
				}			
			} catch (Exception e) {
				LOGGER.error("文件[{}]已同步。",tFileInfo.getFileId());
			}
		}
		
	}
	
}
