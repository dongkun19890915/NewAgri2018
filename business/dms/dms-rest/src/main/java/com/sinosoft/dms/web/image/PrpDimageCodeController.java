package com.sinosoft.dms.web.image;

import com.sinosoft.dms.api.image.PrpDimageCodeApi;
import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;
import com.sinosoft.dms.core.image.service.PrpDimageCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpDimageCodeApi.PATH)
public class PrpDimageCodeController implements PrpDimageCodeApi {

    @Autowired
    private PrpDimageCodeService prpDimageCodeService;

    /**
     * 按主键查询
     *
     * @param param riskCode-险种代码，comCode-机构代码
     * @return PrpDimageCodeDto
     */
    @Override
    public @ResponseBody
    PrpDimageCodeDto queryByPK(@RequestBody Map<String, String> param) {
        return prpDimageCodeService.queryByPK(param.get("riskCode"), param.get("comCode"));
    }
}
