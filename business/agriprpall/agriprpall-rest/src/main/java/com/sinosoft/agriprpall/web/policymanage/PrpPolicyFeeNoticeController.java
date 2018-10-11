package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpPolicyFeeNoticeApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpPolicyFeeNoticeDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpPolicyFeeNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 保费缴款通知书信息表Dao数据操作对象
 *
 * @author: 钱浩
 * @date: 2017/12/6 下午 17:07
 */
@RestController
@RequestMapping(value = PrpPolicyFeeNoticeController.PATH)
public class PrpPolicyFeeNoticeController implements PrpPolicyFeeNoticeApi {

    @Autowired
    private PrpPolicyFeeNoticeService prpPolicyFeeNoticeService;

    /**
     * 缴费通知书号生成所用
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:22
     */
    public @ResponseBody
    List<PrpPolicyFeeNoticeDto> queryByPolicyNo(@RequestParam("policyNo") String policyNo) throws Exception {

        return prpPolicyFeeNoticeService.queryByPolicyNo(policyNo);
    }
}
