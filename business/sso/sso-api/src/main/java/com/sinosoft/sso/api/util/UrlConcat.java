package com.sinosoft.sso.api.util;

/**
 * 
 * @description url地址连接
 * @example UrlConcat.instance(url).concat(path).getUrl();
 * @author ZhangJiansen
 * @date 2016年10月13日下午1:34:12
 */
public class UrlConcat
{
    private String url;

    private UrlConcat(String base){
        this.url = base;
    }
    public static UrlConcat instance(String base){
        return new UrlConcat(base);
    }
    
    public UrlConcat concat(String path){
        url = concatUrl(url,path);
        return this;
    }
    
    public String getUrl(){
        return url;
    }
    
    private String concatUrl(String url, String suffix){
        if(url.endsWith("/")){
            return url+suffix;
        }else{
            return url+"/"+suffix;
        }
    }
}
