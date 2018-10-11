package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PaymentNoticeApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentNoticeDto;
import com.sinosoft.agriprpall.core.policymanage.service.PaymentNoticeService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *（缴费通知书打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/8 14:19
 */
@RestController
@RequestMapping(value = PaymentNoticeController.PATH)
public class PaymentNoticeController implements PaymentNoticeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PaymentNoticeController.class);
    @Autowired
    private PaymentNoticeService paymentNoticeService;


    /**
     * @description:缴费通知书打印查询
     * @author: 陈道洋
     * @date: 2017/10/23 14:59
     * @param policyNo
     * @return
     * @throws Exception
     */
    @Override
    public @ResponseBody
    ResponsePaymentNoticeDto queryPaymentNoticeByCondition(@RequestParam(value="policyNo")String policyNo) throws Exception {
        return paymentNoticeService.queryPaymentNoticeByCondition(policyNo);
    }

    /**
     * @description:缴费通知单号回写
     * @author: 陈道洋
     * @date: 2017/10/24 9:19
     * @param policyFeeNo
     * @param policyNo
     * @return
     * @throws Exception
     */
    @Override
    public void updatepolicyFeeNo(@RequestParam(value = "policyFeeNo") String policyFeeNo, @RequestParam(value = "policyNo")String policyNo) throws Exception {
        paymentNoticeService.updatepolicyFeeNo(policyFeeNo,policyNo);
    }
}
