package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDsalesRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDsalesRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDsalesRate;
import com.sinosoft.pms.core.rate.entity.PrpDsalesRateKey;
import com.sinosoft.pms.core.rate.service.PrpDsalesRateService;
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
 * @description 销售费用率配置表Core接口实现
 */
@Service
public class PrpDsalesRateServiceImpl extends BaseServiceImpl implements PrpDsalesRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDsalesRateServiceImpl.class);
    
    @Autowired
    private PrpDsalesRateDao prpDsalesRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDsalesRateDto prpDsalesRateDto) {
        PrpDsalesRate prpDsalesRate = this.convert(prpDsalesRateDto, PrpDsalesRate.class);
        prpDsalesRateDao.save(prpDsalesRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String businessNature,String versionNo) {
        PrpDsalesRateKey prpDsalesRateKey = new PrpDsalesRateKey(riskCode,businessNature,versionNo);
        prpDsalesRateDao.delete(prpDsalesRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDsalesRateDto prpDsalesRateDto) {
        PrpDsalesRate prpDsalesRate = this.convert(prpDsalesRateDto, PrpDsalesRate.class);
        prpDsalesRateDao.save(prpDsalesRate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDsalesRateDto queryByPK(String riskCode,String businessNature,String versionNo) {
        PrpDsalesRateKey prpDsalesRateKey = new PrpDsalesRateKey(riskCode,businessNature,versionNo);
        PrpDsalesRate prpDsalesRate = prpDsalesRateDao.findOne(prpDsalesRateKey);
        return this.convert(prpDsalesRate,PrpDsalesRateDto.class);
    }
}