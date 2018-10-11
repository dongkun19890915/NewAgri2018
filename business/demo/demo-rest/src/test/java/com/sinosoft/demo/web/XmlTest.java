package com.sinosoft.demo.web;

import com.sinosoft.demo.api.customer.dto.PrpDUserDto;
import com.sinosoft.demo.api.customer.dto.PrpDcompanyDto;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: xml报文与对象转换工具类  测试类
* @Author: 周家伟
* @Date: 2017/10/27 15:07
*/
public class XmlTest {
    /**
     * @description: 对象(body部分为单个对象) 转 报文
     * @author: 周家伟
     * @date: 2017/10/27 15:07
     */
    @Test
    public void dtoToXmlTest(){
        PrpDcustomerDto prpDcustomerDto = new PrpDcustomerDto();
        prpDcustomerDto.setCustomerCode("0001");
        prpDcustomerDto.setCustomerCName("张三");

        PacketDto<PrpDcustomerDto> packeDto = new PacketDto<PrpDcustomerDto>();
        packeDto.setBody(prpDcustomerDto);

        XmlUtil xmlUtil = new XmlUtil();
        String returnXml = xmlUtil.packetDtoToXml_bodyDto(packeDto);
        System.out.println(returnXml);
    }

    /**
     * @description: 报文 转 对象（body部分为单个对象）
     * @author: 周家伟
     * @date: 2017/10/27 15:08
     */
    @Test
    public void xmlToDtoTest(){

        String xml =" <Packet>                                         "+
                "   <head>                                       "+
                "     <userCode>0000</userCode>                  "+
                "     <passWord>交互成功</passWord>              "+
                "   </head>                                      "+
                "   <body>                           "+
                "     <attaches/>                                "+
                "     <customerCode>0001</customerCode>          "+
                "     <customerCName>张三</customerCName>        "+
                "   </body>                                      "+
                " </Packet>                                        ";

        XmlUtil xmlUtil = new XmlUtil();
        PacketDto<PrpDcustomerDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(xml,PrpDcustomerDto.class);
        System.out.println();
    }

    /**
     * @description: List(body为List) 转 报文
     * @author: 周家伟
     * @date: 2017/10/27 15:09
     */
    @Test
    public void listToXmlTest(){

        PacketDto<List<PrpDcustomerDto>> packetDto = new PacketDto<List<PrpDcustomerDto>>();

        PrpDcustomerDto prpDcustomerDto = new PrpDcustomerDto();
        prpDcustomerDto.setCustomerCode("0001");
        prpDcustomerDto.setCustomerCName("张三");
        List<PrpDcustomerDto> prpDcustomerDtolist = new ArrayList<>();
        prpDcustomerDtolist.add(prpDcustomerDto);

        PrpDcustomerDto prpDcustomerDto2 = new PrpDcustomerDto();
        prpDcustomerDto2.setCustomerCode("0001");
        prpDcustomerDto2.setCustomerCName("张三");
        prpDcustomerDtolist.add(prpDcustomerDto2);

        packetDto.setBody(prpDcustomerDtolist);

        XmlUtil xmlUtil = new XmlUtil();
        String returnXml = xmlUtil.packetDtoToXml_bodyList(packetDto,PrpDcustomerDto.class,"prpDcustomerDto");
        System.out.println(returnXml);
    }

    /**
     * @description: 报文 转 List（body为List）
     * @author: 周家伟
     * @date: 2017/10/27 15:10
     */
    @Test
    public void xmlToListTest(){

        String xml =
                " <Packet>                                       "+
                "   <head>                                     "+
                "     <userCode>0000</userCode>                "+
                "     <passWord>交互成功</passWord>            "+
                "   </head>                                    "+
                "   <body>                        "+
                "     <prpDcustomerDto>                        "+
                "       <attaches/>                            "+
                "       <customerCode>0001</customerCode>      "+
                "       <customerCName>张三</customerCName>    "+
                "     </prpDcustomerDto>                       "+
                "     <prpDcustomerDto>                        "+
                "       <attaches/>                            "+
                "       <customerCode>0001</customerCode>      "+
                "       <customerCName>张三</customerCName>    "+
                "     </prpDcustomerDto>                       "+
                "   </body>                                    "+
                " </Packet>                                      ";
        XmlUtil xmlUtil = new XmlUtil();

        PacketDto<List<PrpDcustomerDto>> packetDto = xmlUtil.xmlToPacketDto_bodyList(xml,PrpDcustomerDto.class,"prpDcustomerDto");
        System.out.println();
    }

    /**
     * @description: 复杂对象（body为对象但对象中有子对象和集合） 转 报文
     * @author: 周家伟
     * @date: 2017/10/27 15:12
     */
    @Test
    public void complexObjectToXmlTest(){
        PrpDcompanyDto prpDcompanyDto = new PrpDcompanyDto();
        prpDcompanyDto.setComCode("000000000");
        prpDcompanyDto.setComName("***总公司");

        PrpDcompanyDto prpDcompanyDto2 = new PrpDcompanyDto();
        prpDcompanyDto2.setComCode("000000000");
        prpDcompanyDto2.setComName("***总公司");

        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
        prpDcompanyDtoList.add(prpDcompanyDto);

        PrpDUserDto prpDUserDto = new PrpDUserDto();
        prpDUserDto.setPrpDcompanyDto(prpDcompanyDto2);
        prpDUserDto.setPrpDcompanyDtoList(prpDcompanyDtoList);


        PacketDto<PrpDUserDto> packeDto = new PacketDto<PrpDUserDto>();
        packeDto.setBody(prpDUserDto);

        XmlUtil xmlUtil = new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                xstream.alias("prpDcompanyDto",PrpDcompanyDto.class);
            }
        };
        String returnXml = xmlUtil.packetDtoToXml_bodyDto(packeDto);
        System.out.println(returnXml);
    }

    /**
     * @description: 报文 转 复杂对象（body为对象但对象中有子对象和集合）
     * @author: 周家伟
     * @date: 2017/10/27 15:12
     */
    @Test
    public void xmlToComplexObjectTest(){
        String xml = " <Packet>                                              "+
                "   <head>                                              "+
                "     <returnStatusCode>0000</returnStatusCode>         "+
                "     <returnMessage>交互成功</returnMessage>           "+
                "   </head>                                             "+
                "   <body>                                  "+
                "     <prpDcompanyDtoList>                              "+
                "       <prpDcompanyDto>                                "+
                "         <comCode>000000000</comCode>                  "+
                "         <comName>***总公司</comName>                  "+
                "       </prpDcompanyDto>                               "+
                "     </prpDcompanyDtoList>                             "+
                "     <prpDcompanyDto>                                  "+
                "       <comCode>000000000</comCode>                    "+
                "       <comName>***总公司</comName>                    "+
                "     </prpDcompanyDto>                                 "+
                "   </body>                                             "+
                " </Packet>                                             ";
        XmlUtil xmlUtil = new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                xstream.alias("prpDcompanyDto",PrpDcompanyDto.class);
            }
        };
        PacketDto<PrpDUserDto> packeDto = xmlUtil.xmlToPacketDto_bodyDto(xml,PrpDUserDto.class);

        System.out.println();
    }
}
