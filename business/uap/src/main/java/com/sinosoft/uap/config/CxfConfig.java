package com.sinosoft.uap.config;

import com.sinosoft.uap.service.*;
import com.sinosoft.uap.service.agriclaim.*;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    //    @Autowired
//    PrpDcustomerService prpDcustomerService;
//    @Autowired
//    PrpDcustomer2Service prpDcustomer2Service;
    @Autowired
    InsureListService insureListService;
    @Autowired
    ClaimForPaymentService claimForPaymentService;
    @Autowired
    QueryClaimTableService queryClaimTableService;
    @Autowired
    ClaimForUndwrtService claimForUndwrtService;
    @Autowired
    ReceiveClaimLossListService receiveClaimLossListService;
    @Autowired
    AgriclaimFlowService agriclaimFlowService;
    @Autowired
    AgriclaimRegistService agriclaimRegistService;
    @Autowired
    UnderWriteReCaseService underWriteReCaseService;
    @Autowired
    NyxEffctiveAmoutSaveService nyxEffctiveAmoutSaveService;
    @Autowired
    private GenerateNodeDataService generateNodeDataService;
    @Autowired
    private ClaimForRegistService claimForRegistService;
    @Autowired
    private ClaimForDispatchService claimForDispatchService;
    @Autowired
    AgriclaimPayForUndwrtService agriclaimPayForUndwrtService;
    /** JAX-WS **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus);
        Endpoint.publish("/InsureListService",insureListService);
        Endpoint.publish("/ReceiveClaimLossList",receiveClaimLossListService);//样例代码接口2
        Endpoint.publish("/claimForPaymentService",claimForPaymentService);//理赔提供收付接口
        Endpoint.publish("/queryClaimTableService",queryClaimTableService);//理赔提供双核查询接口
        Endpoint.publish("/claimForUndwrtService",claimForUndwrtService);//理赔提供双核业务接口
        Endpoint.publish("/AgriclaimFlowService",agriclaimFlowService);
        Endpoint.publish("/AgriclaimRegistService",agriclaimRegistService);
        Endpoint.publish("/UnderWriteReCaseService",underWriteReCaseService);
        Endpoint.publish("/NyxEffctiveAmoutSaveService",nyxEffctiveAmoutSaveService);//有效保额调用方法
        // 生成承保节点数据接口
        Endpoint.publish("/GenerateNodeDataService",generateNodeDataService);
        Endpoint.publish("/ClaimForDispatchService",claimForDispatchService);
        Endpoint.publish("/ClaimForRegistService",claimForRegistService);
        Endpoint.publish("/AgriclaimPayForUndwrtService",agriclaimPayForUndwrtService);
        return endpoint;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
//    }
}
