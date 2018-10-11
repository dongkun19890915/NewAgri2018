package com.sinosoft.uap.service.agriclaim;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:报案环节webservice服务接口
 *@Author:王保良
 *@Since:2017年11月4日
 */
@WebService(name = "ClaimForRegistService" //服务名
        ,targetNamespace = "http://agricliam.service.uap.sinosoft.com/"
)

public interface ClaimForRegistService {

    /**
     * @description 预赔报案登记服务
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 王保良
     * @date 2017年11月09日
     */
    @WebMethod
    public String  saveAgriRegistDto(@WebParam(name = "xml") String xml) throws Exception;

}
