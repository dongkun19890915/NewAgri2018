package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelCustomerTaxPayInfoSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelCustomerTaxPayInfoSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelCustomerTaxPayInfoSub;
import com.sinosoft.dms.core.model.entity.PrpModelCustomerTaxPayInfoSubKey;
import com.sinosoft.dms.core.model.service.PrpModelCustomerTaxPayInfoSubService;
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
 * @description 模板客户纳税人信息表Core接口实现
 */
@Service
public class PrpModelCustomerTaxPayInfoSubServiceImpl extends BaseServiceImpl implements PrpModelCustomerTaxPayInfoSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelCustomerTaxPayInfoSubServiceImpl.class);
    
    @Autowired
    private PrpModelCustomerTaxPayInfoSubDao prpModelCustomerTaxPayInfoSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto) {
        PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSub = this.convert(prpModelCustomerTaxPayInfoSubDto, PrpModelCustomerTaxPayInfoSub.class);
        prpModelCustomerTaxPayInfoSubDao.save(prpModelCustomerTaxPayInfoSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode) {
        PrpModelCustomerTaxPayInfoSubKey prpModelCustomerTaxPayInfoSubKey = new PrpModelCustomerTaxPayInfoSubKey(modelCode);
        prpModelCustomerTaxPayInfoSubDao.delete(prpModelCustomerTaxPayInfoSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto) {
        PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSub = this.convert(prpModelCustomerTaxPayInfoSubDto, PrpModelCustomerTaxPayInfoSub.class);
        prpModelCustomerTaxPayInfoSubDao.save(prpModelCustomerTaxPayInfoSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelCustomerTaxPayInfoSubDto queryByPK(String modelCode) {
        PrpModelCustomerTaxPayInfoSubKey prpModelCustomerTaxPayInfoSubKey = new PrpModelCustomerTaxPayInfoSubKey(modelCode);
        PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSub = prpModelCustomerTaxPayInfoSubDao.findOne(prpModelCustomerTaxPayInfoSubKey);
        return this.convert(prpModelCustomerTaxPayInfoSub,PrpModelCustomerTaxPayInfoSubDto.class);
    }
}