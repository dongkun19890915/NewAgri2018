package com.sinosoft.uap.service;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 *@Description:客户信息服务接口实现
 *@Author:周家伟
 *@Since:2017年10月11日
 */
@WebService(serviceName = "prpDcustomer2Service",//服务名
            targetNamespace="http://service.demo.uap.sinosoft.com/",
            endpointInterface = "com.sinosoft.uap.service.PrpDcustomer2Service")
@Component
public class PrpDcustomer2ServiceImpl implements PrpDcustomer2Service {
    /**
     * @description 依据客户代码查询客户名称
     * @param customerCode 客户代码
     * @return 客户名称
     * @throws Exception
     * @author 周家伟
     * @date 2017年10月11日
     */
    @Override
    public String getCustomerName(String customerCode) {
        return "接口2：张三"+customerCode;
    }
}
