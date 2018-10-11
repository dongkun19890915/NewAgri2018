package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiConfigDto;
import com.sinosoft.ims.core.auth.dao.UtiConfigDao;
import com.sinosoft.ims.core.auth.entity.UtiConfig;
import com.sinosoft.ims.core.auth.entity.UtiConfigKey;
import com.sinosoft.ims.core.auth.service.UtiConfigService;
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
 * @time  2017-11-05 01:10:12.703 
 * @description UtiConfigCore接口实现
 */
@Service
public class UtiConfigServiceImpl extends BaseServiceImpl implements UtiConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiConfigServiceImpl.class);
    
    @Autowired
    private UtiConfigDao utiConfigDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiConfigDto utiConfigDto) {
        UtiConfig utiConfig = this.convert(utiConfigDto, UtiConfig.class);
        utiConfigDao.save(utiConfig);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String configCode) {
        UtiConfigKey utiConfigKey = new UtiConfigKey(configCode);
        utiConfigDao.delete(utiConfigKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiConfigDto utiConfigDto) {
        UtiConfig utiConfig = this.convert(utiConfigDto, UtiConfig.class);
        utiConfigDao.save(utiConfig);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiConfigDto queryByPK(String configCode) {
        UtiConfigKey utiConfigKey = new UtiConfigKey(configCode);
        UtiConfig utiConfig = utiConfigDao.findOne(utiConfigKey);
        return this.convert(utiConfig,UtiConfigDto.class);
    }
}