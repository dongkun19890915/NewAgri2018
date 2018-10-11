package com.sinosoft.sso.web;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserResultDto;
import com.sinosoft.ims.api.kernel.dto.ResponseComCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BaseException;
import com.sinosoft.ims.api.kernel.UserLoginApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.sso.api.AuthApi;
import com.sinosoft.sso.api.dto.AuthReq;
import com.sinosoft.sso.api.dto.AuthResp;
import com.sinosoft.sso.api.dto.UserInfo;
import com.sinosoft.sso.api.util.ConstantUtil;
import com.sinosoft.sso.api.util.WebUtil;
import com.sinosoft.sso.core.entity.TokenInfo;
import com.sinosoft.sso.core.security.TokenUtil;
import com.sinosoft.sso.core.security.VerificationCode;
import com.sinosoft.sso.core.service.AppManageService;
import com.sinosoft.sso.core.service.TokenService;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description sso登陆权限控制对外api
 * @author ZhangJiansen
 * @date 2016年9月30日下午4:20:23
 */
@RestController
@RequestMapping(ConstantUtil.SSO_API_REQ_PATH)
public class AuthController implements AuthApi{
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    //登陆过期时间，单位毫秒
    private static Long EXPIRE_TIME = 900000L;
    
    //密码错误提示
    public static String ERROR_USERNAME_PASSWORD = "用户名或密码错误";
    
    //登陆服务
    @Autowired
    private UserLoginApi userLoginService;//登陆服务

    @Autowired
    private PrpDuserApi prpDuserApi;
    
    @Autowired
    private TokenService tokenService;

    @Autowired
	private AppManageService appManageService;

    @Value("${sso.url}")
    private String ssoUrl ;

    @Value("${sso.thirdAuth.authTimeOut}")
    private long authTimeOut;//第三方自动登录请求超时时间

    @Value("${sso.thirdAuth.authSystem}")
    private String authSystem;//第三方自动登录系统标识
	

	/**
	 * @description 登陆授权服务<p>statusCode: 200 成功、500 失败
	 * @param auth
	 * @return AuthResp
	 * @author ZhangJiansen
	 * @date 2016年9月30日下午4:32:41
	 */
    @ResponseBody
    @RequestMapping(value=ConstantUtil.SSO_API_AUTH_REQ_PATH)
    public AuthResp auth(@RequestBody AuthReq auth)
    {
    	String userCode = auth.getUserCode();
    	String passWord = auth.getPassWord();
    	//String verifyCode = auth.getVerifyCode();
        PrpDuserResultDto prpDuserResultDto;

        logger.info("user:{} begin login  ",userCode );

        AuthResp resp = new AuthResp();

        //校验密码
        PrpDuserDto loginInfo = new PrpDuserDto();
        loginInfo.setUserCode(userCode);
        loginInfo.setPassword(passWord);

        PrpDuserDto userRet = null;
        try{
            logger.info("start get User...");
            prpDuserResultDto = userLoginService.checkUserLogin(loginInfo);
            if(prpDuserResultDto!=null){
                userRet=prpDuserResultDto.getPrpDuserDto();
            }
            //TODO 汪强临时测试使用  免登录校验
            //1、注释掉上面一行代码 userRet = userLoginService.checkUserLogin(loginInfo);
            //2、放开下面三行代码
            //userRet=new PrpDuserDto();
            //userRet.setUserCode("340501");
            //userRet.setUserName("政策性农险公司业务");
            //userRet.setPassword("4A7D1ED414474E4033AC29CCB8653D9B");
        }catch(Exception e){
        	logger.error("用户校验错误", e);
        	//String  resultMsg  = "";
            //if (BaseException.class.isAssignableFrom(e.getClass())){
            //    resultMsg = e.getMessage();
            //}
            //else{
            //    resultMsg = e.getMessage(); //--不直接抛出系统异常给前端
            //    //resultMsg = "系统异常,请联系系统管理员!";
            //}
            //logger.error("用户校验错误", e);
            resp.setRetCode("500");
            resp.setRetMsg("用户校验错误:");
            return resp;
        }

        if(userRet == null){
        	resp.setRetCode("500");
            resp.setRetMsg(prpDuserResultDto.getMsg());
            return resp;
        }
        String nickName=userRet.getUserName();

    	String token = null;
        try
        {
            token = TokenUtil.genToken(userCode);
            logger.debug("生成新token："+token);
        }
        catch (Exception e)
        {
            logger.error("生成token异常", e);
            resp.setRetCode("500");
            resp.setRetMsg("生成token异常");
            return resp;
        }

        //将token放入Map
    	TokenInfo info = new TokenInfo();
    	UserInfo user = new UserInfo();
    	user.setUserCode(userCode);
    	user.setUserName(nickName);
    	user.setLoginComCode(userRet.getComCode());
    	user.setMakeCom(userRet.getMakeCom());
    	info.setToken(token);
    	info.setCreateTime(new Date());
    	info.setUserInfo(user);
    	info.setExpiration(EXPIRE_TIME);
    	tokenService.saveToken(info);

    	List<String> urls = appManageService.getAppsCallBackUrl(token);
        resp.getRedirectURLs().addAll(urls);

        resp.setRetCode("200");
        resp.setRetMsg("成功");
        resp.setToken(token);

        return resp;

    }
    
    /**
     * @description 提供忘记密码服务功能
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年10月25日下午5:35:32
     */
     @RequestMapping(value = "/forgotPasswd", method = RequestMethod.POST)
     @ResponseBody
     public AuthResp forgotPasswd(@RequestBody AuthReq auth){
    	 String userCode = auth.getUserCode();
    	 ResponseDto responseDto = new ResponseDto();
    	 AuthResp resp = new AuthResp();
    	 PrpDuserDto info = new PrpDuserDto();
    	 info.setUserCode(userCode);
     	try {
			responseDto = userLoginService.forgetPwd(info);
		} catch (Exception e) {
			logger.error("异常处理，联系管理员", e);
        	resp.setRetCode("9999");
        	resp.setRetMsg("异常处理，联系管理员");
        	return resp;
		}
     	resp.setRetCode(responseDto.getResultCode());
    	resp.setRetMsg(responseDto.getResultMsg());
    	return resp;
     }

    
    /**
     * 
     * @description 生成图片验证码
     * @param req
     * @param res
     * @author zkr02
     * @date 2016年9月30日下午4:36:20
     */
    @RequestMapping(value = "/verify")
    public void verifyCode(HttpServletRequest req,HttpServletResponse res){
    	res.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
    	res.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
    	res.setHeader("Cache-Control", "no-cache");
    	res.setHeader("P3P", "CP=CAO PSA OUR");
    	res.setDateHeader("Expire", 0);
        try {
            VerificationCode.getRandcode(req, res);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 
    /**
     * 
     * @description token有效性校验
     * @param token
     * @param res
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:37:38
     */
    @RequestMapping(value =ConstantUtil.SSO_API_VALID_REQ_PATH)
    public void tokenValid(@RequestParam("token")String token,HttpServletResponse res){
        
        if(token == null){
        	logger.debug("token参数为空");
        	res.setStatus(400); //请求参数错误
        	return;
        }
        
        token = token.replace(' ','+');
        
        TokenInfo info = tokenService.getToken(token);
        
        if(info == null){
        	logger.debug("token不存在");
        	res.setStatus(204); //校验码不存在
        	return;
        }
        
        //更新token，主要是重置过期时间
        tokenService.updateToken(info);
              
        try {
        	res.setStatus(200); //校验码有效
			ObjectOutputStream oos = new ObjectOutputStream(res.getOutputStream());
			oos.writeObject(info.getUserInfo());
			oos.flush();	        
	        oos.close();
	        logger.debug("有效的token");
	        return;
		} catch (IOException e) {
			logger.error("token校验回写数据失败", e);
			res.setStatus(500);
			return;
		}
    }

    @Override
    public AuthResp validToken(@RequestBody String token){
        logger.info("into validToken");
        AuthResp authResp = new AuthResp();
        if(token == null){
            logger.debug("token参数为空");
            authResp.setRetCode("401"); //请求参数错误
            authResp.setRetMsg("token参数为空");
            return authResp;
        }

        token = token.replace(' ','+');

        TokenInfo info = tokenService.getToken(token);

        if(info == null){
            logger.debug("token不存在");
            authResp.setRetCode("204"); //校验码不存在
            authResp.setRetMsg("token不存在");
            return authResp;
        }

        //更新token，主要是重置过期时间
        //tokenService.updateToken(info);

        try {
            authResp.setRetCode("200"); //校验码有效
            authResp.setUserInfo(info.getUserInfo());
            logger.debug("有效的token");
            //延长redis token有效期
            tokenService.expireToken(token);

            return authResp;
        } catch (Exception e) {
            logger.error("token校验回写数据失败", e);
            authResp.setRetCode("500");
            authResp.setRetMsg("token校验回写数据失败");
            return authResp;
        }
    }

    @Override
    public AuthResp logout(@CookieValue(value=ConstantUtil.COOKIE_NAME,required=false) String token)throws Exception{
        AuthResp authResp = new AuthResp();
        if(token == null){
            authResp.setRetCode("400");
            authResp.setRetMsg("token为空，注销失败");
            return authResp;
        }

        TokenInfo info = tokenService.getToken(token);
        if(info == null){
            authResp.setRetCode("204");
            authResp.setRetMsg("此token已注销过");
            return authResp;
        }

        tokenService.deleteToken(token);

        try {
            authResp.setRetCode("200"); //注销成功
            authResp.setRetMsg(String.format("[%s]注销登陆成功", info.getUserInfo().getUserName()) );

//            //注销后统一跳转到单点登录界面， 其返回界面默认为gscore-front
//            ResourceBundle bundle = ResourceBundle.getBundle("comm.config.application");
//            String frontUrl =  bundle.getString("front.url");
//            String ssoUrl =  bundle.getString("sso.url");
//            String url=ssoUrl+"/login?"+ConstantUtil.AUTH_URL_PARAM_NAME+"="+frontUrl;
//            authResp.setRedirectUrl(url);
            authResp.setRedirectUrl(ssoUrl+"login");
            return authResp;
        } catch (Exception e) {
//            logger.error("token注销回写数据失败", e);
//            authResp.setRetCode("500");
//            authResp.setRetMsg("token注销回写数据失败");
//            return authResp;
            throw new Exception("token注销回写数据失败");
        }
    }

    /**
     * 
     * @description 检查是否已登录
     * @param request
     * @return AuthResp
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:38:45
     */
    @Override
    public AuthResp checkLogin(HttpServletRequest request){
    	
    	AuthResp resp = new AuthResp();
    	
    	String token = WebUtil.getTokenFromCookie(request);

    	if(token == null){
    		logger.debug("未登录");
    		resp.setRetCode("500");
    		resp.setRetMsg("未登录");
    		return resp;
    	}
    	
    	TokenInfo info = tokenService.getToken(token);
        if(info == null){
        	logger.debug("用户登录已失效");
        	resp.setRetCode("500");
        	resp.setRetMsg("用户登录已失效");
        	return resp;
        }
    	
        logger.debug("用户状态为已登录");
        resp.setRetCode("200");
        resp.setUserInfo(info.getUserInfo());
        
        List<String> urls = appManageService.getAppsCallBackUrl(token);
        resp.getRedirectURLs().addAll(urls);
        
        return resp;
    }

    /**
     * @description 根据cookie中的用户代码查询用户信息
     * @return
     * @
     * @author zkr07
     * @date 2016年10月7日下午6:00:03
     */
    @Override
    public AuthResp getLoginUserInfo(@CookieValue(value=ConstantUtil.COOKIE_NAME,required=false) String token) {
       /* String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        if(StringUtils.isEmpty(userCode)) {
            return ResponseDto.instance().setResultCode("500").setResultMsg("未获取登录信息...");
        }*/
        SinoRequestContext.getCurrentContext().set("");

        AuthResp authResp = new AuthResp();
        if(token == null || token.isEmpty()){
            authResp.setRetCode("401");
            authResp.setRetMsg("未获取登录信息");
            return authResp;
        }
        TokenInfo info = tokenService.getToken(token);
        UserInfo userInfo=info.getUserInfo();
        if(userInfo == null){
            authResp.setRetCode("401");
            authResp.setRetMsg("未获取登录信息");
            return authResp;
        }
//        //TODO 免登录注释上七行。放开下四行
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserCode("340501");
//        userInfo.setUserName("政策性农险公司业务");
//        userInfo.setLoginComCode("3400000000");

        authResp.setRetCode("200");
        authResp.setRetMsg("获取用户成功");
        authResp.setUserInfo(userInfo);
        return authResp;
    }

    /**
     * 修改用户密码
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @Override
    @RequestMapping(value = "modifypwd", method = RequestMethod.GET)
    public Map<String,String> modifypwd(@RequestParam("oldpwd") String oldpwd, @RequestParam("oldpwd") String newpwd)throws Exception{

        //校验密码长度

        //2、获取当

        return null;
    }

    /**
     * 第三方页面调用自动登陆授权服务<p>statusCode: 200 成功、500 失败
     * @return AuthResp
     * @author zhoujiawei
     * @date 2018年01月30日
     */
    @ResponseBody
    @RequestMapping(value=ConstantUtil.SSO_API_AUTO_AUTH_REQ_PATH,method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView autoAuth(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        String thirdAuthMess = request.getParameter("thirdAuthMess");
        String secondURL = request.getParameter("secondURL");
        //TODO 测试数据
//        String thirdAuthMess = "userCode=0537,authSystemFlag=GIS,authTime=2018-01-30 17:38:00";
        //TODO thirdAuthMess解密
        Map<String, String> thirdAuthMap = stringToMap(thirdAuthMess);
        String userCode = thirdAuthMap.get("userCode");
        String authTime = thirdAuthMap.get("authTime");// yyyy-MM-dd HH:mm:ss
        String authSystemFlag = thirdAuthMap.get("authSystemFlag");

        logger.info("user:{} begin autologin  ",userCode );
        PrpDuserDto userRet = null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sysDate = new Date();
            Date loginDate = sdf.parse(authTime);
            if(Math.abs(sysDate.getTime()-loginDate.getTime())>authTimeOut){
                logger.info("autologin失败，请求已失效！ sysdate={},authTime={},authTimeOut={} ",sdf.format(sysDate),authTime,authTimeOut );
                throw new DataVerifyException("请求已失效！");
            }
            if(authSystem.indexOf(authSystemFlag)<0){
                logger.info("autologin失败，调用系统参数无效！ authSystemFlag={}",authSystemFlag );
            }
            logger.info("start get User...");
            userRet = prpDuserApi.queryByPK(userCode);
            logger.info("end get User..."+userRet.getUserCode());
        }catch(Exception e){
            e.printStackTrace();
            logger.error("用户校验错误", e);
            String  resultMsg  = "";
            if (BaseException.class.isAssignableFrom(e.getClass()))
            {
                resultMsg = e.getMessage();
            }
            else
            {
                resultMsg = "系统异常,请联系系统管理员!";
            }
            logger.error("用户校验错误", e);
            mv.addObject("retCode", "500");
            mv.addObject("retMsg", "用户校验错误:" + resultMsg);
            mv.setViewName("autoLogin");
            return mv;
        }

        if(userRet == null){
            mv.addObject("retCode", "500");
            mv.addObject("retMsg", "用户校验异常，未获取到有效的用户信息");
            mv.setViewName("autoLogin");
            return mv;
        }
        String nickName=userRet.getUserName();

        String token = null;
        try
        {
            token = TokenUtil.genToken(userCode);
            logger.debug("生成新token："+token);
        }
        catch (Exception e)
        {
            logger.error("生成token异常", e);
            mv.addObject("retCode", "500");
            mv.addObject("retMsg", "生成token异常");
            mv.setViewName("autoLogin");
            return mv;
        }

        //将token放入Map
        TokenInfo info = new TokenInfo();
        UserInfo user = new UserInfo();
        user.setUserCode(userCode);
        user.setUserName(nickName);
        user.setLoginComCode(userRet.getComCode());
        info.setToken(token);
        info.setCreateTime(new Date());
        info.setUserInfo(user);
        info.setExpiration(EXPIRE_TIME);
        tokenService.saveToken(info);

        List<String> urls = appManageService.getAppsCallBackUrl(token);
        mv.addObject("retCode", "200");
        mv.addObject("retMsg", "自动登录成功");
        mv.addObject("token", token);
        mv.addObject("urls", urls);
        mv.addObject("secondURL", secondURL);
        mv.setViewName("autoLogin");

        return mv;

    }

    /**
     *
     * @param thirdAuthMess
     * @return
     */
    private Map<String, String> stringToMap(String thirdAuthMess) {
        Map<String,String> thirdAuthMap = new HashMap<>();
        if(StringUtils.isEmpty(thirdAuthMess)){
            throw new DataVerifyException("thirdAuthMess参数必传！");
        }

        String[] thirdAuthMesss = thirdAuthMess.split(",");
        for(String str:thirdAuthMesss){
            String[] strs = str.split("=");
            thirdAuthMap.put(strs[0],strs[1]);
        }
        return thirdAuthMap;
    }


}
