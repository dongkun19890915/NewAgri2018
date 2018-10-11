package com.sinosoft.uap.service;

import com.sinosoft.agriclaim.api.claimmanage.ClaimApi;
import com.sinosoft.agriclaim.api.paymentmanage.PrplPayApi;
import com.sinosoft.agriclaim.api.recasemanage.PrpLRecaseApi;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.uap.dto.HeadResponseDto;
import com.sinosoft.uap.dto.ResultResponseDto;
import com.sinosoft.uap.utils.XmlResponseUtil;
import com.sinosoft.uap.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;

import javax.jws.WebService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * （双核回写重开赔案服务方法）
 * @author: 王志文
 * @date: 2017/12/2 11:45
 */
@WebService(serviceName = "underWriteReCaseService",//服务名
        targetNamespace="http://service.demo.uap.sinosoft.com/",
        endpointInterface = "com.sinosoft.uap.service.UnderWriteReCaseService")
@Component
public class UnderWriteReCaseServiceImpl implements UnderWriteReCaseService{
    @Autowired
    private PrpLRecaseApi prpLRecaseApi;
    @Autowired
    private ClaimApi claimApi;
    @Autowired
    private PrplPayApi prplPayApi;

    @Override
    public String saveCaseTypeByUndwrt(String xml) throws Exception {
        HeadResponseDto headResDto = new HeadResponseDto();
        ResultResponseDto resultResDto = new ResultResponseDto();
        XmlResponseUtil xmlResponseUtil = new XmlResponseUtil();
        InputStream ins = new ByteArrayInputStream(xml.getBytes());
        org.w3c.dom.Document document_head = XmlUtils.parse(ins);
        XmlUtils.getChildElements(document_head);
        InputStream in = new ByteArrayInputStream(xml.getBytes());
        org.w3c.dom.Document document = XmlUtils.parse(in);
        String certiType;
        String businessNo;
        String undwrtFlag;
        String flowId;
        String logNo;
        String notionInfo;
        String handlerCode;
        String nodeNo;
        String returnXml = "";
        try {
            Node node_head = XmlUtils.getChildNodeByPath(document_head, "/REQUEST/HEAD");
            ins.close();
            Node node = XmlUtils.getChildNodeByPath(document, "/REQUEST/ECHOINFO");
            certiType = XmlUtils.getChildNodeValue(node, "CERTITYPE");
            businessNo = XmlUtils.getChildNodeValue(node, "BUSINESSNO");
            undwrtFlag = XmlUtils.getChildNodeValue(node, "UNDERWRITEFLAG");
            flowId = XmlUtils.getChildNodeValue(node, "FLOWID");
            logNo = XmlUtils.getChildNodeValue(node, "LOGNO");
            notionInfo = XmlUtils.getChildNodeValue(node, "NOTIONINFO");
            handlerCode = XmlUtils.getChildNodeValue(node, "HANDLERCODE");
            nodeNo = XmlUtils.getChildNodeValue(node, "NODENO");
            in.close();
            UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto = new UndwrtWriteBackReCaseDto();
            undwrtWriteBackReCaseDto.setBusinessNo(businessNo);
            undwrtWriteBackReCaseDto.setHandlerCode(handlerCode);
            undwrtWriteBackReCaseDto.setLflowID(flowId);
            undwrtWriteBackReCaseDto.setLlogNo(Integer.parseInt(logNo));
            undwrtWriteBackReCaseDto.setNotionInfo(notionInfo);
            undwrtWriteBackReCaseDto.setUndwrtFlag(undwrtFlag);
            undwrtWriteBackReCaseDto.setNodeNo(nodeNo);
            if("B".equals(certiType)){
                //重开赔案审批
                prpLRecaseApi.saveCaseTypeByUndwrt(undwrtWriteBackReCaseDto);
            }else if ("O".equals(certiType)){
                //立案注销审批
                claimApi.saveCancelBackByUndwrt(undwrtWriteBackReCaseDto);
            }else if ("V".equals(certiType)){
                //支付审批
                prplPayApi.writeVeriPay(undwrtWriteBackReCaseDto);
            }
            resultResDto.setResultType("0");
            returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
        } catch (Exception e) {
            resultResDto.setResultType("1");
            resultResDto.setErrorInfo(e.getMessage());
            resultResDto.setErrorType("服务端异常");
            returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
        }
        return returnXml;
    }
}
