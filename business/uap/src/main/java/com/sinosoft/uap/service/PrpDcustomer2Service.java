package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:客户信息服务接口
 *@Author:周家伟
 *@Since:2017年10月11日
 */
@WebService(name = "prpDcustomer2Service",
            targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface PrpDcustomer2Service {
    /**
     * @description 依据客户代码查询客户名称
     * @param customerCode 客户代码
     * @return 客户名称
     * @throws Exception
     * @author 周家伟
     * @date 2017年10月11日
     */
    @WebMethod
    String getCustomerName(@WebParam(name = "customerCode") String customerCode);
}
