package com.sinosoft.agriprpall.core.common.impl;

import com.sinosoft.agriprpall.api.client.platformclient.AgriPrpallPlatformService;
import com.sinosoft.agriprpall.api.undwrtsubmit.dto.RequestGetPropertyDto;
import com.sinosoft.agriprpall.api.undwrtsubmit.dto.RequestGetRuleInUtiPlatConfigRuleDto;
import com.sinosoft.agriprpall.api.undwrtsubmit.dto.ResponseGetPropertyDto;
import com.sinosoft.agriprpall.api.undwrtsubmit.dto.ResponseGetRuleInUtiPlatConfigRuleDto;
import com.sinosoft.agriprpall.core.common.GetRuleInUtiPlatConfigRuleService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetRuleInUtiPlatConfigRuleServiceImpl  extends BaseServiceImpl implements GetRuleInUtiPlatConfigRuleService {
    private XmlUtil xmlUtil;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl2;
    /**
     * @description: 多条件查询tablename
     * @author: 钱浩
     * @date: 2017/10/30 10:02
     * @param systemCode 系统
     * @param paramCode 表代码
     * @param serialNo 标志
     * @return
     */
    public String queryfindOne(String systemCode,String paramCode,String serialNo)throws Exception{
        //1.连接平台配置中心
        RequestGetRuleInUtiPlatConfigRuleDto rule=new RequestGetRuleInUtiPlatConfigRuleDto();
        rule.setParamCode(paramCode);
        rule.setSystemCode(systemCode);
        rule.setSerialNo(serialNo);
        PacketDto packetDto=new PacketDto();
        packetDto.setBody(rule);
        xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(AgriPrpallPlatformService.class);
        factoryBean.setAddress(webserviceUrl2+"/webAgriPrpallService/services/AgriPrpallPlatformService?wsdl".trim());
        AgriPrpallPlatformService platformService=(AgriPrpallPlatformService)factoryBean.create();
        String responseXml=platformService.getRuleInUtiPlatConfigRule(requestXml);
        PacketDto<ResponseGetRuleInUtiPlatConfigRuleDto> reponseDto=xmlUtil.xmlToPacketDto_bodyDto(responseXml,ResponseGetRuleInUtiPlatConfigRuleDto.class);
        String statusCode= reponseDto.getHead().getReturnStatusCode();
        //2.判断连接返回
         if ("9999".equals(statusCode)) {
             throw new BusinessException( reponseDto.getHead().getReturnMessage());
        }
        //3.获取tablename
       //todo 后期缓存
        String  tablename=reponseDto.getBody().getRule();
        return tablename;
    }
    /**
     * @description:平台对接
     * @author: 钱浩
     * @date: 2017/10/25 11:23
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    public String getProperty(String paramCode) throws Exception{
        //1.连接平台配置中心
        RequestGetPropertyDto requestGetPropertyDto=new RequestGetPropertyDto();
        requestGetPropertyDto.setParamKey(paramCode);
        PacketDto<RequestGetPropertyDto> packetDto=new PacketDto<>();
        packetDto.setBody(requestGetPropertyDto);
        xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(AgriPrpallPlatformService.class);
        factoryBean.setAddress(webserviceUrl2+"/webAgriPrpallService/services/AgriPrpallPlatformService?wsdl".trim());
        AgriPrpallPlatformService platform=(AgriPrpallPlatformService)factoryBean.create();
        String reponseXml=platform.getProperty(requestXml);
        PacketDto<ResponseGetPropertyDto> responsePlatform=xmlUtil.xmlToPacketDto_bodyDto(reponseXml,ResponseGetPropertyDto.class);
        ResponseGetPropertyDto responseGetPropertyDto=responsePlatform.getBody();
       String statusCode= responsePlatform.getHead().getReturnStatusCode();
        //2.判断连接返回
        if("9999".equals(statusCode)){
            throw new BusinessException(responsePlatform.getHead().getReturnMessage());
        }
        //3.获取tablenamep
        String tableName= responseGetPropertyDto.getParamValue();
        return tableName;
    }
}
