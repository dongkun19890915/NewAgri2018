package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDriskShortRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDriskShortRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDriskShortRate;
import com.sinosoft.pms.core.rate.entity.PrpDriskShortRateKey;
import com.sinosoft.pms.core.rate.service.PrpDriskShortRateService;
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
 * @time  2017-08-22 03:00:50.124 
 * @description 产品短期费率表Core接口实现
 */
@Service
public class PrpDriskShortRateServiceImpl extends BaseServiceImpl implements PrpDriskShortRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskShortRateServiceImpl.class);
    
    @Autowired
    private PrpDriskShortRateDao prpDriskShortRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskShortRateDto prpDriskShortRateDto) {
        PrpDriskShortRate prpDriskShortRate = this.convert(prpDriskShortRateDto, PrpDriskShortRate.class);
        prpDriskShortRateDao.save(prpDriskShortRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String shortRateId,String clauseCode,java.lang.Integer serialNo) {
        PrpDriskShortRateKey prpDriskShortRateKey = new PrpDriskShortRateKey(riskCode,shortRateId,clauseCode,serialNo);
        prpDriskShortRateDao.delete(prpDriskShortRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskShortRateDto prpDriskShortRateDto) {
        PrpDriskShortRate prpDriskShortRate = this.convert(prpDriskShortRateDto, PrpDriskShortRate.class);
        prpDriskShortRateDao.save(prpDriskShortRate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskShortRateDto queryByPK(String riskCode,String shortRateId,String clauseCode,java.lang.Integer serialNo) {
        PrpDriskShortRateKey prpDriskShortRateKey = new PrpDriskShortRateKey(riskCode,shortRateId,clauseCode,serialNo);
        PrpDriskShortRate prpDriskShortRate = prpDriskShortRateDao.findOne(prpDriskShortRateKey);
        return this.convert(prpDriskShortRate,PrpDriskShortRateDto.class);
    }
}