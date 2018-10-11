package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDclauseContentDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseContentDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseContent;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseContentKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseContentService;
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
 * @time  2017-08-22 03:00:50.124 
 * @description 条款文档表Core接口实现
 */
@Service
public class PrpDclauseContentServiceImpl extends BaseServiceImpl implements PrpDclauseContentService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseContentServiceImpl.class);
    
    @Autowired
    private PrpDclauseContentDao prpDclauseContentDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseContentDto prpDclauseContentDto) {
        PrpDclauseContent prpDclauseContent = this.convert(prpDclauseContentDto, PrpDclauseContent.class);
        prpDclauseContentDao.save(prpDclauseContent);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,java.lang.Integer serialNo) {
        PrpDclauseContentKey prpDclauseContentKey = new PrpDclauseContentKey(clauseCode,serialNo);
        prpDclauseContentDao.delete(prpDclauseContentKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseContentDto prpDclauseContentDto) {
        PrpDclauseContent prpDclauseContent = this.convert(prpDclauseContentDto, PrpDclauseContent.class);
        prpDclauseContentDao.save(prpDclauseContent);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseContentDto queryByPK(String clauseCode,java.lang.Integer serialNo) {
        PrpDclauseContentKey prpDclauseContentKey = new PrpDclauseContentKey(clauseCode,serialNo);
        PrpDclauseContent prpDclauseContent = prpDclauseContentDao.findOne(prpDclauseContentKey);
        return this.convert(prpDclauseContent,PrpDclauseContentDto.class);
    }
}