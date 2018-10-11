package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.MD5Util;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.MenuTreeDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigDto;
import com.sinosoft.ims.api.auth.dto.UtiUserLoginDto;
import com.sinosoft.ims.api.kernel.dto.*;
import com.sinosoft.ims.core.auth.dao.UtiGradeTaskDao;
import com.sinosoft.ims.core.auth.dao.UtiPlatConfigDao;
import com.sinosoft.ims.core.auth.dao.UtiUserGradeTaskDao;
import com.sinosoft.ims.core.auth.dao.UtiUserLoginDao;
import com.sinosoft.ims.core.auth.entity.UtiUserLogin;
import com.sinosoft.ims.core.auth.entity.UtiUserLoginKey;
import com.sinosoft.ims.core.auth.service.ShowMenuService;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.dao.PrpDuserDao;
import com.sinosoft.ims.core.kernel.entity.*;
import com.sinosoft.ims.core.kernel.service.UserLoginService;
import com.sinosoft.ims.core.kernel.service.UserService;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sinosoft.ims.IMSConstant.DILIMITER;

@Service
@Transactional
public class UserLoginServiceImpl extends BaseServiceImpl implements UserLoginService {

	/**
	 * log日志
	 */
	private static Log LOGGER = LogFactory.getLog(UserLoginServiceImpl.class);

	@Autowired
	private PrpDuserDao prpDuserDao;

	@Autowired
	private UserService userService;

	@Autowired
	private UtiUserLoginDao utiUserLoginDao;

	@Autowired
	private UtiPlatConfigDao utiPlatConfigDao;

	@Autowired
	private UtiUserGradeTaskDao utiUserGradeTaskDao;
	@Autowired
	private UtiGradeTaskDao utiGradeTaskDao;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PrpDcompanyDao prpDcompanyDao;
	@Autowired
	private ShowMenuService showMenuService;
	/**
	 * @description 用户登录校验
	 * @author chengzhuo
	 * @return UserReturnDto
	 * @data 2016/9/20 10:55
	 */
	@Override
	public PrpDuserResultDto checkUserLogin(PrpDuserDto userDto)  {
		PrpDuserKey prpDuserKey = new PrpDuserKey();
		PrpDuser prpDuser = new PrpDuser();
		PrpDuserDto resultUserDto = new PrpDuserDto();
		String userCode = userDto.getUserCode();

		PrpDuserResultDto prpDuserResultDto = new PrpDuserResultDto();



			/* 通过userCode获取用户表，判断用户表是否存在 */
		prpDuserKey.setUserCode(userCode);
		LOGGER.error("--userCode=" + userCode);
		try {
			prpDuser = prpDuserDao.findOne(prpDuserKey);
		} catch (NullPointerException e) {
			prpDuserResultDto.setMsg("用户名或密码错误");
			return prpDuserResultDto;
		}
		if (prpDuser == null) {
			//throw new BusinessException("用户名或密码错误");
			prpDuserResultDto.setMsg("用户名或密码错误");
			return prpDuserResultDto;
		}
		// 密码加密&获取用户密码
		String password = userDto.getPassword();
//			String md5Pwd = PwdUtil.md5(password);
		String md5Pwd = MD5Util.MD5(password);
		String userPwd = prpDuser.getPassword();
		LOGGER.error("----------oldpassword=" + password);
		// 判断密码是否相同&返回状态和用户个人信息
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error(userPwd + "=userPwd=" + md5Pwd);
		}
		if (!userPwd.equals(md5Pwd)) {
			//throw new BusinessException("用户名或密码错误");
			prpDuserResultDto.setMsg("用户名或密码错误");
			return prpDuserResultDto;
		}
		//判断密码过期日期
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("=PasswordExpireDate=" + prpDuser.getPasswordExpireDate());
		}
		if (prpDuser.getPasswordExpireDate() != null) {
			DateTime now = new DateTime(new Date(), DateTime.YEAR_TO_SECOND);
			DateTime today = new DateTime(now, DateTime.YEAR_TO_DAY);
			if (prpDuser.getPasswordExpireDate().before(today)) {
				//throw new BusinessException("用户密码已过期，请联系管理员！");
				prpDuserResultDto.setMsg("用户密码已过期，请联系管理员！");
				return prpDuserResultDto;
			}
		}
		resultUserDto = this.convert(prpDuser, PrpDuserDto.class);

		prpDuserResultDto.setPrpDuserDto(resultUserDto);
		prpDuserResultDto.setMsg(null);
		return prpDuserResultDto;
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

	public ResponseDto forgetPwd(PrpDuserDto userDto) {
		ResponseDto responseDto = new ResponseDto();
		ResponseDto resultPasswd = new ResponseDto();
		PrpDuserKey prpDuserKey = new PrpDuserKey();
		prpDuserKey.setUserCode(userDto.getUserCode());
		PrpDuser prpDuser =  prpDuserDao.findOne(prpDuserKey);
		//1、校验账号是否存在
		if(prpDuser == null || prpDuser.getUserCode() == null){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("该登录账号不存在");
			return responseDto;
		}
		//2、校验是否能够修改密码
//		if(prpDuser.getModifyPasswdFlag().equals("0") || prpDuser.getModifyPasswdFlag()==null){
//			responseDto.setResultCode("9999");
//			responseDto.setResultMsg("对不起，管理员设置不允许您自行修改密码，请联系管理员");
//			return responseDto;
//		}
		//3、校验是否有维护密码邮箱
		if(prpDuser.getEmail() == null || "".equals(prpDuser.getEmail())){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("对不起，您未维护接收密码的邮箱，请联系管理员");
			return responseDto;
		}
		//4、生成密码
		String newPasswd = generatePwd();
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("newPasswd=" + newPasswd);
		}
		//5、修改密码服务
		userDto.setPassword(newPasswd);
		resultPasswd = userService.updatePasswd(userDto);
		if(resultPasswd == null || resultPasswd.getResultCode().equals("9999")){
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
	/*public String checkEmail(UserDto userDto) throws Exception {
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
	}*/

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
	/**
	* 承保系统登录后机构和菜单查询接口
	 * @param userCode 用户代码
	 * @param systemCode 系统代码
	 * @return ResponseLoginDto 返回机构和菜单信息
	* @throws Exception
	* @author 李冬松
	* @date 14:14 2017/11/17
	*/
	@Override
	public ResponseLoginDto queryLoginInfo(String userCode, String systemCode) throws Exception {
		if(userCode == null || userCode.equals("")){
			throw new DataVerifyException("用户代码不能为空！");
		}
		if(systemCode == null || systemCode.equals("")){
			throw new DataVerifyException("系统代码不能为空！");
		}
		RequestLoginDto requestLoginDto = new RequestLoginDto();
		requestLoginDto.setUserCode(userCode);
		requestLoginDto.setSystemCode(systemCode);

		ResponseLoginDto responseLoginDto = new ResponseLoginDto();
		responseLoginDto.setUserCode(userCode);
		//查询用户登录机构信息
		StringBuilder sql=new StringBuilder("SELECT DISTINCT p FROM UtiUserGrade u, PrpDcompany p " )
				.append(" WHERE u.userCode = :userCode ")
				.append(" and u.comCode = p.comCode order by p.comLevel, p.comCode");
		/**2、执行查询*/
		Query query=entityManager.createQuery(sql.toString());
		query.setParameter("userCode",requestLoginDto.getUserCode());
		List<PrpDcompany> prpDcompanyList=query.getResultList();
		List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();
		/**3、转换*/
		convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);
		if(prpDcompanyDtoList == null || prpDcompanyDtoList.size() == 0){
			throw new DataVerifyException("没有登录机构权限");
		}
		String comCode = prpDcompanyDtoList.get(0).getComCode();//初始登录机构
		responseLoginDto.setLoginComCode(comCode);
		requestLoginDto.setLoginComCode(comCode);
		requestLoginDto.setTaskCode(systemCode);//将systemCode作为taskCode
		requestLoginDto = showMenuService.generateCheckPowerConditon(requestLoginDto);
		boolean ifCheckPower = showMenuService.checkPower(requestLoginDto);

		if (!ifCheckPower) {
			throw new DataVerifyException("没有登录系统的权限");
		}

		responseLoginDto.setUserComInfo(prpDcompanyDtoList);//加入登录机构
		//查询用户权限菜单
		List<MenuTreeDto> menuTreeDtoList = showMenuService.queryUserMenu(requestLoginDto,false);//不需要再次补充requestLoginDto里的参数
		responseLoginDto.setUserMenuInfo(menuTreeDtoList);
		return responseLoginDto;
	}

	/**
	* 是否是超级用户
	* @param comCode, 机构代码
	 * @param  userCode   用户代码
	* @return boolean
	* @throws Exception
	* @author 李冬松
	* @date 14:30 2017/11/17
	*/
	public boolean isSuperUser(String comCode, String userCode) throws Exception {
		String key = comCode + DILIMITER + userCode;
//		if (superUsers.containsKey(key)) {
//			return true;
//		}
		PrpDcompanyKey prpDcompanyKey=new PrpDcompanyKey(comCode);
		PrpDcompanyDto prpDcompanyDto=convert(prpDcompanyDao.findOne(prpDcompanyKey),PrpDcompanyDto.class);
		boolean topCompany;
		if (prpDcompanyDto != null
				&& prpDcompanyDto.getUpperComCode().equals(
				prpDcompanyDto.getComCode())) {
			topCompany=true;
		}else {
			topCompany=false;
		}
		if (topCompany == true && userCode.equals(StringUtils.newString('0', userCode.length()))
				&& userCode.length() >= 8) {
			//superUsers.put(key, "");
			return true;
		}
		return false;
	}
	/**
	* 承保系统登录，校验用户名密码
	* @param userCode,用户代码
	* @param password 密码
	* @return boolean
	* @throws Exception
	* @author 李冬松
	* @date 15:31 2017/11/18
	*/
	@Override
	public boolean checkUserPassword(String userCode, String password) throws Exception {
		try {
			//执行登录的方法
			userLogin(userCode,password);
		} catch (DataVerifyException dataVerifyException) {
			//如果登录不成功执行的代码
			DateTime now = new DateTime(new Date(), DateTime.YEAR_TO_SECOND);
			UtiUserLoginKey utiUserLoginKey = new UtiUserLoginKey(userCode);
			UtiUserLogin u=utiUserLoginDao.findOne(utiUserLoginKey);
			UtiUserLoginDto utiUserLoginDto = convert(u, UtiUserLoginDto.class);
			if (utiUserLoginDto != null) {
				//每次登录失败，失败次数+1
				int faliLoginCount = Integer.parseInt(utiUserLoginDto.getFailLoginCount()) + 1;
				utiUserLoginDto.setFailLoginCount("" + faliLoginCount);
				utiUserLoginDto.setLastFailLoginTime(now.toString(DateTime.YEAR_TO_SECOND));
				//超过三次即锁定
				int failLoginLimit = 3;
				try {
					failLoginLimit = Integer.parseInt(AppConfig.get("sysconst.FAIL_LOGIN_LIMIT"));
				} catch (Exception e) {
				}

				if (faliLoginCount >= failLoginLimit) {
					int lockLoginperiod = 30;
					try {
						lockLoginperiod = Integer.parseInt(AppConfig.get("sysconst.LOCK_LOGIN_PERIOD"));
					} catch (Exception e) {
					}
					utiUserLoginDto.setLockToTime(now.addMinute(lockLoginperiod).toString(DateTime.YEAR_TO_SECOND));
				}
				//若登录失败过则执行更新数据库的记录
				UtiUserLogin utiUserLogin=convert(utiUserLoginDto,UtiUserLogin.class);
				utiUserLoginDao.updated(utiUserLogin.getLastSuccessLoginTime(),utiUserLogin.getLastFailLoginTime(),
						utiUserLogin.getFailLoginCount(),utiUserLoginDto.getLockToTime(),userCode);

			} else {
				utiUserLoginDto = new UtiUserLoginDto();
				utiUserLoginDto.setUserCode(userCode);
				utiUserLoginDto.setFailLoginCount("1");
				utiUserLoginDto.setLastSuccessLoginTime("");
				utiUserLoginDto.setLastFailLoginTime(now.toString(DateTime.YEAR_TO_SECOND));
				UtiUserLogin utiUserLogin=convert(utiUserLoginDto, UtiUserLogin.class);
				//若之前没有失败过则执行保存操作
				utiUserLoginDao.save(utiUserLogin);
			}
			throw dataVerifyException;
		}
		int intCount = 0;
		boolean bSuccess = true; //查询是否成功
		//校验用户信息
		try {
			PrpDuser prpDuser = prpDuserDao.findOne(new PrpDuserKey(userCode)); //得到BLPrpDuser对象
			if (prpDuser == null) {
				intCount = 100;
			}
			if (intCount != 0) {
				bSuccess = false;
				throw new DataVerifyException("用户代码或密码错误!");
			} else {
				if (prpDuser.getValidStatus().equals("0")) {
					bSuccess = false;
					throw new DataVerifyException("此用户已注销!");
				}
			}
		} catch (Exception ex2) {
			bSuccess = false;
			throw new DataVerifyException("查询用户发生异常,请重试!");
		}
		return bSuccess;
	}
	/**
	*  承保系统登录，校验用户名密码子方法
	* @param userCode 用户代码
	* @param password 密码
	* @return void
	* @throws Exception
	* @author 李冬松
	* @date 16:52 2017/11/18
	*/
	public void userLogin(String userCode,String password) throws Exception {
		if (  userCode == null || userCode.trim() == ""
				|| password == null||password.trim() == "") {
			throw new DataVerifyException("请输入用户名和密码");
		}

		String userVersion = "0";// PrpDuser的版本号。浏览器版为0，终端版为1。默认为0
		String systemCode = "platform";
		String paramCode = "USER_VERSION";

		UtiPlatConfigDto utiPlatConfigDto = convert(utiPlatConfigDao.queryByCondition(systemCode, paramCode),UtiPlatConfigDto.class);
		if (utiPlatConfigDto != null&&utiPlatConfigDto.getParamCode().equals("1")) {//
			userVersion = "1";
		}

		String encryption = "";
		//密码加密过程
		if (userVersion.equals("0")) {
			encryption = EncryptUtils.md5(password).toUpperCase();
		} else {
			encryption = EncryptUtils.sinosoftEncrypt(password);
		}
		// 声明DTO
		PrpDuserDto iprpDuserDto = null;
		// 查询数据,赋值给DTO
		PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
		iprpDuserDto = convert(prpDuserDao.findOne(prpDuserKey), PrpDuserDto.class);

		//密码校验
		if (!iprpDuserDto.getPassword().equalsIgnoreCase(encryption)) {
			throw new DataVerifyException("密码不正确"+this.getClass().getName());
		}

		if (!iprpDuserDto.getValidStatus().equals("1")) {
				throw new DataVerifyException(this.getClass().getName());

			}

		DateTime now = new DateTime(new Date(), DateTime.YEAR_TO_SECOND);
		DateTime today = new DateTime(now, DateTime.YEAR_TO_DAY);

		// 如果失效日期早于今天是则表示已过期
		if (iprpDuserDto.getPasswordExpireDate().before(today)) {
			throw new DataVerifyException(this.getClass().getName());
		}
		// 如果密码设置时间有值，则判断当前时间是否在密码设置日期后PASSWORD_VALID_PERIOD天
		if (!new DateTime(iprpDuserDto.getPasswordSetDate()).isEmpty()) {

			// 如果不设置PASSWORD_VALID_PERIOD则不管
			if (AppConfig.get("sysconst.PASSWORD_VALID_PERIOD") == null
					|| AppConfig.get("sysconst.PASSWORD_VALID_PERIOD") == "") {
			} else {
				int intervalDay = 90;
				// 否则判断当前时间是否在密码设置日期后PASSWORD_VALID_PERIOD天
				intervalDay = Integer.parseInt(AppConfig.get("sysconst.PASSWORD_VALID_PERIOD"))
						- DateTime.intervalDay(new DateTime(iprpDuserDto.getPasswordSetDate()), 0, today, 0);
				if (intervalDay <= 0) {
					int loginAfterExpire = 0;
					try {
						loginAfterExpire = Integer.parseInt(AppConfig.get("sysconst.LOGIN_AFTER_EXPIRE"));
					} catch (Exception e) {
					}
					if (loginAfterExpire == 0) {
						throw new DataVerifyException(this.getClass().getName());
					}
				}
			}
		}
		// 检查用户登录记录
		UtiUserLoginKey utiUserLoginKey = new UtiUserLoginKey(userCode);
		UtiUserLogin u=utiUserLoginDao.findOne(utiUserLoginKey);
		UtiUserLoginDto utiUserLoginDto = convert(u, UtiUserLoginDto.class);
		utiUserLoginDto.setLockToTime("");
		if (utiUserLoginDto != null) {
			if (utiUserLoginDto.getLockToTime().trim().length() > 0) {
				DateTime lockToTime = new DateTime(utiUserLoginDto.getLockToTime(), DateTime.YEAR_TO_SECOND);
				if (now.getTime() < lockToTime.getTime()) {
					throw new DataVerifyException("密码被锁定！"+this.getClass().getName());
				}
			}
			utiUserLoginDto.setFailLoginCount("0");
			utiUserLoginDto.setLastSuccessLoginTime(now.toString(DateTime.YEAR_TO_SECOND));
			utiUserLoginDto.setLockToTime("");
			UtiUserLogin utiUserLogin=convert(utiUserLoginDto,UtiUserLogin.class);
			//若之前登录失败过则执行更新数据库的记录
			utiUserLoginDao.updated(utiUserLogin.getLastSuccessLoginTime(),utiUserLogin.getLastFailLoginTime(),
					utiUserLogin.getFailLoginCount(),utiUserLoginDto.getLockToTime(),userCode);
		} else {
			utiUserLoginDto = new UtiUserLoginDto();
			utiUserLoginDto.setUserCode(userCode);
			utiUserLoginDto.setFailLoginCount("0");
			utiUserLoginDto.setLastSuccessLoginTime(now.toString(DateTime.YEAR_TO_SECOND));
			utiUserLoginDto.setLastFailLoginTime("");
			utiUserLoginDto.setLockToTime("");
			UtiUserLogin utiUserLogin=convert(utiUserLoginDto, UtiUserLogin.class);
			//若之前没有失败过则执行保存操作
			utiUserLoginDao.save(utiUserLogin);
		}
	}


	/**
	 * 修改用户密码
	 *
	 * @param oldpwd
	 * @param newpwd
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean modifypwd(String userCode,String oldpwd, String newpwd) throws Exception {
//        String userCode= "340501";
		//2、密码加密 判断当前用户是否有权限
		String oldpwdMD5=MD5Util.MD5(oldpwd);
		String newpwdMD5=MD5Util.MD5(newpwd);

		//校验账号密码是否正确
		PrpDuser prpDuser = prpDuserDao.findUserByPwd(userCode,oldpwdMD5);
		if (prpDuser == null || prpDuser.getUserCode() == null) {
			throw new DataVerifyException("原密码错误，修改失败");
		}

		//3、有权限，新密码加密，
		prpDuserDao.modifypwd(userCode,newpwdMD5);

		//5、修改密码成功 强制退出生效
		return true;
	}
	/**
	 * 登录机构查询
	 * @param  userCode 用户代码的map
	 * @return ResponseComCodeDto 机构信息具体见dto说明
	 * @throws Exception
	 * @author 李冬松
	 * @date 16:53 2018/1/23
	 */
	@Override
	public List<ResponseComCodeDto> findComCodeList(String userCode) throws Exception {
		if(StringUtils.isEmpty(userCode)){
			throw new DataVerifyException("userCode不可为空！");
		}
		String sql="SELECT DISTINCT UtiUserGrade.ComCode as comCode,UtiUserGrade.UserCode as userCode, prpdcompany.comlevel as comLevel ,prpdcompany.comCName as comCName" +
				" FROM UtiUserGrade , prpdcompany  WHERE   UtiUserGrade.usercode =:userCode and UtiUserGrade.comcode = prpdcompany.comcode order by prpdcompany.comlevel , UtiUserGrade.comcode ";

		Query query=entityManager.createNativeQuery(sql,ResponseComCode.class);

		query.setParameter("userCode",userCode);

		List<ResponseComCode> responseComCodeList =query.getResultList();

		List<ResponseComCodeDto> responseComCodeDtoList=new ArrayList<>();
		convertCollection(responseComCodeList,responseComCodeDtoList,ResponseComCodeDto.class);

		return responseComCodeDtoList;
	}
}
