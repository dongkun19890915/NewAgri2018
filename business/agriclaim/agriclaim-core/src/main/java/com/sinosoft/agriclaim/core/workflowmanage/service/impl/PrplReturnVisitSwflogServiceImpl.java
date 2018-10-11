package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.PrplReturnVisitSwflogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflogKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.PrplReturnVisitSwflogService;
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
 * @time  2017-11-10 02:50:26.122 
 * @description 回访工作流表Core接口实现
 */
@Service
public class PrplReturnVisitSwflogServiceImpl extends BaseServiceImpl implements PrplReturnVisitSwflogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrplReturnVisitSwflogServiceImpl.class);
    
    @Autowired
    private PrplReturnVisitSwflogDao prplReturnVisitSwflogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrplReturnVisitSwflogDto prplReturnVisitSwflogDto) {
        PrplReturnVisitSwflog prplReturnVisitSwflog = this.convert(prplReturnVisitSwflogDto, PrplReturnVisitSwflog.class);
        prplReturnVisitSwflogDao.save(prplReturnVisitSwflog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String businessNo,String nodeType) {
        PrplReturnVisitSwflogKey prplReturnVisitSwflogKey = new PrplReturnVisitSwflogKey(businessNo,nodeType);
        prplReturnVisitSwflogDao.delete(prplReturnVisitSwflogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrplReturnVisitSwflogDto prplReturnVisitSwflogDto) {
        PrplReturnVisitSwflog prplReturnVisitSwflog = this.convert(prplReturnVisitSwflogDto, PrplReturnVisitSwflog.class);
        prplReturnVisitSwflogDao.save(prplReturnVisitSwflog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrplReturnVisitSwflogDto queryByPK(String businessNo,String nodeType) {
        PrplReturnVisitSwflogKey prplReturnVisitSwflogKey = new PrplReturnVisitSwflogKey(businessNo,nodeType);
        PrplReturnVisitSwflog prplReturnVisitSwflog = prplReturnVisitSwflogDao.findOne(prplReturnVisitSwflogKey);
        return this.convert(prplReturnVisitSwflog,PrplReturnVisitSwflogDto.class);
    }
}