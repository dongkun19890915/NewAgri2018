package com.sinosoft.uap.service.agriclaim;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.individuation.UndwrtInfoClaimApi;
import com.sinosoft.agriclaim.api.individuation.dto.UndwrtInfoClaimDto;
import com.sinosoft.agriclaim.api.prepaymanage.PrpLPrepayApi;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.uap.dto.HeadResponseDto;
import com.sinosoft.uap.dto.ResultResponseDto;
import com.sinosoft.uap.utils.XmlResponseUtil;
import com.sinosoft.uap.utils.XmlUtils;

/**
 * @description 理赔提供双核服务接口
 * @author wangzhao
 * @date 2017年12月27日 上午11:10:11
 */
@WebService(serviceName = "claimForUndwrtService",//服务名
            targetNamespace="http://agricliam.service.uap.sinosoft.com/",
            endpointInterface = "com.sinosoft.uap.service.agriclaim.ClaimForUndwrtService")
@Component
public class ClaimForUndwrtServiceImpl implements ClaimForUndwrtService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimForUndwrtServiceImpl.class);
	
	@Autowired
	PrpLPrepayApi prpLPrepayApi;
	@Autowired
	PrpLCompensateApi prpLCompensateApi;
	@Autowired
	UndwrtInfoClaimApi undwrtInfoClaimApi;
	/**
     * @description 预赔登记表，或赔款计算书表回写underWriteFlag
     * @author 汪钊
     * @date 2017年12月27日 上午11:10:28
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     */ 
	@Override
	public String echoUnderWriteFlag(String xml) throws Exception {
		HeadResponseDto headResDto = new HeadResponseDto();
		ResultResponseDto resultResDto = new ResultResponseDto();
		XmlResponseUtil xmlResponseUtil = new XmlResponseUtil();
		LOGGER.error("ClaimForUndwrtServiceImpl.echoUnderWriteFlag的入参报文为：{}",xml);
		InputStream ins = new ByteArrayInputStream(xml.getBytes());
		Document document_head = XmlUtils.parse(ins);
		XmlUtils.getChildElements(document_head);
		InputStream in = new ByteArrayInputStream(xml.getBytes());
		Document document = XmlUtils.parse(in);
		String requestType = "";
		String requestSeqNo = "";
		String flowInTime = "";
		String certiType = "";
		String businessNo = "";
		String underWriteFlag = "";
		String flowId="";
		String logNo="";
		String notionInfo="";
		String handlerCode="";
		String nodeNo="";
		String returnXml = "";
		UndwrtInfoClaimDto UndwrtInfoClaimDto=new UndwrtInfoClaimDto();
		try {
			Node node_head = XmlUtils.getChildNodeByPath(document_head, "/REQUEST/HEAD");
			requestType = XmlUtils.getChildNodeValue(node_head, "REQUESTTYPE");
			requestSeqNo = XmlUtils.getChildNodeValue(node_head, "REQUESTSEQNO");
			flowInTime = XmlUtils.getChildNodeValue(node_head, "FLOWINTIME");
			ins.close();
			Node node = XmlUtils.getChildNodeByPath(document, "/REQUEST/ECHOINFO");		
			certiType = XmlUtils.getChildNodeValue(node, "CERTITYPE");
			businessNo = XmlUtils.getChildNodeValue(node, "BUSINESSNO");
			underWriteFlag = XmlUtils.getChildNodeValue(node, "UNDERWRITEFLAG");
			flowId = XmlUtils.getChildNodeValue(node, "FLOWID");
			logNo= XmlUtils.getChildNodeValue(node, "LOGNO");
			notionInfo= XmlUtils.getChildNodeValue(node, "NOTIONINFO");
			handlerCode= XmlUtils.getChildNodeValue(node, "HANDLERCODE");
			nodeNo= XmlUtils.getChildNodeValue(node, "NODENO");
			in.close();		
			UndwrtInfoClaimDto.setRequestType(requestType);
			UndwrtInfoClaimDto.setRequestSeqNo(requestSeqNo);
			UndwrtInfoClaimDto.setFlowinTime(new DateTime(flowInTime));
			UndwrtInfoClaimDto.setCertiType(certiType);
			UndwrtInfoClaimDto.setBusinessNo(businessNo);
			UndwrtInfoClaimDto.setUndwrtWriteFlag(underWriteFlag);
			UndwrtInfoClaimDto.setFlowId(flowId);
			UndwrtInfoClaimDto.setLogNo(logNo);
			UndwrtInfoClaimDto.setNitionInfo(notionInfo);
			UndwrtInfoClaimDto.setHandlerCode(handlerCode);
			UndwrtInfoClaimDto.setNodeNo(nodeNo);			
		} catch (Exception e) {
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("ClaimForUndwrtServiceImpl.echoUnderWriteFlag报文解析异常");
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
		if(StringUtils.isEmpty(certiType) || StringUtils.isEmpty(businessNo) || StringUtils.isEmpty(underWriteFlag)){
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo("报文参数校验异常，请检查报文数据是否正确");
			resultResDto.setErrorType("服务端异常");
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
		}
		try {
			if("1".equals(underWriteFlag)||"0".equals(underWriteFlag)){
				undwrtInfoClaimApi.checkPass(UndwrtInfoClaimDto);
				
			}
			/*if("C".equals(certiType)){
				PrpLCompensateDto prpLCompensateDto = prpLCompensateApi.queryByPK(businessNo);
				prpLCompensateDto.setUnderWriteFlag(underWriteFlag);
				prpLCompensateApi.modify(prpLCompensateDto);
			}
			if("Y".equals(certiType)){
				PrpLPrepayDto prpLPrepayDto = prpLPrepayApi.queryByPK(businessNo);
				prpLPrepayDto.setUnderWriteFlag(underWriteFlag);
				prpLPrepayApi.modify(prpLPrepayDto);
			}*/
			//jiaoyunzhen 封装返回报文前进行判断，在C中调用Service方法，返回int值判断是否正常的完成流程
			
			resultResDto.setResultType("0");
		    //调用封装报文的工具类
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
		} catch (Exception e) {
			resultResDto.setResultType("1");
			resultResDto.setErrorInfo(e.getMessage());
			resultResDto.setErrorType("服务端异常");
			returnXml = xmlResponseUtil.encode(headResDto, resultResDto);
		}
		System.out.println(returnXml);
		return returnXml;
	}
}
