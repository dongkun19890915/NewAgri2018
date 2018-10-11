package com.sinosoft.framework.agri.core.utils.rsa;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class RSACoderTest {
    private String publicKey;
    private String privateKey;


    /**
     * 1.获取秘钥
     * @throws Exception
     */
    @Before
    public void initKey() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }

    /**
     * 公钥加密——私钥解密
     * @throws Exception
     */
    @Test
    public  void test1() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        System.out.println(encodedData);

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,
                privateKey);
        System.out.println(decodedData);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

    }

    /**
     * 私钥加密——公钥解密
     * @throws Exception
     */
    @Test
    public  void test2() throws Exception {
        System.err.println("私钥加密——公钥解密");

        String returnStr = "abcdef";
        byte[] data_return = returnStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPrivateKey(data_return, privateKey);
        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + returnStr + "\n\r" + "解密后: " + outputStr);

        System.err.println("私钥签名——公钥验证签名");

        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("状态:\r" + status);

    }
}
