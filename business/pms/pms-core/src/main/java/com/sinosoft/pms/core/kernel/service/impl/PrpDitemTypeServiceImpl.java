package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDitemTypeDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemTypeDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitemType;
import com.sinosoft.pms.core.kernel.entity.PrpDitemTypeKey;
import com.sinosoft.pms.core.kernel.service.PrpDitemTypeService;
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
 * @time  2017-08-22 03:00:50.124 
 * @description 标的分类表Core接口实现
 */
@Service
public class PrpDitemTypeServiceImpl extends BaseServiceImpl implements PrpDitemTypeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDitemTypeServiceImpl.class);
    
    @Autowired
    private PrpDitemTypeDao prpDitemTypeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDitemTypeDto prpDitemTypeDto) {
        PrpDitemType prpDitemType = this.convert(prpDitemTypeDto, PrpDitemType.class);
        prpDitemTypeDao.save(prpDitemType);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String itemCode,String itemTypeBase,String itemTypeCode) {
        PrpDitemTypeKey prpDitemTypeKey = new PrpDitemTypeKey(itemCode,itemTypeBase,itemTypeCode);
        prpDitemTypeDao.delete(prpDitemTypeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDitemTypeDto prpDitemTypeDto) {
        PrpDitemType prpDitemType = this.convert(prpDitemTypeDto, PrpDitemType.class);
        prpDitemTypeDao.save(prpDitemType);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDitemTypeDto queryByPK(String itemCode,String itemTypeBase,String itemTypeCode) {
        PrpDitemTypeKey prpDitemTypeKey = new PrpDitemTypeKey(itemCode,itemTypeBase,itemTypeCode);
        PrpDitemType prpDitemType = prpDitemTypeDao.findOne(prpDitemTypeKey);
        return this.convert(prpDitemType,PrpDitemTypeDto.class);
    }
}