package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayBillDto;
import com.sinosoft.agriclaim.core.paymentmanage.dao.PrpLPayBillDao;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayBill;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayBillKey;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayBillService;
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
 * @time  2017-12-14 09:04:11.816 
 * @description 支付信息对应清单主键表Core接口实现
 */
@Service
public class PrpLPayBillServiceImpl extends BaseServiceImpl implements PrpLPayBillService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPayBillServiceImpl.class);
    
    @Autowired
    private PrpLPayBillDao prpLPayBillDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPayBillDto prpLPayBillDto) {
        PrpLPayBill prpLPayBill = this.convert(prpLPayBillDto, PrpLPayBill.class);
        prpLPayBillDao.save(prpLPayBill);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String paymentNo,String registNo,String compensateNo,Integer serialNo) {
        PrpLPayBillKey prpLPayBillKey = new PrpLPayBillKey(paymentNo,registNo,compensateNo,serialNo);
        prpLPayBillDao.delete(prpLPayBillKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPayBillDto prpLPayBillDto) {
        PrpLPayBill prpLPayBill = this.convert(prpLPayBillDto, PrpLPayBill.class);
        prpLPayBillDao.save(prpLPayBill);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayBillDto queryByPK(String paymentNo,String registNo,String compensateNo,Integer serialNo) {
        PrpLPayBillKey prpLPayBillKey = new PrpLPayBillKey(paymentNo,registNo,compensateNo,serialNo);
        PrpLPayBill prpLPayBill = prpLPayBillDao.findOne(prpLPayBillKey);
        return this.convert(prpLPayBill,PrpLPayBillDto.class);
    }
}