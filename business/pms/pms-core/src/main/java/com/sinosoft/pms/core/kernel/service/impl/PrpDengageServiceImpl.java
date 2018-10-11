package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDengageDto;
import com.sinosoft.pms.core.kernel.dao.PrpDengageDao;
import com.sinosoft.pms.core.kernel.entity.PrpDengage;
import com.sinosoft.pms.core.kernel.entity.PrpDengageKey;
import com.sinosoft.pms.core.kernel.service.PrpDengageService;
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
 * @description 特别约定表Core接口实现
 */
@Service
public class PrpDengageServiceImpl extends BaseServiceImpl implements PrpDengageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDengageServiceImpl.class);
    
    @Autowired
    private PrpDengageDao prpDengageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDengageDto prpDengageDto) {
        PrpDengage prpDengage = this.convert(prpDengageDto, PrpDengage.class);
        prpDengageDao.save(prpDengage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String engageCode) {
        PrpDengageKey prpDengageKey = new PrpDengageKey(engageCode);
        prpDengageDao.delete(prpDengageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDengageDto prpDengageDto) {
        PrpDengage prpDengage = this.convert(prpDengageDto, PrpDengage.class);
        prpDengageDao.save(prpDengage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDengageDto queryByPK(String engageCode) {
        PrpDengageKey prpDengageKey = new PrpDengageKey(engageCode);
        PrpDengage prpDengage = prpDengageDao.findOne(prpDengageKey);
        return this.convert(prpDengage,PrpDengageDto.class);
    }
}