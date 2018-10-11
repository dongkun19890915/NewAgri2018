package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 *@Description:客户信息服务接口
 *@Author:周家伟
 *@Since:2017年10月11日
 */
@WebService(name = "prpDcustomerService",
            targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface PrpDcustomerService {
    /**
     * @description 依据客户代码查询客户名称
     * @param xml 入参报文
     * @return 客户名称
     * @throws Exception
     * @author 周家伟
     * @date 2017年10月11日
     */
    @WebMethod
    String getCustomerName(@WebParam(name = "xml") String xml) throws Exception;
}
