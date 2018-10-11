package com.sinosoft.uap.service;

import com.sinosoft.txnlist.api.gisinsurelist.dto.GisItemListRequestDto;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:投保单webservice服务接口
 *@Author:汪强
 *@Since:2017年11月4日
 */
@WebService(name = "InsureListService",
        targetNamespace = "http://service.demo.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface InsureListService {

    /**
     * @description 投保清单持久化接口
     * @author 汪强
     * @date 2017年11月4日
     * @param requestXml 投保预确认数据主表  农户清单表 田块清单表
     * @return 客户名称
     * @throws Exception
     */
    @WebMethod
    String saveInsureList(@WebParam(name = "requestXml") String requestXml)throws Exception;


    /**
     *  根据GIS清单号查询 承保清单 种植险
     * @author: 汪强
     * @date: 2017/11/28
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     */
    @WebMethod
    String queryPlantingPolicyListByGisInsureListCode(@WebParam(name="gisInsureListCode")String gisInsureListCode)throws Exception;

    /**
     *  根据GIS清单号查询 承保清单 养殖险
     * @author: 汪强
     * @date: 2017/11/28
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     */
    @WebMethod
    String queryHerdSettleListByGisInsureListCode(@WebParam(name="gisInsureListCode")String gisInsureListCode)throws Exception;


    /**
     * 保存损失率清单 种植险
     * @author 汪强
     * @date 2017-11-29
     * @param requestXml
     * @return
     * @throws Exception
     */
    @WebMethod
    String savePlantingLossRateList(@WebParam(name="requestXml") String requestXml)throws Exception;



    /**
     * 投保预确认清单接口
     * @author 汪强
     * @date 2018-1-29
     * @param requestXml
     * @return
     * @throws Exception
     */
    @WebMethod(operationName = "ReceivePreconfirmInsureList")
    String receivePreconfirmInsureList(@WebParam(name="requestXml") String requestXml)throws Exception;

    /**
     * 承保清单查询接口
     * 金禾系统调用交易清单接口查看保单信息
     * @param insureListCode
     * @return
     * @throws Exception
     */
    @WebMethod(operationName = "QueryPolicyByGisInsureListCode")
    String queryPolicyByGisInsureListCode(@WebParam(name="insureListCode") String insureListCode)throws Exception;

    /**
     * 修改密码
     * @param requestXml 用户信息
     * @return
     */
    @WebMethod(operationName = "modifyPwd")
    String modifyPwd(@WebParam(name = "userCode") String userCode,@WebParam(name = "password") String password,@WebParam(name = "passwordNew") String passwordNew);


}
