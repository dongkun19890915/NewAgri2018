package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.api.kernel.dto.PrpDuserResultDto;
import com.sinosoft.ims.api.kernel.dto.ResponseComCodeDto;
import com.sinosoft.ims.api.kernel.dto.ResponseLoginDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;

import java.util.List;
import java.util.Map;


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
    @RequestMapping(value = "checkLogin", method =  {RequestMethod.POST})
	public @ResponseBody PrpDuserResultDto checkUserLogin(@RequestBody PrpDuserDto userDto) ;

	@RequestMapping(value = "test", method =  {RequestMethod.GET})
	public void test() ;
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return ResponseDto
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/
    @RequestMapping(value = "forgetPwd", method =  {RequestMethod.POST})
	public ResponseDto forgetPwd(@RequestBody PrpDuserDto userDto) ;
    /**
    * 承保系统登录后机构和菜单查询接口
    * @param userCode 用户代码
	 * @param systemCode 系统代码
    * @return ResponseDto 返回是否登录成功 用户机构和菜单信息
    * @throws Exception
    * @author 李冬松
    * @date 9:41 2017/11/16
    */
	@RequestMapping(value = "login",method = {RequestMethod.POST})
	public @ResponseBody
	ResponseLoginDto queryLoginInfo(@RequestBody Map<String ,String> map)throws Exception;

	/**
	*  承保系统登录查询用户名密码
	* @param userCode 用户代码
	* @param password 密码
	* @return boolean 返回是否登录成功
	* @throws Exception
	* @author 李冬松
	* @date 15:13 2017/11/18
	*/
	@RequestMapping(value = "checkUserPassword",method = {RequestMethod.POST})
	public boolean checkUserPassword(@RequestBody Map<String ,String> map)throws Exception;


	/**
	 * 修改用户密码
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "modifypwd", method = RequestMethod.POST)
//	Map<String,String> modifypwd(@RequestParam("oldpwd") String oldpwd, @RequestParam("newpwd") String newpwd)throws Exception;
	Map<String,String> modifypwd(@RequestBody Map<String,String> map)throws Exception;

	@RequestMapping(value = "queryComCodeList",method = {RequestMethod.POST})
	public List<ResponseComCodeDto> queryComCodeList(@RequestBody Map<String,String> map)throws Exception;

}

