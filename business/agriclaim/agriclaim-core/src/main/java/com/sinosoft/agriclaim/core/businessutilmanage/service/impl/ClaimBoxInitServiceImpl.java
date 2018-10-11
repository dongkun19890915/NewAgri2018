package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitActionDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitDataDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitDataParamDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitRequestVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitResponseVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ConditionVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.InitVo;
import com.sinosoft.agriclaim.core.businessutilmanage.service.ClaimBoxInitService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcodeRiskApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeRiskDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;

/**
 * @description: 类功能简述：页面下拉框，复选框初始化服务实现了=类
 * @author 安齐崇
 * @date 2017年12月9日下午4:54:33
 *
 */
@Service
public class ClaimBoxInitServiceImpl implements ClaimBoxInitService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimBoxInitServiceImpl.class);
	@Autowired
	private PrpDcodeApi codeApi;
	@Autowired
	private PrpDcurrencyApi prpDcurrencyApi;
	@Autowired
	private PrpDcodeRiskApi prpDcodeRiskApi;
	@Autowired
	private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private PrpDuserApi prpDuserApi;
	/**@description:下拉框复选框初始化公共服务类
	 * @param requestDto
	 * @throws Exception
	 */
	@Override
	public ClaimBoxInitResponseVo queryCommonData(ClaimBoxInitRequestVo requestDto) throws Exception {
		ClaimBoxInitResponseVo vo = new ClaimBoxInitResponseVo();
		List<InitVo> initlist = requestDto.getInitlist();
		List<ConditionVo> casecadeConditionList = requestDto.getCasecadeConditionList();
		List<ClaimBoxInitDataDto> dataList = new ArrayList<>();
		for (int i = 0; initlist != null && initlist.size() > 0 && i < initlist.size(); i++) {
			ClaimBoxInitDataDto data = new ClaimBoxInitDataDto();
			ClaimBoxInitActionDto resultobj = new ClaimBoxInitActionDto();
			InitVo initVo = initlist.get(i);
			if (dataList.size() > 0
					&& ("CheckPerson".equals(initVo.getCodeType()) || "CertaPerson".equals(initVo.getCodeType()))) {
				for (ListIterator<ClaimBoxInitDataDto> iterator = dataList.listIterator(); iterator.hasNext();) {
					ClaimBoxInitDataDto dataDto = iterator.next();
					/*查勘人员和定损人员查询规则相同，若已经查询到数据就不再查询数据库，进行如下判断*/
					if ("CheckPerson".equals(dataDto.getCodeType()) || "CertaPerson".equals(dataDto.getCodeType())) {
						if (dataDto.getCodeType().equals(initVo.getCodeType())) {
							break;
						} else {
							boolean flag = true;
							for (ClaimBoxInitDataDto dataValue : dataList) {
								if (dataValue.getCodeType().equals(initVo.getCodeType())) {
									flag = false;
								}
							}
							if (flag) {
								dataDto.setCodeType(initVo.getCodeType());
								iterator.add(dataDto);
							}
						}
					}
				}
			}
			List<ClaimBoxInitDataParamDto> actionResult = this.queryInitParam(initVo.getCodeType(), initVo.getRiskCode(),
					casecadeConditionList);
			resultobj.setAction_result(actionResult);
			data.setCodeType(initVo.getCodeType());
			data.setResultobj(resultobj);
			dataList.add(data);
		}
		vo.setData(dataList);
		vo.setCode("0000");
		vo.setMsg("处理成功！");
		return vo;
	}

	/**
	 * @description:方法功能简述: 根据codeType 和riskCode 查询集合
	 * @author 安齐崇
	 * @date 2017年12月9日下午5:55:25
	 * @param codeType 编码
	 * @param riskCode 险种编码
	 * @return paramDtoList
	 * @throws Exception
	 */
	List<ClaimBoxInitDataParamDto> queryInitParam(String codeType, String riskCode,
			List<ConditionVo> casecadeConditionList) throws Exception {
		List<ClaimBoxInitDataParamDto> paramDtoList = new ArrayList<ClaimBoxInitDataParamDto>();
		/* 币别查询 */
		if ("Currency".equals(codeType)) {
			List<PrpDcurrencyDto> prpDcurrencyDto = prpDcurrencyApi.queryAll();
			for (int i = 0; prpDcurrencyDto != null && prpDcurrencyDto.size() > 0 && i < prpDcurrencyDto.size(); i++) {
				PrpDcurrencyDto currencyDto = prpDcurrencyDto.get(i);
				ClaimBoxInitDataParamDto paramDto = new ClaimBoxInitDataParamDto();
				paramDto.setCodecode(currencyDto.getCurrencyCode());
				paramDto.setCodecname(currencyDto.getCurrencyCName());
				paramDto.setCodeename(currencyDto.getCurrencyEName());
				paramDtoList.add(paramDto);
			}
		}
		/* 查勘核损人员查询 */
		if ("CheckPerson".equals(codeType) || "CertaPerson".equals(codeType)) {
			String userCode = SinoRequestContext.getCurrentContext().getUserCode();
			PrpDuserDto userInfo = prpDuserApi.queryByPK(userCode);
			String comCode = "0000000000";
			List<PrpDuserDto> checkPersons = prpDuserApi.queryCheckPerson(comCode);
			for (PrpDuserDto prpDuserDto : checkPersons) {
				ClaimBoxInitDataParamDto paramDto = new ClaimBoxInitDataParamDto();
				paramDto.setCodecode(prpDuserDto.getUserCode());
				paramDto.setCodecname(prpDuserDto.getUserName());
				paramDto.setCodeename(prpDuserDto.getUserEName());
				paramDtoList.add(paramDto);
			}
		}
		/* 报案类型全险类，巨灾等级全险类 */
		if ("ReportType".equals(codeType) || "CatastropheCode".equals(codeType)) {
			if ("Unit".equals(codeType)) {
				if (casecadeConditionList == null || casecadeConditionList.size() < 1) {
					LOGGER.error("{}类型的查询，险种类型编码不能为空！", codeType);
					throw new BusinessException(codeType + "类型的查询，险种类型编码不能为空！");
				}
			}
			String riskType = "";
			/* 在额外的查询条件中取险类 */
			for (ConditionVo conditionVo : casecadeConditionList) {
				if ("riskType".equals(conditionVo.getName()) && "Unit".equals(codeType)) {
					riskType = conditionVo.getValue();
					break;
				}
			}
			List<String> riskTypeList = new ArrayList<>();
			if (StringUtils.isEmpty(riskType)) {
				riskTypeList.add(riskType);
			} else {
				riskTypeList.add("H");
				riskTypeList.add("I");
			}
			List<String> outerCodesList = utiCodeTransferApi.queryOuterCodeByTypes(riskTypeList);
			String outerCodes = "";
			for (int i = 0; outerCodesList != null && i < outerCodesList.size(); i++) {
				if (i != outerCodesList.size() - 1) {
					outerCodes += outerCodesList.get(i) + "-";
				} else {
					outerCodes += outerCodesList.get(i);
				}
			}
			outerCodes += "-0000";
			List<PrpDcodeRiskDto> codeRiskDtoList = prpDcodeRiskApi.queryByCodesAndType(outerCodes, codeType);
			String codeCodeList = "";
			for (int i = 0; codeRiskDtoList != null && i < codeRiskDtoList.size(); i++) {
				if (i != codeRiskDtoList.size() - 1) {
					codeCodeList += codeRiskDtoList.get(i).getCodeCode() + "-";
				} else {
					codeCodeList += codeRiskDtoList.get(i).getCodeCode();

				}
			}
			List<PrpDcodeDto> prpDcodeDtoList = codeApi.queryByCondition(codeType, codeCodeList);
			this.prepareParam(prpDcodeDtoList, paramDtoList);
		}
		/* 查勘性质 */
		if ("CheckNature".equals(codeType)) {
			UtiCodeTransferDto transferDto = utiCodeTransferApi.queryByPK("RISKCODE_DAA");
			List<PrpDcodeDto> checkNatures = codeApi.queryCodeInfoByCodeType("CheckNature", transferDto.getOuterCode());
			List<PrpDcodeDto> checkNatureList = new ArrayList<>();
			Set<String> set = new HashSet<>();
			for (PrpDcodeDto prpDcodeDto : checkNatures) {
				if (set.add(prpDcodeDto.getCodeCode())) {
					checkNatureList.add(prpDcodeDto);
				}
			}
			this.prepareParam(checkNatureList, paramDtoList);
		}
		/* 出险原因，出险详细原因 */
		/* 出险原因，出险详细原因 */
		if ("DamageCode".equals(codeType) || "DamageDetail".equals(codeType) || "Unit".equals(codeType) || "ChargeCode".equals(codeType)) {
			if ("DamageDetail".equals(codeType)) {
				codeType = "DamageCode";
			}
			List<PrpDcodeDto> damageList = codeApi.queryOptionBox(codeType, riskCode);
			this.prepareParam(damageList, paramDtoList);
		}
		return paramDtoList;
	}

	/**
	 * @description:方法功能简述: 组装参数
	 * @author 安齐崇
	 * @date 2017年12月15日下午5:12:17
	 * @param codeDtoList
	 * @param paramDtoList
	 */
	public void prepareParam(List<PrpDcodeDto> codeDtoList, List<ClaimBoxInitDataParamDto> paramDtoList) {
		for (int i = 0; codeDtoList != null && codeDtoList.size() > 0 && i < codeDtoList.size(); i++) {
			PrpDcodeDto prpDcodeDto = codeDtoList.get(i);
			ClaimBoxInitDataParamDto paramDto = new ClaimBoxInitDataParamDto();
			paramDto.setCodecode(prpDcodeDto.getCodeCode());
			paramDto.setCodecname(prpDcodeDto.getCodeCName());
			paramDto.setCodeename(prpDcodeDto.getCodeEName() == null ? "" : prpDcodeDto.getCodeEName());
			paramDtoList.add(paramDto);
		}
	}
}
