package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLArrearageDto;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLArrearageDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLArrearage;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLArrearageKey;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLArrearageService;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 逾款欠款清单表Core接口实现
 */
@Service
public class PrpLArrearageServiceImpl extends BaseServiceImpl implements PrpLArrearageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLArrearageServiceImpl.class);
    
    @Autowired
    private PrpLArrearageDao prpLArrearageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLArrearageDto prpLArrearageDto) {
        PrpLArrearage prpLArrearage = this.convert(prpLArrearageDto, PrpLArrearage.class);
        prpLArrearageDao.save(prpLArrearage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String policyNo,java.util.Date arrearageEndDate) {
        PrpLArrearageKey prpLArrearageKey = new PrpLArrearageKey(policyNo,arrearageEndDate);
        prpLArrearageDao.delete(prpLArrearageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLArrearageDto prpLArrearageDto) {
        PrpLArrearage prpLArrearage = this.convert(prpLArrearageDto, PrpLArrearage.class);
        prpLArrearageDao.save(prpLArrearage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLArrearageDto queryByPK(String policyNo,java.util.Date arrearageEndDate) {
        PrpLArrearageKey prpLArrearageKey = new PrpLArrearageKey(policyNo,arrearageEndDate);
        PrpLArrearage prpLArrearage = prpLArrearageDao.findOne(prpLArrearageKey);
        return this.convert(prpLArrearage,PrpLArrearageDto.class);
    }
}