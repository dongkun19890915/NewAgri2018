package com.sinosoft.ims.core.kernel.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UserImportDto;
import com.sinosoft.ims.api.kernel.dto.UserQueryConditionDto;

public interface UserService {

	/**
	* @description 用户信息查询列表（分页）
	* @param userQueryCondition
	* @return PageInfo<UserIdvDto>
	* @
	* @author chengzhuo
	* @date 2016年9月27日下午4:28:54
	*/
    PageInfo<PrpDuserDto> queryUserPage(UserQueryConditionDto userQueryCondition) ;

	/**
	 * @description 单个用户增添服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:20:46
	 */
    ResponseDto saveUser(PrpDuserDto userDto) ;

	/**
	 * @description 修改用户
	 * @param userDto
	 * @return ResponseDto
	 * @author dongyingchun
	 * @date 2016年9月20日上午9:21:00
	 */
    ResponseDto updateUser(PrpDuserDto userDto) ;

	/**
	 * @description 判断该账号能否修改密码
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月25日下午2:14:21
	 */
    ResponseDto checkUpdatePasswd(UserDto userDto) ;

	/**
	 * @description 密码校验
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:11
	 */
    ResponseDto checkeUserPasswd(PrpDuserDto userDto) ;

	/**
	 * @description 修改密码服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:33
	 */
    ResponseDto updatePasswd(PrpDuserDto userDto) ;

	/**
	 * @description 根据用户代码查询用户
	 * @param userCode
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:58
	 */
    PrpDuserDto queryUserInfo(String userCode) ;

	/**
	 * @description 用户信息下载功能
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:23:35
	 */
    Map<String, String> downloadUserInfo(PrpDuserDto userDto) ;

	
	/**
	* @description 批量导入用户信息
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年9月27日下午4:30:05
	*/
    ResponseDto importUserInfo(UserImportDto userImportDto) ;


	/**
	 * @description （根据当前机构查询下级机构）
	 * @param prpDcompanyDto
	 * @return
	 * @author chengzhuo
	 * @date 2016年9月23日下午4:43:17
	 */
    List<PrpDcompanyDto> queryDownComCodeService(UserDto userDto) ;
	
	
	/**
	* @description （机构获取服务-根据用户获取该用户可操作的机构服务）
	* @param userDto
	* @return List<PrpDCompanyDto>
	* @author chengzhuo
	* @date 2016年9月23日下午4:44:39
	*/
    List<PrpDcompanyDto> queryUserComCodeService(PrpDuserDto userDto) ;
	
	
	/**
	* @description （获取该用户所属保险公司）
	* @param userDto
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年10月7日下午5:41:14
	*/
    PrpDcompanyDto queryHeadComCodeService(PrpDuserDto userDto) ;
	
	
	/**
	* @description （用户重复性校验）
	* @param userDto
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年10月8日下午2:04:57
	*/
    ResponseDto checkRepeatUserCode(PrpDuserDto userDto) ;
	
	/**
	 * @description 获取用户所属机构
	 * @param userDto
	 * @return ResponseDto
	 * @
	 * @author chengzhuo
	 * @date 2016年10月8日下午2:04:57
	 */
    PrpDcompanyDto queryUserCompany(PrpDuserDto userDto) ;
	/**
	 * @description 业务员查询服务
	 * @param userDto
	 * @return List<PrpDuserDto>
	 * @throws Exception
	 * @author lishaoru
	 * @since 2017年9月23日 15:30:58
	 */
    List<PrpDuserDto> getHandlerInfo(PrpDuserDto userDto) throws Exception;
	/**
	 *  修改员工密码prpDuser
	 * @param userCode,用户代码 oldPassword, 旧密码 newPassword 新密码]
	 * @return java.lang.String 成功返回success,失败返回failed
	 * @throws Exception
	 * @author 李冬松
	 * @date 11:05 2017/10/13
	 */
	public String modifyPassword(String userCode,String oldPassword,String newPassword)throws Exception;

}
