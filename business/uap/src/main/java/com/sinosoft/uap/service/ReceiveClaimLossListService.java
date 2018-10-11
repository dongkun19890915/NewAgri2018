package com.sinosoft.uap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:理赔清单ebservice服务接口
 *@Author:王心洋
 *@Since:2018年1月17日
 */
@WebService(name = "ReceiveClaimLossList",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface ReceiveClaimLossListService{
    /**
     * @description 理赔定损清单持久化接口
     * @author 王心洋
     * @date 2018年1月17日
     * @param requestXml 定损清单主表 农户清单表 田块清单表
     * @return 客户名称
     * @throws Exception
     */
    @WebMethod
    String saveLossList(@WebParam(name = "requestXml") String requestXml)throws Exception;
}