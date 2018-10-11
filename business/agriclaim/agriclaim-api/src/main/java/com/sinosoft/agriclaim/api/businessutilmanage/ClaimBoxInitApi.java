package com.sinosoft.agriclaim.api.businessutilmanage;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitRequestVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitResponseVo;
/**
 * @description: 类功能简述：初始化下拉框复选框服务接口
 * @author 安齐崇
 * @date 2017年12月9日下午4:42:21
 *
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = ClaimBoxInitApi.PATH)
public interface ClaimBoxInitApi {
	public static final String PATH = "common";
	/**
	 * @description:方法功能简述: 初始化下拉框复选框服务方法
	 * @author 安齐崇
	 * @date 2017年12月9日下午4:42:12
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "queryAllClaimBox",method = {RequestMethod.POST})
	@ResponseBody
	ClaimBoxInitResponseVo queryAllClaimBox(@RequestBody ClaimBoxInitRequestVo requestDto) throws Exception;
}
