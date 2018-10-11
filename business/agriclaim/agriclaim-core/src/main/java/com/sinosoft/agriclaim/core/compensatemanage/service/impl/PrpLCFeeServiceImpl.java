package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCFeeDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCFeeDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCFee;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCFeeKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCFeeService;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算金额表Core接口实现
 */
@Service
public class PrpLCFeeServiceImpl extends BaseServiceImpl implements PrpLCFeeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCFeeServiceImpl.class);
    
    @Autowired
    private PrpLCFeeDao prpLCFeeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCFeeDto prpLCFeeDto) {
        PrpLCFee prpLCFee = this.convert(prpLCFeeDto, PrpLCFee.class);
        prpLCFeeDao.save(prpLCFee);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo,String policyNo,String currency) {
        PrpLCFeeKey prpLCFeeKey = new PrpLCFeeKey(compensateNo,policyNo,currency);
        prpLCFeeDao.delete(prpLCFeeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCFeeDto prpLCFeeDto) {
        PrpLCFee prpLCFee = this.convert(prpLCFeeDto, PrpLCFee.class);
        prpLCFeeDao.save(prpLCFee);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCFeeDto queryByPK(String compensateNo,String policyNo,String currency) {
        PrpLCFeeKey prpLCFeeKey = new PrpLCFeeKey(compensateNo,policyNo,currency);
        PrpLCFee prpLCFee = prpLCFeeDao.findOne(prpLCFeeKey);
        return this.convert(prpLCFee,PrpLCFeeDto.class);
    }
}