package com.sinosoft.pms.core.config.service.impl;

import com.sinosoft.pms.api.config.dto.UtiPlatConfigRuleDto;
import com.sinosoft.pms.core.config.dao.UtiPlatConfigRuleDao;
import com.sinosoft.pms.core.config.dao.specification.UtiPlatConfigRuleSpecBuilder;
import com.sinosoft.pms.core.config.entity.UtiPlatConfigRule;
import com.sinosoft.pms.core.config.entity.UtiPlatConfigRuleKey;
import com.sinosoft.pms.core.config.service.UtiPlatConfigRuleService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 平台配置规则表Core接口实现
 */
@Service
public class UtiPlatConfigRuleServiceImpl extends BaseServiceImpl implements UtiPlatConfigRuleService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiPlatConfigRuleServiceImpl.class);
    
    @Autowired
    private UtiPlatConfigRuleDao utiPlatConfigRuleDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        UtiPlatConfigRule utiPlatConfigRule = this.convert(utiPlatConfigRuleDto, UtiPlatConfigRule.class);
        utiPlatConfigRuleDao.save(utiPlatConfigRule);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String systemCode,String paramCode,java.lang.Integer serialNo) {
        UtiPlatConfigRuleKey utiPlatConfigRuleKey = new UtiPlatConfigRuleKey(systemCode,paramCode,serialNo);
        utiPlatConfigRuleDao.delete(utiPlatConfigRuleKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        UtiPlatConfigRule utiPlatConfigRule = this.convert(utiPlatConfigRuleDto, UtiPlatConfigRule.class);
        utiPlatConfigRuleDao.save(utiPlatConfigRule);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiPlatConfigRuleDto queryByPK(String systemCode,String paramCode,java.lang.Integer serialNo) {
        UtiPlatConfigRuleKey utiPlatConfigRuleKey = new UtiPlatConfigRuleKey(systemCode,paramCode,serialNo);
        UtiPlatConfigRule utiPlatConfigRule = utiPlatConfigRuleDao.findOne(utiPlatConfigRuleKey);
        return this.convert(utiPlatConfigRule,UtiPlatConfigRuleDto.class);
    }
    
    
	@Override
	public List<UtiPlatConfigRuleDto> query(String paramCode, String systemCode) throws Exception {
		UtiPlatConfigRule utiPlatConfigRule = new UtiPlatConfigRule();
		utiPlatConfigRule.setParamCode(paramCode);
		utiPlatConfigRule.setSystemCode(systemCode);
		Sort.Order order = new Sort.Order(Sort.Direction.ASC,"serialNo");
		Sort sort = new Sort(order);
		List<UtiPlatConfigRule> entitylist = utiPlatConfigRuleDao.findAll(UtiPlatConfigRuleSpecBuilder.genCondition(utiPlatConfigRule), sort);
		List<UtiPlatConfigRuleDto> dtolist = new ArrayList<UtiPlatConfigRuleDto>();
		this.convertCollection(entitylist, dtolist, UtiPlatConfigRuleDto.class);
		return dtolist;
	}
}