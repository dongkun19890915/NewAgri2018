package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.*;
import com.sinosoft.agriclaim.api.registmanage.dto.RequestQueryPolicyListInfoDto;
import com.sinosoft.agriclaim.api.registmanage.dto.ResponseQueryPolicyListInfoDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.registmanage.dao.*;
import com.sinosoft.agriclaim.core.registmanage.entity.*;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.registmanage.service.RegistService;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleItemDao;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItem;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.endorsemanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCaddressApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCinsuredApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDriskConfigApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.QueryPoilcyListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.RequestQueryPolicyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description 报案服务接口实现
 * @author 杨航
 * @date 2017年11月20日
 */
@Lazy
@Service
public class RegistServiceImpl extends BaseServiceImpl implements RegistService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistServiceImpl.class);
	@Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
	@Autowired
	private PrpLRegistDao prpLRegistDao;
	@Autowired
	private QueryPoilcyListApi queryPoilcyListApi;
	@Autowired
	private PrpLRegistDao prplRegistDao;
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private PrpDriskApi riskApi;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private PrpCitemKindApi prpCitemKindApi;
	@Autowired
	private PrpCaddressApi prpCaddressApi;
	@Autowired
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PrpDriskConfigApi prpDriskConfigApi;
	@Autowired
	private SwfPathDao swfPathDao;
	@Autowired
	private PrpLClaimDao prpLClaimDao;
	@Autowired
	private PrpLCompensateEarDao prpLCompensateEarDao;
	@Autowired
	private PrpLRegistRPolicyDao prpLRegistRPolicyDao;
	@Autowired
	private PrpLclaimStatusDao prpLclaimStatusDao;
	@Autowired
	private PrpLRegistExtDao prpLRegistExtDao;
	@Autowired
	private PrpLRelatePersonDao prpLRelatePersonDao;
	@Autowired
	private PrpLScheduleMainWfDao prpLScheduleMainWfDao;
	@Autowired
	private PrpLScheduleItemDao prpLScheduleItemDao;
	@Autowired
	private PrpLAccIPersonDao prpLAccIPersonDao;
	@Autowired
	private PrpLCompensateDao prpLCompensateDao;
	@Autowired
	private PrpLClaimDao prplClaimDao;
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private InsureMainListApi insureMainListApi;
	@Autowired
	private PrpDuserApi prpDuserApi;
	@Autowired
	private PrpDcodeApi prpDcodeApi;
	@Autowired
	private BillNoApi billNoApi;
	@Autowired
	private PrpDcompanyApi prpDcompanyApi;
	@Autowired
	private PrpLRegistRPolicyDao prpRegistRPolicyDao;
	@Autowired
	private PrpLRegistTextDao prplregisttextDao;
    @Autowired
	private PrpLScheduleMainWfDao prplScheduleMainWfDao; 
    @Autowired
	private PrpLScheduleItemDao prplScheduleItemDao;
    @Autowired
    private PrpLclaimStatusDao claimStatusDao;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
	private PrpLClaimDao prpLclaimDao;
    @Autowired
	private PrpCinsuredApi prpCinsuredApi;
	@Autowired
	private PrpDitemAgriApi prpDitemAgriApi;
	// 格式化日期
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private WorkProcessService workProcessService;
	@Autowired
	private UtiGroupApi utiGroupApi;

	
	
	/**
	 * @description 根据条件查询报案主表的信息
	 * @author 杨航
	 * @date 2017年11月20日 下午3:14:03
	 * @param prpLRegistDto
	 *            报案信息
	 * @return prpLRegistDtoList 报案信息集合
	 */
	@Override
	public List<PrpLRegistDto> queryPrpLRegistByCondition(PrpLRegistDto prpLRegistDto) {
		if (prpLRegistDto == null) {
			throw new DataVerifyException("查询报案信息主表入参不许为空!");
		} else if (StringUtils.isEmpty(prpLRegistDto.getPolicyNo())
				&& StringUtils.isEmpty(prpLRegistDto.getRegistNo())) {
			throw new DataVerifyException("查询报案信息主表保单号和报案号不允许同时为空!");
		}
		List<PrpLRegist> prpLRegistList = prpLRegistDao.findAll(Specifications.<PrpLRegist>and()
				.eq(StringUtils.isNotEmpty(prpLRegistDto.getPolicyNo()), "policyNo", prpLRegistDto.getPolicyNo())
				.eq(StringUtils.isNotEmpty(prpLRegistDto.getRegistNo()), "registNo", prpLRegistDto.getRegistNo())
				.build());
		List<PrpLRegistDto> prpLRegistDtoList = new ArrayList<PrpLRegistDto>();
		this.convertCollection(prpLRegistList, prpLRegistDtoList, PrpLRegistDto.class);
		return prpLRegistDtoList;
	}

	/**
	 * @description 报案登记根据查询入参分页查询保单列表信息
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param requestDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListInfo(RequestQueryPolicyListInfoDto requestDto)
			throws Exception {
		// 请求参数不为空校验，以及页码校验
		if (requestDto == null) {
			throw new DataVerifyException("请求参数不能为空！");
		}
		if (requestDto.getPageNo() < 1) {
			throw new DataVerifyException("查询页码不能小于1！");
		}
		if (requestDto.getPageSize() < 1) {
			throw new DataVerifyException("查询每页数量不能小于1！");
		}
		if (StringUtils.isEmpty(requestDto.getRiskType())) {
			throw new DataVerifyException("险种大类不能传空！");
		}
		List<String> riskList = new ArrayList<>();
		List<String> policyNoList = null;
		// 根据农户信息或耳标号查询出保单号列表
		if (StringUtils.isNotEmpty(requestDto.getEarLabel()) || StringUtils.isNotEmpty(requestDto.getfName())) {
			policyNoList = this.getPolicyNoList(requestDto);
		}
//		// 根据身份证号查询出保单列表
//		List<PrpCmainDto> prpCmainDtoList=new ArrayList<>();
//		if (StringUtils.isNotEmpty(requestDto.getIdentifyNumber())){
//			Map<String,String> map=new HashMap<>();
//			map.put("identifyNumber",requestDto.getIdentifyNumber());
//			prpCmainDtoList=prpCinsuredApi.queryPolicyById(map);
//		}
		// 根据险种类型查询险种列表
		if ("all".equals(requestDto.getRiskType())) {
			List<UtiCodeTransferDto> utiCodeList = new ArrayList<>();
			Map<String, String> hMap = new HashMap<String, String>();
			hMap.put("riskType", "H");
			List<UtiCodeTransferDto> utiCodeHList = utiCodeTransferApi.queryByRiskType(hMap);
			Map<String, String> iMap = new HashMap<String, String>();
			iMap.put("riskType", "I");
			List<UtiCodeTransferDto> utiCodeIList = utiCodeTransferApi.queryByRiskType(iMap);
			if (utiCodeHList != null && utiCodeHList.size() > 0) {
				utiCodeList.addAll(utiCodeHList);
			} 
			if (utiCodeIList != null && utiCodeIList.size() > 0) {
				utiCodeList.addAll(utiCodeIList);
			} 
			if (utiCodeList.size() > 0) {
				for (int i = 0; i < utiCodeList.size(); i++) {
					UtiCodeTransferDto utiCodeTransferDto = utiCodeList.get(i);
					riskList.add(utiCodeTransferDto.getOuterCode());
				}
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("riskType", requestDto.getRiskType());
			List<UtiCodeTransferDto> utiCodeList = utiCodeTransferApi.queryByRiskType(map);
			if (utiCodeList.size() > 0) {
				for (int i = 0; i < utiCodeList.size(); i++) {
					UtiCodeTransferDto utiCodeTransferDto = utiCodeList.get(i);
					riskList.add(utiCodeTransferDto.getOuterCode());
				}
			}
		}
		// 获取保单分页查询结果集
		PageInfo<PrpCmainDto> prpCmainPageInfo = this.getPrpCmainPageInfo(requestDto, riskList, policyNoList);
		// 组织反参信息
		PageInfo<ResponseQueryPolicyListInfoDto> pageInfo = this.setPageInfo(prpCmainPageInfo);
		return pageInfo;
	}

	/**
	 * @description 组织反参信息
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param prpCmainPageInfo
	 * @return
	 * @return Exception
	 */
	private PageInfo<ResponseQueryPolicyListInfoDto> setPageInfo(PageInfo<PrpCmainDto> prpCmainPageInfo)
			throws Exception {
		List<PrpCmainDto> prpCmainDtolist = prpCmainPageInfo.getContent();
		List<ResponseQueryPolicyListInfoDto> responseList = new ArrayList<>();
		for (int i = 0; i < prpCmainDtolist.size(); i++) {
			PrpCmainDto prpCmainDto = prpCmainDtolist.get(i);
			ResponseQueryPolicyListInfoDto responseDto = new ResponseQueryPolicyListInfoDto();
			responseDto.setPolicyNo(prpCmainDto.getPolicyNo());
			responseDto.setStartDate(DateUtils.dateToStr(prpCmainDto.getStartDate()));
			responseDto.setEndDate(DateUtils.dateToStr(prpCmainDto.getEndDate()));
			responseDto.setInsuredName(prpCmainDto.getInsuredName());
			responseDto.setRiskCode(prpCmainDto.getRiskCode());
			Map<String, String> map = new HashMap<String, String>();
			map.put("riskCode", prpCmainDto.getRiskCode());
			map.put("isChinese", "zh-CN");
			responseDto.setRiskName(prpDriskApi.translateCode(map));
			responseList.add(responseDto);
		}
		PageInfo<ResponseQueryPolicyListInfoDto> pageInfo = new PageInfo<>();
		pageInfo.setContent(responseList);
		pageInfo.setPages(prpCmainPageInfo.getPages());
		pageInfo.setTotalCount(prpCmainPageInfo.getTotalCount());
		return pageInfo;
	}

	/**
	 * @description 获取保单分页查询结果集
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param requestDto
	 * @param riskList
	 * @param policyNoList
	 * @return
	 * @throws Exception
	 */
	private PageInfo<PrpCmainDto> getPrpCmainPageInfo(RequestQueryPolicyListInfoDto requestDto, List<String> riskList,
			List<String> policyNoList) throws Exception {
		PrpCmainDto prpCmainDto = new PrpCmainDto();
		PrpCmainRequestDto prpCmainRequestDto = new PrpCmainRequestDto();
		prpCmainDto.setInsuredName(requestDto.getInsuredName());
		prpCmainDto.setInsuredCode(requestDto.getInsuredName());
		prpCmainDto.setPolicyNo(requestDto.getPolicyNo());
		//如果传入的是空字符串,则转换成Date的时候即使是空字符串,也会转换成当前的日期
		if (StringUtils.isNotEmpty(requestDto.getStartDate())){
		prpCmainDto.setStartDate(new DateTime(requestDto.getStartDate(), DateTime.YEAR_TO_DAY));
		}
		if (StringUtils.isNotEmpty(requestDto.getEndDate())) {
			prpCmainDto.setEndDate(new DateTime(requestDto.getEndDate(), DateTime.YEAR_TO_DAY));
		}
		if (StringUtils.isNotEmpty(requestDto.getStartEndDate())) {
			prpCmainDto.setStartEndDate(new DateTime(requestDto.getStartEndDate(), DateTime.YEAR_TO_DAY));
		}
		if (StringUtils.isNotEmpty(requestDto.getEndEndDate())) {
			prpCmainDto.setEndEndDate(new DateTime(requestDto.getEndEndDate(), DateTime.YEAR_TO_DAY));
		}
		prpCmainDto.setPageNo(requestDto.getPageNo());
		prpCmainDto.setPageSize(requestDto.getPageSize());
		prpCmainRequestDto.setPrpCmainDto(prpCmainDto);
		prpCmainRequestDto.setPolicyNoList(policyNoList);
		prpCmainRequestDto.setRiskCodeList(riskList);
		if(StringUtils.isNotEmpty(requestDto.getIdentifyNumber())) {
			prpCmainRequestDto.setIdentifyNumber(requestDto.getIdentifyNumber());
		}
		PageInfo<PrpCmainDto> prpCmainPageInfo = prpCmainApi.queryPolicyListInfo(prpCmainRequestDto);
		return prpCmainPageInfo;
	}

	/**
	 * @description 根据农户信息或耳标号查询出保单号列表
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param requestDto
	 * @return
	 * @throws Exception
	 */
	private List<String> getPolicyNoList(RequestQueryPolicyListInfoDto requestDto) throws Exception {
		RequestQueryPolicyDto requestQueryPolicyDto = new RequestQueryPolicyDto();
		requestQueryPolicyDto.setEarLabel(requestDto.getEarLabel());
		requestQueryPolicyDto.setfName(requestDto.getfName());
		requestQueryPolicyDto.setEditType("RegistBeforeQuery");
		if (requestDto.getStartDate() != null) {
			requestQueryPolicyDto.setStartDate(requestDto.getStartDate());
			if (requestDto.getEndDate() != null) {
				requestQueryPolicyDto.setEndDate(requestDto.getEndDate());
			} else {
				requestQueryPolicyDto.setEndDate((new DateTime(new Date(), DateTime.YEAR_TO_DAY)).toString());
			}
		}
		Map<String,String> map =new HashMap<>();
		if(StringUtils.isNotEmpty(requestDto.getEarLabel())) {
			map.put("earlAbel", requestDto.getEarLabel());
		}
		if (StringUtils.isNotEmpty(requestDto.getfName())) {
			map.put("fName", requestDto.getfName());
		}
		List<InsureMainListDto>  insureMainListDtoList = insureMainListApi.queryByEarableandFname(map);
		List<String> list =new ArrayList<>();
		for (int i = 0;i<insureMainListDtoList.size();i++){
			list.add(insureMainListDtoList.get(i).getPolicyNo());
		}
		return list;
	}
	/**
	 * @description:方法功能简述: 报案登记页面初始化
	 * @author 安齐崇
	 * @date 2017年11月22日下午7:22:52
	 * @param requestDto
	 *            封装入参的传输对象
	 * @throws Exception
	 */
	@Override
	public RegistPageResDto getPageInfo(RegistPageReqDto requestDto) throws Exception {
		Long startTime= System.currentTimeMillis();
		/* 校验数据的合法性 */
		this.verifyParam(requestDto);
		/* 保单号 */
		String policyNo = requestDto.getPolicyNo();
		/* 报案号 */
		String registNo = requestDto.getRegistNo();
		/* 编辑类型，通过此字段判断是报案前初始化（ADD），或者报案后初始化(EDIT,SHOW) */
		String editType = requestDto.getEditType();
		/* 出险时间 */
		String damageDate = requestDto.getDamageDate();
		/* 出险小时 */
		String damageHour = requestDto.getDamageHour();
		/* 出险分钟 */
		String damageMinute = requestDto.getDamageMinute();
		RegistPageResDto pageDto = new RegistPageResDto();
		/* 获取登录用户 */
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		PrpDuserDto userInfo = prpDuserApi.queryByPK(userCode);
		pageDto.setRegistNo(registNo);
		pageDto.setPolicyNo(policyNo);
		pageDto.setEditType(editType);
		pageDto.setUserCode(userCode);
		pageDto.setStatus(requestDto.getStatus());
		pageDto.setSwfLogFlowID(requestDto.getSwfLogFlowID());
		pageDto.setSwfLogLogNo(requestDto.getSwfLogLogNo());
		pageDto.setModelNo(requestDto.getModelNo());
		pageDto.setNodeNo(requestDto.getNodeNo());
		pageDto.setComCode(userInfo.getComCode());
		String riskCode;
		/* 得到险种代码 如果有保单号根据保单号获取（登记前查询），如果没有根据报案号获取（登记后查询），并校验数据的存在性 */
		if (StringUtils.isEmpty(policyNo) && !"ADD".equals(editType)) {
			PrpLRegist prplregist = prplRegistDao.findOne(new PrpLRegistKey(registNo));
			if (prplregist == null) {
				/* 校验传入的报案号是否有效 */
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("不存在报案号为{}的报案信息，请核对！", registNo);
				}
				throw new BusinessException("不存在报案号为{}的报案信息，请核对！", registNo);
			}
			/* 如果查询到报案信息，从报案信息中得到险种编码 */
			riskCode = prplregist.getRiskCode();
			/* 如果查询到保单信息，设置保单信息 */
			pageDto.setPolicyNo(prplregist.getPolicyNo());
			/* 把报案对象prplregist 设置到返参大对象中，下面直接取用 */
			PrpLRegistDtoExt prpLRegistDtoExt = new PrpLRegistDtoExt();
			pageInitCommonService.copyPropertiesIfNull(prplregist, prpLRegistDtoExt);
			pageDto.setPrpLregistDto(prpLRegistDtoExt);
		} else {
			/* 初始化出险时间，没有取系统时间，根据此时间进行把有效的批单信息回倒到保单 */
			Long startTime1=System.currentTimeMillis();
			this.initDamagetime(pageDto, damageDate, damageHour, damageMinute);
			  ResponseQueryPolicyInfoDto policyDto = pageInitCommonService.findEndOrBefore(policyNo,null,null);
			  Long endTime1= System.currentTimeMillis();
			  Long time1=endTime1-startTime1;
			System.out.println("++++++++++++++++++++");
			System.out.println("回倒的执行时间为"+time1);
			if (policyDto == null || policyDto.getPrpCmainDto() == null) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error("不存在保单号为{}的保单信息，不能报案，请核对！", policyNo);
				}
				throw new BusinessException("不存在保单号为{}的保单信息，不能报案，请核对！", policyNo);
			}
			riskCode = policyDto.getPrpCmainDto().getRiskCode();
			/* 设置保单对象，以后可以直接取，之后不用查数据库 */
			pageDto.setPolicyDto(policyDto);
		}
		if (pageDto.getPolicyDto() == null) {
			pageDto.setPolicyDto(pageInitCommonService.findEndOrBefore(policyNo,null,null));
		}
		pageDto.setRiskCode(riskCode);
		String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
		pageDto.setRiskType(riskType);
		/* 把报案对象prplregist 设置到返参大对象中，下面直接取用 */
		PrpLRegistDtoExt prpLRegistDtoExt = new PrpLRegistDtoExt();
		PrpLRegist prplregist = prplRegistDao.findOne(new PrpLRegistKey(registNo));
		pageInitCommonService.copyPropertiesIfNull(prplregist, prpLRegistDtoExt);
		pageDto.setPrpLregistDto(prpLRegistDtoExt);
		if ("ADD".equals(editType)) {
			this.policyDtoToView(policyNo, pageDto);
		} else if ("EDIT".equals(editType) || "SHOW".equals(editType)) {
			this.setRegistDtoToView(pageDto);
		}
		/* 设置调度等额外信息 */
		prepareOthParam(pageDto);
		completePageInfo(pageDto.getPolicyDto().getPrpCmainDto(), pageDto);
		pageDto.setStrDamageDate(null);
		pageDto.setStrDamageHour(null);
		pageDto.setStrDamageMin(null);
		Long endTime= System.currentTimeMillis();
		Long time=endTime-startTime;
		System.out.println("=====================");
		System.out.println("总执行时间为"+time);

		return pageDto;
	}

	/**
	 * @description:方法功能简述: 设置调度信息，操作状态,耳标号等信息
	 * @author 安齐崇
	 * @date 2017年12月11日下午11:31:22
	 * @param pageDto
	 */
	private void prepareOthParam(RegistPageResDto pageDto) {
		String riskCode = pageDto.getRiskCode();
		RegistDto registDto = this.findRegistDtoByRegistNo(pageDto.getRegistNo());
		PrpLScheduleMainWfDto prplScheduleMainWfDto = new PrpLScheduleMainWfDto();
		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		if (registDto != null) {
			prpLclaimStatusDto.setStatus(
					registDto.getPrpLclaimStatusDto() == null ? null : registDto.getPrpLclaimStatusDto().getStatus());
			prplScheduleMainWfDto.setScheduleType(registDto.getPrpLScheduleMainWfDto() == null ? null
					: registDto.getPrpLScheduleMainWfDto().getScheduleType());
			prpLclaimStatusDto.setStatus(prpLclaimStatusDto == null ? "1" : prpLclaimStatusDto.getStatus());
			prplScheduleMainWfDto
					.setScheduleType(prplScheduleMainWfDto == null ? "" : prplScheduleMainWfDto.getScheduleType());
			pageDto.setPrpLRegistRPolicyDtoList(registDto.getPrpLRegistRPolicyDtoList());
			pageDto.setPrplScheduleItemDtoList(registDto.getPrpLScheduleItemDtoList());
		} else {
			prpLclaimStatusDto.setStatus("1");
		}
		pageDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		pageDto.setPrpLScheduleMainWfDto(prplScheduleMainWfDto);
		/* 设置耳标号 */
		String taskCode = pageInitCommonService.getConfigRules("FamilySplittingFlag", "claim");
		String earFlag = "0";
		if (riskCode != null && taskCode.indexOf(riskCode) > -1) {
			List<PrpLCompensateEarDto> prpLCompensateEarDtoList = registDto.getPrpLCompensateEarDtoList();
			pageDto.setPrpLCompensateEarDtoList(prpLCompensateEarDtoList);
			earFlag = "1";
		}
		pageDto.setEarFlag(earFlag);
		pageDto.setNodeType("regis");
		pageDto.setNodeName(prpDcodeApi.translateCodeByPK("ClaimNodeType","regis"));
	}

	/**
	 * @description:方法功能简述: 如果页面没有传时间取系统时间为出险时间(报案前登记，报案后已经有出险时间了，不需要初始化)
	 * @author 安齐崇
	 * @date 2017年11月15日上午11:59:42
	 * @param pageDto
	 *            封装参数的类
	 * @param damageDate
	 *            出险时间
	 * @param damageHour
	 *            出险小时
	 * @param damageMinute
	 *            出险分钟
	 */
	private void initDamagetime(RegistPageResDto pageDto, String damageDate, String damageHour, String damageMinute) {
		if (StringUtils.isEmpty(damageDate)) {
			damageDate = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY).toString();
		}
		if (StringUtils.isEmpty(damageHour)) {
			damageHour = DateTime.current().getHour() + "";
		}
		if (StringUtils.isEmpty(damageMinute)) {
			damageMinute = DateTime.current().getMinute() + "";
		}
		pageDto.setStrDamageDate(damageDate);
		pageDto.setStrDamageHour(damageHour);
		pageDto.setStrDamageMin(damageMinute);
	}

	/**
	 * @description:方法功能简述: 初始化公共显示部分
	 * @author 安齐崇
	 * @date 2017年11月15日下午12:29:06
	 * @param
	 * @return
	 * 
	 */
	private void completePageInfo(PrpCmainDto prpCMain, RegistPageResDto pageDto) {
		PrpLRegistDtoExt prpLregistDto = pageDto.getPrpLregistDto();
		prpLregistDto.setLlflag("L");
		prpLregistDto.setAcceptFlag("Y");
		prpLregistDto.setRepeatInsureFlag("N");
		prpLregistDto.setStartDate(prpCMain.getStartDate());
		prpLregistDto.setStartHour(prpCMain.getStartHour());
		prpLregistDto.setEndHour(prpCMain.getEndHour());
		prpLregistDto.setEndDate(prpCMain.getEndDate());
		completeHead(pageDto, prpCMain);
		pageDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY).toString());
		String riskCode = pageDto.getRiskCode();
		/* 被保险人代码 */
		pageDto.setInsuredCode(prpCMain.getInsuredCode());
		pageDto.setPolicyNo(prpCMain.getPolicyNo());
		pageDto.setStatQuantity(prpCMain.getStatQuantity() == null?"":prpCMain.getStatQuantity()+"");
		Integer insureQuantity = prpCMain.getSumQuantity();

		/* 被保险人名称 */
		String strInsuredName = "";
		if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
				|| insureQuantity <= 1) {
			strInsuredName = prpCMain.getInsuredName();
		} else {
			strInsuredName = prpCMain.getInsuredName() + "等" + insureQuantity + "人";
		}

		pageDto.setInsuredName(strInsuredName);
		/* 险种信息 */
		Map<String,String> m = new HashMap<>();
		m.put("riskCode",riskCode);
		PrpDriskDto riskDto = riskApi.queryByPK(m);
		pageDto.setRiskCName(riskDto.getRiskCName());
		/* 设置已出险次数 */
		int intPerilCount = pageInitCommonService.getSamePolicyRegistInfo(pageDto.getPolicyNo(),pageDto.getRegistNo());
		pageDto.setPerilCount(intPerilCount + "");
		/* 提交工作流节点 */
		this.getSubmitNodes(pageDto, riskCode, pageDto.getComCode());
		/* 检查缴费情况及是否在承保期间内 */
		checkRule(prpCMain, pageDto);
	}

	/**
	 * @description:方法功能简述:设置保险期间中文转换
	 * @author 安齐崇
	 * @date 2017年11月17日下午6:32:11
	 * @param pageDto
	 * @param prpCMain
	 */
	private void completeHead(RegistPageResDto pageDto, PrpCmainDto prpCMain) {
		Date startDate = prpCMain.getStartDate();
		pageDto.setStartDate(new DateTime(startDate, DateTime.YEAR_TO_DAY).toString());
		Integer startHour = prpCMain.getStartHour();
		Date endDate = prpCMain.getEndDate();
		pageDto.setEndDate(new DateTime(endDate, DateTime.YEAR_TO_DAY).toString());
		Integer endHour = prpCMain.getEndHour();
		if (startHour == 0) {
			pageDto.setStartHour("零时起至");
		} else if (startHour == 12) {
			pageDto.setStartHour("十二时起至");
		} else if (startHour == 24) {
			pageDto.setStartHour("二十四时起");
		}
		if (endHour == 12) {
			pageDto.setEndHour("十二时止");
		} else if (endHour == 24) {
			pageDto.setEndHour("二十四时止");
		} else if (endHour == 0) {
			pageDto.setEndHour("零时止");
		}

	}

	/**
	 * @description:方法功能简述:校验是否在保险期间内，缴费情况
	 * @author 安齐崇
	 * @date 2017年11月15日下午12:25:03
	 * @param prpCMain
	 *            保单对象
	 * @return pageDto 封装数据的对象
	 */
	private void checkRule(PrpCmainDto prpCMain, RegistPageResDto pageDto) {
		int checkPay = pageDto.getIntPayFee();
		if ("null".equals(pageDto.getMessage()) || null == pageDto.getMessage()) {
			pageDto.setMessage("");
		}
		pageDto.setIntPayFee(checkPay);
		if (checkPay != 1) {
			if (checkPay == -1) {
				pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage()) ? "</br>"
						: "" + pageDto.getMessage() + "保费未缴，请谨慎处理！");
			} else if (checkPay == -2) {
				pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage()) ? "</br>"
						: "" + pageDto.getMessage() + "保费已缴未缴全，请谨慎处理！");
			}
		}
		Date startdate = prpCMain.getStartDate();
		Date enddate = prpCMain.getEndDate();
		Date current = new Date();
		if (startdate.getTime() > current.getTime() || enddate.getTime() < current.getTime()) {
			pageDto.setMessage(
					StringUtils.isNotBlank(pageDto.getMessage()) ? "</br>" : "" + pageDto.getMessage() + "保单不在保险期间内！");
		}
	}

	/**
	 * @description:方法功能简述:查询保单，并进行批单回到
	 * @author 安齐崇
	 * @date 2017年11月23日上午9:38:01
	 * @param policyNo
	 *            保单号
	 * @return policyDto 保单对象
	 */
	private PrpCmainDto findEndOrBeforePolicy(String policyNo) {
		Map<String, String> map = new HashMap<>();
		map.put("policyNo", policyNo);
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
		return prpCmainDto;
	}

	/**
	 * @description:方法功能简述: 校验数据的合法性
	 * @author 安齐崇
	 * @date 2017年11月24日下午5:19:13
	 * @param requestDto
	 * @throw Exception
	 */
	private void verifyParam(RegistPageReqDto requestDto) {
		if (requestDto == null) {
			throw new DataVerifyException("请求参数不能为空!");
		}
		if ("ADD".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getPolicyNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型保单号不能为空！");
			}
		} else if ("EDIT".equals(requestDto.getEditType()) || "SHOW".equals(requestDto.getEditType())) {
			if (StringUtils.isEmpty(requestDto.getRegistNo())) {
				throw new DataVerifyException(requestDto.getEditType() + "编辑类型报案号不能为空！");
			}
		} else {
			throw new BusinessException("编辑类型不合法,请选择ADD、EDIT或SHOW编辑类型！");
		}
	}
    /**
      * @description ADD类型返回参数组装
      * @author 安齐崇
      * @date 2017年12月18日 上午10:54:54
      * @param policyNo 保单号
      * @param registInfo 报案登记初始化返参对象
      * @return
     */
	public void policyDtoToView(String policyNo, RegistPageResDto registInfo) throws Exception {
		PrpCmainDto prpCMainDto = registInfo.getPolicyDto().getPrpCmainDto();
		String delinquentfeeCase = "";
		int intPayFee = pageInitCommonService.checkPay(policyNo);
		registInfo.setIntPayFee(intPayFee);
		String riskCode = registInfo.getRiskCode();
		/* 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴 */
		if (intPayFee == -2 && prpCMainDto.getPayTimes() > 1) {
			delinquentfeeCase = pageInitCommonService.getDelinquentfeeCase(prpCMainDto);
		}
		/* 设置分期付款未缴期数 */
		registInfo.setDelinquentfeeCase(delinquentfeeCase);
		PrpLRegistDtoExt prpLregistEXtDto = new PrpLRegistDtoExt();
		prpLregistEXtDto.setFirstSiteFlag("0");
		/* 设置报案操作的状态为 新案件登记 (未处理任务) */
		prpLregistEXtDto.setStatus("1");
		String estiCurrency = prpCMainDto.getCurrency();
		/* 报损币别信息 */
		prpLregistEXtDto.setEsticurrency(estiCurrency);
		/* reason:获取报案出险延期天数 */
		// String configValue = prpDriskConfigApi.getConfigValue("00000000",
		// riskCode, "REPORT_DEFER_DAYS");
		PrpDriskConfigDto configDto = prpDriskConfigApi.queryByPK("00000000", riskCode, "REPORT_DEFER_DAYS");
		String configValue = configDto == null ? "" : configDto.getConfigValue();
		if (configValue == null || configValue.equals("")) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("请联系系统管理员，在平台配置系统中进行险种{}报案出险延期天数'的初始化！", riskCode);
			}
		throw new BusinessException(BusinessException.BUSINESS_ERROR_CODE,
					"请联系系统管理员，在平台配置系统中进行险种" + riskCode + "'报案出险延期天数'的初始化！");
		}
		registInfo.setConfigValue(configValue);
		prpLregistEXtDto.setInputDate((new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY)));
		prpLregistEXtDto.setReportDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLregistEXtDto.setReportHour(new DateTime(new Date(), DateTime.HOUR_TO_MINUTE).toString() + ":00");
		prpLregistEXtDto.setDamageStartDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLregistEXtDto.setDamageStartHour(new DateTime(new Date(), DateTime.HOUR_TO_MINUTE).toString() + ":00");
		prpLregistEXtDto.setDamageEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLregistEXtDto.setDamageEndHour(new DateTime(new Date(), DateTime.HOUR_TO_MINUTE).toString() + ":00");
		PrpDuserDto userInfo = prpDuserApi.queryByPK(prpCMainDto.getHandler1Code());
		prpLregistEXtDto.setOperatorCode(userInfo.getUserCode());
		prpLregistEXtDto.setMakeCom(userInfo.getMakeCom());
		String properties = pageInitCommonService.getConfigRules("FamilySplittingFlag", "claim");
		if (properties != null && properties.indexOf(riskCode) > -1) {
			List<PrpCitemKindDto> itemkinds = registInfo.getPolicyDto().getPrpCitemKindDtoList();
			prpLregistEXtDto.setLossName((itemkinds != null && itemkinds.size() > 0)
					? itemkinds.get(0).getItemDetailName() : prpLregistEXtDto.getLossName());
			List<PrpCaddressDto> prpCaddressDtoList = registInfo.getPolicyDto().getPrpCaddressDtoList();
			PrpCaddressDto addressDto = prpCaddressDtoList == null || prpCaddressDtoList.size() < 1? null:prpCaddressDtoList.get(0);
			prpLregistEXtDto.setDamageAddress(
					addressDto == null ? prpLregistEXtDto.getDamageAddress() : addressDto.getAddressName());
		}
		/* 拷贝其它属性 */
		pageInitCommonService.copyPropertiesIfNull(prpCMainDto, prpLregistEXtDto);
		registInfo.setPrpLregistDto(prpLregistEXtDto);
	}
	/**
     * @description EDIT/SHOW类型返回参数组装
     * @author 安齐崇
     * @date 2017年12月18日 上午10:54:54
     * @param registInfo 报案登记初始化返参对象
     * @return
    */
	public void setRegistDtoToView(RegistPageResDto registInfo) throws Exception {
		String policyNo = "";
		String registNo = registInfo.getRegistNo();
		String riskType = registInfo.getRiskType();
		DateTime.setDateDelimiter("-");
		PrpLRegistDtoExt prpLregistDto = registInfo.getPrpLregistDto();
		if (prpLregistDto!= null){
			policyNo = prpLregistDto.getPolicyNo();
		}
		int intPayFee = pageInitCommonService.checkPay(policyNo);
		registInfo.setIntPayFee(intPayFee);
		PrpCmainDto cmainDto = registInfo.getPolicyDto().getPrpCmainDto();
		/* 欠费情况 */
		String delinquentfeeCase = "";
		/* 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴 */
		if (intPayFee == -2 && cmainDto.getPayTimes() > 1) {
			delinquentfeeCase = pageInitCommonService.getDelinquentfeeCase(cmainDto);
		}
		/* 设置分期付款未缴期数 */
		registInfo.setDelinquentfeeCase(delinquentfeeCase);
		if (!"05".equals(prpLregistDto.getClassCode())) {
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(), DateTime.YEAR_TO_DAY));
		} else {
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(), DateTime.YEAR_TO_SECOND));
		}
		/**
		 * 如果种植险是修改报案的话,那么在下面将Status重新赋值,另外判断条件还应该增加一个标志位
		 * 下面对Status重新赋值的意义是,让种植险报案在提交以后修改时,页面上可以显示暂存提交按钮
		 **/
		if ("H".equals(riskType)) {
			prpLregistDto.setStatus("2");
		}
		prpLregistDto.setOtherFlag(cmainDto.getOthFlag());
		/* 报案文本出险摘要，以及出险详细原因 */
		List<String> damageDetails = new ArrayList<String>();
		List<PrpLRegistText> registTextList = prpLRegistTextDao
				.findAll(Specifications.<PrpLRegistText> and().eq("registNo", registNo).build(), new Sort("lineNo"));
		List<PrpLRegistTextDto> prpLregistTextDtoList = new ArrayList<PrpLRegistTextDto>();
		this.convertCollection(registTextList, prpLregistTextDtoList, PrpLRegistTextDto.class);
		StringBuffer context = new StringBuffer();
		if (prpLregistTextDtoList != null) {
			java.util.Iterator<PrpLRegistTextDto> iterator = prpLregistTextDtoList.iterator();
			while (iterator.hasNext()) {
				PrpLRegistTextDto prpLregistTextDto = (PrpLRegistTextDto) iterator.next();
				if ("1".equals(prpLregistTextDto.getTextType())) {
					context.append("  ");
					context.append(prpLregistTextDto.getContext());
					context.append("\t");

				} else if ("06".equals(prpLregistTextDto.getTextType())) {
					damageDetails.add(prpLregistTextDto.getContext());
				}
			}
		}
		if (damageDetails.size() > 0) {
			prpLregistDto.setStrDamageMessage("06");
		}
		/* 出险详细原因复选框 */
		prpLregistDto.setDamageMessage(damageDetails);
		/* 出险摘要 */
		prpLregistDto.setContext(context.toString());
		registInfo.setPrpLregistDto(prpLregistDto);
	}
	 /**
     * @description:方法功能简述: 根据险种和机构得到工作流提交信息
     * @author 安齐崇
     * @date 2017年11月21日下午12:56:50
     * @param registInfo 数据传输对象
     * @param riskCode  险种编码
     * @param comCode  机构编码
     */
	public void getSubmitNodes(RegistPageResDto registInfo, String riskCode, String comCode) {
		/* 报案节点特殊，无法从前面得到当前的modelNo号码，必须从数据库中获得,模板号需要根据险种，操作员部门选择 */
		Integer modelNo = 0;
		/* 节点号 */
		Integer nodeNo = 1;
		Integer nextNodeNo = 0;
		/* 可以选择的所有的下一个节点 */
		List<SwfPath> pathList = new ArrayList<>();
		/* // 需要用户来指定的下一个节点 */
		List<SwfPathDto> userSelectList = new ArrayList<>();
		SwfPathDtoExt swfPathDto = new SwfPathDtoExt();
		modelNo = workFlowService.getModelNo(riskCode, comCode);
		if (modelNo > 0 && nodeNo != null) {
			pathList = swfPathDao.getNextSumbitNodes(modelNo, nodeNo);
			String[] selectNodeList = new String[pathList.size()];
			for (int i = 0; i < pathList.size(); i++) {
				SwfPath swfPathDtoTemp = new SwfPath();
				swfPathDtoTemp = pathList.get(i);
				swfPathDto.setNextNodeNo(nextNodeNo);
				if (!swfPathDtoTemp.getDefaultFlag().equals("3")) {
					/* 判断是可供选择的节点 */
					userSelectList.add(this.convert(swfPathDtoTemp, SwfPathDto.class));
				}
				selectNodeList[i] = nextNodeNo + "";
			}
			swfPathDto.setNextNodeNoList(selectNodeList);
		}
		List<SwfPathDto> swfPathDtoList = new ArrayList<SwfPathDto>();
		this.convertCollection(pathList, swfPathDtoList, SwfPathDto.class);
		swfPathDto.setPathList(swfPathDtoList);
		registInfo.setSwfPathDto(swfPathDto);
	}
	/**
	 * @description:方法功能简述: 根据报案号查询报案相关的大对象
	 * @author 安齐崇
	 * @date 2017年11月9日下午11:31:05
	 * @param registNo 报案号
	 * @return registDto
	 */
	public RegistDto findRegistDtoByRegistNo(String registNo) {
		RegistDto registDto = new RegistDto();
		/*立案基本信息表*/
		List<PrpLClaim> prplClaimList = prpLClaimDao.findAll(Specifications.<PrpLClaim>and().eq("registNo", registNo).build());
		List<PrpLClaimDto> prplClaimDtoList = new ArrayList<PrpLClaimDto>();
		this.convertCollection(prplClaimList, prplClaimDtoList, PrpLClaimDto.class);
		registDto.setPrpLClaimDtoList(prplClaimDtoList);
		
		PrpLRegist prplRegist = prpLRegistDao.findOne(new PrpLRegistKey(registNo));
		registDto.setPrpLRegistDto(this.convert(prplRegist, PrpLRegistDto.class));
		
		List<PrpLRegistExt> regsitExtList = prpLRegistExtDao.findAll(Specifications.<PrpLRegistExt>and().eq("registNo", registNo).build());
		List<PrpLRegistExtDto> regsitExtDtoList = new ArrayList<PrpLRegistExtDto>();
		this.convertCollection(regsitExtList, regsitExtDtoList, PrpLRegistExtDto.class);
		registDto.setPrpLRegistExtDtoList(regsitExtDtoList);
		
		/*报案文字表*/
		List<PrpLRegistText> registTextList = prpLRegistTextDao.findAll(Specifications.<PrpLRegistText>and().eq("registNo", registNo).build(),new Sort("lineNo"));
		List<PrpLRegistTextDto> registTextDtoList =new ArrayList<PrpLRegistTextDto>();
		this.convertCollection(registTextList, registTextDtoList, PrpLRegistTextDto.class);
		registDto.setPrpLRegistTextDtoList(registTextDtoList);
		
		/*联系人表*/
		List<PrpLRelatePerson> personList = prpLRelatePersonDao.findAll(Specifications.<PrpLRelatePerson>and().eq("registNo", registNo).build());
		List<PrpLRelatePersonDto> personDtoList =new ArrayList<PrpLRelatePersonDto>();
		this.convertCollection(personList, personDtoList, PrpLRelatePersonDto.class);
		registDto.setPrpLRelatePersonDtoList(personDtoList);
		/*调度任务/查勘任务主表*/
		PrpLScheduleMainWf mainWf = prpLScheduleMainWfDao.findOne(new PrpLScheduleMainWfKey(1, registNo));
		registDto.setPrpLScheduleMainWfDto((this.convert(mainWf, PrpLScheduleMainWfDto.class)));
		List<PrpLScheduleItem> scheduleItemList = prpLScheduleItemDao.findAll(Specifications.<PrpLScheduleItem>and().eq("registNo", registNo).eq("scheduleId", "1").build());
		List<PrpLScheduleItemDto> scheduleItemDtoList = new ArrayList<PrpLScheduleItemDto>();
		this.convertCollection(scheduleItemList, scheduleItemDtoList, PrpLScheduleItemDto.class);
		registDto.setPrpLScheduleItemDtoList(scheduleItemDtoList);
		/*理赔分户清单表*/
		List<PrpLCompensateEar> earList = prpLCompensateEarDao.findAll(Specifications.<PrpLCompensateEar>and().eq("registNo", registNo).eq("nodeType", "regis").eq("businessNo", registNo).build());
		List<PrpLCompensateEarDto> earDtoList = new ArrayList<PrpLCompensateEarDto>();
		this.convertCollection(earList, earDtoList, PrpLCompensateEarDto.class);
		registDto.setPrpLCompensateEarDtoList(earDtoList);
		/*理赔节点状态表*/
		PrpLclaimStatus status = prpLclaimStatusDao.findOne(new PrpLclaimStatusKey(registNo, "regis", 0));
		registDto.setPrpLclaimStatusDto(this.convert(status, PrpLclaimStatusDto.class));
		/*索赔申请人表*/
		List<PrpLAccIPerson> persons = prpLAccIPersonDao.findAll(Specifications.<PrpLAccIPerson>and().eq("certiNo", registNo).build());
		List<PrpLAccIPersonDto> personsDto =new ArrayList<PrpLAccIPersonDto>();
		//如果性别没有的险种，给赋值为9（与核心分户录入时统一），其表示未知
	     for (int i = 0; i < persons.size(); i++) {
			PrpLAccIPerson prpLacciPersonDto =  persons.get(i);
			if (prpLacciPersonDto.getSex() == null|| prpLacciPersonDto.getSex() == "") {
					prpLacciPersonDto.setSex("9");
			}
		}
	    this.convertCollection(persons, personsDto, PrpLAccIPersonDto.class);
	    registDto.setPrpLAccIPersonDtoList(personsDto);
	   /*关联查询 */
	    List<PrpLRegistRPolicy> policyList = prpLRegistRPolicyDao.findAll(Specifications.<PrpLRegistRPolicy>and().eq("registNo", registNo).eq("validStatus", "1").build());
	    List<PrpLRegistRPolicyDto> policyDtoList =new ArrayList<PrpLRegistRPolicyDto>();
	    this.convertCollection(policyList, policyDtoList, PrpLRegistRPolicyDto.class);
	    registDto.setPrpLRegistRPolicyDtoList(policyDtoList);
	    return registDto;
	}
	/**
	 * @description:方法功能简述: 出险信息查询
	 * @author 安齐崇
	 * @date 2017年11月13日下午9:38:52
	 * @param policyNo 出险信息查询入参类
	 * @return responseDto 出险信息出参对象
	 */
	public RiskInfoResponseDto findRiskInfo(String  policyNo) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("出险信息次数详细查询开始...");
		}
		RiskInfoResponseDto responseDto =new RiskInfoResponseDto();
		List<PrpLRegistDtoExt> prpLRegistDtoExtList =findInfoByPolicyNo(policyNo);
		responseDto.setPrpLRegistDtoExtList(prpLRegistDtoExtList);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("出险信息次数详细查询完毕...");
		}
		return responseDto;
	}
	/**
	 * @description:方法功能简述:报案信息查询
	 * @author 安齐崇
	 * @date 2017年11月13日下午9:38:52
	 * @param policyNo 保单号
	 * @return registClaimDtoList 报案信息返回对象
	 */
	private List<PrpLRegistDtoExt> findInfoByPolicyNo(String policyNo) {
		Specification<PrpLRegist> spec = Specifications.<PrpLRegist>and().eq("policyNo", policyNo).build();
		List<PrpLRegist> prplRegistList = prplRegistDao.findAll(spec);
		Specification<PrpLClaim> specification = Specifications.<PrpLClaim>and().eq("policyNo", policyNo).build();
 		List<PrpLClaim> prpLclaimList = prplClaimDao.findAll(specification);
 		Specification<PrpLCompensate> spec2 = Specifications.<PrpLCompensate>and().eq("policyNo",policyNo).build();
		List<PrpLCompensate> prpLcompensateList=prpLCompensateDao.findAll(spec2);
    	List<PrpLRegistDtoExt> registClaimDtoList = new ArrayList<PrpLRegistDtoExt>();
    	for (int i = 0; i < prplRegistList.size(); i++) {
    		PrpLRegist prpLregist = prplRegistList.get(i);
    		PrpLRegistDtoExt registClaimInfoDto = new PrpLRegistDtoExt();
    		registClaimInfoDto.setPolicyNo(prpLregist.getPolicyNo());
    		registClaimInfoDto.setSerialNo(i+1);
    		registClaimInfoDto.setRegistNo(prpLregist.getRegistNo());
    		registClaimInfoDto.setDamageStartDate(prpLregist.getDamageStartDate());
    		registClaimInfoDto.setStrDamageStartDate(DateUtils.dateToStr(prpLregist.getDamageStartDate()));
    		registClaimInfoDto.setLinkerName(prpLregist.getLinkerName());
    		registClaimInfoDto.setOperatorCode(prpLregist.getOperatorCode());
    		registClaimInfoDto.setDamageAddress(prpLregist.getDamageAddress());
    		registClaimInfoDto.setBrandName(prpLregist.getBrandName());
    		registClaimInfoDto.setRegistNo(prpLregist.getRegistNo()); 
    		registClaimInfoDto.setPhoneNumber(prpLregist.getPhoneNumber());
    		registClaimInfoDto.setDamageName(prpLregist.getDamageName());
    		registClaimInfoDto.setDamageName(prpLregist.getDamageName());
    		registClaimInfoDto.setDamageAreaName(prpLregist.getDamageAddress());
    		List<PrpLClaim> prpLclaimDtoList = new ArrayList<>();
    		List<PrpLCompensate> prpLcompensateDtoList = new ArrayList<>();
    		double sumPaidShow = 0D;
    		for (PrpLClaim prpLClaim : prpLclaimList) {
				if(prpLregist.getRegistNo().equals(prpLClaim.getRegistNo())){
					prpLclaimDtoList.add(prpLClaim);
				}
			}
    		if (prpLclaimDtoList.size() < 1) {
    			registClaimInfoDto.setClaimNo("");
    			registClaimInfoDto.setSumClaim(0);
    			registClaimInfoDto.setSumPaidShow(0);
    			if(prpLregist.getCancelDate() == null || prpLregist.getCancelDate() .toString().equals("")){
    				registClaimInfoDto.setStatus("正在处理");
    			}
    			else{
    				registClaimInfoDto.setStatus("已注销");
    			}
    		} else {
    			PrpLClaim  prpLclaim = (PrpLClaim)  prpLclaimDtoList.get(0);
    		    for (PrpLCompensate prpLCompensate : prpLcompensateList) {
					if(prpLclaim.getClaimNo().equals(prpLCompensate.getClaimNo())){
						prpLcompensateDtoList.add(prpLCompensate);
					}
				}
    			prpLcompensateDtoList=prpLCompensateDao.findAll(spec2);
    			for (int j = 0; j < prpLcompensateDtoList.size(); j++) {
    				if(prpLcompensateDtoList.get(j).getRegistNo()!=null&&prplRegistList.get(i).getRegistNo().equals(prpLcompensateDtoList.get(j).getRegistNo())) {
						PrpLCompensate prpLcompensateDto = (PrpLCompensate) prpLcompensateDtoList.get(j);
						sumPaidShow = sumPaidShow + prpLcompensateDto.getSumPaid();
					}
    			}
    			registClaimInfoDto.setClaimType(prpLclaim.getClaimType());
    			registClaimInfoDto.setClaimNo(prpLclaim.getClaimNo());
    			
    			registClaimInfoDto.setSumClaim(prpLclaim.getSumClaim());
    			registClaimInfoDto.setSumPaidShow(sumPaidShow);
				if (prpLclaim.getCaseType() == null || prpLclaim.getCaseType().equals("")) {
					registClaimInfoDto.setStatus("未结案");
				} else if ("0".equals(prpLclaim.getCaseType())) {
					registClaimInfoDto.setStatus("已注销");
				} else if ("1".equals(prpLclaim.getCaseType())) {
					registClaimInfoDto.setStatus("已拒陪");
				} else if ("2".equals(prpLclaim.getCaseType())) {
					registClaimInfoDto.setStatus("已结案");
				}
    		}
    		registClaimDtoList.add(registClaimInfoDto);
    	}  	
    	return registClaimDtoList;
    }
	/**
     * @description 按条件查询报案任务
     * @param prpLregistQueryDTO
     * @return returnPage
     * @author Majunling
	 * @throws Exception 
     * @date 2017年8月28日 下午2:58:42
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public PageInfo<PrpLregistResponseDto> queryPrpLregistByCondition(PrpLregistQueryDto prpLregistQueryDTO) throws Exception {
        // 业务类型：ADD-新增 EDIT-修改 SHOW-显示
        PageInfo<PrpLregistResponseDto> returnPage = null;

        // 报案查询分页
        int pgageSize = prpLregistQueryDTO.getPageSize();
        int pageNo = prpLregistQueryDTO.getPageNo();
        returnPage = setTurnPageDto(prpLregistQueryDTO, pageNo, pgageSize);
        return returnPage;
    }

    /**
     * @description 查询报案任务数据并组装成返回对象
     * @author 马俊玲
     * @date
     * @param prpLregistQueryDTO
     * @return
     * @throws Exception 
     */
    private PageInfo<PrpLregistResponseDto> setTurnPageDto(PrpLregistQueryDto prpLregistQueryDTO, int pageNo,
			int pageSize) throws Exception {
		String msg = "";
		if (pageNo < 1) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("页码小于1");
			}
			throw new DataVerifyException("页码不能小于1");
		}
		if (pageSize < 1) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("每页数量小于1");
			}
			throw new DataVerifyException("每页数量不能小于1");
		}

		// 根据输入的保单号，报案号生成SQL where 子句
		// 保单号
		String policyNo = prpLregistQueryDTO.getPolicyNo();
		// 报案号
		String registNo = prpLregistQueryDTO.getRegistNo();
		// 险种大类
		String riskCategory = prpLregistQueryDTO.getRiskCategory();
		// 被保险人
		String insuredName = prpLregistQueryDTO.getInsuredName();
		// 案件状态
		String status = prpLregistQueryDTO.getStatus();
		// 出险日期
		String damagerDate = prpLregistQueryDTO.getDamageDate();
		// 出险日期起期
        String damageStartDate = prpLregistQueryDTO.getDamageStartDate();
        // 出险日期止期
        String damageEndDate = prpLregistQueryDTO.getDamageEndDate();
		// 出险小时
		String damageHour = prpLregistQueryDTO.getDamageHour();
		// 耳标号
		String strEarLabel = prpLregistQueryDTO.getEarLabel();
		// 身份证号
		String strFCardID = prpLregistQueryDTO.getfCardID();
		// 农户姓名
		String strFname = prpLregistQueryDTO.getFname();
		// 出险小时起始时间
        String damageStartHour = prpLregistQueryDTO.getDamageStartHour();
        // 出现小时结束时间
        String damageEndHour = prpLregistQueryDTO.getDamageEndHour();
        Map<String,String> map1 =new HashMap<>();
		List<String> list1 = new ArrayList<>();
        if (StringUtils.isNotEmpty(strFname) || StringUtils.isNotEmpty(strEarLabel)){
        	if (StringUtils.isNotEmpty(strFname)){
        		map1.put("fName",strFname);
			}
			if (StringUtils.isNotEmpty(strEarLabel)){
        		map1.put("earlAbel",strEarLabel);
			}
			List<InsureMainListDto> insureMainListDtoList= insureMainListApi.queryByEarableandFname(map1);

			for (int  i=0;i<insureMainListDtoList.size();i++){
				list1.add(insureMainListDtoList.get(i).getPolicyNo());
			}
		}
		if (StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(registNo) && StringUtils.isEmpty(insuredName)
				&& StringUtils.isEmpty(strEarLabel) && StringUtils.isEmpty(strFCardID) && StringUtils.isEmpty(strFname)
				&& StringUtils.isEmpty(damagerDate)) {
			if (LOGGER.isInfoEnabled()) {
				msg = "除了日期，险种大类，案件状态以外的条件不能都为空";
				LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>>>>>>>{}", msg);
			}
			throw new DataVerifyException(msg);
		}
		// 1、定义sql查询语句
        StringBuilder countSql = new StringBuilder("select count(1) from (");
        StringBuilder dataSql = new StringBuilder(
				"Select DISTINCT a.RegistNo,a.PolicyNo, a.ReceiverName, b.Status, b.OperateDate, b.RiskCode, a.reportDate, a.InsuredName,a.canceldate"
						+ " From  PrpLClaimStatus b Right JOIN prpLregist a ON a.RegistNo = b.BusinessNo , prplregistrpolicy c  where  (c.registno=a.registno) and b.nodetype='regis' and 1=1");

		List<String> riskCodeList = new ArrayList<String>();
		if (StringUtils.isEmpty(riskCategory)) {
			throw new BusinessException("险种大类不能为空");
		}
		if ("all".equals(riskCategory)) {
			dataSql.append(" and  (a.riskcode like '31%' or a.riskcode like '32%')");
		} else {
			if ("H".equals(riskCategory)) {
				Map<String, String> riskTypeMap = new HashMap<String, String>();
				riskTypeMap.put("riskType", riskCategory);
				List<UtiCodeTransferDto> outCodeList = null;
				try {
					outCodeList = utiCodeTransferApi.queryByRiskType(riskTypeMap);
					for (UtiCodeTransferDto s : outCodeList) {
						riskCodeList.add(s.getOuterCode());
					}
					dataSql.append(" and  (a.riskcode like '31%')");
				} catch (Exception e) {
					throw new BusinessException();
				}
			}
			if ("I".equals(riskCategory)) {
				Map<String, String> riskTypeMap = new HashMap<String, String>();
				riskTypeMap.put("riskType", riskCategory);
				List<UtiCodeTransferDto> outCodeListI;
				try {
					outCodeListI = utiCodeTransferApi.queryByRiskType(riskTypeMap);
					for (UtiCodeTransferDto s : outCodeListI) {
						riskCodeList.add(s.getOuterCode());
					}
					dataSql.append(" and  ( a.riskcode like '32%')");
				} catch (Exception e) {
					throw new BusinessException();
				}
			}
		}

		// 2、定义条件参数集合
		Map<String, Object> paraMap = new HashMap<String, Object>();

		// 3、判断查询条件是否有值
		if (StringUtils.isNotEmpty(registNo)) {
			dataSql.append(" and  a.registNo like :RegistNo");
			paraMap.put("RegistNo", "%" + registNo + "%");
		}
		if (StringUtils.isNotEmpty(policyNo)) {
			dataSql.append(" and c.policyNo like :policyNo");
			paraMap.put("policyNo", "%" + policyNo + "%");
		}
		if (StringUtils.isNotEmpty(strEarLabel) || StringUtils.isNotEmpty(strFname)){
			dataSql.append(" and c.policyNo in :list");
			paraMap.put("list",list1);
		}
//		if (prpLregistQueryDTO.getStartDate() != null&&prpLregistQueryDTO.getStartEndDate()!=null&&prpLregistQueryDTO.getEndDate() != null&&prpLregistQueryDTO.getEndEndDate()!=null) {
//			dataSql.append(" and  a.damageStartDate >=:startDate");
//			paraMap.put("startDate", prpLregistQueryDTO.getStartDate());
//			dataSql.append(" and  a.damageStartDate <=:startEndDate");
//			paraMap.put("startEndDate", prpLregistQueryDTO.getStartEndDate());
//			dataSql.append(" and  a.damageEndDate >=:endDate");
//			paraMap.put("endDate", prpLregistQueryDTO.getEndDate());
//			dataSql.append(" and  a.damageEndDate <=:endEndDate");
//			paraMap.put("endEndDate",prpLregistQueryDTO.getEndEndDate() );
//		} else {
//			if (prpLregistQueryDTO.getStartDate() != null) {
//				dataSql.append(" and  a.damageStartDate >=:startDate");
//				paraMap.put("startDate", prpLregistQueryDTO.getStartDate());
//			}
//			if (prpLregistQueryDTO.getStartEndDate() != null) {
//				dataSql.append(" and  a.damageStartDate <=:startEndDate");
//				paraMap.put("startEndDate", prpLregistQueryDTO.getStartEndDate());
//			}
//			if (prpLregistQueryDTO.getEndDate() != null) {
//				dataSql.append(" and  a.damageEndDate >=:endDate");
//				paraMap.put("endDate", prpLregistQueryDTO.getEndDate());
//			}
//			if (prpLregistQueryDTO.getEndEndDate() != null) {
//				dataSql.append(" and  a.damageEndDate <=:endEndDate");
//				paraMap.put("endEndDate", prpLregistQueryDTO.getEndEndDate());
//			}
//		}

        //如果出险日期的起期和出险日期的止期都不为空
        if (StringUtils.isNotEmpty(damageStartDate) && StringUtils.isNotEmpty(damageEndDate)){
		    dataSql.append(" and a.damageStartDate >= to_date(:damageStartDate,'yyyy-MM-dd HH24:mi:ss') and a.damageStartDate <= to_date(:damageEndDate,'yyyy-MM-dd HH24:mi:ss')");
            paraMap.put("damageStartDate", damageStartDate);
            paraMap.put("damageEndDate", damageEndDate);
        }
        // 如果出险日期的起期不为空, 但是出险日期的止期为空 则查询大于出险起期的情况
        if (StringUtils.isNotEmpty(damageStartDate) && StringUtils.isEmpty(damageEndDate)){
            dataSql.append(" and a.damageStartDate >= to_date(:damageStartDate,'yyyy-MM-dd HH24:mi:ss') ");
            paraMap.put("damageStartDate", damageStartDate);
        }
        // 如果出险日期的止期不为空, 但是出险日期的止期为空 则查询小于出险止期的情况
        if (StringUtils.isNotEmpty(damageEndDate) &&StringUtils.isEmpty(damageStartDate) ) {
            dataSql.append(" and a.damageStartDate <= to_date(:damageEndDate,'yyyy-MM-dd HH24:mi:ss') ");
            paraMap.put("damageEndDate", damageEndDate);
        }

		if (StringUtils.isNotBlank(status)) {
			if ("all".equals(status)) {

			}
			else if("0".equals(status)){
			}

			else {
				dataSql.append(" and b.status = :status ");
				paraMap.put("status", status);
			}
		}
		//dataSql.append(" AND (a.cancelDate is  null)");
		if (StringUtils.isNotEmpty(insuredName)) {
			dataSql.append(" and  a.insuredName like :insuredName");
			insuredName = insuredName+"%";
			paraMap.put("insuredName", insuredName);
		}

		//0代表用已撤销的状态去查询,及需要撤销时间不为空满足条件
		if ("0".equals(prpLregistQueryDTO.getStatus())){
			dataSql.append(" and a.canceldate is not null");
		}
		//4代表用已处理的状态去查询,要求撤销时间必须为空
		else if ("4".equals(prpLregistQueryDTO.getStatus())){
			dataSql.append(" and a.canceldate is null");
		}
		//获取权限查询条件
		AddCodePowerConditionDto addCodePowerConditionDto =new AddCodePowerConditionDto(prpLregistQueryDTO.getUserCode(),prpLregistQueryDTO.getLoginComCode(),
				prpLregistQueryDTO.getLoginGradeCodes(),prpLregistQueryDTO.getTableName(),prpLregistQueryDTO.getUserCodeFields(),
				prpLregistQueryDTO.getComCodeFields(), "", "a", false);
		String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
		dataSql.append(codePower);
		// 用于电子档案数据库和核心数据库跨库查询条件拼接
		dataSql.append(" order by a.policyNo desc");
		// reason添加新权限h
		PowerConditionDto powerConditionDto = new PowerConditionDto();
		UserInfo user = SinoRequestContext.getCurrentContext().getUser();

		powerConditionDto.setUserCode(user.getUserCode());
		powerConditionDto.setTableName("a");
		powerConditionDto.setComCode(user.getLoginComCode());
		powerConditionDto.setComCodeFields("ComCode");
		powerConditionDto.setUserCodeFields("");
		// String customerPower = powerApi.addPower(powerConditionDto);
		// if(StringUtils.isNotBlank(customerPower)){
		// dataSql.append(customerPower);
		// }
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("报案任务查询sql>>>>>>>>>>>>>>>>>>{}", dataSql.toString());
		}
		countSql.append(dataSql + ")");
		Query countQuery = entityManager.createNativeQuery(countSql.toString());
		Query dataQuery = entityManager.createNativeQuery(dataSql.toString());
		this.setQueryParam(countQuery, paraMap);
		List sizeList = countQuery.getResultList();
		int size = 0;
		if (null != sizeList) {
			Object ar = sizeList.get(0);
			String s = ar.toString();
			size = Integer.parseInt(s);
		}
		this.setQueryParam(dataQuery, pageNo, pageSize, paraMap);
		List<Object[]> list = dataQuery.getResultList();
		List<PrpLregistResponseDto> prpLregistResponseDtoList = null;
		if (null != list && list.size() > 0) {
			prpLregistResponseDtoList = new ArrayList<PrpLregistResponseDto>();
			PrpLregistResponseDto result = null;
			for (int i = 0; i < list.size(); i++) {
				result = new PrpLregistResponseDto();
				result.setRegistNo((String) list.get(i)[0]);
				String policyNosql = "select PolicyNo from prplregistrpolicy where RegistNo='" + (String) list.get(i)[0]
						+ "'";
				Query policyNosQuery = entityManager.createNativeQuery(policyNosql);
				List<String> policyNolist = policyNosQuery.getResultList();
				result.setRelatepolicyNos(policyNolist);
				result.setStatus((String) list.get(i)[3].toString());
				String riskCode = (String) list.get(i)[5];
				Map<String,String> map = new HashMap<>();
				map.put("riskCode", riskCode);
				PrpDriskDto prpdriskDto = prpDriskApi.queryByPK(map);
				if(prpdriskDto != null) {
					String riskName = prpdriskDto.getRiskCName();
					result.setRiskCname(riskName);
					result.setRiskCode((String) list.get(i)[5]);
					result.setReportDate(format.format((Date) list.get(i)[6]));
					result.setInsuredName((String) list.get(i)[7]);
					result.setPolicyNo((String) list.get(i)[1]);
					result.setCancelDate((Date) list.get(i)[8]);
					prpLregistResponseDtoList.add(result);

				}
			}


		} else {
			if (LOGGER.isInfoEnabled()) {
				msg = "没有查到数据";
				LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>{}", msg);
			}
		}
		PageInfo<PrpLregistResponseDto> pageInfo = new PageInfo<PrpLregistResponseDto>();
		if (StringUtils.isNotEmpty(prpLregistQueryDTO.getIdentifyNumber())){
			Map<String,String> map=new HashMap<>();
			map.put("identifyNumber",prpLregistQueryDTO.getIdentifyNumber());
			List<PrpCmainDto> prpCmainDtoList1=prpCinsuredApi.queryPolicyById(map);
			List<PrpLregistResponseDto> newPrpLregistResponseDtoList = new ArrayList<>();
			// prpCmainDtoList.retainAll(prpCmainDtoList1);
			//循环身份证满足的保单号和自己查询满足的保单号 取两者的交集拼成满足的条件
			Long time1= System.currentTimeMillis();
			for (int i = 0;i<prpCmainDtoList1.size();i ++){
				String policyNoNew=prpCmainDtoList1.get(i).getPolicyNo();
				for (int j = 0; j<prpLregistResponseDtoList.size();j++){
					String policyNoOld=prpLregistResponseDtoList.get(j).getPolicyNo();
					if (policyNoNew.equals(policyNoOld)){
						newPrpLregistResponseDtoList.add(prpLregistResponseDtoList.get(j));
					}
				}
			}
			Long time2=System.currentTimeMillis();
			System.out.println("================="+(time2-time1));
			prpLregistResponseDtoList = newPrpLregistResponseDtoList;
		}
		if (null != prpLregistResponseDtoList && prpLregistResponseDtoList.size() > 0) {
			pageInfo = this.setPageInfo(prpLregistResponseDtoList, pageNo);
			pageInfo.setTotalCount(size);
		}
		return pageInfo;
	}

    /**
     * 查询已经报案的数据，计算出现次数来进行显示
     * @param resultMap
     * @param policyNo
     * @param curRegistNo
     * @throws Exception
     */
    @Override
    public void getSamePolicyRegistInfo(Map<String,Object> resultMap, String policyNo, String curRegistNo) {
        List<PrpLRegistDto> registLastList = new ArrayList<>();
        PrpLRegistDto prpLregistDtoTemp = new PrpLRegistDto();
        PrpLRegistDto prpLregistDtoPre = new PrpLRegistDto();
        PrpLRegistDto prpLregistDto = new PrpLRegistDto();
        String strOperatorCode = "";
        String strOperatorName = "";
        List<PrpLRegist> prpLRegistList = prpLRegistDao.findwithPrplext(policyNo);
        int intPerilCount = 0;
        // 最近几天的出险次数
        int intRecentCount = 0;
        // priorDate=sysConfigApi.getValue(""sysconst.RegistViewLimitDay");
        String priorDate = "5";
        DateTime dateTime = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY);
        int intervalDay = 0;
        // 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
        String oldRegistNo = "";
        String nowRegistNo = "";
        int rowNo = 0;
        int rowCount = 0;
        if (prpLRegistList != null) {
            // 计算数据的数目
            rowCount = prpLRegistList.size();
        }
        if (curRegistNo == null) {
            curRegistNo = "";
        }
        for (rowNo = 0; rowNo < rowCount; rowNo++) {
            oldRegistNo = nowRegistNo;
            prpLregistDtoPre = prpLregistDtoTemp;
            prpLregistDtoTemp = convert((PrpLRegist) prpLRegistList.get(rowNo), PrpLRegistDto.class);
            nowRegistNo = prpLregistDtoTemp.getRegistNo();
            intervalDay = DateTime.intervalDay(new DateTime(prpLregistDtoTemp.getDamageStartDate()), 0, dateTime, 0);
            if (intervalDay <= Integer.parseInt(priorDate)) {
                intRecentCount++;
            }
            // 如果为第一行，或者中间行，并且报案号不等于上一行的，或者小于最后一行的，
            if (rowNo == 0 && rowCount != 1
                    || ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo.equals(nowRegistNo)))) {
                if (oldRegistNo.equals(nowRegistNo)) {
                    prpLregistDtoTemp
                            .setBrandName(prpLregistDtoPre.getBrandName() + " " + prpLregistDtoTemp.getBrandName());
                }
                // 接着就continue了，这里需要补个intPerilCount记数
                else {
                    intPerilCount++;
                }
                continue;
            }
            // 添加上行记录

            if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
                prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName() + " " + prpLregistDtoTemp.getBrandName());
            }
            // 如果是第一次出险 intPerilCount就不应该再增加
            // 本次出险不计算在内
            if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo) && (!oldRegistNo.equals(nowRegistNo))) {

                intPerilCount++;
                strOperatorCode = prpLregistDtoTemp.getOperatorCode();
                try {
                	Map<String,String> paramMap=new HashMap<String,String>();
                	paramMap.put("userCode", strOperatorCode);
                	paramMap.put("isChinese",  "true");
                    strOperatorName = prpDuserApi.translateCode(paramMap);
                } catch (Exception e) {
                    throw new DataVerifyException("没有查到用户信息");
                }

                prpLregistDtoTemp.setOperatorCode(strOperatorName);
                if (null != prpLregistDtoTemp.getStatus()) {
                    prpLregistDtoTemp.setStatus(
                            prpDcodeApi.queryByPK("ClaimStatus", prpLregistDtoTemp.getStatus()).getCodeCode());
                }
                prpLregistDtoTemp.setSerialNo(intPerilCount);
                registLastList.add(prpLregistDtoTemp);
            } else {
                if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
                    intPerilCount++;
                    strOperatorCode = prpLregistDtoPre.getOperatorCode();
                    try {
                    	Map<String,String> paramMap=new HashMap<String,String>();
                    	paramMap.put("userCode", strOperatorCode);
                    	paramMap.put("isChinese",  "true");
                        strOperatorName = prpDuserApi.translateCode(paramMap);
                    } catch (Exception e) {
                        throw new DataVerifyException("没有查到用户信息");
                    }
                    ;
                    prpLregistDtoPre.setOperatorCode(strOperatorName);
                    if (null != prpLregistDtoTemp.getStatus()) {
                        prpLregistDtoTemp.setStatus(
                                prpDcodeApi.queryByPK("ClaimStatus", prpLregistDtoTemp.getStatus()).getCodeCode());
                    }
                    prpLregistDtoPre.setSerialNo(intPerilCount);
                    registLastList.add(prpLregistDtoPre);
                }
            }
        }
        // 计算出险的次数
        prpLregistDto.setPerilCount(intPerilCount);
        prpLregistDto.setRecentCount(intRecentCount);
        // 将查询出来的同个保单的数据放入PrpLregistDto的list
        resultMap.put("prpLregistDto1", registLastList);
        resultMap.put("policyNo", policyNo);
        resultMap.put("curRegistNo", curRegistNo);
    }
    /**
     * 根据博哦单号，保险起期，保险止期查询保单信息
     * 
     * @param riskCodeList 险种代码集合
     * @param policyNoList 保单号集合
     * @param identifyNumber 身份证号
     * @param policyNo 保单号
     * @param startDate 保险起期
     * @param endDate 保险止期
     * @param size 
     * @throws Exception
     */
    private List<String> checkPoliy(List<String> riskCodeList, List<String> policyNoList, String identifyNumber,
            String policyNo, String startDate, String endDate,int size) {
        List<PrpCmainDto> prpcmainDtoList = null;
        List<String> policyNos = new ArrayList<String>();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始查询保单");
        }
        PrpCmainRequestDto prpCmainRequestDto = new PrpCmainRequestDto();
        prpCmainRequestDto.setRiskCodeList(riskCodeList);
        prpCmainRequestDto.setIdentifyNumber(identifyNumber);
        prpCmainRequestDto.setPolicyNoList(policyNoList);
        PrpCmainDto prpCmainDto = new PrpCmainDto();
        try {
            prpCmainDto.setPageNo(1);
            prpCmainDto.setPageSize(size);
            prpCmainDto.setPolicyNo(policyNo);
            if (StringUtils.isNotBlank(startDate)) {
                prpCmainDto.setStartDate(format.parse(startDate));
            }
            if (StringUtils.isNotBlank(endDate)) {
                prpCmainDto.setEndDate(format.parse(endDate));
            }
            prpCmainRequestDto.setPrpCmainDto(prpCmainDto);
        } catch (ParseException e) {
            throw new DataVerifyException();
        }
        if (StringUtils.isBlank(policyNo)) {
            prpCmainRequestDto.setPolicyNoList(policyNoList);
        }
        try {
            
            prpcmainDtoList = (List<PrpCmainDto>) prpCmainApi.queryPolicyListInfo(prpCmainRequestDto);
            if (null != prpcmainDtoList && prpcmainDtoList.size() > 0) {
                for (PrpCmainDto pc : prpcmainDtoList) {
                    policyNos.add(pc.getPolicyNo());
                }
            }
        } catch (Exception e) {
            throw new DataVerifyException();
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>>>>>>>>>>>查询保单结束");
        }
        return policyNos;
    }
    /**
     * @description jpql查询参数、分页参数设置
     * @param dataQuery
     * @param pageNo
     * @param pageSize
     * @param paraMap
     */
    public void setQueryParam(Query dataQuery, Integer pageNo, Integer pageSize, Map<String, Object> paraMap) {
        // 1、设置参数
        for (String key : paraMap.keySet()) {
            dataQuery.setParameter(key, paraMap.get(key));
        }
        // 2、设置分页

        if (pageNo != null) {
            dataQuery.setFirstResult((pageNo - 1) * pageSize);
        }
        if (pageSize != null) {
            dataQuery.setMaxResults(pageSize);
        }
    }

    /**
     * @description jpql查询参数、无分页参数设置
     * @param dataQuery
     * @param paraMap
     */
    public void setQueryParam(Query dataQuery, Map<String, Object> paraMap) {
        setQueryParam(dataQuery, null, null, paraMap);
    }

    /**
     * @description jpql设置统一返回类型
     * @param list
     * @param pageNo
     * @param dtoClass
     * @param <T>
     * @return
     */
    public <T> PageInfo<T> setPageInfo(List<?> list, int pageNo, Class<T> dtoClass) {
        List<T> listDto = new ArrayList<T>(list.size());
        // 生成response pageinfo格式
        PageInfo<T> pageInfo = new PageInfo<>();
        convertCollection(list, listDto, dtoClass);
        pageInfo.setContent(listDto);
        pageInfo.setPages(pageNo);
        pageInfo.setTotalCount(list.size());
        return pageInfo;
    }

    /**
     * @description 将查询结果转换成PageInfo对象
     * @author majunling
     * @date
     * @param listDto
     * @param pageNo
     * @throws Exception
     * @return
     */
    public PageInfo<PrpLregistResponseDto> setPageInfo(List<PrpLregistResponseDto> listDto, int pageNo){
        if(null==listDto||listDto.size()==0){
            if(LOGGER.isInfoEnabled()){
                String msg="没有查到数据";
                LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>{}",msg);
            } 
            return null;
        }
        PageInfo<PrpLregistResponseDto> pageInfo = new PageInfo<PrpLregistResponseDto>();
        pageInfo.setContent(listDto);
        pageInfo.setPages(pageNo);
        return pageInfo;
    }

    /**
     * 取得险种的代码
     * 
     * @param  businessNo  字段名
     * @return riskCode 险种
     * @throws Exception
     */
    public String getRiskCode(String businessNo, String businessType){
        if(StringUtils.isEmpty(businessType)){
            if(LOGGER.isErrorEnabled()){
                String msg="业务号不能为空";
                LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>{}",msg);
            } 
            return null;
        }
        if(StringUtils.isEmpty(businessNo)){
            if(LOGGER.isErrorEnabled()){
                String msg="业务类型不能为空";
                LOGGER.error("报案任务查询>>>>>>>>>>>>>>>>>>{}",msg);
            } 
            return null;
        }
        String riskCode = "";
        if ("RegistNo".equals(businessType)) {
            // -------------------报案号
            PrpLRegistKey prplRegistKey = new PrpLRegistKey(businessNo);
            PrpLRegist prplRegist = prpLRegistDao.findOne(prplRegistKey);
            riskCode = prplRegist.getRiskCode();
        }
        if ("".equals(riskCode)) {
            throw new DataVerifyException("获取险种代码失败,请联系系统管理员。");
        }

        return riskCode;
    }
	/**
	 * @description 根据前端页面传过来的dto进行报案登记的暂存和提交
	 * @author 杨昆
	 * @date 2017年11月30日 下午3:00:46
	 * @param registDto 报案大对象
	 * @return map 保险号和报案号
	 * @throws Exception 
	 */
	@Override
	public Map<String, String> saveReport(ReportDto registDto) throws Exception {
		// 检验前端数据是否传全了
		if (registDto.getPrpLregistDto() == null || registDto.getPrpLclaimStatusDto() == null) {
			throw new DataVerifyException("前端传送数据不全！！");
		}
		//初始化是否创建新节点标识
		String createWorkFlowFlag = "0";
		String typeFlag = "";
		PrpLRegistDtoExtend prpLRegistDto = registDto.getPrpLregistDto();
		String comCode = prpLRegistDto.getComCode();
		String registNo = prpLRegistDto.getRegistNo();
		String policyNo = prpLRegistDto.getPolicyNo();

		//翻译页面上出险原因代码

		if(StringUtils.isNotEmpty(registDto.getPrpLregistDto().getDamageCode())) {
			String damageName = prpDcodeApi.queryByPK("DamageCode", registDto.getPrpLregistDto().getDamageCode()).getCodeCName();
			prpLRegistDto.setDamageName(damageName);
		}
		if(StringUtils.isNotEmpty(registDto.getPrpLregistDto().getLossName())) {
			prpLRegistDto.setLossCode(registDto.getPrpLregistDto().getLossName());
			Map map = new HashMap();
			map.put("itemCode",registDto.getPrpLregistDto().getLossName());
			map.put("riskCode",registDto.getPrpLregistDto().getPolicyNo().substring(1,5));
			PrpDitemAgriDto prpDitemAgriDto = prpDitemAgriApi.queryByPk(map);
			prpLRegistDto.setLossName(prpDitemAgriDto.getItemCName());
		}
		//lFlag 是什么?
		prpLRegistDto.setLFlag(prpLRegistDto.getLlflag());
		String riskCode = prpLRegistDto.getRiskCode();
		// begin--取得强制保险的险种代码
		Map<String, String> outerCodeMap = new HashMap<>();
		outerCodeMap.put("outerCode", riskCode);
		List<UtiCodeTransferDto> utiCodeTransferDtoList = utiCodeTransferApi
				.queryUtiCodeTransferDtoByOuterCode(outerCodeMap);
		String strRiskType = utiCodeTransferDtoList.get(0).getRiskType();
		// end--取得强制保险的险种代码,
		PrpLScheduleMainWfDto prpLScheduleMainWfDto = new PrpLScheduleMainWfDto();
		prpLScheduleMainWfDto.setScheduleType("ALLS");
		registDto.setPrpLScheduleMainWfDto(prpLScheduleMainWfDto);
		typeFlag = "10";

		// 获取首次暂存或登记的报案号码  如果没有报案号 则是新的报案
		if (registNo == null || registNo.length() < 1) {
			String tableName = "prplregist";
			int year = DateTime.current().getYear();
			//生成新的报案号的服务
			try {
				String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
//				userCode = "0000000000"; 这段为什么要写死成00000000?
				BillNoDto billNoDto = new BillNoDto();
				billNoDto.setTableName(tableName);
				billNoDto.setRiskCode(riskCode);
				billNoDto.setiComCode(comCode);
				billNoDto.setiYear(new Integer(year).toString());
				billNoDto.setUserCode(userCode);
				registNo = billNoApi.getBillNo(billNoDto).get("billNo");
			} catch (Exception e) {
				throw new BusinessException("生成报案号异常！！");
			}
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("获取保单号：" + policyNo + "的报案号:========" + registNo + "========");
			}
			//保存到prplRegist表中
			prpLRegistDto.setRegistNo(registNo);
			//设置创建新的工作流的标识为1 即创建新的节点(后面会根据这个标识去创建调度的未处理节点)
			createWorkFlowFlag = "1";
		}

		// 组装要保存的报案dto
		registDto = getReportDto(registDto);
		Map<String, String> policyNoMap = new HashMap<>();
		policyNoMap.put("policyNo", policyNo);
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(policyNoMap);
		prpLRegistDto.setBusinessType(prpCmainDto.getBusinessType());
		prpLRegistDto.setBusinessType1(prpCmainDto.getBusinessType1());
		prpLRegistDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
		prpLRegistDto.setOtherFlag(prpCmainDto.getOthFlag());

		SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();

		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
//		userCode = "0000000000"; 为什么要写死成0000000000
		String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
//		userComCode = "0000000000"; 为什么要写死成0000000000
		String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
		swfLogTransferDto.setUserUserCode(userCode);
		swfLogTransferDto.setUserComCode(userComCode);
		swfLogTransferDto.setUserUserName(userName);
		PrpDcompanyDto querPrpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
		swfLogTransferDto.setUserComName(querPrpDcompanyDto.getComCName());
		// 为获得workflowDto做准备
		SwfLogDto swfLogDtoDealNode = new SwfLogDto();
		swfLogDtoDealNode.setLogNo(0);
		if ("1".equals(createWorkFlowFlag)) {
			swfLogTransferDto.setCreateFlow(true);
		}
		//结案节点的endFlag是1 AcceptFlag是什么东西
		if ("N".equals(registDto.getPrpLregistDto().getAcceptFlag())) {
			swfLogDtoDealNode.setEndFlag("1");
		}
		//设置当前节点信息
		swfLogDtoDealNode.setNodeType("regis");
		swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
		swfLogDtoDealNode.setLossitemName(registDto.getPrpLregistDto().getLossName());
		swfLogDtoDealNode.setBusinessNo(registNo);
		swfLogTransferDto.setNextBusinessNo(registNo);
		swfLogDtoDealNode.setKeyIn(registNo);
		swfLogDtoDealNode.setKeyOut(registNo);
		swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		swfLogDtoDealNode.setComCode(comCode);
		swfLogDtoDealNode.setPolicyNo(policyNo);
		swfLogDtoDealNode.setRegistNo(registNo);
		// 待处理的查询条件，增加报案号，被保险人，车牌号(工作流需要添加)
		String strInsuredName = registDto.getPrpLregistDto().getInsuredName();
		swfLogDtoDealNode.setInsuredName(strInsuredName);
		if ( "4".equals(swfLogDtoDealNode.getNodeStatus())) {
			List<SwfLogDto> nextNodeList = new ArrayList<>();
			// 以上是从模板中读取的必须走的模板信息(注意，上面是节点号码，以下是客户自己选择的信息
			SwfLogDto swfLogNextNode = new SwfLogDto();
			swfLogNextNode.setNodeNo(0);
			swfLogNextNode.setNodeType("sched");
			swfLogNextNode.setScheduleId(1);
			swfLogNextNode.setTypeFlag(typeFlag);
			swfLogNextNode.setLossitemName(registDto.getPrpLregistDto().getLossName());
			swfLogNextNode.setHandlerName(userName);
			nextNodeList.add(swfLogNextNode);

			if (nextNodeList.size() > 0) {
				swfLogTransferDto.setNextNodeListType("1");
				// 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
				swfLogTransferDto.setSwfLogNextList(nextNodeList);
			}
		}

		// 获得待保存的workFLowDto
		swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
		WorkFlowDto workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
		// workFlowViewHelper.getWorkFlowDto(swfLogDtoDealNode);

		// 进行报案信息和工作流信息的保存
		Map<String, String> map = null;
		if (workFlowService.checkDealDto(workFlowDto)) {
			map = saveRegistDtoAndWorkFlowDto(registDto, workFlowDto);
		} else {
			if (workFlowDto.getOperateResult() < 0) {
				throw new BusinessException("注意:创建工作流流程时，未找到相关工作流模板的设置，请联系系统管理员进行相应配置！！");
			} else {
				this.saveRegistDto(registDto);
				throw new BusinessException(registNo + ";注意:没有发现与工作流流程相关任何数据！！");
			}

		}
		return map;
	}

	/**
	 * 
	 * @description 对registDto和工作流dto进行保存
	 * @author yk
	 * @date 2017年11月30日 下午3:10:25
	 * @param registDto 和工作流dto
	 * @return Map<String, String> 保单号和报案号
	 */
	private Map<String, String> saveRegistDtoAndWorkFlowDto(ReportDto registDto, WorkFlowDto workFlowDto) {
		// 判断数据库中是否有此报案号的案子，如果有则先删除再保存
		if (isExist(registDto.getPrpLregistDto().getRegistNo())) {
			delete(registDto.getPrpLregistDto().getRegistNo());
		}
		// 保存报案信息
		this.saveRegistDto(registDto);
		// 保存工作流信息
		try {
			workFlowService.deal(workFlowDto);
		} catch (Exception e) {
			throw new BusinessException("提交工作流失败！！");
		}
		PrpLRegistDto prpLregistDto = registDto.getPrpLregistDto();
		try {
		//  流程查询服务调用
			if("2".equals(registDto.getPrpLclaimStatusDto().getStatus())){
			workProcessService.saveWorkProcess(prpLregistDto.getPolicyNo(), prpLregistDto.getRegistNo(), null, null, prpLregistDto.getClassCode(), prpLregistDto.getRiskCode(), "regis","regis", AgriclaimWorkProcessEnum.未报案, SinoRequestContext.getCurrentContext().getUserCode());
			}
			if("4".equals(registDto.getPrpLclaimStatusDto().getStatus())){
				workProcessService.saveWorkProcess(prpLregistDto.getPolicyNo(), prpLregistDto.getRegistNo(), null, null, prpLregistDto.getClassCode(), prpLregistDto.getRiskCode(), "regis","sched", AgriclaimWorkProcessEnum.已报案, SinoRequestContext.getCurrentContext().getUserCode());
			}
			} catch (Exception e) {
			throw new BusinessException("保存到工作流程表失败！！");
		}
		// 如果保存成功的话返回保险号和报案号
		String policyNo = registDto.getPrpLregistDto().getPolicyNo();
		String registNo = registDto.getPrpLregistDto().getRegistNo();
		Map<String, String> map = new HashMap<>();
		map.put("policyNo", policyNo);
		map.put("registNo", registNo);
		return map;
	}

	/**
	 * 
	 * @description 根据页面传入的参数进行待保存的reportDto的修改和拼装
	 * @author yk
	 * @date 2017年11月30日 下午3:11:40
	 * @param registDto
	 * @return ReportDto 修改后的registDto
	 */
	private ReportDto getReportDto(ReportDto registDto) throws ParseException {

		// 组装报案主信息Dto
		PrpLRegistDtoExtend prpLregistDto = registDto.getPrpLregistDto();
		prpLregistDto.setDamageStartDate(new DateTime(prpLregistDto.getDamageStartDate(), DateTime.YEAR_TO_SECOND));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String damageStartDate = simpleDateFormat.format(prpLregistDto.getDamageStartDate());
		damageStartDate = damageStartDate.substring(0,10);
		damageStartDate = damageStartDate +" "+prpLregistDto.getDamageStartHour();
		prpLregistDto.setDamageStartDate(simpleDateFormat.parse(damageStartDate));
		prpLregistDto.setDamageEndDate(prpLregistDto.getDamageStartDate());
		prpLregistDto.setDamageEndHour(prpLregistDto.getDamageStartHour());
		prpLregistDto.setLFlag(prpLregistDto.getLlflag());
		prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate(), DateTime.YEAR_TO_SECOND));
		prpLregistDto.setReportDate(new DateTime(prpLregistDto.getReportDate(), DateTime.YEAR_TO_DAY));

		// 组装操作状态信息Dto
		PrpLclaimStatusDto prpLclaimStatusDto = registDto.getPrpLclaimStatusDto();
		prpLclaimStatusDto.setBusinessno(prpLregistDto.getRegistNo());
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
		userCode = "0000000000";
		prpLclaimStatusDto.setHandlercode(userCode);
		prpLclaimStatusDto.setNodetype("regis");
		prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimStatusDto.setPolicyno(prpLregistDto.getPolicyNo());
		prpLclaimStatusDto.setRiskcode(prpLregistDto.getRiskCode());
		prpLclaimStatusDto.setInputdate(prpLregistDto.getInputDate());

		// 组装强三关联信息Dto
		List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList = new ArrayList<>();
		PrpLRegistRPolicyDto prpLRegistRPolicyDto = new PrpLRegistRPolicyDto();
		prpLRegistRPolicyDto.setOperatorCode(userCode);
		prpLRegistRPolicyDto.setPolicyType("1");
		String usercomCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
		usercomCode = "0000000000";
		prpLRegistRPolicyDto.setRegistComCode(usercomCode);
		prpLRegistRPolicyDto.setRegistFlag("1");
		prpLRegistRPolicyDto.setRegistNo(prpLregistDto.getRegistNo());
		prpLRegistRPolicyDto.setRegistValidStatus("1");
		prpLRegistRPolicyDto.setValidStatus("1");
		prpLRegistRPolicyDto.setInputDate(prpLregistDto.getInputDate());
		prpLRegistRPolicyDto.setRiskCode(prpLregistDto.getRiskCode());
		prpLRegistRPolicyDto.setPolicyNo(prpLregistDto.getPolicyNo());
		prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto);
		registDto.setPrpLRegistRPolicyDtoList(prpLRegistRPolicyDtoList);

		// 组装文本信息Dto
		List<PrpLRegistTextDto> prpLregistTextDtoList = new ArrayList<>();
		String TextTemp = prpLregistDto.getContext();
		int RULE_LENGTH = 70;
		String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
		// 得到连接串,下面将其切分到数组
		if(rules!=null) {
			for (int k = 0; k < rules.length; k++) {
				PrpLRegistTextDto prpLregistTextDto = new PrpLRegistTextDto();
				prpLregistTextDto.setRegistNo(prpLregistDto.getRegistNo());
				prpLregistTextDto.setContext(rules[k]);
				prpLregistTextDto.setLineNo(k + 1);
				prpLregistTextDto.setTextType("1");
				prpLregistTextDtoList.add(prpLregistTextDto);
			}
		}
		registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

		// 组装出险原因详细信息Dto
		List<PrpLRegistTextDto> prpLregistTextDtoDetailList = new ArrayList<>();
		List<String> damageMessage = prpLregistDto.getDamageMessage();
		if (damageMessage != null) {
			for (int index = 0; index < damageMessage.size(); index++) {
				PrpLRegistTextDto prpLregistTextDto = new PrpLRegistTextDto();
				prpLregistTextDto.setRegistNo(prpLregistDto.getRegistNo());
				prpLregistTextDto.setLineNo(index + 1);
				prpLregistTextDto.setContext(damageMessage.get(index));
				prpLregistTextDto.setTextType("06");
				prpLregistTextDtoDetailList.add(prpLregistTextDto);
			}
		}
		registDto.setPrpLregistTextDtoDetailList(prpLregistTextDtoDetailList);

		// 组装调度表的信息Dto
		List<PrpLScheduleItemDto> prplScheduleItemDtoList = new ArrayList<>();
		PrpLScheduleItemDto prpLScheduleItemDto = new PrpLScheduleItemDto();
		prpLScheduleItemDto.setInputDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		prpLScheduleItemDto.setSurveyTimes(0);
		prpLScheduleItemDto.setItemNo(-2);
		prpLScheduleItemDto.setLicenseNo("财产损失");
		prpLScheduleItemDto.setNextNodeNo("certa");
		prpLScheduleItemDto.setRegistNo(prpLregistDto.getRegistNo());
		prpLScheduleItemDto.setScheduleId(1);
		prpLScheduleItemDto.setScheduleObjectId("_");
		prpLScheduleItemDto.setScheduleType("sched");
		prpLScheduleItemDto.setSurveyType("1");
		prpLScheduleItemDto.setCheckSite(prpLregistDto.getDamageAddress());
		prplScheduleItemDtoList.add(prpLScheduleItemDto);
		registDto.setPrplScheduleItemDtoList(prplScheduleItemDtoList);

		// 组装调度主表的信息Dto
		PrpLScheduleMainWfDto prpLscheduleMainWFDto = registDto.getPrpLScheduleMainWfDto();
		prpLscheduleMainWFDto.setCheckFlag("0");
		prpLscheduleMainWFDto.setInputHour(DateTime.current().getHour());
		prpLscheduleMainWFDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLscheduleMainWFDto.setRegistNo(prpLregistDto.getRegistNo());
		// 查勘调度没有被派出去的
		prpLscheduleMainWFDto.setScheduleFlag("0");
		prpLscheduleMainWFDto.setScheduleId(1);
		prpLscheduleMainWFDto.setScheduleObjectId("_");
		prpLscheduleMainWFDto.setCheckSite(prpLregistDto.getDamageAddress());
		prpLscheduleMainWFDto.setClaimcomCode(prpLregistDto.getComCode());
		prpLscheduleMainWFDto.setPolicyNo(prpLregistDto.getPolicyNo());
		prpLscheduleMainWFDto.setRiskCode(prpLregistDto.getRiskCode());

		// 组装耳标号表的信息Dto
		if (registDto.getPrpLCompensateEarDtoList() != null) {
			for (PrpLCompensateEarRegistDto prplCompensateEarDto : registDto.getPrpLCompensateEarDtoList()) {
				prplCompensateEarDto.setNodeNo(1);
				prplCompensateEarDto.setNodeType("regis");
				prplCompensateEarDto
						.setDamageStartDate(new DateTime(prpLregistDto.getDamageStartDate(), DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setBusinessNo(prpLregistDto.getRegistNo());
				prplCompensateEarDto.setRegistNo(prpLregistDto.getRegistNo());
				prplCompensateEarDto.setFCode(prplCompensateEarDto.getCode());
				prplCompensateEarDto.setDamageCode(prpLregistDto.getDamageCode());
				prplCompensateEarDto.setDamageName(prpLregistDto.getDamageName());
				prplCompensateEarDto.setPolicyNo(prpLregistDto.getPolicyNo());
				prplCompensateEarDto.setRegistNo(prpLregistDto.getRegistNo());
				prplCompensateEarDto.setBusinessNo(prpLregistDto.getRegistNo());
				prplCompensateEarDto.setReportTime(prpLregistDto.getReportDate().toString());
			}
		}

		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("组装要保存的报案信息dto");
		}
		return registDto;
	}

	/**
	 * 
	 * @description 根据报案号进行几个表的数据的删除
	 * @author yk
	 * @date 2017年11月30日 下午3:12:37
	 * @param registNo 报案号
	 */
	public void delete(String registNo) {
		registNo = StringUtils.rightTrim(registNo);
		// 删除相关的报案信息
		prplRegistDao.deleteByRegistNo(registNo);
		prpRegistRPolicyDao.deleteByRegistNo(registNo);
		prplregisttextDao.deleteByRegistNo(registNo);
		prplScheduleMainWfDao.deleteByRegistNo(registNo);
		prplScheduleItemDao.deleteByRegistNo(registNo);
		claimStatusDao.deleteByBusinessno(registNo);
		prpLCompensateEarDao.deleteByRegistNoAndNodeType(registNo, "regis");
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("删除原有的报案==报案号==" + registNo);
		}
	}

	/**
	 * 
	 * @description:先拿报案号去查询，看是否有已经存在的报案
	 * @author yk
	 * @date 2017年11月30日 下午3:13:27
	 * @param:String registNo
	 * @return:报案是否已经存在
	 */
	public boolean isExist(String registNo) {
		long count = prplRegistDao.findCountByRegistno(registNo);
		if (count < 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @description 保存报案信息到数据库
	 * @author yk
	 * @date 2017年11月30日 下午3:14:04
	 * @param reportDto 报案dto
	 */
	private void saveRegistDto(ReportDto reportDto) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("保存报案信息到数据库");
		}
		// 组装报案主信息Dto
		PrpLRegistDto prpLregistDto = reportDto.getPrpLregistDto();
		PrpLRegist prplRegist = convert(prpLregistDto, PrpLRegist.class);
		prplRegistDao.save(prplRegist);
		List<PrpLRegistTextDto> prpLregistTextDtoList = reportDto.getPrpLregistTextDtoList();
		List<PrpLRegistText> PrplregisttextList = new ArrayList<>(prpLregistTextDtoList.size());
		convertCollection(prpLregistTextDtoList, PrplregisttextList, PrpLRegistText.class);
		prplregisttextDao.save(PrplregisttextList);

		List<PrpLRegistTextDto> prpLregistTextDtoDetailList = reportDto.getPrpLregistTextDtoDetailList();
		if (prpLregistTextDtoDetailList != null && prpLregistTextDtoDetailList.size() > 0) {
			List<PrpLRegistText> prplregisttextDetailList = new ArrayList<>(prpLregistTextDtoDetailList.size());
			convertCollection(prpLregistTextDtoDetailList, prplregisttextDetailList, PrpLRegistText.class);
			prplregisttextDao.save(prplregisttextDetailList);
		}

		List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList = reportDto.getPrpLRegistRPolicyDtoList();
		List<PrpLRegistRPolicy> PrpLRegistRPolicyList = new ArrayList<>(prpLRegistRPolicyDtoList.size());
		convertCollection(prpLRegistRPolicyDtoList, PrpLRegistRPolicyList, PrpLRegistRPolicy.class);
		prpRegistRPolicyDao.save(PrpLRegistRPolicyList);

		List<PrpLScheduleItemDto> prplScheduleItemDtoList = reportDto.getPrplScheduleItemDtoList();
		ArrayList<PrpLScheduleItem> PrpLScheduleItemList = new ArrayList<>(prplScheduleItemDtoList.size());
		convertCollection(prplScheduleItemDtoList, PrpLScheduleItemList, PrpLScheduleItem.class);
		prplScheduleItemDao.save(PrpLScheduleItemList);

		String registNo = reportDto.getPrpLregistDto().getRegistNo();
		claimStatusDao.deleteByBusinessnoAndNodetype(registNo, "regis");
		reportDto.getPrpLclaimStatusDto().setSerialno(0);
		claimStatusDao.save(convert(reportDto.getPrpLclaimStatusDto(), PrpLclaimStatus.class));
		reportDto.getPrpLScheduleMainWfDto().setSurveyNo(0);
		prplScheduleMainWfDao.save(convert(reportDto.getPrpLScheduleMainWfDto(), PrpLScheduleMainWf.class));

		if (reportDto.getPrpLCompensateEarDtoList() != null) {
			List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList = reportDto.getPrpLCompensateEarDtoList();
			List<PrpLCompensateEar> prpLCompensateEarList = new ArrayList<>(prpLCompensateEarDtoList.size());
			convertCollection(prpLCompensateEarDtoList, prpLCompensateEarList, PrpLCompensateEar.class);
			prpLCompensateEarDao.save(prpLCompensateEarList);
		}

		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("进行报案信息的保存,保单号====" + reportDto.getPrpLregistDto().getPolicyNo() + "===报案号:==="
					+ reportDto.getPrpLregistDto().getRegistNo() + "===");
		}
	}

	/**
	 * 
	 * @description:报案撤销方法
	 * @param:prpLRegistDto
	 * @return:ResponseDto
	 * @throws:Exception
	 * @author:yk
	 * @date:2017年11月28日下午17:14:09
	 */
	@Override
	public Map<String, String> cancelReport(PrpLRegistDtoExtend prpLRegistDto) {
		// 得到报案号
		String registNo = prpLRegistDto.getRegistNo();
		if (!isExist(registNo)) {
			Map<String, String> map = new HashMap<>();
			map.put("message", "没有接收到合法的报案号！");
			return map;
		}
		WorkFlowDto workFlowDto = new WorkFlowDto();
		// 保存立案拒赔注销信息
		// 以下为工作流使用中的
		// 得到流程编号
		String swfLogFlowID = "";
		List<SwfLog> swfLogList = swfLogDao.findByBusinessNoAndNodeType(registNo, "regis");
		Iterator<SwfLog> it = swfLogList.iterator();
		SwfLogDto swfLogDto = new SwfLogDto();
		while (it.hasNext()) {
			swfLogDto = convert(it.next(), SwfLogDto.class);
			swfLogFlowID = swfLogDto.getFlowId();
		}
		String swfLogLogNo = "1"; // 工作流logno黙认为1
		SwfLogDto swfLogDtoDealNode = new SwfLogDto();

		String allCancleFlag = "1";
		if (allCancleFlag.equals("1")) {
			// 需要检查是否有已经立案的，但是是正常的立案的情况。。。
			List<PrpLClaim> prpLclaimList = prpLclaimDao.findByRegistNoAndCancelDateNull(registNo);
			if (prpLclaimList != null && prpLclaimList.size() > 0) {
				Map<String, String> map = new HashMap<>();
				map.put("message", "此报案目前有" + prpLclaimList.size() + "保单已经立案，请做完此保单的立案注销后，再进行报案的全部注销！");
				return map;
			}
			if (swfLogFlowID != null && swfLogLogNo != null && !swfLogFlowID.equals("null")
					&& !swfLogLogNo.equals("null")) {
				swfLogDtoDealNode.setFlowId(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
			}
			swfLogDtoDealNode.setNodeStatus("4");
			swfLogDtoDealNode.setEndFlag("1");

			SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
			swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);

			workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
		}
		if (workFlowService.checkDealDto(workFlowDto)) {
			// 设置本节点为注销状态 
			if (workFlowDto.getUpdateSwfLogDto() != null) {
				workFlowDto.getUpdateSwfLogDto().setNodeStatus("6"); // 撤消的流程
			}
			saveRegistCancel(prpLRegistDto, workFlowDto);
		} else {
			saveRegistCancel(prpLRegistDto, null);
		}

		Map<String, String> map = new HashMap<>();
		map.put("message", "报案撤销成功！！");
		return map;
	}


	/**
	 * 
	 * @description 报案撤销对prpLRegistDto和workFlowDto进行保存
	 * @param prpLRegistDto
	 * @param workFlowDto
	 * @author 杨昆
	 * @date 2017年11月28日下午17:14:09
	 */
	private void saveRegistCancel(PrpLRegistDtoExtend prpLRegistDto, WorkFlowDto workFlowDto) {

		String registNo = prpLRegistDto.getRegistNo();

		String comCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
		comCode = "0000000000";
		PrpLRegist prpLRegist = prplRegistDao.findByRegistNo(registNo);
		if (prpLRegist == null) {
			throw new BusinessException("没有报案信息");
		}
		prpLRegist.setCancelDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
		userCode = "0000000000";
		prpLRegist.setDealerCode(userCode);
		prplRegistDao.flush();
		prpRegistRPolicyDao.updateCancelReport("", "", StringUtils.rightTrim(registNo));
		List<PrpLRegistRPolicy> prpLRegistRPolicyList = prpRegistRPolicyDao.findByRegistNoAndValidStatus(registNo, "1");
		// 加入报案关联表的关联
		if (prpLRegistRPolicyList != null) {
			for (int i = 0; i < prpLRegistRPolicyList.size(); i++) {
				PrpLRegistRPolicy prpLRegistRPolicy = prpLRegistRPolicyList.get(i);
				prpLRegistRPolicy.setRegistValidStatus("0");
				prpLRegistRPolicy.setValidStatus("0");
				prpLRegistRPolicy.setCancelOperaterCode(userCode);
				prpLRegistRPolicy.setCancelComCode(comCode);
				// prpLRegistRPolicy.setCancelReason(registDto.getPrpLregistDto().getCancelReason());
				// prpLRegistRPolicy.setCancelReasonName(registDto.getPrpLregistDto().getCancelReasonName());

				prpLRegistRPolicy.setCancelDate(prpLRegist.getCancelDate().toString());
				prpLRegistRPolicyList.set(i, prpLRegistRPolicy);
			}

			prpRegistRPolicyDao.save(prpLRegistRPolicyList);
		}

		// 保存报案注销原因
		prplregisttextDao.deleteByRegistNoAndTextType(StringUtils.rightTrim(registNo), "2");

		List<PrpLRegistTextDto> prpLregistTextDtoList = new ArrayList<>();
		String textTemp = prpLRegistDto.getContext();
		String linecr = "\r\n";
		String[] rules = StringGyUtils.split(textTemp, linecr);
		for (int k = 0; k < rules.length; k++) {
			PrpLRegistTextDto prplregisttextDto = new PrpLRegistTextDto();
			prplregisttextDto.setRegistNo(registNo);
			prplregisttextDto.setContext(rules[k]);
			prplregisttextDto.setLineNo(k + 1);
			prplregisttextDto.setTextType("2");
			prpLregistTextDtoList.add(prplregisttextDto);
		}

		List<PrpLRegistText> prpLregistTextList = new ArrayList<>(prpLregistTextDtoList.size());
		convertCollection(prpLregistTextDtoList, prpLregistTextList, PrpLRegistText.class);
		prplregisttextDao.save(prpLregistTextList);

		if (workFlowDto != null) {
			try {
				workFlowService.deal(workFlowDto);
			} catch (Exception e) {
				throw new BusinessException("提交工作流失败！！");
			}
		}

	}


	/**
	 * 金禾调用的报案登记接口
	 * @param registDto 报案对象
	 * @return map 返参对象
	 * @author 王保良
	 * @throws Exception
	 * @date:2017年10月28日下午12:53:31
	 */
	@Override
	public Map<String, String> gisSaveReport(AgriRegistDto agriRegistDto) throws Exception {
		if (agriRegistDto == null){
			throw new DataVerifyException("报案对象不能为空");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ReportDto reportDto = new ReportDto();
		//组装prplClaimStatus对象
		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		prpLclaimStatusDto.setStatus("4");

		//组装prpLregistDto对象
		PrpLRegistDtoExtend prpLRegistDto = new PrpLRegistDtoExtend();
		//todo 这个llflag是干什么的?
        prpLRegistDto.setLlflag("L");
		prpLRegistDto.setContext(agriRegistDto.getTextContext());
		prpLRegistDto.setDamageMessage(agriRegistDto.getDamageMessage());
		prpLRegistDto.setClassCode(agriRegistDto.getRiskCode().substring(0,2));
		prpLRegistDto.setRiskCode(agriRegistDto.getRiskCode());
		prpLRegistDto.setPolicyNo(agriRegistDto.getPolicyNo());
		prpLRegistDto.setLanguage("C");

		//todo 清单信息组装
//		prpLRegistDto.setInsuredCode();
//		prpLRegistDto.setInsuredName();
//		prpLRegistDto.setInsuredAddress();


		prpLRegistDto.setReportDate(simpleDateFormat.parse(agriRegistDto.getReportDate()));
		prpLRegistDto.setReportHour(agriRegistDto.getReportHour());
		prpLRegistDto.setReportorName(agriRegistDto.getReportorName());
		prpLRegistDto.setPhoneNumber(agriRegistDto.getPhoneNumber());
		prpLRegistDto.setLinkerName(agriRegistDto.getLinkerName());
		prpLRegistDto.setDamageStartDate(simpleDateFormat.parse(agriRegistDto.getDamageStartDate()));
		prpLRegistDto.setDamageStartHour(agriRegistDto.getDamageStartHour());
		prpLRegistDto.setDamageEndDate(simpleDateFormat.parse(agriRegistDto.getDamageStartDate()));
		prpLRegistDto.setDamageEndHour(agriRegistDto.getDamageStartHour());
		prpLRegistDto.setDamageCode(agriRegistDto.getDamageCode());
		prpLRegistDto.setFirstSiteFlag("0");
		prpLRegistDto.setAddressCode(agriRegistDto.getAddressCode());
		prpLRegistDto.setDamageAddress(agriRegistDto.getDamageAddress());
		prpLRegistDto.setLossName(agriRegistDto.getLossName());
		prpLRegistDto.setEsticurrency(agriRegistDto.getEstiCurrency());
		prpLRegistDto.setEstimateLoss(agriRegistDto.getEstimateLoss());
		//todo
		prpLRegistDto.setHandlerCode(agriRegistDto.getOperatorCode());
		prpLRegistDto.setHandler1Code(agriRegistDto.getOperatorCode());
		prpLRegistDto.setComCode("3400000000");
		prpLRegistDto.setInputDate(simpleDateFormat.parse("2018-05-06"));
		prpLRegistDto.setAcceptFlag("Y");
		prpLRegistDto.setRepeatInsureFlag("N");
		prpLRegistDto.setRemark(agriRegistDto.getRemark());
		prpLRegistDto.setOperatorCode(agriRegistDto.getOperatorCode());
		prpLRegistDto.setMakeCom(agriRegistDto.getMakeCom());
		prpLRegistDto.setCatastropheCode1(agriRegistDto.getCatastropheCode1());
		prpLRegistDto.setCatastropheName2(agriRegistDto.getCatastropheName2());
		prpLRegistDto.setLossesNumber(agriRegistDto.getLossesNumber());
		prpLRegistDto.setBusinessType("01");
		prpLRegistDto.setBusinessType1("00");
		prpLRegistDto.setBusinessFlag("0");




		//将对象放入reportDto中
		reportDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		reportDto.setPrpLregistDto(prpLRegistDto);



		Map<String, String> map=saveReport(reportDto);
		return map;
	}
}