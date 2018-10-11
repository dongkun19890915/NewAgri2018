package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDclauseKindRelationDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseKindRelationDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKindRelation;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKindRelationKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseKindRelationService;
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
 * @description 条款/条款责任间关系表Core接口实现
 */
@Service
public class PrpDclauseKindRelationServiceImpl extends BaseServiceImpl implements PrpDclauseKindRelationService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseKindRelationServiceImpl.class);
    
    @Autowired
    private PrpDclauseKindRelationDao prpDclauseKindRelationDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseKindRelationDto prpDclauseKindRelationDto) {
        PrpDclauseKindRelation prpDclauseKindRelation = this.convert(prpDclauseKindRelationDto, PrpDclauseKindRelation.class);
        prpDclauseKindRelationDao.save(prpDclauseKindRelation);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String relationCode,java.lang.Integer serialNo) {
        PrpDclauseKindRelationKey prpDclauseKindRelationKey = new PrpDclauseKindRelationKey(clauseCode,relationCode,serialNo);
        prpDclauseKindRelationDao.delete(prpDclauseKindRelationKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseKindRelationDto prpDclauseKindRelationDto) {
        PrpDclauseKindRelation prpDclauseKindRelation = this.convert(prpDclauseKindRelationDto, PrpDclauseKindRelation.class);
        prpDclauseKindRelationDao.save(prpDclauseKindRelation);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseKindRelationDto queryByPK(String clauseCode,String relationCode,java.lang.Integer serialNo) {
        PrpDclauseKindRelationKey prpDclauseKindRelationKey = new PrpDclauseKindRelationKey(clauseCode,relationCode,serialNo);
        PrpDclauseKindRelation prpDclauseKindRelation = prpDclauseKindRelationDao.findOne(prpDclauseKindRelationKey);
        return this.convert(prpDclauseKindRelation,PrpDclauseKindRelationDto.class);
    }
}