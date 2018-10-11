package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 提供给金禾的接口
 * @Author: 孙朋飞
 * @Date: 2018/3/7 10:26
 */
@WebService(name = "AgriclaimFlowService",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface AgriclaimFlowService {

    /**
     * 调查流程节点
     * @author: 孙朋飞
     * @date: 2018/3/7 10:31
     * @param requestXml 请求数据
     * @return 报案号
     * @throws Exception
     */
    @WebMethod
    String saveInvestigation(@WebParam(name="requestXml") String requestXml);

}
