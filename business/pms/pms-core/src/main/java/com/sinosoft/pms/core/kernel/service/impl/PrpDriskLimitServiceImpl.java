package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDriskLimitDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskLimitDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskLimit;
import com.sinosoft.pms.core.kernel.entity.PrpDriskLimitKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskLimitService;
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
 * @description 产品限额/免赔表Core接口实现
 */
@Service
public class PrpDriskLimitServiceImpl extends BaseServiceImpl implements PrpDriskLimitService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskLimitServiceImpl.class);
    
    @Autowired
    private PrpDriskLimitDao prpDriskLimitDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskLimitDto prpDriskLimitDto) {
        PrpDriskLimit prpDriskLimit = this.convert(prpDriskLimitDto, PrpDriskLimit.class);
        prpDriskLimitDao.save(prpDriskLimit);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseCode,java.lang.Integer serialNo,String limitCode) {
        PrpDriskLimitKey prpDriskLimitKey = new PrpDriskLimitKey(riskCode,clauseCode,serialNo,limitCode);
        prpDriskLimitDao.delete(prpDriskLimitKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskLimitDto prpDriskLimitDto) {
        PrpDriskLimit prpDriskLimit = this.convert(prpDriskLimitDto, PrpDriskLimit.class);
        prpDriskLimitDao.save(prpDriskLimit);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskLimitDto queryByPK(String riskCode,String clauseCode,java.lang.Integer serialNo,String limitCode) {
        PrpDriskLimitKey prpDriskLimitKey = new PrpDriskLimitKey(riskCode,clauseCode,serialNo,limitCode);
        PrpDriskLimit prpDriskLimit = prpDriskLimitDao.findOne(prpDriskLimitKey);
        return this.convert(prpDriskLimit,PrpDriskLimitDto.class);
    }
}