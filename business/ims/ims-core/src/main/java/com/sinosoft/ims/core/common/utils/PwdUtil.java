package com.sinosoft.ims.core.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;

/**
 * @Description 密码加密工具md5
 * @author chengzhuo
 * @return 加密后的密码
 * @data 2016/9/16 10:17
 *
 */
public class PwdUtil {
	public static String md5(String password){
		try{//采用MD5处理
			MessageDigest md =
				MessageDigest.getInstance("MD5");
			byte[] output = md.digest(
				password.getBytes());//加密处理
			//将加密结果output利用Base64转成字符串输出
			String ret =
			 Base64.encodeBase64String(output);
			return ret;
		}catch(Exception e){
			throw new RuntimeException(
				"密码加密失败", e);
		}

	}
	public static void main(String[] args){
		System.out.println(md5("!!123456aaa"));
		//System.out.println(md5("123"));
		
	}
	/**
	  * @Description java生成随机数字和字母组合
	  * @author chengzhuo
	  * @return 随机密码
	  * @data 2016/9/16/14:20
	  */
	 public static String getPassWord() {
	  String val = "";
	  Random random = new Random();
	  for (int i = 0; i < 8; i++) {
	   // 输出字母还是数字
	   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 
	   // 字符串
	   if ("char".equalsIgnoreCase(charOrNum)) {
	    // 取得大写字母还是小写字母
	    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
	    val += (char) (choice + random.nextInt(26));
	   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
	    val += String.valueOf(random.nextInt(10));
	   }
	  }
	  return val;
	 }
}
