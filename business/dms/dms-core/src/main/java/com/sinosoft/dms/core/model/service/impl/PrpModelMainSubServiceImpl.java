package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelMainSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelMainSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelMainSub;
import com.sinosoft.dms.core.model.entity.PrpModelMainSubKey;
import com.sinosoft.dms.core.model.service.PrpModelMainSubService;
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
 * @time  2017-11-13 11:42:08.278 
 * @description 保单基本信息表Core接口实现
 */
@Service
public class PrpModelMainSubServiceImpl extends BaseServiceImpl implements PrpModelMainSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelMainSubServiceImpl.class);
    
    @Autowired
    private PrpModelMainSubDao prpModelMainSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelMainSubDto prpModelMainSubDto) {
        PrpModelMainSub prpModelMainSub = this.convert(prpModelMainSubDto, PrpModelMainSub.class);
        prpModelMainSubDao.save(prpModelMainSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode) {
        PrpModelMainSubKey prpModelMainSubKey = new PrpModelMainSubKey(modelCode);
        prpModelMainSubDao.delete(prpModelMainSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelMainSubDto prpModelMainSubDto) {
        PrpModelMainSub prpModelMainSub = this.convert(prpModelMainSubDto, PrpModelMainSub.class);
        prpModelMainSubDao.save(prpModelMainSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelMainSubDto queryByPK(String modelCode) {
        PrpModelMainSubKey prpModelMainSubKey = new PrpModelMainSubKey(modelCode);
        PrpModelMainSub prpModelMainSub = prpModelMainSubDao.findOne(prpModelMainSubKey);
        return this.convert(prpModelMainSub,PrpModelMainSubDto.class);
    }
}