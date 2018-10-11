package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelInsuredSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelInsuredSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelInsuredSub;
import com.sinosoft.dms.core.model.entity.PrpModelInsuredSubKey;
import com.sinosoft.dms.core.model.service.PrpModelInsuredSubService;
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
 * @description 模板保险关系人表Core接口实现
 */
@Service
public class PrpModelInsuredSubServiceImpl extends BaseServiceImpl implements PrpModelInsuredSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelInsuredSubServiceImpl.class);
    
    @Autowired
    private PrpModelInsuredSubDao prpModelInsuredSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelInsuredSubDto prpModelInsuredSubDto) {
        PrpModelInsuredSub prpModelInsuredSub = this.convert(prpModelInsuredSubDto, PrpModelInsuredSub.class);
        prpModelInsuredSubDao.save(prpModelInsuredSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode,Integer serialNo) {
        PrpModelInsuredSubKey prpModelInsuredSubKey = new PrpModelInsuredSubKey(modelCode,serialNo);
        prpModelInsuredSubDao.delete(prpModelInsuredSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelInsuredSubDto prpModelInsuredSubDto) {
        PrpModelInsuredSub prpModelInsuredSub = this.convert(prpModelInsuredSubDto, PrpModelInsuredSub.class);
        prpModelInsuredSubDao.save(prpModelInsuredSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelInsuredSubDto queryByPK(String modelCode,Integer serialNo) {
        PrpModelInsuredSubKey prpModelInsuredSubKey = new PrpModelInsuredSubKey(modelCode,serialNo);
        PrpModelInsuredSub prpModelInsuredSub = prpModelInsuredSubDao.findOne(prpModelInsuredSubKey);
        return this.convert(prpModelInsuredSub,PrpModelInsuredSubDto.class);
    }
}