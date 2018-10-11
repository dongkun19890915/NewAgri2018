package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskClauseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskClause;
import com.sinosoft.pms.core.kernel.entity.PrpDriskClauseKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskClauseService;
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
 * @description 产品条款定义表Core接口实现
 */
@Service
public class PrpDriskClauseServiceImpl extends BaseServiceImpl implements PrpDriskClauseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskClauseServiceImpl.class);
    
    @Autowired
    private PrpDriskClauseDao prpDriskClauseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskClauseDto prpDriskClauseDto) {
        PrpDriskClause prpDriskClause = this.convert(prpDriskClauseDto, PrpDriskClause.class);
        prpDriskClauseDao.save(prpDriskClause);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseCode) {
        PrpDriskClauseKey prpDriskClauseKey = new PrpDriskClauseKey(riskCode,clauseCode);
        prpDriskClauseDao.delete(prpDriskClauseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskClauseDto prpDriskClauseDto) {
        PrpDriskClause prpDriskClause = this.convert(prpDriskClauseDto, PrpDriskClause.class);
        prpDriskClauseDao.save(prpDriskClause);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskClauseDto queryByPK(String riskCode,String clauseCode) {
        PrpDriskClauseKey prpDriskClauseKey = new PrpDriskClauseKey(riskCode,clauseCode);
        PrpDriskClause prpDriskClause = prpDriskClauseDao.findOne(prpDriskClauseKey);
        return this.convert(prpDriskClause,PrpDriskClauseDto.class);
    }
}