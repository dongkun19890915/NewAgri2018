package com.sinosoft.agriprpall.web.endorsemanage;


import com.sinosoft.agriprpall.api.endorsemanage.PrpPmainApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPmainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * prppmain表操作类
 * @Author: 李冬松
 * @Date: 9:00 2017/12/15
 */
@RestController
@RequestMapping(value = PrpPmainApi.PATH)
public class PrpPmainController implements PrpPmainApi{
    @Autowired
    private PrpPmainService prpPmainService;
    /**
    * 通过批单号查询prppmain表
    * @param map 批单号
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto
    * @throws
    * @author 李冬松
    * @date 14:28 2017/12/15
    */
    @Override
    public @ResponseBody PrpPmainDto queryPrpCmainDtoByEndorseNo(@RequestBody Map<String, String> map) throws Exception {
        return prpPmainService.queryPrpPmainDtoByEndorseNo(map.get("endorseNo"));
    }
}
