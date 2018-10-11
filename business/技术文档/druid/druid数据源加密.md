# 一、maven依赖
```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.0.25</version>
</dependency>
```
# 二、生成密码
## 1､命令行生成
```
java –cp xx/xxx/druid-1.0.18.jar com.alibaba.druid.filter.config.ConfigTools 你的密码
```
输出参数说名：
- privateKey=xxxxx
- publicKey=xxxxxx
- password=xxxxxx

加密说明：
- 明文密码+私钥(privateKey)加密=加密密码
- 加密密码+公钥(publicKey)解密=明文密码

## 2､代码生成
```
import com.alibaba.druid.filter.config.ConfigTools;
public class test {
    public static void main(String[] args)throws Exception{
        //密码明文
        String password = "123456";
        System.out.println("密码[ "+password+" ]的加密信息如下：\n");
        String [] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        password = ConfigTools.encrypt(privateKey, password);
        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("password:"+password);
        String decryptPassword=ConfigTools.decrypt(publicKey, password);
        System.out.println("decryptPassword："+decryptPassword);
    }
}
```
# 三、配置数据源加密
## 1､application.properties配置
### 1.1数据库密码加密
加密命令
```
#java –cp druid-1.0.18.jar com.alibaba.druid.filter.config.ConfigTools 123456
```
加密结果
```
privateKey=xxxxx
publicKey=xxxxxx
password=xxxxxx
```
### 1.2数据库密码加密
```
#数据源
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.url= jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=${password}
```

### 1.3数据源其他配置参数
```
# 下面为连接池的补充设置，应用到上面所有数据源中
# 初始化大小，最小，最大
spring.datasource.initialSize=5
spring.datasource.minIdle=5
spring.datasource.maxActive=20
# 配置获取连接等待超时的时间
spring.datasource.maxWait=60000
# 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
spring.datasource.timeBetweenEvictionRunsMillis=60000
# 配置一个连接在池中最小生存的时间，单位是毫秒
spring.datasource.minEvictableIdleTimeMillis=300000
spring.datasource.validationQuery=SELECT 1
spring.datasource.testWhileIdle=true
spring.datasource.testOnBorrow=false
spring.datasource.testOnReturn=false
# 打开PSCache，并且指定每个连接上PSCache的大小
spring.datasource.poolPreparedStatements=true
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
# 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
spring.datasource.filters=config
## 通过connectProperties属性来打开mergeSql功能；慢SQL记录
spring.datasource.connectionProperties=config.decrypt=true;config.decrypt.key=${publicKey}
```

## 2､DruidConfig配置
```
@Configuration
public class DruidConfig {

    @Bean
    public DataSource druidDataSource(
            @Value("${spring.datasource.driverClassName}") String driver,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${publicKey}") String publicKey,
            @Value("${spring.datasource.initialSize}") int initialSize,
            @Value("${spring.datasource.minIdle}") int minIdle,
            @Value("${spring.datasource.maxActive}") int maxActive,
            @Value("${spring.datasource.maxWait}") long maxWait,
            @Value("${spring.datasource.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis,
            @Value("${spring.datasource.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis,
            @Value("${spring.datasource.validationQuery}") String validationQuery,
            @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle,
            @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,
            @Value("${spring.datasource.testOnReturn}") boolean testOnReturn,
            @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements,
            @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}") int maxPoolPreparedStatementPerConnectionSize,
            @Value("${spring.datasource.filters}") String filters,
            @Value("${spring.datasource.connectionProperties}") String connectionProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource
                .setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource
                .setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource
                .setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setConnectionProperties(connectionProperties);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
```

# 四、自定义数据源加密 用户名、密码
```

#spring.datasource.type=com.spring.boot.DecryptDruidSource


import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.security.PublicKey;
import java.util.Properties;

@SuppressWarnings("all")
public class DecryptDruidSource extends DruidDataSource{
//    @Override
//    public void setUsername(String username) {
//        try {
//            username = ConfigTools.decrypt(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        super.setUsername(username);
//    }
    @Override
    public void setPassword(String password){

        Properties prop = new Properties();
        try {
            prop.load(DecryptDruidSource.class.getClassLoader().getResourceAsStream("application.properties"));
            //String publicKeyText="MFwwDQ";
            String publicKeyText=prop.getProperty("publicKey");
            password = ConfigTools.decrypt(publicKeyText,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setPassword(password);
    }
}
```
测试代码啊：
```
public class ConfigToolsTest extends TestCase { 
    public void test_0() throws Exception {
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUAMHrATatXwODDAcHxfIcG6diYsw0l0Qfj/NJivHXMVs5JRYf4vao2nEXB+BxA3gHO0er3KiGpz2ieQjPgSF8CAwEAAQ=="; 
        String password = "Q+zSOJytnRLmFHxB9YdFXlMnJj2y60r0Z11OFTRTOYQ/4kzKDWIU6AtFUv+DeVLuitKPGXGIkmalAXaoApOlzw=="; 
        System.out.println( ConfigTools.decrypt(publickey, password) );
    }
｝
```
配置文件：
```
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
# 生成的加密后的密码（原密码 123456）
spring.datasource.password=WVMjPhfXQrIsWRo0/RCqAVvYtTU9WNVToKJohb8AlUmHwnV6vwFL+FM2CNFDMJwGHW1iCmyaUlF+sgvFdogqEA==
# 生成的公钥
public-key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIiwHpFrDijV+GzwRTzWJk8D3j3jFfhsMFJ/7k1NTvBuLgL+TdIHgaMNOIEjHpXzuvX38J3FtOK8hLrySncVGOMCAwEAAQ==
# 配置 connection-properties，启用加密，配置公钥。
spring.datasource.druid.connection-properties=config.decrypt=true;config.decrypt.key=${public-key}
# 启用ConfigFilter
spring.datasource.druid.filter.config.enabled=true
```

- 明文密码+私钥(privateKey)加密=加密密码
- 加密密码+公钥(publicKey)解密=明文密码

```
package com.spring.boot;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import java.security.PublicKey;
import java.util.Properties;

/**
 * 用来解密配置中的密文(重点配置，在这里扩展用户名的解密)
 * setUsername(name) 方法对应xml中的一个property属性，password默认加密不需要重写，
 * 还可以加密url 重写setUrl(url)
 */
@SuppressWarnings("all")
public class DecryptDruidSource extends DruidDataSource{
    @Override
    public void setPassword(String password){
        Properties prop = new Properties();
        try {
            prop.load(DecryptDruidSource.class.getClassLoader().getResourceAsStream("application.properties"));
            String publicKeyText=prop.getProperty("publicKey");
            password = ConfigTools.decrypt(publicKeyText,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setPassword(password);
    }
}
```

```
#spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.type=com.spring.boot.DecryptDruidSource
spring.datasource.url= jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=${password}
```
数据库密码加密:
```
#java –cp druid-1.0.18.jar com.alibaba.druid.filter.config.ConfigTools 123456
privateKey=MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAz60a0AONJ3mSMZrM70IGwxZsUrsvUKtJMc6dhfUNHI5Z3x4R6zcEvz510CLB/T8wRKwkvy2Sfl8/TBl028UXLwIDAQABAkEAnC0c3dPd4hLNu1ojxcYMmceSHMFB+tNlDvzHf4binlae/bzY9aHDlSt9VWue9PPL5kG6haSiuwyxzvDSCOKjgQIhAPrWFrfYo7geCwpLfSzwbcf23Bf66r+ks9eU6l/nef9BAiEA0/OPxU+msZNc6MYAXv2AWKc/7OXXWiG2RGF68cUO6m8CIQCEkdPN9LyKma5CEaWls6iBz9GBBwc8pEK8hKLebwuGQQIgQdHhU+ToXzzkHWVfuCABO4a001yNA/B0Kcgb5fjMKQECIGnw3pdQ6rssoAslqsAEvUcs5uYdmBiGpultMDyqsblu
publicKey=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAM+tGtADjSd5kjGazO9CBsMWbFK7L1CrSTHOnYX1DRyOWd8eEes3BL8+ddAiwf0/MESsJL8tkn5fP0wZdNvFFy8CAwEAAQ==
password=ZgjQ4v1kY/o+v7/PjhOrdqUWcjreRu/nPQ1XSzgz7E6sMJasOgVWOFbgQLctRP6jU040gjRgWdyEjs5PYqik2A==
```