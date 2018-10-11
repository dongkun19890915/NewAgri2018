package com.sinosoft.framework.agri.core.gycore;

import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-07 09:41
 */
public class App {
    public static void main(String[] args) {

        //1、获取用户区域权限
        //getUserRegion();

        //2、生成预报案
        //addNodeItemData();


        //4、更新客户及银行基本信息
        updateCustomerInfo();

        //5、生成预报案
        //addReadyRegistInfo();

        //6、发起调查任务
        //addSurveyTask();


    }

    //1、获取用户区域权限
    public static void getUserRegion(){
        GYcoreUtil gYcoreUtil = new GYcoreUtil("");
        String userCode="0000000000";
        String parentID="0";
        List<UserAreaRoleEntity> list= gYcoreUtil.getUserRegion(userCode,parentID);
        System.out.println(list.size());
    }

    //2、生成预报案
    public static void addNodeItemData(){
        GYcoreUtil gYcoreUtil = new GYcoreUtil("");
        NodeItemData nodeItemData = new NodeItemData();
        nodeItemData.setStepId("环节id");
        nodeItemData.setStepCode("环节代码");
        nodeItemData.setStateCode("状态代码");
        nodeItemData.setResultCode("处理结果代码");
        nodeItemData.setOpCode("操作员代码");
        nodeItemData.setOpName("操作员名称");
        nodeItemData.setBizCode("业务号");
        //nodeItemData.setInflowTime("流入时间");
        nodeItemData.setOutflowTime(new Date());
        nodeItemData.setOpTime(new Date());
        nodeItemData.setPaymentTypeCode("缴费类型代码");
        nodeItemData.setAmount("缴费金额");
        //预投保清单编号
        String insureListCode="";
        boolean flag = gYcoreUtil.addNodeItemData(insureListCode,nodeItemData);
    }

    //4、更新客户及银行基本信息
    public static void updateCustomerInfo(){
        GYcoreUtil gYcoreUtil = new GYcoreUtil("");
        BankInfo bankInfo=new BankInfo();
        bankInfo.setFarmCode("客户代码");
        bankInfo.setFidType("证件类型");
        bankInfo.setFidCard("证件号码");
        bankInfo.setfPhone("联系手机");
        bankInfo.setBankType("开户银行大类");
        bankInfo.setBank("开户银行");
        bankInfo.setBankNo("银行卡号");

        String customerCode = "";
        String customerType = "";
        boolean flag = gYcoreUtil.updateCustomerInfo(customerCode, customerType, bankInfo);
        System.out.println(flag);
    }

    //5、生成预报案
    public static void addReadyRegistInfo(){
        GYcoreUtil gYcoreUtil = new GYcoreUtil("");
        ReadyRegistInfo readyRegistInfo = new ReadyRegistInfo();
        readyRegistInfo.setRegistNo("预报案号码");
        readyRegistInfo.setRiskCode("险种名称");
        readyRegistInfo.setPolicyNo("保单号码");
        readyRegistInfo.setDamageStartDate("出险时间：天");
        readyRegistInfo.setDamageStartHour("出险小时");
        readyRegistInfo.setDamageStartMinute("出险分钟");
        readyRegistInfo.setDamageCode("出险原因代码");
        readyRegistInfo.setDamageName("出险原因");
        readyRegistInfo.setDamageMessage("详细出险原因");
        readyRegistInfo.setReportorName("报案人");
        readyRegistInfo.setReportDate("报案时间");
        readyRegistInfo.setReportHour("报案小时:到分钟");
        readyRegistInfo.setReportType("报案方式");
        readyRegistInfo.setLinkerName("联系人");
        readyRegistInfo.setPhoneNumber("联系电话");
        readyRegistInfo.setAddressCode("出险地邮政编码");
        readyRegistInfo.setDamageAddress("出险地点");
        readyRegistInfo.setEstiCurrency("币别");
        readyRegistInfo.setEstimateLoss(0.0);
        readyRegistInfo.setLossName("受损标的");
        readyRegistInfo.setAcciPersonDtoList("事故者信息");
        readyRegistInfo.setOperatorCode("接报案员代码");
        readyRegistInfo.setOperatorName("接报案员姓名");
        readyRegistInfo.setMakeCom("理赔登记部门代码");
        readyRegistInfo.setMakeComName("理赔登记部门");
        readyRegistInfo.setRemark("备注");
        readyRegistInfo.setTextContext("出险摘要");
        readyRegistInfo.setCatastropheCode1("巨灾一级代码");
        readyRegistInfo.setCatastropheName1("巨灾名称");
        readyRegistInfo.setCatastropheCode2("巨灾二级代码");
        readyRegistInfo.setCatastropheName2("巨灾名称");

       boolean flag= gYcoreUtil.addReadyRegistInfo(readyRegistInfo);
        System.out.println(flag);
    }

    //6、发起调查任务
    public static void addSurveyTask(){
//        GYcoreUtil gYcoreUtil = new GYcoreUtil();
        String registNo="";
//        boolean flag= gYcoreUtil.addSurveyTask(registNo);
//        System.out.println(flag);
    }



    public static void parsexml(String xml) {
//区分head body Head Body大小写问题    重要
//        xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<Packet type=\"Response\" version=\"1.0\">\n" +
//                "<head>\n" +
//                "<returnStatusCode>401</returnStatusCode>\n" +
//                "<returnMessage>数据查询成功!</returnMessage>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<Region>\n" +
//                "<REGIONID>1</REGIONID>\n" +
//                "<PARENTID>0</PARENTID>\n" +
//                "<REGIONNAME>安徽省</REGIONNAME>\n" +
//                "<GBBH>34</GBBH>\n" +
//                "<PLATREGIONCODE>340000</PLATREGIONCODE>\n" +
//                " </Region>\n" +
//                "<Region>\n" +
//                "<REGIONID>NK1</REGIONID>\n" +
//                "<PARENTID>0</PARENTID>\n" +
//                "<REGIONNAME>安徽省-农垦</REGIONNAME>\n" +
//                "<GBBH>NK34</GBBH>\n" +
//                "<PLATREGIONCODE></PLATREGIONCODE>\n" +
//                "</Region>\n" +
//                "</body>\n" +
//                "</Packet>";

        PacketDto packetDtoResult = new PacketDto();

        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("Region", UserAreaRoleEntity.class);
            }
        };

        PacketDto<List<UserAreaRoleEntity>> list = xmlUtil.xmlToPacketDto_bodyList(xml, UserAreaRoleEntity.class, "Region", true);


        System.out.println(list);
    }

    public static String createxml() {

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);

        UserAreaRoleEntity userAreaRoleEntity = new UserAreaRoleEntity("区域id", "p", "区域名称", "区域二调代码", "区域二调对应平台代码");
        UserAreaRoleEntity userAreaRoleEntity2 = new UserAreaRoleEntity("区域2", "区域名称", "p", "区域二调代码", "区域二调对应平台代码");

        List<UserAreaRoleEntity> list = new ArrayList<>();
        list.add(userAreaRoleEntity);
        list.add(userAreaRoleEntity2);

        PacketDto packetDtoResult = new PacketDto();
        HeadDto headDto = new HeadDto();
        packetDtoResult.setHead(headDto);
        packetDtoResult.setBody(list);
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("Region", UserAreaRoleEntity.class);
            }
        };
        String str = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult, true);
        System.out.println(str);
        return str;
    }
}
