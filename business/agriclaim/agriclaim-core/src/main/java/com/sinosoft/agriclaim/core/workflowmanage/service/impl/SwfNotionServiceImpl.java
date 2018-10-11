package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.ResponseSwfNotionInfo;
import com.sinosoft.agriclaim.api.workflowmanage.dto.ResponseSwfNotionInfoDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNotionDto;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNotionDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotion;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotionKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNotionService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.dom4j.Document;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 处理意见表Core接口实现
 */
@Service
public class SwfNotionServiceImpl extends BaseServiceImpl implements SwfNotionService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfNotionServiceImpl.class);
    
    @Autowired
    private SwfNotionDao swfNotionDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;
    @Autowired
    private SwfLogDao swfLogDao;
    /**
     *@description 新增
     *@param
     */
    public void save(SwfNotionDto swfNotionDto) {
        SwfNotion swfNotion = this.convert(swfNotionDto, SwfNotion.class);
        swfNotionDao.save(swfNotion);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo) {
        SwfNotionKey swfNotionKey = new SwfNotionKey(flowId,logNo,lineNo);
        swfNotionDao.delete(swfNotionKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfNotionDto swfNotionDto) {
        SwfNotion swfNotion = this.convert(swfNotionDto, SwfNotion.class);
        swfNotionDao.save(swfNotion);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfNotionDto queryByPK(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo) {
        SwfNotionKey swfNotionKey = new SwfNotionKey(flowId,logNo,lineNo);
        SwfNotion swfNotion = swfNotionDao.findOne(swfNotionKey);
        return this.convert(swfNotion,SwfNotionDto.class);
    }
    /**
     * 根据流程编号和序号查询审核意见
     * @author: 孙朋飞
     * @date: 2018/4/26 19:37
     * @param  businessNo 流程id
     * @return 审核意见的集合
     * @throws Exception
     */
    @Override
    public List<ResponseSwfNotionInfoDto> querySwfNotionByFlowId(String businessNo) throws Exception {
        /*List<SwfLog> allByFlowIDAndLogNo = swfLogDao.findAllByFlowIDAndLogNo(flowId, Integer.valueOf(logNo));
        String businessNo="";
        if(allByFlowIDAndLogNo!=null&&allByFlowIDAndLogNo.size()>0){
            businessNo=allByFlowIDAndLogNo.get(0).getBusinessNo();
        }*/
        ResponseSwfNotionInfo responseSwfNotionInfo = new ResponseSwfNotionInfo();
        responseSwfNotionInfo.setBusinessNo(businessNo);
        String xmlData = "";
        XmlUtil xmlUtil = new XmlUtil();
        PacketDto<ResponseSwfNotionInfo> packetDto = new PacketDto<>();
        packetDto.setBody(responseSwfNotionInfo);
        xmlData = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
        NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();
        String xml = newAgriPrpallUndwrtService.queryCommonTraceInfo(xmlData);
        //xml转为dto
        if(StringUtils.isEmpty(xml)){
            return null;
        }
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element requestData =document.getRootElement();
        List<Element> list = requestData.elements("wfLogDtoList");

        List<ResponseSwfNotionInfoDto> responseSwfNotionInfoDtoList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ResponseSwfNotionInfoDto responseSwfNotionInfoDto = new ResponseSwfNotionInfoDto();
            String flowIds = list.get(i).element("flowId").getTextTrim();
            String logNos = list.get(i).element("logNo").getTextTrim();
            String flowInTime=list.get(i).element("flowInTime").getTextTrim();
            String handleText = list.get(i).element("handleText").getTextTrim();
            String submitTime = list.get(i).element("submitTime").getTextTrim();
            String nodeName = list.get(i).element("nodeName").getTextTrim();
            String nodeStatus = list.get(i).element("nodeStatus").getTextTrim();
            String flowStatus = list.get(i).element("flowStatus").getTextTrim();
            if("0".equals(flowStatus)){
                flowStatus="正常流转";
            }else if("1".equals(flowStatus)){
                flowStatus="回退";
            }
            if("1".equals(nodeStatus)){
                nodeStatus="待处理";
            }else if("2".equals(nodeStatus)){
                nodeStatus="正在处理";
            }else if("3".equals(nodeStatus)){
                nodeStatus="已处理未提交";
            }else if("4".equals(nodeStatus)){
                nodeStatus="已提交";
            }else if ("0".equals(nodeStatus)){
                nodeStatus="已关闭";
            }
            String deptName = list.get(i).element("deptName").getTextTrim();
            String opertorName = list.get(i).element("opertorName").getTextTrim();
            String businessNos = list.get(i).element("businessNo").getTextTrim();
            responseSwfNotionInfoDto.setFlowId(flowIds);
            responseSwfNotionInfoDto.setLogNo(logNos);
            responseSwfNotionInfoDto.setHandleText(handleText);
            responseSwfNotionInfoDto.setSubmitTime(submitTime);
            responseSwfNotionInfoDto.setNodeName(nodeName);
            responseSwfNotionInfoDto.setNodeStatus(nodeStatus);
            responseSwfNotionInfoDto.setFlowStatus(flowStatus);
            responseSwfNotionInfoDto.setDeptName(deptName);
            responseSwfNotionInfoDto.setOpertorName(opertorName);
            responseSwfNotionInfoDto.setBusinessNo(businessNos);
            responseSwfNotionInfoDto.setFlowInTime(flowInTime);
            responseSwfNotionInfoDtoList.add(responseSwfNotionInfoDto);
        }
        return responseSwfNotionInfoDtoList;
    }
}