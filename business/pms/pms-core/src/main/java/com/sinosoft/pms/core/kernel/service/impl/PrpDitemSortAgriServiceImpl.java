package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDitemSortAgriDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemSortAgriDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitemSortAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDitemSortAgriKey;
import com.sinosoft.pms.core.kernel.service.PrpDitemSortAgriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrpDitemSortAgriServiceImpl extends BaseServiceImpl implements PrpDitemSortAgriService{
    @Autowired
    private PrpDitemSortAgriDao prpDitemSortAgriDao;

    @Override
    public void save(PrpDitemSortAgriDto prpDitemSortAgriDto) {
        PrpDitemSortAgri prpDitemSortAgri=convert(prpDitemSortAgriDto,PrpDitemSortAgri.class);
        prpDitemSortAgriDao.save(prpDitemSortAgri);
    }

    @Override
    public void remove(String itemCode) {
        PrpDitemSortAgriKey prpDitemSortAgriKey=new PrpDitemSortAgriKey(itemCode);
        prpDitemSortAgriDao.delete(prpDitemSortAgriKey);
    }

    @Override
    public void modify(PrpDitemSortAgriDto prpDitemSortAgriDto) {
        PrpDitemSortAgri prpDitemSortAgri = this.convert(prpDitemSortAgriDto, PrpDitemSortAgri.class);
        prpDitemSortAgriDao.save(prpDitemSortAgri);
    }

    @Override
    public PrpDitemSortAgriDto queryByPK(String itemCode) {
        PrpDitemSortAgriKey prpDitemSortAgriKey = new PrpDitemSortAgriKey(itemCode);
        PrpDitemSortAgri prpDitemSortAgri = prpDitemSortAgriDao.findOne(prpDitemSortAgriKey);
        return this.convert(prpDitemSortAgri,PrpDitemSortAgriDto.class);
    }
}
