package com.sinosoft.agriclaim.core.endcasemanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.endcasemanage.dto.EndCaseDto;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimService;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.endcasemanage.dao.PrpLCaseNoDao;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNo;
import com.sinosoft.agriclaim.core.endcasemanage.service.EndCaseService;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;

@Service
public class EndCaseServiceImpl extends BaseServiceImpl  implements EndCaseService {

	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCaseNoServiceImpl.class);

    @Autowired
    private PrpLCaseNoDao prpLCaseNoDao;
    @Autowired
    private PrpLLTextDao prpLLTextDao;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Autowired
    private PrpLClaimService prpLClaimService;
    @Autowired
    private PrpLPrepayDao prpLPrepayDao;
    
    
    /**
     *@description 按ClaimNo查询实体
     *@param 
     */
	@Override
	public EndCaseDto findByClaimNo(String claimNo) {
		
		EndCaseDto endCaseDto = new EndCaseDto();
		//根据claimNo 查prpLcaseNo表中数据
		List<PrpLCaseNo> prpLcaseNoList = new ArrayList<PrpLCaseNo>();
		prpLcaseNoList = prpLCaseNoDao.findAll(Specifications.<PrpLCaseNo>and()
				.eq(StringUtils.isNotEmpty(claimNo), "claimNo",
						claimNo)
				.build());
		List<PrpLCaseNoDto> prpLCaseNoDtoList = new ArrayList<PrpLCaseNoDto>();
		this.convertCollection(prpLcaseNoList, prpLCaseNoDtoList, PrpLCaseNoDto.class);
		endCaseDto.setPrpLcaseNoDtoList(prpLCaseNoDtoList);
		

		//根据claimNo与textType 查prpLLText表中数据
		PrpLLText prpLLText = new PrpLLText();
		prpLLText.setTextType("08");
		List<PrpLLText> prpLLTextList = new ArrayList<PrpLLText>();
		
		prpLLTextList = prpLLTextDao.findAll(Specifications.<PrpLLText>and()
				.eq(StringUtils.isNotEmpty(claimNo), "claimNo",
						claimNo)
				.eq(StringUtils.isNotEmpty(prpLLText.getTextType()), "textType",
						prpLLText.getTextType())
				.build());
		List<PrpLLTextDto> prpLLTextDtoList = new ArrayList<PrpLLTextDto>();
		this.convertCollection(prpLLTextList, prpLLTextDtoList, PrpLLTextDto.class);
		endCaseDto.setPrpLltextDtoList(prpLLTextDtoList);
		
		//如果有结案提交的结案报告，就显示结案提交的结案报告；如果没有就显示理算提交的结案报告。
		if(endCaseDto.getPrpLltextDtoList().size() == 0){
			
			List<PrpLCompensate> prpLCompensateList = new ArrayList<PrpLCompensate>();
			prpLCompensateList = prpLCompensateDao.findAll(Specifications.<PrpLCompensate>and()
					.eq(StringUtils.isNotEmpty(claimNo), "claimNo",
							claimNo)
					.build(),new Sort(Sort.Direction.DESC,"compensateNo"));
			if(prpLCompensateList != null && prpLCaseNoDtoList.size() > 0 ){
				
				PrpLCompensate prpLCompensate = prpLCompensateList.iterator().next();
				PrpLCompensateDto prpLCompensateDto = this.convert(prpLCompensate, PrpLCompensateDto.class);
				String compensateNo = prpLCompensateDto.getCompensateNo();
				
				prpLLText.setTextType("28");
				List<PrpLLText> prpLLTextList_1 = new ArrayList<PrpLLText>();
				prpLLTextList_1 = prpLLTextDao.findAll(Specifications.<PrpLLText>and()
						.eq(StringUtils.isNotEmpty(claimNo), "claimNo",
								compensateNo)
						.eq(StringUtils.isNotEmpty(prpLLText.getTextType()), "textType",
								prpLLText.getTextType())
						.build());
				List<PrpLLTextDto> prpLLTextDtoList_1 = new ArrayList<PrpLLTextDto>();
				this.convertCollection(prpLLTextList_1, prpLLTextDtoList_1, PrpLLTextDto.class);
				endCaseDto.setPrpLltextDtoList(prpLLTextDtoList_1);
			}
		}
		if(endCaseDto.getPrpLltextDtoList().size() == 0){
			
			prpLLText.setTextType("28");
			List<PrpLLText> prpLLTextList_1 = new ArrayList<PrpLLText>();
			prpLLTextList_1 = prpLLTextDao.findAll(Specifications.<PrpLLText>and()
					.eq(StringUtils.isNotEmpty(claimNo), "claimNo",
							claimNo)
					.eq(StringUtils.isNotEmpty(prpLLText.getTextType()), "textType",
							prpLLText.getTextType())
					.build());
			List<PrpLLTextDto> prpLLTextDtoList_1 = new ArrayList<PrpLLTextDto>();
			this.convertCollection(prpLLTextList_1, prpLLTextDtoList_1, PrpLLTextDto.class);
			endCaseDto.setPrpLltextDtoList(prpLLTextDtoList_1);
		}
		//根据主键查询prpClaim表
		PrpLClaimDto prpLClaimDto = prpLClaimService.queryByPK(claimNo);
		endCaseDto.setPrpLClaimDto(prpLClaimDto);
		
		List<String> underWriteFlagList = new ArrayList<String>();
		underWriteFlagList.add("1");
		underWriteFlagList.add("3");
		List<PrpLPrepay> prpLPrepayList = prpLPrepayDao.queryByCondition(claimNo, underWriteFlagList);
		List<PrpLPrepayDto> prpLPrepayDtoList = new ArrayList<PrpLPrepayDto>();
		this.convertCollection(prpLPrepayList, prpLPrepayDtoList, PrpLPrepayDto.class);
		endCaseDto.setPrpLprepayDtoList(prpLPrepayDtoList);
		
		return endCaseDto;
	}
}
