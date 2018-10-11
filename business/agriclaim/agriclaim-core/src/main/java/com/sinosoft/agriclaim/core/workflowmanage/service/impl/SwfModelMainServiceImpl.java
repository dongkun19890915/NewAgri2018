package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfModelMainDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelMainKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfModelMainService;
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
 * @description 模板主表Core接口实现
 */
@Service
public class SwfModelMainServiceImpl extends BaseServiceImpl implements SwfModelMainService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfModelMainServiceImpl.class);
    
    @Autowired
    private SwfModelMainDao swfModelMainDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfModelMainDto swfModelMainDto) {
        SwfModelMain swfModelMain = this.convert(swfModelMainDto, SwfModelMain.class);
        swfModelMainDao.save(swfModelMain);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer modelNo) {
        SwfModelMainKey swfModelMainKey = new SwfModelMainKey(modelNo);
        swfModelMainDao.delete(swfModelMainKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfModelMainDto swfModelMainDto) {
        SwfModelMain swfModelMain = this.convert(swfModelMainDto, SwfModelMain.class);
        swfModelMainDao.save(swfModelMain);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfModelMainDto queryByPK(java.lang.Integer modelNo) {
        SwfModelMainKey swfModelMainKey = new SwfModelMainKey(modelNo);
        SwfModelMain swfModelMain = swfModelMainDao.findOne(swfModelMainKey);
        return this.convert(swfModelMain,SwfModelMainDto.class);
    }
}