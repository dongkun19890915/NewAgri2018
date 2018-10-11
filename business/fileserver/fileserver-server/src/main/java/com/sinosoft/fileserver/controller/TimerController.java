package com.sinosoft.fileserver.controller;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sinosoft.fileserver.service.TFileInfoService;

/**
 * 
* @description 定时任务
* @author 周建龙
* @date 2016年10月7日上午11:03:05
 */
@Component
public class TimerController {
	/**
	 * 上传文件转换对象
	 */
	@Autowired
	private CommonsMultipartResolver multipartResolver;
	
	@Autowired
	private TFileInfoService tfileInfoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimerController.class);
	/**
	 * 
	* @description 清理上传临时文件
	* @author 周建龙
	* @date 2016年10月7日上午11:03:46
	 */
	public void cleanFileUploadTmp() {
		LOGGER.error("清理上传文件开始");
		multipartResolver.getFileItemFactory();
		File dir=multipartResolver.getFileItemFactory().getRepository();
		File[] files=dir.listFiles();
		if(null==files){
			return;
		}		
		for (int i = 0; i < files.length; i++) {
			File f=files[i];
			if (f.getName().startsWith("upload_")&&f.getName().endsWith(".tmp")) {
				if (f.lastModified()+300000<new Date().getTime()) {
					boolean flag=f.delete();
					LOGGER.error("删除临时文件{}:{}",f.getAbsolutePath(),flag);
				}
				
			}
			
		}
		LOGGER.error("清理上传文件结束");
	}
	
	/**
	 * 
	* @description 备份数据
	* @author kongchao
	* @date 2016年11月26日15:41:02
	 */
	public void synFile() {
		LOGGER.error("开始备份数据");
		tfileInfoService.synFile();
		LOGGER.error("结束备份数据");
	}
}
