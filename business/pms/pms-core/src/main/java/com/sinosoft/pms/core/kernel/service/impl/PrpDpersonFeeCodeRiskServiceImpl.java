package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.pms.core.kernel.dao.PrpDpersonFeeCodeRiskDao;
import com.sinosoft.pms.core.kernel.entity.PrpDpersonFeeCodeRisk;
import com.sinosoft.pms.core.kernel.entity.PrpDpersonFeeCodeRiskKey;
import com.sinosoft.pms.core.kernel.service.PrpDpersonFeeCodeRiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description 人伤费用险种对照表Core接口实现
 */
@Service
public class PrpDpersonFeeCodeRiskServiceImpl extends BaseServiceImpl implements PrpDpersonFeeCodeRiskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDpersonFeeCodeRiskServiceImpl.class);
    
    @Autowired
    private PrpDpersonFeeCodeRiskDao prpDpersonFeeCodeRiskDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto) {
        PrpDpersonFeeCodeRisk prpDpersonFeeCodeRisk = this.convert(prpDpersonFeeCodeRiskDto, PrpDpersonFeeCodeRisk.class);
        prpDpersonFeeCodeRiskDao.save(prpDpersonFeeCodeRisk);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode,String feeCode) {
        PrpDpersonFeeCodeRiskKey prpDpersonFeeCodeRiskKey = new PrpDpersonFeeCodeRiskKey(riskCode,feeCode);
        prpDpersonFeeCodeRiskDao.delete(prpDpersonFeeCodeRiskKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto) {
        PrpDpersonFeeCodeRisk prpDpersonFeeCodeRisk = this.convert(prpDpersonFeeCodeRiskDto, PrpDpersonFeeCodeRisk.class);
        prpDpersonFeeCodeRiskDao.save(prpDpersonFeeCodeRisk);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDpersonFeeCodeRiskDto queryByPK(String riskCode,String feeCode) {
        PrpDpersonFeeCodeRiskKey prpDpersonFeeCodeRiskKey = new PrpDpersonFeeCodeRiskKey(riskCode,feeCode);
        PrpDpersonFeeCodeRisk prpDpersonFeeCodeRisk = prpDpersonFeeCodeRiskDao.findOne(prpDpersonFeeCodeRiskKey);
        return this.convert(prpDpersonFeeCodeRisk,PrpDpersonFeeCodeRiskDto.class);
    }
}