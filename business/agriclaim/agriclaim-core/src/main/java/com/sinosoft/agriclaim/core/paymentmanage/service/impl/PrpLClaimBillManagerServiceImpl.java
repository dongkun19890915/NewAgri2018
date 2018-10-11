package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLClaimBillManagerDto;
import com.sinosoft.agriclaim.core.paymentmanage.dao.PrpLClaimBillManagerDao;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLClaimBillManager;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLClaimBillManagerKey;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLClaimBillManagerService;
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
 * @time  2018-01-11 08:55:21.509 
 * @description 理赔清单数据管理表Core接口实现
 */
@Service
public class PrpLClaimBillManagerServiceImpl extends BaseServiceImpl implements PrpLClaimBillManagerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimBillManagerServiceImpl.class);
    
    @Autowired
    private PrpLClaimBillManagerDao prpLClaimBillManagerDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimBillManagerDto prpLClaimBillManagerDto) {
        PrpLClaimBillManager prpLClaimBillManager = this.convert(prpLClaimBillManagerDto, PrpLClaimBillManager.class);
        prpLClaimBillManagerDao.save(prpLClaimBillManager);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String compensateNo,Integer serialNo) {
        PrpLClaimBillManagerKey prpLClaimBillManagerKey = new PrpLClaimBillManagerKey(registNo,compensateNo,serialNo);
        prpLClaimBillManagerDao.delete(prpLClaimBillManagerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimBillManagerDto prpLClaimBillManagerDto) {
        PrpLClaimBillManager prpLClaimBillManager = this.convert(prpLClaimBillManagerDto, PrpLClaimBillManager.class);
        prpLClaimBillManagerDao.save(prpLClaimBillManager);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimBillManagerDto queryByPK(String registNo,String compensateNo,Integer serialNo) {
        PrpLClaimBillManagerKey prpLClaimBillManagerKey = new PrpLClaimBillManagerKey(registNo,compensateNo,serialNo);
        PrpLClaimBillManager prpLClaimBillManager = prpLClaimBillManagerDao.findOne(prpLClaimBillManagerKey);
        return this.convert(prpLClaimBillManager,PrpLClaimBillManagerDto.class);
    }
}