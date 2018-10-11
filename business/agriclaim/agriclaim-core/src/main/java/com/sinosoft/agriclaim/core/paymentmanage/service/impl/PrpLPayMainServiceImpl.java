package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayMainDto;
import com.sinosoft.agriclaim.core.paymentmanage.dao.PrpLPayMainDao;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayMain;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayMainKey;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayMainService;
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
 * @description 支付信息主表Core接口实现
 */
@Service
public class PrpLPayMainServiceImpl extends BaseServiceImpl implements PrpLPayMainService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPayMainServiceImpl.class);
    
    @Autowired
    private PrpLPayMainDao prpLPayMainDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPayMainDto prpLPayMainDto) {
        PrpLPayMain prpLPayMain = this.convert(prpLPayMainDto, PrpLPayMain.class);
        prpLPayMainDao.save(prpLPayMain);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String paymentNo) {
        PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey(paymentNo);
        prpLPayMainDao.delete(prpLPayMainKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPayMainDto prpLPayMainDto) {
        PrpLPayMain prpLPayMain = this.convert(prpLPayMainDto, PrpLPayMain.class);
        prpLPayMainDao.save(prpLPayMain);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayMainDto queryByPK(String paymentNo) {
        PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey(paymentNo);
        PrpLPayMain prpLPayMain = prpLPayMainDao.findOne(prpLPayMainKey);
        return this.convert(prpLPayMain,PrpLPayMainDto.class);
    }
}