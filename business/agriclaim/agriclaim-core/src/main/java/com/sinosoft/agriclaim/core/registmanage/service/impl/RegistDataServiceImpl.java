package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.registmanage.dto.*;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.registmanage.dao.*;
import com.sinosoft.agriclaim.core.registmanage.entity.*;
import com.sinosoft.agriclaim.core.registmanage.service.RegistDataService;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleItemDao;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItem;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 类功能简述：查询报案登记大对象<p>
 * @author chong
 * @date 2017年11月9日下午11:27:42
 */
@Service
public class RegistDataServiceImpl extends BaseServiceImpl implements RegistDataService {
	@Autowired
	private PrpLRegistDao prpLRegistDao;
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
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PrpLRelatePersonDao prpLRelatePersonDao;
	@Autowired
	private PrpLScheduleMainWfDao prpLScheduleMainWfDao;
	@Autowired
	private PrpLAccIPersonDao prpLAccIPersonDao;
	@Autowired
	private PrpLScheduleItemDao prpLScheduleItemDao;
	
	@Override
	public RegistDto findRegistDtoByRegistNo(String registNo) {
		RegistDto registDto = new RegistDto();
		/*立案基本信息表*/
		List<PrpLClaim> prplClaimList = prpLClaimDao.findAll(Specifications.<PrpLClaim>and().eq("registNo", registNo).build());
		List<PrpLClaimDto> prplClaimDtoList = new ArrayList<PrpLClaimDto>();
		this.convertCollection(prplClaimList, prplClaimDtoList, PrpLClaimDto.class);
		registDto.setPrpLclaimDtoList(prplClaimDtoList);
		
		PrpLRegist prplRegist = prpLRegistDao.findOne(new PrpLRegistKey(registNo));
		//prplExtDao.findOne(new PrplExtKey(certiNo, certiType));
		registDto.setPrpLRegistDto(this.convert(prplRegist, PrpLRegistDto.class));
		
		List<PrpLRegistExt> regsitExtList = prpLRegistExtDao.findAll(Specifications.<PrpLRegistExt>and().eq("registNo", registNo).build());
		List<PrpLRegistExtDto> regsitExtDtoList = new ArrayList<PrpLRegistExtDto>();
		this.convertCollection(regsitExtList, regsitExtDtoList, PrpLRegistExtDto.class);
		registDto.setPrpLregistExtDtoList(regsitExtDtoList);
		
		/*报案文字表*/
		List<PrpLRegistText> registTextList = prpLRegistTextDao.findAll(Specifications.<PrpLRegistText>and().eq("registNo", registNo).build(),new Sort("lineNo"));
		List<PrpLRegistTextDto> registTextDtoList =new ArrayList<PrpLRegistTextDto>();
		this.convertCollection(registTextList, registTextDtoList, PrpLRegistTextDto.class);
		registDto.setPrpLregistTextDtoList(registTextDtoList);
		
		/*联系人表*/
		List<PrpLRelatePerson> personList = prpLRelatePersonDao.findAll(Specifications.<PrpLRelatePerson>and().eq("registNo", registNo).build());
		List<PrpLRelatePersonDto> personDtoList =new ArrayList<PrpLRelatePersonDto>();
		this.convertCollection(personList, personDtoList, PrpLRelatePersonDto.class);
		registDto.setPrpLrelatePersonDtoList(personList);
		/*调度任务/查勘任务主表*/
		PrpLScheduleMainWf mainWf = prpLScheduleMainWfDao.findOne(new PrpLScheduleMainWfKey(1, registNo));
		registDto.setPrpLscheduleMainWFDto((this.convert(mainWf, PrpLScheduleMainWfDto.class)));
		List<PrpLScheduleItem> scheduleItemList = prpLScheduleItemDao.findAll(Specifications.<PrpLScheduleItem>and().eq("registNo", registNo).eq("scheduleId", "1").build());
		List<PrpLScheduleItemDto> scheduleItemDtoList = new ArrayList<PrpLScheduleItemDto>();
		this.convertCollection(scheduleItemList, scheduleItemDtoList, PrpLScheduleItemDto.class);
		registDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
		/*理赔分户清单表*/
		List<PrpLCompensateEar> earList = prpLCompensateEarDao.findAll(Specifications.<PrpLCompensateEar>and().eq("registNo", registNo).eq("nodeType", "regis").eq("businessNo", registNo).build());
		List<PrpLCompensateEarDto> earDtoList = new ArrayList<PrpLCompensateEarDto>();
		this.convertCollection(earList, earDtoList, PrpLCompensateEarDto.class);
		registDto.setPrpLcompensateEarDtoList(earDtoList);
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
	    registDto.setPrplacciBenPersonDtoList(personsDto);
	   //强三关联查询 
	    List<PrpLRegistRPolicy> policyList = prpLRegistRPolicyDao.findAll(Specifications.<PrpLRegistRPolicy>and().eq("registNo", registNo).eq("validStatus", "1").build());
	    List<PrpLRegistRPolicyDto> policyDtoList =new ArrayList<PrpLRegistRPolicyDto>();
	    this.convertCollection(policyList, policyDtoList, PrpLRegistRPolicyDto.class);
	    registDto.setPrpLRegistRPolicyDtoList(policyDtoList);
	   
	    return registDto;
	
	}

}
