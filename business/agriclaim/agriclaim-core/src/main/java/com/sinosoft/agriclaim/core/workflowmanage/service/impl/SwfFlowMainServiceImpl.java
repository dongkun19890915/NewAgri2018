package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfFlowMainDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMainKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfFlowMainService;
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
 * @description 流程主表Core接口实现
 */
@Service
public class SwfFlowMainServiceImpl extends BaseServiceImpl implements SwfFlowMainService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfFlowMainServiceImpl.class);
    
    @Autowired
    private SwfFlowMainDao swfFlowMainDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfFlowMainDto swfFlowMainDto) {
        SwfFlowMain swfFlowMain = this.convert(swfFlowMainDto, SwfFlowMain.class);
        swfFlowMainDao.save(swfFlowMain);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String flowId) {
        SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey(flowId);
        swfFlowMainDao.delete(swfFlowMainKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfFlowMainDto swfFlowMainDto) {
        SwfFlowMain swfFlowMain = this.convert(swfFlowMainDto, SwfFlowMain.class);
        swfFlowMainDao.save(swfFlowMain);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfFlowMainDto queryByPK(String flowId) {
        SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey(flowId);
        SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
        return this.convert(swfFlowMain,SwfFlowMainDto.class);
    }
}