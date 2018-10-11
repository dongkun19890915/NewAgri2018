package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiSystemDto;
import com.sinosoft.ims.core.auth.dao.UtiSystemDao;
import com.sinosoft.ims.core.auth.entity.UtiSystem;
import com.sinosoft.ims.core.auth.entity.UtiSystemKey;
import com.sinosoft.ims.core.auth.service.UtiSystemService;
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
 * @description 系统定义表Core接口实现
 */
@Service
public class UtiSystemServiceImpl extends BaseServiceImpl implements UtiSystemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiSystemServiceImpl.class);
    
    @Autowired
    private UtiSystemDao utiSystemDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiSystemDto utiSystemDto) {
        UtiSystem utiSystem = this.convert(utiSystemDto, UtiSystem.class);
        utiSystemDao.save(utiSystem);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String systemCode) {
        UtiSystemKey utiSystemKey = new UtiSystemKey(systemCode);
        utiSystemDao.delete(utiSystemKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiSystemDto utiSystemDto) {
        UtiSystem utiSystem = this.convert(utiSystemDto, UtiSystem.class);
        utiSystemDao.save(utiSystem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSystemDto queryByPK(String systemCode) {
        UtiSystemKey utiSystemKey = new UtiSystemKey(systemCode);
        UtiSystem utiSystem = utiSystemDao.findOne(utiSystemKey);
        return this.convert(utiSystem,UtiSystemDto.class);
    }
}