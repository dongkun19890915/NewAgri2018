package com.sinosoft.agriclaim.core.cetainmanage.service.impl;

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLCetainLossDto;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLCetainLossDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLCetainLoss;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLCetainLossKey;
import com.sinosoft.agriclaim.core.cetainmanage.service.PrpLCetainLossService;
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
 * @time  2017-11-08 05:36:28.690 
 * @description 确定损失表（无表名）Core接口实现
 */
@Service
public class PrpLCetainLossServiceImpl extends BaseServiceImpl implements PrpLCetainLossService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCetainLossServiceImpl.class);
    
    @Autowired
    private PrpLCetainLossDao prpLCetainLossDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCetainLossDto prpLCetainLossDto) {
        PrpLCetainLoss prpLCetainLoss = this.convert(prpLCetainLossDto, PrpLCetainLoss.class);
        prpLCetainLossDao.save(prpLCetainLoss);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Double id) {
        PrpLCetainLossKey prpLCetainLossKey = new PrpLCetainLossKey(id);
        prpLCetainLossDao.delete(prpLCetainLossKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCetainLossDto prpLCetainLossDto) {
        PrpLCetainLoss prpLCetainLoss = this.convert(prpLCetainLossDto, PrpLCetainLoss.class);
        prpLCetainLossDao.save(prpLCetainLoss);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCetainLossDto queryByPK(java.lang.Double id) {
        PrpLCetainLossKey prpLCetainLossKey = new PrpLCetainLossKey(id);
        PrpLCetainLoss prpLCetainLoss = prpLCetainLossDao.findOne(prpLCetainLossKey);
        return this.convert(prpLCetainLoss,PrpLCetainLossDto.class);
    }
}