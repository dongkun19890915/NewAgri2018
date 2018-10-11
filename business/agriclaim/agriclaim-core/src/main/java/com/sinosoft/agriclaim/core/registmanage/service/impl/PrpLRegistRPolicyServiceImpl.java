package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistRPolicyDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistRPolicy;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistRPolicyKey;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistRPolicyService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 赔案保单关联表Core接口实现
 */
@Service
public class PrpLRegistRPolicyServiceImpl extends BaseServiceImpl implements PrpLRegistRPolicyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRegistRPolicyServiceImpl.class);
    
    @Autowired
    private PrpLRegistRPolicyDao prpLRegistRPolicyDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
        PrpLRegistRPolicy prpLRegistRPolicy = this.convert(prpLRegistRPolicyDto, PrpLRegistRPolicy.class);
        prpLRegistRPolicyDao.save(prpLRegistRPolicy);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String policyNo) {
        PrpLRegistRPolicyKey prpLRegistRPolicyKey = new PrpLRegistRPolicyKey(registNo,policyNo);
        prpLRegistRPolicyDao.delete(prpLRegistRPolicyKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
        PrpLRegistRPolicy prpLRegistRPolicy = this.convert(prpLRegistRPolicyDto, PrpLRegistRPolicy.class);
        prpLRegistRPolicyDao.save(prpLRegistRPolicy);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistRPolicyDto queryByPK(String registNo,String policyNo) {
        PrpLRegistRPolicyKey prpLRegistRPolicyKey = new PrpLRegistRPolicyKey(registNo,policyNo);
        PrpLRegistRPolicy prpLRegistRPolicy = prpLRegistRPolicyDao.findOne(prpLRegistRPolicyKey);
        return this.convert(prpLRegistRPolicy,PrpLRegistRPolicyDto.class);
    }
}