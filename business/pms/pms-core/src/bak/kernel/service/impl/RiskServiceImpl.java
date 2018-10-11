package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDRiskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.core.kernel.dao.PrpDRiskDao;
import com.sinosoft.pms.core.kernel.entity.PrpDRisk;
import com.sinosoft.pms.core.kernel.entity.PrpDRiskKey;
import com.sinosoft.pms.core.kernel.service.RiskService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskServiceImpl extends BaseServiceImpl implements RiskService {
    
    private static Log LOGGER = LogFactory.getLog(RiskServiceImpl.class);
    
    @Autowired
    PrpDRiskDao prpDRiskDao ;
    
    /**
     * @description 根据险种代码获取险种相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    @Override
    public PrpDRiskDto getRisk(RiskQueryConditionDto conditionDto){
        PrpDRiskDto riskReturnDto = new PrpDRiskDto();
        PrpDRiskKey key = new PrpDRiskKey();
        String riskCode = conditionDto.getRiskCode();
        LOGGER.error("------入参的产品代码-----"+riskCode+"------------------");
        if(riskCode!=null){
            key.setRiskCode(riskCode);
            PrpDRisk riskInfo = prpDRiskDao.findOne(key);
            LOGGER.error("------入参的产品代码2222-----"+riskCode+"------------------");
            if(riskInfo!=null){
                riskReturnDto = this.convert(riskInfo,PrpDRiskDto.class);
                riskReturnDto.setResultCode("Y");
                riskReturnDto.setResultMsg("查询成功，数据已返回");
            }else{
                riskReturnDto.setResultCode("N");
                riskReturnDto.setResultMsg("没有符合查询条件的数据");
            }
        }else{
            riskReturnDto.setResultCode("N");
            riskReturnDto.setResultMsg("查询条件为空");
        }
        return riskReturnDto;
    }
    
    /**
     * @description 获取所有险种相关信息
     * @return List<PrpDRiskDto> 
     * @author chengzhuo
     * @date 2016年10月24日上午9:34:15
     */
	@Override
	public List<PrpDRiskDto> getRiskList(RiskQueryConditionDto conditionDto) {
		List<PrpDRiskDto> prpDRiskDtoList = new ArrayList<PrpDRiskDto>();
		List<PrpDRisk> prpDRiskList = prpDRiskDao.findAll(Specifications.<PrpDRisk>and()
                .eq(StringUtils.isNotEmpty(conditionDto.getValidInd()),"validInd",conditionDto.getValidInd())
                .build());
		this.convertCollection(prpDRiskList,prpDRiskDtoList,PrpDRiskDto.class);
		return prpDRiskDtoList;
	}
}
