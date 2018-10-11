package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimPolicyDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimPolicyDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimPolicy;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimPolicyKey;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimPolicyService;
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
 * @time  2017-11-08 05:39:53.061 
 * @description 立案保单清单表Core接口实现
 */
@Service
public class PrpLClaimPolicyServiceImpl extends BaseServiceImpl implements PrpLClaimPolicyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimPolicyServiceImpl.class);
    
    @Autowired
    private PrpLClaimPolicyDao prpLClaimPolicyDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimPolicyDto prpLClaimPolicyDto) {
        PrpLClaimPolicy prpLClaimPolicy = this.convert(prpLClaimPolicyDto, PrpLClaimPolicy.class);
        prpLClaimPolicyDao.save(prpLClaimPolicy);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo) {
        PrpLClaimPolicyKey prpLClaimPolicyKey = new PrpLClaimPolicyKey(claimNo);
        prpLClaimPolicyDao.delete(prpLClaimPolicyKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimPolicyDto prpLClaimPolicyDto) {
        PrpLClaimPolicy prpLClaimPolicy = this.convert(prpLClaimPolicyDto, PrpLClaimPolicy.class);
        prpLClaimPolicyDao.save(prpLClaimPolicy);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimPolicyDto queryByPK(String claimNo) {
        PrpLClaimPolicyKey prpLClaimPolicyKey = new PrpLClaimPolicyKey(claimNo);
        PrpLClaimPolicy prpLClaimPolicy = prpLClaimPolicyDao.findOne(prpLClaimPolicyKey);
        return this.convert(prpLClaimPolicy,PrpLClaimPolicyDto.class);
    }
}