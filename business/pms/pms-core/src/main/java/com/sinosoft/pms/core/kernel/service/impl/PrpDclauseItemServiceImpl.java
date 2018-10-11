package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDclauseItemDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseItemDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseItem;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseItemKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseItemService;
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
 * @description 条款标的表Core接口实现
 */
@Service
public class PrpDclauseItemServiceImpl extends BaseServiceImpl implements PrpDclauseItemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseItemServiceImpl.class);
    
    @Autowired
    private PrpDclauseItemDao prpDclauseItemDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseItemDto prpDclauseItemDto) {
        PrpDclauseItem prpDclauseItem = this.convert(prpDclauseItemDto, PrpDclauseItem.class);
        prpDclauseItemDao.save(prpDclauseItem);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String itemCode) {
        PrpDclauseItemKey prpDclauseItemKey = new PrpDclauseItemKey(clauseCode,itemCode);
        prpDclauseItemDao.delete(prpDclauseItemKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseItemDto prpDclauseItemDto) {
        PrpDclauseItem prpDclauseItem = this.convert(prpDclauseItemDto, PrpDclauseItem.class);
        prpDclauseItemDao.save(prpDclauseItem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseItemDto queryByPK(String clauseCode,String itemCode) {
        PrpDclauseItemKey prpDclauseItemKey = new PrpDclauseItemKey(clauseCode,itemCode);
        PrpDclauseItem prpDclauseItem = prpDclauseItemDao.findOne(prpDclauseItemKey);
        return this.convert(prpDclauseItem,PrpDclauseItemDto.class);
    }
}