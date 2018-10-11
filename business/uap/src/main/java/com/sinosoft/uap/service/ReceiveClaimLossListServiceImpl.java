package com.sinosoft.uap.service;

import com.ctc.wstx.util.StringUtil;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistTextApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.claiminsurancelist.*;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.api.claimlists.dto.*;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@Description:理赔清单ebservice服务接口
 *@Author:王心洋
 *@Since:2018年1月17日
 */
@WebService(serviceName = "ReceiveClaimLossList",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.ReceiveClaimLossListService")
@Component
public class ReceiveClaimLossListServiceImpl implements ReceiveClaimLossListService {
    @Autowired
    LossRateMainListApi lossRateMainListApi;
    @Autowired
    LossRateItemListApi lossRateItemListApi;
    @Autowired
    LossRateLossListApi lossRateLossListApi;
    @Autowired
    LossRateHerdListApi lossRateHerdListApi;
    @Autowired
    LossRatePersListApi lossRatePersListApi;
    @Autowired
    PrpLRegistTextApi prpLRegistTextApi;

    @Override
    public String saveLossList(String requestXml) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //requestXml="<Packet><head><returnStatusCode>0000</returnStatusCode><returnMessage>交互成功</returnMessage></head><body><gisInsureMainListDto><attaches/><listTypeFlag>1</listTypeFlag><insureListCode>123456</insureListCode><listAlias>245</listAlias><listType>1</listType><serialNo>23</serialNo><fAreaCode>0491</fAreaCode><fAreaName>232N</fAreaName><provinceCode>9434</provinceCode><pCityCode>432</pCityCode><pCountyCode>1</pCountyCode><pTownCode>34</pTownCode><pVillageCode>23</pVillageCode><newFlag>N</newFlag><gisFlag>3</gisFlag><listBeginTime>2017-11-06 08:59:26.0 UTC</listBeginTime><opCode>444</opCode><opName>55</opName><listAffrimTime>2017-11-06 08:59:33.0 UTC</listAffrimTime><affrimOpCode>4224</affrimOpCode><affrimOpName>4242</affrimOpName><remark>212</remark><remark1>1</remark1><remark2>2</remark2><remark3>1</remark3><remark4>2</remark4></gisInsureMainListDto><gisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>2</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>3</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>4</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto><GisNyxInsuranceListDto><attaches/><insureListCode>1</insureListCode><serialNo>1</serialNo><fCode>1</fCode><fName>1</fName><fIdType>1</fIdType><fIdCard>1</fIdCard><fPhone>1</fPhone><fAddress>1</fAddress><teamName>1</teamName><bankType>1</bankType><bank>1</bank><zhiBuKa>1</zhiBuKa><bankLineNo>1</bankLineNo><landCard>1</landCard><landArea>1.0</landArea><realArea>1.0</realArea><insureArea>1.0</insureArea></GisNyxInsuranceListDto></gisNyxInsuranceListDto><gisFeildDtoList><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2224</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2225</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2226</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto><gisFeildDto><attaches/><insureListCode>123456</insureListCode><serialNo>2223</serialNo><fCode>454</fCode><fieldNo>2323</fieldNo><fieldArea>4445.0</fieldArea><adjustArea>232321.0</adjustArea><adjustReason>994324J</adjustReason><validArea>3131.0</validArea><remark>556</remark><remark1>6</remark1><remark2>5</remark2><remark3>5</remark3><remark4>5</remark4></gisFeildDto></gisFeildDtoList></body></Packet>";
        //初始化xmlutil方法
        XmlUtil xmlUtil = new XmlUtil() {
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("GISLossMainListDto",     GISLossMainListDto.class);
                xstream.alias("GISFarmerDto",           GISFarmerDto.class);
                xstream.alias("GISFarmerLossItemDto",   GISFarmerLossItemDto.class);
                xstream.alias("GISItemLossRateDto",     GISItemLossRateDto.class);
                xstream.alias("GISHerdLossDetailDto",   GISHerdLossDetailDto.class);
                xstream.alias("GISManLossDetailDto",    GISManLossDetailDto.class);
            }
        };
        //TODO test测试begin
        /*PacketDto<GISLossMainListDto> dto = new PacketDto<>();
        GISLossMainListDto gisLossMainListDto1 = new GISLossMainListDto();
        GISFarmerDto gisFarmerDto1 = new GISFarmerDto();
        GISFarmerLossItemDto gisFarmerLossItemDto1 = new GISFarmerLossItemDto();
        GISItemLossRateDto gisItemLossRateDto1 = new GISItemLossRateDto();
        GISManLossDetailDto gisManLossDetailDto1 = new GISManLossDetailDto();
        List<GISFarmerDto> gisFarmerDtoList1 = new ArrayList<>();
        List<GISFarmerLossItemDto> gisFarmerLossItemDtoList1 = new ArrayList<>();
        List<GISItemLossRateDto> gisItemLossRateDtoList1 = new ArrayList<>();
        List<GISManLossDetailDto> gisManLossDetailDtoList1 = new ArrayList<>();
        gisManLossDetailDto1.setIdCode("12345");
        gisManLossDetailDtoList1.add(gisManLossDetailDto1);
        gisItemLossRateDto1.setManLossDetailList(gisManLossDetailDtoList1);
        gisItemLossRateDto1.setLossAmount("10");
        gisItemLossRateDtoList1.add(gisItemLossRateDto1);
        gisFarmerLossItemDto1.setItemLossRateList(gisItemLossRateDtoList1);
        gisFarmerLossItemDto1.setItemCode("123");
        gisFarmerLossItemDtoList1.add(gisFarmerLossItemDto1);
        gisFarmerDto1.setFarmerLossItemList(gisFarmerLossItemDtoList1);
        gisFarmerDto1.setFarmerCode("123");
        gisFarmerDtoList1.add(gisFarmerDto1);
        gisLossMainListDto1.setFarmerList(gisFarmerDtoList1);
        gisLossMainListDto1.setLossListCode("201801180001");
        gisLossMainListDto1.setBizNo("111");
        dto.setHead(new HeadDto());
        dto.setBody(gisLossMainListDto1);
        String xml = xmlUtil.packetDtoToXml_bodyDto(dto);
        System.out.println(xml);*/
        //TODO test测试end

        //xml转成dto对象 调用txnlist接口插入方法
        PacketDto<GISLossMainListDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(requestXml, GISLossMainListDto.class);
        GISLossMainListDto          gisLossMainListDto          = packetDto.getBody();

        /** 要保存的定损清单对象 */
        LossRateMainListDto lossRateMainListDto = new LossRateMainListDto();
        List<LossRateItemListDto> lossRateItemListDtoList = new ArrayList<>();
        List<LossRateLossListDto> lossRateLossListDtoList = new ArrayList<>();
        List<LossRateHerdListDto> lossRateHerdListDtoList = new ArrayList<>();
        List<LossRatePersListDto> lossRatePersListDtoList = new ArrayList<>();
        if(StringUtils.isEmpty(gisLossMainListDto.getLossListCode())){
            throw new DataVerifyException("清单号不能为空！");
        }
        Map<String,String> map = new HashMap<>();
        map.put("lossListCode",gisLossMainListDto.getLossListCode());
        /** 生成新的序列号 */
        int serialNo = lossRateMainListApi.queryMaxSerialByLossListCode(map) + 1;
        lossRateMainListDto.setLossListCode(gisLossMainListDto.getLossListCode());
        lossRateMainListDto.setSerialNo(serialNo);
        lossRateMainListDto.setBizNo(gisLossMainListDto.getBizNo());
        lossRateMainListDto.setPolicyNo(gisLossMainListDto.getPolicyNo());
        //未关联标志设置为“0”
        lossRateMainListDto.setCheckBoxFlag("0");
        if(!StringUtils.isEmpty(gisLossMainListDto.getListCreateTime())){
            lossRateMainListDto.setListCreateTime(sdf.parse(gisLossMainListDto.getListCreateTime()));
        }
        lossRateMainListDto.setOpCode(gisLossMainListDto.getOpCode());
        lossRateMainListDto.setOpName(gisLossMainListDto.getOpName());
        if(!StringUtils.isEmpty(gisLossMainListDto.getListAffrimTime())){
            lossRateMainListDto.setListAffirmTime(sdf.parse(gisLossMainListDto.getListAffrimTime()));
        }
        lossRateMainListDto.setAffirmOpCode(gisLossMainListDto.getAffrimopCode());
        lossRateMainListDto.setAffirmOpName(gisLossMainListDto.getAffrimopName());
        lossRateMainListDto.setExploreArea(gisLossMainListDto.getExploreArea());
        if(!StringUtils.isEmpty(gisLossMainListDto.getExploreTime())) {
            lossRateMainListDto.setExploreTime(sdf.parse(gisLossMainListDto.getExploreTime()));
        }
        lossRateMainListDto.setRemark(gisLossMainListDto.getRemark());
        //add by wxy 2018/4/10
        lossRateMainListDto.setCheckId(gisLossMainListDto.getCheckId());
        if(!StringUtils.isEmpty(gisLossMainListDto.getDisasterArea())) {
            lossRateMainListDto.setDisasterArea(new BigDecimal(gisLossMainListDto.getDisasterArea())
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if(!StringUtils.isEmpty(gisLossMainListDto.getAffectedArea())) {
            lossRateMainListDto.setAffectedArea(new BigDecimal(gisLossMainListDto.getAffectedArea())
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if(!StringUtils.isEmpty(gisLossMainListDto.getNoProductionArea())) {
            lossRateMainListDto.setNoProductionArea(new BigDecimal(gisLossMainListDto.getNoProductionArea())
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if(!StringUtils.isEmpty(gisLossMainListDto.getDeathQuantity())) {
            lossRateMainListDto.setDeathQuantity(new BigDecimal(gisLossMainListDto.getDeathQuantity())
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if(!StringUtils.isEmpty(gisLossMainListDto.getKillQuantity())) {
            lossRateMainListDto.setKillQuantity(new BigDecimal(gisLossMainListDto.getKillQuantity())
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if(!StringUtils.isEmpty(gisLossMainListDto.getCheckContext())) {
            lossRateMainListDto.setCheckContext(gisLossMainListDto.getCheckContext());
            if(!StringUtils.isEmpty(gisLossMainListDto.getBizNo())) {
                PrpLRegistTextDto prpLRegistTextDto = new PrpLRegistTextDto();
                Map<String,String> map1 = new HashMap<>();
                map1.put("registNo",gisLossMainListDto.getBizNo());
                map1.put("textType","3");//查勘报告
                List<PrpLRegistTextDto> prpLRegistTextDtoList =  prpLRegistTextApi.queryByRegistNoAndTextType(map);
                prpLRegistTextDto.setRegistNo(gisLossMainListDto.getBizNo());
                prpLRegistTextDto.setTextType("3");
                prpLRegistTextDto.setLineNo(prpLRegistTextDtoList.size()+1);
                prpLRegistTextDto.setContext(gisLossMainListDto.getCheckContext());
                prpLRegistTextApi.save(prpLRegistTextDto);
            }
        }
        /** 金禾导入设置导入来源标识 */
        lossRateMainListDto.setOrigin("0");

        LossRateItemListDto lossRateItemListDto;
        LossRateLossListDto lossRateLossListDto;
        LossRateHerdListDto lossRateHerdListDto;
        LossRatePersListDto lossRatePersListDto;

        //gisFarmerDtoList = gisLossMainListDto.getFarmerList();
        if(gisLossMainListDto.getFarmerList()!=null) {
            for(GISFarmerDto gisFarmerDto:gisLossMainListDto.getFarmerList()){
                //for (int i = 0; i < gisFarmerDtoList.size(); i++) {
                //gisFarmerLossItemDtoList = gisFarmerDtoList.get(i).getFarmerLossItemList();

                if(gisFarmerDto.getFarmerLossItemList()!=null){
                    //for(int j=0;j<gisFarmerLossItemDtoList.size();j++){
                    for(GISFarmerLossItemDto gisFarmerLossItemDto:gisFarmerDto.getFarmerLossItemList()){
                        lossRateItemListDto = new LossRateItemListDto();
                        lossRateItemListDto.setLossListCode(gisLossMainListDto.getLossListCode());
                        lossRateItemListDto.setSerialNo(serialNo);
                        //TODO
                        lossRateItemListDto.setfCode(gisFarmerDto.getFarmerCode());
                        lossRateItemListDto.setfName(gisFarmerDto.getFarmerName());
                        lossRateItemListDto.setfIdType(gisFarmerDto.getFarmerIdType());
                        lossRateItemListDto.setfIdCard(gisFarmerDto.getFarmerIdCode());
                        lossRateItemListDto.setItemCode(gisFarmerLossItemDto.getItemCode());
                        lossRateItemListDto.setItemType(gisFarmerLossItemDto.getItemType());
                        lossRateItemListDto.setItemName(gisFarmerLossItemDto.getItemName());
                        lossRateItemListDtoList.add(lossRateItemListDto);
                        //gisItemLossRateDtoList = gisFarmerLossItemDto.getItemLossRateList();
                        if(gisFarmerLossItemDto.getItemLossRateList()!=null){
                            int k=1;
                            for(GISItemLossRateDto gisItemLossRateDto:gisFarmerLossItemDto.getItemLossRateList()){
                                //for(int k=0;k<gisItemLossRateDtoList.size();k++){
                                lossRateLossListDto = new LossRateLossListDto();
                                lossRateLossListDto.setLossListCode(gisLossMainListDto.getLossListCode());
                                lossRateLossListDto.setSerialNo(serialNo);
                                lossRateLossListDto.setfCode(gisFarmerDto.getFarmerCode());
                                lossRateLossListDto.setItemCode(gisFarmerLossItemDto.getItemCode());
                                lossRateLossListDto.setLossSerialNo(k+1);
                                //add by wxy 2018/4/16 添加田块代码
                                lossRateLossListDto.setFieldCode(gisItemLossRateDto.getFieldCode());
                                if(!StringUtils.isEmpty(gisItemLossRateDto.getLossRate())) {
                                    lossRateLossListDto.setLossRate(new BigDecimal(gisItemLossRateDto.getLossRate())
                                            .setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
                                }
                                if(!StringUtils.isEmpty(gisItemLossRateDto.getLossAmount())) {
                                    lossRateLossListDto.setLossAmount(new BigDecimal(gisItemLossRateDto.getLossAmount())
                                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                }
                                if(!StringUtils.isEmpty(gisItemLossRateDto.getLossMoney())) {
                                    lossRateLossListDto.setLossMoney(new BigDecimal(gisItemLossRateDto.getLossMoney())
                                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                }
                                lossRateLossListDtoList.add(lossRateLossListDto);
                                //gisHerdLossDetailDtoList = gisItemLossRateDto.getHerdLossDetailList();
                                //gisManLossDetailDtoList = gisItemLossRateDto.getManLossDetailList();
                                if(gisItemLossRateDto.getHerdLossDetailList()!=null) {
                                    for(GISHerdLossDetailDto gisHerdLossDetailDto:gisItemLossRateDto.getHerdLossDetailList()){
                                        //for (int l = 0; l < gisHerdLossDetailDtoList.size(); l++) {
                                        lossRateHerdListDto = new LossRateHerdListDto();
                                        lossRateHerdListDto.setLossListCode(gisLossMainListDto.getLossListCode());
                                        lossRateHerdListDto.setSerialNo(serialNo);
                                        lossRateHerdListDto.setfCode(gisFarmerDto.getFarmerCode());
                                        lossRateHerdListDto.setItemCode(gisFarmerLossItemDto.getItemCode());
                                        lossRateHerdListDto.setLossSerialNo(k+1);
                                        lossRateHerdListDto.setEarLabel(gisHerdLossDetailDto.getEarLabel());
                                        lossRateHerdListDtoList.add(lossRateHerdListDto);
                                    }
                                }
                                if(gisItemLossRateDto.getManLossDetailList()!=null) {
                                    for(GISManLossDetailDto gisManLossDetailDto:gisItemLossRateDto.getManLossDetailList()){
                                        //for (int l = 0; l < gisManLossDetailDtoList.size(); l++) {
                                        lossRatePersListDto = new LossRatePersListDto();
                                        lossRatePersListDto.setLossListCode(gisLossMainListDto.getLossListCode());
                                        lossRatePersListDto.setSerialNo(serialNo);
                                        lossRatePersListDto.setfCode(gisFarmerDto.getFarmerCode());
                                        lossRatePersListDto.setItemCode(gisFarmerLossItemDto.getItemCode());
                                        lossRatePersListDto.setLossSerialNo(k+1);
                                        lossRatePersListDto.setIdType(gisManLossDetailDto.getIdType());
                                        lossRatePersListDto.setIdCard(gisManLossDetailDto.getIdCode());
                                        lossRatePersListDto.setName(gisManLossDetailDto.getName());
                                        lossRatePersListDto.setSex(gisManLossDetailDto.getSex());
                                        lossRatePersListDto.setRelation(gisManLossDetailDto.getRelation());
                                        lossRatePersListDtoList.add(lossRatePersListDto);
                                    }
                                }
                                k++;
                            }
                        }
                    }
                }
            }
        }
        lossRateMainListApi.save(lossRateMainListDto);
        if(lossRateItemListDtoList!=null){
            for(int i=0;i<lossRateItemListDtoList.size();i++){
                lossRateItemListApi.save(lossRateItemListDtoList.get(i));
            }
        }
        if(lossRateLossListDtoList!=null){
            for(int i=0;i<lossRateLossListDtoList.size();i++){
                lossRateLossListApi.save(lossRateLossListDtoList.get(i));
            }
        }
        if(lossRateHerdListDtoList!=null){
            for(int i=0;i<lossRateHerdListDtoList.size();i++){
                lossRateHerdListApi.save(lossRateHerdListDtoList.get(i));
            }
        }
        if(lossRatePersListDtoList!=null){
            for(int i=0;i<lossRatePersListDtoList.size();i++){
                lossRatePersListApi.save(lossRatePersListDtoList.get(i));
            }
        }
        //返回值 默认操作成功
        PacketDto packetDtoResult = new PacketDto();
        packetDtoResult.setHead(new HeadDto());
        packetDtoResult.setBody("");
        return xmlUtil.packetDtoToXml_bodyDto(packetDtoResult);
    }
}