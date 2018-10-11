package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.dms.core.dict.dao.PrpDprovinceConfigDao;
import com.sinosoft.dms.core.dict.entity.PrpDprovinceConfig;
import com.sinosoft.dms.core.dict.entity.PrpDprovinceConfigKey;
import com.sinosoft.dms.core.dict.service.PrpDprovinceConfigService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  省级机构配置表Core接口实现
 */
@Service
public class PrpDprovinceConfigServiceImpl extends BaseServiceImpl implements PrpDprovinceConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDprovinceConfigServiceImpl.class);
    
    @Autowired
    private PrpDprovinceConfigDao prpDprovinceConfigDao;

    /**
     * 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDprovinceConfigDto prpDprovinceConfigDto) {
        PrpDprovinceConfig prpDprovinceConfig = this.convert(prpDprovinceConfigDto, PrpDprovinceConfig.class);
        prpDprovinceConfigDao.save(prpDprovinceConfig);
    }
    /**
     * 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String comCode,String riskCode) {
        PrpDprovinceConfigKey prpDprovinceConfigKey = new PrpDprovinceConfigKey(comCode,riskCode);
        prpDprovinceConfigDao.delete(prpDprovinceConfigKey);
    }
    /**
     * 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDprovinceConfigDto prpDprovinceConfigDto) {
        PrpDprovinceConfig prpDprovinceConfig = this.convert(prpDprovinceConfigDto, PrpDprovinceConfig.class);
        prpDprovinceConfigDao.save(prpDprovinceConfig);
    }
    /**
     * 按主键查询实体
     *@param 
     */
    @Override
    public PrpDprovinceConfigDto queryByPK(String comCode,String riskCode) {
        PrpDprovinceConfigKey prpDprovinceConfigKey = new PrpDprovinceConfigKey(comCode,riskCode);
        PrpDprovinceConfig prpDprovinceConfig = prpDprovinceConfigDao.findOne(prpDprovinceConfigKey);
        return this.convert(prpDprovinceConfig,PrpDprovinceConfigDto.class);
    }
}