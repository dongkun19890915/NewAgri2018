package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.ims.core.kernel.dao.PrpDriskConfigDao;
import com.sinosoft.ims.core.kernel.dao.specification.PrpDriskConfigSpecBuilder;
import com.sinosoft.ims.core.kernel.entity.PrpDriskConfig;
import com.sinosoft.ims.core.kernel.entity.PrpDriskConfigKey;
import com.sinosoft.ims.core.kernel.service.PrpDriskConfigService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDriskConfigCore接口实现
 */
@Service
public class PrpDriskConfigServiceImpl extends BaseServiceImpl implements PrpDriskConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskConfigServiceImpl.class);
    
    @Autowired
    private PrpDriskConfigDao prpDriskConfigDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDriskConfigDto prpDriskConfigDto) {
        PrpDriskConfig prpDriskConfig = this.convert(prpDriskConfigDto, PrpDriskConfig.class);
        prpDriskConfigDao.save(prpDriskConfig);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String comCode,String riskCode,String configCode) {
        PrpDriskConfigKey prpDriskConfigKey = new PrpDriskConfigKey(comCode,riskCode,configCode);
        prpDriskConfigDao.delete(prpDriskConfigKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDriskConfigDto prpDriskConfigDto) {
        PrpDriskConfig prpDriskConfig = this.convert(prpDriskConfigDto, PrpDriskConfig.class);
        prpDriskConfigDao.save(prpDriskConfig);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDriskConfigDto queryByPK(String comCode,String riskCode,String configCode) {
        PrpDriskConfigKey prpDriskConfigKey = new PrpDriskConfigKey(comCode,riskCode,configCode);
        PrpDriskConfig prpDriskConfig = prpDriskConfigDao.findOne(prpDriskConfigKey);
        return this.convert(prpDriskConfig,PrpDriskConfigDto.class);
    }
    @Override
    //@Cacheable(value="PrpDriskConfig_query",key="T(String).valueOf(#prpDriskConfigDto.comCode).concat('-').concat(T(String).valueOf(#prpDriskConfigDto.riskCode)).concat('-').concat(T(String).valueOf(#prpDriskConfigDto.configCode)).concat('-').concat(T(String).valueOf(#prpDriskConfigDto.configName)).concat('-').concat(T(String).valueOf(#prpDriskConfigDto.extendValue)).concat('-').concat(T(String).valueOf(#prpDriskConfigDto.flag))")
    @Cacheable(value="PrpDriskConfig_query",key="#prpDriskConfigDto.configCode+'-'+#prpDriskConfigDto.comCode+'-'+#prpDriskConfigDto.riskCode+'-'+#prpDriskConfigDto.configName+'-'+#prpDriskConfigDto.extendValue+'-'+#prpDriskConfigDto.flag")
    public List<PrpDriskConfigDto> query(PrpDriskConfigDto prpDriskConfigDto) throws Exception {
        if(StringUtils.isEmpty(prpDriskConfigDto.getConfigCode())){
            throw new Exception("配置类型ConfigCode不能为空");
        }
        PrpDriskConfig prpDriskConfig = new PrpDriskConfig();
        BeanUtils.copyProperties(prpDriskConfigDto, prpDriskConfig);
        //prpDriskConfig.setValidStatus("1");
        List<PrpDriskConfig> entitylist = new ArrayList<PrpDriskConfig>();
        entitylist = prpDriskConfigDao.findAll(PrpDriskConfigSpecBuilder.genCondition(prpDriskConfig));
        List<PrpDriskConfigDto> dtolist = new ArrayList<PrpDriskConfigDto>();
        convertCollection(entitylist, dtolist, PrpDriskConfigDto.class);
        if(dtolist == null || dtolist.size() == 0){
            dtolist = null;
        }
        return dtolist;
    }
}