package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDtoExt;
import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckPageCommonService;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
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
import com.sinosoft.ims.api.auth.UtiPlatConfigApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.insuremainlist.QueryPoilcyListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;

/**
 * @description 查勘定损服务类
 * @author 杨航
 * @date 2017年11月13日
 */
@Service
public class CheckServiceImpl extends BaseServiceImpl implements CheckService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckServiceImpl.class);
	@Autowired
	private PrpLRegistDao prpLRegistDao;
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private UserApi userApi;
	@Autowired
	private CheckPageCommonService checkPageCommonService;
	@Autowired
	private PrpLCompensateEarDao prpLCompensateEarDao;
	@Autowired
	private RiskApi riskApi;
	@Autowired
	private PrpLclaimStatusDao prpLclaimStatusDao;
	@Autowired
	private PrpCmainApi prpCmainApi;
	@Autowired
	private PrpDriskApi prpDriskApi;
	@Autowired
	private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private PrpLClaimDao prpLClaimDao;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private SwfLogDao swfLogDao;
	@Autowired
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PrpLverifyLossDao prpLverifyLossDao;
	@Autowired
	private PrpLPropDao prpLPropDao;
	@Autowired
    private PrpCitemKindApi prpCitemKindApi;
	@Autowired
    private PrpLCheckDao prpLCheckDao;
	@Autowired
	private PrpDcompanyApi prpDcompanyApi;
	@Autowired
	private UtiPlatConfigApi utiPlatConfigApi;
	@Autowired
	private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
	@PersistenceContext
	private EntityManager entityManager;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
	private PrpDcodeApi prpDcodeApi;
	@Autowired
	private QueryPoilcyListApi queryPoilcyListApi;
	@Autowired
	private PrpDitemAgriApi prpDitemAgriApi;
	/**
	 * 查勘登记页面初始化服务实现类
	 * @author 安齐崇
	 * @date 2017年11月15日下午8:23:20
	 * @param requestDto
	 *            入参dto
	 * @return responseDto 出参dto
	 * @throws Exception
	 */
	@Override
	public CheckPageResponseDto checkPageInit(CheckPageRequestDto requestDto) throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("into CheckPageInitServiceImpl.checkPageInit:查勘页面初始化，编辑类型" + requestDto.getEditType());
		}
		this.verifyParam(requestDto);
		CheckPageResponseDto responseDto = new CheckPageResponseDto();
		String status = requestDto.getStatus();
		String modelNo = requestDto.getModelNo();
		String nodeNo = requestDto.getNodeNo();
		/* 编辑类型ADD,EDIT,SHOW */
		String editType = requestDto.getEditType();
		/* 报案号，编辑类型是ADD 时必传 */
		String registNo = requestDto.getRegistNo();
		/* 查勘号，编辑类型是EDIT,SHOW时必传 */
		String checkNo = requestDto.getCheckNo();
		/* 工作流编码 */
		String flowID = requestDto.getFlowId();
		/* 工作流序号 */
		String logNo = requestDto.getLogNo();
		responseDto.setEditType(editType);
		responseDto.setModelNo(modelNo);
		responseDto.setNodeNo(nodeNo);
		responseDto.setStatus(status);
		responseDto.setFlowId(flowID);
		responseDto.setLogNo(logNo);
		/* 设置登录用户信息 */
		this.setUserInfo(responseDto);
		/* 如果报案号为空，根据查勘号得到报案号 */
		if (StringUtils.isBlank(registNo)) {
			if (checkNo.length() > 21) {
				registNo = checkNo.substring(0, 21);
			} else {
				registNo = checkNo;
			}
		}
		responseDto.setRegistNo(registNo);
		/* 设置险种类型和险种编码 */
		String riskCode = this.getRiskCode(registNo);
		String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
		responseDto.setRiskCode(riskCode);
		responseDto.setRiskType(riskType);
		/* ADD编辑类型进行工作流占号分析 */
		if ("ADD".equals(editType)) {
			this.addCheckView(requestDto, responseDto);
		}
		/* ADD,EDIT,SHOW视图头信息相同，提取为共性方法 */
		prepareHead(responseDto);
		/* 设置中部信息和 */
		prepareBody(responseDto);
		/* 设置尾部耳标号信息,I养殖险 */
		if ("I".equals(riskType)) {
			prepareTail(responseDto);
		}
		/* 根据暂存提交做格式调整 */
		formatAndPrepareData(responseDto);
		/* 完善公共部分信息 */
		perfectCommonView(responseDto, requestDto);
		responseDto.setNodeType("check");
		responseDto.setNodeName(prpDcodeApi.translateCodeByPK("ClaimNodeType","check"));
		return responseDto;
	}

	/**
	 * 
	 * @description:方法功能简述: 根据暂存提交做格式调整
	 * @author 安齐崇
	 * @date 2017年12月12日上午11:16:09
	 * @param responseDto
	 */
	private void formatAndPrepareData(CheckPageResponseDto responseDto) {
		responseDto.setPrpLpropDtoList(responseDto.getPrpLverifyLossDto() == null ? new ArrayList<PrpLPropDtoExt>()
				: responseDto.getPrpLverifyLossDto().getPrpLpropDtoExtList());
		responseDto.getPrpLverifyLossDto().setPrpLpropDtoExtList(null);
		PrpLclaimStatus claimStatus = prpLclaimStatusDao
				.findOne(new PrpLclaimStatusKey(responseDto.getRegistNo(), "check", 0));
		PrpLclaimStatusDto claimStatusDto = new PrpLclaimStatusDto();
		claimStatusDto.setStatus(claimStatus == null ? "1" : claimStatus.getStatus());
		responseDto.setPrpLclaimStatusDto(claimStatusDto);
	}

	/**
	 * @description:方法功能简述: 设置尾部耳标号信息，养殖险
	 * @author 安齐崇
	 * @date 2017年11月18日下午4:46:04
	 * @param responseDto
	 */
	private void prepareTail(CheckPageResponseDto responseDto) {
		String editType = responseDto.getEditType();
		String registNo = responseDto.getRegistNo();
		PrpLverifyLossDtoExt prpLverifyLossDto = responseDto.getPrpLverifyLossDto();
		/* 设置耳标号 */
		String taskCode = pageInitCommonService.getConfigRules("FamilySplittingFlag", "claim");
		String earFlag = "0";
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			if ("EDIT".equals(editType) || "SHOW".equals(editType)) {
				Specification<PrpLCompensateEar> specification = Specifications.<PrpLCompensateEar>and()
						.eq("registNo", registNo).eq("nodeType", "check").eq("businessNo", registNo).build();
				List<PrpLCompensateEar> prpLCompensateEarList = prpLCompensateEarDao.findAll(specification);
				List<PrpLCompensateEarDto> prpLCompensateEarDtoList = new ArrayList<PrpLCompensateEarDto>();
				this.convertCollection(prpLCompensateEarList, prpLCompensateEarDtoList, PrpLCompensateEarDto.class);
				responseDto.setPrpLCompensateEarDtoList(prpLCompensateEarDtoList);
				earFlag = "1";
			}
			responseDto.setEarFlag(earFlag);
		}

	}

	/**
	 * @description:方法功能简述:初始页面中部信息 ：定损登记，定损清单
	 * @author 安齐崇
	 * @date 2017年11月18日下午4:42:41
	 * @param responseDto
	 * @throws Exception 
	 */
	private void prepareBody(CheckPageResponseDto responseDto) throws Exception {
		PrpLverifyLossDtoExt prpLverifyLossDtoExt = checkPageCommonService
				.prepareCertainLossView(responseDto.getRegistNo());
		responseDto.setPrpLverifyLossDto(prpLverifyLossDtoExt);
	}

	/**
	 * @description:方法功能简述: 封装查勘头信息到返参
	 * @author 安齐崇
	 * @date 2017年11月17日上午9:44:37
	 * @param responseDto
	 * @return responseDto
	 * @throws Exception
	 */
	private void prepareHead(CheckPageResponseDto responseDto) {
		PrpLcheckDtoExt prpLcheckDtoExt = checkPageCommonService.prepareCommonHeadParam(responseDto.getRegistNo());
		if ("ADD".equals(responseDto.getEditType())) {
			prpLcheckDtoExt.setChecker1(responseDto.getUserName());

		}
		/* 设置出险摘要 */
		responseDto.setContext(prpLcheckDtoExt.getContext());
		prpLcheckDtoExt.setContext(null);
		/* 设置查勘页面初始化头信息 */
		responseDto.setPrpLcheckDto(prpLcheckDtoExt);
	}

	/**
	 * @description:方法功能简述: 设置登录用户信息到返回对象
	 * @author 安齐崇
	 * @date 2017年11月16日上午10:53:43
	 * @param responseDto
	 *            返回对象
	 */
	private void setUserInfo(CheckPageResponseDto responseDto) throws Exception {
		/* 设置用户信息 */
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
		responseDto.setUserCode(userCode);
		responseDto.setUserName(userInfo == null ? "" : userInfo.getUserName());
		responseDto.setComCode(userInfo == null ? "" : userInfo.getComCode());
		if(StringUtils.isNotEmpty(responseDto.getComCode())){
			PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(responseDto.getComCode());
			responseDto.setComName(prpDcompanyDto.getComCName());
		}

	}

	/**
	 * @description:方法功能简述: 通过业务号查询险种编码
	 * @author 安齐崇
	 * @date 2017年11月15日下午9:30:23
	 * @param businessNo
	 *            业务号
	 * @return riskCode 险种编码
	 */
	String getRiskCode(String businessNo) {
		PrpLRegist prpLRegist = prpLRegistDao.findOne(new PrpLRegistKey(businessNo));
		String riskCode = prpLRegist == null ? null : prpLRegist.getRiskCode();
		return riskCode;
	}

	/**
	 * @description:方法功能简述: 完善初始化数据
	 * @author 安齐崇
	 * @date 2017年11月15日下午9:30:23
	 * @param
	 *
	 * @return riskCode 险种编码
	 * @throws Exception
	 */
	public void perfectCommonView(CheckPageResponseDto responseDto, CheckPageRequestDto requestDto) throws Exception {
		/** 承保数量 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("policyNo", responseDto.getPrpLcheckDto().getPolicyNo());
		PrpCmainDto cmainDto = prpCmainApi.queryByPK(map);
		Double statQuantity = cmainDto == null? 0d:cmainDto.getStatQuantity();
		responseDto.setStatQuantity(statQuantity);
		/* 已出险次数 */
		int perilCount = pageInitCommonService.getSamePolicyRegistInfo(responseDto.getPrpLcheckDto().getPolicyNo(),
				responseDto.getPrpLcheckDto().getRegistNo());
		responseDto.setPerilCount(perilCount);
		/* 险种名称 */
		PrpDriskDto prpDriskDto = riskApi.queryriskByPK(responseDto.getRiskCode());
		responseDto.setRiskName(prpDriskDto.getRiskCName());
		/* 设置工作流下一个节点提交的配置信息 */
		SwfPathDtoExt submitNode = checkPageCommonService.getSubmitNodes(requestDto.getModelNo(),
				requestDto.getNodeNo());
		responseDto.setSubmitNode(submitNode);
	}

	/**
	 * @description:方法功能简述: 校验数据的合法性
	 * @author 安齐崇
	 * @date 2017年11月24日下午5:19:13
	 * @param requestDto
	 * @throw Exception
	 */
	private void verifyParam(CheckPageRequestDto requestDto) {
		if (requestDto == null) {
			throw new DataVerifyException("请求参数不能为空!");
		}
		if ("ADD".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getRegistNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型报案号不能为空！");
			}
		} else if ("EDIT".equals(requestDto.getEditType()) || "SHOW".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getCheckNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型查勘号不能为空！");
			}
		} else {
			throw new BusinessException("编辑类型不合法,请选择ADD、EDIT或SHOW编辑类型！");
		}
	}

	/**
	 * @description:方法功能简述:编辑类型为ADD的查勘页面初始化服务方法
	 * @author 安齐崇
	 * @date 2017年11月15日下午9:06:49
	 * @param responseDto
	 *            出参类，封装页面所需数据
	 * @return requestDto 入参类
	 */
	public void addCheckView(CheckPageRequestDto requestDto, CheckPageResponseDto responseDto) {
		LOGGER.error("into AddCheckViewServiceImpl.addCheckView 查勘定损页面初始化ADD,参数组装服务类");
		String flowID = requestDto.getFlowId();
		String logNo = requestDto.getLogNo();
		/* 如果传工作流信息，进行编号是否被占用校验 */
		if (StringUtils.isNotBlank(flowID) && StringUtils.isNotBlank(logNo)) {
			pageInitCommonService.verifyIsHoldNode(flowID, logNo, responseDto.getUserCode(), responseDto.getUserName(),
					responseDto.getRegistNo());
		}
	}

	/**
	 * @description 查勘定损查询入口
	 * @author 闫磊
	 * @date 2017年11月14日
	 * @param prpLCheckQueryInDto
	 *            查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@Override
	public PageInfo<SwfLogExtendDto> queryByCheckInDto(PrpLCheckQueryInDto prpLCheckQueryInDto) throws Exception {
		if (prpLCheckQueryInDto == null) {
			throw new BusinessException("查询对象不允许为空");
		} else {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error(
						"registNo={},policyNo={},insuredName={},riskCode={},nodeStatus={},flowInTimeStart={},operatorCode={}",
						prpLCheckQueryInDto.getRegistNo(), prpLCheckQueryInDto.getPolicyNo(),
						prpLCheckQueryInDto.getInsuredName(), prpLCheckQueryInDto.getRiskCode(),
						prpLCheckQueryInDto.getNodeStatus(), prpLCheckQueryInDto.getFlowInTimeStart(),
						prpLCheckQueryInDto.getHandlerCode());
			}
		}
		Integer pageNo = prpLCheckQueryInDto.getPageNo();
		Integer pageSize = prpLCheckQueryInDto.getPageSize();
		if (pageNo < 1) {
			throw new BusinessException("页码不能小于1");
		}
		if (pageSize < 1) {
			throw new BusinessException("每页数量不能小于1");
		}
		Long totalSizeStrLon = null;
		String conditions = "";
		String conditionsCount = "";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		conditions = getNodeConditionsByNodeNo(prpLCheckQueryInDto, "query", paraMap);
		conditionsCount = getNodeConditionsByNodeNo(prpLCheckQueryInDto, "count", paraMap);
		Query agentQuery = entityManager.createQuery(conditions);
		Query agentQueryCount = entityManager.createQuery(conditionsCount);
		for (String key : paraMap.keySet()) {
			agentQuery.setParameter(key, paraMap.get(key));
			agentQueryCount.setParameter(key, paraMap.get(key));
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
		for (int n = 0; n < swfLogDto.size(); n++) {
			SwfLogExtendDto swfLogExtendDtoNew = new SwfLogExtendDto();
			swfLogExtendDtoNew.setSwfLogDto(swfLogDto.get(n));
			// 根据险种代码转换中文名称
			Map<String, String> riskcodeMap = new HashMap<String, String>();
			riskcodeMap.put("riskCode", swfLogDto.get(n).getRiskCode());
			riskcodeMap.put("isChinese", LanguageFlagConstant.CHINESE);
			String riskName = prpDriskApi.translateCode(riskcodeMap);
			swfLogExtendDtoNew.setRiskName(riskName);
			// 根据报案号查询受损标的名称
			Query lossNameQuery = entityManager.createNativeQuery(
					"select s.lossName from PrpLRegist s where registNo = '" + swfLogDto.get(n).getRegistNo() + "'");
			String lossName = "";
			if (lossNameQuery.getResultList().size() > 0) {
				lossName = (String) lossNameQuery.getSingleResult();
			}
			swfLogExtendDtoNew.setLossName(lossName);
			PrpLRegist prpLRegist=prpLRegistDao.findByRegistNo(swfLogDto.get(n).getRegistNo());
			lossName = prpLRegist.getLossName();
			swfLogExtendDtoNew.setLossName(lossName);
			swfLogExtendDto.add(swfLogExtendDtoNew);
		}
		PageInfo<SwfLogExtendDto> pageInfo = new PageInfo<>();
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
	 * @param prpLCheckQueryInDto
	 *            入参对象
	 * @param flag
	 *            查询参数
	 * @return str 拼接完成的SQL
	 */
	private String getNodeConditionsByNodeNo(PrpLCheckQueryInDto prpLCheckQueryInDto, String flag,
			Map<String, Object> paraMap) throws Exception {
		String policyNo = prpLCheckQueryInDto.getPolicyNo();
		String registNo = prpLCheckQueryInDto.getRegistNo();
		String insuredName = prpLCheckQueryInDto.getInsuredName();
		String flowInTimeStart = prpLCheckQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd="";
		if(prpLCheckQueryInDto.getFlowInTimeEnd()!=""){
			flowInTimeEnd = prpLCheckQueryInDto.getFlowInTimeEnd()+" 23:59:59";
		}else{
			flowInTimeEnd = prpLCheckQueryInDto.getFlowInTimeEnd();
		}

		String riskType = prpLCheckQueryInDto.getRiskType();
		String nodeStatus = prpLCheckQueryInDto.getNodeStatus();
		String nodeType = prpLCheckQueryInDto.getNodeType();
		String handlerCode = prpLCheckQueryInDto.getHandlerCode();
		StringBuilder stringBuilder = null;
		if ("query".equals(flag)) {
			stringBuilder = new StringBuilder("SELECT s FROM SwfLog s WHERE nodeType = 'check' ");
		} else if ("count".equals(flag)) {
            stringBuilder = new StringBuilder("SELECT count(1) FROM SwfLog s WHERE nodeType = 'check' ");
        }
		this.addStringCondition("nodeType", nodeType, "=", stringBuilder, paraMap);
		// 根据案件类型以及当前处理人员拼接查询条件
		if (StringUtils.isNotEmpty(nodeStatus) && StringUtils.isNotEmpty(handlerCode)) {
			if ("2".equals(nodeStatus) || "4".equals(nodeStatus)) {
				this.addStringCondition("handlerCode", handlerCode, "=", stringBuilder, paraMap);
			} else {
				stringBuilder.append(" and (handlerCode='").append(handlerCode)
						.append("' or handlerCode is null or handlerCode='' )");
			}
			if (!"all".equals(nodeStatus)) {
				this.addStringCondition("nodeStatus", nodeStatus, "", stringBuilder, paraMap);
			} else {
				stringBuilder.append(" and (NodeStatus < '5') ");
			}
		} else {
			throw new BusinessException("当前操作人或者案件状态为空，查询失败");
		}
		stringBuilder.append(" and length(keyin)<>25 ");
		if (StringUtils.isNotEmpty(registNo)) {
			stringBuilder.append(" and keyIn like '").append(registNo).append("%'");
		}
		if (StringUtils.isNotEmpty(policyNo)) {
			stringBuilder
					.append(" and registNo in (select registNo from PrpLRegistRPolicy where 1=1  and  policyNo like '")
					.append(policyNo).append("%')");
		}
		this.addStringCondition("insuredName", insuredName, "*", stringBuilder, paraMap);
		if (StringUtils.isNotEmpty(riskType)) {
			stringBuilder.append(" and s.riskCode in ('");
			Map<String, String> riskCodeMap = new HashMap<String, String>();
			LOGGER.error("riskType" + riskType);
			List<String> outerCodeList = new ArrayList<String>();
			if (!"I".equals(riskType) && !"H".equals(riskType)) {
				riskCodeMap.put("riskType", "I");
				List<UtiCodeTransferDto> dtoListI = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if (dtoListI.size() > 0) {
					for (int s = 0; s < dtoListI.size(); s++) {
						outerCodeList.add(dtoListI.get(s).getOuterCode());
					}
				}
				riskCodeMap.replace("riskType", "H");
				List<UtiCodeTransferDto> dtoListH = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if (dtoListH.size() > 0) {
					for (int s = 0; s < dtoListH.size(); s++) {
						outerCodeList.add(dtoListH.get(s).getOuterCode());
					}
				}
			} else {
				riskCodeMap.put("riskType", riskType);
				List<UtiCodeTransferDto> dtoList = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if (dtoList.size() > 0) {
					for (int s = 0; s < dtoList.size(); s++) {
						outerCodeList.add(dtoList.get(s).getOuterCode());
					}
				}
			}
			if (outerCodeList != null && outerCodeList.size() > 0) {
				for (int i = 0; i < outerCodeList.size(); i++) {
					if (i == outerCodeList.size() - 1) {
						stringBuilder.append(outerCodeList.get(i));
					} else {
						stringBuilder.append(outerCodeList.get(i) + "','");
					}
				}
			}
			stringBuilder.append("')");
		} else {
			 throw new BusinessException("险种大类不能为空，查询失败");
		}
		// 业务号为空时拼接工作流开始或者结束时间
		if (StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(registNo)&&StringUtils.isNotEmpty(flowInTimeStart)&&StringUtils.isNotEmpty(flowInTimeEnd)) {
			stringBuilder.append(" and flowInTime>=").append("'"+flowInTimeStart+"'").append(" and flowInTime<=")
					.append("'"+flowInTimeEnd+"'");

//			stringBuilder.append(" and flowInTime between '").append(flowInTimeStart).append("' and '")
//					.append(flowInTimeEnd).append("' ");
		}
		// 工作流状态不能是关闭
		stringBuilder.append(" and flowStatus!='0' ");
		// 未并案的案件
		stringBuilder.append(" and registNo not in (select c.registNo from PrpLCombine c) ");
		// 新老系统数据区别标志
//		stringBuilder.append(" and dataFlag is null ");
        stringBuilder.append(" and medicalTransitFlag is null ");
        if ("query".equals(flag)) {
            stringBuilder.append(" and s.systemFlag = 'agri' order by handleTime desc");
        } else if ("count".equals(flag)) {
            stringBuilder.append(" and s.systemFlag = 'agri' ");
        }

		if (LOGGER.isDebugEnabled()) {
			LOGGER.error(stringBuilder.toString());
		}
		return stringBuilder.toString();
	}

	/**
	 * @description sql参数(String)转换
	 * @author 闫磊
	 * @throws Exception
	 * @date 2017年10月20日 17:30:27
	 */
	private void addStringCondition(String name, String value, String sign, StringBuilder strWhere,
			Map<String, Object> paraMap) throws Exception {
		if (value != null && !"".equals(value.trim())) {
			if (StringUtils.isNotEmpty(value)) {
				if ("*".equals(sign)) {
					strWhere.append(" and " + name + " like :" + name);
					paraMap.put(name, value + "%");
				} else {
					strWhere.append(" and " + name + " = :" + name);
					paraMap.put(name, value);
				}
			}
		}
	}

//	//---------------查勘定损提交-------------------------
	
	/**
	 * 保存查勘定损信息
	 * @author 杨昆
	 * @date 2017年12月8日 下午5:31:49
	 * @param checkLossDto 查勘定损大对象
	 * @return map 只包含报案号
	 * @throws Exception 
	 */
	@Override
	public  Map<String, String> saveCheckLoss(CheckLossDto checkLossDto) throws Exception {
		// 检验前端数据是否传全了
		if (checkLossDto.getPrpLcheckDto() == null || checkLossDto.getPrpLclaimStatusDto() == null) {
			throw new DataVerifyException("前端传送数据不全！！");
		}

		String checkNo = "";
		PrpLCheckDto prpLcheckDto = checkLossDto.getPrpLcheckDto();
		checkNo = prpLcheckDto.getRegistNo();
		List<PrpLClaim> claimList = prpLClaimDao.findByRegistNo(prpLcheckDto.getRegistNo());
		PrpLClaimDto prpLclaimDto = null;
		boolean claimFlag = false;
		if (claimList.size() != 0) {
			claimList.get(0);
			prpLclaimDto = convert(claimList.get(0), PrpLClaimDto.class);
			claimFlag = true;
		}
		// 组装和修改查勘定损大对象checkLossDto
		checkLossDto = getCheckLossDto(checkLossDto);
		checkLossDto.getPrpLcheckDto().setHandleUnitCode(SinoRequestContext.getCurrentContext().getUser().getLoginComCode());
		PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(SinoRequestContext.getCurrentContext().getUser().getLoginComCode());
		checkLossDto.getPrpLcheckDto().setHandleUnit(prpDcompanyDto.getComCName());
		saveCheckLossDto(checkLossDto);
		// 准备获取工作流大对象
		SwfLogTransferDto swfLogTransferCheckDto = new SwfLogTransferDto();
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
		String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
		if(StringUtils.isEmpty(userComCode)){
			PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
			userComCode = userInfo.getComCode();
		}
		String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
		swfLogTransferCheckDto.setUserUserCode(userCode);
		swfLogTransferCheckDto.setUserComCode(userComCode);
		swfLogTransferCheckDto.setUserUserName(userName);
		PrpDcompanyDto querPrpDcompanyDto = prpDcompanyApi.queryByPK(userComCode);
		swfLogTransferCheckDto.setUserComName(querPrpDcompanyDto.getComCName());
		String swfLogFlowID = checkLossDto.getFlowId();
		if (!checkIfAlready(swfLogFlowID)) {
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String swfLogLogNo = checkLossDto.getLogNo();
			if (swfLogFlowID != null && swfLogLogNo != null) {
				swfLogDtoDealNode.setFlowId(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
			} else {
				swfLogDtoDealNode.setNodeType("check");
				swfLogDtoDealNode.setBusinessNo(checkLossDto.getPrpLcheckDto().getRegistNo());
			}
			swfLogDtoDealNode.setNodeStatus(checkLossDto.getPrpLclaimStatusDto().getStatus());
			swfLogTransferCheckDto.setNextBusinessNo(checkLossDto.getPrpLcheckDto().getRegistNo());
			WorkFlowDto workFlowDtoCheck = null;
			swfLogDtoDealNode.setKeyOut(checkNo);
			swfLogDtoDealNode.setTypeFlag("1");
			swfLogDtoDealNode.setKeyIn(checkLossDto.getPrpLcheckDto().getRegistNo());
			swfLogTransferCheckDto.setSwfLogDto(swfLogDtoDealNode);
			try {
				// 获取查勘工作流对象
				// workFlowDtoCheck =
				// workFlowViewHelper.getWorkFlowDto(swfLogDtoDealNode);
				workFlowDtoCheck = workFlowService.viewToDto(swfLogTransferCheckDto);

			} catch (Exception e) {
				throw new BusinessException("获取查勘工作流对象失败！！");
			}
			String riskType = "";
			Map<String, String> riskMap = new HashMap<>();
			riskMap.put("outerCode", prpLcheckDto.getRiskCode());
			List<UtiCodeTransferDto> utiCodeTransferDtoList = utiCodeTransferApi
					.queryUtiCodeTransferDtoByOuterCode(riskMap);
			// List<UtiCodeTransferDto> utiCodeTransferDtoList =
			// imsApi.queryUtiCodeTransferDtoByOuterCode(prpLcheckDto.getRiskCode());
			if (utiCodeTransferDtoList != null && utiCodeTransferDtoList.size() != 0) {
				UtiCodeTransferDto UtiCodeTransferDto = utiCodeTransferDtoList.get(0);
				riskType = UtiCodeTransferDto.getRiskType();
			}

			if ((workFlowDtoCheck.isCreate()) || (workFlowDtoCheck.isUpdate()) || (workFlowDtoCheck.isSubmit())
					|| (workFlowDtoCheck.isClose())) {
				// 保存查勘定损信息
				if (workFlowDtoCheck != null) {
					try {
						workFlowService.deal(workFlowDtoCheck);
					} catch (Exception e) {
						throw new BusinessException("保存查勘工作流失败！！");
					}
				}
			//  流程查询服务调用(保存流程查询节点)
				if("2".equals(checkLossDto.getPrpLclaimStatusDto().getStatus())){
					workProcessService.saveWorkProcess(prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(), null, null, prpLcheckDto.getRiskCode().substring(0,2), prpLcheckDto.getRiskCode(), "check","check", AgriclaimWorkProcessEnum.未立案, SinoRequestContext.getCurrentContext().getUserCode());
					}
					if("4".equals(checkLossDto.getPrpLclaimStatusDto().getStatus())){
						workProcessService.saveWorkProcess(prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(), null, null, prpLcheckDto.getRiskCode().substring(0,2), prpLcheckDto.getRiskCode(), "check","claim", AgriclaimWorkProcessEnum.未立案, SinoRequestContext.getCurrentContext().getUserCode());
					}
				
				
			} else {
				throw new BusinessException("注意:没有发现与查勘工作流流程相关任何数据！！");
			}
			// 进行与工作流有关的操作
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			// 判断是否是直接从0待处理到提交，如果是则先进行业务保存操作 则从0->3
			// ,从3->4这样的状态变更,由于后来变成人到人的方式，所以去掉以下的代码
//			WorkFlowDto workFlowDtoLoss = new WorkFlowDto();
//			// 定损的工作流设置，比较特殊
//			SwfLogTransferDto swfLogTransferLossDto = new SwfLogTransferDto();
//			SwfLogDto swfLogDtoDealNodeLoss = new SwfLogDto();
//			swfLogLogNo = "4";
//			if (!"null".equals(swfLogFlowID) && !"null".equals(swfLogLogNo)) {
//				swfLogDtoDealNodeLoss.setFlowId(swfLogFlowID);
//				swfLogDtoDealNodeLoss.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
//			}
//			swfLogDtoDealNodeLoss.setBusinessNo(prpLcheckDto.getRegistNo());
//			swfLogTransferLossDto.setNextBusinessNo(prpLcheckDto.getRegistNo());
//			swfLogDtoDealNodeLoss.setNodeStatus(checkLossDto.getPrpLclaimStatusDto().getStatus());
//			swfLogDtoDealNodeLoss.setKeyIn(prpLcheckDto.getRegistNo());
//			swfLogDtoDealNodeLoss.setKeyOut(prpLcheckDto.getRegistNo());
//			swfLogTransferLossDto.setConditionBusinessNo(prpLcheckDto.getRegistNo());
//			swfLogDtoDealNodeLoss.setLossitemCode(checkLossDto.getPrpLverifyLossDto().getLossItemCode());
//			swfLogDtoDealNodeLoss.setRiskCode(prpLcheckDto.getRiskCode());
//
//			// 判断如果是理算退回的定损，并且该定损没有新增加数据，那么可以直接提交回理算的。
//			// 相应的问题，如果理算处，以上信息都没完成，是不可以进行出理算书的。
//			swfLogTransferCheckDto.setSwfLogDto(swfLogDtoDealNodeLoss);
//			workFlowDtoLoss = workFlowService.viewToDto(swfLogTransferCheckDto);
//			// workFlowDtoLoss =
//			// workFlowViewHelper.getWorkFlowDto(swfLogDtoDealNodeLoss);
//			if ((workFlowDtoLoss.isCreate()) || (workFlowDtoLoss.isUpdate()) || (workFlowDtoLoss.isSubmit())
//					|| (workFlowDtoLoss.isClose())) {
//				// 推动定损工作流
//				try {
//					workFlowService.deal(workFlowDtoLoss);
//				} catch (Exception e) {
//					throw new BusinessException("保存定损工作流失败！！");
//				}
//			} else {
//				throw new BusinessException("注意:没有发现与定损工作流流程相关任何数据！！");
//			}
		}
		Map<String, String> map = new HashMap<>();
		map.put("registNo", checkNo);
		return map;
	}

	/**
	 * 检查是否已生成立案工作流
	 * @author 杨昆
	 * @date 2017年12月8日 下午3:35:47
	 * @param
	 * @return true 已经生成 
	 */
	private boolean checkIfAlready(String swfLogFlowID) {
		List<SwfLog> swfLogList = swfLogDao.findAllByFlowIDAndLogNo(swfLogFlowID, 5);
		if(swfLogList != null && swfLogList.size() > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存查勘定损信息到数据库
	 * @author 杨昆
	 * @date 2017年12月8日 下午5:59:47
	 * @param checkLossDto 查勘定损大对象
	 */
	private void saveCheckLossDto(CheckLossDto checkLossDto) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("保存查勘定损信息到数据库!!");
		}
		String checkNo = "";
		checkNo = checkLossDto.getPrpLcheckDto().getRegistNo();

		// 首先删除原来的相关数据
		prpLRegistTextDao.deleteByRegistNoAndTextType(StringUtils.rightTrim(checkNo), "3", "07","1");
		prpLCheckDao.deleteByRegistNo(StringUtils.rightTrim(checkNo));
		PrpLCheck prpLCheck = convert(checkLossDto.getPrpLcheckDto(), PrpLCheck.class);
		if (StringUtils.isEmpty(prpLCheck.getCheckType())){
			prpLCheck.setCheckType(" ");
		}
		if (prpLCheck.getReferSerialNo()==null){
			prpLCheck.setReferSerialNo(0);
		}
		prpLCheckDao.save(prpLCheck);
		List<PrpLRegistTextDto> prpLregistTextDtoList = checkLossDto.getPrpLregistTextDtoList();
		List<PrpLRegistText> PrpLRegistTextList = new ArrayList<>(prpLregistTextDtoList.size());
		convertCollection(prpLregistTextDtoList, PrpLRegistTextList, PrpLRegistText.class);
		if(PrpLRegistTextList!=null && PrpLRegistTextList.size()>0) {
			prpLRegistTextDao.save(PrpLRegistTextList);
		}

		prpLclaimStatusDao.deleteByBusinessnoAndNodetype(
				StringUtils.rightTrim(checkLossDto.getPrpLclaimStatusDto().getBusinessno()), "check");
		PrpLclaimStatusDto prpLclaimStatusDto = checkLossDto.getPrpLclaimStatusDto();
		prpLclaimStatusDto.setNodetype("check");
		prpLclaimStatusDto.setSerialno(0);
		PrpLclaimStatus prpLclaimStatusCheck = convert(prpLclaimStatusDto, PrpLclaimStatus.class);
		prpLclaimStatusDao.save(prpLclaimStatusCheck);
		prpLclaimStatusDao.deleteByBusinessnoAndNodetypeAndSerialno(
				StringUtils.rightTrim(checkLossDto.getPrpLclaimStatusDto().getBusinessno()), "certa", -2);
		prpLclaimStatusDto.setNodetype("certa");
		prpLclaimStatusDto.setSerialno(-2);
		PrpLclaimStatus prpLclaimStatusCerta = convert(prpLclaimStatusDto, PrpLclaimStatus.class);
		prpLclaimStatusDao.save(prpLclaimStatusCerta);

		PrpLverifyLoss prpLverifyLoss = convert(checkLossDto.getPrpLverifyLossDto(), PrpLverifyLoss.class);
		if (StringUtils.isEmpty(prpLverifyLoss.getLossItemCode())){
			prpLverifyLoss.setLossItemCode(" ");
		}
		prpLverifyLossDao.save(prpLverifyLoss);

		List<PrpLPropDto> prpLpropDtoList = checkLossDto.getPrpLpropDtoList();
		if (prpLpropDtoList != null) {
			List<PrpLProp> prpLPropList = new ArrayList<>(prpLpropDtoList.size());
			convertCollection(prpLpropDtoList, prpLPropList, PrpLProp.class);
			prpLPropDao.save(prpLPropList);
		}
		
		List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList = checkLossDto.getPrpLCompensateEarDtoList();
		List<PrpLCompensateEar> prpLCompensateEarList = new ArrayList<>();
		convertCollection(prpLCompensateEarDtoList, prpLCompensateEarList, PrpLCompensateEar.class);
		prpLCompensateEarDao.save(prpLCompensateEarList);
	}

	/**
	 * 查勘定损大对象进行修改和组装
	 * @author 杨昆
	 * @date 2017年12月8日 下午6:03:09
	 * @param checkLossDto 查勘定损大对象
	 * @return checkLossDto查勘定损大对象
	 */
	private CheckLossDto getCheckLossDto(CheckLossDto checkLossDto) {
		Map<String, String> props = new HashMap<>();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("组装查勘定损大对象!!");
		}
		PrpLCheckDto prpLcheckDto = checkLossDto.getPrpLcheckDto();
		prpLcheckDto.setCheckDate(new DateTime(prpLcheckDto.getCheckDate()));
		prpLcheckDto.setRepeatInsureFlag("-");
		String TextTemp = checkLossDto.getContext();
		// rule字段的长度
		int RULE_LENGTH = 70;
		String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
		ArrayList<PrpLRegistTextDto> prpLregistTextDtoList = new ArrayList<>();
		for (int k = 0; k < rules.length; k++) {
			PrpLRegistTextDto prpLregistTextDto = new PrpLRegistTextDto();
			prpLregistTextDto.setRegistNo(prpLcheckDto.getRegistNo());
			prpLregistTextDto.setContext(rules[k]);
			prpLregistTextDto.setLineNo(k + 1);
			prpLregistTextDto.setTextType("3");
			prpLregistTextDtoList.add(prpLregistTextDto);
		}
		// 装入checkDto
		checkLossDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
		/*---------------------状态内容prpLclaimStatus------------------------------------*/
		PrpLclaimStatusDto prpLclaimStatusDto = checkLossDto.getPrpLclaimStatusDto();
		// prpLclaimStatusDto.setStatus(prpLcheckDto.getButtonSaveType());
		prpLclaimStatusDto.setBusinessno(prpLcheckDto.getRegistNo());
		prpLclaimStatusDto.setPolicyno(prpLcheckDto.getPolicyNo());
		prpLclaimStatusDto.setNodetype("check");
		prpLclaimStatusDto.setSerialno(0);
		// prpLclaimStatusDto.setTypeflag(checkLossDto.getPrpLverifyLossDto().getLossItemCode());
		prpLclaimStatusDto.setRiskcode(prpLcheckDto.getRiskCode());
		// 取得当前用户信息，写操作员信息到查勘中
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
		prpLclaimStatusDto.setHandlercode(userCode);
		// prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
		prpLclaimStatusDto.setInputdate(prpLcheckDto.getCheckDate());
		prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		checkLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

		/*---------------------核损主表 PrpLverifyLoss------------------------------------*/
		PrpLverifyLossDto prpLverifyLossDto = checkLossDto.getPrpLverifyLossDto();
		prpLverifyLossDto.setUnderWriteCode(userCode);
		prpLverifyLossDto.setUnderWriteName(SinoRequestContext.getCurrentContext().getUser().getUserName());
		prpLverifyLossDto.setPolicyNo(prpLcheckDto.getPolicyNo());
		prpLverifyLossDto.setRegistNo(prpLcheckDto.getRegistNo());
		prpLverifyLossDto.setRiskCode(prpLcheckDto.getRiskCode());
		prpLverifyLossDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		String buttonSaveType = prpLclaimStatusDto.getStatus();
		if ("3".equals(buttonSaveType) || "4".endsWith(buttonSaveType)) {
			prpLverifyLossDto.setUnderWriteFlag("1");
		} else {
			prpLverifyLossDto.setUnderWriteFlag("0");
		}
		checkLossDto.setPrpLverifyLossDto(prpLverifyLossDto);

		// 先取立案号码，很重要，不要从页面上取得。。。
		String claimNo = prpLcheckDto.getClaimNo();
		String registNo = prpLcheckDto.getRegistNo();
		if (claimNo == null || claimNo.length() < 2) {
			claimNo = prpLClaimDao.findClaimNoByRegistNo(registNo);
		}
		List<PrpLPropDto> prpLpropDtoList = checkLossDto.getPrpLpropDtoList();
		if (prpLpropDtoList!= null && prpLpropDtoList.size()>0) {
			for (int i = 0; i < prpLpropDtoList.size(); i++) {
				PrpLPropDto prpLpropDto = prpLpropDtoList.get(i);
				prpLpropDto.setPolicyNo(prpLcheckDto.getPolicyNo());
				prpLpropDto.setRiskCode(prpLcheckDto.getRiskCode());
				prpLpropDto.setRegistNo(prpLcheckDto.getRegistNo());
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setSerialNo(i + 1);
				prpLpropDto.setLossItemCode("-2");
				prpLpropDto.setFeeTypeCode("");
				prpLpropDto.setFeeTypeName("");
				prpLpropDto.setBuyDate(new DateTime(new Date(), DateTime.YEAR_TO_DAY));

				PrpLRegist prpLRegist = prpLRegistDao.findByRegistNo(registNo);
				PrpLRegistDto prpLRegistDto = convert(prpLRegist, PrpLRegistDto.class);
				if (!"".equals(prpLRegistDto.getPolicyNo())) {
					// 增加是否是团单的判断，如果是团单则从页面收取itemkindno
					String strRiskCode = prpLRegistDto.getRiskCode();
					// 是否是团单的标志
					if (props.containsKey("CREATE_VIRTUALITEM_RISK")) {
						strRiskCode = ((String) props.get("CREATE_VIRTUALITEM_RISK"));
					} else {
						UtiPlatConfigDto utiPlatConfigDto = utiPlatConfigApi.queryByPK("prpall", "CREATE_VIRTUALITEM_RISK");
						Map<String, String> map = new HashMap<>();
						map.put("systemCode", "prpall");
						map.put("paramcode", "CREATE_VIRTUALITEM_RISK");
						List<UtiPlatConfigRuleDto> utiPlatConfigRuleDtoList = utiPlatConfigRuleApi.queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(map);
						String rule = "";
						for (UtiPlatConfigRuleDto x : utiPlatConfigRuleDtoList) {
							rule += x.getRule();
						}
						if (utiPlatConfigDto != null) {
							strRiskCode = rule;
							props.put("CREATE_VIRTUALITEM_RISK", rule);
						}
					}
					Map<String, String> map = new HashMap<>();
					map.put("policyNo", prpLRegistDto.getPolicyNo());
					List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryItemCodeByPolicyNo(prpLRegistDto.getPolicyNo());
					boolean isVirturlItemRisk = ((String) props.get("CREATE_VIRTUALITEM_RISK")).indexOf(strRiskCode) > -1;
					if (!isVirturlItemRisk) {
						for (int k = 0; k < prpCitemKindDtoList.size(); k++) {
							PrpCitemKindDto prpCitemKindDto = prpCitemKindDtoList.get(k);
							if (prpCitemKindDto.getKindCode().equals(prpLpropDto.getKindCode())) {
								prpLpropDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
								break;
							}
						}
					}
				}
			}
		}
		List<PrpLCompensateEarRegistDto> prplCompensateEarDtoList = checkLossDto.getPrpLCompensateEarDtoList();
		for (int index = 0; prplCompensateEarDtoList!=null && prplCompensateEarDtoList.size() > 0&& index < prplCompensateEarDtoList.size(); index++) {
			PrpLCompensateEarRegistDto prplCompensateEarDto = prplCompensateEarDtoList.get(index);
			prplCompensateEarDto.setDamageName(prpLcheckDto.getDamageName());
			prplCompensateEarDto.setDamageCode(prpLcheckDto.getDamageCode());
			prplCompensateEarDto.setBusinessNo(prpLcheckDto.getRegistNo());
			prplCompensateEarDto.setNodeNo(2);
			prplCompensateEarDto.setFCode(prplCompensateEarDto.getCode());
			prplCompensateEarDto.setNodeType("check");
			prplCompensateEarDto.setPolicyNo(prpLcheckDto.getPolicyNo());
			prplCompensateEarDto.setRegistNo(prpLcheckDto.getRegistNo());
			prplCompensateEarDto.setDamageStartDate(new DateTime(prplCompensateEarDto.getDamageStartDate(),DateTime.YEAR_TO_DAY));
		}
		return checkLossDto;
	}
	/**
	 * @description 耳标号验证
	 * @author 马俊玲
	 * @date 2017年11月20日 下午3:14:03
	 * @param earNoCheckRequestDto
	 * #return EearNoCheckResponseDto
	 * @throws Exception
	 */
	@Override
	public EarNoCheckResponseDto earNoCheck(EarNoCheckRequestDto earNoCheckRequestDto) throws Exception {
		String msg="";
		EarNoCheckResponseDto earNoCheckResponseDto=new EarNoCheckResponseDto();
		if(null==earNoCheckRequestDto){
			msg="无效的入参";
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("耳标号验证>>>>>>>>>>>>>>>>>>>>>>>{}",msg);
			}
			return null;
		}
		String prpLpropPolicyNo = earNoCheckRequestDto.getPolicyNo();
		String prpLCompensateEarno = earNoCheckRequestDto.getEarNo();
		String kindCode = earNoCheckRequestDto.getKindCode();
		String strDamageDate = earNoCheckRequestDto.getDamageStartDate();
		String strDamageHour = earNoCheckRequestDto.getDamageStartHour();
		if (StringUtils.isEmpty(prpLpropPolicyNo ) || StringUtils.isEmpty(prpLCompensateEarno )|| StringUtils.isEmpty(kindCode)|| StringUtils.isEmpty(strDamageDate )|| StringUtils.isEmpty(strDamageHour)){
			msg="参数不得为空";
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("耳标号验证>>>>>>>>>>>>>>>>>>>>>>>{}",msg);
			}
			throw new BusinessException( "耳标号验证>>>>>>>>>>>>>>>>>>>>>>>{}", msg);
		}
		//新系统取消prpLCompensateEar验证
//        List<Object[]> list=prpLCompensateEarDao.queryByPolicyNoAndEarNoWithSwfLog(prpLpropPolicyNo, prpLCompensateEarno);
//        if(null==list||list.size()==0){
//            msg="没有查到数据";
//            if(LOGGER.isErrorEnabled()){
//                LOGGER.error("耳标号验证>>>>>>>>>>>>>>>>>>>>>>>{}",msg);
//            }
//            throw new DataVerifyException( "耳标号验证>>>>>>>>>>>>>>>>>>>>>>>{}", msg);
//        }
		com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckResponseDto herdpolicylist =null;
		com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckDto earNoCheckDto=new com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckDto();
		earNoCheckDto.setEarNo(prpLCompensateEarno);
		earNoCheckDto.setKindCode(kindCode);
		earNoCheckDto.setDamageStartDate(strDamageDate);
		earNoCheckDto.setDamageStartHour(strDamageHour);
		earNoCheckDto.setPolicyNo(prpLpropPolicyNo);
		herdpolicylist=queryPoilcyListApi.queryEndorseHerdpolicylist(earNoCheckDto);
		if (herdpolicylist == null || herdpolicylist.getInsureMainListDtoList()==null||herdpolicylist.getHerdPolicyListDtoList()==null||herdpolicylist.getHerdEndorsePolicyListDtoList()==null) {
			msg="保单号为:" + prpLpropPolicyNo + "耳标号"+"【"+earNoCheckDto.getEarNo()+"】"+"验证失败，请确认！";
			throw new BusinessException(msg);
		}
		List<InsureMainListDto> insuremainlistDtoList =  herdpolicylist.getInsureMainListDtoList();
		List<HerdPolicyListDto> herdpolicylistDtoList =  herdpolicylist.getHerdPolicyListDtoList();
		List<HerdPolicyListDto> herdEndorsepolicylistDtoList =  herdpolicylist.getHerdEndorsePolicyListDtoList();
		if (insuremainlistDtoList != null && insuremainlistDtoList.size() == 1) {
			earNoCheckResponseDto.setInusrelistcode(insuremainlistDtoList.get(0).getInusreListCode());
			earNoCheckResponseDto.setInsureMainListDto(insuremainlistDtoList.get(0));
		}
		if(herdpolicylistDtoList != null && herdpolicylistDtoList.size() == 1){
			HerdPolicyListDto herdPolicyListDto = (HerdPolicyListDto) herdpolicylistDtoList.get(0);
			if(herdPolicyListDto != null && "1".equals(herdPolicyListDto.getValidity()) && herdPolicyListDto.getSumAmount() > 0 ){
				if(herdEndorsepolicylistDtoList != null && herdEndorsepolicylistDtoList.size() == 1){
					HerdPolicyListDto herdEndorsePolicyListDto = (HerdPolicyListDto) herdEndorsepolicylistDtoList.get(0);
					if(herdEndorsePolicyListDto != null && "1".equals(herdEndorsePolicyListDto.getValidity())){
						earNoCheckResponseDto.setHerdPolicyListDto(herdEndorsePolicyListDto);
					}
				}
			}
		}
		return earNoCheckResponseDto;
	}
}