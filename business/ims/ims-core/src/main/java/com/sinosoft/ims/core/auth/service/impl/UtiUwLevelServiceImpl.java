package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwLevelDto;
import com.sinosoft.ims.core.auth.dao.UtiUwLevelDao;
import com.sinosoft.ims.core.auth.entity.UtiUwLevel;
import com.sinosoft.ims.core.auth.entity.UtiUwLevelKey;
import com.sinosoft.ims.core.auth.service.UtiUwLevelService;
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
 * @description UtiUwLevelCore接口实现
 */
@Service
public class UtiUwLevelServiceImpl extends BaseServiceImpl implements UtiUwLevelService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUwLevelServiceImpl.class);
    
    @Autowired
    private UtiUwLevelDao utiUwLevelDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUwLevelDto utiUwLevelDto) {
        UtiUwLevel utiUwLevel = this.convert(utiUwLevelDto, UtiUwLevel.class);
        utiUwLevelDao.save(utiUwLevel);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode,String comCode,String riskCode,Integer modelNo,Integer nodeNo,String uwType) {
        UtiUwLevelKey utiUwLevelKey = new UtiUwLevelKey(userCode,comCode,riskCode,modelNo,nodeNo,uwType);
        utiUwLevelDao.delete(utiUwLevelKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUwLevelDto utiUwLevelDto) {
        UtiUwLevel utiUwLevel = this.convert(utiUwLevelDto, UtiUwLevel.class);
        utiUwLevelDao.save(utiUwLevel);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUwLevelDto queryByPK(String userCode,String comCode,String riskCode,Integer modelNo,Integer nodeNo,String uwType) {
        UtiUwLevelKey utiUwLevelKey = new UtiUwLevelKey(userCode,comCode,riskCode,modelNo,nodeNo,uwType);
        UtiUwLevel utiUwLevel = utiUwLevelDao.findOne(utiUwLevelKey);
        return this.convert(utiUwLevel,UtiUwLevelDto.class);
    }
}