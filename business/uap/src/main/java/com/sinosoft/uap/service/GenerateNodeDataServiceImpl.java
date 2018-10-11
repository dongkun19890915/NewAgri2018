package com.sinosoft.uap.service;

import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.utils.StringUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Map;
import java.util.TimeZone;

/**
 * 生成承保流程几点数据供老系统生成接点数据使用ServiceImpl
 *
 * @date: 2018/4/11 9:16
 * @author: 何伟东
 */
@WebService(serviceName = "GenerateNodeDataService",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.GenerateNodeDataService")
@Service
public class GenerateNodeDataServiceImpl implements GenerateNodeDataService {

    //http://localhost:9012/services/GenerateNodeDataService?wsdl
    /**
     * log日志
     */
    private final Logger LOGGER = LoggerFactory.getLogger(GenerateNodeDataServiceImpl.class);

    @Autowired
    private ProcessApi processApi;

    /**
     * 生成承保节点数据
     *
     * @param requestXml 请求报文
     * @date: 2018/4/11 10:41
     * @author: 何伟东
     */
    @Override
    public String generateNode(@WebParam(name = "requestXml") String requestXml) {
        LOGGER.debug(requestXml);
        PacketDto packetDtoResult = new PacketDto();
        HeadDto headDto = new HeadDto();
        XmlUtil util = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
            }
        };
        PacketDto<ProcessDto> processDtoPacketDto = null;
        try {
            processDtoPacketDto = util.xmlToPacketDto_bodyDto(requestXml, ProcessDto.class);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            e.printStackTrace();
        }
        if (processDtoPacketDto == null) {
            headDto.setReturnStatusCode("9999");
            headDto.setReturnMessage("参数错误，对象转换失败");
            packetDtoResult.setHead(headDto);
        } else {
            ProcessDto processDto = processDtoPacketDto.getBody();
            Map<String, String> returnMessage = processApi.generateNodeData(processDto);
            if (StringUtils.isNotEmpty(returnMessage.get("message"))) {
                headDto.setReturnStatusCode("9999");
                headDto.setReturnMessage(returnMessage.get("message"));
                packetDtoResult.setHead(headDto);
            } else {
                packetDtoResult.setHead(headDto);
            }
        }
        packetDtoResult.setBody("");
        String responseXml = util.packetDtoToXml_bodyDto(packetDtoResult);
        return responseXml;
    }
}
