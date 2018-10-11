package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiMenuTaskDto;
import com.sinosoft.ims.core.auth.dao.UtiMenuTaskDao;
import com.sinosoft.ims.core.auth.entity.UtiMenuTask;
import com.sinosoft.ims.core.auth.entity.UtiMenuTaskKey;
import com.sinosoft.ims.core.auth.service.UtiMenuTaskService;
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
 * @description UtiMenuTaskCore接口实现
 */
@Service
public class UtiMenuTaskServiceImpl extends BaseServiceImpl implements UtiMenuTaskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiMenuTaskServiceImpl.class);
    
    @Autowired
    private UtiMenuTaskDao utiMenuTaskDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiMenuTaskDto utiMenuTaskDto) {
        UtiMenuTask utiMenuTask = this.convert(utiMenuTaskDto, UtiMenuTask.class);
        utiMenuTaskDao.save(utiMenuTask);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String menuId) {
        UtiMenuTaskKey utiMenuTaskKey = new UtiMenuTaskKey(menuId);
        utiMenuTaskDao.delete(utiMenuTaskKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiMenuTaskDto utiMenuTaskDto) {
        UtiMenuTask utiMenuTask = this.convert(utiMenuTaskDto, UtiMenuTask.class);
        utiMenuTaskDao.save(utiMenuTask);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiMenuTaskDto queryByPK(String menuId) {
        UtiMenuTaskKey utiMenuTaskKey = new UtiMenuTaskKey(menuId);
        UtiMenuTask utiMenuTask = utiMenuTaskDao.findOne(utiMenuTaskKey);
        return this.convert(utiMenuTask,UtiMenuTaskDto.class);
    }
}