package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumResponseDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = CalPremiumApi.PATH)
public interface CalPremiumApi {
    public static final String PATH = "calPremium";

    /**
     * 种植险、养殖险公用计算方法（点击币别确认时）
     * @author: 田健
     * @date: 2017/12/20 20:47
     * @param calPremiumDto 计算费用请求入参：包含清单号、金禾清单号、险别、标的、总保额、费率、补贴比例等信息
     * @return CalPremiumResponseDto 计算返回信息
     * @throws Exception
     */
    @RequestMapping(value = "CurrencyEnsure",method = RequestMethod.POST)
    public CalPremiumResponseDto CurrencyEnsure(@RequestBody CalPremiumDto calPremiumDto) throws Exception;

}
