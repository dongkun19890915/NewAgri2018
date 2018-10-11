package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDriskItemDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskItemDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskItem;
import com.sinosoft.pms.core.kernel.entity.PrpDriskItemKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskItemService;
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
 * @description 产品标的表Core接口实现
 */
@Service
public class PrpDriskItemServiceImpl extends BaseServiceImpl implements PrpDriskItemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskItemServiceImpl.class);
    
    @Autowired
    private PrpDriskItemDao prpDriskItemDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskItemDto prpDriskItemDto) {
        PrpDriskItem prpDriskItem = this.convert(prpDriskItemDto, PrpDriskItem.class);
        prpDriskItemDao.save(prpDriskItem);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseCode,String itemCode) {
        PrpDriskItemKey prpDriskItemKey = new PrpDriskItemKey(riskCode,clauseCode,itemCode);
        prpDriskItemDao.delete(prpDriskItemKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskItemDto prpDriskItemDto) {
        PrpDriskItem prpDriskItem = this.convert(prpDriskItemDto, PrpDriskItem.class);
        prpDriskItemDao.save(prpDriskItem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskItemDto queryByPK(String riskCode,String clauseCode,String itemCode) {
        PrpDriskItemKey prpDriskItemKey = new PrpDriskItemKey(riskCode,clauseCode,itemCode);
        PrpDriskItem prpDriskItem = prpDriskItemDao.findOne(prpDriskItemKey);
        return this.convert(prpDriskItem,PrpDriskItemDto.class);
    }
}