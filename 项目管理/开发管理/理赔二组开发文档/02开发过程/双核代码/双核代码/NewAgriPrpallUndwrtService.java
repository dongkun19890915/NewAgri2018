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
 * ˫������ũ�նԽ�webService�ӿڣ��ṩԭ�б�ϵͳ����˫��jarʵ�ֵĹ���
 * @author ��ΰ��
 *
 */
public class NewAgriPrpallUndwrtService {
	
	private ReCaseXMLCommitDto reqBodyDto;
	/**
	 * �ύ�˱�����
	 * @param requestXML ����xml
	 * @return ҵ������
	 */
	public String underwriteSubmit(String requestXML) {
		XmlUtil xmlUtil = new XmlUtil();
		// ��xmlת����dto
		PacketDto<RequestUnderwriteSubmitDto> requestPacketDto = xmlUtil.xmlToPacketDto_bodyDto(requestXML,RequestUnderwriteSubmitDto.class);
		// ��ȡbody�ڵ�����
		RequestUnderwriteSubmitDto reqBodyDto = requestPacketDto.getBody();
		HeadDto resHead = new HeadDto();
		String flowId = "";// ҵ������
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		try {
			// �����ύ�˱�����������ȡҵ������
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
		// ����dto
		PacketDto<ResponseUnderwriteSubmitDto> responsePacketDto = new PacketDto<ResponseUnderwriteSubmitDto>();
		// ����dto��body�ڵ�
		ResponseUnderwriteSubmitDto resBodyDto = new ResponseUnderwriteSubmitDto();
		// head��Ϣ��д
		resHead.setUserCode(reqBodyDto.getUserCode());
		// ҵ�����Ÿ�ֵ
		resBodyDto.setFlowId(flowId);
		responsePacketDto.setHead(resHead);
		responsePacketDto.setBody(resBodyDto);
		// dtoת����xml
		String returnXML = xmlUtil.packetDtoToXml_bodyDto(responsePacketDto);
		return returnXML;
	}
	/**
	 * �ؿ��ⰸ�����ύ
	 * @param requestXML ����xml
	 * @return ������
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
	 * �����������ύ
	 * @param requestXML ����xml
	 * @return ������ flowId
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
	 * �����ⰸ�ύ
	 * @param requestXML ����xml
	 * @return ������ flowId
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
	 * ֧��¼���ύ˫��
	 * @param requestXML 
	 * @return ҵ������flowId
	 * @throws UserException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String claimPaySubmit(String requestXML) throws UserException, SQLException, Exception{
		XmlUtil xmlUtil = new XmlUtil();
		// ��xmlת����dto
		PacketDto<RequestUnderwriteSubmitDto> requestPacketDto = xmlUtil.xmlToPacketDto_bodyDto(requestXML,RequestUnderwriteSubmitDto.class);
		// ��ȡbody�ڵ�����
		RequestUnderwriteSubmitDto reqBodyDto = requestPacketDto.getBody();
		HeadDto resHead = new HeadDto();
		String flowId = "";// ҵ������
		BLTaskFacade blTaskFacade = new BLTaskFacade();
		try {
			// �����ύ���ⷽ��������ȡҵ������
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
		// ����dto
		PacketDto<ResponseUnderwriteSubmitDto> responsePacketDto = new PacketDto<ResponseUnderwriteSubmitDto>();
		// ����dto��body�ڵ�
		ResponseUnderwriteSubmitDto resBodyDto = new ResponseUnderwriteSubmitDto();
		// head��Ϣ��д
		resHead.setUserCode(reqBodyDto.getUserCode());
		// ҵ�����Ÿ�ֵ
		resBodyDto.setFlowId(flowId);
		responsePacketDto.setHead(resHead);
		responsePacketDto.setBody(resBodyDto);
		// dtoת����xml
		String returnXML = xmlUtil.packetDtoToXml_bodyDto(responsePacketDto);
		return returnXML;
	}
}