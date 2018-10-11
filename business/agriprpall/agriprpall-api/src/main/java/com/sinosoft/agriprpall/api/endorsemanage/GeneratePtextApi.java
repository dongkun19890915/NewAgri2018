package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GeneratePtextApi.PATH)
public interface GeneratePtextApi {

    public static final String PATH="generateptext";

    /**
     * 批文生成
     *
     * @param policyEndorseDto
     * @return BLEndorseDto
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 下午 15:30
     */
    @RequestMapping(value = "generateUsual",method = RequestMethod.POST)
    public @ResponseBody BLEndorseDto generateUsual(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception;
}
