package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelFeeSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelFeeSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelFeeSub;
import com.sinosoft.dms.core.model.entity.PrpModelFeeSubKey;
import com.sinosoft.dms.core.model.service.PrpModelFeeSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpModelFeeSubServiceImpl extends BaseServiceImpl implements PrpModelFeeSubService {
    @Autowired
    private PrpModelFeeSubDao prpModelFeeSubDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpModelFeeSubDto prpModelFeeSubDto) {
        PrpModelFeeSub prpModelFeeSub = convert(prpModelFeeSubDto,PrpModelFeeSub.class);
        prpModelFeeSubDao.save(prpModelFeeSub);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String modelCode, String currency) {
        PrpModelFeeSubKey prpModelFeeSubKey=new PrpModelFeeSubKey(modelCode,currency);
        prpModelFeeSubDao.delete(prpModelFeeSubKey);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpModelFeeSubDto prpModelFeeSubDto) {
        PrpModelFeeSub prpModelFeeSub = convert(prpModelFeeSubDto,PrpModelFeeSub.class);
        prpModelFeeSubDao.save(prpModelFeeSub);
    }

    @Override
    public PrpModelFeeSubDto queryByPK(String modelCode, String currency) {
        PrpModelFeeSubKey prpModelFeeSubKey=new PrpModelFeeSubKey(modelCode,currency);
        PrpModelFeeSub prpModelFeeSub=prpModelFeeSubDao.findOne(prpModelFeeSubKey);
        return convert(prpModelFeeSub,PrpModelFeeSubDto.class);
    }
}
