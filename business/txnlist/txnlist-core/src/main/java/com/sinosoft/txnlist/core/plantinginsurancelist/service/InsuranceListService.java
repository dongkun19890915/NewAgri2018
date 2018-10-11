package com.sinosoft.txnlist.core.plantinginsurancelist.service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口
 */
public interface InsuranceListService {

    /**
     * @param inusreListCode
     * @description 传inusreListCode查询Planting31InsuranceList集合
     * 将Planting31InsuranceList集合的每一条entity保存到Planting31PolicyList和Planting31PolicyListOrigin
     */
    public void findByPlanting31InsuranceList(String inusreListCode) throws Exception;


    /**
     * @param inusrelistcode
     * @description 传inusreListCode查询 NyxInsuranceList 集合
     * 将NyxInsuranceList集合的每一条entity保存到NyxPolicyList和NyxPolicyListOrigin
     */
    public void saveNyxInsuranceToPolicy(String inusrelistcode) throws Exception;


    /**
     * @param inusreListCode
     * @description 传inusreListCode查询PlantingInsuranceList集合
     * 将PlantingInsuranceList集合的每一条entity保存到PlantingPolicyList和Plantingpolicylistorigin
     */
    public void saveInsuranceToPolicy(String inusreListCode) throws Exception;


    /**
     * @param inusreListCode
     * @author: 潘峰
     * @description 传inusreListCode查询PlantingTCirculationList集合
     * 将PlantingTCirculationList集合的每一条entity保存到PlantingCCirculationList和PlantingCCirculationListOrigin
     */
    public void saveTCirculationToC(String inusreListCode) throws Exception;


    /**
     * @param relationListNo
     * @description 传RelationListNo查询herdinsurancelist集合
     *                       将herdinsurancelist集合的每一条entity保存到herdPolicyList和herdPolicyListOrigin
     * @author: 潘峰
     */
    public void saveHerdinsuranceToPolicy(String relationListNo) throws Exception;
}