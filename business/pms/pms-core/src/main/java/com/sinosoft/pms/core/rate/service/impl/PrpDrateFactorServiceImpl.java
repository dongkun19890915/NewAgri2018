package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.rate.dto.PrpDrateFactorDto;
import com.sinosoft.pms.core.rate.dao.PrpDrateFactorDao;
import com.sinosoft.pms.core.rate.entity.PrpDrateFactor;
import com.sinosoft.pms.core.rate.entity.PrpDrateFactorKey;
import com.sinosoft.pms.core.rate.service.PrpDrateFactorService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-22 03:00:50.124
 * @description 费率因子表Core接口实现
 */
@Service
public class PrpDrateFactorServiceImpl extends BaseServiceImpl implements PrpDrateFactorService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrateFactorServiceImpl.class);

    @Autowired
    private PrpDrateFactorDao prpDrateFactorDao;

    /**
     * @param
     * @description 新增
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDrateFactorDto prpDrateFactorDto) {
        PrpDrateFactor prpDrateFactor = this.convert(prpDrateFactorDto, PrpDrateFactor.class);
        prpDrateFactorDao.save(prpDrateFactor);
    }

    /**
     * @param
     * @description 删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode, String factorType, String factorCode, String factorTable, String rateType, java.lang.Integer ratePeriod) {
        PrpDrateFactorKey prpDrateFactorKey = new PrpDrateFactorKey(riskCode, factorType, factorCode, factorTable, rateType, ratePeriod);
        prpDrateFactorDao.delete(prpDrateFactorKey);
    }

    /**
     * @param
     * @description 修改
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDrateFactorDto prpDrateFactorDto) {
        PrpDrateFactor prpDrateFactor = this.convert(prpDrateFactorDto, PrpDrateFactor.class);
        prpDrateFactorDao.save(prpDrateFactor);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    @Override
    public PrpDrateFactorDto queryByPK(String riskCode, String factorType, String factorCode, String factorTable, String rateType, java.lang.Integer ratePeriod) {
        PrpDrateFactorKey prpDrateFactorKey = new PrpDrateFactorKey(riskCode, factorType, factorCode, factorTable, rateType, ratePeriod);
        PrpDrateFactor prpDrateFactor = prpDrateFactorDao.findOne(prpDrateFactorKey);
        return this.convert(prpDrateFactor, PrpDrateFactorDto.class);
    }

    @Override
    public List<PrpDrateFactorDto> queryList(PrpDrateFactorDto condition) {
        List<PrpDrateFactorDto> dtoList = new ArrayList<PrpDrateFactorDto>();
        Specification<PrpDrateFactor> spec = Specifications.<PrpDrateFactor>and()
                .eq(StringUtils.isNotEmpty(condition.getRiskCode()), "riskCode", condition.getRiskCode())
                .eq(StringUtils.isNotEmpty(condition.getFactorType()), "factorType", condition.getFactorType())
                .eq(StringUtils.isNotEmpty(condition.getFactorCode()), "factorCode", condition.getFactorCode())
                .eq(StringUtils.isNotEmpty(condition.getValidStatus()), "validStatus", condition.getValidStatus())
                .le(condition.getValidDate() != null, "validDate", condition.getValidDate())
                .eq("validStatus", "1")
                .build();
        this.convertCollection(prpDrateFactorDao.findAll(spec), dtoList, PrpDrateFactorDto.class);
        return dtoList;
    }
}