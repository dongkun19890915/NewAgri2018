package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDkindClauseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClause;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseKey;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClauseCore接口实现
 */
@Service
public class PrpDkindClauseServiceImpl extends BaseServiceImpl implements PrpDkindClauseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDkindClauseServiceImpl.class);
    
    @Autowired
    private PrpDkindClauseDao prpDkindClauseDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDkindClauseDto prpDkindClauseDto) {
        PrpDkindClause prpDkindClause = this.convert(prpDkindClauseDto, PrpDkindClause.class);
        prpDkindClauseDao.save(prpDkindClause);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        PrpDkindClauseKey prpDkindClauseKey = new PrpDkindClauseKey(riskCode,clauseFlag,kindCode,language,clauseCode);
        prpDkindClauseDao.delete(prpDkindClauseKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDkindClauseDto prpDkindClauseDto) {
        PrpDkindClause prpDkindClause = this.convert(prpDkindClauseDto, PrpDkindClause.class);
        prpDkindClauseDao.save(prpDkindClause);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindClauseDto queryByPK(String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        PrpDkindClauseKey prpDkindClauseKey = new PrpDkindClauseKey(riskCode,clauseFlag,kindCode,language,clauseCode);
        PrpDkindClause prpDkindClause = prpDkindClauseDao.findOne(prpDkindClauseKey);
        return this.convert(prpDkindClause,PrpDkindClauseDto.class);
    }

    /**
     * 根据险种代码查询条款代码集合
     * @param riskCode 险种代码
     * @return List<String> 条款代码集合
     * @throws Exception
     */
    @Override
    public List<String> queryClauseCode(String riskCode)throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空！");
        }
        List<String> clauseCodes=prpDkindClauseDao.findByRiskCode(riskCode);
        return clauseCodes;
    }
}