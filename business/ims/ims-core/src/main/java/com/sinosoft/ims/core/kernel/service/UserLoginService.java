package com.sinosoft.ims.core.kernel.service;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserResultDto;
import com.sinosoft.ims.api.kernel.dto.ResponseComCodeDto;
import com.sinosoft.ims.api.kernel.dto.ResponseLoginDto;

import java.util.List;


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

	PrpDuserResultDto checkUserLogin(PrpDuserDto userDto) ;
	
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return

	* @
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/

	public ResponseDto forgetPwd(PrpDuserDto userDto) ;
	/**
	 * @description 承保系统登录后机构和菜单查询接口
	 * @param userCode 用户代码
	 * @param systemCode 系统代码
	 * @return ResponseLoginDto 返回机构和菜单信息
	 * @throws Exception
	 * @author 李冬松
	 * @date 9:41 2017/11/16
	 */
	public ResponseLoginDto queryLoginInfo(String userCode, String systemCode)throws Exception;
	/**
	*  判断是否是超级用户的方法
	* @param comCode,机构代码
	 *@param  userCode 用户代码
	* @return boolean
	* @throws Exception
	* @author 李冬松
	* @date 14:37 2017/11/17
	*/
	public boolean isSuperUser(String comCode, String userCode) throws Exception;

	/**
	* 承保系统登录校验用户名密码service接口
	* @param userCode 用户名
	* @param password 密码
	* @return boolean 登录成功返回true
	* @throws Exception
	* @author 李冬松
	* @date 15:28 2017/11/18
	*/
	public boolean checkUserPassword(String userCode,String password) throws Exception;



	/**
	 * 修改用户密码
	 * @param oldpwd
	 * @param newpwd
	 * @return
	 */
	boolean modifypwd(String userCode,String oldpwd,String newpwd)throws Exception;
	/**
	 * 登录机构查询
	 * @param userCode 用户代码的map
	 * @return ResponseComCodeDto 机构信息具体见dto说明
	 * @throws Exception
	 * @author 李冬松
	 * @date 16:53 2018/1/23
	 */
	public List<ResponseComCodeDto> findComCodeList(String userCode)throws Exception;

}

