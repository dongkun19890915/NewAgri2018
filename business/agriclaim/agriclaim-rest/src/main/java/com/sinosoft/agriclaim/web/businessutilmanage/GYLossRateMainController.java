package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.GYLossRateMainApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.GYLossRateMainService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国元版本定损清单接口集合
 * @Author 王心洋
 * @date 2018/03/19
 */
@RestController
@RequestMapping(GYLossRateMainController.PATH)
public class GYLossRateMainController implements GYLossRateMainApi {
    @Autowired
    private GYLossRateMainService gyLossRateMainService;
    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto 定损清单大对象
     * @throws Exception
     */
    @Override
    public void saveLossRateAllList(@RequestBody LossRateWholeListDto requestGYLossRateAllListDto) throws Exception{
        gyLossRateMainService.saveLossRateAllList(requestGYLossRateAllListDto);
    }
}
