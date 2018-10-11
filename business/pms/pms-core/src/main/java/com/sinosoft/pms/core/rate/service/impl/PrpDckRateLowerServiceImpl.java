package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDckRateLowerDto;
import com.sinosoft.pms.core.rate.dao.PrpDckRateLowerDao;
import com.sinosoft.pms.core.rate.entity.PrpDckRateLower;
import com.sinosoft.pms.core.rate.entity.PrpDckRateLowerKey;
import com.sinosoft.pms.core.rate.service.PrpDckRateLowerService;
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
 * @description 条款责任费率下限表Core接口实现
 */
@Service
public class PrpDckRateLowerServiceImpl extends BaseServiceImpl implements PrpDckRateLowerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDckRateLowerServiceImpl.class);
    
    @Autowired
    private PrpDckRateLowerDao prpDckRateLowerDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDckRateLowerDto prpDckRateLowerDto) {
        PrpDckRateLower prpDckRateLower = this.convert(prpDckRateLowerDto, PrpDckRateLower.class);
        prpDckRateLowerDao.save(prpDckRateLower);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer rateLowerId) {
        PrpDckRateLowerKey prpDckRateLowerKey = new PrpDckRateLowerKey(rateLowerId);
        prpDckRateLowerDao.delete(prpDckRateLowerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDckRateLowerDto prpDckRateLowerDto) {
        PrpDckRateLower prpDckRateLower = this.convert(prpDckRateLowerDto, PrpDckRateLower.class);
        prpDckRateLowerDao.save(prpDckRateLower);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDckRateLowerDto queryByPK(java.lang.Integer rateLowerId) {
        PrpDckRateLowerKey prpDckRateLowerKey = new PrpDckRateLowerKey(rateLowerId);
        PrpDckRateLower prpDckRateLower = prpDckRateLowerDao.findOne(prpDckRateLowerKey);
        return this.convert(prpDckRateLower,PrpDckRateLowerDto.class);
    }
}