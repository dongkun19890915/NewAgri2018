package com.sinosoft.uap.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "NyxEffctiveAmoutSaveService",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface NyxEffctiveAmoutSaveService {

    /**
     * 保存有效保额表
     * @author: 刘曼曼
     * @date: 9:14 9:14
     * @param requestXml
     * @return String
     */
    public String saveNyxEffctiveAmoutWebService(@WebParam(name="requestXml")String requestXml);

    /**
     * 批改保存有效保额表
     * @author: 刘曼曼
     * @date: 9:15 9:15
     * @param requestXml
     * @return
     */
    public String modifyNyxEffctiveAmoutWebService(@WebParam(name="requestXml")String requestXml);
}
