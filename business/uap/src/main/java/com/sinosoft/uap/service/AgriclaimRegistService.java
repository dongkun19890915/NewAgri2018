package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 提供给金禾的接口
 * @Author: 孙朋飞
 * @Date: 2018/3/7 10:26
 */
@WebService(name = "AgriclaimRegistService",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface AgriclaimRegistService {


    /**
     * 接受金禾预报案数据
     * @author: 孙朋飞
     * @date: 2018/3/13 14:30
     * @param requestXml 请求数据
     * @return 报案号
     * @throws Exception
     */
    @WebMethod
    String saveReportFoWebService(@WebParam(name = "requestXml") String requestXml);

}
