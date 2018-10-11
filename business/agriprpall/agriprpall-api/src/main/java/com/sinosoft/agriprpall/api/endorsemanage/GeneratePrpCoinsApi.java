package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GenerateTxnListApi.PATH)
public interface GeneratePrpCoinsApi {
    public static final String PATH="generatePrpCoins";
    /**
    * 处理prpcoins
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 15:00 2017/12/13
    */
    @RequestMapping(value = "dealPrpCoins",method = {RequestMethod.POST})
    public void dealPrpCoins(@RequestBody PolicyEndorseDto policyEndorseDto
                             )throws Exception;
}
