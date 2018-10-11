package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayExtDto;
import com.sinosoft.agriclaim.core.paymentmanage.dao.PrpLPayExtDao;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayExt;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayExtKey;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayExtService;
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
 * @description 支付处理意见表Core接口实现
 */
@Service
public class PrpLPayExtServiceImpl extends BaseServiceImpl implements PrpLPayExtService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPayExtServiceImpl.class);
    
    @Autowired
    private PrpLPayExtDao prpLPayExtDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPayExtDto prpLPayExtDto) {
        PrpLPayExt prpLPayExt = this.convert(prpLPayExtDto, PrpLPayExt.class);
        prpLPayExtDao.save(prpLPayExt);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String paymentNo,Integer serialNo) {
        PrpLPayExtKey prpLPayExtKey = new PrpLPayExtKey(paymentNo,serialNo);
        prpLPayExtDao.delete(prpLPayExtKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPayExtDto prpLPayExtDto) {
        PrpLPayExt prpLPayExt = this.convert(prpLPayExtDto, PrpLPayExt.class);
        prpLPayExtDao.save(prpLPayExt);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayExtDto queryByPK(String paymentNo,Integer serialNo) {
        PrpLPayExtKey prpLPayExtKey = new PrpLPayExtKey(paymentNo,serialNo);
        PrpLPayExt prpLPayExt = prpLPayExtDao.findOne(prpLPayExtKey);
        return this.convert(prpLPayExt,PrpLPayExtDto.class);
    }
}