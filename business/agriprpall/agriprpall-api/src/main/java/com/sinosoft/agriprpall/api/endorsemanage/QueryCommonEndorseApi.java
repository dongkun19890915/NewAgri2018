package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.QueryCommonEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * @description （普通批单查询接口）
 * @author 王保良
 * @date 2017年11月2日
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = QueryCommonEndorseApi.PATH)
public interface QueryCommonEndorseApi {
    public static final String PATH="endorse";

    /**
     * @description （根据保单号查询出其批改申请人(一般就是投保人)以及批改申请日期(用起保日期startDate和批改生效日期validDate对比返回的结果）
     * @param policyNo
     * @return ResponseDto
     * @author 王保良
     * @date 2017年10月28日
     */
    @RequestMapping(value = "queryCommonEndorse",method = RequestMethod.POST)
    public QueryCommonEndorseDto queryCommonEndorse(@RequestBody Map<String,String> map) throws Exception;
}
