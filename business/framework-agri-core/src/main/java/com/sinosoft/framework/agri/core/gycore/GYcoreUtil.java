package com.sinosoft.framework.agri.core.gycore;

import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.gycore.client.GYCoreWebService;
import com.sinosoft.framework.agri.core.gycore.client.GYCoreWebServiceSoap;
import com.sinosoft.framework.agri.core.gycore.dto.*;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * description:金禾webservice接口功能
 *
 * @outhor wq
 * @create 2018-03-07 16:14
 */
public class GYcoreUtil {
    private Logger logger = LoggerFactory.getLogger(GYcoreUtil.class);
    private GYCoreWebService gyCoreWebService;
    private GYCoreWebServiceSoap gyCoreWebServiceSoap;

    public GYcoreUtil(String gyServiceUrl) {
        URL url=null;
        try {
            url = new URL(gyServiceUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        gyCoreWebService = new GYCoreWebService(url);
        gyCoreWebServiceSoap = gyCoreWebService.getGYCoreWebServiceSoap();
    }
//    public GYcoreUtil() {
//        gyCoreWebService = new GYCoreWebService();
//        gyCoreWebServiceSoap = gyCoreWebService.getGYCoreWebServiceSoap();
//    }


    /**
     * 1、获取用户区域权限
     * 获取用户区域权限 核心段获取用户区域权限，五级联选。
     *
     * @param userCode 用户名
     * @param parentID 上级区域ID，默认显示省级时，parentID=0；
     * @return
     */
    public List<UserAreaRoleEntity> getUserRegion(String userCode, String parentID) {
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().getUserRegion(userCode, parentID);
        //TODO 临时方法，需要解决
        xml = xml.replaceAll("Head>", "head>").replaceAll("Body>", "body>");
        PacketDto packetDtoResult = new PacketDto();

        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("Region", UserAreaRoleEntity.class);
            }
        };
        PacketDto<List<UserAreaRoleEntity>> dto = xmlUtil.xmlToPacketDto_bodyList(xml, UserAreaRoleEntity.class, "Region", true);
        List<UserAreaRoleEntity> list = dto.getBody();
        return list;
    }

    /**
     * 2、承保节点数据保存
     * 核心段在完成每个承保流程节点时，调用接口保存至GIS端
     *
     * @param insureListCode 预投保清单编号
     * @param nodeItemData   节点数据
     * @return
     */
    public boolean addNodeItemData(String insureListCode, NodeItemData nodeItemData) {
        PacketDto<NodeItemData> packetDto = new PacketDto<>();
        HeadDto headDto = new HeadDto();
        packetDto.setHead(headDto);
        packetDto.setBody(nodeItemData);
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));

            }
        };

        String nodeItemXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().addNodeItemData(insureListCode, nodeItemXml);
        return isResult(xml).isSucess();
    }

    /**
     * 3、清单补录
     * 承保系统调用金禾的接口，传送清单的耳标号/连带被保险人清单
     */
    public boolean addListAdditionalData(String insureListCode, FarmerList farmerList) {
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("farmer", Farmer.class);
                xstream.alias("farmerItem", FarmerItem.class);
                xstream.alias("herdField", GisHerdFieldListDto.class);
                xstream.alias("manFieldList", GisManFieldListDto.class);
            }
        };

        PacketDto<FarmerList> packetDto = new PacketDto<>();
        packetDto.setBody(farmerList);
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);

        String xml = gyCoreWebService.getGYCoreWebServiceSoap().addListAdditionalData(insureListCode, requestXml);
        return isResult(xml).isSucess();
    }

    /**
     * 4、更新客户及银行基本信息
     * 核心段收集到客户新的基本信息或银行信息时，调用接口更新至GIS端。
     */
    public boolean updateCustomerInfo(String customerCode, String customerType, BankInfo bankInfo) {
        PacketDto<BankInfo> packetDto = new PacketDto<>();
        HeadDto headDto = new HeadDto();
        packetDto.setHead(headDto);
        packetDto.setBody(bankInfo);
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("bankInfo", BankInfo.class);
            }
        };
        String nodeItemXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().updateCustomerInfo(customerCode, customerType, nodeItemXml);
        return isResult(xml).isSucess();
    }

    /**
     * 5、生成预报案
     * 针对被呼叫中心判断为预报案的案件，理赔系统保存报案信息后调用接口，接收并保存报案信息
     */
    public boolean addReadyRegistInfo(ReadyRegistInfo readyRegistInfo) {
        PacketDto<ReadyRegistInfo> packetDto = new PacketDto<>();
        HeadDto headDto = new HeadDto();
        packetDto.setHead(headDto);
        packetDto.setBody(readyRegistInfo);
        XmlUtil xmlUtil = new XmlUtil();

        String nodeItemXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().addReadyRegistInfo(nodeItemXml);

        return isResult(xml).isSucess();
    }

    /**
     * 6、发起调查任务
     * 核心段通过系统调用金禾接口，接收并保存调查任务。
     *
     * @param addSurveyTaskDto 报案信息
     * @return String 没有值为成功，有值为失败原因
     */
    public String addSurveyTask(AddSurveyTaskDto addSurveyTaskDto) {
        XmlUtil xmlUtil = new XmlUtil();
        PacketDto<AddSurveyTaskDto> packetDto = new PacketDto<>();
        packetDto.setBody(addSurveyTaskDto);
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().addRegistInfo(requestXml);
        return isResult(xml).getMsg();
    }

    /**
     * 7、获取用户全部区域权限
     * 获取用户区域权限 核心段获取用户区域权限，五级
     * @param userCode 用户名
     * @return
     */
    public UserRegion getUserAllRegion(String userCode) {
        String xml = gyCoreWebService.getGYCoreWebServiceSoap().getUserAllRegion(userCode);
        //TODO 临时方法，需要解决
        PacketDto packetDtoResult = new PacketDto();

        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("Region", UserAreaRoleEntity.class);
            }
        };
        PacketDto<List<UserAreaRoleEntity>> dto = xmlUtil.xmlToPacketDto_bodyList(xml, UserAreaRoleEntity.class, "Region", true);
        List<UserAreaRoleEntity> list = dto.getBody();

        UserRegion userRegion=new UserRegion();
        List<String> fProvinceCodes = new ArrayList<>();
        List<String> fCityCodes = new ArrayList<>();
        List<String> fCountyCodes = new ArrayList<>();
        List<String> fTownCodes = new ArrayList<>();
        List<String> fVillageCodes = new ArrayList<>();
        for(UserAreaRoleEntity userAreaRoleEntity:list){
            switch (userAreaRoleEntity.getRegionlevel()){
                case "1":{
                    fProvinceCodes.add(userAreaRoleEntity.getGbbh());
                    break;
                }
                case "2":{
                    fCityCodes.add(userAreaRoleEntity.getGbbh());
                    break;
                }
                case "3":{
                    fCountyCodes.add(userAreaRoleEntity.getGbbh());
                    break;
                }
                case "4":{
                    fTownCodes.add(userAreaRoleEntity.getGbbh());
                    break;
                }
                case "5":{
                    fVillageCodes.add(userAreaRoleEntity.getGbbh());
                    break;
                }
                default:{
                }
            }
        }
        userRegion.setfProvinceCodes(fProvinceCodes);
        userRegion.setfCityCodes(fCityCodes);
        userRegion.setfCountyCodes(fCountyCodes);
        userRegion.setfTownCodes(fTownCodes);
        userRegion.setfVillageCodes(fVillageCodes);
        return userRegion;
    }


    /**
     * 解析结果是否成功
     *
     * @param xml
     * @return
     */
    private ResultDto isResult(String xml) {
        xml = xml.replaceAll("Head>", "head>").replaceAll("Body>", "body>");
        XmlUtil xmlUtil = new XmlUtil();

        ResultDto resultDto = new ResultDto(true, null);

        try {
            PacketDto<String> dto = xmlUtil.xmlToPacketDto_bodyDto(xml, String.class);
            HeadDto headDto = dto.getHead();
            if (headDto.getReturnStatusCode().equals("401") || headDto.getReturnStatusCode().equals("402")) {

            } else {
                logger.info("核心段通过系统调用金禾接口：" + headDto.getReturnMessage());
                resultDto.setSucess(false);
                resultDto.setMsg("接口异常 " + headDto.getReturnMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultDto.setSucess(false);
            resultDto.setMsg("接口异常");
        }
        return resultDto;
    }
}
