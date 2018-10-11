package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiSolvencyDto;
import com.sinosoft.ims.core.auth.dao.UtiSolvencyDao;
import com.sinosoft.ims.core.auth.entity.UtiSolvency;
import com.sinosoft.ims.core.auth.entity.UtiSolvencyKey;
import com.sinosoft.ims.core.auth.service.UtiSolvencyService;
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
 * @time  2017-11-05 01:10:45.148 
 * @description UtiSolvencyCore接口实现
 */
@Service
public class UtiSolvencyServiceImpl extends BaseServiceImpl implements UtiSolvencyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiSolvencyServiceImpl.class);
    
    @Autowired
    private UtiSolvencyDao utiSolvencyDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiSolvencyDto utiSolvencyDto) {
        UtiSolvency utiSolvency = this.convert(utiSolvencyDto, UtiSolvency.class);
        utiSolvencyDao.save(utiSolvency);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.util.Date id) {
        UtiSolvencyKey utiSolvencyKey = new UtiSolvencyKey(id);
        utiSolvencyDao.delete(utiSolvencyKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiSolvencyDto utiSolvencyDto) {
        UtiSolvency utiSolvency = this.convert(utiSolvencyDto, UtiSolvency.class);
        utiSolvencyDao.save(utiSolvency);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSolvencyDto queryByPK(java.util.Date id) {
        UtiSolvencyKey utiSolvencyKey = new UtiSolvencyKey(id);
        UtiSolvency utiSolvency = utiSolvencyDao.findOne(utiSolvencyKey);
        return this.convert(utiSolvency,UtiSolvencyDto.class);
    }
}