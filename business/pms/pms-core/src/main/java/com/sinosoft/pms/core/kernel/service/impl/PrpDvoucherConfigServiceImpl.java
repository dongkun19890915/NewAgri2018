package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDvoucherConfigDto;
import com.sinosoft.pms.core.kernel.dao.PrpDvoucherConfigDao;
import com.sinosoft.pms.core.kernel.entity.PrpDvoucherConfig;
import com.sinosoft.pms.core.kernel.entity.PrpDvoucherConfigKey;
import com.sinosoft.pms.core.kernel.service.PrpDvoucherConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpDvoucherConfigServiceImpl extends BaseServiceImpl implements PrpDvoucherConfigService{

    @Autowired
    private PrpDvoucherConfigDao prpDvoucherConfigDao;

    @Override
    public PrpDvoucherConfigDto queryByPk(String comCode, String riskCode) throws Exception {
        PrpDvoucherConfigKey prpDvoucherConfigKey=new PrpDvoucherConfigKey(comCode,riskCode);
        PrpDvoucherConfig prpDvoucherConfig=prpDvoucherConfigDao.findOne(prpDvoucherConfigKey);
        PrpDvoucherConfigDto prpDvoucherConfigDto=convert(prpDvoucherConfig,PrpDvoucherConfigDto.class);
        return prpDvoucherConfigDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDvoucherConfigDto prpDvoucherConfigDto) throws Exception {
        PrpDvoucherConfig prpDvoucherConfig=convert(prpDvoucherConfigDto,PrpDvoucherConfig.class);
        prpDvoucherConfigDao.save(prpDvoucherConfig);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PrpDvoucherConfigDto prpDvoucherConfigDto) throws Exception {
        PrpDvoucherConfig prpDvoucherConfig=convert(prpDvoucherConfigDto,PrpDvoucherConfig.class);
        prpDvoucherConfigDao.save(prpDvoucherConfig);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String comCode, String riskCode) throws Exception {
        PrpDvoucherConfigKey prpDvoucherConfigKey=new PrpDvoucherConfigKey(comCode,riskCode);
        prpDvoucherConfigDao.delete(prpDvoucherConfigKey);
    }
}
