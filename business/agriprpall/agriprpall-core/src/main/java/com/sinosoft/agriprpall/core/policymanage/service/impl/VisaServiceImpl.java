package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.*;
import com.sinosoft.agriprpall.api.client.visaclient.AgriPrpallVisaService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.service.VisaService;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单证系统交互相关的ServiceImpl类
 * @Author: 何伟东
 * @Date: 2017/11/29 14:08
 */
@Service
public class VisaServiceImpl extends BaseServiceImpl implements VisaService {

    /** webService服务地址 */
    @Value("${webservice.webAgriPrpallService.url}")
    private String webServiceUrl;
    /** 单证 webService WSDL 地址 */
    private final String VISA_SERVICE_URL = "/webAgriPrpallService/services/AgriPrpallVisaService?wsdl";
    /** webService 服务对象 */
    private static AgriPrpallVisaService agriPrpallVisaService = null;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    /**
     * 查询单证类型以及单证流水号服务
     * @author: 何伟东
     * @date: 2017/11/29 16:32
     * @param queryVisaCodesAndVisaSerialNosDto 包含businessNo业务号、comCode归属机构代码的Dto
     * @return 包含单证类型代码，单证类型名称，单证流水号的list
     */
    @Override
    public List<ResponseQueryVisaCodesAndVisaSerialNosDto> queryVisaCodesAndVisaSerialNos(RequestQueryVisaCodesAndVisaSerialNosDto queryVisaCodesAndVisaSerialNosDto) {
        if (queryVisaCodesAndVisaSerialNosDto ==null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        if (StringUtils.isEmpty(queryVisaCodesAndVisaSerialNosDto.getBusinessNo())) {
            throw new DataVerifyException("业务号不能为空！");
        }
        if (StringUtils.isEmpty(queryVisaCodesAndVisaSerialNosDto.getComCode())) {
            throw new DataVerifyException("归属机构不能为空！");
        }
        PacketDto<RequestQueryVisaCodesAndVisaSerialNosDto> requestPacketDto = new PacketDto();
        HeadDto headDto=new HeadDto();
        headDto.setUserCode(queryVisaCodesAndVisaSerialNosDto.getUserCode());//在这个dto加usecode是因为webservice里用到
        requestPacketDto.setHead(headDto);
        queryVisaCodesAndVisaSerialNosDto.setUserCode(null);//给headDto赋值后再将usecode设为null
        requestPacketDto.setBody(queryVisaCodesAndVisaSerialNosDto);
        XmlUtil xmlUtil = new XmlUtil();
        // 将Dto转换成xml报文
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(requestPacketDto);
        // 初始化webService 服务对象
        this.initService();
        String responseXml = "";
        if (queryVisaCodesAndVisaSerialNosDto.getBusinessNo().contains(",")) {
            responseXml = agriPrpallVisaService.querysVisaCodesAndVisaSerialNos(requestXml);
        } else {
            responseXml = agriPrpallVisaService.queryVisaCodesAndVisaSerialNos(requestXml);
        }
        PacketDto<List<ResponseQueryVisaCodesAndVisaSerialNosDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseQueryVisaCodesAndVisaSerialNosDto.class, "visaDto");
        HeadDto responseDtoHead = responsePacketDto.getHead();
        if (responseDtoHead==null || !"0000".equals(responseDtoHead.getReturnStatusCode())){
            throw new BusinessException(responseDtoHead.getReturnMessage());
        }
        List<ResponseQueryVisaCodesAndVisaSerialNosDto> responseDtoBody = responsePacketDto.getBody();
        return responseDtoBody;
    }

    /**
     * 回写单证状态
     * @author: 何伟东
     * @date: 2017/11/30 9:56
     * @param requestVisaStatusWriteBackDtos 包含业务号、归属及机构、流水号、单证类型
     * @return returnStatus 回写单证状态:1:成功;0:失败
     */
    @Override
    public String visaStatusWriteBack(List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos) {


        if (requestVisaStatusWriteBackDtos == null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        PacketDto<List<RequestVisaStatusWriteBackDto>> packetDto = new PacketDto<List<RequestVisaStatusWriteBackDto>>();
        List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos1 = new ArrayList<RequestVisaStatusWriteBackDto>();
        for (RequestVisaStatusWriteBackDto requestVisaStatusWriteBackDto : requestVisaStatusWriteBackDtos) {
            if (StringUtils.isEmpty(requestVisaStatusWriteBackDto.getBusinessNo())) {
                throw new DataVerifyException("业务号不能为空！");
            }
            if (StringUtils.isEmpty(requestVisaStatusWriteBackDto.getComCode())) {
                throw new DataVerifyException("归属机构不能为空！");
            }
            if (StringUtils.isEmpty(requestVisaStatusWriteBackDto.getVisaCode())) {
                throw new DataVerifyException("单证类型代码不能为空！");
            }
            if (StringUtils.isEmpty(requestVisaStatusWriteBackDto.getVisaSerialNo())) {
                throw new DataVerifyException("单证流水号不能为空！");
            }
            HeadDto headDto = new HeadDto();
            headDto.setUserCode(requestVisaStatusWriteBackDto.getUserCode());//在这个dto加usecode是因为webservice里用到
            packetDto.setHead(headDto);
            requestVisaStatusWriteBackDto.setUserCode(null);//给headDto赋值后再将usecode设为null
            requestVisaStatusWriteBackDtos1.add(requestVisaStatusWriteBackDto);
        }
        packetDto.setBody(requestVisaStatusWriteBackDtos1);
        XmlUtil xmlUtil = new XmlUtil();
        String requestXml = xmlUtil.packetDtoToXml_bodyList(packetDto, RequestVisaStatusWriteBackDto.class, "RequestVisaStatusWriteBackDto");
        // 初始化webService 服务对象
        this.initService();
        String responseXml = agriPrpallVisaService.visaStatusWriteBack(requestXml);
        PacketDto<List<ResponseVisaStatusWriteBackDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml, ResponseVisaStatusWriteBackDto.class, "ResponseVisaStatusWriteBackDto");
        List<ResponseVisaStatusWriteBackDto> responseDtoBodys = responsePacketDto.getBody();
        // 校验是否回写成功
        if ("9999".equals(responsePacketDto.getHead().getReturnStatusCode())) {
            throw new BusinessException("回写单证状态失败");
        }
        String status = "";
        for (ResponseVisaStatusWriteBackDto responseDtoBody : responseDtoBodys) {
            if ("0".equals(responseDtoBody.getReturnStatus())) {
                throw new BusinessException("回写单证状态失败");
            } else {
                status = responseDtoBody.getReturnStatus();
            }
        }
        return status;
    }

    /**
     * 初始化webService服务对象
     * @author: 何伟东
     * @date: 2017/11/30 10:16
     * @return agriPrpallVisaService
     */
    private AgriPrpallVisaService initService(){
        if (agriPrpallVisaService == null) {
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.setServiceClass(AgriPrpallVisaService.class);
            jaxWsProxyFactoryBean.setAddress(webServiceUrl + VISA_SERVICE_URL);
            System.out.println("-----------------------------------");
            System.out.println(webServiceUrl + VISA_SERVICE_URL);
            System.out.println("-----------------------------------");
            agriPrpallVisaService = (AgriPrpallVisaService) jaxWsProxyFactoryBean.create();
        }
        return agriPrpallVisaService;
    }

    /**
     * 废弃流水号
     *
     * @param requesttrashTranDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    public Map<String, String> trashTrans(RequesttrashTranDto requesttrashTranDto) throws Exception {
        //1.防空判断
        if (requesttrashTranDto == null) {
            throw new DataVerifyException("入参不能为空！");
        }
        if (StringUtils.isEmpty(requesttrashTranDto.getUserCode())) {
            throw new DataVerifyException("用户代码不能为空！");
        }
        List<String> businessNos = requesttrashTranDto.getBusinessNos();
        if (businessNos == null || businessNos.size() < 1) {
            throw new DataVerifyException("单号不能为空！");
        }
        List<String> list = new ArrayList<>();
        Boolean fals = false;

        if ("2".equals(requesttrashTranDto.getBusinessNos().get(0).substring(0, 1))) {
            fals = true;
        }
        Map<String, String> mapNo = new HashMap<>();
        if (fals) {
            List<PrpCmain> prpCmainByPolicyNos = prpCmainDao.findPrpCmainByPolicyNos(businessNos);
            for (PrpCmain prpCmain : prpCmainByPolicyNos) {
                mapNo.put(prpCmain.getPolicyNo(), prpCmain.getPrintNo());
            }
        } else {
            List<PrpPhead> prpPheadByPolicyNos = prpPheadDao.findPrpPheadByPolicyNos(businessNos);
            for (PrpPhead PrpPhead : prpPheadByPolicyNos) {
                mapNo.put(PrpPhead.getEndorseNo(), PrpPhead.getPrintNo());
            }
        }
        List<RequestVisaserialnoDto> requestVisaserialnoDtoList = new ArrayList<>();
        RequestVisaserialnoDto requestQueryVisaCodeDto = null;

        for (String str : businessNos) {
            requestQueryVisaCodeDto = new RequestVisaserialnoDto();
            requestQueryVisaCodeDto.setBusinessNo(str);
            requestQueryVisaCodeDto.setUserCode(requesttrashTranDto.getUserCode());
            requestQueryVisaCodeDto.setVisaSerialNo(mapNo.get(str));
            requestQueryVisaCodeDto.setVisaCode(requesttrashTranDto.getVisaCode());
            list.add(str);
            requestVisaserialnoDtoList.add(requestQueryVisaCodeDto);
        }
        //2.生成请求Xml
        PacketDto<List<RequestVisaserialnoDto>> packetDto = new PacketDto<List<RequestVisaserialnoDto>>();
        packetDto.setBody(requestVisaserialnoDtoList);
        XmlUtil xmlUtil = new XmlUtil();
        String requestXml = xmlUtil.packetDtoToXml_bodyList(packetDto, RequestVisaserialnoDto.class, "RequestVisaserialnoDto");
        //3.初始化webService 服务对象
        this.initService();
        //4.获取返回Xml
        String responseXml = agriPrpallVisaService.trashTrans(requestXml);
        //5.解析Xml获取返回Dto
        PacketDto<String> dtoPacketDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml, String.class);
        if ("9999".equals(dtoPacketDto.getHead().getReturnStatusCode())) {
            throw new DataVerifyException(dtoPacketDto.getHead().getReturnMessage());
        }
        if (fals) {
            prpCmainDao.updatePrintNos(list);
        } else {
            prpPheadDao.updatePrintNoos(list);
        }
        Map<String, String> map = new HashMap<>();
        map.put("succse", "作废成功");
        return map;
    }

    /**
     * 获取单证类型
     *
     * @param requestQueryVisaCodeDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    public ResponseQueryVisaCodeDto visaType(RequestQueryVisaCodeDto requestQueryVisaCodeDto) throws Exception {
        //1.防空判断

        if (StringUtils.isEmpty(requestQueryVisaCodeDto.getComCode())) {
            throw new DataVerifyException("归属机构代码ComCode不能为空！");
        }
        if (StringUtils.isEmpty(requestQueryVisaCodeDto.getRiskCode())) {
            throw new DataVerifyException("险种代码riskCode不能为空！");
        }
        if (StringUtils.isEmpty(requestQueryVisaCodeDto.getCertiType())) {
            throw new DataVerifyException("单证类型certiType不能为空！");
        }
        //2.生成请求Xml
        PacketDto<RequestQueryVisaCodeDto> packetDto = new PacketDto<RequestQueryVisaCodeDto>();
        packetDto.setBody(requestQueryVisaCodeDto);
        XmlUtil xmlUtil = new XmlUtil();
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        //3.初始化webService 服务对象
        this.initService();
        //4.获取返回Xml
        String responseXml = agriPrpallVisaService.queryVisaCode(requestXml);
        //5.解析Xml获取返回Dto
        PacketDto<ResponseQueryVisaCodeDto> dtoPacketDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml, ResponseQueryVisaCodeDto.class);
        if ("9999".equals(dtoPacketDto.getHead().getReturnStatusCode())) {
            throw new DataVerifyException(dtoPacketDto.getHead().getReturnMessage());
        }
        ResponseQueryVisaCodeDto responseQueryVisaCodeDto = dtoPacketDto.getBody();
        String visaCode = responseQueryVisaCodeDto.getVisaCode();

        if (visaCode != null && visaCode.indexOf("_") > 0) {
            String[] str = visaCode.split("_");
            if (str.length > 0) {
                visaCode = str[0];
            }
        }
        responseQueryVisaCodeDto.setVisaCode(visaCode);
        return dtoPacketDto.getBody();
    }
}