package com.sinosoft.sso.core.security;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @description Token生成工具类
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:35:49
 */
public class TokenUtil {
    
    private static final EncryptUtil encryptUtil = new EncryptUtil();

	public static String genToken(){
		Date date = new Date();
		String str = date.getTime() + "" + ((Math.random() * 9 + 1) * 1000000);
		return str;
	}
	
	public static String genToken(String key) throws Exception{
		String smpToken = key+"@"+genToken();
		String realKey = StringUtils.leftPad(key, 16, "*");
		String token = encryptUtil.encryptToAES(realKey, smpToken);
        return encryptUtil.encryptToMD5(token);
	}
	
	public static void main(String[] args){
	    try
        {
            System.out.println(TokenUtil.genToken("00010002"));
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
