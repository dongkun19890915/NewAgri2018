package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCdangerCoinsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * *PrpCcoins 共保信息表Api接口
 *
 * @Author: qh
 * @Date: 2017/11/20 15:10
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCdangCoinsApi.PATH)
public interface PrpCdangCoinsApi {
    public static final String PATH = "prpCdangCoins";

    /**
     * （queryCdangerCoinsDtos 服务）
     *
     * @return
     * @throws Exception
     * @author: qh
     * @date: 2018/4/12 18:08
     */
    @RequestMapping(value = "queryCdangerCoinsDtos", method = {RequestMethod.POST})
    List<PrpCdangerCoinsDto> queryCdangerCoinsDtos(@RequestParam("policyNo") String policyNo) throws Exception;
}
