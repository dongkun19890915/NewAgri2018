package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.QueryCommonEndorInfoApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCommonEndorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = QueryCommonEndorInfoApi.PATH)
public class QueryCommonEndorInfoController implements QueryCommonEndorInfoApi {
    @Autowired
    private QueryCommonEndorInfoService queryCommonEndorInfoService;
    /**
    *  普通批改保费计算
    * @param map 保单号
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto 批单保单大对象
    * @throws Exception
    * @author 李冬松
    * @date 16:39 2017/12/22
    */
    @Override
    public @ResponseBody PolicyEndorseDto queryCommonEndorInfo(@RequestBody Map<String, String> map) throws Exception {
        return queryCommonEndorInfoService.queryCommonEndorInfo(map.get("policyNo"),map.get("validDate")) ;
    }
}
