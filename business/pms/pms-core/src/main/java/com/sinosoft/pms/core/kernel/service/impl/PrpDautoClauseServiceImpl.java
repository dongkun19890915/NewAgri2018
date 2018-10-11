package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClause;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseService;
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
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:27:57.599 
 * @description 自动生成特约主表Core接口实现
 */
@Service
public class PrpDautoClauseServiceImpl extends BaseServiceImpl implements PrpDautoClauseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseDao prpDautoClauseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseDto prpDautoClauseDto) {
        PrpDautoClause prpDautoClause = this.convert(prpDautoClauseDto, PrpDautoClause.class);
        prpDautoClauseDao.save(prpDautoClause);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,String riskCode,String clauseCode) {
        PrpDautoClauseKey prpDautoClauseKey = new PrpDautoClauseKey(comCode,riskCode,clauseCode);
        prpDautoClauseDao.delete(prpDautoClauseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseDto prpDautoClauseDto) {
        PrpDautoClause prpDautoClause = this.convert(prpDautoClauseDto, PrpDautoClause.class);
        prpDautoClauseDao.save(prpDautoClause);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseDto queryByPK(String comCode,String riskCode,String clauseCode) {
        PrpDautoClauseKey prpDautoClauseKey = new PrpDautoClauseKey(comCode,riskCode,clauseCode);
        PrpDautoClause prpDautoClause = prpDautoClauseDao.findOne(prpDautoClauseKey);
        return this.convert(prpDautoClause,PrpDautoClauseDto.class);
    }
}