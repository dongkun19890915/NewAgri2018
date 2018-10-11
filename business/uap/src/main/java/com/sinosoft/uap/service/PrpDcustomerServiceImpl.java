package com.sinosoft.uap.service;

import com.sinosoft.demo.api.customer.CustomerApi;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 *@Description:客户信息服务接口实现
 *@Author:周家伟
 *@Since:2017年10月11日
 */
@WebService(serviceName = "prpDcustomerService",//服务名
            targetNamespace="http://service.demo.uap.sinosoft.com/",
            endpointInterface = "com.sinosoft.uap.service.PrpDcustomerService")
@Component
public class PrpDcustomerServiceImpl implements PrpDcustomerService {

//    @Autowired
//    private CustomerApi customerApi;

    /**
     * @param xml 入参报文
     * @return 客户名称
     * @throws Exception
     * @description 依据客户代码查询客户名称
     * @author 周家伟
     * @date 2017年10月11日
     */
    @Override
    public String getCustomerName(String xml) throws Exception {
        //1.xml转Dto
        XStream xstream = new XStream();
//        xstream.alias("root", WebServiceDto.class);
//        xstream.alias("prpDcustomerDto", PrpDcustomerDto.class);
//        WebServiceDto<PrpDcustomerDto> webServiceDto = (WebServiceDto<PrpDcustomerDto>) xstream.fromXML(xml);

        //2.调用demo应用服务查询
//        PrpDcustomerDto prpDcustomerDto = customerApi.getByPrimaryKey(webServiceDto.getData().getCustomerCode());


//        if (prpDcustomerDto != null) {
//            //3.查询结果转xml返回
//            String xmlstr2 = xstream.toXML(prpDcustomerDto);
//            System.out.println(xmlstr2);
//            return "接口1：" + prpDcustomerDto.getCustomerCName();
//        } else {
//            return "接口1：为查询到数据";
//        }
        return null;
    }



}