package com.sinosoft.uap.service.agriclaim;


import com.sinosoft.agriclaim.api.registmanage.dto.ReturnXmlDto;
import com.sinosoft.agriclaim.api.schedulemanage.ScheduleApi;
import com.sinosoft.agriclaim.api.schedulemanage.dto.AgriScheduleDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Map;

@WebService(serviceName = "ClaimForDispatchService",
        targetNamespace = "http://agricliam.service.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.agriclaim.ClaimForDispatchService"
)
@Service
public class ClaimForDispatchServiceImpl implements ClaimForDispatchService{

    @Autowired
    private ScheduleApi scheduleApi;


    @Override
    public String saveAgriScheduleDto(@WebParam(name = "xml") String xml) throws Exception {
        XmlUtil xmlUtil=new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("AgriScheduleDto", AgriScheduleDto.class);
            }
        };
        PacketDto<AgriScheduleDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(xml, AgriScheduleDto.class);
        AgriScheduleDto agriScheduleDto = packetDto.getBody();


        ReturnXmlDto returnXmlDto = new ReturnXmlDto();
        String returnXml = "";
        try {
            Map<String,String> map = scheduleApi.gisScheduleSaveDeal(agriScheduleDto);
            returnXmlDto.setCode("00");
            returnXmlDto.setRegistNo(map.get("registNo"));
            returnXmlDto.setMessage("交互成功,报案号为"+map.get("registNo"));
        }catch (Exception e){
            returnXmlDto.setCode("01");
            returnXmlDto.setMessage("交互失败");
        }




        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody(returnXmlDto);
        returnXml = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);

        return returnXml;
    }
}
