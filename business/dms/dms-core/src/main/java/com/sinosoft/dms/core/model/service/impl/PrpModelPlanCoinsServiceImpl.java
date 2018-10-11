package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelPlanCoinsDto;
import com.sinosoft.dms.core.model.dao.PrpModelPlanCoinsDao;
import com.sinosoft.dms.core.model.entity.PrpModelPlanCoins;
import com.sinosoft.dms.core.model.entity.PrpModelPlanCoinsKey;
import com.sinosoft.dms.core.model.service.PrpModelPlanCoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrpModelPlanCoinsServiceImpl extends BaseServiceImpl implements PrpModelPlanCoinsService {
    @Autowired
    private PrpModelPlanCoinsDao prpModelPlanCoinsDao;

    @Override
    public void save(PrpModelPlanCoinsDto prpModelPlanCoinsDto) {
        PrpModelPlanCoins prpModelPlanCoins=convert(prpModelPlanCoinsDto,PrpModelPlanCoins.class);
        prpModelPlanCoinsDao.save(prpModelPlanCoins);
    }

    @Override
    public void remove(String modelCode, Integer serialNo, String coinsCode, String payReason) {
        PrpModelPlanCoinsKey prpModelPlanCoinsKey=new PrpModelPlanCoinsKey(modelCode,coinsCode,serialNo,payReason);
        prpModelPlanCoinsDao.delete(prpModelPlanCoinsKey);
    }

    @Override
    public void modify(PrpModelPlanCoinsDto prpModelPlanCoinsDto) {
        PrpModelPlanCoins prpModelPlanCoins=convert(prpModelPlanCoinsDto,PrpModelPlanCoins.class);
        prpModelPlanCoinsDao.save(prpModelPlanCoins);
    }

    @Override
    public PrpModelPlanCoinsDto queryByPK(String modelCode, Integer serialNo, String coinsCode, String payReason) {
        PrpModelPlanCoinsKey prpModelPlanCoinsKey=new PrpModelPlanCoinsKey(modelCode,coinsCode,serialNo,payReason);
        PrpModelPlanCoins prpModelPlanCoins= prpModelPlanCoinsDao.findOne(prpModelPlanCoinsKey);
        return convert(prpModelPlanCoins,PrpModelPlanCoinsDto.class);
    }
}
