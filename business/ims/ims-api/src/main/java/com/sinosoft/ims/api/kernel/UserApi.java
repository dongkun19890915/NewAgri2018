package com.sinosoft.ims.api.kernel;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.UserImportDto;
import com.sinosoft.ims.api.kernel.dto.UserQueryConditionDto;

@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UserApi.PATH)
public interface UserApi {

	public static final String PATH = "user";

	/**
	* @description 用户信息查询列表（分页）
	* @param userQueryCondition
	* @return PageInfo<UserIdvDto>
	* @
	* @author chengzhuo
	* @date 2016年9月27日下午4:28:54
	*/
    @RequestMapping(value = "/queryUserList", method =  {RequestMethod.POST})
	public PageInfo<PrpDuserDto> queryUserList(@RequestBody UserQueryConditionDto userQueryCondition) ;

	/**
	 * @description 单个用户增添服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:20:46
	 */
	@RequestMapping(value = "/saveUser", method =  {RequestMethod.POST})
	public ResponseDto saveUser(@RequestBody PrpDuserDto userDto);

	/**
	 * @description 修改用户
	 * @param userDto
	 * @return ResponseDto
	 * @author dongyingchun
	 * @date 2016年9月20日上午9:21:00
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseDto updateUser(@RequestBody PrpDuserDto userDto) ;

	/**
	 * @description 判断该账号能否修改密码
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月25日下午2:14:21
	 */
	/*public ResponseDto checkUpdatePasswd(UserDto userDto) ;*/

	/**
	 * @description 密码校验
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:11
	 */
    @RequestMapping(value = "/checkPwd", method = RequestMethod.POST)
	public ResponseDto checkUserPasswd(@RequestBody PrpDuserDto userDto) ;

	/**
	 * @description 修改密码服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:33
	 */
	@RequestMapping(value = "/updatePasswd", method =  {RequestMethod.POST})
	public ResponseDto updatePasswd(@RequestBody PrpDuserDto userDto) ;

	/**
	 * @description 根据用户代码查询用户
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:21:58
	 */
    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.POST)
	public PrpDuserDto queryUserInfo(@RequestParam(value = "userCode") String userCode) ;

	/**
	 * @description 用户信息下载功能
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:23:35
	 */
    @RequestMapping(value = "/downUserInfo", method = RequestMethod.POST)
	public  Map<String, String> downloadUserInfo(@RequestBody PrpDuserDto userDto) ;

	
	/**
	* @description 批量导入用户信息
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年9月27日下午4:30:05
	*/
    @RequestMapping(value = "/importUsers", method = RequestMethod.POST)
	public ResponseDto importUsers(@RequestBody UserImportDto userImportDto) ;

	/**
	* @description （机构获取服务-根据用户获取该用户可操作的机构服务）
	* @param userDto
	* @return List<PrpDCompanyDto>
	* @author chengzhuo
	* @date 2016年9月23日下午4:44:39
	*/
    @RequestMapping(value = "/queryUserComs", method = RequestMethod.POST)
	public List<PrpDcompanyDto> getUserComCode(@RequestBody PrpDuserDto userDto) ;
	
	
//	/**
//	* @description （获取该用户所属保险公司）
//	* @param userDto
//	* @return ResponseDto
//	* @
//	* @author chengzhuo
//	* @date 2016年10月7日下午5:41:14
//	*/
//    @RequestMapping(value = "/queryHeadComCode", method = RequestMethod.POST)
//	public PrpDcompanyDto queryHeadComCode(@RequestBody PrpDuserDto userDto) ;

//    /**
//     * @description （根据当前机构查询下级机构）
//     * @param userDto
//     * @return
//     * @author chengzhuo
//     * @date 2016年9月23日下午4:43:17
//     */
//    @RequestMapping(value = "/queryDownComCode", method = RequestMethod.POST)
//    public List<PrpDcompanyDto> queryDownComCode(@RequestBody UserDto userDto) ;

	/**
	* @description （用户重复性校验）
	* @param userDto
	* @return ResponseDto
	* @
	* @author chengzhuo
	* @date 2016年10月8日下午2:04:57
	*/
    @RequestMapping(value = "/checkUserCode", method = RequestMethod.POST)
	public ResponseDto checkRepeatUserCode(@RequestBody PrpDuserDto userDto) ;
	
	/**
	 * @description 获取用户所属机构
	 * @param userDto
	 * @return ResponseDto
	 * @
	 * @author chengzhuo
	 * @date 2016年10月8日下午2:04:57
	 */
	@RequestMapping(value = "/queryUserCompany", method = RequestMethod.POST)
	public PrpDcompanyDto queryUserCompany(PrpDuserDto userDto) ;
	/**
	 * @description 业务员查询服务
	 * @param userDto
	 * @return List<PrpDuserDto>
	 * @throws Exception
	 * @author lishaoru
	 * @since 2017年9月23日 15:30:58
	 */
	@PostMapping(value = "/getHandlerInfo")
	public List<PrpDuserDto> getHandlerInfo(PrpDuserDto userDto) throws Exception ;

	/**
	 * @description 密码修改API接口
	 * @param [userCode, oldPassword, newPassword]
	 * @return java.lang.String
	 * @throws Exception
	 * @author 李冬松
	 * @date 10:16 2017/10/13
	 */
	@RequestMapping(value = "modifyPassword",method = RequestMethod.POST)
	public @ResponseBody String modifyPassword(@RequestBody Map<String ,String> map)throws Exception;

}
