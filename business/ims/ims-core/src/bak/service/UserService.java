package com.sinosoft.ims.core.kernel.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.PrpDCompanyDto;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UserIdvDto;
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
	public PageInfo<UserIdvDto> queryUserPage(UserQueryConditionDto userQueryCondition) ;

	/**
	 * @description 单个用户增添服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:20:46
	 */
	public ResponseDto saveUser(UserDto userDto) ;

	/**
	 * @description 修改用户
	 * @param userDto
	 * @return ResponseDto
	 * @author dongyingchun
	 * @date 2016年9月20日上午9:21:00
	 */
	public ResponseDto updateUser(UserDto userDto) ;

	/**
	 * @description 判断该账号能否修改密码
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月25日下午2:14:21
	 */
	public ResponseDto checkUpdatePasswd(UserDto userDto) ;

	/**
	 * @description 密码校验
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:11
	 */
	public ResponseDto checkeUserPasswd(UserDto userDto) ;

	/**
	 * @description 修改密码服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:33
	 */
	public ResponseDto updatePasswd(UserDto userDto) ;

	/**
	 * @description 根据用户代码查询用户
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:58
	 */
	public UserIdvDto queryUserInfo(UserDto userDto) ;

	/**
	 * @description 用户信息下载功能
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:23:35
	 */
	public  Map<String, String> downloadUserInfo(UserDto userDto) ;

	
	/**
	* @description 批量导入用户信息
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年9月27日下午4:30:05
	*/
	public ResponseDto importUserInfo(UserImportDto userImportDto) ;


	/**
	 * @description （根据当前机构查询下级机构）
	 * @param prpDcompanyDto
	 * @return
	 * @author chengzhuo
	 * @date 2016年9月23日下午4:43:17
	 */
	public List<PrpDCompanyDto> queryDownComCodeService(UserDto userDto) ;
	
	
	/**
	* @description （机构获取服务-根据用户获取该用户可操作的机构服务）
	* @param userDto
	* @return List<PrpDCompanyDto>
	* @author chengzhuo
	* @date 2016年9月23日下午4:44:39
	*/
	public List<PrpDCompanyDto> queryUserComCodeService(UserDto userDto) ;
	
	
	/**
	* @description （获取该用户所属保险公司）
	* @param userDto
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年10月7日下午5:41:14
	*/
	public PrpDCompanyDto queryHeadComCodeService(UserDto userDto) ;
	
	
	/**
	* @description （用户重复性校验）
	* @param userDto
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年10月8日下午2:04:57
	*/
	public ResponseDto checkRepeatUserCode(UserDto userDto) ;
	
	/**
	 * @description 获取用户所属机构
	 * @param userDto
	 * @return ResponseDto
	 * @
	 * @author chengzhuo
	 * @date 2016年10月8日下午2:04:57
	 */
	public PrpDCompanyDto queryUserCompany(UserDto userDto) ;

}
