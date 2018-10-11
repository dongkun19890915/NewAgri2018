package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDrateGroupDto;
import com.sinosoft.pms.core.rate.dao.PrpDrateGroupDao;
import com.sinosoft.pms.core.rate.entity.PrpDrateGroup;
import com.sinosoft.pms.core.rate.entity.PrpDrateGroupKey;
import com.sinosoft.pms.core.rate.service.PrpDrateGroupService;
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
 * @time 2017-08-22 03:00:50.124
 * @description 费率分组表Core接口实现
 */
@Service
public class PrpDrateGroupServiceImpl extends BaseServiceImpl implements PrpDrateGroupService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrateGroupServiceImpl.class);

    @Autowired
    private PrpDrateGroupDao prpDrateGroupDao;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDrateGroupDto prpDrateGroupDto) {
        PrpDrateGroup prpDrateGroup = this.convert(prpDrateGroupDto, PrpDrateGroup.class);
        prpDrateGroupDao.save(prpDrateGroup);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String comCode, String rateType, String riskCode, String kindCode, String rateGroupCode, java.lang.Integer ratePeriod) {
        PrpDrateGroupKey prpDrateGroupKey = new PrpDrateGroupKey(comCode, rateType, riskCode, kindCode, rateGroupCode, ratePeriod);
        prpDrateGroupDao.delete(prpDrateGroupKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(PrpDrateGroupDto prpDrateGroupDto) {
        PrpDrateGroup prpDrateGroup = this.convert(prpDrateGroupDto, PrpDrateGroup.class);
        prpDrateGroupDao.save(prpDrateGroup);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDrateGroupDto queryByPK(String comCode, String rateType, String riskCode, String kindCode, String rateGroupCode, java.lang.Integer ratePeriod) {
        PrpDrateGroupKey prpDrateGroupKey = new PrpDrateGroupKey(comCode, rateType, riskCode, kindCode, rateGroupCode, ratePeriod);
        PrpDrateGroup prpDrateGroup = prpDrateGroupDao.findOne(prpDrateGroupKey);
        return this.convert(prpDrateGroup, PrpDrateGroupDto.class);
    }

    @Override
    public List<PrpDrateGroupDto> queryList(PrpDrateGroupDto condition) {
        List<PrpDrateGroupDto> dtoList = new ArrayList<PrpDrateGroupDto>();
        Specification<PrpDrateGroup> spec = Specifications.<PrpDrateGroup>and()
                .eq(StringUtils.isNotEmpty(condition.getRiskCode()), "riskCode", condition.getRiskCode())
                .eq(StringUtils.isNotEmpty(condition.getKindCode()), "kindCode", condition.getKindCode())
                .eq(StringUtils.isNotEmpty(condition.getRateGroupCode()), "rateGroupCode", condition.getRateGroupCode())
                .le(condition.getValidDate() != null, "validDate", condition.getValidDate())
                .eq("validStatus", "1")
                .build();
        this.convertCollection(prpDrateGroupDao.findAll(spec), dtoList, PrpDrateGroupDto.class);
        return dtoList;
    }
}