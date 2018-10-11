package com.sinosoft.uap.service;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLInvestigateApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestPrpLInvestigateDto;
import com.sinosoft.agriclaim.api.registmanage.dto.ReturnXmlDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Map;


/**
 * 调查流程节点
 * @Author: 孙朋飞
 * @Date: 2018/3/7 10:26
 */
@WebService(serviceName = "AgriclaimFlowService",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.AgriclaimFlowService")
@Service
public class AgriclaimFlowServiceImpl implements AgriclaimFlowService {


    @Autowired
    private PrpLInvestigateApi prpLInvestigateApi;
    /**
     * 调查流程节点
     * @author: 孙朋飞
     * @date: 2018/3/7 10:31
     * @param requestXml 请求数据
     * @return 报案号
     * @throws Exception
     */
    @Override
    public String saveInvestigation(@WebParam(name="requestXml")String requestXml) {
        XmlUtil xmlUtil = new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("RequestPrpLInvestigateDto", RequestPrpLInvestigateDto.class);
            }
        };
        PacketDto<RequestPrpLInvestigateDto> requestPrpLInvestigateDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, RequestPrpLInvestigateDto.class);
        RequestPrpLInvestigateDto requestInvestigateDto = requestPrpLInvestigateDto.getBody();
        String returnXml = "";
        ReturnXmlDto returnXmlDto = new ReturnXmlDto();
        Map<String, String> stringStringMap=null;
        try{
            stringStringMap = prpLInvestigateApi.saveInvestigation(requestInvestigateDto.getRegistNo(), requestInvestigateDto.getNodeStatus(),
                    requestInvestigateDto.getHandlerCode(), requestInvestigateDto.getHandlerName(), requestInvestigateDto.getUserComCode(), requestInvestigateDto.getUserComCname());
            returnXmlDto.setCode("00");
            returnXmlDto.setRegistNo(stringStringMap.get("registNo"));
            returnXmlDto.setMessage(stringStringMap.get("message"));
        }catch (Exception e){
            returnXmlDto.setCode("01");
            returnXmlDto.setMessage(stringStringMap.get("message"));
        }
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody(returnXmlDto);
        returnXml = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
        return returnXml;
    }
}
