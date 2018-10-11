package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowRecDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.WorkFlowRecDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.WorkFlowRec;
import com.sinosoft.agriclaim.core.workflowmanage.entity.WorkFlowRecKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowRecService;
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
 * @description 流程监控表Core接口实现
 */
@Service
public class WorkFlowRecServiceImpl extends BaseServiceImpl implements WorkFlowRecService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkFlowRecServiceImpl.class);
    
    @Autowired
    private WorkFlowRecDao workFlowRecDao;

    /**
     *@description 新增
     *@param
     */
    public void save(WorkFlowRecDto workFlowRecDto) {
        WorkFlowRec workFlowRec = this.convert(workFlowRecDto, WorkFlowRec.class);
        workFlowRecDao.save(workFlowRec);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String nodeCode,String businessNo,java.lang.Integer serialNo) {
        WorkFlowRecKey workFlowRecKey = new WorkFlowRecKey(nodeCode,businessNo,serialNo);
        workFlowRecDao.delete(workFlowRecKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(WorkFlowRecDto workFlowRecDto) {
        WorkFlowRec workFlowRec = this.convert(workFlowRecDto, WorkFlowRec.class);
        workFlowRecDao.save(workFlowRec);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public WorkFlowRecDto queryByPK(String nodeCode,String businessNo,java.lang.Integer serialNo) {
        WorkFlowRecKey workFlowRecKey = new WorkFlowRecKey(nodeCode,businessNo,serialNo);
        WorkFlowRec workFlowRec = workFlowRecDao.findOne(workFlowRecKey);
        return this.convert(workFlowRec,WorkFlowRecDto.class);
    }
}