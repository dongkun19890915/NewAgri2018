package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepayKey;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPrepayService;
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
 * @description 预支付理赔表Core接口实现
 */
@Service
public class PrpLPrepayServiceImpl extends BaseServiceImpl implements PrpLPrepayService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPrepayServiceImpl.class);
    
    @Autowired
    private PrpLPrepayDao prpLPrepayDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPrepayDto prpLPrepayDto) {
        PrpLPrepay prpLPrepay = this.convert(prpLPrepayDto, PrpLPrepay.class);
        prpLPrepayDao.save(prpLPrepay);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String preCompensateNo) {
        PrpLPrepayKey prpLPrepayKey = new PrpLPrepayKey(preCompensateNo);
        prpLPrepayDao.delete(prpLPrepayKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPrepayDto prpLPrepayDto) {
        PrpLPrepay prpLPrepay = this.convert(prpLPrepayDto, PrpLPrepay.class);
        prpLPrepayDao.save(prpLPrepay);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPrepayDto queryByPK(String preCompensateNo) {
        PrpLPrepayKey prpLPrepayKey = new PrpLPrepayKey(preCompensateNo);
        PrpLPrepay prpLPrepay = prpLPrepayDao.findOne(prpLPrepayKey);
        return this.convert(prpLPrepay,PrpLPrepayDto.class);
    }
}