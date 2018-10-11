package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossItemDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossItemDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossItem;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossItemKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossItemService;
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
 * @time  2017-11-17 08:28:31.346 
 * @description 核损明细表Core接口实现
 */
@Service
public class PrpLverifyLossItemServiceImpl extends BaseServiceImpl implements PrpLverifyLossItemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossItemServiceImpl.class);
    
    @Autowired
    private PrpLverifyLossItemDao prpLverifyLossItemDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLverifyLossItemDto prpLverifyLossItemDto) {
        PrpLverifyLossItem prpLverifyLossItem = this.convert(prpLverifyLossItemDto, PrpLverifyLossItem.class);
        prpLverifyLossItemDao.save(prpLverifyLossItem);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String policyNo) {
        PrpLverifyLossItemKey prpLverifyLossItemKey = new PrpLverifyLossItemKey(registNo,policyNo);
        prpLverifyLossItemDao.delete(prpLverifyLossItemKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLverifyLossItemDto prpLverifyLossItemDto) {
        PrpLverifyLossItem prpLverifyLossItem = this.convert(prpLverifyLossItemDto, PrpLverifyLossItem.class);
        prpLverifyLossItemDao.save(prpLverifyLossItem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossItemDto queryByPK(String registNo,String policyNo) {
        PrpLverifyLossItemKey prpLverifyLossItemKey = new PrpLverifyLossItemKey(registNo,policyNo);
        PrpLverifyLossItem prpLverifyLossItem = prpLverifyLossItemDao.findOne(prpLverifyLossItemKey);
        return this.convert(prpLverifyLossItem,PrpLverifyLossItemDto.class);
    }
}