package com.sinosoft.uap.service.agriclaim;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *@Description:单表查询服务接口
 *@Author:周柯宇
 *@Since:2017年11月28日
 */

@WebService(name = "queryClaimTableService",
targetNamespace = "http://agriclaim.service.uap.sinosoft.com")// 命名空间,一般是接口的包名倒序
public interface QueryClaimTableService {
	
	/**
     * @description 依据立案号查询立案基本信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLclaim(@WebParam(name = "xml") String xml) throws Exception;	
	 
	 /**
     * @description 依据赔款计算书号码查询赔款计算书信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLcompensate(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据预赔号查询预付信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLprepay(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据报案号码查询报案信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLregist(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据业务号码和标的号码查询单证收集信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLcertifyCollect(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据立案号码查询重开赔案信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLrecase(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据单证号，单证类型，结案号查询赔案号信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLcaseNo(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 依据预赔号，是否申请例外标志，启动例外标志查询账户信息表信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	 @WebMethod
	 public String queryPrpLsumpay(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 结案大对象查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	 @WebMethod
	 public String queryEndCase(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 共保费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	 @WebMethod
	 public String queryPrpLcfeecoins(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 赔付标的信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	 @WebMethod
	 public String queryPrpLloss(@WebParam(name = "xml") String xml) throws Exception;
	 
	 /**
     * @description 赔款费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	 @WebMethod
	 public String queryPrpLcharge(@WebParam(name = "xml") String xml) throws Exception;
	 /**
     * @description 立案险别估损金额表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	 @WebMethod
	 public String queryPrpLclaimLoss(@WebParam(name = "xml") String xml) throws Exception;

	 
}
