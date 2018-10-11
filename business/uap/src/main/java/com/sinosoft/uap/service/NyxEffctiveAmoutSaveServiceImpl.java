package com.sinosoft.uap.service;

import com.sinosoft.agriclaim.api.registmanage.dto.ReportDto;
import com.sinosoft.agriclaim.api.registmanage.dto.ReturnXmlDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Map;

/**
 * 有效保额
 * @Author: 刘曼曼
 * @Date: 2018/3/7 10:26
 */
@WebService(serviceName = "NyxEffctiveAmoutSaveService",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.NyxEffctiveAmoutSaveService")
@Service
public class NyxEffctiveAmoutSaveServiceImpl implements NyxEffctiveAmoutSaveService{

    @Autowired
    private NyxEffectiveAmountApi nyxEffectiveAmountApi;

    /**
     * 保存有效保额表
     * @author: 刘曼曼
     * @date: 9:14 9:14
     * @param requestXml
     * @return String
     */
    @Override
    public String saveNyxEffctiveAmoutWebService(@WebParam(name="requestXml")String requestXml){
        XmlUtil util = new XmlUtil();
        PacketDto<List<NyxEffectiveAmountDto>> pDto = util.xmlToPacketDto_bodyList(requestXml,NyxEffectiveAmountDto.class,"nyxEffectiveAmountDto");
        List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList = pDto.getBody();
        String returnXml = "";
        String messege="";
        PacketDto packetDtoResult = new PacketDto();
        try {
            if(nyxEffectiveAmountDtoList.size()>0){
                Map<String ,String > m =  nyxEffectiveAmountApi.saveNyxEffectiveAmount(nyxEffectiveAmountDtoList);
                messege=m.get("messege");
            }
            packetDtoResult.setBody("成功");
        }catch (Exception e){
            packetDtoResult.getHead().setReturnStatusCode("9999");
            packetDtoResult.getHead().setReturnMessage(e.getMessage());
        }
        returnXml = util.packetDtoToXml_bodyDto(packetDtoResult);
        return returnXml;

    }


    /**
     * 批改保存有效保额表
     * @author: 刘曼曼
     * @date: 9:15 9:15
     * @param requestXml
     * @return
     */
    @Override
    public String modifyNyxEffctiveAmoutWebService(@WebParam(name="requestXml")String requestXml){
        XmlUtil util = new XmlUtil(){
            @Override
            public void xstreamSetting(XStream xstream) {
                super.xstreamSetting(xstream);
                xstream.alias("com.sinosoft.client.dto.NyxEffectiveAmountDto",NyxEffectiveAmountDto.class);
            }
        };

        PacketDto<RequestNyxEffectiveAmountDto> pDto = util.xmlToPacketDto_bodyDto(requestXml,RequestNyxEffectiveAmountDto.class);
        RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto = pDto.getBody();
        String returnXml = "";
        String messege="";
        PacketDto packetDtoResult = new PacketDto();
        try {
            if(requestNyxEffectiveAmountDto!=null){
                Map<String ,String > m =  nyxEffectiveAmountApi.modifyNyxEffectiveAmount(requestNyxEffectiveAmountDto);
                messege=m.get("messege");
            }
            packetDtoResult.setBody("成功");
        }catch (Exception e){
            packetDtoResult.getHead().setReturnStatusCode("9999");
            packetDtoResult.getHead().setReturnMessage(e.getMessage());
        }
        returnXml = util.packetDtoToXml_bodyDto(packetDtoResult);
        return returnXml;

    }
}
