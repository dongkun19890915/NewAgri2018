package com.sinosoft.uap.service.agriclaim;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @description 理赔提供收付服务接口
 * @author wangzhao
 * @date 2017年12月27日 上午11:02:36
 */
@WebService(name = "claimForPaymentService",
            targetNamespace = "http://agriclaim.service.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface ClaimForPaymentService {

    /**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     */ 
    @WebMethod
    String payInfoBack(@WebParam(name = "xml") String xml) throws Exception;
}
