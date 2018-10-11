package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfModelUseDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelUse;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelUseKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfModelUseService;
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
 * @description 模板使用设置Core接口实现
 */
@Service
public class SwfModelUseServiceImpl extends BaseServiceImpl implements SwfModelUseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfModelUseServiceImpl.class);
    
    @Autowired
    private SwfModelUseDao swfModelUseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfModelUseDto swfModelUseDto) {
        SwfModelUse swfModelUse = this.convert(swfModelUseDto, SwfModelUse.class);
        swfModelUseDao.save(swfModelUse);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer modelNo,String riskCode,String comCode,String modelType) {
        SwfModelUseKey swfModelUseKey = new SwfModelUseKey(modelNo,riskCode,comCode,modelType);
        swfModelUseDao.delete(swfModelUseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfModelUseDto swfModelUseDto) {
        SwfModelUse swfModelUse = this.convert(swfModelUseDto, SwfModelUse.class);
        swfModelUseDao.save(swfModelUse);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfModelUseDto queryByPK(java.lang.Integer modelNo,String riskCode,String comCode,String modelType) {
        SwfModelUseKey swfModelUseKey = new SwfModelUseKey(modelNo,riskCode,comCode,modelType);
        SwfModelUse swfModelUse = swfModelUseDao.findOne(swfModelUseKey);
        return this.convert(swfModelUse,SwfModelUseDto.class);
    }
}