package com.sinosoft.fileserver.controller.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sinosoft.fileserver.controller.config.UploadConfig;
import com.sinosoft.fileserver.entity.TFileInfo;

/**
 * 
 * @description 文件信息辅助类
 * @author 周建龙
 * @date 2016年10月5日下午3:08:10
 */
public class FileInfoUtils {
	/**
	 * 日期格式化
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 
	 * @description 生成文件信息文件id
	 * @return 文件id
	 * @author 周建龙
	 * @date 2016年10月5日下午3:13:04
	 */
	public static String createNewFileId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 
	 * @description 根据入参配置，生成文件信息
	 * @param config
	 *            配置
	 * @return 文件信息
	 * @author 周建龙
	 * @date 2016年10月5日下午3:14:33
	 */
	public static TFileInfo getFileInfoByUploadConfig(UploadConfig config) {
		TFileInfo fileInfo = new TFileInfo();
		Date now=new Date();
		MultipartFile file = config.getFile();
		fileInfo.setFileId(createNewFileId());
		fileInfo.setFileExt(getFileExtByFileName(file.getOriginalFilename()));
		fileInfo.setBussType(config.getBussType());
		//调整文件存储路径为 系统代码/业务代码/日期
		fileInfo.setFilePath(getFilePath(config.getSystemId(),config.getBussType(),config.getFilePath()));
		fileInfo.setSystemId(config.getSystemId());
		fileInfo.setCreateTime(now);
		fileInfo.setCreateBy(config.getUserCode());
		fileInfo.setUpdateTime(now);
		fileInfo.setUpdateBy(config.getUserCode());
		fileInfo.setFileName(file.getOriginalFilename());
		fileInfo.setFileSize(file.getSize());
		fileInfo.setIsDeleted("2");
		if(config.getFilePath()==null){
			//拼成实际路径
			if (!StringUtils.isBlank(fileInfo.getFileExt())) {
				fileInfo.setFilePath(fileInfo.getFilePath() + fileInfo.getFileId() + "." + fileInfo.getFileExt());
			} else {
				fileInfo.setFilePath(fileInfo.getFilePath() + fileInfo.getFileId());
			}	
		}
		return fileInfo;
	}

	/**
	 * 
	 * @description 获得文件存储位置
	 * @param systemId	系统代码
	 * @param bussType	业务模块
	 * @param filePath	文件路径
	 * @return 实际文件路径
	 * @author 周建龙
	 * @date 2016年10月5日下午3:31:45
	 */
	public static String getFilePath(String systemId, String bussType, String filePath) {
		if (filePath == null) {
			// 默认路径
			filePath = systemId + "/" + bussType + "/"+sdf.format(new Date())+"/" ;
		} else {
			// 指定路径
			filePath = systemId + "/" + bussType + "/" + filePath;
		}

		return filePath;
	}
	/**
	 * 
	* @description  把上传文件转换成文件对象
	* @param file
	* @return
	* @throws IOException
	* @author 周建龙
	* @date 2016年10月7日上午10:51:27
	 */
	public static File getMultipartFileToFile(MultipartFile file) throws IOException {
		
		CommonsMultipartFile cf= (CommonsMultipartFile)file; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation();		
		return f;
	}
	/**
	 * 
	 * @description 根据文件名获得文件后缀
	 * @param filename
	 *            文件名称
	 * @return 文件后缀
	 * @author 周建龙
	 * @date 2016年10月5日下午3:35:49
	 */
	public static String getFileExtByFileName(String filename) {
		if (filename == null) {
			return null;
		}
		if (filename.indexOf(".") == -1) {
			return "";
		}
		return filename.substring(filename.lastIndexOf(".") + 1);
	}
	
}
