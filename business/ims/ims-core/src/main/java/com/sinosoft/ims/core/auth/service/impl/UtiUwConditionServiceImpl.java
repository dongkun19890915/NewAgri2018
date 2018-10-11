package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwConditionDto;
import com.sinosoft.ims.core.auth.dao.UtiUwConditionDao;
import com.sinosoft.ims.core.auth.entity.UtiUwCondition;
import com.sinosoft.ims.core.auth.entity.UtiUwConditionKey;
import com.sinosoft.ims.core.auth.service.UtiUwConditionService;
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
 * @description UtiUwConditionCore接口实现
 */
@Service
public class UtiUwConditionServiceImpl extends BaseServiceImpl implements UtiUwConditionService{
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUwConditionServiceImpl.class);
    
    @Autowired
    private UtiUwConditionDao utiUwConditionDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUwConditionDto utiUwConditionDto) {
        UtiUwCondition utiUwCondition = this.convert(utiUwConditionDto, UtiUwCondition.class);
        utiUwConditionDao.save(utiUwCondition);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,Integer modelNo,Integer nodeNo,String riskCode,String classCode,String uwType,String factorCode) {
        UtiUwConditionKey utiUwConditionKey = new UtiUwConditionKey(comCode,modelNo,nodeNo,riskCode,classCode,uwType,factorCode);
        utiUwConditionDao.delete(utiUwConditionKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUwConditionDto utiUwConditionDto) {
        UtiUwCondition utiUwCondition = this.convert(utiUwConditionDto, UtiUwCondition.class);
        utiUwConditionDao.save(utiUwCondition);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUwConditionDto queryByPK(String comCode,Integer modelNo,Integer nodeNo,String riskCode,String classCode,String uwType,String factorCode) {
        UtiUwConditionKey utiUwConditionKey = new UtiUwConditionKey(comCode,modelNo,nodeNo,riskCode,classCode,uwType,factorCode);
        UtiUwCondition utiUwCondition = utiUwConditionDao.findOne(utiUwConditionKey);
        return this.convert(utiUwCondition,UtiUwConditionDto.class);
    }
}