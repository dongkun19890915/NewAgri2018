package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathLogDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathLogService;
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
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流路径日志表Core接口实现
 */
@Service
public class SwfPathLogServiceImpl extends BaseServiceImpl implements SwfPathLogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfPathLogServiceImpl.class);
    
    @Autowired
    private SwfPathLogDao swfPathLogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfPathLogDto swfPathLogDto) {
        SwfPathLog swfPathLog = this.convert(swfPathLogDto, SwfPathLog.class);
        swfPathLogDao.save(swfPathLog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String flowId,java.lang.Integer pathNo) {
        SwfPathLogKey swfPathLogKey = new SwfPathLogKey(flowId,pathNo);
        swfPathLogDao.delete(swfPathLogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfPathLogDto swfPathLogDto) {
        SwfPathLog swfPathLog = this.convert(swfPathLogDto, SwfPathLog.class);
        swfPathLogDao.save(swfPathLog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPathLogDto queryByPK(String flowId,java.lang.Integer pathNo) {
        SwfPathLogKey swfPathLogKey = new SwfPathLogKey(flowId,pathNo);
        SwfPathLog swfPathLog = swfPathLogDao.findOne(swfPathLogKey);
        return this.convert(swfPathLog,SwfPathLogDto.class);
    }
}