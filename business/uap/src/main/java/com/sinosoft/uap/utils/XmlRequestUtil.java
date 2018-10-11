package com.sinosoft.uap.utils;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.uap.dto.PacketRequestDto;
import com.thoughtworks.xstream.XStream;

public class XmlRequestUtil {
    private final String BODY_CLASS_FLAG = "BODY_CLASS";

    /**
     * xml转PacketDto   其中body是对象
     * @param xml 入参报文
     * @param dtoClass body类型.class
     * @param <T> body类型
     * @return
     */
    public <T> PacketRequestDto<T> xmlToPacketDto_bodyDto(String xml, Class<T> dtoClass) {
        xml = xmlBodyAddClassAtrr(xml);
        XStream xstream = new XStream();
        xstream.alias("Packet", PacketRequestDto.class);
        xstream.alias(this.BODY_CLASS_FLAG,dtoClass);
        xstreamSetting(xstream);
        PacketRequestDto<T> packetDto = (PacketRequestDto<T>) xstream.fromXML(xml);
        return packetDto;
    }
    public String xmlBodyAddClassAtrr(String xml){
        xml = xml.replace("<body","<body class='"+BODY_CLASS_FLAG+"'");
        return xml;
    }
    /**
     * 复杂转换重写此方法
     * @param xstream
     */
    public  void xstreamSetting(XStream xstream){};
}
