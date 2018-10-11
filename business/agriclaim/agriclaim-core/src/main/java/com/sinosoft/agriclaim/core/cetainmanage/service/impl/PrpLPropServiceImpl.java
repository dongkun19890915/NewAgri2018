package com.sinosoft.agriclaim.core.cetainmanage.service.impl;

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLPropKey;
import com.sinosoft.agriclaim.core.cetainmanage.service.PrpLPropService;
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
 * @time  2017-11-08 05:36:28.690 
 * @description 财产核定损明细清单表Core接口实现
 */
@Service
public class PrpLPropServiceImpl extends BaseServiceImpl implements PrpLPropService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPropServiceImpl.class);
    
    @Autowired
    private PrpLPropDao prpLPropDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPropDto prpLPropDto) {
        PrpLProp prpLProp = this.convert(prpLPropDto, PrpLProp.class);
        prpLPropDao.save(prpLProp);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer serialNo,String registNo,String lossItemCode) {
        PrpLPropKey prpLPropKey = new PrpLPropKey(serialNo,registNo,lossItemCode);
        prpLPropDao.delete(prpLPropKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPropDto prpLPropDto) {
        PrpLProp prpLProp = this.convert(prpLPropDto, PrpLProp.class);
        prpLPropDao.save(prpLProp);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPropDto queryByPK(java.lang.Integer serialNo,String registNo,String lossItemCode) {
        PrpLPropKey prpLPropKey = new PrpLPropKey(serialNo,registNo,lossItemCode);
        PrpLProp prpLProp = prpLPropDao.findOne(prpLPropKey);
        return this.convert(prpLProp,PrpLPropDto.class);
    }
}