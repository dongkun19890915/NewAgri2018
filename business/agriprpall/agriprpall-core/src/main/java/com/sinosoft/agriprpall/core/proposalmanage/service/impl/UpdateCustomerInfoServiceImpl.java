package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.core.proposalmanage.service.UpdateCustomerInfoService;
import com.sinosoft.framework.agri.core.gycore.BankInfo;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerInfoServiceImpl implements UpdateCustomerInfoService {

    /**
     * 金禾webservice地址
     */
    @Value("${webservice.gycoreService.url}")
    private String gycoreService;

    private static GYcoreUtil gYcoreUtil;

    /**
     * 更新客户信息推送给金禾
     *
     * @author: 何伟东
     * @date: 2018/4/23 11:19
     */
    @Override
    public void sendGis(String customerCode, String customerType, BankInfo bankInfo) {
        if (StringUtils.isEmpty(customerCode)) {
            throw new DataVerifyException("客户代码不能为空！");
        }
        if (StringUtils.isEmpty(customerType)) {
            throw new DataVerifyException("客户类型不能为空！");
        }
        if (bankInfo == null) {
            throw new DataVerifyException("银行信息不能为空！");
        }
        boolean isSucess = getgYcoreUtil().updateCustomerInfo(customerCode, customerType, bankInfo);
        if (!isSucess) {
            throw new BusinessException("更新客户信息回写金禾数据失败！");
        }
    }

    /**
     * 构建与金禾交互的对象
     *
     * @author: 何伟东
     * @date: 2018/4/19 19:13
     */
    private GYcoreUtil getgYcoreUtil() {
        if (gYcoreUtil == null) {
            gYcoreUtil = new GYcoreUtil(gycoreService);
        }
        return gYcoreUtil;
    }
}
