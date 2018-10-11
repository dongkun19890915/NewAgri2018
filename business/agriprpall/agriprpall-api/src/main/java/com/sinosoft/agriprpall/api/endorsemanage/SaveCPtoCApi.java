package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description （用cp表更新c表服务）
 * @author 王保良
 * @date 2017年10月28日
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = SaveCPtoCApi.PATH)
public interface SaveCPtoCApi {
    public static final String PATH="endorse";

    /**
     * @description （核批通过后用该保单号的cp表数据更细c表数据）
     * @param policyNo
     * @return
     * @author 王保良
     * @date 2017年10月28日
     */
    @RequestMapping(value = "saveCPtoP")
    public boolean saveCPtoC(@RequestParam(value = "policyNo") String policyNo) throws Exception;
}
