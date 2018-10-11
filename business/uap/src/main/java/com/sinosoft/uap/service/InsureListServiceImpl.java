package com.sinosoft.uap.service;

import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.claiminsurancelist.PlantingLossRateListApi;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdSettleListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * @Description:投保单webservice服务接口
 * @Author:汪强
 * @Since:2017年11月4日
 */
@WebService(serviceName = "InsureListService",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.InsureListService")
@Service
public class InsureListServiceImpl implements InsureListService {

    /**
     * log日志
     */
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InsureListServiceImpl.class);
    @Autowired
    InsuranceListApi insuranceListApi;

    @Autowired
    PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    PlantingLossRateListApi plantingLossRateListApi;
    @Autowired
    HerdSettleListApi herdSettleListApi;
    @Autowired
    GisInsureListApi gisInsureListApi;
    @Autowired
    PrpDuserApi prpDuserApi;

    /**
     * @param requestXml
     * @return
     * @throws Exception
     * @description: 投保清单持久化接口 保存投保预确认清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public String saveInsureList(@WebParam(name = "requestXml") String requestXml) throws Exception {
        //requestXml="<Packet><head><returnStatusCode>0000</returnStatusCode><returnMessage>交互成功</returnMessage></head><body><gisInsureMainListDto><attaches/><listTypeFlag>1</listTypeFlag><insureListCode>123456</insureListCode><listAlias>245</listAlias><listType>1</listType><serialNo>23</serialNo><fAreaCode>0491</fAreaCode><fAreaName>232N</fAreaName><provinceCode>9434</provinceCode><pCityCode>432</pCityCode><pCountyCode>1</pCountyCode><pTownCode>34</pTownCode><pVillageCode>23</pVillageCode><newFlag>N</newFlag><gisFlag>3</gisFlag><listBeginTime>2017-11-06 08:59:26.0 UTC</listBeginTime><opCode>444</opCode><opName>55</opName><listAffrimTime>2017-11-06 08:59:33.0 UTC</listAffrimTime><affrimOpCode>4224</affrimOpCode><affrimOpName>4242</affrimOpName><remark>212</remark><remark1>1</remark1><remark2>2</remark2><remark3>1</remark3><remark4>2</remark4></gisInsureMainListDto><gisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>2</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>3</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>4</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>1</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto></gisNyxInsuranceListDto><gisFeildDtoList><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2224</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2225</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2226</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2223</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto></gisFeildDtoList></body></Packet>";
        //初始化xmlutil方法
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("gisFeildDto", GisFeildDto.class);
                xstream.alias("GisNyxInsuranceListDto", GisNyxInsuranceListDto.class);
            }
        };
        //xml转成dto对象 调用txnlist接口插入方法
        PacketDto<InsuranceListDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, InsuranceListDto.class);
        InsuranceListDto insuranceListDto = packetDto.getBody();
        insuranceListApi.saveInsuranceList(insuranceListDto);

        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody("");
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
    }

    /**
     * 根据GIS清单号查询 承保清单 种植险
     *
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     * @author: 汪强
     * @date: 2017/11/28
     */
    @Override
    public String queryPlantingPolicyListByGisInsureListCode(@WebParam(name = "gisInsureListCode") String gisInsureListCode) throws Exception {
        //初始化xmlutil方法
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("PlantingPolicyListDto", PlantingPolicyListDto.class);
            }
        };

        List<PlantingPolicyListDto> plantingPolicyListDtoList = plantingPolicyListApi.queryByGisInsureListCode(gisInsureListCode);

        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody(plantingPolicyListDtoList);
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
    }

    /**
     * 根据GIS清单号查询 承保清单 养殖险
     *
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     * @author: 汪强
     * @date: 2017/11/28
     */
    @Override
    public String queryHerdSettleListByGisInsureListCode(@WebParam(name = "gisInsureListCode") String gisInsureListCode) throws Exception {
        //初始化xmlutil方法
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("HerdSettleListDto", HerdSettleListDto.class);
            }
        };

        List<HerdSettleListDto> plantingPolicyListDtoList = herdSettleListApi.queryByGisInsureListCode(gisInsureListCode);

        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody(plantingPolicyListDtoList);
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);

    }


    /**
     * 保存损失率清单 种植险
     *
     * @param requestXml
     * @return
     * @throws Exception
     * @author 汪强
     * @date 2017-11-29
     */
    @Override
    public String savePlantingLossRateList(@WebParam(name = "requestXml") String requestXml) throws Exception {
//        //初始化xmlutil方法
//        XmlUtil xmlUtil = new XmlUtil(){
//            @Override
//            public void xstreamSetting(XStream xstream) {
//                super.xstreamSetting(xstream);
//                xstream.alias("PlantingLossRateListDto", PlantingLossRateListDto.class);
//            }
//        };
//        PacketDto<PlantingLossRateListListDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, PlantingLossRateListListDto.class);
//        PlantingLossRateListListDto plantingLossRateListListDto=packetDto.getBody();
//
//        plantingLossRateListApi.savePlantingLossRateList(plantingLossRateListListDto.getPlantingLossRateListDto());
//
//
//        //返回值 默认操作成功
//        PacketDto packetDtoResult = new PacketDto();
//        packetDtoResult.setHead(new HeadDto());
//        packetDtoResult.setBody("");
//        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
        return "";
    }


    /**
     * 投保预确认清单接口
     *
     * @param requestXml
     * @return
     * @throws Exception
     * @author 汪强
     * @date 2018-1-29
     */
    @Override
    public String receivePreconfirmInsureList(@WebParam(name = "requestXml") String requestXml) throws Exception {
        //System.out.println(requestXml);
        LOGGER.debug(requestXml);
        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        HeadDto headDto = new HeadDto();
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("item", GisItemListDto.class);
                xstream.alias("farmer", FarmerRequestDto.class);
                xstream.alias("plantingField", GisFieldListDto.class);
                xstream.alias("farmerItem", FarmerItemRequestDto.class);
                xstream.alias("herdField", GisHerdFieldListDto.class);
                xstream.alias("relationMan", GisManFieldListDto.class);
                xstream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));

            }
        };
        PacketDto<GisItemListRequestDto> packetDto = null;
        try {
            packetDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, GisItemListRequestDto.class);
        } catch (Exception e) {
            LOGGER.error(requestXml,e);
            e.printStackTrace();
        }

//        System.out.println(packetDto.getBody().getListCreateTime());
//        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sim.format(packetDto.getBody().getListCreateTime()));

        //如果转换失败
        if (packetDto == null) {
            headDto.setReturnStatusCode("9999");
            headDto.setReturnMessage("参数错误，对象转换失败");
            packetDtoResult.setHead(headDto);
        } else {
            GisItemListRequestDto plantingLossRateListListDto = packetDto.getBody();
            String result = "";
            try {
                result = gisInsureListApi.saveAndCheckGisInsureList(plantingLossRateListListDto);
            } catch (Exception e) {
                LOGGER.error(requestXml,e);
                result = e.getMessage();
            }
            if (result == null || result.isEmpty()) {
                //调用成功
                packetDtoResult.setHead(new HeadDto());
            } else {
                //调用失败
                headDto.setReturnStatusCode("9999");
                headDto.setReturnMessage(result);
                packetDtoResult.setHead(headDto);
            }
        }
        packetDtoResult.setBody("");
        String s = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
        //System.out.println(s);
        return s;
    }

    /**
     * 承保清单查询接口
     * 金禾系统调用交易清单接口查看保单信息
     *
     * @param insureListCode
     * @return
     * @throws Exception
     */
    @Override
    public String queryPolicyByGisInsureListCode(@WebParam(name = "insureListCode") String insureListCode) throws Exception {
        PacketDto<UnderwritingListDto> packetDtoResult = new PacketDto();
        HeadDto headDto = new HeadDto();
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("policyInfo", PrpCmainDto.class);
                xstream.alias("itemKindInfo", PrpCitemKindDto.class);
                xstream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
            }
        };

        if (insureListCode.isEmpty()) {
            headDto.setReturnStatusCode("9999");
            headDto.setReturnMessage("参数不能为空");
            packetDtoResult.setHead(headDto);
            String str = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
            return str;
        }

        Map<String, String> map = new HashMap<>();
        map.put("gisInsureListCode", insureListCode);

        UnderwritingListDto underwritingListDto = null;
        try {
            underwritingListDto = gisInsureListApi.underwritingListQuery(map);

        } catch (Exception e) {
            headDto.setReturnStatusCode("9999");
            headDto.setReturnMessage("接口调用失败");
            LOGGER.error("金禾系统调用交易清单接口查看保单信息接口报错insureListCode：" + insureListCode,e);
            e.printStackTrace();
        }

        if (underwritingListDto == null) {
            underwritingListDto = new UnderwritingListDto();
            packetDtoResult.setBody(underwritingListDto);
        } else {
            packetDtoResult.setBody(underwritingListDto);
        }

        packetDtoResult.setHead(headDto);
        String str = xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
        return str;
    }


    /**
     * 修改密码
     *
     * @param userCode 用户
     * @param password 用户原密码
     * @param passwordNew 用户新密码
     *
     * @return
     */
    @Override
    public String modifyPwd(@WebParam(name = "userCode") String userCode, @WebParam(name = "password") String password, @WebParam(name = "passwordNew") String passwordNew) {
        //返回结果值
        String result = null;
        if (StringUtils.isEmpty(userCode)) {
            return createResult("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return createResult("原密码不能为空");
        }
        if (StringUtils.isEmpty(passwordNew)) {
            return createResult("新密码不能为空");
        }
        if (passwordNew.length() < 6) {
            return createResult("新密码长度不能小于6位");
        }

        LOGGER.debug(userCode + "原密码" + password + "新密码" + passwordNew);

        try {
            result = prpDuserApi.modifyPwd(userCode, password, passwordNew);
        } catch (Exception e) {
            result = "修改失败，接口异常";
        }
        return createResult(result);
    }

    private String createResult(String result) {
        XmlUtil xmlUtil = new XmlUtil();
        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        HeadDto headDto = new HeadDto();

        if (result != null) {
            headDto.setReturnStatusCode("9999");
            headDto.setReturnMessage(result);
        }
        packetDtoResult.setHead(headDto);
        packetDtoResult.setBody("");
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
    }
}
