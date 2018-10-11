package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDcoinsRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDcoinsRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDcoinsRate;
import com.sinosoft.pms.core.rate.entity.PrpDcoinsRateKey;
import com.sinosoft.pms.core.rate.service.PrpDcoinsRateService;
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
 * @description 共同体成员比例配置表Core接口实现
 */
@Service
public class PrpDcoinsRateServiceImpl extends BaseServiceImpl implements PrpDcoinsRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcoinsRateServiceImpl.class);
    
    @Autowired
    private PrpDcoinsRateDao prpDcoinsRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDcoinsRateDto prpDcoinsRateDto) {
        PrpDcoinsRate prpDcoinsRate = this.convert(prpDcoinsRateDto, PrpDcoinsRate.class);
        prpDcoinsRateDao.save(prpDcoinsRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String comCode,String versionNo) {
        PrpDcoinsRateKey prpDcoinsRateKey = new PrpDcoinsRateKey(riskCode,comCode,versionNo);
        prpDcoinsRateDao.delete(prpDcoinsRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDcoinsRateDto prpDcoinsRateDto) {
        PrpDcoinsRate prpDcoinsRate = this.convert(prpDcoinsRateDto, PrpDcoinsRate.class);
        prpDcoinsRateDao.save(prpDcoinsRate);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDcoinsRateDto queryByPK(String riskCode,String comCode,String versionNo) {
        PrpDcoinsRateKey prpDcoinsRateKey = new PrpDcoinsRateKey(riskCode,comCode,versionNo);
        PrpDcoinsRate prpDcoinsRate = prpDcoinsRateDao.findOne(prpDcoinsRateKey);
        return this.convert(prpDcoinsRate,PrpDcoinsRateDto.class);
    }
}