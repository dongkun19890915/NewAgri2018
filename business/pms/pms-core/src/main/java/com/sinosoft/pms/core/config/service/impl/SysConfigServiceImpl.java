package com.sinosoft.pms.core.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.api.config.dto.UtiPlatConfigRuleDto;
import com.sinosoft.pms.core.config.service.SysConfigService;
import com.sinosoft.pms.core.config.service.UtiPlatConfigRuleService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	UtiPlatConfigRuleService utiPlatConfigRuleService;
	
	@Override
	@Cacheable(value="SysConfig_getValue",key="#key")
	public String getValue(String key) throws Exception {
		if(StringUtils.isEmpty(key)){
			throw new Exception("key不能为空");
		}
		/**systemcode暂时不考虑*/
		List<UtiPlatConfigRuleDto> dtolist = utiPlatConfigRuleService.query(key, "");
		StringBuffer str = new StringBuffer();
		for(UtiPlatConfigRuleDto dto : dtolist){
			str.append(dto.getRule());
		}
		if(StringUtils.isEmpty(str.toString())){
			return null;
		}
		return str.toString();
	}

}
