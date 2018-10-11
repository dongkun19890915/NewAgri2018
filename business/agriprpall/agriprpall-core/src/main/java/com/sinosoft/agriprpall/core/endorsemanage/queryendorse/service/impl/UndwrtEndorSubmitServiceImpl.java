package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestUnderwriteSubmitDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUnderwriteSubmitDto;
import com.sinosoft.agriprpall.api.client.undwrtclient.AgriPrpallUndwrtService;
import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainKey;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.UndwrtEndorSubmitService;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 批改提交核保
 *
 * @author: 钱浩
 * @date: 2017/11/29 上午 10:29
 */
@Service
public class UndwrtEndorSubmitServiceImpl extends BaseServiceImpl implements UndwrtEndorSubmitService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UndwrtEndorSubmitServiceImpl.class);

    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    private XmlUtil xmlUtil;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl1;
    @Autowired
    private ProcessApi processApi;

    /**
     * 批改提交核保
     *
     * @param undwrtEndorSubmitDto 入参对象
     * @return list 返回语句，状态集合
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/29 上午 10:33
     */
    @Override
    public List<String> saveUndwrtByEndorseNo(UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception {
        String[] endorseNos=undwrtEndorSubmitDto.getEndorseNos();
        if(endorseNos.length<=0){
            throw new DataVerifyException("批单号不能为空");
        }
        String userCode=undwrtEndorSubmitDto.getUserCode();
        String DLComCode=undwrtEndorSubmitDto.getDLComCode();
        String strUnderWriteFlag = "";
        String strMessage = "";
        String StatusPic = "";
        String strGetFlagFailMessage = "";
        String strEndorseSuccessMessage = "";
        String CertiType = "E";
        String strFlowId = "";
        String strRiskCode = "";
        String strClassCode = "";
        String strComCode = "";
        String strMakeCom = "";
        String strHandlerCode = "";
        String strHandler1Code = "";
        String strMessage1="";
        List<String> listmassage=new ArrayList<String>();
        int index = 0;
        //影像系统添加
//        String role = "";
//        String appcode = "";
//        String appname = "";
//        String username="";
//        String comcode = "";
//        String comname= "";
//        String code = "";
//        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(userCode);
//        username = prpDuserDto.getUserName();
//        String comCode = prpDuserDto.getComCode();
//        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
//        comcode = prpDuserDto.getComCode();
//        comname = prpDcompanyDto.getComCName();
//        String result = "";
        //逐条提交核保
        //结果信息存list返回
        List<String> list = new ArrayList<String>();
        for (index = 0; index < endorseNos.length; index++) {
            PrpPmain dbPrpPmain = null;
            try {
                dbPrpPmain = prpPmainDao.findOne(new PrpPmainKey(endorseNos[index]));
                strRiskCode = dbPrpPmain.getRiskCode();
                strClassCode = dbPrpPmain.getClassCode();
                strComCode = dbPrpPmain.getComCode();
                strMakeCom = dbPrpPmain.getMakeCom();
                strHandlerCode = dbPrpPmain.getHandlerCode();
                strHandler1Code = dbPrpPmain.getHandler1Code();
                PrpPhead dbPrpPhead = prpPheadDao.findOne(new PrpPheadKey(endorseNos[index]));
                strUnderWriteFlag = dbPrpPhead.getUnderwriteFlag();//取标志位

                String editType = dbPrpPhead.getEndorType();
//                if(strRiskCode!=null)
//                {
//                    prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strRiskCode,"0000000000");
//                    role = prpdimagecodeDto.getPrpallrole();
//                    appcode=prpdimagecodeDto.getPrpallcode();
//                    code = "ECM0002";
//                    appname=prpdimagecodeDto.getPrpallname();
//                    //String businessno= "1111111111";
//                    String businessno = dbPrpPmain.getEndorseNo();
//                    StringBuffer s = new StringBuffer();
//                    s.append("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>");
//                    s.append("<USER_CODE>");
//                    s.append(userCode);
//                    s.append("</USER_CODE>");
//
//                    s.append("<USER_NAME>");
//                    s.append(username);
//                    s.append("</USER_NAME>");
//
//                    s.append("<ORG_CODE>");
//                    s.append(comcode);
//                    s.append("</ORG_CODE>");
//
//                    s.append("<ORG_NAME>");
//                    s.append(comname);
//                    s.append("</ORG_NAME>");
//
//                    s.append("<ROLE_CODE>");
//                    s.append(role);
//                    s.append("</ROLE_CODE>");
//
//                    s.append("</BASE_DATA><META_DATA><BATCH>");
//
//                    s.append("<APP_CODE>");
//                    s.append(appcode);
//                    s.append("</APP_CODE>");
//
//                    s.append("<APP_NAME>");
//                    s.append(appname);
//                    s.append("</APP_NAME>");
//
//                    s.append("<BUSI_NO>");
//                    s.append(businessno);
//                    s.append("</BUSI_NO>");
//
//                    s.append("</BATCH></META_DATA></root>");
//                    try{
//			  /*  result = blPrpdimagecodeFacade.imageStatistics(s.toString()); */
//                        result="";
//                        System.err.println(result);
//                        String newxml = blPrpdimagecodeFacade.html2xml(result);
//                        String nodeID = "";
//                        String strWaning = "";
//                        Collection nodes =  new ArrayList();
//                        nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(strRiskCode,"prpall_P");
//
//                        HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml,nodes);
//                        strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes,hm);
//                        if(!strWaning.equals(""))
//                        {
//                            throw new Exception(strWaning);
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                        throw e;
//                    }
//
//                }
                if (!strUnderWriteFlag.equals("9") && !strUnderWriteFlag.equals("1") && !strUnderWriteFlag.equals("3")) {
                    //周边交互
                    RequestUnderwriteSubmitDto underwriteSubmitDto = new RequestUnderwriteSubmitDto();
                    underwriteSubmitDto.setModelType("11");
                    underwriteSubmitDto.setCertiType(CertiType);
                    underwriteSubmitDto.setBusinessNo(endorseNos[index]);
                    underwriteSubmitDto.setRiskCode(strRiskCode);
                    underwriteSubmitDto.setClassCode(strClassCode);
                    underwriteSubmitDto.setComCode(strComCode);
                    underwriteSubmitDto.setMakecom(strMakeCom);
                    underwriteSubmitDto.setUserCode(userCode);
                    underwriteSubmitDto.setHandlerCode(strHandlerCode);
                    underwriteSubmitDto.setHandler1Code(strHandler1Code);
                    underwriteSubmitDto.setContractNo("");
                    PacketDto<RequestUnderwriteSubmitDto> packeDto = new PacketDto<RequestUnderwriteSubmitDto>();
                    packeDto.setBody(underwriteSubmitDto);
                    xmlUtil = new XmlUtil();
                    String Xml = xmlUtil.packetDtoToXml_bodyDto(packeDto);
                    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
                    factory.setServiceClass(AgriPrpallUndwrtService.class);
                    factory.setAddress(webserviceUrl1 + "/webAgriPrpallService/services/AgriPrpallUndwrtService?wsdl".trim());
                    AgriPrpallUndwrtService port = (AgriPrpallUndwrtService) factory.create();
                    String responseXml = port.underwriteSubmit(Xml);
                    PacketDto<ResponseUnderwriteSubmitDto> responsepackeDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml, ResponseUnderwriteSubmitDto.class);
                    String message = responsepackeDto.getHead().getReturnMessage();
                    String statusCode = responsepackeDto.getHead().getReturnStatusCode();
                    if ("9999".equals(statusCode)) {
                        throw new DataVerifyException(message);
                    }
                    ResponseUnderwriteSubmitDto responseUnderwriteSubmitDto = responsepackeDto.getBody();
                    strFlowId += responseUnderwriteSubmitDto.getFlowId();
                    strMessage = "成功";//信息集合判断标志
                } else {
                    strMessage1 = endorseNos[index] + " 已经提交核保，无需再次提交！";
                    StatusPic = "500";
                }
            } catch (Exception e) {
                strGetFlagFailMessage += endorseNos[index];
                listmassage.add(e.getMessage());
               continue;
            }
            //无需核保
            if (strUnderWriteFlag != null && strUnderWriteFlag.equals("3")) {
                strEndorseSuccessMessage += "批单（" + endorseNos[index] + "）无需核保";
                StatusPic = "500";
            }
            if (!strMessage.equals("")) {
           /* strMessage =  "批单提交核保成功。返回工作流号如下" + strFlowId + "";*/
                strMessage = strFlowId;
                StatusPic = "200";
            }
            if (!strGetFlagFailMessage.equals("")) {
                strMessage += "下列批单提交审批失败：" + strGetFlagFailMessage;
                StatusPic = "500";
            }
            if (!strEndorseSuccessMessage.equals("")) {
                strMessage += strEndorseSuccessMessage;
                StatusPic = "500";
            }
            if (!strMessage1.equals("")) {
                strMessage += strMessage1;
                StatusPic = "500";
            }
            list.add(strMessage);
            this.generateNodeData(dbPrpPmain);
        }//end for
        if(listmassage.size()>0){
            String message1="";
          for(int i=0;i<listmassage.size();i++){
              message1+=listmassage.get(i);
          }
          throw new DataVerifyException(message1);
        }
        return list;
    }

    /**
     * 生成节点数据
     *
     * @param prpPmain 投保单主要信息
     * @return
     * @date: 2018/4/9 11:10
     * @author: 何伟东
     */
    private void generateNodeData(PrpPmain prpPmain) throws Exception {
        String operatorCode = prpPmain.getOperatorCode();
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(operatorCode);
        ProcessDto submitEndorseProcessDto = new ProcessDto.Builder()
                .stepCode(NodeType.SUBMIT_ENDORSE_NODE)
                .stateCode(NodeState.PROCESSED)
                .bizCode(prpPmain.getEndorseNo())
                .inflowTime((Date) prpPmain.getOperateDate().clone())
                .outflowTime((Date) prpPmain.getOperateDate().clone())
                .opCode(operatorCode)
                .opName(prpDuserDto.getUserName())
                .opTime((Date) prpPmain.getOperateDate().clone())
                .resultCode(NodeResultCode.ENDORSE_SUBMIT)
                .build();
        // 同时生成核批未处理节点
        ProcessDto auditEndorseProcessDto = new ProcessDto.Builder()
                .stepCode(NodeType.AUDIT_ENDORSE_NODE)
                .stateCode(NodeState.UNPROCESSED)
                .bizCode(prpPmain.getEndorseNo())
                .inflowTime((Date) prpPmain.getOperateDate().clone())
                .outflowTime((Date) prpPmain.getOperateDate().clone())
                .opCode(operatorCode)
                .opName(prpDuserDto.getUserName())
                .opTime((Date) prpPmain.getOperateDate().clone())
                .resultCode(NodeResultCode.EMPTY)
                .build();
        List<ProcessDto> processDtos = new ArrayList<>(2);
        processDtos.add(submitEndorseProcessDto);
        processDtos.add(auditEndorseProcessDto);
        processApi.generateMultipleNodeData(processDtos);
    }
}
