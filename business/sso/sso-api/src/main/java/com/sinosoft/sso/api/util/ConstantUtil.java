package com.sinosoft.sso.api.util;

public class ConstantUtil {

	public static final String COOKIE_NAME = "sinosoftSSO";  //cookie名字
	
	/*web.xml配置参数*/
	public static final String SSO_FILTER_PARAMNAME_SSOURL = "ssoUrl";
	public static final String SSO_FILTER_PARAMNAME_WHITELISTURL = "notCheckURLList";
	public static final String SSO_FILTER_PARAMNAME_COOKIEAGE  ="cookieMaxAge";
	
	/*用于过滤器中匹配地址*/
	public static final String COOKIE_PATH = "/ssoReturn";     //回写cookie的url地址
	public static final String LOGOUT_PATH = "/logout"; //注销登陆的url地址
	
	/*控制参数*/
	public static final int    COOKIE_MAX_AGE = 172800; //默认的cookie最大有效时间 seconds(两天时间)
	
	public static final String AUTH_URL_HEADER_NAME = "AuthLocation"; //未登录状态下,登录地址写到header中的名字
	
	public static final String AUTH_URL_PARAM_NAME = "ReturnUrl";  //登录地址后面接的参数名字，用于指定登录后跳转的地址
	
	public static final String USER_ATTRIBE_NAME   = "CurrentUser";  //当前用户信息(保存在request中的属性名)
	
	public static final String RESP_MSG_HEADER_NAME = "RetMsg"; //响应头信息中用于保存处理结果信息的属性名
	
	/*sso系统关键服务路径*/
	public static final String SSO_PAGE_REQ_PATH = ""; //单点登录系统页面controller地址
	
	public static final String SSO_PAGE_LOGIN_REQ_PATH = "login"; //单点登录系统登陆页面地址
	
	public static final String SSO_PAGE_LOGOUT_REQ_PATH = "logout"; //单点登录系统登出页面地址
	
	public static final String SSO_API_REQ_PATH = "api"; //单点登录系统对外API的controller地址
	
	public static final String SSO_API_VALID_REQ_PATH = "valid"; //单点登录系统对外API的controller中token验证方法的路径
	
	public static final String SSO_API_LOGOUT_REQ_PATH = "logout";  //单点登录系统对外API的controller中注销登陆方法的路径
	
	public static final String SSO_API_STATUS_REQ_PATH = "status"; //单点登录系统对外API的controller中登陆状态查看方法的路径
	
	public static final String SSO_API_AUTH_REQ_PATH = "auth"; //单点登录系统对外API的controller中登陆方法的路径

	public static final String SSO_API_AUTO_AUTH_REQ_PATH = "autoAuth"; //单点登录系统对外API的controller中登陆方法的路径-自动登录
}
