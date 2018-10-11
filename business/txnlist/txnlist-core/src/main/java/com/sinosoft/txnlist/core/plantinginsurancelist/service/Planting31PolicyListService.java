package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;

import java.util.List;

public interface Planting31PolicyListService {
    public List<Planting31PolicyListDto> findByInusreListCode(String inusreListCode)throws Exception;

    /**
     * 根据保单号查询Planting31PolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return Planting31PolicyListDto集合
     * @throws Exception
     */
    List<Planting31PolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo);
}
