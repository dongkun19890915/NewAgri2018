package com.sinosoft.agriprpall.core.policymanage.service;

/**
 * 保单删除服务
 * @Author: 王保良
 * @Date: 2017/12/8 14:55
 */
public interface PolicyCancelService {
    public void cancel(String policyNo, String option) throws Exception;
}
