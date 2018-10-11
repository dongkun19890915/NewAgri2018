package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDclauseShortRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDclauseShortRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDclauseShortRate;
import com.sinosoft.pms.core.rate.entity.PrpDclauseShortRateKey;
import com.sinosoft.pms.core.rate.service.PrpDclauseShortRateService;
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
 * @description 条款短期费率表Core接口实现
 */
@Service
public class PrpDclauseShortRateServiceImpl extends BaseServiceImpl implements PrpDclauseShortRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseShortRateServiceImpl.class);
    
    @Autowired
    private PrpDclauseShortRateDao prpDclauseShortRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseShortRateDto prpDclauseShortRateDto) {
        PrpDclauseShortRate prpDclauseShortRate = this.convert(prpDclauseShortRateDto, PrpDclauseShortRate.class);
        prpDclauseShortRateDao.save(prpDclauseShortRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String shortRateId,java.lang.Integer serialNo) {
        PrpDclauseShortRateKey prpDclauseShortRateKey = new PrpDclauseShortRateKey(clauseCode,shortRateId,serialNo);
        prpDclauseShortRateDao.delete(prpDclauseShortRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseShortRateDto prpDclauseShortRateDto) {
        PrpDclauseShortRate prpDclauseShortRate = this.convert(prpDclauseShortRateDto, PrpDclauseShortRate.class);
        prpDclauseShortRateDao.save(prpDclauseShortRate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseShortRateDto queryByPK(String clauseCode,String shortRateId,java.lang.Integer serialNo) {
        PrpDclauseShortRateKey prpDclauseShortRateKey = new PrpDclauseShortRateKey(clauseCode,shortRateId,serialNo);
        PrpDclauseShortRate prpDclauseShortRate = prpDclauseShortRateDao.findOne(prpDclauseShortRateKey);
        return this.convert(prpDclauseShortRate,PrpDclauseShortRateDto.class);
    }
}