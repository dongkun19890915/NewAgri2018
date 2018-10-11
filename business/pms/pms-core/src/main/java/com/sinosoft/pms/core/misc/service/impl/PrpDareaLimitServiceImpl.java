package com.sinosoft.pms.core.misc.service.impl;

import com.sinosoft.pms.api.misc.dto.PrpDareaLimitDto;
import com.sinosoft.pms.core.misc.dao.PrpDareaLimitDao;
import com.sinosoft.pms.core.misc.entity.PrpDareaLimit;
import com.sinosoft.pms.core.misc.entity.PrpDareaLimitKey;
import com.sinosoft.pms.core.misc.service.PrpDareaLimitService;
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
 * @description 地区限额控制配置表Core接口实现
 */
@Service
public class PrpDareaLimitServiceImpl extends BaseServiceImpl implements PrpDareaLimitService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDareaLimitServiceImpl.class);
    
    @Autowired
    private PrpDareaLimitDao prpDareaLimitDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDareaLimitDto prpDareaLimitDto) {
        PrpDareaLimit prpDareaLimit = this.convert(prpDareaLimitDto, PrpDareaLimit.class);
        prpDareaLimitDao.save(prpDareaLimit);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String areaCode,String versionNo) {
        PrpDareaLimitKey prpDareaLimitKey = new PrpDareaLimitKey(riskCode,areaCode,versionNo);
        prpDareaLimitDao.delete(prpDareaLimitKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDareaLimitDto prpDareaLimitDto) {
        PrpDareaLimit prpDareaLimit = this.convert(prpDareaLimitDto, PrpDareaLimit.class);
        prpDareaLimitDao.save(prpDareaLimit);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDareaLimitDto queryByPK(String riskCode,String areaCode,String versionNo) {
        PrpDareaLimitKey prpDareaLimitKey = new PrpDareaLimitKey(riskCode,areaCode,versionNo);
        PrpDareaLimit prpDareaLimit = prpDareaLimitDao.findOne(prpDareaLimitKey);
        return this.convert(prpDareaLimit,PrpDareaLimitDto.class);
    }
}