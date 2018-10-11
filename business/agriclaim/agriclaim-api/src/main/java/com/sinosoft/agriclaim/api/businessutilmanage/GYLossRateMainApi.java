package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 国元版本定损清单接口集合
 * @Author 王心洋
 * @date 2018/03/19
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = LossListApi.PATH)
public interface GYLossRateMainApi {
    public static final String PATH = "gyLossRateMain";

    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto 定损清单大对象
     * @throws Exception
     */
    @RequestMapping(value = "saveLossRateAllList",method = {RequestMethod.POST})
    void saveLossRateAllList(@RequestBody LossRateWholeListDto requestGYLossRateAllListDto) throws Exception;
}
