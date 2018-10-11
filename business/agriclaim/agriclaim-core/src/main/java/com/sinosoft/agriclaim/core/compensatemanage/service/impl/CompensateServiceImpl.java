package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLAccIPersonApi;
import com.sinosoft.agriclaim.api.businessutilmanage.PrpLCfeecoinsApi;
import com.sinosoft.agriclaim.api.businessutilmanage.PrpLclaimStatusApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.cetainmanage.PrpLPropApi;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.checkmanage.PrpLverifyLossApi;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimLossApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLCompensateEarApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLLTextApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.compensatemanage.*;
import com.sinosoft.agriclaim.api.compensatemanage.dto.*;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.workflowmanage.SwfLogApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.claimmanage.dao.*;
import com.sinosoft.agriclaim.core.claimmanage.entity.*;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLPersonLossDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateKey;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLPersonLoss;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensatePageCommonService;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensateService;
import com.sinosoft.agriclaim.core.individuation.dao.PrpLsumpayDao;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpay;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.recasemanage.dao.PrpLRecaseDao;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.*;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxBreedClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxClaimPayListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxPlantingClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.SettleMainListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description 计算书业务实现类
 * @author 杨航
 * @date 2017年11月14日
 */
@Service
public class CompensateServiceImpl extends BaseCustomServiceImpl implements CompensateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(CompensateServiceImpl.class);

    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpCdangCoinsApi prpCdangCoinsApi;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private WorkFlowService workFlowService ;
    @Autowired
	private BillNoApi billNoApi;
    @Autowired
    private SwfLogDao swfLogdao ;
    @Autowired
    private SwfLogApi swfLogApi ;
    @Autowired
    private SettleMainListApi settleMainListApi;
    @Autowired
    private PrpLClaimLossApi prpLClaimLossApi ;
    @Autowired
    private PrpLPropApi prpLPropApi ;
    @Autowired
    private PrpLverifyLossApi prpLverifyLossApi ;
    @Autowired
    private PrpLClaimApi prpLClaimApi ;
    @Autowired
    private PrpLCompensateApi prpLCompensateApi ;
    @Autowired
    private PrpLChargeApi prpLChargeApi;
    @Autowired
    private PrpLCompensateEarApi prpLCompensateEarApi ;
    @Autowired
    private PrpLLossApi prpLLossApi ;
    @Autowired
    private PrpLCTextApi prpLCTextApi ;
    @Autowired
    private PrpLCFeeApi prpLCFeeApi ;
    @Autowired
    private PrpLLTextApi prpLLTextApi ;
    @Autowired
    private PrpLAccIPersonApi prpLAccIPersonApi;
    @Autowired
    private PrpLCfeecoinsApi prpLCfeecoinsApi ;
    @Autowired
    private PrpLclaimStatusApi prpLclaimStatusApi ;
    @Autowired
	private PageInitCommonService pageInitCommonService;
    @Autowired
    private PrpLsumpayDao prpLsumpayDao;
    @Autowired
	private PrpLClaimDao prpLClaimDao;
	@Autowired
	private PrpPheadApi prpPheadApi;
	@Autowired
	private PrpLverifyLossDao prpLverifyLossDao;
	@Autowired
	private PrpLPrepayDao prpLPrepayDao;
	@Autowired
	private SwfLogDao swfLogDao;
	@Autowired
	private PrpCmainApi prpCmainApi;
	@Autowired
	private UserApi userApi;
	@Autowired
	private PrpCinsuredApi prpCinsuredApi;
	@Autowired
	private PrpLCompensateEarDao prpLCompensateEarDao;
    @Autowired
    private CompensatePageCommonService compensatePageCommonService;
    @Autowired
    private RiskApi riskApi;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
    private NyxPlantingClaimListApi nyxPlantingClaimListApi;
    @Autowired
	private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
	@Autowired
	private NyxBreedClaimListApi breedClaimListApi;
	@Autowired
	private PrpLRecaseDao prpLRecaseDao;
	@Autowired
	private PrpDitemAgriApi prpDitemAgriApi;
	@Autowired
	private SwfPathLogDao swfPathLogDao;
	@Autowired
	private PrpLDangerUnitDao prpLDangerUnitDao;
	@Autowired
	private PrpLDangerItemDao prpLDangerItemDao;
    @Autowired
	private PrpLDangerTotDao prpLDangerTotDao;
    @Autowired
    private PrpLDangerCoinsDao prpLDangerCoinsDao;
    @Autowired
    private PrpLPersonLossDao prpLPersonLossDao;
	@Autowired
    private PrpCcoinsApi prpCcoinsApi;
	@Autowired
	private NyxClaimPayListApi nyxClaimPayListApi;
	@Autowired
	private PrpLRegistApi prpLRegistApi;
	@Value("${webservice.webAgriPrpallService.url}")
	private String webAgriPrpallServiceUrl;
	@Autowired
	private PrpDuserApi prpDuserApi;
	@Autowired
	private NyxEffectiveAmountApi nyxEffectiveAmountApi;
	@Autowired
	private PrpLRegistDao prpLRegistDao;
	@Autowired
	private SwfLogStoreDao swfLogStoreDao;
	/**
	  * @description 承保需要的服务,根据条件查询计算书信息集合
	  * @author 杨航
	  * @date 2017年11月14日 上午9:46:52
	  * @param prpLCompensateDto 计算书信息入参
	  * @return prpLCompensateDtoList
	 */
	public List<PrpLCompensateDto> queryPrpLCompensateByCondition(PrpLCompensateDto prpLCompensateDto) {
		if (prpLCompensateDto == null) {
			throw new DataVerifyException("查询计算书信息主表入参不许为空!");
		} else if (StringUtils.isEmpty(prpLCompensateDto.getPolicyNo()) && StringUtils.isEmpty(prpLCompensateDto.getCompensateNo())) {
			throw new DataVerifyException("查询计算书信息主表保单号和计算书号不允许同时为空!");
		}
		List<PrpLCompensate> prpLCompensatemList = prpLCompensateDao.findAll(Specifications.<PrpLCompensate>and()
				.eq(StringUtils.isNotEmpty(prpLCompensateDto.getPolicyNo()), "policyNo", prpLCompensateDto.getPolicyNo())
				.eq(StringUtils.isNotEmpty(prpLCompensateDto.getCompensateNo()), "compensateNo", prpLCompensateDto.getCompensateNo()).build());
		List<PrpLCompensateDto> prpLCompensateDtoList = new ArrayList<PrpLCompensateDto>();
		this.convertCollection(prpLCompensatemList, prpLCompensateDtoList, PrpLCompensateDto.class);
		return prpLCompensateDtoList;
	}
    
	/**
	 * @description 理算查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLCompeQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	public PageInfo<SwfLogExtendDto> queryByCompeInDto(PrpLCompeQueryInDto prpLCompeQueryInDto)throws Exception {
		if (prpLCompeQueryInDto == null) {
			throw new BusinessException("prpLCompeQueryInDto对象不允许为null");
		} else {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("compensateNo={},policyNo={},insuredName={},riskCode={},nodeStatus={},flowInTimeStart={}", prpLCompeQueryInDto.getCompensateNo(),
						prpLCompeQueryInDto.getPolicyNo(), prpLCompeQueryInDto.getInsuredName(), prpLCompeQueryInDto.getRiskCode(),
						prpLCompeQueryInDto.getNodeStatus(), prpLCompeQueryInDto.getFlowInTimeStart());
			}
		}
		PageInfo<SwfLogExtendDto> pageInfo=new PageInfo<>();
		Integer pageNo = prpLCompeQueryInDto.getPageNo();
		Integer pageSize = prpLCompeQueryInDto.getPageSize();
		if (pageNo < 1) {
			throw new BusinessException("页码不能小于1");
		}
		if (pageSize < 1) {
			throw new BusinessException("每页数量不能小于1");
		}
		Long totalSizeStrLon = null;
		String conditions;
		String conditionsCount;
		Map<String, Object> paraMap = new HashMap<>();
		if (StringUtils.isNotEmpty(prpLCompeQueryInDto.getNodeStatus()) && ("8".equals(prpLCompeQueryInDto.getNodeStatus()) || "9".equals(prpLCompeQueryInDto.getNodeStatus()))) {
			pageInfo = this.queryCompensateCancelList(prpLCompeQueryInDto);
			return pageInfo;
		}else {
			conditions = getNodeConditionsByNodeNo(prpLCompeQueryInDto,"query",paraMap);
			conditionsCount = getNodeConditionsByNodeNo(prpLCompeQueryInDto,"count",paraMap);
		}
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
				lossName = (String) lossNameQuery.getSingleResult();
			}
			swfLogExtendDtoNew.setLossName(lossName);
			//立案号
			String claimNo = "";
			claimNo = swfLogDto.get(n).getKeyIn();
			swfLogExtendDtoNew.setClaimNo(claimNo);
			//计算书号
			String compensateNo = "";
//			if(!claimNo.equals(swfLogDto.get(n).getKeyOut())){
			List<SwfPathLog> swfPathLogs = swfPathLogDao.queryAllByFlowIdAndStartNodeNo(swfLogDto.get(n).getFlowId(),swfLogDto.get(n).getLogNo());
			if (swfPathLogs.size()>0){
				SwfLogKey swfLogKey = new SwfLogKey();
				swfLogKey.setFlowId(swfLogDto.get(n).getFlowId());
				swfLogKey.setLogNo(swfPathLogs.get(0).getEndNodeNo());
				SwfLog swfLog = swfLogDao.findOne(swfLogKey);
				if (swfLog != null ){
					compensateNo = swfLog.getBusinessNo();
				}
			}
//				compensateNo = swfLogDto.get(n).getKeyOut();
//			}
			swfLogExtendDtoNew.setCompensateNo(compensateNo);
			swfLogExtendDto.add(swfLogExtendDtoNew);
		}
		if(StringUtils.isNotEmpty(prpLCompeQueryInDto.getNodeStatus()) && ("all".equals(prpLCompeQueryInDto.getNodeStatus()) )){
			List<SwfLogExtendDto> swfLogExtendDtoList1 = this.queryCompensateCancelList(prpLCompeQueryInDto).getContent();
			swfLogExtendDto.addAll(swfLogExtendDtoList1);
		}
		// 数据存放dto集合
        pageInfo.setContent(swfLogExtendDto);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(totalSizeStrLon);
        return pageInfo;
	}
	/**
     * @description 理算查询拼接sql
     * @author 闫磊
     * @throws Exception
     * @date 2017年10月20日 17:30:27
     */
	private String getNodeConditionsByNodeNo(PrpLCompeQueryInDto prpLCompeQueryInDto, String flag,Map<String, Object> paraMap)throws Exception {
		String policyNo=prpLCompeQueryInDto.getPolicyNo();
		String claimNo=prpLCompeQueryInDto.getClaimNo();
		String compensateNo=prpLCompeQueryInDto.getCompensateNo();
		String insuredName=prpLCompeQueryInDto.getInsuredName();
		String flowInTimeStart=prpLCompeQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd=prpLCompeQueryInDto.getFlowInTimeEnd();
		String riskType=prpLCompeQueryInDto.getRiskType();
		String nodeStatus=prpLCompeQueryInDto.getNodeStatus();
		String handlerCode=prpLCompeQueryInDto.getHandlerCode();
		StringBuilder stringBuilder = null;
		if("query".equals(flag)){
            stringBuilder = new StringBuilder("SELECT s FROM SwfLog s WHERE s.systemFlag='agri'");
        } else if ("count".equals(flag)) {
            stringBuilder = new StringBuilder("SELECT count(1) FROM SwfLog s WHERE s.systemFlag='agri'");
        }
        //根据案件类型以及当前处理人员拼接查询条件2是正在处理，3是核赔退回
		if(StringUtils.isNotEmpty(nodeStatus) && StringUtils.isNotEmpty(handlerCode)){
			if("2".equals(nodeStatus) || "3".equals(nodeStatus) || "4".equals(nodeStatus)){
				this.addStringCondition("handlerCode",handlerCode,"",stringBuilder,paraMap);
				stringBuilder.append(" and s.nodeType = 'compe'");
			}else if("0".equals(nodeStatus) ){
				stringBuilder.append(" and (s.handlerCode='" + handlerCode + "' or s.handlerCode is null or s.handlerCode='')");
				if(StringUtils.isNotEmpty(policyNo)){
					stringBuilder.append(" and s.registNo in (select registNo from PrpLRegistRPolicy where 1=1  and  policyNo like '").append(policyNo).append("%')");
				}
				stringBuilder.append(" and s.nodeType = 'compe'");
			}else{
				stringBuilder.append(" and (s.handlerCode='" + handlerCode + "' or s.handlerCode is null or s.handlerCode='')");
			}
			if(!"all".equals(nodeStatus)){
				this.addStringCondition("nodeStatus",nodeStatus,"",stringBuilder,paraMap);
			}else{
//				stringBuilder.append(" and ((s.nodeType = 'compp') OR (s.nodeType = 'compe' and s.nodeStatus='0')) ");
				stringBuilder.append(" and (s.nodeType = 'compe') ");
			}
		}else{
			throw new BusinessException("当前操作人或者案件状态为空，查询失败");
		}
		if(StringUtils.isNotEmpty(compensateNo)){
			List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryAllByCompensateNoLike(compensateNo);
			stringBuilder.append(" and s.businessNo in ( ");
			StringBuilder compensateNos = new StringBuilder();
			if (prpLCompensateList.size()>0){
				compensateNos.append("'").append(prpLCompensateList.get(0).getClaimNo()).append("',");
			}
			compensateNos.append(" '1')");
			stringBuilder.append(compensateNos);
		}
		if(StringUtils.isNotEmpty(claimNo)){
			stringBuilder.append(" and s.keyIn like '").append(claimNo).append("%'");
		}
		this.addStringCondition("policyNo",policyNo,"*",stringBuilder,paraMap);
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
		if(StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(compensateNo) && StringUtils.isEmpty(claimNo)){
			stringBuilder.append(" and s.flowInTime between '").append(flowInTimeStart).append(" 00:00:00' and '").append(flowInTimeEnd).append(" 23:59:59' ");
		}
		//工作流状态不能是关闭
		stringBuilder.append(" and s.flowStatus!='0' ");
		//新老系统数据区别标志
//		stringBuilder.append(" and s.systemFlag='agri' ");
        stringBuilder.append(" and s.medicalTransitFlag is null ");
        if ("query".equals(flag)) {
            stringBuilder.append(" order by s.handleTime desc");
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
	 * @description 理算暂存提交
	 * @author 闫磊	
	 * @date 2017年12月8日 
	 * @param  compensateSaveInDto 获取主键的对象
	 * @return map 成功或者失败
	 */
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> saveSubmitBySaveIn(CompensateSaveInDto compensateSaveInDto)throws Exception{

		// 程序思路:
		// ---------------------------------------------------
		// 如果是第一次保存，只要能将状态变成正在处理就行了。。
		// 其他就是在正在处理的状态栏里进行处理了。
		// ---------------------------------------------------
		// 取赔款计算书号
		String compensateNo = ""; // 赔款计算书号
		String ClaimNo=compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo();
		String settleListCode=compensateSaveInDto.getSettleListCode();
		String swfLogFlowID = compensateSaveInDto.getFlowId(); // 工作流号码
		int swfLogLogNo = compensateSaveInDto.getLogNo(); // 工作流logno
		int newCompensate = -1; // 默认不需要重新生成赔款计算书,后来决定不需要用工作流保存每个计算书的状态
		String registNo = "";
		String riskCodeTemp = compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode();
		String caseType = compensateSaveInDto.getPrpLCompensateDtoExt().getCaseType();
		int year = DateTime.current().getYear();
		String comCode = compensateSaveInDto.getPrpLCompensateDtoExt().getComCode();
		String userCode = compensateSaveInDto.getUserCode();
		String userName = compensateSaveInDto.getUserName();
		String imgRiskCode = riskCodeTemp;
		//返回暂存提交信息
		Map<String,Object> map = new HashMap<>();
		//校验是否注销
		//Utils utils = new Utils();//检查内存
		String remark  = "";
		String strClaimNoTemp = compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo();
		String condition = "select s from SwfLog s where flowId = :flowId and nodeType='cance' and nodeStatus in ('0','2') and businessNo= :businessNo";
		Query agentQuery = entityManager.createQuery(condition);
		agentQuery.setParameter("flowId", swfLogFlowID);
		agentQuery.setParameter("businessNo", strClaimNoTemp);
		List<SwfLog> swfLogList = agentQuery.getResultList();
		if(swfLogList!=null&&swfLogList.size()>0){
			throw new BusinessException("案件已经申请注销拒赔！");
		}
		List<SwfLog> swfLogListModify = swfLogdao.findAllByFlowIDAndLogNo(swfLogFlowID,swfLogLogNo);
		SwfLog swfLogmodify = swfLogListModify.get(0);
		if (swfLogmodify.getNodeType().equals("compe")) {
			swfLogmodify.setHandlerCode(userCode);
			swfLogmodify.setHandlerName(userName);
		}
		swfLogApi.modify(this.convert(swfLogmodify, SwfLogDto.class));
		//如果是零赔付校验之前核赔通过计算书的总赔付金额（不含费用）加上本张计算书赔付金额（不含费用）之和是否为零
		String prpLcompensateZeroLossType =  compensateSaveInDto.getPrpLCompensateDtoExt().getZeroLossType(); 
		if("1".equals(prpLcompensateZeroLossType)||"2".equals(prpLcompensateZeroLossType)||"3".equals(prpLcompensateZeroLossType)){
			double sumPid = 0;
			double sumThisPaid = compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid();
			condition = "select s from PrpLCompensate s where claimNo =:claimNo";
			Query agentQueryClaimNo = entityManager.createQuery(condition);
			agentQueryClaimNo.setParameter("claimNo", ClaimNo);
			List<PrpLCompensate> prpLCompensatelist = agentQueryClaimNo.getResultList();
			if(null != prpLCompensatelist && prpLCompensatelist.size()>0){
				for(int i=0;i<prpLCompensatelist.size();i++){
					sumPid += prpLCompensatelist.get(i).getSumThisPaid();
				}
			}
			sumPid += sumThisPaid;
			if(sumPid != 0){
				throw new BusinessException("零赔付赔付金额之和不为零");
			}
		}
		// reason: 防止重复提交 这个暂时没有好的思路，没法处理
		String strLastAccessedTime = "";// + httpServletRequest.getSession().getLastAccessedTime()/1000;
		String oldLastAccessedTime = "";//(String) httpServletRequest.getSession().getAttribute("oldCompensateLastAccessedTime");
		Map<String,String> mapOutCode = new HashMap<String,String>();
		mapOutCode.put("outerCode",riskCodeTemp);
		List<UtiCodeTransferDto> riskList = utiCodeTransferApi.queryUtiCodeTransferDtoByOuterCode(mapOutCode);
		String strRiskType = "I";
		if(riskList.size()>0){
			strRiskType = riskList.get(0).getRiskType();
		}
		if (oldLastAccessedTime.trim().equals("")) {
			// reason: 防止重复提交
			//httpServletRequest.getSession().setAttribute("oldCompensateLastAccessedTime", strLastAccessedTime);
			//防止回退刷新再提交，或多人同时操作提交同一案件。
			condition = "Select s from SwfLog s where flowId = :flowId  and  logNo= :logNo  and nodeStatus ='4'";
			Query certifyQuery = entityManager.createQuery(condition);
			certifyQuery.setParameter("flowId", swfLogFlowID);
			certifyQuery.setParameter("logNo", swfLogLogNo);
			List<SwfLog> certifyNodeList = certifyQuery.getResultList();
			if(certifyNodeList!=null&&certifyNodeList.size()>0){
				throw new BusinessException("该案件计算书节点已处理！");
			}
			// 业务操作
			compensateNo = compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo();
			if (compensateNo == null || compensateNo.length() < 1 || compensateNo.trim().equals("")) {
				String tableName = "prplcompensate";
				BillNoDto billNoDto=new BillNoDto();
				billNoDto.setTableName(tableName);
				billNoDto.setiComCode(comCode);
				billNoDto.setRiskCode(riskCodeTemp);
				billNoDto.setiYear(year+"");
				billNoDto.setUserCode(userCode);
				LOGGER.error("%%%"+tableName+"%%%"+comCode+"%%%"+riskCodeTemp+"%%%"+year+"%%%"+userCode+"%%%");
				//如果重开赔案 单号生成
				if (StringUtils.isNotEmpty(strClaimNoTemp)){
					List<PrpLRecase> prpLRecaseList = prpLRecaseDao.findByClaimNoOrderBySerialNo(strClaimNoTemp);
					if (prpLRecaseList.size()>0){
						List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryAllByClaimNo(strClaimNoTemp);
						if (prpLCompensateList.size()>0){
							String readyCompensateNo = prpLCompensateList.get(0).getCompensateNo();
							int endCompenateNo = prpLRecaseList.size()+1;
							compensateNo = readyCompensateNo.substring(0,21)+"-00"+endCompenateNo;
							//重开赔案将新的计算书号写入prpLRecase
							PrpLRecase prpLRecase = prpLRecaseList.get(0);
							prpLRecase.setCompensateNo(compensateNo);
							prpLRecaseDao.save(prpLRecase);
						}
					}else {
						compensateNo = billNoApi.getBillNo(billNoDto).get("billNo");
					}
				}
				newCompensate = 1; // 生成赔款计算书 这种情况由于是多任务处理，无论何时，都需要新插节点
			}
			//生成计算书号后回写支付清单信息 add by wxy 2018/4/16 begin
			if(StringUtils.isNotEmpty(compensateSaveInDto.getPayBillNo())){
				List<NyxClaimPayListDto> nyxClaimPayListDtoList = nyxClaimPayListApi.queryAllNyxClaimPayListDtoByListNo(compensateSaveInDto.getPayBillNo());
				if(nyxClaimPayListDtoList!=null && nyxClaimPayListDtoList.size()>0){
					for(int i=0;i<nyxClaimPayListDtoList.size();i++){
						nyxClaimPayListDtoList.get(i).setCompensateNo(compensateNo);
						nyxClaimPayListDtoList.get(i).setClaimNo(ClaimNo);
					}
					nyxClaimPayListApi.batchSaveNyxClaimPayList(nyxClaimPayListDtoList);
				}
			}
			//生成计算书号后回写支付清单信息 add by wxy 2018/4/16 end

			// 整理界面输入
			viewToDtoForAgri(compensateSaveInDto,compensateNo);
			boolean checkSumPaid = checkCompensateRelation(compensateSaveInDto);
			if(checkSumPaid){
				throw new BusinessException("" +
						"赔付金额不等于赔款金额加费用！");
			}
			//养殖险判断耳标号是否有进行重复理算
			if(compensateSaveInDto.getPrpLCompensateEarDtoList()!=null&&compensateSaveInDto.getPrpLCompensateEarDtoList().size()>0){
				String sameflag = "false";
				String prpLcompensatePolicyNo = compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo();
				String conditons= "select c from PrpLCompensate c where policyNo=:policyNo and underwriteflag='1'";
				List<PrpLCompensateEarDto> compensateeartDtoList = compensateSaveInDto.getPrpLCompensateEarDtoList();
				Query compensateQuery = entityManager.createQuery(condition);
				compensateQuery.setParameter("policyNo", prpLcompensatePolicyNo);
				List<PrpLCompensate>  prpLcompensateList = compensateQuery.getResultList();
				List<PrpLCompensateDto>  prpLcompensateDtoList = new ArrayList<PrpLCompensateDto>();
				this.convertCollection(prpLcompensateList, prpLcompensateDtoList, PrpLCompensateDto.class);
				if(null!=prpLcompensateDtoList&&prpLcompensateDtoList.size()>0){
					String conditoncompp="select e from  PrpLCompensateEar e where nodeType='compe' and compensateNo in (";
					for(int i=0;i<prpLcompensateDtoList.size();i++){
						PrpLCompensateDto prpLcompensateDto = prpLcompensateDtoList.get(i);
						conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
					}
					conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
					conditoncompp = conditoncompp+") and earno not in (select earNo from PrpLCompensateEar WHERE nodeType = 'compe'  and compensateNo in (";
					for(int i=0;i<prpLcompensateDtoList.size();i++){
						PrpLCompensateDto prpLcompensateDto = prpLcompensateDtoList.get(i);
						conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
					}
					conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
					conditoncompp = conditoncompp+") group by earNo having mod(count(earNo),2) = 0)";
					Query earQuery = entityManager.createNativeQuery(conditoncompp);
					List<PrpLCompensateEarDto> eartDtoList = earQuery.getResultList();
					for(int j=0;j<compensateeartDtoList.size();j++){
						PrpLCompensateEarDto  thisearDto  =	compensateeartDtoList.get(j);
						String earNo = thisearDto.getEarNo();
						Double lossesNumber  = compensateSaveInDto.getPrpLCompensateDtoExt().getLossesNumber();
						if(lossesNumber<0){
							sameflag = "false";
						}
						else{
							for(int k=0;k<eartDtoList.size();k++){
								PrpLCompensateEarDto earDto = eartDtoList.get(k);
								if(earNo.equals(earDto.getEarNo())){
									sameflag = "true";
									break;
								}
							}
						}
					}
				}
				//查询本次理算提交时候耳标号是否在历史理算提交的立标号中存在
				if(null!=sameflag&&"true".equals(sameflag)){
					throw new BusinessException("本计算书存在已经赔付的耳标号！");
				}
			}
			// 农险统计制度
			String claimNo = compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo();
			condition = "select c from PrpLClaim c where claimNo = :claimNo";
			Query claimNoQuery = entityManager.createQuery(condition);
			claimNoQuery.setParameter("claimNo", claimNo);
			List<PrpLClaim> prpLClaim = claimNoQuery.getResultList();
			PrpLClaimDto prpLClaimDto = this.convert(prpLClaim.get(0), PrpLClaimDto.class);
			String businessType = prpLClaimDto.getBusinessType();
			String businessType1 = prpLClaimDto.getBusinessType1();
			String businessFlag  = prpLClaimDto.getBusinessFlag();
			String otherFlag	 = prpLClaimDto.getOtherFlag();
			compensateSaveInDto.getPrpLCompensateDtoExt().setBusinessType(businessType);
			compensateSaveInDto.getPrpLCompensateDtoExt().setBusinessType1(businessType1);
			compensateSaveInDto.getPrpLCompensateDtoExt().setBusinessFlag(businessFlag);
			compensateSaveInDto.getPrpLCompensateDtoExt().setOtherFlag(otherFlag);
			SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			swfLogTransferDto.setUserUserCode(userCode);
			swfLogTransferDto.setUserComCode(comCode);
			swfLogTransferDto.setUserUserName(userName);
			swfLogTransferDto.setUserComName(prpDcompanyApi.queryByPK(comCode).getComCName());
			swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
			swfLogDtoDealNode.setNodeStatus(compensateSaveInDto.getButtonSaveType());
			PrpLClaim prpLClaim1 = prpLClaim.get(0);
			prpLClaim1.setGrowthPeriod(compensateSaveInDto.getPrpLCompensateDtoExt().getGrowthPeriod());
			prpLClaim1.setDamageWay(compensateSaveInDto.getPrpLCompensateDtoExt().getDamageWay());
			prpLClaim1.setDamageDegree(compensateSaveInDto.getPrpLCompensateDtoExt().getDamageDegree());
			prpLClaim1.setEndCaseFlag(compensateSaveInDto.getPrpLCompensateDtoExt().getFinallyFlag());
			prpLClaimDao.save(prpLClaim1);
			// 子任务的处理 ,单个赔款计算书的处理
			if (!swfLogFlowID.equals("null") && swfLogLogNo>0) {
				swfLogDtoDealNode.setFlowId(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(swfLogLogNo);
			}
			if (newCompensate == 1) {
				swfLogDtoDealNode.setBusinessNo(claimNo); // 本节点的查找
				swfLogDtoDealNode.setNextBusinessNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
				swfLogTransferDto.setNextBusinessNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
			} else {
				swfLogDtoDealNode.setBusinessNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo()); // 本节点的查找
				swfLogDtoDealNode.setNextBusinessNo(claimNo);
				swfLogTransferDto.setNextBusinessNo(compensateNo);
			}
			swfLogDtoDealNode.setKeyIn(claimNo);
			swfLogDtoDealNode.setNodeStatus(compensateSaveInDto.getButtonSaveType());
			swfLogDtoDealNode.setKeyOut(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
			// reason:如果是特殊赔案进行的核赔提交，则需要将businessno转换成计算书号码。
			if (("3".equals(caseType) || "4".equals(caseType) || "6".equals(caseType)) && "4".equals(swfLogDtoDealNode.getNodeStatus())) {
				swfLogDtoDealNode.setNextBusinessNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
				swfLogTransferDto.setNextBusinessNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
			}
			//swfLogDao.deleteByFlowIdAndLogNo(swfLogFlowID,swfLogLogNo+1);
			WorkFlowDto workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
			// 保存赔款计算书信息
			compensateSaveInDto.getPrpLCompensateDtoExt().setFinallyFlag("1");
			int vericLogNo = 0;
			if (workFlowService.checkDealDto(workFlowDto)) {
				// 增加对核保核赔系统的接口调用。
				if ("4".equals(swfLogDtoDealNode.getNodeStatus())) {
					// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态。
					// 提交前的暂时保存
					WorkFlowDto workFlowDtoTemp = null;
					swfLogDtoDealNode.setNodeStatus("2");
					workFlowDtoTemp = workFlowService.viewToDto(swfLogTransferDto);
					// 暂存计算书节点时将理算节点状态置为已处理
					SwfLogDto swfLogDto = this.convert(swfLogdao.findAllByFlowIDAndLogNo(swfLogFlowID, swfLogLogNo).get(0), SwfLogDto.class);
					map.put("swfLogDto",swfLogDto);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
						workFlowDtoTemp.setUpdate(true);
						workFlowDtoTemp.setUpdateSwfLogDto(swfLogDto);
					}
					// 如果提交核赔失败则状态为0
					compensateSaveInDto.getPrpLCompensateDtoExt().setUnderWriteFlag("0");
					checkPrpLChargeDto(compensateSaveInDto);
					save(compensateSaveInDto, workFlowDtoTemp);
					// 如果提交核赔则状态为9
					if ("4".equals(compensateSaveInDto.getButtonSaveType())) {
						compensateSaveInDto.getPrpLCompensateDtoExt().setUnderWriteFlag("9");
					}

					// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态，但是发送双核成功后，需要变更成提交数据。
					if (newCompensate == 1) { // 要整理新的workFlowDto为提交的状态。
						// 休整 workFlowDtoTemp 和workFlowDto
						int newCompeLogNo = 0;
						if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
							newCompeLogNo = ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
							((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus("4");
							workFlowDto.setUpdate(true);
							workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
						}
						if (workFlowDto.getSubmitSwfLogDtoList() != null) {
							// 删除多余的点
							for (int i = 0; i < workFlowDto
									.getSubmitSwfLogDtoList().size(); i++) {
								if (((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(i)).getLogNo() == newCompeLogNo) {
									workFlowDto.getSubmitSwfLogDtoList().remove(i);
									break;
								}
							}
						}
						if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
							// 删除多余的边
							for (int i = 0; i < workFlowDto.getSubmitSwfPathLogDtoList().size(); i++) {
								if ((workFlowDto.getSubmitSwfPathLogDtoList().get(i)).getEndNodeNo() == newCompeLogNo) {
									workFlowDto.getSubmitSwfPathLogDtoList().remove(i);
									break;
								}
							}
						}
					}
				}
				// 此处修改理算节点状态，主要在理算暂存时使用。
				SwfLogDto swfLogDto = this.convert(swfLogdao.findAllByFlowIDAndLogNo(swfLogFlowID, swfLogLogNo).get(0), SwfLogDto.class);
				registNo = swfLogDto.getRegistNo();
				if (swfLogDto.getNodeType().equals("compe") && "2".equals(compensateSaveInDto.getButtonSaveType())) {
					swfLogDto.setNodeStatus("2");
					swfLogDto.setHandlerCode(userCode);
					swfLogDto.setHandlerName(userName);
					workFlowDto.setUpdate(true);
					workFlowDto.setUpdateSwfLogDto(swfLogDto);
				}
				//add by hu 20120116 begin Reason：内存检查这个不知道有用没，暂时注掉
				remark = "理算书号："+compensateNo+" 保存开始";
				//utils.getPhisicaMemory(remark);
				//add by hu 20120116 begin end：内存检查
				checkPrpLChargeDto(compensateSaveInDto);
				workFlowDto.getUpdateSwfLogDto().setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
				save(compensateSaveInDto, workFlowDto);
				//add by hu 20120116 begin Reason：内存检查
				remark = "理算书号："+compensateNo+" 保存结束";
				//utils.getPhisicaMemory(remark);
				//add by hu 20120116 begin end：内存检查
				compensateSaveInDto.getPrpLCompensateDtoExt().setRemark("remark");
				//user.setUserMessage(compensateNo);
				//流程查询表理算节点信息保存
				if("4".equals(compensateSaveInDto.getButtonSaveType())){//提交
					workProcessService.saveWorkProcessCompensate(registNo, compensateNo, "compe", "compp", userCode);
				}else{//暂存
					workProcessService.saveWorkProcessCompensate(registNo, compensateNo, "compe", "compe", userCode);
				}
				//流程查询表理算节点信息保存
			} else {
				workFlowDto = null;
				checkPrpLChargeDto(compensateSaveInDto);
				this.save(compensateSaveInDto,workFlowDto);
				//user.setUserMessage(compensateNo + ";注意:没有发现与工作流流程相关任何数据！！");
			}
			//生成危险单位
			Map<String,String> map1 = new HashMap<>();
			map1.put("policyNo",prpLClaimDto.getPolicyNo());
			PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map1);
			if (prpCmainDto!= null && "0".equals(prpCmainDto.getCoinsFlag())){
				this.getLDangerInfoNewC(compensateNo);
			}else {
				PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
				prpLCompensateKey.setCompensateNo(compensateNo);
				PrpLCompensateDto prpLCompensateDto =this.convert(prpLCompensateDao.findOne(prpLCompensateKey),PrpLCompensateDto.class);
				this.getCDangerInfo(prpLCompensateDto);
			}

			Map<String,String> txnList = new HashMap<String,String>();
			txnList.put("listNo", settleListCode);
			txnList.put("compensateNo", compensateNo);
			if(settleListCode!=null && !"".equals(settleListCode)){
				String riskcodes = compensateNo.substring(1, 5);
				String classCodes =compensateNo.substring(1, 3);
				if("32".equals(classCodes)&&!"3224".equals(riskcodes)&&!"3237".equals(riskcodes)){
					breedClaimListApi.updateNyxBreedClaimListCompensateNo(txnList);
				}else{
					nyxPlantingClaimListApi.updateNyxPlantingClaimListCompensateNo(txnList);
				}
			}
			if(null!=compensateSaveInDto.getPrpLCompensateDtoExt()&&null!=compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode()&&!"".equals(compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode())){
				String classCodeForTemp = compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode().substring(0, 2);
				if("32".equals(classCodeForTemp)){
					String conditionClaimNo = "select c from PrpLClaim c where claimNo = :claimNo and autoFlag = '1'";
					Query queryClaimNo = entityManager.createQuery(conditionClaimNo);
					queryClaimNo.setParameter("claimNo", ClaimNo);
					if(queryClaimNo.getResultList().size()>0){
						PrpLClaimDto claimDtoForTemp = prpLClaimApi.queryByPK(claimNo);
						String registNoForTemp = claimDtoForTemp.getRegistNo();
						PrpLClaimLossDto claimlossDtoForTemp = prpLClaimLossApi.queryByPK(ClaimNo, 1);
						PrpLverifyLossDto verifyLossDtoForTemp = prpLverifyLossApi.queryByPK(registNoForTemp, "-2");
						String conditionPrp = "select p from PrpLProp p where serialNo = :serialNo and registNo = :registNo";
						Query queryPrp = entityManager.createQuery(conditionPrp);
						queryPrp.setParameter("serialNo", 1);
						queryPrp.setParameter("registNo", registNoForTemp);
						PrpLPropDto propDtoForTemp = this.convert(queryPrp.getResultList().get(0), PrpLPropDto.class);
						if(null != claimDtoForTemp){
							claimDtoForTemp.setSumClaim(compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid());
							claimDtoForTemp.setLossesNumber(compensateSaveInDto.getPrpLCompensateDtoExt().getLossesNumber());
							claimDtoForTemp.setDamageInsured(compensateSaveInDto.getPrpLCompensateDtoExt().getDamageInsured());
							claimDtoForTemp.setDeathQuantity(compensateSaveInDto.getPrpLCompensateDtoExt().getDeathQuantity());
							claimDtoForTemp.setKillQuantity(compensateSaveInDto.getPrpLCompensateDtoExt().getKillQuantity());
							prpLClaimApi.modify(claimDtoForTemp);
						}
						if(null != claimlossDtoForTemp){
							claimlossDtoForTemp.setKindLoss(compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid());
							claimlossDtoForTemp.setSumClaim(compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid());
							prpLClaimLossApi.modify(claimlossDtoForTemp);
						}
						if(null != verifyLossDtoForTemp){
							boolean needupdate = false;
							double lossesNumbertemp = verifyLossDtoForTemp.getLossEsnumBer();
							if(lossesNumbertemp == 0){
								verifyLossDtoForTemp.setLossEsnumBer(compensateSaveInDto.getPrpLCompensateDtoExt().getLossesNumber());
								needupdate = true;
							}
							double damageInsuredtemp = verifyLossDtoForTemp.getDamageInsured();
							if(damageInsuredtemp == 0){
								verifyLossDtoForTemp.setDamageInsured(compensateSaveInDto.getPrpLCompensateDtoExt().getDamageInsured());
								needupdate = true;
							}
							double DeathQuantitytemp = verifyLossDtoForTemp.getDeathQuantity();
							if(DeathQuantitytemp == 0){
								verifyLossDtoForTemp.setDeathQuantity(compensateSaveInDto.getPrpLCompensateDtoExt().getDeathQuantity());
								needupdate = true;
							}
							double KillQuantitytemp = verifyLossDtoForTemp.getKillQuantity();
							if(KillQuantitytemp == 0){
								verifyLossDtoForTemp.setKillQuantity(compensateSaveInDto.getPrpLCompensateDtoExt().getKillQuantity());
								needupdate = true;
							}
							if(needupdate){
								prpLverifyLossApi.modify(verifyLossDtoForTemp);
							}
						}
						if(null != propDtoForTemp){
							double sumlosstemp = propDtoForTemp.getSumLoss();
							if(sumlosstemp == 0){
								propDtoForTemp.setSumLoss(compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid());
								propDtoForTemp.setSumdefLoss(compensateSaveInDto.getPrpLCompensateDtoExt().getSumThisPaid());
								prpLPropApi.modify(propDtoForTemp);
							}
						}
					}
				}
			}
			String insuredName = "";
			if (workFlowDto.getSubmitSwfLogDtoList() != null && workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
				vericLogNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo();
				registNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getRegistNo();
				insuredName = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getInsuredName();
			}
			Map<String,String> policyMap = new HashMap<String,String>();
			policyMap.put("policyNo", compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo());
			List<PrpCinsuredDto> prpCinsuredList = prpCinsuredApi.queryByPolicyNo(policyMap);
			String insuredCode = "";
			String identifyType = "";
			String identifyNumber = "";
			if(prpCinsuredList!=null && prpCinsuredList.size()>0){
				for(int s=0;s<prpCinsuredList.size();s++){
					if("1".equals(prpCinsuredList.get(s).getInsuredFlag())){
						insuredCode = prpCinsuredList.get(s).getInsuredCode();
						identifyType = prpCinsuredList.get(s).getIdentifyType();
						identifyNumber = prpCinsuredList.get(s).getIdentifyNumber();
					}
				}
			}else{
				throw new BusinessException("请确保本保单在承保系统有效");
			}
			//准备提交双核入参
			map.put("flowId",workFlowDto.getUpdateSwfLogDto().getFlowId());
			map.put("vericLogNo",String.valueOf(vericLogNo));
			map.put("userCode",userCode);
			map.put("registNo",registNo);
			if (StringUtils.isNotEmpty(identifyType)){
				map.put("identifyType",identifyType);
			}else {
				map.put("identifyType","");
			}
			if (StringUtils.isNotEmpty(identifyNumber)){
				map.put("identifyNumber",identifyNumber);
			}else {
				map.put("identifyNumber","");
			}
			if (StringUtils.isNotEmpty(insuredCode)){
				map.put("insuredCode",insuredCode);
			}else {
				map.put("insuredCode","");
			}
			if (StringUtils.isNotEmpty(insuredName)){
				map.put("insuredName",insuredName);
			}else {
				map.put("insuredName","");
			}
			map.put("compensateNo",compensateNo);
		} else {
			throw new BusinessException("请不要重复提交");
		}
		return map;
	}

	private void checkPrpLChargeDto(CompensateSaveInDto compensateSaveInDto){
		List<PrpLChargeDto> prpLChargeDtoList = compensateSaveInDto.getPrpLChargeDtoExtList();
		List<PrpLChargeDto> prpLChargeDtoListNew = new ArrayList<>();
		if(prpLChargeDtoList!=null) {
			for (int i = 0; i < prpLChargeDtoList.size(); i++) {
				PrpLChargeDto prpLchargeDto = prpLChargeDtoList.get(i);
				prpLchargeDto.setCompensateNo(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
				prpLchargeDto.setSerialNo(i);
				prpLchargeDto.setRiskCode(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo().substring(1, 5));
				prpLChargeDtoListNew.add(prpLchargeDto);
			}
		}
		compensateSaveInDto.setPrpLChargeDtoExtList(prpLChargeDtoListNew);
	}

	/**
	 * （理算提交双核实现方法）
	 * @author: 王志文
	 * @date: 2018/2/26 14:49
	 * @param compensateSaveInDto
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveSubmitBySave(CompensateSaveInDto compensateSaveInDto)throws Exception{
		Map<String,Object> map;
		Map<String,Object> returnMap;
		if ("4".equals(compensateSaveInDto.getButtonSaveType())){
			map = this.saveSubmitBySaveIn(compensateSaveInDto);
			returnMap = this.readySubUndwrt(compensateSaveInDto,map);
		}else {
			returnMap = this.saveSubmitBySaveIn(compensateSaveInDto);
		}
		if("2".equals(compensateSaveInDto.getButtonSaveType())){
			returnMap.put("code", "0000");
			returnMap.put("message", "暂存成功");
		}
		returnMap.put("compensateNo", compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());
		return returnMap;
	}

	/**
	 * （准备理算提交双核）
	 * @author: 王志文
	 * @date: 2018/2/26 14:47
	 * @param compensateSaveInDto 页面入参
	 * @param map 入参
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String,Object> readySubUndwrt(CompensateSaveInDto compensateSaveInDto,Map<String,Object> map)throws Exception{
		// add 调用双核 需要加入汪钊的代码，好像要引入新对象的
		SwfLogDto swfLogDto = (SwfLogDto) map.get("swfLogDto");
		try{
			CompensateSubmitUndwrtXMLDto compensateSubmitUndwrtXMLDto;
			compensateSubmitUndwrtXMLDto = new CompensateSubmitUndwrtXMLDto(map.get("flowId").toString(),
					map.get("vericLogNo").toString() + "",
					"22",
					"C",
					compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getClassCode(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getComCode(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getMakeCom(),
					map.get("userCode").toString(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getHandlerCode(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getHandler1Code(),
					"",
					map.get("registNo").toString(),
					"1",
					map.get("identifyType").toString(),
					map.get("identifyNumber").toString(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo(),
					map.get("insuredCode").toString(),
					map.get("insuredName").toString(),
					compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo(),
					"","AgriClaim");
			String UWflowID = this.sendCompensateXMLToUndwrt(compensateSubmitUndwrtXMLDto).get("flowId");
			if (UWflowID.length() < 15) {
				String msg = "案件'" + map.get("compensateNo") + "'提交双核系统失败，请重新提交或者与管理员联系!";
				throw new BusinessException(msg);
			}
		}catch (Exception e){
			swfLogDto.setNodeStatus("2");
			swfLogDao.save(this.convert(swfLogDto,SwfLog.class));
			SwfLogKey swfLogKey = new SwfLogKey();
			swfLogKey.setFlowId(swfLogDto.getFlowId());
			swfLogKey.setLogNo(swfLogDto.getLogNo()+1);
			SwfLog swfLog =  swfLogDao.findOne(swfLogKey);
			swfLog.setNodeStatus("2");
			swfLogDao.save(swfLog);
			//添加核赔节点回写
			/*List<SwfLog> swfLogList = swfLogDao.findByNodeTypeAndRegistNoAndNodeStatus("veric",swfLogDto.getRegistNo(),"0");
			if(swfLogList!=null&&swfLogList.size()>0) {
				swfLogDao.deleteByFlowIdAAndLogNo(swfLogDto.getFlowId(), swfLogList.get(0).getLogNo());
			}*/
			PrpLCompensateDto prpLCompensateDto = prpLCompensateApi.queryByPK(map.get("compensateNo").toString());
			prpLCompensateDto.setUnderWriteFlag("0");
			prpLCompensateDao.save(this.convert(prpLCompensateDto,PrpLCompensate.class));
			map.put("code","8888");
            map.put("compensateNo",prpLCompensateDto.getCompensateNo());
			map.put("message","提交失败，已转为暂存，理算书号为："+prpLCompensateDto.getCompensateNo());
//			return map;
			throw new BusinessException("提交失败,"+e.getMessage()+"已转为暂存，理算书号为："+prpLCompensateDto.getCompensateNo());
		}
    	return map;
	}

	/**
	 * @param compensateSaveInDto
	 * @param compensateNo 计算书号
	 */
	private void viewToDtoForAgri(CompensateSaveInDto compensateSaveInDto, String compensateNo) {
		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		String caseType = compensateSaveInDto.getPrpLCompensateDtoExt().getCaseType();
		if (caseType != null && !caseType.equals("null")) {
			if (caseType.trim().equals("3") || caseType.trim().equals("4")
					|| caseType.trim().equals("6")) {
				prpLclaimStatusDto.setTypeflag(caseType);
				prpLclaimStatusDto.setNodetype("speci");
				prpLclaimStatusDto.setSerialno(Integer.parseInt(DataUtils
						.nullToZero(caseType)));
			} else {
				prpLclaimStatusDto.setNodetype("compe");
				prpLclaimStatusDto.setSerialno(0);
				prpLclaimStatusDto.setTypeflag("2");
			}
		} else {
			prpLclaimStatusDto.setNodetype("compe");
			prpLclaimStatusDto.setSerialno(0);
			prpLclaimStatusDto.setTypeflag("2");
		}
		prpLclaimStatusDto.setStatus(compensateSaveInDto.getButtonSaveType());
		prpLclaimStatusDto.setPolicyno(compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo());
		prpLclaimStatusDto.setRiskcode(compensateSaveInDto.getPrpLCompensateDtoExt().getRiskCode());

		// 取得当前用户信息，写操作员信息到实赔中
		prpLclaimStatusDto.setHandlercode(SinoRequestContext.getCurrentContext().getUser().getUserCode());
		// prpLclaimStatusDto.setHandlerCode(prpLcompensateDto.getOperatorCode()
		// );
		prpLclaimStatusDto.setInputdate(compensateSaveInDto.getPrpLCompensateDtoExt().getInputDate());
		prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		compensateSaveInDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		compensateSaveInDto.getPrpLCompensateDtoExt().setCompensateNo(compensateNo);
		if(compensateSaveInDto.getPrpLCompensateEarDtoList() != null && compensateSaveInDto.getPrpLCompensateEarDtoList().size()>0){
			for(PrpLCompensateEarDto prpLCompensateEarDto : compensateSaveInDto.getPrpLCompensateEarDtoList()){
				prpLCompensateEarDto.setCompensateNo(compensateNo);
			}
		}
		compensateSaveInDto.getPrpLclaimStatusDto().setBusinessno(compensateNo);
		if(compensateSaveInDto.getPrpLLossDtoList() != null && compensateSaveInDto.getPrpLLossDtoList().size()>0){
			for(PrpLLossDto prpLLossDto : compensateSaveInDto.getPrpLLossDtoList()){
				prpLLossDto.setCompensateNo(compensateNo);
			}
		}
		if(compensateSaveInDto.getPrpLagriPersonList() != null && compensateSaveInDto.getPrpLagriPersonList().size()>0){
			for(PrpLAccIPersonDto prpLAccIPersonDto : compensateSaveInDto.getPrpLagriPersonList()){
				prpLAccIPersonDto.setCertiNo(compensateNo);
			}
		}
		if(compensateSaveInDto.getPrpLCFeeDtoList() != null && compensateSaveInDto.getPrpLCFeeDtoList().size()>0){
			for(PrpLCFeeDto prpLCFeeDto : compensateSaveInDto.getPrpLCFeeDtoList()){
				prpLCFeeDto.setCompensateNo(compensateNo);
			}
		}
		if(compensateSaveInDto.getPrpLLossDtoList()!=null && compensateSaveInDto.getPrpLLossDtoList().size()>0){
			for(PrpLLossDto prpLLossDto : compensateSaveInDto.getPrpLLossDtoList()){
				prpLLossDto.setCompensateNo(compensateNo);
			}
		}
		if(compensateSaveInDto.getPrpLChargeDtoExtList()!=null && compensateSaveInDto.getPrpLChargeDtoExtList().size()>0){
			for(PrpLChargeDto prpLChargeDto : compensateSaveInDto.getPrpLChargeDtoExtList()){
				prpLChargeDto.setCompensateNo(compensateNo);
			}
		}
		List<PrpLCTextDto> prpLctextDtoList = new ArrayList<PrpLCTextDto>();
		//理算过程
		String TextTemp = compensateSaveInDto.getContextPayCalcul();
		String[] rules = StringGyUtils.split(TextTemp, 70);
		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < rules.length; k++) {
			PrpLCTextDto prpLctextDto = new PrpLCTextDto();
			prpLctextDto.setCompensateNo(compensateNo);
			prpLctextDto.setContext(rules[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("7");//审核批文
			prpLctextDtoList.add(prpLctextDto);
		}
		//付款说明
		TextTemp = compensateSaveInDto.getContextPayText();
		rules = StringGyUtils.split(TextTemp, 70);
		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < rules.length; k++) {
			PrpLCTextDto prpLctextDto = new PrpLCTextDto();
			prpLctextDto.setCompensateNo(compensateNo);
			prpLctextDto.setContext(rules[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("4");
			prpLctextDtoList.add(prpLctextDto);
		}
		compensateSaveInDto.setPrpLctextList(prpLctextDtoList);
		List<PrpLLTextDto> prpLltextDtoList = new ArrayList<PrpLLTextDto>();
        TextTemp = compensateSaveInDto.getContextReport();
        rules = StringGyUtils.split(TextTemp, 70);
        //得到连接串,下面将其切分到数组
        for (int k = 0; k < rules.length; k++) {
            PrpLLTextDto prpLltextDto = new PrpLLTextDto();
            prpLltextDto.setClaimNo(compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo());
            prpLltextDto.setContext(rules[k]);
            prpLltextDto.setLineNo(k + 1);
            prpLltextDto.setTextType("08");
            prpLltextDtoList.add(prpLltextDto);
        }
        compensateSaveInDto.setPrpLLTextDtoList(prpLltextDtoList);
        PrpLClaimDto prpLClaimDto = null;
        if("4".equals(compensateSaveInDto.getButtonSaveType())){
        	prpLClaimDto = new PrpLClaimDto();
        	prpLClaimDto.setClaimNo(compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo());
        	prpLClaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(compensateSaveInDto.getSumPrePaid())));
        }
        compensateSaveInDto.setPrpLClaimDto(prpLClaimDto);
        if(compensateSaveInDto.getPrpLsumpayDtoList() != null && compensateSaveInDto.getPrpLsumpayDtoList().size()>0){
        	for(PrpLsumpayDto prpLsumpayDto : compensateSaveInDto.getPrpLsumpayDtoList()){
        		prpLsumpayDto.setCompensateNo(compensateNo);
        	}
        }
	}

	/**
	 * 
	 * @param compensateSaveInDto
	 * @param workFlowDtoTemp
	 * @throws Exception 
	 */
	@Transactional(rollbackFor = Exception.class)
	private void save(CompensateSaveInDto compensateSaveInDto, WorkFlowDto workFlowDtoTemp) throws Exception {
		this.save(compensateSaveInDto);
		//暂存会生成重复计算书节点
		if (StringUtils.isNotEmpty(compensateSaveInDto.getButtonSaveType()) && "2".equals(compensateSaveInDto.getButtonSaveType())){
			Long comppCount = swfLogDao.findComppCountByFlowId(compensateSaveInDto.getFlowId());
			if (comppCount>0){
				List<SwfLogDto> swfLogDtoList = workFlowDtoTemp.getSubmitSwfLogDtoList();
				workFlowDtoTemp.setSubmitSwfLogDtoList(new ArrayList<>());
				workFlowDtoTemp.setSubmitSwfPathLogDtoList(new ArrayList<>());
				workFlowDtoTemp.setUpdateSwfLogDtoList(swfLogDtoList);
			}
		}
		//暂存后提交时也会重复生成计算书节点
		if (StringUtils.isNotEmpty(compensateSaveInDto.getButtonSaveType()) && "4".equals(compensateSaveInDto.getButtonSaveType())){
			Long comppCount = swfLogDao.findComppCountByFlowId(compensateSaveInDto.getFlowId());
			if (comppCount>0){
				/*if (workFlowDtoTemp.getSubmitSwfLogDtoList().size()==2){
					List<SwfLogDto> submitSwfLogDtoList = new ArrayList<>();
					Integer logNo1 = workFlowDtoTemp.getSubmitSwfLogDtoList().get(0).getLogNo();
					Integer logNo2 = workFlowDtoTemp.getSubmitSwfLogDtoList().get(1).getLogNo();
					submitSwfLogDtoList = workFlowDtoTemp.getSubmitSwfLogDtoList();
					submitSwfLogDtoList.get(0).setLogNo(logNo2);
					submitSwfLogDtoList.get(1).setLogNo(logNo1);
					workFlowDtoTemp.setSubmitSwfLogDtoList(submitSwfLogDtoList);
				}*/
				if (workFlowDtoTemp.getSubmitSwfPathLogDtoList().size()==2){
					List<SwfPathLogDto> submitSwfPathLogDtoList = new ArrayList<>();
					Integer pathNo1 = workFlowDtoTemp.getSubmitSwfPathLogDtoList().get(0).getPathNo();
					Integer pathNo2 = workFlowDtoTemp.getSubmitSwfPathLogDtoList().get(1).getPathNo();
					submitSwfPathLogDtoList = workFlowDtoTemp.getSubmitSwfPathLogDtoList();
					submitSwfPathLogDtoList.get(0).setPathNo(pathNo2);
					submitSwfPathLogDtoList.get(1).setPathNo(pathNo1);
					workFlowDtoTemp.setSubmitSwfPathLogDtoList(submitSwfPathLogDtoList);
				}
			}
		}
		if(workFlowDtoTemp!=null){
			workFlowService.deal(workFlowDtoTemp);
		}
	}

	/**
	 * 
	 * @param compensateSaveInDto
	 * @throws Exception 
	 */
	private void save(CompensateSaveInDto compensateSaveInDto) throws Exception {
		if (compensateSaveInDto.getPrpLCompensateDtoExt() == null) {
            throw new Exception();
        }
		List<PrpLClaim> prpLClaims = prpLClaimDao.queryVagueListByClaimNo(compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo());
		compensateSaveInDto.getPrpLCompensateDtoExt().setRegistNo(prpLClaims.get(0).getRegistNo());
		//首先删除原来的相关数据
        //deleteSubInfo(compensateSaveInDto);
		if(compensateSaveInDto.getPrpLCompensateDtoExt() != null){
			String riskcode=compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo().substring(1,5);
			String classcode=compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo().substring(1,3);
			if("31".equals(classcode) || "3224".equals(riskcode) || "3237".equals(riskcode)){
				compensateSaveInDto.getPrpLCompensateDtoExt().setLossesUnitCode("11");
				compensateSaveInDto.getPrpLCompensateDtoExt().setDisasterUnit("11");
				compensateSaveInDto.getPrpLCompensateDtoExt().setAffectedUnit("11");
				compensateSaveInDto.getPrpLCompensateDtoExt().setNoProductionUnit("11");
			}else{
				compensateSaveInDto.getPrpLCompensateDtoExt().setDisasterUnit("13");
				compensateSaveInDto.getPrpLCompensateDtoExt().setKillUnit("13");
			}
			if(compensateSaveInDto.getPrpLCompensateDtoExt().getIsVericBack()==null){
				compensateSaveInDto.getPrpLCompensateDtoExt().setIsVericBack("0");
			}
		}
        prpLCompensateApi.save(compensateSaveInDto.getPrpLCompensateDtoExt());
        //删除赔付信息的历史数据，不管本次提交是否有赔付信息
//        prpLChargeApi.deletePrpLchargeForCompeSave(compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo());

        if (compensateSaveInDto.getPrpLChargeDtoExtList() != null && compensateSaveInDto.getPrpLChargeDtoExtList().size()>0) {
        	for(PrpLChargeDto prpLChargeDto : compensateSaveInDto.getPrpLChargeDtoExtList()){
				String policyNo = compensateSaveInDto.getPrpLCompensateDtoExt().getPolicyNo();
				PrpLClaimDto prpLClaimDto = prpLClaimApi.queryByPK(compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo());
				String kindCode = prpLChargeDto.getKindCode();
				String registNo = prpLClaimDto.getRegistNo();
				PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(registNo);
				Map<String,Object> resultMap = new HashMap<>();
				Map<String,String> map = new HashMap<>();
				if (org.apache.commons.lang3.StringUtils.isNotEmpty(policyNo)){
					resultMap.put("policyNo",policyNo);
					map.put("policyNo",policyNo);
				}
				if (org.apache.commons.lang3.StringUtils.isNotEmpty(kindCode)){
					resultMap.put("kindCode",kindCode);
				}
				if (prpLRegistDto!= null){
					resultMap.put("itemCode",prpLRegistDto.getLossCode());
				}
				List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(resultMap);
				PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
				if (prpCitemKindDtoList.size()>0){
					prpCitemKindDto = prpCitemKindDtoList.get(0);
				}
				prpLChargeDto.setPolicyNo(policyNo);
				prpLChargeDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
				if (StringUtils.isEmpty(prpLChargeDto.getChargeCode())){
				    throw new BusinessException("费用名称不能为空");
                }
        		prpLChargeApi.save(prpLChargeDto);
        	}
        }
        //增加耳标信息
        if(compensateSaveInDto.getPrpLCompensateEarDtoList()!=null){
        	for(PrpLCompensateEarDto prpLCompensateEarDto : compensateSaveInDto.getPrpLCompensateEarDtoList()){
        		prpLCompensateEarApi.save(prpLCompensateEarDto);
        	}
        }
        
        //reason:增加危险单位
//        if(compensateSaveInDto.getPrplRiskUnitDtoList()!=null){
//        	new DBPrpLdangerUnit(dbManager).insertAll(compensateSaveInDto.getPrplRiskUnitDtoList());
//        }
//        
//        if(compensateSaveInDto.getPrpLprpLdangerTotList()!=null){
//        	new DBPrpLdangerTot(dbManager).insertAll(compensateSaveInDto.getPrpLprpLdangerTotList());
//        }
//        
//        if(compensateSaveInDto.getPrpLprpLdangerItemList()!=null){
//        	 Iterator i = compensateSaveInDto.getPrpLprpLdangerItemList().iterator();
//             while(i.hasNext()){
//             	PrpLdangerItemDto dangerItemAll1 =(PrpLdangerItemDto) i.next();
//             }
//        	new DBPrpLdangerItem(dbManager).insertAll(compensateSaveInDto.getPrpLprpLdangerItemList());
//        }
        
        if (compensateSaveInDto.getPrpLLossDtoList() != null && compensateSaveInDto.getPrpLLossDtoList().size()>0) {
        	for(PrpLLossDto prpLLossDto : compensateSaveInDto.getPrpLLossDtoList()){
        		prpLLossApi.save(prpLLossDto);
        	}
        }
        
//        if (compensateSaveInDto.getPrpLpersonLossDtoList() != null) {
//            new DBPrpLpersonLoss(dbManager).insertAll(compensateSaveInDto.getPrpLpersonLossDtoList());
//        }
       
        if (compensateSaveInDto.getPrpLctextList() != null && compensateSaveInDto.getPrpLctextList().size()>0) {
        	for(PrpLCTextDto prpLCTextDto : compensateSaveInDto.getPrpLctextList()){
        		prpLCTextApi.save(prpLCTextDto);
        	}
        }
        
        if (compensateSaveInDto.getPrpLCFeeDtoList() != null  && compensateSaveInDto.getPrpLCFeeDtoList().size()>0) {
        	for(PrpLCFeeDto prpLCFeeDto : compensateSaveInDto.getPrpLCFeeDtoList()){
        		prpLCFeeApi.save(prpLCFeeDto);
        	}
        }
        
        if (compensateSaveInDto.getPrpLLTextDtoList() != null && compensateSaveInDto.getPrpLLTextDtoList().size()>0) {
        	for(PrpLLTextDto prpLLTextDto : compensateSaveInDto.getPrpLLTextDtoList()){
        		prpLLTextApi.save(prpLLTextDto);
        	}
        }
        
        if (compensateSaveInDto.getPrpLAccIPersonDtoList() != null && compensateSaveInDto.getPrpLAccIPersonDtoList().size()>0) {
        	for (int i =0; i < compensateSaveInDto.getPrpLAccIPersonDtoList().size(); i++) {
        		prpLAccIPersonApi.modify(compensateSaveInDto.getPrpLAccIPersonDtoList().get(i));	
        	}
        }
        
        if (compensateSaveInDto.getPrpLagriPersonList() != null && compensateSaveInDto.getPrpLagriPersonList().size()>0) {
        	for (int i =0; i < compensateSaveInDto.getPrpLagriPersonList().size(); i++) {
        		prpLAccIPersonApi.modify(compensateSaveInDto.getPrpLagriPersonList().get(i));	
        	}
        }
        //进行状态的改变
        updateClaimStatus(compensateSaveInDto);
        
        //共保信息
        if(compensateSaveInDto.getPrpLcfeecoinsList() != null && compensateSaveInDto.getPrpLctextList().size()>0){
        	for(PrpLCfeecoinsDto prpLCfeecoinsDto : compensateSaveInDto.getPrpLcfeecoinsList()){
        		prpLCfeecoinsApi.save(prpLCfeecoinsDto);
        	}
        }
        
        //账户信息表实体
        if(compensateSaveInDto.getPrpLsumpayDtoList() != null && compensateSaveInDto.getPrpLsumpayDtoList().size()>0){
        	for(PrpLsumpayDto prpLsumpayDto : compensateSaveInDto.getPrpLsumpayDtoList()){
        		prpLsumpayDao.save(this.convert(prpLsumpayDto, PrpLsumpay.class));
        	}
        }
	}
	
	/**
	 * 更改状态
	 * @param compensateSaveInDto
	 */
	private void updateClaimStatus(CompensateSaveInDto compensateSaveInDto) {
		if (compensateSaveInDto.getPrpLclaimStatusDto() != null) {
            String condition3 = " BusinessNo='"
                    + StringUtils.rightTrim(compensateSaveInDto.getPrpLclaimStatusDto().getBusinessno()) + "' "
                    + " AND NodeType ='" + compensateSaveInDto.getPrpLclaimStatusDto().getNodetype() + "' and TypeFlag='"
                    + compensateSaveInDto.getPrpLclaimStatusDto().getTypeflag().trim() + "'";

            String statement = " DELETE FROM prpLclaimStatus Where " + condition3;
            entityManager.createNativeQuery(statement);
            prpLclaimStatusApi.save(compensateSaveInDto.getPrpLclaimStatusDto());

        }
	}

	/**
	 * @param compensateSaveInDto
	 */
	private void deleteSubInfo(CompensateSaveInDto compensateSaveInDto) {
		String compensateNo = compensateSaveInDto.getPrpLCompensateDtoExt().getCompensateNo();
        String condition = " compensateNo = '" + StringUtils.rightTrim(compensateNo) + "'";
        
        String statement = ""; //示例未完成
        statement = " DELETE FROM prplcompensateear Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prpLctext Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prpLcharge Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = "DELETE FROM prpLnodutyLoss where " + condition;
        entityManager.createNativeQuery(statement);
        
        //免赔条件相关信息
        statement = " DELETE FROM prpldeductcond Where " + condition;
        entityManager.createNativeQuery(statement);

        //reason:增加危险单位
        String  conditions =" certino = '" + StringUtils.rightTrim(compensateNo) + "'";
        statement = " DELETE FROM prpldangertot Where " + conditions;
        entityManager.createNativeQuery(statement);
        
        //reason:加入理算免赔额
        statement = " DELETE FROM PrpLdeductible Where " + condition;
        entityManager.createNativeQuery(statement);

        statement = " DELETE FROM prpldangeritem Where " + conditions;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prpldangerunit Where " + conditions;
        entityManager.createNativeQuery(statement);
        //add by qinyongli end 2005-8-19 
        
        statement = " DELETE FROM prpLpersonLoss Where " + condition;
        entityManager.createNativeQuery(statement);

        statement = " DELETE FROM prpLloss Where " + condition;
        entityManager.createNativeQuery(statement);

        statement = " DELETE FROM prpLcfee Where " + condition;
        entityManager.createNativeQuery(statement);

        statement = " DELETE FROM prpLcfeecoins Where businessno = '"+compensateNo+"' "  ; 
        entityManager.createNativeQuery(statement);
        statement = " DELETE FROM PrpLhospitalizationPayFee Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prplcomrepairbill Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prpLcompensate Where " + condition;
        entityManager.createNativeQuery(statement);

        statement = " DELETE FROM prplcfee Where " + condition;
        entityManager.createNativeQuery(statement);
        
        statement = " DELETE FROM prplinjuryperson Where " + condition;
        entityManager.createNativeQuery(statement);

        condition = " registNo = '" + compensateNo + "' and QualityCheckType='compe'";
        statement = " DELETE FROM PrpLqualityCheck Where " + condition;
        entityManager.createNativeQuery(statement);

        PrpLClaimDto prpLclaimDto = prpLClaimApi.queryByPK(compensateSaveInDto.getPrpLCompensateDtoExt().getClaimNo());

        condition = " registNo = " + "'" + prpLclaimDto.getRegistNo() + "'";
        //删除扩展信息
        statement = " DELETE FROM PrpLregistExt Where " + condition;
        entityManager.createNativeQuery(statement);

        condition = " ClaimNo = '" + prpLclaimDto.getClaimNo() + "' AND TextType = '08'";
        statement = " DELETE FROM PrpLlText Where " + condition;
        entityManager.createNativeQuery(statement);
	}

	/**
	 * @param compensateSaveInDto
	 * @return
	 */
	private boolean checkCompensateRelation(CompensateSaveInDto compensateSaveInDto) {
		//理算书金额
		Double sumfee = compensateSaveInDto.getPrpLCompensateDtoExt().getSumPaid();
		//赔款合计 = 赔款金额 + 其他费用
		Double sumDutyPaid = compensateSaveInDto.getPrpLCompensateDtoExt().getSumDutyPaid();
		Double sumNoDutyFee = compensateSaveInDto.getPrpLCompensateDtoExt().getSumNoDutyFee();
		Double result = sumDutyPaid + sumNoDutyFee;
		sumfee = result - sumfee;
		/** 赔付标的信息 */
		/*List lossList = compensateSaveInDto.getPrpLLossDtoList();
		if(lossList != null){
			for (int i = 0; i < lossList.size(); i++) {
				PrpLLossDto prpLLossDto = (PrpLLossDto) lossList.get(i);
				sumfee = Str.round(sumfee-prpLLossDto.getSumrealPay(),2);
			}
		}
		
		*//** 赔款费用信息 *//*
		lossList = compensateSaveInDto.getPrpLChargeDtoExtList();
		if(lossList != null){
			for (int i = 0; i < lossList.size(); i++) {
				PrpLChargeDto prpLChargeDto = (PrpLChargeDto) lossList.get(i);
				sumfee = Str.round(sumfee-prpLChargeDto.getChargeAmount(),2);
			}
		}*/
		
		/** 无责代赔信息 */
//		lossList = compensateSaveInDto.getPrpLnodutyLossDtoList();
//		if(lossList != null){
//			for (int i = 0; i < lossList.size(); i++) {
//				PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto) lossList
//						.get(i);	
//				sumfee = Str.round(sumfee-prpLnodutyLossDto.getRealPaid(),2);
//			}
//		}
		/** 预付赔款 **/
		if(sumfee != 0){
			return true;
		}
		return false;
	}

	/**
	 * （理算书提交双核）
	 * @author: 王志文
	 * @date: 2018/1/15 16:00
	 * @param compensateSubmitUndwrtXMLDto 提交双核入参多想
	 * @return 提交成功信息
	 */
	@Override
	public Map<String, String> sendCompensateXMLToUndwrt(CompensateSubmitUndwrtXMLDto compensateSubmitUndwrtXMLDto)throws Exception {
		Map<String,String> map = new HashMap<>();
		String xmlData = "";
		XmlUtil xmlUtil = new XmlUtil();
		PacketDto<CompensateSubmitUndwrtXMLDto> packetDto = new PacketDto<>();
		packetDto.setBody(compensateSubmitUndwrtXMLDto);
		xmlData = xmlUtil.packetDtoToXml_bodyDto(packetDto);
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
		jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
		NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();

		String getXml = newAgriPrpallUndwrtService.compensateSubmit(xmlData);

		Document document;
		try {
			document = DocumentHelper.parseText(getXml);
		} catch (DocumentException e) {
			throw new BusinessException(e.getMessage());
		}

		Element requestData =document.getRootElement();
		Element flowID = requestData.element("flowId");
		map.put("flowId",flowID.getTextTrim());
		return map;
	}
	@Override
	public CompensatePageResponseDto compensatePageInit(CompensatePageRequestDto requestDto) throws Exception {
		/* 入参规则校验及合法性校验 */
		this.verifyParam(requestDto);
		/* 把入参数据copy到responseDto */
		CompensatePageResponseDto responseDto = this.convert(requestDto, CompensatePageResponseDto.class);
		String riskCode;
		String policyNo;
		/* 根据业务编码查询riskCode并校验数据的存在性 */
		if ("ADD".equals(requestDto.getEditType()) && StringUtils.isNotEmpty(requestDto.getClaimNo())) {
			PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(requestDto.getClaimNo()));
			if (prpLClaim == null) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("不存在立案号为{}的立案信息，请核对！", requestDto.getClaimNo());
				}
				throw new BusinessException(BusinessException.DataVerifyCatalog,
						"不存在立案号为" + requestDto.getClaimNo() + "的立案信息，请核对！");
			}
			riskCode = prpLClaim.getRiskCode();
			policyNo = prpLClaim.getPolicyNo();
			responseDto.setRegistNo(prpLClaim.getRegistNo());
			/* 把查询到到数据设置进来，后续使用不用查数据库 */
			responseDto.setPrpLClaimDto(this.convert(prpLClaim, PrpLClaimDto.class));
		} else {
			PrpLCompensate prpLCompensate = prpLCompensateDao
					.findOne(new PrpLCompensateKey(requestDto.getCompensateNo()));
			if (prpLCompensate == null) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("不存在赔款计算书号为{}赔案信息，请核对！", requestDto.getCompensateNo());
				}
				throw new BusinessException(BusinessException.DataVerifyCatalog,
						"不存在赔款计算书号为" + requestDto.getCompensateNo() + "的赔案信息，请核对！");
			}
			riskCode = prpLCompensate.getRiskCode();
			policyNo = prpLCompensate.getPolicyNo();
			responseDto.setClaimNo(prpLCompensate.getClaimNo());
			/*把计算书主信息设置进返参对象，之后不用再查数据库*/
			PrpLCompensateDtoExt  prpLCompensateDtoExt = new PrpLCompensateDtoExt();
			this.pageInitCommonService.copyPropertiesIfNull(prpLCompensate, prpLCompensateDtoExt);
			responseDto.setPrpLCompensateDtoExt(prpLCompensateDtoExt);
		}
		if(null == responseDto.getPrpLClaimDto()){
			PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(responseDto.getClaimNo()));
			responseDto.setPrpLClaimDto(this.convert(prpLClaim, PrpLClaimDto.class));
			responseDto.setRegistNo(prpLClaim.getRegistNo());
		}
		//有效保额
		Map<String,String> map = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        map.put("policyNo",policyNo);
        map.put("starDate", format.format(responseDto.getPrpLClaimDto().getDamageStartDate()));
        //PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
		Map<String, Double> stringDoubleMap = nyxEffectiveAmountApi.queryNyxEffectiveAmountByPolicyNo(map);
		responseDto.setValidAmount(stringDoubleMap.get("amount").toString());
		//responseDto.setValidAmount(prpCmainDto.getSumAmount().toString());
		responseDto.setRiskCode(riskCode);
		responseDto.setPolicyNo(policyNo);
		this.setUserInfo(responseDto);
		/* 根据险种编码，得到险种类型 */
		String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
		responseDto.setRiskType(riskType);
		if ("ADD".equals(responseDto.getEditType())) {
			compensateBeforeAdd(responseDto);
			/*为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点*/
			if(StringUtils.isNotEmpty(responseDto.getFlowId()) && StringUtils.isNotEmpty(responseDto.getLogNo())){
				workFlowService.avoidUpdateSampCompe(responseDto.getFlowId(),Integer.parseInt(responseDto.getLogNo()), responseDto.getUserCode(), responseDto.getUserName());
			}
		}else{
			compensateBeforeEdit(responseDto);
		}
		/*组织页面头信息到返参对象*/
		compensatePageCommonService.prePareCommonHead(responseDto);
		/*组织赔付标的细信息*/
		compensatePageCommonService.prepareCommonPrpLLoss(responseDto);
		if("I".equals(riskType)){
			/*组织养殖险 耳标号信息*/
			this.prepareCompensateEar(responseDto);
		}
		/*组织文本信息*/
		compensatePageCommonService.prepareCommonText(responseDto);
		/*组织结案报告信息*/
		compensatePageCommonService.prepareCaseReport(responseDto);
		/*设置赔款费用信息*/
		compensatePageCommonService.prepareChargeFee(responseDto);
		/*支付对象信息*/
		compensatePageCommonService.prepareSumPay(responseDto);
		prepareCommonParam(responseDto);
		//responseDto.setPrpLClaimDto(null);
		// 赔款计算过程需要字段，后期添加 2018/02/12 by wangzhiwen
		String kindCode = "";
		List<PrpCitemKindDto> prpCitemKindDtoList =  prpCitemKindApi.queryItemCodeByPolicyNo(policyNo);
		if (prpCitemKindDtoList != null && prpCitemKindDtoList.size()>0){
			kindCode = prpCitemKindDtoList.get(0).getKindCode();
		}
		responseDto.setKindCode(kindCode);
//		if (StringUtils.isNotEmpty(requestDto.getCompensateNo())){
		if ("31".equals(policyNo.substring(1,3)) || "3224".equals(policyNo.substring(1,5))){
			RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto = new RequestNyxPlantingClaimListDto();
			requestNyxPlantingClaimListDto.setRegistNo(responseDto.getRegistNo());
			requestNyxPlantingClaimListDto.setCompensateNo(requestDto.getCompensateNo());
			requestNyxPlantingClaimListDto.setNodeType("compe");
			List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList =
					nyxPlantingClaimListApi.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
			if (nyxPlantingClaimListDtoList != null && nyxPlantingClaimListDtoList.size()>0){
				responseDto.setBillNo(nyxPlantingClaimListDtoList.get(0).getListNo());
				BigDecimal settleAmount = new BigDecimal("0");
				for (NyxPlantingClaimListDto nyxPlantingClaimListDto:nyxPlantingClaimListDtoList){
					if (nyxPlantingClaimListDto.getSettleAmount() != null){
						BigDecimal amount = new BigDecimal(nyxPlantingClaimListDto.getSettleAmount().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
						settleAmount = settleAmount.add(amount);
					}
				}
				responseDto.setSumloss(settleAmount.doubleValue());
			}
		}else {
			RequestNyxBreedClaimListDto requestNyxBreedClaimListDto = new RequestNyxBreedClaimListDto();
			requestNyxBreedClaimListDto.setRegistNo(responseDto.getRegistNo());
			requestNyxBreedClaimListDto.setCompensateNo(requestDto.getCompensateNo());
			requestNyxBreedClaimListDto.setNodeType("compe");
			List<NyxBreedClaimListDto> nyxBreedClaimListDtoList =
				 	breedClaimListApi.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
			if (nyxBreedClaimListDtoList != null && nyxBreedClaimListDtoList.size()>0){
				responseDto.setBillNo(nyxBreedClaimListDtoList.get(0).getListNo());
				Double settleAmount = 0.0;
				for (NyxBreedClaimListDto nyxBreedClaimListDto:nyxBreedClaimListDtoList){
					if (nyxBreedClaimListDto.getPayAmount() != null){
						settleAmount += nyxBreedClaimListDto.getPayAmount();
					}
				}
				responseDto.setSumloss(settleAmount);
			}
		}

//		}else {
//			responseDto.setSumloss(0.0);
//		}
//		if (StringUtils.isNotEmpty(responseDto.getPrpLCompensateDtoExt().getLossName())){
//			List<String> list =new ArrayList<>();
//			list.add(responseDto.getPrpLCompensateDtoExt().getLossName());
//			QueryItemCodePmsDto queryItemCodePmsDto=new QueryItemCodePmsDto();
//			queryItemCodePmsDto.setRiskCode(responseDto.getRiskCode());
//			queryItemCodePmsDto.setItemCodeList(list);
//			List<PrpDitemAgriDto> prpDitemAgriDtoList = prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
//			if(prpDitemAgriDtoList!=null && prpDitemAgriDtoList.size()>0){
//				String lossName = prpDitemAgriDtoList.get(0).getItemCName();
//				responseDto.getPrpLCompensateDtoExt().setLossCode(lossName);
//			}
//		}
		PrpLRegist prpLRegist=new PrpLRegist();
		List<SwfLog> swfLogList =  swfLogdao.querySwfLogsByFlowId(requestDto.getFlowId());
		if (swfLogList.size()!=0) {
			prpLRegist = prpLRegistDao.findByRegistNo(swfLogList.get(0).getRegistNo());
		}
		else {
			List<SwfLogStore> swfLogStoreList = swfLogStoreDao.querySwfLogStoresByFlowId(requestDto.getFlowId());
			if (swfLogStoreList.size()!=0) {
				prpLRegist = prpLRegistDao.findByRegistNo(swfLogStoreList.get(0).getRegistNo());
			}
		}
		responseDto.getPrpLCompensateDtoExt().setLossCode(prpLRegist.getLossCode());
		return responseDto;
	}
	/**
	 * @description:方法功能简述: 设置养殖险耳标号信息
	 * @author 安齐崇
	 * @date 2017年12月2日下午11:18:30
	 * @param responseDto
	 */
    private void prepareCompensateEar(CompensatePageResponseDto responseDto) {
    	String properties = pageInitCommonService.getConfigRules("FamilySplittingFlag","claim");
    	String registNo = responseDto.getRegistNo();
    	String riskCode = responseDto.getRiskCode();
    	String compensateNo = responseDto.getCompensateNo();
    	String prpltextForEar = "";
    	String familySplittingFlag ="";
    	List<PrpLCompensateEarDto> prplCompensateEarDtoList =null;
    	if (properties.indexOf(riskCode) > -1 ) {
    		familySplittingFlag ="1";
			prplCompensateEarDtoList = new ArrayList<PrpLCompensateEarDto>();//耳标清单列表
			if (registNo != null)
			{		
				prplCompensateEarDtoList = new ArrayList<PrpLCompensateEarDto>();
				List<PrpLCompensateEar> prpLCompensateEarList = prpLCompensateEarDao.findAll(Specifications.<PrpLCompensateEar>and().eq("registNo", responseDto.getRegistNo()).eq("nodeType", "regis").build());
				this.convertCollection(prpLCompensateEarList, prplCompensateEarDtoList, PrpLCompensateEarDto.class);
				prpltextForEar =  "";
				Iterator<PrpLCompensateEar> ite = prpLCompensateEarList.iterator();
				double sumloss = 0.00;
	    		while(ite.hasNext())
	    		{
	    			PrpLCompensateEar prplCompensateEarDtotemp2 = (PrpLCompensateEar)ite.next();
	    			double claimloss = prplCompensateEarDtotemp2.getEstimateLoss();
	    			sumloss = sumloss + claimloss;
	    			prpltextForEar = prpltextForEar + "耳标号：" + prplCompensateEarDtotemp2.getEarNo() + " 赔付金额=" + claimloss + "\r\n";
	    		}
	    		/*增加理算报告初始化时的四舍五入保留两位小数的操作。*/
	    		sumloss = (double)(Math.round(sumloss*100)/100.0);
	    		prpltextForEar = prpltextForEar + "\r\n" + "总赔付金额=" + sumloss;
	    		responseDto.setSumloss(sumloss);
	    		responseDto.setText(prpltextForEar);
			}
			responseDto.setPrpLCompensateEarDtoList(prplCompensateEarDtoList);
			responseDto.setFamilySplittingFlag(familySplittingFlag);
		}
		
    }
	private void prepareCommonParam(CompensatePageResponseDto responseDto) throws Exception {
		String policyNo = responseDto.getPolicyNo();
		String registNo = responseDto.getRegistNo();
	    ResponseQueryPolicyInfoDto policyInfoDto = pageInitCommonService.findEndOrBefore(policyNo, null, null);
	    PrpCmainDto prpCmainDto = policyInfoDto.getPrpCmainDto();
		/*设置险种名称*/
		String riskCode = responseDto.getRiskCode();
		PrpDriskDto riskDto = riskApi.queryriskByPK(riskCode);
		String riskName = riskDto==null?"":riskDto.getRiskCName();
		responseDto.setRiskName(riskName);
		/*设置被保险人名称*/
		String insuredName = prpCmainDto.getInsuredName();
		String insuredNameShow = prpCmainDto.getInsuredName();
		Integer insureQuantity = prpCmainDto.getSumQuantity();
		if (insureQuantity == null || String.valueOf(insureQuantity).equals("")
				|| insureQuantity <= 1) {
			insuredNameShow = prpCmainDto.getInsuredName();
		} else {
			insuredNameShow = prpCmainDto.getInsuredName() + "等" + insureQuantity + "人";
		}
		responseDto.getPrpLCompensateDtoExt().setInsuredName(insuredName);
		responseDto.getPrpLCompensateDtoExt().setInsuredNameShow(insuredNameShow);
		responseDto.getPrpLCompensateDtoExt().setAppliCode(prpCmainDto.getAppliCode());
		responseDto.getPrpLCompensateDtoExt().setAppliName(prpCmainDto.getAppliName());
		/*设置币别名称*/
		PrpDcurrencyDto currencyDto = prpDcurrencyApi.queryByPK(responseDto.getPrpLCompensateDtoExt().getCurrency());
		responseDto.getPrpLCompensateDtoExt().setCurrencyName(currencyDto.getCurrencyCName());
		/*已出险次数*/
		int perilCount = pageInitCommonService.getSamePolicyRegistInfo(policyNo, registNo);
		responseDto.setPerilCount(perilCount);
		/*已赔付次数*/
		/*分入标志*/
		responseDto.setBusinessFlag("1");
		/*共保标志*/
		responseDto.setCoinsFlag(prpCmainDto.getCoinsFlag());
		/* 共保标志 (0非共保/1主共保/2共保)*/
		if("1".equals(prpCmainDto.getCoinsFlag()) || "2".equals(prpCmainDto.getCoinsFlag())){
			List<PrpCcoinsDto> ccoinsDtoList = policyInfoDto.getPrpCcoinsDtoList();
			List<PrpCcoinsDto> ccoinsDtoListNew = new ArrayList<>();
			if(ccoinsDtoList !=null && ccoinsDtoList.size()>0){
				double otherRate = 0;
				int serialNo = 1;
				for (ListIterator<PrpCcoinsDto> it = ccoinsDtoList.listIterator(); it.hasNext();) {
					PrpCcoinsDto prpCcoinsDto = it.next();
					if ("1".equals(prpCcoinsDto.getSerialNo()+"")){
						it.remove();
					}else if("2".equals(prpCcoinsDto.getSerialNo()+"")){
						responseDto.setCoinsTreatyNo(prpCcoinsDto.getCoinsTreatyNo());
						/*我方份额*/
						responseDto.setSelfRate(prpCcoinsDto.getCoinsRate());
						/*删除我方信息*/
						it.remove();
					}else if (prpCcoinsDto.getSerialNo() != null && prpCcoinsDto.getSerialNo()>2){
						/*它方份额*/
						otherRate+=prpCcoinsDto.getCoinsRate();
						it.remove();
						ccoinsDtoListNew.add(prpCcoinsDto);
					}
				}
				/**它方份额*/
				responseDto.setOtherRate(otherRate);
				/*设置共保赔付类型，共保协议号*/
				/*coinsPaidLossType 赔付类型对应PrpLcompensate表1按赔案100%赔付,2按我方共保份额赔付*/
				/*协议号 coinsTreatyNo PrpCcoins 表*/
				List<PrpCcoinsDetailDto> ccoinsDetailDtoList = policyInfoDto.getPrpCcoinsDetailDtoList();
				for (PrpCcoinsDto prpCcoinsDto : ccoinsDtoListNew) {
					for (PrpCcoinsDetailDto prpCcoinsDetailDto : ccoinsDetailDtoList) {
						if(prpCcoinsDto.getPolicyNo().equals(prpCcoinsDetailDto.getPolicyNo()) && prpCcoinsDto.getSerialNo() == prpCcoinsDetailDto.getSerialNo()){
							/*共保保额*/
							prpCcoinsDto.setCoinsAmount(prpCcoinsDetailDto.getCoinsAmount());
							prpCcoinsDto.setSerialNo(serialNo);
							serialNo++;
						}
					}
				}
				responseDto.setCcoinsDtoList(ccoinsDtoListNew);
			}else{
				responseDto.setCoinsTreatyNo("");
		}
	}
		/*投被保人风险等级*/
		String insuredRiskLevel = "";
		String appliRiskLevel = "";
		if (StringUtils.isNotEmpty(prpCmainDto.getInsuredCode())){
			insuredRiskLevel = prpDcustomLevelTraceApi.findRiskLevelByCode(prpCmainDto.getInsuredCode());
		}
		if (StringUtils.isNotEmpty(prpCmainDto.getAppliCode())){
			appliRiskLevel = prpDcustomLevelTraceApi.findRiskLevelByCode(prpCmainDto.getAppliCode());
		}
		responseDto.getPrpLCompensateDtoExt().setInsuredRiskLevel(insuredRiskLevel);
		responseDto.getPrpLCompensateDtoExt().setAppliRiskLevel(appliRiskLevel);
		/*缴费情况*/
		int payFeeFlag = pageInitCommonService.checkPay(policyNo);
		/** 保险金额*/
		responseDto.getPrpLCompensateDtoExt().setSumAmount(prpCmainDto.getSumAmount());
		responseDto.setPayFeeFlag(payFeeFlag);
		responseDto.getPrpLCompensateDtoExt().setCurrencyCodeAndName();
		responseDto.getPrpLCompensateDtoExt().setInsuredPeriod();
		responseDto.getPrpLCompensateDtoExt().setHandleCodeAndName();
		
		responseDto.setNodeType("compe");
		responseDto.setNodeName(prpDcodeApi.translateCodeByPK("ClaimNodeType","compe"));
		this.checkRule(prpCmainDto, responseDto);
	}

	/**
	 * @description:方法功能简述:校验是否在保险期间内，缴费情况
	 * @author 安齐崇
	 * @date 2017年11月15日下午12:25:03
	 * @param prpCMain 保单对象
	 * @return pageDto 封装数据的对象
	 */
	private void checkRule(PrpCmainDto prpCMain, CompensatePageResponseDto pageDto) {
		int checkPay = pageDto.getPayFeeFlag();
		pageDto.setMsgCode("0000");
		if("null".equals(pageDto.getMessage())||null==pageDto.getMessage()){
			pageDto.setMessage("");
		}
		if (checkPay != 1) {
			if(checkPay==-1){
				pageDto.setMsgCode("9999");
				pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage())?"</br>":""+pageDto.getMessage() +"保费未缴，请谨慎处理！");
			}/*else if(checkPay==-2){
				pageDto.setMsgCode("9999");
				pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage())?"</br>":""+pageDto.getMessage() +"保费已缴未缴全，请谨慎处理！");
			}*/
		}
		Date startdate = prpCMain.getStartDate();
		Date enddate = prpCMain.getEndDate();
		Date current = new Date();
		if (startdate.getTime() > current.getTime() || enddate.getTime() < current.getTime()) {
			pageDto.setMsgCode("9999");
			pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage())?"</br>":""+pageDto.getMessage() + "保单不在保险期间内！");
		}
	}
	/**
     * 
     * @description:方法功能简述: 向返参对象设置清单号和提交工作流的信息
     * @author 安齐崇
     * @date 2017年12月1日上午11:45:11
     * @param responseDto
     */
	private void compensateBeforeEdit(CompensatePageResponseDto responseDto) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("进行理算前的校验!");
		}
		/* 清单号 */
		Map<String,String> listMap =new HashMap<>();
		listMap.put("registerCode", responseDto.getRegistNo());
		List<SettleMainListDto> settleMainListDto = settleMainListApi.queryByRegisterCode(listMap);
		String settleListCode = settleMainListDto == null ||settleMainListDto.size()<1?"":settleMainListDto.get(0).getSettleListCode();
		responseDto.setSettleListCode(settleListCode);
	}

	/**
	 * @description:方法功能简述:理算前的校验
	 * @author 安齐崇
	 * @date 2017年12月1日上午11:13:29
	 * @param responseDto
	 * @throws Exception 
	 */
	private void compensateBeforeAdd(CompensatePageResponseDto responseDto) throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("进行理算前的校验!");
		}
		String caseType = responseDto.getCaseType();
		String riskCode = responseDto.getRiskCode();
		String claimNo = responseDto.getClaimNo();
		Specification<PrpLCompensate> specification = Specifications.<PrpLCompensate> and().eq("claimNo", claimNo)
				.build();
		List<PrpLCompensate> compensateList = prpLCompensateDao.findAll(specification, new Sort("compensateNo"));
		PrpLClaimDto prpLClaimDto = responseDto.getPrpLClaimDto();
		/* 向页面放置理赔清单号 */
		if (compensateList != null && compensateList.size() > 0) {
			/* 案后重开的不放理赔清单号 */
		} else {
			/* 清单号 */
			Map<String,String> listMap =new HashMap<>();
			listMap.put("registerCode", responseDto.getRegistNo());
			List<SettleMainListDto> settleMainListDto = settleMainListApi.queryByRegisterCode(listMap);
			String settleListCode = settleMainListDto == null ||settleMainListDto.size()<1?"":settleMainListDto.get(0).getSettleListCode();
			responseDto.setSettleListCode(settleListCode);
		}
		// 中央政策性六大种植险险种理算界面控制
		if (("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3186,3149,3148,3174,3150,3151,3152,3153,3154,3155,3156,3190,3191,3132,3172,3194,3193,3187,3178,3176,0311,3177,3161".indexOf(responseDto.getRiskCode()) > -1)) {
			String policyNo = prpLClaimDto.getPolicyNo();
			Map<String,String> map = new HashMap<>();
			map.put("policyNo", policyNo);
			List<PrpPheadDto> prpPheadDtoList = prpPheadApi.queryAllByPolicyNo(map);
			for (PrpPheadDto prpPheadDto : prpPheadDtoList) {
				if (!"1".equals(prpPheadDto.getUnderwriteFlag())) {
					if (LOGGER.isInfoEnabled()) {
						LOGGER.error("{}保单项下存在尚未核批通过的批单，不允许理算!", policyNo);
					}
					throw new BusinessException(policyNo + "保单项下存在尚未核批通过的批单，不允许理算!");
				}
			}

			double SumPaid = 0.00;
			PrpLCompensate prpLCompensate = null;
			if (compensateList != null && compensateList.size() > 0) {
				for (int i = 0; i < compensateList.size(); i++) {
					prpLCompensate = compensateList.get(i);
					if (!"".equals(prpLCompensate.getSumPaid())) {
						SumPaid = Double.valueOf(prpLCompensate.getSumPaid());
					}
					if ("1".equals(prpLCompensate.getUnderWriteFlag()) && SumPaid != 0) {
						/* 老系统去除冲减保额校验，留着以后用了再加 */
					}
				}
			}
			/* 多险别多标的种植险理算控制 */
			String planting31FarmerListFlag = pageInitCommonService.getConfigRules("PLNATING_31_FARMER_LIST_FLAG",
					"claim");
			if (null != planting31FarmerListFlag
					&& (planting31FarmerListFlag.indexOf(riskCode) > -1 || riskCode.equals("0311"))) {
				String policyNo1 = prpLClaimDto.getPolicyNo();
				Map<String,String> map1 = new HashMap<>();
				map.put("policyNo", policyNo1);
				List<PrpPheadDto> prpPheadDtoList1 = prpPheadApi.queryAllByPolicyNo(map1);
				for (PrpPheadDto prpPheadDto : prpPheadDtoList1) {
					if (!"1".equals(prpPheadDto.getUnderwriteFlag())) {
						if (LOGGER.isInfoEnabled()) {
							LOGGER.error("{}保单项下存在尚未核批通过的批单，不允许理算!", policyNo);
						}
						throw new BusinessException(policyNo + "保单项下存在尚未核批通过的批单，不允许理算!");
					}
				}
				/* 多险别多标的种植险自动冲减保额校验 20161214已去除，暂保留部分代码 同上 */
			}
		}
		/* 只有正常实赔才判断定损的,没有定损的案件不能进入实赔理算 */
		int conditionFlag = 0;
		if (!"3".equals(caseType) && !"4".equals(caseType)) {
			conditionFlag = this.checkCondition(prpLClaimDto);
		}
		/* 如果不是特殊陪案，需要进行验证 */
		if (caseType == null || caseType.trim().length() < 1) {
			if (conditionFlag == 1) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("非特殊赔案没有立案，不允许理算!");
				}
				throw new BusinessException("非特殊赔案没有立案，不允许理算!");
			}
			/* 有预赔的案件复核不通过的案件不能进入实赔理算 */
			boolean prepayFlag = this.checkPrepay(claimNo);
			if (prepayFlag == false) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("有预赔的案件非核赔通过或不通过的案件不能进入实赔理算！");
				}
				throw new BusinessException("有预赔的案件非核赔通过或不通过的案件不能进入实赔理算！");
			}
		}
		/* 关于调查的判断 */
		String registNo = prpLClaimDto.getRegistNo();
		Specification<SwfLog> specification2 = Specifications.<SwfLog> and().eq("businessNo", registNo)
				.eq("nodeType", "check").in("nodeStatus", "0", "1", "2", "3").build();
		long count2 = swfLogDao.count(specification2);
		if (count2 > 1) {
			responseDto.setCheckFlag12("N");
		} else {
			responseDto.setCheckFlag12("Y");
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("policyNo", responseDto.getPolicyNo());
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
		if(prpCmainDto == null){
			throw new BusinessException("未查询到保单号为"+responseDto.getPolicyNo()+"的保单信息！");
		}
		/* 分入标志 */
		String businessFlag = prpCmainDto.getBusinessFlag();
		responseDto.setBusinessFlag(businessFlag);
		/* 缴费标志 */
		int checkPay = pageInitCommonService.checkPay(responseDto.getPolicyNo());
		responseDto.setPayFeeFlag(checkPay);
		/* 保单如果为分入业务 不做此校验 */
		/* 增加险种为3101的判断，当险种为3101时，不走保单保费未缴的校验！ */
		if (!"3101".equals(riskCode) && responseDto.getPolicyNo().equals("231943466002016000001")) {
			if (checkPay == -1 && !"1".equals(businessFlag)) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("{}保单保费未缴！", responseDto.getPolicyNo());
				}
				throw new BusinessException("此保单保费未缴！");
			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("理算校验完毕，可以进行理算了!!!");
		}
	}
	/**
	 * @description:方法功能简述: 有预赔的案件核赔通过（1）和不通过（2）的案件不能进入实赔理算 true无，false 有
	 * @author 安齐崇
	 * @date 2017年12月1日上午10:18:05
	 * @param claimNo
	 *            赔案号
	 * @return blnRetrun
	 */
	private boolean checkPrepay(String claimNo) {
		boolean blnRetrun = true;
		/* 取得赔款计算书信息 */
		List<PrpLPrepay> prpLPrepayList = prpLPrepayDao
				.findAll(Specifications.<PrpLPrepay> and().eq("claimNo", claimNo).build());
		for (PrpLPrepay prpLPrepay : prpLPrepayList) {
			if (prpLPrepay.getUnderWriteFlag() == null || !prpLPrepay.getUnderWriteFlag().trim().equals("1") && !"2".equals(prpLPrepay.getUnderWriteFlag().trim())) {
				blnRetrun = false;
				break;
			}
		}
		return blnRetrun;
	}
	/**
	 * @description:方法功能简述: 核损不通过的案件不能进入实赔理算
	 * @author 安齐崇
	 * @date 2017年12月1日上午10:10:27
	 * @param prpLClaimDto
	 * @return intReturn
	 */
	private int checkCondition(PrpLClaimDto prpLClaimDto) {
		int intReturn = 0;
		if (prpLClaimDto == null) {
			intReturn = 1;
		}
		// 根据赔案号码取得对应的报案号码
		String registNo = prpLClaimDto.getRegistNo();
		/*核定损信息*/
		List<PrpLverifyLoss> verifyLossList = prpLverifyLossDao
				.findAll(Specifications.<PrpLverifyLoss> and().eq("registNo", registNo).build());
		if (verifyLossList == null || verifyLossList.size() < 1) {
			intReturn = 2;
		}
		return intReturn;
	}
	/**
	 * @description:方法功能简述: 校验数据的合法性
	 * @author 安齐崇
	 * @date 2017年11月24日下午5:19:13
	 * @param
	 * @return
	 * @throw Exception
	 */
	private void verifyParam(CompensatePageRequestDto requestDto) {
		if (requestDto == null) {
			throw new DataVerifyException("请求参数不能为空!");
		}
		if ("ADD".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getClaimNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型立案号不能为空！");
			}
		} else if ("EDIT".equals(requestDto.getEditType()) || "SHOW".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getCompensateNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型赔款计算书号不能为空！");
			}
		} else {
			throw new BusinessException(BusinessException.DataVerifyCatalog, "编辑类型不合法,请选择ADD、EDIT或SHOW编辑类型！");
		}
	}
	/**
	 * @description:方法功能简述: 设置登录用户信息到返回对象
	 * @author 安齐崇
	 * @date 2017年11月16日上午10:53:43
	 * @param responseDto 返回对象
	 */
	private void setUserInfo(CompensatePageResponseDto responseDto) {
		/* 设置用户信息 */
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
		responseDto.setUserCode(userCode);
		responseDto.setUserName(userInfo == null ? "" : userInfo.getUserName());
		responseDto.setComCode(userInfo == null ? "" : userInfo.getComCode());
	}

	/**
	 * （理算页面已注销拒赔列表查询）
	 * @author: 王志文
	 * @date: 2018/3/16 9:16
	 * @param prpLCompeQueryInDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<SwfLogExtendDto> queryCompensateCancelList(PrpLCompeQueryInDto prpLCompeQueryInDto) throws Exception {
		PageInfo<SwfLogExtendDto> pageInfo=new PageInfo<>();
		Long totalSizeStrLon = null;
		Integer pageNo = prpLCompeQueryInDto.getPageNo();
		Integer pageSize = prpLCompeQueryInDto.getPageSize();
		Map<String, Object> paraMap = new HashMap<>();
		String conditions = this.getCancelSQL(prpLCompeQueryInDto, "query", paraMap);
		String conditionsCount = this.getCancelSQL(prpLCompeQueryInDto, "count", paraMap);
		Query agentQuery = entityManager.createNativeQuery(conditions.replaceFirst("(?i)1=1 and "," "), SwfLogStore.class);
		Query agentQueryCount = entityManager.createNativeQuery(conditionsCount.replaceFirst("(?i)1=1 and "," "));
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
				lossName = (String) lossNameQuery.getSingleResult();
			}
			swfLogExtendDtoNew.setLossName(lossName);
			//立案号
			String claimNo = "";
			claimNo = swfLogDto.get(n).getKeyIn();
			swfLogExtendDtoNew.setClaimNo(claimNo);
			if (StringUtils.isEmpty(swfLogDto.get(n).getHandlerName())&&StringUtils.isNotEmpty(swfLogDto.get(n).getHandlerCode())){
				String userName = prpDuserApi.translateCodeByPK(swfLogDto.get(n).getHandlerCode());
				swfLogExtendDtoNew.getSwfLogDto().setHandlerName(userName);
			}
			//计算书号
			String compensateNo = "";
			if(!claimNo.equals(swfLogDto.get(n).getKeyOut()) && swfLogDto.get(n).getKeyOut()!=null){
				compensateNo = swfLogDto.get(n).getKeyOut();
			}
			List<PrpLClaim> byRegistNo = prpLClaimDao.findByRegistNo(swfLogDto.get(n).getRegistNo());
			String flag=null;
			if(byRegistNo.size()>0&&byRegistNo!=null){
				flag=byRegistNo.get(0).getCaseType();
			}
			swfLogExtendDtoNew.setFlag(flag);
			swfLogExtendDtoNew.setCompensateNo(compensateNo);
			swfLogExtendDto.add(swfLogExtendDtoNew);
		}
		pageInfo.setContent(swfLogExtendDto);
		// 当前页数
		pageInfo.setPages(pageNo);
		// 总记录数
		pageInfo.setTotalCount(totalSizeStrLon);
		return pageInfo;
	}

	private String getCancelSQL(PrpLCompeQueryInDto prpLCompeQueryInDto, String flag,Map<String, Object> paraMap) throws Exception{
		String policyNo=prpLCompeQueryInDto.getPolicyNo();
		String claimNo=prpLCompeQueryInDto.getClaimNo();
		String compensateNo=prpLCompeQueryInDto.getCompensateNo();
		String insuredName=prpLCompeQueryInDto.getInsuredName();
		String flowInTimeStart=prpLCompeQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd=prpLCompeQueryInDto.getFlowInTimeEnd();
		String riskType=prpLCompeQueryInDto.getRiskType();
		String nodeStatus=prpLCompeQueryInDto.getNodeStatus();
		String handlerCode=prpLCompeQueryInDto.getHandlerCode();
		String registNo=prpLCompeQueryInDto.getRegistNo();
		StringBuilder stringBuilder = null;
		if("query".equals(flag)){
			stringBuilder=new StringBuilder("SELECT s.* FROM SwfLogStore s WHERE 1=1");
		}else if("count".equals(flag)){
            stringBuilder = new StringBuilder("SELECT count(1) FROM SwfLogStore s WHERE 1=1");
        }
		//8为已注销 9 为已拒赔
		if(StringUtils.isNotEmpty(nodeStatus) && StringUtils.isNotEmpty(handlerCode)){
			if("8".equals(nodeStatus)){
				this.addStringCondition("handlerCode",handlerCode,"",stringBuilder,paraMap);
				stringBuilder.append(" and s.nodeType = 'cance' and s.nodeStatus = '4' and exists (select 1 from prplclaim p where p.casetype = '0' and s.registNo = p.registNo) ");
			}else if("9".equals(nodeStatus) ){
//				this.addStringCondition("handlerCode",handlerCode,"",stringBuilder,paraMap);
				stringBuilder.append(" and s.nodeType = 'cance' and s.nodeStatus = '4' and exists (select 1 from prplclaim p where p.casetype = '1' and s.registNo = p.registNo)");
			}
			if ("all".equals(nodeStatus)){
				stringBuilder.append(" and s.nodeType = 'cance' and s.nodeStatus = '4' and exists (select 1 from prplclaim p where p.casetype in ('0','1') and s.registNo = p.registNo) ");
			}
			stringBuilder.append(
					" and (s.handlerCode='" + handlerCode + "' or s.handlerCode is null or s.handlerCode='')");
		}else{
			throw new BusinessException("当前操作人或者案件状态为空，查询失败");
		}
		if(StringUtils.isNotEmpty(compensateNo)){
			stringBuilder.append(" and s.businessNo like '").append(compensateNo).append("%'");
		}
		if(StringUtils.isNotEmpty(registNo)){
			stringBuilder.append(" and s.registNo like '").append(registNo).append("%'");
		}
		if(StringUtils.isNotEmpty(claimNo)){
			stringBuilder.append(" and s.keyIn like '").append(claimNo).append("%'");
		}
		this.addStringCondition("policyNo",policyNo,"*",stringBuilder,paraMap);
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
		/*if(StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(compensateNo) && StringUtils.isEmpty(claimNo)){
			stringBuilder.append(" and s.flowInTime between '").append(flowInTimeStart).append(" 00:00:00' and '").append(flowInTimeEnd).append(" 23:59:59' ");
		}*/
		if(StringUtils.isNotEmpty(flowInTimeStart)){
			stringBuilder.append(" and s.flowInTime between '").append(flowInTimeStart).append(" 00:00:00' and '").append(flowInTimeEnd).append(" 23:59:59' ");
		}
		//新老系统数据区别标志
		stringBuilder.append(" and s.dataFlag is null ");
		stringBuilder.append(" and s.medicalTransitFlag is null ");
		if("query".equals(flag)){
			stringBuilder.append(" order by s.handleTime desc");
		}
		if(LOGGER.isDebugEnabled()){
			LOGGER.error(stringBuilder.toString());
		}
		return stringBuilder.toString();
	}

	/**
	 * （理算时重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param compensateNo
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void getLDangerInfoNewC(String compensateNo) throws Exception {
		List<PrpLDangerCoinsDto> prpLdangerCoinsDtoList = new ArrayList<>();
		PrpLDangerCoinsDto prpLdangerCoinsDto = null;
		//add end by zhaijq 20060404
		PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
		prpLCompensateKey.setCompensateNo(compensateNo);
		PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
		String claimNo1 = prpLCompensate.getClaimNo();
		int dangerItemCount = 0;// 出险标的个数
		int chargeItemkindno = -1; //
		Map<String,Object> kindMap = new HashMap<>();
		//	Map kindMapFee = new HashMap();
		String strKindCodeList = "";
		List<PrpLLossDto> prpLLossDtoList = prpLLossApi.queryByBusinessNo(compensateNo);
		List<PrpLChargeDto> prpLChargeDtoList = prpLChargeApi.queryByBusinessNo(compensateNo);
		List<PrpLPersonLoss> prpLPersonLossList = prpLPersonLossDao.queryAllByCompensateNo(compensateNo);
		for (int i = 0; i < prpLLossDtoList.size(); i++) {
			dangerItemCount++;
			PrpLLossDto prpLlossDto = prpLLossDtoList.get(i);
			if (prpLlossDto.getSumrealPay() != 0) {

			}
			if (kindMap.containsKey(prpLlossDto.getItemkindNo() + "")) {
				String tempSumLoss = String.valueOf((Double.parseDouble(prpLlossDto.getSumrealPay()
									+ "") + Double.parseDouble("" + kindMap.get(prpLlossDto.getItemkindNo() + ""))));
				kindMap.put(prpLlossDto.getItemkindNo() + "", tempSumLoss);
			} else {
				strKindCodeList += ",'" + prpLlossDto.getItemkindNo() + "'";
				kindMap.put(prpLlossDto.getItemkindNo() + "", prpLlossDto.getSumrealPay() + "");
			}
		}
		for (int i = 0; i < prpLPersonLossList.size(); i++) {
			dangerItemCount++;
			PrpLPersonLoss prpLpersonLoss = prpLPersonLossList.get(i);
			if (prpLpersonLoss.getSumRealPay() != 0) {

			}
			if (kindMap.containsKey(prpLpersonLoss.getItemKindNo() + "")) {
				String tempSumLoss = String.valueOf((Double.parseDouble(prpLpersonLoss.getSumRealPay() + "") + Double.parseDouble(""
								+ kindMap.get(prpLpersonLoss.getItemKindNo() + ""))));
				kindMap.put(prpLpersonLoss.getItemKindNo() + "",
								tempSumLoss);
			} else {
				strKindCodeList += ",'" + prpLpersonLoss.getItemKindNo()
						+ "'";
				kindMap.put(prpLpersonLoss.getItemKindNo() + "",
						prpLpersonLoss.getSumRealPay() + "");
			}
		}
		for (int i = 0; i < prpLChargeDtoList.size(); i++) {
			dangerItemCount++;
			PrpLChargeDto prpLchargeDto = prpLChargeDtoList.get(i);
			for(int l=0;l<prpLLossDtoList.size();l++){
				PrpLLossDto prpLlossDto = prpLLossDtoList.get(l);
				if(prpLchargeDto.getKindCode().equals(prpLlossDto.getKindCode())){
					chargeItemkindno = prpLlossDto.getItemkindNo();
					break;
				}
			}
			if (kindMap.containsKey("f"+chargeItemkindno)) {
				double tempSumLoss = 0.0;
				if (kindMap.get(""+chargeItemkindno) != null){
					tempSumLoss = Double.parseDouble(""+ kindMap.get(""+chargeItemkindno));
				}
				double tempSumLossFee = Double.parseDouble(""+ kindMap.get("f"+chargeItemkindno));
				if (prpLchargeDto.getSumRealPay() == 0) {
					tempSumLossFee += prpLchargeDto.getChargeAmount();
				} else {
					tempSumLoss += prpLchargeDto.getSumRealPay();
					tempSumLossFee  = tempSumLossFee + (prpLchargeDto.getChargeAmount() - prpLchargeDto.getSumRealPay());
					kindMap.put(chargeItemkindno + "", tempSumLoss);
				}
				kindMap.put("f"+chargeItemkindno, tempSumLossFee);
			} else {
				strKindCodeList += ",'" + prpLchargeDto.getItemKindNo() + "'";
				if (prpLchargeDto.getSumRealPay() == 0) {
					kindMap.put("f"+chargeItemkindno,prpLchargeDto.getChargeAmount()+"");
				} else {
					kindMap.put("f"+chargeItemkindno,(prpLchargeDto.getChargeAmount() - prpLchargeDto.getSumRealPay())+"");
					if (kindMap.get(chargeItemkindno+"") != null){
						kindMap.put(chargeItemkindno+"", Double.parseDouble(""+kindMap.get(chargeItemkindno+"")) + prpLchargeDto.getSumRealPay()); //计入赔款的部分加到原来赔款上面
					}
				}
			}
			//费用信息单独存放到map中
		}
		if (strKindCodeList.length()>1){
			strKindCodeList = strKindCodeList.substring(1);
		}else {
			strKindCodeList = "''";
		}
		// 根据标的代码查询数据库危险单位信息 start
		PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
		prpLClaimKey.setClaimNo(prpLCompensate.getClaimNo());
		PrpLClaim prpLclaim = prpLClaimDao.findOne(prpLClaimKey);
		String policyNo = prpLclaim.getPolicyNo();
		List<NewDangerUnitDto> prpdangerUnitList ;
		// 如果在出险时间之前存在批改，则取pdangunit表的数据，否则取cdangunit表的数据
		String wherepart = " policyno='" + policyNo
				+ "' and validdate <= date '"
				+ prpLclaim.getDamageStartDate() + "' "
				+ "  and underwriteflag in ('1','3')";
		StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM PrpPhead ");
		int count=0;
		if (StringUtils.isNotEmpty(policyNo) && prpLclaim.getDamageStartDate()!= null){
			Map<String,Object> paraMap = new HashMap<>();
			paraMap.put("policyNo",policyNo);
			paraMap.put("damageStartDate",prpLclaim.getDamageStartDate());
			stringBuilder.append(" where policyno=:policyNo and validdate <=:damageStartDate and underwriteflag in ('1','3') ");
			Query query = entityManager.createNativeQuery(stringBuilder.toString());
			this.setQueryParam(query,paraMap);
			BigDecimal result = (BigDecimal)query.getSingleResult();
			count = Integer.valueOf(result.toString());
		}
		if (count == 0) {
			prpdangerUnitList = this.getCompensatePrpCdangerUnit(policyNo, strKindCodeList);
		} else {
			if ("05".indexOf(prpLCompensate.getClassCode()) > -1) {
				prpdangerUnitList = this.getCompensatePrpPdangerUnit(prpLclaim.getRegistNo(), policyNo, strKindCodeList);
			} else {
				prpdangerUnitList = this.getCompensatePrpPdangerUnit(prpLclaim.getRegistNo(), policyNo, strKindCodeList);
			}
		}
		// 根据标的代码查询数据库危险单位信息 end

		double dbSumLoss = 0D;
		double dbSumFee = 0D;
		double dbshare = 0D;
		double tempSumLoss = 0D;
		double tempSumFee = 0D;
		// 危险单位估损金额按照标的序号最后一位减法原则处理
		boolean flag = false;
		NewDangerUnitDto newDangerUnitDto = null;
		for (int i = 0; i < prpdangerUnitList.size(); i++) {
			newDangerUnitDto = prpdangerUnitList.get(i);
			dbSumLoss = Double.parseDouble(Str.chgStrZero("" + kindMap.get("f"+chargeItemkindno)));
			if(kindMap.containsKey("f"+newDangerUnitDto.getItemkindno())){
				dbSumFee = Double.parseDouble(Str.chgStrZero("" + kindMap.get("f"+newDangerUnitDto.getItemkindno())));
			}
			dbSumLoss = dbSumLoss + dbSumFee ; //赔付金额=赔款 + 费用
			dbshare = Double.parseDouble(Str.chgStrZero(newDangerUnitDto.getDangerkindshare()));
			flag = false;
			for (int j = i + 1; j < prpdangerUnitList.size(); j++) {
				NewDangerUnitDto newDangerUnitDtoTemp = prpdangerUnitList.get(i);
				if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
					flag = true;
					break;
				}
			}
			if (flag) {
				dbSumLoss = Str.round((dbSumLoss * (dbshare / 100)), 2);
				newDangerUnitDto.setDangerkindAmount("" + dbSumLoss);
				dbSumFee = Str.round((dbSumFee * (dbshare / 100)), 2);
				newDangerUnitDto.setDangerkindFee("" + dbSumFee);
			} else {
				tempSumLoss = 0;
				for (int k = 0; k < i; k++) {
					NewDangerUnitDto newDangerUnitDtoTemp = prpdangerUnitList.get(k);
					if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
						tempSumLoss += Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindAmount()));
						tempSumFee += Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindFee()));
					}
				}
				newDangerUnitDto.setDangerkindAmount("" + Str.round((dbSumLoss - tempSumLoss), 2));
				newDangerUnitDto.setDangerkindFee("" + Str.round((dbSumFee - tempSumFee), 2));
			}
		}

		ArrayList dangerUnitList = new ArrayList();
		ArrayList dangerItemList = new ArrayList();
		ArrayList dangerTotList = new ArrayList();

		double temp = 0;
		double sumDangerUnit = 0d;
		double sumDangerUnitFee = 0d;
		flag = true;

		PrpLDangerItemDto prpLdangerItemDto;

		NewDangerUnitDto newDangerUnitDto1;
		for (int index = 0; index < prpdangerUnitList.size(); index++) {
			newDangerUnitDto1 = prpdangerUnitList.get(index);
			if (Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()) != 0 && Double.parseDouble(newDangerUnitDto1.getDangerkindshare()) != 0) {
				prpLdangerItemDto = new PrpLDangerItemDto();
				prpLdangerItemDto.setCertiNo(compensateNo); // 立案号
				prpLdangerItemDto.setDangerNo(Integer.parseInt(newDangerUnitDto1.getDangerno())); // 危险单位
				prpLdangerItemDto.setCurrency(newDangerUnitDto1.getCurrency()); // 损失币别
				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
				prpLdangerItemDto.setKindCode(newDangerUnitDto1.getKindcode());
				prpLdangerItemDto.setKindName(newDangerUnitDto1.getKindname());
				prpLdangerItemDto.setRiskCode(newDangerUnitDto1.getRiskcode());
				prpLdangerItemDto.setAddressName(newDangerUnitDto1.getAddressname());
				prpLdangerItemDto.setPolicyNo(newDangerUnitDto1.getPolicyno());
				prpLdangerItemDto.setDangerDesc(newDangerUnitDto1.getDangerdesc());
				prpLdangerItemDto.setItemCode(newDangerUnitDto1.getItemcode());
				prpLdangerItemDto.setItemName(newDangerUnitDto1.getItemname());
				// 占比最后一个减法原则
				flag = true;
				for (int i = index + 1; i < prpdangerUnitList.size(); i++) {
					NewDangerUnitDto newDangerUnitDtoI = prpdangerUnitList.get(i);
					if (newDangerUnitDto1.getItemkindno().equals(
							newDangerUnitDtoI.getItemkindno())) {
						flag = false;
					}
				}
				if (flag) {
					temp = 0;
					for (int k = 0; k < index; k++) {
						NewDangerUnitDto newDangerUnitDtok = prpdangerUnitList.get(k);
						if (newDangerUnitDtok.getItemkindno().equals(newDangerUnitDto1.getItemkindno())) {
							temp += Str.round(Double.parseDouble(newDangerUnitDtok.getDangerkindshare()), 2);
						}
					}
					prpLdangerItemDto.setDangerKindShare(Str.round(100 - temp, 2));
				} else {
					prpLdangerItemDto.setDangerKindShare(Double.parseDouble(newDangerUnitDto1.getDangerkindshare()));
				}

				prpLdangerItemDto.setSumPaid(Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()), 2));
				prpLdangerItemDto.setSumFee(Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindFee()), 2));
				prpLdangerItemDto.setSerialNo(Integer.parseInt(newDangerUnitDto1.getItemkindno())); // 标的序号
				sumDangerUnit += Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()), 2);
				sumDangerUnitFee += Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindFee()), 2);
				// 加入集合
				if (prpLdangerItemDto != null) {
					dangerItemList.add(prpLdangerItemDto);
				}
			}
		}

		// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）
		PrpLDangerTotDto prpLdangerTotDto = new PrpLDangerTotDto(); // 金额合计Dto
		Iterator iterator = null;
		PrpLDangerTotDto prpLdangerTotNewDto = null;
		Iterator itTot = null;
		PrpLDangerItemDto prpLdangerItemNewDto = null; // 标的DTO
		boolean find = true;
		if (dangerItemList != null) {
			iterator = dangerItemList.iterator();
			while (iterator.hasNext()) {
				prpLdangerItemNewDto = (PrpLDangerItemDto) iterator.next();
				find = false;
				itTot = dangerTotList.iterator();
				while (itTot.hasNext()) {
					prpLdangerTotNewDto = (PrpLDangerTotDto) itTot.next();
					if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
						find = true;
						prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
						prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx() + prpLdangerItemNewDto.getSumPaid(), 2));
						prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotNewDto.getSumFee()+ prpLdangerItemNewDto.getSumFee(), 2));
						prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotNewDto.getSumFeeEx()+ prpLdangerItemNewDto.getSumFee(), 2));
						break;
					}
				}
				// 每个危险单位标的的第一次数据的生成
				if (find == false) {
					prpLdangerTotNewDto = new PrpLDangerTotDto();
					prpLdangerTotNewDto.setCertiNo(compensateNo);
					prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
					prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // 标的原币别
					prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
					prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
					prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
					prpLdangerTotNewDto.setExchRate(1.0);
					prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
					prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
					// 加入集合
					if (prpLdangerTotNewDto != null) {
						dangerTotList.add(prpLdangerTotNewDto);
					}
				}
			}
		}

		// 3、生成危险单位prpLdangerUnit
		Map<String,String> map = new HashMap<>();
		map.put("policyNo",policyNo);
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
		Iterator itUnit = null;
		PrpLDangerUnitDto prpLdangerUnitNewDto = null;
		if (dangerItemList != null) {
			iterator = dangerItemList.iterator();
			while (iterator.hasNext()) {
				prpLdangerItemNewDto = (PrpLDangerItemDto) iterator.next();
				find = false;
				itUnit = dangerUnitList.iterator();
				while (itUnit.hasNext()) {
					prpLdangerUnitNewDto = (PrpLDangerUnitDto) itUnit.next();
					if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
						find = true;
						prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
						prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee()+ prpLdangerItemNewDto.getSumFee(), 2));
						prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
						break;
					}
				}
				// 每个危险单位标的的第一次数据的生成
				if (find == false) {

					prpLdangerUnitNewDto = new PrpLDangerUnitDto();
					prpLdangerUnitNewDto.setCertiNo(compensateNo);
					prpLdangerUnitNewDto.setClaimNo(prpLCompensate.getClaimNo());
					prpLdangerUnitNewDto.setCertiType("3");
					prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto
							.getRiskCode());
					prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto
							.getPolicyNo());
					prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto
							.getDangerNo());
					prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto
							.getDangerDesc());
					prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto
							.getAddressName());
					prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto
							.getCurrency());
					prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto
							.getSumPaid());
					prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
					List<PrpLDangerUnit> prpLDangerUnitList = prpLDangerUnitDao.queryAllByClaimNoAndDangerNo(claimNo1, prpLdangerUnitNewDto.getDangerNo());
					PrpLDangerUnit prpLDangerUnit = new PrpLDangerUnit();
					if (prpLDangerUnitList.size()>0){
						prpLDangerUnit = prpLDangerUnitList.get(0);
					}
					//	prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
					if(!"".equals(prpLDangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())
							&&prpLDangerUnit.getSumLoss() != null && prpLdangerItemNewDto.getSumPaid() != null){
						prpLdangerUnitNewDto.setSumLoss(Double.parseDouble(prpLDangerUnit.getSumLoss().toString()));
						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(prpLDangerUnit.getSumLoss().toString()) - prpLdangerUnitNewDto.getSumPaid());
					}
					prpLdangerUnitNewDto.setCoinsFlag(prpCmainDto
							.getCoinsFlag());
					prpLdangerUnitNewDto.setDamageDate(prpLclaim.getDamageStartDate());
					// prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.
					// getBusinessType1());
//					dbPrpCmain.getInfo(policyNo);
					prpLdangerUnitNewDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
					prpLdangerUnitNewDto.setBusinessNature(prpCmainDto.getBusinessNature());
					prpLdangerUnitNewDto.setBusinessType(prpCmainDto.getBusinessType());
					prpLdangerUnitNewDto.setBusinessType1(prpCmainDto.getBusinessType1());
					prpLdangerUnitNewDto.setPolicyBizType(prpCmainDto.getPolicyBizType());
					prpLdangerUnitNewDto.setPolicyType(prpCmainDto.getPolicyType());
					prpLdangerUnitNewDto.setOthFlag(prpCmainDto.getOthFlag());
					prpLdangerUnitNewDto.setBusinessProvince(prpCmainDto.getBusinessProvince());
					prpLdangerUnitNewDto.setBusinessTown(prpCmainDto.getBusinessTown());
					prpLdangerUnitNewDto.setBusinessCounty(prpCmainDto.getBusinessCounty());
					prpLdangerUnitNewDto.setBusinessAreaName(prpCmainDto.getBusinessAreaName());
					// 加入集合
					if (prpLdangerUnitNewDto != null) {
						dangerUnitList.add(prpLdangerUnitNewDto);
					}
				}
			}
			// 最后一个占比减法原则
			double dangerShare = 0;
			double tempSumDangerShare = 0;
			ClaimDto claimDto = new ClaimDto();
			tempSumLoss = 0;
			double sumTempSumLoss = 0;
			double tempSumNoPaid = 0;
			double sumTempNoPaid = 0;
			PrpLDangerUnitDto prpLdangerUnitDtotemp = null;
			for (int i = 0; i < dangerUnitList.size(); i++) {
				prpLdangerUnitDtotemp = (PrpLDangerUnitDto) dangerUnitList
						.get(i);
				if (i == (dangerUnitList.size() - 1)) {
					dangerShare = Str.round(100 - tempSumDangerShare, 2);
					tempSumNoPaid = Str.round(prpLclaim.getSumClaim()
							- prpLdangerUnitDtotemp.getSumPaid()
							- sumTempNoPaid, 2);
					tempSumLoss = Str.round(prpLclaim.getSumClaim() - sumTempSumLoss, 2);
				} else {
					dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid()
							/ sumDangerUnit * 100, 2);
					tempSumDangerShare = Str.round(tempSumDangerShare
							+ dangerShare, 2);
					tempSumNoPaid = Str.round((prpLclaim.getSumClaim() - prpLdangerUnitDtotemp.getSumPaid())
							* dangerShare / 100, 2);
					sumTempNoPaid = Str.round(sumTempSumLoss + tempSumLoss, 2);
					tempSumLoss = Str.round(prpLclaim.getSumClaim()
							* dangerShare / 100, 2);
					sumTempSumLoss = Str.round(sumTempSumLoss + tempSumLoss, 2);
				}
				prpLdangerUnitDtotemp.setDangerShare(dangerShare);
				prpLdangerUnitDtotemp.setClaimDate(prpLclaim.getClaimDate());
				prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
				if("1".equals(prpLCompensate.getFinallyFlag())){
					prpLdangerUnitDtotemp.setSumNoPaid(0.0);  //结案  未决赔款置零
				}else{
					prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
					prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid()-prpLCompensate.getSumThisPaid(),2));
				}
			}
		}

		String conditions = " CertiNo = '"+compensateNo + "'";
		//add begin by zhaijq 20060404 删除联共保信息
//		prpLDangerCoinsDao.deleteByCertiNo(compensateNo);
//		//add end by zhaijq 20060404
//		prpLDangerTotDao.deleteByCertiNo(compensateNo);
//		prpLDangerItemDao.deleteByCertiNo(compensateNo);
//		prpLDangerUnitDao.deleteByCertiNo(compensateNo);

		// 保存新生成的数据
		if (dangerUnitList != null) {
			Iterator iterator1 = dangerUnitList.iterator();
			while (iterator1.hasNext()) {
				PrpLDangerUnitDto prpLdangerUnitDto1 = (PrpLDangerUnitDto) iterator1.next();
				prpLdangerUnitDto1.setClaimAddTimes(0);
				prpLDangerUnitDao.save(this.convert(prpLdangerUnitDto1,PrpLDangerUnit.class));
			}
		}
		if (dangerItemList != null) {
			Iterator iterator1 = dangerItemList.iterator();
			while (iterator1.hasNext()) {
				PrpLDangerItemDto prpLdangerItemDto1 = new PrpLDangerItemDto();
				prpLdangerItemDto1 = (PrpLDangerItemDto) iterator1.next();
				prpLdangerItemDto1.setClaimAddTimes(0);
				prpLDangerItemDao.save(this.convert(prpLdangerItemDto1,PrpLDangerItem.class));
			}
		}
		if (dangerTotList != null) {
			Iterator iterator1 = dangerTotList.iterator();
			while (iterator1.hasNext()) {
				PrpLDangerTotDto prpLdangerTotDto1 = new PrpLDangerTotDto();
				prpLdangerTotDto1 = (PrpLDangerTotDto) iterator1.next();
				prpLdangerTotDto1.setClaimAddTimes(0);
				prpLDangerTotDao.save(this.convert(prpLdangerTotDto1,PrpLDangerTot.class));
			}
		}

		//add begin by zhaijq 20060404 存储联共保信息
		if (prpLdangerCoinsDtoList != null) {
			Iterator iterator1 = prpLdangerCoinsDtoList.iterator();
			while (iterator.hasNext()) {
				prpLdangerCoinsDto = (PrpLDangerCoinsDto) iterator1.next();
				prpLDangerCoinsDao.save(this.convert(prpLdangerCoinsDto,PrpLDangerCoins.class));
			}
		}
	}


	private List<NewDangerUnitDto> getCompensatePrpCdangerUnit(String policyNo,String kingCodeList){
		StringBuilder sqlC =new StringBuilder("select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname"
				+ " from prpcdangeritem m, prpcdangerunit t"
				+ " where m.policyno = '"
				+ policyNo
				+ "'"
				+ "  and m.policyno = t.policyno"
				+ " and m.dangerno = t.dangerno"
				+ " and m.serialno in ("+ kingCodeList + ") "
				+ " order by t.dangerno,m.serialno ");
		Query query = entityManager.createNativeQuery(sqlC.toString());
		List<Object[]> objects = query.getResultList();
		NewDangerUnitDto newDangerUnitDto ;
		List<NewDangerUnitDto> newDangerUnitDtoList = new ArrayList<>();
		if (objects.size()>0){
			for (Object[] object:objects){
				newDangerUnitDto= new NewDangerUnitDto();
				newDangerUnitDto.setPolicyno((String)object[10]);
				newDangerUnitDto.setRiskcode((String)object[11]);
				BigDecimal dangerNo = (BigDecimal) object[0];
				newDangerUnitDto.setDangerno(dangerNo.toString());
				newDangerUnitDto.setKindcode((String)object[3]);
				newDangerUnitDto.setKindname((String)object[4]);
				newDangerUnitDto.setDangerdesc((String)object[1]);
				newDangerUnitDto.setAddressname((String)object[2]);
				BigDecimal dangerkindshare = (BigDecimal)object[6];
				newDangerUnitDto.setDangerkindshare(dangerkindshare.toString());
				newDangerUnitDto.setCurrency((String)object[5]);
				newDangerUnitDto.setItemcode((String)object[7]);
				newDangerUnitDto.setItemname((String)object[8]);
				BigDecimal itemKindno = (BigDecimal) object[9];
				newDangerUnitDto.setItemkindno(itemKindno.toString());
				newDangerUnitDto.setBusinessNature((String)object[12]);
				newDangerUnitDto.setPolicyBizType((String)object[13]);
				newDangerUnitDto.setPolicyType((String)object[14]);
				newDangerUnitDto.setOthFlag((String)object[17]);
				newDangerUnitDto.setBusinessType((String)object[16]);
				newDangerUnitDto.setBusinessType1((String)object[15]);
				newDangerUnitDto.setBusinessProvince((String)object[18]);
				newDangerUnitDto.setBusinessTown((String)object[19]);
				newDangerUnitDto.setBusinessCounty((String)object[20]);
				newDangerUnitDto.setBusinessAreaName((String)object[21]);
				newDangerUnitDtoList.add(newDangerUnitDto);
			}
		}
		return newDangerUnitDtoList;
	}

	private List<NewDangerUnitDto> getCompensatePrpPdangerUnit(String registNo,String policyNo,String strKindCodeList){
		StringBuilder stringBuilder = new StringBuilder("select * from (select rownum as rn, phead.* from (select endorseno from prpphead h  " +
				"where h.validdate <=(select t.damagestartdate"
				+ " from prplregist t"
				+ " where registno = '"
				+ registNo
				+ "')"
				+ " and policyno = '"
				+ policyNo
				+ "'"
				+ " and underwriteflag in ('1','3')"
				+ "  order by h.validdate desc ) phead)" + " where rn = 1");
		StringBuilder sqlp = new StringBuilder("");
		Query query = entityManager.createNativeQuery(stringBuilder.toString());
		List<Object[]> objects = query.getResultList();
		if (objects.size()>0) {
			sqlp.append( "  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode , nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname "
					+ "  from prppdangeritem m, prppdangerunit t"
					+ " where m.endorseno = '"
					+ objects.get(0)[0]
					+ "'"
					+ " and m.endorseno = t.endorseno"
					+ " and m.dangerno = t.dangerno"
					+ " and m.serialno in ("+ strKindCodeList + ")"
					+ "  order by t.dangerno,m.serialno");
		}
		Query query1 = entityManager.createNativeQuery(sqlp.toString());
		List<Object[]> objects1 = query1.getResultList();
		NewDangerUnitDto  newDangerUnitDto;
		List<NewDangerUnitDto> newDangerUnitDtos = new ArrayList();
		if (objects1.size()>0) {
			for (Object[] object:objects1){
				newDangerUnitDto= new NewDangerUnitDto();
				newDangerUnitDto.setPolicyno((String)object[10]);
				newDangerUnitDto.setRiskcode((String)object[11]);
				BigDecimal dangerNo = (BigDecimal) object[0];
				newDangerUnitDto.setDangerno(dangerNo.toString());
				newDangerUnitDto.setKindcode((String)object[3]);
				newDangerUnitDto.setKindname((String)object[4]);
				newDangerUnitDto.setDangerdesc((String)object[1]);
				newDangerUnitDto.setAddressname((String)object[2]);
				BigDecimal dangerkindshare = (BigDecimal)object[6];
				newDangerUnitDto.setDangerkindshare(dangerkindshare.toString());
				newDangerUnitDto.setCurrency((String)object[5]);
				newDangerUnitDto.setItemcode((String)object[7]);
				newDangerUnitDto.setItemname((String)object[8]);
				BigDecimal itemKindno = (BigDecimal) object[9];
				newDangerUnitDto.setItemkindno(itemKindno.toString());
				newDangerUnitDto.setBusinessNature((String)object[12]);
				newDangerUnitDto.setPolicyBizType((String)object[13]);
				newDangerUnitDto.setPolicyType((String)object[14]);
				newDangerUnitDto.setOthFlag((String)object[17]);
				newDangerUnitDto.setBusinessType((String)object[16]);
				newDangerUnitDto.setBusinessType1((String)object[15]);
				newDangerUnitDto.setBusinessProvince((String)object[18]);
				newDangerUnitDto.setBusinessTown((String)object[19]);
				newDangerUnitDto.setBusinessCounty((String)object[20]);
				newDangerUnitDto.setBusinessAreaName((String)object[21]);
				newDangerUnitDtos.add(newDangerUnitDto);
			}
		}
		return newDangerUnitDtos;
	}

	//联供保新危险单位重新生成
	@Transactional(rollbackFor = Exception.class)
	public void getCDangerInfo(PrpLCompensateDto prpLcompensateDto) throws Exception {
		List<PrpLDangerUnitDto> prpLdangerUnitDtoList = new ArrayList<>();
		List<PrpLDangerItemDto> prpLdangerItemDtoList = new ArrayList<>();
		List<PrpLDangerTotDto> prpLdangerTotDtoList = new ArrayList<>();
		List<PrpLDangerCoinsDto> prpLdangerCoinsDtoList = new ArrayList<>();
		PrpLDangerCoinsDto  prpLdangerCoinsDto      = null;
		int dangerItemCount = 0;// 出险标的个数

		// 获取实赔信息
		PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
		prpLCompensateKey.setCompensateNo(prpLcompensateDto.getCompensateNo());
		List<PrpLChargeDto> prpLChargeDtoList = prpLChargeApi.queryByBusinessNo(prpLcompensateDto.getCompensateNo());
		List<PrpLLossDto> prpLLossDtoList = prpLLossApi.queryByBusinessNo(prpLcompensateDto.getCompensateNo());
		List<PrpLPersonLoss> prpLPersonLossList = prpLPersonLossDao.queryAllByCompensateNo(prpLcompensateDto.getCompensateNo());
		PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);

		// 生成PrpLdangerItem数据
		for (int i = 0; i < prpLLossDtoList.size(); i++) {
			dangerItemCount++;
			PrpLLossDto prpLLossDto =  prpLLossDtoList.get(i);
			PrpLDangerItemDto prpLdangerItemDto = new PrpLDangerItemDto();
			prpLdangerItemDto.setCertiNo(prpLLossDto.getCompensateNo());
			prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
			prpLdangerItemDto.setCurrency(prpLLossDto.getCurrency()); // 损失币别
			prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
			prpLdangerItemDto.setKindName("正常"); // 险别归类名称
			prpLdangerItemDto.setRiskCode(prpLLossDto.getRiskCode());
			prpLdangerItemDto.setSerialNo(dangerItemCount); // 标的序号
			prpLdangerItemDto.setSumPaid(prpLLossDto
					.getSumrealPay());
			prpLdangerItemDto.setKindCode(prpLLossDto.getKindCode());
			prpLdangerItemDtoList.add(prpLdangerItemDto);
		}
		for (int i = 0; i < prpLPersonLossList.size(); i++) {
			dangerItemCount++;
			PrpLPersonLoss prpLpersonLossSchema = prpLPersonLossList.get(i);
			PrpLDangerItemDto prpLdangerItemDto = new PrpLDangerItemDto();
			prpLdangerItemDto.setCertiNo(prpLpersonLossSchema
					.getCompensateNo());
			prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
			prpLdangerItemDto.setCurrency(prpLpersonLossSchema
					.getCurrency()); // 损失币别
			prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
			prpLdangerItemDto.setKindName("正常"); // 险别归类名称
			prpLdangerItemDto.setRiskCode(prpLpersonLossSchema
					.getRiskCode());
			prpLdangerItemDto.setSerialNo(dangerItemCount); // 标的序号
			prpLdangerItemDto.setSumPaid(prpLpersonLossSchema.getSumRealPay());
			prpLdangerItemDto.setKindCode(prpLpersonLossSchema.getKindCode());
			prpLdangerItemDtoList.add(prpLdangerItemDto);
		}
		for (int i = 0; i < prpLChargeDtoList.size(); i++) {
			dangerItemCount++;
			PrpLChargeDto prpLChargeDto =  prpLChargeDtoList.get(i);
			PrpLDangerItemDto prpLdangerItemDto = new PrpLDangerItemDto();
			prpLdangerItemDto
					.setCertiNo(prpLChargeDto.getCompensateNo());
			prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
			prpLdangerItemDto.setCurrency(prpLChargeDto.getCurrency()); // 损失币别
			prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
			prpLdangerItemDto.setKindName("正常"); // 险别归类名称
			prpLdangerItemDto.setRiskCode(prpLChargeDto.getRiskCode());
			prpLdangerItemDto.setSerialNo(dangerItemCount); // 标的序号
			if(prpLChargeDto.getSumRealPay() == 0 ){
				prpLdangerItemDto.setSumPaid(prpLChargeDto.getChargeAmount());
			}else{
				prpLdangerItemDto.setSumPaid(prpLChargeDto.getSumRealPay());
			}
			prpLdangerItemDto.setKindCode(prpLChargeDto.getKindCode());
			prpLdangerItemDtoList.add(prpLdangerItemDto);
		}
		// 生成PrpLdangerTot数据
		if (prpLdangerItemDtoList != null) {
			boolean findCurrency = false;
			Iterator itItem = prpLdangerItemDtoList.iterator();
			while (itItem.hasNext()) {
				PrpLDangerItemDto prpLdangerItemDto = (PrpLDangerItemDto) itItem
						.next();
				findCurrency = false;
				if (prpLdangerTotDtoList != null) {
					Iterator itTot = prpLdangerTotDtoList.iterator();
					while (itTot.hasNext()) {
						PrpLDangerTotDto prpLdangerTotDto = (PrpLDangerTotDto) itTot.next();
						if (prpLdangerTotDto.getTCurrency().equals(prpLdangerItemDto.getCurrency())) {
							prpLdangerTotDto.setSumPaid(prpLdangerTotDto.getSumPaid() + prpLdangerItemDto.getSumPaid());
							prpLdangerTotDto.setSumFee(prpLdangerTotDto.getSumFee() + prpLdangerItemDto.getSumFee());
							prpLdangerTotDto.setSumPaidEx(prpLdangerTotDto.getSumPaidEx() + prpLdangerItemDto.getSumPaid() * prpLdangerTotDto.getExchRate());
							prpLdangerTotDto.setSumFeeEx(prpLdangerTotDto.getSumFeeEx() + prpLdangerItemDto.getSumFee() * prpLdangerTotDto.getExchRate());
							findCurrency = true;
							break;
						}
					}
				}
				if (findCurrency == false) {
					PrpLDangerTotDto prpLdangerTotDto = new PrpLDangerTotDto();
					prpLdangerTotDto.setCertiNo(prpLdangerItemDto
							.getCertiNo());
					prpLdangerTotDto.setDangerNo(1); // 目前，就一个危险单位
					prpLdangerTotDto.setSCurrency(prpLdangerItemDto
							.getCurrency()); // 标的原币别
					prpLdangerTotDto.setSumFee(prpLdangerItemDto
							.getSumFee());
					prpLdangerTotDto.setSumPaid(prpLdangerItemDto
							.getSumPaid());
					prpLdangerTotDto.setTCurrency("CNY");
					// 进行币别转化 转化后的币别为TCurrency
					String SCurrency = prpLdangerItemDto.getCurrency(); // 原币别
					double exchangeRate = prpCcoinsApi.getPubTools("CNY",
							"CNY", String.valueOf(new Date()));
					prpLdangerTotDto.setExchRate(exchangeRate);
					if (prpLdangerTotDto.getSumFee()!= null){
						prpLdangerTotDto.setSumFeeEx(prpLdangerTotDto.getSumFee() * exchangeRate);
					}else {
						prpLdangerTotDto.setSumFeeEx(0.0);
					}
					prpLdangerTotDto.setSumPaidEx(prpLdangerTotDto
							.getSumPaid()
							* exchangeRate);
					prpLdangerTotDtoList.add(prpLdangerTotDto);
				}
			}
		}
		//add begin by zhaijq 20060404 联共保信息处理
		Map<String,String> map = new HashMap<>();
		map.put("policyNo",prpLcompensateDto.getPolicyNo());
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
//		StringBuilder prpcdangerSQl = new StringBuilder("select p.* from PrpCdangerCoins p where p.policyNo=:policyNo ");
//		Query query = entityManager.createNativeQuery(prpcdangerSQl.toString());
//		Map<String,Object> paraMap = new HashMap<>();
//		paraMap.put("policyNo",prpLcompensateDto.getPolicyNo());
//		this.setQueryParam(query,paraMap);
//		List<PrpCdangerCoinsDto>  prpCdangerCoinsDtoList = query.getResultList();
        List<PrpCdangerCoinsDto> prpCdangerCoinsDtoList = prpCdangCoinsApi.queryCdangerCoinsDtos(prpLcompensateDto.getPolicyNo());
        System.out.println("BLLDangerGetAction DBPrpLcfeecoins conditions:BusinessNo ='"+prpLcompensateDto.getCompensateNo()+"'");
		Collection  prpLcfeecoinsDtoList   = new ArrayList() ; // new DBPrpLcfeecoins(dbManager).findByConditions(" BusinessNo = '"+prpLcompensateDto.getCompensateNo()+"'");
		double      sumLoss                = 0d;
		double      sumPay                 = 0d;
		double      sumFee                 = 0d;
		double      sumNoPaid              = 0d;
		if (!prpCmainDto.getCoinsFlag().equals("0"))
		{
			if (prpCdangerCoinsDtoList != null && prpCdangerCoinsDtoList.size()>0)
			{
				Iterator iterator = prpCdangerCoinsDtoList.iterator();
				while(iterator.hasNext())
				{
					PrpCdangerCoinsDto prpCdangerCoinsDto = (PrpCdangerCoinsDto)iterator.next();
					prpLdangerCoinsDto = new PrpLDangerCoinsDto();
					prpLdangerCoinsDto.setCertiNo(prpLcompensateDto.getCompensateNo());
					prpLdangerCoinsDto.setDangerNo(1);
					prpLdangerCoinsDto.setSerialNo(prpCdangerCoinsDto.getSerialNo());
					prpLdangerCoinsDto.setMainCertiNo(prpLcompensateDto.getCompensateNo());
					prpLdangerCoinsDto.setCoinsCode(prpCdangerCoinsDto.getCoinsCode());
					prpLdangerCoinsDto.setCoinsName(prpCdangerCoinsDto.getCoinsName());
					prpLdangerCoinsDto.setCoinsType(prpCdangerCoinsDto.getCoinsType());
					prpLdangerCoinsDto.setCoinsRate(prpCdangerCoinsDto.getCoinsRate());
					prpLdangerCoinsDto.setChiefFlag(prpCdangerCoinsDto.getChiefFlag());
					prpLdangerCoinsDto.setCurrency(prpLcompensateDto.getCurrency());
					prpLdangerCoinsDto.setFlag("");

					if (prpLcfeecoinsDtoList != null && prpLcfeecoinsDtoList.size()>0)
					{
						Iterator itLfee = prpLcfeecoinsDtoList.iterator();
						while(itLfee.hasNext())
						{
							PrpLCfeecoinsDto prpLcfeecoinsDto = (PrpLCfeecoinsDto) itLfee.next();
							if (prpLcfeecoinsDto.getCoinsCode().equals(prpLdangerCoinsDto.getCoinsCode())){
								if (prpLcfeecoinsDto.getLossFeeType().equals("0"))//实赔
								{
									sumPay = sumPay + prpLcfeecoinsDto.getCoinsSumPaid();
									prpLdangerCoinsDto.setCoinsSumPaid(prpLcfeecoinsDto.getCoinsSumPaid());
								}else if (prpLcfeecoinsDto.getLossFeeType().equals("1"))//费用
								{
									sumFee = sumFee + prpLcfeecoinsDto.getCoinsSumPaid();
									prpLdangerCoinsDto.setCoinsSumFee(prpLcfeecoinsDto.getCoinsSumPaid());
								}else if (prpLcfeecoinsDto.getLossFeeType().equals("2"))//未决
								{
									sumNoPaid = sumNoPaid + prpLcfeecoinsDto.getCoinsSumPaid();
									prpLdangerCoinsDto.setCoinsSumNoPaid(prpLcfeecoinsDto.getCoinsSumPaid());
								}
								prpLdangerCoinsDto.setCoinsSumLoss(prpLdangerCoinsDto.getCoinsSumPaid()+prpLdangerCoinsDto.getCoinsSumNoPaid());
							}
						}
					}
					prpLdangerCoinsDtoList.add(prpLdangerCoinsDto);
				}
			}
			sumLoss = sumPay + sumNoPaid;
		}
		//add end by zhaijq 20060404

		// 生成PrpLdangerUnit数据
		PrpLDangerUnitDto prpLdangerUnitDto = new PrpLDangerUnitDto();
		prpLdangerUnitDto
				.setCertiNo(prpLCompensate.getCompensateNo());
		prpLdangerUnitDto.setClaimNo(prpLCompensate.getClaimNo());
		prpLdangerUnitDto.setCertiType("3");// 案终为实赔
		prpLdangerUnitDto.setReinsureFlag("0");
		prpLdangerUnitDto.setRiskCode(prpLCompensate.getRiskCode());
		prpLdangerUnitDto.setPolicyNo(prpLCompensate.getPolicyNo());
		prpLdangerUnitDto.setDangerNo(1);
		prpLdangerUnitDto.setDangerDesc("");
		prpLdangerUnitDto.setAddressName("");
		prpLdangerUnitDto.setCurrency(prpLCompensate.getCurrency());
		//modify begin by zhaijq 联共保理赔的实赔、费用、未决需要各联共保人累加得到
		if (prpCmainDto.getCoinsFlag().equals("0"))
		{
			prpLdangerUnitDto.setSumLoss(Double
					.parseDouble(prpLCompensate.getSumLoss().toString()));
			prpLdangerUnitDto.setSumPaid(Double
					.parseDouble(prpLCompensate.getSumPaid().toString()));
			// 从立案获取实赔
			PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
			prpLClaimKey.setClaimNo(prpLCompensate.getClaimNo());
			PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
			double sumPaid = Double.parseDouble(prpLClaim.getSumPaid().toString());
			prpLdangerUnitDto.setSumNoPaid(prpLClaim.getSumClaim() - sumPaid);
			// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSchema.getSumThisPaid()));
		}else{
			prpLdangerUnitDto.setSumLoss(sumLoss);
			prpLdangerUnitDto.setSumPaid(sumPay);
			prpLdangerUnitDto.setSumFee(sumFee);
			prpLdangerUnitDto.setSumNoPaid(sumNoPaid);
		}
		//modify end by zhaijq 20060404

		prpLdangerUnitDto.setDangerShare(100.0);

		//add begin by zhaijq 20060404 存储联共保标志
		prpLdangerUnitDto.setCoinsFlag(prpCmainDto.getCoinsFlag());
		prpLdangerUnitDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
		prpLdangerUnitDto.setShareHolderFlag(prpCmainDto.getShareholderFlag());
		prpLdangerUnitDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
		prpLdangerUnitDto.setBusinessNature(prpCmainDto.getBusinessNature());
		prpLdangerUnitDto.setBusinessType(prpCmainDto.getBusinessType());
		prpLdangerUnitDto.setBusinessType1(prpCmainDto.getBusinessType1());
		prpLdangerUnitDto.setPolicyBizType(prpCmainDto.getPolicyBizType());
		prpLdangerUnitDto.setPolicyType(prpCmainDto.getPolicyType());
		prpLdangerUnitDto.setOthFlag(prpCmainDto.getOthFlag());
		prpLdangerUnitDto.setBusinessProvince(prpCmainDto.getBusinessProvince());
		prpLdangerUnitDto.setBusinessTown(prpCmainDto.getBusinessTown());
		prpLdangerUnitDto.setBusinessCounty(prpCmainDto.getBusinessCounty());
		prpLdangerUnitDto.setBusinessAreaName(prpCmainDto.getBusinessAreaName());
		prpLdangerUnitDto.setClaimAddTimes(0);

		//add end by zhaijq 20060404
		prpLdangerUnitDtoList.add(prpLdangerUnitDto);
		// 先删除原有的数据

		String conditions = " CertiNo = '"
				+ prpLCompensate.getCompensateNo() + "'";
		//add begin by zhaijq 20060404 删除联共保信息
		prpLDangerCoinsDao.deleteByCertiNo(prpLCompensate.getCompensateNo());
		prpLDangerTotDao.deleteByCertiNo(prpLCompensate.getCompensateNo());
		prpLDangerItemDao.deleteByCertiNo(prpLCompensate.getCompensateNo());
		prpLDangerUnitDao.deleteByCertiNo(prpLCompensate.getCompensateNo());

		// 保存新生成的数据
		if (prpLdangerUnitDtoList != null) {
			Iterator iterator = prpLdangerUnitDtoList.iterator();
			while (iterator.hasNext()) {
				prpLdangerUnitDto = (PrpLDangerUnitDto) iterator.next();
				prpLdangerUnitDto.setClaimAddTimes(0);
				prpLDangerUnitDao.save(this.convert(prpLdangerUnitDto,PrpLDangerUnit.class));
			}
		}
		if (prpLdangerItemDtoList != null) {
			Iterator iterator = prpLdangerItemDtoList.iterator();
			while (iterator.hasNext()) {
				PrpLDangerItemDto prpLdangerItemDto = new PrpLDangerItemDto();
				prpLdangerItemDto = (PrpLDangerItemDto) iterator.next();
				prpLdangerItemDto.setClaimAddTimes(0);
				prpLDangerItemDao.save(this.convert(prpLdangerItemDto,PrpLDangerItem.class));
			}
		}
		if (prpLdangerTotDtoList != null) {
			Iterator iterator = prpLdangerTotDtoList.iterator();
			while (iterator.hasNext()) {
				PrpLDangerTotDto prpLdangerTotDto = new PrpLDangerTotDto();
				prpLdangerTotDto = (PrpLDangerTotDto) iterator.next();
				prpLdangerTotDto.setClaimAddTimes(0);
				prpLDangerTotDao.save(this.convert(prpLdangerTotDto,PrpLDangerTot.class));
			}
		}

		//add begin by zhaijq 20060404 存储联共保信息
		if (prpLdangerCoinsDtoList != null) {
			Iterator iterator = prpLdangerCoinsDtoList.iterator();
			while (iterator.hasNext()) {
				prpLdangerCoinsDto = (PrpLDangerCoinsDto) iterator.next();
                prpLdangerCoinsDto.setClaimAddTimes(0);
                prpLDangerCoinsDao.save(this.convert(prpLdangerCoinsDto,PrpLDangerCoins.class));
			}
		}
	}
}