package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwFactorDto;
import com.sinosoft.ims.core.auth.dao.UtiUwFactorDao;
import com.sinosoft.ims.core.auth.entity.UtiUwFactor;
import com.sinosoft.ims.core.auth.entity.UtiUwFactorKey;
import com.sinosoft.ims.core.auth.service.UtiUwFactorService;
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
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwFactorCore接口实现
 */
@Service
public class UtiUwFactorServiceImpl extends BaseServiceImpl implements UtiUwFactorService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUwFactorServiceImpl.class);
    
    @Autowired
    private UtiUwFactorDao utiUwFactorDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUwFactorDto utiUwFactorDto) {
        UtiUwFactor utiUwFactor = this.convert(utiUwFactorDto, UtiUwFactor.class);
        utiUwFactorDao.save(utiUwFactor);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String uwType,String factorCode,String classCode) {
        UtiUwFactorKey utiUwFactorKey = new UtiUwFactorKey(uwType,factorCode,classCode);
        utiUwFactorDao.delete(utiUwFactorKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUwFactorDto utiUwFactorDto) {
        UtiUwFactor utiUwFactor = this.convert(utiUwFactorDto, UtiUwFactor.class);
        utiUwFactorDao.save(utiUwFactor);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUwFactorDto queryByPK(String uwType,String factorCode,String classCode) {
        UtiUwFactorKey utiUwFactorKey = new UtiUwFactorKey(uwType,factorCode,classCode);
        UtiUwFactor utiUwFactor = utiUwFactorDao.findOne(utiUwFactorKey);
        return this.convert(utiUwFactor,UtiUwFactorDto.class);
    }
}