package com.sinosoft.agriclaim.api.common;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.common.dto.RequestImportDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
 * @description 表格上传下载类
 * @author 杨璐
 * @date 2018年01月01日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = ImportRateListingApi.PATH)
public interface ImportRateListingApi {
	public static final String PATH="importRateListing";
	
	/**
	 * 上传文件到文件服务器
	 * 
	 * @author 杨璐
	 * @date 2018年01月01日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "uploadBreedingList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> uploadFile(@RequestBody MultipartFile multipartFile) throws Exception;


	/**
	 * 解析养殖险excel文件
	 * @author: 杨璐
	 * @date: 2018年01月01日
	 * @param： wb
	 * @param：requestDto
	 * @return：
	 */
	@RequestMapping(value = "readBreedingList",method = {RequestMethod.POST})
    public @ResponseBody   Map<String,Object> readBreedExcelContent(@RequestBody RequestImportDto requestImportDto) throws Exception;
	/**
	 * 解析种植险excel文件
	 * @author: 杨璐
	 * @date: 2018年01月04日
	 * @param： wb
	 * @param：requestDto
	 * @return：
	 */
	@RequestMapping(value = "readPlantingList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,Object>readPlantingExcelContent(@RequestBody RequestImportDto requestImportDto) throws Exception;

	 /**
     * 文件模板下载
     * @author 杨璐
     * @date   2018/01/19
     * @param  map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "exportExcel",method = {RequestMethod.POST})
    @ResponseBody Map<String,String>  exportExcel(@RequestBody Map<String, String> map) throws Exception;

	/**
	 * 理算清单撤销
	 * @author 杨璐
	 * @date 2018/01/24
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteByListNo", method = { RequestMethod.POST })
	@ResponseBody
	Map<String, String> delete(@RequestBody Map<String, String> map) throws Exception;
	
}
