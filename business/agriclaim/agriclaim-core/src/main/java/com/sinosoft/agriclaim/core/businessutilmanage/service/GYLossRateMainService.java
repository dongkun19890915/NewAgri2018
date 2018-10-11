package com.sinosoft.agriclaim.core.businessutilmanage.service;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;

public interface GYLossRateMainService {

    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param lossRateWholeListDto 定损清单大对象
     * @throws Exception
     */
    void saveLossRateAllList(LossRateWholeListDto lossRateWholeListDto) throws Exception;
}
