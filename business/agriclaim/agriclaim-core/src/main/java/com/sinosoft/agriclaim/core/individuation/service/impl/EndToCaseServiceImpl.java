package com.sinosoft.agriclaim.core.individuation.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLclaimStatusApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.PrpLLTextApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.endcasemanage.PrpLCaseNoApi;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.agriclaim.core.individuation.entity.EndCaseDto;
import com.sinosoft.agriclaim.core.individuation.service.EndToCaseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
/**
 * jiaoyunzhen  2018年1月5日16:48:34
 * @author Administrator
 *
 */
@Service
public class EndToCaseServiceImpl extends BaseServiceImpl implements EndToCaseService{
	
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLsumpayLogServiceImpl.class);
    @Autowired
    private PrpLClaimApi prpLClaimApi;
    @Autowired 
    private PrpLclaimStatusApi prpLclaimStatusApi;
    @Autowired
    private PrpLLTextApi prpLLTextApi;
    @Autowired
    private PrpLCaseNoApi prpLCaseNoApi;
    @Autowired
    private PrpLCompensateApi prpCompensateApi;
	@Override
	@Transactional
	public void save(EndCaseDto endCaseDto) throws Exception {
		try{
		prpLClaimApi.save(endCaseDto.getPrpLclaimDto());
		prpLclaimStatusApi.save(endCaseDto.getPrpLclaimStatusDto());
		
		for(int i=0;i<endCaseDto.getPrpLltextDtoList().size();i++){
			prpLLTextApi.save((PrpLLTextDto) endCaseDto.getPrpLltextDtoList().get(i));
		}
		for(int i=0;i<endCaseDto.getPrpLcaseNoDtoList().size();i++){
			prpLCaseNoApi.save((PrpLCaseNoDto) endCaseDto.getPrpLcaseNoDtoList().get(i));
		}
		for(int i=0;i<endCaseDto.getPrpLcompensateDtoList().size();i++){
			prpCompensateApi.save( (PrpLCompensateDto) endCaseDto.getPrpLcompensateDtoList().get(i));
		}
		}catch (Exception e) {
			throw new Exception("回写失败");
		}
	}

}
