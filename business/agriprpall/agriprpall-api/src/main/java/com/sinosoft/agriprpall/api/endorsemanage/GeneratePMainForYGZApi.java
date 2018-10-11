package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLPolicyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = GeneratePMainForYGZApi.PATH)
public interface GeneratePMainForYGZApi {
    public static final String PATH="generatePMainForYGZ";
    /**
     *  批单价税分离
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param blPolicyDtoNew 页面传入保单数据
     * @param blEndorseDto 页面传入批单数据
     */
    @RequestMapping(value = "dealPMainForYGZ",method = RequestMethod.POST)
    public void dealPMainForYGZ(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception;

}
