package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDRiskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.core.kernel.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/risk")
public class RiskController implements RiskApi{

	@Autowired
	private RiskService riskService;

	@Override
	public ResponseDto getRiskList(@RequestBody RiskQueryConditionDto riskQueryConditionDto)
			throws Exception
	{
		List<PrpDRiskDto> prpDRiskDtoList = new ArrayList<PrpDRiskDto>();
		prpDRiskDtoList = riskService.getRiskList(riskQueryConditionDto);
		return ResponseDto.instance(prpDRiskDtoList);
	}

	@Override
	public PrpDRiskDto getRisk(RiskQueryConditionDto conditionDto) {
		return riskService.getRisk(conditionDto);
	}
}
