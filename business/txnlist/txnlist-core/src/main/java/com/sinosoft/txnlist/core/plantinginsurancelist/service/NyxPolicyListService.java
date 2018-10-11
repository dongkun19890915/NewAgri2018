package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyList;

import java.util.List;
import java.util.Map;

public interface NyxPolicyListService {
    public List<NyxPolicyListDto> findByInusreListCode(String inusreListCode) throws Exception;

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param policyNo 保单号码
     * @return 承保分户清单数据
     * @author: 何伟东
     * @date: 2017/12/28 17:29
     */
    List<NyxPolicyListDto> queryByPolicyNo(String policyNo);
    /**
     * 根据保单号查询NyxPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return NyxPolicyListDto集合
     * @throws Exception
     */
    List<NyxPolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo);
}
