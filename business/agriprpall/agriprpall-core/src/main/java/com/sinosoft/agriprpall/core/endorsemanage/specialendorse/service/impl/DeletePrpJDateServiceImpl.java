package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.client.paymentclient.AgriPrpallQueryAndDeleteExchangeInfoService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.DeletePrpJDateService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 根据保单号删除收付数据(webservice)
 * @author 王保良
 * @date 2017年11月10日
 */
@Service
public class DeletePrpJDateServiceImpl extends BaseServiceImpl implements DeletePrpJDateService {

    @Value("${webservice.webAgriPrpallService.url}")
    private String agriPrpallQueryAndDeleteExchangeInfoServiceUrl;

    private String failCode="9999";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePrpJDate(String businessNo) throws Exception {
        if (StringUtils.isEmpty(businessNo)){
            throw new DataVerifyException("请传入保单号或批单号");
        }


//        组装对象
        PacketDto packetDto= new PacketDto();
        packetDto.setBody(businessNo);
        XmlUtil xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);

        //发送给webService
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallQueryAndDeleteExchangeInfoService.class);
        jaxWsProxyFactoryBean.setAddress(agriPrpallQueryAndDeleteExchangeInfoServiceUrl+"/webAgriPrpallService/services/AgriPrpallQueryAndDeleteExchangeInfoService?wsdl".trim());
        AgriPrpallQueryAndDeleteExchangeInfoService agriPrpallQueryAndDeleteExchangeInfoService=(AgriPrpallQueryAndDeleteExchangeInfoService)jaxWsProxyFactoryBean.create();
        String responseXml=agriPrpallQueryAndDeleteExchangeInfoService.queryAndDeleteExchangeInfo(requestXml);

        //解析
        PacketDto<String> responseDto=xmlUtil.xmlToPacketDto_bodyDto(responseXml,String.class);
        String statusCode=responseDto.getHead().getReturnStatusCode();
        if (failCode.equals(statusCode)){
            throw new BusinessException(responseDto.getHead().getReturnMessage());
        }
    }
}
