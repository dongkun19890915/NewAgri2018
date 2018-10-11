package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiSysParamDto;
import com.sinosoft.ims.core.auth.dao.UtiSysParamDao;
import com.sinosoft.ims.core.auth.entity.UtiSysParam;
import com.sinosoft.ims.core.auth.entity.UtiSysParamKey;
import com.sinosoft.ims.core.auth.service.UtiSysParamService;
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
 * @description UtiSysParamCore接口实现
 */
@Service
public class UtiSysParamServiceImpl extends BaseServiceImpl implements UtiSysParamService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiSysParamServiceImpl.class);
    
    @Autowired
    private UtiSysParamDao utiSysParamDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiSysParamDto utiSysParamDto) {
        UtiSysParam utiSysParam = this.convert(utiSysParamDto, UtiSysParam.class);
        utiSysParamDao.save(utiSysParam);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String systemCode,String paramCode) {
        UtiSysParamKey utiSysParamKey = new UtiSysParamKey(systemCode,paramCode);
        utiSysParamDao.delete(utiSysParamKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiSysParamDto utiSysParamDto) {
        UtiSysParam utiSysParam = this.convert(utiSysParamDto, UtiSysParam.class);
        utiSysParamDao.save(utiSysParam);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSysParamDto queryByPK(String systemCode,String paramCode) {
        UtiSysParamKey utiSysParamKey = new UtiSysParamKey(systemCode,paramCode);
        UtiSysParam utiSysParam = utiSysParamDao.findOne(utiSysParamKey);
        return this.convert(utiSysParam,UtiSysParamDto.class);
    }
}