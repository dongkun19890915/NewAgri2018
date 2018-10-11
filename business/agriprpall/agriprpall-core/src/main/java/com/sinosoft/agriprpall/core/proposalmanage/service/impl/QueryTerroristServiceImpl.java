package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestQueryTerroristInfoDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTerroristInfoDto;
import com.sinosoft.agriprpall.api.client.rinsclient.AgriPrpallTerroristInfoService;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryTerroristService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QueryTerroristServiceImpl extends BaseServiceImpl implements QueryTerroristService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryTerroristServiceImpl.class);
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl3;
    /**
     * 调用反洗钱系统服务查询所有恐怖分子
     * @author: 宋振振
     * @date: 2017/10/21 11:02
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return 返回恐怖分子信息列表
     * @throws Exception
     */
    public List<ResponseQueryTerroristInfoDto> queryTerroristInfo(Integer pageNo,Integer pageSize) throws Exception{
        if(pageNo<=0){
            throw new DataVerifyException("页码不能小于0");
        }
        if(pageSize<=0){
            throw new DataVerifyException("每页条数不能小于0");
        }
        // 调用反洗钱系统服务查询所有恐怖分子
        PacketDto packetDto = new PacketDto();
        XmlUtil xmlUtil = new XmlUtil();
        RequestQueryTerroristInfoDto requestQueryTerroristInfoDto=new RequestQueryTerroristInfoDto();
        requestQueryTerroristInfoDto.setPageNo(pageNo);
        requestQueryTerroristInfoDto.setPageSize(pageSize);
        packetDto.setBody(requestQueryTerroristInfoDto);
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallTerroristInfoService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallTerroristInfoService?wsdl".trim());
        AgriPrpallTerroristInfoService reinsService = (AgriPrpallTerroristInfoService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.queryTerroristInfo(requsetXml);
        PacketDto<List<ResponseQueryTerroristInfoDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseQueryTerroristInfoDto.class, "ResponseQueryTerroristInfoDto");
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
        // 校验statusCode
        if("9999".equals(statusCode)){
            throw new Exception("调用反洗钱系统查询所有恐怖分子的操作失败！");
        }
        List<ResponseQueryTerroristInfoDto> responseQueryTerroristInfoDtoList= responsePacketDto.getBody();

        return responseQueryTerroristInfoDtoList;
    }
}
