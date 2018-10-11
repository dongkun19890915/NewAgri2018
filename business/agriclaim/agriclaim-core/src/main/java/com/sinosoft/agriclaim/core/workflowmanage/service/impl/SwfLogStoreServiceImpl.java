package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogStoreDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStoreKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogStoreService;
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
 * @description 工作流日志表1Core接口实现
 */
@Service
public class SwfLogStoreServiceImpl extends BaseServiceImpl implements SwfLogStoreService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfLogStoreServiceImpl.class);
    
    @Autowired
    private SwfLogStoreDao swfLogStoreDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfLogStoreDto swfLogStoreDto) {
        SwfLogStore swfLogStore = this.convert(swfLogStoreDto, SwfLogStore.class);
        swfLogStoreDao.save(swfLogStore);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String flowId,java.lang.Integer logNo) {
        SwfLogStoreKey swfLogStoreKey = new SwfLogStoreKey(flowId,logNo);
        swfLogStoreDao.delete(swfLogStoreKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfLogStoreDto swfLogStoreDto) {
        SwfLogStore swfLogStore = this.convert(swfLogStoreDto, SwfLogStore.class);
        swfLogStoreDao.save(swfLogStore);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfLogStoreDto queryByPK(String flowId,java.lang.Integer logNo) {
        SwfLogStoreKey swfLogStoreKey = new SwfLogStoreKey(flowId,logNo);
        SwfLogStore swfLogStore = swfLogStoreDao.findOne(swfLogStoreKey);
        return this.convert(swfLogStore,SwfLogStoreDto.class);
    }
}