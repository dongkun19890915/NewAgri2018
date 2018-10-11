package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPreChargeDto;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPreChargeDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPreCharge;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPreChargeKey;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPreChargeService;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔费用信息表Core接口实现
 */
@Service
public class PrpLPreChargeServiceImpl extends BaseServiceImpl implements PrpLPreChargeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPreChargeServiceImpl.class);
    
    @Autowired
    private PrpLPreChargeDao prpLPreChargeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPreChargeDto prpLPreChargeDto) {
        PrpLPreCharge prpLPreCharge = this.convert(prpLPreChargeDto, PrpLPreCharge.class);
        prpLPreChargeDao.save(prpLPreCharge);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer id) {
        PrpLPreChargeKey prpLPreChargeKey = new PrpLPreChargeKey(id);
        prpLPreChargeDao.delete(prpLPreChargeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPreChargeDto prpLPreChargeDto) {
        PrpLPreCharge prpLPreCharge = this.convert(prpLPreChargeDto, PrpLPreCharge.class);
        prpLPreChargeDao.save(prpLPreCharge);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPreChargeDto queryByPK(java.lang.Integer id) {
        PrpLPreChargeKey prpLPreChargeKey = new PrpLPreChargeKey(id);
        PrpLPreCharge prpLPreCharge = prpLPreChargeDao.findOne(prpLPreChargeKey);
        return this.convert(prpLPreCharge,PrpLPreChargeDto.class);
    }
}