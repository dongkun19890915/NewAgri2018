package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * (查询是否有效的批单）
 * @author 王保良
 * @date 2017年11月10日
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path =CheckStatusApi.PATH)
public interface CheckStatusApi {
    public static final String PATH="endorse";

    /**
     * 根据保单号查询是否有有效批单
     * @param policyNo 保单号
     * @return status 标示了查询结果(0代表没有,1代表有),有或者无有效的批单 并封装进responseDto中
     * @author 王保良
     * @date 2017年10月28日
     */
    @RequestMapping(value = "checkStatus",method = RequestMethod.POST)
    public Integer checkStatus(@RequestParam("policyNo") String policyNo) throws Exception;

}
