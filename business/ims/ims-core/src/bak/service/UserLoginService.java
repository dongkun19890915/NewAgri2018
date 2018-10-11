package com.sinosoft.ims.core.kernel.service;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UtiIUserDto;


/**
 * @description 用户登录服务
 * @author chengzhuo
 * @data 2016/9/20 14:40
 *
 */
public interface UserLoginService {
	
	/**
	* @description （用户登录验证）
	* @param userDto
	* @return UserReturnDto
	* @author chengzhuo
	* @date 2016年9月23日下午4:44:53
	*/

	public UtiIUserDto checkUserLogin(UtiIUserDto userDto) ;
	
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return

	* @
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/

	public ResponseDto forgetPwd(UserDto userDto) ;
	
}

