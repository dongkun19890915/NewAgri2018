package com.sinosoft.agriclaim.core.individuation.service;

import com.sinosoft.agriclaim.api.individuation.dto.ReturnInfo;
import com.sinosoft.agriclaim.api.individuation.dto.SystemToImageRequsetDto;

/***
 * 
 * @description 信雅达图片上传
 * @author 周柯宇
 * @date 2017年12月27日 下午6:46:17
 */
public interface SystemToImageService {
	
	/***
	 * 
	 * @description 信雅达图片上传
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	public String transportXML(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;

	/***
	 * 
	 * @description 信雅达图片上传
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	public ReturnInfo transport(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;

}
