package com.sinosoft.agriclaim.web.individuation;

import com.sinosoft.agriclaim.api.individuation.SystemToImageApi;
import com.sinosoft.agriclaim.api.individuation.dto.ReturnInfo;
import com.sinosoft.agriclaim.api.individuation.dto.SystemToImageRequsetDto;
import com.sinosoft.agriclaim.core.individuation.service.SystemToImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/***
 * 
 * @description 信雅达图片上传
 * @author 周柯宇
 * @date 2017年12月27日 下午6:46:17
 */
@RestController
@RequestMapping(value = SystemToImageController.PATH)
public class SystemToImageController implements SystemToImageApi {

	@Autowired
	private SystemToImageService service;
	/***
	 * 
	 * @description 查看上传次数
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	@Override
	@ResponseBody
	public Map<String,String> transportXML(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {

		String requestXml=service.transportXML(systemToImageRequsetDto);
		Map<String,String> map = new HashMap<>(1);
		map.put("requestXml",requestXml);
		return map;
	}
	
	/***
	 * 
	 * @description 信雅达图片上传
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	@Override
	@ResponseBody
	public ReturnInfo transport(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
		
		return service.transport(systemToImageRequsetDto);
	}

}
