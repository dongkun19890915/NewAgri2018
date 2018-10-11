package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigDto;
import com.sinosoft.ims.core.auth.dao.UtiPlatConfigDao;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfig;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigKey;
import com.sinosoft.ims.core.auth.service.UtiPlatConfigService;
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
 * @time  2017-11-05 01:10:45.148 
 * @description UtiPlatConfigCore接口实现
 */
@Service
public class UtiPlatConfigServiceImpl extends BaseServiceImpl implements UtiPlatConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiPlatConfigServiceImpl.class);
    
    @Autowired
    private UtiPlatConfigDao utiPlatConfigDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiPlatConfigDto utiPlatConfigDto) {
        UtiPlatConfig utiPlatConfig = this.convert(utiPlatConfigDto, UtiPlatConfig.class);
        utiPlatConfigDao.save(utiPlatConfig);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String systemCode,String paramCode) {
        UtiPlatConfigKey utiPlatConfigKey = new UtiPlatConfigKey(systemCode,paramCode);
        utiPlatConfigDao.delete(utiPlatConfigKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiPlatConfigDto utiPlatConfigDto) {
        UtiPlatConfig utiPlatConfig = this.convert(utiPlatConfigDto, UtiPlatConfig.class);
        utiPlatConfigDao.save(utiPlatConfig);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiPlatConfigDto queryByPK(String systemCode,String paramCode) {
        UtiPlatConfigKey utiPlatConfigKey = new UtiPlatConfigKey(systemCode,paramCode);
        UtiPlatConfig utiPlatConfig = utiPlatConfigDao.findOne(utiPlatConfigKey);
        return this.convert(utiPlatConfig,UtiPlatConfigDto.class);
    }
}