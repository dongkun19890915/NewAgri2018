package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimFeeDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimFeeDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimFee;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimFeeKey;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimFeeService;
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
 * @description 估损金额表Core接口实现
 */
@Service
public class PrpLClaimFeeServiceImpl extends BaseServiceImpl implements PrpLClaimFeeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimFeeServiceImpl.class);
    
    @Autowired
    private PrpLClaimFeeDao prpLClaimFeeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimFeeDto prpLClaimFeeDto) {
        PrpLClaimFee prpLClaimFee = this.convert(prpLClaimFeeDto, PrpLClaimFee.class);
        prpLClaimFeeDao.save(prpLClaimFee);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,String currency) {
        PrpLClaimFeeKey prpLClaimFeeKey = new PrpLClaimFeeKey(claimNo,currency);
        prpLClaimFeeDao.delete(prpLClaimFeeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimFeeDto prpLClaimFeeDto) {
        PrpLClaimFee prpLClaimFee = this.convert(prpLClaimFeeDto, PrpLClaimFee.class);
        prpLClaimFeeDao.save(prpLClaimFee);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimFeeDto queryByPK(String claimNo,String currency) {
        PrpLClaimFeeKey prpLClaimFeeKey = new PrpLClaimFeeKey(claimNo,currency);
        PrpLClaimFee prpLClaimFee = prpLClaimFeeDao.findOne(prpLClaimFeeKey);
        return this.convert(prpLClaimFee,PrpLClaimFeeDto.class);
    }
}