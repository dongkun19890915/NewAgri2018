package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto;
import com.sinosoft.dms.core.customer.dao.PrpDcustomLevelTraceDao;
import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTrace;
import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTraceKey;
import com.sinosoft.dms.core.customer.service.PrpDcustomLevelTraceService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * @description 客户风险等级轨迹表Core接口实现
 */
@Service
public class PrpDcustomLevelTraceServiceImpl extends BaseServiceImpl implements PrpDcustomLevelTraceService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomLevelTraceServiceImpl.class);
    
    @Autowired
    private PrpDcustomLevelTraceDao prpDcustomLevelTraceDao;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        PrpDcustomLevelTrace prpDcustomLevelTrace = this.convert(prpDcustomLevelTraceDto, PrpDcustomLevelTrace.class);
        prpDcustomLevelTraceDao.save(prpDcustomLevelTrace);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String customerCode,java.lang.Integer lineNo) {
        PrpDcustomLevelTraceKey prpDcustomLevelTraceKey = new PrpDcustomLevelTraceKey(customerCode,lineNo);
        prpDcustomLevelTraceDao.delete(prpDcustomLevelTraceKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        PrpDcustomLevelTrace prpDcustomLevelTrace = this.convert(prpDcustomLevelTraceDto, PrpDcustomLevelTrace.class);
        prpDcustomLevelTraceDao.save(prpDcustomLevelTrace);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDcustomLevelTraceDto queryByPK(String customerCode,java.lang.Integer lineNo) {
        PrpDcustomLevelTraceKey prpDcustomLevelTraceKey = new PrpDcustomLevelTraceKey(customerCode,lineNo);
        PrpDcustomLevelTrace prpDcustomLevelTrace = prpDcustomLevelTraceDao.findOne(prpDcustomLevelTraceKey);
        return this.convert(prpDcustomLevelTrace,PrpDcustomLevelTraceDto.class);
    }

    /**
     * @description 按照customerCode查询最后一条客户风险等级
     * @autor 王心洋
     * @param customerCode
     */
    @Override
    public String findRiskLevelByCode(String customerCode) {
        String newRiskLevel = "";
        PrpDcustomLevelTrace prpDcustomLevelTrace = prpDcustomLevelTraceDao.findRiskLevelByCode(customerCode);
        if(prpDcustomLevelTrace!=null){
            newRiskLevel =  prpDcustomLevelTrace.getNewRiskLevel();
        }
        return newRiskLevel;
    }

    /**
     *  根据客户代码查询最新的客户风险等级信息
     * @author: 田健
     * @date: 2018/4/4 16:57
     * @param customerCode 客户代码
     * @return 客户风险等级信息
     */
    @Override
    public PrpDcustomLevelTraceDto findRiskLevelByCustomerCode(String customerCode) {
        PrpDcustomLevelTrace prpDcustomLevelTrace = prpDcustomLevelTraceDao.findRiskLevelByCode(customerCode);
        return this.convert(prpDcustomLevelTrace,PrpDcustomLevelTraceDto.class);
    }
}