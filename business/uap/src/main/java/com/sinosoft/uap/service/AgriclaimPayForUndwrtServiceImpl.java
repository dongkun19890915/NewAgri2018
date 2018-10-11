package com.sinosoft.uap.service;

import com.sinosoft.agriclaim.api.paymentmanage.PrplPayApi;
import com.sinosoft.agriclaim.api.paymentmanage.dto.RequestPrpLPayDto;
import com.sinosoft.agriclaim.api.paymentmanage.dto.ResponsePrpLPayDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;




@WebService(serviceName = "AgriclaimPayForUndwrtService",//服务名
        targetNamespace = "http://service.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.AgriclaimPayForUndwrtService")
@Service
public class AgriclaimPayForUndwrtServiceImpl implements AgriclaimPayForUndwrtService {

    @Autowired
    PrplPayApi prplPayApi;


    /**
     * 双核系统支付审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:19
     * @param requestXml 请求数据
     * @return 回调成功
     * @throws Exception
     */
    @Override
    public String writeVeriPay(@WebParam(name="requestXml") String requestXml) throws Exception {
        XmlUtil xmlUtil = new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("RequestPrpLPayDto", RequestPrpLPayDto.class);
            }
        };
        PacketDto<UndwrtWriteBackReCaseDto> requestPrpLPayDtoPacketDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, UndwrtWriteBackReCaseDto.class);
        UndwrtWriteBackReCaseDto requestPrpLPayDto = requestPrpLPayDtoPacketDto.getBody();
        Integer flag=prplPayApi.writeVeriPay(requestPrpLPayDto);
        ResponsePrpLPayDto responsePrpLPayDto = new ResponsePrpLPayDto();
        responsePrpLPayDto.setCheckFlag(flag);
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody(responsePrpLPayDto);
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
    }


}
