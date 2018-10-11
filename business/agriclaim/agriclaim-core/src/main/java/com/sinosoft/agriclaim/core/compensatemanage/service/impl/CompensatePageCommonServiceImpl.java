package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLAcciCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheck;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCTextDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLChargeDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLLossDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.*;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensatePageCommonService;
import com.sinosoft.agriclaim.core.individuation.dao.PrpLsumpayDao;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpay;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.recasemanage.dao.PrpLRecaseDao;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecaseKey;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriprpall.api.policymanage.PrpCengageApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description: 类功能简述：理算页面初始化公共服务实现类
 * @author 安齐崇
 * @date 2017年11月30日下午7:46:53
 *
 */
@Service
public class CompensatePageCommonServiceImpl extends BaseServiceImpl implements CompensatePageCommonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompensatePageCommonServiceImpl.class);
	@Autowired
	private PrpLRecaseDao PrpLRecaseDao;
	@Autowired
	private PrpLCompensateDao prpLCompensateDao;
	@Autowired
	private PrpLAcciCheckDao prpLacciCheckDao;
	@Autowired
	private PrpLPrepayDao prpLPrepayDao;
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private PrpLPropDao prpLPropDao;
	@Autowired
	private PrpLAccIPersonDao prpLAccIPersonDao;
	@Autowired
	private PrpDkindApi prpDkindApi;
	@Autowired
	private PrpDcurrencyApi prpDcurrencyApi;
    @Autowired
    private PrpLLossDao prpLLossDao; 
    @Autowired
    private PrpLChargeDao prpLChargeDao;
    @Autowired
    private PrpLCTextDao prpLCTextDao;
    @Autowired
    private PrpLLTextDao prpLLTextDao;
    @Autowired
    private PrpCengageApi prpCengageApi;
    @Autowired
    private PrpLsumpayDao prpLsumpayDao;
	@Override
	public void prePareCommonHead(CompensatePageResponseDto responseDto) {
		/* 特殊赔案标志 */
		String caseType = responseDto.getCaseType();
		String registNo = responseDto.getPrpLClaimDto().getRegistNo();
		String editType = responseDto.getEditType();
		String claimNo = responseDto.getClaimNo();
		String compensateNo = responseDto.getCompensateNo();
		PrpLClaimDto prpLClaimDto = responseDto.getPrpLClaimDto();
		/* 查询重开赔案信息 */
		int recount = 0;
		double sumDamageInsured = 0.00;
		double dbSumPaid = 0.00;
		double dbLossNumber = 0.00;
		double dbSumDutyPaid = 0.00;
		PrpLRecase prpLrecase = PrpLRecaseDao.findOne(new PrpLRecaseKey(claimNo, 1));
		if (prpLrecase != null && prpLrecase.getClaimNo() != null && prpLrecase.getClaimNo().trim().length() > 0) {
			recount = 1;
			Specification<PrpLCompensate> spec = Specifications.<PrpLCompensate> and().eq("claimNo", claimNo)
					.in("underWriteFlag", "1", "3").build();
			List<PrpLCompensate> compensateList = prpLCompensateDao.findAll(spec);
			for (int index = 0; index < compensateList.size(); index++) {
				PrpLCompensate prplcompensate = compensateList.get(index);
				sumDamageInsured += prplcompensate.getDamageInsured();
				dbSumPaid += prplcompensate.getSumPaid();
				dbLossNumber += prplcompensate.getLossesNumber();
				dbSumDutyPaid += prplcompensate.getSumDutyPaid();
			}
		}
		responseDto.setSumDamageInsured(sumDamageInsured + "");
		responseDto.setDbSumPaid(dbSumPaid + "");
		responseDto.setDbLossNumber(dbLossNumber + "");
		responseDto.setDbSumDutyPaid(dbSumDutyPaid + "");
		responseDto.setRecaseFlag(String.valueOf(recount));
		/* 查询重开赔案信息结束 */
		/* 设置预赔信息 */
		double sumPrePaid = 0.0;
		double preSosMedicFee = 0.0;
		if (recount < 1) {
			List<PrpLPrepay> prepayList = prpLPrepayDao
					.findAll(Specifications.<PrpLPrepay> and().eq("claimNo", claimNo).build());
			String underWriteFlag = "";
			if (prepayList != null) {
				for (Iterator<PrpLPrepay> its = prepayList.iterator(); its.hasNext();) {
					PrpLPrepay prpLPrepay = its.next();
					underWriteFlag = prpLPrepay.getUnderWriteFlag();
					if (underWriteFlag.equals("1") || underWriteFlag.equals("3")) {
						sumPrePaid += prpLPrepay.getSumPrepaid();
						preSosMedicFee += prpLPrepay.getSumPrechargePaid();
					} else {
						if (LOGGER.isInfoEnabled()) {
							LOGGER.error("还有未核赔通过的预赔案件,不能立案！");
						}
						throw new BusinessException("还有未核赔通过的预赔案件,不能立案！");
					}
				}
			}
		}
		PrpLCompensateDtoExt prpLCompensateDtoExt = null;
		/* 根据编辑类型组织赔款计算书主信息，初始化理算页面头信息 */
		if ("ADD".equals(editType)) {
			prpLCompensateDtoExt = new PrpLCompensateDtoExt();
			;
			double sumCheckFee = 0.00;
			List<PrpLAcciCheck> prpLAcciCheckList = prpLacciCheckDao
					.findAll(Specifications.<PrpLAcciCheck> and().eq("registNo", registNo).build());
			for (int i = 0; prpLAcciCheckList != null && i < prpLAcciCheckList.size(); i++) {
				sumCheckFee = sumCheckFee + prpLAcciCheckList.get(i).getCheckFee();
			}
			prpLCompensateDtoExt.setSumCheckFee(sumCheckFee);
			/* 特殊赔案标志 */
			if (caseType != null) {
				prpLCompensateDtoExt.setCaseType(caseType);

			} else {
				/* 正常的流程，进行赔付 */
				prpLCompensateDtoExt.setCaseType("2");
			}
			/* 设置特有属性，其它通过属性拷贝填充 */
			prpLCompensateDtoExt.setTimes(1);
			prpLCompensateDtoExt.setPreserveDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			prpLCompensateDtoExt.setUnderWriteFlag("0");
			prpLCompensateDtoExt.setUnderWriteFlag("0");
			
			prpLCompensateDtoExt.setStatisticSym(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			prpLCompensateDtoExt
					.setUnderWriteEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			prpLCompensateDtoExt.setCoinsSumPaid(0d);
			prpLCompensateDtoExt.setCoinsSelfSumPaid(0d);
			prpLCompensateDtoExt.setCoinsOtherPaid(0d);
			prpLCompensateDtoExt.setSumPrePaid(sumPrePaid);
			prpLCompensateDtoExt.setSumPreChargeAmount(preSosMedicFee);
			prpLCompensateDtoExt.setClaimNotification("1");
			prpLCompensateDtoExt.setFinallyFlag("1");
			prpLCompensateDtoExt.setInncentTreatment("1");
			prpLCompensateDtoExt.setLawsuitFlag("0");
			prpLCompensateDtoExt.setSumDutyPaid(0.0d);
			prpLCompensateDtoExt.setSumNoDutyFee(0.0d);
			prpLCompensateDtoExt.setSumPaid(0.0d);
			prpLCompensateDtoExt.setSumPrepaid(0.0d);
			prpLCompensateDtoExt.setSumThisPaid(0.0d);
			/* 从立案信息中获取并填充赔案信息 */
		} else {
			prpLCompensateDtoExt = responseDto.getPrpLCompensateDtoExt();
			double sumPaid = 0d;
			double sumDutyPaid = 0d;
			double sumThisPaid = 0d;
			sumPaid = prpLCompensateDtoExt.getSumPaid();
			sumDutyPaid = prpLCompensateDtoExt.getSumDutyPaid();
			sumThisPaid = prpLCompensateDtoExt.getSumThisPaid();
			List<PrpLCharge> PrpLChargeList = prpLChargeDao
					.findAll(Specifications.<PrpLCharge> and().eq("compensateNo", compensateNo).build());
			for (int i = 0; PrpLChargeList != null && i < PrpLChargeList.size(); i++) {
				PrpLCharge prpLchargeDto = PrpLChargeList.get(i);
				if ("28".equals(prpLchargeDto.getChargeCode())) {
					sumPaid -= prpLchargeDto.getChargeAmount();
					sumDutyPaid -= prpLchargeDto.getChargeAmount();
					sumThisPaid -= prpLchargeDto.getChargeAmount();
				}
			}
			prpLCompensateDtoExt.setSumPaid(sumPaid);
			prpLCompensateDtoExt.setSumDutyPaid(sumDutyPaid);
			prpLCompensateDtoExt.setSumThisPaid(sumThisPaid);
			prpLCompensateDtoExt.setSumPrePaid(sumPrePaid);
			prpLCompensateDtoExt.setSumPreChargeAmount(preSosMedicFee);
		}
		prpLCompensateDtoExt.setHandlerCode(responseDto.getUserCode());
		prpLCompensateDtoExt.setHandlerName(responseDto.getUserName());
		pageInitCommonService.copyPropertiesIfNull(prpLClaimDto, prpLCompensateDtoExt);
		prpLCompensateDtoExt.setDamageDate(new DateTime(prpLClaimDto.getDamageStartDate()).toString());
		responseDto.setPrpLCompensateDtoExt(prpLCompensateDtoExt);

	}

	@Override
	public void prepareCommonParam(CompensatePageResponseDto responseDto) {
		/* 设置特别约定信息 */
		this.setCengageMessage(responseDto);
	}

	/**
	 * @description:方法功能简述: 设置特别约定信息到返参对象
	 * @author 安齐崇
	 * @date 2017年12月1日下午7:50:07
	 * @param responseDto
	 */
	private void setCengageMessage(CompensatePageResponseDto responseDto) {
		/*
		 * Collection arrayList = new ArrayList(); PrpCengageDto prpCengageDto =
		 * new PrpCengageDto(); arrayList =
		 * compensateDto.getPrpCengageDtoList(); ArrayList cengageListTemp = new
		 * ArrayList(); if (arrayList != null) { Iterator iteratorCengage =
		 * arrayList.iterator(); while (iteratorCengage.hasNext()) {
		 * PrpCengageDto prpCengageDtoTemp = (PrpCengageDto)
		 * iteratorCengage.next(); if (prpCengageDtoTemp.getClauseCode() != null
		 * && prpCengageDtoTemp.getClauseCode().length() > 0 &&
		 * prpCengageDtoTemp.getClauseCode().charAt(0) == 'T' //&&
		 * prpCengageDtoTemp.getClauseCode().charAt(1)!= 'X' ) {
		 * cengageListTemp.add(prpCengageDtoTemp); } } boolean cFlag = false;
		 * arrayList = new ArrayList(); arrayList.addAll(cengageListTemp);
		 * cengageListTemp = new ArrayList(); iteratorCengage =
		 * arrayList.iterator(); PrpCengageDto prpCengageDtoTemp1 = new
		 * PrpCengageDto(); while (iteratorCengage.hasNext()) { PrpCengageDto
		 * prpCengageDtoTemp = (PrpCengageDto) iteratorCengage.next(); if
		 * (prpCengageDtoTemp.getTitleFlag().equals("0")) { cFlag = true;
		 * cengageListTemp.add(prpCengageDtoTemp1); prpCengageDtoTemp1 = new
		 * PrpCengageDto(); PropertyUtils.copyProperties(prpCengageDtoTemp1,
		 * prpCengageDtoTemp); } else {
		 * prpCengageDtoTemp1.setContext(prpCengageDtoTemp1.getContext() +
		 * prpCengageDtoTemp.getClauses() + "<br>"); } }
		 * cengageListTemp.add(prpCengageDtoTemp1); if (cengageListTemp.size() >
		 * 0) { cengageListTemp.remove(0); } }
		 * prpCengageDto.setPrpCengageList(cengageListTemp);
		 * 
		 * httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);
		 */
	}

	@Override
	public void prepareCommonPrpLLoss(CompensatePageResponseDto responseDto) {
		String editType = responseDto.getEditType();
		String recaseFlag = responseDto.getRecaseFlag();
		String compensateNo = responseDto.getCompensateNo();
		List<PrpLLossDtoExt> initPropLossList = null;
		/* 初始化标的从定损带数据 条件：新增理算并且不是重开赔案的理算 */
		if (editType.trim().equals("ADD") && "1".equals(recaseFlag)) {
			// 标的损失信息带数
			initPropLossList= initPropLossItemAgri(responseDto);
		}
		if("EDIT".equals(editType)){
			
			List<PrpLLoss> prpLlossDtoList = prpLLossDao.findAll(Specifications.<PrpLLoss>and().eq("compensateNo", compensateNo).build());
			initPropLossList = new ArrayList<>();
				for (int i = 0; prpLlossDtoList!=null &&i< prpLlossDtoList.size(); i++) {
					PrpLLoss prpLloss = prpLlossDtoList.get(i);
					PrpLLossDtoExt prpLLossEXt = new PrpLLossDtoExt();
					PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpLloss.getRiskCode(), prpLloss.getKindCode());
					String kindName = prpDkindDto == null ? "" : prpDkindDto.getKindCName();
					PrpDcurrencyDto currencyDto =null;// prpDcurrencyApi.queryByPK(prpLloss.getCurrency());
					String currencyName = currencyDto == null ? "" : currencyDto.getCurrencyCName();
					prpLLossEXt.setKindName(kindName);
					prpLLossEXt.setCurrency1Name(currencyName);
					prpLLossEXt.setCurrency2Name(currencyName);
					prpLLossEXt.setCurrency3Name(currencyName);
					prpLLossEXt.setCurrency4Name(currencyName);
					pageInitCommonService.copyPropertiesIfNull(prpLloss, prpLLossEXt);
					initPropLossList.add(prpLLossEXt);
				}
			}
		responseDto.setPrpLLossDtoExtList(initPropLossList);
	}

	/**
	 * @description:方法功能简述: 初始化赔付标的信息
	 * @author 安齐崇
	 * @date 2017年12月2日下午3:07:20
	 * @param responseDto 封装返参的对象
	 * @return prpLLossDtoExtList 赔付信息集合
	 */
	public List<PrpLLossDtoExt> initPropLossItemAgri(CompensatePageResponseDto responseDto) {
		String riskCode = responseDto.getRiskCode();
		String registNo = responseDto.getRegistNo();
		String claimNo = responseDto.getClaimNo();
		String properties = pageInitCommonService.getConfigRules("CREATE_VIRTUALITEM_RISK", "prpall");
		boolean isVirturlItemRisk = properties.indexOf(riskCode) > -1;
		List<PrpLLossDtoExt> prpLLossDtoExtList = new ArrayList<>();
		List<PrpLProp> prpLPropList = prpLPropDao
				.findAll(Specifications.<PrpLProp> and().eq("registNo", registNo).eq("claimNo", claimNo).build());
		int serialNo = 1;
		for (int i = 0; prpLPropList != null && i < prpLPropList.size(); i++) {
			Map<String, String> tempMap = new HashMap<String, String>();
			PrpLProp prpLProp = prpLPropList.get(i);
			PrpLLossDtoExt prpLLossDtoTemp = new PrpLLossDtoExt();
			List<Object> itemKindList = new ArrayList<Object>();
			String itemKindNoFlag = prpLProp.getFamilyName();
			String lossItemCode = prpLProp.getLossItemCode();
			String strItemDetailName = "";
			double dbAmount = 0.0;
			if (isVirturlItemRisk) {

			} else {

			}
			List<PrpLAccIPerson> acciPersonList = prpLAccIPersonDao
					.findAll(Specifications.<PrpLAccIPerson> and().eq("certiNo", claimNo).eq("flag", 1).build());
			for (Iterator<PrpLAccIPerson> it = acciPersonList.iterator(); it.hasNext();) {
				PrpLAccIPerson acciPersonDto = it.next();
				if (!"3202".equals(prpLProp.getRiskCode())) {
					if (acciPersonDto.getFamilyNo() == prpLProp.getFamilyNo()) {
						serialNo = acciPersonDto.getSerialNo();
					}
				} else {
					if (acciPersonDto.getAddress().equals(prpLProp.getFamilyName())) {
						serialNo = acciPersonDto.getSerialNo();
					}
				}

			}
			if (tempMap.get(itemKindNoFlag) != null) {
				int prpLlossDtoTempNo = Integer.parseInt((String) tempMap.get(itemKindNoFlag));
				prpLLossDtoTemp.setKindCode(prpLProp.getKindCode());
				prpLLossDtoTemp.setRiskCode(prpLProp.getRiskCode());
				PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpLProp.getRiskCode(), prpLProp.getKindCode());
				String kindName = prpDkindDto == null ? "" : prpDkindDto.getKindCName();
				prpLLossDtoTemp.setKindName(kindName);
				prpLLossDtoTemp.setItemCode(prpLProp.getItemCode());
				if ("3204".equals(riskCode)) {
					prpLLossDtoTemp.setLossName(prpLProp.getLossItemName());
				} else {
					prpLLossDtoTemp.setLossName(strItemDetailName);
				}
				prpLLossDtoTemp = (PrpLLossDtoExt) prpLLossDtoExtList.get(prpLlossDtoTempNo);
				prpLLossDtoTemp.setSumLoss(prpLLossDtoTemp.getSumLoss() + prpLProp.getSumLoss());
				prpLLossDtoTemp.setSumRest(prpLLossDtoTemp.getSumRest() + prpLProp.getSumReject());
				prpLLossDtoTemp.setSumrealPay(prpLLossDtoTemp.getSumLoss() - prpLLossDtoTemp.getSumRest());
				if ("3204".equals(riskCode)) {
					PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
					itemKindList = null;
					for (Iterator it = itemKindList.iterator(); it.hasNext();) {
						itemKindDto = (PrpCitemKindDto) it.next();
						if (itemKindDto.getKindCode().equals(prpLProp.getKindCode())
								&& itemKindDto.getItemCode().equals(prpLProp.getItemCode()))
							prpLLossDtoTemp.setAmount(itemKindDto.getAmount());
					}
				} else {
					prpLLossDtoTemp.setAmount(dbAmount);
				}
				prpLLossDtoTemp.setPolicyNo(prpLProp.getPolicyNo());
				prpLLossDtoTemp.setFamilyNo(prpLProp.getFamilyNo());
			} else {

				prpLLossDtoTemp.setKindCode(prpLProp.getKindCode());
				PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpLProp.getRiskCode(), prpLProp.getKindCode());
				String kindName = prpDkindDto == null ? "" : prpDkindDto.getKindCName();
				PrpDcurrencyDto currencyDto = prpDcurrencyApi.queryByPK(prpLProp.getCurrency());
				String currencyName = currencyDto == null ? "" : currencyDto.getCurrencyCName();
				prpLLossDtoTemp.setSerialNo(serialNo);
				if ("3204".equals(riskCode)) {
					prpLLossDtoTemp.setLossName(prpLProp.getLossItemName());
				} else {
					prpLLossDtoTemp.setLossName(strItemDetailName);
				}
				prpLLossDtoTemp.setRiskCode(prpLProp.getRiskCode());
				prpLLossDtoTemp.setKindName(kindName);
				prpLLossDtoTemp.setItemCode(prpLProp.getItemCode());
				prpLLossDtoTemp.setItemkindNo(prpLProp.getItemKindNo());
				prpLLossDtoTemp.setClaimRate(100.00);
				if ("3204".equals(riskCode)) {
					PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
					itemKindList = null;
					for (Iterator it = itemKindList.iterator(); it.hasNext();) {
						itemKindDto = (PrpCitemKindDto) it.next();
						if (itemKindDto.getKindCode().equals(prpLProp.getKindCode())
								&& itemKindDto.getItemCode().equals(prpLProp.getItemCode())) {
							System.err.println(itemKindDto.getAmount());
							prpLLossDtoTemp.setAmount(itemKindDto.getAmount());
						}
					}
				} else {
					prpLLossDtoTemp.setAmount(dbAmount);
				}
				prpLLossDtoTemp.setFlag(String.valueOf(serialNo++));
				prpLLossDtoTemp.setCurrency1(prpLProp.getCurrency());
				prpLLossDtoTemp.setCurrency1Name(currencyName);
				prpLLossDtoTemp.setCurrency2(prpLProp.getCurrency());
				prpLLossDtoTemp.setCurrency2Name(currencyName);
				prpLLossDtoTemp.setCurrency3(prpLProp.getCurrency());
				prpLLossDtoTemp.setCurrency3Name(currencyName);
				prpLLossDtoTemp.setCurrency4(prpLProp.getCurrency());
				prpLLossDtoTemp.setCurrency4Name(currencyName);
				prpLLossDtoTemp.setSumLoss(prpLProp.getSumLoss());
				prpLLossDtoTemp.setSumRest(prpLProp.getSumReject());
				prpLLossDtoTemp.setSumrealPay(prpLProp.getSumLoss() - prpLProp.getSumReject());
				prpLLossDtoTemp.setItemkindNo((int) prpLProp.getItemKindNo());
				prpLLossDtoTemp.setPolicyNo(prpLProp.getPolicyNo());
				prpLLossDtoTemp.setFamilyNo(prpLProp.getFamilyNo());
				prpLLossDtoExtList.add(prpLLossDtoTemp);

			}
			tempMap.put(String.valueOf(prpLLossDtoTemp.getItemkindNo()),
					String.valueOf(prpLLossDtoTemp.getSerialNo() - 1));
		}
		return prpLLossDtoExtList;
	}

	@Override
	public void prepareCommonText(CompensatePageResponseDto responseDto) {
		/*设置付款说明文字,理算报告文字和赔款计算过程文字*/
		setPayAndReportDescription(responseDto);
		/*设置特别约定信息*/
		setPrpCengageText(responseDto);
		
	}
    /**
     * @description:方法功能简述: 特别约定信息
     * @author 安齐崇
     * @date 2017年12月23日上午10:48:15
     * @param responseDto
     */
    @Override
	public List<PrpCengageDtoExt> setPrpCengageText(CompensatePageResponseDto responseDto) {
		// 特别约定信息多行列表准备数据
		List<PrpCengageDto> engageList = prpCengageApi.queryEngageByPolicyNo(responseDto.getPolicyNo());
		ArrayList<PrpCengageDto> cengageListTemp = new ArrayList<>();
		for (PrpCengageDto prpCengageDto : engageList) {
			if (prpCengageDto.getClauseCode() != null && prpCengageDto.getClauseCode().length() > 0
					&& prpCengageDto.getClauseCode().charAt(0) == 'T') {
				cengageListTemp.add(prpCengageDto);
			}
		}
		engageList = new ArrayList<>();
		engageList.addAll(cengageListTemp);
		List<PrpCengageDtoExt> prpCengageDtoList = new ArrayList<>();
		Map<String, List<PrpCengageDtoExt>> cengageKind = new HashMap<String, List<PrpCengageDtoExt>>();
		for (PrpCengageDto prpCengageDto : engageList) {
			if (cengageKind.isEmpty()) {
				cengageKind.put(prpCengageDto.getClauseCode(), new ArrayList<PrpCengageDtoExt>());
			}
			if (cengageKind.containsKey(prpCengageDto.getClauseCode())) {
				List<PrpCengageDtoExt> list = cengageKind.get(prpCengageDto.getClauseCode());
				list.add(this.convert(prpCengageDto, PrpCengageDtoExt.class));
				cengageKind.put(prpCengageDto.getClauseCode(), list);
			} else {
				List<PrpCengageDtoExt> list = new ArrayList<>();
				list.add(this.convert(prpCengageDto, PrpCengageDtoExt.class));
				cengageKind.put(prpCengageDto.getClauseCode(), list);
			}
		}
		for (Map.Entry<String, List<PrpCengageDtoExt>> entry : cengageKind.entrySet()) {
			List<PrpCengageDtoExt> prpCengageDtoExtList = entry.getValue();
			PrpCengageDtoExt prpCengageDto = null;
			String context = "";
			int currencyLine = -1;
			int nextLine = -1;
			for (PrpCengageDtoExt prpCengageDtoExt : prpCengageDtoExtList) {
				nextLine = prpCengageDtoExt.getLineNo();
				if ("0".equals(prpCengageDtoExt.getTitleFlag())) {
					prpCengageDto = prpCengageDtoExt;
				} else {
					if (currencyLine > nextLine) {
						context = prpCengageDtoExt.getClauses() + context;
					} else {
						context += prpCengageDtoExt.getClauses();
					}
				}
				currencyLine = nextLine;
			}
			prpCengageDto.setContext(context);
			prpCengageDtoList.add(prpCengageDto);
			prpCengageDto = null;
			currencyLine = -1;
			nextLine = -1;
		}
		responseDto.setPrpCengageDtoList(prpCengageDtoList);
		return prpCengageDtoList;
	}

	/**
     * @description:方法功能简述: 设置付款说明文字和理算报告
     * @author 安齐崇
     * @date 2017年12月3日上午11:35:36
     * @param responseDto
     */
	private void setPayAndReportDescription(CompensatePageResponseDto responseDto) {
		String editType = responseDto.getEditType();
		String compensateNo = responseDto.getCompensateNo();
		PrpLCTextDtoExt prpLCTextPayTextDto = new PrpLCTextDtoExt();
		List<PrpLCText> prpLCTextList = prpLCTextDao.findAll(Specifications.<PrpLCText>and().eq("compensateNo", compensateNo).build());
		/*设置付款说明信息*/
		if("ADD".equals(editType)){
			String payText = "";
	    	payText += "请将赔款      付给\r\n";
	    	payText += "单位:\r\n";
	    	payText += "开户行:\r\n";
	    	payText += "帐号:\r\n";
	    	payText += "付讫日期及方式:\r\n";
	    	/*付款说明textType=4*/
	    	prpLCTextPayTextDto.setTextType("4");
	    	prpLCTextPayTextDto.setContext(payText);
		}else{
			List<PrpLCTextDto> prpLctextPayTextDtoList =new ArrayList<PrpLCTextDto>();
			String tempContext = "";
			for(int i= 0;prpLCTextList!=null && i<prpLCTextList.size();i++){

                PrpLCText prpLctextTemp = prpLCTextList.get(i);
                if (prpLctextTemp.getTextType().equals("4")) {
                    tempContext = tempContext + prpLctextTemp.getContext();
                    prpLctextPayTextDtoList.add(this.convert(prpLctextTemp, PrpLCTextDto.class));
                }
            
			}
			prpLCTextPayTextDto.setPrpLCTextDtoList(prpLctextPayTextDtoList);
			prpLCTextPayTextDto.setTextType("4");
			prpLCTextPayTextDto.setContext(tempContext);
			responseDto.setContextPayText(tempContext);
		}
		/*设置付款文字说明*/
		responseDto.setPrpLCTextPayTextDto(prpLCTextPayTextDto);
		/*设置理算报告*/
		List<PrpLCTextDto> prpLCTextDtoList1 =new ArrayList<PrpLCTextDto>();
		List<PrpLCTextDto> prpLCTextDtoList7 =new ArrayList<PrpLCTextDto>();
		PrpLCTextDtoExt prpLCTextReport1 = new PrpLCTextDtoExt();
		PrpLCTextDtoExt prpLCTextReport7 = new PrpLCTextDtoExt();
		String tempContext = "";
        String tempContext1 = "";
        for(int i= 0;prpLCTextList!=null && i<prpLCTextList.size();i++){
            PrpLCText prpLctextDtoTemp = prpLCTextList.get(i);
            if (prpLctextDtoTemp.getTextType().equals("7")) {
                tempContext = tempContext + prpLctextDtoTemp.getContext();
                prpLCTextDtoList7.add(this.convert(prpLctextDtoTemp, PrpLCTextDto.class));
            }else if(prpLctextDtoTemp.getTextType().equals("1")) {
            	tempContext1 +=  prpLctextDtoTemp.getContext();
            	prpLCTextDtoList1.add(this.convert(prpLctextDtoTemp, PrpLCTextDto.class));
            }
            
        }
        prpLCTextReport7.setContext(tempContext);
        prpLCTextReport7.setTextType("7");
        responseDto.setPrpLCTextReport(prpLCTextReport7);
        responseDto.setContextReport(tempContext);
        prpLCTextReport1.setContext(tempContext1);
        prpLCTextReport1.setTextType("1");
        responseDto.setPrpLCTextPayCalcul(prpLCTextReport1);
        responseDto.setContextPayCalcul(tempContext);
        
	}

	@Override
	public void prepareChargeFee(CompensatePageResponseDto responseDto) {
		String editType = responseDto.getEditType();
		String compensateNo = responseDto.getCompensateNo();
		List<PrpLChargeDtoExt> prpLChargeDtoExtList = new ArrayList<PrpLChargeDtoExt>();
		if(!"ADD".equals(editType)){
			List<PrpLCharge> prpLChargeList = prpLChargeDao.findAll(Specifications.<PrpLCharge>and().eq("compensateNo", compensateNo).build());
		    for(int i=0 ;prpLChargeList!=null&&i<prpLChargeList.size();i++){
		    	PrpLChargeDtoExt prpLChargeDtoExt = new PrpLChargeDtoExt();
		    	PrpLCharge prpLCharge = prpLChargeList.get(i);
		    	PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpLCharge.getRiskCode(), prpLCharge.getKindCode());
		    	if(prpDkindDto!=null) {
					prpLChargeDtoExt.setKindName(prpDkindDto.getKindCName());
				}
		    	pageInitCommonService.copyPropertiesIfNull(prpLCharge, prpLChargeDtoExt);
		    	prpLChargeDtoExtList.add(prpLChargeDtoExt);
		    }
		}
		responseDto.setPrpLChargeDtoExtList(prpLChargeDtoExtList);
	}

	@Override
	public void prepareCaseReport(CompensatePageResponseDto responseDto) {
		List<PrpLLText> prpLLTextList = prpLLTextDao.findAll(Specifications.<PrpLLText>and().eq("claimNo", responseDto.getClaimNo()).build());
		PrpLLTextDto prpLLTextDto = new PrpLLTextDto();
		String tempContext = "";
		if(!"ADD".equals(responseDto.getEditType())){
			for(int i = 0;prpLLTextList != null && i<prpLLTextList.size();i++){
				PrpLLText prpLLText = prpLLTextList.get(i);
				if ("08".equals(prpLLText.getTextType())) {
					tempContext = tempContext + prpLLText.getContext();
				}
			}
		}
		if (!responseDto.getPrpLClaimDto().getClassCode().equals( "26") &&!responseDto.getPrpLClaimDto().getClassCode().equals( "27") &&!responseDto.getPrpLClaimDto().getClassCode().equals( "28") && !"1".equals(responseDto.getFamilySplittingFlag())){
			tempContext="一、被保险人概况"+"\r\n";
			tempContext= tempContext+"二、事故经过及原因调查"+"\r\n";
			tempContext= tempContext+"三、认定责任"+"\r\n";
			tempContext= tempContext+"四、足额投保"+"\r";
			tempContext= tempContext+"五、是否存在重复投保及向第三者追偿前景"+"\r\n";
			tempContext= tempContext+"六、索赔及定损"+"\r\n";
			tempContext= tempContext+"七、总结和赔付";
    	}
		if("1".equals(responseDto.getFamilySplittingFlag())&& StringUtils.isNotEmpty(responseDto.getText())){
			prpLLTextDto.setContext(responseDto.getText());
		}else{
			prpLLTextDto.setContext(tempContext);
		}
		prpLLTextDto.setTextType("08");
		prpLLTextDto.setClaimNo(responseDto.getClaimNo());
		responseDto.setPrpLLTextDto(prpLLTextDto);
	}
	/**
	 * @description:方法功能简述: 设置支付对象信息
	 * @author 安齐崇
	 * @date 2017年12月3日下午11:07:39
	 * @param responseDto
	 */
	@Override
	public void prepareSumPay(CompensatePageResponseDto responseDto) {
		List<PrpLsumpayDto> prpLsumpayDtoList = null; 
		String editType = responseDto.getEditType();
		if("ADD".equals(editType)){
			prpLsumpayDtoList = new ArrayList<>();
			/*prpLsumpayDto.setRegistNo(responseDto.getRegistNo());
			prpLsumpayDto.setClaimNo(responseDto.getClaimNo());
			prpLsumpayDto.setPolicyNo(responseDto.getPolicyNo());
			prpLsumpayDto.setComCode(responseDto.getComCode());
			prpLsumpayDto.setHandlerCode(responseDto.getUserCode());
			prpLsumpayDto.setHandlerName(responseDto.getUserName());
			prpLsumpayDto.setHandleTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			prpLsumpayDtoList.add(prpLsumpayDto);*/
		}else{
			List<PrpLsumpay> prpLsumpayList = prpLsumpayDao.findAll(Specifications.<PrpLsumpay>and().eq("compensateNo", responseDto.getCompensateNo()).build());
			this.convertCollection(prpLsumpayList, prpLsumpayDtoList, PrpLsumpayDto.class);
			if(prpLsumpayDtoList == null){
				prpLsumpayDtoList = new ArrayList<>();
			}
		}
		responseDto.setPrpLsumpayDtoList(prpLsumpayDtoList);
	}
}
