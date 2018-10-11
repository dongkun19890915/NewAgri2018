package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GeneratePMainForYGZApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePMainForYGZService;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneratePMainForYGZController implements GeneratePMainForYGZApi {
    @Autowired
    GeneratePMainForYGZService generatePMainForYGZService;
    /**
     *  批单价税分离
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param blPolicyDtoNew 页面传入保单数据
     * @param blEndorseDto 页面传入批单数据
     */
    public void dealPMainForYGZ(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        generatePMainForYGZService.dealPMainForYGZ(blPolicyDtoNew,blEndorseDto);
    }
}
