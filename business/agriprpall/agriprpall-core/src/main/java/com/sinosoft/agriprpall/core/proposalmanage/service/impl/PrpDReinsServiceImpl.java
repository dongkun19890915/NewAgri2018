package com.sinosoft.agriprpall.core.proposalmanage.service.impl;


import com.sinosoft.agriprpall.api.client.dto.*;
import com.sinosoft.agriprpall.api.client.rinsclient.AgriPrpallReinsService;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpDReinsService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 12:54:07.447
 * @description 分保接受人代码表Core接口实现
 */
@Service
public class PrpDReinsServiceImpl extends BaseServiceImpl implements PrpDReinsService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDReinsServiceImpl.class);


    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl3;

    /**
     * 查询共保接受人信息
     * @author: 钱浩
     * @date: 2017/10/24 21:10
     * @param reinsCode 接受人代码
     * @param shortName 接受人简称
     * @return List<ResponseQueryPrpDreinsDto> 共保人信息List
     */
    public List<ResponseQueryPrpDreinsDto> queryCoinsComCodeInfo(String reinsCode, String shortName) throws Exception {

        String strWhere = " ValidStatus='1' ";
        if (StringUtils.isNotEmpty(shortName)) {
            strWhere += " and  shortName like '%" + shortName + "%'";
        } else if (StringUtils.isNotEmpty(reinsCode)) {
            strWhere += " and  reinsCode like '%" + reinsCode + "%'";
        }
        strWhere += " ORDER BY ReinsCode";
        //再保接口
        RequestQueryPrpDreinsDto requestQueryPrpDreinsDto = new RequestQueryPrpDreinsDto();
        requestQueryPrpDreinsDto.setCondition(strWhere);
        PacketDto packetDto = new PacketDto();
        packetDto.setBody(requestQueryPrpDreinsDto);
        XmlUtil xmlUtil = new XmlUtil();
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallReinsService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallReinsService?wsdl".trim());
        AgriPrpallReinsService reinsService = (AgriPrpallReinsService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.getNewAgriPrpallReins(requsetXml);
        PacketDto<List<ResponseQueryPrpDreinsDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseQueryPrpDreinsDto.class, "responseQueryPrpDreinsDto");
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
        //2.判断连接返回
        if ("9999".equals(statusCode)) {
            throw new BusinessException(responsePacketDto.getHead().getReturnMessage());
        }
        List<ResponseQueryPrpDreinsDto> prpDreinsDtoList = responsePacketDto.getBody();
        return prpDreinsDtoList;
    }

    /**
     * 查询协议共保
     * @author: 田健
     * @date: 2018/5/8 10:10
     * @param startDate 起保时间
     * @param comCode 归属机构
     * @param riskCode 险种代码
     * @return 协议共保信息
     * @throws Exception
     */
    public ResponseQueryReinsCoinsDto findCoinsTreaty(String startDate,String comCode,String riskCode) throws Exception{
        List<ResponseQueryReinsCoinsDto> responseQueryReinsCoinsDtoList = new ArrayList<>();
        RequestQueryReinsCoinsDto requestQueryReinsCoinsDto = new RequestQueryReinsCoinsDto();
        PacketDto packetDto = new PacketDto();
        XmlUtil xmlUtil = new XmlUtil();
        requestQueryReinsCoinsDto.setComCode(comCode);
        requestQueryReinsCoinsDto.setRiskCode(riskCode);
        requestQueryReinsCoinsDto.setStartDate(startDate);
        packetDto.setBody(requestQueryReinsCoinsDto);
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallReinsService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallReinsService?wsdl".trim());
        AgriPrpallReinsService reinsService = (AgriPrpallReinsService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.getReinsCoinsuranceAgreement(requsetXml);
        PacketDto<List<ResponseQueryReinsCoinsDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseQueryReinsCoinsDto.class, "responseQueryReinsCoinsDto");
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
        //2.判断连接返回
        if ("9999".equals(statusCode)) {
            throw new BusinessException(responsePacketDto.getHead().getReturnMessage());
        }
        responseQueryReinsCoinsDtoList = responsePacketDto.getBody();
        return responseQueryReinsCoinsDtoList.get(0);

    }

    /**
     * 获取再保协议业务数据方法
     * @author: 田健
     * @date: 2018/5/8 18:05
     * @param TreatyNo 再保合约号
     * @return 再保合约信息
     * @throws Exception
     */
    public List<ResponseQueryReinsAgreementDto> getResponseQueryReinsAgreementDtoList(String TreatyNo)throws Exception{
        RequestQueryReinsAgreementDto requestQueryReinsAgreementDto = new RequestQueryReinsAgreementDto();
        List<ResponseQueryReinsAgreementDto> responseQueryReinsCoinsDtoList = new ArrayList<>();
        PacketDto packetDto = new PacketDto();
        XmlUtil xmlUtil = new XmlUtil();
        requestQueryReinsAgreementDto.setTreatyNo(TreatyNo);
        packetDto.setBody(requestQueryReinsAgreementDto);
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallReinsService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallReinsService?wsdl".trim());
        AgriPrpallReinsService reinsService = (AgriPrpallReinsService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.getReinsAgreement(requsetXml);
        PacketDto<List<ResponseQueryReinsAgreementDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseQueryReinsAgreementDto.class, "responseQueryReinsAgreementDto");
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
        //2.判断连接返回
        if ("9999".equals(statusCode)) {
            throw new BusinessException(responsePacketDto.getHead().getReturnMessage());
        }
        responseQueryReinsCoinsDtoList = responsePacketDto.getBody();
        return responseQueryReinsCoinsDtoList;
    }
}