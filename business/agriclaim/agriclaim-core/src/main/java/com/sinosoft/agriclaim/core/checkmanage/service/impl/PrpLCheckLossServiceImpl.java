package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckLossDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckLoss;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckLossKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckLossService;
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
 * @time  2017-11-08 05:38:49.324 
 * @description 查勘事故估损金额表Core接口实现
 */
@Service
public class PrpLCheckLossServiceImpl extends BaseServiceImpl implements PrpLCheckLossService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCheckLossServiceImpl.class);
    
    @Autowired
    private PrpLCheckLossDao prpLCheckLossDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCheckLossDto prpLCheckLossDto) {
        PrpLCheckLoss prpLCheckLoss = this.convert(prpLCheckLossDto, PrpLCheckLoss.class);
        prpLCheckLossDao.save(prpLCheckLoss);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Integer serialNo) {
        PrpLCheckLossKey prpLCheckLossKey = new PrpLCheckLossKey(registNo,serialNo);
        prpLCheckLossDao.delete(prpLCheckLossKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCheckLossDto prpLCheckLossDto) {
        PrpLCheckLoss prpLCheckLoss = this.convert(prpLCheckLossDto, PrpLCheckLoss.class);
        prpLCheckLossDao.save(prpLCheckLoss);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckLossDto queryByPK(String registNo,java.lang.Integer serialNo) {
        PrpLCheckLossKey prpLCheckLossKey = new PrpLCheckLossKey(registNo,serialNo);
        PrpLCheckLoss prpLCheckLoss = prpLCheckLossDao.findOne(prpLCheckLossKey);
        return this.convert(prpLCheckLoss,PrpLCheckLossDto.class);
    }
    @Override
    public List<PrpLCheckLossDto> queryByRegistNo(String registNo) {
        Specification<PrpLCheckLoss> specification = Specifications.<PrpLCheckLoss>and().eq("registNo", registNo).build();
        List<PrpLCheckLoss> checkLossList = prpLCheckLossDao.findAll(specification);
        List<PrpLCheckLossDto> checkLossDtoList = new ArrayList<PrpLCheckLossDto>();
        this.convertCollection(checkLossList, checkLossDtoList, PrpLCheckLossDto.class);
        return checkLossDtoList;
    }
}