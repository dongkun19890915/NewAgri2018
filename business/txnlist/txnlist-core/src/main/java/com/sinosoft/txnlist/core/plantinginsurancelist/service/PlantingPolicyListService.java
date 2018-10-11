package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;

import java.util.List;

public interface PlantingPolicyListService {
    /**
     *  按照inusreListCode查询集合
     * @author 王心洋
     * @time 2017-11-08
     * @param inusreListCode 保单号
     * @return List集合
     */
    public List<PlantingPolicyListDto> queryByInusreListCode(String inusreListCode) throws Exception;
    /**
     *  按照inusreListCode查询PlantingPolicyList_OLDDto集合
     * @author 王心洋
     * @time 2017-11-09
     * @param inusreListCode 保单号
     * @return List集合
     */
    public List<PlantingPolicyListDto> queryOLDByInusreListCode(String inusreListCode) throws Exception;
    /**
     *  按照 inusreListCode 查询 PlantingPolicyList_OLDDto 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param inusreListCode 清单号
     * @return List集合
     */
    public List<NyxPolicyListDto> queryNyxByInsureListCode(String inusreListCode) throws Exception;

    /**
     *  按照 inusreListCode 查询 Planting31PolicyListDto 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param inusreListCode 清单号
     * @return List集合
     */
    public List<Planting31PolicyListDto> queryPlanting31ByInsuereListCode(String inusreListCode) throws Exception;

    /**
     *  按照 inusreListCode 查询 HerdPolicyListDto 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param inusreListCode 清单号
     * @return List集合
     */
    public List<HerdPolicyListDto> queryHerdByInsureListCode(String inusreListCode) throws Exception;

    /**
     *  按照查询条件查询 HerdPolicyListDto 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param endorseConditionDto 清单号
     * @return List集合
     */
    public List<HerdPolicyListDto> queryHerdByConditions(EndorseConditionDto endorseConditionDto) throws Exception;


    /**
     *  根据GIS清单号查询承保清单 种植险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    public List<PlantingPolicyListDto> queryByGisInsureListCode( String gisInsureListCode) throws Exception;


    List<PlantingPolicyListDto> queryByInsureMainListByPolicyNO(String policyNo);
    public List<PlantingPolicyListDto> findPlantingPolicyListByInsureListCode(String insureListCode) throws Exception;
}
