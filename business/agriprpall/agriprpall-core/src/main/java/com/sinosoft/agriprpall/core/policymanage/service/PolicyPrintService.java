package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.policymanage.dto.ResItemKindDto;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524 
 * @description 保单标的子险信息表Core接口
 */
public interface PolicyPrintService {

    /**
     * @description: 根据保单号查询险别信息
     * @author: 何伟东
     * @date: 2017/10/22 16:20
     * @param policyNo
     * @param type
     * @return
     */
    public ResItemKindDto queryItemKindListByPolicyNo(String policyNo, String type);
}