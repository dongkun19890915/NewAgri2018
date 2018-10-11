package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiParamDto;
import com.sinosoft.ims.core.auth.dao.UtiParamDao;
import com.sinosoft.ims.core.auth.entity.UtiParam;
import com.sinosoft.ims.core.auth.entity.UtiParamKey;
import com.sinosoft.ims.core.auth.service.UtiParamService;
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
 * @description UtiParamCore接口实现
 */
@Service
public class UtiParamServiceImpl extends BaseServiceImpl implements UtiParamService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiParamServiceImpl.class);
    
    @Autowired
    private UtiParamDao utiParamDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiParamDto utiParamDto) {
        UtiParam utiParam = this.convert(utiParamDto, UtiParam.class);
        utiParamDao.save(utiParam);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String paramCode) {
        UtiParamKey utiParamKey = new UtiParamKey(paramCode);
        utiParamDao.delete(utiParamKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiParamDto utiParamDto) {
        UtiParam utiParam = this.convert(utiParamDto, UtiParam.class);
        utiParamDao.save(utiParam);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiParamDto queryByPK(String paramCode) {
        UtiParamKey utiParamKey = new UtiParamKey(paramCode);
        UtiParam utiParam = utiParamDao.findOne(utiParamKey);
        return this.convert(utiParam,UtiParamDto.class);
    }
}