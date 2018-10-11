package com.sinosoft.pms.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.api.config.SysConfigApi;
import com.sinosoft.pms.core.config.service.SysConfigService;


@RestController
@RequestMapping(value = SysConfigApi.PATH)
public class SysConfigController implements SysConfigApi{
	@Autowired
	SysConfigService sysConfigService;
	@Override
	public String getValue(String key) throws Exception {
		return sysConfigService.getValue(key);
	}

}
