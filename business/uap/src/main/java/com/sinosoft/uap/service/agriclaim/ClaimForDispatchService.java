package com.sinosoft.uap.service.agriclaim;


import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:报案环节webservice服务接口
 *@Author:王保良
 *@Since:2017年11月4日
 */
@WebService(name = "ClaimForDispatchService" //服务名
        ,targetNamespace = "http://agricliam.service.uap.sinosoft.com/"
        )
public interface ClaimForDispatchService {

    public String  saveAgriScheduleDto (@WebParam(name = "xml") String xml)throws Exception;
}
