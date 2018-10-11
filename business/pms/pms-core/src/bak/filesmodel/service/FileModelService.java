package com.sinosoft.pms.core.filesmodel.service;


import com.sinosoft.pms.api.filesmodel.dto.ModelFilesQueryConditionDto;
import com.sinosoft.pms.api.filesmodel.dto.PrpDfilesModelDto;
import com.sinosoft.pms.api.filesmodel.dto.PrpDpayOfNoticeDto;

/**
* @description excel模板下载
* @author dongyingchun
* @date 2016年9月19日下午2:10:56
*/
public interface FileModelService {

	
	/**
	* @description 模板下载
	* @param modelFilesQueryConditionDto
	* @return
	* @author dongyingchun
	* @date 2016年9月19日下午2:12:44
	*/
	public PrpDfilesModelDto downLoadModelExcel(ModelFilesQueryConditionDto modelFilesQueryConditionDto);

	
	
	/**
	* @description 模板下载
	* @param prpDpayOfNoticeDto
	* @return InputStream
	* @author dongyingchun
	* @date 2016年9月19日下午2:12:44
	*/
	public String dowLoadPayOfNotice(PrpDpayOfNoticeDto prpDpayOfNoticeDto)throws Exception;
}
