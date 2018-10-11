package com.sinosoft.uap.service;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.registmanage.RegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.ReportDto;
import com.sinosoft.agriclaim.api.registmanage.dto.ReturnXmlDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Map;


/**
 * 调查流程节点
 * @Author: 孙朋飞
 * @Date: 2018/3/7 10:26
 */
@WebService(serviceName = "AgriclaimRegistService",//服务名
        targetNamespace = "http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.AgriclaimRegistService")
@Service
public class AgriclaimRegistServiceImpl implements AgriclaimRegistService {



    @Autowired
    private RegistApi registApi;

    /**
     * 接受金禾预报案数据
     * @author: 孙朋飞
     * @date: 2018/3/13 14:30
     * @param requestXml 请求数据
     * @return 报案号
     * @throws Exception
     */
    @Override
    public String saveReportFoWebService(@WebParam(name="requestXml")String requestXml){
        XmlUtil util = new XmlUtil();
        PacketDto<ReportDto> pDto = util.xmlToPacketDto_bodyDto(requestXml,ReportDto.class);
        ReportDto registDto = pDto.getBody();
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus("4");
        registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        String returnXml = "";
        ReturnXmlDto  returnXmlDto = new ReturnXmlDto();
        try {
            Map<String ,String > m =  registApi.saveReport(registDto);
            //todo 调度提交
            returnXmlDto.setCode("00");
            returnXmlDto.setMessage("报案成功，报案号为： " + m.get("registNo"));
            returnXmlDto.setPolicyNo(m.get("policyNo"));
            returnXmlDto.setRegistNo(m.get("registNo"));
        }catch (Exception e){
            returnXmlDto.setCode("01");
            returnXmlDto.setMessage(e.getMessage());
        }
        PacketDto<ReturnXmlDto> rPdto = new PacketDto();
        rPdto.setBody(returnXmlDto);
        returnXml = util.packetDtoToXml_bodyDto(rPdto);
        return returnXml;
    }
}
