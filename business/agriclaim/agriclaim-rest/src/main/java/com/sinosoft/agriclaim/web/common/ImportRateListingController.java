package com.sinosoft.agriclaim.web.common;

import com.sinosoft.agriclaim.api.common.ImportRateListingApi;
import com.sinosoft.agriclaim.api.common.dto.RequestImportDto;
import com.sinosoft.agriclaim.core.common.service.ImportRateListingService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @description 表格上传下载类
 * @author 杨璐
 * @date 2018年01月01日
 */
@RestController
@RequestMapping(ImportRateListingApi.PATH)
public class ImportRateListingController implements ImportRateListingApi {

	@Autowired
	private ImportRateListingService importRateListingService;

	/**
	 * 上传文件到文件服务器
	 * 
	 * @author 杨璐
	 * @date 2018年01月01日
	 * @return
	 * @throws Exception
	 */

	@Override
	public @ResponseBody Map<String, String> uploadFile(@RequestBody MultipartFile multipartFile) throws Exception {
		return importRateListingService.uploadFile(multipartFile);
	}

	/**
	 * 解析养殖险excel文件
	 * 
	 * @author: 杨璐
	 * @date: 2018年01月01日
	 * @param：requestDto @return：
	 */
	@Override
	public @ResponseBody Map<String,Object> readBreedExcelContent(@RequestBody RequestImportDto requestImportDto)
			throws Exception {
		return importRateListingService.readBreedExcelContent(requestImportDto);
	}

	/**
	 * 解析种植险excel文件
	 * 
	 * @author: 杨璐
	 * @date: 2018年01月04日 @param： wb
	 * @param：requestDto @return：
	 */
	@Override
	public @ResponseBody Map<String, Object> readPlantingExcelContent(@RequestBody RequestImportDto requestImportDto)
			throws Exception {
		return importRateListingService.readPlantingExcelContent(requestImportDto);
	}

	/**
	 * 文件模板下载
	 * 
	 * @author 杨璐
	 * @date 2018/01/19
	 * @param map
	 * @return
	 * @throws Exception
	 */

	@Override
	public @ResponseBody Map<String, String> exportExcel( @RequestBody Map<String, String> map) throws Exception {
		return importRateListingService.exportExcel(map);
	}  

	/**
	 * 理算清单撤销
	 * @author 杨璐
	 * @date 2018/01/24
	 * @param map
	 * @return
	 * @throws Exception
	 */

	@Override
	public  @ResponseBody Map<String, String> delete(@RequestBody Map<String, String> map) throws Exception {
		
		
		return importRateListingService.delete(map);
	}  
	
}
