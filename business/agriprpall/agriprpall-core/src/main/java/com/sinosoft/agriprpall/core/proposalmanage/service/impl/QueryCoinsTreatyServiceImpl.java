package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.RequestQueryReinsCoinsDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;
import com.sinosoft.agriprpall.api.client.rinsclient.AgriPrpallReinsService;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryCoinsTreatyService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 共保再保信息基本信息表Service层实现类
 * @author : 王保良
 * @Date: 2017/11/18 11:20
 */
@Service
public class QueryCoinsTreatyServiceImpl extends BaseServiceImpl implements QueryCoinsTreatyService{

    private static final Logger LOGGER= LoggerFactory.getLogger(QueryCoinsTreatyServiceImpl.class);

    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;

    /**定义返回的失败码为9999*/
    private String failCode="9999";

    /**
     * 方法简述：根据入参1险种代码 riskCode 2机构代码 comCode 3合约起期查询其共保协议信息 startDate
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param riskCode 险种代码
     * @param comCode 机构代码
     * @param startDate 合约起期
     * @return List<FhCoinsTreatyDto>(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付)
     * @throws Exception
     */
    @Override
    public List<ResponseQueryReinsCoinsDto> queryCoinsTreatyService(String riskCode, String comCode, String startDate) throws Exception {
        if (StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("请先录入归属机构");
        }
        if (StringUtils.isEmpty(startDate)){
            throw new DataVerifyException("请先录入保单起保日期");
        }
//        组装coins对象
        RequestQueryReinsCoinsDto requestQueryReinsCoinsDto=new RequestQueryReinsCoinsDto();
        requestQueryReinsCoinsDto.setComCode(comCode);
        requestQueryReinsCoinsDto.setRiskCode(riskCode);
        requestQueryReinsCoinsDto.setStartDate(startDate);
        PacketDto packetDto=new PacketDto();
        packetDto.setBody(requestQueryReinsCoinsDto);
        //todo  packetDto头信息中加入用户名账号以及密码
        XmlUtil xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);

//        发送给webService
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallReinsService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/AgriPrpallReinsService?wsdl".trim());
        AgriPrpallReinsService agriPrpallReinsService= (AgriPrpallReinsService) jaxWsProxyFactoryBean.create();
        String responseXml=agriPrpallReinsService.getReinsCoinsuranceAgreement(requestXml);

//        获取ResponseXml后解析为Dto 根据状态码抛出异常或者返回对象
        PacketDto<List<ResponseQueryReinsCoinsDto>> responseDto=xmlUtil.xmlToPacketDto_bodyList(responseXml,ResponseQueryReinsCoinsDto.class,"responseQueryReinsCoinsDto");
        String statusCode=responseDto.getHead().getReturnStatusCode();
        if (failCode.equals(statusCode)){
            throw new BusinessException(responseDto.getHead().getReturnMessage());
        }
        List<ResponseQueryReinsCoinsDto> responseQueryReinsCoinsDtoList=responseDto.getBody();
        return responseQueryReinsCoinsDtoList;
    }



    /**
     * 方法简述：根据入参treatyNo 协议共保合约编码 查询其再保协议信息
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param treatyNo
     * @return List<FhCoinsTreatyInfoDto>(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付 )
     * @throws Exception
     */
    @Override
    public List<ResponseQueryReinsAgreementDto> queryCoinsTreatyInfo(String treatyNo) throws Exception{
        if (StringUtils.isEmpty(treatyNo)){
            throw new DataVerifyException("再保合约号不能为空");
        }
//        将入参装入对象中在解析成xml
        RequestQueryReinsAgreementDto requestQueryReinsAgreementDto=new RequestQueryReinsAgreementDto();
        requestQueryReinsAgreementDto.setTreatyNo(treatyNo);
        PacketDto packetDto=new PacketDto();
        packetDto.setBody(requestQueryReinsAgreementDto);
        //todo packetDto头信息中加入用户名以及密码
        XmlUtil xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);
//        将xml发送
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallReinsService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/AgriPrpallReinsService?wsdl".trim());
        AgriPrpallReinsService agriPrpallReinsService= (AgriPrpallReinsService) jaxWsProxyFactoryBean.create();
        String responseXml= agriPrpallReinsService.getReinsAgreement(requestXml);
//        获取相应的xml并解析为对象再返回
        PacketDto<List<ResponseQueryReinsAgreementDto>> responseDto=xmlUtil.xmlToPacketDto_bodyList(responseXml,ResponseQueryReinsAgreementDto.class,"responseQueryReinsAgreementDto");
        String statusCode = responseDto.getHead().getReturnStatusCode();
//        判断返回的状态码,抛出所要的异常或者返回所需要的数据
        if (failCode.equals(statusCode)){
            throw new BusinessException(responseDto.getHead().getReturnMessage());
        }
        List<ResponseQueryReinsAgreementDto> responseQueryReinsAgreementDtoList=responseDto.getBody();
        return responseQueryReinsAgreementDtoList;
    }
}
