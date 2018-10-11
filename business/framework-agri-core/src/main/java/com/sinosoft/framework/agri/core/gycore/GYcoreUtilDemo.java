package com.sinosoft.framework.agri.core.gycore;

import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.gycore.dto.*;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;

import java.util.*;


//webservice命令
//wsimport http://36.32.160.60:9000/GYCoreWebService.asmx?WSDL -keep -s /Users/apple/Documents/ -p com.sinosoft.framework.agri.core.gycore.client

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-26 16:06
 */
public class GYcoreUtilDemo {
    private static final String URL="http://36.32.160.60:9000/GYCoreWebService.asmx?WSDL";
    public static void main(String[] args) {
//        testAddSurveyTask();


        testGetUserRegion();
//        testGetUserAllRegion();
    }

    public static void testGetUserRegion(){

        GYcoreUtil gYcoreUtil = new GYcoreUtil(URL);
        List list = gYcoreUtil.getUserRegion("0537", "0");
        System.out.println(list.size());
    }


    public static void testAddListAdditionalData() {
        FarmerList farmerList = new FarmerList();
        List<Farmer> list = new ArrayList<>();
        Farmer farmer = new Farmer();
        farmer.setFcode("c3400000");

        List<FarmerItem> farmerItemList = new ArrayList<>();
        FarmerItem farmerItem = new FarmerItem();
        List<GisHerdFieldListDto> herdFieldList = new ArrayList<>();
        List<GisManFieldListDto> manFieldList = new ArrayList<>();

        GisHerdFieldListDto gisHerdFieldListDto = new GisHerdFieldListDto();
        gisHerdFieldListDto.setEarLabel("耳标号");
        gisHerdFieldListDto.setBreedingAreaCode("养殖地点代码");
        gisHerdFieldListDto.setBreedingAreaName("养殖地点名称");
        gisHerdFieldListDto.setSpecies("养殖品种");
        gisHerdFieldListDto.setAnimalAge(3.0);

        GisHerdFieldListDto gisHerdFieldListDto2 = new GisHerdFieldListDto();
        gisHerdFieldListDto2.setEarLabel("xxxx");
        herdFieldList.add(gisHerdFieldListDto);
        herdFieldList.add(gisHerdFieldListDto2);


        GisManFieldListDto gisManFieldListDto = new GisManFieldListDto();
        gisManFieldListDto.setIdType("证件类型");
        gisManFieldListDto.setIdCard("证件号码");
        gisManFieldListDto.setSex("男");
        gisManFieldListDto.setRelation("与农户关系");
        GisManFieldListDto gisManFieldListDto2 = new GisManFieldListDto();
        gisManFieldListDto2.setIdCard("证件号码");
        manFieldList.add(gisManFieldListDto);
        manFieldList.add(gisManFieldListDto2);

        farmerItem.setItemCode("bb1110");
        farmerItem.setInsureCount("2");
//        farmerItem.setHerdFieldList(herdFieldList);
        farmerItem.setManFieldList(manFieldList);

        farmerItemList.add(farmerItem);

        farmer.setFarmerItemList(farmerItemList);

        list.add(farmer);
        farmerList.setFarmerList(list);

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

        String xml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        System.out.println(xml);

    }

    public static void testAddSurveyTask() {

        AddSurveyTaskDto addSurveyTaskDto = new AddSurveyTaskDto();
//        addSurveyTaskDto.setRegistNo("报案号码");
//        addSurveyTaskDto.setFlowId("流程编号");
//        addSurveyTaskDto.setLogNo("序号");
//        addSurveyTaskDto.setInsuranceListCode("预投保单号码");
//        addSurveyTaskDto.setCreateUserCode("发起人用户名");
//        addSurveyTaskDto.setCreateUserName("发起人姓名");

        addSurveyTaskDto.setRegistNo("431073400002018000395");
//        addSurveyTaskDto.setFlowId("L31073400002018000370");
//        addSurveyTaskDto.setLogNo("2");
//        addSurveyTaskDto.setInsuranceListCode("34152400000020180327093844995");
//        addSurveyTaskDto.setCreateUserCode("0537");
//        addSurveyTaskDto.setCreateUserName("杨婷");

//        AddSureveryRegistInfo addSureveryRegistInfo = new AddSureveryRegistInfo();
//
////        addSureveryRegistInfo.setRegistNo("报案号码");
////        addSureveryRegistInfo.setRiskCode("险种名称");
////        addSureveryRegistInfo.setPolicyNo("保单号码");
////        addSureveryRegistInfo.setDamageStartDate("出险时间：天");
////        addSureveryRegistInfo.setDamageStartHour("出险小时");
////        addSureveryRegistInfo.setDamageStartMinute("出险分钟");
////        addSureveryRegistInfo.setDamageCode("出险原因代码");
////        addSureveryRegistInfo.setDamageName("出险原因");
////        addSureveryRegistInfo.setDamageMessage("详细出险原因");
////        addSureveryRegistInfo.setReportorName("报案人");
////        addSureveryRegistInfo.setReportDate("报案时间");
////        addSureveryRegistInfo.setReportHour("报案小时:到分钟");
////        addSureveryRegistInfo.setReportType("报案方式");
//
//
//
//        addSureveryRegistInfo.setRegistNo("431073400002018000395");
//        addSureveryRegistInfo.setRiskCode("3107");
//		addSureveryRegistInfo.setPolicyNo("231073400002018000372");
//		addSureveryRegistInfo.setDamageStartDate("2018-04-08");
//		addSureveryRegistInfo.setDamageStartHour("15");
//		addSureveryRegistInfo.setDamageStartMinute("30");
//		addSureveryRegistInfo.setDamageCode("106");
//		addSureveryRegistInfo.setDamageName("出险原因");
//		addSureveryRegistInfo.setDamageMessage("详细出险原因");
//		addSureveryRegistInfo.setReportorName("杨婷");
//		addSureveryRegistInfo.setReportDate("2018-04-08");
//		addSureveryRegistInfo.setReportHour("10");
//		addSureveryRegistInfo.setReportType("10");
//		addSureveryRegistInfo.setLinkerName("杨婷");
//		addSureveryRegistInfo.setPhoneNumber("13366667777");
//		addSureveryRegistInfo.setAddressCode("23000");
//		addSureveryRegistInfo.setDamageAddress("出险地点");
//		addSureveryRegistInfo.setEstiCurrency("C");
//		addSureveryRegistInfo.setEstimateLoss("0");
//		addSureveryRegistInfo.setLossName("受损标的");
//		addSureveryRegistInfo.setAcciPersonDtoList("事故者信息");
//		addSureveryRegistInfo.setOperatorCode("0000");
//		addSureveryRegistInfo.setOperatorName("接报案员姓名");
//		addSureveryRegistInfo.setMakeCom("00000000");
//		addSureveryRegistInfo.setMakeComName("00000000");
//		addSureveryRegistInfo.setRemark("备注");
//		addSureveryRegistInfo.setTextContext("出险摘要");
//		addSureveryRegistInfo.setCatastropheCode1("001");
//        addSureveryRegistInfo.setCatastropheName1("巨灾名称");
//        addSureveryRegistInfo.setCatastropheCode2("002");
//        addSureveryRegistInfo.setCatastropheName2("巨灾名称");
//        addSureveryRegistInfo.setInsuranceListCode("34152400000020180327093844995");
//        addSureveryRegistInfo.setOpUserCode("0000");
//        addSureveryRegistInfo.setOpUserName("杨婷");
//
//
//
//                XmlUtil xmlUtil = new XmlUtil();
//        PacketDto<AddSurveyTaskDto> packetDto = new PacketDto<>();
//        packetDto.setBody(addSurveyTaskDto);
//
//        String xml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
//
//
//        PacketDto<AddSureveryRegistInfo> packetDto2 = new PacketDto<>();
//        packetDto2.setBody(addSureveryRegistInfo);
//
//        String addSureveryRegistInfoXml = xmlUtil.packetDtoToXml_bodyDto(packetDto2);
//
//        System.out.println(xml);
//        System.out.println(addSureveryRegistInfoXml);
//
//
//        GYcoreUtil util=new GYcoreUtil();
//        util.addSurveyTask(addSurveyTaskDto,addSureveryRegistInfo);
    }

    public static void testGetUserAllRegion(){
        GYcoreUtil gYcoreUtil = new GYcoreUtil(URL);
        UserRegion userRegion=gYcoreUtil.getUserAllRegion("0537");

    }
}
