package com.sinosoft.agriprpall.api.endorsemanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = PrpPmainApi.PATH)
public interface PrpPmainApi {
    public static final String PATH="prppmain";
    /**
    * 通过批单号查询prppmain表
    * @param map 批单号
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto
    * @throws
    * @author 李冬松
    * @date 14:25 2017/12/15
    */
    @RequestMapping(value = "queryPrpCmainDtoByEndorseNo",method = RequestMethod.POST)
    public @ResponseBody
    PrpPmainDto queryPrpCmainDtoByEndorseNo(@RequestBody Map<String ,String> map)throws Exception;

}
