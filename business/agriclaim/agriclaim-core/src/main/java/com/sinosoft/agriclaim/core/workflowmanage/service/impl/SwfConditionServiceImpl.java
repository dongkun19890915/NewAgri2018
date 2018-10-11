package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfConditionDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfConditionDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfCondition;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfConditionKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfConditionService;
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
 * @description 工作流条件描述表Core接口实现
 */
@Service
public class SwfConditionServiceImpl extends BaseServiceImpl implements SwfConditionService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfConditionServiceImpl.class);
    
    @Autowired
    private SwfConditionDao swfConditionDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfConditionDto swfConditionDto) {
        SwfCondition swfCondition = this.convert(swfConditionDto, SwfCondition.class);
        swfConditionDao.save(swfCondition);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo) {
        SwfConditionKey swfConditionKey = new SwfConditionKey(modelNo,pathNo,conditionNo,serialNo);
        swfConditionDao.delete(swfConditionKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfConditionDto swfConditionDto) {
        SwfCondition swfCondition = this.convert(swfConditionDto, SwfCondition.class);
        swfConditionDao.save(swfCondition);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfConditionDto queryByPK(java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo) {
        SwfConditionKey swfConditionKey = new SwfConditionKey(modelNo,pathNo,conditionNo,serialNo);
        SwfCondition swfCondition = swfConditionDao.findOne(swfConditionKey);
        return this.convert(swfCondition,SwfConditionDto.class);
    }
}