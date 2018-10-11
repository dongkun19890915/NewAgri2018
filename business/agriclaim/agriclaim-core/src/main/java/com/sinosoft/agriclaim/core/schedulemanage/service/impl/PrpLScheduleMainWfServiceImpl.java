package com.sinosoft.agriclaim.core.schedulemanage.service.impl;

import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainWfService;
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
 * @description 调度任务/查勘任务主表Core接口实现
 */
@Service
public class PrpLScheduleMainWfServiceImpl extends BaseServiceImpl implements PrpLScheduleMainWfService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleMainWfServiceImpl.class);
    
    @Autowired
    private PrpLScheduleMainWfDao prpLScheduleMainWfDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
        PrpLScheduleMainWf prpLScheduleMainWf = this.convert(prpLScheduleMainWfDto, PrpLScheduleMainWf.class);
        prpLScheduleMainWfDao.save(prpLScheduleMainWf);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer scheduleId,String registNo) {
        PrpLScheduleMainWfKey prpLScheduleMainWfKey = new PrpLScheduleMainWfKey(scheduleId,registNo);
        prpLScheduleMainWfDao.delete(prpLScheduleMainWfKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
        PrpLScheduleMainWf prpLScheduleMainWf = this.convert(prpLScheduleMainWfDto, PrpLScheduleMainWf.class);
        prpLScheduleMainWfDao.save(prpLScheduleMainWf);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleMainWfDto queryByPK(java.lang.Integer scheduleId,String registNo) {
        PrpLScheduleMainWfKey prpLScheduleMainWfKey = new PrpLScheduleMainWfKey(scheduleId,registNo);
        PrpLScheduleMainWf prpLScheduleMainWf = prpLScheduleMainWfDao.findOne(prpLScheduleMainWfKey);
        return this.convert(prpLScheduleMainWf,PrpLScheduleMainWfDto.class);
    }
}