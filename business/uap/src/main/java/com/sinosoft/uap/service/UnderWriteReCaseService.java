package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/***（双核回写重开赔案服务接口）
 * @Author: 王志文
 * @Date: 2017/12/2 11:29
 */
@WebService(name = "underWriteReCaseService",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface UnderWriteReCaseService {
    @WebMethod
    String saveCaseTypeByUndwrt(@WebParam(name = "xml") String xml) throws Exception;
}
