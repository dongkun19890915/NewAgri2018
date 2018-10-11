package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDdepreCateRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDdepreCateRate;
import com.sinosoft.pms.core.rate.entity.PrpDdepreCateRateKey;
import com.sinosoft.pms.core.rate.service.PrpDdepreCateRateService;
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
 * @description 折旧率表Core接口实现
 */
@Service
public class PrpDdepreCateRateServiceImpl extends BaseServiceImpl implements PrpDdepreCateRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDdepreCateRateServiceImpl.class);
    
    @Autowired
    private PrpDdepreCateRateDao prpDdepreCateRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDdepreCateRateDto prpDdepreCateRateDto) {
        PrpDdepreCateRate prpDdepreCateRate = this.convert(prpDdepreCateRateDto, PrpDdepreCateRate.class);
        prpDdepreCateRateDao.save(prpDdepreCateRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseType,String carKindCode) {
        PrpDdepreCateRateKey prpDdepreCateRateKey = new PrpDdepreCateRateKey(riskCode,clauseType,carKindCode);
        prpDdepreCateRateDao.delete(prpDdepreCateRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDdepreCateRateDto prpDdepreCateRateDto) {
        PrpDdepreCateRate prpDdepreCateRate = this.convert(prpDdepreCateRateDto, PrpDdepreCateRate.class);
        prpDdepreCateRateDao.save(prpDdepreCateRate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDdepreCateRateDto queryByPK(String riskCode,String clauseType,String carKindCode) {
        PrpDdepreCateRateKey prpDdepreCateRateKey = new PrpDdepreCateRateKey(riskCode,clauseType,carKindCode);
        PrpDdepreCateRate prpDdepreCateRate = prpDdepreCateRateDao.findOne(prpDdepreCateRateKey);
        return this.convert(prpDdepreCateRate,PrpDdepreCateRateDto.class);
    }
}