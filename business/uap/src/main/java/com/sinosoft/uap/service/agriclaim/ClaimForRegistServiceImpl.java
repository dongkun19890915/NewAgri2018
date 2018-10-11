package com.sinosoft.uap.service.agriclaim;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.RegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.AgriRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.ReturnXmlDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.uap.service.InsureListServiceImpl;
import com.thoughtworks.xstream.XStream;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Map;

@WebService(serviceName = "ClaimForRegistService",
targetNamespace = "http://agricliam.service.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.agriclaim.ClaimForRegistService"
)
@Service
public class ClaimForRegistServiceImpl  implements ClaimForRegistService {
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private RegistApi registApi;

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InsureListServiceImpl.class);

    @Override
    public String saveAgriRegistDto(@WebParam(name = "xml") String xml) throws Exception {
        XmlUtil xmlUtil=new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("AgriRegistDto", AgriRegistDto.class);
            }
        };

        //xml对象转换方法 调用理赔的报案登记接口 入参满足调用入参
        PacketDto<AgriRegistDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(xml, AgriRegistDto.class);
        AgriRegistDto agriRegistDto = packetDto.getBody();
        ReturnXmlDto returnXmlDto = new ReturnXmlDto();
        String returnXml = "";
        try {
            Map<String,String> map = registApi.gisSaveReport(agriRegistDto);
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
