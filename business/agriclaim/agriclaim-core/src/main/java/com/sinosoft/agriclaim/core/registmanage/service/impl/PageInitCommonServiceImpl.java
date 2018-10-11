package com.sinosoft.agriclaim.core.registmanage.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.endorsemanage.CheckStatusApi;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.QueryPApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.PolicyQueryApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCplanApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;

/**
 * @description: 类功能简述：公共查询类
 * @author 安齐崇
 * @date 2017年11月15日下午9:35:10
 */
@Service
public class PageInitCommonServiceImpl extends BaseServiceImpl implements PageInitCommonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PageInitCommonServiceImpl.class);
	@Autowired
	private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PrpCplanApi prpCplanApi;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private PolicyQueryApi policyQueryApi;
	@Autowired
	private CheckStatusApi checkStatusApi;
	@Autowired
	private QueryPApi queryPApi;
	@Autowired
	private PrpPheadApi prpPheadApi;

	/**
	 * @description:方法功能简述: 根据险种编码查询险种类型
	 * @author 安齐崇
	 * @date 2017年11月15日下午9:37:23
	 * @param riskCode
	 *            险种编码
	 * @return riskType 险种类型
	 */
	@Override
	public String findRiskTypeByCode(String riskCode) {
		Map<String, String> map = new HashMap<>();
		map.put("outerCode", riskCode);
		List<UtiCodeTransferDto> utiCodeTransfers = utiCodeTransferApi.queryUtiCodeTransferDtoByOuterCode(map);
		UtiCodeTransferDto utiCodeTransfer = utiCodeTransfers != null && utiCodeTransfers.size() > 0 ? utiCodeTransfers.get(0):null;
		String riskType = utiCodeTransfer == null  ? "" : utiCodeTransfer.getRiskType();
		return riskType;
	}

	/**
	 * @description:方法功能简述: 已出险次数查询
	 * @author 安齐崇
	 * @date 2017年11月17日上午12:58:12
	 * @param policyNo
	 *            保单号
	 * @param registNo
	 *            报案号
	 * @return intPerilCount 已出险次数
	 */
	@Override
	public int getSamePolicyRegistInfo(String policyNo, String registNo) {
		PrpLRegist prpLregistDtoTemp = new PrpLRegist();
		PrpLRegist prpLregistDtoPre = new PrpLRegist();
		List<PrpLRegist> registList = (List<PrpLRegist>) this.getSamePolicyRegist(policyNo);
		int intPerilCount = 0;
		/* 最近几天的出险次数 */
		int intRecentCount = 0;
		/*-- 出险报案次数增加在N天内的出险次数   常量*/
		String priorDate = "5";
		DateTime dateTime = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null) {
			rowCount = registList.size();
		}
		if (registNo == null) {
			registNo = "";
		}
		for (rowNo = 0; rowNo < rowCount; rowNo++) {
			oldRegistNo = nowRegistNo;
			prpLregistDtoPre = prpLregistDtoTemp;
			prpLregistDtoTemp = (PrpLRegist) registList.get(rowNo);
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
				} else {
					intPerilCount++;
				}
				continue;
			}
			// 添加上行记录
			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName() + " " + prpLregistDtoTemp.getBrandName());
			}
			// reason:如果是第一次出险 intPerilCount就不应该再增加 本次出险不计算在内
			if ((rowNo == rowCount - 1) && !registNo.equals(nowRegistNo) && (!oldRegistNo.equals(nowRegistNo))) {
				intPerilCount++;
			} else {
//				if (rowCount != 1 && !registNo.equals(nowRegistNo)) {
					intPerilCount++;
//				}
			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("$$$$$$$$$$$$$$$$$$$$$$$ wl 计算" + priorDate + "天内出险的次数:= " + intRecentCount);
			LOGGER.error("$$$$$$$$$$$$$$$$$$$$$$$ wl 计算出险的次数:= " + intPerilCount);
		}
		return intPerilCount;
	}
    /**
      * @description 根据保单号查历史报案信息
      * @author 安齐崇
      * @date 2017年12月18日 上午10:48:06
      * @param policyNo 保单号
      * @return registList PrpLRegist集合
     */
	private List<PrpLRegist> getSamePolicyRegist(String policyNo) {
		String sql = " Select p.registNo,p.damageStartDate,p.reportDate,p.riskCode "
				+ "From PrpLRegist p  left join PrpLext t on t.certino=p.registNo where p.policyNo = :policyNo order by p.registNo";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("policyNo", policyNo);
		List<PrpLRegist> registList = new ArrayList<PrpLRegist>();
		@SuppressWarnings("unchecked")
		List<Object> list = query.getResultList();
		for (Object object : list) {
			Object[] obj = (Object[]) object;
			PrpLRegist regist = new PrpLRegist();
			regist.setRegistNo((String) obj[0]);
			regist.setDamageStartDate((Date) obj[1]);
			regist.setReportDate((Date) obj[2]);
			regist.setRiskCode((String) obj[3]);
			registList.add(regist);
		}
		return registList;
	}
	/**
	 * @description:方法功能简述:通过条件查询utiPlatConfigRule中rule 信息
	 * @author 安齐崇
	 * @date 2017年11月18日下午5:11:57
	 * @param paramCode
	 * @return systemCode
	 */
	@Override
	public String getConfigRules(String paramCode, String systemCode) {
		UtiPlatConfigRuleDto configRuleDto = utiPlatConfigRuleApi.queryByPK(systemCode, paramCode, 1);
		return configRuleDto == null?"":configRuleDto.getRule();
	}
	/**
	 * @description:方法功能简述:此方法为属性拷贝方法，若目标类里面属性有值以目标类为准，若目标类属性没值，则从资源类中获取并给目标类赋值，
	 * 目标类和资源类可以支持有父类
	 * @author 安齐崇
	 * @date 2017年11月21日上午12:50:11
	 * @param src 资源类
	 * @param des 目标类
	 */
	@Override
	public void copyPropertiesIfNull(Object src, Object des) {
		try {
			for (Class<?> descClazz = des.getClass(); descClazz != Object.class; descClazz = descClazz
					.getSuperclass()) {
				Field[] desFields = descClazz.getDeclaredFields();
				for (Field desField : desFields) {
					for (Class<?> srcClazz = src.getClass(); srcClazz != Object.class; srcClazz = srcClazz
							.getSuperclass()) {
						Field[] srcFields = srcClazz.getDeclaredFields();
						for (Field srcField : srcFields) {
							desField.setAccessible(true);
							srcField.setAccessible(true);
							if (desField.getName().equalsIgnoreCase(srcField.getName())) {
								String desfield = desField.getName();
								if ("serialVersionUID".equals(desfield)) {
									break;
								}
								String srcfield = srcField.getName();
								String paramSrc = srcfield.substring(0, 1).toUpperCase() + srcfield.substring(1);
								String paramDesc = desfield.substring(0, 1).toUpperCase() + desfield.substring(1);
								Method methodSrc;
								Method methodDesc;
								try {
									methodDesc = descClazz.getDeclaredMethod("get" + paramDesc);
									Object objDesc = methodDesc.invoke(des);
									methodSrc = src.getClass().getDeclaredMethod("get" + paramSrc);
									Object objSrc = methodSrc.invoke(src);
									if (objDesc != null || objSrc == null) {
										continue;
									}
								} catch (Exception e) {
									paramDesc = desfield.substring(0, 1).toLowerCase() + desfield.substring(1);
									methodDesc = descClazz.getDeclaredMethod("get" + paramDesc);
									Object objDesc = methodDesc.invoke(des);
									if (objDesc != null) {
										continue;
									}
									paramSrc = srcfield.substring(0, 1).toLowerCase() + srcfield.substring(1);
									methodSrc = src.getClass().getDeclaredMethod("get" + paramSrc);
									Object objSrc = methodSrc.invoke(src);
									if (objSrc == null) {
										continue;
									}
								}
								LOGGER.error("反射赋值属性为{}", desField.getName());
								try {
									desField.set(des, methodSrc.invoke(src));
								} catch (Exception e) {
									LOGGER.error("{}属性反射赋值异常,属性拷贝类型不一致,请核对！本次赋值跳过，请单独赋值！", desField.getName());
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("属性反射赋值异常,属性拷贝类型不一致,请核对！");
			LOGGER.error(e.getStackTrace().toString());
		}
	}
	/**
	 * @description: 用于集合属性拷贝
	 * @author 安齐崇
	 * @date 2017年11月2日下午8:06:07
	 * @param srcList 源集合
	 * @param desList 目标集合
	 */
	@Override
	public void copyCollection(List<Object> srcList, List<Object> desList) {
		Object des = desList.get(0);
		for (Object src : srcList) {
			this.copyPropertiesIfNull(src, des);
			desList.add(des);
		}
	}
	/**
	 * @description:方法功能简述: 根据保单号查询保费缴费状态
	 * @author 安齐崇
	 * @date 2017年11月25日下午1:53:30
	 * @param policyNo 保单号
	 * @return intRet 缴费状态 -1未缴，1，全缴，-2，缴部分
	 * @throws Exception 
	 */
	@Override
	public int checkPay(String policyNo) throws Exception {
		Map<String, String> fees = prpCplanApi.queryPrpCplanByPolicyNo(policyNo);
		/* 应缴 */
		double sumPlanfee = 0.0;
		/* 欠缴 */
		double sumDelinquentfee = 0.0;
		int intRet = -1;
		if (fees != null && fees.size() > 0) {
			if (StringUtils.isNotEmpty(fees.get("planFee")) && !"null".equals(fees.get("planFee"))) {
				sumPlanfee = Double.parseDouble(String.valueOf(fees.get("planFee")));
			}
			if (StringUtils.isNotEmpty(fees.get("delinquentFee")) && !"null".equals(fees.get("delinquentFee"))) {
				sumDelinquentfee = Double.parseDouble(String.valueOf(fees.get("delinquentFee")));
			}
			/* 检查缴费情况的算法是: 应缴费总和-欠缴费总和==0 则未缴; */
			/* 欠缴费总和==0 则全缴; 欠缴费总和>0 则缴部分费用; */
			if (sumPlanfee < 0) {
				throw new BusinessException("计算所得的应缴费用总和小于零了!!!");
			}
			if (sumPlanfee == 0) {
				intRet = 0;
			} else {
				if (sumPlanfee - sumDelinquentfee == 0) {
					/* 未缴 */
					intRet = -1;
				} else if (sumDelinquentfee == 0) {
					/* 全缴 */
					intRet = 1;
				} else if (sumDelinquentfee > 0) {
					/* 缴部分 */
					intRet = -2;
				}
			}
		} else {
			/* 在prpcPlan表中无满足条件的缴费情况记录,视作已缴费 */
			intRet = 1;
		}
		return intRet;
	}
	/**
	 * @description:方法功能简述: 欠费情况
	 * @author 安齐崇
	 * @date 2017年11月15日下午12:12:34
	 * @param prpCMainDto 保单对象
	 * @return delinquentfeeCase 分期付款欠费情况描述
	 */
	@Override
	public String getDelinquentfeeCase(PrpCmainDto prpCMainDto) {
		/* 欠费情况 */
		String delinquentfeeCase = "";
		/* 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴 */
		if (prpCMainDto.getPayTimes() < 2) {
			delinquentfeeCase = "缴费计划为 " + prpCMainDto.getPayTimes() + " 期";
		} else {
			int[] delinquentfeeTime = prpCplanApi.getDelinquentfeeTime(prpCMainDto.getPolicyNo());
			for (int i = 0; i < delinquentfeeTime.length; i++) {
				if (i == 0) {
					delinquentfeeCase = "缴费计划为 " + prpCMainDto.getPayTimes() + " 期";
				}
				delinquentfeeCase += "\n";
				delinquentfeeCase += "第 " + delinquentfeeTime[i] + " 期未缴费";
			}
		}
		return delinquentfeeCase;
	}
    /**
      * @description 校验是否被占号
      * @author 安齐崇
      * @date 2017年12月22日 上午10:12:27
      * @param
      * @return
     */
	@Override
	public void verifyIsHoldNode(String flowID, String logNo, String userCode, String userName, String businessNo) {
		if (StringUtils.isNotEmpty(flowID) && StringUtils.isNotEmpty(flowID)) {
			SwfLogDto swfLogDto = workFlowService.holdNode(flowID, Integer.parseInt(logNo), userCode, userName);
			if ("false".equals(swfLogDto.getFlag())) {
				String msg = "案件'" + businessNo + "'已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
						+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
				if (LOGGER.isInfoEnabled()) {
					LOGGER.error(msg);
				}
				throw new BusinessException(BusinessException.DataVerifyCatalog, msg);
			}
		}

	}
	/**
	 * @description:方法功能简述: 进行工作流占号校验，如果工作流被占用则抛出异常
	 * @author 安齐崇
	 * @date 2017年12月7日下午2:54:03
	 * @param policyNo 保单号
	 * @param strDate  日期
	 * @param strHour  小时
	 */
	@Override
	public ResponseQueryPolicyInfoDto findEndOrBefore(String policyNo, String strDate, String strHour)
			throws Exception {
		Map<String,String> policyMap = new HashMap<>();
		policyMap.put("policyNo", policyNo);
		ResponseQueryPolicyInfoDto policyDto = policyQueryApi.queryPolicyInfoByPolicyNo(policyMap);
		/* 查询是否有有效批单，1有，0没有 */
		Integer checkStatus = checkStatusApi.checkStatus(policyNo);
		if (checkStatus == 1) {
			/* 如果有有效批单则进行批单回倒 */
			Map<String,String> map = new HashMap<>();
			map.put("policyNo", policyNo);
			List<PrpPheadDto> prppHeadDtoList = prpPheadApi.queryAllByPolicyNo(map);
			for (int i = 0; prppHeadDtoList != null && prppHeadDtoList.size() > 0 && i < prppHeadDtoList.size(); i++) {
				PrpPheadDto prpPheadDto = prppHeadDtoList.get(0);
				backWardData(policyDto, prpPheadDto.getEndorseNo());
			}
		}
		return policyDto;
	}

	/**
	 * @description:方法功能简述: 进行属性回倒
	 * @author 安齐崇
	 * @date 2017年12月11日下午7:45:50
	 * @param checkStatus
	 * @param policyNo
	 * @throws Exception
	 */
	private void backWardData(ResponseQueryPolicyInfoDto policyDto, String endorseNo) throws Exception {
		BLEndorseDto queryP = queryPApi.queryP(endorseNo);
		/* 回倒保单主信息 */
		policyDto.setPrpCmainDto(this.convert(queryP.getPrpPmainDto(), PrpCmainDto.class));
		List<PrpCengageDto> prpCengageDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPengageDtoList(), prpCengageDtoList, PrpCengageDto.class);
		/* 回倒特备约定信息 */
		policyDto.setPrpCengageDtoList(prpCengageDtoList);
		List<PrpCinsuredDto> prpCinsuredDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPinsuredDtoList(), prpCinsuredDtoList, PrpCinsuredDto.class);
		/* 回倒被保险人信息 */
		policyDto.setPrpCinsuredDtoList(prpCinsuredDtoList);
		List<PrpCaddressDto> prpCaddressDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPaddressDtoList(), prpCaddressDtoList, PrpCaddressDto.class);
		/* 回倒投保地址信息 */
		policyDto.setPrpCaddressDtoList(prpCaddressDtoList);
		List<PrpCfeeDto> prpCfeeDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPfeeDtoList(), prpCfeeDtoList, PrpCfeeDto.class);
		/* 回倒费用信息 */
		policyDto.setPrpCfeeDtoList(prpCfeeDtoList);
		List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPitemKindDtoList(), prpCitemKindDtoList, PrpCitemKindDto.class);
		/* 回倒标的信息 */
		policyDto.setPrpCitemKindDtoList(prpCitemKindDtoList);
		List<PrpCplanDto> prpCplanDtoList = new ArrayList<>();
		this.convertCollection(queryP.getPrpPplanDtoList(), prpCplanDtoList, PrpCplanDto.class);
		/* 回倒缴费计划信息 */
		policyDto.setPrpCplanDtoList(prpCplanDtoList);
	}
}
