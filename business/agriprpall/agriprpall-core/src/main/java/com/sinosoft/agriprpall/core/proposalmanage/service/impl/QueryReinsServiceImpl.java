package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryRepolicyNoInfoDto;
import com.sinosoft.agriprpall.api.client.queryreinsclient.AgriPrpallRepolicynoInfoService;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryReinsService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 单号详细信息查询
 *
 * @author: 钱浩
 * @date: 2017/11/30 下午 14:39
 */
@Service
public class QueryReinsServiceImpl extends BaseServiceImpl implements QueryReinsService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryReinsServiceImpl.class);

    @Value("${webservice.webAgriPrpallService.url}")
    private String webUrl;

    /**
     * 根据分保保单号查询详细信息
     *
     * @param reinsNo 分保保单号
     * @return 分保保单Dto
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/30 下午 14:51
     */
    @Override
    public List<ResponseQueryRepolicyNoInfoDto> queryByReinNo(String reinsNo) throws Exception {
        PacketDto packetDto = new PacketDto();
        packetDto.setBody(reinsNo);
        XmlUtil xmlUtil = new XmlUtil();
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(AgriPrpallRepolicynoInfoService.class);
        factoryBean.setAddress(webUrl + "/webAgriPrpallService/services/AgriPrpallRepolicynoInfoService?wsdl");
        AgriPrpallRepolicynoInfoService repolicynoInfoService = (AgriPrpallRepolicynoInfoService) factoryBean.create();
        String responsXml = repolicynoInfoService.queryRelateRepolicyno(requestXml);
        PacketDto<List<ResponseQueryRepolicyNoInfoDto>> queryRepolicyNoInfoDtos = xmlUtil.xmlToPacketDto_bodyList(responsXml, ResponseQueryRepolicyNoInfoDto.class, "responseQueryRepolicyNoInfoDto");
        String statusCode = queryRepolicyNoInfoDtos.getHead().getReturnStatusCode();
        //2.判断连接返回
        if ("9999".equals(statusCode)) {
            throw new BusinessException(queryRepolicyNoInfoDtos.getHead().getReturnMessage());
        }
        List<ResponseQueryRepolicyNoInfoDto> responseQueryTraceInfoDtos = queryRepolicyNoInfoDtos.getBody();
        return responseQueryTraceInfoDtos;
    }
}