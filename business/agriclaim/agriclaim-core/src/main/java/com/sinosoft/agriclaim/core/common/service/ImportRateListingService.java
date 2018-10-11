package com.sinosoft.agriclaim.core.common.service;

import com.sinosoft.agriclaim.api.common.dto.RequestImportDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImportRateListingService {
	/**
	 * 上传文件到文件服务器
	 * 
	 * @author 杨璐
	 * @date 2018年01月01日
	 * @return
	 * @throws Exception
	 */
	Map<String, String> uploadFile(MultipartFile multipartFile) throws Exception;

	/**
	 * 解析养殖险excel文件
	 * 
	 * @author: 杨璐
	 * @date: 2018年01月01日
	 * @param：requestDto @return：
	 */
	Map<String,Object> readBreedExcelContent(RequestImportDto requestImportDto) throws Exception;

	/**
	 * 解析种植险excel文件
	 * 
	 * @author: 杨璐
	 * @date: 2018年01月04日 @param： wb
	 * @param：requestDto @return：
	 */
	Map<String,Object> readPlantingExcelContent(RequestImportDto requestImportDto) throws Exception;

	/**
	 * 文件模板下载
	 * 
	 * @author 杨璐
	 * @date 2018/01/19
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */

	Map<String, String> exportExcel(Map<String, String> map) throws IOException;

	/**
	 * 理算清单撤销
	 * @author 杨璐
	 * @date 2018/01/24
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, String> delete(Map<String, String> map) throws Exception;

}
