package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentNoticeDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *（缴费通知书打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/8 14:19
 */
public interface PaymentNoticeService {
    /**
     * @description:缴费通知书打印查询
     * @author: 陈道洋
     * @date: 2017/10/23 14:57
     * @param policyNo
     * @return
     * @throws Exception
     */
    public ResponsePaymentNoticeDto queryPaymentNoticeByCondition (String policyNo)throws Exception;

    /**
     * @description:缴费通知单号回写
     * @author: 陈道洋
     * @date: 2017/10/24 9:18
     * @param policyFeeNo
     * @param policyNo
     * @return
     * @throws Exception
     */
    public void updatepolicyFeeNo(String policyFeeNo, String policyNo) throws Exception;
}