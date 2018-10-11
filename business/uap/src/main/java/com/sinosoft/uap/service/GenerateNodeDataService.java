package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 生成承保流程几点数据供老系统生成接点数据使用Service
 *
 * @date: 2018/4/11 9:16
 * @author: 何伟东
 */
@WebService(name = "GenerateNodeDataService", targetNamespace = "http://service.demo.uap.sinosoft.com")
public interface GenerateNodeDataService {

    /**
     * 生成承保节点数据
     *
     * @param requestXml 请求报文
     * @date: 2018/4/11 10:41
     * @author: 何伟东
     */
    @WebMethod
    String generateNode(@WebParam(name = "requestXml") String requestXml);
}
