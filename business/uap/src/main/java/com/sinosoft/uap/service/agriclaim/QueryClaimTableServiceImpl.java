package com.sinosoft.uap.service.agriclaim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLCfeecoinsApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimLossApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLChargeApi;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLLossApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLLossDto;
import com.sinosoft.agriclaim.api.docmanage.PrpLCertifyCollectApi;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyCollectDto;
import com.sinosoft.agriclaim.api.endcasemanage.EndCaseApi;
import com.sinosoft.agriclaim.api.endcasemanage.PrpLCaseNoApi;
import com.sinosoft.agriclaim.api.endcasemanage.dto.EndCaseDto;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.agriclaim.api.individuation.PrpLsumpayApi;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayDto;
import com.sinosoft.agriclaim.api.prepaymanage.PrpLPrepayApi;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.recasemanage.PrpLRecaseApi;
import com.sinosoft.agriclaim.api.recasemanage.dto.PrpLRecaseDto;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.uap.dto.BodyRequestDto;
import com.sinosoft.uap.dto.HeadResponseDto;
import com.sinosoft.uap.dto.PacketRequestDto;
import com.sinosoft.uap.utils.XmlRequestUtil;

@WebService(serviceName = "queryClaimTableService",//服务名
			targetNamespace="http://agriclaim.service.uap.sinosoft.com",
			endpointInterface = "com.sinosoft.uap.service.agriclaim.QueryClaimTableService")
@Component
public class QueryClaimTableServiceImpl implements QueryClaimTableService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryClaimTableServiceImpl.class);
	
	@Autowired
	private PrpLClaimApi prpLclaimApi;
	@Autowired
	private PrpLCompensateApi prpLCompensateApi;
	@Autowired
	private PrpLPrepayApi prpLPrepayApi;
	@Autowired
	private PrpLRegistApi prpLRegistApi;
	@Autowired
	private PrpLCertifyCollectApi prpLCertifyCollectApi;
	@Autowired
	private PrpLRecaseApi prpLRecaseApi;
	@Autowired
	private PrpLCaseNoApi prpLCaseNoApi;
	@Autowired
	private PrpLsumpayApi prpLsumpayApi;
	@Autowired
	private EndCaseApi endCaseApi;
	@Autowired
	private PrpLCfeecoinsApi prpLCfeecoinsApi;
	@Autowired
	private PrpLLossApi prpLLossApi;
	@Autowired
	private PrpLChargeApi prpLchargeApi;
	@Autowired
	private PrpLClaimLossApi prpLClaimLossApi;
	
	public String getErrorReturnXml(String returnStatusCode,String returnMessage){
		//生成查询失败后的反参报文，Body部分必传，不然会报错，所以默认一个HeadResponseDto空对象。
    	HeadResponseDto headResponseDto = new HeadResponseDto();
        PacketDto<HeadResponseDto> packeDto = new PacketDto<HeadResponseDto>();
        HeadDto headDto = new HeadDto();
        headDto.setReturnMessage(returnMessage);
        headDto.setReturnStatusCode(returnStatusCode);
        packeDto.setBody(headResponseDto);
        packeDto.setHead(headDto);
        XmlUtil xmlUtil = new XmlUtil();
        String returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packeDto);
        return returnXml;
    }
	/**
     * @description 依据立案号查询立案基本信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLclaim(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLclaim的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String claimNo = packetReqDto.getBody().getClaimNo();
		if(claimNo==null || "".equals(claimNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLclaim报文校验异常，立案号码不能为空");
				return getErrorReturnXml("9999","立案号码不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			PrpLClaimDto prpClaimDto = null;
			prpClaimDto = prpLclaimApi.queryByPK(claimNo);
			if(prpClaimDto == null){
				prpClaimDto = new PrpLClaimDto();
			}
			PacketDto<PrpLClaimDto> packetDto = new PacketDto<PrpLClaimDto>();
			packetDto.setBody(prpClaimDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			// TODO: handle exception
			return getErrorReturnXml("9999",e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 依据赔款计算书号码查询赔款计算书信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLcompensate(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcompensate的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		
		String compensateNo = packetReqDto.getBody().getCompensateNo();
		String claimNo = packetReqDto.getBody().getClaimNo();
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		List<PrpLCompensateDto> prpCompensateDtoList = new ArrayList<PrpLCompensateDto>();
		PrpLCompensateDto prpLCompensateDto = null;
		try {
			if(("".equals(compensateNo) || compensateNo == null) && !"".equals(claimNo)){//根据立案号查询
				prpCompensateDtoList = prpLCompensateApi.queryClaimNo(claimNo);
			}else if(!"".equals(compensateNo)){//根据主键查询
				prpLCompensateDto = prpLCompensateApi.queryByPK(compensateNo);
				if(prpLCompensateDto!=null){
					prpCompensateDtoList.add(prpLCompensateDto);
				}
			}else{
				return getErrorReturnXml("9999","传输数据有误！");
			}
			PacketDto<List<PrpLCompensateDto>> packetDto = new PacketDto<List<PrpLCompensateDto>>();
			packetDto.setBody(prpCompensateDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packetDto, PrpLCompensateDto.class, "PrpLCompensateDto");
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 依据预赔号查询预付信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日queryPrpLcompensate
     */
	@Override
	public String queryPrpLprepay(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLprepay的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String preCompensateNo = packetReqDto.getBody().getPreCompensateNo();
		if(preCompensateNo == null || "".equals(preCompensateNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLprepay报文校验异常，预赔号不能为空");
				return getErrorReturnXml("9999","预赔号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			PrpLPrepayDto prpLPrepayDto = null;
			prpLPrepayDto = prpLPrepayApi.queryByPK(preCompensateNo);
			if(prpLPrepayDto == null){
				prpLPrepayDto = new PrpLPrepayDto();
			}
			PacketDto<PrpLPrepayDto> packetDto = new PacketDto<PrpLPrepayDto>();
			packetDto.setBody(prpLPrepayDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 依据报案号码查询报案信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLregist(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLregist的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String registNo = packetReqDto.getBody().getRegistNo();
		if(registNo == null || "".equals(registNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLregist报文校验异常，报案号码不能为空");
				return getErrorReturnXml("9999","报案号码不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			PrpLRegistDto prpLRegistDto = null;
			prpLRegistDto = prpLRegistApi.queryByPK(registNo);
			if(prpLRegistDto == null){
				prpLRegistDto = new PrpLRegistDto();
			}
			PacketDto<PrpLRegistDto> packetDto = new PacketDto<PrpLRegistDto>();
			packetDto.setBody(prpLRegistDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	 /**
     * @description 依据业务号码和标的号码查询单证收集信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLcertifyCollect(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcertifyCollect的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String businessNo = packetReqDto.getBody().getBusinessNo();
		String lossItemCode = packetReqDto.getBody().getLossItemCode();
		if(businessNo == null || "".equals(businessNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcertifyCollect报文校验异常，业务号码不能为空");
				return getErrorReturnXml("9999","业务号码不能为空");
			}
		}
		if(lossItemCode == null || "".equals(lossItemCode)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcertifyCollect报文校验异常，标的号码不能为空");
				return getErrorReturnXml("9999","标的号码不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			PrpLCertifyCollectDto prpLCertifyCollectDto = null;
			prpLCertifyCollectDto = prpLCertifyCollectApi.queryByPK(businessNo, lossItemCode);
			if(prpLCertifyCollectDto == null){
				
				prpLCertifyCollectDto = new PrpLCertifyCollectDto();
			}
			PacketDto<PrpLCertifyCollectDto> packetDto = new PacketDto<PrpLCertifyCollectDto>();
			packetDto.setBody(prpLCertifyCollectDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 依据立案号码查询重开赔案信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLrecase(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLrecase的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String claimNo = packetReqDto.getBody().getClaimNo();
		if(claimNo == null || "".equals(claimNo)){
			
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLrecase报文校验异常，立案号码不能为空");
				return getErrorReturnXml("9999","立案号码不能为空");
			}
		}
		String serialNo = packetReqDto.getBody().getSerialNo();
		List<PrpLRecaseDto> prpLRecaseDtoList = new ArrayList<PrpLRecaseDto>();
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			//根据立案号查询
			if(serialNo == null || "".equals(serialNo)){
				Map<String, String> map = new HashMap<String, String>();
				map.put("claimNo", claimNo);
				prpLRecaseDtoList = prpLRecaseApi.queryByClaimNo(map);
			}
			//根据主键查询
			else{
				PrpLRecaseDto prpLRecaseDto = prpLRecaseApi.queryByPK(claimNo, Integer.parseInt(serialNo));
				if(prpLRecaseDto!=null){
					prpLRecaseDtoList.add(prpLRecaseDto);
				}
			}
			PacketDto<List<PrpLRecaseDto>> packetDto = new PacketDto<List<PrpLRecaseDto>>();
			packetDto.setBody(prpLRecaseDtoList);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packetDto, PrpLRecaseDto.class, "PrpLRecaseDto");
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 依据单证号，单证类型，结案号查询赔案号信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLcaseNo(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcaseNo的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil requestUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = requestUtil.xmlToPacketDto_bodyDto(xml, BodyRequestDto.class);
		String caseNo = packetReqDto.getBody().getCaseNo();
		String certiNo = packetReqDto.getBody().getCertiNo();
		String certiType = packetReqDto.getBody().getCertiType();
		if(caseNo == null || "".equals(caseNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcaseNo报文校验异常，立案号码不能为空");
				return getErrorReturnXml("9999","结案号不能为空");
			}
		}
		if(certiNo == null || "".equals(certiNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcaseNo报文校验异常，立案号码不能为空");
				return getErrorReturnXml("9999","单证号不能为空");
			}
		}
		if(certiType == null || "".equals(certiType)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcaseNo报文校验异常，立案号码不能为空");
				return getErrorReturnXml("9999","单证类型不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			PrpLCaseNoDto prpLCaseNoDto = null;
			prpLCaseNoDto = prpLCaseNoApi.queryByPK(certiNo, certiType, caseNo);
			if(prpLCaseNoDto == null){
				prpLCaseNoDto = new PrpLCaseNoDto();
			}
			PacketDto<PrpLCaseNoDto> packetDto = new PacketDto<PrpLCaseNoDto>();
			packetDto.setBody(prpLCaseNoDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
		}
	
	/**
     * @description 依据预赔号，是否申请例外标志，启动例外标志查询账户信息表信息
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017年11月28日
     */
	@Override
	public String queryPrpLsumpay(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLsumpay的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		
		String preparNo = packetReqDto.getBody().getPreparNo();
		String exceptionFlag = packetReqDto.getBody().getExceptionFlag();
		String exceptionStartFlag = packetReqDto.getBody().getExceptionStartFlag();
		String compensateNo = packetReqDto.getBody().getCompensateNo();
		
		if(StringUtils.isEmpty(exceptionFlag)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLsumpay报文校验异常，异常标记不能为空");
				return getErrorReturnXml("9999","异常标记不能为空");
			}
		}
		if(StringUtils.isEmpty(exceptionStartFlag)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLsumpay报文校验异常，异常开始标记不能为空");
				return getErrorReturnXml("9999","异常开始标记不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		List<PrpLsumpayDto> prpLsumpayDtoList = null;
		try {
			
			PrpLsumpayDto prpLsumpayDto = new PrpLsumpayDto();
			if(!StringUtils.isEmpty(preparNo)){
				compensateNo = "";
				prpLsumpayDtoList = prpLsumpayApi.queryByPreparNoAndExceptionFlagAndExceptionStartFlag(preparNo,exceptionFlag,exceptionStartFlag,compensateNo);
			}else if(!StringUtils.isEmpty(compensateNo)){
				prpLsumpayDtoList = prpLsumpayApi.queryByPreparNoAndExceptionFlagAndExceptionStartFlag(preparNo,exceptionFlag,exceptionStartFlag,compensateNo);
			}else{
				return getErrorReturnXml("9999","预赔号计算书号不能都为空");
			}
			if(prpLsumpayDtoList == null){
				
				prpLsumpayDtoList = new ArrayList<PrpLsumpayDto>();
			}
			PacketDto<List<PrpLsumpayDto>> packeDto = new PacketDto<List<PrpLsumpayDto>>();
			packeDto.setBody(prpLsumpayDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packeDto, PrpLsumpayDto.class, "PrpLsumpayDto");
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	@Override
	public String queryEndCase(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryEndCase的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String claimNo = packetReqDto.getBody().getClaimNo();
		if(StringUtils.isEmpty(claimNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryEndCase报文校验异常，立案号不能为空");
				return getErrorReturnXml("9999","立案号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		try {
			EndCaseDto endCaseDto = null;
			endCaseDto = endCaseApi.findByClaimNo(claimNo);
			if(endCaseDto == null){
				endCaseDto = new EndCaseDto();
			}
			PacketDto<EndCaseDto> packetDto = new PacketDto<EndCaseDto>();
			packetDto.setBody(endCaseDto);
			returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyDto(packetDto);
		} catch (Exception e) {
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 共保费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	@Override
	public String queryPrpLcfeecoins(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcfeecoins的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","业务号不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String businessNo = packetReqDto.getBody().getBusinessNo();
		if(StringUtils.isEmpty(businessNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcfeecoins报文校验异常，业务号不能为空");
				return getErrorReturnXml("9999","业务号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		List<PrpLCfeecoinsDto> prpLcfeecoinsDtoList = new ArrayList<PrpLCfeecoinsDto>();
		try {
			prpLcfeecoinsDtoList = prpLCfeecoinsApi.queryByBusinessNo(businessNo);
			
			PacketDto<List<PrpLCfeecoinsDto>> packeDto = new PacketDto<List<PrpLCfeecoinsDto>>();
			packeDto.setBody(prpLcfeecoinsDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packeDto, PrpLCfeecoinsDto.class, "PrpLCfeecoinsDto");
		} catch (Exception e) {
			
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 赔付标的信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	@Override
	public String queryPrpLloss(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLloss的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","业务号不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String businessNo = packetReqDto.getBody().getBusinessNo();
		if(StringUtils.isEmpty(businessNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLloss报文校验异常，业务号不能为空");
				return getErrorReturnXml("9999","业务号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		List<PrpLLossDto> prpLlossDtoList = new ArrayList<PrpLLossDto>(); 
		try {
			prpLlossDtoList = prpLLossApi.queryByBusinessNo(businessNo);
			PacketDto<List<PrpLLossDto>> packeDto = new PacketDto<List<PrpLLossDto>>();
			packeDto.setBody(prpLlossDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packeDto, PrpLLossDto.class, "PrpLLossDto");
		} catch (Exception e) {
			
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
	/**
     * @description 赔款费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	@Override
	public String queryPrpLcharge(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcharge的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","业务号不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String businessNo = packetReqDto.getBody().getBusinessNo();
		if(StringUtils.isEmpty(businessNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLcharge报文校验异常，业务号不能为空");
				return getErrorReturnXml("9999","业务号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		List<PrpLChargeDto> prpLChargeDtoList = new ArrayList<PrpLChargeDto>(); 
		try {
			prpLChargeDtoList = prpLchargeApi.queryByBusinessNo(businessNo);
			PacketDto<List<PrpLChargeDto>> packeDto = new PacketDto<List<PrpLChargeDto>>();
			packeDto.setBody(prpLChargeDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packeDto, PrpLChargeDto.class, "PrpLChargeDto");
		} catch (Exception e) {
			
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	/**
     * @description 立案险别估损金额表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
	@Override
	public String queryPrpLclaimLoss(String xml) throws Exception {
		LOGGER.error("QueryClaimTableServiceImpl.queryPrpLclaimLoss的入参报文为：{}",xml);
		if(StringUtils.isEmpty(xml)){
        	return getErrorReturnXml("9999","入参报文不能为空");
		}
		XmlRequestUtil xmlReqUtil = new XmlRequestUtil();
		PacketRequestDto<BodyRequestDto> packetReqDto = xmlReqUtil.xmlToPacketDto_bodyDto(xml,BodyRequestDto.class);
		String claimNo = packetReqDto.getBody().getClaimNo();
		if(StringUtils.isEmpty(claimNo)){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("QueryClaimTableServiceImpl.queryPrpLclaimLoss报文校验异常，立案号不能为空");
				return getErrorReturnXml("9999","业务号不能为空");
			}
		}
		String returnXml = "";
		XmlUtil xmlUtil = new XmlUtil();
		Map<String, String> map = new HashMap<String, String>();
		map.put("claimNo", claimNo);
		List<PrpLClaimLossDto> prpLClaimLossDtoList = new ArrayList<PrpLClaimLossDto>(); 
		try {
			prpLClaimLossDtoList = prpLClaimLossApi.queryByClaimNo(map);
			PacketDto<List<PrpLClaimLossDto>> packeDto = new PacketDto<List<PrpLClaimLossDto>>();
			packeDto.setBody(prpLClaimLossDtoList);
			returnXml ="<?xml version=\"1.0\" encoding=\"GBK\"?>" + xmlUtil.packetDtoToXml_bodyList(packeDto, PrpLClaimLossDto.class, "PrpLClaimLossDto");
		} catch (Exception e) {
			
			return getErrorReturnXml("9999", e.getMessage());
		}
		return returnXml;
	}
	
}























