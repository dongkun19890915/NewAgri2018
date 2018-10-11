package com.sinosoft.notice.core.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.DigestException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;



/**
 * @description 编码工具类
 * @author zkr10
 * @date 2016年10月13日下午1:54:29
 */
public final class  CodeUtils
{
    public static final JceProvider DEFAULT_PROVIDER = JceProvider.SUN_PROVIDER;    
    public static final JceAlgorithm DEFAULT_DES_ALGORITHM = JceAlgorithm.DES;  
    public static final String DEFAULT_IV = "0102030405060708"; 
 

    public static final String GBK_CHARSET = "GBK";
    public static final String GB2312_CHARSET = "gb2312";
    public static final String UTF8_CHARSET = "utf-8";
    public static final String ISO_CHARSET = "iso-8859-1";
    public static final String GB18030_CHARSET = "GB18030";
    
    public static final String DEFAULT_CHARSET = UTF8_CHARSET;  
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String IDVERI_IV = "12345678";
    public static final String DEFAULT_ENCODING = "UTF-8";   


      
    /**
     * @description byte数组=>字符串(把byte数组转换为16进制字符串) 例如，把byte数组{0x11,0x12,0x13}的字符串为"111213"
     * @param src 所要转换的byte数组
     * @return
     * @author zkr10
     * @date 2016年10月13日下午1:55:39
     */
    public static final String byte2hex(byte[] src) {
        StringBuffer ret = new StringBuffer();
        if (!ArrayUtils.isEmpty(src)){
            for (int i = 0; i < src.length; i++) {
                byte b = src[i];
                String stmp = (Integer.toHexString(b & 0XFF));
                if (stmp.length() == 1) {
                    ret.append("0").append(stmp);
                } else {
                    ret.append(stmp);
                }
            }
        }
        return ret.toString();
    }

    
    
    /**
     * @description 字符串=>byte数组(把16进制字符串转换为数组)
     * 例如，把字符串为"111213"转换为byte数组{0x11,0x12,0x13}
     * @param src  所要转换的字符串
     * @return
     * @author zkr10
     * @date 2016年10月13日下午1:56:02
     */
    public static final byte[] hex2byte(String src) {
        byte [] ret = null;
        if (StringUtils.isNotBlank(src)){       
            char[] arr = src.toCharArray();
            ret = new byte[src.length() / 2];
            for (int i = 0, j = 0, l = src.length(); i < l; i++, j++) {
                StringBuffer swap = new StringBuffer().append(arr[i++]).append(arr[i]);
                int byteint = Integer.parseInt(swap.toString(), 16) & 0xFF;
                ret[j] = new Integer(byteint).byteValue();
            }
        }
        return ret;
    }
    
   
    /**
     * @description DES算法，加密
     * @param key 加密私钥，长度不能够小于8位
     * @param data待加密字符串
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:56:23
     */
    public static String desEncode(String key,String data) throws Exception
    {
        return desEncode(key, data.getBytes(GB18030_CHARSET));
    }
    
   
    
    /**
     * @description DES算法，加密
     * @param key 待加密字符串
     * @param data 加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:56:43
     */
    public static String desEncode(String key,byte[] data) throws Exception
    {
        try
        {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(IDVERI_IV.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,paramSpec);
            
            byte[] bytes = cipher.doFinal(data);
            return base64Encode(bytes);
        } catch (Exception e)
        {
            throw new Exception(e);
        }
    }

   
    
    /**
     * @description DES算法，解密
     * @param key 解密私钥，长度不能够小于8位
     * @param data 待解密字符串
     * @return 解密后的字节数组
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:57:07
     */
    public static byte[] desDecode(String key,byte[] data) throws Exception
    {
        try
        {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(IDVERI_IV.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey,paramSpec);
            return cipher.doFinal(data);
        } catch (Exception e)
        {
            throw new Exception(e);
        }
    }
    
  
    
    /**
     * @description 获取编码后的值
     * @param key
     * @param data
     * @return
     * @author zkr10
     * @date 2016年10月13日下午1:57:26
     */
    public static String desDecode(String key,String data) 
    {
        byte[] datas;
        String value = null;
        try {
            datas = desDecode(key, base64DecodeToBytes(data));
            value = new String(datas,GB18030_CHARSET);
        } catch (Exception e) {
            value = "";
        }
        return value;
    }
    
   
    /**
     * @description MD5 摘要计算(byte[]).
     * @param src byte[]
     * @return  byte[] 16 bit digest
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:57:38
     */
    public static final byte[] md5Digest(byte[] src) throws Exception {
        if (ArrayUtils.isEmpty(src)) return ArrayUtils.EMPTY_BYTE_ARRAY;
        MessageDigest alg = MessageDigest.getInstance(JceAlgorithm.MD5.toString()); // MD5 is 16 bit coremessage digest
        return alg.digest(src);
    }

   
    
    /**
     * @description 32位MD5 摘要计算(String).
     * @param src
     * @return
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:57:55
     */
    public static final String md5Digest(String src) throws Exception {
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'};  
        byte tmp[] = md5Digest(src.getBytes("UTF-8"));
        char str[] = new char[16 * 2]; 
        int k = 0;                                
        for (int i = 0; i < 16; i++) {        
            byte byte0 = tmp[i];                
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
            str[k++] = hexDigits[byte0 & 0xf];           
        } 
        return new String(str);
    }
    
     
    
    /**
     * @description SHA-1 安全加密算法 
     * @param src
     * @return
     * @throws DigestException
     * @author zkr10
     * @date 2016年10月13日下午1:58:08
     */
    public static String sha1Digest(String src) throws DigestException {  
        try {  
            //指定sha1算法  
            MessageDigest digest = MessageDigest.getInstance(JceAlgorithm.SHA1.toString());  
            digest.update(src.getBytes());  
            //获取字节数组  
            byte messageDigest[] = digest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < messageDigest.length; i++) {  
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                if (shaHex.length() < 2) {  
                    hexString.append(0);  
                }  
                hexString.append(shaHex);  
            }  
            return hexString.toString();  
  
        } catch (NoSuchAlgorithmException e) {
            throw new DigestException("签名错误！");  
        }  
    }  
    
 
    /**
     * @description BASE64 编码(String).
     * @param src
     * @return
     * @author zkr10
     * @date 2016年10月13日下午1:58:19
     */
    public static final String base64Encode(String src)  {
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return new String(new Base64().encode(src.getBytes()));
    }

   
    
    /**
     * @description BASE64 编码(byte[]).
     * @param src byte[] inputed string
     * @return String returned string
     * @author zkr10
     * @date 2016年10月13日下午1:58:37
     */
    public static final String base64Encode(byte[] src) {
        if (ArrayUtils.isEmpty(src)) return StringUtils.EMPTY;
        return new String(new Base64().encode(src));
    }
    
   
    /**
     * @description BASE64 编码(byte[]).
     * @param src src byte[] inputed string
     * @return byte[]
     * @author zkr10
     * @date 2016年10月13日下午1:58:54
     */
    public static final byte[] base64EncodeToBytes(byte[] src) {
        if (ArrayUtils.isEmpty(src)) return ArrayUtils.EMPTY_BYTE_ARRAY;
        return new Base64().encode(src);
    }

    
    
    /**
     * @description BASE64 解码(String).
     * @param src
     * @return
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:59:17
     */
    public static final String base64Decode(String src) throws Exception{
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return new String(base64DecodeToBytes(src));
    }

   
    
    /**
     * @description BASE64 解码(byte[]).
     * @param src  String inputed string
     * @return String returned string
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:59:27
     */
    public static final byte[] base64DecodeToBytes(String src) throws Exception{
        if (StringUtils.isBlank(src)) return ArrayUtils.EMPTY_BYTE_ARRAY;
        return new Base64().decode(src.getBytes());
    }
    
   
    /**
     * @description BASE64 解码(byte[]).
     * @param src String inputed string
     * @return String returned string
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午1:59:45
     */
    public static final byte[] base64DecodeToBytes(byte[] src) throws Exception{
        if (ArrayUtils.isEmpty(src)) return ArrayUtils.EMPTY_BYTE_ARRAY;
        return new Base64().decode(src);
    }
    
    
    /**
     * @description 对给定字符进行 URL 编码(GB2312).
     * @param src String
     * @return String
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午2:00:05
     */
    public static final String urlEncode(String src) throws Exception{
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return URLEncoder.encode(src, GB2312_CHARSET);
    }

  
    
    /**
     * @description 对给定字符进行 URL 编码(charset).
     * @param src
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     * @author zkr10
     * @date 2016年10月13日下午2:00:19
     */
    public static final String urlEncode(String src,String charset) throws UnsupportedEncodingException{
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return URLEncoder.encode(src, charset);
    }
    
  
    
    /**
     * @description 对给定字符进行 URL 解码(GB2312).
     * @param src
     * @return
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午2:00:33
     */
    public static final String urlDecode(String src) throws Exception{
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return URLDecoder.decode(src, GB2312_CHARSET);
    }

   
    
    /**
     * @description 对给定字符进行 URL 解码(charset).
     * @param src
     * @param charset
     * @return
     * @throws Exception
     * @author zkr10
     * @date 2016年10月13日下午2:00:46
     */
    public static final String urlDecode(String src,String charset) throws Exception{
        if (StringUtils.isBlank(src)) return StringUtils.EMPTY;
        return URLDecoder.decode(src, charset);
    }



    
    /**
     * @description 将一个字串编码成unicode
     * @param src
     * @return
     * @author zkr10
     * @date 2016年10月13日下午2:00:56
     */
    public static final String encode2Unicode(String src){
        if (StringUtils.isEmpty(src)) return StringUtils.EMPTY;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < src.length(); i++) {
            sb.append(encode2Unicode(src.charAt(i)));
        }
        return sb.toString();
    }
 
    /**
     * @description 将一个字符编码成unicode
     * @param c
     * @return
     * @author zkr10
     * @date 2016年10月13日下午2:01:06
     */
    public static final String encode2Unicode(char c){
        StringBuffer sb = new StringBuffer();
        String tmp;
        if (c > 255) {
            sb.append("\\u");
            //高8位
            tmp = Integer.toHexString(c >>> 8);
            if (tmp.length() == 1) sb.append("0");
            sb.append(tmp);
            //低8位
            tmp = Integer.toHexString(c & 0xff);
            if (tmp.length() == 1) sb.append("0");
            sb.append(tmp);         
        } else {
            sb.append(c);
        }
        return sb.toString();
    }
    
   
    
    /**
     * @description  将一个字串编码成html所用的某种特殊的unicode
     * @param src
     * @return
     * @author zkr10
     * @date 2016年10月13日下午2:01:16
     */
    public static final String encode2HtmlUnicode(String src){
        if (StringUtils.isEmpty(src)) return StringUtils.EMPTY;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < src.length(); i++) {    
            sb.append(encode2HtmlUnicode(src.charAt(i)));
        }
        return sb.toString();
    }

 
    
    /**
     * @description 将一个字符编码成html所用的某种特殊的unicode
     * @param c
     * @return
     * @author zkr10
     * @date 2016年10月13日下午2:01:36
     */
    public static final String encode2HtmlUnicode(char c){
        if (c > 255) {
            return new StringBuffer().append("&#").append(c & 0xffff).append(";").toString();
        } else {
            return String.valueOf(c);
        }
    }
    
    
    public enum JceTransformation {
        DES_ECB("DES/ECB/PKCS5Padding"),
        DES_CBC("DES/CBC/PKCS5Padding"),
        DES_ECB_NOPADDING("DES/ECB/NoPadding"),
        DESEDE_CBC("DESede/CBC/PKCS5Padding"),
        DESEDE_CBC_PKCS7("DESede/CBC/PKCS7Padding"),
        DESEDE_ECB("DESede/ECB/PKCS5Padding");
        private JceTransformation(String transformation) {
            this.transformation = transformation;
        }
        private String transformation;
        public String toString() {
            return transformation;
        };
    }
    
    public enum JceAlgorithm{
        AES,DES,DESede,RSA,SHA1("SHA-1"),MD5;
        private JceAlgorithm() {
            this.algorithm = name();
        }
        private JceAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }
        private String algorithm;
        public String toString() {
            return algorithm;
        }
    }
    
    public enum JceProvider{
        SUN_PROVIDER("SunJCE"),BOUNCY_CASTLE_PROVIDER("BC");
        private JceProvider(String provider) {
            this.provider = provider;
        }
        private String provider;
        public String toString(){
            return provider;
        }
    }
    
    public static String fuzzify(String input) {
        try {
            byte[] bytes = Base64
                    .encodeBase64(input.getBytes(DEFAULT_ENCODING));
            swap(bytes);
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            return input;
        }
    }

    public static String defuzzify(String input) {
        try {
            byte[] bytes = input.getBytes();
            swap(bytes);
            return new String(Base64.decodeBase64(bytes), DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            return input;
        }
    }

    private static void swap(byte[] bytes) {
        int half = bytes.length / 2;
        for (int i = 0; i < half; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[half + i];
            bytes[half + i] = temp;
        }
    }

    public static String swap(String str) {
        char[] chars = str.toCharArray();
        int half = chars.length / 2;
        for (int i = 0; i < half; i++) {
            char temp = chars[i];
            chars[i] = chars[half + i];
            chars[half + i] = temp;
        }
        return new String(chars);
    }
}
