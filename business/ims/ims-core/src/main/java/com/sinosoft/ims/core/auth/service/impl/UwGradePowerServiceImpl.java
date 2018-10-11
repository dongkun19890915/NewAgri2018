package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGradePowerDto;
import com.sinosoft.ims.core.auth.dao.UwGradePowerDao;
import com.sinosoft.ims.core.auth.entity.UwGradePower;
import com.sinosoft.ims.core.auth.entity.UwGradePowerKey;
import com.sinosoft.ims.core.auth.service.UwGradePowerService;
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
 * @description UwGradePowerCore接口实现
 */
@Service
public class UwGradePowerServiceImpl extends BaseServiceImpl implements UwGradePowerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UwGradePowerServiceImpl.class);
    
    @Autowired
    private UwGradePowerDao uwGradePowerDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UwGradePowerDto uwGradePowerDto) {
        UwGradePower uwGradePower = this.convert(uwGradePowerDto, UwGradePower.class);
        uwGradePowerDao.save(uwGradePower);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode,String marketType,String policyType,String uwType,Integer verifyLevel,String comCode,String classCode,String riskCode) {
        UwGradePowerKey uwGradePowerKey = new UwGradePowerKey(userCode,marketType,policyType,uwType,verifyLevel,comCode,classCode,riskCode);
        uwGradePowerDao.delete(uwGradePowerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UwGradePowerDto uwGradePowerDto) {
        UwGradePower uwGradePower = this.convert(uwGradePowerDto, UwGradePower.class);
        uwGradePowerDao.save(uwGradePower);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UwGradePowerDto queryByPK(String userCode,String marketType,String policyType,String uwType,Integer verifyLevel,String comCode,String classCode,String riskCode) {
        UwGradePowerKey uwGradePowerKey = new UwGradePowerKey(userCode,marketType,policyType,uwType,verifyLevel,comCode,classCode,riskCode);
        UwGradePower uwGradePower = uwGradePowerDao.findOne(uwGradePowerKey);
        return this.convert(uwGradePower,UwGradePowerDto.class);
    }
}