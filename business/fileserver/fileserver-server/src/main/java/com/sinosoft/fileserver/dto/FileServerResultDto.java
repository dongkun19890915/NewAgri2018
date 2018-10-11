/**
 * 
 */
package com.sinosoft.fileserver.dto;

import com.sinosoft.framework.dto.ResponseDto;

/**
* @description （用一句话描述这个类的作用）
* @author 周建龙
* @date 2016年10月21日下午12:40:19
*/

public class FileServerResultDto  extends ResponseDto{
	private static final long serialVersionUID = 1L;
	private String fileId;
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	private FileServerResultDto(Object resultObj){
		super.instance(resultObj);
	}
	private FileServerResultDto(Object resultObj,String fileId){
		super.instance(resultObj);
		this.fileId = fileId;
	}
}
