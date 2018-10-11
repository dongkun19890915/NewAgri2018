package com.sinosoft.uap.utils;

import org.springframework.util.StringUtils;

import com.sinosoft.uap.dto.HeadResponseDto;
import com.sinosoft.uap.dto.ResultResponseDto;

public class XmlResponseUtil {

	private String LINE_GROUP = "\r\n";
	
	/**
     * 生成反参报文
     * @param headResDto 报文头对象
     * @param resultResDto 报文体对象
     * @return xml 反参报文
     */
	public String encode(HeadResponseDto headResDto,ResultResponseDto resultResDto)throws Exception {
		StringBuffer xmlBuffer = new StringBuffer();
		StringBuffer xmlHead = new StringBuffer(500);
		String xmlHeadInfo = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
		xmlHead.append(xmlHeadInfo);
		try {
			xmlBuffer.append(xmlHead.toString()).append(LINE_GROUP);
			xmlBuffer.append("<RESPONSE>").append(LINE_GROUP);
			xmlBuffer.append("<HEAD>").append(LINE_GROUP);
			
			xmlBuffer.append("<REQUESTTYPE>"+ headResDto.getRequestType() + "</REQUESTTYPE>").append(LINE_GROUP);
			xmlBuffer.append("<REQUESTSEQNO>" + headResDto.getRequestSeqNo() + "</REQUESTSEQNO>").append(LINE_GROUP);
			xmlBuffer.append("<FLOWINTIME>" + headResDto.getFlowInTime() + "</FLOWINTIME>").append(LINE_GROUP);
			
			xmlBuffer.append("</HEAD>").append(LINE_GROUP);
			xmlBuffer.append("<RESULT>").append(LINE_GROUP);
			 
			xmlBuffer.append("<RESULTTYPE>" + resultResDto.getResultType() + "</RESULTTYPE>").append(LINE_GROUP);
			xmlBuffer.append("<ERRORTYPE>" + resultResDto.getErrorType() + "</ERRORTYPE>").append(LINE_GROUP);
			xmlBuffer.append("<ERRORINFO>" + resultResDto.getErrorInfo() + "</ERRORINFO>").append(LINE_GROUP);
			if(!StringUtils.isEmpty(resultResDto.getConfigValue())){
				xmlBuffer.append("<CONFIGVALUE>" + resultResDto.getConfigValue() + "</CONFIGVALUE>").append(LINE_GROUP);
			}
			if(!StringUtils.isEmpty(resultResDto.getCertiNo())){
				xmlBuffer.append("<CERTINO>" + resultResDto.getCertiNo() + "</CERTINO>").append(LINE_GROUP);
			}
			if(!StringUtils.isEmpty(resultResDto.getInfoLogText())){
				xmlBuffer.append("<INFOLOGTEXT>" + resultResDto.getInfoLogText() + "</INFOLOGTEXT>").append(LINE_GROUP);
			}
			if(!StringUtils.isEmpty(resultResDto.getEndorseNo())){
				xmlBuffer.append("<ENDORSENO>" + resultResDto.getEndorseNo() + "</ENDORSENO>").append(LINE_GROUP);
			}
		    xmlBuffer.append("</RESULT>").append(LINE_GROUP);
		    xmlBuffer.append("</RESPONSE>").append(LINE_GROUP);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		String xml = xmlBuffer.toString();
		return xml;
	}
}
