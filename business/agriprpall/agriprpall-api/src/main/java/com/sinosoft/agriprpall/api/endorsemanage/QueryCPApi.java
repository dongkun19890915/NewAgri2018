package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CPpolicyDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description （cp表查询服务）
 * @author 王保良
 * @date 2017年10月28日
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME)
public interface QueryCPApi {
    public static final String PATH="endorse";

    /**
     *  （根据保单号查询该保单号所有cp表的信息）
     * @param policyNo 保单号
     * @return CPpolicyDto
     * @author 王保良
     * @throws  Exception
     * @date 2017年10月28日
     */
    @RequestMapping(value = "queryCPolicyInfo",method = RequestMethod.POST)
    public CPpolicyDto queryCPolicyInfo(@RequestParam(value = "policyNo") String policyNo) throws Exception;
}
