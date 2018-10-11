package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLChargeDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCharge;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLChargeKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLChargeService;
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
 * @description 赔款费用信息表Core接口实现
 */
@Service
public class PrpLChargeServiceImpl extends BaseServiceImpl implements PrpLChargeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLChargeServiceImpl.class);
    
    @Autowired
    private PrpLChargeDao prpLChargeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLChargeDto prpLChargeDto) {
        PrpLCharge prpLCharge = this.convert(prpLChargeDto, PrpLCharge.class);
        prpLChargeDao.save(prpLCharge);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo,java.lang.Integer serialNo) {
        PrpLChargeKey prpLChargeKey = new PrpLChargeKey(compensateNo,serialNo);
        prpLChargeDao.delete(prpLChargeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLChargeDto prpLChargeDto) {
        PrpLCharge prpLCharge = this.convert(prpLChargeDto, PrpLCharge.class);
        prpLChargeDao.save(prpLCharge);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLChargeDto queryByPK(String compensateNo,java.lang.Integer serialNo) {
        PrpLChargeKey prpLChargeKey = new PrpLChargeKey(compensateNo,serialNo);
        PrpLCharge prpLCharge = prpLChargeDao.findOne(prpLChargeKey);
        return this.convert(prpLCharge,PrpLChargeDto.class);
    }

    /**
     *
     * @description 根据业务号查询PrpLCharge
     * @author 周柯宇
     * @date 2018年1月26日 下午3:53:37
     * @param 业务号
     * @return List<PrpLChargeDto>
     * @Throws Exception
     */
    @Override
    public List<PrpLChargeDto> queryByBusinessNo(String businessNo) {
        if(StringUtils.isEmpty(businessNo)){
            throw new DataVerifyException("业务号不能为空");
        }
        List<PrpLCharge> prpLChargeList = prpLChargeDao.findByCompensateNo(businessNo);
        List<PrpLChargeDto> prpLChargeDtoList = new ArrayList<PrpLChargeDto>();
        this.convertCollection(prpLChargeList, prpLChargeDtoList, PrpLChargeDto.class);
        return prpLChargeDtoList;
    }

    /**
     * （理算保存赔付信息删除历史数据）
     * @author: 王志文
     * @date: 2018/4/27 15:08
     * @param compensateNo
     * @throws Exception
     */
    @Override
    public void deletePrpLchargeForCompeSave(String compensateNo) throws Exception {
        prpLChargeDao.deleteAllByCompensateNo(compensateNo);
    }
}