package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDriskComConfigDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskComConfigDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskComConfig;
import com.sinosoft.pms.core.kernel.entity.PrpDriskComConfigKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskComConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDriskComConfigCore接口实现
 */
@Service
public class PrpDriskComConfigServiceImpl extends BaseServiceImpl implements PrpDriskComConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskComConfigServiceImpl.class);
    
    @Autowired
    private PrpDriskComConfigDao prpDriskComConfigDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDriskComConfigDto prpDriskComConfigDto) {
        PrpDriskComConfig prpDriskComConfig = this.convert(prpDriskComConfigDto, PrpDriskComConfig.class);
        prpDriskComConfigDao.save(prpDriskComConfig);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(java.util.Date id) {
        PrpDriskComConfigKey prpDriskComConfigKey = new PrpDriskComConfigKey(id);
        prpDriskComConfigDao.delete(prpDriskComConfigKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDriskComConfigDto prpDriskComConfigDto) {
        PrpDriskComConfig prpDriskComConfig = this.convert(prpDriskComConfigDto, PrpDriskComConfig.class);
        prpDriskComConfigDao.save(prpDriskComConfig);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDriskComConfigDto queryByPK(java.util.Date id) {
        PrpDriskComConfigKey prpDriskComConfigKey = new PrpDriskComConfigKey(id);
        PrpDriskComConfig prpDriskComConfig = prpDriskComConfigDao.findOne(prpDriskComConfigKey);
        return this.convert(prpDriskComConfig,PrpDriskComConfigDto.class);
    }
}