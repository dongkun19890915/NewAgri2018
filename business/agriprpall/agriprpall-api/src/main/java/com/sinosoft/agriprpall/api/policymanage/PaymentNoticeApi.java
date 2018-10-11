package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentNoticeDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *（缴费通知书打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/8 14:19
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PaymentNoticeApi.PATH)
public interface PaymentNoticeApi {

    public static final String PATH = "prpPolicyFeeNotice";

    /**
     * @description:缴费通知书打印查询
     * @author: 陈道洋
     * @date: 2017/10/23 14:42
     * @param proposalNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryPaymentNoticeByCondition",method = RequestMethod.POST)
  public @ResponseBody
    ResponsePaymentNoticeDto queryPaymentNoticeByCondition (@RequestParam(value="policyNo") String proposalNo)throws Exception;

    /**
     * @description:缴费通知单号回写
     * @author: 陈道洋
     * @date: 2017/10/24 9:21
     * @param policyFeeNo
     * @param policyNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updatepolicyFeeNo",method = RequestMethod.POST)
    public  @ResponseBody void updatepolicyFeeNo(@RequestParam(value = "policyFeeNo") String policyFeeNo, @RequestParam(value = "policyNo")String policyNo)throws  Exception;
}