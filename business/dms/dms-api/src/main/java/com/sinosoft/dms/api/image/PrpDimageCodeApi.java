package com.sinosoft.dms.api.image;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDimageCodeApi.PATH)
public interface PrpDimageCodeApi {

    String PATH = "PrpDimageCode";

    /**
     * 按主键查询
     *
     * @param param riskCode-险种代码，comCode-机构代码
     * @return PrpDimageCodeDto
     */
    @RequestMapping(value = "queryByPK", method = RequestMethod.POST)
    @ResponseBody
    PrpDimageCodeDto queryByPK(@RequestBody Map<String, String> param);
}
