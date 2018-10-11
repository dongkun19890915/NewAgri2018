package com.sinosoft.notice.core.common.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.protocol.HTTP;


/**
 * @description 短信发送公共方法
 * @author zkr10
 * @date 2016年10月10日上午11:25:37
 */
public class SendCommonUtil
{

    
    /**
     * @description 短信,邮件交互公共方法
     * @param message
     * @param sendurl
     * @return  
     * @throws Exception
     * @author zkr10
     * @date 2016年10月10日下午6:46:54
     */
    public static String sendCommon(String message, String sendurl)
        throws Exception
    {
        HttpPost httpost = new HttpPost(sendurl);
        httpost.addHeader("Content-Type", "application/json");
        StringEntity entityTemplate = new StringEntity(message, "application/json",
            HTTP.UTF_8);
        entityTemplate.setContentEncoding(HTTP.UTF_8);
        httpost.setEntity(entityTemplate);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpost);
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return "";
        }
        String returnMsg = EntityUtils.toString(entity, HTTP.UTF_8);

        return returnMsg;
    }

}
