package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;

import java.util.List;

public interface PrpCvirturlItemService {
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    public List<PrpCvirturlItemDto> queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(String policyNo,String familyNo)throws Exception;

    /**
     * 根据policyNo保单号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 安齐崇
     * @param riskCode 险种编码
     * @param flag
     * @date: 2018/1/24 15:01
     * @param map policyNo保单号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    public List<PrpCvirturlItemDto> queryVirturlItemByPolicyNo(String policyNo, String riskCode, String flag);
}
