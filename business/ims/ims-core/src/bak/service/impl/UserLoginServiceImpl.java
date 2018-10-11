package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UserIdvDto;
import com.sinosoft.ims.api.kernel.dto.UtiIUserDto;
import com.sinosoft.ims.core.common.utils.PwdUtil;
import com.sinosoft.ims.core.kernel.dao.UtiIAccountDao;
import com.sinosoft.ims.core.kernel.dao.UtiIUserDao;
import com.sinosoft.ims.core.kernel.dao.UtiIUserIdvDao;
import com.sinosoft.ims.core.kernel.entity.*;
import com.sinosoft.ims.core.kernel.service.UserLoginService;
import com.sinosoft.ims.core.kernel.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserLoginServiceImpl extends BaseServiceImpl implements UserLoginService {

	/** log日志 */
	private static Log LOGGER = LogFactory.getLog(UserLoginServiceImpl.class);

	@Autowired
	private UtiIAccountDao utilAccoutnMapper;

	@Autowired
	private UtiIUserDao utiIUserMapper;
	
	@Autowired
	private UtiIUserIdvDao utiIUserIdvMapper;
	
	@Autowired
	private UserService userService;

	/**
	 * @description 用户登录校验
	 * @author chengzhuo
	 * @return UserReturnDto
	 * @data 2016/9/20 10:55
	 */
	@Override
	public UtiIUserDto checkUserLogin(UtiIUserDto userDto)  {
		
			UtiIUserKey utiIUserKey = new UtiIUserKey();
			UtiIUser utiIUser = new UtiIUser();
			UtiIUserDto resultUserDto = new UtiIUserDto();
			String userCode = userDto.getUserCode();

			/* 通过userCode获取用户表，判断用户表是否存在 */
			utiIUserKey.setUserCode(userCode);
			utiIUser = utiIUserMapper.findOne(utiIUserKey);
			if(utiIUser ==null){

				throw new BusinessException("用户名或密码错误");
			}
			// 密码加密&获取用户密码
			String password = userDto.getPassWord();
			String md5Pwd = PwdUtil.md5(password);
			List<UtiIAccount> list = utilAccoutnMapper.findAll(Specifications.<UtiIAccount>and()
					.eq("userCode",userDto.getUserCode()).build());
			String userPwd = list.get(0).getPassWord();

			// 判断密码是否相同&返回状态和用户个人信息
			if (!userPwd.equals(md5Pwd)) {

				throw new BusinessException("用户名或密码错误");
			}
			resultUserDto=convert(utiIUser, UtiIUserDto.class);
			return resultUserDto;
	}
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return ResponseDto
	* @throws Exception
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/
	@Override

	public ResponseDto forgetPwd(UserDto userDto) {
		ResponseDto responseDto = new ResponseDto();
		ResponseDto resultPasswd = new ResponseDto();
		UserIdvDto userIdvDto =  userService.queryUserInfo(userDto);
		//1、校验账号是否存在
		if(userIdvDto==null||userIdvDto.getUserCode()==null){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("该登录账号不存在");
			return responseDto;
		}
		//2、校验是否能够修改密码
		if(userIdvDto.getModifyPasswdFlag().equals("0")||userIdvDto.getModifyPasswdFlag()==null){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("对不起，管理员设置不允许您自行修改密码，请联系管理员");
			return responseDto;
		}
		//3、校验是否有维护密码邮箱
		if(userIdvDto.getEmail()==null||"".equals(userIdvDto.getEmail())){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("对不起，您未维护接收密码的邮箱，请联系管理员");
			return responseDto;
		}
		//4、生成密码
		String newPasswd = generatePwd();
		//5、修改密码服务
		userDto.setNewPassword(newPasswd);
		resultPasswd = userService.updatePasswd(userDto);
		if(resultPasswd==null||resultPasswd.getResultCode()=="9999"){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("对不起，修改密码失败，请联系管理员");
			return responseDto;
		}
		//6、调用发送邮箱服务(需要邮箱和密码)
		responseDto.setResultCode("0000");
		responseDto.setResultMsg("重新生成的密码已发送至邮箱");
		return responseDto;
	}

	/**
	* @description 校验是否有维护密码邮箱
	* @param userDto
	* @return ResponseDto
	* @throws Exception
	* @author chengzhuo
	* @date 2016年10月25日上午10:34:27
	*/
	public String checkEmail(UserDto userDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		String userCode = userDto.getUserCode();
		UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
		UtiIUserIdv utiIUserIdv= new UtiIUserIdv();
		UserIdvDto userIdvDto = new UserIdvDto();
		//通过userCode获取该用户是否有维护密码邮箱
		utiIUserIdvKey.setUserCode(userCode);
		utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
		userIdvDto = convert(utiIUserIdv, UserIdvDto.class);
		String Eamil = userIdvDto.getEmail();
		return Eamil;
	}
	
	/**
	* @description 生成由数字字母符号组成的明文密码
	* @return String
	* @author chengzhuo
	* @date 2016年10月25日上午11:19:45
	*/
	public String generatePwd(){
		StringBuffer password = new StringBuffer();
        for(int i = 0; i <= (int)(Math.random()*9)+7; i++) {
            int ran = (int)(Math.random()*94) + 33;
            char c = (char) ran;
            password.append(c);
        }
        String pwd = password.toString();
		return pwd;
	}
}
