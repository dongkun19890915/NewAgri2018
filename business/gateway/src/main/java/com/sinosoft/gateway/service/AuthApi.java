package com.sinosoft.gateway.service;

import com.sinosoft.gateway.service.dto.AuthResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @description 权限验证
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:39:30
 */
@FeignClient(value = "sso",path = "api")
public interface AuthApi {

	@RequestMapping(value = "/validToken", method = RequestMethod.POST)
	public AuthResp validToken(@RequestParam("token")String token);

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public AuthResp logout(@RequestParam("token")String token);
}
