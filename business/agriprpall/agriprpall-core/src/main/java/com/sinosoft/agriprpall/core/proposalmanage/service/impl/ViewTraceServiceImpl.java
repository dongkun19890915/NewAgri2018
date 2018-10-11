package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTraceInfoDto;
import com.sinosoft.agriprpall.api.client.undwrtclient.AgriPrpallUndwrtService;
import com.sinosoft.agriprpall.api.client.undwrttrace.AgriPrpallUndwrtTraceInfoService;
import com.sinosoft.agriprpall.core.proposalmanage.service.ViewTraceService;
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

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description
 */
@Service
public class ViewTraceServiceImpl extends BaseServiceImpl implements ViewTraceService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewTraceServiceImpl.class);

    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl1;

    /**
     * @description: 核保信息查询
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param proposalNo 投保单号
     * @return ResponseDto： 审批意见集合
     * @throws Exception
     */
    public  List<ResponseQueryTraceInfoDto> getViewTrace(String proposalNo)throws Exception{
        if(StringUtils.isEmpty(proposalNo)){
            throw new DataVerifyException("投保单号不能为空");
        }
        List list=new ArrayList();
        PacketDto packetDto=new PacketDto();
        packetDto.setBody(proposalNo);
        XmlUtil xmlUtil=new XmlUtil();
        String requestXml=xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(AgriPrpallUndwrtTraceInfoService.class);
        factoryBean.setAddress(webserviceUrl1+"/webAgriPrpallService/services/AgriPrpallUndwrtTraceInfoService?wsdl");
        AgriPrpallUndwrtTraceInfoService agriPrpallUndwrtService=(AgriPrpallUndwrtTraceInfoService)factoryBean.create();
        String responseXml=agriPrpallUndwrtService.queryUndwrtTraceInfo(requestXml);
        PacketDto<List<ResponseQueryTraceInfoDto>> reponseDto=xmlUtil.xmlToPacketDto_bodyList(responseXml,ResponseQueryTraceInfoDto.class,"responseQueryTraceInfoDto");
        String statusCode= reponseDto.getHead().getReturnStatusCode();
        //2.判断连接返回
        if ("9999".equals(statusCode)) {
            throw new BusinessException( reponseDto.getHead().getReturnMessage());
        }
        List<ResponseQueryTraceInfoDto> responseQueryTraceInfoDtos=reponseDto.getBody();
        return responseQueryTraceInfoDtos;
    }
}