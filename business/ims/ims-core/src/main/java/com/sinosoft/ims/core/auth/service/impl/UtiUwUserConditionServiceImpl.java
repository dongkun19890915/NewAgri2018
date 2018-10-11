package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwUserConditionDto;
import com.sinosoft.ims.core.auth.dao.UtiUwUserConditionDao;
import com.sinosoft.ims.core.auth.entity.UtiUwUserCondition;
import com.sinosoft.ims.core.auth.entity.UtiUwUserConditionKey;
import com.sinosoft.ims.core.auth.service.UtiUwUserConditionService;
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
 * @description UtiUwUserConditionCore接口实现
 */
@Service
public class UtiUwUserConditionServiceImpl extends BaseServiceImpl implements UtiUwUserConditionService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUwUserConditionServiceImpl.class);
    
    @Autowired
    private UtiUwUserConditionDao utiUwUserConditionDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUwUserConditionDto utiUwUserConditionDto) {
        UtiUwUserCondition utiUwUserCondition = this.convert(utiUwUserConditionDto, UtiUwUserCondition.class);
        utiUwUserConditionDao.save(utiUwUserCondition);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,Integer modelNo,Integer nodeNo,String riskCode,String uwType,String factorCode,Integer factorValueNo,String userCode) {
        UtiUwUserConditionKey utiUwUserConditionKey = new UtiUwUserConditionKey(comCode,modelNo,nodeNo,riskCode,uwType,factorCode,factorValueNo,userCode);
        utiUwUserConditionDao.delete(utiUwUserConditionKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUwUserConditionDto utiUwUserConditionDto) {
        UtiUwUserCondition utiUwUserCondition = this.convert(utiUwUserConditionDto, UtiUwUserCondition.class);
        utiUwUserConditionDao.save(utiUwUserCondition);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUwUserConditionDto queryByPK(String comCode,Integer modelNo,Integer nodeNo,String riskCode,String uwType,String factorCode,Integer factorValueNo,String userCode) {
        UtiUwUserConditionKey utiUwUserConditionKey = new UtiUwUserConditionKey(comCode,modelNo,nodeNo,riskCode,uwType,factorCode,factorValueNo,userCode);
        UtiUwUserCondition utiUwUserCondition = utiUwUserConditionDao.findOne(utiUwUserConditionKey);
        return this.convert(utiUwUserCondition,UtiUwUserConditionDto.class);
    }
}