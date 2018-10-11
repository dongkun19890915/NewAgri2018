package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelCoinsDetailDto;
import com.sinosoft.dms.core.model.dao.PrpModelCoinsDetailDao;
import com.sinosoft.dms.core.model.entity.PrpModelCoinsDetail;
import com.sinosoft.dms.core.model.entity.PrpModelCoinsDetailKey;
import com.sinosoft.dms.core.model.service.PrpModelCoinsDetailService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpModelCoinsDetailServiceImpl extends BaseServiceImpl implements PrpModelCoinsDetailService {

    @Autowired
    private PrpModelCoinsDetailDao prpModelCoinsDetailDao;

    @Override
    public PrpModelCoinsDetailDto queryByPk(String modelCode, Integer serialNo, String currency) throws Exception {
        PrpModelCoinsDetailKey prpModelCoinsDetailKey=new PrpModelCoinsDetailKey(modelCode,serialNo,currency);
        PrpModelCoinsDetail prpModelCoinsDetail=prpModelCoinsDetailDao.findOne(prpModelCoinsDetailKey);
        PrpModelCoinsDetailDto prpModelCoinsDetailDto=convert(prpModelCoinsDetail,PrpModelCoinsDetailDto.class);
        return prpModelCoinsDetailDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpModelCoinsDetailDto prpModelCoinsDetailDto) throws Exception {
        PrpModelCoinsDetail prpModelCoinsDetail=convert(prpModelCoinsDetailDto,PrpModelCoinsDetail.class);
        prpModelCoinsDetailDao.save(prpModelCoinsDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PrpModelCoinsDetailDto prpModelCoinsDetailDto) throws Exception {
        PrpModelCoinsDetail prpModelCoinsDetail=convert(prpModelCoinsDetailDto,PrpModelCoinsDetail.class);
        prpModelCoinsDetailDao.save(prpModelCoinsDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String modelCode, Integer serialNo, String currency) throws Exception {
        PrpModelCoinsDetailKey prpModelCoinsDetailKey=new PrpModelCoinsDetailKey(modelCode,serialNo,currency);
        prpModelCoinsDetailDao.delete(prpModelCoinsDetailKey);
    }
}
