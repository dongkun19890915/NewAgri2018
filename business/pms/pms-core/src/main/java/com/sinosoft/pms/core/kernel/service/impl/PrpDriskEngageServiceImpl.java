package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDriskEngageDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskEngageDao;
import com.sinosoft.pms.core.kernel.entity.PrpDriskEngage;
import com.sinosoft.pms.core.kernel.entity.PrpDriskEngageKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskEngageService;
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
 * @description 产品特别约定表Core接口实现
 */
@Service
public class PrpDriskEngageServiceImpl extends BaseServiceImpl implements PrpDriskEngageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskEngageServiceImpl.class);
    
    @Autowired
    private PrpDriskEngageDao prpDriskEngageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDriskEngageDto prpDriskEngageDto) {
        PrpDriskEngage prpDriskEngage = this.convert(prpDriskEngageDto, PrpDriskEngage.class);
        prpDriskEngageDao.save(prpDriskEngage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String clauseCode,String engageCode) {
        PrpDriskEngageKey prpDriskEngageKey = new PrpDriskEngageKey(riskCode,clauseCode,engageCode);
        prpDriskEngageDao.delete(prpDriskEngageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDriskEngageDto prpDriskEngageDto) {
        PrpDriskEngage prpDriskEngage = this.convert(prpDriskEngageDto, PrpDriskEngage.class);
        prpDriskEngageDao.save(prpDriskEngage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskEngageDto queryByPK(String riskCode,String clauseCode,String engageCode) {
        PrpDriskEngageKey prpDriskEngageKey = new PrpDriskEngageKey(riskCode,clauseCode,engageCode);
        PrpDriskEngage prpDriskEngage = prpDriskEngageDao.findOne(prpDriskEngageKey);
        return this.convert(prpDriskEngage,PrpDriskEngageDto.class);
    }
}