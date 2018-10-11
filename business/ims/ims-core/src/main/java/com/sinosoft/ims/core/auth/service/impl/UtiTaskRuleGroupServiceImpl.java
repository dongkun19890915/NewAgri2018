package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiTaskRuleGroupDto;
import com.sinosoft.ims.core.auth.dao.UtiTaskRuleGroupDao;
import com.sinosoft.ims.core.auth.entity.UtiTaskRuleGroup;
import com.sinosoft.ims.core.auth.entity.UtiTaskRuleGroupKey;
import com.sinosoft.ims.core.auth.service.UtiTaskRuleGroupService;
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
 * @description UtiTaskRuleGroupCore接口实现
 */
@Service
public class UtiTaskRuleGroupServiceImpl extends BaseServiceImpl implements UtiTaskRuleGroupService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiTaskRuleGroupServiceImpl.class);
    
    @Autowired
    private UtiTaskRuleGroupDao utiTaskRuleGroupDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiTaskRuleGroupDto utiTaskRuleGroupDto) {
        UtiTaskRuleGroup utiTaskRuleGroup = this.convert(utiTaskRuleGroupDto, UtiTaskRuleGroup.class);
        utiTaskRuleGroupDao.save(utiTaskRuleGroup);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String ruleGroupCode) {
        UtiTaskRuleGroupKey utiTaskRuleGroupKey = new UtiTaskRuleGroupKey(ruleGroupCode);
        utiTaskRuleGroupDao.delete(utiTaskRuleGroupKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiTaskRuleGroupDto utiTaskRuleGroupDto) {
        UtiTaskRuleGroup utiTaskRuleGroup = this.convert(utiTaskRuleGroupDto, UtiTaskRuleGroup.class);
        utiTaskRuleGroupDao.save(utiTaskRuleGroup);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiTaskRuleGroupDto queryByPK(String ruleGroupCode) {
        UtiTaskRuleGroupKey utiTaskRuleGroupKey = new UtiTaskRuleGroupKey(ruleGroupCode);
        UtiTaskRuleGroup utiTaskRuleGroup = utiTaskRuleGroupDao.findOne(utiTaskRuleGroupKey);
        return this.convert(utiTaskRuleGroup,UtiTaskRuleGroupDto.class);
    }
}