package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossService;
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
 * @time  2017-11-17 08:28:31.346 
 * @description 定核损主表Core接口实现
 */
@Service
public class PrpLverifyLossServiceImpl extends BaseServiceImpl implements PrpLverifyLossService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossServiceImpl.class);
    
    @Autowired
    private PrpLverifyLossDao prpLverifyLossDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLverifyLossDto prpLverifyLossDto) {
        PrpLverifyLoss prpLverifyLoss = this.convert(prpLverifyLossDto, PrpLverifyLoss.class);
        prpLverifyLossDao.save(prpLverifyLoss);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String lossItemCode) {
        PrpLverifyLossKey prpLverifyLossKey = new PrpLverifyLossKey(registNo,lossItemCode);
        prpLverifyLossDao.delete(prpLverifyLossKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLverifyLossDto prpLverifyLossDto) {
        PrpLverifyLoss prpLverifyLoss = this.convert(prpLverifyLossDto, PrpLverifyLoss.class);
        prpLverifyLossDao.save(prpLverifyLoss);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossDto queryByPK(String registNo,String lossItemCode) {
        PrpLverifyLossKey prpLverifyLossKey = new PrpLverifyLossKey(registNo,lossItemCode);
        PrpLverifyLoss prpLverifyLoss = prpLverifyLossDao.findOne(prpLverifyLossKey);
        return this.convert(prpLverifyLoss,PrpLverifyLossDto.class);
    }
}