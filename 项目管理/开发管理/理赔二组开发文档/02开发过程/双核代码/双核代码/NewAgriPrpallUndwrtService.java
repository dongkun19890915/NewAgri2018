package com.sinosoft.newagriprpall.webservice.service;

import java.sql.SQLException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sinosoft.newagriprpall.webservice.dto.CompensateSubmitUndwrtXMLDto;
import com.sinosoft.newagriprpall.webservice.dto.PaymentStatisticsInDto;
import com.sinosoft.newagriprpall.webservice.dto.ReCaseXMLCommitDto;
import com.sinosoft.newagriprpall.webservice.dto.RequestUnderwriteSubmitDto;
import com.sinosoft.newagriprpall.webservice.dto.ResponseUnderwriteSubmitDto;
import com.sinosoft.newagriprpall.webservice.xmlutil.HeadDto;
import com.sinosoft.newagriprpall.webservice.xmlutil.PacketDto;
import com.sinosoft.newagriprpall.webservice.xmlutil.XmlUtil;
import com.sinosoft.undwrt.bl.facade.BLTaskFacade;
import com.sinosoft.utility.error.UserException;

/**
 * 双核与新农险对接webService接口，提供原承保系统调用双核jar实现的功能
 * @author 何伟东
 *
 */
public class NewAgriPrpallUndwrtService {
	
	private ReCaseXMLCommitDto reqBodyDto;
	/**
	 * 提交核保功能
	 * @param requestXML 请求xml
	 * @return 业务流号
	 */
	public String underwriteSubmit(String requestXML) {
		XmlUtil xmlUtil = new XmlUtil();
		// 将xml转换成dto
		PacketDto<RequestUnderwriteSubmitDto> requestPacketDto = xmlUtil.xmlToPacketDto_bodyDto(requestXML,RequestUnderwriteSubmitDto.class);
		// 获取body节点内容
		RequestUnderwriteSubmitDto reqBodyDto = requestPacketDto.getBody();
		HeadDto resHead = new HeadDto();
		String flowId = "";// 业务流号
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		try {
			// 调用提交核保方法，并获取业务流号
			flowId = blTaskFacade.start(reqBodyDto.getModelType(), reqBodyDto.getCertiType(), reqBodyDto.getBusinessNo(),
					reqBodyDto.getRiskCode(), reqBodyDto.getClassCode(), reqBodyDto.getComCode(), reqBodyDto.getMakecom(), reqBodyDto.getUserCode(),
					reqBodyDto.getHandlerCode(), reqBodyDto.getHandler1Code(), reqBodyDto.getContractNo());
		} catch (UserException e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getErrorMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getMessage());
			e.printStackTrace();
		}
		// 返回dto
		PacketDto<ResponseUnderwriteSubmitDto> responsePacketDto = new PacketDto<ResponseUnderwriteSubmitDto>();
		// 返回dto的body节点
		ResponseUnderwriteSubmitDto resBodyDto = new ResponseUnderwriteSubmitDto();
		// head信息填写
		resHead.setUserCode(reqBodyDto.getUserCode());
		// 业务流号赋值
		resBodyDto.setFlowId(flowId);
		responsePacketDto.setHead(resHead);
		responsePacketDto.setBody(resBodyDto);
		// dto转换成xml
		String returnXML = xmlUtil.packetDtoToXml_bodyDto(responsePacketDto);
		return returnXML;
	}
	/**
	 * 重开赔案申请提交
	 * @param requestXML 请求xml
	 * @return 申请结果
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws UserException 
	 */
	public String reCaseSubmit(String requestXML) throws UserException, SQLException, Exception {
//		XmlUtil xmlUtil = new XmlUtil();
//		PacketDto<ReCaseXMLCommitDto> packetDto = xmlUtil.xmlToPacketDto_bodyDto(requestXML, ReCaseXMLCommitDto.class);
//		ReCaseXMLCommitDto reCaseCommittedDto = packetDto.getBody();
		
		Document document = DocumentHelper.parseText(requestXML);
		Element requestData =document.getRootElement();
		Element startData = requestData.element("body");
		String modelType = startData.element("modelType").getTextTrim();
		String certiType = startData.element("certiType").getTextTrim();
		String businessNo = startData.element("businessNo").getTextTrim();
		String riskCode = startData.element("riskCode").getTextTrim();
		String classCode = startData.element("classCode").getTextTrim();
		String comCode = startData.element("comCode").getTextTrim();
		String makeCom = startData.element("makeCom").getTextTrim();
		String userCode = startData.element("userCode").getTextTrim();
		String handlerCode = startData.element("handlerCode").getTextTrim();
		String handler1Code = startData.element("handler1Code").getTextTrim();
		String contractNo = startData.element("contractNo").getTextTrim();
		
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		String flowId = blTaskFacade.startApproval(modelType,certiType,businessNo,
				riskCode,classCode,comCode,makeCom,
				userCode,handlerCode,handler1Code,contractNo);
		
		String returnXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><returnData>";
		returnXml += "<flowId>" + flowId+" </flowId>";
		returnXml += "</returnData>";
		System.out.println(returnXml.replaceAll("><",">\r\n<"));
		return  returnXml;
	}
	
	/**
	 * 理算书申请提交
	 * @param requestXML 请求xml
	 * @return 申请结果 flowId
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws UserException 
	 */
	public String compensateSubmit(String requestXML)throws UserException, SQLException, Exception {
		Document document = DocumentHelper.parseText(requestXML);
		Element requestData =document.getRootElement();
		Element startData = requestData.element("body");
		String LflowID = startData.element("lFlowID").getTextTrim();
		int LlogNo = Integer.parseInt(startData.element("lLogNo").getTextTrim());
		String modelType = startData.element("modelType").getTextTrim();
		String certiType = startData.element("certiType").getTextTrim();
		String businessNo = startData.element("businessNo").getTextTrim();
		String riskCode = startData.element("riskCode").getTextTrim();
		String classCode = startData.element("classCode").getTextTrim();
		String comCode = startData.element("comCode").getTextTrim();
		String handlerCode = startData.element("handlerCode").getTextTrim();
		String makecom = startData.element("makecom").getTextTrim();
		String userCode = startData.element("userCode").getTextTrim();
		String handler1Code = startData.element("handler1Code").getTextTrim();
		String contractNo = startData.element("contractNo").getTextTrim();
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		String flowId = blTaskFacade.start(LflowID, LlogNo, modelType, certiType, 
				businessNo, riskCode, classCode, comCode, makecom, userCode, handlerCode,
				handler1Code, contractNo,"");
		
		String returnXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><returnData>";
		returnXml += "<flowId>" +flowId+" </flowId>";
		returnXml += "</returnData>";
		System.out.println(returnXml.replaceAll("><",">\r\n<"));
		return  returnXml;
	}
	
	/**
	 * 特殊赔案提交
	 * @param requestXML 请求xml
	 * @return 申请结果 flowId
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws UserException 
	 */
	public String prepaySubmit(String requestXML)throws UserException, SQLException, Exception {
		Document document = DocumentHelper.parseText(requestXML);
		Element requestData =document.getRootElement();
		Element startData = requestData.element("body");
		String LflowID = startData.element("lFlowId").getTextTrim();
		int LlogNo = Integer.parseInt(startData.element("lLogNo").getTextTrim());
		String modelType = startData.element("modelType").getTextTrim();
		String certiType = startData.element("certiType").getTextTrim();
		String businessNo = startData.element("businessNo").getTextTrim();
		String riskCode = startData.element("riskCode").getTextTrim();
		String classCode = startData.element("classCode").getTextTrim();
		String comCode = startData.element("comCode").getTextTrim();
		String handlerCode = startData.element("handlerCode").getTextTrim();
		String makecom = startData.element("makecom").getTextTrim();
		String userCode = startData.element("userCode").getTextTrim();
		String handler1Code = startData.element("handler1Code").getTextTrim();
		String contractNo = startData.element("contractNo").getTextTrim();
		String flag = startData.element("flag").getTextTrim();
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		String flowId = blTaskFacade.start(LflowID, LlogNo, modelType, certiType, 
				businessNo, riskCode, classCode, comCode, makecom, userCode, handlerCode,
				handler1Code, "",flag);
		
		String returnXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><returnData>";
		returnXml += "<flowId>" +flowId+" </flowId>";
		returnXml += "</returnData>";
		System.out.println(returnXml.replaceAll("><",">\r\n<"));
		return  returnXml;
	}
	
	/**
	 * 支付录入提交双核
	 * @param requestXML 
	 * @return 业务流程flowId
	 * @throws UserException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String claimPaySubmit(String requestXML) throws UserException, SQLException, Exception{
		XmlUtil xmlUtil = new XmlUtil();
		// 将xml转换成dto
		PacketDto<RequestUnderwriteSubmitDto> requestPacketDto = xmlUtil.xmlToPacketDto_bodyDto(requestXML,RequestUnderwriteSubmitDto.class);
		// 获取body节点内容
		RequestUnderwriteSubmitDto reqBodyDto = requestPacketDto.getBody();
		HeadDto resHead = new HeadDto();
		String flowId = "";// 业务流号
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		try {
			// 调用提交核赔方法，并获取业务流号
			flowId =blTaskFacade.startApproval(reqBodyDto.getLflowID(),Integer.valueOf(reqBodyDto.getLlogNo()),reqBodyDto.getModelType(),reqBodyDto.getCertiType(),reqBodyDto.getBusinessNo(),
					reqBodyDto.getRiskCode(),reqBodyDto.getClassCode(),reqBodyDto.getComCode(),reqBodyDto.getMakecom(),reqBodyDto.getUserCode(),reqBodyDto.getHandlerCode(),reqBodyDto.getHandler1Code(),"","claim");
		} catch (UserException e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getErrorMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			resHead.setReturnStatusCode("9999");
			resHead.setReturnMessage(e.getMessage());
			e.printStackTrace();
		}
		// 返回dto
		PacketDto<ResponseUnderwriteSubmitDto> responsePacketDto = new PacketDto<ResponseUnderwriteSubmitDto>();
		// 返回dto的body节点
		ResponseUnderwriteSubmitDto resBodyDto = new ResponseUnderwriteSubmitDto();
		// head信息填写
		resHead.setUserCode(reqBodyDto.getUserCode());
		// 业务流号赋值
		resBodyDto.setFlowId(flowId);
		responsePacketDto.setHead(resHead);
		responsePacketDto.setBody(resBodyDto);
		// dto转换成xml
		String returnXML = xmlUtil.packetDtoToXml_bodyDto(responsePacketDto);
		return returnXML;
	}
}