package com.sinosoft.fileserver.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.DruidPasswordCallback;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-04-28 00:05
 */
//@Component
public class DBConfig extends DruidPasswordCallback {
    /**
     * 动态修改数据配置密码 解密
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        //super.setProperties(properties);
        String key = properties.getProperty("key");
        String pwd = decrypt(properties.getProperty("password"), key);
        if (pwd == null || pwd.isEmpty()) {
            return;
        }
        try {
            setPassword(pwd.toCharArray());
        } catch (Exception e) {
            setPassword(pwd.toCharArray());
        }
    }


    /**
     * 密码解密
     * @param pwd 需要解密码
     * @param key 密钥
     * @return
     */
    private String decrypt(String pwd, String key) {
        if (key == null || key.isEmpty() || pwd == null || pwd.isEmpty()) {
            return pwd;
        }
        pwd = pwd.trim();
        //截取加密特殊配置ENC()
        if (pwd.indexOf("ENC(") == 0 && pwd.lastIndexOf(")") + 1 == pwd.length()) {
            pwd = pwd.substring(4, pwd.length() - 1);
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(key);
            pwd = encryptor.decrypt(pwd);
        }
        return pwd;
    }

    /**
     * 读取密钥
     * @param key
     * @return
     */
    private String readDecryptKey(String key) {
        FileInputStream in = null;
        try {
            Properties properties = new Properties();
            in = new FileInputStream("file.properties");
            properties.load(in);

            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
