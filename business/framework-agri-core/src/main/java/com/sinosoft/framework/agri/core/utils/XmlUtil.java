package com.sinosoft.framework.agri.core.utils;


import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * 报文&对象转换工具类
 */

/**
 * @Description:（请具体描述此方法的用途及逻辑）
 * @Author: 周家伟
 * @Date: 2017/10/13 15:06
 */
public class XmlUtil {
    private final String BODY_CLASS_FLAG = "BODY_CLASS";

    /**
     * xml转PacketDto   其中body是对象
     *
     * @param xml      入参报文
     * @param dtoClass body类型.class
     * @param <T>      body类型
     * @return
     */
    public <T> PacketDto<T> xmlToPacketDto_bodyDto(String xml, Class<T> dtoClass) {
        xml = xmlBodyAddClassAtrr(xml);
        XStream xstream = new XStream();
        xstream.alias("Packet", PacketDto.class);
        xstream.alias(this.BODY_CLASS_FLAG, dtoClass);
        xstreamSetting(xstream);
        PacketDto<T> packetDto = (PacketDto<T>) xstream.fromXML(xml);
        return packetDto;
    }

    /**
     * xml转PacketDto   其中body是List
     * @param xml 入参报文
     * @param dtoClass  body中每个对象的类型.class
     * @param <T>  body中每个对象的类型
     * @param aliasName  body中每一个对象的别名
     * @return
     */

    /**
     * @param xml
     * @param dtoClass
     * @param aliasName
     * @param <T>
     * @return
     * @description:（请具体描述此方法的用途及逻辑）
     * @author: 周家伟
     * @date: 2017/10/13 15:05
     */
    public <T> PacketDto<List<T>> xmlToPacketDto_bodyList(String xml, Class<T> dtoClass, String aliasName) {
        return xmlToPacketDto_bodyList(xml, dtoClass, aliasName,false);
    }

    public <T> PacketDto<List<T>> xmlToPacketDto_bodyList(String xml, Class<T> dtoClass, String aliasName, boolean autodetectAnnotations) {
        xml = xmlBodyAddClassAtrr(xml);
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(autodetectAnnotations);
        xstream.alias("Packet", PacketDto.class);
        xstream.alias(this.BODY_CLASS_FLAG, List.class);
        xstream.alias(aliasName, dtoClass);
        xstreamSetting(xstream);
        PacketDto<List<T>> packetDto = (PacketDto<List<T>>) xstream.fromXML(xml);
        xstream.alias(aliasName, dtoClass);
        return packetDto;
    }

    /**
     * Dto转xml  其中body为单个对象
     *
     * @param dto PacketDto
     * @return xml报文
     */
    public String packetDtoToXml_bodyDto(PacketDto dto) {
        XStream xstream = new XStream();
        xstream.alias("Packet", PacketDto.class);
        if (dto.getBody() instanceof List || dto.getBody() instanceof ArrayList) {
            xstream.alias("LIST", List.class);
        } else {
            xstream.alias("DTO", dto.getBody().getClass());
        }
        xstream.aliasSystemAttribute(null, "class");
        xstreamSetting(xstream);
        String xml = xstream.toXML(dto);
        return xml;
    }

    /**
     * Dto转xml  其中body为单个对象
     *
     * @param dto PacketDto
     * @return xml报文
     */
    public String packetDtoToXml_bodyDto(PacketDto dto, boolean autodetectAnnotations) {
        XStream xstream = new XStream();
        xstream.alias("Packet", PacketDto.class);
        xstream.autodetectAnnotations(autodetectAnnotations);
        if (dto.getBody() instanceof List || dto.getBody() instanceof ArrayList) {
            xstream.alias("LIST", List.class);
        } else {
            xstream.alias("DTO", dto.getBody().getClass());
        }
        xstream.aliasSystemAttribute(null, "class");
        xstreamSetting(xstream);
        String xml = xstream.toXML(dto);
        return xml;
    }

    /**
     * Dto转xml  其中body为集合
     *
     * @param dto      PacketDto
     * @param dtoClass body集合的每个对象类型
     * @param dtoClass body集合的每个对象类型 转别名
     * @return xml报文
     */
    public <T> String packetDtoToXml_bodyList(PacketDto dto, Class<T> dtoClass, String aliasName) {
        XStream xstream = new XStream();
        xstream.alias("Packet", PacketDto.class);
        if (dto.getBody() instanceof List || dto.getBody() instanceof ArrayList) {
            xstream.alias("LIST", List.class);
            xstream.alias(aliasName, dtoClass);
        } else {
            xstream.alias("DTO", dto.getBody().getClass());
        }
        xstream.aliasSystemAttribute(null, "class");
        xstreamSetting(xstream);
        String xml = xstream.toXML(dto);
        return xml;
    }

    public String xmlBodyAddClassAtrr(String xml) {
        xml = xml.replace("<body", "<body class='" + BODY_CLASS_FLAG + "'");
        return xml;
    }

    /**
     * 复杂转换重写此方法
     *
     * @param xstream
     */
    public void xstreamSetting(XStream xstream) {
    }

    ;
}
