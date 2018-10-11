package com.sinosoft.uap.service.agriclaim;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:理赔提供双核服务接口
 *@Author:jiaoyunzhen
 *@Since:2017年11月09日
 */
@WebService(name = "claimForUndwrtService",
            targetNamespace = "http://agriclaim.service.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface ClaimForUndwrtService {

	/**
     * @description 预赔登记表，或赔款计算书表回写underWriteFlag
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 汪钊
     * @date 2017年11月09日
     */
    @WebMethod
    String echoUnderWriteFlag(@WebParam(name = "xml") String xml) throws Exception;
    
}
