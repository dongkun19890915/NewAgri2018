package com.sinosoft.sso.api.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @description Web处理工具类
 * @param request
 * @return ip地址
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:41:48
 */
public class WebUtil {
	
	public static String getIp(HttpServletRequest request) {
		String ipList = request.getHeader("X-Forwarded-For");
		String ip = "";
		if (ipList == null || ipList.length() == 0) {
			ipList = request.getHeader("Proxy-Client-ipList");
		}
		if (ipList == null || ipList.length() == 0) {
			ipList = request.getHeader("WL-Proxy-Client-ipList");
		}
		if (ipList == null || ipList.length() == 0) {
			ipList = request.getRemoteAddr();
		}
		if (!"".equals(ipList) && null != ipList) {
			String[] str = ipList.split(",");
			for (int i = 0; i < str.length; i++) {
				if (!"".equals(str[i]) && null != str[i] && str[i].indexOf(".") != -1) {
					ip = str[i].trim().replaceAll(" ", "");
					break;
				}
			}
		}
		return ip;
	}
	
	/**
	 * 
	 * @description 获取cookie中的token值
	 * @param request
	 * @return token
	 * @author ZhangJiansen
	 * @date 2016年10月10日上午9:11:46
	 */
	public static String getTokenFromCookie(HttpServletRequest request){
		String token = null;
		if(request.getCookies() != null && request.getCookies().length > 0){
            for(int i = 0 ; i < request.getCookies().length ; i++){
                String cookieName = request.getCookies()[i].getName();
                if(cookieName.equals(ConstantUtil.COOKIE_NAME)){
                    token = request.getCookies()[i].getValue();
                    token = token.replace(' ','+');
                }
            }
        }
		
		return token;
	}
}
