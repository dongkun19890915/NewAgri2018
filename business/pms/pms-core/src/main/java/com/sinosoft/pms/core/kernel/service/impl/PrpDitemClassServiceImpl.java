package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDitemClassDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemClassDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitemClass;
import com.sinosoft.pms.core.kernel.entity.PrpDitemClassKey;
import com.sinosoft.pms.core.kernel.service.PrpDitemClassService;
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
 * @description 标的险种分类子表Core接口实现
 */
@Service
public class PrpDitemClassServiceImpl extends BaseServiceImpl implements PrpDitemClassService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDitemClassServiceImpl.class);
    
    @Autowired
    private PrpDitemClassDao prpDitemClassDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDitemClassDto prpDitemClassDto) {
        PrpDitemClass prpDitemClass = this.convert(prpDitemClassDto, PrpDitemClass.class);
        prpDitemClassDao.save(prpDitemClass);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String itemCode   ) {
        PrpDitemClassKey prpDitemClassKey = new PrpDitemClassKey(itemCode   );
        prpDitemClassDao.delete(prpDitemClassKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDitemClassDto prpDitemClassDto) {
        PrpDitemClass prpDitemClass = this.convert(prpDitemClassDto, PrpDitemClass.class);
        prpDitemClassDao.save(prpDitemClass);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDitemClassDto queryByPK(String itemCode   ) {
        PrpDitemClassKey prpDitemClassKey = new PrpDitemClassKey(itemCode   );
        PrpDitemClass prpDitemClass = prpDitemClassDao.findOne(prpDitemClassKey);
        return this.convert(prpDitemClass,PrpDitemClassDto.class);
    }
}