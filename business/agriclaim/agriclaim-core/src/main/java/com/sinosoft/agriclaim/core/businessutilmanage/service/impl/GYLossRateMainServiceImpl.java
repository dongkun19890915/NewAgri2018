package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.core.businessutilmanage.service.GYLossRateMainService;
import com.sinosoft.txnlist.api.claiminsurancelist.LossRateMainListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GYLossRateMainServiceImpl implements GYLossRateMainService {

    @Autowired
    private LossRateMainListApi lossRateMainListApi;
    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param lossRateWholeListDto 定损清单大对象
     * @throws Exception
     */
    @Override
    public void saveLossRateAllList(LossRateWholeListDto lossRateWholeListDto) throws Exception{
        lossRateMainListApi.saveLossRateAllList(lossRateWholeListDto);
    }
}
