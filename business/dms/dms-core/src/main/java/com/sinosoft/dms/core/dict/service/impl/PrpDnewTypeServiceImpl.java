package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.dms.core.dict.dao.PrpDnewTypeDao;
import com.sinosoft.dms.core.dict.entity.PrpDnewType;
import com.sinosoft.dms.core.dict.entity.PrpDnewTypeKey;
import com.sinosoft.dms.core.dict.service.PrpDnewTypeService;
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
 * @time  2017-08-22 03:00:01.505 
 * @description 通用代码类表Core接口实现
 */
@Service
public class PrpDnewTypeServiceImpl extends BaseServiceImpl implements PrpDnewTypeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDnewTypeServiceImpl.class);
    
    @Autowired
    private PrpDnewTypeDao prpDnewTypeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDnewTypeDto prpDnewTypeDto) {
        PrpDnewType prpDnewType = this.convert(prpDnewTypeDto, PrpDnewType.class);
        prpDnewTypeDao.save(prpDnewType);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String codeType) {
        PrpDnewTypeKey prpDnewTypeKey = new PrpDnewTypeKey(codeType);
        prpDnewTypeDao.delete(prpDnewTypeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDnewTypeDto prpDnewTypeDto) {
        PrpDnewType prpDnewType = this.convert(prpDnewTypeDto, PrpDnewType.class);
        prpDnewTypeDao.save(prpDnewType);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDnewTypeDto queryByPK(String codeType) {
        PrpDnewTypeKey prpDnewTypeKey = new PrpDnewTypeKey(codeType);
        PrpDnewType prpDnewType = prpDnewTypeDao.findOne(prpDnewTypeKey);
        return this.convert(prpDnewType,PrpDnewTypeDto.class);
    }
}