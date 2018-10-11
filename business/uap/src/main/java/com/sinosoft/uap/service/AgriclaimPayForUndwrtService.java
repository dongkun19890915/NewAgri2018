package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(name = "AgriclaimPayForUndwrtService",
        targetNamespace = "http://service.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface AgriclaimPayForUndwrtService {

    /**
     *双核系统支付审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:16
     * @param requestXml 请求数据
     * @return 回调成功
     * @throws Exception
     */
    @WebMethod
    String writeVeriPay(@WebParam(name = "requestXml") String requestXml) throws Exception;
}
