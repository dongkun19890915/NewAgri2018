package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckKey;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossKey;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimLossDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLoss;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimViewService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.pms.api.kernel.PrpDkindAgriApi;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @description: 类功能简述：立案登记页面初始化视图服务类
 * @author 安齐崇
 * @date 2017年11月25日下午3:58:29
 *
 */
@Service
public class ClaimViewServiceImpl extends BaseServiceImpl implements ClaimViewService {
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private PrpLCompensateEarDao prpLCompensateEarDao;
	@Autowired
	private PrpLCheckDao prpLCheckDao;
	@Autowired
	private PrpLRegistDao prpLregistDao;
	@Autowired
	private PrpCmainApi prpCmainApi;
	@Autowired
	private PrpLverifyLossDao prpLverifyLossDao;
	@Autowired
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PrpLLTextDao prpLLTextDao;
	@Autowired
	private PrpLClaimLossDao prpLClaimLossDao;
	@Autowired
	private PrpDcurrencyApi prpDcurrencyApi;
	@Autowired
	private PrpDkindApi prpDkindApi;
	@Autowired
	private PrpLPropDao prpLPropDao;
	@Autowired
	private PrpDkindAgriApi prpDkindAgriApi;
	@Autowired
	private PrpCitemKindApi prpCitemKindApi;
	@Override 
	public void prepareCommonHead(ClaimPageInitResDto responseDto) {
		String claimNo = responseDto.getClaimNo();
		String registNo = responseDto.getRegistNo();
		PrpLRegist prpLregist = null;
		 PrpLClaimDtoExt prpLclaimDto = null;
		 PrpLverifyLoss prpLverifyLoss = null;
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("policyNo", responseDto.getPolicyNo());
		 PrpCmainDto prpCmainDto =  prpCmainApi.queryByPK(map);
		 List<PrpLLTextDto> prpLLTextDtoList = new ArrayList<PrpLLTextDto>();
		/*如果不为空，说明前面已经校验过，responseDto中已经有立案信息*/
		if(StringUtils.isNotBlank(claimNo)){
			prpLclaimDto = responseDto.getPrpLClaimDto();
			Specification<PrpLLText> specification = Specifications.<PrpLLText>and().eq("claimNo", claimNo).eq("textType", "09").build();
			List<PrpLLText> prplTextList = prpLLTextDao.findAll(specification,new Sort("lineNo"));
			this.convertCollection(prplTextList, prpLLTextDtoList, PrpLLTextDto.class);
		}else{
			/*无立案信息，从前面的查勘中取*/
			prpLregist = prpLregistDao.findOne(new PrpLRegistKey(registNo));
			prpLclaimDto = new PrpLClaimDtoExt();
			PrpLCheck prpLCheck = prpLCheckDao.findOne(new PrpLCheckKey(registNo, 1));
			if(null != prpLCheck){
            prpLclaimDto.setIndemnityDuty(prpLCheck.getIndemnityDuty());
            String indemnityDuty = prpLCheck.getIndemnityDuty();
            double indemnityDutyRate = 100;
            //转换赔偿责任
            if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("0")) {
                indemnityDutyRate = 100;
            } else if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("1")) {
                indemnityDutyRate = 70;
            } else if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("2")) {
                indemnityDutyRate = 50;
            } else if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("3")) {
                indemnityDutyRate = 30;
            } else if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("4")) {
                indemnityDutyRate = 0.0;
            } else if (StringUtils.isNotEmpty(indemnityDuty) && indemnityDuty.trim().equals("9")) {
                indemnityDutyRate = 0.0;
            }
            prpLclaimDto.setIndemnityDutyRate(indemnityDutyRate);
			}
            prpLclaimDto.setLossName(prpLregist.getLossName());
            prpLclaimDto.setRegistNo(prpLregist.getRegistNo());
            prpLclaimDto.setPolicyNo(responseDto.getPolicyNo());
            //自动理赔时添加非空校验 modify by wxy 2018/3/31
			if(prpLCheck!=null && StringUtils.isNotEmpty(prpLCheck.getDamageCode())){
				prpLclaimDto.setDamageCode(prpLCheck.getDamageCode());
				prpLclaimDto.setDamageName(prpLCheck.getDamageName());
			}else {
				prpLclaimDto.setDamageCode(prpLregist.getDamageCode());//prpLCheck
				prpLclaimDto.setDamageName(prpLregist.getDamageName());
			}
            prpLclaimDto.setDamageTypeCode(prpLregist.getDamageTypeCode());
            prpLclaimDto.setDamageTypeName(prpLregist.getDamageTypeName());
            prpLclaimDto.setDamageAreaCode(prpLregist.getDamageAreaCode());
            prpLclaimDto.setDamageAreaName(prpLregist.getDamageAreaName()); 
             //立案时出险地点取查勘的，如果没有就取报案的出险地点----------------------------------
             if ( prpLCheck==null || prpLCheck.getDamageAddress()==null || prpLCheck.getDamageAddress().equals("")){
             	 prpLclaimDto.setDamageAddress(prpLregist.getDamageAddress());
             	 prpLclaimDto.setDamageAddressType(prpLregist.getDamageAddressType());
             } else {
             	 prpLclaimDto.setDamageAddress(prpLCheck.getDamageAddress());
             	 prpLclaimDto.setDamageAddressType(prpLCheck.getDamageAddressType());
             }
             //赔案类别，如果查勘没有，就从报案取  modify by YANGABO 2008-01-16
             if ( prpLCheck==null || StringUtils.isEmpty(prpLCheck.getClaimType())){
            	 prpLclaimDto.setClaimType(prpLregist.getClaimType());
             }
             else{
            	 prpLclaimDto.setClaimType(prpLCheck.getClaimType());
             }
            prpLclaimDto.setRiskCode(responseDto.getRiskCode());  
            prpLclaimDto.setDamageStartDate(prpLregist.getDamageStartDate());
            prpLclaimDto.setDamageStartHour(prpLregist.getDamageStartHour());
            prpLclaimDto.setDamageEndDate(prpLregist.getDamageEndDate());
            prpLclaimDto.setDamageEndHour(prpLregist.getDamageEndHour());
            prpLclaimDto.setClassCode(prpLregist.getClassCode());
            prpLclaimDto.setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
            prpLclaimDto.setClaimTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
            prpLclaimDto.setInsuredCode(prpLregist.getInsuredCode());
            prpLclaimDto.setInsuredName(prpLregist.getInsuredName());
            prpLclaimDto.setCurrency(prpLregist.getEsticurrency());
            prpLclaimDto.setComCode(prpLregist.getComCode());
            prpLclaimDto.setAddressCode(prpLregist.getAddressCode());
            
            prpLclaimDto.setLanguage(prpLregist.getLanguage());
            prpLclaimDto.setLossName(prpLregist.getLossName());
            prpLclaimDto.setMakeCom(prpLregist.getMakeCom());
            prpLclaimDto.setHandler1Code(prpLregist.getHandler1Code());
            prpLclaimDto.setOperatorCode(responseDto.getUserCode());
            /*估损金额的获取，如果是查勘，定损，核损都可以立案，*/
            prpLclaimDto.setSumClaim(prpLregist.getEstimateLoss());
            /*设置默认的经办人*/
            prpLclaimDto.setHandlerCode(responseDto.getUserCode());
            prpLclaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
            prpLverifyLoss = prpLverifyLossDao.findOne(new PrpLverifyLossKey(registNo, " "));
            if(prpLverifyLoss != null){
            	// 如果赔付数量不为0说明存在核损环节并且在核损环节录入了数据
				prpLclaimDto.setLossesNumber(prpLverifyLoss
						.getLossEsnumBer());
				prpLclaimDto.setLossesUnitCode(prpLverifyLoss
						.getLossESunItCode());
				prpLclaimDto.setDamageInsured(prpLverifyLoss
						.getDamageInsured());
				prpLclaimDto.setDisasterArea(prpLverifyLoss
						.getDisasterArea());
				prpLclaimDto.setDisasterUnit(prpLverifyLoss
						.getDisasterUnit());
				prpLclaimDto.setAffectedArea(prpLverifyLoss
						.getAffectEDarea());
				prpLclaimDto.setAffectedUnit(prpLverifyLoss
						.getAffectedunit());
				prpLclaimDto.setNoProductionArea(prpLverifyLoss
						.getNoProductionArea());
				prpLclaimDto.setNoProductionUnit(prpLverifyLoss
						.getNoProductionUnit());
				prpLclaimDto.setDeathQuantity(prpLverifyLoss
						.getDeathQuantity());
				prpLclaimDto.setDeathUnit(prpLverifyLoss.getDeathUnit());
				prpLclaimDto.setKillQuantity(prpLverifyLoss
						.getKillQuantity());
				prpLclaimDto.setKillUnit(prpLverifyLoss.getKillUnit());
            }
            prpLclaimDto.setAgentCode(prpCmainDto.getAgentCode());
            prpLclaimDto.setPolicyNo(prpCmainDto.getPolicyNo());
            prpLclaimDto.setSumAmount(prpCmainDto.getSumAmount());
            prpLclaimDto.setHandler1Code(prpCmainDto.getHandler1Code());
            prpLclaimDto.setComCode(prpCmainDto.getComCode());
            prpLclaimDto.setInsuredCode(prpCmainDto.getInsuredCode());
           
			
			prpLclaimDto.setInsuredName(prpCmainDto.getInsuredName());
			prpLclaimDto.setSumAmount(prpCmainDto.getSumAmount());
			Double sumPremium = prpCmainDto.getSumPremium();
			String str = (sumPremium+"").split("\\.")[0];
            prpLclaimDto.setSumPremium(Integer.parseInt(str));
            prpLclaimDto.setBusinessNature(prpCmainDto.getBusinessNature());
            prpLclaimDto.setPolicyType(prpCmainDto.getPolicyType());
            prpLclaimDto.setCurrency(prpCmainDto.getCurrency());
            prpLclaimDto.setRiskCode(prpCmainDto.getRiskCode());
            prpLclaimDto.setStartDate(prpCmainDto.getStartDate());
            prpLclaimDto.setEndDate(prpCmainDto.getEndDate());
            prpLclaimDto.setStartHour (prpCmainDto.getStartHour ());
            prpLclaimDto.setEndHour (prpCmainDto.getEndHour ());
            prpLclaimDto.setAgentCode(prpCmainDto.getAgentCode());
            prpLclaimDto.setOtherFlag(prpLclaimDto.getOtherFlag());
            prpLclaimDto.setCatastropheCode1(prpLregist.getCatastropheCode1());
            prpLclaimDto.setCatastropheName1(prpLregist.getCatastropheName1());
            prpLclaimDto.setCatastropheCode2(prpLregist.getCatastropheCode2());
            prpLclaimDto.setCatastropheName2(prpLregist.getCatastropheName2());
            prpLclaimDto.setLFlag("L");
            if (prpLregist.getLossQuantity() != null){
				prpLclaimDto.setLossQuantity(Integer.parseInt(prpLregist.getLossQuantity().toString().split("\\.")[0]));
			}
            prpLclaimDto.setAddressCode(prpLregist.getAddressCode()==null?"":prpLregist.getAddressCode());
            Specification<PrpLRegistText> specification = Specifications.<PrpLRegistText>and().eq("registNo",registNo).eq("textType", "3").build();
            List<PrpLRegistText> PrpLRegistTextList = prpLRegistTextDao.findAll(specification,new Sort("lineNo"));
		    for (PrpLRegistText prpLRegistText : PrpLRegistTextList) {
		    	PrpLLTextDto prpLLTextDto = new PrpLLTextDto();
		    	prpLLTextDto.setTextType(prpLRegistText.getTextType());
		    	prpLLTextDto.setContext(prpLRegistText.getContext());
		    	prpLLTextDtoList.add(prpLLTextDto);
			}
		    this.pageInitCommonService.copyPropertiesIfNull(prpLregist, prpLclaimDto);
		}
		prpLclaimDto.setLlflag(prpLclaimDto.getLFlag());
		/*把保单信息设置到返参对象，进行传输，后面不查询数据库*/
		responseDto.setPrpCmainDto(prpCmainDto);
		/*页面头信息*/
		responseDto.setPrpLClaimDto(prpLclaimDto);
		/*出险摘要文本信息*/
		responseDto.setPrpLLTextDtoList(prpLLTextDtoList);
	}
    
	@Override
	public void prepareCompensateEar(ClaimPageInitResDto responseDto) {
		String registNo = responseDto.getRegistNo();
		String riskCode = responseDto.getRiskCode();
		/*设置耳标号*/
		String taskCode = pageInitCommonService.getConfigRules("FamilySplittingFlag","claim");
		String earFlag = "0";
		List<PrpLCompensateEarDto> prpLCompensateEarDtoList = null;
	    if (riskCode != null && taskCode.indexOf(riskCode) > -1) {
			Specification<PrpLCompensateEar> specification = Specifications.<PrpLCompensateEar>and().eq("registNo", registNo).eq("nodeType", "check").eq("businessNo", registNo).build();
			List<PrpLCompensateEar> prpLCompensateEarList = prpLCompensateEarDao.findAll(specification);
			prpLCompensateEarDtoList = new ArrayList<PrpLCompensateEarDto>();
			this.convertCollection(prpLCompensateEarList, prpLCompensateEarDtoList, PrpLCompensateEarDto.class);
			earFlag="1";
		}
	    responseDto.setEarFlag(earFlag);
	    responseDto.setPrpLCompensateEarDtoList(prpLCompensateEarDtoList);
	}

	@Override
	public void prepareDangerUnit(ClaimPageInitResDto responseDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareCommonClaimLoss(ClaimPageInitResDto responseDto) {
		String claimNo = responseDto.getClaimNo();
		List<PrpLClaimLossDtoExt> prpLClaimLossDtoExtList =  new ArrayList<PrpLClaimLossDtoExt>();
		List<PrpLClaimLoss> prpLClaimLossList = prpLClaimLossDao.findAll(Specifications.<PrpLClaimLoss>and().eq("claimNo", claimNo).build(),new Sort("serialNo"));
		for (int i = 0; prpLClaimLossList!=null&& prpLClaimLossList.size()>0 && i< prpLClaimLossList.size(); i++) {
			PrpLClaimLoss prpLClaimLoss = prpLClaimLossList.get(i);
			PrpLClaimLossDtoExt prpLClaimLossDtoExt = new PrpLClaimLossDtoExt();
			Map<String,Object> map = new HashMap<>();
			map.put("riskCode", responseDto.getRiskCode());
			map.put("kindCode", prpLClaimLoss.getKindCode() == null?"":prpLClaimLoss.getKindCode());
			PrpDkindDto prpdKind = prpDkindApi.queryByPK(responseDto.getRiskCode(), prpLClaimLoss.getKindCode() == null?"":prpLClaimLoss.getKindCode());
			PrpDcurrencyDto prpDcurrencyDto = prpDcurrencyApi.queryByPK(prpLClaimLoss.getCurrency());
			prpLClaimLossDtoExt.setKindName(prpdKind == null?"":prpdKind.getKindCName());
			prpLClaimLossDtoExt.setCurrencyName(prpDcurrencyDto.getCurrencyCName());
			pageInitCommonService.copyPropertiesIfNull(prpLClaimLoss, prpLClaimLossDtoExt);
			prpLClaimLossDtoExtList.add(prpLClaimLossDtoExt);
		}
		if(null == prpLClaimLossList || prpLClaimLossList.size() <1){
			List<PrpLProp> prpLPropList = prpLPropDao.findAll(Specifications.<PrpLProp>and().eq("registNo", responseDto.getRegistNo()).build());
			for (int i = 0; prpLPropList!=null&& i < prpLPropList.size(); i++) {
				PrpLProp prpLProp = prpLPropList.get(i);
				PrpLClaimLossDtoExt prpLClaimLossDtoExt = new PrpLClaimLossDtoExt();
				Map<String,Object> map = new HashMap<>();
				map.put("policyNo", responseDto.getPolicyNo());
				map.put("kindCode", prpLProp.getKindCode() == null?"":prpLProp.getKindCode());
				PrpCitemKindDto itemKindDto = prpCitemKindApi.queryByPK(map);
				//PrpDcurrencyDto prpDcurrencyDto = prpDcurrencyApi.queryByPK(prpLProp.getCurrency());
				prpLClaimLossDtoExt.setKindName(itemKindDto == null?"":itemKindDto.getKindName());
				//prpLClaimLossDtoExt.setCurrencyName(prpDcurrencyDto.getCurrencyCname());
				prpLClaimLossDtoExt.setItemDetailName(prpLProp.getLossItemName());
				prpLClaimLossDtoExt.setInputDate((new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY)));
				pageInitCommonService.copyPropertiesIfNull(prpLProp, prpLClaimLossDtoExt);
				prpLClaimLossDtoExt.setClaimNo(null);
				prpLClaimLossDtoExtList.add(prpLClaimLossDtoExt);
			}
		}
		responseDto.setPrpLclaimLossDtoList(prpLClaimLossDtoExtList);
	}

}