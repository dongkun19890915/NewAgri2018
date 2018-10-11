package com.sinosoft.agriclaim.core.schedulemanage.service.impl;

import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleItemDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItem;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItemKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleItemService;
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
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务标的表Core接口实现
 */
@Service
public class PrpLScheduleItemServiceImpl extends BaseServiceImpl implements PrpLScheduleItemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleItemServiceImpl.class);
    
    @Autowired
    private PrpLScheduleItemDao prpLScheduleItemDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLScheduleItemDto prpLScheduleItemDto) {
        PrpLScheduleItem prpLScheduleItem = this.convert(prpLScheduleItemDto, PrpLScheduleItem.class);
        prpLScheduleItemDao.save(prpLScheduleItem);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo) {
        PrpLScheduleItemKey prpLScheduleItemKey = new PrpLScheduleItemKey(scheduleId,registNo,itemNo);
        prpLScheduleItemDao.delete(prpLScheduleItemKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLScheduleItemDto prpLScheduleItemDto) {
        PrpLScheduleItem prpLScheduleItem = this.convert(prpLScheduleItemDto, PrpLScheduleItem.class);
        prpLScheduleItemDao.save(prpLScheduleItem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleItemDto queryByPK(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo) {
        PrpLScheduleItemKey prpLScheduleItemKey = new PrpLScheduleItemKey(scheduleId,registNo,itemNo);
        PrpLScheduleItem prpLScheduleItem = prpLScheduleItemDao.findOne(prpLScheduleItemKey);
        return this.convert(prpLScheduleItem,PrpLScheduleItemDto.class);
    }
}