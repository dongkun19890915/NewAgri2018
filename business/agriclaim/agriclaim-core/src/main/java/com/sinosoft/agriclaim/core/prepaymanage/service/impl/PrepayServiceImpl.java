package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimKey;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPreChargeDao;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPtextDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPreCharge;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepayKey;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPtext;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrepayService;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNotionDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.impl.WorkFlowServiceImpl;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDriskConfigApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.txnlist.api.claiminsurancelist.SpecCaseListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.SpecCaseListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.SettleMainListApi;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 特殊赔案业务实现类
 * @author 杨航
 * @date 2017年11月14日
 */
@Service
public class PrepayServiceImpl extends BaseServiceImpl implements PrepayService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PrepayServiceImpl.class);

	@Autowired
	private PrpLPrepayDao prpLPrepayDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private PrpDriskApi prpDriskApi;
	@Autowired
	private PrpLClaimDao prpLClaimDao;
	@Autowired
	private BillNoApi billNoApi;
	@Autowired
	private PrpLclaimStatusDao prpLclaimStatusDao;
	@Autowired
	private PrpLPreChargeDao prpLPreChargeDao;
	@Autowired
	private PrpLPtextDao prpLPtextDao;
	@Autowired
	private WorkFlowServiceImpl workFlowServiceImpl;
	@Autowired
	private PrpDcompanyApi prpDcompanyApi;   
	@Autowired
    private SwfNotionDao swfNotionDao;
	@Autowired
    private SwfLogDao swfLogDao;
	@Autowired
	private PrpDuserApi userApi;
	@Value("${webservice.webAgriPrpallService.url}")
	private String webAgriPrpallServiceUrl;
	//----
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private PrpLCompensateDao prpLCompensateDao;
	@Autowired
	private CompanyApi companyApi;
	@Autowired
	private PrpDcurrencyApi prpDcurrencyApi;
	@Autowired
	private PrpDriskConfigApi prpDriskConfigApi;
	@Autowired
	private PrpDkindApi prpDkindApi;
	@Autowired
	private SettleMainListApi settleMainListApi;
	@Autowired
	private SpecCaseListApi specCaseListApi;
	@Override
	/**
	 * @description 承保需要的方法,根据条件查询PrpLPrepay
	 * @author 杨航
	 * @date 2017年11月13日 下午9:30:33
	 * @param prpLPrepayDto
	 *            特殊赔案信息
	 * @return prpLPrepayDtoList
	 */
	public List<PrpLPrepayDto> queryPrpLPrepayByCondition(PrpLPrepayDto prpLPrepayDto) {
		if (prpLPrepayDto == null) {
			throw new DataVerifyException("查询特殊赔案信息主表入参不许为空!");
		} else if (StringUtils.isEmpty(prpLPrepayDto.getPolicyNo())
				&& StringUtils.isEmpty(prpLPrepayDto.getPreCompensateNo())) {
			throw new DataVerifyException("查询特殊赔案信息主表保单号和预赔号不允许同时为空!");
		}
		List<PrpLPrepay> prpLPrepayList = prpLPrepayDao.findAll(Specifications.<PrpLPrepay>and()
				.eq(StringUtils.isNotEmpty(prpLPrepayDto.getPolicyNo()), "policyNo", prpLPrepayDto.getPolicyNo())
				.eq(StringUtils.isNotEmpty(prpLPrepayDto.getPreCompensateNo()), "preCompensateNo",
						prpLPrepayDto.getPreCompensateNo())
				.build());
		List<PrpLPrepayDto> prpLPrepayDtoList = new ArrayList<PrpLPrepayDto>();
		this.convertCollection(prpLPrepayList, prpLPrepayDtoList, PrpLPrepayDto.class);
		return prpLPrepayDtoList;
	}
	
	/**
	 * @description 特殊赔案查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLSpeciQueryInDto 查询入参对象
	 * @return PageInfo<SwfLogExtendDto> 工作流主表信息大对象
	 */
	public PageInfo<SwfLogExtendDto> queryBySpeciInDto(@RequestBody PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception{
		if (prpLSpeciQueryInDto == null) {
			throw new BusinessException("prpLSpeciQueryInDto对象不允许为null");
		} else {
			if(LOGGER.isDebugEnabled()){
				LOGGER.error("registNo={},policyNo={},insuredName={},riskCode={},nodeStatus={},flowInTimeStart={}", prpLSpeciQueryInDto.getRegistNo(),
					prpLSpeciQueryInDto.getPolicyNo(), prpLSpeciQueryInDto.getInsuredName(),prpLSpeciQueryInDto.getRiskCode(),
					prpLSpeciQueryInDto.getNodeStatus(),prpLSpeciQueryInDto.getFlowInTimeStart());
			}
		}
		Integer pageNo = prpLSpeciQueryInDto.getPageNo();
		Integer pageSize = prpLSpeciQueryInDto.getPageSize();
		if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        Long totalSizeStrLon = null;
        String conditions = "";
    	String conditionsCount = "";
    	Map<String,Object> paraMap=new HashMap<String,Object>();
        conditions = getNodeConditionsByNodeNo(prpLSpeciQueryInDto,"query",paraMap);
        conditionsCount = getNodeConditionsByNodeNo(prpLSpeciQueryInDto,"count",paraMap);
		Query agentQuery = entityManager.createQuery(conditions);
		Query agentQueryCount = entityManager.createQuery(conditionsCount);
		for (String key : paraMap.keySet()) {
			agentQuery.setParameter(key,paraMap.get(key));
			agentQueryCount.setParameter(key,paraMap.get(key));
        }
        totalSizeStrLon = new BigInteger(agentQueryCount.getSingleResult().toString()).longValue();
        if (pageNo != null) {
        	agentQuery.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
        	agentQuery.setMaxResults(pageSize.intValue());
        }
        List<SwfLog> swfLogList = agentQuery.getResultList();
		List<SwfLogDto> swfLogDto = new ArrayList<>();
		this.convertCollection(swfLogList, swfLogDto, SwfLogDto.class);
		List<SwfLogExtendDto> swfLogExtendDto = new ArrayList<>(swfLogDto.size());
		for(int n=0;n<swfLogDto.size();n++){
			SwfLogExtendDto swfLogExtendDtoNew = new SwfLogExtendDto();
			swfLogExtendDtoNew.setSwfLogDto(swfLogDto.get(n));
			//根据险种代码转换中文名称
			Map<String,String> riskcodeMap=new HashMap<String,String>();
			riskcodeMap.put("riskCode", swfLogDto.get(n).getRiskCode());
			riskcodeMap.put("isChinese", LanguageFlagConstant.CHINESE);
			String riskName = prpDriskApi.translateCode(riskcodeMap);
			swfLogExtendDtoNew.setRiskName(riskName);
			//根据报案号查询受损标的名称
			Query lossNameQuery = entityManager.createNativeQuery("select lossname from PrpLRegist where registNo = '"+ swfLogDto.get(n).getRegistNo() +"'");
			String lossName = "";
			if(lossNameQuery.getResultList().size()>0){
				lossName = (String)lossNameQuery.getSingleResult();
			}
			swfLogExtendDtoNew.setLossName(lossName);
			//根据报案号查询立案号
			String claimNo = swfLogDto.get(n).getKeyIn();
			swfLogExtendDtoNew.setClaimNo(claimNo);
			swfLogExtendDto.add(swfLogExtendDtoNew);
		}
		PageInfo<SwfLogExtendDto> pageInfo=new PageInfo<>();
		// 数据存放dto集合
        pageInfo.setContent(swfLogExtendDto);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(totalSizeStrLon);
        return pageInfo;
	}

	/**
	 * @description 根据对象拼接SQL
	 * @author 闫磊
	 * @date 2017年11月15日 
	 * @param prpLSpeciQueryInDto 入参对象
	 * @param flag 查询参数
	 * @return String 拼接完成的SQL
	 */
	private String getNodeConditionsByNodeNo(PrpLSpeciQueryInDto prpLSpeciQueryInDto, String flag,Map<String, Object> paraMap)throws Exception {
		String policyNo=prpLSpeciQueryInDto.getPolicyNo();
		String claimNo=prpLSpeciQueryInDto.getClaimNo();
		String registNo=prpLSpeciQueryInDto.getRegistNo();
		String insuredName=prpLSpeciQueryInDto.getInsuredName();
		String flowInTimeStart=prpLSpeciQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd=prpLSpeciQueryInDto.getFlowInTimeEnd();
		String riskType=prpLSpeciQueryInDto.getRiskType();
		String nodeStatus=prpLSpeciQueryInDto.getNodeStatus();
		String nodeType=prpLSpeciQueryInDto.getNodeType();
		String handlerCode=prpLSpeciQueryInDto.getHandlerCode();
		String riskCode=prpLSpeciQueryInDto.getRiskCode();
		String businessNo=prpLSpeciQueryInDto.getBusinessNo();
		StringBuilder stringBuilder = new StringBuilder();
		if("query".equals(flag)){
			stringBuilder=new StringBuilder("SELECT s FROM SwfLog s WHERE nodeType = 'speci' ");
		}else if("count".equals(flag)){
            stringBuilder = new StringBuilder("SELECT count(1) FROM SwfLog s WHERE nodeType = 'speci' ");
        }
		this.addStringCondition("nodeType", nodeType, "=", stringBuilder, paraMap);
		//根据案件类型以及当前处理人员拼接查询条件2是正在处理，3是核赔退回
		if(StringUtils.isNotEmpty(nodeStatus) && StringUtils.isNotEmpty(handlerCode)){
			if("2".equals(nodeStatus) || "3".equals(nodeStatus) || "4".equals(nodeStatus)){
				this.addStringCondition("handlerCode",handlerCode,"",stringBuilder,paraMap);
			}else{
				stringBuilder.append(" and (s.handlerCode='" + handlerCode + "' or s.handlerCode is null or s.handlerCode='')");
			}
			if(!"all".equals(nodeStatus)){
				this.addStringCondition("nodeStatus",nodeStatus,"",stringBuilder,paraMap);
			}else{
				stringBuilder.append(" and (NodeStatus < '5') ");
			}
		}else{
			throw new BusinessException("当前操作人或者案件状态为空，查询失败");
		}
		if("speciQuery".equals(flag)){
			stringBuilder.delete(0, stringBuilder.length());
			paraMap.clear();
			stringBuilder.append("select s from SwfLog s where (nodeType='compe' and nodeStatus = '0')  and flowId in (select flowId from SwfLog where nodeType='claim' and nodeStatus='4')");
			stringBuilder.append(" and (handlerCode='" + handlerCode + "' or handlerCode is null or handlerCode='')");
			
		}else if("speciCount".equals(flag)){
			stringBuilder.delete(0, stringBuilder.length());
			paraMap.clear();
			stringBuilder.append("select count(s) from SwfLog s where (nodeType='compe' and nodeStatus = '0')  and flowId in (select flowId from SwfLog where nodeType='claim' and nodeStatus='4')");
			stringBuilder.append(" and (handlerCode='" + handlerCode + "' or handlerCode is null or handlerCode='')");
		}
		if(StringUtils.isNotEmpty(policyNo)){
			stringBuilder.append(" and s.registNo in (select registNo from PrpLRegistRPolicy where 1=1 and policyNo like '").append(policyNo).append("%')");
		}
		if(StringUtils.isNotEmpty(claimNo)){
			stringBuilder.append(" and s.keyIn like '").append(claimNo).append("%'");
		}
		if(StringUtils.isNotEmpty(businessNo)){
			stringBuilder.append(" and s.keyOut like '").append(businessNo).append("%'");
		}
		if(!"all".equals(riskCode)) {
			this.addStringCondition("riskCode", riskCode, "", stringBuilder, paraMap);
		}
		this.addStringCondition("registNo",registNo,"*",stringBuilder,paraMap);
		this.addStringCondition("insuredName",insuredName,"*",stringBuilder,paraMap);
		if (StringUtils.isNotEmpty(riskType)) {
			stringBuilder.append(" and s.riskCode in ('");
			Map<String,String> riskCodeMap=new HashMap<String,String>();
			List<String> outerCodeList = new ArrayList<String>();
			if(!"I".equals(riskType) && !"H".equals(riskType)){
				riskCodeMap.put("riskType", "I");
				List<UtiCodeTransferDto> dtoListI = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if(dtoListI.size()>0){
					for(int s=0;s<dtoListI.size();s++){
						outerCodeList.add(dtoListI.get(s).getOuterCode());
					}
				}
				riskCodeMap.replace("riskType", "H");
				List<UtiCodeTransferDto> dtoListH = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if(dtoListH.size()>0){
					for(int s=0;s<dtoListH.size();s++){
						outerCodeList.add(dtoListH.get(s).getOuterCode());
					}
				}
			}else{
				riskCodeMap.put("riskType", riskType);
				List<UtiCodeTransferDto> dtoList = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if(dtoList.size()>0){
					for(int s=0;s<dtoList.size();s++){
						outerCodeList.add(dtoList.get(s).getOuterCode());
					}
				}
			}
			if(outerCodeList != null && outerCodeList.size()>0){
				for (int i = 0; i < outerCodeList.size(); i++) {
					if(i == outerCodeList.size()-1){
						stringBuilder.append(outerCodeList.get(i));
					}else{
						stringBuilder.append(outerCodeList.get(i)+"','");
					}
				}
			}
			stringBuilder.append("')");
		}
		//业务号为空时拼接工作流开始或者结束时间
		if((StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(registNo) && StringUtils.isEmpty(claimNo)) && !"spec".equals(flag.substring(0, 4))){
			if(StringUtils.isNotEmpty(flowInTimeEnd)) {
				stringBuilder.append(" and s.flowInTime >= '").append(flowInTimeStart).append("' and s.flowInTime <= '").append(flowInTimeEnd).append(" 23:59:59' ");
			}else if(StringUtils.isEmpty(flowInTimeEnd)&&StringUtils.isNotEmpty(flowInTimeStart)){
				stringBuilder.append(" and s.flowInTime >= '").append(flowInTimeStart).append("'");
			}
		}
		//工作流状态不能是关闭
		stringBuilder.append(" and s.flowStatus!='0' ");
		//新老系统数据区别标志
//		stringBuilder.append(" and s.dataFlag is null ");
        stringBuilder.append(" and s.medicalTransitFlag is null ");
        if ("query".equals(flag)) {
            stringBuilder.append("  and s.systemFlag = 'agri' order by s.handleTime desc");
        } else if ("count".equals(flag)) {
            stringBuilder.append("  and s.systemFlag = 'agri' ");
        }

		if(LOGGER.isDebugEnabled()){
			LOGGER.error(stringBuilder.toString());
		}
		return stringBuilder.toString();
	}

	/**
     * @description sql参数(String)转换
     * @return void
     * @author 闫磊
     * @throws Exception
     * @date 2017年10月20日 17:30:27
     */
    public void addStringCondition(String name,String value,String sign,StringBuilder strWhere,Map<String,Object> paraMap) throws Exception{
        if(value!= null&&!"".equals(value.trim())){
            if(StringUtils.isNotEmpty(value)){
            	if("*".equals(sign)){
                	strWhere.append(" and s."+name+" like :"+name);
                	paraMap.put(name,value+"%");
            	}else{
                	strWhere.append(" and s."+name+" = :"+name);
                	paraMap.put(name,value);
            	}
            }
    	}
    }
    
	
	/**
	 * @description 特殊赔案前置查询
	 * @author 闫磊
	 * @date 2017年12月11日 
	 * @param prpLSpeciQueryInDto 查询入参对象
	 * @return PageInfo<SwfLogExtendDto> 工作流主表信息大对象
	 */
	public PageInfo<SwfLogExtendDto> queryByTurnSpeciInDto(@RequestBody PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception{
		if (prpLSpeciQueryInDto == null) {
			throw new BusinessException("查询对象不允许为空");
		} else {
			if(LOGGER.isDebugEnabled()){
				LOGGER.error("registNo={},policyNo={},insuredName={},riskCode={},nodeStatus={},flowInTimeStart={}", prpLSpeciQueryInDto.getRegistNo(),
					prpLSpeciQueryInDto.getPolicyNo(), prpLSpeciQueryInDto.getInsuredName(),prpLSpeciQueryInDto.getRiskCode(),
					prpLSpeciQueryInDto.getNodeStatus(),prpLSpeciQueryInDto.getFlowInTimeStart());
			}
		}
		Integer pageNo = prpLSpeciQueryInDto.getPageNo();
		Integer pageSize = prpLSpeciQueryInDto.getPageSize();
		if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        String uerCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
        prpLSpeciQueryInDto.setHandlerCode(uerCode);
        prpLSpeciQueryInDto.setNodeStatus("0");
        prpLSpeciQueryInDto.setNodeType("");
        Long totalSizeStrLon = null;
        String conditions = "";
    	String conditionsCount = "";
    	Map<String,Object> paraMap=new HashMap<String,Object>();
        conditions = getNodeConditionsByNodeNo(prpLSpeciQueryInDto,"speciQuery",paraMap);
        conditionsCount = getNodeConditionsByNodeNo(prpLSpeciQueryInDto,"speciCount",paraMap);
		Query agentQuery = entityManager.createQuery(conditions);
		Query agentQueryCount = entityManager.createQuery(conditionsCount);
		for (String key : paraMap.keySet()) {
			agentQuery.setParameter(key,paraMap.get(key));
			agentQueryCount.setParameter(key,paraMap.get(key));
        }
        totalSizeStrLon = new BigInteger(agentQueryCount.getSingleResult().toString()).longValue();
        if (pageNo != null) {
        	agentQuery.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
        	agentQuery.setMaxResults(pageSize.intValue());
        }
        List<SwfLog> swfLogList = agentQuery.getResultList();
		List<SwfLogDto> swfLogDto = new ArrayList<>();
		this.convertCollection(swfLogList, swfLogDto, SwfLogDto.class);
		List<SwfLogExtendDto> swfLogExtendDto = new ArrayList<>(swfLogDto.size());
		for(int n=0;n<swfLogDto.size();n++){
			SwfLogExtendDto swfLogExtendDtoNew = new SwfLogExtendDto();
			swfLogExtendDtoNew.setSwfLogDto(swfLogDto.get(n));
			//根据险种代码转换中文名称
			Map<String,String> riskcodeMap=new HashMap<String,String>();
			riskcodeMap.put("riskCode", swfLogDto.get(n).getRiskCode());
			riskcodeMap.put("isChinese", LanguageFlagConstant.CHINESE);
			String riskName = prpDriskApi.translateCode(riskcodeMap);
			swfLogExtendDtoNew.setRiskName(riskName);
			//根据报案号查询受损标的名称
			Query lossNameQuery = entityManager.createNativeQuery("select lossname from PrpLRegist where registNo = '"+ swfLogDto.get(n).getRegistNo() +"'");
			String lossName = "";
			if(lossNameQuery.getResultList().size()>0){
				lossName = (String)lossNameQuery.getSingleResult();
			}
			swfLogExtendDtoNew.setLossName(lossName);
			//根据报案号查询立案号
			String claimNo = swfLogDto.get(n).getKeyIn();
			swfLogExtendDtoNew.setClaimNo(claimNo);
			swfLogExtendDto.add(swfLogExtendDtoNew);
		}
		
		PageInfo<SwfLogExtendDto> pageInfo=new PageInfo<>();
		// 数据存放dto集合
        pageInfo.setContent(swfLogExtendDto);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(totalSizeStrLon);
        return pageInfo;
	}
	
	
	
	/**
	 * 
	 * @description 特殊赔案保存预付信息
	 * @author yk
	 * @date 2017年12月9日 上午12:30:09
	 * @param prepayDto 预付信息对象
	 */
	@Override
	public Map<String, String> savePrepay(PrepayDto prepayDto) throws Exception{

		if (prepayDto.getPrpLPrepayDto() == null) {
			throw new BusinessException("前端传送数据出错！！");
		}
		PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(prepayDto.getClaimNo()));
		if(StringUtils.isEmpty(prepayDto.getPrpLPrepayDto().getClassCode())){
			prepayDto.getPrpLPrepayDto().setClassCode(prpLClaim.getClassCode());
		}
		Double sumClaim = prpLClaim.getSumClaim();
		double prePaid = prepayDto.getPrpLPrepayDto().getSumPrepaid() == null ? 0 : prepayDto.getPrpLPrepayDto().getSumPrepaid();
		//double sumPaid = Double.parseDouble(prepayDto.getSumPaid());
		if (prePaid > sumClaim / 2) {
			throw new BusinessException("预赔金额应该小于等于估损金额的50%");
		}
		PrpLPrepayExtDto prpLprepayDto = prepayDto.getPrpLPrepayDto();
		// 工作流号码
		String swfLogFlowID = prepayDto.getFlowId();
		// 工作流logno
		String swfLogLogNo = prepayDto.getLogNo();
		String riskCode = "";
		String riskCodeTemp = prpLprepayDto.getRiskCode();
		// 表示是特殊赔案中的预赔的新增，还是修改，如果是新增，则会增加新的工作流信息，
		// 只要设置taskType="T"类型的就可以了。
		String taskType = "";
		if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
			riskCode = riskCodeTemp;
		}
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
		PrpDuserDto prpDuserDto = userApi.queryByPK(userCode);
		String comCode = prpDuserDto.getComCode();
//		comCode = "0000000000";
		int year = DateTime.current().getYear();
		// 险种
		// 如果是新登记，则从取号表中取预赔号码，如果是修改，则保持原来的preCompensateNo不变
		// 取预赔号
		String preCompensateNo = ""; // 预赔号
		preCompensateNo = prpLprepayDto.getPreCompensateNo();
		if (preCompensateNo == null || preCompensateNo.length() < 1 || preCompensateNo.trim().equals("")) {
			String tableName = "prplprepay";
			try {
//				userCode = "0000000000";
				BillNoDto billNoDto = new BillNoDto();
				billNoDto.setTableName(tableName);
				billNoDto.setRiskCode(riskCode);
				billNoDto.setiComCode(comCode);
				billNoDto.setiYear(new Integer(year).toString());
				billNoDto.setUserCode(userCode);
				preCompensateNo = billNoApi.getBillNo(billNoDto).get("billNo");

				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("获得保单号" + prepayDto.getPrpLPrepayDto().getPolicyNo() + "的预赔号"
							+ prepayDto.getPrpLPrepayDto().getPreCompensateNo());
				}
			} catch (Exception e) {
			}
			prepayDto.getPrpLPrepayDto().setPreCompensateNo(preCompensateNo);
			taskType = "T";
		}
		// 组装预付信息对象
		prepayDto = getPrepayDto(prepayDto);

		// 如果提交核赔则状态为9
		if (prepayDto.getPrpLclaimStatusDto().getStatus().equals("4")) {
			prepayDto.getPrpLPrepayDto().setUnderWriteFlag("9");
		}

		// 异常测试
		if (preCompensateNo.equals("") || preCompensateNo.length() != 22) {
			// throw new UserException(-98,-200,"","错误测试");
		}

		// 工作流处理过程(属于特殊)
		// -----------------------------------------------------
		// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码

		SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();

//		userCode = "0000000000";
		String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
//		userComCode = "0000000000";
		String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
		swfLogTransferDto.setUserUserCode(userCode);
		swfLogTransferDto.setUserComCode(userComCode);
		swfLogTransferDto.setUserUserName(userName);
		PrpDcompanyDto querPrpDcompanyDto = null;
		try {
			querPrpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
		} catch (Exception e) {
			throw new BusinessException("根据comcode查询公司失败！！");
		}
		swfLogTransferDto.setUserComName(querPrpDcompanyDto.getComCName());
		
		SwfLogDto swfLogDtoDealNode = new SwfLogDto();
		// swfLogDtoDealNode.setTaskType(taskType);

		swfLogDtoDealNode.setFlowId(swfLogFlowID);
		swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));

		// 如果下一个节点是结案的话，那么直接是赔案号就可以了
		// swfLogDtoDealNode.setNextBusinessNo(prepayDto.getPrpLprepayDto().getClaimNo());
		swfLogDtoDealNode.setNextBusinessNo(preCompensateNo);
		swfLogTransferDto.setNextBusinessNo(preCompensateNo);
		swfLogDtoDealNode.setKeyIn(prepayDto.getClaimNo());
		swfLogDtoDealNode.setKeyOut(preCompensateNo);
		swfLogDtoDealNode.setNodeStatus(prepayDto.getPrpLclaimStatusDto().getStatus());
		// 获得工作流对象
		
		swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
		WorkFlowDto workFlowDto = workFlowServiceImpl.viewToDto(swfLogTransferDto);
		// ------------------------------------------------------------
		// 保存预赔信息

		if (workFlowDto.isCheckClose()) {
			throw new BusinessException("该工作流程已经关闭，" + "如果需要操作，请联系管理员重新开启工作流!");
		}

		if ((workFlowDto.isCreate()) || (workFlowDto.isUpdate()) || (workFlowDto.isSubmit())
				|| (workFlowDto.isClose())) {
			// 增加对核保核赔系统的接口调用。
			int vericLogNo = 0;
			if (swfLogDtoDealNode.getNodeStatus().equals("4")) {
				if (taskType.equals("T")) { // 业务数据库中还没有数据
					savePrepayDto(prepayDto);
				}
				if (workFlowDto.getSubmitSwfLogDtoList() != null && workFlowDto.getSubmitSwfLogDtoList().size() != 0) {
					vericLogNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo();
				}
				String UWflowID = "";
						/*sendXMLData(workFlowDto.getUpdateSwfLogDto().getFlowId(), vericLogNo + "", "22", "Y",
						preCompensateNo, prpLprepayDto.getRiskCode(), prpLprepayDto.getClassCode(),
						prpLprepayDto.getComCode(), prpLprepayDto.getHandlerCode(), prpLprepayDto.getMakeCom(),
						userCode, prpLprepayDto.getHandler1Code(), "");*/
				PrepaySubmitUndwrtXMLDto prepaySubmitUndwrtXMLDto = new PrepaySubmitUndwrtXMLDto();
				prepaySubmitUndwrtXMLDto.setlFlowId(workFlowDto.getUpdateSwfLogDto().getFlowId());
				prepaySubmitUndwrtXMLDto.setlLogNo(vericLogNo);
				prepaySubmitUndwrtXMLDto.setModelType("22");
				prepaySubmitUndwrtXMLDto.setCertiType("Y");
				prepaySubmitUndwrtXMLDto.setBusinessNo(preCompensateNo);
				prepaySubmitUndwrtXMLDto.setRiskCode(prpLprepayDto.getRiskCode());
				prepaySubmitUndwrtXMLDto.setClassCode(prpLprepayDto.getClassCode());
				prepaySubmitUndwrtXMLDto.setComCode(prpLprepayDto.getComCode());
				prepaySubmitUndwrtXMLDto.setHandlerCode(prpLprepayDto.getHandlerCode());
				prepaySubmitUndwrtXMLDto.setMakecom(prpLprepayDto.getMakeCom());
				prepaySubmitUndwrtXMLDto.setUserCode(userCode);
				prepaySubmitUndwrtXMLDto.setHandler1Code(prpLprepayDto.getHandler1Code());
				prepaySubmitUndwrtXMLDto.setContractNo("");
				prepaySubmitUndwrtXMLDto.setFlag("claim");
				try {
					UWflowID = sendPrepayXMLToUndwrt(prepaySubmitUndwrtXMLDto).get("flowId");
				}catch (Exception e){
					throw new BusinessException("特殊赔案生成提交双核xml文件失败！！");
				}

				if (UWflowID.length() != 27) {
					// 如果提交核赔失败则状态为0
					// 计算书提交失败时，把计算书置为暂存，可以再次提交。
					swfLogDtoDealNode.setNodeStatus("2");
					prpLprepayDto.setUnderWriteFlag("0");
					workFlowDto =  workFlowServiceImpl.viewToDto(swfLogTransferDto);
					savePrepayDto(prepayDto);
					try {
						workFlowServiceImpl.deal(workFlowDto);
					} catch (Exception e) {
                          throw new BusinessException("保存工作流异常！！");
					}
					String msg = "案件'" + preCompensateNo + "'提交双核系统失败，请重新提交或者与管理员联系!";
					throw new BusinessException(msg);
				}
			}
			// 保存预付信息对象和工作流对象
			savePrepayDto(prepayDto);
			//将特殊赔案号回写到特殊赔案清单
			if(StringUtils.isNotEmpty(prepayDto.getListNo())){
				Map<String,String> map = new HashMap<>();
				map.put("listNo",prepayDto.getListNo());
				map.put("preCompensateNo",preCompensateNo);
				specCaseListApi.saveSpecCaseListPreCompensateNo(map);
			}
			try {
				workFlowServiceImpl.deal(workFlowDto);
			} catch (Exception e) {
				throw new BusinessException("保存工作流异常！！");
			}
		} else {
			// 如果提交核赔失败则状态为0
			prepayDto.getPrpLPrepayDto().setUnderWriteFlag("0");
			savePrepayDto(prepayDto);
		}
		Map<String, String> map = new HashMap<>();
		map.put("preCompensateNo", preCompensateNo);
		return map;

	}


	/**
	 * 
	 * @description 组装和修改prepayDto预付对象
	 * @author yk
	 * @date 2017年12月9日 上午12:33:34
	 * @param prepayDto 预付对象
	 * @return prepayDto预付对象
	 */
	private PrepayDto getPrepayDto(PrepayDto prepayDto) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("组装prepayDto预付对象!!");
		}
		String claimNo = prepayDto.getClaimNo();

		PrpLPrepayDto prpLprepayDto = prepayDto.getPrpLPrepayDto();
		prpLprepayDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLprepayDto.setUnderWriteendDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLprepayDto.setClaimNo(claimNo);

		PrpLclaimStatusDto prpLclaimStatusDto = prepayDto.getPrpLclaimStatusDto();
		prpLclaimStatusDto.setBusinessno(prpLprepayDto.getPreCompensateNo());
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
//		userCode = "0000000000";
		prpLclaimStatusDto.setHandlercode(userCode);
		prpLclaimStatusDto.setInputdate(prpLprepayDto.getInputDate());
		prpLclaimStatusDto.setTypeflag("5");
		prpLclaimStatusDto.setNodetype("speci");
		prpLclaimStatusDto.setSerialno(5);
		prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimStatusDto.setPolicyno(prpLprepayDto.getPolicyNo());
		prpLclaimStatusDto.setRiskcode(prpLprepayDto.getRiskCode());
		double sumPrePaid = 0.0;
		List<PrpLPreChargeDto> prpLpreChargeDtoList = prepayDto.getPrpLpreChargeDtoList();
		if (prpLpreChargeDtoList != null && prpLpreChargeDtoList.size() > 0) {
			for (int i = 0; i < prpLpreChargeDtoList.size(); i++) {
				PrpLPreChargeDto prpLPreChargeDto = prpLpreChargeDtoList.get(i);
				prpLPreChargeDto.setClaimNo(claimNo);
				prpLPreChargeDto.setRiskCode(prpLprepayDto.getRiskCode());
				prpLPreChargeDto.setPolicyNo(prpLprepayDto.getPolicyNo());
				prpLPreChargeDto.setPrecompensateNo(prpLprepayDto.getPreCompensateNo());
				prpLPreChargeDto.setSerialNo(i + 1);
				if(StringUtils.isNotEmpty(prpLPreChargeDto.getChargeCode())){
					if(prpLPreChargeDto.getChargeCode().length()==1){
						prpLPreChargeDto.setChargeCode("0"+prpLPreChargeDto.getChargeCode());
					}
				}
				List<PrpLPreCharge> prpLPreChargeList = prpLPreChargeDao.findAll();
//				prpLPreChargeDto.setId(prpLPreChargeList.size() + 1);
				sumPrePaid += prpLPreChargeDto.getSumprePaid();
			}
		}
		int sumPrePaidInt = (int) sumPrePaid;
		prpLprepayDto.setSumPrechargePaid(sumPrePaidInt);
		/*---------------------预赔文本表PrpLptextDto------------------------------------*/
		List<PrpLPtextDto> prpLptextDtoList = new ArrayList<>();
		String TextTemp = prepayDto.getContext();
		int RULE_LENGTH = 70;
		String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < rules.length; k++) {
			PrpLPtextDto prpLptextDto = new PrpLPtextDto();
			prpLptextDto.setPreCompensateNo(prpLprepayDto.getPreCompensateNo());
			prpLptextDto.setContext(rules[k]);
			prpLptextDto.setLineNo((double) (k + 1));
			prpLptextDtoList.add(prpLptextDto);
		}

		prepayDto.setPrpLptextDtoList(prpLptextDtoList);
		return prepayDto;
	}
	
	
	/**
	 * 
	 * @description 保存预付对象到数据库
	 * @author yk
	 * @date 2017年12月9日 上午12:32:47
	 * @param prepayDto 预付对象
	 */
	@Transactional
	public void savePrepayDto(PrepayDto prepayDto) {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("把prepayDto预付对象保存到数据库!!");
		}

		// PrpLClaimDto prpLclaimDto = new PrpLClaimDto();
		// prpLclaimDto.setClaimNo(prepayDto.getClaimNo());

		if ("4".equals(prepayDto.getPrpLclaimStatusDto().getStatus())) {
			PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(prepayDto.getClaimNo()));
			prpLClaim.setSumPaid(Double.parseDouble(prepayDto.getSumPaid()));
			prpLClaimDao.save(prpLClaim);
		}

		PrpLPrepayDto prpLprepayDto = prepayDto.getPrpLPrepayDto();
		PrpLPrepay prpLPrepay = convert(prpLprepayDto, PrpLPrepay.class);
		prpLPrepayDao.save(prpLPrepay);

		if (prepayDto.getPrpLpreChargeDtoList() != null) {
			List<PrpLPreChargeDto> prpLpreChargeDtoList = prepayDto.getPrpLpreChargeDtoList();
			List<PrpLPreCharge> prpLpreChargeList = new ArrayList<>(prpLpreChargeDtoList.size());
			convertCollection(prpLpreChargeDtoList, prpLpreChargeList, PrpLPreCharge.class);
			PrpLPreCharge prpLPreCharge = new PrpLPreCharge();
			if(prpLpreChargeDtoList.size()>0) {
				prpLPreCharge.setPrecompensateNo(prpLpreChargeDtoList.get(0).getPrecompensateNo());

			StringBuffer sql = new StringBuffer("select p.* from PrpLPreCharge p where p.PrecompensateNo='")
					.append(prpLpreChargeDtoList.get(0).getPrecompensateNo()).append("'");
			Query dataQuery= entityManager.createNativeQuery(sql.toString(),PrpLPreCharge.class);
			List<PrpLPreCharge> chargeList = dataQuery.getResultList();
			prpLPreChargeDao.delete(chargeList);
			}
			//prpLPreChargeDao.deleteByPrecompensateNo(prpLpreChargeDtoList.get(0).getPrecompensateNo());
			prpLPreChargeDao.save(prpLpreChargeList);
		}
		if (prepayDto.getPrpLptextDtoList() != null) {
			List<PrpLPtextDto> prpLptextDtoList = prepayDto.getPrpLptextDtoList();
			List<PrpLPtext> PrpLPtextList = new ArrayList<>(prpLptextDtoList.size());
			convertCollection(prpLptextDtoList, PrpLPtextList, PrpLPtext.class);
			prpLPtextDao.save(PrpLPtextList);
		}
		// prpLClaimDao.updatePrpLclaimSumPaid(Double.parseDouble(prepayDto.getSumPaid()),
		// prepayDto.getClaimNo());

		// 进行状态的改变
		prpLclaimStatusDao.save(convert(prepayDto.getPrpLclaimStatusDto(), PrpLclaimStatus.class));
	}
	
	
	private String sendXMLData(String LflowID, String LlogNo, String modelType, String certiType, String businessNo,
			String riskCode, String classCode, String comCode, String handlerCode, String makecom, String userCode,
			String handler1Code, String contractNo) {
		String interMethod = "start";
		String xmlData = "<?xml version=\"1.0\" encoding=\"GBK\" ?>";
		xmlData += "<REQUEST>";
		xmlData += "<Interface>CLAIMUNDWRTINFO</Interface>";
		xmlData += "<HEAD>";
		// 组织数据
		xmlData += "  <REQUESTTYPE>U01001</REQUESTTYPE>   ";
		xmlData += "  <REQSERIALNO>38</REQSERIALNO>       ";
		xmlData += "  <FLOWINTIME>2013-05-29</FLOWINTIME> ";
		xmlData += "  </HEAD>                             ";
		xmlData += "  <CLAIMUNDWRTINFO>                   ";
		xmlData += "  <lFlowID>" + LflowID + "</lFlowID>                 ";
		xmlData += "  <lLogNo>" + LlogNo + "</lLogNo>                   ";
		xmlData += "  <modelType>" + modelType + "</modelType>             ";
		xmlData += "  <certiType>" + certiType + "</certiType>             ";
		xmlData += "  <businessNo>" + businessNo + "</businessNo>           ";
		xmlData += "  <riskCode>" + riskCode + "</riskCode>               ";
		xmlData += "  <classCode>" + classCode + "</classCode>             ";
		xmlData += "  <comCode>" + comCode + "</comCode>                 ";
		xmlData += "  <makecom>" + makecom + "</makecom>                 ";
		xmlData += "  <userCode>" + userCode + "</userCode>               ";
		xmlData += "  <handlerCode>" + handlerCode + "</handlerCode>         ";
		xmlData += "  <handler1Code>" + handler1Code + "</handler1Code>       ";
		xmlData += "  <contractNo>" + contractNo + "</contractNo>           ";
		xmlData += "  <flag>claim</flag>                  ";
		xmlData += "  </CLAIMUNDWRTINFO>                  ";
		xmlData += "  </REQUEST>                          ";
		//
		// xmlData += "<" + interMethod + ">";
		// xmlData += "<LflowID>" + LflowID + "</LflowID>";
		// xmlData += "<LlogNo>" + LlogNo + "</LlogNo>";
		// xmlData += "<modelType>" + modelType + "</modelType>";
		// xmlData += "<certiType>" + certiType + "</certiType>";
		// xmlData += "<businessNo>" + businessNo + "</businessNo>";
		// xmlData += "<riskCode>" + riskCode + "</riskCode>";
		// xmlData += "<classCode>c</classCode>";
		// xmlData += "<comCode>" + comCode + "</comCode>";
		// xmlData += "<makecom>" + makecom + "</makecom>";
		// xmlData += "<userCode>" + userCode + "</userCode>";
		// xmlData += "<handlerCode>" + handlerCode + "</handlerCode>";
		// xmlData += "<handler1Code>" + handler1Code + "</handler1Code>";
		// xmlData += "<contractNo>" +contractNo + "</contractNo>";
		// xmlData += "<flag>" +"claim" + "</flag>";
		// xmlData += "</" + interMethod + ">";
		// xmlData += "</ClaimData>";

		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("准备好的XML::::" + xmlData);
		}
		// 返回的是字符uwflowid
		String flag = "";
		try {
			flag = this.sendData(xmlData);
		} catch (Exception e) {
//			throw new BusinessException("数据已经发送， 但没有返回结果！");
			throw new BusinessException(e.getMessage());
		}
		return flag;

	}
	
	public String sendData(String xmlData) throws Exception {
		String SERVER_URL = "http://localhost:7005/undwrt/UWWFServer";//todo http://9.0.2.151:9004/undwrt/UWWFServer
		// 开启连接
		URL uploadServlet = new URL(SERVER_URL);
		URLConnection servletConnection = uploadServlet.openConnection();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("请求理赔URL::::::" + servletConnection.getURL());
		}
		// 设置连接参数
		servletConnection.setUseCaches(false);
		servletConnection.setDoOutput(true);
		servletConnection.setDoInput(true);
		// 开启流，写入XML数据
		BufferedOutputStream output = new BufferedOutputStream(servletConnection.getOutputStream());
		output.write(xmlData.getBytes());
		output.close();

		try {
			// 接收返回参数
			DataInputStream input = null;
			input = new DataInputStream(servletConnection.getInputStream());
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024];
			int read = 0;
			while ((read = input.read(b)) > 0) {
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			String dataString = new String(data);
			input.close();
			return dataString;
		} catch (Exception e) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("数据已经发送， 但没有返回结果！");
			}
			throw new BusinessException("数据已经发送， 但没有返回结果！");
		}
	}
	
	
	/**
     * 
     * @description 特殊赔案申请提交
     * @author yk
     * @date 2017年12月14日 下午11:18:56
     * @param prepayApplicationDto 特殊赔案dto
     * @return String预赔号
     */
	@Override
	public Map<String, String>  savePrepayApplication(PrepayApplicationDto prepayApplicationDto) {
		String claimNo = prepayApplicationDto.getClaimNo();
		String nodeStatus = prepayApplicationDto.getNodeStatus();
		PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(claimNo));
		PrpLClaimDto prpLClaimDto = convert(prpLClaim, PrpLClaimDto.class);

		SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
//		userCode = "0000000000";
		String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
//		userComCode = "0000000000";
		String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
		swfLogTransferDto.setUserUserCode(userCode);
		swfLogTransferDto.setUserComCode(userComCode);
		swfLogTransferDto.setUserUserName(userName);
		PrpDcompanyDto querPrpDcompanyDto;
		try {
			querPrpDcompanyDto = prpDcompanyApi.queryByPK(userComCode);
		} catch (Exception e) {
			throw new BusinessException("根据comcode查询机构失败！！");
		}
		swfLogTransferDto.setUserComName(querPrpDcompanyDto.getComCName());

		SwfLogTransferDto specialCaseSwfLogTransferDto = getSpecialCaseSwfLogDto(prepayApplicationDto);
		SwfLogDto swfLogDtoTemp = getSpecialCaseSwfLogDto(prepayApplicationDto).getSwfLogDto();
		SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	    swfLogDtoDealNode.setFlowId(swfLogDtoTemp.getFlowId());
	    swfLogDtoDealNode.setLogNo(swfLogDtoTemp.getLogNo());
	    swfLogDtoDealNode.setNodeStatus("4");
	    swfLogDtoDealNode.setKeyIn(claimNo);
	    swfLogDtoDealNode.setKeyOut(claimNo);
	    swfLogDtoDealNode.setNextBusinessNo(claimNo );
	    swfLogTransferDto.setNextBusinessNo(claimNo );
	    swfLogDtoDealNode.setPolicyNo(prpLClaimDto.getPolicyNo());
	    //指定下个节点就是特殊赔案的申请
		List<SwfLogDto> nextNodeList = new ArrayList<>();
		SwfLogDto swfLogNextNode = new SwfLogDto();
		swfLogNextNode.setNodeNo(0);
		swfLogNextNode.setNodeType("speci");
		swfLogNextNode.setTypeFlag(swfLogDtoTemp.getTypeFlag()); //区分赔案类型的
		swfLogNextNode.setPolicyNo(prpLClaimDto.getPolicyNo());
		nextNodeList.add(swfLogNextNode);
		swfLogTransferDto.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
		swfLogTransferDto.setSwfLogNextList(nextNodeList);

		swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
	    WorkFlowDto workFlowDto = workFlowServiceImpl.viewToDto(swfLogTransferDto);
	    workFlowDto.setSwfNotionDtoList((ArrayList<SwfNotionDto>)specialCaseSwfLogTransferDto.getSwfNotionDtoList() );
	    if (workFlowDto.getUpdateSwfLogDto()!=null) {
	    	workFlowDto.getUpdateSwfLogDto().setNodeStatus(nodeStatus);
	    }

	    if (workFlowServiceImpl.checkDealDto(workFlowDto)) {
	    	try {
				workFlowServiceImpl.deal(workFlowDto);
			} catch (Exception e) {
	    		throw new BusinessException("保存工作流失败！！");
			}
		}

		Map<String, String> map = new HashMap<>();
		map.put("claimNo", claimNo);
		return map;
	}
	
	/**
     * 
      * @description 组装待保存的报案申请的工作流dto
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayApplicationDto 特殊赔案dto
      * @return 组装待保存的报案申请的工作流dto
     */
	private SwfLogTransferDto getSpecialCaseSwfLogDto(PrepayApplicationDto prepayApplicationDto) {
		
		SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
	  	 SwfLogDto swfLogDto = new SwfLogDto ();
	     swfLogDto.setFlowId(prepayApplicationDto.getFlowID()) ;
	     swfLogDto.setLogNo(prepayApplicationDto.getLogNo()) ;
	     String content = prepayApplicationDto.getContent();
	     String typeFlag = prepayApplicationDto.getTypeFlag();
	     swfLogDto.setTypeFlag(typeFlag); 
	     
	  	 int RULE_LENGTH = 69;
	  	
	     content= SinoRequestContext.getCurrentContext().getUser().getUserName()+" "+ new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()  +" "+ content;
	     String[] rules = StringGyUtils.split(content,RULE_LENGTH);
	     //if (content.length()>70) content = content.substring(0,69);
	     List<SwfNotionDto> swfNotionList = new ArrayList<>();
	     
	     Integer maxLineNo = swfNotionDao.getMaxLineNo(swfLogDto.getFlowId(),swfLogDto.getLogNo());
	     if(maxLineNo == null){
	    	 maxLineNo = 1;
	     }
	     
//	     int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(swfLogDto.getFlowId(),swfLogDto.getLogNo() );
	     for (int i = 0; i < rules.length; i++) {
		    SwfNotionDto swfNotionDto = new SwfNotionDto();
		    swfNotionDto.setFlowId(swfLogDto.getFlowId());
		    swfNotionDto.setLogNo(swfLogDto.getLogNo()); 
		    swfNotionDto.setHandleText(rules[i]);
		    swfNotionDto.setLineNo(i+maxLineNo);
		    swfNotionList.add(swfNotionDto) ; 
	     }
	     
	     swfLogTransferDto.setSwfLogDto(swfLogDto);
	     swfLogTransferDto.setSwfNotionDtoList(swfNotionList);
	     return swfLogTransferDto;

	}
	/**
     * @description:方法功能简述: 申请特殊赔案初始化服务方法
     * @author 安齐崇
     * @date 2017年12月16日下午6:08:14
     * @param requestDto
     * @return
     * @throws Exception 
     */
	@Override
	public SpecialCaseResDto specialCaseApplyInit(SpecialCaseReqDto requestDto) throws Exception {
		/*校验入参*/
		this.verifyParam(requestDto);
		/*把入参设置到出参对象*/
		SpecialCaseResDto responseDto = this.convert(requestDto, SpecialCaseResDto.class);
		/*设置用户信息*/
		this.setUserInfo(responseDto);
		/*查询立案信息*/
		List<PrpLClaimDto> prpLClaimDtoList = this.queryClaimInfo(responseDto);
		responseDto.setPrpLClaimDtoList(prpLClaimDtoList);
		this.prepareParam(responseDto);
		//responseDto.setPrpLClaimDtoList(null);
		/* 校验此赔案是否出计算书 */
		if("ADD".equals(requestDto.getEditType())&&prpLClaimDtoList!=null&&prpLClaimDtoList.size()>0){
			this.verifyExistCompensate(prpLClaimDtoList.get(0).getClaimNo());
			this.verifyExistPrepay(prpLClaimDtoList.get(0).getClaimNo(),responseDto.getNodeStatus());
		}
		return responseDto;
	}
	/**
	 * @description:方法功能简述: 完善页面数据
	 * @author 安齐崇
	 * @date 2017年12月17日上午11:53:01
	 * @param responseDto
	 */
	private void prepareParam(SpecialCaseResDto responseDto) {
		List<PrpLClaimDto> prpLClaimDtoList = responseDto.getPrpLClaimDtoList();
		String registNo = prpLClaimDtoList.get(0).getRegistNo();
		responseDto.setFlowInTime(new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND ).toString() );
		/*查询已有的特殊赔案情况*/
		List<SwfLog> swfLogList = swfLogDao.findAll(Specifications.<SwfLog>and().eq("handleDept", responseDto.getComCode()).eq("nodeType",responseDto.getNodeType()).eq("registNo", registNo).build());
		List<SwfLogDto> swfLogDtoList = new ArrayList<>();
		this.convertCollection(swfLogList, swfLogDtoList, SwfLogDto.class);
		responseDto.setSwfLogDtoList(swfLogDtoList);
	}
	private List<PrpLClaimDto> queryClaimInfo(SpecialCaseResDto responseDto) {
		String nodeType = responseDto.getNodeType();
		String businessNo = responseDto.getBusinessNo();
		String claimNo = "";
		String registNo = "";
		String policyNo = "";
		String config = "check,certa,verif";
		if (config.indexOf(nodeType) > 0) {
			registNo = businessNo;
			List<PrpLClaim> prpLClaimList = prpLClaimDao
					.findAll(Specifications.<PrpLClaim> and().eq("registNo", registNo).build());
			claimNo = prpLClaimList == null || prpLClaimList.size() < 1 ? "" : prpLClaimList.get(0).getClaimNo();
		}
		if ("speci".equals(nodeType)) {
			claimNo = businessNo;
			PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(claimNo));
			registNo = prpLClaim.getRegistNo();
			policyNo = prpLClaim.getPolicyNo();
		}
		responseDto.setPolicyNo(policyNo);
		responseDto.setRegistNo(registNo);
		String sqlStr = "select * from prplclaim where registno in (Select registNo From Swflog Where registno = :registNo and (nodestatus = '4' or nodestatus='2'))";
		Query query = entityManager.createNativeQuery(sqlStr, PrpLClaim.class);
		query.setParameter("registNo", registNo);
		List<PrpLClaim> prpLClaimList = query.getResultList();
		if (prpLClaimList == null || prpLClaimList.size() == 0) {
			throw new BusinessException("案件目前还没有立案，请先立案后再申请！");
		}
		List<PrpLClaimDto> prpLClaimDtoList = new ArrayList<>();
		this.convertCollection(prpLClaimList, prpLClaimDtoList, PrpLClaimDto.class);
		return prpLClaimDtoList;
	}
	/**
	 * @description:方法功能简述: 进行入参非空校验
	 * @author 安齐崇
	 * @date 2017年12月17日上午12:02:20
	 * @param requestDto
	 */
	private void verifyParam(SpecialCaseReqDto requestDto) {
		if(requestDto == null){
			throw new BusinessException("请求参数不能为空");
		}
		if(StringUtils.isEmpty(requestDto.getRiskCode())){
			throw new BusinessException("险种编码不能为空！");
		}
		if(StringUtils.isEmpty(requestDto.getLogNo())){
			throw new BusinessException("报案号不能为空！");
		}
		
	}
	/**
	 * @description:方法功能简述: 设置登录用户信息到返回对象
	 * @author 安齐崇
	 * @date 2017年11月16日上午10:53:43
	 * @param responseDto 返回对象
	 * @throws Exception 
	 */
	private void setUserInfo(SpecialCaseResDto responseDto) throws Exception {
		/* 设置用户信息 */
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		PrpDuserDto userInfo = userApi.queryByPK(userCode);
		responseDto.setUserCode(userCode);
		responseDto.setUserName(userInfo == null ? "" : userInfo.getUserName());
		responseDto.setComCode(userInfo == null ? "" : userInfo.getComCode());
	}
	public PrepayPageResDto prepayPageInit(PrepayPageReqDto requestDto) throws Exception {
		/* 入参规则校验及合法性校验 */
		this.verifyParam(requestDto);
		/* 把入参对象中数据复制到返参对象进行传递 */
		PrepayPageResDto responseDto = this.convert(requestDto, PrepayPageResDto.class);
		responseDto.setFlowId(requestDto.getFlowID());
		/* 设置用户信息到返参对象 */
		this.setUserInfo(responseDto);

		/* 如果传立案号，则校验是否有立案信息 */
		PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(responseDto.getClaimNo()));
		if (null == prpLClaim) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("不存在立案号为{}的立案信息，请核对！", responseDto.getClaimNo());
			}
			throw new BusinessException(BusinessException.DataVerifyCatalog,
					"不存在立案号为" + responseDto.getClaimNo() + "的立案信息，请核对！");
		}
		responseDto.setPolicyNo(prpLClaim.getPolicyNo());
		responseDto.setRegistNo(prpLClaim.getRegistNo());
		responseDto.setPrpLClaimDto(this.convert(prpLClaim, PrpLClaimDto.class));

		if ("ADD".equals(responseDto.getEditType())) {
			/* 校验此赔案是否出计算书 */
			this.verifyExistCompensate(responseDto.getClaimNo());
			this.verifyExistPrepay(responseDto.getClaimNo(),responseDto.getNodeStatus());
			/* 进行占号校验 */
			pageInitCommonService.verifyIsHoldNode(responseDto.getFlowId(), responseDto.getLogNo(),
					responseDto.getUserCode(), responseDto.getUserName(), responseDto.getClaimNo());
			/* 获取保费未实收是否允许预赔 */
			int flag = this.verifyPrePay(prpLClaim.getPolicyNo(), prpLClaim.getRiskCode());
			responseDto.setPrePayFlag(flag);
		} else {
			PrpLPrepay prpLPrepay = prpLPrepayDao.findOne(new PrpLPrepayKey(responseDto.getPrepayNo()));
			if (null == prpLPrepay) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("不存特殊赔案号为{}的赔案信息，请核对！", responseDto.getPrepayNo());
				}
				throw new BusinessException(BusinessException.DataVerifyCatalog,
						"不存在特殊赔案号为" + responseDto.getPrepayNo() + "的赔案信息，请核对！");
			}
			PrpLPrepayDtoExt prpLPrepayDtoExt = new PrpLPrepayDtoExt();
			pageInitCommonService.copyPropertiesIfNull(prpLPrepay, prpLPrepayDtoExt);
			responseDto.setPolicyNo(prpLPrepay.getPolicyNo());
			responseDto.setPrpLPrepayDto(prpLPrepayDtoExt);
			//暂存或已提交案件查询关联清单号
			Map<String,String> map = new HashMap<>();
			map.put("preCompensateNo",responseDto.getPrepayNo());
			map.put("pageNo","");
			map.put("pageSize","");
			List<SpecCaseListDto> specCaseListDtoList = specCaseListApi.querySpecCaseListByPreCompensateNo(map).getContent();
			if(specCaseListDtoList!=null && specCaseListDtoList.size()>0){
				double sumPaid = 0;
				String listNo = specCaseListDtoList.get(0).getListNo();
				for(int i=0;i<specCaseListDtoList.size();i++){
					sumPaid += specCaseListDtoList.get(i).getSettleAmount();

				}
				BigDecimal settleAmount = new BigDecimal("0");
				BigDecimal resultAmount = new BigDecimal(sumPaid).setScale(2,BigDecimal.ROUND_HALF_UP);
				settleAmount=settleAmount.add(resultAmount);
				responseDto.setSumPaid(settleAmount+"");
				responseDto.setListNo(listNo);
			}
		}
		/* 组织特殊赔案的主信息（头部分信息显示） */
		this.preparePrepayMain(responseDto);
		/* 设置预赔报告 */
		this.preparePrePayReport(responseDto);
		/* 费用赔款信息 */
		if(StringUtils.isNotEmpty(responseDto.getPrepayNo())) {
			this.preparePreCharge(responseDto);
		}
		/* 设置预赔清单 */
		this.preparePrePaysettleList(responseDto);
		//responseDto.setSumPaid(responseDto.getPrpLClaimDto().getSumPaid() + "");
		//responseDto.setPrpLClaimDto(null);
		responseDto.setPrpLsumpayDtoList(new ArrayList<>());
		int perilCount = pageInitCommonService.getSamePolicyRegistInfo(responseDto.getPolicyNo(), responseDto.getRegistNo());
		responseDto.setPerilCount(perilCount+"");
		return responseDto;
	}
	/**
	 * @description:方法功能简述: 校验是否有核赔未通过的案件
	 * @author 安齐崇
	 * @date 2017年12月7日下午7:46:14
	 * @param claimNo
	 */
	//该赔案下是否存在未审核通过的预赔记录；
	//若以上校验未通过，则系统进行相应提示“该案件下存在未审核通过的预赔案件，预赔单号为******
	private void verifyExistPrepay(String claimNo,String nodeStatus) {
		List<PrpLPrepay> prePayList = prpLPrepayDao.findAll(Specifications.<PrpLPrepay>and().eq("claimNo", claimNo).build());
		if(prePayList != null && prePayList.size()>=1){
			for (PrpLPrepay prpLPrepay : prePayList) {
				if(!"1".equals(prpLPrepay.getUnderWriteFlag()) && !"3".equals(prpLPrepay.getUnderWriteFlag())){
					if (LOGGER.isInfoEnabled()) {
						LOGGER.error("该案件下存在未审核通过或审核不通过的预赔案件，预赔单号为{}",prpLPrepay.getPreCompensateNo());
					}
					throw new BusinessException(
							"该案件下存在未审核通过或不通过的预赔案件，预赔单号为"+prpLPrepay.getPreCompensateNo());
				}
			}
		}
	}
	/**
	 * @description:方法功能简述: 设置预赔清单信息
	 * @author 安齐崇
	 * @date 2017年12月7日下午7:46:14
	 * @param responseDto
	 */
	private void preparePrePaysettleList(PrepayPageResDto responseDto) {
		//TODO   设置清单号
		/*清单号*/
		/*RegisterCoderDto registerCoder = new RegisterCoderDto(responseDto.getClaimNo());
		registerCoder.setValidity(2+"");
		List<SettleMainListDto> settleMainList = settleMainListApi.queryByRegisterCodeAndValidity(registerCoder);*/
		String settleListCode = "";//settleMainList == null?"":settleMainList.get(0).getSettleListCode();
		responseDto.setSettleListCode(settleListCode);
	}
	/**
	 * @description:方法功能简述: 设置费用赔款信息
	 * @author 安齐崇
	 * @date 2017年12月7日下午5:22:08
	 * @param responseDto
	 */
	private void preparePreCharge(PrepayPageResDto responseDto) {
		//List<PrpLPreCharge> prpLPreChargeList = prpLPreChargeDao.findAll(Specifications.<PrpLPreCharge>and().eq("precompensateNo", responseDto.getPrepayNo()).build());
		List<PrpLPreCharge> prpLPreChargeList = prpLPreChargeDao.findAllByPrecompensateNo(responseDto.getPrepayNo());
		List<PrpLPreChargeDtoExt> prpLPreChargeDtoList = new ArrayList<>();
		for(int i = 0;prpLPreChargeList !=null && i< prpLPreChargeList.size();i++){
			PrpLPreCharge prpLPreCharge = prpLPreChargeList.get(i);
			PrpLPreChargeDtoExt chargeDtoExt =new PrpLPreChargeDtoExt();
			if(prpLPreCharge!=null && StringUtils.isNotEmpty(prpLPreCharge.getRiskCode()) && StringUtils.isNotEmpty(prpLPreCharge.getKindCode())) {
				PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpLPreCharge.getRiskCode(), prpLPreCharge.getKindCode());
				chargeDtoExt.setKindName(prpDkindDto == null ? "" : prpDkindDto.getKindCName());
			}
			if(prpLPreCharge!=null && StringUtils.isNotEmpty(prpLPreCharge.getCurrency())) {
				PrpDcurrencyDto prpDcurrencyDto = prpDcurrencyApi.queryByPK(prpLPreCharge.getCurrency());
				chargeDtoExt.setCurrencyName(prpDcurrencyDto == null?"":prpDcurrencyDto.getCurrencyCName());
			}
			pageInitCommonService.copyPropertiesIfNull(prpLPreCharge, chargeDtoExt);
			prpLPreChargeDtoList.add(chargeDtoExt);
    	}
    	responseDto.setPrpLPreChargeDtoList(prpLPreChargeDtoList);
	}
	/**
	 * @description:方法功能简述: 设置预赔报告文本信息
	 * @author 安齐崇
	 * @date 2017年12月7日下午5:21:00
	 * @param responseDto
	 */
    private void preparePrePayReport(PrepayPageResDto responseDto) {
    	List<PrpLPtext> PrpLPtextList = prpLPtextDao.findAll(Specifications.<PrpLPtext>and().eq("preCompensateNo", responseDto.getPrepayNo()).build());
    	String context ="";
    	for (PrpLPtext prpLPtext : PrpLPtextList) {
    		context += prpLPtext.getContext()+"\r\n";
		}
    	responseDto.setContext(context);
	}
	/**
     * @description:方法功能简述: 得到保费未实收是否可以预赔1，可以预赔，0不可以预赔
     * @author 安齐崇
     * @date 2017年12月7日下午5:06:22
     * @param policyNo 保单号
     * @param riskCode 险种号
     * @return flag 1，可以预赔，0不可以预赔
	 * @throws Exception 
     */
	private int verifyPrePay(String policyNo, String riskCode) throws Exception {
		int flag = 0;
		/*-1为未缴费，0为未缴全，1为缴全*/
		int checkPay = pageInitCommonService.checkPay(policyNo);
		String config = prpDriskConfigApi.getConfigValue("00000000", riskCode, "ALLOW_UNPAYED_PREPAY");
		 if(StringUtils.isEmpty(config)){
			 if (LOGGER.isInfoEnabled()) {
					LOGGER.error("{}险种未进行基础数据初始化，请在基础平台系统，险种配置中进行初始化！", riskCode);
				}
				throw new BusinessException(BusinessException.DataVerifyCatalog,riskCode+"险种未进行基础数据初始化，请在基础平台系统，险种配置中进行初始化！");
		  }
		 if(config.equals("2")&&checkPay!=1){
	    	  if("3101".equals(riskCode)){
	    		  flag = 1;//新增操作，屏蔽3101险种特殊赔案时报保费未实付，不允许预赔
	    	  }else{
	              LOGGER.error("保费未实收，系统不允许预赔！缴费校验码:"+checkPay);
	    	  }
	      }else{
	    	/*1表示允许预赔*/
	    	  flag = 1;
	      }
		return flag;
	}

	private void verifyExistCompensate(String claimNo) {
		List<PrpLCompensate> compensateList = prpLCompensateDao
				.findAll(Specifications.<PrpLCompensate> and().eq("claimNo", claimNo).build());
		if (null != compensateList && compensateList.size() > 0) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("立案号为{}的赔案已出计算书，不能再进行预赔！", claimNo);
			}
			throw new BusinessException(BusinessException.DataVerifyCatalog, "立案号为" + claimNo + "的赔案已出计算书，不能再进行预赔！");
		}
	}

	/**
	 * @description:方法功能简述: 组织特殊赔案的主信息（头部分信息显示）
	 * @author 安齐崇
	 * @date 2017年12月7日下午3:25:27
	 * @param responseDto
	 * @throws Exception 
	 */
	private void preparePrepayMain(PrepayPageResDto responseDto) throws Exception {
		PrpLPrepayDtoExt prepayDtoExt = responseDto.getPrpLPrepayDto();
		if (null == prepayDtoExt) {
			prepayDtoExt = new PrpLPrepayDtoExt();
			PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(responseDto.getClaimNo()));
			prepayDtoExt.setArrearageTimes(0);
			prepayDtoExt.setSumArrearage(0d);
			prepayDtoExt.setSumBeforePrepaid(0d);
			prepayDtoExt.setBlockUpTimes(0);
			prepayDtoExt.setSumTotalPrepaid(0d);
			prepayDtoExt.setUnderWriteCode("");
			prepayDtoExt.setUnderwriteName("");
			prepayDtoExt.setUnderWriteendDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			/* 归属业务员 */
			prepayDtoExt.setHandler1Code(responseDto.getUserCode());
			/* 统计年月 */
			prepayDtoExt.setStatisticSym(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			/* 操作员代码 */
			prepayDtoExt.setOperatorCode(responseDto.getUserCode());
			/* 设置预赔操作的状态为 新案件登记 (未处理任务) */
			prepayDtoExt.setStatus("1");
			/*属性拷贝，完善信息*/
			this.pageInitCommonService.copyPropertiesIfNull(prpLClaim, prepayDtoExt);
		} else {
			/* 设置预赔操作的状态为 案件修改 (正处理任务) */
			PrpLclaimStatus statusDto = this.prpLclaimStatusDao
					.findOne(new PrpLclaimStatusKey(responseDto.getClaimNo(), "speci", 5));
			if (null == statusDto) {
				prepayDtoExt.setStatus("4");
			} else {
				if (statusDto.getStatus().equals("7"))
					statusDto.setStatus("3");
				prepayDtoExt.setStatus(statusDto.getStatus());
			}
			/* 从工作流上去状态.以工作流上的为准确 */
			String status = responseDto.getClaimNo();
			if (status != null && !status.equals("")) {
				prepayDtoExt.setStatus(status);
			}
		}
		/*把业务员机构等编码转换成名称*/
		PrpDuserDto handler1Dto = userApi.queryByPK(prepayDtoExt.getHandler1Code());
		String handler1Name = handler1Dto == null ?"":handler1Dto.getUserName();
		/*归属业务员*/
		prepayDtoExt.setHandler1Name(handler1Name);
		if(!prepayDtoExt.getHandler1Code().equals(prepayDtoExt.getHandlerCode())){
			PrpDuserDto handlerDto = userApi.queryByPK(prepayDtoExt.getHandlerCode());
			handler1Name = handlerDto == null ?"":handlerDto.getUserName();
		}
		/*经办人*/
		prepayDtoExt.setHandlerName(handler1Name);
		PrpDcompanyDto companyDto = companyApi.queryCompanyByComCode(prepayDtoExt.getComCode());
		/*业务归属机构*/
		prepayDtoExt.setComName(companyDto == null?"":companyDto.getComCName());
		PrpDcurrencyDto currencyDto = prpDcurrencyApi.queryByPK(prepayDtoExt.getCurrency());
		/*币别中文名*/
		prepayDtoExt.setCurrencyName(currencyDto == null?"":currencyDto.getCurrencyCName());
		responseDto.setPrpLPrepayDto(prepayDtoExt);
	}

	/**
	 * @description:方法功能简述: 校验数据的合法性
	 * @author 安齐崇
	 * @date 2017年11月24日下午5:19:13
	 * @param
	 * @return
	 * @throw Exception
	 */
	private void verifyParam(PrepayPageReqDto requestDto) {
		if (requestDto == null) {
			throw new DataVerifyException("请求参数不能为空!");
		}
		if ("ADD".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getClaimNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型立案号不能为空！");
			}
		} else if ("EDIT".equals(requestDto.getEditType()) || "SHOW".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getPrepayNo())) {
				throw new DataVerifyException(requestDto.getPrepayNo() + "编辑类型特殊赔案号不能为空！");
			}
		} else {
			throw new BusinessException(BusinessException.DataVerifyCatalog, "编辑类型不合法,请选择ADD、EDIT或SHOW编辑类型！");
		}
	}

	/**
	 * @description:方法功能简述: 设置登录用户信息到返回对象
	 * @author 安齐崇
	 * @date 2017年11月16日上午10:53:43
	 * @param responseDto
	 *            返回对象
	 * @throws Exception 
	 */
	private void setUserInfo(PrepayPageResDto responseDto) throws Exception {
		/* 设置用户信息 */
		PrpDuserDto userInfo = userApi.getUserInfo();
		responseDto.setUserCode(userInfo.getUserCode());
		responseDto.setUserName(userInfo == null ? "" : userInfo.getUserName());
		responseDto.setComCode(userInfo == null ? "" : userInfo.getComCode());
	}

	/**
	 * （特殊赔案提交双核）
	 * @author: 王心洋
	 * @date: 2018/2/27
	 * @param prepaySubmitUndwrtXMLDto 提交双核入参
	 * @return 提交成功信息
	 */
	@Override
	public Map<String, String> sendPrepayXMLToUndwrt(PrepaySubmitUndwrtXMLDto prepaySubmitUndwrtXMLDto) throws Exception {
		Map<String,String> map = new HashMap<>();
		String xmlData = "";
		XmlUtil xmlUtil = new XmlUtil();
		PacketDto<PrepaySubmitUndwrtXMLDto> packetDto = new PacketDto<>();
		packetDto.setBody(prepaySubmitUndwrtXMLDto);
		xmlData = xmlUtil.packetDtoToXml_bodyDto(packetDto);

		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
		jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
		NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();
		String getXml = newAgriPrpallUndwrtService.prepaySubmit(xmlData);

		Document document;
		try {
			document = DocumentHelper.parseText(getXml);
		} catch (DocumentException e) {
			throw new BusinessException(e.getMessage());
		}

		Element requestData =document.getRootElement();
		Element flowId = requestData.element("flowId");
		map.put("flowId",flowId.getTextTrim());
		return map;
	}
}