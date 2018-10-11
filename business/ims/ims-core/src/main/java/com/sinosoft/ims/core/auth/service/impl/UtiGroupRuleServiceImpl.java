package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiGroupRuleDto;
import com.sinosoft.ims.core.auth.dao.UtiGroupRuleDao;
import com.sinosoft.ims.core.auth.entity.UtiGroupRule;
import com.sinosoft.ims.core.auth.entity.UtiGroupRuleKey;
import com.sinosoft.ims.core.auth.service.UtiGroupRuleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupRuleCore接口实现
 */
@Service
public class UtiGroupRuleServiceImpl extends BaseServiceImpl implements UtiGroupRuleService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiGroupRuleServiceImpl.class);
    
    @Autowired
    private UtiGroupRuleDao utiGroupRuleDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiGroupRuleDto utiGroupRuleDto) {
        UtiGroupRule utiGroupRule = this.convert(utiGroupRuleDto, UtiGroupRule.class);
        utiGroupRuleDao.save(utiGroupRule);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String groupCode,Integer serialNo) {
        UtiGroupRuleKey utiGroupRuleKey = new UtiGroupRuleKey(groupCode,serialNo);
        utiGroupRuleDao.delete(utiGroupRuleKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiGroupRuleDto utiGroupRuleDto) {
        UtiGroupRule utiGroupRule = this.convert(utiGroupRuleDto, UtiGroupRule.class);
        utiGroupRuleDao.save(utiGroupRule);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGroupRuleDto queryByPK(String groupCode,Integer serialNo) {
        UtiGroupRuleKey utiGroupRuleKey = new UtiGroupRuleKey(groupCode,serialNo);
        UtiGroupRule utiGroupRule = utiGroupRuleDao.findOne(utiGroupRuleKey);
        return this.convert(utiGroupRule,UtiGroupRuleDto.class);
    }
}