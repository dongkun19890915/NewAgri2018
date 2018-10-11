package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.pms.api.rate.dto.PrpDrateUsualDto;
import com.sinosoft.pms.core.rate.dao.PrpDrateUsualDao;
import com.sinosoft.pms.core.rate.entity.PrpDrateUsual;
import com.sinosoft.pms.core.rate.entity.PrpDrateUsualKey;
import com.sinosoft.pms.core.rate.service.PrpDrateUsualService;
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
 * @description 费率代码表Core接口实现
 */
@Service
public class PrpDrateUsualServiceImpl extends BaseServiceImpl implements PrpDrateUsualService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrateUsualServiceImpl.class);

    @Autowired
    private PrpDrateUsualDao prpDrateUsualDao;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDrateUsualDto prpDrateUsualDto) {
        PrpDrateUsual prpDrateUsual = this.convert(prpDrateUsualDto, PrpDrateUsual.class);
        prpDrateUsualDao.save(prpDrateUsual);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String riskCode, String kindCode, java.lang.Integer ratePeriod, String rateCode, String currency) {
        PrpDrateUsualKey prpDrateUsualKey = new PrpDrateUsualKey(riskCode, kindCode, ratePeriod, rateCode, currency);
        prpDrateUsualDao.delete(prpDrateUsualKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(PrpDrateUsualDto prpDrateUsualDto) {
        PrpDrateUsual prpDrateUsual = this.convert(prpDrateUsualDto, PrpDrateUsual.class);
        prpDrateUsualDao.save(prpDrateUsual);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDrateUsualDto queryByPK(String riskCode, String kindCode, java.lang.Integer ratePeriod, String rateCode, String currency) {
        PrpDrateUsualKey prpDrateUsualKey = new PrpDrateUsualKey(riskCode, kindCode, ratePeriod, rateCode, currency);
        PrpDrateUsual prpDrateUsual = prpDrateUsualDao.findOne(prpDrateUsualKey);
        return this.convert(prpDrateUsual, PrpDrateUsualDto.class);
    }

    @Override
    public List<PrpDrateUsualDto> queryList(PrpDrateUsualDto condition) {
        List<PrpDrateUsualDto> dtoList = new ArrayList<PrpDrateUsualDto>();
        Specification<PrpDrateUsual> spec = Specifications.<PrpDrateUsual>and()
                .eq(StringUtils.isNotEmpty(condition.getRiskCode()), "riskCode", condition.getRiskCode())
                .eq(StringUtils.isNotEmpty(condition.getKindCode()), "kindCode", condition.getKindCode())
                .eq(StringUtils.isNotEmpty(condition.getRateCode()), "rateCode", condition.getRateCode())
                .le(condition.getValidDate() != null, "validDate", condition.getValidDate())
                .eq("validStatus", "1")
                .build();
        this.convertCollection(prpDrateUsualDao.findAll(spec), dtoList, PrpDrateUsualDto.class);
        return dtoList;
    }
}