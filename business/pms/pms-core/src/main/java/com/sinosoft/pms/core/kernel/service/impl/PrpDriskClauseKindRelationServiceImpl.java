package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseKindRelationDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskClauseKindRelationDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskClauseKindRelation;
import com.sinosoft.pms.core.kernel.entity.PrpDriskClauseKindRelationKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskClauseKindRelationService;
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
 * @description 产品条款/责任关系表Core接口实现
 */
@Service
public class PrpDriskClauseKindRelationServiceImpl extends BaseServiceImpl implements PrpDriskClauseKindRelationService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskClauseKindRelationServiceImpl.class);
    
    @Autowired
    private PrpDriskClauseKindRelationDao prpDriskClauseKindRelationDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskClauseKindRelationDto prpDriskClauseKindRelationDto) {
        PrpDriskClauseKindRelation prpDriskClauseKindRelation = this.convert(prpDriskClauseKindRelationDto, PrpDriskClauseKindRelation.class);
        prpDriskClauseKindRelationDao.save(prpDriskClauseKindRelation);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseCode,String relationCode,java.lang.Integer serialNo) {
        PrpDriskClauseKindRelationKey prpDriskClauseKindRelationKey = new PrpDriskClauseKindRelationKey(riskCode,clauseCode,relationCode,serialNo);
        prpDriskClauseKindRelationDao.delete(prpDriskClauseKindRelationKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskClauseKindRelationDto prpDriskClauseKindRelationDto) {
        PrpDriskClauseKindRelation prpDriskClauseKindRelation = this.convert(prpDriskClauseKindRelationDto, PrpDriskClauseKindRelation.class);
        prpDriskClauseKindRelationDao.save(prpDriskClauseKindRelation);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskClauseKindRelationDto queryByPK(String riskCode,String clauseCode,String relationCode,java.lang.Integer serialNo) {
        PrpDriskClauseKindRelationKey prpDriskClauseKindRelationKey = new PrpDriskClauseKindRelationKey(riskCode,clauseCode,relationCode,serialNo);
        PrpDriskClauseKindRelation prpDriskClauseKindRelation = prpDriskClauseKindRelationDao.findOne(prpDriskClauseKindRelationKey);
        return this.convert(prpDriskClauseKindRelation,PrpDriskClauseKindRelationDto.class);
    }
}