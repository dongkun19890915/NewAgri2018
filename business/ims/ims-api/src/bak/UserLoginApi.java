package com.sinosoft.ims.api.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UtiIUserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @description 用户登录服务
 * @author chengzhuo
 * @data 2016/9/20 14:40
 *
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UserLoginApi.PATH)
public interface UserLoginApi {

	public static final String PATH = "login";
	
	/**
	* @description （用户登录验证）
	* @param userDto
	* @return UserReturnDto
	* @author chengzhuo
	* @date 2016年9月23日下午4:44:53
	*/
    @RequestMapping(value = "checkLogin")
	public UtiIUserDto checkUserLogin(@RequestBody UtiIUserDto userDto) ;
	
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return ResponseDto
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/
    @RequestMapping("forgetPwd")
	public ResponseDto forgetPwd(@RequestBody UserDto userDto) ;
	
}

