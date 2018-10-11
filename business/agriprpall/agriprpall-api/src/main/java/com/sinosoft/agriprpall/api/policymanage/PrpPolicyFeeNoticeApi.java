package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpPolicyFeeNoticeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 保费缴款通知书信息表Dao数据操作对象
 *
 * @author: 钱浩
 * @date: 2017/12/6 下午 17:07
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpPolicyFeeNoticeApi.PATH)
public interface PrpPolicyFeeNoticeApi {
    public static final String PATH = "prppolicyfeenotice";

    /**
     * 缴费通知书号生成所用
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:22
     */
    @RequestMapping(value = "queryByPolicyNo", method = {RequestMethod.POST})
    public @ResponseBody
    List<PrpPolicyFeeNoticeDto> queryByPolicyNo(@RequestParam("policyNo") String policyNo) throws Exception;
}
