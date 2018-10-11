package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNodeDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNodeDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNode;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNodeKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNodeService;
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
 * @description 工作流节点定义表Core接口实现
 */
@Service
public class SwfNodeServiceImpl extends BaseServiceImpl implements SwfNodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfNodeServiceImpl.class);
    
    @Autowired
    private SwfNodeDao swfNodeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfNodeDto swfNodeDto) {
        SwfNode swfNode = this.convert(swfNodeDto, SwfNode.class);
        swfNodeDao.save(swfNode);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer modelNo,java.lang.Integer nodeNo) {
        SwfNodeKey swfNodeKey = new SwfNodeKey(modelNo,nodeNo);
        swfNodeDao.delete(swfNodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfNodeDto swfNodeDto) {
        SwfNode swfNode = this.convert(swfNodeDto, SwfNode.class);
        swfNodeDao.save(swfNode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfNodeDto queryByPK(java.lang.Integer modelNo,java.lang.Integer nodeNo) {
        SwfNodeKey swfNodeKey = new SwfNodeKey(modelNo,nodeNo);
        SwfNode swfNode = swfNodeDao.findOne(swfNodeKey);
        return this.convert(swfNode,SwfNodeDto.class);
    }
}