package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDfacConfigDto;
import com.sinosoft.ims.core.kernel.dao.PrpDfacConfigDao;
import com.sinosoft.ims.core.kernel.entity.PrpDfacConfig;
import com.sinosoft.ims.core.kernel.entity.PrpDfacConfigKey;
import com.sinosoft.ims.core.kernel.service.PrpDfacConfigService;
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
 * @description 临分权限控制表Core接口实现
 */
@Service
public class PrpDfacConfigServiceImpl extends BaseServiceImpl implements PrpDfacConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDfacConfigServiceImpl.class);
    
    @Autowired
    private PrpDfacConfigDao prpDfacConfigDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDfacConfigDto prpDfacConfigDto) {
        PrpDfacConfig prpDfacConfig = this.convert(prpDfacConfigDto, PrpDfacConfig.class);
        prpDfacConfigDao.save(prpDfacConfig);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String id) {
        PrpDfacConfigKey prpDfacConfigKey = new PrpDfacConfigKey(id);
        prpDfacConfigDao.delete(prpDfacConfigKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDfacConfigDto prpDfacConfigDto) {
        PrpDfacConfig prpDfacConfig = this.convert(prpDfacConfigDto, PrpDfacConfig.class);
        prpDfacConfigDao.save(prpDfacConfig);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDfacConfigDto queryByPK(String id) {
        PrpDfacConfigKey prpDfacConfigKey = new PrpDfacConfigKey(id);
        PrpDfacConfig prpDfacConfig = prpDfacConfigDao.findOne(prpDfacConfigKey);
        return this.convert(prpDfacConfig,PrpDfacConfigDto.class);
    }
}