package com.sinosoft.agriclaim.core.schedulemanage.service.impl;

import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainDto;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMain;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainService;
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
 * @description 调度任务主表Core接口实现
 */
@Service
public class PrpLScheduleMainServiceImpl extends BaseServiceImpl implements PrpLScheduleMainService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleMainServiceImpl.class);
    
    @Autowired
    private PrpLScheduleMainDao prpLScheduleMainDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLScheduleMainDto prpLScheduleMainDto) {
        PrpLScheduleMain prpLScheduleMain = this.convert(prpLScheduleMainDto, PrpLScheduleMain.class);
        prpLScheduleMainDao.save(prpLScheduleMain);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Double scheduleId,String registNo,java.lang.Double serialNo) {
        PrpLScheduleMainKey prpLScheduleMainKey = new PrpLScheduleMainKey(scheduleId,registNo,serialNo);
        prpLScheduleMainDao.delete(prpLScheduleMainKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLScheduleMainDto prpLScheduleMainDto) {
        PrpLScheduleMain prpLScheduleMain = this.convert(prpLScheduleMainDto, PrpLScheduleMain.class);
        prpLScheduleMainDao.save(prpLScheduleMain);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleMainDto queryByPK(java.lang.Double scheduleId,String registNo,java.lang.Double serialNo) {
        PrpLScheduleMainKey prpLScheduleMainKey = new PrpLScheduleMainKey(scheduleId,registNo,serialNo);
        PrpLScheduleMain prpLScheduleMain = prpLScheduleMainDao.findOne(prpLScheduleMainKey);
        return this.convert(prpLScheduleMain,PrpLScheduleMainDto.class);
    }
}