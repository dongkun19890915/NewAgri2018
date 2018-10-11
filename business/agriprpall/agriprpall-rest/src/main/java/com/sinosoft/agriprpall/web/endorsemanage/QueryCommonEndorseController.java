package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.QueryCommonEndorseApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.QueryCommonEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCommonEndorseService;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @description （cp表查询服务 控制层）
 * @author 王保良
 * @date 2017年11月3日
 */
@RestController
@RequestMapping(value = QueryCommonEndorseApi.PATH)
public class QueryCommonEndorseController implements QueryCommonEndorseApi {

    @Autowired
    QueryCommonEndorseService queryCommonEndorseService;

    /**
     * 根据保单号查询出其批改申请人(一般就是投保人)以及批改申请日期(用起保日期startDate和批改生效日期validDate对比返回的结果）
     * @param policyNo 保单号
     * @return 返回投保人以及批改生效日期和起保日期比较的结果
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    public QueryCommonEndorseDto queryCommonEndorse(@RequestBody Map<String,String> map) throws Exception {
        return queryCommonEndorseService.queryCommonEndorse(map.get("policyNo"),map.get("validDate"));
    }
}
