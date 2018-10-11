package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwComboFactorDto;
import com.sinosoft.ims.core.auth.dao.UtiUwComboFactorDao;
import com.sinosoft.ims.core.auth.entity.UtiUwComboFactor;
import com.sinosoft.ims.core.auth.entity.UtiUwComboFactorKey;
import com.sinosoft.ims.core.auth.service.UtiUwComboFactorService;
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
 * @description UtiUwComboFactorCore接口实现
 */
@Service
public class UtiUwComboFactorServiceImpl extends BaseServiceImpl implements UtiUwComboFactorService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUwComboFactorServiceImpl.class);
    
    @Autowired
    private UtiUwComboFactorDao utiUwComboFactorDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUwComboFactorDto utiUwComboFactorDto) {
        UtiUwComboFactor utiUwComboFactor = this.convert(utiUwComboFactorDto, UtiUwComboFactor.class);
        utiUwComboFactorDao.save(utiUwComboFactor);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String uwType,String classCode,String factorCode,String codeType) {
        UtiUwComboFactorKey utiUwComboFactorKey = new UtiUwComboFactorKey(uwType,classCode,factorCode,codeType);
        utiUwComboFactorDao.delete(utiUwComboFactorKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUwComboFactorDto utiUwComboFactorDto) {
        UtiUwComboFactor utiUwComboFactor = this.convert(utiUwComboFactorDto, UtiUwComboFactor.class);
        utiUwComboFactorDao.save(utiUwComboFactor);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUwComboFactorDto queryByPK(String uwType,String classCode,String factorCode,String codeType) {
        UtiUwComboFactorKey utiUwComboFactorKey = new UtiUwComboFactorKey(uwType,classCode,factorCode,codeType);
        UtiUwComboFactor utiUwComboFactor = utiUwComboFactorDao.findOne(utiUwComboFactorKey);
        return this.convert(utiUwComboFactor,UtiUwComboFactorDto.class);
    }
}