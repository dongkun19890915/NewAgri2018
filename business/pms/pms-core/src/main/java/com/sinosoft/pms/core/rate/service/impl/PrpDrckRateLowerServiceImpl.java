package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDrckRateLowerDto;
import com.sinosoft.pms.core.rate.dao.PrpDrckRateLowerDao;
import com.sinosoft.pms.core.rate.entity.PrpDrckRateLower;
import com.sinosoft.pms.core.rate.entity.PrpDrckRateLowerKey;
import com.sinosoft.pms.core.rate.service.PrpDrckRateLowerService;
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
 * @description 产品条款责任费率下限表Core接口实现
 */
@Service
public class PrpDrckRateLowerServiceImpl extends BaseServiceImpl implements PrpDrckRateLowerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrckRateLowerServiceImpl.class);
    
    @Autowired
    private PrpDrckRateLowerDao prpDrckRateLowerDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDrckRateLowerDto prpDrckRateLowerDto) {
        PrpDrckRateLower prpDrckRateLower = this.convert(prpDrckRateLowerDto, PrpDrckRateLower.class);
        prpDrckRateLowerDao.save(prpDrckRateLower);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer rateLowerId) {
        PrpDrckRateLowerKey prpDrckRateLowerKey = new PrpDrckRateLowerKey(rateLowerId);
        prpDrckRateLowerDao.delete(prpDrckRateLowerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDrckRateLowerDto prpDrckRateLowerDto) {
        PrpDrckRateLower prpDrckRateLower = this.convert(prpDrckRateLowerDto, PrpDrckRateLower.class);
        prpDrckRateLowerDao.save(prpDrckRateLower);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDrckRateLowerDto queryByPK(java.lang.Integer rateLowerId) {
        PrpDrckRateLowerKey prpDrckRateLowerKey = new PrpDrckRateLowerKey(rateLowerId);
        PrpDrckRateLower prpDrckRateLower = prpDrckRateLowerDao.findOne(prpDrckRateLowerKey);
        return this.convert(prpDrckRateLower,PrpDrckRateLowerDto.class);
    }
}