package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLEarDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLEarDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLEarKey;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLEarService;
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
 * @time  2017-12-01 01:33:42.103 
 * @description 耳标号表Core接口实现
 */
@Service
public class PrpLEarServiceImpl extends BaseServiceImpl implements PrpLEarService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLEarServiceImpl.class);
    
    @Autowired
    private PrpLEarDao prpLEarDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLEarDto prpLEarDto) {
        PrpLEar prpLEar = this.convert(prpLEarDto, PrpLEar.class);
        prpLEarDao.save(prpLEar);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String policyNo,String earNo,String registNo) {
        PrpLEarKey prpLEarKey = new PrpLEarKey(policyNo,earNo,registNo);
        prpLEarDao.delete(prpLEarKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLEarDto prpLEarDto) {
        PrpLEar prpLEar = this.convert(prpLEarDto, PrpLEar.class);
        prpLEarDao.save(prpLEar);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEarDto queryByPK(String policyNo,String earNo,String registNo) {
        PrpLEarKey prpLEarKey = new PrpLEarKey(policyNo,earNo,registNo);
        PrpLEar prpLEar = prpLEarDao.findOne(prpLEarKey);
        return this.convert(prpLEar,PrpLEarDto.class);
    }
}