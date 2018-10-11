package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDclauseLimitDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseLimitDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseLimit;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseLimitKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseLimitService;
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
 * @description 条款限额免赔保额表Core接口实现
 */
@Service
public class PrpDclauseLimitServiceImpl extends BaseServiceImpl implements PrpDclauseLimitService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseLimitServiceImpl.class);
    
    @Autowired
    private PrpDclauseLimitDao prpDclauseLimitDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseLimitDto prpDclauseLimitDto) {
        PrpDclauseLimit prpDclauseLimit = this.convert(prpDclauseLimitDto, PrpDclauseLimit.class);
        prpDclauseLimitDao.save(prpDclauseLimit);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,java.lang.Integer serialNo,String limitCode) {
        PrpDclauseLimitKey prpDclauseLimitKey = new PrpDclauseLimitKey(clauseCode,serialNo,limitCode);
        prpDclauseLimitDao.delete(prpDclauseLimitKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseLimitDto prpDclauseLimitDto) {
        PrpDclauseLimit prpDclauseLimit = this.convert(prpDclauseLimitDto, PrpDclauseLimit.class);
        prpDclauseLimitDao.save(prpDclauseLimit);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseLimitDto queryByPK(String clauseCode,java.lang.Integer serialNo,String limitCode) {
        PrpDclauseLimitKey prpDclauseLimitKey = new PrpDclauseLimitKey(clauseCode,serialNo,limitCode);
        PrpDclauseLimit prpDclauseLimit = prpDclauseLimitDao.findOne(prpDclauseLimitKey);
        return this.convert(prpDclauseLimit,PrpDclauseLimitDto.class);
    }
}