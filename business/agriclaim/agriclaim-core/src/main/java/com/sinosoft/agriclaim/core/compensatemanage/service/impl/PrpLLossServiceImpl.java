package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLLossDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLLossDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLLoss;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLLossKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLLossService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 赔付标的信息表Core接口实现
 */
@Service
public class PrpLLossServiceImpl extends BaseServiceImpl implements PrpLLossService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLLossServiceImpl.class);
    
    @Autowired
    private PrpLLossDao prpLLossDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLLossDto prpLLossDto) {
        PrpLLoss prpLLoss = this.convert(prpLLossDto, PrpLLoss.class);
        prpLLossDao.save(prpLLoss);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo,java.lang.Integer serialNo) {
        PrpLLossKey prpLLossKey = new PrpLLossKey(compensateNo,serialNo);
        prpLLossDao.delete(prpLLossKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLLossDto prpLLossDto) {
        PrpLLoss prpLLoss = this.convert(prpLLossDto, PrpLLoss.class);
        prpLLossDao.save(prpLLoss);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLLossDto queryByPK(String compensateNo,java.lang.Integer serialNo) {
        PrpLLossKey prpLLossKey = new PrpLLossKey(compensateNo,serialNo);
        PrpLLoss prpLLoss = prpLLossDao.findOne(prpLLossKey);
        return this.convert(prpLLoss,PrpLLossDto.class);
    }

    /**
     *
     * @description 根据业务号查询PrpLLoss表
     * @author 周柯宇
     * @date 2018年1月26日 下午3:49:27
     * @param businessNo
     * @return List<PrpLLossDto>
     * @Throws Exception
     */
    @Override
    public List<PrpLLossDto> queryByBusinessNo(String businessNo) {
        if(StringUtils.isEmpty(businessNo)){
            throw new DataVerifyException("业务号不能为空");
        }
        List<PrpLLoss> prpLLossList = prpLLossDao.findByCompensateNo(businessNo);
        List<PrpLLossDto> prpLLossDtoList = new ArrayList<PrpLLossDto>();
        this.convertCollection(prpLLossList, prpLLossDtoList, PrpLLossDto.class);
        return prpLLossDtoList;
    }
}