package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelMainAgriSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelMainAgriSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelMainAgriSub;
import com.sinosoft.dms.core.model.entity.PrpModelMainAgriSubKey;
import com.sinosoft.dms.core.model.service.PrpModelMainAgriSubService;
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
 * @description 模板农业险保单信息Core接口实现
 */
@Service
public class PrpModelMainAgriSubServiceImpl extends BaseServiceImpl implements PrpModelMainAgriSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelMainAgriSubServiceImpl.class);
    
    @Autowired
    private PrpModelMainAgriSubDao prpModelMainAgriSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelMainAgriSubDto prpModelMainAgriSubDto) {
        PrpModelMainAgriSub prpModelMainAgriSub = this.convert(prpModelMainAgriSubDto, PrpModelMainAgriSub.class);
        prpModelMainAgriSubDao.save(prpModelMainAgriSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode) {
        PrpModelMainAgriSubKey prpModelMainAgriSubKey = new PrpModelMainAgriSubKey(modelCode);
        prpModelMainAgriSubDao.delete(prpModelMainAgriSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelMainAgriSubDto prpModelMainAgriSubDto) {
        PrpModelMainAgriSub prpModelMainAgriSub = this.convert(prpModelMainAgriSubDto, PrpModelMainAgriSub.class);
        prpModelMainAgriSubDao.save(prpModelMainAgriSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelMainAgriSubDto queryByPK(String modelCode) {
        PrpModelMainAgriSubKey prpModelMainAgriSubKey = new PrpModelMainAgriSubKey(modelCode);
        PrpModelMainAgriSub prpModelMainAgriSub = prpModelMainAgriSubDao.findOne(prpModelMainAgriSubKey);
        return this.convert(prpModelMainAgriSub,PrpModelMainAgriSubDto.class);
    }
}