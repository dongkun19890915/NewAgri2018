package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDrateCondDto;
import com.sinosoft.pms.core.rate.dao.PrpDrateCondDao;
import com.sinosoft.pms.core.rate.entity.PrpDrateCond;
import com.sinosoft.pms.core.rate.entity.PrpDrateCondKey;
import com.sinosoft.pms.core.rate.service.PrpDrateCondService;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-22 03:00:50.124
 * @description 费率条件表Core接口实现
 */
@Service
public class PrpDrateCondServiceImpl extends BaseServiceImpl implements PrpDrateCondService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrateCondServiceImpl.class);

    @Autowired
    private PrpDrateCondDao prpDrateCondDao;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDrateCondDto prpDrateCondDto) {
        PrpDrateCond prpDrateCond = this.convert(prpDrateCondDto, PrpDrateCond.class);
        prpDrateCondDao.save(prpDrateCond);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String comCode, String riskCode, String factorType, String kindCode, java.lang.Integer ratePeriod, String factorCode) {
        PrpDrateCondKey prpDrateCondKey = new PrpDrateCondKey(comCode, riskCode, factorType, kindCode, ratePeriod, factorCode);
        prpDrateCondDao.delete(prpDrateCondKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(PrpDrateCondDto prpDrateCondDto) {
        PrpDrateCond prpDrateCond = this.convert(prpDrateCondDto, PrpDrateCond.class);
        prpDrateCondDao.save(prpDrateCond);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDrateCondDto queryByPK(String comCode, String riskCode, String factorType, String kindCode, java.lang.Integer ratePeriod, String factorCode) {
        PrpDrateCondKey prpDrateCondKey = new PrpDrateCondKey(comCode, riskCode, factorType, kindCode, ratePeriod, factorCode);
        PrpDrateCond prpDrateCond = prpDrateCondDao.findOne(prpDrateCondKey);
        return this.convert(prpDrateCond, PrpDrateCondDto.class);
    }

    @Override
    public List<PrpDrateCondDto> queryList(PrpDrateCondDto condition) {
        List<PrpDrateCondDto> dtoList = new ArrayList<PrpDrateCondDto>();
        Specification<PrpDrateCond> spec = Specifications.<PrpDrateCond>and()
                .eq(StringUtils.isNotEmpty(condition.getComCode()), "comCode", condition.getComCode())
                .eq(StringUtils.isNotEmpty(condition.getRiskCode()), "riskCode", condition.getRiskCode())
                .eq(StringUtils.isNotEmpty(condition.getKindCode()), "kindCode", condition.getKindCode())
                .eq(StringUtils.isNotEmpty(condition.getFactorType()), "factorType", condition.getFactorType())
                .eq(StringUtils.isNotEmpty(condition.getValidStatus()), "validStatus", condition.getValidStatus())
                .le(condition.getValidDate() != null, "validDate", condition.getValidDate())
                .eq("validStatus", "1")
                .build();
        List<PrpDrateCond> a = prpDrateCondDao.findAll(spec);
        this.convertCollection(a, dtoList, PrpDrateCondDto.class);
        return dtoList;
    }
}