package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelPlanSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelPlanSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelPlanSub;
import com.sinosoft.dms.core.model.entity.PrpModelPlanSubKey;
import com.sinosoft.dms.core.model.service.PrpModelPlanSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpModelPlanSubServiceImpl extends BaseServiceImpl implements PrpModelPlanSubService {

    @Autowired
    private PrpModelPlanSubDao prpModelPlanSubDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpModelPlanSubDto prpModelPlanSubDto) {
        PrpModelPlanSub prpModelPlanSub=convert(prpModelPlanSubDto,PrpModelPlanSub.class);
        prpModelPlanSubDao.save(prpModelPlanSub);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String modelCode, Integer serialNo) {
        PrpModelPlanSubKey prpModelPlanSubKey=new PrpModelPlanSubKey(modelCode,serialNo);
        prpModelPlanSubDao.delete(prpModelPlanSubKey);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpModelPlanSubDto prpModelPlanSubDto) {
        PrpModelPlanSub prpModelPlanSub=convert(prpModelPlanSubDto,PrpModelPlanSub.class);
        prpModelPlanSubDao.save(prpModelPlanSub);
    }

    @Override
    public PrpModelPlanSubDto queryByPK(String modelCode, Integer serialNo) {
        PrpModelPlanSubKey prpModelPlanSubKey=new PrpModelPlanSubKey(modelCode,serialNo);
        PrpModelPlanSub prpModelPlanSub=prpModelPlanSubDao.findOne(prpModelPlanSubKey);
        return convert(prpModelPlanSub,PrpModelPlanSubDto.class);
    }
}
