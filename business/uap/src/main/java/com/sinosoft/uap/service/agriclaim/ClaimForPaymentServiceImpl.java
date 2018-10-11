package com.sinosoft.uap.service.agriclaim;

import com.sinosoft.agriclaim.api.individuation.PrpLsumpayApi;
import com.sinosoft.agriclaim.api.individuation.dto.PayInfoBackDto;
import com.sinosoft.uap.dto.HeadResponseDto;
import com.sinosoft.uap.dto.ResultResponseDto;
import com.sinosoft.uap.utils.XmlResponseUtil;
import com.sinosoft.uap.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.jws.WebService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

//import com.sinosoft.framework.core.service.impl.BaseServiceImpl;

/**
 * @description 理赔提供收付服务接口
 * @author wangzhao
 * @date 2017年12月27日 上午11:02:36
 */
@WebService(serviceName = "claimForPaymentService",//服务名
            targetNamespace="http://agricliam.service.uap.sinosoft.com/",
            endpointInterface = "com.sinosoft.uap.service.agriclaim.ClaimForPaymentService")
@Component
public class ClaimForPaymentServiceImpl implements ClaimForPaymentService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimForPaymentServiceImpl.class);
	
	@Autowired
	PrpLsumpayApi prpLsumpayApi;
	/**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     */ 
	@Override
	public String payInfoBack(String xml) throws Exception {
		HeadResponseDto headResDto = new HeadResponseDto();
		ResultResponseDto resultResDto = new ResultResponseDto();
		XmlResponseUtil xmlResponseUtil = new XmlResponseUtil();
		LOGGER.error("ClaimForPaymentServiceImpl.payInfoBack的入参报文为：{}",xml);
		InputStream ins = new ByteArrayInputStream(xml.getBytes());
		Document document_head = XmlUtils.parse(ins);
		XmlUtils.getChildElements(document_head);
		InputStream in = new ByteArrayInputStream(xml.getBytes());
		Document document = XmlUtils.parse(in);
		String requestType = "";
		String requestSeqNo = "";
		String flowInTime = "";
		//业务类型
		String certiType = "";
		//计算书号
		String compensateNo = "";
		//理赔ID
		String acpaymentInfoId = "";
		//
		String certiId = "";
		//
		String uploadFileName = "";
		//立案号
		String claimNo = "";
		//备注
		String remark = "";
		//退回原因代码
		String backCode = "";
		//退回原因描述
		String backMessage = "";
		//预赔号
		String preparNo = "";
		//节点号
		String nodeType = "";
		//返回报文
		String returnXml = "";
		try {
			Node node_head = XmlUtils.getChildNodeByPath(document_head, "/REQUEST/HEAD");
			requestType = XmlUtils.getChildNodeValue(node_head, "REQUESTTYPE");
			requestSeqNo = XmlUtils.getChildNodeValue(node_head, "REQUESTSEQNO");
			flowInTime = XmlUtils.getChildNodeValue(node_head, "FLOWINTIME");
			System.out.println("reqSerialNo="+requestSeqNo);
			ins.close();
			Node node = XmlUtils.getChildNodeByPath(document, "/REQUEST/PAYMENTINFOLIST/PAYMENTINFO");		
			claimNo = XmlUtils.getChildNodeValue(node, "CLAIMNO");
			certiType = XmlUtils.getChildNodeValue(node, "CERTITYPE");
			compensateNo = XmlUtils.getChildNodeValue(node, "COMPENSATENO");
			acpaymentInfoId = XmlUtils.getChildNodeValue(node, "ACPAYMENTINFOID");
			remark = XmlUtils.getChildNodeValue(node, "REMARK");
			backCode = XmlUtils.getChildNodeValue(node, "BACKCODE");
			backMessage = XmlUtils.getChildNodeValue(node, "BACKMESSAGE");
			certiId = XmlUtils.getChildNodeValue(node, "CERTIID");
			uploadFileName = XmlUtils.getChildNodeValue(node, "UPLOADFILENAME");
			in.close();
			headResDto.setFlowInTime(flowInTime);
			headResDto.setRequestSeqNo(requestSeqNo);
			headResDto.setRequestType(requestType);
		} catch (Exception e) {
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("ClaimForPaymentServiceImpl.payInfoBack报文解析异常");
			}
			headResDto.setFlowInTime(flowInTime);
			headResDto.setRequestSeqNo(requestSeqNo);
			headResDto.setRequestType(requestType);
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo("请确认报文中数据是否正确");
			resultResDto.setErrorType("报文解析异常");			
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
			return returnXml;
		}
		if(StringUtils.isEmpty(certiType) || StringUtils.isEmpty(compensateNo) || StringUtils.isEmpty(acpaymentInfoId) || StringUtils.isEmpty(backCode) || StringUtils.isEmpty(backMessage) || StringUtils.isEmpty(certiId) || StringUtils.isEmpty(uploadFileName)){
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo("报文参数校验异常，请检查报文数据是否正确");
			resultResDto.setErrorType("服务端异常");
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
		}
		if("C".equals(certiType)){
			nodeType = "compp";
		}else if("Y".equals(certiType)){
			nodeType = "speci";
			preparNo = compensateNo;
			compensateNo = "";
		}else{
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo("支付信息退回失败，不支持的业务类型");
			resultResDto.setErrorType("服务端异常");			
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
			return returnXml;
		}
		PayInfoBackDto payInfoBackDto = new PayInfoBackDto();
		payInfoBackDto.setAcpaymentInfoId(acpaymentInfoId);
		payInfoBackDto.setBackCode(backCode);
		payInfoBackDto.setBackMessage(backMessage);
		payInfoBackDto.setCertiId(certiId);
		payInfoBackDto.setCertiType(certiType);
		payInfoBackDto.setClaimNo(claimNo);
		payInfoBackDto.setCompensateNo(compensateNo);
		payInfoBackDto.setNodeType(nodeType);
		payInfoBackDto.setPreparNo(preparNo);
		payInfoBackDto.setRemark(remark);
		payInfoBackDto.setUploadFileName(uploadFileName);
		try {
			prpLsumpayApi.payInfoBack(payInfoBackDto);
		} catch (Exception e) {
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo(e.getMessage());
			resultResDto.setErrorType("服务端异常");			
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
			return returnXml;
		}
		resultResDto.setResultType("0");
		returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
		return returnXml;
	}

}
