package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.CheckEndoreseNextApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CheckEndorseConditionDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CheckEndorseNextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = CheckEndoreseNextApi.PATH)
public class CheckEndorseNextController implements CheckEndoreseNextApi{
    @Autowired
    private CheckEndorseNextService checkEndorseNextService;
    /**
    * 允许批改校验
    * @param checkEndorseConditionDto 允许批改改条件
    * @return java.lang.String
    * @throws Exception
    * @author 李冬松
    * @date 14:29 2017/12/13
    */
    @Override
    public @ResponseBody Map<String,String> checkNext(@RequestBody CheckEndorseConditionDto checkEndorseConditionDto) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("versionNo",checkEndorseNextService.checkEndorse(checkEndorseConditionDto));
        return map;
    }
}
