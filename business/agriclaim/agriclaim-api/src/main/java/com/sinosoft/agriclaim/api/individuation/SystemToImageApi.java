package com.sinosoft.agriclaim.api.individuation;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.individuation.dto.ReturnInfo;
import com.sinosoft.agriclaim.api.individuation.dto.SystemToImageRequsetDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/***
 * 
 * @description 信雅达图片上传
 * @author 周柯宇
 * @date 2017年12月27日 下午6:46:17
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = SystemToImageApi.PATH)
public interface SystemToImageApi {

	public static final String PATH = "systemToImage";
	
	/***
	 * 
	 * @description 信雅达图片上传
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	@RequestMapping(value = "transportXML",method = {RequestMethod.POST})
	@ResponseBody
	public Map<String,String> transportXML(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;
	
	/***
	 * 
	 * @description 查看上传次数
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return ReturnInfo
	 * @Throws Exception
	 */
	@RequestMapping(value = "transport",method = {RequestMethod.POST})
	@ResponseBody
	public ReturnInfo transport(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;
}
