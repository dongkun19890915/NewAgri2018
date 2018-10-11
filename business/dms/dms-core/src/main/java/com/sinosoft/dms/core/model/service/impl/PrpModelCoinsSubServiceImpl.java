package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelCoinsSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelCoinsSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelCoinsSub;
import com.sinosoft.dms.core.model.entity.PrpModelCoinsSubKey;
import com.sinosoft.dms.core.model.service.PrpModelCoinsSubService;
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
 * @description 模板共保信息表Core接口实现
 */
@Service
public class PrpModelCoinsSubServiceImpl extends BaseServiceImpl implements PrpModelCoinsSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelCoinsSubServiceImpl.class);
    
    @Autowired
    private PrpModelCoinsSubDao prpModelCoinsSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelCoinsSubDto prpModelCoinsSubDto) {
        PrpModelCoinsSub prpModelCoinsSub = this.convert(prpModelCoinsSubDto, PrpModelCoinsSub.class);
        prpModelCoinsSubDao.save(prpModelCoinsSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode) {
        PrpModelCoinsSubKey prpModelCoinsSubKey = new PrpModelCoinsSubKey(modelCode);
        prpModelCoinsSubDao.delete(prpModelCoinsSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelCoinsSubDto prpModelCoinsSubDto) {
        PrpModelCoinsSub prpModelCoinsSub = this.convert(prpModelCoinsSubDto, PrpModelCoinsSub.class);
        prpModelCoinsSubDao.save(prpModelCoinsSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelCoinsSubDto queryByPK(String modelCode) {
        PrpModelCoinsSubKey prpModelCoinsSubKey = new PrpModelCoinsSubKey(modelCode);
        PrpModelCoinsSub prpModelCoinsSub = prpModelCoinsSubDao.findOne(prpModelCoinsSubKey);
        return this.convert(prpModelCoinsSub,PrpModelCoinsSubDto.class);
    }
}