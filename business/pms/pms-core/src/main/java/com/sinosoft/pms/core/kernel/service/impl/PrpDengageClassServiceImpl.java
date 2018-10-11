package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDengageClassDto;
import com.sinosoft.pms.core.kernel.dao.PrpDengageClassDao;
import com.sinosoft.pms.core.kernel.entity.PrpDengageClass;
import com.sinosoft.pms.core.kernel.entity.PrpDengageClassKey;
import com.sinosoft.pms.core.kernel.service.PrpDengageClassService;
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
 * @description 特别约定险类表Core接口实现
 */
@Service
public class PrpDengageClassServiceImpl extends BaseServiceImpl implements PrpDengageClassService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDengageClassServiceImpl.class);
    
    @Autowired
    private PrpDengageClassDao prpDengageClassDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDengageClassDto prpDengageClassDto) {
        PrpDengageClass prpDengageClass = this.convert(prpDengageClassDto, PrpDengageClass.class);
        prpDengageClassDao.save(prpDengageClass);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String engageCode,String classCode) {
        PrpDengageClassKey prpDengageClassKey = new PrpDengageClassKey(engageCode,classCode);
        prpDengageClassDao.delete(prpDengageClassKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDengageClassDto prpDengageClassDto) {
        PrpDengageClass prpDengageClass = this.convert(prpDengageClassDto, PrpDengageClass.class);
        prpDengageClassDao.save(prpDengageClass);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDengageClassDto queryByPK(String engageCode,String classCode) {
        PrpDengageClassKey prpDengageClassKey = new PrpDengageClassKey(engageCode,classCode);
        PrpDengageClass prpDengageClass = prpDengageClassDao.findOne(prpDengageClassKey);
        return this.convert(prpDengageClass,PrpDengageClassDto.class);
    }
}