package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.framework.agri.core.gycore.BankInfo;

/**
 * 更新客户信息
 *
 * @Author: 何伟东
 * @Date: 2018/4/23 11:14
 */
public interface UpdateCustomerInfoService {


    /**
     * 更新客户信息推送给金禾
     *
     * @author: 何伟东
     * @date: 2018/4/23 11:19
     */
    void sendGis(String customerCode, String customerType, BankInfo bankInfo);
}